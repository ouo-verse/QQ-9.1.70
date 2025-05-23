package com.tencent.qqmini.minigame.debug;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.qqmini.miniapp.util.DebugUtils;
import com.tencent.qqmini.minigame.GameConst;
import com.tencent.qqmini.minigame.debug.DebugWebSocket;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class QQDebugWebSocket extends DebugWebSocket implements InspectorAgent {
    private static final String DISCONNECT_TIPS = "\u771f\u673a\u8c03\u8bd5\u65ad\u5f00\u8fde\u63a5";
    private static final String DISCONNECT_TIPS_NOT_RECOVERY = "\u771f\u673a\u8c03\u8bd5\u65ad\u5f00\u8fde\u63a5\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5";
    private static final String RECONNECT_TIPS = "\u771f\u673a\u8c03\u8bd5\u65ad\u7ebf\u91cd\u8fde...";
    private MiniAppInfo gameInfo;
    private DebugWebSocket.DebuggerStateListener mDebugListener;
    private InspectorAgent.DebuggerMessageListener mDebuggerMessageListener;
    private IMiniAppContext miniAppContext;
    private String sessionId;
    private AtomicInteger count = new AtomicInteger();
    private DebugWebSocket.DebugSocketListener qqSocketListener = new DebugWebSocket.DebugSocketListener() { // from class: com.tencent.qqmini.minigame.debug.QQDebugWebSocket.1
        @Override // com.tencent.qqmini.minigame.debug.DebugWebSocket.DebugSocketListener
        public void onSocketClose(DebugWebSocket debugWebSocket, int i3) {
            QMLog.e(DebugWebSocket.TAG, "qq onSocketClose:" + i3);
            QQDebugWebSocket.this.onQQDebuggerFail(i3);
        }

        @Override // com.tencent.qqmini.minigame.debug.DebugWebSocket.DebugSocketListener
        public void onSocketFailure(DebugWebSocket debugWebSocket, int i3) {
            QMLog.e(DebugWebSocket.TAG, "qq onSocketFailure:" + i3);
            QQDebugWebSocket.this.onQQDebuggerFail(i3);
        }

        @Override // com.tencent.qqmini.minigame.debug.DebugWebSocket.DebugSocketListener
        public void onSocketMessage(DebugWebSocket debugWebSocket, String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    QQDebugWebSocket.this.dealWithQQMessage(jSONObject.getString("cmd"), jSONObject.getString("data"));
                } catch (JSONException e16) {
                    QMLog.e(DebugWebSocket.TAG, "qq onSocketMessage:", e16);
                }
            }
        }

        @Override // com.tencent.qqmini.minigame.debug.DebugWebSocket.DebugSocketListener
        public void onSocketOpened(DebugWebSocket debugWebSocket) {
            QMLog.i(DebugWebSocket.TAG, "qq onSocketOpened");
        }
    };
    private boolean isQQDebugReady = false;
    Runnable heartbeatRunnable = new Runnable() { // from class: com.tencent.qqmini.minigame.debug.QQDebugWebSocket.4
        @Override // java.lang.Runnable
        public void run() {
            QQDebugWebSocket.this.sendHeartBeat();
        }
    };

    public QQDebugWebSocket(IMiniAppContext iMiniAppContext, MiniAppInfo miniAppInfo) {
        this.miniAppContext = iMiniAppContext;
        this.gameInfo = miniAppInfo;
        DebugWebSocket.TAG = "[debugger].QQDebugWebSocket";
    }

    private String covertProfileToIdeData(String str) {
        return "{\"debug_message\":[{\"seq\":1,\"category\":\"performance\",\"data\":" + str + "}]}";
    }

    private String covertV8ToIdeData(String str) {
        return "{\"debug_message\":[{\"seq\":1,\"category\":\"chromeDevtools\",\"data\":" + str + "}]}";
    }

    private void dealDebugMessageMaster(String str, String str2) {
        try {
            QMLog.i(DebugWebSocket.TAG, "qq onSocketMessage cmd:" + str + ",data:" + str2);
            JSONArray jSONArray = new JSONObject(str2).getJSONArray(DebugUtils.JSONObject.DEBUG_MESSAGE);
            if (jSONArray != null && jSONArray.getJSONObject(0) != null) {
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                if (jSONObject == null) {
                    return;
                }
                String string = jSONObject.getString("category");
                if (TextUtils.equals(string, DebugUtils.Command.CHROME_DEVTOOLS)) {
                    doChromeDevTools(jSONObject);
                } else if (TextUtils.equals(string, ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE)) {
                    doPerformance(jSONObject);
                }
            }
        } catch (JSONException e16) {
            QMLog.e(DebugWebSocket.TAG, "qq onSocketMessage", e16);
        }
    }

    private void dealDebugPing(String str) {
        try {
            String string = new JSONObject(str).getString("ping_id");
            int activeNetworkType = NetworkUtil.getActiveNetworkType(this.miniAppContext.getContext());
            if (!this.isQQDebugReady) {
                sendQQDebugMethodMsg(DebugUtils.Body.DEBUG_PONG, "{\"ping_id\":" + string + ",\"network_type\":" + activeNetworkType + "}");
                this.isQQDebugReady = true;
                notifyIdeSetUp();
                checkDebuggerReady();
            }
        } catch (JSONException e16) {
            QMLog.e(DebugWebSocket.TAG, "qq onSocketMessage", e16);
        }
    }

    private void dealSocketMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.sessionId = jSONObject.getString("sessionId");
            if (TextUtils.equals(jSONObject.getString("code"), "0002")) {
                setCanSendMsg(true);
            }
        } catch (JSONException e16) {
            QMLog.e(DebugWebSocket.TAG, "qq onSocketMessage", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealWithQQMessage(String str, String str2) {
        if (TextUtils.equals(str, DebugUtils.Body.DEBUG_SOCKET_MESSAGE)) {
            dealSocketMessage(str2);
        }
        if (TextUtils.equals(str, DebugUtils.Body.DEBUG_ARK_MASTER)) {
            return;
        }
        if (TextUtils.equals(str, DebugUtils.Body.DEBUG_PING)) {
            dealDebugPing(str2);
            return;
        }
        if (TextUtils.equals(str, DebugUtils.Body.DEBUG_MESSAGE_MASTER)) {
            dealDebugMessageMaster(str, str2);
            return;
        }
        QMLog.i(DebugWebSocket.TAG, "qq onSocketMessage cmd:" + str + ",data:" + str2);
    }

    private void doChromeDevTools(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        String string = jSONObject.getString("data");
        if (!TextUtils.isEmpty(string)) {
            JSONObject jSONObject3 = new JSONObject(string);
            String string2 = jSONObject3.getString("method");
            if ((TextUtils.equals(string2, "Runtime.evaluate") || TextUtils.equals(string2, "Debugger.evaluateOnCallFrame")) && (jSONObject2 = jSONObject3.getJSONObject("params")) != null) {
                jSONObject2.remove("timeout");
                jSONObject3.put("params", jSONObject2);
            }
            this.mDebuggerMessageListener.sendMessageToEngine(jSONObject3.toString());
        }
    }

    private void doPerformance(@NonNull JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("data");
        if (!TextUtils.isEmpty(string)) {
            JSONObject jSONObject2 = new JSONObject(string);
            String string2 = jSONObject2.getString("method");
            int i3 = jSONObject2.getInt("id");
            if (TextUtils.equals(string2, "profile.start")) {
                AppStateEvent.obtain(GameConst.GAME_RUNTIME_MSG_PROFILE_START, Integer.valueOf(i3)).notifyRuntime(this.miniAppContext);
            } else if (TextUtils.equals(string2, "profile.end")) {
                AppStateEvent.obtain(GameConst.GAME_RUNTIME_MSG_PROFILE_END, Integer.valueOf(i3)).notifyRuntime(this.miniAppContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getAccount() {
        try {
            return Long.parseLong(LoginManager.getInstance().getAccount());
        } catch (Exception unused) {
            return 0L;
        }
    }

    private String getAppVersion() {
        return ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion();
    }

    private JSONObject getDeviceInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("device_name", Build.DEVICE);
            jSONObject.put("device_model", DeviceInfoUtil.getPhoneModel());
            jSONObject.put("os", Build.VERSION.SDK_INT);
            jSONObject.put(AppConstants.Preferences.QQ_VERSION, getAppVersion());
            jSONObject.put("pixel_ratio", "3");
            jSONObject.put("screen_width", ViewUtils.getScreenWidth());
            jSONObject.put("user_agent", "MiniGame");
            return jSONObject;
        } catch (Exception e16) {
            Log.e(DebugWebSocket.TAG, "getSetupContexString error:" + e16);
            return null;
        }
    }

    private JSONObject getSetupContexData() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("configure_js", "");
            jSONObject.put("device_info", getDeviceInfo());
            jSONObject.put("support_compress_algo", 0);
            return jSONObject;
        } catch (Exception e16) {
            Log.e(DebugWebSocket.TAG, "getSetupContexString error:" + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQQDebuggerFail(int i3) {
        setCanSendMsg(false);
        if (i3 == 1000) {
            DebugWebSocket.DebuggerStateListener debuggerStateListener = this.mDebugListener;
            if (debuggerStateListener != null) {
                debuggerStateListener.onDebuggerDisconnect(DISCONNECT_TIPS);
                return;
            }
            return;
        }
        DebugWebSocket.DebuggerStateListener debuggerStateListener2 = this.mDebugListener;
        if (debuggerStateListener2 != null) {
            debuggerStateListener2.onDebuggerReconnecting(RECONNECT_TIPS);
        }
        reconnectQQDebugSocket();
    }

    private void reconnectQQDebugSocket() {
        postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.debug.QQDebugWebSocket.2
            @Override // java.lang.Runnable
            public void run() {
                QQDebugWebSocket qQDebugWebSocket = QQDebugWebSocket.this;
                qQDebugWebSocket.startConnectIDE(qQDebugWebSocket.mDebugListener, true);
            }
        }, 2000L);
    }

    private void sendQQDeviceMsgInfo() {
        String sendCmdString = getSendCmdString(DebugUtils.Body.DEBUG_MESSAGE_CLIENT, DebugUtils.Command.SETUP_CONTEXT, getSetupContexData());
        QMLog.i(DebugWebSocket.TAG, "sendQQDeviceMsgInfo deviceInfoCmd:" + sendCmdString);
        sendStringMessage(sendCmdString);
    }

    public void checkDebuggerReady() {
        if (this.isQQDebugReady) {
            DebugWebSocket.DebuggerStateListener debuggerStateListener = this.mDebugListener;
            if (debuggerStateListener != null) {
                debuggerStateListener.onDebuggerConnectedNormal();
            }
            sendHeartBeat();
        }
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
            Log.e(DebugWebSocket.TAG, "send Cmd error:" + e16);
            return "";
        }
    }

    public int getSeq() {
        return this.count.incrementAndGet();
    }

    public void notifyIdeSetUp() {
        sendQQDebugMethodMsg(DebugUtils.Body.DEBUG_MESSAGE_CLIENT, "{\"debug_message\":[{}]}");
        sendQQDeviceMsgInfo();
    }

    public void sendHeartBeat() {
        sendQQDebugMethodMsg("HeartBeat", "{}");
        postDelayed(this.heartbeatRunnable, 10000L);
    }

    @Override // com.tencent.mobileqq.triton.script.InspectorAgent
    public void sendMessageToDebugger(@NonNull String str) {
        QMLog.i(DebugWebSocket.TAG, "v8 onSocketMessage:" + str);
        DebugWebSocket.DebuggerStateListener debuggerStateListener = this.mDebugListener;
        if (debuggerStateListener != null && !TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("method");
                if (!TextUtils.isEmpty(optString)) {
                    if (TextUtils.equals(optString, "Debugger.paused")) {
                        debuggerStateListener.onDebuggerBreakPointPaused();
                    } else if (TextUtils.equals(optString, "Debugger.resumed")) {
                        debuggerStateListener.onDebuggerConnectedNormal();
                    }
                }
            } catch (JSONException e16) {
                QMLog.e(DebugWebSocket.TAG, "v8 onSocketMessage error", e16);
            }
        }
        sendQQDebugMethodMsg(DebugUtils.Body.DEBUG_MESSAGE_CLIENT, covertV8ToIdeData(str));
    }

    public void sendQQDebugMethodMsg(String str, String str2) {
        sendStringMessage("{\"cmd\":\"" + str + "\",\"data\":" + str2 + "}");
    }

    public void sendQuitDebugMsgInfo() {
        sendQQDebugMethodMsg("QuitRoom", "{}");
    }

    @Override // com.tencent.mobileqq.triton.script.InspectorAgent
    public void setOnDebuggerMessageListener(@Nullable InspectorAgent.DebuggerMessageListener debuggerMessageListener) {
        this.mDebuggerMessageListener = debuggerMessageListener;
    }

    public void startConnectIDE(DebugWebSocket.DebuggerStateListener debuggerStateListener) {
        startConnectIDE(debuggerStateListener, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConnectIDE(final DebugWebSocket.DebuggerStateListener debuggerStateListener, final boolean z16) {
        post(new Runnable() { // from class: com.tencent.qqmini.minigame.debug.QQDebugWebSocket.3
            @Override // java.lang.Runnable
            public void run() {
                DebugInfo debugInfo;
                String str;
                MiniAppInfo miniAppInfo = QQDebugWebSocket.this.gameInfo;
                if (miniAppInfo != null && (debugInfo = miniAppInfo.debugInfo) != null && debugInfo.valid()) {
                    QQDebugWebSocket.this.mDebugListener = debuggerStateListener;
                    long account = QQDebugWebSocket.this.getAccount();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(miniAppInfo.debugInfo.wsUrl);
                    sb5.append("?roomId=");
                    String str2 = "";
                    if (QQDebugWebSocket.this.gameInfo == null || QQDebugWebSocket.this.gameInfo.debugInfo == null) {
                        str = "";
                    } else {
                        str = QQDebugWebSocket.this.gameInfo.debugInfo.roomId;
                    }
                    sb5.append(str);
                    sb5.append("&appId=");
                    if (QQDebugWebSocket.this.gameInfo != null) {
                        str2 = QQDebugWebSocket.this.gameInfo.appId;
                    }
                    sb5.append(str2);
                    sb5.append("&uin=");
                    sb5.append(account);
                    String sb6 = sb5.toString();
                    if (z16) {
                        sb6 = sb6 + "&sessionId=" + QQDebugWebSocket.this.sessionId;
                    }
                    QQDebugWebSocket.this.isQQDebugReady = false;
                    QMLog.i(DebugWebSocket.TAG, "qq startConnectIDE " + sb6);
                    QQDebugWebSocket qQDebugWebSocket = QQDebugWebSocket.this;
                    qQDebugWebSocket.connect(sb6, qQDebugWebSocket.qqSocketListener);
                }
            }
        });
    }
}
