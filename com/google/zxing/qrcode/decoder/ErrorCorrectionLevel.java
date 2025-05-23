package com.google.zxing.qrcode.decoder;

/* compiled from: P */
/* loaded from: classes2.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);

    private final int bits;

    ErrorCorrectionLevel(int i3) {
        this.bits = i3;
    }

    public int getBits() {
        return this.bits;
    }
}
