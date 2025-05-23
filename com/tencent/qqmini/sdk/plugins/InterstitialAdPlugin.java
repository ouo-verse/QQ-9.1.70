package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class InterstitialAdPlugin extends BaseJsPlugin {
    public static final String API_OPERATE_DESTROY = "destroy";
    public static final String API_OPERATE_INTERSTITIAL_AD = "operateInterstitialAd";
    public static final String API_OPERATE_LOAD = "load";
    public static final String API_OPERATE_SHOW = "show";
    private static final String ERRCODE = "errCode";
    private static final String ERRMSG = "errMsg";
    public static final String EVENT_INTERSTITIAL_CLOSE = "onInterstitialAdClose";
    public static final String KEY_REF_ID = "biz_src_miniapp";
    public static final HashMap<Integer, String> S_CODE_MSG_MAP = MiniSDKConst.AdConst.CODE_MSG_MAP;
    private static final String TAG = "InterstitialAdPlugin";
    private Map<Integer, MiniInterstitialAd> mInterstitialMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class MiniInterstitialAd {
        private static final String ADUNIT_ID = "adUnitId";
        private static final String APP_Interstitial_ID = "id";
        private static final String COMP_ID = "compId";
        private static final String OPERATION_TYPE = "type";
        private static final String TAG = "SDK_MiniInterstitialAd";
        private AdProxy.AbsInterstitialAdView adInterstitial;
        private String adUnitId;
        private String appId;
        private int appInterstitialId;
        private WeakReference<Activity> mActivity;
        private volatile boolean mIsRequestingAd = false;
        private IJsService mJsService;
        private AdProxy.InterstitialADLisener mListener;

        MiniInterstitialAd(Activity activity, int i3, String str, String str2, IJsService iJsService) {
            this.mActivity = new WeakReference<>(activity);
            this.appInterstitialId = i3;
            this.adUnitId = str;
            this.appId = str2;
            this.mJsService = iJsService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callbackJs(boolean z16, String str, int i3, int i16, int i17) {
            JSONObject wrapCallbackFail;
            if (this.mJsService != null) {
                if (z16) {
                    wrapCallbackFail = ApiUtil.wrapCallbackOk(str, getResultObj(i3, i16));
                } else {
                    wrapCallbackFail = ApiUtil.wrapCallbackFail(str, getResultObj(i3, i16), InterstitialAdPlugin.S_CODE_MSG_MAP.get(Integer.valueOf(i16)));
                }
                String jSONObject = wrapCallbackFail.toString();
                QMLog.i(TAG, "evaluateCallbackJs callbackId: " + i17 + " content:" + jSONObject);
                this.mJsService.evaluateCallbackJs(i17, jSONObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject getResultObj(int i3, int i16) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.appInterstitialId);
                jSONObject.put(COMP_ID, i3);
                jSONObject.put(ADUNIT_ID, this.adUnitId);
                jSONObject.put("errCode", i16);
                return jSONObject;
            } catch (Throwable th5) {
                try {
                    QMLog.e(TAG, "getResultObj e:", th5);
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        }

        private boolean initAdParam(final int i3, final int i16) {
            boolean z16;
            int i17;
            String str;
            String str2;
            String str3;
            Activity activity;
            String str4;
            LaunchParam launchParam;
            String account = LoginManager.getInstance().getAccount();
            if (TextUtils.isEmpty(this.appId)) {
                QMLog.e(TAG, "TextUtils.isEmpty(appid)");
                return false;
            }
            if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i17 = 90;
            } else {
                i17 = 0;
            }
            QMLog.i(TAG, "handle initAdParam appId = " + this.appId + "\uff0c deviceOrient = " + i17);
            int adType = InterstitialAdPlugin.this.getAdType();
            MiniAppInfo miniAppInfo = ((BaseJsPlugin) InterstitialAdPlugin.this).mMiniAppInfo;
            String str5 = "";
            if (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) {
                str = "";
                str2 = str;
                str3 = str2;
            } else {
                str2 = launchParam.entryPath;
                if (str2 == null) {
                    str2 = "";
                }
                str3 = launchParam.reportData;
                str = String.valueOf(launchParam.scene);
            }
            if (miniAppInfo != null && (str4 = miniAppInfo.via) != null) {
                str5 = str4;
            }
            String spAdGdtCookie = AdUtil.getSpAdGdtCookie(adType);
            WnsConfig.getConfig("QZoneSetting", "MiniGameShareRate", 53);
            WeakReference<Activity> weakReference = this.mActivity;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            Activity activity2 = activity;
            if (activity2 == null) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString(AdProxy.KEY_ACCOUNT, account);
            bundle.putInt(AdProxy.KEY_AD_TYPE, adType);
            bundle.putInt(AdProxy.KEY_ORIENTATION, i17);
            bundle.putString(AdProxy.KEY_GDT_COOKIE, spAdGdtCookie);
            bundle.putString(AdProxy.KEY_ENTRY_PATH, str2);
            bundle.putString(AdProxy.KEY_REPORT_DATA, str3);
            bundle.putString(AdProxy.KEY_REFER, str);
            bundle.putString(AdProxy.KEY_VIA, str5);
            this.mListener = new AdProxy.InterstitialADLisener() { // from class: com.tencent.qqmini.sdk.plugins.InterstitialAdPlugin.MiniInterstitialAd.2
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener
                public void onDismiss() {
                    QMLog.i(MiniInterstitialAd.TAG, "onDismiss");
                    if (MiniInterstitialAd.this.mJsService != null) {
                        MiniInterstitialAd.this.mJsService.evaluateSubscribeJS(InterstitialAdPlugin.EVENT_INTERSTITIAL_CLOSE, MiniInterstitialAd.this.getResultObj(i3, -1).toString(), 0);
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener
                public void onError(int i18, String str6) {
                    QMLog.i(MiniInterstitialAd.TAG, "onError, errCode = " + i18 + ", errMsg = " + str6);
                    MiniInterstitialAd.this.callbackJs(false, InterstitialAdPlugin.API_OPERATE_INTERSTITIAL_AD, i3, i18, i16);
                    MiniInterstitialAd.this.mIsRequestingAd = false;
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener
                public void onLoad() {
                    QMLog.i(MiniInterstitialAd.TAG, "onLoad");
                    MiniInterstitialAd.this.callbackJs(true, InterstitialAdPlugin.API_OPERATE_INTERSTITIAL_AD, i3, 0, i16);
                    MiniInterstitialAd.this.mIsRequestingAd = false;
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener
                public void onShow() {
                    QMLog.i(MiniInterstitialAd.TAG, "onShow");
                }
            };
            AdProxy.AbsInterstitialAdView createInterstitialAdView = ((AdProxy) ProxyManager.get(AdProxy.class)).createInterstitialAdView(activity2, this.appId, this.adUnitId, this.mListener, bundle, ((BaseJsPlugin) InterstitialAdPlugin.this).mMiniAppContext);
            this.adInterstitial = createInterstitialAdView;
            if (createInterstitialAdView != null) {
                createInterstitialAdView.loadAD();
            }
            return true;
        }

        boolean destroy() {
            AdProxy.AbsInterstitialAdView absInterstitialAdView = this.adInterstitial;
            if (absInterstitialAdView != null) {
                absInterstitialAdView.destroy();
                this.adInterstitial = null;
            }
            this.mListener = null;
            return true;
        }

        boolean load(int i3, int i16) {
            if (this.mIsRequestingAd) {
                return true;
            }
            this.mIsRequestingAd = true;
            return initAdParam(i3, i16);
        }

        void setActivity(Activity activity) {
            this.mActivity = new WeakReference<>(activity);
        }

        void setJsService(IJsService iJsService) {
            this.mJsService = iJsService;
        }

        boolean show(final int i3, final int i16) {
            WeakReference<Activity> weakReference;
            if (this.adInterstitial != null && (weakReference = this.mActivity) != null && weakReference.get() != null) {
                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.InterstitialAdPlugin.MiniInterstitialAd.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity activity;
                        try {
                            if (MiniInterstitialAd.this.mActivity != null) {
                                activity = (Activity) MiniInterstitialAd.this.mActivity.get();
                            } else {
                                activity = null;
                            }
                            if (activity != null && MiniInterstitialAd.this.adInterstitial.show(activity)) {
                                MiniInterstitialAd.this.callbackJs(true, InterstitialAdPlugin.API_OPERATE_INTERSTITIAL_AD, i3, 0, i16);
                                ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.sdk.plugins.InterstitialAdPlugin.MiniInterstitialAd.1.1
                                    @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
                                    public boolean doOnActivityResult(int i17, int i18, Intent intent) {
                                        String str;
                                        Activity activity2;
                                        if (i17 != 10001) {
                                            return false;
                                        }
                                        AdFrequencyLimit.setInterstitialAdShowing(false);
                                        if (i18 == -1) {
                                            str = "on closed";
                                        } else {
                                            str = "on closed error";
                                        }
                                        if (MiniInterstitialAd.this.mListener != null) {
                                            MiniInterstitialAd.this.mListener.onDismiss();
                                        }
                                        ActivityResultManager.g().removeActivityResultListener(this);
                                        if (MiniInterstitialAd.this.mActivity != null) {
                                            activity2 = (Activity) MiniInterstitialAd.this.mActivity.get();
                                        } else {
                                            activity2 = null;
                                        }
                                        if (MiniInterstitialAd.this.adInterstitial != null) {
                                            MiniInterstitialAd.this.adInterstitial.onClose(activity2, i18, intent);
                                        }
                                        QMLog.i(MiniInterstitialAd.TAG, str);
                                        return true;
                                    }
                                });
                                AdFrequencyLimit.setInterstitialAdShowing(true);
                            } else {
                                QMLog.e(MiniInterstitialAd.TAG, "activity is null");
                                MiniInterstitialAd.this.callbackJs(false, InterstitialAdPlugin.API_OPERATE_INTERSTITIAL_AD, i3, 1003, i16);
                            }
                        } catch (Throwable th5) {
                            QMLog.e(MiniInterstitialAd.TAG, "adInterstitial show Exception:", th5);
                            MiniInterstitialAd.this.callbackJs(false, InterstitialAdPlugin.API_OPERATE_INTERSTITIAL_AD, i3, 1003, i16);
                        }
                    }
                });
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAdType() {
        boolean z16;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniApp()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return 10;
        }
        return 11;
    }

    static boolean isAdUnitIdValid(String str) {
        return !TextUtils.isEmpty(str);
    }

    MiniInterstitialAd getMiniInterstitialAd(int i3, String str, RequestEvent requestEvent) {
        String str2;
        Activity activity;
        MiniInterstitialAd miniInterstitialAd;
        ApkgInfo apkgInfo;
        Activity activity2 = null;
        if (this.mInterstitialMap.containsKey(Integer.valueOf(i3))) {
            miniInterstitialAd = this.mInterstitialMap.get(Integer.valueOf(i3));
        } else {
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext != null && (apkgInfo = this.mApkgInfo) != null) {
                str2 = apkgInfo.appId;
            } else {
                str2 = "";
            }
            String str3 = str2;
            if (iMiniAppContext != null) {
                activity = iMiniAppContext.getAttachActivity();
            } else {
                activity = null;
            }
            MiniInterstitialAd miniInterstitialAd2 = new MiniInterstitialAd(activity, i3, str, str3, requestEvent.jsService);
            this.mInterstitialMap.put(Integer.valueOf(i3), miniInterstitialAd2);
            miniInterstitialAd = miniInterstitialAd2;
        }
        if (miniInterstitialAd != null) {
            IMiniAppContext iMiniAppContext2 = this.mMiniAppContext;
            if (iMiniAppContext2 != null) {
                activity2 = iMiniAppContext2.getAttachActivity();
            }
            miniInterstitialAd.setJsService(requestEvent.jsService);
            miniInterstitialAd.setActivity(activity2);
        }
        return miniInterstitialAd;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        Iterator<Map.Entry<Integer, MiniInterstitialAd>> it = this.mInterstitialMap.entrySet().iterator();
        while (it.hasNext()) {
            MiniInterstitialAd value = it.next().getValue();
            if (value != null) {
                value.destroy();
            }
        }
    }

    @JsEvent({API_OPERATE_INTERSTITIAL_AD})
    public String operateInterstitialAd(RequestEvent requestEvent) {
        JSONObject put;
        try {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "operateInterstitialAd, jsonParams = " + requestEvent.jsonParams);
            }
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int optInt = jSONObject.optInt("id", -1);
            String optString = jSONObject.optString("adUnitId", null);
            if (!isAdUnitIdValid(optString)) {
                JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject);
                wrapCallbackFail.put("errCode", 1002);
                String jSONObject2 = wrapCallbackFail.toString();
                requestEvent.fail(wrapCallbackFail, MiniSDKConst.AdConst.ERROR_MSG_INVALID_ADUNITID);
                return jSONObject2;
            }
            MiniInterstitialAd miniInterstitialAd = getMiniInterstitialAd(optInt, optString, requestEvent);
            String optString2 = jSONObject.optString("type");
            int optInt2 = jSONObject.optInt("compId", -1);
            if ("load".equals(optString2)) {
                if (!miniInterstitialAd.load(optInt2, requestEvent.callbackId)) {
                    JSONObject wrapCallbackFail2 = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject);
                    wrapCallbackFail2.put("errCode", 1003);
                    requestEvent.fail(wrapCallbackFail2, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
                    return "";
                }
                return "";
            }
            if ("show".equals(optString2)) {
                int canShowInterstitialAdNow = AdFrequencyLimit.canShowInterstitialAdNow();
                if (canShowInterstitialAdNow != 0) {
                    JSONObject wrapCallbackFail3 = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject);
                    wrapCallbackFail3.put("errCode", canShowInterstitialAdNow);
                    requestEvent.fail(wrapCallbackFail3, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
                    return wrapCallbackFail3.toString();
                }
                if (!miniInterstitialAd.show(optInt2, requestEvent.callbackId)) {
                    JSONObject wrapCallbackFail4 = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject);
                    wrapCallbackFail4.put("errCode", 1003);
                    requestEvent.fail(wrapCallbackFail4, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
                    return "";
                }
                return "";
            }
            if ("destroy".equals(optString2)) {
                if (miniInterstitialAd.destroy()) {
                    put = ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject);
                } else {
                    put = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR).put("errCode", 1003).put("errMsg", MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
                }
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, put.toString());
                this.mInterstitialMap.remove(Integer.valueOf(optInt));
                return "";
            }
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, "operateInterstitialAdfailed e:", th5);
            JSONObject wrapCallbackFail5 = ApiUtil.wrapCallbackFail(requestEvent.event, null);
            try {
                wrapCallbackFail5.put("errCode", 1003);
                requestEvent.fail(wrapCallbackFail5, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
            } catch (Throwable unused) {
            }
            return wrapCallbackFail5.toString();
        }
    }
}
