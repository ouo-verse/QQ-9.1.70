package com.tencent.upload.network.base;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IConnectionCallback {
    void onConnect(IConnectionCallback iConnectionCallback, boolean z16, int i3, String str);

    void onDisconnect(IConnectionCallback iConnectionCallback);

    void onError(IConnectionCallback iConnectionCallback, int i3);

    void onRecv(IConnectionCallback iConnectionCallback, byte[] bArr);

    void onSendBegin(IConnectionCallback iConnectionCallback, int i3);

    void onSendEnd(IConnectionCallback iConnectionCallback, int i3);

    void onSendTimeOut(IConnectionCallback iConnectionCallback, int i3, int i16);

    void onStart(IConnectionCallback iConnectionCallback);
}
