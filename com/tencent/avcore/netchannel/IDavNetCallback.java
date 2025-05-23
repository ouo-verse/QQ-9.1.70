package com.tencent.avcore.netchannel;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IDavNetCallback {
    void receiveGatewayMsg(String str, int i3);

    byte receiveSharpVideoAck(long j3, byte[] bArr, byte[] bArr2);

    byte receiveSharpVideoCall(long j3, byte[] bArr, byte[] bArr2);
}
