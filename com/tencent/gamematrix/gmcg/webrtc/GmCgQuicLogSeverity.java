package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgQuicLogSeverity {
    VERBOSE(-1),
    INFO(0),
    WARNING(1),
    ERROR(2),
    NONE(3);

    private final int mValue;

    GmCgQuicLogSeverity(int i3) {
        this.mValue = i3;
    }

    public int getValue() {
        return this.mValue;
    }
}
