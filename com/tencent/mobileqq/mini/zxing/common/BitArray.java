package com.tencent.mobileqq.mini.zxing.common;

import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    private void ensureCapacity(int i3) {
        if (i3 > this.bits.length * 32) {
            int[] makeArray = makeArray(i3);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, makeArray, 0, iArr.length);
            this.bits = makeArray;
        }
    }

    public void appendBit(boolean z16) {
        ensureCapacity(this.size + 1);
        if (z16) {
            int[] iArr = this.bits;
            int i3 = this.size;
            int i16 = i3 / 32;
            iArr[i16] = (1 << (i3 & 31)) | iArr[i16];
        }
        this.size++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i3 = bitArray.size;
        ensureCapacity(this.size + i3);
        for (int i16 = 0; i16 < i3; i16++) {
            appendBit(bitArray.get(i16));
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.bits[i3] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
    }

    public void flip(int i3) {
        int[] iArr = this.bits;
        int i16 = i3 / 32;
        iArr[i16] = (1 << (i3 & 31)) ^ iArr[i16];
    }

    public boolean get(int i3) {
        return ((1 << (i3 & 31)) & this.bits[i3 / 32]) != 0;
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public int getNextSet(int i3) {
        int i16 = this.size;
        if (i3 >= i16) {
            return i16;
        }
        int i17 = i3 / 32;
        int i18 = (-(1 << (i3 & 31))) & this.bits[i17];
        while (i18 == 0) {
            i17++;
            int[] iArr = this.bits;
            if (i17 == iArr.length) {
                return this.size;
            }
            i18 = iArr[i17];
        }
        int numberOfTrailingZeros = (i17 * 32) + Integer.numberOfTrailingZeros(i18);
        int i19 = this.size;
        return numberOfTrailingZeros > i19 ? i19 : numberOfTrailingZeros;
    }

    public int getNextUnset(int i3) {
        int i16 = this.size;
        if (i3 >= i16) {
            return i16;
        }
        int i17 = i3 / 32;
        int i18 = (-(1 << (i3 & 31))) & (~this.bits[i17]);
        while (i18 == 0) {
            i17++;
            int[] iArr = this.bits;
            if (i17 == iArr.length) {
                return this.size;
            }
            i18 = ~iArr[i17];
        }
        int numberOfTrailingZeros = (i17 * 32) + Integer.numberOfTrailingZeros(i18);
        int i19 = this.size;
        return numberOfTrailingZeros > i19 ? i19 : numberOfTrailingZeros;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public void reverse() {
        int[] iArr = new int[this.bits.length];
        int i3 = (this.size - 1) / 32;
        int i16 = i3 + 1;
        for (int i17 = 0; i17 < i16; i17++) {
            long j3 = this.bits[i17];
            long j16 = ((j3 & 1431655765) << 1) | ((j3 >> 1) & 1431655765);
            long j17 = ((j16 & 858993459) << 2) | ((j16 >> 2) & 858993459);
            long j18 = ((j17 & 252645135) << 4) | ((j17 >> 4) & 252645135);
            long j19 = ((j18 & 16711935) << 8) | ((j18 >> 8) & 16711935);
            iArr[i3 - i17] = (int) (((j19 & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((j19 >> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        int i18 = this.size;
        int i19 = i16 * 32;
        if (i18 != i19) {
            int i26 = i19 - i18;
            int i27 = iArr[0] >>> i26;
            for (int i28 = 1; i28 < i16; i28++) {
                int i29 = iArr[i28];
                iArr[i28 - 1] = i27 | (i29 << (32 - i26));
                i27 = i29 >>> i26;
            }
            iArr[i16 - 1] = i27;
        }
        this.bits = iArr;
    }

    public void set(int i3) {
        int[] iArr = this.bits;
        int i16 = i3 / 32;
        iArr[i16] = (1 << (i3 & 31)) | iArr[i16];
    }

    public void setBulk(int i3, int i16) {
        this.bits[i3 / 32] = i16;
    }

    public String toString() {
        int i3 = this.size;
        StringBuilder sb5 = new StringBuilder(i3 + (i3 / 8) + 1);
        for (int i16 = 0; i16 < this.size; i16++) {
            if ((i16 & 7) == 0) {
                sb5.append(TokenParser.SP);
            }
            sb5.append(get(i16) ? 'X' : '.');
        }
        return sb5.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.size != bitArray.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i3 >= iArr.length) {
                return;
            }
            iArr[i3] = iArr[i3] ^ bitArray.bits[i3];
            i3++;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitArray m205clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }

    private static int[] makeArray(int i3) {
        return new int[(i3 + 31) / 32];
    }

    public BitArray(int i3) {
        this.size = i3;
        this.bits = makeArray(i3);
    }

    public boolean isRange(int i3, int i16, boolean z16) {
        if (i16 < i3 || i3 < 0 || i16 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i16 == i3) {
            return true;
        }
        int i17 = i16 - 1;
        int i18 = i3 / 32;
        int i19 = i17 / 32;
        int i26 = i18;
        while (i26 <= i19) {
            int i27 = (2 << (i26 >= i19 ? 31 & i17 : 31)) - (1 << (i26 > i18 ? 0 : i3 & 31));
            int i28 = this.bits[i26] & i27;
            if (!z16) {
                i27 = 0;
            }
            if (i28 != i27) {
                return false;
            }
            i26++;
        }
        return true;
    }

    public void setRange(int i3, int i16) {
        if (i16 < i3 || i3 < 0 || i16 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i16 == i3) {
            return;
        }
        int i17 = i16 - 1;
        int i18 = i3 / 32;
        int i19 = i17 / 32;
        int i26 = i18;
        while (i26 <= i19) {
            int i27 = 31;
            int i28 = i26 > i18 ? 0 : i3 & 31;
            if (i26 >= i19) {
                i27 = 31 & i17;
            }
            int i29 = (2 << i27) - (1 << i28);
            int[] iArr = this.bits;
            iArr[i26] = i29 | iArr[i26];
            i26++;
        }
    }

    BitArray(int[] iArr, int i3) {
        this.bits = iArr;
        this.size = i3;
    }

    public void appendBits(int i3, int i16) {
        if (i16 >= 0 && i16 <= 32) {
            ensureCapacity(this.size + i16);
            while (i16 > 0) {
                boolean z16 = true;
                if (((i3 >> (i16 - 1)) & 1) != 1) {
                    z16 = false;
                }
                appendBit(z16);
                i16--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void toBytes(int i3, byte[] bArr, int i16, int i17) {
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = 0;
            for (int i26 = 0; i26 < 8; i26++) {
                if (get(i3)) {
                    i19 |= 1 << (7 - i26);
                }
                i3++;
            }
            bArr[i16 + i18] = (byte) i19;
        }
    }
}
