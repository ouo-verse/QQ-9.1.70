package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
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
public class AppBoxPlugin extends BaseJsPlugin {
    public static final String API_OPERATE_APP_BOX = "operateAppBox";
    public static final String API_OPERATE_DESTROY = "destroy";
    public static final String API_OPERATE_LOAD = "load";
    public static final String API_OPERATE_SHOW = "show";
    private static final String ERRCODE = "errCode";
    private static final String ERRMSG = "errMsg";
    public static final String EVENT_APP_BOX_CLOSE = "onAppBoxClose";
    public static final String KEY_REF_ID = "biz_src_miniapp";
    public static final HashMap<Integer, String> S_CODE_MSG_MAP = MiniSDKConst.AdConst.CODE_MSG_MAP;
    private static final String TAG = "AppBoxPlugin";
    private Map<Integer, MiniAppBox> mAppBoxMap = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class MiniAppBox {
        private static final String ADUNIT_ID = "adUnitId";
        private static final String APP_BOX_ID = "id";
        private static final String COMP_ID = "compId";
        private static final String OPERATION_TYPE = "type";
        private static final String TAG = "SDK_MiniAppBox";
        private AdProxy.AbsBoxAdView adBox;
        private String adUnitId;
        private int appBoxId;
        private String appId;
        private WeakReference<Activity> mActivity;
        private volatile boolean mIsRequestingAd = false;
        private IJsService mJsService;

        MiniAppBox(Activity activity, int i3, String str, String str2, IJsService iJsService) {
            this.mActivity = new WeakReference<>(activity);
            this.appBoxId = i3;
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
                    wrapCallbackFail = ApiUtil.wrapCallbackFail(str, getResultObj(i3, i16), AppBoxPlugin.S_CODE_MSG_MAP.get(Integer.valueOf(i16)));
                }
                String jSONObject = wrapCallbackFail.toString();
                QMLog.i(TAG, "evaluateCallbackJs callbackId: " + i17 + " content:" + jSONObject);
                this.mJsService.evaluateCallbackJs(i17, jSONObject);
            }
        }

        private void createBoxAdView(final int i3, final int i16, Activity activity, Bundle bundle) {
            this.adBox = ((AdProxy) ProxyManager.get(AdProxy.class)).createBoxAdView(activity, this.appId, this.adUnitId, new AdProxy.IBoxADLisener() { // from class: com.tencent.qqmini.sdk.plugins.AppBoxPlugin.MiniAppBox.2
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener
                public void onDismiss() {
                    QMLog.i(MiniAppBox.TAG, "gdtBox onDismiss");
                    if (MiniAppBox.this.mJsService != null) {
                        MiniAppBox.this.mJsService.evaluateSubscribeJS(AppBoxPlugin.EVENT_APP_BOX_CLOSE, MiniAppBox.this.getResultObj(i3, -1).toString(), 0);
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener
                public void onError(int i17, String str) {
                    QMLog.i(MiniAppBox.TAG, "gdtBox onError, errCode = " + i17 + ", errMsg = " + str);
                    MiniAppBox.this.callbackJs(true, AppBoxPlugin.API_OPERATE_APP_BOX, i3, i17, i16);
                    MiniAppBox.this.mIsRequestingAd = false;
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener
                public void onLoad() {
                    QMLog.i(MiniAppBox.TAG, "gdtBox onLoad");
                    MiniAppBox.this.callbackJs(true, AppBoxPlugin.API_OPERATE_APP_BOX, i3, 0, i16);
                    MiniAppBox.this.mIsRequestingAd = false;
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBoxADLisener
                public void onShow() {
                    QMLog.i(MiniAppBox.TAG, "gdtBox onShow");
                }
            }, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject getResultObj(int i3, int i16) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.appBoxId);
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

        private boolean initAdParam(int i3, int i16) {
            boolean z16;
            int i17;
            boolean z17;
            int i18;
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
            if (((BaseJsPlugin) AppBoxPlugin.this).mMiniAppInfo != null && ((BaseJsPlugin) AppBoxPlugin.this).mMiniAppInfo.isEngineTypeMiniApp()) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                i18 = 7;
            } else {
                i18 = 8;
            }
            MiniAppInfo miniAppInfo = ((BaseJsPlugin) AppBoxPlugin.this).mMiniAppInfo;
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
                if (launchParam == null) {
                    str3 = "";
                } else {
                    str3 = launchParam.reportData;
                }
                str = String.valueOf(launchParam.scene);
            }
            if (miniAppInfo != null && (str4 = miniAppInfo.via) != null) {
                str5 = str4;
            }
            String spAdGdtCookie = AdUtil.getSpAdGdtCookie(i18);
            WnsConfig.getConfig("QZoneSetting", "MiniGameShareRate", 53);
            WeakReference<Activity> weakReference = this.mActivity;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (activity == null) {
                QMLog.e(TAG, "activity is null");
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString(AdProxy.KEY_ACCOUNT, account);
            bundle.putInt(AdProxy.KEY_AD_TYPE, i18);
            bundle.putInt(AdProxy.KEY_ORIENTATION, i17);
            bundle.putString(AdProxy.KEY_GDT_COOKIE, spAdGdtCookie);
            bundle.putString(AdProxy.KEY_ENTRY_PATH, str2);
            bundle.putString(AdProxy.KEY_REPORT_DATA, str3);
            bundle.putString(AdProxy.KEY_REFER, str);
            bundle.putString(AdProxy.KEY_VIA, str5);
            createBoxAdView(i3, i16, activity, bundle);
            AdProxy.AbsBoxAdView absBoxAdView = this.adBox;
            if (absBoxAdView != null) {
                absBoxAdView.loadAD();
                return true;
            }
            this.mIsRequestingAd = false;
            return false;
        }

        boolean destroy() {
            AdProxy.AbsBoxAdView absBoxAdView = this.adBox;
            if (absBoxAdView != null) {
                absBoxAdView.destroy();
                this.adBox = null;
                return true;
            }
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
            if (this.adBox == null) {
                QMLog.e(TAG, "adBox is null");
                return false;
            }
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.AppBoxPlugin.MiniAppBox.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MiniAppBox.this.adBox.show();
                        MiniAppBox.this.callbackJs(true, AppBoxPlugin.API_OPERATE_APP_BOX, i3, 0, i16);
                    } catch (Throwable th5) {
                        QMLog.e(MiniAppBox.TAG, "adBox show Exception:", th5);
                        MiniAppBox.this.callbackJs(false, AppBoxPlugin.API_OPERATE_APP_BOX, i3, 1003, i16);
                    }
                }
            });
            return true;
        }
    }

    static boolean isAdUnitIdValid(String str) {
        return !TextUtils.isEmpty(str);
    }

    MiniAppBox getMiniAppBox(int i3, String str, RequestEvent requestEvent) {
        String str2;
        Activity activity;
        MiniAppBox miniAppBox;
        ApkgInfo apkgInfo;
        Activity activity2 = null;
        if (this.mAppBoxMap.containsKey(Integer.valueOf(i3))) {
            miniAppBox = this.mAppBoxMap.get(Integer.valueOf(i3));
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
            MiniAppBox miniAppBox2 = new MiniAppBox(activity, i3, str, str3, requestEvent.jsService);
            this.mAppBoxMap.put(Integer.valueOf(i3), miniAppBox2);
            miniAppBox = miniAppBox2;
        }
        if (miniAppBox != null) {
            IMiniAppContext iMiniAppContext2 = this.mMiniAppContext;
            if (iMiniAppContext2 != null) {
                activity2 = iMiniAppContext2.getAttachActivity();
            }
            miniAppBox.setJsService(requestEvent.jsService);
            miniAppBox.setActivity(activity2);
        }
        return miniAppBox;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        Iterator<Map.Entry<Integer, MiniAppBox>> it = this.mAppBoxMap.entrySet().iterator();
        while (it.hasNext()) {
            MiniAppBox value = it.next().getValue();
            if (value != null) {
                value.destroy();
            }
        }
    }

    @JsEvent({API_OPERATE_APP_BOX})
    public String operateAppBox(RequestEvent requestEvent) {
        JSONObject put;
        try {
            QMLog.e(TAG, "operateAppBox, jsonParams = " + requestEvent.jsonParams);
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
            MiniAppBox miniAppBox = getMiniAppBox(optInt, optString, requestEvent);
            String optString2 = jSONObject.optString("type");
            int optInt2 = jSONObject.optInt("compId", -1);
            if ("load".equals(optString2)) {
                if (!miniAppBox.load(optInt2, requestEvent.callbackId)) {
                    JSONObject wrapCallbackFail2 = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject);
                    wrapCallbackFail2.put("errCode", 1003);
                    requestEvent.fail(wrapCallbackFail2, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
                    return "";
                }
                return "";
            }
            if ("show".equals(optString2)) {
                IMiniAppContext iMiniAppContext = this.mMiniAppContext;
                if (iMiniAppContext == null || iMiniAppContext.getAttachActivity() == null || !miniAppBox.show(optInt2, requestEvent.callbackId)) {
                    JSONObject wrapCallbackFail3 = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject);
                    wrapCallbackFail3.put("errCode", 1003);
                    requestEvent.fail(wrapCallbackFail3, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
                    return "";
                }
                return "";
            }
            if ("destroy".equals(optString2)) {
                if (miniAppBox.destroy()) {
                    put = ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject);
                } else {
                    put = ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR).put("errCode", 1003).put("errMsg", MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
                }
                requestEvent.jsService.evaluateCallbackJs(requestEvent.callbackId, put.toString());
                this.mAppBoxMap.remove(Integer.valueOf(optInt));
                return "";
            }
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, "operateAppBoxfailed e:", th5);
            JSONObject wrapCallbackFail4 = ApiUtil.wrapCallbackFail(requestEvent.event, null);
            try {
                wrapCallbackFail4.put("errCode", 1003);
                requestEvent.fail(wrapCallbackFail4, MiniSDKConst.AdConst.ERROR_MSG_INNER_ERROR);
            } catch (Throwable unused) {
            }
            return wrapCallbackFail4.toString();
        }
    }
}
