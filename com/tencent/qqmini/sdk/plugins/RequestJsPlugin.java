package com.tencent.qqmini.sdk.plugins;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ark.ark;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.luggage.wxa.nf.f;
import com.tencent.luggage.wxa.nf.i;
import com.tencent.luggage.wxa.pf.a;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.MiniappHttpUtil;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05116;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class RequestJsPlugin extends BaseJsPlugin {
    private static final String STATE_COMPLETE = "complete";
    private static final String STATE_FAIL = "fail";
    private static final String STATE_OK = "ok";
    private static final String TAG = "[mini] http.RequestJsPlugin";
    private static final String WNS_CGI_REQUEST = "wnsCgiRequest";
    private static final String WNS_GUILD_REQUEST = "wnsGuildRequest";
    private final byte[] lock = new byte[0];
    private final ConcurrentHashMap<Integer, RequestTask> requestMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, WebsocketRequestTask> wsrequestMap = new ConcurrentHashMap<>();
    private static final List<String> HIGH_FREQUERCY_FAILED_URL = new ArrayList(Arrays.asList("https://api.deep.fenpeiduixiang.com/api/analytic/app/log/poster?"));
    private static final ArrayList<String> supportMethod = new ArrayList<>(Arrays.asList(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, "DELETE", "TRACE"));

    /* loaded from: classes23.dex */
    public class RequestTask {
        public byte[] mBody;
        public String mDataType;
        private final IJsService mJsService;
        public String mMethod;
        public String mOriginUrl;
        public String mResponseType;
        public long mTimeOut;
        public String mUrl;
        public Map<String, String> mHeaders = new HashMap();
        public int mTaskId = RequestProxy.getRequestSocketId();
        public long mRequestCreatedMillis = SystemClock.elapsedRealtime();

        public RequestTask(IJsService iJsService, JSONObject jSONObject) {
            this.mMethod = "GET";
            this.mDataType = ark.ARKMETADATA_JSON;
            this.mResponseType = "text";
            this.mJsService = iJsService;
            if (jSONObject == null) {
                return;
            }
            this.mUrl = jSONObject.optString("url", "");
            if (jSONObject.has("origin_url")) {
                this.mOriginUrl = jSONObject.optString("origin_url");
            } else {
                this.mOriginUrl = this.mUrl;
            }
            this.mMethod = jSONObject.optString("method", this.mMethod);
            this.mDataType = jSONObject.optString("dataType", this.mDataType);
            this.mResponseType = jSONObject.optString("responseType", this.mResponseType);
            this.mTimeOut = Math.min(jSONObject.optLong("timeout", 60000L), 180000L);
            RequestJsPlugin.mergeHeaders(this.mHeaders, jSONObject);
            this.mHeaders.put("Referer", RequestJsPlugin.this.getRequestReferer());
            this.mHeaders.put("User-Agent", QUAUtil.getRequestUA());
            processBody(jSONObject);
        }

        private void processBody(JSONObject jSONObject) {
            byte[] bArr;
            NativeBuffer unpackNativeBuffer = NativeBuffer.unpackNativeBuffer(this.mJsService, jSONObject, "data");
            byte[] bArr2 = null;
            if (unpackNativeBuffer != null) {
                bArr = unpackNativeBuffer.buf;
            } else {
                bArr = null;
            }
            this.mBody = bArr;
            if (bArr == null && jSONObject.has("data")) {
                String optString = jSONObject.optString("data");
                if (optString != null) {
                    bArr2 = optString.getBytes();
                }
                this.mBody = bArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class WebsocketRequestTask {
        public String mMethod;
        public String mOriginUrl;
        public int mTimeout;
        public String mUrl;
        public Map<String, String> mHeaders = new HashMap();
        public int mTaskId = WebSocketProxy.getWebSocketRequestId();

        public WebsocketRequestTask(JSONObject jSONObject, String str) {
            if (jSONObject != null) {
                if (jSONObject.has("url")) {
                    this.mUrl = jSONObject.optString("url");
                }
                if (jSONObject.has("origin_url")) {
                    this.mOriginUrl = jSONObject.optString("origin_url");
                } else {
                    this.mOriginUrl = this.mUrl;
                }
                if (jSONObject.has("method")) {
                    this.mMethod = jSONObject.optString("method");
                }
                RequestJsPlugin.mergeHeaders(this.mHeaders, jSONObject);
                if (jSONObject.has("timeout")) {
                    this.mTimeout = jSONObject.optInt("timeout");
                }
                this.mHeaders.put("Referer", str);
                this.mHeaders.put("User-Agent", QUAUtil.getRequestUA());
            }
        }
    }

    /* loaded from: classes23.dex */
    class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f348242a;

        a(RequestEvent requestEvent) {
            this.f348242a = requestEvent;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            if (z16) {
                RequestJsPlugin.this.callbackOK(this.f348242a, jSONObject);
            } else if (jSONObject != null) {
                RequestJsPlugin.this.callbackFail(this.f348242a, jSONObject, jSONObject.optString("errMsg"));
            } else {
                RequestJsPlugin.this.callbackFail(this.f348242a, null, "do not support addGroupApp!");
            }
        }
    }

    private void callback(RequestEvent requestEvent, JSONObject jSONObject, String str, String str2, String str3) {
        String str4;
        if (requestEvent != null) {
            StringBuilder sb5 = new StringBuilder();
            if (str3 == null) {
                str3 = requestEvent.event;
            }
            sb5.append(str3);
            sb5.append(":");
            sb5.append(str);
            if (TextUtils.isEmpty(str2)) {
                str4 = "";
            } else {
                str4 = " " + str2;
            }
            sb5.append(str4);
            String jSONObject2 = JSONUtil.append(jSONObject, "errMsg", sb5.toString()).toString();
            requestEvent.evaluateCallbackJs(jSONObject2);
            if ("fail".equals(str)) {
                QMLog.e(TAG, "[callbackFail] " + jSONObject2);
            }
        }
    }

    private void callbackComplete(RequestEvent requestEvent, JSONObject jSONObject) {
        callback(requestEvent, jSONObject, STATE_COMPLETE, null, null);
    }

    private void callbackFail(RequestEvent requestEvent, JSONObject jSONObject) {
        callback(requestEvent, jSONObject, "fail", null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackOK(RequestEvent requestEvent, JSONObject jSONObject) {
        callback(requestEvent, jSONObject, "ok", null, null);
    }

    private void connectSocket(final RequestEvent requestEvent, WebSocketProxy webSocketProxy, int i3, final WebsocketRequestTask websocketRequestTask) {
        webSocketProxy.connectSocket(websocketRequestTask.mTaskId, websocketRequestTask.mUrl, websocketRequestTask.mHeaders, websocketRequestTask.mMethod, i3, new WebSocketProxy.WebSocketListener() { // from class: com.tencent.qqmini.sdk.plugins.RequestJsPlugin.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onClose(int i16, int i17, String str) {
                QMLog.d(RequestJsPlugin.TAG, "---onClosed---");
                RequestJsPlugin.this.onCloseCallback(requestEvent, i17, str, websocketRequestTask.mTaskId);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onError(int i16, int i17, String str) {
                QMLog.e(RequestJsPlugin.TAG, "MiniAppWebsocketListener onFailure, socketId=" + websocketRequestTask.mTaskId + str);
                RequestJsPlugin.this.onConnectSocketError(i17, str, websocketRequestTask, requestEvent);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onMessage(int i16, byte[] bArr) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("socketTaskId", websocketRequestTask.mTaskId);
                    jSONObject.put("state", "message");
                    jSONObject.put("errMsg", "ok");
                    jSONObject.put("isBuffer", true);
                    if (((BaseJsPlugin) RequestJsPlugin.this).mIsMiniGame) {
                        NativeBuffer.packNativeBuffer(requestEvent.jsService, bArr, NativeBuffer.TYPE_BUFFER_NATIVE, "data", jSONObject);
                    } else {
                        NativeBuffer.packNativeBuffer(requestEvent.jsService, bArr, NativeBuffer.TYPE_BUFFER_BASE64, "data", jSONObject);
                    }
                    requestEvent.jsService.evaluateSubscribeJS(f.b.NAME, jSONObject.toString(), 0);
                } catch (Exception e16) {
                    QMLog.e(RequestJsPlugin.TAG, "MiniAppWebsocketListener onMessage exception:", e16);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onOpen(int i16, int i17, Map<String, List<String>> map) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("socketTaskId", websocketRequestTask.mTaskId);
                    jSONObject.put("state", "open");
                    jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i17);
                    jSONObject.put("header", JSONUtil.headerToJson(map));
                    requestEvent.jsService.evaluateSubscribeJS(f.b.NAME, jSONObject.toString(), 0);
                    MiniReportManager.reportEventType(((BaseJsPlugin) RequestJsPlugin.this).mMiniAppInfo, 632, null, null, null, 0, MiniReportManager.getAppType(((BaseJsPlugin) RequestJsPlugin.this).mMiniAppInfo), 0L, RequestJsPlugin.getSecondLevelDomain(websocketRequestTask.mUrl));
                } catch (JSONException e16) {
                    QMLog.e(RequestJsPlugin.TAG, "MiniAppWebsocketListener onOpen error:", e16);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
            public void onMessage(int i16, String str) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("socketTaskId", websocketRequestTask.mTaskId);
                    jSONObject.put("state", "message");
                    jSONObject.put("errMsg", "ok");
                    jSONObject.put("isBuffer", false);
                    jSONObject.put("data", str);
                    requestEvent.jsService.evaluateSubscribeJS(f.b.NAME, jSONObject.toString(), 0);
                } catch (JSONException e16) {
                    QMLog.e(RequestJsPlugin.TAG, "MiniAppWebsocketListener onMessage exception:", e16);
                }
            }
        });
    }

    private String createRequestTaskInMiniGame(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final RequestTask requestTask = new RequestTask(requestEvent.jsService, jSONObject);
            jSONObject.put("requestTaskId", requestTask.mTaskId);
            ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.RequestJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    RequestJsPlugin requestJsPlugin = RequestJsPlugin.this;
                    requestJsPlugin.executeRequestTask(((BaseJsPlugin) requestJsPlugin).mMiniAppInfo, requestEvent, jSONObject, requestTask);
                }
            });
            return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
        } catch (JSONException e16) {
            QMLog.e(TAG, "createRequestTaskInMiniGame: parse params failed.", e16);
            return ApiUtil.wrapCallbackFail(requestEvent.event, null, "").toString();
        }
    }

    private boolean doRequest(final RequestEvent requestEvent, final RequestTask requestTask, final String str, RequestProxy requestProxy, final boolean z16) {
        int min;
        long j3 = requestTask.mTimeOut;
        if (j3 <= 0) {
            min = 60000;
        } else {
            min = (int) Math.min(60000L, j3);
        }
        return requestProxy.request(requestTask.mUrl, requestTask.mBody, requestTask.mHeaders, requestTask.mMethod, min, new RequestProxy.RequestListener() { // from class: com.tencent.qqmini.sdk.plugins.RequestJsPlugin.2
            String contentType;

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
            public void onRequestFailed(int i3, String str2) {
                long j16;
                String convertCode2Reason;
                RequestTask requestTask2 = (RequestTask) RequestJsPlugin.this.requestMap.get(Integer.valueOf(requestTask.mTaskId));
                RequestJsPlugin requestJsPlugin = RequestJsPlugin.this;
                RequestTask requestTask3 = requestTask;
                requestJsPlugin.reportRequestResult(i3, requestTask2, requestTask3, requestEvent, str, 0, requestTask3.mMethod);
                if (requestTask2 != null) {
                    j16 = SystemClock.elapsedRealtime() - requestTask2.mRequestCreatedMillis;
                } else {
                    j16 = 0;
                }
                com.tencent.qqmini.sdk.report.a.d(((BaseJsPlugin) RequestJsPlugin.this).mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, str, i3, 0L, j16);
                QMLog.e(RequestJsPlugin.TAG, "--fail--- url: " + requestTask.mUrl + " taskId=" + requestTask.mTaskId + " resCode=" + i3);
                if (!TextUtils.isEmpty(str2)) {
                    convertCode2Reason = str2 + " errCode: " + i3;
                } else {
                    convertCode2Reason = MiniappHttpUtil.convertCode2Reason(Const.BUNDLE_KEY_REQUEST, i3);
                }
                RequestJsPlugin.this.onCreateRequestTaskFail(requestEvent, requestTask.mTaskId, convertCode2Reason);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
            public void onRequestHeadersReceived(int i3, Map<String, List<String>> map) {
                List<String> list;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", str);
                    jSONObject.put("requestTaskId", requestTask.mTaskId);
                    jSONObject.put("header", JSONUtil.headerToJson(map));
                    jSONObject.put("errMsg", "ok");
                    jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i3);
                    jSONObject.put("state", "headersReceived");
                    if (map != null && map.containsKey("Content-Type") && (list = map.get("Content-Type")) != null && list.size() > 0) {
                        this.contentType = list.get(0);
                    }
                    requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject.toString(), 0);
                } catch (Exception e16) {
                    QMLog.e(RequestJsPlugin.TAG, "headersReceived exception, url: " + requestTask.mUrl, e16);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener
            public void onRequestSucceed(int i3, byte[] bArr, Map<String, List<String>> map) {
                int i16;
                long j16;
                RequestTask requestTask2 = (RequestTask) RequestJsPlugin.this.requestMap.remove(Integer.valueOf(requestTask.mTaskId));
                if (bArr != null) {
                    i16 = bArr.length;
                } else {
                    i16 = 0;
                }
                RequestJsPlugin requestJsPlugin = RequestJsPlugin.this;
                RequestTask requestTask3 = requestTask;
                requestJsPlugin.reportRequestResult(i3, requestTask2, requestTask3, requestEvent, str, i16, requestTask3.mMethod);
                if (requestTask2 != null) {
                    j16 = SystemClock.elapsedRealtime() - requestTask2.mRequestCreatedMillis;
                } else {
                    j16 = 0;
                }
                long j17 = j16;
                if (z16) {
                    com.tencent.qqmini.sdk.report.a.g(((BaseJsPlugin) RequestJsPlugin.this).mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, str, i16, j17);
                }
                RequestJsPlugin.this.onRequestSucceed(i3, bArr, map, str, requestTask, requestEvent);
            }
        });
    }

    private boolean doWnsCgiRequest(final RequestEvent requestEvent) throws JSONException {
        String replace = requestEvent.jsonParams.replace("{groupId}", String.valueOf(this.mMiniAppInfo.launchParam.entryModel.uin));
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null) {
            channelProxy.wnsCgiRequest(new JSONObject(replace), new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.RequestJsPlugin.6
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        RequestJsPlugin.this.callbackOK(requestEvent, jSONObject);
                    } else {
                        RequestJsPlugin.this.callbackFail(requestEvent, null, "do not support wnsGroupRequest");
                    }
                }
            });
            return false;
        }
        callbackFail(requestEvent, null, "do not support wnsGroupRequest");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeRequestTask(MiniAppInfo miniAppInfo, RequestEvent requestEvent, JSONObject jSONObject, RequestTask requestTask) {
        if (miniAppInfo == null) {
            onCreateRequestTaskFail(requestEvent, requestTask.mTaskId, "game info get null.");
            return;
        }
        ((RequestStrategyProxy) ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(jSONObject);
        String str = requestTask.mOriginUrl;
        boolean f16 = com.tencent.qqmini.sdk.report.a.f(miniAppInfo, Const.BUNDLE_KEY_REQUEST, str);
        String str2 = requestTask.mMethod;
        if (str2 != null && !supportMethod.contains(str2.toUpperCase())) {
            com.tencent.qqmini.sdk.report.a.e(miniAppInfo, Const.BUNDLE_KEY_REQUEST, str, "request protocol error");
            onCreateRequestTaskFail(requestEvent, requestTask.mTaskId, "request protocol error");
            return;
        }
        if (!TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("http://"))) {
            if (!DomainUtil.isDomainValid(miniAppInfo, jSONObject.optBoolean("__skipDomainCheck__", false), str, 0)) {
                String str3 = "\u8bf7\u6c42\u57df\u540d\u672a\u52a0\u767d\u540d\u5355\uff0curl=" + str;
                com.tencent.qqmini.sdk.report.a.e(miniAppInfo, Const.BUNDLE_KEY_REQUEST, str, str3);
                onCreateRequestTaskFail(requestEvent, requestTask.mTaskId, str3);
                return;
            }
            if (this.requestMap.size() >= 200) {
                com.tencent.qqmini.sdk.report.a.e(miniAppInfo, Const.BUNDLE_KEY_REQUEST, str, "[httpRequest] too much request");
                onCreateRequestTaskFail(requestEvent, requestTask.mTaskId, "[httpRequest] too much request");
                return;
            } else {
                this.requestMap.put(Integer.valueOf(requestTask.mTaskId), requestTask);
                if (!doRequest(requestEvent, requestTask, str, (RequestProxy) ProxyManager.get(RequestProxy.class), f16)) {
                    onCreateRequestTaskFail(requestEvent, requestTask.mTaskId, "request not impl.");
                    return;
                }
                return;
            }
        }
        com.tencent.qqmini.sdk.report.a.e(miniAppInfo, Const.BUNDLE_KEY_REQUEST, str, "url is invalid");
        onCreateRequestTaskFail(requestEvent, requestTask.mTaskId, "url is invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getRequestReferer() {
        String str;
        String str2;
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            str = miniAppInfo.appId;
            str2 = miniAppInfo.version;
        } else {
            str = "";
            str2 = "debug";
        }
        if (!MiniappHttpUtil.isRefererVersionValid(str2)) {
            str2 = "invalidVersion";
        }
        return "https://appservice.qq.com/" + str + "/" + str2 + "/page-frame.html";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSecondLevelDomain(String str) {
        Uri parse;
        String host;
        if (str != null && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            String[] split = host.split("\\.");
            if (split.length > 3) {
                int length = split.length;
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = length - 3; i3 < length; i3++) {
                    sb5.append(split[i3]);
                    if (i3 != length - 1) {
                        sb5.append('.');
                    }
                }
                return sb5.toString();
            }
            return host;
        }
        return null;
    }

    private boolean isHighFrequencyFailedUrl(String str) {
        Iterator<String> it = HIGH_FREQUERCY_FAILED_URL.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mergeHeaders(Map<String, String> map, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject.has("header") && (optJSONObject = jSONObject.optJSONObject("header")) != null) {
            map.putAll(JSONUtil.toMap(optJSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCloseCallback(RequestEvent requestEvent, int i3, String str, int i16) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("socketTaskId", i16);
            jSONObject.put("state", "close");
            jSONObject.put("code", i3);
            jSONObject.put("reason", str);
            requestEvent.jsService.evaluateSubscribeJS(f.b.NAME, jSONObject.toString(), 0);
            WebsocketRequestTask websocketRequestTask = this.wsrequestMap.get(Integer.valueOf(i16));
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            String appType = MiniReportManager.getAppType(miniAppInfo);
            if (websocketRequestTask != null) {
                str2 = websocketRequestTask.mUrl;
            } else {
                str2 = null;
            }
            MiniReportManager.reportEventType(miniAppInfo, 633, null, null, null, 0, appType, 0L, getSecondLevelDomain(str2));
        } catch (JSONException e16) {
            QMLog.e(TAG, "MiniAppWebsocketListener onClose exception:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectSocketError(int i3, String str, WebsocketRequestTask websocketRequestTask, RequestEvent requestEvent) {
        String str2;
        String str3;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        try {
            if (!str2.equals("SSL handshake timed out") && !str2.equals("timeout")) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("socketTaskId", websocketRequestTask.mTaskId);
                jSONObject.put("state", "error");
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    str3 = "resposeCode=" + i3;
                    QMLog.e(TAG, "MiniAppWebsocketListener onFailure socketId=" + websocketRequestTask.mTaskId + " errMsg=" + str3);
                    requestEvent.jsService.evaluateSubscribeJS(f.b.NAME, jSONObject.toString(), 0);
                    MiniAppInfo miniAppInfo = this.mMiniAppInfo;
                    MiniReportManager.reportEventType(miniAppInfo, 634, null, null, null, 0, MiniReportManager.getAppType(miniAppInfo), 0L, getSecondLevelDomain(websocketRequestTask.mUrl));
                }
                str3 = "network is down";
                jSONObject.put("errMsg", "network is down");
                QMLog.e(TAG, "MiniAppWebsocketListener onFailure socketId=" + websocketRequestTask.mTaskId + " errMsg=" + str3);
                requestEvent.jsService.evaluateSubscribeJS(f.b.NAME, jSONObject.toString(), 0);
                MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
                MiniReportManager.reportEventType(miniAppInfo2, 634, null, null, null, 0, MiniReportManager.getAppType(miniAppInfo2), 0L, getSecondLevelDomain(websocketRequestTask.mUrl));
            }
            QMLog.e(TAG, "MiniAppWebsocketListener onFailure , timeout , send close state. socketId=" + websocketRequestTask.mTaskId);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("socketTaskId", websocketRequestTask.mTaskId);
            jSONObject2.put("state", "close");
            jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i3);
            requestEvent.jsService.evaluateSubscribeJS(f.b.NAME, jSONObject2.toString(), 0);
            MiniAppInfo miniAppInfo22 = this.mMiniAppInfo;
            MiniReportManager.reportEventType(miniAppInfo22, 634, null, null, null, 0, MiniReportManager.getAppType(miniAppInfo22), 0L, getSecondLevelDomain(websocketRequestTask.mUrl));
        } catch (JSONException e16) {
            QMLog.e(TAG, "MiniAppWebsocketListener onFailure exception:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCreateRequestTaskFail(RequestEvent requestEvent, int i3, String str) {
        this.requestMap.remove(Integer.valueOf(i3));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", "fail");
            jSONObject.put("requestTaskId", i3);
            jSONObject.put("errMsg", str);
            requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject.toString(), 0);
        } catch (Exception e16) {
            QMLog.e(TAG, "onRequestFailed: failed.", e16);
        }
        QMLog.w(TAG, "createRequestTask execute failed, error=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequestSucceed(int i3, byte[] bArr, Map<String, List<String>> map, String str, RequestTask requestTask, RequestEvent requestEvent) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("url", str);
            if (i3 > 0) {
                jSONObject2.put("requestTaskId", requestTask.mTaskId);
                if (map != null) {
                    jSONObject2.put("header", JSONUtil.headerToJson(map));
                }
                jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, i3);
                jSONObject2.put("state", "success");
                jSONObject2.put("errMsg", "ok");
                try {
                    if (bArr != null) {
                        if ("arraybuffer".equals(requestTask.mResponseType)) {
                            if (this.mIsMiniGame) {
                                NativeBuffer.packNativeBuffer(requestEvent.jsService, bArr, NativeBuffer.TYPE_BUFFER_NATIVE, "data", jSONObject2);
                            } else {
                                NativeBuffer.packNativeBuffer(requestEvent.jsService, bArr, NativeBuffer.TYPE_BUFFER_BASE64, "data", jSONObject2);
                            }
                        } else {
                            if ("text".equals(requestTask.mResponseType)) {
                                if (bArr.length > 3 && (bArr[0] & 255) == 239 && (bArr[1] & 255) == 187 && (bArr[2] & 255) == 191) {
                                    str2 = new String(bArr, 3, bArr.length - 3, "UTF-8");
                                } else {
                                    str2 = new String(bArr, "UTF-8");
                                }
                                jSONObject2.put("data", str2);
                                jSONObject.put("res", jSONObject2);
                                requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject2.toString(), 0);
                            }
                            QMLog.e(TAG, "url: " + requestTask.mUrl + "--mResponseType error ---" + requestTask.mResponseType);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("state", "fail");
                            jSONObject3.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, -1);
                            jSONObject3.put("requestTaskId", requestTask.mTaskId);
                            requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject3.toString(), 0);
                            return;
                        }
                    }
                    jSONObject.put("res", jSONObject2);
                    requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject2.toString(), 0);
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("state", "fail");
                        jSONObject4.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "-1");
                        jSONObject4.put("requestTaskId", requestTask.mTaskId);
                        jSONObject4.put("errMsg", "exception\uff1a" + th.getMessage());
                        requestEvent.jsService.evaluateSubscribeJS(a.b.NAME, jSONObject4.toString(), 0);
                    } catch (Throwable unused) {
                    }
                    QMLog.e(TAG, "httpCallBack exception:", th);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private String operateSocketClose(RequestEvent requestEvent, JSONObject jSONObject, int i3) {
        synchronized (this.lock) {
            ConcurrentHashMap<Integer, WebsocketRequestTask> concurrentHashMap = this.wsrequestMap;
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                WebsocketRequestTask websocketRequestTask = this.wsrequestMap.get(Integer.valueOf(i3));
                this.wsrequestMap.remove(Integer.valueOf(i3));
                int optInt = jSONObject.optInt("code", 1000);
                String optString = jSONObject.optString("reason", "Goodbye");
                WebSocketProxy webSocketProxy = (WebSocketProxy) ProxyManager.get(WebSocketProxy.class);
                if (webSocketProxy != null && websocketRequestTask != null) {
                    webSocketProxy.closeSocket(i3, optInt, optString);
                }
                if (this.mIsMiniGame) {
                    callbackOK(requestEvent, null, "closeSocket");
                }
                return ApiUtil.wrapCallbackOk(requestEvent.event, null).toString();
            }
            if (this.mIsMiniGame) {
                callbackFail(requestEvent, null, "do not have this socket ", "closeSocket");
            }
            return ApiUtil.wrapCallbackFail(requestEvent.event, null, "do not have this socket ").toString();
        }
    }

    private String operateSocketSend(RequestEvent requestEvent, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("data", null);
        if (optString != null) {
            return operateSocketSend(requestEvent, i3, optString);
        }
        if (NativeBuffer.hasNativeBuffer(jSONObject)) {
            return operateSocketSendWithNativeBuffer(requestEvent, jSONObject, i3);
        }
        return null;
    }

    @NotNull
    private String operateSocketSendWithNativeBuffer(RequestEvent requestEvent, JSONObject jSONObject, int i3) {
        ConcurrentHashMap<Integer, WebsocketRequestTask> concurrentHashMap;
        NativeBuffer unpackNativeBuffer = NativeBuffer.unpackNativeBuffer(requestEvent.jsService, jSONObject, "data");
        if (unpackNativeBuffer != null && unpackNativeBuffer.buf != null && (concurrentHashMap = this.wsrequestMap) != null && concurrentHashMap.size() != 0) {
            WebsocketRequestTask websocketRequestTask = this.wsrequestMap.get(Integer.valueOf(i3));
            WebSocketProxy webSocketProxy = (WebSocketProxy) ProxyManager.get(WebSocketProxy.class);
            if (websocketRequestTask != null && webSocketProxy != null) {
                webSocketProxy.send(i3, unpackNativeBuffer.buf);
                if (this.mIsMiniGame) {
                    callbackOK(requestEvent, null);
                }
                return ApiUtil.wrapCallbackOk(requestEvent.event, null).toString();
            }
            QMLog.e(TAG, requestEvent.event + " error, send NativeBuffer on null socket instance");
            if (this.mIsMiniGame) {
                callbackFail(requestEvent, null, "socket is null ", "sendSocketMessage");
            }
            return ApiUtil.wrapCallbackFail(requestEvent.event, null, "socket is null ").toString();
        }
        if (this.mIsMiniGame) {
            callbackFail(requestEvent, null, "do not have this socket ", "closeSocket");
        }
        return ApiUtil.wrapCallbackFail(requestEvent.event, null, "do not have this socket ").toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRequestResult(int i3, RequestTask requestTask, RequestTask requestTask2, RequestEvent requestEvent, String str, int i16, String str2) {
        String str3;
        if (requestTask != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - requestTask.mRequestCreatedMillis;
            if (QMLog.isColorLevel() && !isHighFrequencyFailedUrl(str)) {
                QMLog.d(TAG, "[request httpCallBack][minigame timecost=" + elapsedRealtime + "ms],[code=" + i3 + "][url=" + requestTask2.mUrl + "][callbackId=" + requestEvent.callbackId + "][params=" + requestEvent.jsonParams + "]");
            }
            String secondLevelDomain = getSecondLevelDomain(requestTask.mOriginUrl);
            QMLog.d(TAG, "httpCallBack second level domain " + secondLevelDomain);
            if (this.mIsMiniGame) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            MiniReportManager.reportEventType(this.mMiniAppInfo, 628, null, null, null, i3, str3, elapsedRealtime, secondLevelDomain, str2, null, null, null);
            long j3 = i16;
            MiniProgramLpReportDC05115.reportHttpRequestResult(this.mMiniAppInfo, i3, j3, elapsedRealtime);
            MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.mMiniAppInfo, str, j3, elapsedRealtime, i3);
        }
    }

    private String startCgiRequest(final RequestEvent requestEvent, final String str) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optJSONObject.put("Referer", getRequestReferer());
            ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
            if (channelProxy != null) {
                channelProxy.wnsCgiRequest(jSONObject, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.RequestJsPlugin.5
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z16, JSONObject jSONObject2) {
                        if (z16) {
                            RequestJsPlugin.this.callbackOK(requestEvent, jSONObject2);
                            return;
                        }
                        RequestJsPlugin.this.callbackFail(requestEvent, null, "do not support " + str);
                    }
                });
                return "";
            }
            callbackFail(requestEvent, null, "do not support " + str);
            return ApiUtil.wrapCallbackFail(requestEvent.event, null, "do not support " + str).toString();
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " exception:", th5);
            return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
        }
    }

    @JsEvent({"addGroupApp"})
    public String addGroupApp(RequestEvent requestEvent) {
        IMiniAppContext iMiniAppContext;
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null && (iMiniAppContext = this.mMiniAppContext) != null) {
            channelProxy.addGroupApp(iMiniAppContext, new a(requestEvent));
            return "";
        }
        callbackFail(requestEvent, null, "do not support addGroupApp");
        return ApiUtil.wrapCallbackFail(requestEvent.event, null, "do not support addGroupApp").toString();
    }

    @JsEvent({com.tencent.luggage.wxa.pf.b.NAME})
    public String createRequestTask(RequestEvent requestEvent) {
        JSONObject jSONObject;
        if (this.mIsMiniGame) {
            return createRequestTaskInMiniGame(requestEvent);
        }
        try {
            synchronized (this) {
                JSONObject jSONObject2 = new JSONObject(requestEvent.jsonParams);
                ((RequestStrategyProxy) ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(jSONObject2);
                boolean optBoolean = jSONObject2.optBoolean("__skipDomainCheck__", false);
                RequestTask requestTask = new RequestTask(requestEvent.jsService, jSONObject2);
                String str = requestTask.mOriginUrl;
                boolean f16 = com.tencent.qqmini.sdk.report.a.f(this.mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, str);
                String str2 = requestTask.mMethod;
                if (str2 != null && !supportMethod.contains(str2.toUpperCase())) {
                    if (!this.mIsMiniGame) {
                        callbackFail(requestEvent, null, "request protocol error");
                    }
                    com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, str, "request protocol error");
                    return ApiUtil.wrapCallbackFail("createRequest", null, "request protocol error").toString();
                }
                if (!TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("http://"))) {
                    if (!DomainUtil.isDomainValid(this.mMiniAppInfo, optBoolean, str, 0)) {
                        String str3 = "\u8bf7\u6c42\u57df\u540d\u672a\u52a0\u767d\u540d\u5355\uff0curl=" + str;
                        if (!this.mIsMiniGame) {
                            callbackFail(requestEvent, null, str3);
                        }
                        com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, str, str3);
                        return ApiUtil.wrapCallbackFail("createRequest", null, str3).toString();
                    }
                    this.requestMap.put(Integer.valueOf(requestTask.mTaskId), requestTask);
                    try {
                        jSONObject = new JSONObject(requestEvent.jsonParams);
                        jSONObject.put("requestTaskId", requestTask.mTaskId);
                    } catch (Throwable th5) {
                        QMLog.e(TAG, "", th5);
                    }
                    if (this.requestMap.size() > 200) {
                        QMLog.d(TAG, "[httpRequest] too much request");
                        if (!this.mIsMiniGame) {
                            callbackFail(requestEvent, jSONObject);
                        }
                        com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, str, "[httpRequest] too much request");
                        return ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject).toString();
                    }
                    RequestProxy requestProxy = (RequestProxy) ProxyManager.get(RequestProxy.class);
                    if (requestProxy == null) {
                        QMLog.d(TAG, "[httpRequest] reqProxy is null");
                        if (!this.mIsMiniGame) {
                            callbackFail(requestEvent, jSONObject);
                        }
                        com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, str, "[httpRequest] reqProxy is null");
                        return ApiUtil.wrapCallbackFail(requestEvent.event, jSONObject).toString();
                    }
                    if (doRequest(requestEvent, requestTask, str, requestProxy, f16)) {
                        if (!this.mIsMiniGame) {
                            callbackOK(requestEvent, jSONObject);
                        }
                        return ApiUtil.wrapCallbackOk(requestEvent.event, jSONObject).toString();
                    }
                    com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, str, "send request failed");
                    return "";
                }
                if (!this.mIsMiniGame) {
                    callbackFail(requestEvent, null, "url is invalid");
                }
                com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, str, "url is invalid");
                return ApiUtil.wrapCallbackFail("createRequest", null, "url is invalid").toString();
            }
        } catch (Throwable th6) {
            String str4 = "event:" + requestEvent.event + " params:" + requestEvent.jsonParams + " error:" + th6;
            QMLog.e(TAG, str4);
            com.tencent.qqmini.sdk.report.a.e(this.mMiniAppInfo, Const.BUNDLE_KEY_REQUEST, "", str4);
            callbackFail(requestEvent, null, str4);
            return "";
        }
    }

    @JsEvent({com.tencent.luggage.wxa.nf.f.NAME})
    public String createSocketTask(RequestEvent requestEvent) {
        try {
            synchronized (this.lock) {
                WebSocketProxy webSocketProxy = (WebSocketProxy) ProxyManager.get(WebSocketProxy.class);
                if (webSocketProxy == null) {
                    QMLog.w(TAG, "not support web socket right now");
                    callbackFail(requestEvent, null, "not support web socket right now");
                    return "";
                }
                JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                ((RequestStrategyProxy) ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo(jSONObject);
                boolean optBoolean = jSONObject.optBoolean("__skipDomainCheck__", false);
                int i3 = this.mApkgInfo.getAppConfigInfo().networkTimeoutInfo.connectSocket;
                WebsocketRequestTask websocketRequestTask = new WebsocketRequestTask(jSONObject, getRequestReferer());
                if (!DomainUtil.isDomainValid(this.mMiniAppInfo, optBoolean, websocketRequestTask.mOriginUrl, 1)) {
                    QMLog.w(TAG, "check socket DomainValid fail, callbackFail, event:" + requestEvent.event + ", callbackId:" + requestEvent.callbackId + ", url:" + websocketRequestTask.mUrl);
                    callbackFail(requestEvent, null, "\u8bf7\u6c42\u57df\u540d\u4e0d\u5408\u6cd5");
                    return "";
                }
                int i16 = websocketRequestTask.mTimeout;
                if (i16 > i3) {
                    i3 = i16;
                }
                connectSocket(requestEvent, webSocketProxy, i3, websocketRequestTask);
                this.wsrequestMap.put(Integer.valueOf(websocketRequestTask.mTaskId), websocketRequestTask);
                JSONObject jSONObject2 = new JSONObject(requestEvent.jsonParams);
                jSONObject2.put("socketTaskId", websocketRequestTask.mTaskId);
                jSONObject2.put("errMsg", requestEvent.event + ":ok");
                callbackOK(requestEvent, jSONObject2);
                return jSONObject2.toString();
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " exception:", th5);
            callbackFail(requestEvent, null);
            try {
                String str = new WebsocketRequestTask(new JSONObject(requestEvent.jsonParams), getRequestReferer()).mUrl;
                MiniAppInfo miniAppInfo = this.mMiniAppInfo;
                MiniReportManager.reportEventType(miniAppInfo, 632, null, null, null, 1, MiniReportManager.getAppType(miniAppInfo), 0L, getSecondLevelDomain(str));
                return "";
            } catch (JSONException e16) {
                QMLog.e(TAG, "handleNativeRequest ", e16);
                return "";
            }
        }
    }

    @JsEvent({"getGroupAppStatus"})
    public String getGroupAppStatus(final RequestEvent requestEvent) {
        IMiniAppContext iMiniAppContext;
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null && (iMiniAppContext = this.mMiniAppContext) != null) {
            channelProxy.getGroupAppStatus(iMiniAppContext, requestEvent.jsonParams, new AsyncResult() { // from class: com.tencent.qqmini.sdk.plugins.RequestJsPlugin.7
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        RequestJsPlugin.this.callbackOK(requestEvent, jSONObject);
                    } else if (jSONObject != null) {
                        RequestJsPlugin.this.callbackFail(requestEvent, jSONObject, null);
                    } else {
                        RequestJsPlugin.this.callbackFail(requestEvent, null, "do not support getGroupAppStatus!");
                    }
                }
            });
            return "";
        }
        callbackFail(requestEvent, null, "do not support wnsGroupRequest");
        return ApiUtil.wrapCallbackFail(requestEvent.event, null, "do not support getGroupAppStatus").toString();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        super.onDestroy();
        this.mMiniAppContext = null;
        WebSocketProxy webSocketProxy = (WebSocketProxy) ProxyManager.get(WebSocketProxy.class);
        if (webSocketProxy != null) {
            webSocketProxy.release();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onRestart() {
        super.onRestart();
        QMLog.d(TAG, "---restartApp---");
        if (this.wsrequestMap.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.wsrequestMap.keySet().iterator();
        while (it.hasNext()) {
            operateSocketClose(new RequestEvent.Builder().setEvent("onRestart mini app").build(), new JSONObject(), it.next().intValue());
        }
    }

    @JsEvent({com.tencent.luggage.wxa.pf.d.NAME})
    public String operateRequestTask(RequestEvent requestEvent) {
        RequestTask remove;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            int optInt = jSONObject.optInt("requestTaskId");
            String optString = jSONObject.optString("operationType");
            if (this.requestMap.containsKey(Integer.valueOf(optInt)) && (remove = this.requestMap.remove(Integer.valueOf(optInt))) != null && "abort".equals(optString)) {
                ((RequestProxy) ProxyManager.get(RequestProxy.class)).abort(remove.mUrl);
                if (!this.mIsMiniGame) {
                    callbackOK(requestEvent, null);
                    return "";
                }
                return "";
            }
            return "";
        } catch (Exception e16) {
            e16.printStackTrace();
            QMLog.e(TAG, "OPERATE_REQUEST_TASK : " + e16);
            return "";
        }
    }

    @JsEvent({i.NAME})
    public String operateSocketTask(RequestEvent requestEvent) {
        String operateSocketSend;
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            String optString = jSONObject.optString("operationType");
            int optInt = jSONObject.optInt("socketTaskId");
            if ("close".equals(optString)) {
                return operateSocketClose(requestEvent, jSONObject, optInt);
            }
            if ("send".equals(optString) && (operateSocketSend = operateSocketSend(requestEvent, jSONObject, optInt)) != null) {
                return operateSocketSend;
            }
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " exception:", th5);
            return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
        }
    }

    @JsEvent(isSync = false, value = {WNS_CGI_REQUEST})
    public String wnsCgiRequest(RequestEvent requestEvent) {
        return startCgiRequest(requestEvent, WNS_CGI_REQUEST);
    }

    @JsEvent({"wnsGroupRequest"})
    public String wnsGroupRequest(RequestEvent requestEvent) {
        LaunchParam launchParam;
        EntryModel entryModel;
        try {
            String optString = new JSONObject(requestEvent.jsonParams).optString("entryDataHash");
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && (entryModel = launchParam.entryModel) != null && optString != null) {
                if (optString.equals(entryModel.getEntryHash()) && this.mMiniAppInfo.launchParam.entryModel.isAdmin) {
                    if (requestEvent.jsonParams.contains("{groupId}")) {
                        if (doWnsCgiRequest(requestEvent)) {
                            return ApiUtil.wrapCallbackFail(requestEvent.event, null, "do not support wnsGroupRequest").toString();
                        }
                        return "";
                    }
                    requestEvent.fail("groupId is null");
                    return "";
                }
                requestEvent.fail("entryDataHash is not vaild or you are not group administrator");
                return "";
            }
            return "";
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " exception:", th5);
            return ApiUtil.wrapCallbackFail(requestEvent.event, null).toString();
        }
    }

    @JsEvent(isSync = false, value = {WNS_GUILD_REQUEST})
    public String wnsGuildRequest(RequestEvent requestEvent) {
        return startCgiRequest(requestEvent, WNS_GUILD_REQUEST);
    }

    @JsEvent({"wnsRequest"})
    public String wnsRequest(final RequestEvent requestEvent) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.RequestJsPlugin.4

            /* renamed from: com.tencent.qqmini.sdk.plugins.RequestJsPlugin$4$a */
            /* loaded from: classes23.dex */
            class a implements AsyncResult {
                a() {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        RequestJsPlugin.this.callbackOK(requestEvent, jSONObject);
                    } else {
                        AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                        RequestJsPlugin.this.callbackFail(requestEvent, null, "do not support wnsRequest");
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
                    JSONObject optJSONObject = jSONObject.optJSONObject("header");
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    optJSONObject.put("Referer", RequestJsPlugin.this.getRequestReferer());
                    ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
                    if (channelProxy == null) {
                        RequestJsPlugin.this.callbackFail(requestEvent, null, "do not support wnsRequest");
                    } else {
                        channelProxy.wnsCgiRequest(jSONObject, new a());
                    }
                } catch (Throwable th5) {
                    QMLog.e(RequestJsPlugin.TAG, requestEvent.event + " exception:", th5);
                }
            }
        });
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackFail(RequestEvent requestEvent, JSONObject jSONObject, String str) {
        callback(requestEvent, jSONObject, "fail", str, null);
    }

    private void callbackOK(RequestEvent requestEvent, JSONObject jSONObject, String str) {
        callback(requestEvent, jSONObject, "ok", null, str);
    }

    private void callbackFail(RequestEvent requestEvent, JSONObject jSONObject, String str, String str2) {
        callback(requestEvent, jSONObject, "fail", str, null);
    }

    @NotNull
    private String operateSocketSend(RequestEvent requestEvent, int i3, String str) {
        synchronized (this.lock) {
            ConcurrentHashMap<Integer, WebsocketRequestTask> concurrentHashMap = this.wsrequestMap;
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                WebsocketRequestTask websocketRequestTask = this.wsrequestMap.get(Integer.valueOf(i3));
                WebSocketProxy webSocketProxy = (WebSocketProxy) ProxyManager.get(WebSocketProxy.class);
                if (websocketRequestTask != null && webSocketProxy != null) {
                    webSocketProxy.send(i3, str);
                    if (this.mIsMiniGame) {
                        callbackOK(requestEvent, null, "sendSocketMessage");
                    }
                    return ApiUtil.wrapCallbackOk(requestEvent.event, null).toString();
                }
                QMLog.e(TAG, requestEvent.event + " error, send msg:" + str + " on null socket instance");
                if (this.mIsMiniGame) {
                    callbackFail(requestEvent, null, "socket is null ", "sendSocketMessage");
                }
                return ApiUtil.wrapCallbackFail(requestEvent.event, null, "socket is null ").toString();
            }
            if (this.mIsMiniGame) {
                callbackFail(requestEvent, null, "do not have this socket ", "closeSocket");
            }
            return ApiUtil.wrapCallbackFail(requestEvent.event, null, "do not have this socket ").toString();
        }
    }
}
