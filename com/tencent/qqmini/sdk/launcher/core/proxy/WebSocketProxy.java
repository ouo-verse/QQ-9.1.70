package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes23.dex */
public abstract class WebSocketProxy {
    private static AtomicInteger sWebSocketRequestId = new AtomicInteger();

    /* loaded from: classes23.dex */
    public interface WebSocketListener {
        void onClose(int i3, int i16, String str);

        void onError(int i3, int i16, String str);

        void onMessage(int i3, String str);

        void onMessage(int i3, byte[] bArr);

        void onOpen(int i3, int i16, Map<String, List<String>> map);
    }

    public static int getWebSocketRequestId() {
        return sWebSocketRequestId.getAndIncrement();
    }

    public abstract boolean closeSocket(int i3, int i16, String str);

    public abstract boolean connectSocket(int i3, String str, Map<String, String> map, String str2, int i16, WebSocketListener webSocketListener);

    public abstract void release();

    public abstract boolean send(int i3, String str);

    public abstract boolean send(int i3, byte[] bArr);
}
