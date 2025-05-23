package cooperation.vip.qqbanner.manager;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import j15.a;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static a f391336f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f391337g = ar.b("kenaiyu", "2024-09-11", "vas_qzone_new_downloader_config_three").isEnable(true);

    /* renamed from: h, reason: collision with root package name */
    public static RFWDownloadStrategy f391338h = new C10128a();

    /* renamed from: c, reason: collision with root package name */
    private Downloader f391341c;

    /* renamed from: e, reason: collision with root package name */
    private RFWDownloader f391343e;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f391342d = false;

    /* renamed from: b, reason: collision with root package name */
    private final File f391340b = new File(BaseApplicationImpl.getApplication().getCacheDir(), "vas_ad");

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, j15.a> f391339a = new HashMap();

    /* compiled from: P */
    /* renamed from: cooperation.vip.qqbanner.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    class C10128a extends RFWDownloadStrategy {
        C10128a() {
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public String getBusinessKey() {
            return "vas_ad";
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public SharedPreferences getSP() {
            return MobileQQ.sMobileQQ.peekAppRuntime().getPreferences();
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportBreakPointDownload() {
            return false;
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloadStrategy
        public boolean supportUnZipFile() {
            return false;
        }
    }

    a() {
        if (!f391337g) {
            this.f391341c = DownloaderFactory.getInstance(BaseApplication.getContext()).getCommonDownloader();
        } else {
            this.f391343e = RFWDownloaderFactory.getDownloader(f391338h);
        }
    }

    private void d(QQAppInterface qQAppInterface, j15.a aVar) {
        SparseArray<a.C10566a> sparseArray;
        if (aVar != null && (sparseArray = aVar.f409140a) != null && sparseArray.size() != 0) {
            if (!f391337g) {
                b bVar = new b(qQAppInterface, aVar, aVar.f409140a.size());
                for (int i3 = 0; i3 < aVar.f409140a.size(); i3++) {
                    a.C10566a valueAt = aVar.f409140a.valueAt(i3);
                    if (valueAt != null && !TextUtils.isEmpty(valueAt.f409143a)) {
                        if (QLog.isColorLevel()) {
                            QLog.i("VasADBannerResDownloadManager", 2, "start downloadFile , url = " + valueAt.f409143a);
                        }
                        if (q.p(valueAt.f409145c)) {
                            bVar.onDownloadSucceed(valueAt.f409143a, null);
                            if (QLog.isColorLevel()) {
                                QLog.i("VasADBannerResDownloadManager", 2, "current res has download , onsuccess, url = " + valueAt.f409143a);
                            }
                        } else {
                            Downloader downloader = this.f391341c;
                            if (downloader != null) {
                                try {
                                    downloader.download(valueAt.f409143a, valueAt.f409145c, false, (Downloader.DownloadListener) bVar);
                                } catch (Exception e16) {
                                    QLog.e("VasADBannerResDownloadManager", 1, "downloadFile fail, e:", e16);
                                    h(qQAppInterface);
                                }
                            }
                        }
                    } else {
                        QLog.e("VasADBannerResDownloadManager", 1, "download data = null");
                        h(qQAppInterface);
                        return;
                    }
                }
                return;
            }
            c cVar = new c(qQAppInterface, aVar, aVar.f409140a.size());
            for (int i16 = 0; i16 < aVar.f409140a.size(); i16++) {
                a.C10566a valueAt2 = aVar.f409140a.valueAt(i16);
                if (valueAt2 != null && !TextUtils.isEmpty(valueAt2.f409143a)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("VasADBannerResDownloadManager", 2, "start downloadFile , url = " + valueAt2.f409143a);
                    }
                    if (q.p(valueAt2.f409145c)) {
                        cVar.onRspCallback(true, valueAt2.f409145c);
                        if (QLog.isColorLevel()) {
                            QLog.i("VasADBannerResDownloadManager", 2, "current res has download , onsuccess, url = " + valueAt2.f409143a);
                        }
                    } else {
                        RFWDownloader rFWDownloader = this.f391343e;
                        if (rFWDownloader != null) {
                            try {
                                rFWDownloader.download(valueAt2.f409143a, cVar);
                            } catch (Exception e17) {
                                QLog.e("VasADBannerResDownloadManager", 1, "downloadFile fail, e:", e17);
                                h(qQAppInterface);
                            }
                        }
                    }
                } else {
                    QLog.e("VasADBannerResDownloadManager", 1, "download data = null");
                    h(qQAppInterface);
                    return;
                }
            }
            return;
        }
        h(qQAppInterface);
    }

    public static a e() {
        if (f391336f == null) {
            synchronized (a.class) {
                if (f391336f == null) {
                    f391336f = new a();
                }
            }
        }
        return f391336f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(QQAppInterface qQAppInterface) {
        this.f391342d = false;
        if (qQAppInterface == null) {
            return;
        }
        QLog.i("VasADBannerResDownloadManager", 1, "notifyBannerHide");
        BannerManager.l().D(VasADBannerProcessor.f185279h, 3001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(QQAppInterface qQAppInterface) {
        this.f391342d = false;
        if (qQAppInterface == null) {
            return;
        }
        QLog.i("VasADBannerResDownloadManager", 1, "notifyBannerShow");
        BannerManager.l().D(VasADBannerProcessor.f185279h, 3000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(j15.a aVar, String str, boolean z16) {
        if (aVar != null && !TextUtils.isEmpty(str) && aVar.f409140a != null) {
            for (int i3 = 0; i3 < aVar.f409140a.size(); i3++) {
                a.C10566a valueAt = aVar.f409140a.valueAt(i3);
                if (valueAt != null && !TextUtils.isEmpty(valueAt.f409143a) && (valueAt.f409143a.equalsIgnoreCase(str) || (f391337g && this.f391343e.getDefaultSavePath(valueAt.f409143a).equals(str)))) {
                    valueAt.b(z16);
                }
            }
        }
    }

    public String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (f391337g) {
            return this.f391343e.getContentFilePath(str);
        }
        return this.f391340b.getAbsolutePath() + File.separator + Utils.Crc64String(str) + str.substring(str.lastIndexOf("."));
    }

    public j15.a g(String str) {
        j15.a aVar;
        if (TextUtils.isEmpty(str)) {
            QLog.i("VasADBannerResDownloadManager", 1, "getVasADBannerConfig uin is empty. return.");
            return null;
        }
        if (this.f391339a.isEmpty()) {
            SharedPreferences l3 = com.tencent.mobileqq.vassplash.common.c.l(BaseApplication.getContext(), str);
            String h16 = com.tencent.mobileqq.vassplash.common.c.h(str);
            QLog.i("VasADBannerResDownloadManager", 1, "getCurrentUnionBannerInfoFromSp adId: " + h16);
            if (!TextUtils.isEmpty(h16)) {
                j15.a d16 = j15.a.d(null, l3.getString("splash_union_banner_type_" + h16, "-1"));
                if (d16 != null) {
                    d16.c(l3, h16);
                    this.f391339a.put(str, d16);
                }
            }
        }
        synchronized (this.f391339a) {
            aVar = this.f391339a.get(str);
        }
        return aVar;
    }

    public void k(QQAppInterface qQAppInterface, j15.a aVar) {
        if (qQAppInterface == null) {
            return;
        }
        if (aVar == null) {
            QLog.i("VasADBannerResDownloadManager", 1, "saveVasADBannerConfigAndNotify VasADBannerConfigInfo = null notifyBannerHide");
            h(qQAppInterface);
        } else if (aVar.b() && !aVar.h()) {
            QLog.i("VasADBannerResDownloadManager", 1, "checkIsFileExist exist , notifyBannerShow ");
            i(qQAppInterface);
        } else {
            QLog.i("VasADBannerResDownloadManager", 1, "checkIsFileExist is not exist , start downloadFile ");
            this.f391342d = true;
            d(qQAppInterface, aVar);
        }
    }

    public void l(QQAppInterface qQAppInterface, j15.a aVar) {
        if (aVar != null && aVar.f() != null && !aVar.b()) {
            QLog.i("VasADBannerResDownloadManager", 1, "checkIsFileExist is not exist , start downloadFile ");
            this.f391342d = true;
            d(qQAppInterface, aVar);
        }
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("VasADBannerResDownloadManager", 1, "removeVasADBannerConfig uin is empty. return.");
            return;
        }
        synchronized (this.f391339a) {
            this.f391339a.remove(str);
        }
    }

    public void n(j15.a aVar, String str) {
        synchronized (this.f391339a) {
            if (aVar == null) {
                this.f391339a.remove(str);
            } else {
                this.f391339a.put(str, aVar);
            }
        }
    }

    public void o(QQAppInterface qQAppInterface, j15.a aVar) {
        if (qQAppInterface == null) {
            QLog.i("VasADBannerResDownloadManager", 1, "saveVasADBannerConfigAndNotify app is null. return.");
            return;
        }
        String currentUin = qQAppInterface.getCurrentUin();
        if (TextUtils.isEmpty(currentUin)) {
            QLog.i("VasADBannerResDownloadManager", 1, "saveVasADBannerConfigAndNotify uin is empty. return.");
            return;
        }
        if (this.f391342d) {
            QLog.i("VasADBannerResDownloadManager", 1, "saveVasADBannerConfigAndNotify mIsDownloading = " + this.f391342d + " multi banner show");
            return;
        }
        n(aVar, currentUin);
        k(qQAppInterface, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        private j15.a f391344a;

        /* renamed from: b, reason: collision with root package name */
        private volatile int f391345b = 0;

        /* renamed from: c, reason: collision with root package name */
        private volatile int f391346c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f391347d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<QQAppInterface> f391348e;

        public b(QQAppInterface qQAppInterface, j15.a aVar, int i3) {
            this.f391348e = new WeakReference<>(qQAppInterface);
            this.f391344a = aVar;
            this.f391347d = i3;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            if (QLog.isColorLevel()) {
                QLog.i("VasADBannerResDownloadManager", 2, "diy data download fail url = " + str);
            }
            this.f391346c++;
            a.this.j(this.f391344a, str, false);
            QLog.e("VasADBannerResDownloadManager", 1, "onDownloadFailed mLoadSuccessTimes = " + this.f391345b + " mDownTotalSize = " + this.f391347d);
            QQAppInterface qQAppInterface = this.f391348e.get();
            if (this.f391346c + this.f391345b == this.f391347d) {
                a.this.h(qQAppInterface);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            if (QLog.isColorLevel()) {
                QLog.i("VasADBannerResDownloadManager", 2, "banner resources download success url = " + str);
            }
            this.f391345b++;
            a.this.j(this.f391344a, str, true);
            QQAppInterface qQAppInterface = this.f391348e.get();
            QLog.e("VasADBannerResDownloadManager", 1, "onDownloadSucceed mLoadSuccessTimes = " + this.f391345b + " mDownTotalSize = " + this.f391347d);
            if (this.f391345b == this.f391347d && !this.f391344a.h()) {
                a.this.i(qQAppInterface);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        private j15.a f391350d;

        /* renamed from: e, reason: collision with root package name */
        private volatile int f391351e = 0;

        /* renamed from: f, reason: collision with root package name */
        private volatile int f391352f = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f391353h;

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<QQAppInterface> f391354i;

        public c(QQAppInterface qQAppInterface, j15.a aVar, int i3) {
            this.f391354i = new WeakReference<>(qQAppInterface);
            this.f391350d = aVar;
            this.f391353h = i3;
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callEnd(Call call) {
            v.a(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callFailed(Call call, IOException iOException) {
            v.b(this, call, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void callStart(Call call) {
            v.c(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
            v.d(this, call, inetSocketAddress, proxy, protocol2);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
            v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            v.f(this, call, inetSocketAddress, proxy);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
            v.g(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void connectionReleased(Call call, Connection connection) {
            v.h(this, call, connection);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean z16, String str) {
            QLog.e("VasADBannerResDownloadManager", 1, "new onDownloadSucceed mLoadSuccessTimes = " + this.f391351e + " mDownTotalSize = " + this.f391353h);
            QQAppInterface qQAppInterface = this.f391354i.get();
            if (z16) {
                this.f391351e++;
                a.this.j(this.f391350d, str, true);
                if (this.f391351e == this.f391353h && !this.f391350d.h()) {
                    a.this.i(qQAppInterface);
                    return;
                }
                return;
            }
            this.f391352f++;
            a.this.j(this.f391350d, str, false);
            if (this.f391352f + this.f391351e == this.f391353h) {
                a.this.h(qQAppInterface);
            }
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyEnd(Call call, long j3) {
            v.k(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestBodyStart(Call call) {
            v.l(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
            v.m(this, call, request);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void requestHeadersStart(Call call) {
            v.n(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyEnd(Call call, long j3) {
            v.o(this, call, j3);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseBodyStart(Call call) {
            v.p(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
            v.q(this, call, response);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void responseHeadersStart(Call call) {
            v.r(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
            v.s(this, call, handshake);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void secureConnectStart(Call call) {
            v.t(this, call);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }
}
