package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.AttaReporter;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.ui.InternalMiniActivity;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import com.tencent.qqmini.sdk.utils.ScreenShotUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppStateManager extends AppRuntimeEventCenter.RuntimeStateObserver {
    private static final int LAUNCH_STATUS_CLICK = 0;
    private static final int LAUNCH_STATUS_FIRST_FRAME = 2;
    private static final int LAUNCH_STATUS_LOAD = 1;
    private static final String TAG = "minisdk-start_RuntimeState";
    private static final int WHITE_SCREEN_ERROR_TYPE_DETECT_WHITESCREEN = 2;
    private static final int WHITE_SCREEN_ERROR_TYPE_NO_DOMREADY = 1;
    private static volatile boolean mX5GuideShowed = false;
    private static HashMap<String, Integer> restartCount = new HashMap<>();
    public boolean hasFirstDomReadied;
    public boolean hasPreloadCompleted;
    public boolean isFlutter;
    public boolean isFromPrelaunch;
    public boolean isFromPreload;
    private long mBeginOnCreate;
    private final BaseRuntimeLoader mRuntimeLoader;
    private WhiteScreenCheckRunnable mWhiteScreenCheckRunnable;
    public int launchStatus = 0;
    private int mLaunchResult = 0;
    private long onResumeTime = 0;
    private boolean hasShowCleanInfo = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class WhiteScreenCheckRunnable implements Runnable {

        /* compiled from: P */
        /* loaded from: classes23.dex */
        class a implements ICaptureImageCallback {
            a() {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback
            public void onResult(Bitmap bitmap) {
                if (bitmap == null) {
                    QMLog.i(AppStateManager.TAG, "--- getScreenshot failed, " + AppStateManager.this.mRuntimeLoader.mMiniAppInfo.appId);
                    return;
                }
                AppStateManager appStateManager = AppStateManager.this;
                appStateManager.checkWhiteScreen(bitmap, appStateManager.mRuntimeLoader.mMiniAppInfo);
                AppStateManager.this.mRuntimeLoader.getRuntime().setScreenShotState(false);
            }
        }

        WhiteScreenCheckRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AppStateManager.this.mRuntimeLoader.getRuntime().getAttachActivity() != null) {
                    AppStateManager.this.mRuntimeLoader.getRuntime().captureImage(new a());
                }
            } catch (Exception e16) {
                QMLog.e(AppStateManager.TAG, "---getScreenshot failed", e16);
            }
        }
    }

    public AppStateManager(BaseRuntimeLoader baseRuntimeLoader) {
        this.mRuntimeLoader = baseRuntimeLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canShowCleanInfo(long j3, int i3, BaseRuntime baseRuntime) {
        if (this.hasShowCleanInfo) {
            QMLog.i(TAG, "has shown cleanInfo, not showCleanInfo 2");
            return true;
        }
        if (mX5GuideShowed) {
            QMLog.i(TAG, "mX5GuideShowed not showCleanInfo 2");
            return true;
        }
        if (i3 == 1 && this.hasFirstDomReadied) {
            QMLog.i(TAG, "hasFirstDomReadied not showCleanInfo 2");
            return true;
        }
        if (!baseRuntime.getIsForeground()) {
            QMLog.e(TAG, "showCleanInfo failed, not is forground");
            return true;
        }
        long j16 = this.onResumeTime;
        if (j16 > 0 && j3 - j16 < 5000) {
            QMLog.e(TAG, "onResume time < 5000 not show clean info, onResumeTime: " + this.onResumeTime + "  curTime:" + j3);
            return true;
        }
        return false;
    }

    private boolean checkNeedShowCleanInfo(int i3, BaseRuntime baseRuntime, MiniAppInfo miniAppInfo) {
        if (this.hasShowCleanInfo) {
            QMLog.i(TAG, "has shown cleanInfo, not showCleanInfo 1");
            return true;
        }
        if (mX5GuideShowed) {
            QMLog.i(TAG, "has mX5GuideShowed not showCleanInfo 1");
            return true;
        }
        if (i3 == 1 && this.hasFirstDomReadied) {
            QMLog.i(TAG, "hasFirstDomReadied not showCleanInfo 1");
            return true;
        }
        if (baseRuntime != null && baseRuntime.getAttachActivity() != null) {
            if (!baseRuntime.getIsForeground()) {
                QMLog.e(TAG, "showCleanInfo failed, not is forground");
                return true;
            }
            if (!checkRestartCountValid(miniAppInfo.appId) || !miniAppInfo.isEngineTypeMiniApp()) {
                return true;
            }
            return false;
        }
        QMLog.e(TAG, "showCleanInfo failed," + baseRuntime);
        return true;
    }

    private boolean checkRestartCountValid(String str) {
        int config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_SHOW_CLEAN_MAX_COUNT, 3);
        int restartCount2 = getRestartCount(str);
        if (restartCount2 >= config) {
            QMLog.i(TAG, "Appid:" + str + "  has restart count:" + restartCount2 + "  reach the max count");
            return false;
        }
        QMLog.i(TAG, "Appid:" + str + "  has restart count:" + restartCount2);
        setRestartCount(str, restartCount2 + 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkWhiteScreen(Bitmap bitmap, MiniAppInfo miniAppInfo) {
        try {
            if (ScreenShotUtil.checkIfWhiteScreen(bitmap, this.mRuntimeLoader.getRuntime())) {
                String bitmapTobase64 = ScreenShotUtil.bitmapTobase64(bitmap, WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_WHITE_SCREEN_SHOT_MAX_WIDTH, 500), WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_WHITE_SCREEN_SHOT_MAX_HEIGHT, 500));
                if (bitmapTobase64 != null) {
                    if (bitmapTobase64.length() < 5120) {
                        QMLog.i(TAG, "--- report white_screen appid:" + miniAppInfo.appId + " img:" + bitmapTobase64);
                    } else {
                        QMLog.i(TAG, "--- report white_screen appid:" + miniAppInfo.appId + " base64 length:" + bitmapTobase64.length());
                    }
                    MiniReportManager.reportEventType(miniAppInfo, 150, MiniReportManager.getAppType(miniAppInfo), "dom_ready", String.valueOf(bitmapTobase64.length()), "", "");
                }
                if (WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_SHOW_CLEAN_DETECT_WHITESCREEN, 0) > 0) {
                    showCleanInfo(2);
                }
            }
            if (bitmap != null) {
                bitmap.recycle();
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "---check white screen failed", th5);
        }
    }

    private void detectWhiteScreen(MiniAppInfo miniAppInfo) {
        if (miniAppInfo.isEngineTypeMiniGame()) {
            QMLog.i(TAG, "not detect mini game.");
        } else if (WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_ENABLE_WHITE_SCREEN_CHECK_AFTER_DOMREADY, 1) > 0) {
            this.mWhiteScreenCheckRunnable = new WhiteScreenCheckRunnable();
            ThreadManager.getSubThreadHandler().postDelayed(this.mWhiteScreenCheckRunnable, 10000L);
        }
    }

    private String getCurPagePath(BaseRuntime baseRuntime) {
        if (baseRuntime != null && baseRuntime.getPage() != null) {
            return PageAction.obtain(baseRuntime).getPageUrl();
        }
        return null;
    }

    private int getRestartCount(String str) {
        if (restartCount.containsKey(str)) {
            return restartCount.get(str).intValue();
        }
        return 0;
    }

    private void handleExit(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        if (miniAppStateMessage == null) {
            QMLog.w(TAG, "handleExit msg is null");
            return;
        }
        BaseRuntimeLoader baseRuntimeLoader = miniAppStateMessage.appRuntimeLoader;
        if (baseRuntimeLoader == null) {
            QMLog.w(TAG, "handleExit mRuntimeLoader is null");
            return;
        }
        BaseRuntime runtime = baseRuntimeLoader.getRuntime();
        if (runtime == null) {
            QMLog.w(TAG, "handleExit baseRuntime is null");
            return;
        }
        if (runtime.isMiniGame()) {
            return;
        }
        Activity attachActivity = runtime.getAttachActivity();
        Object obj = miniAppStateMessage.obj;
        if (obj instanceof MiniAppConst.RuntimeCloseType) {
            if (obj == MiniAppConst.RuntimeCloseType.CLOSE_BUTTON) {
                if (!(attachActivity instanceof InternalMiniActivity)) {
                    com.tencent.qqmini.sdk.utils.a.a(attachActivity, runtime, false, false, true);
                } else {
                    com.tencent.qqmini.sdk.utils.a.a(attachActivity, runtime, true, false, false);
                }
                AppStateEvent.obtain(60).notifyRuntime(runtime);
                return;
            }
            com.tencent.qqmini.sdk.utils.a.a(attachActivity, runtime, true, false, false);
        }
    }

    private void notifyEvent(MiniAppInfo miniAppInfo, String str, long j3) {
        LaunchParam launchParam;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null) {
            String str2 = miniAppInfo.appId;
            int i3 = launchParam.scene;
            String str3 = miniAppInfo.via;
            Bundle bundle = new Bundle();
            bundle.putString("key_appid", str2);
            bundle.putInt("key_scene", i3);
            bundle.putString("key_via", str3);
            bundle.putString("key_event", str);
            bundle.putLong("key_timestamp", j3);
            AppBrandCmdProxy.g().sendCmd("cmd_notify_event_info", bundle, null);
        }
    }

    private void onGameLaunch(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        int i3;
        Object obj = miniAppStateMessage.obj;
        Pair pair = (Pair) obj;
        int i16 = 0;
        if (obj != null) {
            i3 = ((Integer) pair.first).intValue();
        } else {
            i3 = 0;
        }
        if (i3 < 0) {
            i16 = i3;
        }
        this.mLaunchResult = i16;
    }

    private void onJsError(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        BaseRuntime runtime;
        try {
            if (!mX5GuideShowed && !this.hasFirstDomReadied && (runtime = this.mRuntimeLoader.getRuntime()) != null && runtime.getAttachActivity() != null) {
                boolean z16 = true;
                if (WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_ENABLE_JSERROR_TIP, 1) != 1) {
                    z16 = false;
                }
                if (!z16) {
                    return;
                }
                QMLog.e(TAG, "js error, try start X5 guide.");
                tryShowDownloadX5OnJsError();
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "onJsError exception.", th5);
        }
    }

    private void onMsgBackKey() {
        int i3;
        MiniAppInfo miniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
        String curPagePath = getCurPagePath(this.mRuntimeLoader.getRuntime());
        if (miniAppInfo != null) {
            i3 = miniAppInfo.getReportType();
        } else {
            i3 = 0;
        }
        if (i3 == 1) {
            if (miniAppInfo != null) {
                int i16 = this.launchStatus;
                if (i16 == 0) {
                    SDKMiniProgramLpReportDC04239.reportPageView(miniAppInfo, "1", null, "load_fail", "loading_page_back_press");
                } else if (i16 == 1) {
                    SDKMiniProgramLpReportDC04239.reportPageView(miniAppInfo, "1", null, "show_fail", "loading_page_back_press");
                }
            } else {
                QMLog.e(TAG, "doOnBackPressed gameConfig=null");
            }
        }
        if (this.hasFirstDomReadied) {
            MiniAppReportManager2.reportPageView("2back_key", "inner_page", curPagePath, miniAppInfo);
        } else {
            MiniAppReportManager2.reportPageView("2back_key", "loading_page", curPagePath, miniAppInfo);
        }
    }

    private void onMsgCloseInner() {
        MiniAppInfo miniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
        MiniAppReportManager2.reportPageView("2close", "inner_page", getCurPagePath(this.mRuntimeLoader.getRuntime()), miniAppInfo);
        String appType = MiniReportManager.getAppType(miniAppInfo);
        if (this.mRuntimeLoader.isLoadSucceed()) {
            MiniReportManager.reportEventType(miniAppInfo, 1025, appType);
        } else {
            MiniReportManager.reportEventType(miniAppInfo, 1026, appType);
        }
        AttaReporter.g("129", miniAppInfo, 0L);
    }

    private void onMsgDomReady() {
        int i3;
        String str;
        String str2;
        String str3;
        MiniAppInfo miniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
        BaseRuntime runtime = this.mRuntimeLoader.getRuntime();
        String curPagePath = getCurPagePath(runtime);
        if (miniAppInfo != null) {
            i3 = miniAppInfo.getReportType();
        } else {
            i3 = 0;
        }
        if (!this.hasFirstDomReadied) {
            this.hasFirstDomReadied = true;
            if (runtime != null && miniAppInfo != null) {
                QMLog.i(TAG, "--- report show firstframe appid:" + miniAppInfo.appId);
                MiniAppReportManager2.reportPageView("2launch", "first_frame", curPagePath, miniAppInfo);
                if (TextUtils.isEmpty(curPagePath)) {
                    str = miniAppInfo.launchParam.entryPath;
                } else {
                    str = curPagePath;
                }
                if (this.isFromPrelaunch) {
                    str2 = "preLaunch";
                } else {
                    str2 = null;
                }
                MiniReportManager.reportEventType(miniAppInfo, 21, str, str2, null, 0);
                long currentTimeMillis = System.currentTimeMillis() - this.mBeginOnCreate;
                int i16 = this.mLaunchResult;
                if (i3 == 0) {
                    str3 = "0";
                } else {
                    str3 = "1";
                }
                MiniReportManager.reportEventType(miniAppInfo, 1043, null, null, null, i16, str3, currentTimeMillis, null);
                Bundle bundle = new Bundle();
                bundle.putString(IPCConst.KEY_BUNDLE_RUNTIME_LIFECYCLE, "first_frame");
                bundle.putParcelable(IPCConst.KEY_BUNDLE_APPINFO, miniAppInfo);
                AppBrandCmdProxy.g().sendCmd(IPCConst.CMD_NOTIFY_RUNTIME_LIFECYCLE, bundle, null);
            }
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            if (this.isFlutter && miniAppProxy.isDebugVersion()) {
                MiniToast.makeText(MiniAppEnv.g().getContext(), "\u8fdb\u5165native\u5c0f\u7a0b\u5e8f,\u4ec5debug\u53ef\u89c1", 0).show();
            }
            miniAppProxy.notifyMiniAppInfo(1, miniAppInfo);
            detectWhiteScreen(miniAppInfo);
        }
        if (miniAppInfo != null) {
            MiniReportManager.reportEventType(miniAppInfo, 611, curPagePath, null, null, 0, MiniAppStartState.getBaseLibDownloadDesc(miniAppInfo.appId), MiniAppStartState.getApkgDownloadDesc(miniAppInfo.appId), MiniAppStartState.getBaselibLoadDesc(miniAppInfo.appId), MiniAppStartState.getPageSwitchDesc(miniAppInfo.appId));
        }
    }

    private void onMsgFrameworkCompleted(MiniAppInfo miniAppInfo) {
        if (this.isFromPreload || this.isFromPrelaunch) {
            this.hasPreloadCompleted = true;
        }
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
            MiniAppStartState.setBaseLibLoad(miniAppInfo.appId, false);
            QMLog.d(TAG, "framework load finished :" + miniAppInfo.appId);
        }
        QMLog.d(TAG, "framework load finished");
    }

    private void onMsgGameDestroy() {
        MiniAppInfo miniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
        if (miniAppInfo != null) {
            int i3 = this.launchStatus;
            if (i3 == 0 || i3 == 1) {
                SDKMiniProgramLpReportDC04239.reportPageView(miniAppInfo, "1", null, "load_fail", "loading_page_kill");
                MiniAppReportManager2.reportPageView("2launch_fail", "loading_page_kill", null, miniAppInfo);
                return;
            }
            return;
        }
        QMLog.e(TAG, "doOnDestroy kill self gameConfig=null");
    }

    private void onMsgPause() {
        int i3;
        MiniAppInfo miniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
        String curPagePath = getCurPagePath(this.mRuntimeLoader.getRuntime());
        if (miniAppInfo != null) {
            i3 = miniAppInfo.getReportType();
        } else {
            i3 = 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.onResumeTime;
        if (j3 < 0) {
            j3 = 0;
        }
        MiniAppReportManager2.reportPageView("2hide", String.valueOf(j3), curPagePath, miniAppInfo);
        notifyEvent(miniAppInfo, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, currentTimeMillis);
        MiniReportManager.reportEventType(miniAppInfo, 20, "" + i3, j3);
        if (this.mWhiteScreenCheckRunnable != null) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.mWhiteScreenCheckRunnable);
        }
        if (miniAppInfo != null) {
            QMLog.i(TAG, "--- report bring_to_bg appid:" + miniAppInfo.appId);
        }
    }

    private void onMsgResume() {
        String str;
        MiniAppInfo miniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
        BaseRuntime runtime = this.mRuntimeLoader.getRuntime();
        if (miniAppInfo == null) {
            return;
        }
        QMLog.i(TAG, "--- report bring_to_front appid:" + miniAppInfo.appId);
        long currentTimeMillis = System.currentTimeMillis();
        this.onResumeTime = currentTimeMillis;
        String curPagePath = getCurPagePath(runtime);
        MiniAppReportManager2.reportPageView("2show", "bring_to_front", curPagePath, miniAppInfo);
        notifyEvent(miniAppInfo, "onResume", currentTimeMillis);
        if (TextUtils.isEmpty(curPagePath)) {
            str = miniAppInfo.launchParam.entryPath;
        } else {
            str = curPagePath;
        }
        MiniReportManager.reportEventType(miniAppInfo, 1, str, null, null, 0);
        if (runtime != null && this.hasFirstDomReadied) {
            QMLog.i(TAG, "--- report click_resume appid:" + miniAppInfo.appId);
            MiniAppReportManager2.reportPageView("2launch", "click_resume", curPagePath, miniAppInfo);
            MiniReportManager.reportEventType(miniAppInfo, 21, str, null, null, 0);
        }
    }

    private void onMsgRouteDone() {
        MiniReportManager.reportEventType(this.mRuntimeLoader.getMiniAppInfo(), 121, getCurPagePath(this.mRuntimeLoader.getRuntime()), null, null, 0);
        tryShowUpdateX5OnMsgRouteDone();
        int config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_ENABLE_SHOW_CLEAN_ROUTEDONE, 1);
        int config2 = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_SHOW_CLEAN_DELAY_TIME, 5000);
        if (config > 0) {
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppStateManager.1
                @Override // java.lang.Runnable
                public void run() {
                    AppStateManager.this.showCleanInfo(1);
                }
            }, config2);
        }
    }

    private void onMsgStart() {
        int i3;
        String str;
        String str2;
        MiniAppInfo miniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
        if (miniAppInfo != null) {
            i3 = miniAppInfo.getReportType();
        } else {
            i3 = 0;
        }
        this.mBeginOnCreate = System.currentTimeMillis();
        if (miniAppInfo != null) {
            str = miniAppInfo.appId;
        } else {
            str = "";
        }
        QMLog.i(TAG, "[" + str + "] \u542f\u52a8(MiniActivity onCreate)");
        if (this.isFromPrelaunch) {
            str2 = "preLaunch";
        } else {
            str2 = null;
        }
        MiniReportManager.reportEventType(miniAppInfo, 24, null, str2, null, 0, String.valueOf(i3), 0L, null, "", "", "", "");
        this.launchStatus = 0;
    }

    private void setRestartCount(String str, int i3) {
        restartCount.put(str, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCleanInfo(int i3) {
        Activity attachActivity;
        BaseRuntime runtime = this.mRuntimeLoader.getRuntime();
        MiniAppInfo miniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
        if (!checkNeedShowCleanInfo(i3, runtime, miniAppInfo) && (attachActivity = runtime.getAttachActivity()) != null) {
            attachActivity.runOnUiThread(new AnonymousClass2(i3, runtime, attachActivity, miniAppInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDownloadX5Dialog() {
        BaseRuntime runtime;
        if (!mX5GuideShowed && (runtime = this.mRuntimeLoader.getRuntime()) != null && runtime.getAttachActivity() != null) {
            QMLog.e(TAG, "showDownloadX5Dialog, start X5 guide.");
            try {
                mX5GuideShowed = true;
                ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).startDownloadX5(runtime);
            } catch (Throwable th5) {
                QMLog.e(TAG, "start X5 guide exception.", th5);
            }
        }
    }

    private void tryShowDownloadX5OnJsError() {
        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppStateManager.3
            @Override // java.lang.Runnable
            public void run() {
                AppStateManager appStateManager = AppStateManager.this;
                if (!appStateManager.hasFirstDomReadied) {
                    appStateManager.showDownloadX5Dialog();
                }
            }
        }, 2000L);
    }

    private void tryShowUpdateX5OnMsgRouteDone() {
        boolean z16 = false;
        if (WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_ENABLE_SHOW_X5_DIALOG_ONROUTEDONE, 0) > 0) {
            z16 = true;
        }
        int config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_SHOW_X5_DIALOG_DELAY_TIME, 2000);
        if (!z16) {
            return;
        }
        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppStateManager.4
            @Override // java.lang.Runnable
            public void run() {
                QMLog.i(AppStateManager.TAG, "tryShowUpdateX5OnMsgRouteDone");
                AppStateManager.this.showDownloadX5Dialog();
            }
        }, config);
    }

    @Override // com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver
    public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
        Object obj;
        if (miniAppStateMessage == null && miniAppStateMessage.appRuntimeLoader == this.mRuntimeLoader) {
            return;
        }
        QMLog.i(TAG, "onStateChange message:" + miniAppStateMessage.what);
        BaseRuntime runtime = this.mRuntimeLoader.getRuntime();
        MiniAppInfo miniAppInfo = this.mRuntimeLoader.getMiniAppInfo();
        String curPagePath = getCurPagePath(runtime);
        int i3 = miniAppStateMessage.what;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 20) {
                    if (i3 != 21) {
                        if (i3 != 24) {
                            if (i3 != 25) {
                                if (i3 != 71) {
                                    if (i3 != 72) {
                                        switch (i3) {
                                            case 10:
                                                onMsgRouteDone();
                                                return;
                                            case 11:
                                                this.launchStatus = 2;
                                                onMsgDomReady();
                                                return;
                                            case 12:
                                                if (miniAppInfo != null) {
                                                    QMLog.i(TAG, "--- report launch fail appid:" + miniAppInfo.appId);
                                                    MiniAppReportManager2.reportPageView("2launch_fail", "flutter_sdk_fail", curPagePath, miniAppInfo);
                                                    return;
                                                }
                                                return;
                                            default:
                                                switch (i3) {
                                                    case 60:
                                                        Object obj2 = miniAppStateMessage.obj;
                                                        if (obj2 instanceof MiniAppConst.RuntimeCloseType) {
                                                            if (obj2 == MiniAppConst.RuntimeCloseType.CLOSE_BUTTON) {
                                                                onMsgCloseInner();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        onMsgCloseInner();
                                                        return;
                                                    case 61:
                                                        MiniAppReportManager2.reportPageView("2close", "loading_page", null, miniAppInfo);
                                                        AttaReporter.g("129", miniAppInfo, 0L);
                                                        return;
                                                    case 62:
                                                        MiniAppReportManager2.reportPageView("2unload", null, curPagePath, miniAppInfo);
                                                        MiniReportManager.reportEventType(miniAppInfo, 22, MiniReportManager.getAppType(miniAppInfo));
                                                        return;
                                                    case 63:
                                                        onGameLaunch(miniAppStateMessage);
                                                        return;
                                                    case 64:
                                                        onMsgGameDestroy();
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                    }
                                    handleExit(miniAppStateMessage);
                                    return;
                                }
                                onJsError(miniAppStateMessage);
                                return;
                            }
                            onMsgBackKey();
                            return;
                        }
                        onMsgPause();
                        return;
                    }
                    onMsgResume();
                    return;
                }
                onMsgStart();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("--- report load appid:");
                if (miniAppInfo != null) {
                    obj = miniAppInfo.appId;
                } else {
                    obj = 0;
                }
                sb5.append(obj);
                QMLog.i(TAG, sb5.toString());
                MiniAppReportManager2.reportPageView("2load", null, null, miniAppInfo);
                return;
            }
            this.launchStatus = 1;
            return;
        }
        onMsgFrameworkCompleted(miniAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.sdk.runtime.AppStateManager$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ BaseRuntime val$baseRuntime;
        final /* synthetic */ MiniAppInfo val$miniAppInfo;
        final /* synthetic */ int val$type;

        AnonymousClass2(int i3, BaseRuntime baseRuntime, Activity activity, MiniAppInfo miniAppInfo) {
            this.val$type = i3;
            this.val$baseRuntime = baseRuntime;
            this.val$activity = activity;
            this.val$miniAppInfo = miniAppInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, Integer> tbsVersion;
            String str;
            if (AppStateManager.this.canShowCleanInfo(System.currentTimeMillis(), this.val$type, this.val$baseRuntime) || (tbsVersion = AppStateManager.this.mRuntimeLoader.getTbsVersion(this.val$activity)) == null) {
                return;
            }
            int intValue = ((Integer) tbsVersion.first).intValue();
            int intValue2 = ((Integer) tbsVersion.second).intValue();
            if (WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_SHOW_CLEAN_CHECK_X5, 1) > 0 && intValue == 0 && intValue2 == 0) {
                QMLog.e(AppStateManager.TAG, "whitescreen without x5, start x5 guide");
                try {
                    boolean unused = AppStateManager.mX5GuideShowed = true;
                    ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).startDownloadX5(AppStateManager.this.mRuntimeLoader.getRuntime());
                    return;
                } catch (Throwable th5) {
                    QMLog.e(AppStateManager.TAG, "start X5 guide exception.", th5);
                    return;
                }
            }
            int i3 = this.val$type;
            if (i3 == 1) {
                str = "\u5c0f\u7a0b\u5e8f\u542f\u52a8\u78b0\u5230\u4e86\u5f02\u5e38.";
            } else if (i3 == 2) {
                str = "\u5c0f\u7a0b\u5e8f\u542f\u52a8\u53ef\u80fd\u78b0\u5230\u4e86\u95ee\u9898.";
            } else {
                str = "";
            }
            String str2 = (str + " \n   tbsVersion=" + intValue + " \n   tmpDirTbsVersion=" + intValue2) + "\n\u662f\u5426\u9700\u8981\u6e05\u7406\u5f53\u524d\u5c0f\u7a0b\u5e8f\u7f13\u5b58\uff0c\u5e76\u91cd\u65b0\u542f\u52a8\u5c0f\u7a0b\u5e8f\uff1f";
            QMLog.e(AppStateManager.TAG, "show Dialig :" + str2);
            DialogUtil.createCustomDialog(this.val$activity, 230, "\u5c0f\u7a0b\u5e8f\u542f\u52a8", str2, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.runtime.AppStateManager.2.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i16) {
                    try {
                        QMLog.i(AppStateManager.TAG, "restart " + AppStateManager.this.mRuntimeLoader.getRuntime().getMiniAppInfo());
                        MiniCacheFreeManager.freeCache(LoginManager.getInstance().getAccount(), AnonymousClass2.this.val$miniAppInfo, false, new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppStateManager.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Activity attachActivity = AppStateManager.this.mRuntimeLoader.getRuntime().getAttachActivity();
                                MiniAppInfo miniAppInfo = AnonymousClass2.this.val$miniAppInfo;
                                miniAppInfo.launchParam.forceReload = 3;
                                MiniAppLauncher.launchMiniApp(attachActivity, miniAppInfo, (Bundle) null, (ResultReceiver) null);
                            }
                        });
                    } catch (Exception e16) {
                        QMLog.e(AppStateManager.TAG, "clear cache and restart failed ", e16);
                    }
                }
            }, new a()).show();
            AppStateManager.this.hasShowCleanInfo = true;
        }

        /* compiled from: P */
        /* renamed from: com.tencent.qqmini.sdk.runtime.AppStateManager$2$a */
        /* loaded from: classes23.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        }
    }
}
