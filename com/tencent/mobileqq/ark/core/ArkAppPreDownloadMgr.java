package com.tencent.mobileqq.ark.core;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ark.ArkAppPreloader;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkStateCenter;
import com.tencent.ark.Constants;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.config.qqmc.ArkPlatformConfParser;
import com.tencent.mobileqq.ark.core.i;
import com.tencent.mobileqq.ark.temp.api.IDisplayConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* loaded from: classes11.dex */
public class ArkAppPreDownloadMgr {

    /* renamed from: a, reason: collision with root package name */
    private boolean f199288a;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<AppRuntime> f199291d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f199289b = false;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, c91.d> f199290c = new ConcurrentHashMap<>(8);

    /* renamed from: e, reason: collision with root package name */
    private final ArkAppPreloader.PreloadAppCallback f199292e = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements ArkAppMgr.IGetAppPathByNameCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c91.d f199293a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ i.a f199294b;

        a(c91.d dVar, i.a aVar) {
            this.f199293a = dVar;
            this.f199294b = aVar;
        }

        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
            long j3;
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, "profiling preDownloadApp app=", this.f199293a.f30469a, ",retcode=", Integer.valueOf(i3), ",msg=", str);
            }
            if (((AppRuntime) ArkAppPreDownloadMgr.this.f199291d.get()) == null) {
                return;
            }
            if (i3 == 0 && appPathInfo != null && appPathInfo.path != null) {
                File file = new File(appPathInfo.path);
                if (file.exists()) {
                    j3 = file.length();
                } else {
                    j3 = 0;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, "profiling preDownloadApp app=", this.f199293a.f30469a, ",filesize=", Long.valueOf(j3));
                }
                this.f199294b.a(this.f199293a.f30469a, j3);
                return;
            }
            this.f199294b.a(this.f199293a.f30469a, -1L);
        }
    }

    /* loaded from: classes11.dex */
    class b implements ArkAppPreloader.PreloadAppCallback {

        /* loaded from: classes11.dex */
        class a implements ArkAppMgr.IGetAppPathByNameCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f199297a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f199298b;

            a(String str, String str2) {
                this.f199297a = str;
                this.f199298b = str2;
            }

            @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
            public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
                String str2;
                QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling onReleaseAndReload onGetAppPathByName app=" + this.f199297a + ",retcode=" + i3 + ",msg=" + str);
                if (i3 == 0 && appPathInfo != null && (str2 = appPathInfo.path) != null) {
                    ArkAppPreDownloadMgr arkAppPreDownloadMgr = ArkAppPreDownloadMgr.this;
                    arkAppPreDownloadMgr.n(this.f199297a, this.f199298b, str2, arkAppPreDownloadMgr.f199292e, 2);
                }
            }
        }

        b() {
        }

        @Override // com.tencent.ark.ArkAppPreloader.PreloadAppCallback
        public void beginAppload(String str, int i3) {
            if (i3 == 1) {
                com.tencent.mobileqq.ark.util.a.e(str);
            }
        }

        @Override // com.tencent.ark.ArkAppPreloader.PreloadAppCallback
        public void onAppLoaded(boolean z16, String str, int i3) {
            if (i3 == 1) {
                com.tencent.mobileqq.ark.util.a.b(str);
                if (QLog.isColorLevel()) {
                    QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling preload app appname=", str, ",success=", Boolean.valueOf(z16));
                }
            }
        }

        @Override // com.tencent.ark.ArkAppPreloader.PreloadAppCallback
        public void onReleaseAndReload(String str, String str2, int i3) {
            QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling onReleaseAndReload begin app = " + str + ", bizSrc = " + str2);
            ArkAppMgr.getInstance().getAppPathByName(str, Constants.DEFAULT_MIN_APP_VERSION, str2, new a(str, str2));
        }
    }

    public ArkAppPreDownloadMgr(AppRuntime appRuntime) {
        this.f199288a = false;
        this.f199291d = new WeakReference<>(appRuntime);
        this.f199288a = false;
    }

    private static void f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @NonNull
    private Runnable h(final c91.d dVar, final i.a aVar) {
        return new Runnable() { // from class: com.tencent.mobileqq.ark.core.c
            @Override // java.lang.Runnable
            public final void run() {
                ArkAppPreDownloadMgr.this.j(dVar, aVar);
            }
        };
    }

    static boolean i(String str) {
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_ark_app_first_use", 0);
        if (sharedPreferences.getBoolean(str, false)) {
            return true;
        }
        sharedPreferences.edit().putBoolean(str, true).apply();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(c91.d dVar, i.a aVar) {
        if (TextUtils.isEmpty(dVar.f30469a)) {
            return;
        }
        if (!TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathFromLocal(dVar.f30469a, dVar.f30471c))) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, "profiling preDownloadApp app", dVar.f30469a, "allready downloaded");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkAppPreDownloadMgr", 2, "profiling preDownloadApp begin app = ", dVar.f30469a);
            }
            ArkAppMgr.getInstance().getAppPathByName(dVar.f30469a, Constants.DEFAULT_MIN_APP_VERSION, dVar.f30471c, new a(dVar, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(c91.d dVar) {
        AppRuntime appRuntime = this.f199291d.get();
        if (appRuntime == null) {
            return;
        }
        String str = dVar.f30469a;
        i.a a16 = i.a(appRuntime, str, str);
        Runnable h16 = h(dVar, a16);
        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling add ark predowload to scheduler,app=", dVar.f30469a);
        a16.b(h16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, String str2, String str3, ArkAppPreloader.PreloadAppCallback preloadAppCallback, int i3) {
        String cacheDirectory = ArkEnvironmentManager.getInstance().getCacheDirectory();
        String storageDirectory = ArkEnvironmentManager.getInstance().getStorageDirectory();
        String appResPath = ArkEnvironmentManager.getInstance().getAppResPath(str);
        f(appResPath);
        ArkAppPreloader.preloadApp(str, str2, str3, storageDirectory, appResPath, cacheDirectory, preloadAppCallback, i3);
    }

    public static void o() {
        String cacheDirectory = ArkEnvironmentManager.getInstance().getCacheDirectory();
        String storageDirectory = ArkEnvironmentManager.getInstance().getStorageDirectory();
        f(cacheDirectory);
        f(storageDirectory);
        ArkAppPreloader.preloadCommon(((IDisplayConfig) QRoute.api(IDisplayConfig.class)).getDisplayDensity(), storageDirectory, cacheDirectory);
    }

    public void g() {
        d91.g d16 = ArkPlatformConfParser.d();
        if (d16 == null && QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling get preload config from default");
        }
        this.f199290c.clear();
        s(d16);
        o();
        q();
    }

    void l(final c91.d dVar) {
        if (dVar == null) {
            QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling preDownloadApp failed for item null");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ark.core.b
                @Override // java.lang.Runnable
                public final void run() {
                    ArkAppPreDownloadMgr.this.k(dVar);
                }
            }, 16, null, true);
        }
    }

    void m() {
        if (this.f199290c.size() != 0 && !this.f199289b) {
            if (!ArkStateCenter.getInstance().isForeground()) {
                QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "app is not foreground not do preloadApp");
                return;
            }
            this.f199289b = true;
            Iterator<Map.Entry<String, c91.d>> it = this.f199290c.entrySet().iterator();
            while (it.hasNext()) {
                c91.d value = it.next().getValue();
                if (!TextUtils.isEmpty(value.f30469a) && !TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathFromLocal(value.f30469a, value.f30471c))) {
                    if (com.tencent.mobileqq.ark.util.a.d(value.f30469a)) {
                        value.f30470b = 0;
                        QLog.w("ArkApp.ArkAppPreDownloadMgr", 1, "profiling disable to preload ArkApp name = " + value.f30469a);
                    }
                    if (value.f30470b == 1) {
                        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling need to preload ArkApp name = " + value.f30469a);
                        n(value.f30469a, "", ArkAppMgr.getInstance().getAppPathFromLocal(value.f30469a, ""), this.f199292e, 1);
                    }
                }
            }
            return;
        }
        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "not do preload mPreDownload.size = " + this.f199290c.size() + ", mHandledPreload = " + this.f199289b);
    }

    public synchronized void p(String str, boolean z16) {
        if (!TextUtils.isEmpty(str) && this.f199290c.containsKey(str)) {
            try {
            } catch (Exception e16) {
                QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling reportPredownloadFirstHit exception=", e16);
            }
            if (i(str)) {
                return;
            }
            String account = this.f199291d.get().getAccount();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("app_name", str);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(account, "ark_app_predownload_first_hit", z16, 0L, 0L, hashMap, "", false);
            QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling reportPredownloadFirstHit app=", str, ",hasPreDownload=", Boolean.valueOf(z16));
        }
    }

    public void q() {
        if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling startPredownload");
        }
        if (this.f199290c.size() > 0 && !this.f199288a) {
            if (!ArkStateCenter.getInstance().isForeground()) {
                QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "app is not foreground not do startPreDownload");
                return;
            }
            this.f199288a = true;
            Iterator<Map.Entry<String, c91.d>> it = this.f199290c.entrySet().iterator();
            while (it.hasNext()) {
                c91.d value = it.next().getValue();
                if (!TextUtils.isEmpty(value.f30469a)) {
                    if (ArkAppMgr.getInstance().getAppPathFromLocal(value.f30469a, value.f30471c) == null) {
                        l(value);
                    } else {
                        QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling ark app predowloaded,app=", value.f30469a);
                    }
                }
            }
        }
    }

    public void r() {
        QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling startPreload");
        com.tencent.mobileqq.ark.base.b.a(new Runnable() { // from class: com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr.1
            @Override // java.lang.Runnable
            public void run() {
                ArkAppPreDownloadMgr.this.m();
            }
        }, 20000L);
    }

    public void s(d91.g gVar) {
        if (gVar != null && gVar.c() != null) {
            this.f199290c = gVar.c().f395982l;
        } else if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling updatePreloadConfig cfg is empty");
        }
    }
}
