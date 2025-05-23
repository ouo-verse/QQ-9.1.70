package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgNetworkType {
    NET_INVALID(0),
    NET_WIFI(1),
    NET_2G(2),
    NET_3G(3),
    NET_4G(4),
    NET_5G(5),
    NET_WIRED(6),
    NET_MOBILE(7);

    private final int mValue;

    GmCgNetworkType(int i3) {
        this.mValue = i3;
    }

    public int getValue() {
        return this.mValue;
    }
}
