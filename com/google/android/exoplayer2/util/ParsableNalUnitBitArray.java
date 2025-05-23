package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public final class ParsableNalUnitBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    private byte[] data;

    public ParsableNalUnitBitArray(byte[] bArr, int i3, int i16) {
        reset(bArr, i3, i16);
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

    private int readExpGolombCodeNum() {
        int i3 = 0;
        int i16 = 0;
        while (!readBit()) {
            i16++;
        }
        int i17 = (1 << i16) - 1;
        if (i16 > 0) {
            i3 = readBits(i16);
        }
        return i17 + i3;
    }

    private boolean shouldSkipByte(int i3) {
        if (2 <= i3 && i3 < this.byteLimit) {
            byte[] bArr = this.data;
            if (bArr[i3] == 3 && bArr[i3 - 2] == 0 && bArr[i3 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canReadBits(int i3) {
        int i16 = this.byteOffset;
        int i17 = i3 / 8;
        int i18 = i16 + i17;
        int i19 = (this.bitOffset + i3) - (i17 * 8);
        if (i19 > 7) {
            i18++;
            i19 -= 8;
        }
        while (true) {
            i16++;
            if (i16 > i18 || i18 >= this.byteLimit) {
                break;
            }
            if (shouldSkipByte(i16)) {
                i18++;
                i16 += 2;
            }
        }
        int i26 = this.byteLimit;
        if (i18 < i26) {
            return true;
        }
        if (i18 == i26 && i19 == 0) {
            return true;
        }
        return false;
    }

    public boolean canReadExpGolombCodedNum() {
        boolean z16;
        int i3 = this.byteOffset;
        int i16 = this.bitOffset;
        int i17 = 0;
        while (this.byteOffset < this.byteLimit && !readBit()) {
            i17++;
        }
        if (this.byteOffset == this.byteLimit) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.byteOffset = i3;
        this.bitOffset = i16;
        if (z16 || !canReadBits((i17 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public boolean readBit() {
        boolean z16;
        if ((this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        skipBit();
        return z16;
    }

    public int readBits(int i3) {
        int i16;
        int i17;
        this.bitOffset += i3;
        int i18 = 0;
        while (true) {
            i16 = this.bitOffset;
            i17 = 2;
            if (i16 <= 8) {
                break;
            }
            int i19 = i16 - 8;
            this.bitOffset = i19;
            byte[] bArr = this.data;
            int i26 = this.byteOffset;
            i18 |= (bArr[i26] & 255) << i19;
            if (!shouldSkipByte(i26 + 1)) {
                i17 = 1;
            }
            this.byteOffset = i26 + i17;
        }
        byte[] bArr2 = this.data;
        int i27 = this.byteOffset;
        int i28 = ((-1) >>> (32 - i3)) & (i18 | ((bArr2[i27] & 255) >> (8 - i16)));
        if (i16 == 8) {
            this.bitOffset = 0;
            if (!shouldSkipByte(i27 + 1)) {
                i17 = 1;
            }
            this.byteOffset = i27 + i17;
        }
        assertValidOffset();
        return i28;
    }

    public int readSignedExpGolombCodedInt() {
        int i3;
        int readExpGolombCodeNum = readExpGolombCodeNum();
        if (readExpGolombCodeNum % 2 == 0) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        return i3 * ((readExpGolombCodeNum + 1) / 2);
    }

    public int readUnsignedExpGolombCodedInt() {
        return readExpGolombCodeNum();
    }

    public void reset(byte[] bArr, int i3, int i16) {
        this.data = bArr;
        this.byteOffset = i3;
        this.byteLimit = i16;
        this.bitOffset = 0;
        assertValidOffset();
    }

    public void skipBit() {
        int i3 = 1;
        int i16 = this.bitOffset + 1;
        this.bitOffset = i16;
        if (i16 == 8) {
            this.bitOffset = 0;
            int i17 = this.byteOffset;
            if (shouldSkipByte(i17 + 1)) {
                i3 = 2;
            }
            this.byteOffset = i17 + i3;
        }
        assertValidOffset();
    }

    public void skipBits(int i3) {
        int i16 = this.byteOffset;
        int i17 = i3 / 8;
        int i18 = i16 + i17;
        this.byteOffset = i18;
        int i19 = this.bitOffset + (i3 - (i17 * 8));
        this.bitOffset = i19;
        if (i19 > 7) {
            this.byteOffset = i18 + 1;
            this.bitOffset = i19 - 8;
        }
        while (true) {
            i16++;
            if (i16 <= this.byteOffset) {
                if (shouldSkipByte(i16)) {
                    this.byteOffset++;
                    i16 += 2;
                }
            } else {
                assertValidOffset();
                return;
            }
        }
    }
}
