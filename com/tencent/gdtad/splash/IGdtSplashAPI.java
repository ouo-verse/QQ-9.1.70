package com.tencent.gdtad.splash;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.lang.ref.WeakReference;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtSplashAPI extends QRouteApi {
    void bgSplashPreload(boolean z16);

    com.tencent.qqperf.monitor.crash.safemode.a buildSafeModeStartUpRunner();

    boolean canRealTimeOrderCold();

    boolean canRealTimeOrderHot();

    boolean checkSplashShowtime();

    void clearHotSplashCache();

    void coldRealTimePrepare(WeakReference<Activity> weakReference, WeakReference<w> weakReference2);

    void doAfterLoginAndMessageLoaded();

    void fgSplashPreload();

    String getSafeModeRunnerKey();

    boolean hasHotSplashPrepare(WeakReference<com.tencent.mobileqq.splash.a> weakReference);

    void hotRealTimePrepare(WeakReference<Activity> weakReference, WeakReference<w> weakReference2, WeakReference<com.tencent.mobileqq.splash.a> weakReference3);

    boolean needSkipPreload();

    void onClosed();

    void onEmptyHotSplash();

    void onPrepareTimeOut();

    Object prepare(WeakReference<Activity> weakReference);

    void recycleHotSplash();

    void reportForAnalysis(int i3);

    void reportSplashEmptyOrder(boolean z16, boolean z17, int i3);

    boolean setAdRequestToTestSever();

    void setTestOnServer(boolean z16);

    void show(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3, Object obj);

    void showColdRealTimeSplash(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3);

    void showHotGdtRealTimeSplash(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3);

    void showHotGdtSplash(WeakReference<Activity> weakReference, WeakReference<ViewGroup> weakReference2, WeakReference<w> weakReference3);

    void updateGdtHotSplashDuration(Long l3);
}
