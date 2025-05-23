package com.tencent.liteav.videobase.common;

/* compiled from: P */
/* loaded from: classes7.dex */
public enum d {
    UNKNOWN(0),
    BASELINE(1),
    MAIN(2),
    HIGH(3),
    BASELINE_RPS(11),
    MAIN_RPS(12),
    HIGH_RPS(13);


    /* renamed from: h, reason: collision with root package name */
    private static final d[] f119312h = values();
    public final int mValue;

    d(int i3) {
        this.mValue = i3;
    }

    public static d a(int i3) {
        for (d dVar : f119312h) {
            if (dVar.mValue == i3) {
                return dVar;
            }
        }
        return UNKNOWN;
    }
}
