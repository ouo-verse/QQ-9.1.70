package com.tencent.midas.control;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.pay.tool.APMidasTools;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasNetCallBack;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.IAPWebView;
import com.tencent.midas.api.IMidasSoCallback;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasNetRequest;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.comm.APIPConfig;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APPluginDataStorage;
import com.tencent.midas.control.APCallBackResultReceiver;
import com.tencent.midas.data.APDataId;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.midas.data.APMultiProcessData;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.jsbridge.APWebJSBridgeActivity;
import com.tencent.midas.plugin.APPluginChecker;
import com.tencent.midas.plugin.APPluginInstallerAndUpdater;
import com.tencent.midas.plugin.APPluginInterfaceManager;
import com.tencent.midas.plugin.APPluginLoader;
import com.tencent.midas.plugin.APPluginUtils;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.raft.measure.utils.MeasureConst;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tenpay.sdk.net.core.comm.CGIErrorCode;
import cooperation.qzone.QzoneIPCModule;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public class APMidasPayHelper implements APCallBackResultReceiver.Receiver {
    public static String MED_DISTRIBUTE_CALL = "openMidasCall";
    public static String MED_DISTRIBUTE_CALL2 = "openMidasCall2";
    public static final String MED_DISTRIBUTE_CALLBACK_FROM_MIDAS_PAY = "callbackFromMidasPay";
    public static String MED_DISTRIBUTE_H5PAY = "openMidasH5Pay";
    public static String MED_DISTRIBUTE_HANDLE_QQ_WALLET_INTENT = "handleQQWalletIntent";
    public static String MED_DISTRIBUTE_HANDLE_WX_INTENT = "handleWXIntent";
    public static final String MED_DISTRIBUTE_HF_COUPONS_ROLLBACK = "hfCouponsRollBack";
    public static String MED_DISTRIBUTE_INFO = "openMidasInfo";
    public static String MED_DISTRIBUTE_INIT = "golbalInit";
    public static String MED_DISTRIBUTE_LongConnection = "setLongConnection";
    public static String MED_DISTRIBUTE_NET = "openMidasNet";
    public static String MED_DISTRIBUTE_PAY = "openMidasPay";
    public static String MED_DISTRIBUTE_PYA_SCORE_CONTRACT = "openMidasPayScoreContract";
    public static String MED_DISTRIBUTE_RECEIVE = "receiveMidas";
    public static String MED_DISTRIBUTE_RELEASE = "release";
    public static String MED_DISTRIBUTE_SIGN_PAY = "openMidasSignPay";
    public static String MED_DISTRIBUTE_WEB = "openMidasWeb";
    public static String MED_DISTRIBUTE_WECHATPAY = "openMidasWechatPay";
    public static final String MED_DISTRIBUTE_WX_MINIPROGRAM = "launchWXMiniProgram";
    public static final String MED_DISTRIBUTE_WX_MINIPROGRAM_ONRESPONSE = "launchWXMiniProgram_OnResponse";
    public static final String MED_DISTRIBUTE_XGAME_CONSUME = "consumeAsync";
    public static final String MED_DISTRIBUTE_XGAME_QUERY = "queryInventoryAsync";
    public static int MIDAS_INNER_WEBVIEW = 0;
    public static int MIDAS_OUT_WEBVIEW = 1;
    public static String MIDAS_PLUGIN_NAME = "MidasPay";
    public static final String MIDAS_PLUGIN_VERSION = "1.9.8c";
    public static int MIDAS_WEBVIEW = 0;
    public static String PKG_DISTRIBUTE = "com.tencent.midas.pay.APMidasDistribute";
    public static final int PLUGIN_INITFAIL = 2;
    private static final int PLUGIN_INITIDLE = -1;
    public static final int PLUGIN_INITING = 0;
    public static final int PLUGIN_INITSUCC = 1;
    private static final int RET_CHANGE_H5 = -100011;
    private static final String RET_MSG_CHANGE_H5 = "needChangeH5";
    private static final String TAG = "APMidasPayHelper";
    public static boolean cutoutEnable = false;
    private static String env = "release";
    public static boolean hasCheckedProcess = false;
    private static int initCount = 0;
    private static APMidasBaseRequest initRequest = null;
    public static int initState = -1;
    private static boolean isInitSucc = false;
    private static boolean isNeedLocalUpdate = false;
    public static boolean isNewProcess = false;
    public static boolean isPayCenterSDK = false;
    private static String logCallbackClassName = "";
    private static boolean logEnable = false;
    public static IAPMidasPayCallBack midasCallBack = null;
    public static IMidasSoCallback midasSoCallback = null;
    public static IAPMidasNetCallBack netCallBack = null;
    private static String netCallBack_ReqType = "";
    private static APCallBackResultReceiver remotRecevier;
    public static APMidasBaseRequest requestObject;
    public static IAPWebView sIWebView;
    public static Context staticActivityContext;
    public static WebView webview;
    public static com.tencent.smtt.sdk.WebView x5Webview;
    private static Object initObject = new Object();
    private static Object dexloadObject = new Object();
    private static Object loadingObject = new Object();
    public int saveType = 0;
    public int screenType = 0;
    Object retobj = null;

    static /* synthetic */ int access$508() {
        int i3 = initCount;
        initCount = i3 + 1;
        return i3;
    }

    public static synchronized String getJSContent(Context context) {
        String str;
        synchronized (APMidasPayHelper.class) {
            APLog.i(TAG, "getJSContent");
            init(context, null);
            str = (String) new APMidasPayHelper().callWithContext(context, "getH5JS", new Object[]{context});
        }
        return str;
    }

    public static String getLogCallbackClassName() {
        return logCallbackClassName;
    }

    @SuppressLint({"NewApi"})
    public static synchronized void h5Init(final Activity activity, WebView webView, com.tencent.smtt.sdk.WebView webView2) {
        synchronized (APMidasPayHelper.class) {
            APLog.i(TAG, "h5Init");
            APPluginReportManager.getInstance().reportImmediatelyOneRecord("init", APPluginReportManager.MIDASPLUGIN_H5_INIT, "");
            x5Webview = webView2;
            webview = webView;
            isNewProcess = isNewProcess(activity);
            if (initCount < 1) {
                APPluginUtils.release();
                preLoadPlugin(activity, "init", new IAPInitCallBack() { // from class: com.tencent.midas.control.APMidasPayHelper.4
                    @Override // com.tencent.midas.control.IAPInitCallBack
                    public void result(int i3, String str, String str2, Bundle bundle) {
                        APLog.i(APMidasPayHelper.TAG, "init ret:" + i3 + " msg:" + str);
                        APPluginReportManager.getInstance().dataReport("init");
                        if (i3 == 0) {
                            APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
                            Activity activity2 = activity;
                            String str3 = (String) aPMidasPayHelper.call(activity2, "getH5JS", new Object[]{activity2});
                            if (!TextUtils.isEmpty(str3)) {
                                try {
                                    WebView webView3 = APMidasPayHelper.webview;
                                    if (webView3 != null) {
                                        webView3.loadUrl(a.JAVASCRIPT_PREFIX + str3);
                                    }
                                    com.tencent.smtt.sdk.WebView webView4 = APMidasPayHelper.x5Webview;
                                    if (webView4 != null) {
                                        webView4.loadUrl(a.JAVASCRIPT_PREFIX + str3);
                                    }
                                    APPluginReportManager.getInstance().reportImmediatelyOneRecord("init", APPluginReportManager.MIDASPLUGIN_H5_LOAD_JS, "");
                                } catch (Exception e16) {
                                    APLog.w(APMidasPayHelper.TAG, "h5Init loadJS error:" + e16.toString());
                                }
                            }
                            boolean unused = APMidasPayHelper.isInitSucc = true;
                            APMidasPayHelper.access$508();
                        }
                    }
                });
            } else {
                String str = (String) new APMidasPayHelper().call(activity, "getH5JS", new Object[]{activity});
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (webview != null) {
                            webView.loadUrl(a.JAVASCRIPT_PREFIX + str);
                        }
                        com.tencent.smtt.sdk.WebView webView3 = x5Webview;
                        if (webView3 != null) {
                            webView3.loadUrl(a.JAVASCRIPT_PREFIX + str);
                        }
                        APPluginReportManager.getInstance().reportImmediatelyOneRecord("init", APPluginReportManager.MIDASPLUGIN_H5_LOAD_JS, "");
                    } catch (Exception e16) {
                        APLog.w(TAG, "h5Init loadJS error:" + e16.toString());
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static synchronized void h5InitUnifier(final Activity activity, IAPWebView iAPWebView) {
        synchronized (APMidasPayHelper.class) {
            APLog.i(TAG, "h5InitUnifier");
            sIWebView = iAPWebView;
            isNewProcess = isNewProcess(activity);
            if (initCount < 1) {
                APPluginUtils.release();
                preLoadPlugin(activity, "init", new IAPInitCallBack() { // from class: com.tencent.midas.control.APMidasPayHelper.3
                    @Override // com.tencent.midas.control.IAPInitCallBack
                    public void result(int i3, String str, String str2, Bundle bundle) {
                        APLog.i(APMidasPayHelper.TAG, "h5InitUnifier ret:" + i3 + " msg:" + str);
                        APPluginReportManager.getInstance().dataReport("init");
                        if (i3 == 0) {
                            APMidasPayHelper aPMidasPayHelper = new APMidasPayHelper();
                            Activity activity2 = activity;
                            String str3 = (String) aPMidasPayHelper.call(activity2, "getH5JS", new Object[]{activity2});
                            if (!TextUtils.isEmpty(str3)) {
                                try {
                                    IAPWebView iAPWebView2 = APMidasPayHelper.sIWebView;
                                    if (iAPWebView2 != null) {
                                        iAPWebView2.loadUrl(a.JAVASCRIPT_PREFIX + str3);
                                    }
                                } catch (Exception e16) {
                                    APLog.w(APMidasPayHelper.TAG, "h5InitUnifier loadJS error:" + e16.toString());
                                }
                            }
                            boolean unused = APMidasPayHelper.isInitSucc = true;
                            APMidasPayHelper.access$508();
                        }
                    }
                });
            } else {
                String str = (String) new APMidasPayHelper().call(activity, "getH5JS", new Object[]{activity});
                if (!TextUtils.isEmpty(str)) {
                    try {
                        IAPWebView iAPWebView2 = sIWebView;
                        if (iAPWebView2 != null) {
                            iAPWebView2.loadUrl(a.JAVASCRIPT_PREFIX + str);
                        }
                    } catch (Exception e16) {
                        APLog.w(TAG, "h5InitUnifier loadJS error:" + e16.toString());
                    }
                }
            }
        }
    }

    public static synchronized void init(Context context, APMidasBaseRequest aPMidasBaseRequest) {
        synchronized (APMidasPayHelper.class) {
            init(context, aPMidasBaseRequest, null);
        }
    }

    public static boolean isLogEnable() {
        return logEnable;
    }

    public static boolean isNewProcess(Context context) {
        if (hasCheckedProcess) {
            return isNewProcess;
        }
        try {
            hasCheckedProcess = true;
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            ActivityInfo[] activityInfoArr = InstalledAppListMonitor.getPackageInfo(packageManager, InstalledAppListMonitor.getPackageInfo(packageManager, context.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (activityInfo.name.equals("com.tencent.midas.proxyactivity.APMidasPayProxyActivity")) {
                    String str = activityInfo.processName;
                    if (!TextUtils.isEmpty(str) && str.contains("midasPay")) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
            hasCheckedProcess = false;
        }
        return false;
    }

    public static void midasCallBack(APMidasResponse aPMidasResponse) {
        if (aPMidasResponse != null && aPMidasResponse.resultCode == RET_CHANGE_H5 && RET_MSG_CHANGE_H5.equals(aPMidasResponse.resultMsg) && APWebJSBridgeActivity.startPureH5Pay(staticActivityContext, "", "change_h5_from_cgi")) {
            staticActivityContext = null;
            return;
        }
        APLog.i(TAG, "midasCallBack resultCode :" + aPMidasResponse.resultCode + " midasCallBack:" + midasCallBack);
        IAPMidasPayCallBack iAPMidasPayCallBack = midasCallBack;
        if (iAPMidasPayCallBack != null) {
            iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
            midasCallBack = null;
        }
        APCallBackResultReceiver aPCallBackResultReceiver = remotRecevier;
        if (aPCallBackResultReceiver != null) {
            aPCallBackResultReceiver.setReceiver(null);
            remotRecevier = null;
        }
        APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        requestObject = null;
        APPluginUtils.release();
        APLog.closeLog();
        staticActivityContext = null;
    }

    public static void midasH5CallBack(String str) {
        APLog.i(TAG, "midasH5CallBack params:" + str + " webview:" + webview + " x5Webview:" + x5Webview);
        WebView webView = webview;
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Exception e16) {
                APLog.w(TAG, "midasH5CallBack error:" + e16.toString());
            }
        }
        com.tencent.smtt.sdk.WebView webView2 = x5Webview;
        if (webView2 != null) {
            try {
                webView2.loadUrl(str);
            } catch (Exception e17) {
                APLog.w(TAG, "midasH5CallBack error:" + e17.toString());
            }
        }
        APCallBackResultReceiver aPCallBackResultReceiver = remotRecevier;
        if (aPCallBackResultReceiver != null) {
            aPCallBackResultReceiver.setReceiver(null);
            remotRecevier = null;
        }
        APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        APPluginUtils.release();
        APLog.closeLog();
        staticActivityContext = null;
        requestObject = null;
    }

    public static void midasLoginExpire() {
        IAPMidasPayCallBack iAPMidasPayCallBack = midasCallBack;
        if (iAPMidasPayCallBack != null) {
            iAPMidasPayCallBack.MidasPayNeedLogin();
            midasCallBack = null;
        }
        APCallBackResultReceiver aPCallBackResultReceiver = remotRecevier;
        if (aPCallBackResultReceiver != null) {
            aPCallBackResultReceiver.setReceiver(null);
            remotRecevier = null;
        }
        APPluginReportManager.getInstance().dataReport(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        APPluginUtils.release();
        APLog.closeLog();
        staticActivityContext = null;
        requestObject = null;
    }

    public static void onNetError(String str, Integer num, String str2) {
        IAPMidasNetCallBack iAPMidasNetCallBack = netCallBack;
        if (iAPMidasNetCallBack != null) {
            iAPMidasNetCallBack.MidasNetError(str, num.intValue(), str2);
            netCallBack = null;
            netCallBack_ReqType = "";
        }
        staticActivityContext = null;
    }

    public static void onNetFinish(String str, String str2) {
        IAPMidasNetCallBack iAPMidasNetCallBack = netCallBack;
        if (iAPMidasNetCallBack != null) {
            iAPMidasNetCallBack.MidasNetFinish(str, str2);
            netCallBack = null;
            netCallBack_ReqType = "";
        }
        staticActivityContext = null;
    }

    public static void onNetStop(String str) {
        IAPMidasNetCallBack iAPMidasNetCallBack = netCallBack;
        if (iAPMidasNetCallBack != null) {
            iAPMidasNetCallBack.MidasNetStop(str);
            netCallBack = null;
            netCallBack_ReqType = "";
        }
        staticActivityContext = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openPlugin(Activity activity, Intent intent, String str) {
        Object obj;
        APLog.d(TAG, "Calling into openPlugin, method = " + str + " caller = " + Thread.currentThread().getStackTrace()[3].toString());
        try {
            obj = APPluginInterfaceManager.initPluginInterface(activity, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, str, new Object[]{activity, intent});
        } catch (Exception e16) {
            e16.printStackTrace();
            obj = null;
        }
        try {
            APPluginReportManager.getInstance().dataReport(APPluginDataInterface.singleton().getLaunchInterface());
        } catch (Exception e17) {
            APLog.i(TAG, "openPlugin dataReport:" + e17.toString());
        }
        APLog.i(TAG, "openPlugin obj:" + obj);
    }

    private void pluginInitErrCallBack(final Activity activity) {
        APLog.i(TAG, "pluginInitErrCallBack" + midasCallBack);
        if (APWebJSBridgeActivity.startPureH5Pay(activity, APPluginUtils.getInitErrorMsg(), "pluginInitErrCallBack")) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.14
            @Override // java.lang.Runnable
            public void run() {
                APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_ERROR, "", APPluginUtils.getInitErrorMsg());
                Toast.makeText(activity, "\u817e\u8baf\u652f\u4ed8\u670d\u52a1\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5", 1).show();
                APMidasResponse aPMidasResponse = new APMidasResponse();
                aPMidasResponse.resultCode = -100;
                IAPMidasPayCallBack iAPMidasPayCallBack = APMidasPayHelper.midasCallBack;
                if (iAPMidasPayCallBack != null) {
                    iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
                    APMidasPayHelper.midasCallBack = null;
                    APMidasPayHelper.requestObject = null;
                    APMidasPayHelper.staticActivityContext = null;
                }
                IAPMidasNetCallBack iAPMidasNetCallBack = APMidasPayHelper.netCallBack;
                if (iAPMidasNetCallBack != null) {
                    iAPMidasNetCallBack.MidasNetError(APMidasPayHelper.netCallBack_ReqType, -100, "\u817e\u8baf\u652f\u4ed8\u670d\u52a1\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5");
                    APMidasPayHelper.netCallBack = null;
                    String unused = APMidasPayHelper.netCallBack_ReqType = "";
                    APMidasPayHelper.requestObject = null;
                    APMidasPayHelper.staticActivityContext = null;
                }
                APPluginReportManager.getInstance().dataReport(APPluginDataInterface.singleton().getLaunchInterface());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void preLoadMidasPay(final Context context, final String str, final IAPInitCallBack iAPInitCallBack) {
        int i3;
        APLog.d(TAG, "Calling into preLoadMidasPay " + Thread.currentThread().getStackTrace()[3].toString());
        APPluginUtils.deletePluginOat(context);
        if (isPayCenterSDK) {
            APIPConfig.loadIPMappingFile(context);
        }
        System.currentTimeMillis();
        if (isNeedLocalUpdate) {
            APLog.d(TAG, "Calling into preLoadMidasPay isNeedLocalUpdate == true");
            APPluginInstallerAndUpdater.installFromLocal(context);
            APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_INSTALL_FROM_LOCAL, System.currentTimeMillis());
            isNeedLocalUpdate = false;
        } else {
            APLog.d(TAG, "Calling into preLoadMidasPay isNeedLocalUpdate == false");
        }
        long currentTimeMillis = System.currentTimeMillis();
        int isNeedUpdateFromAssets = APPluginInstallerAndUpdater.isNeedUpdateFromAssets(context, env);
        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_IS_NEED_ASSETS_UPDATE, currentTimeMillis);
        APLog.d(TAG, "preLoadMidasPay isNeedUpdateFromAssets = " + isNeedUpdateFromAssets);
        if (isNeedUpdateFromAssets > 0) {
            long currentTimeMillis2 = System.currentTimeMillis();
            i3 = APPluginInstallerAndUpdater.installPlugin(context, isNeedUpdateFromAssets);
            APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_INSTALL_FROM_ASSETS, currentTimeMillis2);
        } else {
            i3 = 0;
        }
        APLog.i(TAG, "preLoadMidasPay installPlugin ret:" + i3 + " initRequest:" + initRequest);
        synchronized (initObject) {
            if (i3 != 0) {
                initCount = 0;
                initState = 2;
                if (iAPInitCallBack != null) {
                    iAPInitCallBack.result(-1, APPluginUtils.getInitErrorMsg(), str, null);
                }
            } else {
                long currentTimeMillis3 = System.currentTimeMillis();
                boolean isPluginValid = APPluginChecker.isPluginValid(context);
                APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_PLUGIN_VALID, currentTimeMillis3);
                if (!isPluginValid) {
                    APLog.i(TAG, "preLoadMidasPay isPluginValid false");
                    APPluginInstallerAndUpdater.unInstallPlugin(context);
                    initState = -1;
                    if (iAPInitCallBack != null) {
                        initCount = 0;
                        iAPInitCallBack.result(-1, "\u652f\u4ed8\u63d2\u4ef6\u6821\u9a8c\u5931\u8d25", str, null);
                    }
                    synchronized (loadingObject) {
                        loadingObject.notifyAll();
                    }
                } else {
                    try {
                        long currentTimeMillis4 = System.currentTimeMillis();
                        APPluginLoader.preCreateClassLoaderByPath(context);
                        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_LOAD_DEX, currentTimeMillis4);
                    } catch (Exception e16) {
                        APLog.e(TAG, "preLoadMidasPay preCreateClassLoaderByPath e: " + e16.toString());
                        e16.printStackTrace();
                    }
                    final String name = Thread.currentThread().getName();
                    if (context instanceof Activity) {
                        ((Activity) context).runOnUiThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.13
                            /* JADX WARN: Removed duplicated region for block: B:12:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                            @Override // java.lang.Runnable
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public void run() {
                                Object obj;
                                Intent intent = new Intent();
                                intent.putExtra("version", "1.9.8c");
                                intent.putExtra("req", APMidasPayHelper.initRequest);
                                intent.putExtra(MosaicConstants$JsProperty.PROP_ENV, APMidasPayHelper.env);
                                intent.putExtra("logEnable", APMidasPayHelper.logEnable);
                                intent.putExtra("launchInterfaceName", name);
                                Activity activity = (Activity) context;
                                try {
                                    long currentTimeMillis5 = System.currentTimeMillis();
                                    obj = APPluginInterfaceManager.initPluginInterface(activity, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_INIT, new Object[]{activity, intent});
                                    try {
                                        APPluginReportManager.getInstance().insertTimeDataEx(name, APPluginReportManager.MIDASPLUGIN_TIMENAME_INIT_KERNEL, currentTimeMillis5);
                                        IAPInitCallBack iAPInitCallBack2 = iAPInitCallBack;
                                        if (iAPInitCallBack2 != null) {
                                            iAPInitCallBack2.result(0, MeasureConst.SLI_TYPE_SUCCESS, str, null);
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                        e.printStackTrace();
                                        IAPInitCallBack iAPInitCallBack3 = iAPInitCallBack;
                                        if (iAPInitCallBack3 != null) {
                                            iAPInitCallBack3.result(-2, e.toString(), str, null);
                                        }
                                        APLog.i(APMidasPayHelper.TAG, "preLoadMidasPay openPlugin obj:" + obj);
                                        APPluginReportManager.getInstance().insertTimeData(name, APPluginReportManager.MIDASPLUGIN_TIMENAME_INIT_TOTALTIME);
                                        APLog.i(APMidasPayHelper.TAG, "preLoadMidasPay initState = PLUGIN_INITSUCC");
                                        APMidasPayHelper.initState = 1;
                                        synchronized (APMidasPayHelper.loadingObject) {
                                        }
                                    }
                                } catch (Exception e18) {
                                    e = e18;
                                    obj = null;
                                }
                                APLog.i(APMidasPayHelper.TAG, "preLoadMidasPay openPlugin obj:" + obj);
                                APPluginReportManager.getInstance().insertTimeData(name, APPluginReportManager.MIDASPLUGIN_TIMENAME_INIT_TOTALTIME);
                                APLog.i(APMidasPayHelper.TAG, "preLoadMidasPay initState = PLUGIN_INITSUCC");
                                APMidasPayHelper.initState = 1;
                                synchronized (APMidasPayHelper.loadingObject) {
                                    APMidasPayHelper.loadingObject.notifyAll();
                                }
                            }
                        });
                    } else {
                        initState = 1;
                        synchronized (loadingObject) {
                            loadingObject.notifyAll();
                        }
                    }
                }
            }
        }
    }

    private static void preLoadPlugin(final Context context, final String str, final IAPInitCallBack iAPInitCallBack) {
        synchronized (initObject) {
            initState = 0;
        }
        BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.12
            @Override // java.lang.Runnable
            public void run() {
                APMidasPayHelper.preLoadMidasPay(context, str, iAPInitCallBack);
            }
        });
        baseThread.setName(APPluginDataInterface.singleton().getLaunchInterface());
        baseThread.start();
    }

    public static void release(Context context) {
        APLog.d(TAG, "release");
        APPluginInstallerAndUpdater.unInstallPlugin(context);
        synchronized (initObject) {
            initState = -1;
        }
    }

    public static void releaseSDK(Activity activity) {
        midasSoCallback = null;
        midasCallBack = null;
        netCallBack = null;
        remotRecevier = null;
        new APMidasPayHelper().call(activity, MED_DISTRIBUTE_RELEASE, new Object[0]);
    }

    public static void setEnv(String str) {
        if (!"release".equals(str) && !"test".equals(str) && !APMidasPayAPI.ENV_DEV.equals(str) && !"debug".equals(str) && !APMidasPayAPI.ENV_TESTING.equals(str)) {
            str = "release";
        }
        env = str;
    }

    public static void setLogCallbackClassName(String str) {
        logCallbackClassName = str;
    }

    public static void setLogEnable(boolean z16) {
        logEnable = z16;
    }

    public static synchronized void setLongConnection(Context context, boolean z16) {
        synchronized (APMidasPayHelper.class) {
            APLog.i(TAG, "setLongConnection to open = " + z16);
            Intent intent = new Intent();
            intent.putExtra("version", "1.9.8c");
            intent.putExtra(MosaicConstants$JsProperty.PROP_ENV, env);
            intent.putExtra("logEnable", logEnable);
            intent.putExtra("openLongConnection", z16);
            intent.putExtra("launchInterfaceName", Thread.currentThread().getName());
            try {
                APPluginInterfaceManager.initPluginInterface(context, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_LongConnection, new Object[]{context, intent});
            } catch (Exception e16) {
                APLog.i(TAG, "initcallback isInitSucc direct call init function e:" + e16.toString());
            }
        }
    }

    private int toH5Midas(final Activity activity, WebView webView, final String str, final String str2, final String str3, String str4) {
        APLog.i(TAG, "toH5Midas initState: " + initState);
        synchronized (initObject) {
            final ReportProgressDialog reportProgressDialog = new ReportProgressDialog(activity);
            reportProgressDialog.setIndeterminate(false);
            reportProgressDialog.setProgressStyle(0);
            reportProgressDialog.setTitle("\u6e29\u99a8\u63d0\u793a");
            reportProgressDialog.setMessage("\u817e\u8baf\u652f\u4ed8\u670d\u52a1\u521d\u59cb\u5316\u4e2d");
            int i3 = initState;
            if (i3 == -1 || i3 == 0) {
                try {
                    reportProgressDialog.show();
                } catch (Throwable unused) {
                }
            }
            if (initState == -1) {
                preLoadPlugin(activity, str4, null);
            }
            if (initState == 0) {
                new BaseThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.10
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (APMidasPayHelper.loadingObject) {
                                LockMethodProxy.wait(APMidasPayHelper.loadingObject);
                            }
                        } catch (InterruptedException e16) {
                            APLog.w(APMidasPayHelper.TAG, "toH5Midas e:" + e16.toString());
                        }
                        try {
                            if (reportProgressDialog.isShowing()) {
                                reportProgressDialog.dismiss();
                            }
                        } catch (Throwable unused2) {
                        }
                        APMidasPayHelper.this.toH5MidasPay(activity, str, str2, str3);
                    }
                }).start();
                return 0;
            }
            return toH5MidasPay(activity, str, str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toH5MidasPay(final Activity activity, final String str, final String str2, final String str3) {
        synchronized (initObject) {
            if (initState == 2) {
                APLog.i(TAG, "toH5MidasPay plugin init error");
                pluginInitErrCallBack(activity);
                initState = -1;
                return -1;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.11
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = new Intent();
                    intent.putExtra("version", APMidasPayAPI.getMidasPluginVersion());
                    intent.putExtra(MosaicConstants$JsProperty.PROP_ENV, APMidasPayHelper.env);
                    intent.putExtra("screenType", APMidasPayHelper.this.screenType);
                    intent.putExtra("logEnable", APMidasPayHelper.logEnable);
                    intent.putExtra("req", "H5Pay");
                    intent.putExtra("url", str);
                    intent.putExtra("message", str2);
                    intent.putExtra("reqType", APMidasPayHelper.netCallBack_ReqType);
                    try {
                        APMultiProcessData processData = APPluginDataInterface.singleton().getProcessData();
                        if (processData != null) {
                            intent.putExtra("launchPayGUID", processData.getGuid());
                            intent.putExtra("launchPayTime", processData.getPayInterfaceTime());
                            intent.putExtra("launchPayDataid", APDataId.getDataId());
                            intent.putExtra("launchIntervalTime", processData.getIntervalTime());
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (APMidasPayHelper.isNewProcess) {
                        APCallBackResultReceiver unused = APMidasPayHelper.remotRecevier = new APCallBackResultReceiver(new Handler());
                        APMidasPayHelper.remotRecevier.setReceiver(APMidasPayHelper.this);
                        intent.putExtra("remoteReceiver", APMidasPayHelper.remotRecevier);
                    }
                    APMidasPayHelper.this.openPlugin(activity, intent, str3);
                }
            });
            return 0;
        }
    }

    private int toMidas(final Activity activity, final APMidasBaseRequest aPMidasBaseRequest, final String str, final String str2) {
        if (aPMidasBaseRequest == null) {
            APLog.w(TAG, "toMidas pay request is null");
            return -1;
        }
        requestObject = aPMidasBaseRequest;
        staticActivityContext = activity.getApplicationContext();
        APLog.i(TAG, "ToMidas initState = " + initState);
        synchronized (initObject) {
            final ReportProgressDialog reportProgressDialog = new ReportProgressDialog(activity);
            reportProgressDialog.setIndeterminate(false);
            reportProgressDialog.setProgressStyle(0);
            reportProgressDialog.setTitle("\u6e29\u99a8\u63d0\u793a");
            reportProgressDialog.setMessage("\u817e\u8baf\u652f\u4ed8\u670d\u52a1\u521d\u59cb\u5316\u4e2d");
            final long currentTimeMillis = System.currentTimeMillis();
            boolean isNeedUpdateFromLocal = APPluginInstallerAndUpdater.isNeedUpdateFromLocal(activity);
            isNeedLocalUpdate = isNeedUpdateFromLocal;
            if (isNeedUpdateFromLocal) {
                synchronized (initObject) {
                    initState = -1;
                }
            }
            int i3 = initState;
            if ((i3 == -1 || i3 == 0) && !MED_DISTRIBUTE_NET.equals(str) && !MED_DISTRIBUTE_INFO.equals(str)) {
                try {
                    reportProgressDialog.show();
                } catch (Throwable unused) {
                }
            }
            if (initState == 1 && !APPluginChecker.isPluginExists(activity)) {
                initState = -1;
            }
            if (initState == -1) {
                if (isNeedLocalUpdate) {
                    releaseSDK(activity);
                }
                preLoadPlugin(activity, str2, null);
            }
            if (initState == 0) {
                new BaseThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (APMidasPayHelper.loadingObject) {
                                LockMethodProxy.wait(APMidasPayHelper.loadingObject);
                            }
                        } catch (InterruptedException e16) {
                            APLog.w(APMidasPayHelper.TAG, e16.toString());
                        }
                        try {
                            if (reportProgressDialog.isShowing()) {
                                reportProgressDialog.dismiss();
                            }
                        } catch (Throwable unused2) {
                        }
                        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY_WAIT_INIT, currentTimeMillis);
                        APMidasPayHelper.this.toMidasPay(activity, aPMidasBaseRequest, str, str2);
                    }
                }).start();
                return 0;
            }
            return toMidasPay(activity, aPMidasBaseRequest, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toMidasPay(final Activity activity, final APMidasBaseRequest aPMidasBaseRequest, final String str, String str2) {
        synchronized (initObject) {
            if (initState == 2) {
                APLog.i(TAG, "toMidasPay plugin init error");
                pluginInitErrCallBack(activity);
                initState = -1;
                return -1;
            }
            requestObject = aPMidasBaseRequest;
            staticActivityContext = activity.getApplicationContext();
            isNewProcess = isNewProcess(activity);
            try {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.9
                    @Override // java.lang.Runnable
                    public void run() {
                        Intent intent = new Intent();
                        intent.putExtra("version", APMidasPayAPI.getMidasPluginVersion());
                        intent.putExtra(MosaicConstants$JsProperty.PROP_ENV, APMidasPayHelper.env);
                        intent.putExtra("screenType", APMidasPayHelper.this.screenType);
                        intent.putExtra("logEnable", APMidasPayHelper.logEnable);
                        intent.putExtra("req", aPMidasBaseRequest);
                        intent.putExtra("reqType", APMidasPayHelper.netCallBack_ReqType);
                        intent.putExtra("method", str);
                        if (APMidasPayHelper.isNewProcess) {
                            APCallBackResultReceiver unused = APMidasPayHelper.remotRecevier = new APCallBackResultReceiver(new Handler());
                            APMidasPayHelper.remotRecevier.setReceiver(APMidasPayHelper.this);
                            intent.putExtra("remoteReceiver", APMidasPayHelper.remotRecevier);
                        }
                        intent.putExtra("launchInterfaceName", APPluginDataInterface.singleton().getLaunchInterface());
                        try {
                            APMultiProcessData processData = APPluginDataInterface.singleton().getProcessData();
                            if (processData != null) {
                                intent.putExtra("launchPayGUID", processData.getGuid());
                                intent.putExtra("launchPayTime", processData.getPayInterfaceTime());
                                intent.putExtra("launchPayDataid", APDataId.getDataId());
                                intent.putExtra("launchIntervalTime", processData.getIntervalTime());
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        APMidasPayHelper.this.openPlugin(activity, intent, str);
                    }
                });
                return 0;
            } catch (Exception e16) {
                e16.printStackTrace();
                return 0;
            }
        }
    }

    private void waitingPluginReady(Context context, final ResultReceiver resultReceiver) {
        if ("test".equals(env) && initCount < 1) {
            Toast.makeText(context, "\u817e\u8baf\u652f\u4ed8\u5c1a\u672a\u521d\u59cb\u5316\uff0c\u8bf7\u5148\u8c03\u7528\u521d\u59cb\u5316\u63a5\u53e3!", 1).show();
        }
        if (isNewProcess) {
            APPluginDataStorage.storeData(context, APPluginDataInterface.SHARE_PREFERENCE_NAME, "launchpaycalling", "1");
        }
        APLog.i(TAG, "ToMidas initState = " + initState);
        synchronized (initObject) {
            final ReportProgressDialog reportProgressDialog = new ReportProgressDialog(context);
            reportProgressDialog.setIndeterminate(false);
            reportProgressDialog.setProgressStyle(0);
            reportProgressDialog.setTitle("\u6e29\u99a8\u63d0\u793a");
            reportProgressDialog.setMessage("\u817e\u8baf\u652f\u4ed8\u670d\u52a1\u521d\u59cb\u5316\u4e2d");
            final long currentTimeMillis = System.currentTimeMillis();
            boolean isNeedUpdateFromLocal = APPluginInstallerAndUpdater.isNeedUpdateFromLocal(context);
            isNeedLocalUpdate = isNeedUpdateFromLocal;
            if (isNeedUpdateFromLocal) {
                synchronized (initObject) {
                    initState = -1;
                }
            }
            int i3 = initState;
            if ((i3 == -1 || i3 == 0) && !MED_DISTRIBUTE_NET.equals("launchFunction") && !MED_DISTRIBUTE_INFO.equals("launchFunction")) {
                try {
                    reportProgressDialog.show();
                } catch (Throwable unused) {
                }
            }
            if (initState == -1) {
                if (isNeedLocalUpdate) {
                    release(context);
                }
                preLoadPlugin(context, "launchFunction", null);
            }
            if (initState == 0) {
                new BaseThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (APMidasPayHelper.loadingObject) {
                                LockMethodProxy.wait(APMidasPayHelper.loadingObject);
                            }
                        } catch (InterruptedException e16) {
                            APLog.w(APMidasPayHelper.TAG, e16.toString());
                        }
                        try {
                            if (reportProgressDialog.isShowing()) {
                                reportProgressDialog.dismiss();
                            }
                        } catch (Throwable unused2) {
                        }
                        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY_WAIT_INIT, currentTimeMillis);
                        resultReceiver.send(0, new Bundle());
                    }
                }).start();
            } else {
                resultReceiver.send(0, new Bundle());
            }
        }
    }

    public Object call(Activity activity, String str, Object[] objArr) {
        return callWithContext(activity, str, objArr);
    }

    public Object callWithContext(Context context, String str, Object[] objArr) {
        try {
            return APPluginInterfaceManager.initPluginInterface(context, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_CALL, new Object[]{str, objArr});
        } catch (Exception e16) {
            APLog.i(TAG, "callWithContext error:" + e16.toString());
            return null;
        }
    }

    public int getInfo(Activity activity, String str, APMidasBaseRequest aPMidasBaseRequest, IAPMidasNetCallBack iAPMidasNetCallBack) {
        netCallBack = iAPMidasNetCallBack;
        netCallBack_ReqType = str;
        return toMidas(activity, aPMidasBaseRequest, MED_DISTRIBUTE_INFO, "getInfo");
    }

    public int h5Pay(Activity activity, WebView webView, com.tencent.smtt.sdk.WebView webView2, String str, String str2) {
        webview = webView;
        x5Webview = webView2;
        APLog.i(TAG, "h5Pay webview:" + webview + " x5Webview:" + x5Webview + " msg:" + str2);
        APPluginReportManager aPPluginReportManager = APPluginReportManager.getInstance();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("msg:");
        sb5.append(str2);
        aPPluginReportManager.reportImmediatelyOneRecord("init", APPluginReportManager.MIDASPLUGIN_H5_PAY_HOOK, sb5.toString());
        if (!TextUtils.isEmpty(str2) && str2.startsWith("midas_js_bridge_")) {
            return toH5Midas(activity, webView, str, str2, MED_DISTRIBUTE_H5PAY, "h5Pay");
        }
        return -2;
    }

    public void launchWXMiniProgram(Context context, Bundle bundle, ResultReceiver resultReceiver) {
        call(context, MED_DISTRIBUTE_WX_MINIPROGRAM, new Class[]{Context.class, Bundle.class, ResultReceiver.class}, new Object[]{context, bundle, resultReceiver});
    }

    public void launchWXMiniProgram_OnResponse(Context context, int i3, Bundle bundle) {
        call(context, MED_DISTRIBUTE_WX_MINIPROGRAM_ONRESPONSE, new Class[]{Integer.TYPE, Bundle.class}, new Object[]{Integer.valueOf(i3), bundle});
    }

    public int launchWeChat(Activity activity, JSONObject jSONObject, IAPMidasPayCallBack iAPMidasPayCallBack) {
        APLog.d(TAG, "Calling into pay, caller = " + Thread.currentThread().getStackTrace()[3].toString());
        if ("test".equals(env) && initCount < 1) {
            Toast.makeText(activity, "\u817e\u8baf\u652f\u4ed8\u5c1a\u672a\u521d\u59cb\u5316\uff0c\u8bf7\u5148\u8c03\u7528\u521d\u59cb\u5316\u63a5\u53e3!", 1).show();
        }
        midasCallBack = iAPMidasPayCallBack;
        if (isNewProcess) {
            APPluginDataStorage.storeData(activity, APPluginDataInterface.SHARE_PREFERENCE_NAME, "launchpaycalling", "1");
        }
        APMidasGameRequest aPMidasGameRequest = new APMidasGameRequest();
        try {
            aPMidasGameRequest.reserv = "H5PayParams=" + URLEncoder.encode(jSONObject.toString(), "utf-8");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return toMidas(activity, aPMidasGameRequest, MED_DISTRIBUTE_WECHATPAY, "launchWeChat");
    }

    public void launchWeb(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        Intent intent = new Intent();
        intent.setClass(activity, APWebJSBridgeActivity.class);
        activity.startActivity(intent);
    }

    public int net(Activity activity, APMidasNetRequest aPMidasNetRequest, IAPMidasNetCallBack iAPMidasNetCallBack) {
        netCallBack = iAPMidasNetCallBack;
        netCallBack_ReqType = aPMidasNetRequest.reqType;
        return toMidas(activity, aPMidasNetRequest, MED_DISTRIBUTE_NET, "net");
    }

    @Override // com.tencent.midas.control.APCallBackResultReceiver.Receiver
    public void onReceiveResult(int i3, Bundle bundle) {
        APLog.i(TAG, "remotRecevier payHelper resultCode:" + i3);
        if (i3 == 0) {
            progressRemoteInfo(bundle);
        }
    }

    public int pay(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        APLog.d(TAG, "Calling into pay, caller = " + Thread.currentThread().getStackTrace()[3].toString());
        if ("test".equals(env) && initCount < 1) {
            Toast.makeText(activity, "\u817e\u8baf\u652f\u4ed8\u5c1a\u672a\u521d\u59cb\u5316\uff0c\u8bf7\u5148\u8c03\u7528\u521d\u59cb\u5316\u63a5\u53e3!", 1).show();
        }
        midasCallBack = iAPMidasPayCallBack;
        if (isNewProcess) {
            APPluginDataStorage.storeData(activity, APPluginDataInterface.SHARE_PREFERENCE_NAME, "launchpaycalling", "1");
        }
        return toMidas(activity, aPMidasBaseRequest, MED_DISTRIBUTE_PAY, OpenConstants.ApiName.PAY);
    }

    public int payScoreContract(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        APLog.d(TAG, "payScoreContract, caller = " + Thread.currentThread().getStackTrace()[3].toString());
        if ("test".equals(env) && initCount < 1) {
            Toast.makeText(activity, "\u817e\u8baf\u652f\u4ed8\u5c1a\u672a\u521d\u59cb\u5316\uff0c\u8bf7\u5148\u8c03\u7528\u521d\u59cb\u5316\u63a5\u53e3!", 1).show();
        }
        midasCallBack = iAPMidasPayCallBack;
        if (isNewProcess) {
            APPluginDataStorage.storeData(activity, APPluginDataInterface.SHARE_PREFERENCE_NAME, "launchpaycalling", "1");
        }
        return toMidas(activity, aPMidasBaseRequest, MED_DISTRIBUTE_PYA_SCORE_CONTRACT, "payScoreContract");
    }

    public void progressRemoteInfo(Bundle bundle) {
        APPurchase aPPurchase;
        String string = bundle.getString("type");
        APLog.i(TAG, "progressRemoteInfo type:" + string);
        if ("callback".equals(string)) {
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = bundle.getInt(QzoneIPCModule.RESULT_CODE, -1);
            aPMidasResponse.resultInerCode = bundle.getInt("resultInerCode");
            aPMidasResponse.realSaveNum = bundle.getInt("realSaveNum");
            aPMidasResponse.payChannel = bundle.getInt("payChannel");
            aPMidasResponse.payState = bundle.getInt("payState");
            aPMidasResponse.provideState = bundle.getInt("provideState");
            aPMidasResponse.resultMsg = bundle.getString("resultMsg");
            aPMidasResponse.extendInfo = bundle.getString("extendInfo");
            aPMidasResponse.payReserve1 = bundle.getString("payReserve1");
            aPMidasResponse.payReserve2 = bundle.getString("payReserve2");
            aPMidasResponse.payReserve3 = bundle.getString("payReserve3");
            try {
                aPPurchase = new APPurchase(bundle.getString("purchaseJson"), bundle.getString("purchaseSign"));
            } catch (JSONException e16) {
                aPPurchase = new APPurchase();
                APLog.w("progressRemoteInfo", "purchase creat fail1 " + e16.toString());
            } catch (Exception e17) {
                aPPurchase = new APPurchase();
                APLog.w("progressRemoteInfo", "purchase creat fail2 " + e17.toString());
            }
            aPMidasResponse.mAPPurchase = aPPurchase;
            midasCallBack(aPMidasResponse);
            return;
        }
        if ("h5callback".equals(string)) {
            midasH5CallBack(bundle.getString("callbackinfo"));
        } else if (PublicAccountMessageUtilImpl.ITEM_NEED_LOGIN.equals(string)) {
            midasLoginExpire();
        }
    }

    public void sendMidas(final Context context, final Bundle bundle, final ResultReceiver resultReceiver) {
        waitingPluginReady(context, new ResultReceiver(new Handler(Looper.getMainLooper())) { // from class: com.tencent.midas.control.APMidasPayHelper.5
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle2) {
                if (i3 == 0) {
                    try {
                        APMidasPayHelper aPMidasPayHelper = APMidasPayHelper.this;
                        Context context2 = context;
                        aPMidasPayHelper.retobj = APPluginInterfaceManager.initPluginInterface(context2, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_RECEIVE, new Object[]{context2, bundle, resultReceiver}, new Class[]{Context.class, Bundle.class, ResultReceiver.class});
                        return;
                    } catch (Exception e16) {
                        APLog.e(APMidasPayHelper.TAG, "sendMidas() e = " + e16.toString());
                        e16.printStackTrace();
                        return;
                    }
                }
                if (resultReceiver != null) {
                    String string = bundle.getString("__midas_ability_baseReq__postBack");
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("midas_callback_ability_postBack", string);
                    bundle3.putInt("midas_callback_ability_code", CGIErrorCode.ERROR_NETWORK_END);
                    bundle3.putString("midas_callback_ability_msg", "MidasPlugin load failure");
                    bundle3.putBundle("midas_callback_ability_data", bundle2);
                    resultReceiver.send(-1, bundle3);
                }
            }
        });
    }

    public void setScreenType(int i3) {
        this.screenType = i3;
    }

    public int signPay(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        APLog.d(TAG, "Calling into pay, caller = " + Thread.currentThread().getStackTrace()[3].toString());
        if ("test".equals(env) && initCount < 1) {
            Toast.makeText(activity, "\u817e\u8baf\u652f\u4ed8\u5c1a\u672a\u521d\u59cb\u5316\uff0c\u8bf7\u5148\u8c03\u7528\u521d\u59cb\u5316\u63a5\u53e3!", 1).show();
        }
        midasCallBack = iAPMidasPayCallBack;
        if (isNewProcess) {
            APPluginDataStorage.storeData(activity, APPluginDataInterface.SHARE_PREFERENCE_NAME, "launchpaycalling", "1");
        }
        return toMidas(activity, aPMidasBaseRequest, MED_DISTRIBUTE_SIGN_PAY, "signPay");
    }

    public void web(Activity activity, APMidasBaseRequest aPMidasBaseRequest, IAPMidasPayCallBack iAPMidasPayCallBack) {
        midasCallBack = iAPMidasPayCallBack;
        launchWeb(activity, aPMidasBaseRequest, iAPMidasPayCallBack);
    }

    public Object call(Activity activity, String str, Object[] objArr, Class<?>[] clsArr) {
        return callWithContext(activity, str, objArr, clsArr);
    }

    public static synchronized void init(final Context context, APMidasBaseRequest aPMidasBaseRequest, final ResultReceiver resultReceiver) {
        synchronized (APMidasPayHelper.class) {
            APLog.i(TAG, "init initCount:" + initCount);
            isNewProcess = isNewProcess(context);
            initRequest = aPMidasBaseRequest;
            if (initCount < 1 && !isInitSucc) {
                APPluginUtils.release();
                preLoadPlugin(context, "init", new IAPInitCallBack() { // from class: com.tencent.midas.control.APMidasPayHelper.1
                    @Override // com.tencent.midas.control.IAPInitCallBack
                    public void result(int i3, String str, String str2, Bundle bundle) {
                        APLog.i(APMidasPayHelper.TAG, "initcallback ret:" + i3 + " msg:" + str);
                        synchronized (APMidasPayHelper.dexloadObject) {
                            boolean unused = APMidasPayHelper.isInitSucc = true;
                            APMidasPayHelper.dexloadObject.notifyAll();
                            ResultReceiver resultReceiver2 = resultReceiver;
                            if (resultReceiver2 != null) {
                                resultReceiver2.send(i3, bundle);
                            }
                        }
                        APPluginReportManager.getInstance().dataReport("init");
                    }
                });
            } else if (isInitSucc) {
                ((Activity) context).runOnUiThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        APLog.i(APMidasPayHelper.TAG, "initcallback isInitSucc direct call init function");
                        Intent intent = new Intent();
                        intent.putExtra("version", "1.9.8c");
                        intent.putExtra("req", APMidasPayHelper.initRequest);
                        intent.putExtra(MosaicConstants$JsProperty.PROP_ENV, APMidasPayHelper.env);
                        intent.putExtra("logEnable", APMidasPayHelper.logEnable);
                        intent.putExtra("launchInterfaceName", Thread.currentThread().getName());
                        ResultReceiver resultReceiver2 = resultReceiver;
                        if (resultReceiver2 != null) {
                            intent.putExtra("receiver", resultReceiver2);
                        }
                        try {
                            Context context2 = context;
                            APPluginInterfaceManager.initPluginInterface(context2, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_INIT, new Object[]{context2, intent});
                        } catch (Exception e16) {
                            APLog.i(APMidasPayHelper.TAG, "initcallback isInitSucc direct call init function e:" + e16.toString());
                        }
                    }
                });
            }
            APPluginReportManager.getInstance().dataReport("init");
            initCount++;
        }
    }

    public Object call(Context context, String str, Class<?>[] clsArr, Object[] objArr) {
        return callWithContext(context, str, objArr, clsArr);
    }

    public Object callWithContext(final Context context, final String str, final Object[] objArr, final Class<?>[] clsArr) {
        synchronized (initObject) {
            APLog.i("callWithContext ", "initState:" + initState);
            if (initState == 0) {
                new BaseThread(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            APLog.d("callWithContext ", "PLUGIN_INITING wait");
                            synchronized (APMidasPayHelper.dexloadObject) {
                                LockMethodProxy.wait(APMidasPayHelper.dexloadObject);
                            }
                            APLog.d("callWithContext ", "PLUGIN_INITING go");
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                        APMidasPayHelper.this.retobj = APPluginInterfaceManager.initPluginInterface2(context, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_CALL2, new Object[]{str, objArr, clsArr});
                                    } catch (Exception e16) {
                                        APLog.e("callWithContext", "error1 " + e16.toString());
                                    }
                                }
                            });
                        } catch (InterruptedException e16) {
                            APLog.e("callWithContext", "error2 " + e16.toString());
                        } catch (Exception e17) {
                            APLog.e("callWithContext", "error3 " + e17.toString());
                        } catch (Throwable th5) {
                            APLog.e("callWithContext", "error4 " + th5.toString());
                        }
                    }
                }).start();
            } else {
                try {
                    this.retobj = APPluginInterfaceManager.initPluginInterface2(context, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_CALL2, new Object[]{str, objArr, clsArr});
                } catch (Exception e16) {
                    APLog.e("callWithContext", "error3 " + e16.toString());
                }
            }
        }
        return this.retobj;
    }
}
