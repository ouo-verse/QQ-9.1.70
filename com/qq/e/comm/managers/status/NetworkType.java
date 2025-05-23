package com.qq.e.comm.managers.status;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;

/* compiled from: P */
/* loaded from: classes3.dex */
public enum NetworkType {
    UNKNOWN(0, 1, "unknown"),
    WIFI(1, 2, "wifi"),
    NET_2G(2, 4, QADNetStatus.G_2),
    NET_3G(3, 8, QADNetStatus.G_3),
    NET_4G(4, 16, QADNetStatus.G_4),
    NET_5G(7, 128, QADNetStatus.G_5);


    /* renamed from: a, reason: collision with root package name */
    private int f38254a;

    /* renamed from: b, reason: collision with root package name */
    private int f38255b;

    /* renamed from: c, reason: collision with root package name */
    private String f38256c;

    NetworkType(int i3, int i16, String str) {
        this.f38254a = i3;
        this.f38255b = i16;
        this.f38256c = str;
    }

    public final int getConnValue() {
        return this.f38254a;
    }

    public final String getNameValue() {
        return this.f38256c;
    }

    public final int getPermValue() {
        return this.f38255b;
    }
}
