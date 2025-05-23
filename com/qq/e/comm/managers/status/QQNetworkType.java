package com.qq.e.comm.managers.status;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;

/* compiled from: P */
/* loaded from: classes3.dex */
public enum QQNetworkType {
    UNKNOWN(0, 0, "unknown"),
    WIFI(1, 1, "wifi"),
    NET_2G(2, 2, QADNetStatus.G_2),
    NET_3G(3, 4, QADNetStatus.G_3),
    NET_4G(4, 8, QADNetStatus.G_4),
    NET_5G(7, 16, QADNetStatus.G_5);


    /* renamed from: a, reason: collision with root package name */
    private int f38258a;

    /* renamed from: b, reason: collision with root package name */
    private int f38259b;

    /* renamed from: c, reason: collision with root package name */
    private String f38260c;

    QQNetworkType(int i3, int i16, String str) {
        this.f38258a = i3;
        this.f38259b = i16;
        this.f38260c = str;
    }

    public final int getConnValue() {
        return this.f38258a;
    }

    public final String getNameValue() {
        return this.f38260c;
    }

    public final int getPermValue() {
        return this.f38259b;
    }
}
