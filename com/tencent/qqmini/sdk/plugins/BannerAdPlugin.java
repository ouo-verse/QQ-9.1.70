package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.MiniAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.BannerAdPosInfo;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class BannerAdPlugin extends BaseJsPlugin implements IGetAdPosInfo {
    public static final String AD_AUTO_REFRESH_INTERVAL = "ad_auto_refresh_interval";
    private static final HashMap<Integer, String> AD_ERROR_MSG = MiniSDKConst.AdConst.CODE_MSG_MAP;
    public static final String API_AD_CREATE_BANNER_AD = "createBannerAd";
    public static final String API_AD_OPERATE_BANNER_AD = "operateBannerAd";
    public static final String API_AD_UPDATE_BANNER_AD_SIZE = "updateBannerAdSize";
    public static final String EVENT_BANNER_AD_SHOW_DONE = "onBannerAdShowDone";
    public static final String EVENT_BANNER_AD_STATE_CHANGE = "onBannerAdStateChange";
    private static final int RESUME_REFRESH_DELAY = 300;
    private static final String TAG = "BannerAdPlugin";
    private FrameLayout mBannerAdContainer;
    private BannerAdPosInfo mBannerAdPosInfo;
    private AdProxy.AbsBannerAdView mBannerAdView;
    private Bundle mCreateViewExt;
    private RequestEvent mCreateViewReq;
    private long mRecordShowedTime;
    private long mShowBannerAdStartTime;
    private float mGameDensity = -1.0f;
    private int mGameWidth = 0;
    private int mGameHeight = 0;
    private boolean mHasNewAd = false;
    private volatile boolean mIsPluginResume = false;
    private volatile boolean mIsRefreshResume = true;
    private volatile boolean mIsAdClose = false;
    private Runnable refreshAdRunnable = new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.6
        @Override // java.lang.Runnable
        public void run() {
            if (BannerAdPlugin.this.mIsPluginResume && BannerAdPlugin.this.mIsRefreshResume) {
                QMLog.i(BannerAdPlugin.TAG, " start refreshAdRunnable");
                BannerAdPlugin.this.doRefresh();
            } else {
                QMLog.i(BannerAdPlugin.TAG, " pause refreshAdRunnable");
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bannerErrorStateCallbackDelay(final RequestEvent requestEvent, final int i3, final String str, int i16) {
        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("state", "error");
                    jSONObject.put("errMsg", str);
                    jSONObject.put("errCode", i3);
                    BannerAdPlugin.this.informJs(requestEvent, jSONObject, BannerAdPlugin.EVENT_BANNER_AD_STATE_CHANGE);
                } catch (JSONException e16) {
                    QMLog.e(BannerAdPlugin.TAG, "bannerErrorStateCallback error", e16);
                }
            }
        }, i16);
    }

    private boolean checkShowValid() {
        BannerAdPosInfo bannerAdPosInfo;
        AdProxy.AbsBannerAdView absBannerAdView = this.mBannerAdView;
        if (absBannerAdView != null && absBannerAdView.getView() != null && (bannerAdPosInfo = this.mBannerAdPosInfo) != null) {
            if (!bannerAdPosInfo.isValid()) {
                QMLog.e(TAG, "showBannerAd error, adPosInfo is invalid." + this.mBannerAdPosInfo);
                return false;
            }
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext != null && iMiniAppContext.getAttachActivity() != null) {
                return true;
            }
            QMLog.e(TAG, "showBannerAd error, mGdtBannerView == null");
            return false;
        }
        QMLog.e(TAG, "showBannerAd error, data is null");
        return false;
    }

    private void createBannerAdView(final RequestEvent requestEvent, final String str, final BannerAdPosInfo bannerAdPosInfo, final Bundle bundle) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
                if (adProxy != null && BannerAdPlugin.this.mBannerAdPosInfo != null) {
                    Activity attachActivity = ((BaseJsPlugin) BannerAdPlugin.this).mMiniAppContext.getAttachActivity();
                    if (attachActivity == null) {
                        QMLog.i(BannerAdPlugin.TAG, "start create, activity null");
                        BannerAdPlugin.this.bannerErrorStateCallbackDelay(requestEvent, 1003, (String) BannerAdPlugin.AD_ERROR_MSG.get(1003), 300);
                        return;
                    }
                    BannerAdPlugin.this.mBannerAdView = adProxy.createBannerAdView(attachActivity, str, bannerAdPosInfo.mAdUnitId, Math.round(r11.mBannerAdPosInfo.mAdRealWidth * BannerAdPlugin.this.mGameDensity), Math.round(BannerAdPlugin.this.mBannerAdPosInfo.mAdRealHeight * BannerAdPlugin.this.mGameDensity), new AdProxy.IBannerAdListener() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.1.1
                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onADClicked() {
                            QMLog.i(BannerAdPlugin.TAG, "onADClicked");
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onADCloseOverlay() {
                            QMLog.i(BannerAdPlugin.TAG, "onADCloseOverlay");
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onADClosed() {
                            BannerAdPlugin.this.destroyBannerAd();
                            BannerAdPlugin.this.mIsAdClose = true;
                            QMLog.i(BannerAdPlugin.TAG, "onADClosed");
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onADExposure() {
                            QMLog.i(BannerAdPlugin.TAG, "onADExposure");
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onADLeftApplication() {
                            QMLog.i(BannerAdPlugin.TAG, "onADLeftApplication");
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onADOpenOverlay() {
                            QMLog.i(BannerAdPlugin.TAG, "onADOpenOverlay");
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onADReceive(JSONObject jSONObject) {
                            QMLog.i(BannerAdPlugin.TAG, "onADReceive");
                            if (bannerAdPosInfo == null) {
                                return;
                            }
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("state", "load");
                                jSONObject2.put("adUnitId", bannerAdPosInfo.mAdUnitId);
                                jSONObject2.put("left", bannerAdPosInfo.mAdLeft);
                                jSONObject2.put("top", bannerAdPosInfo.mAdTop);
                                jSONObject2.put("width", bannerAdPosInfo.mAdWidth);
                                jSONObject2.put("height", bannerAdPosInfo.mAdHeight);
                                jSONObject2.put("realWidth", bannerAdPosInfo.mAdRealWidth);
                                jSONObject2.put("realHeight", bannerAdPosInfo.mAdRealHeight);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                BannerAdPlugin.this.informJs(requestEvent, jSONObject2, BannerAdPlugin.EVENT_BANNER_AD_STATE_CHANGE);
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("state", "resize");
                                jSONObject3.put("width", bannerAdPosInfo.mAdRealWidth);
                                jSONObject3.put("height", bannerAdPosInfo.mAdRealHeight);
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                BannerAdPlugin.this.informJs(requestEvent, jSONObject3, BannerAdPlugin.EVENT_BANNER_AD_STATE_CHANGE);
                                BannerAdPlugin.this.mHasNewAd = true;
                            } catch (JSONException e16) {
                                QMLog.e(BannerAdPlugin.TAG, "informJs success", e16);
                            }
                            if (BannerAdPlugin.this.mBannerAdPosInfo != null && jSONObject != null) {
                                int optInt = jSONObject.optInt(BannerAdPlugin.AD_AUTO_REFRESH_INTERVAL, 0);
                                if (BannerAdPlugin.this.mBannerAdPosInfo.mAdIntervals == 0 && optInt != 0) {
                                    BannerAdPlugin.this.mBannerAdPosInfo.mAdIntervals = optInt;
                                    QMLog.i(BannerAdPlugin.TAG, "adAutoRefreshInterval:" + optInt);
                                }
                            }
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onAdRefreshPause() {
                            QMLog.i(BannerAdPlugin.TAG, "onAdRefreshPause");
                            BannerAdPlugin.this.mIsRefreshResume = false;
                            BannerAdPlugin.this.onPause();
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onAdRefreshResume() {
                            QMLog.i(BannerAdPlugin.TAG, "onAdRefreshResume");
                            BannerAdPlugin.this.mIsRefreshResume = true;
                            BannerAdPlugin.this.onResume();
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                        public void onNoAD(int i3, String str2) {
                            QMLog.i(BannerAdPlugin.TAG, "onNoAD, errCode = " + i3 + ", errMsg = " + str2);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            BannerAdPlugin.this.bannerErrorStateCallbackDelay(requestEvent, i3, str2, 0);
                        }
                    }, bundle, ((BaseJsPlugin) BannerAdPlugin.this).mMiniAppContext, BannerAdPlugin.this);
                    if (BannerAdPlugin.this.mBannerAdView != null) {
                        try {
                            BannerAdPlugin.this.mBannerAdView.loadAD();
                            return;
                        } catch (Throwable th5) {
                            QMLog.i(BannerAdPlugin.TAG, "loadAd error", th5);
                            return;
                        }
                    }
                    return;
                }
                QMLog.i(BannerAdPlugin.TAG, "start create, null");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void createRefreshAdView(final RequestEvent requestEvent, String str, final BannerAdPosInfo bannerAdPosInfo, Bundle bundle) {
        QMLog.i(TAG, "refresh : start create bannerAd view.");
        AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
        if (adProxy != null && this.mBannerAdPosInfo != null) {
            Activity attachActivity = this.mMiniAppContext.getAttachActivity();
            if (attachActivity == null) {
                QMLog.i(TAG, "start create, activity null");
                bannerErrorStateCallbackDelay(requestEvent, 1003, AD_ERROR_MSG.get(1003), 300);
                return;
            }
            AdProxy.AbsBannerAdView createBannerAdView = adProxy.createBannerAdView(attachActivity, str, bannerAdPosInfo.mAdUnitId, Math.round(this.mBannerAdPosInfo.mAdRealWidth * this.mGameDensity), Math.round(this.mBannerAdPosInfo.mAdRealHeight * this.mGameDensity), new AdProxy.IBannerAdListener() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.8
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onADClicked() {
                    QMLog.i(BannerAdPlugin.TAG, "onADClicked");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onADCloseOverlay() {
                    QMLog.i(BannerAdPlugin.TAG, "onADCloseOverlay");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onADClosed() {
                    BannerAdPlugin.this.destroyBannerAd();
                    BannerAdPlugin.this.mIsAdClose = true;
                    QMLog.i(BannerAdPlugin.TAG, "onADClosed");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onADExposure() {
                    QMLog.i(BannerAdPlugin.TAG, "onADExposure");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onADLeftApplication() {
                    QMLog.i(BannerAdPlugin.TAG, "onADLeftApplication");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onADOpenOverlay() {
                    QMLog.i(BannerAdPlugin.TAG, "onADOpenOverlay");
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onADReceive(JSONObject jSONObject) {
                    QMLog.i(BannerAdPlugin.TAG, "onADReceive");
                    if (bannerAdPosInfo != null) {
                        BannerAdPlugin.this.mHasNewAd = true;
                        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (BannerAdPlugin.this.refreshBannerAdView()) {
                                    BannerAdPlugin.this.refreshViewCountTimeDown();
                                } else {
                                    QMLog.i(BannerAdPlugin.TAG, "refreshBannerAdView fail.");
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onAdRefreshPause() {
                    QMLog.i(BannerAdPlugin.TAG, "onAdRefreshPause");
                    BannerAdPlugin.this.mIsRefreshResume = false;
                    BannerAdPlugin.this.onPause();
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onAdRefreshResume() {
                    QMLog.i(BannerAdPlugin.TAG, "onAdRefreshResume");
                    BannerAdPlugin.this.mIsRefreshResume = true;
                    BannerAdPlugin.this.onResume();
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener
                public void onNoAD(int i3, String str2) {
                    QMLog.i(BannerAdPlugin.TAG, "onNoAD, errCode = " + i3 + ", errMsg = " + str2);
                    BannerAdPlugin.this.bannerErrorStateCallbackDelay(requestEvent, i3, str2, 0);
                }
            }, bundle, this.mMiniAppContext, this);
            this.mBannerAdView = createBannerAdView;
            if (createBannerAdView != null) {
                try {
                    createBannerAdView.loadAD();
                } catch (Throwable th5) {
                    QMLog.i(TAG, "loadAd error", th5);
                }
            }
            return;
        }
        QMLog.i(TAG, "start create, null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroyBannerAd() {
        FrameLayout frameLayout = this.mBannerAdContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        destroyBannerAdView();
        this.mBannerAdContainer = null;
        this.mBannerAdPosInfo = null;
        this.mRecordShowedTime = 0L;
        ThreadManager.getUIHandler().removeCallbacks(this.refreshAdRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void destroyBannerAdView() {
        AdProxy.AbsBannerAdView absBannerAdView = this.mBannerAdView;
        if (absBannerAdView != null) {
            absBannerAdView.destroy(this.mMiniAppContext.getAttachActivity());
            this.mBannerAdView = null;
            QMLog.i(TAG, "destroyBannerAdView");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doRefresh() {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.7
            @Override // java.lang.Runnable
            public void run() {
                BannerAdPlugin.this.mShowBannerAdStartTime = System.currentTimeMillis();
                BannerAdPlugin.this.destroyBannerAdView();
                BannerAdPlugin bannerAdPlugin = BannerAdPlugin.this;
                bannerAdPlugin.createRefreshAdView(bannerAdPlugin.mCreateViewReq, ((BaseJsPlugin) BannerAdPlugin.this).mApkgInfo.appId, BannerAdPlugin.this.mBannerAdPosInfo, BannerAdPlugin.this.mCreateViewExt);
            }
        });
    }

    private boolean doRefreshBannerView() {
        FrameLayout frameLayout = this.mBannerAdContainer;
        if (frameLayout == null) {
            return false;
        }
        frameLayout.removeAllViews();
        AdProxy.AbsBannerAdView absBannerAdView = this.mBannerAdView;
        if (absBannerAdView != null && absBannerAdView.getView() != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
            layoutParams.leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
            layoutParams.topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
            this.mBannerAdContainer.addView(this.mBannerAdView.getView(), layoutParams);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("state", "refresh");
                informJs(this.mCreateViewReq, jSONObject, EVENT_BANNER_AD_STATE_CHANGE);
            } catch (JSONException e16) {
                QMLog.e(TAG, "informJs refresh success", e16);
            }
            String reportUrl = this.mBannerAdView.getReportUrl();
            if (this.mHasNewAd && this.mBannerAdPosInfo != null && !TextUtils.isEmpty(reportUrl) && this.mIsPluginResume) {
                this.mBannerAdView.onExposure();
                this.mBannerAdView.onAdShow();
            }
            this.mHasNewAd = false;
            return true;
        }
        QMLog.e(TAG, "showBannerAd error, mGdtBannerView is null");
        return false;
    }

    private boolean doUpdateBannerView() {
        this.mBannerAdContainer.removeAllViews();
        AdProxy.AbsBannerAdView absBannerAdView = this.mBannerAdView;
        if (absBannerAdView != null && absBannerAdView.getView() != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
            layoutParams.leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
            layoutParams.topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
            this.mBannerAdContainer.addView(this.mBannerAdView.getView(), layoutParams);
            this.mBannerAdContainer.setVisibility(0);
            String reportUrl = this.mBannerAdView.getReportUrl();
            if (this.mHasNewAd && this.mBannerAdPosInfo != null && !TextUtils.isEmpty(reportUrl)) {
                this.mBannerAdView.onExposure();
                this.mBannerAdView.onAdShow();
            }
            this.mHasNewAd = false;
            return true;
        }
        QMLog.e(TAG, "showBannerAd error, mGdtBannerView is null");
        return false;
    }

    private int gameDpTopx(float f16) {
        return Math.round(f16 * this.mGameDensity);
    }

    private float getDensity(float f16) {
        float f17 = this.mGameDensity;
        if (f17 > 0.0f) {
            return f17;
        }
        return f16;
    }

    @NotNull
    private String getEntryPathFromAppConfig(MiniAppInfo miniAppInfo) {
        String str = miniAppInfo.launchParam.entryPath;
        if (str == null) {
            return "";
        }
        return str;
    }

    private int getScreenHeight(int i3) {
        int i16 = this.mGameHeight;
        if (i16 > 0) {
            return i16;
        }
        return i3;
    }

    private int getScreenWidth(int i3) {
        int i16 = this.mGameWidth;
        if (i16 > 0) {
            return i16;
        }
        return i3;
    }

    @NotNull
    private String getViaFromAppConfig(MiniAppInfo miniAppInfo) {
        String str;
        if (miniAppInfo == null || (str = miniAppInfo.via) == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void informJs(RequestEvent requestEvent, JSONObject jSONObject, String str) {
        requestEvent.jsService.evaluateSubscribeJS(str, jSONObject.toString(), 0);
    }

    private boolean isAdParamValid(BannerAdPosInfo bannerAdPosInfo, String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(bannerAdPosInfo.mAdUnitId)) {
            return false;
        }
        return true;
    }

    private boolean makeSureContainerAdded() {
        FrameLayout frameLayout = this.mBannerAdContainer;
        if (frameLayout != null && frameLayout.getParent() != null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) this.mMiniAppContext.getAttachActivity().getWindow().getDecorView();
        if (viewGroup == null) {
            QMLog.e(TAG, "makeSureContainerAdded, root view is null");
            return false;
        }
        if (this.mBannerAdContainer == null) {
            this.mBannerAdContainer = new FrameLayout(this.mMiniAppContext.getAttachActivity());
        }
        if (viewGroup instanceof FrameLayout) {
            viewGroup.addView(this.mBannerAdContainer, new FrameLayout.LayoutParams(-1, -1));
        } else if (viewGroup instanceof RelativeLayout) {
            viewGroup.addView(this.mBannerAdContainer, new RelativeLayout.LayoutParams(-1, -1));
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean refreshBannerAdView() {
        if (!checkShowValid() || !doRefreshBannerView()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void refreshViewCountTimeDown() {
        if (this.mIsAdClose) {
            destroyBannerAd();
            return;
        }
        FrameLayout frameLayout = this.mBannerAdContainer;
        if (frameLayout != null && frameLayout.isShown() && this.mIsPluginResume && this.mIsRefreshResume && this.mBannerAdPosInfo != null) {
            this.mShowBannerAdStartTime = System.currentTimeMillis();
            long j3 = (this.mBannerAdPosInfo.mAdIntervals * 1000) - this.mRecordShowedTime;
            this.mRecordShowedTime = 0L;
            if (j3 > 0) {
                ThreadManager.getUIHandler().removeCallbacks(this.refreshAdRunnable);
                ThreadManager.getUIHandler().postDelayed(this.refreshAdRunnable, j3);
            } else {
                doRefresh();
            }
        }
    }

    private void reportBannerAd(final String str) {
        QMLog.i(TAG, "reportBannerAd reportUrl = " + str);
        if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
            ThreadManager.executeOnNetworkIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        httpURLConnection.connect();
                        QMLog.i(BannerAdPlugin.TAG, "reportBannerAd rspCode" + httpURLConnection.getResponseCode());
                    } catch (Throwable th5) {
                        QMLog.i(BannerAdPlugin.TAG, "reportBannerAd error, url = " + str, th5);
                    }
                }
            });
        }
    }

    private void resumeRefresh() {
        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.5
            @Override // java.lang.Runnable
            public void run() {
                if (BannerAdPlugin.this.mBannerAdView != null && BannerAdPlugin.this.mRecordShowedTime == 0) {
                    BannerAdPlugin.this.mBannerAdView.onExposure();
                }
                BannerAdPlugin.this.refreshViewCountTimeDown();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean showBannerAd() {
        if (!checkShowValid()) {
            return false;
        }
        makeSureContainerAdded();
        if (!this.mHasNewAd && this.mBannerAdContainer.getChildCount() > 0) {
            this.mBannerAdContainer.setVisibility(0);
            AdProxy.AbsBannerAdView absBannerAdView = this.mBannerAdView;
            if (absBannerAdView != null) {
                absBannerAdView.onAdShow();
            }
            return true;
        }
        this.mRecordShowedTime = 0L;
        if (!doUpdateBannerView()) {
            return false;
        }
        AdProxy.AbsBannerAdView absBannerAdView2 = this.mBannerAdView;
        if (absBannerAdView2 != null) {
            absBannerAdView2.onAdShow();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0018, code lost:
    
        if (r0.mAdRealWidth != r7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x001d, code lost:
    
        if (r0.mAdTop != r7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0022, code lost:
    
        if (r0.mAdLeft != r7) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateBannerAdPosition(final RequestEvent requestEvent, final int i3, final int i16) {
        if (i3 == -1 || !this.mIsMiniGame) {
            return;
        }
        BannerAdPosInfo bannerAdPosInfo = this.mBannerAdPosInfo;
        if (bannerAdPosInfo != null) {
            boolean z16 = false;
            boolean z17 = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                    }
                    if (!z17) {
                        if (QMLog.isColorLevel()) {
                            QMLog.i(TAG, "updateBannerAd no need to resize");
                            return;
                        }
                        return;
                    }
                }
            }
        }
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.10
            @Override // java.lang.Runnable
            public void run() {
                boolean updateBannerAdPosition = BannerAdPlugin.this.updateBannerAdPosition(i3, i16);
                if (updateBannerAdPosition && i3 == 3) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("state", "resize");
                        jSONObject.put("width", i16);
                        jSONObject.put("height", BannerAdPosInfo.getHeight(i16));
                        BannerAdPlugin.this.informJs(requestEvent, jSONObject, BannerAdPlugin.EVENT_BANNER_AD_STATE_CHANGE);
                    } catch (JSONException e16) {
                        QMLog.e(BannerAdPlugin.TAG, "updateBannerAd informJs error", e16);
                    }
                }
                if (QMLog.isColorLevel()) {
                    QMLog.i(BannerAdPlugin.TAG, "updateBannerAd " + updateBannerAdPosition + ", resizeValue = " + i16);
                }
            }
        });
    }

    private void updateBannerSize(RequestEvent requestEvent) {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int i16 = 1;
            if (jSONObject.has("left")) {
                i3 = jSONObject.getInt("left");
            } else if (jSONObject.has("top")) {
                i3 = jSONObject.getInt("top");
                i16 = 2;
            } else if (jSONObject.has("width")) {
                float density = ViewUtils.getDensity();
                int screenWidth = ViewUtils.getScreenWidth();
                int screenHeight = ViewUtils.getScreenHeight();
                BannerAdPosInfo bannerAdPosInfo = this.mBannerAdPosInfo;
                Activity attachActivity = this.mMiniAppContext.getAttachActivity();
                if (attachActivity != null) {
                    i16 = MiniAppEnv.g().getContext().getResources().getConfiguration().orientation;
                    initActivitySize(attachActivity);
                    density = getDensity(density);
                    screenWidth = getScreenWidth(screenWidth);
                    screenHeight = getScreenHeight(screenHeight);
                }
                int i17 = jSONObject.getInt("width");
                i3 = BannerAdPosInfo.calculateLegalWidth(i17, i16, density, screenWidth, screenHeight);
                if (bannerAdPosInfo != null && i17 != bannerAdPosInfo.mAdWidth && i3 == bannerAdPosInfo.mAdRealWidth) {
                    bannerAdPosInfo.mAdWidth = i17;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("state", "resize");
                        jSONObject2.put("width", bannerAdPosInfo.mAdRealWidth);
                        jSONObject2.put("height", bannerAdPosInfo.mAdRealHeight);
                        informJs(requestEvent, jSONObject2, EVENT_BANNER_AD_STATE_CHANGE);
                        return;
                    } catch (JSONException e16) {
                        QMLog.e(TAG, "updateBannerAd informJs error", e16);
                        return;
                    }
                }
                i16 = 3;
            } else {
                i3 = -1;
                i16 = -1;
            }
            if (i16 == -1) {
                return;
            }
            if (i3 < 0) {
                bannerErrorStateCallbackDelay(requestEvent, 1003, AD_ERROR_MSG.get(1003), 0);
            } else {
                updateBannerAdPosition(requestEvent, i16, i3);
            }
        } catch (JSONException e17) {
            QMLog.e(TAG, "handle updateBannerAdSize parse json error", e17);
        }
    }

    @JsEvent({API_AD_CREATE_BANNER_AD})
    public synchronized String createBannerAd(RequestEvent requestEvent) {
        String str;
        BannerAdPosInfo parseBannerAdPosInfoFromJson;
        int i3;
        int i16;
        QMLog.i(TAG, "receive createBannerAd event");
        try {
            parseBannerAdPosInfoFromJson = BannerAdPosInfo.parseBannerAdPosInfoFromJson(requestEvent.jsonParams);
        } catch (Exception e16) {
            JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, null);
            if (wrapCallbackFail != null) {
                str = wrapCallbackFail.toString();
            } else {
                str = "";
            }
            bannerErrorStateCallbackDelay(requestEvent, 1003, AD_ERROR_MSG.get(1003), 0);
            QMLog.i(TAG, "handle createBannerAd parse json error" + requestEvent.jsonParams, e16);
            if (str != null) {
                return str;
            }
        }
        if (parseBannerAdPosInfoFromJson == null) {
            bannerErrorStateCallbackDelay(requestEvent, 1001, AD_ERROR_MSG.get(1001), 300);
            QMLog.i(TAG, "handle createBannerAd error params, " + requestEvent.jsonParams);
            return "";
        }
        String account = LoginManager.getInstance().getAccount();
        float density = ViewUtils.getDensity();
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        String str2 = this.mApkgInfo.appId;
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        if (attachActivity != null) {
            i3 = MiniAppEnv.g().getContext().getResources().getConfiguration().orientation;
            initActivitySize(attachActivity);
            density = getDensity(density);
            screenWidth = getScreenWidth(screenWidth);
            screenHeight = getScreenHeight(screenHeight);
        } else {
            i3 = 1;
        }
        QMLog.i(TAG, "handle createBannerAd appId = " + str2 + ", posid = " + parseBannerAdPosInfoFromJson.mAdUnitId);
        if (isAdParamValid(parseBannerAdPosInfoFromJson, str2)) {
            bannerErrorStateCallbackDelay(requestEvent, 1001, AD_ERROR_MSG.get(1001), 300);
            return "";
        }
        BannerAdPosInfo buildFormatInfo = BannerAdPosInfo.buildFormatInfo(parseBannerAdPosInfoFromJson, i3, density, screenWidth, screenHeight);
        if (buildFormatInfo != null && buildFormatInfo.isValid()) {
            this.mBannerAdPosInfo = buildFormatInfo;
            String spAdGdtCookie = AdUtil.getSpAdGdtCookie(0);
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            String str3 = "";
            String str4 = "";
            String str5 = "";
            if (miniAppInfo != null) {
                str3 = getEntryPathFromAppConfig(miniAppInfo);
                LaunchParam launchParam = miniAppInfo.launchParam;
                String str6 = launchParam.reportData;
                str5 = String.valueOf(launchParam.scene);
                str4 = str6;
            }
            String viaFromAppConfig = getViaFromAppConfig(miniAppInfo);
            Bundle bundle = new Bundle();
            bundle.putString(AdProxy.KEY_ACCOUNT, account);
            bundle.putInt(AdProxy.KEY_AD_TYPE, 0);
            String str7 = AdProxy.KEY_ORIENTATION;
            if (i3 == 2) {
                i16 = 90;
            } else {
                i16 = 0;
            }
            bundle.putInt(str7, i16);
            bundle.putString(AdProxy.KEY_GDT_COOKIE, spAdGdtCookie);
            bundle.putString(AdProxy.KEY_ENTRY_PATH, str3);
            bundle.putString(AdProxy.KEY_REPORT_DATA, str4);
            bundle.putString(AdProxy.KEY_REFER, str5);
            bundle.putString(AdProxy.KEY_VIA, viaFromAppConfig);
            this.mCreateViewReq = requestEvent;
            this.mCreateViewExt = bundle;
            createBannerAdView(requestEvent, str2, buildFormatInfo, bundle);
            return "";
        }
        bannerErrorStateCallbackDelay(requestEvent, 1001, AD_ERROR_MSG.get(1001), 300);
        QMLog.i(TAG, "handle createBannerAd invalid adInfo = " + buildFormatInfo);
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo
    public MiniAdPosInfo getPosInfo() {
        BannerAdPosInfo bannerAdPosInfo = this.mBannerAdPosInfo;
        if (bannerAdPosInfo == null) {
            return null;
        }
        return new MiniAdPosInfo(bannerAdPosInfo.mAdLeft, bannerAdPosInfo.mAdTop, bannerAdPosInfo.mAdRealWidth, bannerAdPosInfo.mAdRealHeight);
    }

    public synchronized boolean hideBannerAd() {
        AdProxy.AbsBannerAdView absBannerAdView = this.mBannerAdView;
        if (absBannerAdView == null) {
            QMLog.e(TAG, "hideBannerAd error, no data");
            return false;
        }
        if (this.mBannerAdContainer == null) {
            return false;
        }
        absBannerAdView.onAdHide();
        if (this.mBannerAdContainer.getVisibility() != 0) {
            return false;
        }
        this.mBannerAdContainer.setVisibility(8);
        ThreadManager.getUIHandler().removeCallbacks(this.refreshAdRunnable);
        BannerAdPosInfo bannerAdPosInfo = this.mBannerAdPosInfo;
        if (bannerAdPosInfo != null && bannerAdPosInfo.mAdIntervals != 0) {
            this.mRecordShowedTime += System.currentTimeMillis() - this.mShowBannerAdStartTime;
        }
        return true;
    }

    public void initActivitySize(Activity activity) {
        if (this.mGameDensity > 0.0f && this.mGameWidth > 0 && this.mGameHeight > 0) {
            return;
        }
        activity.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        this.mGameDensity = displayMetrics.density;
        this.mGameWidth = displayMetrics.widthPixels;
        this.mGameHeight = displayMetrics.heightPixels;
        QMLog.i(TAG, "density = " + displayMetrics.density + ", ViewUtils.density = " + ViewUtils.getDensity() + ", screenW = " + displayMetrics.widthPixels + ", screenH = " + displayMetrics.heightPixels);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        IMiniAppContext iMiniAppContext;
        IMiniAppContext iMiniAppContext2;
        if (this.mBannerAdView != null && (iMiniAppContext2 = this.mMiniAppContext) != null && iMiniAppContext2.getAttachActivity() != null) {
            this.mBannerAdView.destroy(this.mMiniAppContext.getAttachActivity());
        }
        AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
        if (adProxy != null && (iMiniAppContext = this.mMiniAppContext) != null && iMiniAppContext.getAttachActivity() != null) {
            adProxy.destroy(this.mMiniAppContext.getAttachActivity());
        }
        super.onDestroy();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
        IMiniAppContext iMiniAppContext;
        if (this.mBannerAdView != null && (iMiniAppContext = this.mMiniAppContext) != null && iMiniAppContext.getAttachActivity() != null) {
            this.mBannerAdView.pause(this.mMiniAppContext.getAttachActivity());
            this.mIsPluginResume = false;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        IMiniAppContext iMiniAppContext;
        BannerAdPosInfo bannerAdPosInfo;
        if (this.mBannerAdView != null && (iMiniAppContext = this.mMiniAppContext) != null && iMiniAppContext.getAttachActivity() != null) {
            this.mBannerAdView.resume(this.mMiniAppContext.getAttachActivity());
            this.mIsPluginResume = true;
            if (this.mIsRefreshResume && !this.mIsAdClose && (bannerAdPosInfo = this.mBannerAdPosInfo) != null && bannerAdPosInfo.mAdIntervals != 0) {
                resumeRefresh();
            }
        }
    }

    @JsEvent({API_AD_OPERATE_BANNER_AD})
    public String operateBannerAd(final RequestEvent requestEvent) {
        QMLog.i(TAG, "receive operateBannerAd event");
        try {
            String string = new JSONObject(requestEvent.jsonParams).getString("type");
            QMLog.i(TAG, "handle operateBannerAd type = " + string);
            if ("show".equals(string)) {
                AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        boolean showBannerAd = BannerAdPlugin.this.showBannerAd();
                        if (showBannerAd && BannerAdPlugin.this.mBannerAdPosInfo != null && BannerAdPlugin.this.mBannerAdPosInfo.mAdIntervals != 0) {
                            BannerAdPlugin.this.refreshViewCountTimeDown();
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("state", "show");
                            if (showBannerAd) {
                                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                            } else {
                                str = "error";
                            }
                            jSONObject.put("status", str);
                            BannerAdPlugin.this.informJs(requestEvent, jSONObject, BannerAdPlugin.EVENT_BANNER_AD_SHOW_DONE);
                        } catch (JSONException e16) {
                            BannerAdPlugin.this.bannerErrorStateCallbackDelay(requestEvent, 1003, (String) BannerAdPlugin.AD_ERROR_MSG.get(1003), 0);
                            QMLog.i(BannerAdPlugin.TAG, "handle operateBannerAd show error", e16);
                        }
                        QMLog.i(BannerAdPlugin.TAG, "showBannerAd " + showBannerAd);
                    }
                }, 300L);
            } else if ("hide".equals(string)) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.3
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean hideBannerAd = BannerAdPlugin.this.hideBannerAd();
                        if (QMLog.isColorLevel()) {
                            QMLog.i(BannerAdPlugin.TAG, "hideBannerAd " + hideBannerAd);
                        }
                    }
                });
            } else if ("destroy".equals(string)) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.BannerAdPlugin.4
                    @Override // java.lang.Runnable
                    public void run() {
                        BannerAdPlugin.this.destroyBannerAd();
                    }
                });
            } else {
                QMLog.i(TAG, "handle operateBannerAd not define type = " + string);
            }
            return "";
        } catch (JSONException e16) {
            QMLog.i(TAG, "handle operateBannerAd parse json error", e16);
            return "";
        }
    }

    @JsEvent({API_AD_UPDATE_BANNER_AD_SIZE})
    public void updateBannerAdSize(RequestEvent requestEvent) {
        QMLog.i(TAG, "updateBannerAdSize " + requestEvent.jsonParams);
        updateBannerSize(requestEvent);
    }

    public synchronized boolean updateBannerAdPosition(int i3, int i16) {
        BannerAdPosInfo bannerAdPosInfo;
        QMLog.i(TAG, "updateBannerAdPosition");
        if (this.mBannerAdView != null && (bannerAdPosInfo = this.mBannerAdPosInfo) != null) {
            if (i3 == 1) {
                bannerAdPosInfo.mAdLeft = i16;
            } else if (i3 == 2) {
                bannerAdPosInfo.mAdTop = i16;
            } else if (i3 == 3) {
                bannerAdPosInfo.mAdRealWidth = i16;
                bannerAdPosInfo.mAdRealHeight = BannerAdPosInfo.getHeight(i16);
            }
            FrameLayout frameLayout = this.mBannerAdContainer;
            if (frameLayout != null && frameLayout.getChildCount() > 0) {
                View childAt = this.mBannerAdContainer.getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.leftMargin = gameDpTopx(this.mBannerAdPosInfo.mAdLeft);
                layoutParams.topMargin = gameDpTopx(this.mBannerAdPosInfo.mAdTop);
                layoutParams.width = gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth);
                layoutParams.height = gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight);
                this.mBannerAdView.setSize(gameDpTopx(this.mBannerAdPosInfo.mAdRealWidth), gameDpTopx(this.mBannerAdPosInfo.mAdRealHeight));
                childAt.setLayoutParams(layoutParams);
            }
            return true;
        }
        QMLog.e(TAG, "updateBannerAdPosition error, no data");
        return false;
    }
}
