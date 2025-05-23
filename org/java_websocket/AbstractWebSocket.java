package org.java_websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class AbstractWebSocket extends WebSocketAdapter {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) AbstractWebSocket.class);
    private Timer connectionLostTimer;
    private TimerTask connectionLostTimerTask;
    private boolean reuseAddr;
    private boolean tcpNoDelay;
    private int connectionLostTimeout = 60;
    private boolean websocketRunning = false;
    private final Object syncConnectionLost = new Object();

    private void cancelConnectionLostTimer() {
        Timer timer = this.connectionLostTimer;
        if (timer != null) {
            timer.cancel();
            this.connectionLostTimer = null;
        }
        TimerTask timerTask = this.connectionLostTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.connectionLostTimerTask = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeConnectionLostDetection(WebSocket webSocket, long j3) {
        if (webSocket instanceof WebSocketImpl) {
            WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
            if (webSocketImpl.getLastPong() < j3) {
                log.trace("Closing connection due to no pong received: {}", webSocketImpl);
                webSocketImpl.closeConnection(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
            } else if (webSocketImpl.isOpen()) {
                webSocketImpl.sendPing();
            } else {
                log.trace("Trying to ping a non open connection: {}", webSocketImpl);
            }
        }
    }

    private void restartConnectionLostTimer() {
        cancelConnectionLostTimer();
        this.connectionLostTimer = new Timer("WebSocketTimer");
        TimerTask timerTask = new TimerTask() { // from class: org.java_websocket.AbstractWebSocket.1
            private ArrayList<WebSocket> connections = new ArrayList<>();

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.connections.clear();
                try {
                    this.connections.addAll(AbstractWebSocket.this.getConnections());
                    long currentTimeMillis = System.currentTimeMillis() - (AbstractWebSocket.this.connectionLostTimeout * 1500);
                    Iterator<WebSocket> it = this.connections.iterator();
                    while (it.hasNext()) {
                        AbstractWebSocket.this.executeConnectionLostDetection(it.next(), currentTimeMillis);
                    }
                } catch (Exception unused) {
                }
                this.connections.clear();
            }
        };
        this.connectionLostTimerTask = timerTask;
        Timer timer = this.connectionLostTimer;
        int i3 = this.connectionLostTimeout;
        timer.scheduleAtFixedRate(timerTask, i3 * 1000, 1000 * i3);
    }

    public int getConnectionLostTimeout() {
        int i3;
        synchronized (this.syncConnectionLost) {
            i3 = this.connectionLostTimeout;
        }
        return i3;
    }

    protected abstract Collection<WebSocket> getConnections();

    public boolean isReuseAddr() {
        return this.reuseAddr;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public void setConnectionLostTimeout(int i3) {
        synchronized (this.syncConnectionLost) {
            this.connectionLostTimeout = i3;
            if (i3 <= 0) {
                log.trace("Connection lost timer stopped");
                cancelConnectionLostTimer();
                return;
            }
            if (this.websocketRunning) {
                log.trace("Connection lost timer restarted");
                try {
                    Iterator it = new ArrayList(getConnections()).iterator();
                    while (it.hasNext()) {
                        WebSocket webSocket = (WebSocket) it.next();
                        if (webSocket instanceof WebSocketImpl) {
                            ((WebSocketImpl) webSocket).updateLastPong();
                        }
                    }
                } catch (Exception e16) {
                    log.error("Exception during connection lost restart", (Throwable) e16);
                }
                restartConnectionLostTimer();
            }
        }
    }

    public void setReuseAddr(boolean z16) {
        this.reuseAddr = z16;
    }

    public void setTcpNoDelay(boolean z16) {
        this.tcpNoDelay = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            if (this.connectionLostTimeout <= 0) {
                log.trace("Connection lost timer deactivated");
                return;
            }
            log.trace("Connection lost timer started");
            this.websocketRunning = true;
            restartConnectionLostTimer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopConnectionLostTimer() {
        synchronized (this.syncConnectionLost) {
            if (this.connectionLostTimer != null || this.connectionLostTimerTask != null) {
                this.websocketRunning = false;
                log.trace("Connection lost timer stopped");
                cancelConnectionLostTimer();
            }
        }
    }
}
