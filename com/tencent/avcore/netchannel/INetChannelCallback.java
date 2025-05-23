package com.tencent.avcore.netchannel;

import android.os.Bundle;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface INetChannelCallback {
    public static final String KEY_BUF = "buffer";
    public static final String KEY_TINY_ID = "tiny_id";

    void receiveDeviceMsg(Bundle bundle);

    void receiveGatewayMsg(String str, int i3);

    void receiveMultiVideoAck(Bundle bundle);

    void receiveMultiVideoMsg(Bundle bundle);

    void receiveMultiVideoOfflineMsg(Bundle bundle);

    void receiveOpenImAck(byte[] bArr);

    void receiveSSOMultiVideoAck(int i3, byte[] bArr);

    void receiveSSOMultiVideoMsg(int i3, byte[] bArr, boolean z16);

    void receiveSharpVideoAck(Bundle bundle);

    void receiveSharpVideoMsg(Bundle bundle);

    void receiveSharpVideoOfflineMsg(Bundle bundle);

    void receiveVideoConfig(Bundle bundle);
}
