package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.util.Assertions;

/* compiled from: P */
/* loaded from: classes2.dex */
final class VorbisBitArray {
    private int bitOffset;
    private final int byteLimit;
    private int byteOffset;
    private final byte[] data;

    public VorbisBitArray(byte[] bArr) {
        this.data = bArr;
        this.byteLimit = bArr.length;
    }

    private void assertValidOffset() {
        boolean z16;
        int i3;
        int i16 = this.byteOffset;
        if (i16 >= 0 && (i16 < (i3 = this.byteLimit) || (i16 == i3 && this.bitOffset == 0))) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
    }

    public int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public boolean readBit() {
        boolean z16;
        if ((((this.data[this.byteOffset] & 255) >> this.bitOffset) & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        skipBits(1);
        return z16;
    }

    public int readBits(int i3) {
        int i16 = this.byteOffset;
        int min = Math.min(i3, 8 - this.bitOffset);
        int i17 = i16 + 1;
        int i18 = ((this.data[i16] & 255) >> this.bitOffset) & (255 >> (8 - min));
        while (min < i3) {
            i18 |= (this.data[i17] & 255) << min;
            min += 8;
            i17++;
        }
        int i19 = i18 & ((-1) >>> (32 - i3));
        skipBits(i3);
        return i19;
    }

    public void reset() {
        this.byteOffset = 0;
        this.bitOffset = 0;
    }

    public void setPosition(int i3) {
        int i16 = i3 / 8;
        this.byteOffset = i16;
        this.bitOffset = i3 - (i16 * 8);
        assertValidOffset();
    }

    public void skipBits(int i3) {
        int i16 = i3 / 8;
        int i17 = this.byteOffset + i16;
        this.byteOffset = i17;
        int i18 = this.bitOffset + (i3 - (i16 * 8));
        this.bitOffset = i18;
        if (i18 > 7) {
            this.byteOffset = i17 + 1;
            this.bitOffset = i18 - 8;
        }
        assertValidOffset();
    }
}
