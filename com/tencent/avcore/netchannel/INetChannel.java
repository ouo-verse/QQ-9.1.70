package com.tencent.avcore.netchannel;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface INetChannel {
    void sendGetGatewayMsg();

    void sendGetVideoConfig(byte[] bArr);

    void sendLogReportMsg(long j3, byte[] bArr);

    void sendMultiVideoMsg(long j3, long j16, byte[] bArr, boolean z16);

    void sendSharpVideoMsg(long j3, byte[] bArr);
}
