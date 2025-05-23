package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.qqmini.minigame.GameConst;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.minigame.manager.EnginePackageUpdater;
import com.tencent.qqmini.minigame.manager.FloatDragAdDataManager;
import com.tencent.qqmini.minigame.manager.PendantDataManager;
import com.tencent.qqmini.minigame.report.GameStopType;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.minigame.report.MiniGameMonitorReport;
import com.tencent.qqmini.minigame.task.LaunchEngineUISteps;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import com.tencent.qqmini.sdk.report.MiniGdtReporter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer;
import com.tencent.qqmini.sdk.ui.InternalMiniActivity;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameRuntimeStateObserver extends AppRuntimeEventCenter.RuntimeStateObserver {
    private static final String TAG = "GameRuntimeState";
    private Activity mActivity;
    private long mBeginOnCreate;
    private long mFirstRenderTime;
    private GameLaunchStatistic mGameLaunchStatistic;
    private final GameUIProxy mGameUI;
    private boolean mIsReportStartPerformance;
    private long mLastOnShowTime;
    private long mLoadGameStartTime;
    private MiniAppInfo mMiniAppInfo;
    private long mOnGameLaunchedTime;
    private long mOnGameSurfaceCreateTime;
    private final LaunchEngineUISteps mLaunchEngineUISteps = new LaunchEngineUISteps(AppLoaderFactory.g().getContext());
    private final Runnable mGameLaunchWatchDog = new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.1
        @Override // java.lang.Runnable
        public void run() {
            if (!GameRuntimeStateObserver.this.mLaunchEngineUISteps.isDone()) {
                QMLog.e(GameRuntimeStateObserver.TAG, "GameLaunchStuck for 10S GameLoadTaskExecutionStatics:\n" + TaskStaticsVisualizer.visualizeToString((List<TaskExecutionStatics>) GameRuntimeStateObserver.this.getTaskExecutionStatics()));
            }
        }
    };
    private Runnable mGameInnerLoadingWatchDog = null;
    private boolean mHasFirstFrameFinished = false;
    private boolean mHasReportLoadCanceled = false;
    private AtomicLong mGameInnerStartTime = null;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private com.tencent.qqmini.minigame.report.a mRunTimeReport = com.tencent.qqmini.minigame.report.a.c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class GameInnerLoadingWatchDog implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<GameUIProxy> f346748d;

        public GameInnerLoadingWatchDog(GameUIProxy gameUIProxy) {
            this.f346748d = new WeakReference<>(gameUIProxy);
        }

        @Override // java.lang.Runnable
        public void run() {
            GameRuntimeStateObserver.this.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.GameInnerLoadingWatchDog.1
                @Override // java.lang.Runnable
                public void run() {
                    QMLog.d(GameRuntimeStateObserver.TAG, "showGameInnerLoadingDialog");
                    GameUIProxy gameUIProxy = (GameUIProxy) GameInnerLoadingWatchDog.this.f346748d.get();
                    if (gameUIProxy != null) {
                        GameRuntime gameRuntime = gameUIProxy.getGameRuntime();
                        gu3.a.c(gameRuntime).perform(gameRuntime);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GameRuntimeStateObserver(GameUIProxy gameUIProxy) {
        this.mGameUI = gameUIProxy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MiniAppInfo getMiniAppInfoFromStateMessage(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        BaseRuntimeLoader baseRuntimeLoader;
        if (miniAppStateMessage != null && (baseRuntimeLoader = miniAppStateMessage.appRuntimeLoader) != null) {
            return baseRuntimeLoader.getMiniAppInfo();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public List<TaskExecutionStatics> getTaskExecutionStatics() {
        List<TaskExecutionStatics> taskStatics = this.mGameUI.getTaskStatics();
        taskStatics.add(this.mLaunchEngineUISteps.getExecutionStatics());
        return taskStatics;
    }

    private void notifyGameOnHide() {
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).onAppStateChange(this.mMiniAppInfo, 2);
    }

    private void notifyGameOnShow() {
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).onAppStateChange(this.mMiniAppInfo, 1);
    }

    private void notifyGameRealCanPlay() {
        Runnable runnable = this.mGameInnerLoadingWatchDog;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
            this.mGameInnerLoadingWatchDog = null;
        }
        reportGameInnerLoadingCost();
    }

    private void notifyGameStop() {
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).onAppStateChange(this.mMiniAppInfo, 3);
    }

    private void onEngineLoaded(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        QMLog.i(TAG, "Game engine loaded. " + this.mMiniAppInfo);
        Object obj = miniAppStateMessage.obj;
        if (obj instanceof String) {
            this.mGameUI.updateLoadingProcessText((String) obj, 1.0f);
        }
        BaseRuntimeLoader baseRuntimeLoader = miniAppStateMessage.appRuntimeLoader;
        if (baseRuntimeLoader != null) {
            baseRuntimeLoader.notifyRuntimeEvent(4, new Object[0]);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mLoadGameStartTime;
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1033, null, String.valueOf(this.mGameUI.getStatMode()), null, 0, "1", currentTimeMillis, null);
        QMLog.e("[minigame][timecost] ", "step[load baseLib] succeed, cost time: " + currentTimeMillis);
    }

    private void onGameRuntimeMsgEngineFailed(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        int i3;
        QMLog.i(TAG, "Failed to load game engine. " + this.mMiniAppInfo);
        Object obj = miniAppStateMessage.obj;
        if (obj instanceof Integer) {
            i3 = ((Integer) obj).intValue();
            if (i3 == 104) {
                this.mGameUI.showUpdateMobileQQDialog();
            } else {
                runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GameRuntimeStateObserver.this.mActivity != null) {
                            MiniToast.makeText(GameRuntimeStateObserver.this.mActivity, "\u5c0f\u6e38\u620f\u57fa\u7840\u5f15\u64ce\u52a0\u8f7d\u5931\u8d25\uff01", 0).show();
                        }
                        QMLog.e(GameRuntimeStateObserver.TAG, "\u5c0f\u6e38\u620f\u57fa\u7840\u5f15\u64ce\u52a0\u8f7d\u5931\u8d25\uff01");
                    }
                });
            }
        } else {
            i3 = 100;
        }
        MiniGdtReporter.report(this.mMiniAppInfo, 510);
        long currentTimeMillis = System.currentTimeMillis() - this.mLoadGameStartTime;
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1033, null, String.valueOf(this.mGameUI.getStatMode()), null, -1, "1", currentTimeMillis, null);
        QMLog.e("[minigame][timecost] ", "step[load baseLib] fail, cost time: " + currentTimeMillis);
        MiniGameMonitorReport.n(this.mGameUI, "minigame_launch_exception_andriod", MiniGameMonitorReport.MiniGameLaunchErrorType.LOAD_JSSDK_ERROR.ordinal(), "ErrorCode:" + i3, true);
        runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.5
            @Override // java.lang.Runnable
            public void run() {
                if (GameRuntimeStateObserver.this.mGameUI != null) {
                    GameRuntimeStateObserver.this.mGameUI.notifyExit(true, false, false);
                }
            }
        });
    }

    private void onGameRuntimeMsgFirstRender(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        int i3;
        String str;
        QMLog.i(TAG, "Game First render. " + this.mMiniAppInfo);
        this.mHasFirstFrameFinished = true;
        Object obj = miniAppStateMessage.obj;
        if (obj instanceof Integer) {
            i3 = ((Integer) obj).intValue();
        } else {
            i3 = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mFirstRenderTime = currentTimeMillis;
        long j3 = currentTimeMillis - this.mOnGameSurfaceCreateTime;
        long j16 = currentTimeMillis - this.mBeginOnCreate;
        long j17 = currentTimeMillis - this.mOnGameLaunchedTime;
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1043, null, this.mGameUI.getLaunchMsg(), null, i3, "1", j16, null);
        QMLog.e("[minigame][timecost] ", "step[onFirstFrameAppear] (\u9996\u5e27\u51fa\u73b0) cost time " + j3 + "(from create surfaceView), " + j16 + "(from onCreate) " + j17 + " ms(from gameLaunched)");
        runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.3
            @Override // java.lang.Runnable
            public void run() {
                GameRuntimeStateObserver.this.mGameUI.hideLoading();
                if (GameRuntimeStateObserver.this.mMiniAppInfo != null && GameRuntimeStateObserver.this.mMiniAppInfo.launchParam != null) {
                    FloatDragAdDataManager.requestAd(GameRuntimeStateObserver.this.mActivity, GameRuntimeStateObserver.this.mGameUI.getGameRuntime(), GameRuntimeStateObserver.this.mMiniAppInfo.appId, GameRuntimeStateObserver.this.mMiniAppInfo.launchParam.scene);
                    PendantDataManager.requestAd(GameRuntimeStateObserver.this.mActivity, GameRuntimeStateObserver.this.mGameUI.getGameRuntime(), GameRuntimeStateObserver.this.mMiniAppInfo.appId, GameRuntimeStateObserver.this.mMiniAppInfo.launchParam.scene);
                    MiniLoadingAdManager.getInstance().preloadLoadingAd(GameRuntimeStateObserver.this.mMiniAppInfo);
                }
            }
        });
        BaseRuntimeLoader baseRuntimeLoader = miniAppStateMessage.appRuntimeLoader;
        if (baseRuntimeLoader != null) {
            baseRuntimeLoader.notifyRuntimeEvent(11, new Object[0]);
        }
        this.mLaunchEngineUISteps.onFirstFrame();
        TaskExecutionStatics taskExecutionStatics = getTaskExecutionStatics(j16);
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            str = miniAppInfo.appId;
        } else {
            str = "";
        }
        MiniGameBeaconReport.reportLaunchStatics(str, taskExecutionStatics, this.mGameLaunchStatistic, true, this.mGameUI.getStatMode());
        reportFirstRender();
        preDownloadGameTaskJsBundle();
        this.mGameUI.onFirstFrame();
        QMLog.e("[minigame][timecost] ", "launchGame " + this.mGameUI.getMiniAppInfo() + " GameLoadTaskExecutionStatics: \n" + TaskStaticsVisualizer.visualizeToString(taskExecutionStatics));
        EnginePackageUpdater.f(this.mMiniAppInfo);
    }

    private void onGpkgFailed(final AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        QMLog.i(TAG, "Failed to load game package. " + this.mMiniAppInfo);
        runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver.2
            @Override // java.lang.Runnable
            public void run() {
                String customPackageLoadFailToast;
                if (GameRuntimeStateObserver.this.mActivity != null) {
                    MiniAppInfo miniAppInfoFromStateMessage = GameRuntimeStateObserver.this.getMiniAppInfoFromStateMessage(miniAppStateMessage);
                    QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
                    if (qQCustomizedProxy == null) {
                        customPackageLoadFailToast = null;
                    } else {
                        customPackageLoadFailToast = qQCustomizedProxy.getCustomPackageLoadFailToast(GameRuntimeStateObserver.this.mActivity, miniAppInfoFromStateMessage);
                    }
                    if (TextUtils.isEmpty(customPackageLoadFailToast)) {
                        customPackageLoadFailToast = "\u5c0f\u6e38\u620f\u914d\u7f6e\u52a0\u8f7d\u5931\u8d25\uff01";
                    }
                    MiniToast.makeText(GameRuntimeStateObserver.this.mActivity, customPackageLoadFailToast, 0).show();
                }
                QMLog.e(GameRuntimeStateObserver.TAG, "\u5c0f\u6e38\u620f\u914d\u7f6e\u52a0\u8f7d\u5931\u8d25\uff01");
            }
        });
        long currentTimeMillis = System.currentTimeMillis() - this.mLoadGameStartTime;
        MiniGdtReporter.report(this.mMiniAppInfo, 511);
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1036, null, null, null, -1, "1", currentTimeMillis, null);
        reportDownloadFailed(miniAppStateMessage);
        QMLog.e("[minigame][timecost] ", "step[load gpkg] fail, cost time: " + currentTimeMillis);
    }

    private void onGpkgLoading(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        QMLog.i(TAG, "Game package loading. " + miniAppStateMessage.obj + this.mMiniAppInfo);
        Object obj = miniAppStateMessage.obj;
        if (obj instanceof LoadingStatus) {
            LoadingStatus loadingStatus = (LoadingStatus) obj;
            if (loadingStatus.isInProgress()) {
                this.mGameUI.setPackageDownloadFlag(true);
            }
            this.mGameUI.updateLoadingProcessText(loadingStatus.getProcessInPercentage(), loadingStatus.getProgress());
        }
    }

    private void onLoadRuntimeFinished(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        if (miniAppStateMessage != null) {
            Object obj = miniAppStateMessage.obj;
            if (obj instanceof Integer) {
                reportInitRuntime(((Integer) obj).intValue());
            }
        }
    }

    private void onMsgHide() {
        notifyGameOnHide();
        com.tencent.qqmini.minigame.report.a aVar = this.mRunTimeReport;
        if (aVar != null) {
            aVar.h();
        }
        reportLaunchPerformance();
        reportPlayTime();
        StartupReportUtil.markPaused(this.mMiniAppInfo);
    }

    private void preDownloadGameTaskJsBundle() {
        HippyPageProxy hippyPageProxy = (HippyPageProxy) ProxyManager.get(HippyPageProxy.class);
        String a16 = com.tencent.qqmini.minigame.utils.a.a(this.mMiniAppInfo);
        if (hippyPageProxy != null && !TextUtils.isEmpty(a16)) {
            hippyPageProxy.downloadJSBundle(a16, 1);
        }
    }

    private void reportDownloadFailed(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        if (!(miniAppStateMessage.obj instanceof Bundle)) {
            return;
        }
        int ordinal = MiniGameMonitorReport.MiniGameLaunchErrorType.DOWNLOAD_MAIN_PACKAGE_ERROR.ordinal();
        Bundle bundle = (Bundle) miniAppStateMessage.obj;
        if (bundle.getBoolean("isSuccess")) {
            ordinal = MiniGameMonitorReport.MiniGameLaunchErrorType.DOWNLOAD_ENGINE_PLUGIN_ERROR.ordinal();
        }
        MiniGameMonitorReport.n(this.mGameUI, "minigame_launch_exception_andriod", ordinal, bundle.getString("errMsg"), true);
    }

    private void reportFirstRender() {
        HashMap hashMap = new HashMap();
        hashMap.put("code", String.valueOf(0));
        MiniGameMonitorReport.o(this.mGameUI, "minigame_launch_first_render_andriod", hashMap, true);
    }

    private void reportGameInnerLoadingCost() {
        AtomicLong atomicLong = this.mGameInnerStartTime;
        if (atomicLong == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - atomicLong.get();
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "page_view", SDKMiniProgramLpReportDC04239.PAGE_VIEW_SUB_ACTION_GAME_ON, null, String.valueOf(currentTimeMillis));
    }

    private void reportGameLoadCanceled(GameStopType gameStopType) {
        String str;
        if (!this.mHasFirstFrameFinished && !this.mHasReportLoadCanceled) {
            this.mHasReportLoadCanceled = true;
            TaskExecutionStatics taskExecutionStatics = getTaskExecutionStatics(System.currentTimeMillis() - this.mBeginOnCreate);
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null) {
                str = miniAppInfo.appId;
            } else {
                str = "";
            }
            MiniGameBeaconReport.reportGameLoadCancelEvent(str, taskExecutionStatics, this.mGameLaunchStatistic, gameStopType, this.mGameUI.getStatMode());
        }
    }

    private void reportInitRuntime(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("code", String.valueOf(i3));
        MiniGameMonitorReport.o(this.mGameUI, "minigame_launch_init_runtime_andriod", hashMap, true);
    }

    private void reportLaunchPerformance() {
        if (this.mIsReportStartPerformance) {
            return;
        }
        this.mIsReportStartPerformance = true;
        long j3 = this.mFirstRenderTime;
        if (j3 > 0) {
            MiniGameMonitorReport.p(this.mGameUI, getTaskExecutionStatics(j3 - this.mBeginOnCreate), this.mBeginOnCreate, this.mFirstRenderTime);
        } else {
            List<TaskExecutionStatics> taskStatics = this.mGameUI.getTaskStatics();
            taskStatics.add(this.mLaunchEngineUISteps.getExecutionStatics());
            MiniGameMonitorReport.p(this.mGameUI, new TaskExecutionStatics("root", 0L, 0L, TaskExecutionStatics.Status.FAIL, "", taskStatics), this.mBeginOnCreate, 0L);
        }
    }

    private void reportPlayTime() {
        if (this.mFirstRenderTime > 0 && this.mLastOnShowTime > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.mLastOnShowTime;
            long j16 = this.mFirstRenderTime;
            if (j3 < j16) {
                j3 = j16;
            }
            long j17 = (currentTimeMillis - j3) / 1000;
            HashMap hashMap = new HashMap();
            ou3.a jankStatistics = MiniGamePerformanceStatics.getInstance().getJankStatistics();
            hashMap.put("duration", String.valueOf(j17));
            hashMap.put("jankCount", String.valueOf(jankStatistics.getJankCount()));
            hashMap.put("bigJankCount", String.valueOf(jankStatistics.getBigJankCount()));
            hashMap.put("totalJankTimeSec", String.valueOf(jankStatistics.d()));
            MiniGameMonitorReport.o(this.mGameUI, "minigame_duration_andriod", hashMap, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnUiThread(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    private void startGameInnerLoadingWatch() {
        long j3;
        if (this.mGameInnerStartTime != null) {
            QMLog.w(TAG, "startGameInnerLoadingWatch not first, break");
            return;
        }
        Runnable runnable = this.mGameInnerLoadingWatchDog;
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
            this.mGameInnerLoadingWatchDog = null;
        }
        this.mGameInnerStartTime = new AtomicLong(System.currentTimeMillis());
        boolean z16 = !GpkgManager.isGpkgDownloaded(this.mMiniAppInfo.appId);
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class);
        if (wnsConfigProxy != null) {
            j3 = wnsConfigProxy.getGameInnerTimeoutSetting(z16);
        } else {
            j3 = 60000;
        }
        GameInnerLoadingWatchDog gameInnerLoadingWatchDog = new GameInnerLoadingWatchDog(this.mGameUI);
        this.mGameInnerLoadingWatchDog = gameInnerLoadingWatchDog;
        this.mMainHandler.postDelayed(gameInnerLoadingWatchDog, j3);
    }

    public void onGameStart() {
        com.tencent.qqmini.minigame.report.a aVar = this.mRunTimeReport;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver
    public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        this.mMiniAppInfo = this.mGameUI.getMiniAppInfo();
        this.mActivity = this.mGameUI.getActivity();
        int i3 = miniAppStateMessage.what;
        if (i3 != 5) {
            if (i3 != 6) {
                if (i3 != 20) {
                    if (i3 != 60) {
                        if (i3 != 63) {
                            if (i3 != 72) {
                                if (i3 != 2021) {
                                    if (i3 != 2022) {
                                        if (i3 != 2031) {
                                            if (i3 != 2032) {
                                                switch (i3) {
                                                    case 2001:
                                                        onGpkgLoading(miniAppStateMessage);
                                                        return;
                                                    case 2002:
                                                        QMLog.i(TAG, "Game package loaded. " + this.mMiniAppInfo);
                                                        this.mGameUI.updateLoadingProcessText("100%", 1.0f);
                                                        long currentTimeMillis = System.currentTimeMillis() - this.mLoadGameStartTime;
                                                        MiniReportManager.reportEventType(this.mMiniAppInfo, 1036, null, this.mGameUI.getLaunchMsg(), null, 0, "1", currentTimeMillis, null);
                                                        QMLog.e("[minigame][timecost] ", "step[load gpkg] succeed, cost time: " + currentTimeMillis);
                                                        return;
                                                    case 2003:
                                                        onGpkgFailed(miniAppStateMessage);
                                                        return;
                                                    default:
                                                        switch (i3) {
                                                            case 2011:
                                                                QMLog.i(TAG, "Game engine loading. " + this.mMiniAppInfo);
                                                                Object obj = miniAppStateMessage.obj;
                                                                if (obj instanceof LoadingStatus) {
                                                                    LoadingStatus loadingStatus = (LoadingStatus) obj;
                                                                    this.mGameUI.updateLoadingProcessText(loadingStatus.getProcessInPercentage(), loadingStatus.getProgress());
                                                                    return;
                                                                }
                                                                return;
                                                            case 2012:
                                                                onEngineLoaded(miniAppStateMessage);
                                                                return;
                                                            case 2013:
                                                                onGameRuntimeMsgEngineFailed(miniAppStateMessage);
                                                                return;
                                                            default:
                                                                switch (i3) {
                                                                    case GameConst.GAME_RUNTIME_MSG_GAME_ON_SHOW /* 2051 */:
                                                                        this.mLastOnShowTime = System.currentTimeMillis();
                                                                        notifyGameOnShow();
                                                                        com.tencent.qqmini.minigame.report.a aVar = this.mRunTimeReport;
                                                                        if (aVar != null) {
                                                                            aVar.f(this.mGameUI);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    case 2052:
                                                                        onMsgHide();
                                                                        return;
                                                                    case 2053:
                                                                        notifyGameStop();
                                                                        Object obj2 = miniAppStateMessage.obj;
                                                                        if (obj2 instanceof GameStopType) {
                                                                            reportGameLoadCanceled((GameStopType) obj2);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    default:
                                                                        return;
                                                                }
                                                        }
                                                }
                                            }
                                            onGameRuntimeMsgFirstRender(miniAppStateMessage);
                                            return;
                                        }
                                        QMLog.i(TAG, "Game surface create. " + this.mMiniAppInfo);
                                        this.mOnGameSurfaceCreateTime = System.currentTimeMillis();
                                        return;
                                    }
                                    onLoadRuntimeFinished(miniAppStateMessage);
                                    return;
                                }
                                long currentTimeMillis2 = System.currentTimeMillis() - this.mLoadGameStartTime;
                                MiniReportManager.reportEventType(this.mMiniAppInfo, 1037, null, this.mGameUI.getLaunchMsg(), null, 0, "1", currentTimeMillis2, null);
                                QMLog.e("[minigame][timecost] ", "[MiniEng] step[init runTime] cost time " + currentTimeMillis2 + ", include steps[load baseLib, load gpkg]");
                                this.mLaunchEngineUISteps.onRuntimeInitDone();
                                return;
                            }
                            QMLog.d(TAG, "RUNTIME_MSG_CLOSE_INNER obj" + miniAppStateMessage.obj);
                            Object obj3 = miniAppStateMessage.obj;
                            if (obj3 instanceof MiniAppConst.RuntimeCloseType) {
                                if (obj3 == MiniAppConst.RuntimeCloseType.CLOSE_BUTTON) {
                                    reportGameLoadCanceled(GameStopType.CAPSULE_BUTTON);
                                    if (!(this.mActivity instanceof InternalMiniActivity)) {
                                        this.mGameUI.notifyExit(false, false, true);
                                        return;
                                    } else {
                                        this.mGameUI.notifyExit(true, false, false);
                                        return;
                                    }
                                }
                                if (obj3 == MiniAppConst.RuntimeCloseType.TRITON_ERROR) {
                                    this.mGameUI.notifyExit(true, true, false);
                                    return;
                                } else {
                                    this.mGameUI.notifyExit(true, false, false);
                                    return;
                                }
                            }
                            return;
                        }
                        QMLog.i(TAG, "Game launched. " + this.mMiniAppInfo);
                        Pair pair = (Pair) miniAppStateMessage.obj;
                        this.mOnGameLaunchedTime = System.currentTimeMillis();
                        Object obj4 = pair.second;
                        this.mGameLaunchStatistic = (GameLaunchStatistic) obj4;
                        this.mLaunchEngineUISteps.onGameLaunched((GameLaunchStatistic) obj4);
                        return;
                    }
                    reportGameLoadCanceled(GameStopType.CAPSULE_BUTTON);
                    return;
                }
                QMLog.i(TAG, "User click. onCreate/onNewIntent. " + this.mMiniAppInfo);
                this.mLoadGameStartTime = System.currentTimeMillis();
                this.mMainHandler.postDelayed(this.mGameLaunchWatchDog, 10000L);
                return;
            }
            notifyGameRealCanPlay();
            return;
        }
        startGameInnerLoadingWatch();
    }

    public void release() {
        this.mMainHandler.removeCallbacksAndMessages(null);
        com.tencent.qqmini.minigame.report.a aVar = this.mRunTimeReport;
        if (aVar != null) {
            aVar.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCreateTimeStamp() {
        this.mBeginOnCreate = System.currentTimeMillis();
    }

    @NonNull
    private TaskExecutionStatics getTaskExecutionStatics(long j3) {
        List<TaskExecutionStatics> taskStatics = this.mGameUI.getTaskStatics();
        taskStatics.add(this.mLaunchEngineUISteps.getExecutionStatics());
        TaskExecutionStatics taskExecutionStatics = taskStatics.get(0);
        return new TaskExecutionStatics("root", taskExecutionStatics.getRunDurationMs() + j3, taskExecutionStatics.getRunDurationMs() + j3, TaskExecutionStatics.Status.SUCCESS, "", taskStatics);
    }
}
