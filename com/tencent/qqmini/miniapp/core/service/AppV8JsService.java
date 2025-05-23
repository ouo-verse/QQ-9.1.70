package com.tencent.qqmini.miniapp.core.service;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.qqmini.miniapp.core.fsm.JsStatMachine;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.worker.MiniWorkerInterface;
import com.tencent.qqmini.miniapp.util.AdReportInfoUtil;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DebugHelper;
import com.tencent.qqmini.sdk.utils.MiniLog;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.v8rt.engine.Callback;
import com.tencent.qqmini.v8rt.engine.Engine;
import com.tencent.qqmini.v8rt.engine.IServiceEventHandler;
import com.tencent.qqmini.v8rt.engine.IWorkerEventHandler;
import com.tencent.qqmini.v8rt.engine.JsRuntimeLoader;
import com.tencent.qqmini.v8rt.engine.Logger;
import com.tencent.qqmini.v8rt.engine.ServiceEventHandlerProvider;
import com.tencent.qqmini.v8rt.engine.SpeedUtil;
import com.tencent.qqmini.v8rt.engine.V8JsRuntime;
import com.tencent.qqmini.v8rt.engine.WorkerHandlerProvider;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppV8JsService extends AbsAppBrandService {
    public static final String TAG = "V8ServiceRuntime";
    private Context context;
    private Engine engine;
    private boolean injectFlutterFlag;
    private V8JsRuntime jsRuntime;
    private EmbeddedState mEmbeddedState;

    static {
        Logger.init(new V8LogImpl());
    }

    public AppV8JsService(IMiniAppContext iMiniAppContext) {
        this(iMiniAppContext, false);
    }

    private void reportEmbeddedStatus(final int i3, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.service.AppV8JsService.7
            @Override // java.lang.Runnable
            public void run() {
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), i3, "0", str, null, null, null);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateCallbackJs(int i3, String str) {
        if (this.jsRuntime != null) {
            if (QMLog.isColorLevel()) {
                Logger.d(TAG, "evaluateCallbackJs  callbackId=" + i3 + ",result=" + str);
            }
            evaluateJs(String.format("WeixinJSBridge.invokeCallbackHandler(%d, %s)", Integer.valueOf(i3), str), null);
            return;
        }
        Logger.e(TAG, "evaluateCallbackJs failed jsRuntime null");
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateJs(String str, ValueCallback valueCallback) {
        evaluateJs(str, valueCallback, null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IJsService
    public void evaluateSubscribeJS(String str, String str2, int i3) {
        String str3 = "WeixinJSBridge.subscribeHandler(\"" + str + "\"," + str2 + "," + i3 + ",0)";
        if (QMLog.isColorLevel() && !MiniLog.isHighFrequencyEventLog(str)) {
            QMLog.d(TAG, "evaluateSubscribeJS: " + str3);
        }
        if (!isStateSucc()) {
            QMLog.e(TAG, "Service is not completd! Add to waiting list");
            addWaitEvaluateJs(str3);
            return;
        }
        V8JsRuntime v8JsRuntime = this.jsRuntime;
        if (v8JsRuntime != null) {
            v8JsRuntime.getDefaultContext().evaluateJsAsync(str3, null);
        } else {
            Logger.e(TAG, "evaluateSubscribeJS failed jsRuntime null");
        }
    }

    public int getEngineId() {
        V8JsRuntime v8JsRuntime = this.jsRuntime;
        if (v8JsRuntime != null) {
            return v8JsRuntime.getId();
        }
        return -1;
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
        if (DebugHelper.d().c(apkgInfo.appId)) {
            format = format + "__qqConfig.debug=true;";
        }
        if (this.mEmbeddedState != null) {
            format = ((format + "__qqConfig.useXWebVideo=" + this.mEmbeddedState.isEnableEmbeddedVideo() + ";") + "__qqConfig.useXWebLive=" + this.mEmbeddedState.isEnableEmbeddedLive() + ";") + "__qqConfig.useXWebElement=" + this.mEmbeddedState.isEnableEmbeddedElement() + ";";
            QMLog.d("miniapp-embedded", "x5 service enableEmbeddedVideo : " + this.mEmbeddedState.isEnableEmbeddedVideo());
            if (this.mEmbeddedState.isEnableEmbeddedVideo()) {
                str3 = "x5_embedded_video";
            } else {
                str3 = "x5_native_video";
            }
            reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, str3);
            if (this.mEmbeddedState.isEnableEmbeddedLive()) {
                str4 = "x5_embedded_live";
            } else {
                str4 = "x5_native_live";
            }
            reportEmbeddedStatus(MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER, str4);
            if (this.mEmbeddedState.isEnableEmbeddedElement()) {
                str5 = "x5_embedded_element";
            } else {
                str5 = "x5_native_element";
            }
            reportEmbeddedStatus(772, str5);
        }
        return (format + String.format("__qqConfig.adReportInfo=%1$s;", AdReportInfoUtil.getAdReportInfo(apkgInfo).toString())) + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
    }

    public String getJsDefaultConfig(boolean z16) {
        String str;
        String str2;
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
            if (!this.injectFlutterFlag) {
                str2 = "";
            } else {
                str2 = "__qqConfig.useFlutter = true";
            }
            sb5.append(str2);
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
        return this.engine.getStatus();
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

    public void initWorker() {
        final MiniWorkerInterface miniWorkerInterface = new MiniWorkerInterface(this.miniAppContext);
        WorkerHandlerProvider.getInstance().setWorkerHandler(this.jsRuntime, new IWorkerEventHandler() { // from class: com.tencent.qqmini.miniapp.core.service.AppV8JsService.6
            @Override // com.tencent.qqmini.v8rt.engine.IWorkerEventHandler
            public int create(String str) {
                return miniWorkerInterface.create(str);
            }

            @Override // com.tencent.qqmini.v8rt.engine.IWorkerEventHandler
            public void postMsgToAppService(String str) {
                miniWorkerInterface.postMsgToAppService(str);
            }

            @Override // com.tencent.qqmini.v8rt.engine.IWorkerEventHandler
            public void postMsgToWorker(int i3, String str) {
                miniWorkerInterface.postMsgToWorker(i3, str);
            }

            @Override // com.tencent.qqmini.v8rt.engine.IWorkerEventHandler
            public void terminate(int i3) {
                miniWorkerInterface.terminate(i3);
            }
        });
    }

    public void release() {
        V8JsRuntime v8JsRuntime = this.jsRuntime;
        if (v8JsRuntime != null) {
            v8JsRuntime.release();
            ServiceEventHandlerProvider.getInstance().removeServiceEventHandler(this.jsRuntime);
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
    public void setAppBrandEventInterface(final ServiceEventListener serviceEventListener) {
        ServiceEventHandlerProvider.getInstance().setServiceEventHandler(this.jsRuntime, new IServiceEventHandler() { // from class: com.tencent.qqmini.miniapp.core.service.AppV8JsService.5
            @Override // com.tencent.qqmini.v8rt.engine.IServiceEventHandler
            public void onServiceEvent(String str, String str2, int[] iArr) {
                serviceEventListener.onServiceEvent(str, str2, iArr);
            }

            @Override // com.tencent.qqmini.v8rt.engine.IServiceEventHandler
            public String onServiceNativeRequest(String str, String str2, int i3) {
                return serviceEventListener.onServiceNativeRequest(str, str2, i3);
            }
        });
    }

    @Override // com.tencent.qqmini.miniapp.core.service.AbsAppBrandService
    public void setAppServiceJs(String str) {
        this.stateAppServiceJsLoading.setJsContent(str, "app_service.js");
        appendEvent(7);
    }

    @Override // com.tencent.qqmini.miniapp.core.service.AbsAppBrandService
    public void setDefaultConfigJs(String str) {
        this.stateDefaulConfigJsLoading.setJsContent(str, "default_config.js");
        appendEvent(4);
    }

    @Override // com.tencent.qqmini.miniapp.core.service.AbsAppBrandService
    public void setGlobalConfigJs(String str) {
        this.stateGlobalConfigJsLoading.setJsContent(str, "global_config.js");
        appendEvent(6);
    }

    @Override // com.tencent.qqmini.miniapp.core.service.AbsAppBrandService
    public void setWaServiceJS(String str, String str2) {
        this.stateWaJsLoading.setJsContent(str, str2);
        appendEvent(5);
    }

    public AppV8JsService(IMiniAppContext iMiniAppContext, boolean z16) {
        super(iMiniAppContext);
        this.injectFlutterFlag = false;
        this.mEmbeddedState = null;
        this.engine = Engine.getInstance();
        if (WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_KEY_MINI_APP_ENABLE_V8_SERVICE_DEBUG, 0) > 0) {
            this.engine.setDebuggerOption(true, false);
        }
        this.engine.setLibLoader(new V8rtSoLoader());
        this.engine.initEngine(iMiniAppContext.getContext());
        this.injectFlutterFlag = z16;
        this.context = iMiniAppContext.getContext();
        if (this.engine.getStatus() == 0) {
            synchronized (AppV8JsService.class) {
                V8JsRuntime createJsRuntime = this.engine.createJsRuntime();
                this.jsRuntime = createJsRuntime;
                createJsRuntime.getDefaultContext().injectAll();
                initWorker();
                sendEvent((Integer) 3);
                Logger.i(Engine.TAG, "create jsruntime success " + this.jsRuntime);
            }
        } else {
            Logger.e(Engine.TAG, "create jsruntime failed, engine status:" + this.engine.getStatus());
        }
        setJsStateListener(new JsStatMachine.JsStateListener() { // from class: com.tencent.qqmini.miniapp.core.service.AppV8JsService.1
            @Override // com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsStateListener
            public void onJsStateEnd(JsStatMachine.JsState jsState) {
                String jsPath = jsState.getJsPath();
                if (!TextUtils.isEmpty(jsPath) && jsPath.contains("QLogic.js")) {
                    SpeedUtil.DEFAULT.event("runQLogicJs finish " + this);
                }
            }

            @Override // com.tencent.qqmini.miniapp.core.fsm.JsStatMachine.JsStateListener
            public void onJsStateStart(JsStatMachine.JsState jsState) {
                String jsPath = jsState.getJsPath();
                if (!TextUtils.isEmpty(jsPath) && jsPath.contains("QLogic.js")) {
                    SpeedUtil.DEFAULT.event("runQLogicJs start " + this);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.qqmini.miniapp.core.fsm.JsStatMachine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void evaluateJs(String str, final ValueCallback valueCallback, String str2) {
        String str3;
        V8JsRuntime v8JsRuntime;
        File parentFile;
        if (!TextUtils.isEmpty(str2)) {
            if (str2.endsWith("QLogic.js") && str2.startsWith("/")) {
                if (str2.startsWith("assets://")) {
                    File file = new File(str2.substring(9));
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.context.getCacheDir().getPath());
                    String str4 = File.separator;
                    sb5.append(str4);
                    sb5.append("cc_assets");
                    sb5.append(str4);
                    sb5.append(file.getParentFile().getPath());
                    parentFile = new File(sb5.toString());
                    parentFile.mkdirs();
                } else {
                    parentFile = new File(str2).getParentFile();
                    parentFile.mkdirs();
                }
                if (parentFile.exists() && parentFile.isDirectory()) {
                    str2 = new File(str2).getName();
                    str3 = new File(parentFile, str2).getAbsolutePath() + JsRuntimeLoader.CODE_CACHE_SUFFIX;
                }
            } else {
                str3 = "";
            }
            boolean z16 = !TextUtils.isEmpty(str2);
            v8JsRuntime = this.jsRuntime;
            if (v8JsRuntime == null) {
                if (valueCallback == null) {
                    if (z16) {
                        v8JsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(str, new Callback() { // from class: com.tencent.qqmini.miniapp.core.service.AppV8JsService.2
                            @Override // com.tencent.qqmini.v8rt.engine.Callback
                            public void onFinish(Object obj) {
                            }
                        }, str2, str3);
                        return;
                    } else {
                        v8JsRuntime.getDefaultContext().evaluateJsAsync(str, null);
                        return;
                    }
                }
                if (z16) {
                    v8JsRuntime.getDefaultContext().evaluateJsAsyncWithCodeCache(str, new Callback() { // from class: com.tencent.qqmini.miniapp.core.service.AppV8JsService.3
                        @Override // com.tencent.qqmini.v8rt.engine.Callback
                        public void onFinish(Object obj) {
                            valueCallback.onReceiveValue(null);
                        }
                    }, str2, str3);
                    return;
                } else {
                    v8JsRuntime.getDefaultContext().evaluateJsAsyncWithReturn(str, new Callback() { // from class: com.tencent.qqmini.miniapp.core.service.AppV8JsService.4
                        @Override // com.tencent.qqmini.v8rt.engine.Callback
                        public void onFinish(Object obj) {
                            valueCallback.onReceiveValue(obj);
                        }
                    });
                    return;
                }
            }
            return;
        }
        str2 = null;
        str3 = null;
        boolean z162 = !TextUtils.isEmpty(str2);
        v8JsRuntime = this.jsRuntime;
        if (v8JsRuntime == null) {
        }
    }
}
