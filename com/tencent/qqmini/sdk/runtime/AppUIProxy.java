package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;
import com.tencent.qqmini.sdk.manager.MiniLoadManager;
import com.tencent.qqmini.sdk.manager.MiniLoadingAdManager;
import com.tencent.qqmini.sdk.manager.PreloadResource;
import com.tencent.qqmini.sdk.report.MiniAppStartState;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.CapsuleButton;
import com.tencent.qqmini.sdk.widget.MiniLoadingUI;
import java.lang.ref.WeakReference;

@MiniKeep
/* loaded from: classes23.dex */
public class AppUIProxy extends BaseUIProxy {
    public static final int LAUNCH_SCENE_GUILD_APPLICATION = 5002;
    private DebugLayout mDebugLayout;
    private EngineChannel mEngineChannel;
    private MiniLoadingUI mHalfLoadingUI;
    private LoadingUI mLoadingUI;
    private boolean fromFackStart = false;
    private final AppRuntimeEventCenter.RuntimeStateObserver mObserver = new AppRuntimeEventCenter.RuntimeStateObserver() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.1
        @Override // com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver
        public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
            int i3 = miniAppStateMessage.what;
            if (i3 == 100) {
                AppUIProxy.this.enableBreak();
            } else if (i3 == 101) {
                AppUIProxy.this.disableBreak();
            }
        }
    };
    private View.OnClickListener mLoadingClickListener = new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() != R.id.btn_close && view.getId() != R.id.mini_sdk_left_btn) {
                view.getId();
            } else {
                AppStateEvent.obtain(60).notifyRuntime(AppUIProxy.this.getRuntime());
                Activity activity = AppUIProxy.this.mActivity;
                if (activity != null) {
                    activity.finish();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    };

    /* loaded from: classes23.dex */
    public static class DebugLayout extends FrameLayout {
        public DebugLayout(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideAdLoading() {
        this.hasCompletedLoading = true;
        this.loadCompleteTimeForLoadingAdReport = System.currentTimeMillis();
        LoadingUI loadingUI = this.mLoadingUI;
        if (loadingUI != null) {
            loadingUI.setCustomClickListener(null);
        }
        MiniLoadingUI miniLoadingUI = this.mHalfLoadingUI;
        if (miniLoadingUI != null) {
            miniLoadingUI.setCustomClickListener(null);
        }
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.11
            @Override // java.lang.Runnable
            public void run() {
                if (AppUIProxy.this.mLoadingUI != null) {
                    AppUIProxy.this.mLoadingUI.onStop();
                }
                if (AppUIProxy.this.mHalfLoadingUI != null) {
                    AppUIProxy.this.mHalfLoadingUI.n();
                }
            }
        });
        AdFrequencyLimit.setOnStartTime(System.currentTimeMillis());
        MiniLoadingAdManager.getInstance().preloadLoadingAd(getMiniAppInfo());
    }

    private boolean isLaunchFromAppIdWithoutEntryPath(MiniAppInfo miniAppInfo) {
        if (miniAppInfo.isStartFromAppId() && TextUtils.isEmpty(miniAppInfo.launchParam.entryPath)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseLoadingUI() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.4
            @Override // java.lang.Runnable
            public void run() {
                AppUIProxy appUIProxy = AppUIProxy.this;
                if (appUIProxy.mRootLayout != null && appUIProxy.mLoadingUI != null) {
                    AppUIProxy appUIProxy2 = AppUIProxy.this;
                    if (appUIProxy2.mRootLayout.equals(appUIProxy2.mLoadingUI.getParent())) {
                        AppUIProxy appUIProxy3 = AppUIProxy.this;
                        appUIProxy3.mRootLayout.removeView(appUIProxy3.mLoadingUI);
                        AppUIProxy.this.mLoadingUI = null;
                        QMLog.d("minisdk-start_UIProxy", " hideLoading release mLoadingUI");
                    }
                }
                AppUIProxy appUIProxy4 = AppUIProxy.this;
                if (appUIProxy4.mRootLayout != null && appUIProxy4.mHalfLoadingUI != null) {
                    AppUIProxy appUIProxy5 = AppUIProxy.this;
                    if (appUIProxy5.mRootLayout.equals(appUIProxy5.mHalfLoadingUI.getParent())) {
                        AppUIProxy appUIProxy6 = AppUIProxy.this;
                        appUIProxy6.mRootLayout.removeView(appUIProxy6.mHalfLoadingUI);
                        AppUIProxy.this.mHalfLoadingUI = null;
                        QMLog.d("minisdk-start_UIProxy", " hideLoading release mHalfLoadingUI");
                    }
                }
            }
        });
    }

    private void showKingcardTip() {
        QMLog.i("minisdk-start_UIProxy", MiniChatConstants.MINI_APP_SHOW_KINGCARD_TIP);
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.6
            @Override // java.lang.Runnable
            public void run() {
                BaseRuntime baseRuntime;
                BaseRuntimeLoader baseRuntimeLoader = AppUIProxy.this.mCurrRuntimeLoader;
                if (baseRuntimeLoader != null) {
                    baseRuntime = baseRuntimeLoader.getRuntime();
                } else {
                    baseRuntime = null;
                }
                if (baseRuntime != null && baseRuntime.getPage() != null) {
                    ICapsuleButton capsuleButton = baseRuntime.getPage().getCapsuleButton();
                    if (capsuleButton instanceof CapsuleButton) {
                        ((KingCardProxy) ProxyManager.get(KingCardProxy.class)).showKingCardTips(baseRuntime, ((CapsuleButton) capsuleButton).getMoreView());
                        return;
                    }
                    return;
                }
                QMLog.i("minisdk-start_UIProxy", "page is null");
            }
        });
    }

    public void disableBreak() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.9
            @Override // java.lang.Runnable
            public void run() {
                if (AppUIProxy.this.mDebugLayout != null) {
                    AppUIProxy.this.mDebugLayout.setVisibility(4);
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.IUIProxy
    public boolean doDispatchKeyEvent(KeyEvent keyEvent) {
        BaseRuntime baseRuntime;
        IPage page;
        BaseRuntimeLoader baseRuntimeLoader = this.mCurrRuntimeLoader;
        if (baseRuntimeLoader != null) {
            baseRuntime = baseRuntimeLoader.getRuntime();
        } else {
            baseRuntime = null;
        }
        if (baseRuntime != null && (page = baseRuntime.getPage()) != null) {
            page.doDispatchKeyEvent(keyEvent);
            return false;
        }
        return false;
    }

    public void enableBreak() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.8
            @Override // java.lang.Runnable
            public void run() {
                if (AppUIProxy.this.mDebugLayout == null) {
                    AppUIProxy.this.mDebugLayout = PreloadResource.g().getAppDebugUI(AppUIProxy.this.mActivity.getApplicationContext());
                }
                AppUIProxy appUIProxy = AppUIProxy.this;
                if (appUIProxy.mRootLayout != null) {
                    if (appUIProxy.mDebugLayout.getParent() != null) {
                        ((ViewGroup) AppUIProxy.this.mDebugLayout.getParent()).removeView(AppUIProxy.this.mDebugLayout);
                    }
                    AppUIProxy appUIProxy2 = AppUIProxy.this;
                    appUIProxy2.mRootLayout.addView(appUIProxy2.mDebugLayout);
                    AppUIProxy.this.mDebugLayout.setVisibility(0);
                    AppUIProxy.this.mRootLayout.requestLayout();
                    AppUIProxy.this.mRootLayout.invalidate();
                }
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected AppRuntimeEventCenter.RuntimeStateObserver getRuntimeStateObserver() {
        return this.mObserver;
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void hideLoading() {
        QMLog.d("minisdk-start_UIProxy", " hideLoading\uff01");
        long currentTimeMillis = System.currentTimeMillis() - this.loadStartTimeStamp;
        if (isAbleToShowLoadingAd() && !this.hasHideLoading) {
            this.hasHideLoading = true;
            if (currentTimeMillis < this.adLimitShowTime) {
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AppUIProxy.this.showDefaultLoadingAd();
                        AppUIProxy.this.hideAdLoading();
                        AppUIProxy.this.releaseLoadingUI();
                    }
                }, this.adLimitShowTime - currentTimeMillis);
                return;
            }
            showDefaultLoadingAd();
            hideAdLoading();
            releaseLoadingUI();
            return;
        }
        hideAdLoading();
        releaseLoadingUI();
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected boolean isAbleToShowAd() {
        return !this.hasCompletedLoading;
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
        super.onAttachActivity(activity, bundle, viewGroup);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onDetachActivity(Activity activity) {
        if (!this.hasHideLoading) {
            hideLoading();
        }
        super.onDetachActivity(activity);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onIntentUpdate(Intent intent) {
        EngineChannel engineChannel;
        if (intent != null) {
            try {
                engineChannel = (EngineChannel) intent.getParcelableExtra("engineChannel");
            } catch (Throwable th5) {
                QMLog.e("minisdk-start_UIProxy", "", th5);
            }
        } else {
            engineChannel = null;
        }
        this.mEngineChannel = engineChannel;
        MiniLoadManager.g().configTask(AppLoaderFactory.g().getContext(), null);
        MiniLoadManager.g().setDownloadEngineChannel(this.mEngineChannel);
        MiniLoadManager.g().startDownload(null);
        super.onIntentUpdate(intent);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy, com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniResume() {
        BaseRuntime runtime;
        super.onMiniResume();
        Activity activity = this.mActivity;
        if (activity != null && activity.getRequestedOrientation() != 1 && ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDeviceType() == MiniAppProxy.DeviceType.PHONE && (runtime = getRuntime()) != null && runtime.getPage() != null) {
            if (!WindowInfo.ORIENTATION_LANDSCAPE.equals(runtime.getPage().getPageOrientation())) {
                this.mActivity.setRequestedOrientation(1);
            }
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
        super.onMiniStop();
        AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
        if (adProxy != null) {
            adProxy.onActivityStop();
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void onRuntimeFail(int i3, String str) {
        String config;
        String str2 = "";
        if (13 == i3) {
            try {
                config = WnsConfig.getConfig("qqminiapp", "mini_app_upgrade_url", "https://m.q.qq.com/upgrade/{appid}");
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                if (getMiniAppInfo() != null) {
                    str2 = getMiniAppInfo().appId;
                }
                if (config.contains("{appid}") && !TextUtils.isEmpty(str2)) {
                    config = config.replace("{appid}", str2);
                }
                str2 = config;
                QMLog.i("minisdk-start_UIProxy", "showUpdateMobileQQDialog jump to upgrate page:" + str2);
                Intent intent = new Intent();
                intent.putExtra("hide_more_button", true);
                intent.putExtra("hide_operation_bar", true);
                intent.putExtra("url", str2);
                ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).startBrowserActivity(this.mActivity, intent);
                AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity activity = AppUIProxy.this.mActivity;
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                }, 1500L);
                return;
            } catch (Throwable th6) {
                th = th6;
                str2 = config;
                QMLog.e(AppLoaderFactory.TAG, "jump to upgrate page exception! url=" + str2, th);
                return;
            }
        }
        super.onRuntimeFail(i3, str);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void onRuntimeReady() {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.5

            /* renamed from: com.tencent.qqmini.sdk.runtime.AppUIProxy$5$a */
            /* loaded from: classes23.dex */
            class a extends AppRuntimeEventCenter.RuntimeStateObserver {
                a() {
                }

                @Override // com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver
                public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage miniAppStateMessage) {
                    if (miniAppStateMessage.what == 11) {
                        AppUIProxy.this.hideLoading();
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseRuntimeLoader baseRuntimeLoader = AppUIProxy.this.mCurrRuntimeLoader;
                if (baseRuntimeLoader != null) {
                    if (!baseRuntimeLoader.dismissLoadingAfterLoaded()) {
                        AppUIProxy.this.mCurrRuntimeLoader.addRuntimeStateObserver(new a());
                    } else {
                        AppUIProxy.this.hideLoading();
                    }
                    BaseRuntimeLoader baseRuntimeLoader2 = AppUIProxy.this.mCurrRuntimeLoader;
                    baseRuntimeLoader2.startLoadMiniAppContent(baseRuntimeLoader2.needReloadPage());
                    AppUIProxy appUIProxy = AppUIProxy.this;
                    appUIProxy.mCurrRuntimeLoader.onAttachActivity(appUIProxy.mActivity, null, appUIProxy.mRootLayout);
                }
            }
        });
        showKingcardTip();
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (channelProxy != null && miniAppInfo != null) {
            channelProxy.syncForceGroundAndRefreshBadge(this.mActivity, miniAppInfo.appId, AppLoaderFactory.g().getProcessName());
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void reloadMiniAppInfoIfNeed(BaseRuntimeLoader baseRuntimeLoader, MiniAppInfo miniAppInfo) {
        if (baseRuntimeLoader.isLoadSucceed()) {
            MiniAppInfo miniAppInfo2 = baseRuntimeLoader.getMiniAppInfo();
            if (!miniAppInfo.isShortcutFakeApp() && !miniAppInfo.launchParam.fromBackToMiniApp() && !isLaunchFromAppIdWithoutEntryPath(miniAppInfo)) {
                if (miniAppInfo.isFakeAppInfo()) {
                    baseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
                    baseRuntimeLoader.updateMiniAppInfoFromReload(miniAppInfo);
                    return;
                }
                String str = miniAppInfo.launchParam.entryPath;
                String str2 = miniAppInfo2.launchParam.entryPath;
                if (baseRuntimeLoader.getRuntime().getPage() != null && baseRuntimeLoader.getRuntime().getPage().getPageInfo(2) != null) {
                    str2 = baseRuntimeLoader.getRuntime().getPage().getPageInfo(2).pageUrl;
                }
                if (!miniAppInfo.appMode.reloadWithFirstPageChange && !TextUtils.isEmpty(str)) {
                    QMLog.i("minisdk-start_UIProxy", "not appstore, entryPath need reload");
                    baseRuntimeLoader.updateMiniAppInfoFromReload(miniAppInfo);
                    if (!TextUtils.isEmpty(miniAppInfo.appId)) {
                        MiniAppStartState.setSwitchPage(miniAppInfo.appId, true);
                    }
                } else if (!TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2))) {
                    baseRuntimeLoader.updateMiniAppInfo(miniAppInfo);
                } else {
                    QMLog.i("minisdk-start_UIProxy", "entryPath need reload");
                    baseRuntimeLoader.updateMiniAppInfoFromReload(miniAppInfo);
                    if (!TextUtils.isEmpty(miniAppInfo.appId)) {
                        MiniAppStartState.setSwitchPage(miniAppInfo.appId, true);
                    }
                }
                baseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
                hideLoading();
                return;
            }
            miniAppInfo2.launchParam.clone(miniAppInfo.launchParam);
            baseRuntimeLoader.onAttachActivity(this.mActivity, null, this.mRootLayout);
            hideLoading();
            return;
        }
        showLoading(miniAppInfo);
        baseRuntimeLoader.setRuntimeLoadListener(createRuntimeLoaderListener());
        if (!baseRuntimeLoader.isRunning()) {
            baseRuntimeLoader.setMiniAppInfo(miniAppInfo);
            baseRuntimeLoader.start();
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void showLoading(MiniAppInfo miniAppInfo) {
        LaunchParam launchParam;
        EntryModel entryModel;
        if (this.mActivity == null) {
            QMLog.e("minisdk-start_UIProxy", "showLoading mActivity == null");
            return;
        }
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && (entryModel = launchParam.entryModel) != null && entryModel.type == 9) {
            QMLog.d("minisdk-start_UIProxy", " showLoading TYPE_HALFMINI");
            MiniLoadingUI halfLoadingUI = PreloadResource.g().getHalfLoadingUI(this.mActivity.getApplicationContext());
            this.mHalfLoadingUI = halfLoadingUI;
            halfLoadingUI.h(miniAppInfo);
            this.mHalfLoadingUI.setMaskContainerShow();
            this.mHalfLoadingUI.setCustomClickListener(this.mLoadingClickListener);
            if (this.mHalfLoadingUI.getVisibility() != 0) {
                this.mHalfLoadingUI.setVisibility(0);
            }
            if (this.mHalfLoadingUI.getParent() != null) {
                ((ViewGroup) this.mHalfLoadingUI.getParent()).removeView(this.mHalfLoadingUI);
            }
            ViewGroup viewGroup = this.mRootLayout;
            if (viewGroup != null) {
                viewGroup.addView(this.mHalfLoadingUI);
            }
            this.mHalfLoadingUI.m();
        } else {
            QMLog.d("minisdk-start_UIProxy", " showLoading TYPE_FULLMINI");
            LoadingUI appLoadingUI = PreloadResource.g().getAppLoadingUI(this.mActivity.getApplicationContext());
            this.mLoadingUI = appLoadingUI;
            appLoadingUI.initData(miniAppInfo);
            this.mLoadingUI.setCustomClickListener(this.mLoadingClickListener);
            if (this.mLoadingUI.getVisibility() != 0) {
                this.mLoadingUI.setVisibility(0);
            }
            if (this.mLoadingUI.getParent() != null) {
                ((ViewGroup) this.mLoadingUI.getParent()).removeView(this.mLoadingUI);
            }
            ViewGroup viewGroup2 = this.mRootLayout;
            if (viewGroup2 != null) {
                viewGroup2.addView(this.mLoadingUI);
            }
            this.mLoadingUI.onResume();
        }
        this.hasCompletedLoading = false;
        this.hasHideLoading = false;
        processSelectLoadingAdLogic(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void startMiniAppInfo(MiniAppInfo miniAppInfo, Bundle bundle) {
        LaunchParam launchParam;
        EntryModel entryModel;
        this.adLimitShowTime = 0L;
        MiniQMMKVProxy miniQMMKVProxy = (MiniQMMKVProxy) ProxyManager.get(MiniQMMKVProxy.class);
        if (miniQMMKVProxy != null) {
            try {
                this.adLimitShowTime = Long.parseLong(miniQMMKVProxy.getMiniAppString(MiniLoadingAdManager.EXTRA_APP_LOADING_KEY, "0"));
            } catch (NumberFormatException e16) {
                QMLog.e("minisdk-start_UIProxy", "startMiniAppInfo error:", e16);
            }
        }
        QMLog.i("minisdk-start_UIProxy", "startMiniAppInfo");
        super.startMiniAppInfo(miniAppInfo, bundle);
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && (entryModel = launchParam.entryModel) != null && entryModel.type == 9) {
            SDKMiniProgramLpReportDC04239.reportAsyncR9(miniAppInfo, "page_view", "click", "", "", "", "halfscreen");
        } else if (miniAppInfo != null) {
            SDKMiniProgramLpReportDC04239.reportAsyncR9(miniAppInfo, "page_view", "click", "", "", "", ReportConst.ACTION.FULLSCREEN);
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseUIProxy
    protected void updateLoadingAdUI(final MiniAppInfo miniAppInfo, final String str, final long j3, WeakReference<Activity> weakReference) {
        final Activity activity = weakReference.get();
        if (activity == null) {
            QMLog.e("minisdk-start_UIProxy", "updateLoadingAdUI activity is null!");
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.10

                /* renamed from: com.tencent.qqmini.sdk.runtime.AppUIProxy$10$a */
                /* loaded from: classes23.dex */
                class a implements MiniLoadingAdManager.OnDismissListener {
                    a() {
                    }

                    @Override // com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.OnDismissListener
                    public void onDismiss() {
                        AppUIProxy.this.updateLoadingAdStatus(3);
                        DisplayUtil.setSystemUIVisible(activity, true);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    AppUIProxy.this.updateLoadingAdStatus(2);
                    DisplayUtil.setSystemUIVisible(activity, false);
                    MiniLoadingAdManager.getInstance().updateLoadingAdLayoutAndShow(miniAppInfo, activity, false, str, j3, new a());
                }
            });
        }
    }

    /* loaded from: classes23.dex */
    public static class LoadingUI extends RelativeLayout implements View.OnClickListener {
        private ImageView backIV;
        int iconSize;
        private boolean isForeground;
        private RelativeLayout leftContainer;
        private View.OnClickListener mClickListener;
        private ImageView mCloseView;
        private LinearLayout mDeveloperInfoContainer;
        private TextView mDeveloperInfoDesc;
        private SquareImageView mLogoView;
        private ImageView mMoreView;
        private TextView mNameView;
        private ProgressBar mProgressBar;
        private ViewGroup mRootView;
        private View mStatusBar;
        private MiniAppInfo miniAppInfo;
        private RelativeLayout rightContainer;
        Handler uiHandler;

        public LoadingUI(Context context) {
            super(context);
            this.iconSize = DisplayUtil.dip2px(getContext(), 60.0f);
            this.isForeground = false;
            init();
        }

        private void cleanAnimation() {
            this.mRootView.setVisibility(0);
            this.mRootView.clearAnimation();
            this.mLogoView.clearAnimation();
            this.mNameView.clearAnimation();
            this.mProgressBar.clearAnimation();
        }

        private void init() {
            this.mRootView = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.mRootView.setBackgroundColor(-1);
            this.mRootView.setLayoutParams(layoutParams);
            addView(this.mRootView);
            this.uiHandler = new Handler(Looper.getMainLooper());
            this.leftContainer = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, DisplayUtil.dip2px(getContext(), 30.0f));
            layoutParams2.addRule(9, -1);
            layoutParams2.topMargin = DisplayUtil.dip2px(getContext(), 9.0f) + ImmersiveUtils.getStatusBarHeight(getContext());
            this.leftContainer.setLayoutParams(layoutParams2);
            this.backIV = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 9.0f), DisplayUtil.dip2px(getContext(), 15.0f));
            this.backIV.setId(R.id.mini_sdk_left_btn);
            layoutParams3.addRule(15);
            layoutParams3.leftMargin = DisplayUtil.dip2px(getContext(), 12.0f);
            this.backIV.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.backIV.setImageResource(R.drawable.mini_sdk_nav_bar_title_back_img);
            this.backIV.setOnClickListener(this);
            this.leftContainer.addView(this.backIV, layoutParams3);
            this.mRootView.addView(this.leftContainer, layoutParams2);
            this.rightContainer = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 80.0f), DisplayUtil.dip2px(getContext(), 30.0f));
            layoutParams4.addRule(11, -1);
            layoutParams4.topMargin = DisplayUtil.dip2px(getContext(), 9.0f) + ImmersiveUtils.getStatusBarHeight(getContext());
            layoutParams4.rightMargin = DisplayUtil.dip2px(getContext(), 12.5f);
            this.rightContainer.setLayoutParams(layoutParams4);
            ImageView imageView = new ImageView(getContext());
            this.mMoreView = imageView;
            int i3 = R.id.btn_more_menu;
            imageView.setId(i3);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 40.0f), -1);
            this.mMoreView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.mMoreView.setImageResource(R.drawable.mini_sdk_top_btns_more_bg);
            this.mMoreView.setOnClickListener(this);
            this.rightContainer.addView(this.mMoreView, layoutParams5);
            ImageView imageView2 = new ImageView(getContext());
            this.mCloseView = imageView2;
            imageView2.setId(R.id.btn_close);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 40.0f), -1);
            layoutParams6.addRule(1, i3);
            this.mCloseView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.mCloseView.setImageResource(R.drawable.mini_sdk_top_btns_close_bg);
            this.mCloseView.setOnClickListener(this);
            this.rightContainer.addView(this.mCloseView, layoutParams6);
            View view = new View(getContext());
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 0.5f), DisplayUtil.dip2px(getContext(), 18.0f));
            layoutParams7.addRule(13, -1);
            view.setBackgroundColor(436207616);
            view.setVisibility(0);
            this.rightContainer.addView(view, layoutParams7);
            this.mRootView.addView(this.rightContainer, layoutParams4);
            SquareImageView squareImageView = new SquareImageView(getContext());
            this.mLogoView = squareImageView;
            int i16 = R.id.logo_mask;
            squareImageView.setId(i16);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 45.0f), DisplayUtil.dip2px(getContext(), 45.0f));
            layoutParams8.topMargin = DisplayUtil.dip2px(getContext(), 60.0f);
            layoutParams8.addRule(14, -1);
            this.mLogoView.setRoundRect(40);
            this.mLogoView.setLayerType(1, null);
            this.mRootView.addView(this.mLogoView, layoutParams8);
            TextView textView = new TextView(getContext());
            this.mNameView = textView;
            int i17 = R.id.game_name;
            textView.setId(i17);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams9.topMargin = DisplayUtil.dip2px(getContext(), 10.0f);
            layoutParams9.addRule(14, -1);
            layoutParams9.addRule(3, i16);
            this.mNameView.setTextColor(-1442840576);
            this.mNameView.setTextSize(16.0f);
            this.mNameView.setIncludeFontPadding(false);
            this.mRootView.addView(this.mNameView, layoutParams9);
            this.mProgressBar = new ProgressBar(getContext());
            RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 60.0f), DisplayUtil.dip2px(getContext(), 14.5f));
            layoutParams10.topMargin = DisplayUtil.dip2px(getContext(), 12.0f);
            layoutParams10.addRule(3, i17);
            layoutParams10.addRule(14, -1);
            this.mProgressBar.setIndeterminate(true);
            this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.mini_sdk_loading_drawable));
            this.mRootView.addView(this.mProgressBar, layoutParams10);
            this.mDeveloperInfoContainer = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams11.addRule(12);
            layoutParams11.addRule(14);
            layoutParams11.bottomMargin = DisplayUtil.dip2px(getContext(), 12.0f);
            this.mDeveloperInfoContainer.setOrientation(0);
            this.mDeveloperInfoContainer.setGravity(17);
            this.mDeveloperInfoContainer.setVisibility(8);
            this.mDeveloperInfoDesc = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
            this.mDeveloperInfoDesc.setMaxWidth(DisplayUtil.dip2px(getContext(), 187.0f));
            this.mDeveloperInfoDesc.setGravity(1);
            this.mDeveloperInfoDesc.setTextSize(11.0f);
            this.mDeveloperInfoDesc.setMaxEms(99);
            this.mDeveloperInfoDesc.setTextColor(-5196865);
            layoutParams12.leftMargin = DisplayUtil.dip2px(getContext(), 20.0f);
            layoutParams12.rightMargin = DisplayUtil.dip2px(getContext(), 20.0f);
            this.mDeveloperInfoContainer.addView(this.mDeveloperInfoDesc, layoutParams12);
            this.mRootView.addView(this.mDeveloperInfoContainer, layoutParams11);
            setImportantForAccessibility(2);
        }

        private boolean isCurrInterLoadingMode() {
            AppMode appMode;
            MiniAppInfo miniAppInfo = this.miniAppInfo;
            if (miniAppInfo != null && (appMode = miniAppInfo.appMode) != null && appMode.interLoading) {
                return true;
            }
            return false;
        }

        private boolean isInternalApp() {
            AppMode appMode;
            MiniAppInfo miniAppInfo = this.miniAppInfo;
            if (miniAppInfo != null && (appMode = miniAppInfo.appMode) != null && appMode.interMode) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSlideInAnimation() {
            AnimationSet animationSet = new AnimationSet(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 40.0f, 0.0f);
            translateAnimation.setDuration(300L);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.setInterpolator(new LinearInterpolator());
            this.mLogoView.setVisibility(0);
            this.mLogoView.setAnimation(animationSet);
            final AnimationSet animationSet2 = new AnimationSet(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 40.0f, 0.0f);
            translateAnimation2.setDuration(300L);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation2.setDuration(800L);
            alphaAnimation2.setInterpolator(new DecelerateInterpolator());
            animationSet2.addAnimation(translateAnimation2);
            animationSet2.addAnimation(alphaAnimation2);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LoadingUI.this.mProgressBar.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI.3
                @Override // java.lang.Runnable
                public void run() {
                    LoadingUI.this.mNameView.setVisibility(0);
                    LoadingUI.this.mNameView.setAnimation(animationSet2);
                }
            }, 200L);
        }

        private void setSlideOutAnimation() {
            cleanAnimation();
            AnimationSet animationSet = new AnimationSet(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -80.0f);
            translateAnimation.setDuration(200L);
            animationSet.addAnimation(alphaAnimation);
            animationSet.addAnimation(translateAnimation);
            animationSet.setInterpolator(new LinearInterpolator());
            animationSet.setFillAfter(true);
            this.mLogoView.setVisibility(0);
            this.mLogoView.setAnimation(animationSet);
            final AnimationSet animationSet2 = new AnimationSet(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -60.0f);
            translateAnimation2.setDuration(200L);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation2.setDuration(300L);
            alphaAnimation2.setInterpolator(new DecelerateInterpolator());
            animationSet2.addAnimation(translateAnimation2);
            animationSet2.addAnimation(alphaAnimation2);
            animationSet2.setFillAfter(true);
            this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI.4
                @Override // java.lang.Runnable
                public void run() {
                    LoadingUI.this.mNameView.setVisibility(0);
                    LoadingUI.this.mNameView.setAnimation(animationSet2);
                }
            }, 100L);
            this.mProgressBar.setVisibility(8);
            new AnimationSet(true);
            AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation3.setDuration(400L);
            alphaAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LoadingUI.this.mRootView.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.mRootView.setAnimation(alphaAnimation3);
        }

        public int getStatusBarHeight() {
            return getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        }

        void hideRightContainerFromArk() {
            LaunchParam launchParam;
            MiniAppInfo miniAppInfo = this.miniAppInfo;
            if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && launchParam.scene == 5002) {
                RelativeLayout relativeLayout = this.rightContainer;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(4);
                }
                RelativeLayout relativeLayout2 = this.leftContainer;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout3 = this.rightContainer;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(0);
            }
            RelativeLayout relativeLayout4 = this.leftContainer;
            if (relativeLayout4 != null) {
                relativeLayout4.setVisibility(4);
            }
        }

        public void initData(MiniAppInfo miniAppInfo) {
            this.miniAppInfo = miniAppInfo;
        }

        public boolean isForeground() {
            return this.isForeground;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.btn_close || view.getId() == R.id.mini_sdk_left_btn) {
                MiniReportManager.reportEventType(this.miniAppInfo, 1026, "1");
            }
            View.OnClickListener onClickListener = this.mClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public void onResume() {
            AppMode appMode;
            this.isForeground = true;
            cleanAnimation();
            if (!isInternalApp() && !isCurrInterLoadingMode()) {
                if (!TextUtils.isEmpty(this.miniAppInfo.iconUrl)) {
                    MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                    Drawable drawable = getContext().getResources().getDrawable(R.drawable.mini_sdk_icon_loading_default);
                    Context context = getContext();
                    String str = this.miniAppInfo.iconUrl;
                    int i3 = this.iconSize;
                    Drawable drawable2 = miniAppProxy.getDrawable(context, str, i3, i3, drawable);
                    if (drawable2 != null) {
                        drawable = drawable2;
                    }
                    this.mLogoView.setImageDrawable(drawable);
                }
                RelativeLayout relativeLayout = this.rightContainer;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                this.mNameView.setText(this.miniAppInfo.name);
                this.mNameView.setVisibility(0);
                this.mProgressBar.setVisibility(0);
                this.mLogoView.setVisibility(0);
                this.mRootView.setBackgroundColor(-1);
                this.uiHandler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.runtime.AppUIProxy.LoadingUI.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LoadingUI.this.setSlideInAnimation();
                    }
                }, 250L);
            } else {
                this.mLogoView.setVisibility(8);
                this.mNameView.setVisibility(4);
                this.mProgressBar.setVisibility(0);
                this.mRootView.setBackgroundColor(-1);
                MiniAppInfo miniAppInfo = this.miniAppInfo;
                if (miniAppInfo != null && (appMode = miniAppInfo.appMode) != null && appMode.closeTopRightCapsule) {
                    RelativeLayout relativeLayout2 = this.rightContainer;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(4);
                    }
                } else {
                    RelativeLayout relativeLayout3 = this.rightContainer;
                    if (relativeLayout3 != null) {
                        relativeLayout3.setVisibility(0);
                    }
                }
            }
            hideRightContainerFromArk();
        }

        public void onStop() {
            this.isForeground = false;
            if (isCurrInterLoadingMode()) {
                this.mRootView.setVisibility(8);
            } else {
                setSlideOutAnimation();
            }
        }

        public void setCustomClickListener(View.OnClickListener onClickListener) {
            this.mClickListener = onClickListener;
        }

        public LoadingUI(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.iconSize = DisplayUtil.dip2px(getContext(), 60.0f);
            this.isForeground = false;
            init();
        }

        public LoadingUI(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.iconSize = DisplayUtil.dip2px(getContext(), 60.0f);
            this.isForeground = false;
            init();
        }
    }
}
