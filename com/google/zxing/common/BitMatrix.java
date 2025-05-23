package com.google.zxing.common;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class BitMatrix {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i3) {
        this(i3, i3);
    }

    public void clear() {
        int length = this.bits.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.bits[i3] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        if (this.width != bitMatrix.width || this.height != bitMatrix.height || this.rowSize != bitMatrix.rowSize || this.bits.length != bitMatrix.bits.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i3 < iArr.length) {
                if (iArr[i3] != bitMatrix.bits[i3]) {
                    return false;
                }
                i3++;
            } else {
                return true;
            }
        }
    }

    public void flip(int i3, int i16) {
        int i17 = (i16 * this.rowSize) + (i3 >> 5);
        int[] iArr = this.bits;
        iArr[i17] = (1 << (i3 & 31)) ^ iArr[i17];
    }

    public boolean get(int i3, int i16) {
        if (((this.bits[(i16 * this.rowSize) + (i3 >> 5)] >>> (i3 & 31)) & 1) != 0) {
            return true;
        }
        return false;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i3 = this.width;
        int i16 = (((((i3 * 31) + i3) * 31) + this.height) * 31) + this.rowSize;
        for (int i17 : this.bits) {
            i16 = (i16 * 31) + i17;
        }
        return i16;
    }

    public void set(int i3, int i16) {
        int i17 = (i16 * this.rowSize) + (i3 >> 5);
        int[] iArr = this.bits;
        iArr[i17] = (1 << (i3 & 31)) | iArr[i17];
    }

    public void setRegion(int i3, int i16, int i17, int i18) {
        if (i16 >= 0 && i3 >= 0) {
            if (i18 >= 1 && i17 >= 1) {
                int i19 = i17 + i3;
                int i26 = i18 + i16;
                if (i26 <= this.height && i19 <= this.width) {
                    while (i16 < i26) {
                        int i27 = this.rowSize * i16;
                        for (int i28 = i3; i28 < i19; i28++) {
                            int[] iArr = this.bits;
                            int i29 = (i28 >> 5) + i27;
                            iArr[i29] = iArr[i29] | (1 << (i28 & 31));
                        }
                        i16++;
                    }
                    return;
                }
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        throw new IllegalArgumentException("Left and top must be nonnegative");
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder(this.height * (this.width + 1));
        for (int i3 = 0; i3 < this.height; i3++) {
            for (int i16 = 0; i16 < this.width; i16++) {
                if (get(i16, i3)) {
                    str = "X ";
                } else {
                    str = "  ";
                }
                sb5.append(str);
            }
            sb5.append('\n');
        }
        return sb5.toString();
    }

    public BitMatrix(int i3, int i16) {
        if (i3 >= 1 && i16 >= 1) {
            this.width = i3;
            this.height = i16;
            int i17 = (i3 + 31) >> 5;
            this.rowSize = i17;
            this.bits = new int[i17 * i16];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }
}
