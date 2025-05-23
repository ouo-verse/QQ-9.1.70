package com.tencent.qqmini.miniapp.core.service;

import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface;
import com.tencent.qqmini.miniapp.util.AdReportInfoUtil;
import com.tencent.qqmini.miniapp.util.AppBrandUtil;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.MiniLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppBrandWebviewService extends AbsAppBrandService {
    protected static final String JS_INTERFACE_NAME = "WeixinJSCore";
    protected static final String TAG = "AppBrandWebviewService";
    private ServiceEventListener mAppBrandEventInterface;
    private EmbeddedState mEmbeddedState;
    private WebView mWebView;

    public AppBrandWebviewService(IMiniAppContext iMiniAppContext, ServiceEventListener serviceEventListener) {
        super(iMiniAppContext);
        this.mEmbeddedState = null;
        setAppBrandEventInterface(serviceEventListener);
        QmX5Webview qmX5Webview = new QmX5Webview(iMiniAppContext.getContext());
        this.mWebView = qmX5Webview;
        qmX5Webview.addJavascriptInterface(this, JS_INTERFACE_NAME);
        this.mWebView.addJavascriptInterface(new MiniWorkerInterface(this.miniAppContext), MiniAppWorkerManager.OBJ_WEIXINWORKER);
        WebSettings settings = this.mWebView.getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService.1
            @Override // com.tencent.smtt.sdk.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                AppBrandWebviewService.this.onJsError(consoleMessage);
                if (consoleMessage != null) {
                    if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
                        QMLog.e(AppBrandWebviewService.TAG, "consoleMessage.message() " + consoleMessage.message() + " line:" + consoleMessage.lineNumber());
                    } else if (!MiniLog.isLogStringContainerHighFrequencyEvent(consoleMessage.message()) && !FastClickUtils.isFastDoubleClick(AppBrandWebviewService.TAG, 200L)) {
                        QMLog.i(AppBrandWebviewService.TAG, "consoleMessage.message() " + consoleMessage.message());
                    }
                }
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // com.tencent.smtt.sdk.WebChromeClient
            public void onProgressChanged(WebView webView, int i3) {
                JsInjector.getInstance().onProgressChanged(webView, i3);
                super.onProgressChanged(webView, i3);
            }
        });
        sendEvent((Integer) 3);
    }

    public static int[] jsStringToJavaIntArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] split = str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        int[] iArr = new int[split.length];
        for (int i3 = 0; i3 < split.length; i3++) {
            try {
                iArr[i3] = Integer.parseInt(split[i3]);
            } catch (NumberFormatException unused) {
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onJsError(ConsoleMessage consoleMessage) {
        if (consoleMessage != null && consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            this.miniAppContext.performAction(AppStateEvent.obtain(71, consoleMessage));
        }
    }

    private void reportEmbeddedStatus(final int i3, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService.3
            @Override // java.lang.Runnable
            public void run() {
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), i3, "0", str, null, null, null);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateCallbackJs(int i3, String str) {
        evaluateJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", Integer.valueOf(i3), str), null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateJs(String str, ValueCallback valueCallback) {
        evaluateJs(str, valueCallback, null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateSubscribeJS(String str, String str2, int i3) {
        String str3 = "WeixinJSBridge.subscribeHandler(\"" + str + "\"," + str2 + "," + i3 + ",0)";
        if (!isStateSucc()) {
            QMLog.e(TAG, "Service is not completd! Add to waiting list");
            addWaitEvaluateJs(str3);
        } else {
            evaluateJs(str3, null);
        }
    }

    public String getJSGlobalConfig(ApkgInfo apkgInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (apkgInfo == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", apkgInfo.appId);
            jSONObject.put("icon", apkgInfo.iconUrl);
            jSONObject.put("nickname", apkgInfo.apkgName);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        MiniAppInfo miniAppInfo = apkgInfo.mMiniAppInfo;
        if (miniAppInfo == null) {
            str = "";
            str2 = "release";
        } else {
            str2 = miniAppInfo.getVerTypeStr();
            str = apkgInfo.mMiniAppInfo.version;
        }
        String format = String.format("if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig=%1$s;  __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s');  __qqConfig.envVersion='" + str2 + "'; __qqConfig.deviceinfo='" + QUAUtil.getSimpleDeviceInfo(AppLoaderFactory.g().getContext()) + "'; __qqConfig.miniapp_version='" + str + "';", apkgInfo.mConfigStr, jSONObject.toString());
        if (DebugUtil.getDebugEnabled(apkgInfo.appId)) {
            format = format + "__qqConfig.debug=true;";
        }
        if (this.mEmbeddedState != null) {
            String str6 = format + "__qqConfig.useXWebVideo=" + this.mEmbeddedState.isEnableEmbeddedVideo() + ";";
            QMLog.d("miniapp-embedded", "system service enableEmbeddedVideo : " + this.mEmbeddedState.isEnableEmbeddedVideo());
            String str7 = str6 + "__qqConfig.useXWebLive=" + this.mEmbeddedState.isEnableEmbeddedLive() + ";";
            QMLog.d("miniapp-embedded", "system service enableEmbeddedLive : " + this.mEmbeddedState.isEnableEmbeddedLive());
            format = str7 + "__qqConfig.useXWebElement=" + this.mEmbeddedState.isEnableEmbeddedElement() + ";";
            QMLog.d("miniapp-embedded", "system service enableEmbeddedElement : " + this.mEmbeddedState.isEnableEmbeddedElement());
            if (this.mEmbeddedState.isEnableEmbeddedVideo()) {
                str3 = "system_embedded_video";
            } else {
                str3 = "system_native_video";
            }
            reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, str3);
            if (this.mEmbeddedState.isEnableEmbeddedLive()) {
                str4 = "system_embedded_live";
            } else {
                str4 = "system_native_live";
            }
            reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, str4);
            if (this.mEmbeddedState.isEnableEmbeddedElement()) {
                str5 = "system_embedded_element";
            } else {
                str5 = "system_native_element";
            }
            reportEmbeddedStatus(772, str5);
        }
        return (format + String.format("__qqConfig.adReportInfo=%1$s;", AdReportInfoUtil.getAdReportInfo(apkgInfo).toString())) + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }

    public String getJsDefaultConfig(boolean z16) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("USER_DATA_PATH", "qqfile://usr");
            jSONObject.put(MosaicConstants$JsProperty.PROP_ENV, jSONObject2);
            jSONObject.put("preload", z16);
            int config = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_XPROF_API_REPORT, 0);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nvar window = window || {}; window.__webview_engine_version__ = 0.02; if (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s');__qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.appContactInfo = {};__qqConfig.appContactInfo.operationInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo = {};__qqConfig.appContactInfo.operationInfo.jsonInfo.apiAvailable = {'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'share':0,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0};__qqConfig.platform = 'android';__qqConfig.QUA='");
            sb5.append(QUAUtil.getPlatformQUA());
            sb5.append("';__qqConfig.clipboardInterval='");
            sb5.append(QUAUtil.getClipboardInterval());
            sb5.append("';__qqConfig.frameworkInfo = {};__qqConfig.frameworkInfo.isAlpha=");
            if (config == 0) {
                str = "false";
            } else {
                str = "true";
            }
            sb5.append(str);
            sb5.append(";");
            String format = String.format(sb5.toString(), jSONObject);
            QMLog.d(AppLoaderFactory.TAG, "getJsDefaultConfig ServiceWebview String: " + format);
            return format;
        } catch (Exception e16) {
            QMLog.d(AppLoaderFactory.TAG, "getJsDefaultConfig failed: " + e16);
            return "";
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public int getStatus() {
        return 0;
    }

    @Override // com.tencent.qqmini.miniapp.core.service.AbsAppBrandService, com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public void initBaseJs(BaselibLoader.BaselibContent baselibContent) {
        setDefaultConfigJs(getJsDefaultConfig(true));
        setWaServiceJS(baselibContent.waServiceJsStr, baselibContent.waServicePath);
    }

    @Override // com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public void initEmbeddedState(EmbeddedState embeddedState) {
        this.mEmbeddedState = embeddedState;
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i3) {
        QMLog.d(TAG, "invokeHandler|service: " + str + " |id:" + i3);
        ServiceEventListener serviceEventListener = this.mAppBrandEventInterface;
        if (serviceEventListener != null) {
            return serviceEventListener.onServiceNativeRequest(str, str2, i3);
        }
        return "";
    }

    @JavascriptInterface
    public void publishHandler(String str, String str2, String str3) {
        if (QMLog.isColorLevel() && !MiniLog.isHighFrequencyEventLog(str)) {
            QMLog.d(TAG, "publishHandler|service: " + str + " |webviewIds:" + str3);
        }
        if (HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(str3)) {
            str3 = "";
        }
        ServiceEventListener serviceEventListener = this.mAppBrandEventInterface;
        if (serviceEventListener != null) {
            serviceEventListener.onServiceEvent(str, str2, jsStringToJavaIntArray(str3));
        }
    }

    @Override // com.tencent.qqmini.miniapp.core.service.AbsAppBrandService, com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public void setApkgInfo(ApkgInfo apkgInfo) {
        if (apkgInfo == null) {
            return;
        }
        setGlobalConfigJs(getJSGlobalConfig(apkgInfo));
        setAppServiceJs(apkgInfo.getAppServiceJsContent());
    }

    @Override // com.tencent.qqmini.miniapp.core.service.IAppBrandService
    public void setAppBrandEventInterface(ServiceEventListener serviceEventListener) {
        this.mAppBrandEventInterface = serviceEventListener;
    }

    @Override // com.tencent.qqmini.miniapp.core.fsm.JsStatMachine
    public void evaluateJs(final String str, final ValueCallback valueCallback, String str2) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            WebView webView = this.mWebView;
            if (webView != null) {
                webView.evaluateJavascript(str, AppBrandUtil.convertValueCallback(valueCallback));
                return;
            }
            return;
        }
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService.2
            @Override // java.lang.Runnable
            public void run() {
                if (AppBrandWebviewService.this.mWebView != null) {
                    AppBrandWebviewService.this.mWebView.evaluateJavascript(str, AppBrandUtil.convertValueCallback(valueCallback));
                }
            }
        });
    }
}
