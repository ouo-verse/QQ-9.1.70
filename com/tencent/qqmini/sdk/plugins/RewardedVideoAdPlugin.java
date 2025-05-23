package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.qqmini.sdk.action.AudioFocusEvent;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class RewardedVideoAdPlugin extends BaseJsPlugin {
    public static final String EVENT_REWARDED_VIDEO_SHOW_DONE = "onRewardedVideoShowDone";
    public static final String EVENT_REWARDED_VIDEO_STATE_CHANGE = "onRewardedVideoStateChange";
    private static final String REAL_TIME_TAG = "RealTimeRewardedVideoAdPlugin";
    private static final String TAG = "RewardedVideoAdPlugin";
    private static final HashMap<Integer, String> errCodeMsgMap = MiniSDKConst.AdConst.CODE_MSG_MAP;
    private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
    private String mPosID = "";
    private boolean mIsOrientationLandscape = false;
    private volatile boolean mIsRequestingAd = false;
    private boolean mGetRewarded = false;
    private boolean mHasShowGPToast = false;
    private boolean mHasClosedAd = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$appid;
        final /* synthetic */ String val$compId;
        final /* synthetic */ Context val$context;
        final /* synthetic */ Bundle val$ext;
        final /* synthetic */ String val$posId;
        final /* synthetic */ RequestEvent val$req;
        final /* synthetic */ boolean val$showAdAfterLoad;

        AnonymousClass1(Context context, String str, String str2, boolean z16, RequestEvent requestEvent, String str3, Bundle bundle) {
            this.val$context = context;
            this.val$appid = str;
            this.val$posId = str2;
            this.val$showAdAfterLoad = z16;
            this.val$req = requestEvent;
            this.val$compId = str3;
            this.val$ext = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
            if (adProxy == null) {
                RewardedVideoAdPlugin.this.mIsRequestingAd = false;
                return;
            }
            final AdProxy.AbsRewardVideoAdView absRewardVideoAdView = RewardedVideoAdPlugin.this.mRewardedVideoAd;
            final WeakReference weakReference = new WeakReference(this.val$context);
            RewardedVideoAdPlugin.this.mRewardedVideoAd = adProxy.createRewardVideoAdView(this.val$context, this.val$appid, this.val$posId, new AdProxy.IRewardVideoAdListener() { // from class: com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.1.1
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADClick() {
                    QMLog.i(RewardedVideoAdPlugin.TAG, "onADClick, time = " + System.currentTimeMillis());
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADClose(final String str) {
                    RewardedVideoAdPlugin.this.mRewardedVideoAd = null;
                    QMLog.i(RewardedVideoAdPlugin.TAG, "onADClose,  time = " + System.currentTimeMillis());
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    RewardedVideoAdPlugin.this.onCloseAd(anonymousClass1.val$req, str);
                    ThreadManager.executeOnComputationThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QMLog.i("RealTimeRewardedVideoAdPlugin", "onADClose \u5173\u95ed\u5e7f\u544a\u540e\u91cd\u65b0\u62c9\u53d6");
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            RewardedVideoAdPlugin.this.initAdParam(anonymousClass12.val$req, anonymousClass12.val$posId, str, false);
                        }
                    });
                    if (((BaseJsPlugin) RewardedVideoAdPlugin.this).mMiniAppContext != null) {
                        ((BaseJsPlugin) RewardedVideoAdPlugin.this).mMiniAppContext.performAction(AudioFocusEvent.obtain(1));
                    }
                    AdFrequencyLimit.setRewardVideoAdShowing(false);
                    RewardedVideoAdPlugin.this.mHasClosedAd = true;
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADExpose() {
                    QMLog.i(RewardedVideoAdPlugin.TAG, "onADExpose, time = " + System.currentTimeMillis());
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADLoad(List<AdProxy.ExpParam> list) {
                    QMLog.i("RealTimeRewardedVideoAdPlugin", "onADLoad, time = " + System.currentTimeMillis() + " showAdAfterLoad:" + AnonymousClass1.this.val$showAdAfterLoad);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    RewardedVideoAdPlugin.this.handleOnLoadAndInformJs(anonymousClass1.val$req, true, anonymousClass1.val$compId);
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                    RewardedVideoAdPlugin.this.handleLoadAndInformJs(anonymousClass12.val$req, true, anonymousClass12.val$compId);
                    AnonymousClass1.this.val$req.ok();
                    RewardedVideoAdPlugin.this.mIsRequestingAd = false;
                    if (weakReference.get() != null) {
                        RewardedVideoAdPlugin rewardedVideoAdPlugin = RewardedVideoAdPlugin.this;
                        Context context = (Context) weakReference.get();
                        AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                        rewardedVideoAdPlugin.handleInterval(context, anonymousClass13.val$req, anonymousClass13.val$compId, anonymousClass13.val$showAdAfterLoad, list);
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onADShow() {
                    if (((BaseJsPlugin) RewardedVideoAdPlugin.this).mMiniAppContext != null) {
                        ((BaseJsPlugin) RewardedVideoAdPlugin.this).mMiniAppContext.performAction(AudioFocusEvent.obtain(2));
                    }
                    QMLog.i(RewardedVideoAdPlugin.TAG, "onADShow, time = " + System.currentTimeMillis());
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onError(int i3, String str) {
                    QMLog.i(RewardedVideoAdPlugin.TAG, "onError, time = " + System.currentTimeMillis() + ", errCode = " + i3 + ", errMsg = " + str + " showAdAfterLoad\uff1a" + AnonymousClass1.this.val$showAdAfterLoad);
                    if (AnonymousClass1.this.val$showAdAfterLoad && weakReference.get() != null) {
                        QMLog.i("RealTimeRewardedVideoAdPlugin", "showAdAfterLoad \u5b9e\u65f6load\u7684\u5e7f\u544a\u62c9\u53d6\u5931\u8d25\u4e86 \u5c55\u793a\u4e4b\u524d\u7684\u5e7f\u544a");
                        RewardedVideoAdPlugin rewardedVideoAdPlugin = RewardedVideoAdPlugin.this;
                        AdProxy.AbsRewardVideoAdView absRewardVideoAdView2 = absRewardVideoAdView;
                        Context context = (Context) weakReference.get();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        rewardedVideoAdPlugin.handleLoadAndShow(absRewardVideoAdView2, context, anonymousClass1.val$req, anonymousClass1.val$compId);
                        return;
                    }
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                    RewardedVideoAdPlugin.this.handleErrorAndInformJs(anonymousClass12.val$req, i3, anonymousClass12.val$compId);
                    RewardedVideoAdPlugin.this.mIsRequestingAd = false;
                    RewardedVideoAdPlugin.this.mRewardedVideoAd = null;
                    RewardedVideoAdPlugin.this.mHasClosedAd = true;
                    RewardedVideoAdPlugin.this.handleGooglePlay();
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onReward() {
                    QMLog.i(RewardedVideoAdPlugin.TAG, "onReward, time = " + System.currentTimeMillis());
                    RewardedVideoAdPlugin.this.mGetRewarded = true;
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onVideoCached() {
                    QMLog.i(RewardedVideoAdPlugin.TAG, "onVideoCached, time = " + System.currentTimeMillis());
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IRewardVideoAdListener
                public void onVideoComplete() {
                    QMLog.i(RewardedVideoAdPlugin.TAG, "onVideoComplete, time = " + System.currentTimeMillis());
                }
            }, this.val$ext, ((BaseJsPlugin) RewardedVideoAdPlugin.this).mMiniAppContext);
            try {
                if (RewardedVideoAdPlugin.this.mRewardedVideoAd == null || weakReference.get() == null) {
                    RewardedVideoAdPlugin.this.mIsRequestingAd = false;
                } else {
                    RewardedVideoAdPlugin.this.mRewardedVideoAd.loadAD((Context) weakReference.get());
                }
            } catch (Exception unused) {
                RewardedVideoAdPlugin.this.mIsRequestingAd = false;
            }
        }
    }

    private void createRewardVideoAdView(RequestEvent requestEvent, String str, String str2, String str3, Context context, Bundle bundle, boolean z16) {
        AppBrandTask.runTaskOnUiThread(new AnonymousClass1(context, str3, str, z16, requestEvent, str2, bundle));
    }

    private void doCreateRewardVideoAdView(RequestEvent requestEvent, String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6, String str7, String str8, String str9, boolean z16) {
        Context attachActivity = this.mMiniAppContext.getAttachActivity() != null ? this.mMiniAppContext.getAttachActivity() : MiniAppEnv.g().getContext();
        if (attachActivity != null) {
            Bundle bundle = new Bundle();
            bundle.putString(AdProxy.KEY_ACCOUNT, str3);
            bundle.putInt(AdProxy.KEY_AD_TYPE, i16);
            bundle.putInt(AdProxy.KEY_ORIENTATION, i3);
            bundle.putString(AdProxy.KEY_GDT_COOKIE, str5);
            bundle.putString(AdProxy.KEY_ENTRY_PATH, str6);
            bundle.putString(AdProxy.KEY_REPORT_DATA, str7);
            bundle.putString(AdProxy.KEY_REFER, str8);
            bundle.putString(AdProxy.KEY_VIA, str9);
            createRewardVideoAdView(requestEvent, str, str2, str4, attachActivity, bundle, z16);
            return;
        }
        QMLog.e(TAG, "context is null");
    }

    private int getAdType(int i3) {
        if (i3 == 0) {
            return 3;
        }
        return 1;
    }

    private int getMiniType() {
        if (this.mMiniAppInfo.isEngineTypeMiniApp()) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleErrorAndInformJs(RequestEvent requestEvent, int i3, String str) {
        String str2 = errCodeMsgMap.get(Integer.valueOf(i3));
        QMLog.d(TAG, "handleErrorAndInformJs errCode= " + i3 + " errMsg=" + str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", "error");
            jSONObject.put("errMsg", str2);
            jSONObject.put("errCode", i3);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("compId", str);
            }
            informJs(requestEvent, jSONObject, EVENT_REWARDED_VIDEO_STATE_CHANGE);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleGetAdFailed(RequestEvent requestEvent, int i3, String str) {
        handleErrorAndInformJs(requestEvent, i3, str);
        handleShowAndInformJs(requestEvent, false, str);
        handleLoadAndInformJs(requestEvent, false, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGooglePlay() {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null && channelProxy.isGooglePlayVersion()) {
            boolean z16 = false;
            if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_ad_switch", 0) == 1) {
                z16 = true;
            }
            if (!z16 && !this.mHasShowGPToast) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniToast.makeText(((BaseJsPlugin) RewardedVideoAdPlugin.this).mContext, "\u5f53\u524d\u7248\u672c\u6682\u4e0d\u652f\u6301\u89c2\u770b\u5e7f\u544a", 0).show();
                    }
                });
                this.mHasShowGPToast = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInterval(Context context, RequestEvent requestEvent, String str, boolean z16, List<AdProxy.ExpParam> list) {
        AdProxy.AbsRewardVideoAdView absRewardVideoAdView = this.mRewardedVideoAd;
        if (absRewardVideoAdView != null) {
            absRewardVideoAdView.loadTime = System.currentTimeMillis() / 1000;
            this.mRewardedVideoAd.loadInterval = AdUtil.getLoadIntervalFromExpParam(list);
            if (z16) {
                QMLog.i("RealTimeRewardedVideoAdPlugin", "showAdAfterLoad \u5c55\u793a\u5b9e\u65bd\u62c9\u53d6\u7684\u65b0\u5e7f\u544a");
                handleLoadAndShow(this.mRewardedVideoAd, context, requestEvent, str);
            }
        }
    }

    private void handleLoad(RequestEvent requestEvent, String str) {
        String str2;
        if (this.mRewardedVideoAd != null && !this.mIsRequestingAd && !this.mRewardedVideoAd.needToLoadNewAd()) {
            QMLog.i("RealTimeRewardedVideoAdPlugin", "operateRewardedAd load \u62c9\u53d6\u5e7f\u544a\u4fe1\u606f \u6709\u73b0\u6210\u7684\u5e7f\u544a\u4e14\u6ca1\u6709\u8d85\u8fc7\u65f6\u95f4\u9650\u5236");
            handleLoadAndInformJs(requestEvent, true, str);
            return;
        }
        if (!this.mIsRequestingAd) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("operateRewardedAd load \u62c9\u53d6\u5e7f\u544a\u4fe1\u606f,");
            if (this.mRewardedVideoAd == null) {
                str2 = "AdView is null";
            } else {
                str2 = "\u662f\u5426\u56e0\u4e3a\u5e7f\u544a\u8fc7\u671f\uff1a" + this.mRewardedVideoAd.needToLoadNewAd();
            }
            sb5.append(str2);
            QMLog.i("RealTimeRewardedVideoAdPlugin", sb5.toString());
            initAdParam(requestEvent, this.mPosID, str, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadAndInformJs(final RequestEvent requestEvent, final boolean z16, final String str) {
        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", "load");
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("compId", str);
                    }
                    if (z16) {
                        str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                    } else {
                        str2 = "error";
                    }
                    jSONObject.put("status", str2);
                    RewardedVideoAdPlugin.this.informJs(requestEvent, jSONObject, RewardedVideoAdPlugin.EVENT_REWARDED_VIDEO_SHOW_DONE);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLoadAndShow(AdProxy.AbsRewardVideoAdView absRewardVideoAdView, Context context, RequestEvent requestEvent, String str) {
        boolean isRewardedAdValid = isRewardedAdValid(absRewardVideoAdView);
        QMLog.i("RealTimeRewardedVideoAdPlugin", "handleLoadAndShow isRewardedAdValid:" + isRewardedAdValid);
        if (isRewardedAdValid) {
            absRewardVideoAdView.showAD(context, str);
            handleShowAndInformJs(requestEvent, true, str);
            this.mRewardedVideoAd = null;
            this.mHasClosedAd = false;
            AdFrequencyLimit.setRewardVideoAdShowing(true);
            return;
        }
        handleShowAndInformJs(requestEvent, false, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnLoadAndInformJs(RequestEvent requestEvent, boolean z16, String str) {
        String str2;
        QMLog.d(TAG, "handleOnLoadAndInformJs isSucc= " + z16);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", "load");
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("compId", str);
            }
            if (z16) {
                str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            } else {
                str2 = "error";
            }
            jSONObject.put("status", str2);
            informJs(requestEvent, jSONObject, EVENT_REWARDED_VIDEO_STATE_CHANGE);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleShow(RequestEvent requestEvent, String str) {
        Activity activity;
        if (isRewardedAdValid(this.mRewardedVideoAd)) {
            QMLog.i("RealTimeRewardedVideoAdPlugin", "operateRewardedAd show \u7acb\u5373\u5c55\u793a");
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext != null) {
                activity = iMiniAppContext.getAttachActivity();
            } else {
                activity = null;
            }
            this.mRewardedVideoAd.showAD(activity, str);
            handleShowAndInformJs(requestEvent, true, str);
            this.mRewardedVideoAd = null;
            this.mHasClosedAd = false;
            AdFrequencyLimit.setRewardVideoAdShowing(true);
            return;
        }
        AdProxy.AbsRewardVideoAdView absRewardVideoAdView = this.mRewardedVideoAd;
        if (absRewardVideoAdView != null && absRewardVideoAdView.needToLoadNewAd()) {
            QMLog.i("RealTimeRewardedVideoAdPlugin", "operateRewardedAd show \u62c9\u53d6\u5e7f\u544a\u4fe1\u606f \u662f\u5426\u56e0\u4e3a\u5e7f\u544a\u8fc7\u671f\uff1atrue \u671f\u671b\u62c9\u53d6\u540e\u7acb\u5373\u5c55\u793a");
            initAdParam(requestEvent, this.mPosID, str, true);
        } else {
            handleShowAndInformJs(requestEvent, false, str);
        }
    }

    private void handleShowAndInformJs(final RequestEvent requestEvent, final boolean z16, final String str) {
        AppBrandTask.runTaskOnUiThreadDelay(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin.4
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", "show");
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("compId", str);
                    }
                    if (z16) {
                        str2 = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                    } else {
                        str2 = "error";
                    }
                    jSONObject.put("status", str2);
                    RewardedVideoAdPlugin.this.informJs(requestEvent, jSONObject, RewardedVideoAdPlugin.EVENT_REWARDED_VIDEO_SHOW_DONE);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void informJs(RequestEvent requestEvent, JSONObject jSONObject, String str) {
        QMLog.d(TAG, "informJs d= " + String.valueOf(jSONObject) + " event=" + str);
        requestEvent.jsService.evaluateSubscribeJS(str, jSONObject.toString(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAdParam(RequestEvent requestEvent, String str, String str2, boolean z16) {
        int i3;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        LaunchParam launchParam;
        this.mIsRequestingAd = true;
        String account = LoginManager.getInstance().getAccount();
        String str8 = this.mApkgInfo.appId;
        if (this.mIsOrientationLandscape) {
            i3 = 90;
        } else {
            i3 = 0;
        }
        int i16 = i3;
        QMLog.i(TAG, "handle initAdParam appId = " + str8 + "\uff0c deviceOrient = " + i16 + " showAdAfterLoad:" + z16);
        if (!TextUtils.isEmpty(str8) && !TextUtils.isEmpty(str)) {
            int adType = getAdType(getMiniType());
            String spAdGdtCookie = AdUtil.getSpAdGdtCookie(adType);
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) {
                str3 = "";
                str4 = str3;
                str5 = str4;
            } else {
                str3 = launchParam.entryPath;
                if (str3 == null) {
                    str3 = "";
                }
                if (launchParam == null) {
                    str4 = "";
                } else {
                    str4 = launchParam.reportData;
                }
                str5 = String.valueOf(launchParam.scene);
            }
            if (miniAppInfo == null || (str7 = miniAppInfo.via) == null) {
                str6 = "";
            } else {
                str6 = str7;
            }
            QMLog.i(TAG, "getRewardedVideoADInfo account= " + account + " pos_id=" + str);
            doCreateRewardVideoAdView(requestEvent, str, str2, account, str8, i16, adType, spAdGdtCookie, str3, str4, str5, str6, z16);
            return;
        }
        QMLog.e(TAG, "appid or pos_id is empty");
        handleGetAdFailed(requestEvent, 1003, str2);
    }

    private boolean isRewardedAdValid(AdProxy.AbsRewardVideoAdView absRewardVideoAdView) {
        if (!this.mIsRequestingAd && absRewardVideoAdView != null && !absRewardVideoAdView.needToLoadNewAd() && this.mHasClosedAd) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCloseAd(RequestEvent requestEvent, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", "close");
            jSONObject.put("isEnded", this.mGetRewarded);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("compId", str);
            }
            informJs(requestEvent, jSONObject, EVENT_REWARDED_VIDEO_STATE_CHANGE);
            this.mGetRewarded = false;
        } catch (JSONException e16) {
            QMLog.e(TAG, "doOnActivityResult failed e:", e16);
            handleErrorAndInformJs(requestEvent, 1003, str);
        }
    }

    @JsEvent({PluginConst.OuterJsPluginConst.API_AD_CREATE_REWARDED_VIDEO_AD})
    public String createRewardedVideoAd(RequestEvent requestEvent) {
        boolean z16;
        String str;
        String str2;
        boolean z17 = true;
        if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsOrientationLandscape = z16;
        AdProxy.AbsRewardVideoAdView absRewardVideoAdView = this.mRewardedVideoAd;
        if (absRewardVideoAdView == null || absRewardVideoAdView.needToLoadNewAd()) {
            try {
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                String optString = jSONObject.optString("adUnitId");
                String optString2 = jSONObject.optString("compId");
                if (TextUtils.isEmpty(optString)) {
                    handleErrorAndInformJs(requestEvent, 1002, optString2);
                    JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, null);
                    if (wrapCallbackFail == null) {
                        str2 = "";
                    } else {
                        str2 = wrapCallbackFail.toString();
                    }
                    requestEvent.fail(wrapCallbackFail.toString());
                    if (str2 != null) {
                        return str2;
                    }
                }
                this.mPosID = optString;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("createRewardedVideoAd \u62c9\u53d6\u5e7f\u544a\u4fe1\u606f \u662f\u5426\u56e0\u4e3a\u5e7f\u544a\u8fc7\u671f\uff1a");
                if (this.mRewardedVideoAd == null) {
                    z17 = false;
                }
                sb5.append(z17);
                QMLog.i("RealTimeRewardedVideoAdPlugin", sb5.toString());
                initAdParam(requestEvent, this.mPosID, optString2, false);
            } catch (Exception e16) {
                QMLog.e(TAG, "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", e16);
                JSONObject wrapCallbackFail2 = ApiUtil.wrapCallbackFail(requestEvent.event, null);
                if (wrapCallbackFail2 == null) {
                    str = "";
                } else {
                    str = wrapCallbackFail2.toString();
                }
                handleErrorAndInformJs(requestEvent, 1003, "");
                requestEvent.fail(wrapCallbackFail2.toString());
                if (str != null) {
                    return str;
                }
            }
        }
        return "";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        IMiniAppContext iMiniAppContext;
        AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
        if (adProxy != null && (iMiniAppContext = this.mMiniAppContext) != null && iMiniAppContext.getAttachActivity() != null) {
            adProxy.destroy(this.mMiniAppContext.getAttachActivity());
        }
        super.onDestroy();
    }

    @JsEvent({PluginConst.OuterJsPluginConst.API_AD_OPERATE_REWARDED_VIDEO_AD})
    public void operateRewardedAd(RequestEvent requestEvent) {
        boolean z16;
        if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsOrientationLandscape = z16;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            requestEvent.ok();
            String optString = jSONObject.optString("type");
            String optString2 = jSONObject.optString("compId");
            if ("load".equals(optString)) {
                handleLoad(requestEvent, optString2);
            } else if ("show".equals(optString)) {
                handleShow(requestEvent, optString2);
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", e16);
            handleErrorAndInformJs(requestEvent, 1003, "");
            requestEvent.fail();
        }
    }
}
