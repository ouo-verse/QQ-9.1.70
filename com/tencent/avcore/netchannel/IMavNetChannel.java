package com.tencent.avcore.netchannel;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IMavNetChannel {
    void sendGetGatewayMsg();

    void sendMultiVideoMsg(long j3, long j16, byte[] bArr, boolean z16);

    void setNetCallback(IMavNetCallback iMavNetCallback);
}
