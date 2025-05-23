package com.tencent.qqmini.minigame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.TritonPlatform;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.view.GameView;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqmini.minigame.MiniGameChromeInspectAgent;
import com.tencent.qqmini.minigame.api.MiniEnginePackage;
import com.tencent.qqmini.minigame.api.MiniErrorListener;
import com.tencent.qqmini.minigame.api.MiniGameDataFileSystem;
import com.tencent.qqmini.minigame.api.MiniGamePackage;
import com.tencent.qqmini.minigame.api.SimpleEngineLifeCycle;
import com.tencent.qqmini.minigame.debug.DebugWebSocket;
import com.tencent.qqmini.minigame.debug.QQDebugWebSocket;
import com.tencent.qqmini.minigame.helper.c;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.minigame.manager.GameTouchHeartBeatManager;
import com.tencent.qqmini.minigame.manager.JsApiUpdateManager;
import com.tencent.qqmini.minigame.notifybubble.MiniGameNotifyBubbleControl;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.qqmini.minigame.report.GameFrameReport;
import com.tencent.qqmini.minigame.report.GameSubpackageReport;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.minigame.statistics.FpsStatistics;
import com.tencent.qqmini.minigame.utils.TritonEngineUtil;
import com.tencent.qqmini.minigame.utils.f;
import com.tencent.qqmini.minigame.yungame.d;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.action.UpdateUIAction;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.Preloadable;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.PreCacheManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.IRuntimeLifecycleListener;
import com.tencent.qqmini.sdk.launcher.core.IScreenRecord;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AdReportData;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IMiniGameEnv;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics;
import com.tencent.qqmini.sdk.report.MiniGdtReporter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.MiniProgressDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameRuntime extends BaseRuntimeImpl implements Preloadable<TritonPlatform> {
    private static final String TAG = "GameRuntime";
    public static boolean sStorageReport = false;
    private Activity mActivity;
    private long mBackgroundTime;
    private com.tencent.qqmini.sdk.auth.a mColorSignAuthChecker;
    private boolean mFirstFrameDone;
    private com.tencent.qqmini.minigame.floatview.b mFloatViewFactory;
    private GameInfoManager mGameInfoManager;
    private InspectorAgent mGameInspectAgent;
    private GameLaunchStatistic mGameLaunchStatics;
    private GamePage mGamePage;
    private final AtomicBoolean mIsForeground;
    private GameJsPluginEngine mJsPluginEngine;
    private int mLaunchResult;
    private volatile boolean mLoadingAdEnabled;
    private MiniAppInfo mMiniAppInfo;
    private boolean mNeedLaunchGameOnResume;
    private MiniGameNotifyBubbleControl mNotifyBubbleControl;
    private boolean mOnFirstBlackScreenReport;
    private boolean mOnFirstHide;
    private long mOnGameLaunchedTime;
    private long mOnShowTime;
    private long mPauseTime;
    private final MiniGamePerformanceStatics mPerformanceStatics;
    private boolean mPkgDownloadFlag;
    protected boolean mPrecacheFetched;
    private ShareState mRecordShareState;
    private ViewGroup mRootView;
    private MiniProgressDialog mShareScreenshotProgressDialog;
    private ShareState mShareState;
    private int mStartMode;
    private GameTouchHeartBeatManager mTouchHeartBeatManager;
    private TritonEngine mTritonEngine;
    private MiniEnginePackage mTritonEnginePackage;
    private TritonPlatform mTritonPlatform;
    private final Handler mUIHandler;
    private com.tencent.qqmini.minigame.yungame.b mYunGamePage;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements d {
        a() {
        }

        @Override // com.tencent.qqmini.minigame.yungame.d
        @NonNull
        public String a() {
            if (GameRuntime.this.mGamePage != null) {
                GameRuntime.this.mGamePage.getMenuButtonBoundingClientRect(new NativeViewRequestEvent());
                return "{}";
            }
            return "{}";
        }
    }

    public GameRuntime(Context context) {
        super(context);
        this.mPrecacheFetched = false;
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mLoadingAdEnabled = true;
        this.mOnFirstHide = true;
        this.mOnFirstBlackScreenReport = true;
        this.mPkgDownloadFlag = false;
        this.mIsForeground = new AtomicBoolean(false);
        this.mLaunchResult = 0;
        this.mFirstFrameDone = false;
        this.mStartMode = 3;
        QMLog.i("floatBox.GameRuntime", "[GameRuntime]");
        this.mShareState = new ShareState();
        this.mRecordShareState = new ShareState();
        this.mFloatViewFactory = new com.tencent.qqmini.minigame.floatview.b();
        this.mColorSignAuthChecker = new c();
        MiniGamePerformanceStatics miniGamePerformanceStatics = MiniGamePerformanceStatics.getInstance();
        this.mPerformanceStatics = miniGamePerformanceStatics;
        miniGamePerformanceStatics.recordInitialMemory();
        this.mNotifyBubbleControl = new MiniGameNotifyBubbleControl();
    }

    private void addFloatView() {
        this.mFloatViewFactory.a(17);
        this.mFloatViewFactory.a(18);
        this.mFloatViewFactory.a(19);
        this.mFloatViewFactory.i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public GameLaunchParam createGameLaunchParam() {
        boolean z16;
        boolean z17;
        JankTraceLevel jankTraceLevel;
        Intent intent;
        if (this.mGamePage == null) {
            QMLog.e(TAG, "createGameLaunchParam: mGamePage is null");
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(getClass(), this);
        Activity activity = this.mActivity;
        boolean z18 = false;
        if (activity != null && (intent = activity.getIntent()) != null) {
            z16 = intent.getBooleanExtra("isMute", false);
        } else {
            z16 = false;
        }
        boolean webgl2Config = this.mGamePage.getGamePackage().getWebgl2Config();
        if (!webgl2Config) {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null && hu3.a.c(miniAppInfo.appId)) {
                z18 = true;
            }
            z17 = z18;
        } else {
            z17 = webgl2Config;
        }
        if (z17) {
            MiniGameBeaconReport.reportWebgl2Usage(this.mMiniAppInfo);
        }
        MiniGamePackage gamePackage = this.mGamePage.getGamePackage();
        MiniGameDataFileSystem miniGameDataFileSystem = new MiniGameDataFileSystem(this.mMiniAppInfo.apkgInfo);
        GameView from = GameView.INSTANCE.from(this.mGamePage.getGameSurfaceView());
        InspectorAgent inspectorAgent = this.mGameInspectAgent;
        if (isJankCanaryBriefEnabled()) {
            jankTraceLevel = JankTraceLevel.BRIEF;
        } else {
            jankTraceLevel = JankTraceLevel.NONE;
        }
        return new GameLaunchParam(gamePackage, miniGameDataFileSystem, from, inspectorAgent, jankTraceLevel, hashMap, z16, z17);
    }

    private void destroyFloatView() {
        this.mFloatViewFactory.f();
    }

    private void destroyGamePage() {
        QMLog.i(TAG, "destroyGamePage");
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            gamePage.onDestroy();
            this.mGamePage = null;
        }
        com.tencent.qqmini.minigame.yungame.b bVar = this.mYunGamePage;
        if (bVar != null) {
            bVar.doOnDestroy();
            this.mYunGamePage = null;
        }
        MiniGameNotifyBubbleControl miniGameNotifyBubbleControl = this.mNotifyBubbleControl;
        if (miniGameNotifyBubbleControl != null) {
            miniGameNotifyBubbleControl.m();
            this.mNotifyBubbleControl = null;
        }
    }

    private void destroyTTEngine() {
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine != null) {
            tritonEngine.destroy();
            this.mTritonEngine = null;
        }
    }

    private void destroyTouchHeartBeatManager() {
        GameTouchHeartBeatManager gameTouchHeartBeatManager = this.mTouchHeartBeatManager;
        if (gameTouchHeartBeatManager != null) {
            gameTouchHeartBeatManager.g();
            this.mTouchHeartBeatManager = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doOnTTEngineExit() {
        QMLog.i(TAG, "doOnEngineExit");
        IRuntimeLifecycleListener iRuntimeLifecycleListener = this.mLifecycleListener;
        if (iRuntimeLifecycleListener != null) {
            iRuntimeLifecycleListener.onDestroy(MiniAppEnv.g().getContext(), this.mMiniAppInfo);
        }
    }

    private void initGamePage() {
        GamePage gamePage = new GamePage();
        this.mGamePage = gamePage;
        gamePage.init((IMiniAppContext) this);
        QMLog.i(TAG, "initGamePage");
    }

    private void initTouchHeartBeat() {
        this.mTouchHeartBeatManager = new GameTouchHeartBeatManager(this.mTritonEngine);
    }

    private boolean isGameLaunchSuccess(GameLaunchStatistic gameLaunchStatistic) {
        if (gameLaunchStatistic.getSuccess()) {
            return true;
        }
        if (!gameLaunchStatistic.getEngineInitStatistic().getSuccess()) {
            return false;
        }
        for (ScriptLoadStatistic scriptLoadStatistic : gameLaunchStatistic.getGameScriptLoadStatics()) {
            if (scriptLoadStatistic.getScriptContextType() == ScriptContextType.MAIN && !scriptLoadStatistic.getLoadResult().getIsSuccess()) {
                return false;
            }
        }
        return true;
    }

    private boolean isJankCanaryBriefEnabled() {
        boolean z16;
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (miniAppProxy.isDebugVersion()) {
            String account = miniAppProxy.getAccount();
            if (this.mActivity.getSharedPreferences(account + "_user_sdk_minigame_", 0).getBoolean("_minigame_enable_jank_canary_brief", false)) {
                return true;
            }
        }
        if (new Random().nextInt(10000) < WnsConfig.getConfig("qqminiapp", "mini_game_jank_trace_sampling_rate", 100)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        QMLog.e(TAG, "sampled for JankCanary Trace Info");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchGame() {
        if (this.mActivity == null) {
            QMLog.e(TAG, "launchGame: current activity is null.");
            return;
        }
        String str = null;
        if (!this.mIsForeground.get()) {
            SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "load_fail", "not_foreground");
            MiniAppReportManager2.reportPageView("2launch_fail", "not_foreground", null, this.mMiniAppInfo);
            QMLog.e(TAG, "not in forground, donot lauchGame");
            this.mNeedLaunchGameOnResume = true;
            return;
        }
        this.mNeedLaunchGameOnResume = false;
        Activity activity = this.mActivity;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            str = miniAppInfo.appId;
        }
        com.tencent.qqmini.minigame.manager.a.a(activity, str);
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.GameRuntime.8
            @Override // java.lang.Runnable
            public void run() {
                GameLaunchParam createGameLaunchParam = GameRuntime.this.createGameLaunchParam();
                if (createGameLaunchParam == null) {
                    QMLog.e(GameRuntime.TAG, "launchGame: failed, launchParam is null.");
                    return;
                }
                SDKMiniProgramLpReportDC04239.reportPageView(GameRuntime.this.mMiniAppInfo, "1", null, "load", null);
                MiniAppReportManager2.reportPageView("2load", null, null, GameRuntime.this.mMiniAppInfo);
                MiniReportManager.reportEventType(GameRuntime.this.mMiniAppInfo, 1007, "1");
                GameRuntime.this.mTritonPlatform.launchGame(createGameLaunchParam, new GameLaunchCallback() { // from class: com.tencent.qqmini.minigame.GameRuntime.8.1
                    @Override // com.tencent.mobileqq.triton.engine.GameLaunchCallback
                    public void onFirstFrame(@NotNull FirstFrameStatistic firstFrameStatistic) {
                        GameRuntime.this.onFirstFrame(firstFrameStatistic);
                    }

                    @Override // com.tencent.mobileqq.triton.engine.GameLaunchCallback
                    public void onGameLaunched(@Nullable TritonEngine tritonEngine, @NotNull GameLaunchStatistic gameLaunchStatistic) {
                        GameRuntime.this.onGameLaunched(tritonEngine, gameLaunchStatistic);
                    }

                    @Override // com.tencent.mobileqq.triton.engine.GameLaunchCallback
                    public void onV8OOM() {
                        GameRuntime.this.onTritonV8OOM();
                    }
                });
            }
        });
    }

    private void launchGameWithChromeInspect() {
        MiniToast.makeText(this.mContext, "\u6b63\u5728\u4f7f\u7528 Chrome Inspect\uff0c\u7b49\u5f85\u8fde\u63a5\u4e2d...", 1).show();
        MiniGameChromeInspectAgent miniGameChromeInspectAgent = new MiniGameChromeInspectAgent();
        this.mGameInspectAgent = miniGameChromeInspectAgent;
        miniGameChromeInspectAgent.f(new MiniGameChromeInspectAgent.b() { // from class: com.tencent.qqmini.minigame.GameRuntime.7
            private boolean mHasLaunch = false;

            @Override // com.tencent.qqmini.minigame.MiniGameChromeInspectAgent.b
            public void onConnected() {
                QMLog.w(GameRuntime.TAG, "launchGameWithChromeInspect onConnected");
                GameRuntime.this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.GameRuntime.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!AnonymousClass7.this.mHasLaunch) {
                            AnonymousClass7.this.mHasLaunch = true;
                            GameRuntime.this.launchGame();
                        }
                    }
                });
            }

            @Override // com.tencent.qqmini.minigame.MiniGameChromeInspectAgent.b
            public void onDisconnected() {
                QMLog.w(GameRuntime.TAG, "launchGameWithChromeInspect onDisconnected");
            }
        });
    }

    private void launchGameWithIDEDebug() {
        QQDebugWebSocket qQDebugWebSocket = new QQDebugWebSocket(this, this.mMiniAppInfo);
        this.mGameInspectAgent = qQDebugWebSocket;
        qQDebugWebSocket.startConnectIDE(new DebugWebSocket.DebuggerStateListener() { // from class: com.tencent.qqmini.minigame.GameRuntime.6
            @Override // com.tencent.qqmini.minigame.debug.DebugWebSocket.DebuggerStateListener
            public void onDebuggerBreakPointPaused() {
                QMLog.e("GameRuntime DebugSocket", "launchGame debugger BreakPointPaused");
                if (GameRuntime.this.mGamePage != null) {
                    GameRuntime.this.mGamePage.updateDebuggerStatus("\u65ad\u70b9\u4e2d", null, true);
                }
            }

            @Override // com.tencent.qqmini.minigame.debug.DebugWebSocket.DebuggerStateListener
            public void onDebuggerConnectedNormal() {
                QMLog.e("GameRuntime DebugSocket", "launchGame debugger connected ");
                if (GameRuntime.this.mGamePage != null) {
                    GameRuntime.this.mGamePage.updateDebuggerStatus("\u5df2\u8fde\u63a5", null, false);
                }
                GameRuntime.this.launchGame();
            }

            @Override // com.tencent.qqmini.minigame.debug.DebugWebSocket.DebuggerStateListener
            public void onDebuggerDisconnect(String str) {
                QMLog.e("GameRuntime DebugSocket", "launchGame debugger Disconnect");
                if (GameRuntime.this.mGamePage != null) {
                    GameRuntime.this.mGamePage.updateDebuggerStatus("\u8fde\u63a5\u65ad\u5f00", "\u5173\u95ed\u8c03\u8bd5\u8fde\u63a5", false);
                }
            }

            @Override // com.tencent.qqmini.minigame.debug.DebugWebSocket.DebuggerStateListener
            public void onDebuggerReconnecting(String str) {
                QMLog.e("GameRuntime DebugSocket", "launchGame debugger Reconnecting");
                if (GameRuntime.this.mGamePage != null) {
                    GameRuntime.this.mGamePage.updateDebuggerStatus("\u8fde\u63a5\u65ad\u5f00", "\u91cd\u65b0\u5efa\u7acb\u8c03\u8bd5\u8fde\u63a5...", false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFirstFrame(FirstFrameStatistic firstFrameStatistic) {
        this.mFirstFrameDone = true;
        QMLog.i(TAG, "onFirstRender. " + this.mMiniAppInfo);
        performAction(AppStateEvent.obtain(GameConst.GAME_RUNTIME_MSG_FIRST_RENDER, Integer.valueOf(this.mLaunchResult)));
        this.mOnShowTime = System.currentTimeMillis();
        if (this.mPkgDownloadFlag) {
            this.mPkgDownloadFlag = false;
            QMLog.i(TAG, "game[" + this.mMiniAppInfo.appId + "][" + this.mMiniAppInfo.name + "] \u51b7\u542f\u52a8\uff0c\u9996\u5e27\u51fa\u73b0!");
            MiniReportManager.reportEventType(this.mMiniAppInfo, 1022, "1");
        } else {
            QMLog.i(TAG, "game[" + this.mMiniAppInfo.appId + "][" + this.mMiniAppInfo.name + "] \u70ed\u542f\u52a8,\u4e8c\u6b21\u542f\u52a8\u6e38\u620f!");
            MiniReportManager.reportEventType(this.mMiniAppInfo, 1023, "1");
            JsApiUpdateManager.checkForUpdate(this.mMiniAppInfo, new JsApiUpdateManager.IUpdateListener() { // from class: com.tencent.qqmini.minigame.GameRuntime.3
                @Override // com.tencent.qqmini.minigame.manager.JsApiUpdateManager.IUpdateListener
                public void onCheckResult(boolean z16) {
                    QMLog.i(GameRuntime.TAG, "UpdateManager checkResult hasUpdate:" + z16 + ", currentAppInfo:" + GameRuntime.this.mMiniAppInfo);
                    AppStateEvent.obtain(2054, Boolean.valueOf(z16)).notifyRuntime(GameRuntime.this);
                }

                @Override // com.tencent.qqmini.minigame.manager.JsApiUpdateManager.IUpdateListener
                public void onDownloadResult(boolean z16) {
                    QMLog.i(GameRuntime.TAG, "UpdateManager downloadResult success:" + z16 + ", currentAppInfo:" + GameRuntime.this.mMiniAppInfo);
                    AppStateEvent.obtain(GameConst.GAME_RUNTIME_MSG_UPDATE_DOWNLOAD_RESULT, Boolean.valueOf(z16)).notifyRuntime(GameRuntime.this);
                }
            });
        }
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1042, null, null, null, 0, "1", this.mOnShowTime - this.mOnGameLaunchedTime, null);
        AdFrequencyLimit.setOnStartTime(this.mOnShowTime);
        this.mUIHandler.post(new Runnable() { // from class: com.tencent.qqmini.minigame.GameRuntime.4
            @Override // java.lang.Runnable
            public void run() {
                if (GameRuntime.this.mGamePage != null) {
                    GameRuntime.this.mGamePage.showKingCardTips();
                }
                UpdateUIAction.updateRedDot(GameRuntime.this);
                if (GameRuntime.this.isLoadingAdShowing()) {
                    GameRuntime.this.pauseEngineOnly();
                } else if (GameRuntime.this.mGamePage != null) {
                    GameRuntime.this.mGamePage.checkPayForFriendLogic(GameRuntime.this.mMiniAppInfo);
                }
                GameRuntime.this.mFloatViewFactory.b(19, "");
            }
        });
        this.mFloatViewFactory.e(this.mMiniAppInfo.appId);
        preloadSpringHbRaffleMaterial();
        ((AdProxy) ProxyManager.get(AdProxy.class)).onFirstFrame();
        StartupReportUtil.reportShow(this.mMiniAppInfo, this.mBackgroundTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGameLaunched(TritonEngine tritonEngine, @NonNull GameLaunchStatistic gameLaunchStatistic) {
        String str;
        QMLog.e("[minigame] ", "onGameLaunched: success?" + gameLaunchStatistic.getSuccess() + ", exception:" + gameLaunchStatistic.getException());
        this.mGameLaunchStatics = gameLaunchStatistic;
        this.mTritonEngine = tritonEngine;
        if (tritonEngine != null) {
            this.mFloatViewFactory.j(tritonEngine);
            tritonEngine.observeLifeCycle(new SimpleEngineLifeCycle() { // from class: com.tencent.qqmini.minigame.GameRuntime.1
                @Override // com.tencent.qqmini.minigame.api.SimpleEngineLifeCycle, com.tencent.mobileqq.triton.lifecycle.LifeCycle
                public void onDestroy() {
                    GameRuntime.this.doOnTTEngineExit();
                }
            });
            tritonEngine.getStatisticsManager().setFrameCallback(new GameFrameReport(this.mMiniAppInfo.appId));
            tritonEngine.getStatisticsManager().setFpsUpdateListener(new FpsStatistics(this));
            tritonEngine.getStatisticsManager().setSubpackageLoadStatisticsCallback(new GameSubpackageReport());
            tritonEngine.getStatisticsManager().setErrorCallback(new MiniErrorListener(this.mContext, this.mMiniAppInfo) { // from class: com.tencent.qqmini.minigame.GameRuntime.2
                @Override // com.tencent.qqmini.minigame.api.MiniErrorListener
                public void notifyExit() {
                    com.tencent.qqmini.sdk.utils.a.b(GameRuntime.this, MiniAppConst.RuntimeCloseType.TRITON_ERROR);
                }
            });
            if (this.mIsForeground.get()) {
                tritonEngine.start();
            }
        }
        GamePage gamePage = this.mGamePage;
        int i3 = 0;
        if (gamePage != null && gamePage.isOrientationLandscape() && !isLoadingAdShowing()) {
            this.mGamePage.adjustViewForOrientation();
            this.mLoadingAdEnabled = false;
            QMLog.i(TAG, "onGameLaunched: disable loadingAd for landscape");
        }
        long createEGLContextTimeMs = gameLaunchStatistic.getEngineInitStatistic().getCreateEGLContextTimeMs();
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1039, null, String.valueOf(this.mStartMode), null, 0, "1", createEGLContextTimeMs, null);
        QMLog.e("[minigame][timecost] ", "step[create surfaceView] cost time: " + createEGLContextTimeMs + "(from create SurfaceView)");
        this.mLaunchResult = 0;
        long launchTimesMs = gameLaunchStatistic.getLaunchTimesMs();
        if (!isGameLaunchSuccess(gameLaunchStatistic)) {
            i3 = -1;
        }
        this.mLaunchResult = i3;
        this.mOnGameLaunchedTime = System.currentTimeMillis();
        QMLog.i("[minigame][timecost] ", "step[launchGame] launchResult: " + this.mLaunchResult + ", timeCost: " + launchTimesMs + ", " + this.mMiniAppInfo + ", statics=" + gameLaunchStatistic);
        MiniReportManager.reportEventType(this.mMiniAppInfo, 1040, null, null, null, 0, "1", launchTimesMs, null);
        AppStateEvent.obtain(63, new Pair(Integer.valueOf(this.mLaunchResult), gameLaunchStatistic)).notifyRuntime(this);
        AppStateEvent.obtain(GameConst.GAME_RUNTIME_MSG_GAME_ON_SHOW).notifyRuntime(this);
        MiniAppReportManager2.reportPageView("2load_end", String.valueOf(this.mLaunchResult), null, this.mMiniAppInfo);
        if (this.mLaunchResult >= 0) {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (this.mPkgDownloadFlag) {
                str = "1";
            } else {
                str = "0";
            }
            MiniReportManager.addCostTimeEventAttachInfo(miniAppInfo, 1008, str);
            MiniReportManager.reportEventType(this.mMiniAppInfo, 1008, "1");
            return;
        }
        SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "show_fail", "load_pkg_fail");
        MiniAppReportManager2.reportPageView("2launch_fail", "load_pkg_fail", null, this.mMiniAppInfo);
        MiniGdtReporter.report(this.mMiniAppInfo, 512);
        MiniCacheFreeManager.freeCacheDialog(this.mActivity, LoginManager.getInstance().getAccount(), this.mMiniAppInfo, GameWnsUtils.getGameLaunchFailContent(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTritonV8OOM() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.GameRuntime.5
            @Override // java.lang.Runnable
            public void run() {
                f.a(GameRuntime.this.mActivity, GameRuntime.this.mMiniAppInfo);
            }
        });
    }

    private void preloadSpringHbRaffleMaterial() {
        String str;
        GameInfoManager gameInfoManager = this.mGameInfoManager;
        if (gameInfoManager != null) {
            JSONObject queryPath = gameInfoManager.getQueryPath();
            QMLog.d(TAG, "preloadSpringHbRaffleMaterial query: " + queryPath);
            if ("springfestival".equals(queryPath.optString(EventKey.ACT))) {
                MiniAppInfo miniAppInfo = this.mMiniAppInfo;
                if (miniAppInfo != null) {
                    str = miniAppInfo.appId;
                } else {
                    str = null;
                }
                RaffleJsPlugin.preloadGameRaffleMaterial(this.mContext, str, ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount());
            }
        }
    }

    private void reportAppFirstStorageUsage() {
        long j3;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            j3 = Storage.getCurrentStorageSize(miniAppInfo.appId);
        } else {
            j3 = -1;
        }
        if (j3 >= 0 && !sStorageReport) {
            sStorageReport = true;
            MiniReportManager.reportEventType(this.mMiniAppInfo, 639, null, String.valueOf(j3), null, 1, "1", 0L, null);
        }
    }

    private void reportGameBlackScreen() {
        long j3;
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine != null && tritonEngine.getState() != EngineState.DESTROYED) {
            j3 = this.mTritonEngine.getStatisticsManager().getLastBlackScreenTimeMillis();
        } else {
            j3 = 0;
        }
        if (this.mOnFirstBlackScreenReport && j3 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - j3;
            if (currentTimeMillis > 0) {
                this.mOnFirstBlackScreenReport = false;
                MiniReportManager.reportEventType(this.mMiniAppInfo, 1018, null, null, null, 0, "1", currentTimeMillis, null);
                QMLog.e(TAG, "doOnPause blackTimeDuration " + currentTimeMillis);
            }
        }
    }

    private void reportGameFirstStayDuration() {
        if (this.mOnFirstHide && this.mOnShowTime > 0) {
            this.mOnFirstHide = false;
            MiniReportManager.reportEventType(this.mMiniAppInfo, 1016, "1");
            long currentTimeMillis = System.currentTimeMillis() - this.mOnShowTime;
            if (currentTimeMillis > 0) {
                MiniReportManager.reportEventType(this.mMiniAppInfo, 1020, null, null, null, 0, "1", currentTimeMillis, null);
            }
        }
    }

    private void reportGameStayDuration() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.mOnShowTime;
        long j16 = currentTimeMillis - j3;
        if (j16 > 0 && j3 > 0) {
            MiniReportManager.reportEventType(this.mMiniAppInfo, 1021, null, null, null, 0, "1", j16, null);
        }
    }

    private void reportOnDestroy() {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null) {
            return;
        }
        MiniReportManager.reportEventType(miniAppInfo, 22, "1");
        SDKMiniProgramLpReportDC04239.reportPageView(this.mMiniAppInfo, "1", null, "unload", null);
        MiniAppReportManager2.reportPageView("2unload", null, null, this.mMiniAppInfo);
        SDKMiniProgramLpReportDC04239.deleteRecordDurationMsg();
    }

    private void reportOnPause() {
        reportGameBlackScreen();
        reportGameFirstStayDuration();
        reportGameStayDuration();
        reportAppFirstStorageUsage();
        SDKMiniProgramLpReportDC04239.deleteRecordDurationMsg();
    }

    public void attachYunGamePage(com.tencent.qqmini.minigame.yungame.b bVar) {
        boolean z16;
        this.mYunGamePage = bVar;
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            z16 = !"portrait".equals(gamePage.getPageOrientation());
        } else {
            z16 = false;
        }
        bVar.b(new a());
        bVar.d(this.mRootView, z16, new b());
    }

    public void checkPayForFriendLogic(MiniAppInfo miniAppInfo) {
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            gamePage.checkPayForFriendLogic(miniAppInfo);
        }
    }

    protected void dismissShareScreenshotProgress() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.GameRuntime.11
            @Override // java.lang.Runnable
            public void run() {
                if (GameRuntime.this.mShareScreenshotProgressDialog != null) {
                    GameRuntime.this.mShareScreenshotProgressDialog.dismiss();
                    GameRuntime.this.mShareScreenshotProgressDialog = null;
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public AdReportData getAdReportData() {
        AdReportData adReportData = super.getAdReportData();
        adReportData.path = "";
        adReportData.canScroll = 0;
        adReportData.referPath = "";
        adReportData.networkType = NetworkUtil.getActiveNetworkType(getContext());
        adReportData.lastClicks = getLastClicks();
        adReportData.isGame = 1;
        return adReportData;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IBaseAppContext
    /* renamed from: getAttachedActivity */
    public Activity getAttachActivity() {
        return this.mActivity;
    }

    public com.tencent.qqmini.sdk.auth.a getAuthChecker() {
        return this.mColorSignAuthChecker;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public String getBaseLibVersion() {
        return getJsVersion();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IBaseAppContext
    public Context getContext() {
        return MiniAppEnv.g().getContext();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    @androidx.annotation.Nullable
    public CrashRtInfoHolder getCrashRtInfoHolder() {
        boolean z16;
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        String jsVersion = getJsVersion();
        String tritonVersion = getTritonVersion();
        if (this.mLaunchResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return new ku3.c(miniAppInfo, jsVersion, tritonVersion, z16, this.mFirstFrameDone);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public long getCurrentDrawCount() {
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine != null && tritonEngine.getState() != EngineState.DESTROYED) {
            return this.mTritonEngine.getStatisticsManager().getCurrentDrawCalls();
        }
        return 0L;
    }

    public MiniEnginePackage getEnginePackage() {
        return this.mTritonEnginePackage;
    }

    public com.tencent.qqmini.minigame.floatview.b getFloatViewCtrl() {
        return this.mFloatViewFactory;
    }

    @Nullable
    public IMiniGameEnv.IMiniGameFloatViewOperator getFloatViewOperator(int i3) {
        com.tencent.qqmini.minigame.floatview.a d16 = this.mFloatViewFactory.d(i3);
        if (d16 == null) {
            return null;
        }
        return d16.d();
    }

    public TritonEngine getGameEngine() {
        return this.mTritonEngine;
    }

    public GameInfoManager getGameInfoManager() {
        return this.mGameInfoManager;
    }

    public GameLaunchStatistic getGameLaunchStatics() {
        return this.mGameLaunchStatics;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public IJsPluginEngine getJsPluginEngine() {
        GameJsPluginEngine gameJsPluginEngine = this.mJsPluginEngine;
        if (gameJsPluginEngine != null) {
            return gameJsPluginEngine.getRealPluginEngine();
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public IJsService getJsService() {
        GameJsPluginEngine gameJsPluginEngine = this.mJsPluginEngine;
        if (gameJsPluginEngine != null) {
            return gameJsPluginEngine.getCommonJsService(ScriptContextType.MAIN);
        }
        return null;
    }

    public String getJsVersion() {
        MiniEnginePackage miniEnginePackage = this.mTritonEnginePackage;
        if (miniEnginePackage != null && miniEnginePackage.getJsLibVersion() != null) {
            return this.mTritonEnginePackage.getJsLibVersion().getVersion();
        }
        return "";
    }

    public String getLastClicks() {
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine != null && tritonEngine.getState() != EngineState.DESTROYED) {
            return this.mTritonEngine.getStatisticsManager().getLastClicks();
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public MiniAppInfo getMiniAppInfo() {
        return this.mMiniAppInfo;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public IPage getPage() {
        return this.mGamePage;
    }

    public QQDebugWebSocket getQQDebugSocket() {
        InspectorAgent inspectorAgent = this.mGameInspectAgent;
        if (inspectorAgent instanceof QQDebugWebSocket) {
            return (QQDebugWebSocket) inspectorAgent;
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public ShareState getRecordShareState() {
        return this.mRecordShareState;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public IScreenRecord getScreenRecordMgr() {
        Object d16 = this.mFloatViewFactory.d(17);
        if (d16 instanceof IScreenRecord) {
            return (IScreenRecord) d16;
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void getScreenshot(final GetScreenshot.Callback callback) {
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine == null && tritonEngine.getState() != EngineState.DESTROYED) {
            QMLog.e(TAG, "Failed to get screen shot. TTEngine is null");
            if (callback != null) {
                callback.onGetScreenshot(null);
                return;
            }
            return;
        }
        showShareScreenshotProgress();
        this.mShareState.isGettingScreenShot = true;
        this.mTritonEngine.takeScreenShot(new ScreenShotCallback() { // from class: com.tencent.qqmini.minigame.GameRuntime.9
            @Override // com.tencent.mobileqq.triton.engine.ScreenShotCallback
            public void onGetScreenShot(@NotNull Object obj) {
                final Bitmap bitmap;
                if (obj instanceof Bitmap) {
                    bitmap = (Bitmap) obj;
                } else {
                    bitmap = null;
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.minigame.GameRuntime.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                            GetScreenshot.Callback callback2 = callback;
                            if (callback2 != null) {
                                GameRuntime gameRuntime = GameRuntime.this;
                                callback2.onGetScreenshot(ImageUtil.cutAndSaveShareScreenshot(gameRuntime, gameRuntime.mActivity, bitmap));
                            }
                            GameRuntime.this.mShareState.isGettingScreenShot = false;
                            GameRuntime.this.dismissShareScreenshotProgress();
                        }
                    });
                    return;
                }
                GetScreenshot.Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onGetScreenshot(null);
                }
                GameRuntime.this.mShareState.isGettingScreenShot = false;
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public ShareState getShareState() {
        return this.mShareState;
    }

    public String getTheLastClickInfo() {
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine != null && tritonEngine.getState() != EngineState.DESTROYED) {
            return this.mTritonEngine.getStatisticsManager().getLastClickInfo();
        }
        return null;
    }

    public String getTritonVersion() {
        MiniEnginePackage miniEnginePackage = this.mTritonEnginePackage;
        if (miniEnginePackage != null && miniEnginePackage.getSoVersion() != null) {
            return this.mTritonEnginePackage.getSoVersion().getVersion();
        }
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void handleFocusGain() {
        GameJsPluginEngine gameJsPluginEngine = this.mJsPluginEngine;
        if (gameJsPluginEngine != null) {
            gameJsPluginEngine.handleFocusGain();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void handleFocusLoss() {
        GameJsPluginEngine gameJsPluginEngine = this.mJsPluginEngine;
        if (gameJsPluginEngine != null) {
            gameJsPluginEngine.handleFocusLoss();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    /* renamed from: isForeground */
    public boolean getIsForeground() {
        return this.mIsForeground.get();
    }

    public boolean isLoadingAdEnabled() {
        return this.mLoadingAdEnabled;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean isMiniGame() {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean isOrientationLandscape() {
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            return gamePage.isOrientationLandscape();
        }
        return false;
    }

    public Boolean isYunGameRuntime() {
        boolean z16;
        if (this.mYunGamePage != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void loadMiniApp(MiniAppInfo miniAppInfo) {
        this.mMiniAppInfo = miniAppInfo;
        if (!this.mPrecacheFetched) {
            this.mPrecacheFetched = true;
            PreCacheManager.g().fetchPreCacheData(this.mMiniAppInfo);
            PreCacheManager.g().fetchPreResourceIfNeed(this.mMiniAppInfo);
        }
        ApkgInfo apkgInfo = (ApkgInfo) miniAppInfo.apkgInfo;
        AppConfigInfo appConfigInfo = new AppConfigInfo();
        apkgInfo.mAppConfigInfo = appConfigInfo;
        appConfigInfo.networkTimeoutInfo = new NetworkTimeoutInfo();
        NetworkTimeoutInfo networkTimeoutInfo = apkgInfo.mAppConfigInfo.networkTimeoutInfo;
        networkTimeoutInfo.request = 60000;
        networkTimeoutInfo.connectSocket = 60000;
        networkTimeoutInfo.downloadFile = 60000;
        networkTimeoutInfo.uploadFile = 60000;
        ((MiniAppFileManager) getManager(MiniAppFileManager.class)).initFileManager(apkgInfo, true);
        this.mFloatViewFactory.l(miniAppInfo);
        onLoadMiniAppInfo(this.mMiniAppInfo, false, null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public boolean onBackPress() {
        return false;
    }

    public void onFpsUpdate(float f16) {
        this.mPerformanceStatics.onGetFps(f16);
        TaskMonitorManager.g().setCurrentFps(f16);
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            gamePage.updateMonitorFPSText(f16, getCurrentDrawCount());
        }
    }

    public void onIntentUpdate(Intent intent) {
        com.tencent.qqmini.minigame.yungame.b bVar = this.mYunGamePage;
        if (bVar != null) {
            bVar.c(intent);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onLoadMiniAppInfo(MiniAppInfo miniAppInfo, boolean z16, String str) {
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            gamePage.onCreate(miniAppInfo);
        }
        this.mPerformanceStatics.setMiniAppInfo(miniAppInfo);
        this.mPerformanceStatics.setVersion(getJsVersion(), getTritonVersion());
    }

    public void onLoadingAdShowEnd() {
        updateViewIfAdFinished();
        resumeEngineOnly();
        checkPayForFriendLogic(this.mMiniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void onLoadingAdStatusChanged(int i3) {
        super.onLoadingAdStatusChanged(i3);
        com.tencent.qqmini.minigame.floatview.b bVar = this.mFloatViewFactory;
        if (bVar != null) {
            bVar.g(i3);
        }
    }

    public void onLoadingEnd() {
        updateViewIfAdFinished();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeAttachActivity(Activity activity, ViewGroup viewGroup) {
        if (this.mActivity == activity && this.mRootView == viewGroup) {
            checkPayForFriendLogic(this.mMiniAppInfo);
            return;
        }
        this.mActivity = activity;
        this.mRootView = viewGroup;
        this.mFloatViewFactory.k(viewGroup);
        this.mFloatViewFactory.h(this.mActivity);
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            gamePage.onAttachWindow(activity, viewGroup);
        }
        updateViewIfAdFinished();
        startGame();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeDestroy() {
        AppStateEvent.obtain(64).notifyRuntime(this);
        com.tencent.qqmini.sdk.utils.a.b(this, MiniAppConst.RuntimeCloseType.RUNTIME_DESTROY);
        destroyFloatView();
        destroyGamePage();
        destroyTTEngine();
        destroyTouchHeartBeatManager();
        reportOnDestroy();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeDetachActivity(Activity activity) {
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            gamePage.onDetachWindow(activity);
        }
        this.mActivity = null;
        this.mRootView = null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimePause() {
        try {
            reportOnPause();
        } catch (Throwable th5) {
            QMLog.e(TAG, "doOnPause reportOnPause ", th5);
        }
        this.mPauseTime = System.currentTimeMillis();
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            gamePage.onPause();
        }
        com.tencent.qqmini.minigame.yungame.b bVar = this.mYunGamePage;
        if (bVar != null) {
            bVar.doOnPause();
        }
        this.mIsForeground.set(false);
        this.lastStayTime += System.currentTimeMillis() - this.onResumeTime;
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine != null) {
            tritonEngine.stop();
        }
        GameTouchHeartBeatManager gameTouchHeartBeatManager = this.mTouchHeartBeatManager;
        if (gameTouchHeartBeatManager != null) {
            gameTouchHeartBeatManager.g();
        }
        this.mPerformanceStatics.onGamePaused();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeResume() {
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine != null) {
            tritonEngine.start();
        }
        if (!this.mFirstFrameDone && this.mPauseTime > 0) {
            this.mBackgroundTime += System.currentTimeMillis() - this.mPauseTime;
        }
        GamePage gamePage = this.mGamePage;
        if (gamePage != null) {
            gamePage.onResume(this.mMiniAppInfo);
        }
        com.tencent.qqmini.minigame.yungame.b bVar = this.mYunGamePage;
        if (bVar != null) {
            bVar.doOnResume();
        }
        this.mPerformanceStatics.onGameResumed();
        long currentTimeMillis = System.currentTimeMillis();
        this.mOnShowTime = currentTimeMillis;
        this.onResumeTime = currentTimeMillis;
        this.mIsForeground.set(true);
        if (this.startTime == 0) {
            this.startTime = this.onResumeTime;
        }
        if (this.mNeedLaunchGameOnResume) {
            QMLog.i(TAG, "need launch game onResume");
            launchGame();
        }
        GameTouchHeartBeatManager gameTouchHeartBeatManager = this.mTouchHeartBeatManager;
        if (gameTouchHeartBeatManager != null) {
            gameTouchHeartBeatManager.e(this.mMiniAppInfo);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeStart() {
        GameJsPluginEngine gameJsPluginEngine = this.mJsPluginEngine;
        if (gameJsPluginEngine != null) {
            gameJsPluginEngine.onActStart();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime, com.tencent.qqmini.sdk.launcher.core.IRuntime
    public void onRuntimeStop() {
        GameJsPluginEngine gameJsPluginEngine = this.mJsPluginEngine;
        if (gameJsPluginEngine != null) {
            gameJsPluginEngine.onActStop();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void onUpdateMiniAppInfo(MiniAppInfo miniAppInfo) {
        this.mMiniAppInfo = miniAppInfo;
        super.onUpdateMiniAppInfo(miniAppInfo);
        GameInfoManager gameInfoManager = this.mGameInfoManager;
        if (gameInfoManager != null) {
            gameInfoManager.setLaunchOptions();
        }
        com.tencent.qqmini.minigame.floatview.b bVar = this.mFloatViewFactory;
        if (bVar != null) {
            bVar.l(miniAppInfo);
        }
    }

    public void pauseEngineOnly() {
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine != null && tritonEngine.getState() != EngineState.DESTROYED) {
            this.mTritonEngine.stop();
        }
        GameTouchHeartBeatManager gameTouchHeartBeatManager = this.mTouchHeartBeatManager;
        if (gameTouchHeartBeatManager != null) {
            gameTouchHeartBeatManager.g();
        }
    }

    public void resumeEngineOnly() {
        TritonEngine tritonEngine = this.mTritonEngine;
        if (tritonEngine != null && tritonEngine.getState() != EngineState.DESTROYED) {
            this.mTritonEngine.start();
        }
        GameTouchHeartBeatManager gameTouchHeartBeatManager = this.mTouchHeartBeatManager;
        if (gameTouchHeartBeatManager != null) {
            gameTouchHeartBeatManager.e(this.mMiniAppInfo);
        }
    }

    public void setEnginePackage(MiniEnginePackage miniEnginePackage) {
        this.mTritonEnginePackage = miniEnginePackage;
    }

    public void setGameInfoManager(GameInfoManager gameInfoManager) {
        this.mGameInfoManager = gameInfoManager;
    }

    public void setJsPluginEngine(GameJsPluginEngine gameJsPluginEngine) {
        GameJsPluginEngine gameJsPluginEngine2 = this.mJsPluginEngine;
        if (gameJsPluginEngine2 != null && gameJsPluginEngine2 != gameJsPluginEngine) {
            QMLog.i(TAG, "[setJsPluginEngine] destroy last jsPluginEngine!");
            this.mJsPluginEngine.onDestroy();
        }
        this.mJsPluginEngine = gameJsPluginEngine;
        gameJsPluginEngine.setAuthChecker(this.mColorSignAuthChecker);
        this.mColorSignAuthChecker.c(getJsPluginEngine());
    }

    public void setPackageDownloadFlag(boolean z16) {
        this.mPkgDownloadFlag = z16;
    }

    public void setStartMode(int i3) {
        this.mStartMode = i3;
    }

    public void showNotifyBubble() {
        boolean z16;
        if (this.mActivity != null && this.mMiniAppInfo != null && this.mRootView != null) {
            GamePage gamePage = this.mGamePage;
            if (gamePage != null) {
                z16 = !"portrait".equals(gamePage.getPageOrientation());
            } else {
                z16 = false;
            }
            ImmersiveUtils.getNotchHeight(this.mContext, this.mActivity);
            MiniGameNotifyBubbleControl miniGameNotifyBubbleControl = this.mNotifyBubbleControl;
            if (miniGameNotifyBubbleControl != null) {
                miniGameNotifyBubbleControl.p(this.mActivity, this.mMiniAppInfo, this.mRootView, z16);
            }
        }
    }

    protected void showShareScreenshotProgress() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.GameRuntime.10
            @Override // java.lang.Runnable
            public void run() {
                if (GameRuntime.this.mActivity != null) {
                    GameRuntime.this.mShareScreenshotProgressDialog = new MiniProgressDialog(GameRuntime.this.mActivity);
                    GameRuntime.this.mShareScreenshotProgressDialog.show();
                }
            }
        });
    }

    public void startGame() {
        MiniAppInfo miniAppInfo;
        QMLog.i(TAG, "startGame");
        if (TritonEngineUtil.a()) {
            QMLog.e(TAG, "startLoadGame on chrome inspect mode");
            launchGameWithChromeInspect();
            return;
        }
        DebugInfo debugInfo = this.mMiniAppInfo.debugInfo;
        if (debugInfo != null && debugInfo.valid() && (miniAppInfo = this.mMiniAppInfo) != null && miniAppInfo.launchParam.scene == 1011) {
            QMLog.e(TAG, "startLoadGame on ide debug mode");
            launchGameWithIDEDebug();
        } else {
            QMLog.e(TAG, "startGame on real mode");
            launchGame();
        }
    }

    public void updateViewIfAdFinished() {
        GamePage gamePage;
        if (getLoadingAdStatus() == 3 && !isRewardedVideoAdShowing() && (gamePage = this.mGamePage) != null) {
            gamePage.adjustViewForOrientation();
        }
    }

    @Override // com.tencent.qqmini.sdk.core.Preloadable
    public void init(TritonPlatform tritonPlatform) {
        QMLog.i(" floatBox.GameRuntime", "[init]");
        this.mTritonPlatform = tritonPlatform;
        initGamePage();
        initTouchHeartBeat();
        addFloatView();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class b implements GameLaunchCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.triton.engine.GameLaunchCallback
        public void onFirstFrame(@NonNull FirstFrameStatistic firstFrameStatistic) {
            GameRuntime.this.onFirstFrame(null);
        }

        @Override // com.tencent.mobileqq.triton.engine.GameLaunchCallback
        public void onV8OOM() {
        }

        @Override // com.tencent.mobileqq.triton.engine.GameLaunchCallback
        public void onGameLaunched(@androidx.annotation.Nullable TritonEngine tritonEngine, @NonNull GameLaunchStatistic gameLaunchStatistic) {
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void onRuntimeCreate() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime
    public void captureImage(ICaptureImageCallback iCaptureImageCallback) {
    }
}
