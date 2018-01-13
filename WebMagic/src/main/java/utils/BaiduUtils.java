package utils;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class BaiduUtils implements PageProcessor {

	/**
	 * ��װ����ͷ����Ϣ
	 */
	private Site site = Site
			.me()
			.setDomain("www.baidu.com")
			.setRetryTimes(3)
			.setSleepTime(1000)
			.addCookie("BAIDUID", "A54EA43A4763F4235FC6553C6FD7BB2C:FG=1")
			.addCookie("BDORZ", "B490B5EBF6F3CD402E515D22BCDA1598")
			.addCookie(
					"BDUSS",
					"3Iwb1VVZTU0Q0hNY2J3ZkxCdHduZE1rNTBnU3JwbjJnLVVFOW15bTZSNlN-MzlhQVFBQUFBJCQAAAAAAAAAAAEAAABSD8kDcHVyZcrpza8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJJyWFqSclhac")
			.addCookie("BIDUPSID", "AEE9E6742A3D070EE68CFB8F2DEA02A9")
			.addCookie("FP_UID", "f29cf29743d04d278bea056bd9996d70")
			.addCookie("H_PS_PSSID", "1438_21088_17001_20930")
			.addCookie("PSTM", "1515744544")
			.addCookie("Hm_lpvt_f4165db5a1ac36eadcfa02a10a6bd243", "1515745948")
			.addCookie("Hm_lvt_f4165db5a1ac36eadcfa02a10a6bd243", "1515745935")
			.addCookie("sugstore", "0")
			.addCookie("BD_HOME", "1")
			.addCookie("BD_UPN", "12314353")
			.addCookie("PHPSESSID", "giovte2rq6rajiob4toblr2ft0")
			.addHeader(
					"User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36")
			.addCookie(
					"Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
			.addCookie("Accept-Encoding", "gzip, deflate, br")
			.addCookie("Accept-Language", "en,zh-CN;q=0.8,zh;q=0.6")
			.addCookie("Connection", "keep-alive");

	public Site getSite() {
		return site;
	}

	public void process(Page page) {

		String userName = page.getHtml()
				.xpath("//*[@id='1000000']/div[2]/div[1]/h2/text()").toString();

		System.out.println(page.getHtml().toString());

		System.out.println(userName);

	}

	public static void main(String[] args) {

		System.out.println("��ʼ");
		Spider.create(new BaiduUtils()).addUrl("https://www.baidu.com/p/pure%E4%B9%A6%E7%AB%A5").thread(3)
				.start();
		System.out.println("����");
	}

}
