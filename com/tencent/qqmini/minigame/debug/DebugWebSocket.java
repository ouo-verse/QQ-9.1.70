package com.tencent.qqmini.minigame.debug;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DebugWebSocket {
    protected static String TAG = "[debugger].DebugWebSocket";
    private static final int maxMessageCount = 64;
    protected static Handler sDebuggerHandler;
    protected static HandlerThread sDebuggerHandlerThread;
    protected static Handler sHandler;
    protected static HandlerThread sHandlerThread;
    private int currentWebSocketId;
    protected DebugSocketListener mOutListener;
    private boolean canSendMsg = false;
    private ArrayList<String> sendingMessages = new ArrayList<>();
    private WebSocketProxy webSocketProxy = (WebSocketProxy) ProxyManager.get(WebSocketProxy.class);
    private WebSocketProxy.WebSocketListener listener = new WebSocketProxy.WebSocketListener() { // from class: com.tencent.qqmini.minigame.debug.DebugWebSocket.1
        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
        public void onClose(int i3, int i16, String str) {
            DebugWebSocket debugWebSocket = DebugWebSocket.this;
            DebugSocketListener debugSocketListener = debugWebSocket.mOutListener;
            if (debugSocketListener != null) {
                debugSocketListener.onSocketClose(debugWebSocket, i16);
            }
            QMLog.e(DebugWebSocket.TAG, "---onClose---code: " + i16 + ",reason:" + str);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
        public void onError(int i3, int i16, String str) {
            QMLog.e(DebugWebSocket.TAG, "onFailure " + str);
            DebugWebSocket debugWebSocket = DebugWebSocket.this;
            DebugSocketListener debugSocketListener = debugWebSocket.mOutListener;
            if (debugSocketListener != null) {
                debugSocketListener.onSocketFailure(debugWebSocket, i16);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
        public void onMessage(int i3, byte[] bArr) {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
        public void onOpen(int i3, int i16, Map<String, List<String>> map) {
            DebugWebSocket debugWebSocket = DebugWebSocket.this;
            DebugSocketListener debugSocketListener = debugWebSocket.mOutListener;
            if (debugSocketListener != null) {
                debugSocketListener.onSocketOpened(debugWebSocket);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener
        public void onMessage(int i3, String str) {
            DebugWebSocket debugWebSocket = DebugWebSocket.this;
            DebugSocketListener debugSocketListener = debugWebSocket.mOutListener;
            if (debugSocketListener != null) {
                debugSocketListener.onSocketMessage(debugWebSocket, str);
            }
        }
    };
    private Runnable socketMsgRunnable = new Runnable() { // from class: com.tencent.qqmini.minigame.debug.DebugWebSocket.3
        @Override // java.lang.Runnable
        public void run() {
            DebugWebSocket.this.excuteSocketMsg();
        }
    };

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface DebugSocketListener {
        void onSocketClose(DebugWebSocket debugWebSocket, int i3);

        void onSocketFailure(DebugWebSocket debugWebSocket, int i3);

        void onSocketMessage(DebugWebSocket debugWebSocket, String str);

        void onSocketOpened(DebugWebSocket debugWebSocket);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface DebuggerStateListener {
        void onDebuggerBreakPointPaused();

        void onDebuggerConnectedNormal();

        void onDebuggerDisconnect(String str);

        void onDebuggerReconnecting(String str);
    }

    private Handler getDebugHandler() {
        if (sDebuggerHandler == null || !sDebuggerHandlerThread.isAlive()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("minigame_debugger", 10);
            sDebuggerHandlerThread = baseHandlerThread;
            baseHandlerThread.start();
            sDebuggerHandler = new Handler(sDebuggerHandlerThread.getLooper());
        }
        return sDebuggerHandler;
    }

    private Handler getSocketHandler() {
        if (sHandler == null || !sHandlerThread.isAlive()) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("minigame_socket", 10);
            sHandlerThread = baseHandlerThread;
            baseHandlerThread.start();
            sHandler = new Handler(sHandlerThread.getLooper());
        }
        return sHandler;
    }

    public void closeWebSocket(int i3, String str) {
        this.webSocketProxy.closeSocket(999, i3, str);
    }

    public void connect(String str, DebugSocketListener debugSocketListener) {
        int webSocketRequestId = WebSocketProxy.getWebSocketRequestId();
        this.currentWebSocketId = webSocketRequestId;
        this.webSocketProxy.connectSocket(webSocketRequestId, str, null, null, 120000, this.listener);
        this.mOutListener = debugSocketListener;
    }

    protected void excuteSocketMsg() {
        if (this.sendingMessages.size() > 0) {
            Iterator<String> it = this.sendingMessages.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (this.canSendMsg) {
                    try {
                        this.webSocketProxy.send(this.currentWebSocketId, next);
                        it.remove();
                    } catch (Exception e16) {
                        QMLog.e(TAG, "sendStringMessage", e16);
                        handleSocketException(e16);
                    }
                } else {
                    Handler socketHandler = getSocketHandler();
                    if (socketHandler != null) {
                        socketHandler.removeCallbacks(this.socketMsgRunnable);
                        socketHandler.postDelayed(this.socketMsgRunnable, 1000L);
                    }
                }
            }
        }
    }

    public boolean isCanSendMsg() {
        return this.canSendMsg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void post(Runnable runnable) {
        Handler debugHandler = getDebugHandler();
        if (debugHandler != null) {
            debugHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postDelayed(Runnable runnable, long j3) {
        Handler debugHandler = getDebugHandler();
        if (debugHandler != null) {
            debugHandler.postDelayed(runnable, j3);
        }
    }

    protected void removeCallbacks(Runnable runnable) {
        Handler debugHandler = getDebugHandler();
        if (debugHandler != null) {
            debugHandler.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendStringMessage(final String str) {
        Handler socketHandler;
        if (!TextUtils.isEmpty(str) && (socketHandler = getSocketHandler()) != null) {
            socketHandler.post(new Runnable() { // from class: com.tencent.qqmini.minigame.debug.DebugWebSocket.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DebugWebSocket.this.sendingMessages.size() < 64) {
                        DebugWebSocket.this.sendingMessages.add(str);
                    }
                    DebugWebSocket.this.excuteSocketMsg();
                }
            });
        }
    }

    public void setCanSendMsg(boolean z16) {
        this.canSendMsg = z16;
    }

    public void destroy() {
    }

    protected void handleSocketException(Exception exc) {
    }
}
