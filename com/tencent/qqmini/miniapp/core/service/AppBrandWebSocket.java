package com.tencent.qqmini.miniapp.core.service;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.service.AppBrandRemoteService;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.DebugUtil;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppBrandWebSocket extends AppBrandBaseWebSocket {
    public static final String TAG = "AppBrandRemoteService";
    public static AtomicInteger sWebSocketRequestId = new AtomicInteger();
    private ApkgInfo mApkgInfo;
    private AbsAppBrandService mJsRutime;
    private AppBrandRemoteService.OnLoadServiceWebvieJsListener mServiceInitFinishListener;
    protected Handler mThreadHandler;
    private ServiceEventListener serviceEventListener;
    public Map<Long, ValueCallback> jsCallBackMap = new HashMap();
    private boolean startPing = false;
    private boolean hasSetupContextResult = false;
    private boolean hasEnterRoom = false;
    private boolean hasSetupContext = false;
    private EmbeddedState mEmbeddedState = null;
    private ConcurrentLinkedQueue<EvaluateData> mEvaluateDatas = new ConcurrentLinkedQueue<>();
    private AtomicInteger count = new AtomicInteger();
    private AtomicInteger pingcount = new AtomicInteger();
    private AtomicInteger scriptId = new AtomicInteger();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class EvaluateData {

        /* renamed from: js, reason: collision with root package name */
        public String f346244js;
        public ValueCallback valueCallback;

        public EvaluateData(String str, ValueCallback valueCallback) {
            this.f346244js = str;
            this.valueCallback = valueCallback;
        }
    }

    public AppBrandWebSocket(IMiniAppContext iMiniAppContext, Handler handler, AbsAppBrandService absAppBrandService) {
        this.mThreadHandler = handler;
        this.mJsRutime = absAppBrandService;
        this.miniAppContext = iMiniAppContext;
        this.mTaskId = sWebSocketRequestId.getAndIncrement();
        this.mListener = new WebSocketProxy.WebSocketListener() { // from class: com.tencent.qqmini.miniapp.core.service.AppBrandWebSocket.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onClose(int i3, int i16, String str) {
                QMLog.d("AppBrandRemoteService", "onClose ");
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onError(int i3, int i16, String str) {
                QMLog.d("AppBrandRemoteService", "onError ");
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onMessage(int i3, final byte[] bArr) {
                QMLog.d("AppBrandRemoteService", "<--- onMessage byte");
                Handler handler2 = AppBrandWebSocket.this.mThreadHandler;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.service.AppBrandWebSocket.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AppBrandWebSocket.this.processMessage(bArr.toString());
                        }
                    });
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onOpen(int i3, int i16, Map<String, List<String>> map) {
                QMLog.d("AppBrandRemoteService", "onOpen ");
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onMessage(int i3, final String str) {
                QMLog.d("AppBrandRemoteService", "<--- onMessage string" + str);
                Handler handler2 = AppBrandWebSocket.this.mThreadHandler;
                if (handler2 != null) {
                    handler2.post(new Runnable() { // from class: com.tencent.qqmini.miniapp.core.service.AppBrandWebSocket.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AppBrandWebSocket.this.processMessage(str);
                        }
                    });
                }
            }
        };
    }

    private void debugMessageCallInterface(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        jSONObject2.getString("name");
        String string = jSONObject2.getString("method");
        JSONArray jSONArray = new JSONArray(jSONObject2.getString("args"));
        long j3 = jSONObject2.getLong("call_id");
        if (DebugUtils.Method.PUBLISHHANDLER.equals(string)) {
            String string2 = jSONArray.getString(0);
            String string3 = jSONArray.getString(1);
            String string4 = jSONArray.getString(2);
            if (HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(string4)) {
                string4 = "";
            }
            ServiceEventListener serviceEventListener = this.serviceEventListener;
            if (serviceEventListener != null) {
                serviceEventListener.onServiceEvent(string2, string3, jsStringToJavaIntArray(string4));
                sendCallInterfaceResultCmd(j3, "");
                QMLog.d("AppBrandRemoteService", "--- send callinterfaceResult   publishHandler: " + j3);
                return;
            }
            return;
        }
        if (DebugUtils.Method.INVOKEHANDLER.equals(string)) {
            String string5 = jSONArray.getString(0);
            String string6 = jSONArray.getString(1);
            int i3 = jSONArray.getInt(2);
            ServiceEventListener serviceEventListener2 = this.serviceEventListener;
            if (serviceEventListener2 != null) {
                sendCallInterfaceResultCmd(j3, serviceEventListener2.onServiceNativeRequest(string5, string6, i3));
                QMLog.d("AppBrandRemoteService", "--- send callinterfaceResult   invokeHandler: " + j3);
            }
        }
    }

    private void debugMessageDomOp(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        String string = jSONObject2.getString("params");
        int i3 = jSONObject2.getInt("webview_id");
        ServiceEventListener serviceEventListener = this.serviceEventListener;
        if (serviceEventListener != null) {
            serviceEventListener.onServiceEvent("remoteDebugCommand", string, new int[]{i3});
        }
    }

    private void debugMessageEvaluateJavascriptResult(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        String string = jSONObject2.getString("ret");
        long j3 = jSONObject2.getLong("evaluate_id");
        if (this.jsCallBackMap.containsKey(Long.valueOf(j3))) {
            ValueCallback valueCallback = this.jsCallBackMap.get(Long.valueOf(j3));
            if (valueCallback != null) {
                valueCallback.onReceiveValue(string);
            }
            this.jsCallBackMap.remove(Long.valueOf(j3));
        }
    }

    private void debugMessageSetupContextResult(JSONObject jSONObject) throws JSONException {
        this.hasSetupContextResult = true;
        while (!this.mEvaluateDatas.isEmpty()) {
            EvaluateData poll = this.mEvaluateDatas.poll();
            if (poll != null) {
                evaluateJsEx(poll.f346244js, poll.valueCallback);
            }
        }
        AppBrandRemoteService.OnLoadServiceWebvieJsListener onLoadServiceWebvieJsListener = this.mServiceInitFinishListener;
        if (onLoadServiceWebvieJsListener != null) {
            onLoadServiceWebvieJsListener.onLoadFinish();
        }
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

    private void processDebugMesage(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(DebugUtils.JSONObject.DEBUG_MESSAGE);
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
            sendArkCmd(jSONObject2.getLong("seq"));
            String string = jSONObject2.getString("category");
            if (string.equals(DebugUtils.Command.EVALUATE_JAVASCRIPT_RESULT)) {
                debugMessageEvaluateJavascriptResult(jSONObject2);
            } else if (string.equals(DebugUtils.Command.CALL_INTERFACE)) {
                debugMessageCallInterface(jSONObject2);
            } else if (string.equals(DebugUtils.Command.DOM_OP)) {
                debugMessageDomOp(jSONObject2);
            } else if (string.equals(DebugUtils.Command.SETUP_CONTEXT_RESULT)) {
                debugMessageSetupContextResult(jSONObject2);
            } else if (string.equals(DebugUtils.Command.BREAK_POINT)) {
                if (jSONObject2.getJSONObject("data").getInt("is_hit") == 0) {
                    AppStateEvent.obtain(101).notifyRuntime(this.miniAppContext);
                } else {
                    AppStateEvent.obtain(100).notifyRuntime(this.miniAppContext);
                }
            }
        }
    }

    private void processSocketMessage(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("code");
        if (!string.equals("0002") && !string.equals("0004")) {
            if (string.equals("1002")) {
                QMLog.d("AppBrandRemoteService", "enter room failed ");
                ProcessUtil.exitProcess(this.miniAppContext);
                return;
            }
            return;
        }
        jSONObject.getString("sessionId");
        this.hasEnterRoom = true;
        sendSetupContextCmd(this.mServiceInitFinishListener);
        evaluateJs("WeixinJSBridge.subscribeHandler('onWxConfigReady');", null);
    }

    public void evaluateJs(String str, ValueCallback valueCallback) {
        if (this.hasSetupContextResult) {
            while (!this.mEvaluateDatas.isEmpty()) {
                EvaluateData poll = this.mEvaluateDatas.poll();
                if (poll != null) {
                    evaluateJsEx(poll.f346244js, poll.valueCallback);
                }
            }
            evaluateJsEx(str, valueCallback);
            return;
        }
        this.mEvaluateDatas.add(new EvaluateData(str, valueCallback));
    }

    public void evaluateJsEx(String str, ValueCallback valueCallback) {
        long scriptId = getScriptId();
        sendStringMessage(getSendCmdString(DebugUtils.Body.DEBUG_MESSAGE_CLIENT, DebugUtils.Command.EVALUATE_JAVASCRIPT, getEvaluateSCriptData(str, scriptId)));
        if (valueCallback != null) {
            this.jsCallBackMap.put(Long.valueOf(scriptId), valueCallback);
        }
    }

    public JSONObject getCallInterfaceResultData(long j3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("call_id", j3);
            if (TextUtils.isEmpty(str)) {
                jSONObject.put("ret", "{}");
            } else {
                jSONObject.put("ret", str);
            }
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("AppBrandRemoteService", "getCallInterfaceResultData error:" + e16);
            return null;
        }
    }

    public String getDefaultConfigScript() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", this.mApkgInfo.appId);
            jSONObject.put("icon", this.mApkgInfo.iconUrl);
            jSONObject.put("nickname", this.mApkgInfo.apkgName);
            JSONObject jSONObject2 = new JSONObject(this.mApkgInfo.mConfigStr);
            jSONObject2.put("appContactInfo", new JSONObject("{'operationInfo':{'jsonInfo':{'apiAvailable':{'navigateToMiniProgramConfig':0,'shareCustomImageUrl':1,'authorize':0,'navigateToMiniProgram':1,'getUserInfo':0,'openSetting':0}}}}"));
            jSONObject2.remove("preload");
            String str = "release";
            IMiniAppContext iMiniAppContext = this.miniAppContext;
            if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null) {
                str = this.miniAppContext.getMiniAppInfo().getVerTypeStr();
            }
            String format = String.format("function extend(obj, src) {\n    for (var key in src) {\n        if (src.hasOwnProperty(key)) obj[key] = src[key];\n    }\n    return obj;\n}\nif (typeof __qqConfig === 'undefined') var __qqConfig = {};var __tempConfig = JSON.parse('%1$s'); __qqConfig = extend(__qqConfig, __tempConfig);__qqConfig.accountInfo=JSON.parse('%2$s'); __qqConfig.envVersion='" + str + "';__qqConfig.QUA='" + QUAUtil.getPlatformQUA() + "';var __wxIndexPage = 'page/index/index.html';", jSONObject2.toString(), jSONObject.toString());
            IMiniAppContext iMiniAppContext2 = this.miniAppContext;
            if (iMiniAppContext2 != null && DebugUtil.getDebugEnabled(iMiniAppContext2.getMiniAppInfo())) {
                format = format + "__qqConfig.debug =true;";
            }
            if (this.mEmbeddedState != null) {
                String str2 = format + "__qqConfig.useXWebVideo=" + this.mEmbeddedState.isEnableEmbeddedVideo() + ";";
                QMLog.d("miniapp-embedded", "x5 service enableEmbeddedVideo : " + this.mEmbeddedState.isEnableEmbeddedVideo());
                String str3 = str2 + "__qqConfig.useXWebLive=" + this.mEmbeddedState.isEnableEmbeddedLive() + ";";
                QMLog.d("miniapp-embedded", "x5 service enableEmbeddedLive : " + this.mEmbeddedState.isEnableEmbeddedLive());
                format = str3 + "__qqConfig.useXWebElement=" + this.mEmbeddedState.isEnableEmbeddedElement() + ";";
                QMLog.d("miniapp-embedded", "x5 service enableEmbeddedElement : " + this.mEmbeddedState.isEnableEmbeddedElement());
            }
            return format + "if (typeof WeixinJSBridge != 'undefined' && typeof WeixinJSBridge.subscribeHandler == 'function') {WeixinJSBridge.subscribeHandler('onWxConfigReady')};";
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public JSONObject getDeviceInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("device_name", Build.DEVICE);
            jSONObject.put("device_model", DeviceInfoUtil.getPhoneModel());
            jSONObject.put("os", Build.VERSION.SDK_INT);
            jSONObject.put(AppConstants.Preferences.QQ_VERSION, "8.3.6");
            jSONObject.put("pixel_ratio", "3");
            jSONObject.put("screen_width", ViewUtils.getScreenWidth());
            jSONObject.put("publib", this.miniAppContext.getBaseLibVersion());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.e("AppBrandRemoteService", "getDeviceInfo error:", e16);
            return null;
        }
    }

    public JSONObject getDomEventData(String str, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("params", str);
            jSONObject.put("webview_id", i3);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("AppBrandRemoteService", "getDomEventData error:" + e16);
            return null;
        }
    }

    public JSONObject getEvaluateSCriptData(String str, long j3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("script", str);
            jSONObject.put("evaluate_id", j3);
            return jSONObject;
        } catch (Exception e16) {
            QMLog.e("AppBrandRemoteService", "getEvaluateSCriptData error:", e16);
            return null;
        }
    }

    int getNetworkType() {
        int activeNetworkType = NetworkUtil.getActiveNetworkType(this.miniAppContext.getContext());
        if (activeNetworkType == 5) {
            return 1;
        }
        if (activeNetworkType == 1) {
            return 5;
        }
        if (activeNetworkType != 2 && activeNetworkType != 3 && activeNetworkType != 4) {
            return 0;
        }
        return activeNetworkType;
    }

    public int getPingCount() {
        return this.pingcount.incrementAndGet();
    }

    public int getScriptId() {
        return this.scriptId.incrementAndGet();
    }

    public String getSendCmdString(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("seq", getSeq());
            jSONObject2.put("category", str2);
            jSONObject2.put("data", jSONObject);
            jSONObject2.put("compress_algo", 0);
            jSONObject2.put("original_size", 0);
            jSONObject2.put("delay", 0);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(DebugUtils.JSONObject.DEBUG_MESSAGE, jSONArray);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("cmd", str);
            jSONObject4.put("data", jSONObject3);
            return jSONObject4.toString();
        } catch (Exception e16) {
            QMLog.d("AppBrandRemoteService", "send Cmd error: " + e16);
            return "";
        }
    }

    public int getSeq() {
        return this.count.incrementAndGet();
    }

    public JSONObject getSetupContexData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("configure_js", getDefaultConfigScript());
            jSONObject.put("device_info", getDeviceInfo());
            jSONObject.put("support_compress_algo", 0);
            jSONObject.put("publib_ver", this.miniAppContext.getBaseLibVersion());
            return jSONObject;
        } catch (Exception e16) {
            QMLog.d("AppBrandRemoteService", "getSetupContexData error:" + e16);
            return null;
        }
    }

    public void initEmbeddedState(EmbeddedState embeddedState) {
        this.mEmbeddedState = embeddedState;
    }

    protected void processMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("cmd");
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            if (string.equals(DebugUtils.Body.DEBUG_PING)) {
                sendPongCmd(jSONObject2.getLong("ping_id"));
            } else if (string.equals(DebugUtils.Body.DEBUG_SOCKET_MESSAGE)) {
                processSocketMessage(jSONObject2);
            } else if (string.equals(DebugUtils.Body.DEBUG_MESSAGE_MASTER)) {
                processDebugMesage(jSONObject2);
            } else {
                string.equals(DebugUtils.Body.DEBUG_ARK_MASTER);
            }
        } catch (Exception e16) {
            QMLog.e("AppBrandRemoteService", "cmd error: " + e16);
        }
    }

    public void sendArkCmd(long j3) {
        sendStringMessage("{\"cmd\":\"DebugArkClient\",\"data\":{\"ark_message\":[{\"ark\":" + j3 + "}]}}");
    }

    public void sendCallInterfaceResultCmd(long j3, String str) {
        sendStringMessage(getSendCmdString(DebugUtils.Body.DEBUG_MESSAGE_CLIENT, DebugUtils.Command.CALL_INTERFACE_RESULT, getCallInterfaceResultData(j3, str)));
    }

    public void sendDomEvent(String str, int i3) {
        sendStringMessage(getSendCmdString(DebugUtils.Body.DEBUG_MESSAGE_CLIENT, DebugUtils.Command.DOM_EVENT, getDomEventData(str, i3)));
    }

    public void sendPingCmd(long j3) {
        sendStringMessage("{ \"cmd\": \"DebugPong\", \"data\": { \"ping_id\": " + j3 + " }}");
    }

    public void sendPongCmd(long j3) {
        sendStringMessage("{ \"cmd\": \"DebugPong\", \"data\": { \"ping_id\": " + j3 + ",\"network_type\":" + getNetworkType() + " }}");
    }

    public void sendSetupContextCmd(AppBrandRemoteService.OnLoadServiceWebvieJsListener onLoadServiceWebvieJsListener) {
        if (this.hasEnterRoom) {
            if (!this.hasSetupContext && this.mApkgInfo != null) {
                sendStringMessage(getSendCmdString(DebugUtils.Body.DEBUG_MESSAGE_CLIENT, DebugUtils.Command.SETUP_CONTEXT, getSetupContexData()));
                this.hasSetupContext = true;
            }
            if (onLoadServiceWebvieJsListener != null) {
                this.mServiceInitFinishListener = onLoadServiceWebvieJsListener;
                if (this.hasSetupContextResult) {
                    onLoadServiceWebvieJsListener.onLoadFinish();
                    return;
                }
                return;
            }
            return;
        }
        this.mServiceInitFinishListener = onLoadServiceWebvieJsListener;
    }

    public void setApkgInfo(ApkgInfo apkgInfo) {
        this.mApkgInfo = apkgInfo;
    }

    public void setServiceEventListener(ServiceEventListener serviceEventListener) {
        this.serviceEventListener = serviceEventListener;
    }
}
