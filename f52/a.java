package f52;

import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f397851a;

    /* renamed from: b, reason: collision with root package name */
    public String f397852b;

    /* renamed from: c, reason: collision with root package name */
    public String f397853c;

    /* renamed from: d, reason: collision with root package name */
    public String f397854d = "now_for_qq";

    /* renamed from: e, reason: collision with root package name */
    public String f397855e = "now_appid_2";

    /* renamed from: f, reason: collision with root package name */
    public String f397856f = "now";

    /* renamed from: g, reason: collision with root package name */
    public int f397857g = 0;

    /* renamed from: h, reason: collision with root package name */
    public String f397858h;

    /* renamed from: i, reason: collision with root package name */
    public String f397859i;

    /* renamed from: j, reason: collision with root package name */
    public long f397860j;

    /* renamed from: k, reason: collision with root package name */
    private DownloaderTask f397861k;

    public static a a(String str, String str2, String str3) {
        a aVar = new a();
        aVar.f397851a = "2";
        aVar.f397858h = str3.substring(0, str3.lastIndexOf("/") + 1);
        aVar.f397859i = str3.substring(str3.lastIndexOf("/") + 1);
        aVar.f397852b = str;
        aVar.f397853c = str2;
        aVar.f397860j = System.currentTimeMillis();
        QLog.i("NowDownloadTaskInfo", 4, aVar.toString());
        return aVar;
    }

    public DownloaderTask b() {
        return this.f397861k;
    }

    public void c(DownloaderTask downloaderTask) {
        this.f397861k = downloaderTask;
    }

    public String toString() {
        return "appid = " + this.f397851a + ", url = " + this.f397852b + ", downloadDir = " + this.f397858h + ", fileName = " + this.f397859i + ", taskSource = " + this.f397855e + ", appName = " + this.f397856f;
    }
}
