package org.jf.dexlib2.writer;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nonnull;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexDataWriter extends BufferedOutputStream {
    private int filePosition;
    private byte[] tempBuf;
    private byte[] zeroBuf;

    public DexDataWriter(@Nonnull OutputStream outputStream, int i3) {
        this(outputStream, i3, 262144);
    }

    public static void writeInt(OutputStream outputStream, int i3) throws IOException {
        outputStream.write(i3);
        outputStream.write(i3 >> 8);
        outputStream.write(i3 >> 16);
        outputStream.write(i3 >> 24);
    }

    public static void writeSleb128(OutputStream outputStream, int i3) throws IOException {
        if (i3 >= 0) {
            while (i3 > 63) {
                outputStream.write((i3 & 127) | 128);
                i3 >>>= 7;
            }
            outputStream.write(i3 & 127);
            return;
        }
        while (i3 < -64) {
            outputStream.write((i3 & 127) | 128);
            i3 >>= 7;
        }
        outputStream.write(i3 & 127);
    }

    public static void writeUleb128(OutputStream outputStream, int i3) throws IOException {
        while ((i3 & 4294967295L) > 127) {
            outputStream.write((i3 & 127) | 128);
            i3 >>>= 7;
        }
        outputStream.write(i3);
    }

    public void align() throws IOException {
        int i3 = (-getPosition()) & 3;
        if (i3 > 0) {
            write(this.zeroBuf, 0, i3);
        }
    }

    public int getPosition() {
        return this.filePosition;
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) throws IOException {
        this.filePosition++;
        super.write(i3);
    }

    public void writeEncodedDouble(int i3, double d16) throws IOException {
        writeRightZeroExtendedLong(i3, Double.doubleToRawLongBits(d16));
    }

    public void writeEncodedFloat(int i3, float f16) throws IOException {
        writeRightZeroExtendedInt(i3, Float.floatToRawIntBits(f16));
    }

    public void writeEncodedInt(int i3, int i16) throws IOException {
        int i17 = 0;
        if (i16 >= 0) {
            while (i16 > 127) {
                this.tempBuf[i17] = (byte) i16;
                i16 >>= 8;
                i17++;
            }
        } else {
            while (i16 < -128) {
                this.tempBuf[i17] = (byte) i16;
                i16 >>= 8;
                i17++;
            }
        }
        int i18 = i17 + 1;
        this.tempBuf[i17] = (byte) i16;
        writeEncodedValueHeader(i3, i18 - 1);
        write(this.tempBuf, 0, i18);
    }

    public void writeEncodedLong(int i3, long j3) throws IOException {
        int i16;
        if (j3 >= 0) {
            i16 = 0;
            while (j3 > 127) {
                this.tempBuf[i16] = (byte) j3;
                j3 >>= 8;
                i16++;
            }
        } else {
            i16 = 0;
            while (j3 < -128) {
                this.tempBuf[i16] = (byte) j3;
                j3 >>= 8;
                i16++;
            }
        }
        int i17 = i16 + 1;
        this.tempBuf[i16] = (byte) j3;
        writeEncodedValueHeader(i3, i17 - 1);
        write(this.tempBuf, 0, i17);
    }

    public void writeEncodedUint(int i3, int i16) throws IOException {
        int i17 = 0;
        while (true) {
            int i18 = i17 + 1;
            this.tempBuf[i17] = (byte) i16;
            i16 >>>= 8;
            if (i16 == 0) {
                writeEncodedValueHeader(i3, i18 - 1);
                write(this.tempBuf, 0, i18);
                return;
            }
            i17 = i18;
        }
    }

    public void writeEncodedValueHeader(int i3, int i16) throws IOException {
        write(i3 | (i16 << 5));
    }

    public void writeLong(long j3) throws IOException {
        writeInt((int) j3);
        writeInt((int) (j3 >> 32));
    }

    protected void writeRightZeroExtendedInt(int i3, int i16) throws IOException {
        int i17 = 3;
        while (true) {
            int i18 = i17 - 1;
            this.tempBuf[i17] = (byte) (((-16777216) & i16) >>> 24);
            i16 <<= 8;
            if (i16 == 0) {
                int i19 = i18 + 1;
                int i26 = 4 - i19;
                writeEncodedValueHeader(i3, i26 - 1);
                write(this.tempBuf, i19, i26);
                return;
            }
            i17 = i18;
        }
    }

    protected void writeRightZeroExtendedLong(int i3, long j3) throws IOException {
        int i16 = 7;
        while (true) {
            int i17 = i16 - 1;
            this.tempBuf[i16] = (byte) (((-72057594037927936L) & j3) >>> 56);
            j3 <<= 8;
            if (j3 == 0) {
                int i18 = i17 + 1;
                int i19 = 8 - i18;
                writeEncodedValueHeader(i3, i19 - 1);
                write(this.tempBuf, i18, i19);
                return;
            }
            i16 = i17;
        }
    }

    public void writeShort(int i3) throws IOException {
        if (i3 >= -32768 && i3 <= 32767) {
            write(i3);
            write(i3 >> 8);
            return;
        }
        throw new ExceptionWithContext("Short value out of range: %d", Integer.valueOf(i3));
    }

    public void writeString(String str) throws IOException {
        int length = str.length();
        if (this.tempBuf.length <= str.length() * 3) {
            this.tempBuf = new byte[str.length() * 3];
        }
        byte[] bArr = this.tempBuf;
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            char charAt = str.charAt(i16);
            if (charAt != 0 && charAt < '\u0080') {
                bArr[i3] = (byte) charAt;
                i3++;
            } else if (charAt < '\u0800') {
                int i17 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 6) & 31) | 192);
                i3 = i17 + 1;
                bArr[i17] = (byte) ((charAt & '?') | 128);
            } else {
                int i18 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> '\f') & 15) | 224);
                int i19 = i18 + 1;
                bArr[i18] = (byte) (((charAt >> 6) & 63) | 128);
                bArr[i19] = (byte) ((charAt & '?') | 128);
                i3 = i19 + 1;
            }
        }
        write(bArr, 0, i3);
    }

    public void writeUbyte(int i3) throws IOException {
        if (i3 >= 0 && i3 <= 255) {
            write(i3);
            return;
        }
        throw new ExceptionWithContext("Unsigned byte value out of range: %d", Integer.valueOf(i3));
    }

    public void writeUshort(int i3) throws IOException {
        if (i3 >= 0 && i3 <= 65535) {
            write(i3);
            write(i3 >> 8);
            return;
        }
        throw new ExceptionWithContext("Unsigned short value out of range: %d", Integer.valueOf(i3));
    }

    public DexDataWriter(@Nonnull OutputStream outputStream, int i3, int i16) {
        super(outputStream, i16);
        this.tempBuf = new byte[8];
        this.zeroBuf = new byte[3];
        this.filePosition = i3;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void writeUleb128(int i3) throws IOException {
        writeUleb128(this, i3);
    }

    @Override // java.io.BufferedOutputStream, java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i16) throws IOException {
        this.filePosition += i16;
        super.write(bArr, i3, i16);
    }

    public void writeInt(int i3) throws IOException {
        writeInt(this, i3);
    }

    public void writeSleb128(int i3) throws IOException {
        writeSleb128(this, i3);
    }
}
