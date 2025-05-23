package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.ui.RaffleFailDialog;
import com.tencent.qqmini.minigame.ui.RaffleSuccessDialog;
import com.tencent.qqmini.sdk.action.AudioFocusEvent;
import com.tencent.qqmini.sdk.action.ShareAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class RaffleJsPlugin extends BaseJsPlugin {
    private static final long ALLOW_CANCEL_DELAY = 5000;
    public static final String ERROR_REPORT_NETWORK_ERROR = "network error";
    public static final String ERROR_REPORT_NO_NETWORK = "no network";
    public static final String ERROR_REPORT_RAFFLE_FAIL = "raffle fail";
    public static final String ERROR_REPORT_RAFFLE_LIMITED = "raffle limited";
    public static final String ERROR_REPORT_RAFFLE_OUT_OF_TIME = "raffle out of time";
    public static final String EVENT_ON_RAFFLE_STATE_CHANGE = "onMinigameRaffleStateChange";
    public static final String EVENT_ON_SHARE_SUC_NOTICE = "onRaffleShareSucNotice";
    public static final String EVENT_START_RAFFLE = "minigameRaffle";
    private static final int IMAGE_TYPE_BUTTON = 3;
    private static final int IMAGE_TYPE_LOGO = 1;
    private static final int IMAGE_TYPE_PRIZE = 2;
    public static final String KEY_RESULT_DATA = "key_result_data";
    private static final long PRELOAD_EFFECTIVE_TIME_SECOND = 3600;
    private static final String PRELOAD_MATERIAL_SP_NAME = "minigame_raffleJsPlugin_getGameRaffleMaterial";
    public static final boolean PRELOAD_SWITCH = true;
    public static final String RAFFLE_SHARE_ACTION = "raffleShare";
    public static final String RAFFLE_STATE_AGAIN = "again";
    public static final String RAFFLE_STATE_CLOSE = "close";
    public static final String RAFFLE_STATE_ERROR = "error";
    public static final int RAFFLE_STATE_HIT = 0;
    public static final int RAFFLE_STATE_LIMITED = 1;
    public static final int RAFFLE_STATE_OUT_OF_TIME = 2;
    public static final String RAFFLE_STATE_SHARE = "share";
    public static final String RAFFLE_STATE_WATCH_AD = "watchAd";
    public static final long RECOVER_CLICK_DELAY = 1000;
    private static final String REPORT_ACTION_CLK = "clk";
    private static final String REPORT_ACTION_EXP = "exp";
    private static final int REPORT_ERROR_CODE_FAIL_AD_LOAD_ERROR = 7;
    private static final int REPORT_ERROR_CODE_FAIL_GET_MATERIAL_FAIL = 5;
    private static final int REPORT_ERROR_CODE_FAIL_LOAD_IMAGE_ERROR = 6;
    private static final int REPORT_ERROR_CODE_SUCCESS_DO_RAFFLE_DATA_ERROR = 2;
    private static final int REPORT_ERROR_CODE_SUCCESS_DO_RAFFLE_FAIL = 1;
    private static final int REPORT_ERROR_CODE_SUCCESS_GET_MATERIAL_FAIL = 3;
    private static final int REPORT_ERROR_CODE_SUCCESS_LOAD_IMAGE_ERROR = 4;
    private static final String REPORT_EVENT_NAME_FAIL = "xiaoyouxi_fail";
    private static final String REPORT_EVENT_NAME_FAIL_AGAIN = "xiaoyouxi_fail_again";
    private static final String REPORT_EVENT_NAME_FAIL_CLOSE = "xiaoyouxi_fail_close";
    private static final String REPORT_EVENT_NAME_FAIL_SHARE_CLICK = "xiaoyouxi_fail_share_recover";
    private static final String REPORT_EVENT_NAME_FAIL_SHARE_SUCCESS = "xiaoyouxi_fail_share_finish";
    private static final String REPORT_EVENT_NAME_FAIL_WATCH_AD_CLICK = "xiaoyouxi_fail_reward_video";
    private static final String REPORT_EVENT_NAME_FAIL_WATCH_AD_SUCCESS = "xiaoyouxi_fail_reward_video_finish";
    private static final String REPORT_EVENT_NAME_RAFFLE = "xiaoyouxi_choujiang";
    private static final String REPORT_EVENT_NAME_RAFFLE_BACK_AGAIN = "xiaoyouxi_return_again";
    private static final String REPORT_EVENT_NAME_RAFFLE_BACK_GAME = "xiaoyouxi_return_game";
    private static final String REPORT_EVENT_NAME_RAFFLE_CLOSE = "xiaoyouxi_choujiang_close";
    private static final String REPORT_EVENT_NAME_RAFFLE_CLOSE_CANCEL = "xiaoyouxi_close_pop_cancel";
    private static final String REPORT_EVENT_NAME_RAFFLE_CLOSE_CERTAIN = "xiaoyouxi_close_pop_confirm";
    private static final String REPORT_EVENT_NAME_RAFFLE_ERROR = "xiaoyouxi_raffle_error";
    private static final String REPORT_EVENT_NAME_RAFFLE_OPEN = "xiaoyouxi_choujiang_open";
    private static final long SHOW_LOADING_DELAY = 500;
    private static final String TAG = "RaffleJsPlugin";
    private static final String WEB_VIEW_PARAM = "&_wwv=13";
    private String appid;
    private String failUrl;
    private String goBackMainButtonUrl;
    private boolean isHorizontal;
    private String jumpUrl;
    private Dialog loadingDialog;
    private String logoUrl;
    private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
    private String posId;
    private String prizeUrl;
    private RaffleFailDialog raffleFailDialog;
    private RaffleSuccessDialog raffleSuccessDialog;
    private String receiveUrl;
    private String shareButtonUrl;
    private String uin;
    private String watchAdButtonUrl;
    private String wishingImgUrl;
    private Integer promotionId = 0;
    private Integer activeId = 0;
    private boolean hasGetMaterial = false;
    private volatile boolean mIsPreloadAd = true;
    private volatile boolean mIsRequestingAd = false;
    private boolean mIsAlreadyFail = false;
    private boolean mGetRewarded = false;
    Runnable showLoadingRunnable = new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.14
        @Override // java.lang.Runnable
        public void run() {
            Activity attachActivity = ((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext.getAttachActivity();
            RaffleJsPlugin.this.loadingDialog = new ReportDialog(attachActivity);
            RaffleJsPlugin.this.loadingDialog.setCancelable(false);
            if (RaffleJsPlugin.this.loadingDialog.getWindow() != null) {
                RaffleJsPlugin.this.loadingDialog.getWindow().requestFeature(1);
                RaffleJsPlugin.this.loadingDialog.getWindow().setBackgroundDrawableResource(17170445);
            }
            RaffleJsPlugin.this.loadingDialog.setContentView(LayoutInflater.from(attachActivity).inflate(R.layout.mini_sdk_full_screen_loading_bar, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
            RaffleJsPlugin.this.loadingDialog.show();
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.14.1
                @Override // java.lang.Runnable
                public void run() {
                    if (RaffleJsPlugin.this.loadingDialog != null) {
                        RaffleJsPlugin.this.loadingDialog.setCancelable(true);
                    }
                }
            }, 5000L);
        }
    };
    Runnable hideLoadingRunnable = new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.15
        @Override // java.lang.Runnable
        public void run() {
            ThreadManager.getUIHandler().removeCallbacks(RaffleJsPlugin.this.showLoadingRunnable);
            RaffleJsPlugin raffleJsPlugin = RaffleJsPlugin.this;
            raffleJsPlugin.dismissDialog(raffleJsPlugin.loadingDialog);
        }
    };
    private OnRaffleSuccessListener onRaffleSuccessListener = new a();
    private OnRaffleFailListener onRaffleFailListener = new b();

    /* loaded from: classes23.dex */
    public interface OnRaffleFailListener {
        void onAgain();

        void onClose();

        void onShare();

        void onWatchAd();
    }

    /* loaded from: classes23.dex */
    public interface OnRaffleSuccessListener {
        void onAgain();

        void onClose();

        void onCloseCancel();

        void onCloseCertain();

        void onGoBackMain();

        boolean onReceive();
    }

    /* loaded from: classes23.dex */
    class a implements OnRaffleSuccessListener {
        a() {
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener
        public void onAgain() {
            RaffleJsPlugin.this.onRaffleStateChange(RaffleJsPlugin.RAFFLE_STATE_AGAIN);
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleSuccessListener onAgain");
            RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_RAFFLE_BACK_AGAIN, RaffleJsPlugin.REPORT_ACTION_CLK);
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener
        public void onClose() {
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleSuccessListener onClose");
            RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_RAFFLE_CLOSE, RaffleJsPlugin.REPORT_ACTION_CLK);
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener
        public void onCloseCancel() {
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleSuccessListener onCloseCancel");
            RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_RAFFLE_CLOSE_CANCEL, RaffleJsPlugin.REPORT_ACTION_CLK);
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener
        public void onCloseCertain() {
            RaffleJsPlugin.this.onRaffleStateChange("close");
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleSuccessListener onCloseCertain");
            RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_RAFFLE_CLOSE_CERTAIN, RaffleJsPlugin.REPORT_ACTION_CLK);
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener
        public void onGoBackMain() {
            RaffleJsPlugin.this.onRaffleStateChange("close");
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleSuccessListener onGoBack");
            RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_RAFFLE_BACK_GAME, RaffleJsPlugin.REPORT_ACTION_CLK);
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener
        public boolean onReceive() {
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleSuccessListener onReceive");
            Activity attachActivity = ((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext.getAttachActivity();
            if (RaffleJsPlugin.this.isNoNetwork(attachActivity)) {
                QMLog.e(RaffleJsPlugin.TAG, "onRaffleSuccessListener onReceive no network");
                RaffleJsPlugin.this.showErrorToast(attachActivity, attachActivity.getResources().getString(R.string.mini_sdk_game_raffle_no_network));
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("url", RaffleJsPlugin.this.jumpUrl + RaffleJsPlugin.WEB_VIEW_PARAM);
            ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).startBrowserActivity(attachActivity, intent);
            RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_RAFFLE_OPEN, RaffleJsPlugin.REPORT_ACTION_CLK);
            return true;
        }
    }

    /* loaded from: classes23.dex */
    class b implements OnRaffleFailListener {
        b() {
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleFailListener
        public void onAgain() {
            RaffleJsPlugin.this.onRaffleStateChange(RaffleJsPlugin.RAFFLE_STATE_AGAIN);
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleFailListener onAgain");
            RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_FAIL_AGAIN, RaffleJsPlugin.REPORT_ACTION_CLK);
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleFailListener
        public void onClose() {
            RaffleJsPlugin.this.onRaffleStateChange("close");
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleFailListener onClose");
            RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_FAIL_CLOSE, RaffleJsPlugin.REPORT_ACTION_CLK);
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleFailListener
        public void onShare() {
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleFailListener onShare");
            Activity attachActivity = ((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext.getAttachActivity();
            if (RaffleJsPlugin.this.isNoNetwork(attachActivity)) {
                RaffleJsPlugin.this.showErrorToast(attachActivity, attachActivity.getResources().getString(R.string.mini_sdk_game_raffle_no_network));
                QMLog.e(RaffleJsPlugin.TAG, "onRaffleFailListener onShare no network");
            } else {
                ((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext.performAction(ShareAction.obtain(6));
                RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_FAIL_SHARE_CLICK, RaffleJsPlugin.REPORT_ACTION_CLK);
            }
        }

        @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleFailListener
        public void onWatchAd() {
            QMLog.d(RaffleJsPlugin.TAG, "onRaffleFailListener onWatchAd");
            Activity attachActivity = ((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext.getAttachActivity();
            if (RaffleJsPlugin.this.isNoNetwork(attachActivity)) {
                RaffleJsPlugin.this.showErrorToast(attachActivity, attachActivity.getResources().getString(R.string.mini_sdk_game_raffle_no_network));
                QMLog.e(RaffleJsPlugin.TAG, "onRaffleFailListener onWatchAd no network");
            } else {
                RaffleJsPlugin.this.clickRewardedAd(attachActivity);
                RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_FAIL_WATCH_AD_CLICK, RaffleJsPlugin.REPORT_ACTION_CLK);
            }
        }
    }

    /* loaded from: classes23.dex */
    public interface c {
        void onFail();

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clickRewardedAd(Context context) {
        boolean z16;
        if (!this.mIsRequestingAd && this.mRewardedVideoAd != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QMLog.d(TAG, "clickRewardedAd isValid:" + z16 + ";mIsPreloadAd:" + this.mIsPreloadAd);
        if (z16) {
            showRewardedAd(context);
        } else if (this.mIsPreloadAd) {
            showLoading();
            this.mIsPreloadAd = false;
        } else {
            showLoading();
            loadRewardedAd(context);
        }
    }

    private void createRewardVideoAdView(final Context context, final Bundle bundle) {
        QMLog.d(TAG, "createRewardVideoAdView ext:" + bundle.toString());
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.10

            /* renamed from: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin$10$a */
            /* loaded from: classes23.dex */
            class a implements AdProxy.IRewardVideoAdListener {
                a() {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADClick() {
                    QMLog.i(RaffleJsPlugin.TAG, "onADClick, time = " + System.currentTimeMillis());
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADClose(String str) {
                    QMLog.i(RaffleJsPlugin.TAG, "onADClose,  time = " + System.currentTimeMillis());
                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                    RaffleJsPlugin.this.onCloseAd(context);
                    if (((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext != null) {
                        ((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext.performAction(AudioFocusEvent.obtain(1));
                    }
                    AdFrequencyLimit.setRewardVideoAdShowing(false);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADExpose() {
                    QMLog.i(RaffleJsPlugin.TAG, "onADExpose, time = " + System.currentTimeMillis());
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADLoad(List<AdProxy.ExpParam> list) {
                    QMLog.i(RaffleJsPlugin.TAG, "onADLoad, time = " + System.currentTimeMillis());
                    RaffleJsPlugin.this.mIsRequestingAd = false;
                    if (!RaffleJsPlugin.this.mIsPreloadAd) {
                        RaffleJsPlugin.this.hideLoading();
                        AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                        RaffleJsPlugin.this.showRewardedAd(context);
                    }
                    RaffleJsPlugin.this.mIsPreloadAd = false;
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADShow() {
                    if (((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext != null) {
                        ((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext.performAction(AudioFocusEvent.obtain(2));
                    }
                    QMLog.i(RaffleJsPlugin.TAG, "onADShow, time = " + System.currentTimeMillis());
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onError(int i3, String str) {
                    QMLog.i(RaffleJsPlugin.TAG, "onError, time = " + System.currentTimeMillis() + ", errCode = " + i3 + ", errMsg = " + str);
                    RaffleJsPlugin.this.hideLoading();
                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                    RaffleJsPlugin.this.loadAdError(context);
                    RaffleJsPlugin.this.mRewardedVideoAd = null;
                    RaffleJsPlugin.this.mIsRequestingAd = false;
                    RaffleJsPlugin.this.mIsPreloadAd = false;
                    RaffleJsPlugin.this.springHbReportError(7);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onReward() {
                    QMLog.i(RaffleJsPlugin.TAG, "onReward, time = " + System.currentTimeMillis());
                    RaffleJsPlugin.this.mGetRewarded = true;
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onVideoCached() {
                    QMLog.i(RaffleJsPlugin.TAG, "onVideoCached, time = " + System.currentTimeMillis());
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onVideoComplete() {
                    QMLog.i(RaffleJsPlugin.TAG, "onVideoComplete, time = " + System.currentTimeMillis());
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
                boolean z16 = true;
                if (adProxy != null) {
                    RaffleJsPlugin raffleJsPlugin = RaffleJsPlugin.this;
                    raffleJsPlugin.mRewardedVideoAd = adProxy.createRewardVideoAdView(context, raffleJsPlugin.appid, RaffleJsPlugin.this.posId, new a(), bundle, ((BaseJsPlugin) RaffleJsPlugin.this).mMiniAppContext);
                    try {
                        if (RaffleJsPlugin.this.mRewardedVideoAd != null) {
                            RaffleJsPlugin.this.mRewardedVideoAd.loadAD(context);
                            z16 = false;
                        }
                    } catch (Exception unused) {
                    }
                }
                if (z16) {
                    RaffleJsPlugin.this.mIsRequestingAd = false;
                    RaffleJsPlugin.this.mIsPreloadAd = false;
                    RaffleJsPlugin.this.hideLoading();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog(Dialog dialog) {
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "dismissDialog exception", e16);
            }
        }
    }

    private void doGameRaffle(Context context) {
        QMLog.d(TAG, "doGameRaffle");
        showLoading();
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).doGameRaffle(this.appid, this.uin, getDoGameRaffleCallback(context));
    }

    private static void downloadImage(Context context, String str) {
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(context, str, 0, 0, null);
    }

    private void gameRaffleFail(final Context context, final boolean z16, final boolean z17) {
        QMLog.d(TAG, "gameRaffleFail");
        showLoading();
        getGameRaffleMaterial(context, new c() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.5
            @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.c
            public void onFail() {
                RaffleJsPlugin.this.hideLoading();
                RaffleJsPlugin.this.raffleFailImageLoadError(context);
                RaffleJsPlugin.this.springHbReportError(5);
            }

            @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.c
            public void onSuccess() {
                RaffleJsPlugin.this.showGameFailDialog(context, z16, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gameRaffleSuccess(final Context context, JSONObject jSONObject) {
        boolean z16;
        QMLog.d(TAG, "gameRaffleSuccess");
        boolean z17 = true;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("pack");
            this.logoUrl = jSONObject2.optString("business_name_pic");
            this.jumpUrl = jSONObject2.getString("url");
            z16 = false;
        } catch (JSONException e16) {
            QMLog.e(TAG, "gameRaffleSuccess JSONException", e16);
            z16 = true;
        }
        if (TextUtils.isEmpty(this.jumpUrl)) {
            QMLog.e(TAG, "gameRaffleSuccess jumpUrl is null");
        } else {
            z17 = z16;
        }
        if (z17) {
            hideLoading();
            showErrorToast(context, context.getResources().getString(R.string.mini_sdk_game_raffle_fail));
            onRaffleError(ERROR_REPORT_RAFFLE_FAIL);
            springHbReportError(2);
            return;
        }
        getGameRaffleMaterial(context, new c() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.3
            @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.c
            public void onFail() {
                RaffleJsPlugin.this.hideLoading();
                RaffleJsPlugin.this.raffleSuccessImageLoadError(context);
                RaffleJsPlugin.this.springHbReportError(3);
            }

            @Override // com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.c
            public void onSuccess() {
                RaffleJsPlugin.this.showGameSuccessDialog(context);
            }
        });
    }

    private AsyncResult getDoGameRaffleCallback(final Context context) {
        return new AsyncResult() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.2
            /* JADX WARN: Removed duplicated region for block: B:17:0x00ab  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x00d5  */
            /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                boolean z17;
                boolean z18;
                JSONObject jSONObject2;
                int i3;
                if (z16) {
                    z17 = false;
                    try {
                        jSONObject2 = new JSONObject(jSONObject.getString("key_result_data"));
                        QMLog.d(RaffleJsPlugin.TAG, "doGameRaffle result: " + jSONObject2.toString());
                        i3 = jSONObject2.getInt("state");
                    } catch (JSONException e16) {
                        e = e16;
                        z18 = true;
                    }
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                QMLog.e(RaffleJsPlugin.TAG, "doGameRaffle onReceiveResult out of time");
                                RaffleJsPlugin raffleJsPlugin = RaffleJsPlugin.this;
                                Context context2 = context;
                                raffleJsPlugin.showErrorToast(context2, context2.getResources().getString(R.string.mini_sdk_game_raffle_out_of_time));
                                RaffleJsPlugin.this.onRaffleError(RaffleJsPlugin.ERROR_REPORT_RAFFLE_OUT_OF_TIME);
                            }
                        } else {
                            QMLog.e(RaffleJsPlugin.TAG, "doGameRaffle onReceiveResult limited");
                            RaffleJsPlugin raffleJsPlugin2 = RaffleJsPlugin.this;
                            Context context3 = context;
                            raffleJsPlugin2.showErrorToast(context3, context3.getResources().getString(R.string.mini_sdk_game_raffle_limited));
                            RaffleJsPlugin.this.onRaffleError(RaffleJsPlugin.ERROR_REPORT_RAFFLE_LIMITED);
                        }
                    } else {
                        QMLog.d(RaffleJsPlugin.TAG, "doGameRaffle onReceiveResult success");
                        try {
                            RaffleJsPlugin.this.gameRaffleSuccess(context, jSONObject2);
                        } catch (JSONException e17) {
                            e = e17;
                            z18 = false;
                            QMLog.e(RaffleJsPlugin.TAG, "doGameRaffle onReceiveResult JSONException", e);
                            z16 = false;
                            z17 = z18;
                            if (!z16) {
                            }
                            if (z17) {
                            }
                        }
                        if (!z16) {
                            QMLog.e(RaffleJsPlugin.TAG, "doGameRaffle onReceiveResult fail");
                            RaffleJsPlugin raffleJsPlugin3 = RaffleJsPlugin.this;
                            Context context4 = context;
                            raffleJsPlugin3.showErrorToast(context4, context4.getResources().getString(R.string.mini_sdk_game_raffle_fail));
                            RaffleJsPlugin.this.onRaffleError(RaffleJsPlugin.ERROR_REPORT_RAFFLE_FAIL);
                            RaffleJsPlugin.this.springHbReportError(1);
                        }
                        if (z17) {
                            RaffleJsPlugin.this.hideLoading();
                            return;
                        }
                        return;
                    }
                }
                z17 = true;
                if (!z16) {
                }
                if (z17) {
                }
            }
        };
    }

    private void getGameRaffleMaterial(Context context, c cVar) {
        if (this.hasGetMaterial) {
            QMLog.d(TAG, "getGameRaffleMaterial hasGetMaterial");
            cVar.onSuccess();
        } else if (isAlreadyPreload(context)) {
            QMLog.d(TAG, "getGameRaffleMaterial isAlreadyPreload");
            readFromSp(context);
            cVar.onSuccess();
        } else {
            QMLog.d(TAG, "getGameRaffleMaterial new request");
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getGameRaffleMaterial(this.appid, this.uin, getGetGameRaffleMaterialCallback(context, cVar));
        }
    }

    private static void getGameRaffleMaterialStatic(final Context context, String str, String str2) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getGameRaffleMaterial(str, str2, new AsyncResult() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.7
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                QMLog.d(RaffleJsPlugin.TAG, "getGameRaffleMaterialStatic isSuc: " + z16 + ";jsonObject: " + jSONObject.toString());
                if (z16) {
                    RaffleJsPlugin.handlePreload(context, jSONObject);
                }
            }
        });
    }

    private AsyncResult getGetGameRaffleMaterialCallback(final Context context, final c cVar) {
        return new AsyncResult() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.8
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                boolean z17;
                if (z16 && RaffleJsPlugin.this.parseMaterialUrl(jSONObject)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    cVar.onSuccess();
                    RaffleJsPlugin.this.writeToSp(context);
                } else {
                    cVar.onFail();
                }
            }
        };
    }

    private int getPxFromDimen(Context context, int i3, int i16) {
        if (this.isHorizontal) {
            return context.getResources().getDimensionPixelOffset(i16);
        }
        return context.getResources().getDimensionPixelOffset(i3);
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        if (context == null) {
            QMLog.e(TAG, "getSharedPreferences context is null");
            return null;
        }
        return context.getSharedPreferences(PRELOAD_MATERIAL_SP_NAME, 4);
    }

    public static long getUpdateTime(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong("updateTime", 0L);
    }

    private Drawable getWebImage(Context context, String str, int i3) {
        int pxFromDimen;
        int pxFromDimen2;
        int i16;
        int i17;
        Drawable drawable = context.getResources().getDrawable(R.color.transparent);
        if (TextUtils.isEmpty(str)) {
            if (i3 == 2) {
                QMLog.e(TAG, "getWebImage necessary url is null");
                return null;
            }
            QMLog.d(TAG, "getWebImage other url is null");
            return drawable;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    i16 = 0;
                    i17 = 0;
                    return ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(context, str, i16, i17, drawable);
                }
                pxFromDimen = getPxFromDimen(context, R.dimen.mini_sdk_raffle_common_button_width, R.dimen.mini_sdk_raffle_landscape_common_button_width);
                pxFromDimen2 = getPxFromDimen(context, R.dimen.mini_sdk_raffle_common_button_height, R.dimen.mini_sdk_raffle_landscape_common_button_height);
            } else {
                pxFromDimen = getPxFromDimen(context, R.dimen.mini_sdk_raffle_main_image_width, R.dimen.mini_sdk_raffle_landscape_main_image_width);
                pxFromDimen2 = getPxFromDimen(context, R.dimen.mini_sdk_raffle_main_image_height, R.dimen.mini_sdk_raffle_landscape_main_image_height);
            }
        } else {
            pxFromDimen = getPxFromDimen(context, R.dimen.mini_sdk_raffle_logo_image_width, R.dimen.mini_sdk_raffle_landscape_logo_image_width);
            pxFromDimen2 = getPxFromDimen(context, R.dimen.mini_sdk_raffle_logo_image_height, R.dimen.mini_sdk_raffle_landscape_logo_image_height);
        }
        i16 = pxFromDimen;
        i17 = pxFromDimen2;
        return ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(context, str, i16, i17, drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handlePreload(Context context, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("key_result_data"));
            String optString = jSONObject2.optString("raffleImg");
            String optString2 = jSONObject2.optString("openedPackImg");
            String optString3 = jSONObject2.optString("backBtn");
            String optString4 = jSONObject2.optString("shareImg");
            String optString5 = jSONObject2.optString("shareBtn");
            String optString6 = jSONObject2.optString("wishingImg");
            String optString7 = jSONObject2.optString("watchAdBtn");
            int optInt = jSONObject2.optInt("promotion_id");
            int optInt2 = jSONObject2.optInt("active_id");
            downloadImage(context, optString);
            downloadImage(context, optString2);
            downloadImage(context, optString3);
            downloadImage(context, optString4);
            downloadImage(context, optString5);
            downloadImage(context, optString6);
            downloadImage(context, optString7);
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (sharedPreferences == null) {
                QMLog.e(TAG, "handlePreload SharedPreferences is null");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("prizeUrl", optString);
            edit.putString("receiveUrl", optString2);
            edit.putString("goBackMainButtonUrl", optString3);
            edit.putString("failUrl", optString4);
            edit.putString("shareButtonUrl", optString5);
            edit.putString("wishingImgUrl", optString6);
            edit.putString("watchAdButtonUrl", optString7);
            edit.putInt("promotionId", optInt);
            edit.putInt("activeId", optInt2);
            edit.putLong("updateTime", System.currentTimeMillis());
            edit.apply();
        } catch (Exception e16) {
            QMLog.e(TAG, "handlePreload Exception", e16);
        }
    }

    private boolean isAdInvalid(boolean z16, boolean z17, String str) {
        if (!z16 && z17 && TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    private static boolean isAlreadyPreload(Context context) {
        long updateTime = getUpdateTime(context);
        if (updateTime != 0) {
            long currentTimeMillis = (System.currentTimeMillis() - updateTime) / 1000;
            QMLog.d(TAG, "isAlreadyPreload deltaSecond = " + currentTimeMillis);
            if (currentTimeMillis > 3600) {
                return false;
            }
            return true;
        }
        QMLog.d(TAG, "isAlreadyPreload updateTime = 0");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNoNetwork(Context context) {
        if (NetworkUtil.getActiveNetworkType(context) == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdError(final Context context) {
        QMLog.e(TAG, "loadAdError mIsAlreadyFail = " + this.mIsAlreadyFail);
        if (this.mIsAlreadyFail) {
            onRaffleStateChange(RAFFLE_STATE_WATCH_AD);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.12
                @Override // java.lang.Runnable
                public void run() {
                    MiniToast.makeText(context, 0, context.getResources().getString(R.string.mini_sdk_game_raffle_fail_ad_fail_twice_auto_reward), 1).show();
                    if (RaffleJsPlugin.this.raffleFailDialog != null) {
                        RaffleJsPlugin.this.raffleFailDialog.dismiss();
                    }
                }
            });
        } else {
            this.mIsAlreadyFail = true;
            showErrorToast(context, context.getResources().getString(R.string.mini_sdk_game_raffle_fail_ad_load_fail));
        }
    }

    private void loadRewardedAd(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = TAG;
        QMLog.d(str5, "loadRewardedAd");
        if (this.mIsRequestingAd) {
            QMLog.e(str5, "loadRewardedAd is requesting Ad");
            return;
        }
        this.mRewardedVideoAd = null;
        this.mIsRequestingAd = true;
        int i3 = 0;
        this.mGetRewarded = false;
        if (this.isHorizontal) {
            i3 = 90;
        }
        String spAdGdtCookie = AdUtil.getSpAdGdtCookie(1);
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        String str6 = "";
        if (miniAppInfo == null) {
            str = "";
            str2 = str;
            str3 = str2;
        } else {
            LaunchParam launchParam = miniAppInfo.launchParam;
            str2 = launchParam.entryPath;
            if (str2 == null) {
                str2 = "";
            }
            str3 = launchParam.reportData;
            str = String.valueOf(launchParam.scene);
        }
        if (miniAppInfo != null && (str4 = miniAppInfo.via) != null) {
            str6 = str4;
        }
        Bundle bundle = new Bundle();
        bundle.putString(AdProxy.KEY_ACCOUNT, this.uin);
        bundle.putInt(AdProxy.KEY_AD_TYPE, 1);
        bundle.putInt(AdProxy.KEY_ORIENTATION, i3);
        bundle.putString(AdProxy.KEY_GDT_COOKIE, spAdGdtCookie);
        bundle.putString(AdProxy.KEY_ENTRY_PATH, str2);
        bundle.putString(AdProxy.KEY_REPORT_DATA, str3);
        bundle.putString(AdProxy.KEY_REFER, str);
        bundle.putString(AdProxy.KEY_VIA, str6);
        createRewardVideoAdView(context, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCloseAd(final Context context) {
        QMLog.d(TAG, "onCloseAd mGetRewarded = " + this.mGetRewarded);
        if (this.mGetRewarded) {
            onRaffleStateChange(RAFFLE_STATE_WATCH_AD);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.11
                @Override // java.lang.Runnable
                public void run() {
                    if (RaffleJsPlugin.this.raffleFailDialog != null) {
                        RaffleJsPlugin.this.raffleFailDialog.dismiss();
                    }
                    MiniToast.makeText(context, 2, context.getResources().getString(R.string.mini_sdk_game_raffle_fail_watch_ad_success), 1).show();
                }
            });
            springHbReport(REPORT_EVENT_NAME_FAIL_WATCH_AD_SUCCESS, "exp");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRaffleError(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", "error");
            jSONObject.put("errorMsg", str);
            QMLog.d(TAG, "onRaffleError errorMsg: " + str);
            sendSubscribeEvent(EVENT_ON_RAFFLE_STATE_CHANGE, jSONObject.toString());
        } catch (JSONException e16) {
            QMLog.e(TAG, "onRaffleError exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRaffleStateChange(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", str);
            QMLog.d(TAG, "onRaffleStateChange state: " + str);
            sendSubscribeEvent(EVENT_ON_RAFFLE_STATE_CHANGE, jSONObject.toString());
        } catch (JSONException e16) {
            QMLog.e(TAG, "onRaffleStateChange exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean parseMaterialUrl(JSONObject jSONObject) {
        QMLog.d(TAG, "getMaterialUrl jsonObject: " + jSONObject.toString());
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("key_result_data"));
            this.prizeUrl = jSONObject2.optString("raffleImg");
            this.receiveUrl = jSONObject2.optString("openedPackImg");
            this.goBackMainButtonUrl = jSONObject2.optString("backBtn");
            this.failUrl = jSONObject2.optString("shareImg");
            this.shareButtonUrl = jSONObject2.optString("shareBtn");
            this.wishingImgUrl = jSONObject2.optString("wishingImg");
            this.watchAdButtonUrl = jSONObject2.optString("watchAdBtn");
            this.promotionId = Integer.valueOf(jSONObject2.optInt("promotion_id"));
            this.activeId = Integer.valueOf(jSONObject2.optInt("active_id"));
            this.hasGetMaterial = true;
        } catch (JSONException e16) {
            QMLog.e(TAG, "getMaterialUrl JSONException", e16);
            this.hasGetMaterial = false;
        }
        return this.hasGetMaterial;
    }

    public static void preloadGameRaffleMaterial(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!isAlreadyPreload(context)) {
                getGameRaffleMaterialStatic(context, str, str2);
                return;
            }
            return;
        }
        QMLog.e(TAG, "preloadGameRaffleMaterial appid=" + str + ";uin=" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raffleFailImageLoadError(Context context) {
        QMLog.e(TAG, "raffleFailImageLoadError");
        onRaffleError("network error");
        showErrorToast(context, context.getResources().getString(R.string.mini_sdk_game_raffle_fail_image_load_fail));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raffleSuccessImageLoadError(final Context context) {
        QMLog.e(TAG, "raffleSuccessImageLoadError");
        onRaffleError("network error");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.9

            /* renamed from: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin$9$a */
            /* loaded from: classes23.dex */
            class a implements DialogInterface.OnClickListener {
                a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                DialogUtil.createCloseAlertDialog(context2, R.style.mini_sdk_QQProgressDialog, context2.getResources().getString(R.string.mini_sdk_game_raffle_success_image_load_fail), "", context.getResources().getString(R.string.mini_sdk_game_raffle_know), 100.0f, false, false, true, null, new a()).show();
            }
        });
    }

    private void readFromSp(Context context) {
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if (sharedPreferences == null) {
            QMLog.e(TAG, "readFromSp SharedPreferences is null");
            this.hasGetMaterial = false;
            return;
        }
        this.prizeUrl = sharedPreferences.getString("prizeUrl", "");
        this.receiveUrl = sharedPreferences.getString("receiveUrl", "");
        this.goBackMainButtonUrl = sharedPreferences.getString("goBackMainButtonUrl", "");
        this.failUrl = sharedPreferences.getString("failUrl", "");
        this.shareButtonUrl = sharedPreferences.getString("shareButtonUrl", "");
        this.wishingImgUrl = sharedPreferences.getString("wishingImgUrl", "");
        this.watchAdButtonUrl = sharedPreferences.getString("watchAdButtonUrl", "");
        this.promotionId = Integer.valueOf(sharedPreferences.getInt("promotionId", 0));
        this.activeId = Integer.valueOf(sharedPreferences.getInt("activeId", 0));
        this.hasGetMaterial = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorToast(final Context context, final String str) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.13
            @Override // java.lang.Runnable
            public void run() {
                MiniToast.makeText(context, 1, str, 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGameFailDialog(final Context context, final boolean z16, final boolean z17) {
        final Drawable drawable;
        final Drawable drawable2;
        QMLog.d(TAG, "showGameFailDialog");
        final Drawable webImage = getWebImage(context, this.failUrl, 2);
        if (z16) {
            drawable = getWebImage(context, this.shareButtonUrl, 3);
        } else {
            drawable = null;
        }
        if (z17) {
            drawable2 = getWebImage(context, this.watchAdButtonUrl, 3);
        } else {
            drawable2 = null;
        }
        hideLoading();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.6
            @Override // java.lang.Runnable
            public void run() {
                RaffleJsPlugin.this.raffleFailDialog = new RaffleFailDialog(context, RaffleJsPlugin.this.isHorizontal, RaffleJsPlugin.this.onRaffleFailListener);
                if (!RaffleJsPlugin.this.raffleFailDialog.setDrawable(webImage, drawable, drawable2)) {
                    RaffleJsPlugin.this.raffleFailImageLoadError(context);
                    RaffleJsPlugin.this.springHbReportError(6);
                    return;
                }
                RaffleJsPlugin.this.raffleFailDialog.setCanShare(z16);
                RaffleJsPlugin.this.raffleFailDialog.setCanWatchAd(z17);
                RaffleJsPlugin.this.raffleFailDialog.show();
                QMLog.d(RaffleJsPlugin.TAG, "showGameFailDialog show success");
                RaffleJsPlugin.this.springHbGameFailReport(z16, z17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGameSuccessDialog(final Context context) {
        QMLog.d(TAG, "showGameSuccessDialog");
        final Drawable webImage = getWebImage(context, this.logoUrl, 1);
        final Drawable webImage2 = getWebImage(context, this.wishingImgUrl, 1);
        final Drawable webImage3 = getWebImage(context, this.prizeUrl, 2);
        final Drawable webImage4 = getWebImage(context, this.receiveUrl, 2);
        final Drawable webImage5 = getWebImage(context, this.goBackMainButtonUrl, 3);
        hideLoading();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                RaffleJsPlugin.this.raffleSuccessDialog = new RaffleSuccessDialog(context, RaffleJsPlugin.this.isHorizontal, RaffleJsPlugin.this.onRaffleSuccessListener);
                if (!RaffleJsPlugin.this.raffleSuccessDialog.setDrawable(webImage, webImage2, webImage3, webImage4, webImage5)) {
                    RaffleJsPlugin.this.raffleSuccessImageLoadError(context);
                    RaffleJsPlugin.this.springHbReportError(4);
                } else {
                    RaffleJsPlugin.this.raffleSuccessDialog.show();
                    QMLog.d(RaffleJsPlugin.TAG, "showGameSuccessDialog show success");
                    RaffleJsPlugin.this.springHbReport(RaffleJsPlugin.REPORT_EVENT_NAME_RAFFLE, "exp");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showRewardedAd(Context context) {
        boolean z16;
        if (!this.mIsRequestingAd && this.mRewardedVideoAd != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QMLog.d(TAG, "showRewardedAd isValid:" + z16);
        if (z16) {
            this.mRewardedVideoAd.showAD(context, "");
            this.mRewardedVideoAd = null;
            AdFrequencyLimit.setRewardVideoAdShowing(true);
            return;
        }
        loadAdError(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void springHbGameFailReport(boolean z16, boolean z17) {
        String str;
        int i3;
        String str2 = this.appid;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        Integer num = this.activeId;
        if (num == null) {
            str = "";
        } else {
            str = num.toString();
        }
        Integer num2 = this.promotionId;
        if (num2 != null) {
            str3 = num2.toString();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", str2);
        hashMap.put("active_id", str);
        hashMap.put("jackpot_id", str3);
        hashMap.put("ext1", "1");
        if (z17) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        hashMap.put("ext2", String.valueOf((z16 ? 1 : 0) | i3));
        QMLog.d(TAG, "springHbGameFailReport \neventName:xiaoyouxi_fail \nactionType: exp \nparams: " + hashMap.toString());
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).springHbReport(REPORT_EVENT_NAME_FAIL, 0, 0, hashMap, "exp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void springHbReport(String str, String str2) {
        String str3;
        String str4 = this.appid;
        String str5 = "";
        if (str4 == null) {
            str4 = "";
        }
        Integer num = this.activeId;
        if (num == null) {
            str3 = "";
        } else {
            str3 = num.toString();
        }
        Integer num2 = this.promotionId;
        if (num2 != null) {
            str5 = num2.toString();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", str4);
        hashMap.put("active_id", str3);
        hashMap.put("jackpot_id", str5);
        hashMap.put("ext1", "1");
        QMLog.d(TAG, "springHbReport \neventName:" + str + " \nactionType: " + str2 + " \nparams: " + hashMap.toString());
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).springHbReport(str, 0, 0, hashMap, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void springHbReportError(int i3) {
        String str = this.appid;
        if (str == null) {
            str = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", str);
        hashMap.put("ext1", "1");
        hashMap.put("ext2", String.valueOf(i3));
        QMLog.d(TAG, "springHbReport \neventName:xiaoyouxi_raffle_error \nactionType: exp \nparams: " + hashMap.toString());
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).springHbReport(REPORT_EVENT_NAME_RAFFLE_ERROR, 0, 0, hashMap, "exp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToSp(Context context) {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(context);
            if (sharedPreferences == null) {
                QMLog.e(TAG, "writeToSp SharedPreferences is null");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("prizeUrl", this.prizeUrl);
            edit.putString("receiveUrl", this.receiveUrl);
            edit.putString("goBackMainButtonUrl", this.goBackMainButtonUrl);
            edit.putString("failUrl", this.failUrl);
            edit.putString("shareButtonUrl", this.shareButtonUrl);
            edit.putString("wishingImgUrl", this.wishingImgUrl);
            edit.putString("watchAdButtonUrl", this.watchAdButtonUrl);
            edit.putInt("promotionId", this.promotionId.intValue());
            edit.putInt("activeId", this.activeId.intValue());
            edit.putLong("updateTime", System.currentTimeMillis());
            edit.apply();
        } catch (Exception e16) {
            QMLog.e(TAG, "saveGetGameRaffleMaterialResult Exception", e16);
        }
    }

    public void hideLoading() {
        ThreadManager.getUIHandler().post(this.hideLoadingRunnable);
    }

    @JsEvent({EVENT_ON_SHARE_SUC_NOTICE})
    public void onRaffleShareSucNotice(RequestEvent requestEvent) {
        QMLog.d(TAG, EVENT_ON_SHARE_SUC_NOTICE);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                RaffleJsPlugin raffleJsPlugin = RaffleJsPlugin.this;
                raffleJsPlugin.dismissDialog(raffleJsPlugin.raffleFailDialog);
            }
        });
        springHbReport(REPORT_EVENT_NAME_FAIL_SHARE_SUCCESS, "exp");
    }

    public void showLoading() {
        ThreadManager.getUIHandler().postDelayed(this.showLoadingRunnable, 500L);
    }

    @JsEvent({EVENT_START_RAFFLE})
    public void startRaffle(RequestEvent requestEvent) {
        String str;
        String str2 = TAG;
        QMLog.d(str2, "startRaffle params: " + requestEvent.jsonParams);
        ApkgInfo apkgInfo = this.mApkgInfo;
        if (apkgInfo != null) {
            str = apkgInfo.appId;
        } else {
            str = null;
        }
        this.appid = str;
        this.uin = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount();
        if (!TextUtils.isEmpty(this.appid) && !TextUtils.isEmpty(this.uin)) {
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                boolean z16 = jSONObject.getBoolean("isSuccess");
                boolean optBoolean = jSONObject.optBoolean("canShare", false);
                boolean optBoolean2 = jSONObject.optBoolean("canWatchAd", false);
                String optString = jSONObject.optString("adUnitId");
                this.posId = optString;
                if (isAdInvalid(z16, optBoolean2, optString)) {
                    QMLog.e(str2, "startRaffle canWatchAd but posId is null");
                    requestEvent.fail();
                    return;
                }
                requestEvent.ok();
                Activity attachActivity = this.mMiniAppContext.getAttachActivity();
                this.isHorizontal = this.mMiniAppContext.isOrientationLandscape();
                if (isNoNetwork(attachActivity)) {
                    showErrorToast(attachActivity, attachActivity.getResources().getString(R.string.mini_sdk_game_raffle_no_network));
                    onRaffleError(ERROR_REPORT_NO_NETWORK);
                    return;
                } else {
                    if (z16) {
                        doGameRaffle(attachActivity);
                        return;
                    }
                    gameRaffleFail(attachActivity, optBoolean, optBoolean2);
                    if (optBoolean2) {
                        this.mIsAlreadyFail = false;
                        this.mIsPreloadAd = true;
                        loadRewardedAd(attachActivity);
                        return;
                    }
                    return;
                }
            } catch (JSONException e16) {
                QMLog.e(TAG, "startRaffle isSuccess is null", e16);
                requestEvent.fail();
                return;
            }
        }
        QMLog.e(str2, "startRaffle appid=" + this.appid + ";uin=" + this.uin);
        requestEvent.fail();
    }
}
