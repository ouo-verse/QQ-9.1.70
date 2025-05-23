package com.tencent.mobileqq.ark.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.config.qqmc.ArkPlatformConfParser;
import com.tencent.mobileqq.ark.core.ArkAppCGI;
import com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr;
import com.tencent.mobileqq.ark.core.ArkMultiProc;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.mobileqq.ark.module.ArkAppNotifyCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import d91.g;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppCenter {

    /* renamed from: i, reason: collision with root package name */
    private static boolean f199164i = false;

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<AppRuntime> f199165a;

    /* renamed from: b, reason: collision with root package name */
    private final ArkAppCGI f199166b;

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.mobileqq.ark.core.d f199167c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.ark.b f199168d;

    /* renamed from: e, reason: collision with root package name */
    private final ArkAppPreDownloadMgr f199169e;

    /* renamed from: f, reason: collision with root package name */
    private final IGuardInterface f199170f = new a();

    /* renamed from: g, reason: collision with root package name */
    private ProxyChangeNotifier f199171g = new ProxyChangeNotifier();

    /* renamed from: h, reason: collision with root package name */
    private final INetInfoHandler f199172h = new b(this);

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static final class ProxyChangeNotifier extends BroadcastReceiver implements Runnable {
        ProxyChangeNotifier() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.PROXY_CHANGE".equals(intent.getAction())) {
                QLog.i("ArkApp.AppCenter", 1, "receive broadcast proxy change.");
                ThreadManagerV2.executeOnSubThread(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AppNetConnInfo.isWifiConn()) {
                ArkViewModelBase.setArkHttpProxy();
            } else {
                ArkViewModelBase.clearArkHttpProxy();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static final class b implements INetInfoHandler {

        /* renamed from: d, reason: collision with root package name */
        WeakReference<ArkAppCenter> f199176d;

        public b(ArkAppCenter arkAppCenter) {
            this.f199176d = new WeakReference<>(arkAppCenter);
        }

        void a(int i3, int i16) {
            ArkAppCenter arkAppCenter = this.f199176d.get();
            if (arkAppCenter != null) {
                arkAppCenter.s(i3, i16);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            a(1, 0);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            a(1, 2);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            a(0, 1);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            a(0, 2);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            a(2, 1);
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            a(2, 0);
        }
    }

    public ArkAppCenter(AppRuntime appRuntime) {
        QLog.i("ArkApp.AppCenter", 1, "ArkAppCenter.onCreate");
        this.f199165a = new WeakReference<>(appRuntime);
        this.f199166b = new ArkAppCGI(appRuntime);
        this.f199167c = new com.tencent.mobileqq.ark.core.d(this);
        this.f199168d = new com.tencent.mobileqq.ark.b();
        this.f199169e = new ArkAppPreDownloadMgr(appRuntime);
        n();
        l();
        t(appRuntime);
        f();
        v();
    }

    private void m() {
        g d16 = ArkPlatformConfParser.d();
        if (d16 != null && d16.c() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.AppCenter", 1, "ArkSafe.initGlobalWhiteListAndUrlCheckStatus.loadConfig content = " + d16.b());
            }
            e91.g c16 = d16.c();
            ArkAppConfigMgr.getInstance().initGlobalWhiteListAndUrlCheckStatus(c16.g(), c16.f395984n, c16.f395983m);
        }
    }

    public static boolean o() {
        if (QLog.isDevelopLevel()) {
            QLog.i("ArkApp.AppCenter", 4, "isPANonShow,  bRet = " + f199164i);
        }
        if (!f199164i && ArkUtil.isDeviceSupportArkMsg()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        f199164i = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("arkapp_pa_nshow", f199164i);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i3, int i16) {
        if (i16 == 2) {
            ArkViewModelBase.setArkHttpProxy();
        } else {
            ArkViewModelBase.clearArkHttpProxy();
        }
    }

    private void u(final BaseApplication baseApplication) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ark.base.ArkAppCenter.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                synchronized (this) {
                    if (baseApplication != null && ArkAppCenter.this.f199171g != null) {
                        baseApplication.registerReceiver(ArkAppCenter.this.f199171g, new IntentFilter("android.intent.action.PROXY_CHANGE"));
                        QLog.d("ArkApp.AppCenter", 1, "register proxy change receiver");
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("registerEventObserver failed, for mProxyChangeNotifier is null:");
                        if (ArkAppCenter.this.f199171g == null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        sb5.append(z16);
                        QLog.e("ArkApp.AppCenter", 1, sb5.toString());
                    }
                }
            }
        }, 16, null, true);
    }

    private void w(final BaseApplication baseApplication) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ark.base.ArkAppCenter.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    BaseApplication baseApplication2 = baseApplication;
                    if (baseApplication2 != null) {
                        try {
                            baseApplication2.unregisterReceiver(ArkAppCenter.this.f199171g);
                        } catch (Exception e16) {
                            QLog.w("ArkApp.AppCenter", 1, "unregisterProxyReceiverOnSubThread exception:" + e16);
                        }
                        ArkAppCenter.this.f199171g = null;
                    }
                }
            }
        }, 16, null, false);
    }

    public static void x(String str) {
        try {
            if (str != null) {
                f199164i = "1".equalsIgnoreCase(str);
            } else {
                f199164i = false;
            }
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("arkapp_pa_nshow", f199164i).commitAsync();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (str != null) {
            QLog.i("ArkApp.AppCenter", 1, "updatePANShowSwitch, value = " + str);
            return;
        }
        QLog.i("ArkApp.AppCenter", 1, "updatePANShowSwitch, value = null");
    }

    void f() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ark.base.ArkAppCenter.4
            @Override // java.lang.Runnable
            public void run() {
                ArkAppCenter.this.f199169e.g();
            }
        }, 16, null, false);
    }

    public AppRuntime h() {
        return this.f199165a.get();
    }

    public boolean i(String str, Object obj, ArkAppCGI.c cVar) {
        if (str != null && str.length() > 0) {
            this.f199166b.l(str, obj, cVar);
            return true;
        }
        return false;
    }

    public ArkAppPreDownloadMgr j() {
        return this.f199169e;
    }

    public com.tencent.mobileqq.ark.core.d k() {
        return this.f199167c;
    }

    void l() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.ark.base.a
            @Override // java.lang.Runnable
            public final void run() {
                ArkAppCenter.this.p();
            }
        }, 16, null, false);
    }

    void n() {
        if (!ArkMultiProc.f199300a) {
            l91.a.b(true);
        }
        ArkAppNotifyCenter.init();
    }

    public void q() {
        AppRuntime appRuntime = this.f199165a.get();
        if (appRuntime != null) {
            if (!TextUtils.isEmpty(appRuntime.getAccount())) {
                ArkAppMgr.getInstance().updateInstalledApps();
            }
            ((IArkDictManager) appRuntime.getRuntimeService(IArkDictManager.class, "")).reloadWordData();
        }
    }

    public void r() {
        QLog.i("ArkApp.AppCenter", 1, "ArkAppCenter.onDestroy");
        ArkAppMgr.getInstance().onDestroy();
        AppNetConnInfo.unregisterNetInfoHandler(this.f199172h);
        AppRuntime appRuntime = this.f199165a.get();
        if (appRuntime != null) {
            BaseApplication app = appRuntime.getApp();
            if (app != null) {
                w(app);
            } else {
                QLog.e("ArkApp.AppCenter", 1, "application is null");
            }
        } else {
            QLog.e("ArkApp.AppCenter", 1, "appRuntime is null");
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this.f199170f);
        } else {
            QLog.i("ArkApp.AppCenter", 1, "guard manager is null");
        }
    }

    void t(AppRuntime appRuntime) {
        if (appRuntime != null) {
            BaseApplication app = appRuntime.getApp();
            if (app != null) {
                AppNetConnInfo.registerConnectionChangeReceiver(app, this.f199172h);
                u(app);
            } else {
                QLog.e("ArkApp.AppCenter", 1, "application is null");
            }
        } else {
            QLog.e("ArkApp.AppCenter", 1, "appRuntime is null");
        }
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this.f199170f);
        } else {
            QLog.i("ArkApp.AppCenter", 1, "guard manager is null");
        }
    }

    void v() {
        ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToMainThreadDelay(new Runnable() { // from class: com.tencent.mobileqq.ark.base.ArkAppCenter.5
            @Override // java.lang.Runnable
            public void run() {
                ArkAppMgr.getInstance().updateInstalledApps();
            }
        }, 10000);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements IGuardInterface {
        a() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            ArkAppCenter.this.q();
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
        }
    }

    public static void g(boolean z16) {
    }
}
