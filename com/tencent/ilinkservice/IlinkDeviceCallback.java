package com.tencent.ilinkservice;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface IlinkDeviceCallback {
    void onFinishGetStrategy();

    void onLoginComplete(int i3, int i16, byte[] bArr, String str);

    void onNetStatusChanged(int i3);

    void onReceiveMessage(String str, String str2, String str3, String str4, int i3);

    void onReceivePullLogCmd(byte[] bArr);

    void onSendMsgResult(int i3, int i16);

    void onUploadLogComplete(int i3);
}
