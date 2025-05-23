package com.tencent.liteav.videobase.common;

/* compiled from: P */
/* loaded from: classes7.dex */
public enum c {
    UNKNOWN(65535),
    IDR(0),
    P(1),
    B(6),
    P_MULTI_REF(7),
    I(8),
    SEI(17),
    SPS(18),
    PPS(19),
    VPS(20);


    /* renamed from: k, reason: collision with root package name */
    private static final c[] f119303k = values();
    public final int mValue;

    c(int i3) {
        this.mValue = i3;
    }

    public static c a(int i3) {
        for (c cVar : f119303k) {
            if (cVar.mValue == i3) {
                return cVar;
            }
        }
        return UNKNOWN;
    }
}
