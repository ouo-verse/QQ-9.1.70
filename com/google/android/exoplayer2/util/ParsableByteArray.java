package com.google.android.exoplayer2.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class ParsableByteArray {
    public byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray() {
    }

    public int bytesLeft() {
        return this.limit - this.position;
    }

    public int capacity() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public int getPosition() {
        return this.position;
    }

    public int limit() {
        return this.limit;
    }

    public char peekChar() {
        byte[] bArr = this.data;
        int i3 = this.position;
        return (char) ((bArr[i3 + 1] & 255) | ((bArr[i3] & 255) << 8));
    }

    public int peekUnsignedByte() {
        return this.data[this.position] & 255;
    }

    public void readBytes(ParsableBitArray parsableBitArray, int i3) {
        readBytes(parsableBitArray.data, 0, i3);
        parsableBitArray.setPosition(0);
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public int readInt() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i3] & 255) << 24) | ((bArr[i16] & 255) << 16);
        int i19 = i17 + 1;
        int i26 = i18 | ((bArr[i17] & 255) << 8);
        this.position = i19 + 1;
        return (bArr[i19] & 255) | i26;
    }

    public int readInt24() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = (((bArr[i3] & 255) << 24) >> 8) | ((bArr[i16] & 255) << 8);
        this.position = i17 + 1;
        return (bArr[i17] & 255) | i18;
    }

    public String readLine() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i3 = this.position;
        while (i3 < this.limit && !Util.isLinebreak(this.data[i3])) {
            i3++;
        }
        int i16 = this.position;
        if (i3 - i16 >= 3) {
            byte[] bArr = this.data;
            if (bArr[i16] == -17 && bArr[i16 + 1] == -69 && bArr[i16 + 2] == -65) {
                this.position = i16 + 3;
            }
        }
        byte[] bArr2 = this.data;
        int i17 = this.position;
        String str = new String(bArr2, i17, i3 - i17);
        this.position = i3;
        int i18 = this.limit;
        if (i3 == i18) {
            return str;
        }
        byte[] bArr3 = this.data;
        if (bArr3[i3] == 13) {
            int i19 = i3 + 1;
            this.position = i19;
            if (i19 == i18) {
                return str;
            }
        }
        int i26 = this.position;
        if (bArr3[i26] == 10) {
            this.position = i26 + 1;
        }
        return str;
    }

    public int readLittleEndianInt() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = (bArr[i3] & 255) | ((bArr[i16] & 255) << 8);
        int i19 = i17 + 1;
        int i26 = i18 | ((bArr[i17] & 255) << 16);
        this.position = i19 + 1;
        return ((bArr[i19] & 255) << 24) | i26;
    }

    public int readLittleEndianInt24() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = (bArr[i3] & 255) | ((bArr[i16] & 255) << 8);
        this.position = i17 + 1;
        return ((bArr[i17] & 255) << 16) | i18;
    }

    public long readLittleEndianLong() {
        byte[] bArr = this.data;
        long j3 = bArr[r1] & 255;
        int i3 = this.position + 1 + 1 + 1;
        long j16 = j3 | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        long j17 = j16 | ((bArr[i3] & 255) << 24);
        long j18 = j17 | ((bArr[r3] & 255) << 32);
        long j19 = j18 | ((bArr[r4] & 255) << 40);
        long j26 = j19 | ((bArr[r3] & 255) << 48);
        this.position = i3 + 1 + 1 + 1 + 1 + 1;
        return j26 | ((bArr[r4] & 255) << 56);
    }

    public short readLittleEndianShort() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = bArr[i3] & 255;
        this.position = i16 + 1;
        return (short) (((bArr[i16] & 255) << 8) | i17);
    }

    public long readLittleEndianUnsignedInt() {
        byte[] bArr = this.data;
        long j3 = bArr[r1] & 255;
        int i3 = this.position + 1 + 1 + 1;
        long j16 = j3 | ((bArr[r2] & 255) << 8) | ((bArr[r1] & 255) << 16);
        this.position = i3 + 1;
        return j16 | ((bArr[i3] & 255) << 24);
    }

    public int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = (bArr[i3] & 255) | ((bArr[i16] & 255) << 8);
        this.position = i17 + 1;
        return ((bArr[i17] & 255) << 16) | i18;
    }

    public int readLittleEndianUnsignedIntToInt() {
        int readLittleEndianInt = readLittleEndianInt();
        if (readLittleEndianInt >= 0) {
            return readLittleEndianInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readLittleEndianInt);
    }

    public int readLittleEndianUnsignedShort() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = bArr[i3] & 255;
        this.position = i16 + 1;
        return ((bArr[i16] & 255) << 8) | i17;
    }

    public long readLong() {
        byte[] bArr = this.data;
        long j3 = (bArr[r1] & 255) << 56;
        int i3 = this.position + 1 + 1 + 1;
        long j16 = j3 | ((bArr[r2] & 255) << 48) | ((bArr[r1] & 255) << 40);
        long j17 = j16 | ((bArr[i3] & 255) << 32);
        long j18 = j17 | ((bArr[r3] & 255) << 24);
        long j19 = j18 | ((bArr[r4] & 255) << 16);
        long j26 = j19 | ((bArr[r3] & 255) << 8);
        this.position = i3 + 1 + 1 + 1 + 1 + 1;
        return j26 | (bArr[r4] & 255);
    }

    public String readNullTerminatedString(int i3) {
        if (i3 == 0) {
            return "";
        }
        int i16 = this.position;
        int i17 = (i16 + i3) - 1;
        String str = new String(this.data, i16, (i17 >= this.limit || this.data[i17] != 0) ? i3 : i3 - 1);
        this.position += i3;
        return str;
    }

    public short readShort() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = (bArr[i3] & 255) << 8;
        this.position = i16 + 1;
        return (short) ((bArr[i16] & 255) | i17);
    }

    public String readString(int i3) {
        return readString(i3, Charset.forName("UTF-8"));
    }

    public int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public int readUnsignedByte() {
        byte[] bArr = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        return bArr[i3] & 255;
    }

    public int readUnsignedFixedPoint1616() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = (bArr[i16] & 255) | ((bArr[i3] & 255) << 8);
        this.position = i16 + 1 + 2;
        return i17;
    }

    public long readUnsignedInt() {
        byte[] bArr = this.data;
        long j3 = (bArr[r1] & 255) << 24;
        int i3 = this.position + 1 + 1 + 1;
        long j16 = j3 | ((bArr[r2] & 255) << 16) | ((bArr[r1] & 255) << 8);
        this.position = i3 + 1;
        return j16 | (bArr[i3] & 255);
    }

    public int readUnsignedInt24() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = i16 + 1;
        int i18 = ((bArr[i3] & 255) << 16) | ((bArr[i16] & 255) << 8);
        this.position = i17 + 1;
        return (bArr[i17] & 255) | i18;
    }

    public int readUnsignedIntToInt() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readInt);
    }

    public long readUnsignedLongToLong() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        throw new IllegalStateException("Top bit not zero: " + readLong);
    }

    public int readUnsignedShort() {
        byte[] bArr = this.data;
        int i3 = this.position;
        int i16 = i3 + 1;
        int i17 = (bArr[i3] & 255) << 8;
        this.position = i16 + 1;
        return (bArr[i16] & 255) | i17;
    }

    public long readUtf8EncodedLong() {
        int i3;
        int i16;
        long j3 = this.data[this.position];
        int i17 = 7;
        while (true) {
            if (i17 < 0) {
                break;
            }
            if (((1 << i17) & j3) != 0) {
                i17--;
            } else if (i17 < 6) {
                j3 &= r6 - 1;
                i16 = 7 - i17;
            } else if (i17 == 7) {
                i16 = 1;
            }
        }
        i16 = 0;
        if (i16 != 0) {
            for (i3 = 1; i3 < i16; i3++) {
                if ((this.data[this.position + i3] & 192) == 128) {
                    j3 = (j3 << 6) | (r3 & 63);
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j3);
                }
            }
            this.position += i16;
            return j3;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j3);
    }

    public void reset(int i3) {
        reset(capacity() < i3 ? new byte[i3] : this.data, i3);
    }

    public void setLimit(int i3) {
        boolean z16;
        if (i3 >= 0 && i3 <= this.data.length) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        this.limit = i3;
    }

    public void setPosition(int i3) {
        boolean z16;
        if (i3 >= 0 && i3 <= this.limit) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkArgument(z16);
        this.position = i3;
    }

    public void skipBytes(int i3) {
        setPosition(this.position + i3);
    }

    public ParsableByteArray(int i3) {
        this.data = new byte[i3];
        this.limit = i3;
    }

    public String readString(int i3, Charset charset) {
        String str = new String(this.data, this.position, i3, charset);
        this.position += i3;
        return str;
    }

    public void reset(byte[] bArr, int i3) {
        this.data = bArr;
        this.limit = i3;
        this.position = 0;
    }

    public void readBytes(byte[] bArr, int i3, int i16) {
        System.arraycopy(this.data, this.position, bArr, i3, i16);
        this.position += i16;
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public void readBytes(ByteBuffer byteBuffer, int i3) {
        byteBuffer.put(this.data, this.position, i3);
        this.position += i3;
    }

    public String readNullTerminatedString() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i3 = this.position;
        while (i3 < this.limit && this.data[i3] != 0) {
            i3++;
        }
        byte[] bArr = this.data;
        int i16 = this.position;
        String str = new String(bArr, i16, i3 - i16);
        this.position = i3;
        if (i3 < this.limit) {
            this.position = i3 + 1;
        }
        return str;
    }

    public void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public ParsableByteArray(byte[] bArr, int i3) {
        this.data = bArr;
        this.limit = i3;
    }
}
