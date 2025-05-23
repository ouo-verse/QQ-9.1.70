package com.eclipsesource.mmv8;

import androidx.annotation.Keep;

/* compiled from: P */
/* loaded from: classes2.dex */
public class V8Inspector {
    private static JsInspectorChannelServer _server;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface JsInspectorChannelServer {
        int notify(long j3, long j16, String str);

        int sendData(long j3, String str);
    }

    public static native int JniNotify(long j3, long j16, String str);

    public static native void JniReceiveData(long j3, String str);

    @Keep
    public static int jniCallbackNotify(long j3, long j16, String str) {
        JsInspectorChannelServer jsInspectorChannelServer = _server;
        if (jsInspectorChannelServer == null) {
            return -1;
        }
        return jsInspectorChannelServer.notify(j3, j16, str);
    }

    @Keep
    public static int jniCallbackSendData(long j3, String str) {
        JsInspectorChannelServer jsInspectorChannelServer = _server;
        if (jsInspectorChannelServer == null) {
            return -1;
        }
        return jsInspectorChannelServer.sendData(j3, str);
    }

    public static int notify(long j3, long j16, String str) {
        return JniNotify(j3, j16, str);
    }

    public static void onReceiveData(long j3, String str) {
        JniReceiveData(j3, str);
    }

    public static void setServer(JsInspectorChannelServer jsInspectorChannelServer) {
        _server = jsInspectorChannelServer;
    }
}
