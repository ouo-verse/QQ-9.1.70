package com.tencent.qqmini.miniapp.core.service;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppBrandBaseWebSocket {
    public static final String TAG = "AppBrandRemoteService";
    public static AtomicInteger sWebSocketRequestId = new AtomicInteger(10000);
    protected WebSocketProxy.WebSocketListener mListener;
    public int mTaskId;
    protected IMiniAppContext miniAppContext;
    protected WebSocketProxy wsProxy;

    public void closeSocket(int i3, String str) {
        this.wsProxy.closeSocket(this.mTaskId, 1000, str);
    }

    public void connect(String str) {
        this.mTaskId = sWebSocketRequestId.getAndIncrement();
        WebSocketProxy webSocketProxy = (WebSocketProxy) ProxyManager.get(WebSocketProxy.class);
        this.wsProxy = webSocketProxy;
        webSocketProxy.connectSocket(this.mTaskId, str, null, "", 30000, this.mListener);
    }

    public void destroy() {
        this.wsProxy = null;
    }

    public void sendStringMessage(String str) {
        QMLog.d("AppBrandRemoteService", "---> send Message" + str);
        this.wsProxy.send(this.mTaskId, str);
    }
}
