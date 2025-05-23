package com.tencent.mobileqq.mini.zxing.common;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i3) {
        this(i3, i3);
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder(this.height * (this.width + 1));
        for (int i3 = 0; i3 < this.height; i3++) {
            for (int i16 = 0; i16 < this.width; i16++) {
                sb5.append(get(i16, i3) ? str : str2);
            }
            sb5.append(str3);
        }
        return sb5.toString();
    }

    public static BitMatrix parse(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        BitMatrix bitMatrix = new BitMatrix(length2, length);
        for (int i3 = 0; i3 < length; i3++) {
            boolean[] zArr2 = zArr[i3];
            for (int i16 = 0; i16 < length2; i16++) {
                if (zArr2[i16]) {
                    bitMatrix.set(i16, i3);
                }
            }
        }
        return bitMatrix;
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
        return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
    }

    public void flip(int i3, int i16) {
        int i17 = (i16 * this.rowSize) + (i3 / 32);
        int[] iArr = this.bits;
        iArr[i17] = (1 << (i3 & 31)) ^ iArr[i17];
    }

    public boolean get(int i3, int i16) {
        return ((this.bits[(i16 * this.rowSize) + (i3 / 32)] >>> (i3 & 31)) & 1) != 0;
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i3 = this.rowSize;
        int i16 = length / i3;
        int i17 = (length % i3) * 32;
        int i18 = 31;
        while ((this.bits[length] >>> i18) == 0) {
            i18--;
        }
        return new int[]{i17 + i18, i16};
    }

    public int[] getEnclosingRectangle() {
        int i3 = this.width;
        int i16 = this.height;
        int i17 = -1;
        int i18 = -1;
        for (int i19 = 0; i19 < this.height; i19++) {
            int i26 = 0;
            while (true) {
                int i27 = this.rowSize;
                if (i26 < i27) {
                    int i28 = this.bits[(i27 * i19) + i26];
                    if (i28 != 0) {
                        if (i19 < i16) {
                            i16 = i19;
                        }
                        if (i19 > i18) {
                            i18 = i19;
                        }
                        int i29 = i26 * 32;
                        if (i29 < i3) {
                            int i36 = 0;
                            while ((i28 << (31 - i36)) == 0) {
                                i36++;
                            }
                            int i37 = i36 + i29;
                            if (i37 < i3) {
                                i3 = i37;
                            }
                        }
                        if (i29 + 31 > i17) {
                            int i38 = 31;
                            while ((i28 >>> i38) == 0) {
                                i38--;
                            }
                            int i39 = i29 + i38;
                            if (i39 > i17) {
                                i17 = i39;
                            }
                        }
                    }
                    i26++;
                }
            }
        }
        if (i17 < i3 || i18 < i16) {
            return null;
        }
        return new int[]{i3, i16, (i17 - i3) + 1, (i18 - i16) + 1};
    }

    public int getHeight() {
        return this.height;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i3 = this.width;
        return (((((((i3 * 31) + i3) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (int i3 = 0; i3 < (height + 1) / 2; i3++) {
            bitArray = getRow(i3, bitArray);
            int i16 = (height - 1) - i3;
            bitArray2 = getRow(i16, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i3, bitArray2);
            setRow(i16, bitArray);
        }
    }

    public void set(int i3, int i16) {
        int i17 = (i16 * this.rowSize) + (i3 / 32);
        int[] iArr = this.bits;
        iArr[i17] = (1 << (i3 & 31)) | iArr[i17];
    }

    public void setRow(int i3, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i16 = this.rowSize;
        System.arraycopy(bitArray2, 0, iArr, i3 * i16, i16);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public void unset(int i3, int i16) {
        int i17 = (i16 * this.rowSize) + (i3 / 32);
        int[] iArr = this.bits;
        iArr[i17] = (~(1 << (i3 & 31))) & iArr[i17];
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.width == bitMatrix.getWidth() && this.height == bitMatrix.getHeight() && this.rowSize == bitMatrix.getRowSize()) {
            BitArray bitArray = new BitArray(this.width);
            for (int i3 = 0; i3 < this.height; i3++) {
                int i16 = this.rowSize * i3;
                int[] bitArray2 = bitMatrix.getRow(i3, bitArray).getBitArray();
                for (int i17 = 0; i17 < this.rowSize; i17++) {
                    int[] iArr = this.bits;
                    int i18 = i16 + i17;
                    iArr[i18] = iArr[i18] ^ bitArray2[i17];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }

    public BitMatrix(int i3, int i16) {
        if (i3 >= 1 && i16 >= 1) {
            this.width = i3;
            this.height = i16;
            int i17 = (i3 + 31) / 32;
            this.rowSize = i17;
            this.bits = new int[i17 * i16];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitMatrix m206clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public String toString(String str, String str2) {
        return buildToString(str, str2, "\n");
    }

    public BitArray getRow(int i3, BitArray bitArray) {
        if (bitArray != null && bitArray.getSize() >= this.width) {
            bitArray.clear();
        } else {
            bitArray = new BitArray(this.width);
        }
        int i16 = i3 * this.rowSize;
        for (int i17 = 0; i17 < this.rowSize; i17++) {
            bitArray.setBulk(i17 * 32, this.bits[i16 + i17]);
        }
        return bitArray;
    }

    public int[] getTopLeftOnBit() {
        int[] iArr;
        int i3 = 0;
        while (true) {
            iArr = this.bits;
            if (i3 >= iArr.length || iArr[i3] != 0) {
                break;
            }
            i3++;
        }
        if (i3 == iArr.length) {
            return null;
        }
        int i16 = this.rowSize;
        int i17 = i3 / i16;
        int i18 = (i3 % i16) * 32;
        int i19 = iArr[i3];
        int i26 = 0;
        while ((i19 << (31 - i26)) == 0) {
            i26++;
        }
        return new int[]{i18 + i26, i17};
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return buildToString(str, str2, str3);
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str != null) {
            boolean[] zArr = new boolean[str.length()];
            int i3 = -1;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i16 < str.length()) {
                if (str.charAt(i16) == '\n' || str.charAt(i16) == '\r') {
                    if (i17 > i18) {
                        if (i3 == -1) {
                            i3 = i17 - i18;
                        } else if (i17 - i18 != i3) {
                            throw new IllegalArgumentException("row lengths do not match");
                        }
                        i19++;
                        i18 = i17;
                    }
                    i16++;
                } else {
                    if (str.substring(i16, str2.length() + i16).equals(str2)) {
                        i16 += str2.length();
                        zArr[i17] = true;
                    } else if (str.substring(i16, str3.length() + i16).equals(str3)) {
                        i16 += str3.length();
                        zArr[i17] = false;
                    } else {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(i16));
                    }
                    i17++;
                }
            }
            if (i17 > i18) {
                if (i3 == -1) {
                    i3 = i17 - i18;
                } else if (i17 - i18 != i3) {
                    throw new IllegalArgumentException("row lengths do not match");
                }
                i19++;
            }
            BitMatrix bitMatrix = new BitMatrix(i3, i19);
            for (int i26 = 0; i26 < i17; i26++) {
                if (zArr[i26]) {
                    bitMatrix.set(i26 % i3, i26 / i3);
                }
            }
            return bitMatrix;
        }
        throw new IllegalArgumentException();
    }

    BitMatrix(int i3, int i16, int i17, int[] iArr) {
        this.width = i3;
        this.height = i16;
        this.rowSize = i17;
        this.bits = iArr;
    }

    public void setRegion(int i3, int i16, int i17, int i18) {
        if (i16 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i18 >= 1 && i17 >= 1) {
            int i19 = i17 + i3;
            int i26 = i18 + i16;
            if (i26 > this.height || i19 > this.width) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i16 < i26) {
                int i27 = this.rowSize * i16;
                for (int i28 = i3; i28 < i19; i28++) {
                    int[] iArr = this.bits;
                    int i29 = (i28 / 32) + i27;
                    iArr[i29] = iArr[i29] | (1 << (i28 & 31));
                }
                i16++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }
}
