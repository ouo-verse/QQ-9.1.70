package com.tencent.avcore.netchannel;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IDavNetChannel {
    void SendSharpVideoMsgBySSOChannel(int i3, long j3, byte[] bArr);

    void sendGetGatewayMsg();

    void sendGetVideoConfig(byte[] bArr);

    @Deprecated
    void sendSharpVideoMsg(long j3, byte[] bArr);

    void sendSharpVideoMsgByJCEChannel(long j3, byte[] bArr);

    void setNetCallback(IDavNetCallback iDavNetCallback);
}
