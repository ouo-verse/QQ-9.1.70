package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public final class ParsableBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
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

    public void byteAlign() {
        if (this.bitOffset == 0) {
            return;
        }
        this.bitOffset = 0;
        this.byteOffset++;
        assertValidOffset();
    }

    public int getBytePosition() {
        boolean z16;
        if (this.bitOffset == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        return this.byteOffset;
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public void putInt(int i3, int i16) {
        if (i16 < 32) {
            i3 &= (1 << i16) - 1;
        }
        int min = Math.min(8 - this.bitOffset, i16);
        int i17 = this.bitOffset;
        int i18 = (8 - i17) - min;
        byte[] bArr = this.data;
        int i19 = this.byteOffset;
        byte b16 = (byte) (((65280 >> i17) | ((1 << i18) - 1)) & bArr[i19]);
        bArr[i19] = b16;
        int i26 = i16 - min;
        bArr[i19] = (byte) (b16 | ((i3 >>> i26) << i18));
        int i27 = i19 + 1;
        while (i26 > 8) {
            this.data[i27] = (byte) (i3 >>> (i26 - 8));
            i26 -= 8;
            i27++;
        }
        int i28 = 8 - i26;
        byte[] bArr2 = this.data;
        byte b17 = (byte) (bArr2[i27] & ((1 << i28) - 1));
        bArr2[i27] = b17;
        bArr2[i27] = (byte) (((i3 & ((1 << i26) - 1)) << i28) | b17);
        skipBits(i16);
        assertValidOffset();
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
        if (i3 == 0) {
            return 0;
        }
        this.bitOffset += i3;
        int i17 = 0;
        while (true) {
            i16 = this.bitOffset;
            if (i16 <= 8) {
                break;
            }
            int i18 = i16 - 8;
            this.bitOffset = i18;
            byte[] bArr = this.data;
            int i19 = this.byteOffset;
            this.byteOffset = i19 + 1;
            i17 |= (bArr[i19] & 255) << i18;
        }
        byte[] bArr2 = this.data;
        int i26 = this.byteOffset;
        int i27 = ((-1) >>> (32 - i3)) & (i17 | ((bArr2[i26] & 255) >> (8 - i16)));
        if (i16 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i26 + 1;
        }
        assertValidOffset();
        return i27;
    }

    public void readBytes(byte[] bArr, int i3, int i16) {
        boolean z16;
        if (this.bitOffset == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        System.arraycopy(this.data, this.byteOffset, bArr, i3, i16);
        this.byteOffset += i16;
        assertValidOffset();
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void setPosition(int i3) {
        int i16 = i3 / 8;
        this.byteOffset = i16;
        this.bitOffset = i3 - (i16 * 8);
        assertValidOffset();
    }

    public void skipBit() {
        int i3 = this.bitOffset + 1;
        this.bitOffset = i3;
        if (i3 == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
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

    public void skipBytes(int i3) {
        boolean z16;
        if (this.bitOffset == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.byteOffset += i3;
        assertValidOffset();
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.data, parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public ParsableBitArray(byte[] bArr, int i3) {
        this.data = bArr;
        this.byteLimit = i3;
    }

    public void reset(byte[] bArr, int i3) {
        this.data = bArr;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = i3;
    }

    public void readBits(byte[] bArr, int i3, int i16) {
        int i17 = (i16 >> 3) + i3;
        while (i3 < i17) {
            byte[] bArr2 = this.data;
            int i18 = this.byteOffset;
            int i19 = i18 + 1;
            this.byteOffset = i19;
            byte b16 = bArr2[i18];
            int i26 = this.bitOffset;
            byte b17 = (byte) (b16 << i26);
            bArr[i3] = b17;
            bArr[i3] = (byte) (((255 & bArr2[i19]) >> (8 - i26)) | b17);
            i3++;
        }
        int i27 = i16 & 7;
        if (i27 == 0) {
            return;
        }
        byte b18 = (byte) (bArr[i17] & (255 >> i27));
        bArr[i17] = b18;
        int i28 = this.bitOffset;
        if (i28 + i27 > 8) {
            byte[] bArr3 = this.data;
            int i29 = this.byteOffset;
            this.byteOffset = i29 + 1;
            bArr[i17] = (byte) (b18 | ((byte) ((bArr3[i29] & 255) << i28)));
            this.bitOffset = i28 - 8;
        }
        int i36 = this.bitOffset + i27;
        this.bitOffset = i36;
        byte[] bArr4 = this.data;
        int i37 = this.byteOffset;
        bArr[i17] = (byte) (((byte) (((255 & bArr4[i37]) >> (8 - i36)) << (8 - i27))) | bArr[i17]);
        if (i36 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i37 + 1;
        }
        assertValidOffset();
    }
}
