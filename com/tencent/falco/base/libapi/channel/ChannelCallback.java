package com.tencent.falco.base.libapi.channel;

/* compiled from: P */
/* loaded from: classes31.dex */
public interface ChannelCallback {
    void onError(boolean z16, int i3, String str);

    void onRecv(byte[] bArr);
}
