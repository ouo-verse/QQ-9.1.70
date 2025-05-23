package com.tencent.crossengine.debugJs;

import com.tencent.crossengine.debugJs.a;
import java.net.InetSocketAddress;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WebSocketServerInspectAgent implements a {

    /* renamed from: a, reason: collision with root package name */
    private final int f100473a;

    /* renamed from: b, reason: collision with root package name */
    private final AgentServer f100474b;

    /* renamed from: c, reason: collision with root package name */
    private WebSocket f100475c;

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC1022a f100476d;

    /* renamed from: e, reason: collision with root package name */
    private String f100477e;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class AgentServer extends WebSocketServer {

        /* renamed from: d, reason: collision with root package name */
        private final int f100478d;

        AgentServer(int i3) {
            super(new InetSocketAddress(i3));
            this.f100478d = i3;
            setConnectionLostTimeout(Integer.MAX_VALUE);
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onClose(WebSocket webSocket, int i3, String str, boolean z16) {
            com.tencent.crossengine.log.a.k("AgentServer", "Debugger disconnected " + str + " " + webSocket);
            WebSocketServerInspectAgent.this.f100475c = null;
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onError(WebSocket webSocket, Exception exc) {
            WebSocketServerInspectAgent.this.f100475c = null;
            com.tencent.crossengine.log.a.l("AgentServer", "ScriptEngine Inspector Debugger server failed", exc);
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onMessage(WebSocket webSocket, String str) {
            if (WebSocketServerInspectAgent.this.f100476d != null) {
                WebSocketServerInspectAgent.this.f100476d.sendMessageToEngine(str);
                com.tencent.crossengine.log.a.g("AgentServer", "<< " + str);
            }
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
            WebSocketServerInspectAgent.this.f100475c = webSocket;
            com.tencent.crossengine.log.a.k("AgentServer", "Debugger connected " + webSocket);
        }

        @Override // org.java_websocket.server.WebSocketServer
        public void onStart() {
            com.tencent.crossengine.log.a.g("AgentServer", "World " + WebSocketServerInspectAgent.this.f100477e + " ScriptEngine Inspector Debugger server successfully started on port:" + this.f100478d + "\nfollow the steps to start debug:\n1. adb forward tcp:" + this.f100478d + " tcp:" + this.f100478d + "\n2. open chrome with url to start inspect\ndevtools://devtools/bundled/js_app.html?ws=localhost:" + this.f100478d + "\nREADME: https://docs.qq.com/doc/DZmtmYUdMdXZ2a3lm");
        }
    }

    public WebSocketServerInspectAgent(String str) {
        int random = (int) (Math.random() * 10000.0d);
        this.f100473a = random;
        this.f100477e = str;
        AgentServer agentServer = new AgentServer(random);
        this.f100474b = agentServer;
        agentServer.start();
    }

    @Override // com.tencent.crossengine.debugJs.a
    public void a(a.InterfaceC1022a interfaceC1022a) {
        this.f100476d = interfaceC1022a;
    }
}
