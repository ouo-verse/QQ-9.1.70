package com.tencent.qqmini.minigame;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import org.apache.httpcore.message.TokenParser;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0003$\u000f\u0013B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0018\u00010\u0012R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqmini/minigame/MiniGameChromeInspectAgent;", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "", "message", "", "e", "d", "Lcom/tencent/qqmini/minigame/MiniGameChromeInspectAgent$b;", "listener", "f", "destroy", "sendMessageToDebugger", "Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;", "setOnDebuggerMessageListener", "", "a", "I", "mPort", "Lcom/tencent/qqmini/minigame/MiniGameChromeInspectAgent$AgentServer;", "b", "Lcom/tencent/qqmini/minigame/MiniGameChromeInspectAgent$AgentServer;", "mAgentServer", "Lorg/java_websocket/WebSocket;", "c", "Lorg/java_websocket/WebSocket;", "mWebSocket", "Lcom/tencent/mobileqq/triton/script/InspectorAgent$DebuggerMessageListener;", "mDebuggerMessageListener", "Lcom/tencent/qqmini/minigame/MiniGameChromeInspectAgent$b;", "mDebugAttachListener", "", "Ljava/util/List;", "mDebugPendingMsgList", "<init>", "()V", "g", "AgentServer", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class MiniGameChromeInspectAgent implements InspectorAgent {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AgentServer mAgentServer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WebSocket mWebSocket;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile InspectorAgent.DebuggerMessageListener mDebuggerMessageListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b mDebugAttachListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int mPort = new Random().nextInt(20000);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<String> mDebugPendingMsgList = new LinkedList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqmini/minigame/MiniGameChromeInspectAgent$AgentServer;", "Lorg/java_websocket/server/WebSocketServer;", "Lorg/java_websocket/WebSocket;", "conn", "Lorg/java_websocket/handshake/ClientHandshake;", "handshake", "", "onOpen", "", "code", "", "reason", "", "remote", "onClose", "message", "onMessage", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ex", "onError", "onStart", "d", "I", "mPort", "<init>", "(Lcom/tencent/qqmini/minigame/MiniGameChromeInspectAgent;I)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public final class AgentServer extends WebSocketServer {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int mPort;

        public AgentServer(int i3) {
            super(new InetSocketAddress(i3));
            this.mPort = i3;
            setConnectionLostTimeout(Integer.MAX_VALUE);
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onClose(@NotNull WebSocket conn, int code, @NotNull String reason, boolean remote) {
            Intrinsics.checkParameterIsNotNull(conn, "conn");
            Intrinsics.checkParameterIsNotNull(reason, "reason");
            QMLog.w("MiniGameChromeInspectAgent", "Debugger disconnected " + reason + TokenParser.SP + conn);
            conn.close();
            MiniGameChromeInspectAgent.this.mWebSocket = null;
            b bVar = MiniGameChromeInspectAgent.this.mDebugAttachListener;
            if (bVar != null) {
                bVar.onDisconnected();
            }
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onError(@NotNull WebSocket conn, @NotNull Exception ex5) {
            Intrinsics.checkParameterIsNotNull(conn, "conn");
            Intrinsics.checkParameterIsNotNull(ex5, "ex");
            QMLog.w("MiniGameChromeInspectAgent", "ScriptEngine Inspector Debugger server failed", ex5);
            MiniGameChromeInspectAgent.this.mWebSocket = null;
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onMessage(@NotNull WebSocket conn, @NotNull String message) {
            Intrinsics.checkParameterIsNotNull(conn, "conn");
            Intrinsics.checkParameterIsNotNull(message, "message");
            MiniGameChromeInspectAgent.this.e(message);
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onOpen(@NotNull WebSocket conn, @NotNull ClientHandshake handshake) {
            Intrinsics.checkParameterIsNotNull(conn, "conn");
            Intrinsics.checkParameterIsNotNull(handshake, "handshake");
            QMLog.w("MiniGameChromeInspectAgent", "Debugger connected " + conn);
            MiniGameChromeInspectAgent.this.mWebSocket = conn;
            b bVar = MiniGameChromeInspectAgent.this.mDebugAttachListener;
            if (bVar != null) {
                bVar.onConnected();
            }
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onStart() {
            String trimMargin$default;
            trimMargin$default = StringsKt__IndentKt.trimMargin$default("\n                   ChromeInspector \u8c03\u8bd5\u542f\u52a8\u6210\u529f\uff0c\u4f7f\u7528\u7aef\u53e3\u53f7\u4e3a: " + this.mPort + "\n                   \n                   \u6309\u7167\u4ee5\u4e0b\u6b65\u9aa4\u5f00\u59cb\u8c03\u8bd5:\n                   1. \u547d\u4ee4\u884c\u6267\u884c: adb forward tcp:" + this.mPort + " tcp:" + this.mPort + "\n                   2. \u4f7f\u7528 chrome \u6253\u5f00\u4ee5\u4e0b\u94fe\u63a5: devtools://devtools/bundled/js_app.html?ws=127.0.0.1:" + this.mPort + "\n                   \n                   \u6ce8\u610f:\n                   chrome \u65ad\u5f00\u91cd\u8fde\u6216\u5237\u65b0\u65f6\uff0c\u8c03\u8bd5\u5668\u4e2d\u5df2\u52a0\u8f7d\u8fc7\u7684\u4ee3\u7801\u6587\u4ef6\u4e0d\u4f1a\u518d\u6b21\u663e\u793a\u3002\u5982\u679c\u9700\u8981\u5bf9\u4ee3\u7801\u8fdb\u884c\u65ad\u70b9\u8c03\u8bd5\uff0c\u5efa\u8bae\u6740\u6389\u6e38\u620f\u91cd\u542f\u3002\n                ", null, 1, null);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\n********** Chrome Inspector **********\n");
            sb5.append(trimMargin$default);
            QMLog.i("MiniGameChromeInspectAgent", sb5.toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqmini/minigame/MiniGameChromeInspectAgent$b;", "", "", "onConnected", "onDisconnected", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public interface b {
        void onConnected();

        void onDisconnected();
    }

    private final String d(@NotNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("method");
            Intrinsics.checkExpressionValueIsNotNull(string, "msgObj.getString(\"method\")");
            if (TextUtils.equals(string, "Runtime.evaluate") || TextUtils.equals(string, "Debugger.evaluateOnCallFrame")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "msgObj.getJSONObject(\"params\")");
                jSONObject2.remove("timeout");
                jSONObject.put("params", jSONObject2);
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "msgObj.toString()");
            return jSONObject3;
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(String message) {
        synchronized (this) {
            if (this.mDebuggerMessageListener != null) {
                InspectorAgent.DebuggerMessageListener debuggerMessageListener = this.mDebuggerMessageListener;
                if (debuggerMessageListener == null) {
                    Intrinsics.throwNpe();
                }
                debuggerMessageListener.sendMessageToEngine(d(message));
                Unit unit = Unit.INSTANCE;
            } else {
                this.mDebugPendingMsgList.add(message);
            }
        }
    }

    @Override // com.tencent.mobileqq.triton.script.InspectorAgent
    public void destroy() {
        try {
            AgentServer agentServer = this.mAgentServer;
            if (agentServer != null) {
                agentServer.stop();
            }
        } catch (Exception e16) {
            QMLog.e("MiniGameChromeInspectAgent", "destroy", e16);
        }
    }

    public final void f(@Nullable b listener) {
        AgentServer agentServer = new AgentServer(this.mPort);
        this.mAgentServer = agentServer;
        agentServer.start();
        this.mDebugAttachListener = listener;
    }

    @Override // com.tencent.mobileqq.triton.script.InspectorAgent
    public void sendMessageToDebugger(@NotNull String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        WebSocket webSocket = this.mWebSocket;
        if (webSocket != null) {
            webSocket.send(message);
        }
    }

    @Override // com.tencent.mobileqq.triton.script.InspectorAgent
    public void setOnDebuggerMessageListener(@Nullable InspectorAgent.DebuggerMessageListener listener) {
        synchronized (this) {
            this.mDebuggerMessageListener = listener;
            if (listener != null) {
                Iterator<String> it = this.mDebugPendingMsgList.iterator();
                while (it.hasNext()) {
                    listener.sendMessageToEngine(d(it.next()));
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
