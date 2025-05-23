package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.qqmini.minigame.GameConst;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.GameRuntimeLoader;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.report.GameStopType;
import com.tencent.qqmini.minigame.report.MiniGameMonitorReport;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.action.RestartAction;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView;
import com.tencent.qqmini.sdk.launcher.utils.CPUUtil;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.manager.MiniGameUserAgreementManager;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.runtime.BaseUIProxy;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
/* loaded from: classes23.dex */
public class GameUIProxy extends BaseUIProxy {
    private static final String META_MINI_GAME_APPID = "1112288843";
    private static HashMap<String, WeakReference<GameUIProxy>> mUIProxyMap = new HashMap<>();
    private GameActivityStatusWatcher mBroadcastWatcher;
    private long mLoadingAdCloseTime;
    private BaseGameLoadingView mLoadingUI;
    private MiniAppInfo mMiniAppInfo;
    private GameRuntime mRuntime;
    private boolean mPkgDownloadFlag = false;
    private boolean mHasReportStepOnResume = false;
    private int mStartMode = 3;
    private final GameRuntimeStateObserver mGameRuntimeStateObserver = new GameRuntimeStateObserver(this);
    private final AtomicLong mActivityStartDuration = new AtomicLong(0);
    private final AtomicLong mActivityStartTime = new AtomicLong(0);
    private String mGameRoundId = "";

    private boolean checkParamsValid(Intent intent) {
        if (intent == null) {
            QMLog.e("minisdk-start_UIProxy", "[checkParamsValid] intent is null");
            return false;
        }
        if (((MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO)) == null) {
            QMLog.e("minisdk-start_UIProxy", "[checkParamsValid] miniAppInfo is null");
            return false;
        }
        return true;
    }

    private void createGameActivityStatusWatcher(Activity activity) {
        GameActivityStatusWatcher gameActivityStatusWatcher = new GameActivityStatusWatcher(activity);
        this.mBroadcastWatcher = gameActivityStatusWatcher;
        gameActivityStatusWatcher.setOnHomePressedListener(new GameActivityStatusWatcher.OnWatcherActionListener() { // from class: com.tencent.qqmini.minigame.ui.GameUIProxy.2
            @Override // com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher.OnWatcherActionListener
            public void onHomePressed() {
                QMLog.e("minisdk-start_UIProxy", "home pressed!");
                AppStateEvent.obtain(2053, GameStopType.HOME_PRESS).notifyRuntime(GameUIProxy.this.getRuntime());
            }

            @Override // com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher.OnWatcherActionListener
            public void onRecentTaskPressed() {
                QMLog.e("minisdk-start_UIProxy", "rencent task to front!");
                AppStateEvent.obtain(2053, GameStopType.RECENT_PRESS).notifyRuntime(GameUIProxy.this.getRuntime());
            }

            @Override // com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher.OnWatcherActionListener
            public void onScreenOff() {
                QMLog.e("minisdk-start_UIProxy", "screen off");
                AppStateEvent.obtain(2053, GameStopType.SCREEN_OFF).notifyRuntime(GameUIProxy.this.getRuntime());
            }

            @Override // com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher.OnWatcherActionListener
            public void onShowMonitorView(boolean z16) {
            }
        });
        this.mBroadcastWatcher.startWatch();
    }

    private void createLoadingUI(Activity activity, MiniAppInfo miniAppInfo) {
        BaseGameLoadingView createCustomLoadingView;
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy == null) {
            createCustomLoadingView = null;
        } else {
            createCustomLoadingView = qQCustomizedProxy.createCustomLoadingView(activity, miniAppInfo);
        }
        if (createCustomLoadingView == null) {
            createCustomLoadingView = new LoadingUI(activity);
        }
        this.mLoadingUI = createCustomLoadingView;
    }

    private void dealWithStartActTime(Activity activity, final MiniAppInfo miniAppInfo, Intent intent, Bundle bundle) {
        final long j3;
        String str;
        long longExtra = intent.getLongExtra("startDuration", 0L);
        if (bundle != null) {
            QMLog.i("minisdk-start_UIProxy", "[dealWithStartActTime] savedInstanceState != null, reset startActivityTime");
            j3 = 0;
        } else {
            j3 = longExtra;
        }
        Uri referrer = activity.getReferrer();
        if (referrer != null) {
            str = referrer.toString();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        final String str2 = str;
        ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameUIProxy.1
            @Override // java.lang.Runnable
            public void run() {
                long j16;
                String processName = AppLoaderFactory.g().getProcessName();
                long lastStartActTime = GameUIProxy.this.getLastStartActTime(processName);
                long j17 = j3;
                if (j17 != 0 && lastStartActTime == j17) {
                    j17 = 0;
                }
                GameUIProxy.this.mActivityStartTime.set(j17);
                if (j17 != 0) {
                    j16 = System.currentTimeMillis() - j17;
                    GameUIProxy.this.saveStartActTime(processName, j17);
                } else {
                    j16 = 500;
                }
                GameUIProxy.this.mActivityStartDuration.set(j16);
                MiniReportManager.reportEventType(miniAppInfo, 1030, null, String.valueOf(GameUIProxy.this.mStartMode), null, 0, "1", j16, null);
                GameUIProxy.this.logOnAttachActivity(str2, miniAppInfo, j16);
            }
        });
    }

    private void destroyGameActivityStatusWatcher() {
        try {
            this.mBroadcastWatcher.stopWatch();
        } catch (Exception e16) {
            QMLog.e("minisdk-start_UIProxy", "[destroyGameActivityStatusWatcher] error:" + e16.getMessage());
        }
    }

    private String generateGameRoundId() {
        return String.valueOf((System.currentTimeMillis() * 1000) + ((int) (Math.random() * 1000.0d)));
    }

    public static GameUIProxy getGameUIProxy(MiniAppInfo miniAppInfo) {
        WeakReference<GameUIProxy> weakReference;
        if (miniAppInfo != null && (weakReference = mUIProxyMap.get(getMiniAppKey(miniAppInfo))) != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getLastStartActTime(String str) {
        return StorageUtil.getPreference().getLong(str + "startDuration", 0L);
    }

    private static String getMiniAppKey(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return "";
        }
        return miniAppInfo.appId + "_" + miniAppInfo.verType;
    }

    private void getUserAgreement() {
        MiniAppInfo miniAppInfo;
        if (((WnsConfigProxy) ProxyManager.get(WnsConfigProxy.class)) != null && (miniAppInfo = this.mMiniAppInfo) != null && !isMetaDream(miniAppInfo.appId)) {
            MiniGameUserAgreementManager.f348129b.h(this.mMiniAppInfo.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAdLoading() {
        this.hasCompletedLoading = true;
        this.loadCompleteTimeForLoadingAdReport = System.currentTimeMillis();
        BaseGameLoadingView baseGameLoadingView = this.mLoadingUI;
        if (baseGameLoadingView != null) {
            baseGameLoadingView.hide();
        }
        GameRuntime gameRuntime = this.mRuntime;
        if (gameRuntime != null) {
            gameRuntime.onLoadingEnd();
        }
    }

    private void initStatusBar(MiniAppInfo miniAppInfo) {
        if (miniAppInfo != null && miniAppInfo.isShowStatusBar()) {
            showStatusBar();
        }
    }

    private boolean isHotLoad(BaseRuntimeLoader baseRuntimeLoader, BaseRuntimeLoader baseRuntimeLoader2) {
        if (baseRuntimeLoader != null && baseRuntimeLoader == baseRuntimeLoader2) {
            return baseRuntimeLoader.isLoadSucceed();
        }
        return false;
    }

    private boolean isMetaDream(String str) {
        return "1112288843".equals(str);
    }

    private static boolean isValidABI(MiniAppInfo miniAppInfo) {
        if (CPUUtil.sIsX86Emulator) {
            if (miniAppInfo != null) {
                SDKMiniProgramLpReportDC04239.reportPageView(miniAppInfo, "1", null, "load_fail", "system_version_limit_fail");
                MiniAppReportManager2.reportPageView("2launch_fail", "system_version_limit_fail", null, miniAppInfo);
                return false;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logOnAttachActivity(String str, MiniAppInfo miniAppInfo, long j3) {
        QMLog.e("[minigame][timecost] ", "step[startActivity] cost time: " + j3 + " startMode: " + this.mStartMode + " miniAppInfo: " + miniAppInfo + " referrer: " + str);
    }

    private void processGetVipWithoutAdLogic() {
        ((AdProxy) ProxyManager.get(AdProxy.class)).getVipWithoutAdMemberState();
    }

    private void processStartupLoadingReport(MiniAppInfo miniAppInfo, long j3) {
        int i3;
        if (miniAppInfo == null) {
            return;
        }
        int i16 = this.mStartMode;
        boolean z16 = false;
        if (i16 == 3) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i16 != 3) {
            z16 = true;
        }
        StartupReportUtil.reportLoading(miniAppInfo, j3, z16, i3);
    }

    private void resetQuery() {
        GameInfoManager gameInfoManager;
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader != null) {
            BaseRuntime runtime = baseRuntimeLoader.getRuntime();
            if ((runtime instanceof GameRuntime) && (gameInfoManager = ((GameRuntime) runtime).getGameInfoManager()) != null) {
                gameInfoManager.resetQuery();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveStartActTime(String str, long j3) {
        StorageUtil.getPreference().edit().putLong(str + "startDuration", j3).apply();
    }

    private void showStatusBar() {
        WindowManager.LayoutParams attributes = this.mActivity.getWindow().getAttributes();
        attributes.flags &= -1025;
        this.mActivity.getWindow().setAttributes(attributes);
        this.mActivity.getWindow().clearFlags(512);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        return false;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public String getGameRoundId() {
        return this.mGameRoundId;
    }

    public GameRuntime getGameRuntime() {
        return this.mRuntime;
    }

    public String getLaunchMsg() {
        if (this.mPkgDownloadFlag) {
            return "firstLaunch" + this.mStartMode;
        }
        return "twiceLaunch" + this.mStartMode;
    }

    public long getLoadingAdCloseTime() {
        return this.mLoadingAdCloseTime;
    }

    BaseGameLoadingView getLoadingUI() {
        return this.mLoadingUI;
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    public MiniAppInfo getMiniAppInfo() {
        return this.mMiniAppInfo;
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected AppRuntimeEventCenter.RuntimeStateObserver getRuntimeStateObserver() {
        return this.mGameRuntimeStateObserver;
    }

    public int getStatMode() {
        return this.mStartMode;
    }

    public List<TaskExecutionStatics> getTaskStatics() {
        List<TaskExecutionStatics> taskExecuteStatics;
        GameRuntimeLoader gameRuntimeLoader = (GameRuntimeLoader) this.mCurrRuntimeLoader;
        if (gameRuntimeLoader == null) {
            taskExecuteStatics = new ArrayList<>();
        } else {
            taskExecuteStatics = gameRuntimeLoader.getTaskExecuteStatics();
        }
        long j3 = this.mActivityStartDuration.get();
        long j16 = this.mActivityStartTime.get();
        taskExecuteStatics.add(0, new TaskExecutionStatics("StartActivity", j3, j3, TaskExecutionStatics.Status.SUCCESS, "mode:" + this.mStartMode, new ArrayList(), j16));
        QMLog.d("[minigame][timecost] ", "getTaskStatics: duration=" + j3 + " startTime=" + j16);
        return taskExecuteStatics;
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IUIProxy
    public void handleRestart() {
        BaseRuntime runtime = getRuntime();
        if (runtime == null) {
            QMLog.e("minisdk-start_UIProxy", "handleRestart failed runtime is null");
        } else {
            RestartAction.restart(runtime);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    public void hideLoading() {
        GameRuntime gameRuntime;
        long currentTimeMillis = System.currentTimeMillis() - this.loadStartTimeStamp;
        if (isAbleToShowLoadingAd() && (gameRuntime = this.mRuntime) != null && gameRuntime.isLoadingAdEnabled() && !this.hasHideLoading) {
            this.hasHideLoading = true;
            if (currentTimeMillis < this.adLimitShowTime) {
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameUIProxy.4
                    @Override // java.lang.Runnable
                    public void run() {
                        GameUIProxy.this.showDefaultLoadingAd();
                        GameUIProxy.this.hideAdLoading();
                    }
                }, this.adLimitShowTime - currentTimeMillis);
                return;
            } else {
                showDefaultLoadingAd();
                hideAdLoading();
                return;
            }
        }
        hideAdLoading();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected boolean isAbleToShowAd() {
        GameRuntime gameRuntime;
        if (!this.hasCompletedLoading && (gameRuntime = this.mRuntime) != null && gameRuntime.isLoadingAdEnabled()) {
            return true;
        }
        return false;
    }

    public boolean isFromPreload() {
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader != null && baseRuntimeLoader.getAppStateManager() != null && this.mCurrRuntimeLoader.getAppStateManager().isFromPreload) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        super.onActivityResult(activity, i3, i16, intent);
        AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
        if (adProxy != null) {
            adProxy.onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onAttachActivity(Activity activity, Bundle bundle, ViewGroup viewGroup) {
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = activity.getIntent();
        if (!checkParamsValid(intent)) {
            MiniToast.makeText(activity, "\u542f\u52a8\u53c2\u6570\u51fa\u9519\uff0c\u8bf7\u91cd\u8bd5", 1).show();
            activity.finish();
            return;
        }
        MiniAppInfo miniAppInfo = (MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO);
        if (!isValidABI(miniAppInfo)) {
            MiniToast.makeText(activity, "\u5c0f\u6e38\u620f\u4e0d\u652f\u6301\u8be5\u8bbe\u5907", 1).show();
            activity.finish();
            return;
        }
        MiniAppEnv.g().setMiniGameEnv(new com.tencent.qqmini.minigame.b(this));
        mUIProxyMap.put(getMiniAppKey(miniAppInfo), new WeakReference<>(this));
        this.mStartMode = intent.getIntExtra("start_mode", 3);
        if (bundle != null) {
            this.mStartMode = 3;
            if (miniAppInfo != null) {
                miniAppInfo.launchParam.startupReportData = null;
            }
        }
        dealWithStartActTime(activity, miniAppInfo, intent, bundle);
        this.mGameRuntimeStateObserver.setOnCreateTimeStamp();
        createGameActivityStatusWatcher(activity);
        createLoadingUI(activity, miniAppInfo);
        super.onAttachActivity(activity, bundle, viewGroup);
        initStatusBar(miniAppInfo);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        MiniReportManager.reportEventType(miniAppInfo, 1031, null, String.valueOf(this.mStartMode), null, 0, "1", currentTimeMillis2, null);
        QMLog.e("[minigame][timecost] ", "step[doOnCreate] cost time: " + currentTimeMillis2);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IUIProxy
    public boolean onBackPressed(Activity activity) {
        AppStateEvent.obtain(2053, GameStopType.BACK_PRESS).notifyRuntime(getRuntime());
        return super.onBackPressed(activity);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameUIProxy.7
            @Override // java.lang.Runnable
            public void run() {
                GameRuntime gameRuntime = GameUIProxy.this.getGameRuntime();
                if (GameUIProxy.this.mRuntime == null) {
                    QMLog.e("minisdk-start_UIProxy", "onConfigurationChanged failed runtime is null");
                    return;
                }
                Pair<Integer, Integer> a16 = com.tencent.qqmini.minigame.utils.b.a(gameRuntime.getContext(), DisplayUtil.getDisplayMetrics(gameRuntime.getContext()), gameRuntime.isOrientationLandscape(), PageAction.obtain(gameRuntime).getSurfaceViewWidth(), PageAction.obtain(gameRuntime).getSurfaceViewHeight());
                QMLog.d("minisdk-start_UIProxy", "screenSize:" + a16);
                JSONObject jSONObject = new JSONObject();
                if (a16 != null) {
                    try {
                        jSONObject.put("windowWidth", a16.first);
                        jSONObject.put("windowHeight", a16.second);
                    } catch (JSONException e16) {
                        QMLog.e("minisdk-start_UIProxy", "map callbackJson failed.", e16);
                    }
                }
                gameRuntime.performAction(ServiceSubscribeEvent.obtain("onWindowResize", jSONObject.toString(), 0));
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onDetachActivity(Activity activity) {
        QMLog.i("minisdk-start_UIProxy", "onDetachActivity");
        mUIProxyMap.remove(getMiniAppKey(this.mMiniAppInfo));
        destroyGameActivityStatusWatcher();
        this.mGameRuntimeStateObserver.release();
        super.onDetachActivity(activity);
    }

    public void onFirstFrame() {
        GameRuntime gameRuntime = this.mRuntime;
        if (gameRuntime != null) {
            gameRuntime.showNotifyBubble();
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onIntentUpdate(Intent intent) {
        super.onIntentUpdate(intent);
        GameRuntime gameRuntime = this.mRuntime;
        if (gameRuntime != null) {
            gameRuntime.onIntentUpdate(intent);
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniPause() {
        AppStateEvent.obtain(2052).notifyRuntime(getRuntime());
        resetQuery();
        super.onMiniPause();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniResume() {
        if (this.mCurrRuntimeLoader == null) {
            QMLog.e("minisdk-start_UIProxy", this + " GameUIProxy.onMiniResume() current runtime loader is null!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean isLoadSucceed = this.mCurrRuntimeLoader.isLoadSucceed();
        if (!isLoadSucceed) {
            QMLog.d("minisdk-start_UIProxy", "onResume(). runtime is loading. start cold boot. " + this.mCurrRuntimeLoader.getMiniAppInfo());
            this.mCurrRuntimeLoader.start();
        }
        super.onMiniResume();
        if (isLoadSucceed) {
            QMLog.d("minisdk-start_UIProxy", "onResume(). runtime is loaded. warm boot. " + this.mCurrRuntimeLoader.getMiniAppInfo());
            this.mCurrRuntimeLoader.notifyRuntimeEvent(GameConst.GAME_RUNTIME_MSG_GAME_ON_SHOW, new Object[0]);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (!this.mHasReportStepOnResume) {
            this.mHasReportStepOnResume = true;
            MiniReportManager.reportEventType(this.mCurrRuntimeLoader.getMiniAppInfo(), 1035, null, String.valueOf(this.mStartMode), null, 0, "1", currentTimeMillis2, null);
            QMLog.e("[minigame][timecost] ", "step[onResume] cost time: " + currentTimeMillis2);
        }
        GameRuntime gameRuntime = this.mRuntime;
        if (gameRuntime != null) {
            gameRuntime.updateViewIfAdFinished();
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStart() {
        super.onMiniStart();
        AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
        if (adProxy != null) {
            adProxy.onActivityStart();
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStop() {
        if (getRuntime() != null) {
            getRuntime().onRuntimeStop();
        }
        AppLoaderFactory.g().getAppBrandProxy().onAppBackground(getMiniAppInfo(), null);
        AppStateEvent.obtain(22).notifyRuntime(getRuntime());
        AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
        if (adProxy != null) {
            adProxy.onActivityStop();
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void onRuntimeFail(int i3, final String str) {
        if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
            super.onRuntimeFail(i3, str);
            return;
        }
        QMLog.e("minisdk-start_UIProxy", this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onRuntimeFail. Whoops, failed to load the runtime, retCode = " + i3 + ", msg = " + str);
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameUIProxy.3
            @Override // java.lang.Runnable
            public void run() {
                MiniToast.makeText(MiniAppEnv.g().getContext(), "\u52a0\u8f7d\u5931\u8d25\uff0c" + str, 0).show();
                if (((BaseUIProxy) GameUIProxy.this).mActivity != null) {
                    ((BaseUIProxy) GameUIProxy.this).mActivity.finish();
                }
            }
        }, 1000L);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void onRuntimeReady() {
        QMLog.i("minisdk-start_UIProxy", "GameRuntime onRuntimeReady. Here we go, start the runtime lifecycle");
        this.mMiniAppInfo = this.mCurrRuntimeLoader.getMiniAppInfo();
        GameRuntime gameRuntime = (GameRuntime) this.mCurrRuntimeLoader.getRuntime();
        this.mRuntime = gameRuntime;
        if (gameRuntime != null) {
            gameRuntime.setPackageDownloadFlag(this.mPkgDownloadFlag);
            this.mRuntime.setStartMode(this.mStartMode);
        }
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        String str = null;
        if ((baseRuntimeLoader instanceof GameRuntimeLoader) && !((GameRuntimeLoader) baseRuntimeLoader).isGameReadyStart(this.mMiniAppInfo)) {
            SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "not_ready");
            MiniAppReportManager2.reportPageView("2launch_fail", "not_ready", null, this.mMiniAppInfo);
            return;
        }
        if (NetworkUtil.getActiveNetworkType(getActivity()) == 0) {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null && !miniAppInfo.isSupportOffline) {
                SDKMiniProgramLpReportDC04239.reportPageView(miniAppInfo, "1", null, "load_fail", "offline_not_support");
                MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_support", null, this.mMiniAppInfo);
                MiniToast.makeText(getActivity(), "\u6b64\u6e38\u620f\u6682\u4e0d\u652f\u6301\u79bb\u7ebf\u6a21\u5f0f", 0).show();
                return;
            } else if (miniAppInfo != null && !GpkgManager.isOfflineResourceReady(miniAppInfo)) {
                SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "offline_not_ready");
                MiniAppReportManager2.reportPageView("2launch_fail", "offline_not_ready", null, this.mMiniAppInfo);
                QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
                if (qQCustomizedProxy != null) {
                    str = qQCustomizedProxy.getCustomPackageLoadFailToast(getActivity(), this.mMiniAppInfo);
                }
                if (TextUtils.isEmpty(str)) {
                    str = "\u6e38\u620f\u8d44\u6e90\u672a\u52a0\u8f7d\u5b8c\u6210\uff0c\u8bf7\u8054\u7f51\u540e\u91cd\u8bd5";
                }
                MiniToast.makeText(getActivity(), str, 0).show();
                return;
            }
        }
        getUserAgreement();
        GameRuntime gameRuntime2 = this.mRuntime;
        if (gameRuntime2 != null) {
            gameRuntime2.onRuntimeAttachActivity(this.mActivity, this.mRootLayout);
            this.mRuntime.onRuntimeResume();
        }
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        MiniAppInfo miniAppInfo2 = getMiniAppInfo();
        if (channelProxy != null && miniAppInfo2 != null) {
            channelProxy.syncForceGroundAndRefreshBadge(this.mActivity, miniAppInfo2.appId, AppLoaderFactory.g().getProcessName());
        }
        QQCustomizedProxy qQCustomizedProxy2 = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy2 != null && miniAppInfo2 != null) {
            qQCustomizedProxy2.checkRoamLocalAuthState(this.mActivity, miniAppInfo2.appId);
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void reloadMiniAppInfoIfNeed(BaseRuntimeLoader baseRuntimeLoader, MiniAppInfo miniAppInfo) {
        if (baseRuntimeLoader.isLoadSucceed()) {
            if (!miniAppInfo.isShortcutFakeApp()) {
                baseRuntimeLoader.updateMiniAppInfo(miniAppInfo);
            }
            baseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
            hideLoading();
            return;
        }
        showLoading(miniAppInfo);
        baseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
        if (!baseRuntimeLoader.isRunning()) {
            baseRuntimeLoader.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPackageDownloadFlag(boolean z16) {
        this.mPkgDownloadFlag = z16;
        GameRuntime gameRuntime = this.mRuntime;
        if (gameRuntime != null) {
            gameRuntime.setPackageDownloadFlag(z16);
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void showLoading(MiniAppInfo miniAppInfo) {
        this.hasCompletedLoading = false;
        this.hasHideLoading = false;
        BaseGameLoadingView baseGameLoadingView = this.mLoadingUI;
        if (baseGameLoadingView == null) {
            return;
        }
        baseGameLoadingView.initUIData(miniAppInfo).show(this.mRootLayout);
        processGetVipWithoutAdLogic();
        processSelectLoadingAdLogic(miniAppInfo);
    }

    public void showUpdateMobileQQDialog() {
        String qQUpdateUrl;
        String str = "";
        try {
            qQUpdateUrl = GameWnsUtils.getQQUpdateUrl();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            if (getMiniAppInfo() != null) {
                str = getMiniAppInfo().appId;
            }
            if (qQUpdateUrl.contains("{appid}") && !TextUtils.isEmpty(str)) {
                str = qQUpdateUrl.replace("{appid}", str);
            } else {
                str = qQUpdateUrl;
            }
            QMLog.i("minisdk-start_UIProxy", "showUpdateMobileQQDialog jump to upgrate page:" + str);
            Intent intent = new Intent();
            intent.putExtra("hide_more_button", true);
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra("url", str);
            ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).startBrowserActivity(getActivity(), intent);
        } catch (Throwable th6) {
            th = th6;
            str = qQUpdateUrl;
            QMLog.e(AppLoaderFactory.TAG, "jump to upgrate page exception! url=" + str, th);
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void startMiniAppInfo(MiniAppInfo miniAppInfo, Bundle bundle) {
        String str;
        String str2;
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(miniAppInfo);
        this.adLimitShowTime = 0L;
        MiniQMMKVProxy miniQMMKVProxy = (MiniQMMKVProxy) ProxyManager.get(MiniQMMKVProxy.class);
        if (miniQMMKVProxy != null) {
            try {
                this.adLimitShowTime = Long.parseLong(miniQMMKVProxy.getMiniAppString(MiniLoadingAdManager.EXTRA_GAME_LOADING_KEY, "0"));
            } catch (NumberFormatException e16) {
                QMLog.e("minisdk-start_UIProxy", "startMiniAppInfo error:", e16);
            }
        }
        super.startMiniAppInfo(miniAppInfo, bundle);
        boolean isHotLoad = isHotLoad(queryAppRunTimeLoader, this.mCurrRuntimeLoader);
        if (!isHotLoad) {
            this.mGameRoundId = generateGameRoundId();
        }
        if (miniAppInfo != null && isHotLoad) {
            StartupReportUtil.reportDelete(miniAppInfo);
        } else {
            processStartupLoadingReport(miniAppInfo, bundle.getLong("startDuration", 0L));
        }
        HashMap hashMap = new HashMap();
        if (isHotLoad) {
            str = "2";
        } else {
            str = "1";
        }
        hashMap.put("launchType", str);
        if (miniAppInfo != null) {
            str2 = miniAppInfo.appId;
        } else {
            str2 = "";
        }
        hashMap.put("appId", str2);
        MiniGameMonitorReport.o(this, "minigame_launch_start_andriod", hashMap, true);
        this.mGameRuntimeStateObserver.onGameStart();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void updateLoadingAdUI(final MiniAppInfo miniAppInfo, final String str, final long j3, WeakReference<Activity> weakReference) {
        final Activity activity = weakReference.get();
        if (activity == null) {
            QMLog.e("minisdk-start_UIProxy", "updateLoadingAdUI activity is null!");
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameUIProxy.6

                /* renamed from: com.tencent.qqmini.minigame.ui.GameUIProxy$6$a */
                /* loaded from: classes23.dex */
                class a implements MiniLoadingAdManager.OnDismissListener {
                    a() {
                    }

                    @Override // com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnDismissListener
                    public void onDismiss() {
                        GameUIProxy.this.mLoadingAdCloseTime = System.currentTimeMillis();
                        GameUIProxy.this.updateLoadingAdStatus(3);
                        if (GameUIProxy.this.mRuntime != null) {
                            GameUIProxy.this.mRuntime.onLoadingAdShowEnd();
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (!GameUIProxy.this.isAbleToShowAd()) {
                        GameUIProxy.this.updateLoadingAdStatus(3);
                    } else {
                        GameUIProxy.this.updateLoadingAdStatus(2);
                        MiniLoadingAdManager.getInstance().updateLoadingAdLayoutAndShow(miniAppInfo, activity, true, str, j3, new a());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateLoadingProcessText(final String str, final float f16) {
        if (this.mLoadingUI == null) {
            return;
        }
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.GameUIProxy.5
            @Override // java.lang.Runnable
            public void run() {
                GameUIProxy.this.mLoadingUI.setProgressTxt(str);
                GameUIProxy.this.mLoadingUI.setProgressInt(f16);
            }
        });
    }
}
