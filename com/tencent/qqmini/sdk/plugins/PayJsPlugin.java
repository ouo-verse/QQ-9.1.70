package com.tencent.qqmini.sdk.plugins;

import NS_COMM.COMM;
import NS_MINI_APP_PAY.MiniAppMidasPay$StGamePayRsp;
import NS_MINI_APP_PAY.MiniAppMidasPay$StQueryStarCurrencyRsp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qqmini.sdk.action.GetShareState;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import com.tencent.qqmini.sdk.utils.MiniLog;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.MiniToast;
import com.tencent.tav.core.ExportErrorStatus;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class PayJsPlugin extends BaseJsPlugin {
    public static final int COME_FROM_MINI = 9;
    public static final String KEY_MINI_GAME_PAY_ENV = "keyMiniGamePayEnv";
    public static final String KEY_MINI_GAME_PAY_ENV_APPID_VERTYPE = "keyMiniGamePayEnvAppidVertype";
    public static final String PAYJSON_KEY_MINI_APP_VERTYPE_STR = "miniAppVertypeStr";
    public static final String PAYJSON_KEY_SET_MIDAS_ENV = "setMidasEnv";
    public static final int PAY_CHANNEL_WECHAT = 8;
    public static final int PAY_DISABLE = 2;
    public static final int PAY_ENABLE = 1;
    public static final int PAY_TYPE_BUILDIN_H5 = 1;
    public static final int PAY_UNKNOWN = 0;
    public static final int SET_MIDAS_ENV_VAL_RELEASE = 0;
    public static final int SET_MIDAS_ENV_VAL_TEST = 1;
    private static final String TAG = "PayJsPlugin";
    private static final int TMP_MODE_FOR_H5 = 0;
    public static final String URL_PAY_BY_H5 = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_GAME_PAY_BY_H5_URL, WnsConfig.DefaultValue.DEFAULT_MINI_GAME_PAY_BY_H5_URL);
    public static final String URL_PAY_BY_H5_LANDSCAPE = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_GAME_PAY_BY_H5_URL_LANDSCAPE, WnsConfig.DefaultValue.DEFAULT_MINI_GAME_PAY_BY_H5_URL_LANDSCAPE);
    protected String mRealOfferId = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public interface IStarQueryListener {
        void onResult(boolean z16, JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String appendPayComeFrom(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 9);
            return jSONObject.toString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return str;
        }
    }

    private void checkWxPayUrl(final RequestEvent requestEvent, final String str, final String str2, String str3) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).checkWxPayUrl(str3, str, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                int i3;
                String str4;
                int i16;
                if (jSONObject != null) {
                    try {
                        if (jSONObject.has("retCode")) {
                            i3 = jSONObject.getInt("retCode");
                            if (jSONObject == null && jSONObject.has("errMsg")) {
                                str4 = jSONObject.getString("errMsg");
                            } else {
                                str4 = "";
                            }
                            if (!z16 && i3 == 0) {
                                if (jSONObject != null && jSONObject.has("key_url_valid")) {
                                    i16 = jSONObject.getInt("key_url_valid");
                                } else {
                                    i16 = 0;
                                }
                                if (i16 == 1) {
                                    if (((BaseJsPlugin) PayJsPlugin.this).mMiniAppContext.getAttachActivity() != null) {
                                        PayJsPlugin payJsPlugin = PayJsPlugin.this;
                                        payJsPlugin.startWxPayBrowser(((BaseJsPlugin) payJsPlugin).mMiniAppContext.getAttachActivity(), str, str2, requestEvent);
                                    } else {
                                        QMLog.i(PayJsPlugin.TAG, "context is null");
                                    }
                                } else {
                                    requestEvent.fail("url is invalid");
                                }
                                QMLog.i(PayJsPlugin.TAG, "requestWxPayment urlValid=" + i16);
                            } else {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(QzoneIPCModule.RESULT_CODE, i3);
                                jSONObject2.put("resultMsg", str4);
                                requestEvent.fail(jSONObject2, "pay fail");
                            }
                            QMLog.i(PayJsPlugin.TAG, "requestWxPayment error=" + i3 + ", msg=" + str4);
                        }
                    } catch (Exception unused) {
                        requestEvent.fail("pay fail");
                        return;
                    }
                }
                i3 = -1;
                if (jSONObject == null) {
                }
                str4 = "";
                if (!z16) {
                }
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put(QzoneIPCModule.RESULT_CODE, i3);
                jSONObject22.put("resultMsg", str4);
                requestEvent.fail(jSONObject22, "pay fail");
                QMLog.i(PayJsPlugin.TAG, "requestWxPayment error=" + i3 + ", msg=" + str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public PayProxy.IPayResultCallBack getIPayResultCallBack(final RequestEvent requestEvent, final boolean z16, final String str) {
        return new PayProxy.IPayResultCallBack() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.15
            /* JADX WARN: Removed duplicated region for block: B:17:0x00ae  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x00c9  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x0093  */
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onPayCallBack(PayProxy.PayResponse payResponse) {
                JSONException jSONException;
                String str2;
                int i3;
                int i16;
                int i17;
                int i18;
                int i19;
                int i26;
                JSONObject jSONObject;
                String optString;
                int optInt;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(QzoneIPCModule.RESULT_CODE, payResponse.getResultCode());
                } catch (JSONException unused) {
                }
                String str3 = null;
                int i27 = -1;
                if (z16) {
                    try {
                        jSONObject = new JSONObject(str);
                        optString = jSONObject.optString("appId", null);
                        try {
                            str3 = jSONObject.optString("prepayId", null);
                            optInt = jSONObject.optInt("balanceAmount", -1);
                            try {
                                i16 = jSONObject.optInt("topupAmount", -1);
                            } catch (JSONException e16) {
                                i16 = -1;
                                i27 = optInt;
                                jSONException = e16;
                                str2 = str3;
                                str3 = optString;
                                i3 = i16;
                                QMLog.e(PayJsPlugin.TAG, "", jSONException);
                                i17 = 0;
                                i18 = i27;
                                i19 = i16;
                                i26 = i3;
                                int payChannel = PayJsPlugin.this.getPayChannel(payResponse);
                                if (payResponse.getResultCode() != 0) {
                                }
                                if (z16) {
                                }
                                QMLog.i(PayJsPlugin.TAG, "handleRechargeGame onPayCallBack, , resultCode = " + payResponse.getResultCode() + ", resultMsg = " + payResponse.getResultMsg() + "extendInfo = " + payResponse.getExtendInfo());
                            }
                        } catch (JSONException e17) {
                            jSONException = e17;
                            str2 = str3;
                            i16 = -1;
                        }
                    } catch (JSONException e18) {
                        jSONException = e18;
                        str2 = null;
                        i3 = -1;
                        i16 = -1;
                    }
                    try {
                        i27 = jSONObject.optInt("starCurrency", -1);
                        i17 = jSONObject.optInt("setEnv", 0);
                        str2 = str3;
                        str3 = optString;
                        i18 = optInt;
                        i19 = i16;
                        i26 = i27;
                    } catch (JSONException e19) {
                        jSONException = e19;
                        str2 = str3;
                        str3 = optString;
                        i3 = i27;
                        i27 = optInt;
                        QMLog.e(PayJsPlugin.TAG, "", jSONException);
                        i17 = 0;
                        i18 = i27;
                        i19 = i16;
                        i26 = i3;
                        int payChannel2 = PayJsPlugin.this.getPayChannel(payResponse);
                        if (payResponse.getResultCode() != 0) {
                        }
                        if (z16) {
                        }
                        QMLog.i(PayJsPlugin.TAG, "handleRechargeGame onPayCallBack, , resultCode = " + payResponse.getResultCode() + ", resultMsg = " + payResponse.getResultMsg() + "extendInfo = " + payResponse.getExtendInfo());
                    }
                } else {
                    i17 = 0;
                    str2 = null;
                    i26 = -1;
                    i18 = -1;
                    i19 = -1;
                }
                int payChannel22 = PayJsPlugin.this.getPayChannel(payResponse);
                if (payResponse.getResultCode() != 0 && payResponse.getPayState() == 0) {
                    PayJsPlugin.this.handlePayResultSuc(jSONObject2, str3, str2, i18, i19, i26, i17, payChannel22, z16, requestEvent);
                } else if (z16) {
                    PayJsPlugin payJsPlugin = PayJsPlugin.this;
                    int i28 = i26;
                    payJsPlugin.invokeMidasQuery(str2, str3, i28, i17, payJsPlugin.getStarQueryListener(str3, str2, i28, i18, i19, payChannel22, i17, requestEvent));
                } else {
                    PayJsPlugin.this.handleNativeResponseFail(requestEvent, jSONObject2, payResponse.getResultMsg());
                }
                QMLog.i(PayJsPlugin.TAG, "handleRechargeGame onPayCallBack, , resultCode = " + payResponse.getResultCode() + ", resultMsg = " + payResponse.getResultMsg() + "extendInfo = " + payResponse.getExtendInfo());
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
            public void payNeedLogin() {
                QMLog.e(PayJsPlugin.TAG, "handleRechargeGame payNeedLogin");
                PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "payNeedLogin");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPayChannel(PayProxy.PayResponse payResponse) {
        if (payResponse.getPayChannel() == 8) {
            return 2;
        }
        return 3;
    }

    private String getSDKH5Url(String str) {
        if (!QUAUtil.isQQApp()) {
            String appName = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName();
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null && miniAppInfo.launchParam != null) {
                appName = appName + "_" + this.mMiniAppInfo.launchParam.scene;
            }
            String account = LoginManager.getInstance().getAccount();
            if (TextUtils.isEmpty(account)) {
                account = "null";
            }
            StringBuilder sb5 = new StringBuilder(str);
            String platformId = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPlatformId();
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("refer=");
            sb5.append(appName);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("shareuid=");
            sb5.append(account);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("platform=");
            sb5.append(platformId);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("fromSDK=1");
            return sb5.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0019, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSDKPf(String str) {
        String str2;
        String appName;
        MiniAppInfo miniAppInfo;
        String account;
        String str3 = "null";
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = new JSONObject(str).optString("prepayId");
            } catch (JSONException e16) {
                e = e16;
                str2 = "null";
            }
            try {
            } catch (JSONException e17) {
                e = e17;
                e.printStackTrace();
                appName = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName();
                miniAppInfo = this.mMiniAppInfo;
                if (miniAppInfo != null) {
                    appName = appName + "_" + this.mMiniAppInfo.launchParam.scene;
                }
                account = LoginManager.getInstance().getAccount();
                if (!TextUtils.isEmpty(account)) {
                }
                int loginType = LoginManager.getInstance().getLoginType();
                if (this.mMiniAppInfo != null) {
                }
                return "";
            }
        }
        str2 = "null";
        appName = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName();
        miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && miniAppInfo.launchParam != null) {
            appName = appName + "_" + this.mMiniAppInfo.launchParam.scene;
        }
        account = LoginManager.getInstance().getAccount();
        if (!TextUtils.isEmpty(account)) {
            str3 = account;
        }
        int loginType2 = LoginManager.getInstance().getLoginType();
        if (this.mMiniAppInfo != null) {
            if (loginType2 != 2 && loginType2 != 3) {
                if (loginType2 == 1) {
                    return "qq_m_wx-20031-android-2011-" + this.mMiniAppInfo.appId + "-" + str2 + "-" + appName + "-" + str3;
                }
            } else {
                return "qq_m_qq-20031-android-2011-" + this.mMiniAppInfo.appId + "-" + str2 + "-" + appName + "-" + str3;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public IStarQueryListener getStarQueryListener(final String str, final String str2, final int i3, final int i16, final int i17, final int i18, final int i19, final RequestEvent requestEvent) {
        return new IStarQueryListener() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.16
            @Override // com.tencent.qqmini.sdk.plugins.PayJsPlugin.IStarQueryListener
            public void onResult(boolean z16, JSONObject jSONObject) {
                if (!z16) {
                    PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "");
                    return;
                }
                int optInt = jSONObject.optInt(QzoneIPCModule.RESULT_CODE);
                int optInt2 = jSONObject.optInt("rechargeNum");
                if (optInt == 0 && optInt2 <= 0) {
                    PayJsPlugin.this.invokeMidasConsume(requestEvent, str, str2, i3, i16, i17, i18, i19);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(QzoneIPCModule.RESULT_CODE, -3);
                    jSONObject2.put("errMsg", "\u652f\u4ed8\u5931\u8d25");
                    PayJsPlugin.this.handleNativeResponseFail(requestEvent, jSONObject2, "");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        };
    }

    private void handleMidasGoodsPay(Activity activity, JSONObject jSONObject, RequestEvent requestEvent) throws JSONException {
        final RequestEvent requestEvent2;
        Bundle bundle;
        String optString = jSONObject.optString("offerId", "");
        JSONObject jSONObject2 = jSONObject.getJSONObject("payInfo");
        String string = jSONObject.getString("userId");
        String string2 = jSONObject2.getString("tokenUrl");
        String optString2 = jSONObject2.optString("aid", "");
        String optString3 = jSONObject2.optString("zoneId", "1");
        String optString4 = jSONObject2.optString("numberVisible", "");
        String optString5 = jSONObject2.optString("unit", "");
        String optString6 = jSONObject2.optString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, "");
        String optString7 = jSONObject2.optString("other", "");
        String valueOf = String.valueOf(requestEvent.callbackId);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("offerId", optString);
        jSONObject3.put("userId", string);
        jSONObject3.put("tokenUrl", string2);
        jSONObject3.put("zoneId", optString3);
        jSONObject3.put("numberVisible", optString4);
        jSONObject3.put("unit", optString5);
        jSONObject3.put("aid", optString2);
        jSONObject3.put(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, optString6);
        jSONObject3.put("other", optString7);
        jSONObject3.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 9);
        Bundle bundle2 = new Bundle();
        bundle2.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, valueOf);
        bundle2.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, jSONObject3.toString());
        bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle2.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, System.currentTimeMillis());
        bundle2.putInt(PayProxy.Source.PAY_REQUEST_CODE_KEY, 7);
        bundle2.putString(PayProxy.Source.PAY_REQUEST_SDK_PF, getSDKPf(jSONObject3.toString()));
        if (activity != null) {
            PayProxy payProxy = (PayProxy) ProxyManager.get(PayProxy.class);
            if (payProxy == null) {
                handleNativeResponseFail(requestEvent, null, "not support pay");
                return;
            } else {
                requestEvent2 = requestEvent;
                bundle = payProxy.midasPay(activity, jSONObject3.toString(), new PayProxy.IPayResultCallBack() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.12
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
                    public void onPayCallBack(PayProxy.PayResponse payResponse) {
                        JSONObject jSONObject4 = new JSONObject();
                        try {
                            jSONObject4.put(QzoneIPCModule.RESULT_CODE, payResponse.getResultCode());
                        } catch (JSONException unused) {
                        }
                        if (payResponse.getResultCode() == 0 && payResponse.getPayState() == 0) {
                            PayJsPlugin.this.handleNativeResponseOk(requestEvent2, jSONObject4);
                        } else if (payResponse.getResultCode() == 2 || payResponse.getPayState() == 1) {
                            PayJsPlugin.this.handleNativeResponseCancel(requestEvent2, jSONObject4);
                        } else {
                            PayJsPlugin.this.handleNativeResponseFail(requestEvent2, jSONObject4, payResponse.getResultMsg());
                        }
                        QMLog.i(PayJsPlugin.TAG, "handleMidasGoodsPay onPayCallBack, , resultCode = " + payResponse.getResultCode() + ", resultMsg = " + payResponse.getResultMsg() + "extendInfo = " + payResponse.getExtendInfo());
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
                    public void payNeedLogin() {
                        QMLog.e(PayJsPlugin.TAG, "handleMidasGoodsPay payNeedLogin");
                        PayJsPlugin.this.handleNativeResponseFail(requestEvent2, null, "payNeedLogin");
                    }
                }, bundle2);
            }
        } else {
            requestEvent2 = requestEvent;
            bundle = null;
        }
        int i3 = 0;
        if (bundle != null) {
            i3 = bundle.getInt("retCode", 0);
        }
        if (bundle != null && i3 != 0) {
            handleNativeResponseFail(requestEvent2, null, "");
        }
    }

    private void handleMidasMonthCardPay(Activity activity, String str, final RequestEvent requestEvent) {
        Bundle bundle;
        String valueOf = String.valueOf(requestEvent.callbackId);
        Bundle bundle2 = new Bundle();
        bundle2.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, valueOf);
        bundle2.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, str);
        bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle2.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, System.currentTimeMillis());
        bundle2.putInt(PayProxy.Source.PAY_REQUEST_CODE_KEY, 14);
        bundle2.putString(PayProxy.Source.PAY_REQUEST_SDK_PF, getSDKPf(str));
        if (activity != null) {
            PayProxy payProxy = (PayProxy) ProxyManager.get(PayProxy.class);
            if (payProxy == null) {
                handleNativeResponseFail(requestEvent, null, "not support pay");
                return;
            }
            bundle = payProxy.midasPay(activity, str, new PayProxy.IPayResultCallBack() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.11
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
                public void onPayCallBack(PayProxy.PayResponse payResponse) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(QzoneIPCModule.RESULT_CODE, payResponse.getResultCode());
                    } catch (JSONException unused) {
                    }
                    if (payResponse.getResultCode() == 0 && payResponse.getPayState() == 0) {
                        PayJsPlugin.this.handleNativeResponseOk(requestEvent, jSONObject);
                    } else if (payResponse.getResultCode() == 2 || payResponse.getPayState() == 1) {
                        PayJsPlugin.this.handleNativeResponseCancel(requestEvent, jSONObject);
                    } else {
                        PayJsPlugin.this.handleNativeResponseFail(requestEvent, jSONObject, payResponse.getResultMsg());
                    }
                    QMLog.i(PayJsPlugin.TAG, "handleMidasMonthCardPay onPayCallBack, , resultCode = " + payResponse.getResultCode() + ", resultMsg = " + payResponse.getResultMsg() + "extendInfo = " + payResponse.getExtendInfo());
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
                public void payNeedLogin() {
                    QMLog.e(PayJsPlugin.TAG, "handleMidasMonthCardPay payNeedLogin");
                    PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "payNeedLogin");
                }
            }, bundle2);
        } else {
            bundle = null;
        }
        int i3 = 0;
        if (bundle != null) {
            i3 = bundle.getInt("retCode", 0);
        }
        if (bundle != null && i3 != 0) {
            handleNativeResponseFail(requestEvent, null, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNativeResponseCancel(RequestEvent requestEvent, JSONObject jSONObject) {
        if (requestEvent != null) {
            requestEvent.cancel(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNativeResponseFail(RequestEvent requestEvent, JSONObject jSONObject, String str) {
        if (requestEvent != null) {
            requestEvent.fail(jSONObject, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNativeResponseOk(RequestEvent requestEvent, JSONObject jSONObject) {
        if (requestEvent != null) {
            requestEvent.ok(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePayResultSuc(JSONObject jSONObject, String str, String str2, int i3, int i16, int i17, int i18, int i19, boolean z16, RequestEvent requestEvent) {
        if (z16) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i17 != -1 && i16 != -1 && i3 != -1 && i19 != -1) {
                invokeMidasConsume(requestEvent, str, str2, i17, i3, i16, i19, i18);
                return;
            }
            QMLog.i(TAG, "handleRechargeGame onPayCallBack, , consumeAppid = " + str + ", consumePrepayId = " + str2 + ", consumeStarCurrency = " + i17 + ", consumeTopupAmount = " + i16 + ", consumeBalanceAmount = " + i3 + ", payChannel = " + i19);
            return;
        }
        handleNativeResponseOk(requestEvent, jSONObject);
    }

    private void handleQQPay(final RequestEvent requestEvent) throws JSONException {
        Activity activity;
        Bundle bundle;
        JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
        String optString = jSONObject.optString("prepayId", "");
        JSONObject jSONObject2 = jSONObject.getJSONObject("payInfo");
        String optString2 = jSONObject2.optString("miniAppId", "");
        if (TextUtils.isEmpty(optString2)) {
            optString2 = this.mApkgInfo.appId;
        }
        String optString3 = jSONObject2.optString("bargainor_id", "");
        String optString4 = jSONObject2.optString(WadlProxyConsts.CHANNEL, "");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("tokenId", optString);
        jSONObject3.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 9);
        jSONObject3.put("appInfo", "appid#" + optString2 + "|bargainor_id#" + optString3 + "|channel#" + optString4);
        String valueOf = String.valueOf(requestEvent.callbackId);
        Bundle bundle2 = new Bundle();
        bundle2.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, valueOf);
        bundle2.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, jSONObject3.toString());
        bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
        bundle2.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, System.currentTimeMillis());
        bundle2.putInt(PayProxy.Source.PAY_REQUEST_CODE_KEY, 9);
        bundle2.putString(PayProxy.Source.PAY_REQUEST_SDK_PF, getSDKPf(jSONObject3.toString()));
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            activity = iMiniAppContext.getAttachActivity();
        } else {
            activity = null;
        }
        if (activity != null) {
            PayProxy payProxy = (PayProxy) ProxyManager.get(PayProxy.class);
            if (payProxy == null) {
                handleNativeResponseFail(requestEvent, null, "not support pay");
                return;
            }
            bundle = payProxy.midasPay(activity, jSONObject3.toString(), new PayProxy.IPayResultCallBack() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.13
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
                public void onPayCallBack(PayProxy.PayResponse payResponse) {
                    PayJsPlugin.this.onPlayCallback(payResponse, requestEvent);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
                public void payNeedLogin() {
                    QMLog.e(PayJsPlugin.TAG, "handleMidasMonthCardPay payNeedLogin");
                    PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "payNeedLogin");
                }
            }, bundle2);
        } else {
            bundle = null;
        }
        int i3 = 0;
        if (bundle != null) {
            i3 = bundle.getInt("retCode", 0);
        }
        if (bundle != null && i3 != 0) {
            handleNativeResponseFail(requestEvent, null, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayCallback(PayProxy.PayResponse payResponse, RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QzoneIPCModule.RESULT_CODE, payResponse.getResultCode());
            String extendInfo = payResponse.getExtendInfo();
            if (!TextUtils.isEmpty(extendInfo) && JSONUtil.isJson(extendInfo)) {
                jSONObject.put("data", new JSONObject(extendInfo).optJSONObject("data"));
            }
        } catch (JSONException unused) {
        }
        if (payResponse.getResultCode() == 0 && payResponse.getPayState() == 0) {
            handleNativeResponseOk(requestEvent, jSONObject);
        } else if (payResponse.getResultCode() != 2 && payResponse.getPayState() != 1) {
            handleNativeResponseFail(requestEvent, jSONObject, payResponse.getResultMsg());
        } else {
            handleNativeResponseCancel(requestEvent, jSONObject);
        }
        QMLog.i(TAG, "handleMidasGoodsPay onPayCallBack, , resultCode = " + payResponse.getResultCode() + ", resultMsg = " + payResponse.getResultMsg() + "extendInfo = " + payResponse.getExtendInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String processPayByH5Param(JSONObject jSONObject) {
        boolean z16;
        String str;
        String str2;
        CharSequence charSequence;
        LaunchParam launchParam;
        String str3 = URL_PAY_BY_H5;
        if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str3 = URL_PAY_BY_H5_LANDSCAPE;
        }
        String optString = jSONObject.optString("prepayId", "");
        int optInt = jSONObject.optInt("starCurrency");
        String optString2 = jSONObject.optString("offerId", "");
        String optString3 = jSONObject.optString("zoneId", "");
        String optString4 = jSONObject.optString("acctType", "");
        int optInt2 = jSONObject.optInt("saveValue");
        boolean optBoolean = jSONObject.optBoolean("isCanChange");
        String optString5 = jSONObject.optString("currencyType", "");
        String optString6 = jSONObject.optString("platform", "");
        String optString7 = jSONObject.optString("remark", "");
        String optString8 = jSONObject.optString("aid", "");
        boolean optBoolean2 = jSONObject.optBoolean("numberVisible");
        String optString9 = jSONObject.optString("other", "");
        int optInt3 = jSONObject.optInt("setEnv");
        String optString10 = jSONObject.optString("firstRefer", "");
        String optString11 = jSONObject.optString("firstVia", "");
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) {
            str = "";
        } else {
            str = String.valueOf(launchParam.scene);
        }
        if (miniAppInfo == null) {
            str2 = "";
        } else {
            str2 = miniAppInfo.via;
        }
        String replace = str3.replace("{prepayId}", optString).replace("{starCurrency}", optInt + "").replace("{offerId}", optString2).replace("{setEnv}", optInt3 + "").replace("{appid}", this.mMiniAppInfo.appId).replace("{acctType}", optString4).replace("{zoneId}", optString3).replace("{buyQuantity}", optInt2 + "");
        String str4 = "1";
        if (optBoolean) {
            charSequence = "1";
        } else {
            charSequence = "0";
        }
        String replace2 = replace.replace("{isCanChange}", charSequence).replace("{currencyType}", optString5).replace("{platform}", optString6).replace("{remark}", optString7);
        if (!optBoolean2) {
            str4 = "0";
        }
        return replace2.replace("{numberVisible}", str4).replace("{other}", optString9).replace("{aid}", optString8).replace("{firstRefer}", optString10).replace("{firstVia}", optString11).replace("{refer}", str).replace("{via}", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void putAid(JSONObject jSONObject, String str, String str2, String str3, String str4, String str5) {
        if (jSONObject == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "null";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "null";
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "null";
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = "null";
        }
        if (TextUtils.isEmpty(str5)) {
            str5 = "null";
        }
        String format = String.format("%s-%s-%s-%s-%s", str, str2, str3, str4, str5);
        try {
            jSONObject.put("aid", format);
        } catch (JSONException unused) {
        }
        QMLog.d(TAG, "putAid, aid = " + format);
    }

    private void reChargeStarCurrency(RequestEvent requestEvent, boolean z16) {
        String str;
        int i3;
        MiniAppInfo miniAppInfo;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("prepayId", null);
            int optInt = jSONObject.optInt("balanceAmount", -1);
            int optInt2 = jSONObject.optInt("topupAmount", -1);
            int optInt3 = jSONObject.optInt("starCurrency", -1);
            int optInt4 = jSONObject.optInt("setEnv", 0);
            String optString2 = jSONObject.optString("aid", "");
            if (TextUtils.isEmpty(optString2) || !optString2.contains("{appid}")) {
                str = "setEnv";
            } else {
                str = "setEnv";
                optString2 = optString2.replace("{appid}", this.mApkgInfo.appId);
            }
            jSONObject.put("userId", LoginManager.getInstance().getAccount());
            jSONObject.put("aid", optString2);
            jSONObject.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 9);
            jSONObject.put(PAYJSON_KEY_SET_MIDAS_ENV, optInt4);
            if (this.mIsMiniGame && (miniAppInfo = this.mMiniAppInfo) != null) {
                String str2 = this.mApkgInfo.appId + "_" + miniAppInfo.verType;
                i3 = optInt4;
                this.mContext.getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", MD5Utils.encodeHexStr(str2)).commit();
                jSONObject.put(PAYJSON_KEY_MINI_APP_VERTYPE_STR, str2);
            } else {
                i3 = optInt4;
            }
            String valueOf = String.valueOf(requestEvent.callbackId);
            if (optInt != -1 && optInt2 != -1 && optInt3 != -1) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appId", this.mApkgInfo.appId);
                jSONObject2.put("prepayId", optString);
                jSONObject2.put("balanceAmount", optInt);
                jSONObject2.put("topupAmount", optInt2);
                jSONObject2.put("starCurrency", optInt3);
                jSONObject2.put("seq", requestEvent.callbackId);
                jSONObject2.put(str, i3);
                valueOf = jSONObject2.toString();
            }
            String str3 = valueOf;
            if (!TextUtils.isEmpty(this.mRealOfferId)) {
                jSONObject.put("offerId", this.mRealOfferId);
            }
            handleRechargeGame(requestEvent, this.mMiniAppContext.getAttachActivity(), jSONObject.toString(), str3, z16);
        } catch (JSONException e16) {
            QMLog.e(TAG, "API_RECHARGE_STAR_CURRENCY JSONException ", e16);
        }
    }

    private void reportWithGroupId(String str) {
        LaunchParam launchParam;
        EntryModel entryModel;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        String str2 = "";
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && (entryModel = launchParam.entryModel) != null) {
            int i3 = entryModel.type;
            long j3 = entryModel.uin;
            if (i3 == 1) {
                str2 = String.valueOf(j3);
            }
            QMLog.i(TAG, "report 4329 type=" + i3 + ", uin=" + j3);
        } else {
            QMLog.i(TAG, "no groupId");
        }
        SDKMiniProgramLpReportDC04239.reportWithGroupId(this.mMiniAppInfo, "wechat_pay", "launch_wechatpay", "", str, str2);
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_REQUEST_WX_PAYMENT})
    private void requestWxPayment(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString(ISchemeApi.KEY_REFERER);
            QMLog.i(TAG, "handleWxPayment, url=" + optString);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                if (!URLUtil.isHttpsUrl(optString) && !URLUtil.isHttpUrl(optString)) {
                    requestEvent.fail("url is not http url, please check!");
                    QMLog.i(TAG, "handleWxPayment, url=" + optString);
                    return;
                }
                checkWxPayUrl(requestEvent, optString, optString2, this.mMiniAppInfo.appId);
                reportWithGroupId(optString);
                return;
            }
            requestEvent.fail("url or referer is empty, please check!");
            QMLog.i(TAG, "handleWxPayment, url=" + optString + ", referer=" + optString2);
        } catch (Exception e16) {
            QMLog.i(TAG, "handleWxPayment error", e16);
            requestEvent.fail();
        }
    }

    private void setCookieIfNeed(Bundle bundle) {
        if (!QUAUtil.isQQApp()) {
            int loginType = LoginManager.getInstance().getLoginType();
            String payOpenId = LoginManager.getInstance().getPayOpenId();
            String payOpenKey = LoginManager.getInstance().getPayOpenKey();
            String payAccessToken = LoginManager.getInstance().getPayAccessToken();
            String appId = LoginManager.getInstance().getAppId();
            byte[] loginSig = LoginManager.getInstance().getLoginSig();
            String account = LoginManager.getInstance().getAccount();
            bundle.putString("cookie", ("openid=" + payOpenId) + ";" + ("openkey=" + payOpenKey) + ";" + ("accesstoken=" + payAccessToken) + ";" + ("login_type=" + loginType) + ";" + ("login_appid=" + appId) + ";" + ("login_sig=" + new String(loginSig)) + ";" + ("login_uin=" + account));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPayBrowserActivity(Activity activity, final RequestEvent requestEvent, String str) {
        ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.7
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                String str2;
                String str3;
                if (i3 != 3003) {
                    return false;
                }
                ActivityResultManager.g().removeActivityResultListener(this);
                String str4 = "";
                int i17 = -1;
                if (i16 != -1) {
                    QMLog.e(PayJsPlugin.TAG, "startPayBrowserActivity: pay failed, resultCode=" + i16);
                    str2 = "\u652f\u4ed8\u5931\u8d25\uff1a\u7cfb\u7edf\u9519\u8bef";
                } else {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        i17 = extras.getInt("errCode", -1);
                        String string = extras.getString("errMsg", "");
                        str4 = extras.getString("tipMsg", "");
                        QMLog.i(PayJsPlugin.TAG, "startPayBrowserActivity: pay result, retCode=" + i17 + "; retMsg=" + string + "; tipMsg" + str4);
                        str2 = string;
                    } else {
                        QMLog.i(PayJsPlugin.TAG, "startPayBrowserActivity: pay failed, bundle is null.");
                        str2 = "\u652f\u4ed8\u5931\u8d25\uff1a\u56de\u8c03\u5f02\u5e38";
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(QzoneIPCModule.RESULT_CODE, i17);
                    jSONObject.put("resultMsg", str2);
                    jSONObject.put("tipMsg", str4);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(requestEvent.event);
                    if (i17 == 0) {
                        str3 = ":ok";
                    } else {
                        str3 = ":fail";
                    }
                    sb5.append(str3);
                    jSONObject.put("errMsg", sb5.toString());
                } catch (Exception e16) {
                    QMLog.e(PayJsPlugin.TAG, "startPayBrowserActivity: json put exception=", e16);
                }
                if (i17 != 0) {
                    MiniLog.consoleLog(((BaseJsPlugin) PayJsPlugin.this).mMiniAppInfo, "\u652f\u4ed8\uff1aresultCode=" + i16 + "; resultMsg=" + str2 + "; tipMsg=" + str4);
                }
                requestEvent.evaluateCallbackJs(jSONObject.toString());
                return true;
            }
        });
        Bundle bundle = new Bundle();
        setCookieIfNeed(bundle);
        bundle.putBoolean(IPCConst.KEY_HIDE_TITLE_BAR, true);
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        String sDKH5Url = getSDKH5Url(str);
        channelProxy.startTransparentBrowserActivityForResult(activity, sDKH5Url, bundle, 3003);
        QMLog.i(TAG, "startPayBrowserActivity, url=" + sDKH5Url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startWxPayBrowser(Activity activity, String str, String str2, final RequestEvent requestEvent) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("hide_more_button", true);
        bundle.putBoolean("keyForForceCloseAfterJump", true);
        HashMap hashMap = new HashMap();
        hashMap.put("Referer", str2);
        bundle.putSerializable(MiniAppWebviewFragment.KEY_HEADER, hashMap);
        ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.6
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                QMLog.d(PayJsPlugin.TAG, "doOnActivityResult requestCode" + i3 + " resultCode:" + i16);
                if (i3 == 3005) {
                    new JSONObject();
                    requestEvent.ok();
                    ActivityResultManager.g().removeActivityResultListener(this);
                    return true;
                }
                return false;
            }
        });
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null && activity != null) {
            channelProxy.startBrowserSupportHeaderActivityForResult(activity, str, bundle, 3005);
        }
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_CHECK_H5_PAY_STATUS})
    public void checkH5PayStatus(RequestEvent requestEvent) {
        JSONObject jSONObject = new JSONObject();
        try {
            int payMode = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPayMode();
            if (payMode != 0) {
                if (payMode != 1) {
                    if (payMode != 2) {
                        handleNativeResponseFail(requestEvent, jSONObject, "not support pay mode:" + payMode);
                    }
                } else {
                    jSONObject.put(QzoneIPCModule.RESULT_CODE, 1);
                    handleNativeResponseOk(requestEvent, jSONObject);
                }
            }
            jSONObject.put(QzoneIPCModule.RESULT_CODE, 0);
            handleNativeResponseOk(requestEvent, jSONObject);
        } catch (JSONException e16) {
            QMLog.e(TAG, "checkH5PayStatus JSONException ", e16);
        }
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_CONSUME_STAR_CURRENTY})
    public void consumeStarCurrency(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            invokeMidasConsume(requestEvent, this.mApkgInfo.appId, jSONObject.optString("prepayId"), jSONObject.optInt("starCurrency"), jSONObject.optInt("balanceAmount"), jSONObject.optInt("topupAmount"), jSONObject.optInt("payChannel"), jSONObject.optInt("setEnv", 0));
        } catch (JSONException e16) {
            QMLog.e(TAG, "consumestarcurrency error = ", e16);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(QzoneIPCModule.RESULT_CODE, 1000);
                handleNativeResponseFail(requestEvent, jSONObject2, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR);
            } catch (JSONException e17) {
                QMLog.e(TAG, "handleNativeResponse error = ", e17);
            }
        }
    }

    public void handleRechargeGame(final RequestEvent requestEvent, final Activity activity, final String str, final String str2, final boolean z16) {
        if (activity == null) {
            handleNativeResponseFail(requestEvent, null, "activity is null");
        } else {
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.14
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    Bundle bundle = new Bundle();
                    bundle.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, str2);
                    bundle.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, PayJsPlugin.this.appendPayComeFrom(str));
                    bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
                    bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, System.currentTimeMillis());
                    bundle.putInt(PayProxy.Source.PAY_REQUEST_CODE_KEY, 6);
                    bundle.putString(PayProxy.Source.PAY_REQUEST_SDK_PF, PayJsPlugin.this.getSDKPf(str));
                    PayProxy payProxy = (PayProxy) ProxyManager.get(PayProxy.class);
                    if (payProxy == null) {
                        PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "not support pay");
                        return;
                    }
                    Bundle midasPay = payProxy.midasPay(activity, PayJsPlugin.this.appendPayComeFrom(str), PayJsPlugin.this.getIPayResultCallBack(requestEvent, z16, str2), bundle);
                    if (midasPay != null) {
                        i3 = midasPay.getInt("retCode", 0);
                    } else {
                        i3 = 0;
                    }
                    if (midasPay != null && i3 != 0) {
                        PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "");
                    }
                    MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
                    if (miniAppProxy != null && miniAppProxy.isDebugVersion()) {
                        MiniToast.makeText(activity, 0, "\u3010\u4ec5debug\u53ef\u89c1\u3011\u4f7f\u7528native\u652f\u4ed8", 0).show();
                    }
                }
            });
        }
    }

    public void invokeMidasConsume(final RequestEvent requestEvent, String str, String str2, int i3, int i16, int i17, int i18, int i19) {
        String str3;
        String str4;
        String str5;
        QMLog.i(TAG, "invokeMidasConsume prepayId= " + str2 + " starCurrency=" + String.valueOf(i3));
        if (!TextUtils.isEmpty(str2) && i3 > 0 && !TextUtils.isEmpty(str)) {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo == null || miniAppInfo.launchParam == null) {
                str3 = "";
            } else {
                str3 = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName() + "_" + this.mMiniAppInfo.launchParam.scene;
            }
            MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
            if (miniAppInfo2 == null || (str5 = miniAppInfo2.via) == null) {
                str4 = "";
            } else {
                str4 = str5;
            }
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getMidasConsumeResult(str, str2, i3, i16, i17, i18, i19, str3, str4, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.9
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (jSONObject == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(QzoneIPCModule.RESULT_CODE, -4);
                            jSONObject2.put("resultMsg", "\u6d88\u8017\u7cfb\u7edf\u9519\u8bef");
                            PayJsPlugin.this.handleNativeResponseFail(requestEvent, jSONObject2, "");
                            return;
                        } catch (JSONException e16) {
                            QMLog.e(PayJsPlugin.TAG, "invokeMidasConsume JSONException ", e16);
                            return;
                        }
                    }
                    try {
                        MiniAppMidasPay$StGamePayRsp miniAppMidasPay$StGamePayRsp = (MiniAppMidasPay$StGamePayRsp) jSONObject.get("response");
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        int i26 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
                        String string = jSONObject.getString("errMsg");
                        JSONObject jSONObject5 = new JSONObject(new HashMap());
                        jSONObject4.put("attachInfo", miniAppMidasPay$StGamePayRsp.extInfo.attachInfo.get());
                        jSONObject4.put(ThirdPartyMiniApiImpl.KEY_MAP_INFO, jSONObject5);
                        jSONObject3.put(QzoneIPCModule.RESULT_CODE, i26);
                        jSONObject3.put("resultMsg", string);
                        jSONObject3.put("extInfo", jSONObject4);
                        QMLog.i(PayJsPlugin.TAG, "invokeMidasConsume receive isSuc= " + z16 + " resObj=" + jSONObject.toString());
                        PayJsPlugin.this.handleNativeResponseOk(requestEvent, jSONObject);
                    } catch (Throwable th5) {
                        QMLog.e(PayJsPlugin.TAG, "invokeMidasConsume JSONException ", th5);
                    }
                }
            });
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QzoneIPCModule.RESULT_CODE, -4);
            jSONObject.put("resultMsg", "\u6d88\u8017\u53c2\u6570\u9519\u8bef");
            handleNativeResponseFail(requestEvent, jSONObject, "");
        } catch (JSONException e16) {
            QMLog.e(TAG, "invokeMidasConsume JSONException ", e16);
        }
    }

    public void invokeMidasQuery(String str, String str2, int i3, int i16, final IStarQueryListener iStarQueryListener) {
        QMLog.i(TAG, "invokeMidasQuery prepayId= " + str + " starCurrency=" + String.valueOf(i3) + " setEnv:" + i16);
        if (!TextUtils.isEmpty(str) && i3 > 0 && !TextUtils.isEmpty(str2)) {
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).queryCurrency(str, str2, i3, i16, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.10
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    QMLog.i(PayJsPlugin.TAG, "invokeMidasQuery receive isSuc= " + z16 + " ret=" + jSONObject);
                    if (jSONObject == null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(QzoneIPCModule.RESULT_CODE, -1);
                            jSONObject2.put("errMsg", "\u7cfb\u7edf\u9519\u8bef");
                            IStarQueryListener iStarQueryListener2 = iStarQueryListener;
                            if (iStarQueryListener2 != null) {
                                iStarQueryListener2.onResult(false, jSONObject2);
                                return;
                            }
                            return;
                        } catch (JSONException e16) {
                            QMLog.e(PayJsPlugin.TAG, "invokeMidasQuery JSONException ", e16);
                            return;
                        }
                    }
                    try {
                        MiniAppMidasPay$StQueryStarCurrencyRsp miniAppMidasPay$StQueryStarCurrencyRsp = (MiniAppMidasPay$StQueryStarCurrencyRsp) jSONObject.get("response");
                        int i17 = jSONObject.getInt(QzoneIPCModule.RESULT_CODE);
                        String string = jSONObject.getString("errMsg");
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        JSONObject jSONObject5 = new JSONObject(new HashMap());
                        jSONObject4.put("attachInfo", miniAppMidasPay$StQueryStarCurrencyRsp.extInfo.attachInfo.get());
                        jSONObject4.put(ThirdPartyMiniApiImpl.KEY_MAP_INFO, jSONObject5);
                        jSONObject3.put(QzoneIPCModule.RESULT_CODE, i17);
                        jSONObject3.put("errMsg", string);
                        jSONObject3.put("extInfo", jSONObject4);
                        jSONObject3.put("rechargeNum", miniAppMidasPay$StQueryStarCurrencyRsp.rechargeNum.get());
                        jSONObject3.put("remainder", miniAppMidasPay$StQueryStarCurrencyRsp.remainder.get());
                        String str3 = miniAppMidasPay$StQueryStarCurrencyRsp.offerid.get();
                        if (!TextUtils.isEmpty(str3) && !QUAUtil.isQQApp()) {
                            PayJsPlugin.this.mRealOfferId = str3;
                        }
                        QMLog.i(PayJsPlugin.TAG, "invokeMidasQuery receive isSuc= " + z16 + " resObj=" + jSONObject3.toString());
                        IStarQueryListener iStarQueryListener3 = iStarQueryListener;
                        if (iStarQueryListener3 != null) {
                            iStarQueryListener3.onResult(true, jSONObject3);
                        }
                    } catch (Throwable th5) {
                        QMLog.e(PayJsPlugin.TAG, "invokeMidasQuery failed", th5);
                    }
                }
            });
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QzoneIPCModule.RESULT_CODE, 1000);
            jSONObject.put("errMsg", MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR);
            if (iStarQueryListener != null) {
                iStarQueryListener.onResult(false, jSONObject);
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "invokeMidasQuery JSONException ", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null && channelProxy.isGooglePlayVersion()) {
            boolean z16 = false;
            if (WnsConfig.getConfig("qqminiapp", WnsConfig.MINI_APP_GOOGLE_PLAY_PAY_SWITCH, 0) == 1) {
                z16 = true;
            }
            if (!z16) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("retCode", ExportErrorStatus.END_WRITE_VIDEO_SAMPLE);
                    jSONObject.put("errMsg", "googlePlay PayAPI no supported!");
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                handleNativeResponseFail(requestEvent, jSONObject, "googlePlay PayAPI no supported!");
                return true;
            }
        }
        return super.onInterceptJsEvent(requestEvent);
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_REQUEST_STAR_CURRENCY})
    public void queryStarCurrency(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            invokeMidasQuery(jSONObject.optString("prepayId"), this.mApkgInfo.appId, jSONObject.optInt("starCurrency"), jSONObject.optInt("setEnv", 0), new IStarQueryListener() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.8
                @Override // com.tencent.qqmini.sdk.plugins.PayJsPlugin.IStarQueryListener
                public void onResult(boolean z16, JSONObject jSONObject2) {
                    if (z16) {
                        PayJsPlugin.this.handleNativeResponseOk(requestEvent, jSONObject2);
                    } else {
                        PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, jSONObject2.optString("errMsg"));
                    }
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, "querystarcurrency error = ", e16);
            try {
                new JSONObject().put(QzoneIPCModule.RESULT_CODE, 1000);
                handleNativeResponseFail(requestEvent, null, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR);
            } catch (JSONException e17) {
                QMLog.e(TAG, "handleNativeResponse error = ", e17);
            }
        }
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_RECHARGE_AND_CONSUME})
    public void rechargeAndConsumeStarCurrency(RequestEvent requestEvent) {
        reChargeStarCurrency(requestEvent, true);
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_RECHARGE_STAR_CURRENCY})
    public void rechargeStarCurrency(RequestEvent requestEvent) {
        reChargeStarCurrency(requestEvent, false);
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_PAY_BY_FRIEND})
    public void requestFriendPayment(RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String string = jSONObject.getString("prepayId");
            int optInt = jSONObject.optInt("setEnv", 0);
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("imageUrl");
            if (TextUtils.isEmpty(optString)) {
                optString = GameWnsUtils.defaultPayShareTitle();
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = GameWnsUtils.defaultPayShareImg();
            }
            COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
            COMM.Entry entry = new COMM.Entry();
            entry.key.set("prepay_id");
            entry.value.set(string);
            stCommonExt.mapInfo.get().add(entry);
            COMM.Entry entry2 = new COMM.Entry();
            entry2.key.set("set_env");
            entry2.value.set(optInt + "");
            stCommonExt.mapInfo.get().add(entry2);
            ShareState obtain = GetShareState.obtain(this.mMiniAppContext);
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null && obtain != null) {
                obtain.shareAppid = miniAppInfo.appId;
            }
            if (obtain != null) {
                obtain.shareEvent = requestEvent.event;
                obtain.shareCallbackId = requestEvent.callbackId;
                obtain.requestEvent = requestEvent;
            }
            if (miniAppInfo != null) {
                new InnerShareData.Builder().setShareSource(13).setShareTarget(0).setShareScene(4).setTitle(this.mMiniAppInfo.name).setSummary(optString).setEntryPath(null).setWebUrl("").setTemplateId("").setTemplateData("").setEntryModel(null).setShareChatModel(null).setWithShareTicket(false).setSharePicPath(optString2).setMiniAppInfo(this.mMiniAppInfo).setFromActivity(this.mMiniAppContext.getAttachActivity()).setExtInfo(stCommonExt).setShareInMiniProcess(true).build().shareAppMessage();
            }
        } catch (JSONException e16) {
            QMLog.e(TAG, "requestFriendPayment error = ", e16);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(QzoneIPCModule.RESULT_CODE, 1000);
                handleNativeResponseFail(requestEvent, jSONObject2, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR);
            } catch (JSONException e17) {
                QMLog.e(TAG, "handleNativeResponse error = ", e17);
            }
        }
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_PAY_COIN_BY_H5})
    public void requestMidasCoinPaymentByH5(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String string = jSONObject.getString("offerId");
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).checkOfferId(this.mApkgInfo.appId, string, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.5
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                    if (z16) {
                        int optInt = jSONObject2.optInt("result");
                        final String optString = jSONObject2.optString("errMsg");
                        String optString2 = jSONObject2.optString("firstRefer");
                        String optString3 = jSONObject2.optString("firstVia");
                        try {
                            jSONObject.put("firstRefer", optString2);
                            jSONObject.put("firstVia", optString3);
                        } catch (JSONException e16) {
                            QMLog.e(PayJsPlugin.TAG, "put refer via error ", e16);
                        }
                        if (optInt == 1) {
                            String processPayByH5Param = PayJsPlugin.this.processPayByH5Param(jSONObject);
                            PayJsPlugin payJsPlugin = PayJsPlugin.this;
                            payJsPlugin.startPayBrowserActivity(((BaseJsPlugin) payJsPlugin).mMiniAppContext.getAttachActivity(), requestEvent, processPayByH5Param);
                            return;
                        } else {
                            if (optInt == 0 || optInt == 2) {
                                AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        MiniToast.makeText(((BaseJsPlugin) PayJsPlugin.this).mContext, optString, 0).show();
                                    }
                                });
                                QMLog.e(PayJsPlugin.TAG, "handleNativeRequest result = " + optInt);
                                PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, optString);
                                return;
                            }
                            return;
                        }
                    }
                    QMLog.e(PayJsPlugin.TAG, "checkOfferId isSuc = " + z16);
                    PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "checkOfferId fail");
                }
            });
        } catch (Exception e16) {
            QMLog.e(TAG, "requestMidasCoinPaymentByH5 error", e16);
            requestEvent.fail();
        }
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_REQUEST_MIDAS_GOODS_PAY})
    public void requestMidasGoodsPay(RequestEvent requestEvent) {
        try {
            String account = LoginManager.getInstance().getAccount();
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            jSONObject.put("userId", account);
            handleMidasGoodsPay(this.mMiniAppContext.getAttachActivity(), jSONObject, requestEvent);
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
            handleNativeResponseFail(requestEvent, null, "");
        }
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_REQUEST_MIDAS_MONTH_CARD_PAY})
    public void requestMidasMonthCardPay(RequestEvent requestEvent) {
        try {
            String account = LoginManager.getInstance().getAccount();
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            jSONObject.put("userId", account);
            handleMidasMonthCardPay(this.mMiniAppContext.getAttachActivity(), jSONObject.toString(), requestEvent);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_REQUEST_MIDAS_PAYMENT})
    public void requestMidasPayment(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("offerId");
            jSONObject.put("userId", LoginManager.getInstance().getAccount());
            jSONObject.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 9);
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).checkOfferId(this.mApkgInfo.appId, optString, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.3
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                    String str;
                    LaunchParam launchParam;
                    if (z16) {
                        int optInt = jSONObject2.optInt("result");
                        final String optString2 = jSONObject2.optString("errMsg");
                        String optString3 = jSONObject2.optString("firstRefer");
                        String optString4 = jSONObject2.optString("firstVia");
                        if (optInt == 1) {
                            Activity attachActivity = ((BaseJsPlugin) PayJsPlugin.this).mMiniAppContext.getAttachActivity();
                            if (attachActivity != null) {
                                try {
                                    MiniAppInfo miniAppInfo = ((BaseJsPlugin) PayJsPlugin.this).mMiniAppInfo;
                                    String str2 = "";
                                    if (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) {
                                        str = "";
                                    } else {
                                        str = String.valueOf(launchParam.scene);
                                    }
                                    if (miniAppInfo != null) {
                                        str2 = miniAppInfo.via;
                                    }
                                    PayJsPlugin payJsPlugin = PayJsPlugin.this;
                                    payJsPlugin.putAid(jSONObject, ((BaseJsPlugin) payJsPlugin).mMiniAppInfo.appId, optString3, optString4, str, str2);
                                    jSONObject.put(PayJsPlugin.PAYJSON_KEY_SET_MIDAS_ENV, jSONObject.optInt("setEnv", 0));
                                    if (miniAppInfo != null) {
                                        String str3 = ((BaseJsPlugin) PayJsPlugin.this).mApkgInfo.appId + "_" + miniAppInfo.verType;
                                        ((BaseJsPlugin) PayJsPlugin.this).mContext.getSharedPreferences("keyMiniGamePayEnv", 4).edit().putString("keyMiniGamePayEnvAppidVertype", MD5Utils.encodeHexStr(str3)).commit();
                                        jSONObject.put(PayJsPlugin.PAYJSON_KEY_MINI_APP_VERTYPE_STR, str3);
                                    }
                                } catch (Exception e16) {
                                    QMLog.i(PayJsPlugin.TAG, "setEnv error", e16);
                                }
                                PayJsPlugin.this.handleRechargeGame(requestEvent, attachActivity, jSONObject.toString(), String.valueOf(requestEvent.callbackId), false);
                                return;
                            }
                            PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "activity is null");
                            return;
                        }
                        if (optInt == 0 || optInt == 2) {
                            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MiniToast.makeText(((BaseJsPlugin) PayJsPlugin.this).mContext, optString2, 0).show();
                                }
                            });
                            QMLog.e(PayJsPlugin.TAG, "handleNativeRequest result = " + optInt);
                            PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, optString2);
                            return;
                        }
                        return;
                    }
                    QMLog.e(PayJsPlugin.TAG, "checkOfferId isSuc = " + z16);
                    PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "checkOfferId fail");
                }
            });
        } catch (Exception e16) {
            QMLog.e(TAG, " error,", e16);
            handleNativeResponseFail(requestEvent, null, "");
        }
    }

    @JsEvent({PluginConst.PayJsPluginConst.API_PAY_BY_H5})
    public void requestMidasPaymentByH5(RequestEvent requestEvent) {
        try {
            startPayBrowserActivity(this.mMiniAppContext.getAttachActivity(), requestEvent, processPayByH5Param(new JSONObject(requestEvent.jsonParams)));
        } catch (JSONException e16) {
            QMLog.e(TAG, "requestMidasPaymentByH5: exception=", e16);
        }
    }

    @JsEvent({"requestPayment"})
    public void requestPayment(final RequestEvent requestEvent) {
        ActivityResultManager.g().addActivityResultListener(new IActivityResultListener() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.1
            @Override // com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener
            public boolean doOnActivityResult(int i3, int i16, Intent intent) {
                if (i3 == 3001) {
                    if (i16 == 0) {
                        PayJsPlugin.this.handleNativeResponseCancel(requestEvent, null);
                    }
                    ActivityResultManager.g().removeActivityResultListener(this);
                    return true;
                }
                return false;
            }
        });
        try {
            handleQQPay(requestEvent);
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error,", e16);
            handleNativeResponseFail(requestEvent, null, "");
        }
    }

    @JsEvent({"requestQQPayment"})
    public void requestQQPayment(final RequestEvent requestEvent) {
        Activity activity;
        Bundle bundle;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String str = this.mApkgInfo.appId;
            String optString = jSONObject.optString(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
            String optString2 = jSONObject.optString(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY);
            String optString3 = jSONObject.optString("package");
            String optString4 = jSONObject.optString(PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY);
            String optString5 = jSONObject.optString(PayProxy.Source.PAY_REQUEST_PAY_SIGN_KEY);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appId", str);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, optString);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY, optString2);
            jSONObject2.put("package", optString3);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY, optString4);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_SIGN_KEY, optString5);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_VERSION_KEY, "1");
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_CODE_KEY, 24);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, "9");
            String valueOf = String.valueOf(requestEvent.callbackId);
            Bundle bundle2 = new Bundle();
            bundle2.putString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY, valueOf);
            bundle2.putString(PayProxy.Source.PAY_JSON_EXTRA_KEY, jSONObject2.toString());
            bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 1);
            bundle2.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, System.currentTimeMillis());
            bundle2.putInt(PayProxy.Source.PAY_REQUEST_CODE_KEY, 9);
            bundle2.putString(PayProxy.Source.PAY_REQUEST_SDK_PF, getSDKPf(jSONObject2.toString()));
            IMiniAppContext iMiniAppContext = this.mMiniAppContext;
            if (iMiniAppContext != null) {
                activity = iMiniAppContext.getAttachActivity();
            } else {
                activity = null;
            }
            if (activity != null) {
                PayProxy payProxy = (PayProxy) ProxyManager.get(PayProxy.class);
                if (payProxy == null) {
                    handleNativeResponseFail(requestEvent, null, "not support pay");
                    return;
                }
                bundle = payProxy.midasPay(activity, jSONObject2.toString(), new PayProxy.IPayResultCallBack() { // from class: com.tencent.qqmini.sdk.plugins.PayJsPlugin.2
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
                    public void onPayCallBack(PayProxy.PayResponse payResponse) {
                        PayJsPlugin.this.onPlayCallback(payResponse, requestEvent);
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy.IPayResultCallBack
                    public void payNeedLogin() {
                        QMLog.e(PayJsPlugin.TAG, "requestQQPayment payNeedLogin");
                        PayJsPlugin.this.handleNativeResponseFail(requestEvent, null, "payNeedLogin");
                    }
                }, bundle2);
            } else {
                bundle = null;
            }
            int i3 = 0;
            if (bundle != null) {
                i3 = bundle.getInt("retCode", 0);
            }
            if (bundle != null && i3 != 0) {
                handleNativeResponseFail(requestEvent, null, "retCode:" + i3);
            }
        } catch (Exception e16) {
            QMLog.e(TAG, requestEvent.event + " error,", e16);
            handleNativeResponseFail(requestEvent, null, "");
        }
    }
}
