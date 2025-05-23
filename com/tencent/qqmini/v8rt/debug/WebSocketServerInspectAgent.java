package com.tencent.qqmini.v8rt.debug;

import com.tencent.qqmini.v8rt.anno.NotNull;
import com.tencent.qqmini.v8rt.anno.Nullable;
import com.tencent.qqmini.v8rt.engine.IInspectorAgent;
import com.tencent.qqmini.v8rt.engine.Logger;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Random;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WebSocketServerInspectAgent implements IInspectorAgent {
    private static final boolean DEBUG = true;
    private static final String TAG = "WebSocketServerInspectAgent";
    private final AgentServer mAgentServer;
    private IInspectorAgent.IDebuggerMessageListener mDebuggerMessageListener;
    private boolean mWaitForDebugger;
    private WebSocket mWebSocket;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private class AgentServer extends WebSocketServer {
        private final int mPort;

        AgentServer(int i3) {
            super(new InetSocketAddress(i3));
            setReuseAddr(true);
            this.mPort = i3;
            setConnectionLostTimeout(Integer.MAX_VALUE);
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onClose(WebSocket webSocket, int i3, String str, boolean z16) {
            Logger.w(WebSocketServerInspectAgent.TAG, "Debugger disconnected " + str + " " + webSocket);
            WebSocketServerInspectAgent.this.mWebSocket = null;
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onError(WebSocket webSocket, Exception exc) {
            WebSocketServerInspectAgent.this.mWebSocket = null;
            Logger.w(WebSocketServerInspectAgent.TAG, "ScriptEngine Inspector Debugger server failed", exc);
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onMessage(WebSocket webSocket, String str) {
            if (WebSocketServerInspectAgent.this.mDebuggerMessageListener != null) {
                WebSocketServerInspectAgent.this.mDebuggerMessageListener.sendMessageToEngine(str);
                Logger.i(WebSocketServerInspectAgent.TAG, "<< " + str);
            }
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
            WebSocketServerInspectAgent.this.mWebSocket = webSocket;
            Logger.w(WebSocketServerInspectAgent.TAG, "Debugger connected " + webSocket);
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onStart() {
            Logger.i(WebSocketServerInspectAgent.TAG, "ScriptEngine Inspector Debugger server successfully started on port:" + this.mPort + "\nfollow the steps to start debug:\n1. adb forward tcp:" + this.mPort + " tcp:" + this.mPort + "\n2. open chrome with url to start inspect\ndevtools://devtools/bundled/js_app.html?ws=localhost:" + this.mPort);
        }
    }

    public WebSocketServerInspectAgent(boolean z16) {
        this.mWaitForDebugger = false;
        AgentServer agentServer = new AgentServer(getServerPort());
        this.mAgentServer = agentServer;
        agentServer.start();
        this.mWaitForDebugger = z16;
    }

    private int getServerPort() {
        return new Random().nextInt(9999);
    }

    @Override // com.tencent.qqmini.v8rt.engine.IInspectorAgent
    public boolean isWaitForDebugger() {
        return this.mWaitForDebugger;
    }

    @Override // com.tencent.qqmini.v8rt.engine.IInspectorAgent
    public void sendMessageToDebugger(@NotNull String str) {
        WebSocket webSocket = this.mWebSocket;
        if (webSocket != null) {
            webSocket.send(str);
            Logger.i(TAG, ">> " + str);
        }
    }

    @Override // com.tencent.qqmini.v8rt.engine.IInspectorAgent
    public void setOnDebuggerMessageListener(@Nullable IInspectorAgent.IDebuggerMessageListener iDebuggerMessageListener) {
        this.mDebuggerMessageListener = iDebuggerMessageListener;
    }

    @Override // com.tencent.qqmini.v8rt.engine.IInspectorAgent
    public void stop() {
        try {
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                webSocket.close();
            }
            this.mAgentServer.stop();
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (InterruptedException e17) {
            e17.printStackTrace();
        }
    }
}
