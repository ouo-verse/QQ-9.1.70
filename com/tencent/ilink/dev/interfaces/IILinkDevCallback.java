package com.tencent.ilink.dev.interfaces;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IILinkDevCallback {
    void onDevLoginComplete(int i3, int i16);

    void onDevLogoutComplete(int i3);

    void onFinishGetStrategy();

    void onNetStatusChanged(int i3);

    void onReceiveMessage(int i3, byte[] bArr);

    void onReceivePullLogCmd(byte[] bArr);

    void onReceiveResponse(int i3, int i16, byte[] bArr);

    void onSendMsgResult(int i3, String str);

    void onUploadLogComplete(int i3);
}
