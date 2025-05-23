package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.manager.ObserverManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.report.MiniAppPrelaunchRecorder;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniGdtReporter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.utils.MiniAppUtils;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.qqmini.sdk.widget.media.MiniAppVideoConstants;
import java.lang.ref.WeakReference;

/* loaded from: classes23.dex */
public abstract class BaseUIProxy implements IUIProxy {
    private static final int MAX_LENGTH = 10000;
    protected static final String TAG = "minisdk-start_UIProxy";
    protected long loadCompleteTimeForLoadingAdReport;
    protected Activity mActivity;
    protected BaseRuntimeLoader mCurrRuntimeLoader;
    private boolean mIsDestroyed;
    protected PageGestureProxy mPageGestureProxy;
    protected ViewGroup mRootLayout;
    protected Handler mMainHandler = new Handler(Looper.getMainLooper());
    protected boolean hasCompletedLoading = false;
    protected boolean hasHideLoading = false;
    protected boolean needRealTimeLoading = false;
    protected String loadingAdJson = "";
    protected long cachedAid = 0;
    protected long loadStartTimeStamp = 0;
    protected long adLimitShowTime = 0;
    private MiniLoadingAdManager.OnChooseAdEndListener chooseAdEndListener = null;
    protected int mLoadingAdStatus = 0;
    private final Binder mClientBinder = new Binder();

    private void destroyLastRuntimeLoader(BaseRuntimeLoader baseRuntimeLoader) {
        if (baseRuntimeLoader.isRunning()) {
            QMLog.i(TAG, "pause last runtime loader:" + baseRuntimeLoader);
            baseRuntimeLoader.pause();
        }
        baseRuntimeLoader.onDetachActivity(this.mActivity, false);
        baseRuntimeLoader.removeRuntimeStateObserver(getRuntimeStateObserver());
    }

    private boolean isMiniConsumeBackPress(MiniAppInfo miniAppInfo) {
        QQCustomizedProxy qQCustomizedProxy = (QQCustomizedProxy) ProxyManager.get(QQCustomizedProxy.class);
        if (qQCustomizedProxy == null) {
            return false;
        }
        return qQCustomizedProxy.isMiniAppConsumeBackPress(miniAppInfo);
    }

    private void updateLoadingAdStatusToRuntime() {
        BaseRuntime runtime;
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader != null && (runtime = baseRuntimeLoader.getRuntime()) != null) {
            runtime.onLoadingAdStatusChanged(this.mLoadingAdStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseRuntimeLoader.OnAppRuntimeLoadListener createRuntimeLoaderListener() {
        return new BaseRuntimeLoader.OnAppRuntimeLoadListener() { // from class: com.tencent.qqmini.sdk.runtime.BaseUIProxy.2
            @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.OnAppRuntimeLoadListener
            public void onResult(int i3, String str, BaseRuntimeLoader baseRuntimeLoader) {
                if (i3 == 0 && baseRuntimeLoader != null) {
                    BaseUIProxy baseUIProxy = BaseUIProxy.this;
                    if (baseRuntimeLoader == baseUIProxy.mCurrRuntimeLoader) {
                        baseUIProxy.onRuntimeReady();
                        return;
                    }
                    return;
                }
                BaseUIProxy.this.onRuntimeFail(i3, str);
            }
        };
    }

    public MiniAppInfo getMiniAppInfo() {
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader != null) {
            return baseRuntimeLoader.getMiniAppInfo();
        }
        return null;
    }

    public BaseRuntime getRuntime() {
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader != null) {
            return baseRuntimeLoader.getRuntime();
        }
        return null;
    }

    protected abstract AppRuntimeEventCenter.RuntimeStateObserver getRuntimeStateObserver();

    protected abstract void hideLoading();

    protected abstract boolean isAbleToShowAd();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAbleToShowLoadingAd() {
        if (getMiniAppInfo() != null && getMiniAppInfo().enableLoadingAd && MiniLoadingAdManager.getInstance().checkSelectAdNecessity(getMiniAppInfo(), ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void notifyExit(boolean z16, boolean z17, boolean z18) {
        com.tencent.qqmini.sdk.utils.a.a(this.mActivity, getRuntime(), z16, z17, z18);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onActivityResult(Activity activity, int i3, int i16, Intent intent) {
        QMLog.i(TAG, "onActivityResult requestCode=" + i3 + " resultCode=" + i16);
        ActivityResultManager.g().notifyActivityResultListener(i3, i16, intent);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onAttachActivity(Activity activity, Bundle bundle, ViewGroup viewGroup) {
        QMLog.i(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onAttachActivity");
        Window window = activity.getWindow();
        if (window != null) {
            window.setSoftInputMode(18);
        }
        this.mActivity = activity;
        this.mRootLayout = viewGroup;
        MiniGdtReporter.prepareReport();
        PageGestureProxy pageGestureProxy = (PageGestureProxy) ProxyManager.get(PageGestureProxy.class);
        this.mPageGestureProxy = pageGestureProxy;
        if (pageGestureProxy != null) {
            pageGestureProxy.onActivityCreate(activity);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public boolean onBackPressed(Activity activity) {
        BaseRuntime runtime;
        QMLog.i(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onBackPressed");
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader == null) {
            runtime = null;
        } else {
            runtime = baseRuntimeLoader.getRuntime();
        }
        if (runtime == null) {
            QMLog.w(TAG, "onBackPressed, runtime is null, return false");
            return false;
        }
        if (isMiniConsumeBackPress(getMiniAppInfo())) {
            QMLog.d(TAG, "onBackPressed, isMiniConsumeBackPress:true");
            runtime.onGeneralNativeEvent("onBackPressed", null, -1);
            return true;
        }
        boolean onBackPress = runtime.onBackPress();
        AppStateEvent.obtain(25).notifyRuntime(getRuntime());
        return onBackPress;
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onDetachActivity(Activity activity) {
        QMLog.i(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onDetachActivity");
        if (this.mActivity != activity) {
            QMLog.e(TAG, "onDetachActivity. activity is mismatch. mActivity=" + this.mActivity + " activity=" + activity);
            return;
        }
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader != null) {
            baseRuntimeLoader.onDetachActivity(activity);
            if (this.mCurrRuntimeLoader.getMiniAppInfo() != null) {
                AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
            }
        }
        this.mCurrRuntimeLoader = null;
        PageGestureProxy pageGestureProxy = this.mPageGestureProxy;
        if (pageGestureProxy != null) {
            pageGestureProxy.onActivityDestroy(activity);
        }
        ViewGroup viewGroup = this.mRootLayout;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.mRootLayout = null;
        }
        this.mActivity = null;
        this.chooseAdEndListener = null;
        MiniLoadingAdManager.getInstance().Destroy();
        this.mIsDestroyed = true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onIntentUpdate(Intent intent) {
        QMLog.i(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onIntentUpdate " + intent);
        MiniAppInfo miniAppInfo = (MiniAppInfo) intent.getParcelableExtra(IPCConst.KEY_APPINFO);
        if (miniAppInfo == null) {
            QMLog.e(TAG, "onIntentUpdate MiniAppInfo is Null!");
            return;
        }
        boolean z16 = false;
        if (miniAppInfo.getMaxListSize() > 10000) {
            notifyExit(true, true, false);
            return;
        }
        if (miniAppInfo.canDebug()) {
            miniAppInfo.launchParam.forceReload = 3;
        }
        AppLoaderFactory.g().getAppBrandProxy().onAppStart(miniAppInfo, null);
        if (miniAppInfo.launchParam.skipHotReload && this.mCurrRuntimeLoader != null) {
            z16 = true;
        }
        if (!z16) {
            startMiniAppInfo(miniAppInfo, intent.getExtras());
        }
        QMLog.d(TAG, "launch param skipHotReload: " + miniAppInfo.launchParam.skipHotReload + " forceReload=" + miniAppInfo.launchParam.forceReload);
        MiniGdtReporter.prepareReport();
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniPause() {
        if (this.mCurrRuntimeLoader == null) {
            QMLog.e(TAG, "onMiniPause current runtime loader is null!");
            return;
        }
        QMLog.i(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onMiniPause");
        this.mCurrRuntimeLoader.onMiniPause();
        if (this.mCurrRuntimeLoader.getMiniAppInfo() != null) {
            GameGrowthGuardianManager.executeEnd(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo());
            PageGestureProxy pageGestureProxy = this.mPageGestureProxy;
            if (pageGestureProxy != null) {
                pageGestureProxy.onActivityPause(this.mActivity);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniResume() {
        if (this.mCurrRuntimeLoader == null) {
            QMLog.e(TAG, "onMiniResume current runtime loader is null!");
            return;
        }
        QMLog.i(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onMiniResume");
        this.mCurrRuntimeLoader.onMiniResume();
        AppRuntimeLoaderManager.g().onEnterForeground(this.mCurrRuntimeLoader);
        if (this.mCurrRuntimeLoader.getMiniAppInfo() != null) {
            AppLoaderFactory.g().getAppBrandProxy().onAppForeground(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
            GameGrowthGuardianManager.executeBegin(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo());
            PageGestureProxy pageGestureProxy = this.mPageGestureProxy;
            if (pageGestureProxy != null) {
                pageGestureProxy.onActivityResume(this.mActivity);
                this.mPageGestureProxy.onCreateMiniAppInfo(this.mCurrRuntimeLoader.getMiniAppInfo());
            }
            ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            if (channelProxy != null) {
                channelProxy.syncForceGroundAndRefreshBadge(this.mActivity, this.mCurrRuntimeLoader.getMiniAppInfo().appId, AppLoaderFactory.g().getProcessName());
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStart() {
        if (this.mCurrRuntimeLoader == null) {
            QMLog.e(TAG, "onMiniStart current runtime loader is null!");
            return;
        }
        QMLog.i(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onMiniStart");
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader != null) {
            baseRuntimeLoader.onMiniStart();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStop() {
        Activity activity;
        if (this.mCurrRuntimeLoader == null) {
            QMLog.e(TAG, "onMiniStop current runtime loader is null!");
            return;
        }
        QMLog.i(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onMiniStop");
        this.mCurrRuntimeLoader.onMiniStop();
        AppRuntimeLoaderManager.g().onEnterBackground();
        if (this.mCurrRuntimeLoader.getMiniAppInfo() != null) {
            AppLoaderFactory.g().getAppBrandProxy().onAppBackground(this.mCurrRuntimeLoader.getMiniAppInfo(), null);
        }
        PageGestureProxy pageGestureProxy = this.mPageGestureProxy;
        if (pageGestureProxy != null && (activity = this.mActivity) != null) {
            pageGestureProxy.onActivityStop(activity);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onRefreshMiniBadge(Activity activity, Bundle bundle) {
        BaseRuntime baseRuntime;
        MiniAppInfo miniAppInfo;
        QMLog.i(TAG, "onRefreshMiniBadge");
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        ICapsuleButton iCapsuleButton = null;
        if (baseRuntimeLoader != null) {
            baseRuntime = baseRuntimeLoader.getRuntime();
        } else {
            baseRuntime = null;
        }
        BaseRuntimeLoader baseRuntimeLoader2 = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader2 != null) {
            miniAppInfo = baseRuntimeLoader2.getMiniAppInfo();
        } else {
            miniAppInfo = null;
        }
        if (baseRuntime != null && miniAppInfo != null) {
            if (bundle != null) {
                String string = bundle.getString("key_appid");
                if (QMLog.isColorLevel()) {
                    QMLog.d("TAG", "onRefreshMiniBadge appID : " + string);
                }
                if (miniAppInfo.appId.equals(string)) {
                    int i3 = bundle.getInt(IPCConst.KEY_BADGE_COUNT);
                    if (QMLog.isColorLevel()) {
                        QMLog.e(TAG, "onRefreshMiniBadge badge : " + i3);
                    }
                    IPage page = baseRuntime.getPage();
                    if (page != null) {
                        iCapsuleButton = page.getCapsuleButton();
                    }
                    if (iCapsuleButton != null) {
                        iCapsuleButton.setUnReadCount(i3, false);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        QMLog.e(TAG, "Failed to refreshMiniBadge, runtime or miniappinfo is null");
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onRequestPermissionsResult(Activity activity, int i3, String[] strArr, int[] iArr) {
        QMLog.i(TAG, "onRequestPermissionsResult requestCode=" + i3 + " permissions=" + strArr + "grantResults=" + iArr);
        ActivityResultManager.g().notifyRequestPermissionResultListener(i3, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRuntimeFail(final int i3, final String str) {
        QMLog.e(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onRuntimeFail. Whoops, failed to load the runtime, retCode = " + i3 + ", msg = " + str);
        this.mMainHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.BaseUIProxy.4
            @Override // java.lang.Runnable
            public void run() {
                MiniToast.makeText(MiniAppEnv.g().getContext(), "\u52a0\u8f7d\u5931\u8d25 retCode=" + i3 + " " + str, 0).show();
                BaseUIProxy.this.notifyExit(true, true, false);
            }
        }, 1000L);
    }

    protected void onRuntimeReady() {
        QMLog.i(TAG, this + AppLoaderFactory.LOG_FLAG_LIFECYCLE + "onRuntimeReady. Here we go, start the runtime lifecycle");
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.BaseUIProxy.3
            @Override // java.lang.Runnable
            public void run() {
                BaseRuntimeLoader baseRuntimeLoader = BaseUIProxy.this.mCurrRuntimeLoader;
                if (baseRuntimeLoader != null) {
                    baseRuntimeLoader.startLoadMiniAppContent(baseRuntimeLoader.needReloadPage());
                    BaseUIProxy baseUIProxy = BaseUIProxy.this;
                    baseUIProxy.mCurrRuntimeLoader.onAttachActivity(baseUIProxy.mActivity, null, baseUIProxy.mRootLayout);
                }
                BaseUIProxy.this.hideLoading();
                ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                BaseRuntimeLoader baseRuntimeLoader2 = BaseUIProxy.this.mCurrRuntimeLoader;
                if (baseRuntimeLoader2 != null && channelProxy != null && baseRuntimeLoader2.getMiniAppInfo() != null) {
                    BaseUIProxy baseUIProxy2 = BaseUIProxy.this;
                    channelProxy.syncForceGroundAndRefreshBadge(baseUIProxy2.mActivity, baseUIProxy2.mCurrRuntimeLoader.getMiniAppInfo().appId, AppLoaderFactory.g().getProcessName());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processSelectLoadingAdLogic(final MiniAppInfo miniAppInfo) {
        int i3;
        final String account = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount();
        final WeakReference weakReference = new WeakReference(this.mActivity);
        final long currentTimeMillis = System.currentTimeMillis();
        this.chooseAdEndListener = new MiniLoadingAdManager.OnChooseAdEndListener() { // from class: com.tencent.qqmini.sdk.runtime.BaseUIProxy.5
            @Override // com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnChooseAdEndListener
            public void onChooseAdEnd(String str, long j3, boolean z16) {
                QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd adJson=" + str + " aid=" + j3 + " needExtraDownload:" + z16);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (BaseUIProxy.this.isAbleToShowAd()) {
                    if (z16) {
                        QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd \u9009\u5355\u8fd4\u56de\u4e86\u6ca1\u6709\u9884\u4e0b\u8f7d\u8fc7\u7684\u5e7f\u544a");
                        MiniLoadingAdManager.getInstance().processSelectAdWithUncachedAd(str, account, miniAppInfo.appId, this);
                        MiniAppInfo miniAppInfo2 = miniAppInfo;
                        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), null, "ad", "ad_loading", "request_success_realtime", String.valueOf(currentTimeMillis2));
                        return;
                    }
                    if (str != null && j3 != -1) {
                        QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd \u9009\u5355\u63a5\u53e3\u5b9e\u5355\u6210\u529f");
                        MiniAppInfo miniAppInfo3 = miniAppInfo;
                        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo3, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo3), null, "ad", "ad_loading", "request_success_online", String.valueOf(currentTimeMillis2));
                        BaseUIProxy.this.updateLoadingAdUI(miniAppInfo, str, j3, weakReference);
                        return;
                    }
                    QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd \u9009\u5355\u63a5\u53e3\u7a7a\u5355\u6210\u529f");
                    BaseUIProxy.this.updateLoadingAdStatus(3);
                    MiniAppInfo miniAppInfo4 = miniAppInfo;
                    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo4, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo4), null, "ad", "ad_loading", "request_success_offline", String.valueOf(currentTimeMillis2));
                    return;
                }
                QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd \u9009\u5355\u63a5\u53e3\u8d85\u65f6");
                BaseUIProxy.this.updateLoadingAdStatus(3);
                long j16 = BaseUIProxy.this.loadCompleteTimeForLoadingAdReport - currentTimeMillis;
                MiniAppInfo miniAppInfo5 = miniAppInfo;
                SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo5, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo5), null, "ad", "ad_loading", "request_timeout", String.valueOf(j16), String.valueOf(currentTimeMillis2));
            }

            @Override // com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnChooseAdEndListener
            public void onDownloadAdEnd(String str, long j3) {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (BaseUIProxy.this.isAbleToShowAd()) {
                    if (str != null && j3 != -1) {
                        QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onDownloadAdEnd \u56fe\u7247\u4e0b\u8f7d\u6210\u529f");
                        MiniAppInfo miniAppInfo2 = miniAppInfo;
                        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), null, "ad", "ad_loading", "spec_download_success", String.valueOf(currentTimeMillis2));
                        BaseUIProxy.this.updateLoadingAdUI(miniAppInfo, str, j3, weakReference);
                        return;
                    }
                    QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onDownloadAdEnd \u56fe\u7247\u4e0b\u8f7d\u5931\u8d25");
                    BaseUIProxy.this.updateLoadingAdStatus(3);
                    MiniAppInfo miniAppInfo3 = miniAppInfo;
                    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo3, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo3), null, "ad", "ad_loading", "spec_download_fail", "");
                    return;
                }
                QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onDownloadAdEnd \u56fe\u7247\u4e0b\u8f7d\u8d85\u65f6");
                BaseUIProxy.this.updateLoadingAdStatus(3);
                MiniAppInfo miniAppInfo4 = miniAppInfo;
                SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo4, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo4), null, "ad", "ad_loading", "spec_download_timeout", String.valueOf(currentTimeMillis2));
            }

            @Override // com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnChooseAdEndListener
            public void onNeedWaitRealTime(String str, boolean z16, long j3) {
                BaseUIProxy baseUIProxy = BaseUIProxy.this;
                baseUIProxy.needRealTimeLoading = z16;
                baseUIProxy.loadingAdJson = str;
                baseUIProxy.cachedAid = j3;
                QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onNeedWaitRealTime \u66f4\u65b0\u7f13\u5b58");
            }
        };
        if (MiniLoadingAdManager.getInstance().selectAd(miniAppInfo, account, this.chooseAdEndListener)) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        updateLoadingAdStatus(i3);
    }

    protected void reloadMiniAppInfoIfNeed(BaseRuntimeLoader baseRuntimeLoader, MiniAppInfo miniAppInfo) {
        if (baseRuntimeLoader.isLoadSucceed()) {
            if (!miniAppInfo.isShortcutFakeApp()) {
                baseRuntimeLoader.setMiniAppInfo(miniAppInfo);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void showDefaultLoadingAd() {
        if (isAbleToShowAd() && !TextUtils.isEmpty(this.loadingAdJson) && this.needRealTimeLoading && this.cachedAid != -1 && this.mLoadingAdStatus == 0) {
            updateLoadingAdUI(getMiniAppInfo(), this.loadingAdJson, this.cachedAid, new WeakReference<>(this.mActivity));
            QMLog.i("MiniLoadingAdManager", "processSelectLoadingAdLogic onChooseAdEnd \u515c\u5e95\u903b\u8f91");
        }
    }

    protected abstract void showLoading(MiniAppInfo miniAppInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public void startMiniAppInfo(MiniAppInfo miniAppInfo, final Bundle bundle) {
        int i3;
        if (miniAppInfo == null) {
            QMLog.e(TAG, "Failed to start. miniAppInfo is null");
            return;
        }
        this.loadStartTimeStamp = System.currentTimeMillis();
        MiniAppUtils.setMiniAppInfo(miniAppInfo);
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.BaseUIProxy.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("receiver");
                    if (resultReceiver != null) {
                        QMLog.i(BaseUIProxy.TAG, "notify resultReceiver.");
                        resultReceiver.send(0, new Bundle());
                    }
                } catch (Throwable th5) {
                    QMLog.e(BaseUIProxy.TAG, "exception when notify resultReceiver.", th5);
                }
            }
        });
        MiniAppPrelaunchRecorder.get().onMiniAppStart(miniAppInfo.appId);
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader != null && baseRuntimeLoader.getRuntime() != null) {
            ((ObserverManager) baseRuntimeLoader.getRuntime().getManager(ObserverManager.class)).notifyChange(MiniAppVideoConstants.NOTIFY_STATUS_RESET);
        }
        if (QMLog.isDebugEnabled()) {
            QMLog.i(TAG, " [MiniLifecycle] startMiniAppInfo=" + miniAppInfo.toDetailString());
        }
        BaseRuntimeLoader queryAppRunTimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(miniAppInfo);
        if (queryAppRunTimeLoader != null && miniAppInfo.launchParam.forceReload != 0) {
            QMLog.i(TAG, "startMiniAppInfo. There is a existing runtime loader but need force Reroad. " + queryAppRunTimeLoader.toSimpleString());
            AppRuntimeLoaderManager.g().removeRuntimeLoader(queryAppRunTimeLoader);
            destroyLastRuntimeLoader(queryAppRunTimeLoader);
            queryAppRunTimeLoader = null;
        }
        if (queryAppRunTimeLoader != null) {
            QMLog.i(TAG, "startMiniAppInfo. Resume the existing runtime of existing runtime loader = " + queryAppRunTimeLoader.toSimpleString());
            this.mCurrRuntimeLoader = queryAppRunTimeLoader;
            queryAppRunTimeLoader.addRuntimeStateObserver(getRuntimeStateObserver());
            AppRuntimeLoaderManager.g().bringToFront(queryAppRunTimeLoader);
            if (baseRuntimeLoader != null && baseRuntimeLoader != queryAppRunTimeLoader) {
                destroyLastRuntimeLoader(baseRuntimeLoader);
            }
            queryAppRunTimeLoader.notifyRuntimeEvent(20, new Object[0]);
            if (baseRuntimeLoader != queryAppRunTimeLoader) {
                showLoading(miniAppInfo);
            }
            reloadMiniAppInfoIfNeed(queryAppRunTimeLoader, miniAppInfo);
        } else {
            showLoading(miniAppInfo);
            MiniReportManager.reportEventType(miniAppInfo, 1013, "1");
            BaseRuntimeLoader createAppRuntimeLoader = AppRuntimeLoaderManager.g().createAppRuntimeLoader(miniAppInfo, createRuntimeLoaderListener(), bundle);
            if (baseRuntimeLoader != null && baseRuntimeLoader != createAppRuntimeLoader) {
                destroyLastRuntimeLoader(baseRuntimeLoader);
            }
            if (createAppRuntimeLoader == null) {
                QMLog.e(TAG, "get runtimeLoader failed. appid=" + miniAppInfo.appId);
                MiniToast.makeText(this.mActivity, "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u8fdb\u5165\u3002", 0).show();
                notifyExit(true, true, false);
                return;
            }
            createAppRuntimeLoader.addRuntimeStateObserver(getRuntimeStateObserver());
            if (miniAppInfo.launchParam.forceReload != 0) {
                createAppRuntimeLoader.resetAndStart(miniAppInfo);
                this.mCurrRuntimeLoader = createAppRuntimeLoader;
            } else {
                this.mCurrRuntimeLoader = createAppRuntimeLoader;
                if (QMLog.isDebugEnabled()) {
                    QMLog.i(TAG, "startMiniAppInfo. Create a new runtime loader = " + createAppRuntimeLoader);
                }
                createAppRuntimeLoader.start();
            }
            createAppRuntimeLoader.notifyRuntimeEvent(20, new Object[0]);
            updateLoadingAdStatusToRuntime();
        }
        if (!TextUtils.isEmpty(miniAppInfo.appId)) {
            if (bundle != null) {
                i3 = bundle.getInt("start_mode", 3);
            } else {
                i3 = 3;
            }
            if (i3 == 3) {
                MiniAppStartState.setProcessLoad(miniAppInfo.appId, false);
            } else {
                MiniAppStartState.setProcessLoad(miniAppInfo.appId, true);
            }
            PageGestureProxy pageGestureProxy = this.mPageGestureProxy;
            if (pageGestureProxy != null) {
                pageGestureProxy.onCreateMiniAppInfo(miniAppInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateLoadingAdStatus(int i3) {
        this.mLoadingAdStatus = i3;
        updateLoadingAdStatusToRuntime();
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void handleRestart() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public void onConfigurationChanged(Configuration configuration) {
    }

    protected void updateLoadingAdUI(MiniAppInfo miniAppInfo, String str, long j3, WeakReference<Activity> weakReference) {
    }
}
