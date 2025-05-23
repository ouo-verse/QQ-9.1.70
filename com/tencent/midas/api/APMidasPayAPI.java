package com.tencent.midas.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.Toast;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.tencent.midas.api.ability.MidasBaseAbility;
import com.tencent.midas.api.request.APIabResult;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasNetRequest;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.api.request.APQueryInventoryFinishedListener;
import com.tencent.midas.api.request.OnAPConsumeFinishedListener;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogUtil;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginLoader;
import com.tencent.midas.plugin.APPluginStatic;
import com.tencent.midas.plugin.APPluginUtils;
import com.tencent.mobileqq.highway.netprobe.EchoTask;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class APMidasPayAPI {
    public static final String ACCOUNT_TYPE_COMMON = "common";
    public static final String ACCOUNT_TYPE_SECURITY = "secrety";
    public static final String ENV_DEV = "dev";
    public static final String ENV_RELEASE = "release";
    public static final String ENV_TEST = "test";
    public static final String ENV_TESTING = "testing";
    public static final int LANDSCAPE = 0;
    public static final String PAY_CHANNEL_BANK = "bank";
    public static final String PAY_CHANNEL_ECOMMERCE_QQ = "wechat_ecommerce_qq";
    public static final String PAY_CHANNEL_PAYSCORE = "wechat_payscore";
    public static final String PAY_CHANNEL_QQWALLET = "qqwallet";
    public static final String PAY_CHANNEL_UNIONPAY = "wechat_quickpass";
    public static final String PAY_CHANNEL_WECHAT = "wechat";
    public static final int PORTRAINT = 1;
    private static final String TAG = "APMidasPayAPI";
    public static final String WX_COUPONS = "wechatAddCardToWXCardPackage";
    private static String dataPath = "";
    public static String env = "release";
    public static Context fromApplicationContext = null;
    private static String logCallbackClassName = "";
    private static boolean logEnable = true;
    private static int screenType = -1;

    public static void H5Release() {
        if (APMidasPayHelper.x5Webview != null) {
            APMidasPayHelper.x5Webview = null;
        }
        if (APMidasPayHelper.webview != null) {
            APMidasPayHelper.webview = null;
        }
        if (APMidasPayHelper.sIWebView != null) {
            APMidasPayHelper.sIWebView = null;
        }
    }

    public static void InnerH5PayInit(Activity activity, WebView webView) {
        APLog.i(TAG, "InnerH5PayInit enter");
        if (!checkParams(activity)) {
            return;
        }
        APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_INNER_WEBVIEW;
        APMidasPayHelper.h5Init(activity, webView, null);
    }

    public static void InnerH5PayInitX5(Activity activity, com.tencent.smtt.sdk.WebView webView) {
        APLog.i(TAG, "InnerH5PayInit enter");
        if (!checkParams(activity)) {
            return;
        }
        APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_INNER_WEBVIEW;
        APMidasPayHelper.h5Init(activity, null, webView);
    }

    private static boolean checkInitCommParam(Context context, APMidasBaseRequest aPMidasBaseRequest) {
        if (!env.equals("release")) {
            try {
                if (APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay")) {
                    return true;
                }
                if (aPMidasBaseRequest == null) {
                    Toast.makeText(context, "\u521d\u59cb\u5316request\u4e0d\u80fd\u4e3a\u7a7a", 1).show();
                    return false;
                }
                if (TextUtils.isEmpty(aPMidasBaseRequest.offerId)) {
                    Toast.makeText(context, "\u521d\u59cb\u5316offerid\u4e0d\u80fd\u4e3a\u7a7a", 1).show();
                    return false;
                }
                if (TextUtils.isEmpty(aPMidasBaseRequest.openId)) {
                    Toast.makeText(context, "\u521d\u59cb\u5316openId\u4e0d\u80fd\u4e3a\u7a7a", 1).show();
                    return false;
                }
                if (TextUtils.isEmpty(aPMidasBaseRequest.openKey)) {
                    Toast.makeText(context, "\u521d\u59cb\u5316openKey\u4e0d\u80fd\u4e3a\u7a7a", 1).show();
                    return false;
                }
                if (TextUtils.isEmpty(aPMidasBaseRequest.sessionId)) {
                    Toast.makeText(context, "\u521d\u59cb\u5316sessionId\u4e0d\u80fd\u4e3a\u7a7a", 1).show();
                    return false;
                }
                if (TextUtils.isEmpty(aPMidasBaseRequest.sessionType)) {
                    Toast.makeText(context, "\u521d\u59cb\u5316sessionType\u4e0d\u80fd\u4e3a\u7a7a", 1).show();
                    return false;
                }
                if (TextUtils.isEmpty(aPMidasBaseRequest.f151589pf)) {
                    Toast.makeText(context, "\u521d\u59cb\u5316pf\u4e0d\u80fd\u4e3a\u7a7a", 1).show();
                    return false;
                }
                if (TextUtils.isEmpty(aPMidasBaseRequest.pfKey)) {
                    Toast.makeText(context, "\u521d\u59cb\u5316pfKey\u4e0d\u80fd\u4e3a\u7a7a", 1).show();
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private static boolean checkParams(Context context) {
        if (context == null) {
            APLog.e(TAG, "checkParams() context/activity == Null");
            new Throwable("APMidasPayAPI().checkParams() context/activity == Null").printStackTrace();
            return false;
        }
        return true;
    }

    public static void closeAll() {
        APPluginStatic.removeAll();
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 9 */
    public static void consumeAsync(Activity activity, List<APPurchase> list, OnAPConsumeFinishedListener onAPConsumeFinishedListener) {
        Class<?> cls;
        APLog.i(TAG, "consumeAsync enter");
        if (!checkParams(activity)) {
            return;
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        try {
            cls = Class.forName(List.class.getName());
        } catch (ClassNotFoundException e16) {
            APLog.d(TAG, "consumeAsync setEnv e:" + e16.toString());
            cls = null;
        }
        Object call = aPMidasPayHelper.call(activity, APMidasPayHelper.MED_DISTRIBUTE_XGAME_CONSUME, new Object[]{list, onAPConsumeFinishedListener}, new Class[]{cls, OnAPConsumeFinishedListener.class});
        APLog.i(TAG, "consumeAsync ret " + call);
        if (call == null) {
            onAPConsumeFinishedListener.onConsumeFinished(new ArrayList());
        }
    }

    public static void getInfo(Activity activity, String str, APMidasBaseRequest aPMidasBaseRequest, IAPMidasNetCallBack iAPMidasNetCallBack) {
        APLog.i(TAG, "getInfo enter");
        if (!checkParams(activity)) {
            return;
        }
        try {
            fromApplicationContext = activity.getApplicationContext();
        } catch (Exception e16) {
            APLog.i("fromApplicationContext", e16.toString());
        }
        APPluginReportManager.payDataRelease();
        APPluginReportManager.getInstance().payInterfaceInit(aPMidasBaseRequest, APMidasPluginInfo.LAUNCH_INTERFACE_GETINFO);
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_GETINFO, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHINFO);
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        aPMidasPayHelper.getInfo(activity, str, aPMidasBaseRequest, iAPMidasNetCallBack);
    }

    public static String getJSContent(Context context) {
        APLog.i(TAG, "getJSContent enter");
        if (!checkParams(context)) {
            return "";
        }
        return APMidasPayHelper.getJSContent(context);
    }

    public static String getMidasCoreVersion(Activity activity) {
        APLog.i(TAG, "getMidasCoreVersion enter");
        if (!checkParams(activity)) {
            return "";
        }
        return APPluginUtils.getMidasCoreVersionName(activity);
    }

    public static String getMidasPluginVersion() {
        APLog.d(TAG, "getMidasPluginVersion enter " + Thread.currentThread().getStackTrace()[3].toString());
        if (APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay")) {
            return APMidasCommMethod.getApplicationVersion();
        }
        return "1.9.8c";
    }

    public static String getMidasSDKVersion(Activity activity) {
        APLog.i(TAG, "getMidasSDKVersion enter");
        return getMidasCoreVersion(activity);
    }

    public static String getPath() {
        return dataPath;
    }

    public static int h5PayHook(Activity activity, WebView webView, String str, String str2, JsResult jsResult) {
        APLog.i(TAG, "h5PayHook enter");
        if (!checkParams(activity)) {
            return -33;
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        aPMidasPayHelper.setScreenType(screenType);
        return aPMidasPayHelper.h5Pay(activity, webView, null, str, str2);
    }

    public static int h5PayHookX5(Activity activity, com.tencent.smtt.sdk.WebView webView, String str, String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        APLog.i(TAG, "h5PayHookX5 enter");
        if (!checkParams(activity)) {
            return -33;
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        aPMidasPayHelper.setScreenType(screenType);
        return aPMidasPayHelper.h5Pay(activity, null, webView, str, str2);
    }

    public static void h5PayInit(Activity activity, WebView webView) {
        APLog.i(TAG, "h5PayInit enter");
        if (!checkParams(activity)) {
            return;
        }
        APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_OUT_WEBVIEW;
        APMidasPayHelper.h5Init(activity, webView, null);
    }

    public static void h5PayInitUnifier(Activity activity, IAPWebView iAPWebView) {
        APLog.i(TAG, "h5PayInitUnifier enter");
        if (!checkParams(activity)) {
            return;
        }
        APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_OUT_WEBVIEW;
        APMidasPayHelper.h5InitUnifier(activity, iAPWebView);
    }

    public static void h5PayInitX5(Activity activity, com.tencent.smtt.sdk.WebView webView) {
        APLog.i(TAG, "h5PayInitX5 enter");
        if (!checkParams(activity)) {
            return;
        }
        APMidasPayHelper.h5Init(activity, null, webView);
    }

    public static void hfCouponsRollBack(Activity activity, String str) {
        APLog.i(TAG, "hfCouponsRollBack enter");
        if (!checkParams(activity)) {
            return;
        }
        new APMidasPayHelper().call(activity, APMidasPayHelper.MED_DISTRIBUTE_HF_COUPONS_ROLLBACK, new Object[]{str});
    }

    public static void init(Context context, APMidasBaseRequest aPMidasBaseRequest) {
        if (context != null && aPMidasBaseRequest != null) {
            initCommon(context, aPMidasBaseRequest);
            if (checkInitCommParam(context, aPMidasBaseRequest)) {
                APMidasPayHelper.init(context, aPMidasBaseRequest);
                return;
            } else {
                APMidasPayHelper.isNewProcess = APMidasPayHelper.isNewProcess(context);
                return;
            }
        }
        APLog.e(TAG, "init parameter is null!");
    }

    private static void initCommon(Context context, APMidasBaseRequest aPMidasBaseRequest) {
        APPluginReportManager.initDataRelease();
        APPluginReportManager.getInstance().initInterfaceInit("init", aPMidasBaseRequest);
        APLogUtil.initAPLogInPlugin(context.getApplicationContext(), logEnable, logCallbackClassName);
        APLog.i(TAG, "init new enter");
        APPluginReportManager.getInstance().insertTimeData("init", APPluginReportManager.MIDASPLUGIN_TIMENAME_INIT);
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
    }

    public static void launchAbility(Context context, MidasBaseAbility midasBaseAbility, final ResultReceiver resultReceiver) {
        APLog.i(TAG, "launchAbility enter : " + midasBaseAbility.toString());
        if (APMidasTools.isFastClick()) {
            APLog.i("launchAbility", "isfast");
            if (resultReceiver != null) {
                Bundle bundle = new Bundle();
                bundle.putString("midas_callback_ability_postBack", midasBaseAbility.postBack);
                bundle.putInt("midas_callback_ability_code", -999);
                bundle.putString("midas_callback_ability_msg", "fast click");
                bundle.putBundle("midas_callback_ability_data", new Bundle());
                resultReceiver.send(-1, bundle);
                return;
            }
            return;
        }
        if (!checkParams(context)) {
            return;
        }
        APPluginReportManager.payDataRelease();
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        aPMidasGameRequest.offerId = midasBaseAbility.offerId;
        aPMidasGameRequest.openId = midasBaseAbility.openId;
        aPMidasGameRequest.openKey = midasBaseAbility.openKey;
        aPMidasGameRequest.sessionId = midasBaseAbility.sessionId;
        aPMidasGameRequest.sessionType = midasBaseAbility.sessionType;
        aPMidasGameRequest.f151589pf = midasBaseAbility.f151588pf;
        aPMidasGameRequest.pfKey = midasBaseAbility.pfKey;
        APPluginReportManager.getInstance().payInterfaceInit(aPMidasGameRequest, APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHFEATURE);
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHFEATURE, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHABILITY);
        APPluginReportManager.getInstance().insertData(APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHABILITY, APPluginReportManager.MIDASPLUGIN_ENTER_ABILITY, "MidasPlugin", midasBaseAbility.toString());
        new APMidasPayHelper().sendMidas(context, midasBaseAbility.toBundle(), new ResultReceiver(new Handler()) { // from class: com.tencent.midas.api.APMidasPayAPI.1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle2) {
                APLog.i(APMidasPayAPI.TAG, "launchAbility.onReceiveResult() resultCode=" + i3 + ", resultData=" + bundle2);
                ResultReceiver resultReceiver2 = resultReceiver;
                if (resultReceiver2 != null) {
                    resultReceiver2.send(i3, bundle2);
                    APPluginReportManager.getInstance().dataReport("launchAbility");
                    APPluginUtils.release();
                    APLog.closeLog();
                }
            }
        });
    }

    public static void launchNet(Activity activity, APMidasNetRequest aPMidasNetRequest, IAPMidasNetCallBack iAPMidasNetCallBack) {
        APLog.i(TAG, "launchNet enter");
        if (!checkParams(activity)) {
            return;
        }
        try {
            fromApplicationContext = activity.getApplicationContext();
        } catch (Exception e16) {
            APLog.i("fromApplicationContext", e16.toString());
        }
        APPluginReportManager.payDataRelease();
        APPluginReportManager.getInstance().payInterfaceInit(aPMidasNetRequest, APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHNET);
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHNET, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHNET);
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        aPMidasPayHelper.net(activity, aPMidasNetRequest, iAPMidasNetCallBack);
    }

    public static void launchPay(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        APLog.i(TAG, "launchPay enter");
        if (!checkParams(activity)) {
            return;
        }
        try {
            fromApplicationContext = activity.getApplicationContext();
        } catch (Exception e16) {
            APLog.i("fromApplicationContext", e16.toString());
        }
        if (APMidasTools.isFastClick()) {
            APLog.i("launchPay", "isfast");
            APLog.w(TAG, "launchPay enter fast:" + iAPMidasPayCallBack);
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = -1;
            aPMidasResponse.payChannel = -1;
            aPMidasResponse.payState = 2;
            aPMidasResponse.provideState = -1;
            aPMidasResponse.resultMsg = "fast click";
            iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
            return;
        }
        APPluginReportManager.payDataRelease();
        APPluginReportManager.getInstance().payInterfaceInit(aPMidasBaseRequest, APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY);
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        aPMidasPayHelper.setScreenType(screenType);
        aPMidasPayHelper.pay(activity, aPMidasBaseRequest, iAPMidasPayCallBack);
    }

    public static void launchPayScoreContract(Activity activity, APMidasGoodsRequest aPMidasGoodsRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        APLog.i(TAG, "launchPayScoreContract enter");
        if (checkParams(activity) && aPMidasGoodsRequest != null && !TextUtils.isEmpty(aPMidasGoodsRequest.extendInfo.contractDomain) && !TextUtils.isEmpty(aPMidasGoodsRequest.extendInfo.ecOfferId) && !TextUtils.isEmpty(aPMidasGoodsRequest.extendInfo.ecSubOfferId)) {
            try {
                fromApplicationContext = activity.getApplicationContext();
            } catch (Exception e16) {
                APLog.i("fromApplicationContext", e16.toString());
            }
            if (APMidasTools.isFastClick()) {
                APLog.e("launchPayScoreContract", "fast click");
                APMidasResponse aPMidasResponse = new APMidasResponse();
                aPMidasResponse.resultCode = -1;
                aPMidasResponse.payChannel = -1;
                aPMidasResponse.payState = 2;
                aPMidasResponse.provideState = -1;
                aPMidasResponse.resultMsg = "fast click";
                iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
                return;
            }
            APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
            APMidasPayHelper.setEnv(env);
            APMidasPayHelper.setLogEnable(logEnable);
            APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
            aPMidasPayHelper.setScreenType(screenType);
            aPMidasPayHelper.payScoreContract(activity, aPMidasGoodsRequest, iAPMidasPayCallBack);
            return;
        }
        APLog.e(TAG, "launchPayScoreContract params error");
        APMidasResponse aPMidasResponse2 = new APMidasResponse();
        aPMidasResponse2.resultCode = 3;
        aPMidasResponse2.payChannel = -1;
        aPMidasResponse2.payState = 2;
        aPMidasResponse2.provideState = -1;
        aPMidasResponse2.resultMsg = "\u7b7e\u7ea6\u53c2\u6570\u9519\u8bef";
        iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse2);
    }

    public static void launchPaySign(Activity activity, APMidasGoodsRequest aPMidasGoodsRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        APLog.i(TAG, "launchPaySign enter");
        if (!checkParams(activity)) {
            return;
        }
        try {
            fromApplicationContext = activity.getApplicationContext();
        } catch (Exception e16) {
            APLog.i("fromApplicationContext", e16.toString());
        }
        if (APMidasTools.isFastClick()) {
            APLog.i("launchPaySign", "isfast");
            APLog.w(TAG, "launchPaySign enter fast:" + iAPMidasPayCallBack);
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = -1;
            aPMidasResponse.payChannel = -1;
            aPMidasResponse.payState = 2;
            aPMidasResponse.provideState = -1;
            aPMidasResponse.resultMsg = "fast click";
            iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
            return;
        }
        if (!TextUtils.isEmpty(aPMidasGoodsRequest.reserv)) {
            aPMidasGoodsRequest.reserv += "&wechattype=sign";
        } else {
            aPMidasGoodsRequest.reserv = "wechattype=sign";
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        aPMidasPayHelper.setScreenType(screenType);
        aPMidasPayHelper.signPay(activity, aPMidasGoodsRequest, iAPMidasPayCallBack);
    }

    public static void launchPurchaseFlow(Activity activity, APMidasBaseRequest aPMidasBaseRequest, final APOnIabPurchaseFinished aPOnIabPurchaseFinished) {
        boolean z16;
        APLog.i(TAG, "launchPurchaseFlow enter");
        if (!checkParams(activity)) {
            return;
        }
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        if (aPMidasBaseRequest != null && ((z16 = aPMidasBaseRequest instanceof APMidasGoodsRequest))) {
            if (z16) {
                ((APMidasGoodsRequest) aPMidasBaseRequest).mIsReceiptMode = true;
            }
            APMidasGoodsRequest aPMidasGoodsRequest = (APMidasGoodsRequest) aPMidasBaseRequest;
            aPMidasGoodsRequest.isCanChange = false;
            aPMidasGoodsRequest.saveValue = "1";
            aPMidasGoodsRequest.tokenType = 2;
            launchPay(activity, aPMidasBaseRequest, new IAPMidasPayCallBack() { // from class: com.tencent.midas.api.APMidasPayAPI.2
                @Override // com.tencent.midas.api.IAPMidasPayCallBack
                public void MidasPayCallBack(APMidasResponse aPMidasResponse) {
                    int resultCode = aPMidasResponse.getResultCode();
                    if (aPMidasResponse.resultCode == 100) {
                        resultCode = 101;
                    }
                    APOnIabPurchaseFinished.this.onIabPurchaseFinished(new APIabResult(resultCode, aPMidasResponse.getResultMsg()), aPMidasResponse.getReceipt());
                }

                @Override // com.tencent.midas.api.IAPMidasPayCallBack
                public void MidasPayNeedLogin() {
                    APOnIabPurchaseFinished.this.onIabyNeedLogin();
                }
            });
            return;
        }
        aPOnIabPurchaseFinished.onIabPurchaseFinished(new APIabResult(3, ""), null);
        APLog.e("launchPurchaseFlow", "parameter is error");
    }

    public static void launchWXMiniProgram(Context context, Bundle bundle, ResultReceiver resultReceiver) {
        APLog.i(TAG, "launchWXMiniProgram enter");
        if (!checkParams(context)) {
            return;
        }
        if (!(context instanceof Activity)) {
            APLog.e("launchAbility", "context is not Activity : " + context);
            if (!"release".equals(env)) {
                Toast.makeText(context.getApplicationContext(), "Input context must be Activity", 1).show();
            }
            if (resultReceiver != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("midas_callback_ability_code", EchoTask.ECHO_SERVER_EXCEPTION);
                bundle2.putString("midas_callback_ability_msg", "context is not Activity ");
                bundle2.putBundle("midas_callback_ability_data", new Bundle());
                resultReceiver.send(-101, bundle2);
                return;
            }
            return;
        }
        new APMidasPayHelper().launchWXMiniProgram(context, bundle, resultReceiver);
    }

    public static void launchWXMiniProgram_OnResponse(Context context, int i3, Bundle bundle) {
        APLog.i(TAG, "launchWXMiniProgram_OnResponse enter");
        APLog.i(TAG, "launchWXMiniProgram_OnResponse enter: bundle = " + bundle);
        if (!checkParams(context)) {
            return;
        }
        if (!(context instanceof Activity)) {
            APLog.e("launchAbility", "context is not Activity : " + context);
            if (!"release".equals(env)) {
                Toast.makeText(context.getApplicationContext(), "Input context must be Activity", 1).show();
                return;
            }
            return;
        }
        new APMidasPayHelper().launchWXMiniProgram_OnResponse(context, i3, bundle);
    }

    public static void launchWeChat(Activity activity, JSONObject jSONObject, IAPMidasPayCallBack iAPMidasPayCallBack) {
        APLog.i(TAG, "launchWeChat enter");
        if (!checkParams(activity)) {
            return;
        }
        try {
            fromApplicationContext = activity.getApplicationContext();
        } catch (Exception e16) {
            APLog.i("fromApplicationContext", e16.toString());
        }
        if (APMidasTools.isFastClick()) {
            APLog.i("launchWeChat", "isfast");
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = -1;
            aPMidasResponse.payChannel = -1;
            aPMidasResponse.payState = 2;
            aPMidasResponse.provideState = -1;
            aPMidasResponse.resultMsg = "fast click";
            iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
            return;
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        aPMidasPayHelper.setScreenType(screenType);
        aPMidasPayHelper.launchWeChat(activity, jSONObject, iAPMidasPayCallBack);
    }

    public static void launchWeb(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        APLog.i(TAG, "launchWeb enter");
        if (!checkParams(activity)) {
            return;
        }
        try {
            fromApplicationContext = activity.getApplicationContext();
        } catch (Exception e16) {
            APLog.i("fromApplicationContext", e16.toString());
        }
        APPluginReportManager.payDataRelease();
        APPluginReportManager.getInstance().payInterfaceInit(aPMidasBaseRequest, APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHWEB);
        APPluginReportManager.getInstance().insertTimeData(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHWEB, APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHWEB);
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        APMidasPayHelper.setEnv(env);
        APMidasPayHelper.setLogEnable(logEnable);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        aPMidasPayHelper.setScreenType(screenType);
        aPMidasPayHelper.web(activity, aPMidasBaseRequest, iAPMidasPayCallBack);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 10 */
    public static void queryInventoryAsync(Activity activity, boolean z16, List<?> list, APQueryInventoryFinishedListener aPQueryInventoryFinishedListener) {
        Class<?> cls;
        APLog.i(TAG, "queryInventoryAsync enter");
        if (!checkParams(activity)) {
            return;
        }
        APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
        try {
            cls = Class.forName(List.class.getName());
        } catch (ClassNotFoundException e16) {
            APLog.d(TAG, "queryInventoryAsync setEnv e:" + e16.toString());
            cls = null;
        }
        Object call = aPMidasPayHelper.call(activity, APMidasPayHelper.MED_DISTRIBUTE_XGAME_QUERY, new Object[]{Boolean.valueOf(z16), list, aPQueryInventoryFinishedListener}, new Class[]{Boolean.class, cls, APQueryInventoryFinishedListener.class});
        APLog.i(TAG, "queryInventoryAsync ret " + call);
        if (call == null) {
            aPQueryInventoryFinishedListener.onQueryInventoryFinished(new APIabResult(-1, ""), null);
        }
    }

    public static void release(Activity activity) {
        APLog.i(TAG, "release() enter");
        APMidasPayHelper.releaseSDK(activity);
    }

    public static void setCutoutEnable(boolean z16) {
        APMidasPayHelper.cutoutEnable = z16;
    }

    public static void setEnv(String str) {
        env = str;
        APMidasPayHelper.setEnv(str);
        Context context = fromApplicationContext;
        if (context != null && (context instanceof Activity)) {
            new APMidasPayHelper().call(fromApplicationContext, "setEnv", new Class[]{String.class}, new Object[]{str});
        }
        APLog.d("MidasPluginSDK", "env= " + env);
    }

    public static <T extends IMidasLogCallback> void setLogCallback(Class<T> cls) {
        logCallbackClassName = cls.getName();
    }

    public static void setLogEnable(boolean z16) {
        logEnable = z16;
        APMidasPayHelper.setLogEnable(z16);
        APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
        Context context = fromApplicationContext;
        if (context != null && (context instanceof Activity)) {
            new APMidasPayHelper().call(fromApplicationContext, "setLogEnable", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z16)});
        }
    }

    public static void setLongConnection(Context context, boolean z16) {
        APMidasPayHelper.setLongConnection(context, z16);
    }

    public static void setParentClassloader(DexClassLoader dexClassLoader) {
        APLog.i(TAG, "setParentClassloader enter classLoader:" + dexClassLoader);
        APPluginLoader.setParentClassLoader(dexClassLoader);
    }

    public static void setPath(String str) {
        APLog.i(TAG, "setPath enter path:" + str);
        dataPath = str;
    }

    public static void setScreenType(Activity activity, int i3) {
        screenType = i3;
    }

    public static void setSoMonitorCallback(IMidasSoCallback iMidasSoCallback) {
        APMidasPayHelper.midasSoCallback = iMidasSoCallback;
    }

    public static void init(Context context, APMidasBaseRequest aPMidasBaseRequest, ResultReceiver resultReceiver) {
        initCommon(context, aPMidasBaseRequest);
        if (checkInitCommParam(context, aPMidasBaseRequest)) {
            APMidasPayHelper.init(context, aPMidasBaseRequest, resultReceiver);
        } else {
            APMidasPayHelper.isNewProcess = APMidasPayHelper.isNewProcess(context);
        }
    }
}
