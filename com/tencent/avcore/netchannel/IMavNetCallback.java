package com.tencent.avcore.netchannel;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IMavNetCallback {

    @Deprecated
    public static final int EM_PROTO_CHANNEL_GA_ACK = 2;

    @Deprecated
    public static final int EM_PROTO_CHANNEL_GA_MSG = 1;

    @Deprecated
    public static final int EM_PROTO_CHANNEL_GA_OFFLINE = 3;

    @Deprecated
    public static final int EM_PROTO_CHANNEL_OPENSDK_ACK = 103;

    void receiveGatewayMsg(String str, int i3);

    int receiveMultiVideoMsg(int i3, byte[] bArr, boolean z16);
}
