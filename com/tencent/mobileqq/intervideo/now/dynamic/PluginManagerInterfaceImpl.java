package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.now.NowRecordInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedTicket;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.INowDownloadManager;
import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import com.tencent.mobileqq.intervideo.now.dynamic.channelImpl.NowChannerHandlerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import mqq.app.MainService;
import mqq.util.WeakReference;

/* loaded from: classes33.dex */
public class PluginManagerInterfaceImpl implements com.tencent.mobileqq.intervideo.now.dynamic.c {

    /* renamed from: d, reason: collision with root package name */
    private static volatile PluginManagerInterfaceImpl f238346d;

    /* renamed from: a, reason: collision with root package name */
    private INowDownloadManager f238347a;

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.mobileqq.intervideo.now.a f238348b;

    /* renamed from: c, reason: collision with root package name */
    boolean f238349c = false;

    /* loaded from: classes33.dex */
    class a implements CustomizedTicket {
        a() {
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedTicket
        public Future<Bundle> getA1(String str, String str2, String str3, String str4) {
            PluginManagerInterfaceImpl pluginManagerInterfaceImpl = PluginManagerInterfaceImpl.this;
            return pluginManagerInterfaceImpl.e(pluginManagerInterfaceImpl.k(), str, str2, str3, str4);
        }

        @Override // com.tencent.intervideo.nowproxy.customized_interface.CustomizedTicket
        public Future<Bundle> getAccessToken(String str, String str2) {
            return PluginManagerInterfaceImpl.this.f(str, str2);
        }
    }

    /* loaded from: classes33.dex */
    class b implements NowRecordInfo.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NowRecordInfo f238355a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonCallback f238356b;

        b(NowRecordInfo nowRecordInfo, CommonCallback commonCallback) {
            this.f238355a = nowRecordInfo;
            this.f238356b = commonCallback;
        }

        @Override // com.tencent.biz.now.NowRecordInfo.a
        public void a(boolean z16, String str, String str2, long j3, String str3) {
            PluginManagerInterfaceImpl.this.f238348b.k(this.f238355a.D2(), this.f238355a.E2(), j3, 0);
            Bundle bundle = new Bundle();
            bundle.putBoolean("isOnline", z16);
            bundle.putString(AppConstants.Key.KEY_QZONE_VIDEO_URL, str);
            bundle.putString("vid", str2);
            bundle.putLong("timeConsume", j3);
            bundle.putString("mqqApi", str3);
            this.f238356b.onResult(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c implements Callable<Bundle> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f238358d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f238359e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f238360f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f238361h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f238362i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes33.dex */
        public class a implements ILoginKeyHelper.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ILoginKeyHelper f238364d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle[] f238365e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f238366f;

            a(ILoginKeyHelper iLoginKeyHelper, Bundle[] bundleArr, CountDownLatch countDownLatch) {
                this.f238364d = iLoginKeyHelper;
                this.f238365e = bundleArr;
                this.f238366f = countDownLatch;
            }

            @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper.b
            public void a(String str, boolean z16, int i3) {
                Bundle bundle = new Bundle(this.f238364d.getAccountInfo().f238095d.getExtras());
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("data", bundle);
                bundle2.putBoolean("isSuccess", z16);
                bundle2.putInt("code", i3);
                this.f238365e[0] = bundle2;
                this.f238366f.countDown();
            }
        }

        c(String str, String str2, String str3, String str4, String str5) {
            this.f238358d = str;
            this.f238359e = str2;
            this.f238360f = str3;
            this.f238361h = str4;
            this.f238362i = str5;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle call() throws Exception {
            ILoginKeyHelper iLoginKeyHelper = (ILoginKeyHelper) QRoute.api(ILoginKeyHelper.class);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Bundle[] bundleArr = new Bundle[1];
            iLoginKeyHelper.getA1(this.f238358d, this.f238359e, this.f238360f, this.f238361h, new a(iLoginKeyHelper, bundleArr, countDownLatch), true, this.f238362i);
            countDownLatch.await();
            return bundleArr[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static final class d implements Callable<Bundle> {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<PluginManagerInterfaceImpl> f238368d;

        /* renamed from: e, reason: collision with root package name */
        private final String f238369e;

        /* renamed from: f, reason: collision with root package name */
        private final String f238370f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes33.dex */
        public class a implements ILoginKeyHelper.b {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ILoginKeyHelper f238371d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle[] f238372e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f238373f;

            a(ILoginKeyHelper iLoginKeyHelper, Bundle[] bundleArr, CountDownLatch countDownLatch) {
                this.f238371d = iLoginKeyHelper;
                this.f238372e = bundleArr;
                this.f238373f = countDownLatch;
            }

            @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper.b
            public void a(String str, boolean z16, int i3) {
                if (z16) {
                    Bundle a16 = this.f238371d.getAccountInfo().a();
                    a16.putLong("accountUpdateTime", this.f238371d.getAccountInfo().f238096e);
                    a16.putString("payToken", this.f238371d.getAccountInfo().f238094c);
                    Bundle bundle = new Bundle();
                    bundle.putBundle("data", a16);
                    bundle.putBoolean("isSuccess", true);
                    bundle.putInt("code", i3);
                    this.f238372e[0] = bundle;
                } else {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("isSuccess", false);
                    bundle2.putInt("code", i3);
                    this.f238372e[0] = bundle2;
                }
                this.f238373f.countDown();
            }
        }

        d(PluginManagerInterfaceImpl pluginManagerInterfaceImpl, String str, String str2) {
            this.f238369e = str;
            this.f238370f = str2;
            this.f238368d = new WeakReference<>(pluginManagerInterfaceImpl);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bundle call() throws Exception {
            Bundle[] bundleArr = new Bundle[1];
            if (this.f238368d.get() != null) {
                ILoginKeyHelper iLoginKeyHelper = (ILoginKeyHelper) QRoute.api(ILoginKeyHelper.class);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                iLoginKeyHelper.getAccessToken(PluginManagerInterfaceImpl.b(), this.f238370f, BaseApplication.getContext(), this.f238369e, new a(iLoginKeyHelper, bundleArr, countDownLatch));
                countDownLatch.await();
                return bundleArr[0];
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isSuccess", false);
            bundle.putInt("code", -1000);
            bundleArr[0] = bundle;
            return bundle;
        }
    }

    static /* bridge */ /* synthetic */ QQAppInterface b() {
        return g();
    }

    public static void c() {
        if (f238346d != null) {
            f238346d.r();
        }
    }

    private static QQAppInterface g() {
        return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    public static PluginManagerInterfaceImpl i() {
        if (f238346d == null) {
            synchronized (PluginManagerInterfaceImpl.class) {
                if (f238346d == null) {
                    f238346d = new PluginManagerInterfaceImpl();
                }
            }
        }
        return f238346d;
    }

    public synchronized void d(Bundle bundle, Object obj) {
        final DownloadCallback downloadCallback = (DownloadCallback) obj;
        final String string = bundle.getString("url", "");
        String string2 = bundle.getString("path", "");
        INowDownloadManager createObject = ((INowDownloadManager) QRoute.api(INowDownloadManager.class)).createObject(true);
        this.f238347a = createObject;
        createObject.init(BaseApplication.getContext());
        this.f238347a.addDownloadListener(string, new com.tencent.mobileqq.intervideo.now.DownloadEngine.a() { // from class: com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.2
            @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.a
            public void onDownloadProgress(long j3, long j16, int i3) {
                if (downloadCallback != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putLong("downloadSize", j3);
                    bundle2.putLong("totalSize", j16);
                    bundle2.putInt("percent", i3);
                    downloadCallback.onProgress((int) j3, (int) j16);
                }
            }

            @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.a
            public void onDownloadComplete() {
                QLog.i("PluginManagerInterfaceImpl", 4, "onDownloadComplete------");
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.i("PluginManagerInterfaceImpl", 4, "onDownloadComplete------sub thread run");
                        if (downloadCallback != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("errCode", 0);
                            bundle2.putString("errMsg", "Helly Download Success");
                            downloadCallback.onDownloadSuccess("");
                        }
                    }
                });
                PluginManagerInterfaceImpl.this.f238347a.removeDownloadListener(string);
            }

            @Override // com.tencent.mobileqq.intervideo.now.DownloadEngine.a
            public void onDownloadFailed(int i3, int i16, String str) {
                QLog.i("PluginManagerInterfaceImpl", 4, "onDownloadFailed------");
                if (downloadCallback != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("errCode", i3);
                    bundle2.putInt("httpCode", i16);
                    bundle2.putString("errMsg", str);
                    downloadCallback.onDownloadError(i3, i16, str);
                }
                PluginManagerInterfaceImpl.this.f238347a.removeDownloadListener(string);
            }
        });
        this.f238347a.addNowDownloadTask(f52.a.a(string, INowUtil.Now_PKG_NAME, string2));
    }

    public com.tencent.mobileqq.intervideo.now.a h() {
        return this.f238348b;
    }

    public void j(Bundle bundle, Object obj) {
        CommonCallback commonCallback = (CommonCallback) obj;
        QQAppInterface g16 = g();
        if (g16 == null) {
            return;
        }
        NowRecordInfo nowRecordInfo = (NowRecordInfo) g16.getBusinessHandler(BusinessHandlerFactory.NOW_PROXY_HANDLER);
        String string = bundle.getString("fromId");
        long j3 = bundle.getLong("roomId");
        String k3 = k();
        if (TextUtils.isEmpty(k3)) {
            QLog.i("PluginManagerInterfaceImpl", 1, "getRecordInfo(): uin is null, PluginManagerInterfaceImpl had unInit.");
            k3 = "";
        }
        nowRecordInfo.F2(string, j3, k3, new b(nowRecordInfo, commonCallback));
    }

    public String k() {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (qQAppInterface == null) {
            return null;
        }
        return qQAppInterface.getCurrentAccountUin();
    }

    public void l(AppInterface appInterface) {
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        if (this.f238349c) {
            return;
        }
        if (this.f238348b == null) {
            this.f238348b = new com.tencent.mobileqq.intervideo.now.a(qQAppInterface);
        }
        NowLive.setCustomizedTicket(new a());
        this.f238349c = true;
    }

    public void m(Bundle bundle) {
        QQToast.makeText(BaseApplication.getContext(), "\u62b1\u6b49\uff0cbiu\u4e1a\u52a1\u5df2\u4e0b\u67b6", 1).show();
    }

    public void n(Bundle bundle) {
        QLog.i("PluginManagerInterfaceImpl", 1, "\u8df3\u8f6cweb\u9875\u9762 URL = " + bundle.getString("url", ""));
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        BaseApplication.getContext().startActivity(intent);
    }

    public String o(String str) {
        return InnerDns.getInstance().reqDns(str, 1017);
    }

    public void p(Bundle bundle, Object obj) {
        CommonCallback<Bundle> commonCallback = (CommonCallback) obj;
        QQAppInterface g16 = g();
        if (g16 == null) {
            QLog.i("PluginManagerInterfaceImpl", 1, "sendCsTask(): mApp is null, PluginManagerInterfaceImpl had unInit.");
            return;
        }
        ((NowChannerHandlerV2) g16.getBusinessHandler(BusinessHandlerFactory.NOW_CHANNEL_HANDLER_V2)).E2(bundle.getString("serviceName"), bundle.getString(MainService.SERVICE_CMD), bundle.getByteArray("buffer"), commonCallback);
    }

    public void q(Bundle bundle) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("uin", g() == null ? null : g().getCurrentUin());
        RouteUtils.startActivity(BaseApplication.getContext(), intent, "/share/toqq/activity");
    }

    public void r() {
        f238346d = null;
        this.f238348b = null;
        INowDownloadManager iNowDownloadManager = this.f238347a;
        if (iNowDownloadManager != null) {
            iNowDownloadManager.unInit();
            this.f238347a = null;
        }
    }

    public Future<Bundle> e(String str, String str2, String str3, String str4, String str5) {
        return ThreadManagerExecutor.getExecutorService(128).submit(new c(str, str2, str3, str4, str5));
    }

    public Future<Bundle> f(String str, String str2) {
        return ThreadManagerExecutor.getExecutorService(128).submit(new d(this, str2, str));
    }
}
