package com.tencent.gamematrix.gmcg.webrtc;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmQuicCongestionType {
    QUICCUBICBYTES(0),
    QUICRENOBYTES(1),
    QUICBBR(2),
    QUICPCC(3),
    QUICGOOGCC(4),
    QUICBBRv2(5);

    private final int mValue;

    GmQuicCongestionType(int i3) {
        this.mValue = i3;
    }

    public int getValue() {
        return this.mValue;
    }
}
