package com.tencent.gdtad.splash.impl;

import android.app.Activity;
import android.view.ViewGroup;
import com.qq.e.adnet.ProductConfig;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.splash.GdtSplashAdCacheTool;
import com.tencent.gdtad.splash.GdtSplashManager;
import com.tencent.gdtad.splash.GdtSplashPreloader;
import com.tencent.gdtad.splash.IGdtSplashAPI;
import com.tencent.gdtad.splash.f;
import com.tencent.gdtad.splash.mcconfig.GdtSplashAdPreloadConfigParser;
import com.tencent.gdtad.splash.n;
import com.tencent.gdtad.splash.statistics.GdtSplashReporterUtil;
import com.tencent.gdtad.splash.statistics.b;
import com.tencent.gdtad.splash.u;
import com.tencent.gdtad.splash.w;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.a;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

/* loaded from: classes6.dex */
public final class GdtSplashAPIImpl implements IGdtSplashAPI {
    private static final String KEY_DEBUG_TEST_SERVER_ON = "key_debug_test_server_on";
    private static final String TAG = "GdtSplashAPIImpl";

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void bgSplashPreload(boolean z16) {
        f.f109360a.z(true, z16);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public a buildSafeModeStartUpRunner() {
        return GdtSplashAdCacheTool.d();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public boolean canRealTimeOrderCold() {
        return n.f109392a.f();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public boolean canRealTimeOrderHot() {
        return n.f109392a.g();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public boolean checkSplashShowtime() {
        return u.b();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void clearHotSplashCache() {
        f.f109360a.j();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void coldRealTimePrepare(WeakReference<Activity> weakReference, WeakReference<w> weakReference2) {
        GdtSplashManager.p().z(weakReference, weakReference2);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void doAfterLoginAndMessageLoaded() {
        GdtSplashPreloader.q();
        GdtSplashAdPreloadConfigParser.a a16 = com.tencent.gdtad.splash.mcconfig.a.a();
        if (a16 == null) {
            QLog.e(TAG, 1, "[preloadAfterLoginAndMessageLoaded] use default config");
            a16 = new GdtSplashAdPreloadConfigParser.a();
        }
        QLog.i(TAG, 1, "[preloadAfterLoginAndMessageLoaded] config:" + a16);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gdtad.splash.impl.GdtSplashAPIImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).needSkipPreload()) {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316001);
                    QLog.d(GdtSplashAPIImpl.TAG, 1, "splash show time skip, cancel doAfterLoginAndMessageLoaded");
                } else if (((IGdtAPI) QRoute.api(IGdtAPI.class)).needCancelSplashFgPreload()) {
                    ((IGdtSplashAPI) QRoute.api(IGdtSplashAPI.class)).reportForAnalysis(1316002);
                    QLog.d(GdtSplashAPIImpl.TAG, 1, "time over load, cancel doAfterLoginAndMessageLoaded");
                } else {
                    GdtSplashManager.p().o();
                    f.f109360a.m();
                    ((IGdtAPI) QRoute.api(IGdtAPI.class)).updateSplashFgPreload();
                }
            }
        }, 128, null, true, ((long) a16.E) * 1000);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void fgSplashPreload() {
        f.f109360a.z(false, false);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public String getSafeModeRunnerKey() {
        return "GtdSafeModeRunner";
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public boolean hasHotSplashPrepare(WeakReference<com.tencent.mobileqq.splash.a> weakReference) {
        return f.f109360a.p(weakReference);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void hotRealTimePrepare(WeakReference<Activity> weakReference, WeakReference<w> weakReference2, WeakReference<com.tencent.mobileqq.splash.a> weakReference3) {
        f.f109360a.r(weakReference, weakReference2, weakReference3);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public boolean needSkipPreload() {
        return u.e();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void onClosed() {
        GdtSplashManager.p().v();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void onEmptyHotSplash() {
        f.f109360a.n();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void onPrepareTimeOut() {
        f.f109360a.o();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public Object prepare(WeakReference<Activity> weakReference) {
        return GdtSplashManager.p().y(weakReference);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void recycleHotSplash() {
        f.f109360a.u();
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void reportForAnalysis(int i3) {
        int a16 = u.a().a();
        if (a16 != 0) {
            QLog.e(TAG, 1, "reportForAnalysis error, canRun errorCode:" + a16);
            return;
        }
        GdtSplashReporterUtil.e(new b(i3));
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void reportSplashEmptyOrder(boolean z16, boolean z17, int i3) {
        GdtSplashManager.p().B(z16, z17, i3);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public boolean setAdRequestToTestSever() {
        boolean decodeBool = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).decodeBool(KEY_DEBUG_TEST_SERVER_ON, false);
        ProductConfig.testControlServerOn = decodeBool;
        return decodeBool;
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void setTestOnServer(boolean z16) {
        ProductConfig.testControlServerOn = z16;
        QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_AD).encodeBool(KEY_DEBUG_TEST_SERVER_ON, z16);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void show(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3, Object obj) {
        GdtSplashManager.p().F(weakReference, weakReference2, weakReference3, obj);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void showColdRealTimeSplash(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3) {
        GdtSplashManager.p().A(weakReference, weakReference2, weakReference3);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void showHotGdtRealTimeSplash(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3) {
        f.f109360a.t(weakReference, weakReference2, weakReference3);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void showHotGdtSplash(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3) {
        f.f109360a.y(weakReference, weakReference2, weakReference3);
    }

    @Override // com.tencent.gdtad.splash.IGdtSplashAPI
    public void updateGdtHotSplashDuration(Long l3) {
        f.f109360a.A(l3.longValue());
    }
}
