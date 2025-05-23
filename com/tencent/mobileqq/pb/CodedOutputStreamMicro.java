package com.tencent.mobileqq.pb;

import cooperation.qzone.ShareElfFile;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class CodedOutputStreamMicro {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int position;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    CodedOutputStreamMicro(OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.position = 0;
        this.limit = bArr.length;
    }

    public static int computeBoolSize(int i3, boolean z16) {
        return computeTagSize(i3) + computeBoolSizeNoTag(z16);
    }

    public static int computeBoolSizeNoTag(boolean z16) {
        return 1;
    }

    public static int computeByteArraySize(int i3, byte[] bArr) {
        return computeTagSize(i3) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeBytesSize(int i3, ByteStringMicro byteStringMicro) {
        return computeTagSize(i3) + computeBytesSizeNoTag(byteStringMicro);
    }

    public static int computeBytesSizeNoTag(ByteStringMicro byteStringMicro) {
        return computeRawVarint32Size(byteStringMicro.size()) + byteStringMicro.size();
    }

    public static int computeDoubleSize(int i3, double d16) {
        return computeTagSize(i3) + computeDoubleSizeNoTag(d16);
    }

    public static int computeDoubleSizeNoTag(double d16) {
        return 8;
    }

    public static int computeEnumSize(int i3, int i16) {
        return computeTagSize(i3) + computeEnumSizeNoTag(i16);
    }

    public static int computeEnumSizeNoTag(int i3) {
        return computeRawVarint32Size(i3);
    }

    public static int computeFixed32Size(int i3, int i16) {
        return computeTagSize(i3) + computeFixed32SizeNoTag(i16);
    }

    public static int computeFixed32SizeNoTag(int i3) {
        return 4;
    }

    public static int computeFixed64Size(int i3, long j3) {
        return computeTagSize(i3) + computeFixed64SizeNoTag(j3);
    }

    public static int computeFixed64SizeNoTag(long j3) {
        return 8;
    }

    public static int computeFloatSize(int i3, float f16) {
        return computeTagSize(i3) + computeFloatSizeNoTag(f16);
    }

    public static int computeFloatSizeNoTag(float f16) {
        return 4;
    }

    public static int computeGroupSize(int i3, MessageMicro<?> messageMicro) {
        return (computeTagSize(i3) * 2) + computeGroupSizeNoTag(messageMicro);
    }

    public static int computeGroupSizeNoTag(MessageMicro<?> messageMicro) {
        return messageMicro.getCachedSize();
    }

    public static int computeInt32Size(int i3, int i16) {
        return computeTagSize(i3) + computeInt32SizeNoTag(i16);
    }

    public static int computeInt32SizeNoTag(int i3) {
        if (i3 >= 0) {
            return computeRawVarint32Size(i3);
        }
        return 10;
    }

    public static int computeInt64Size(int i3, long j3) {
        return computeTagSize(i3) + computeInt64SizeNoTag(j3);
    }

    public static int computeInt64SizeNoTag(long j3) {
        return computeRawVarint64Size(j3);
    }

    public static int computeMessageSize(int i3, MessageMicro<?> messageMicro) {
        return computeTagSize(i3) + computeMessageSizeNoTag(messageMicro);
    }

    public static int computeMessageSizeNoTag(MessageMicro<?> messageMicro) {
        int cachedSize = messageMicro.getCachedSize();
        return computeRawVarint32Size(cachedSize) + cachedSize;
    }

    public static int computeRawVarint32Size(int i3) {
        if ((i3 & (-128)) == 0) {
            return 1;
        }
        if ((i3 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i3) == 0) {
            return 3;
        }
        if ((i3 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) {
            return 4;
        }
        return 5;
    }

    public static int computeRawVarint64Size(long j3) {
        if (((-128) & j3) == 0) {
            return 1;
        }
        if (((-16384) & j3) == 0) {
            return 2;
        }
        if (((-2097152) & j3) == 0) {
            return 3;
        }
        if (((-268435456) & j3) == 0) {
            return 4;
        }
        if (((-34359738368L) & j3) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j3) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j3) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j3) == 0) {
            return 8;
        }
        if ((j3 & Long.MIN_VALUE) == 0) {
            return 9;
        }
        return 10;
    }

    public static int computeSFixed32Size(int i3, int i16) {
        return computeTagSize(i3) + computeSFixed32SizeNoTag(i16);
    }

    public static int computeSFixed32SizeNoTag(int i3) {
        return 4;
    }

    public static int computeSFixed64Size(int i3, long j3) {
        return computeTagSize(i3) + computeSFixed64SizeNoTag(j3);
    }

    public static int computeSFixed64SizeNoTag(long j3) {
        return 8;
    }

    public static int computeSInt32Size(int i3, int i16) {
        return computeTagSize(i3) + computeSInt32SizeNoTag(i16);
    }

    public static int computeSInt32SizeNoTag(int i3) {
        return computeRawVarint32Size(encodeZigZag32(i3));
    }

    public static int computeSInt64Size(int i3, long j3) {
        return computeTagSize(i3) + computeSInt64SizeNoTag(j3);
    }

    public static int computeSInt64SizeNoTag(long j3) {
        return computeRawVarint64Size(encodeZigZag64(j3));
    }

    public static int computeStringSize(int i3, String str) {
        return computeTagSize(i3) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int computeTagSize(int i3) {
        return computeRawVarint32Size(WireFormatMicro.makeTag(i3, 0));
    }

    public static int computeUInt32Size(int i3, int i16) {
        return computeTagSize(i3) + computeUInt32SizeNoTag(i16);
    }

    public static int computeUInt32SizeNoTag(int i3) {
        return computeRawVarint32Size(i3);
    }

    public static int computeUInt64Size(int i3, long j3) {
        return computeTagSize(i3) + computeUInt64SizeNoTag(j3);
    }

    public static int computeUInt64SizeNoTag(long j3) {
        return computeRawVarint64Size(j3);
    }

    public static int encodeZigZag32(int i3) {
        return (i3 >> 31) ^ (i3 << 1);
    }

    public static long encodeZigZag64(long j3) {
        return (j3 >> 63) ^ (j3 << 1);
    }

    public static CodedOutputStreamMicro newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    private void refreshBuffer() throws IOException {
        OutputStream outputStream = this.output;
        if (outputStream != null) {
            outputStream.write(this.buffer, 0, this.position);
            this.position = 0;
            return;
        }
        throw new OutOfSpaceException();
    }

    public void checkNoSpaceLeft() {
        if (spaceLeft() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void flush() throws IOException {
        if (this.output != null) {
            refreshBuffer();
        }
    }

    public int spaceLeft() {
        if (this.output == null) {
            return this.limit - this.position;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void writeBool(int i3, boolean z16) throws IOException {
        writeTag(i3, 0);
        writeBoolNoTag(z16);
    }

    public void writeBoolNoTag(boolean z16) throws IOException {
        writeRawByte(z16 ? 1 : 0);
    }

    public void writeByteArray(int i3, byte[] bArr) throws IOException {
        writeTag(i3, 2);
        writeByteArrayNoTag(bArr);
    }

    public void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeBytes(int i3, ByteStringMicro byteStringMicro) throws IOException {
        writeTag(i3, 2);
        writeBytesNoTag(byteStringMicro);
    }

    public void writeBytesNoTag(ByteStringMicro byteStringMicro) throws IOException {
        byte[] byteArray = byteStringMicro.toByteArray();
        writeRawVarint32(byteArray.length);
        writeRawBytes(byteArray);
    }

    public void writeDouble(int i3, double d16) throws IOException {
        writeTag(i3, 1);
        writeDoubleNoTag(d16);
    }

    public void writeDoubleNoTag(double d16) throws IOException {
        writeRawLittleEndian64(Double.doubleToLongBits(d16));
    }

    public void writeEnum(int i3, int i16) throws IOException {
        writeTag(i3, 0);
        writeEnumNoTag(i16);
    }

    public void writeEnumNoTag(int i3) throws IOException {
        writeRawVarint32(i3);
    }

    public void writeFixed32(int i3, int i16) throws IOException {
        writeTag(i3, 5);
        writeFixed32NoTag(i16);
    }

    public void writeFixed32NoTag(int i3) throws IOException {
        writeRawLittleEndian32(i3);
    }

    public void writeFixed64(int i3, long j3) throws IOException {
        writeTag(i3, 1);
        writeFixed64NoTag(j3);
    }

    public void writeFixed64NoTag(long j3) throws IOException {
        writeRawLittleEndian64(j3);
    }

    public void writeFloat(int i3, float f16) throws IOException {
        writeTag(i3, 5);
        writeFloatNoTag(f16);
    }

    public void writeFloatNoTag(float f16) throws IOException {
        writeRawLittleEndian32(Float.floatToIntBits(f16));
    }

    public void writeGroup(int i3, MessageMicro<?> messageMicro) throws IOException {
        writeTag(i3, 3);
        writeGroupNoTag(messageMicro);
        writeTag(i3, 4);
    }

    public void writeGroupNoTag(MessageMicro<?> messageMicro) throws IOException {
        messageMicro.writeTo(this);
    }

    public void writeInt32(int i3, int i16) throws IOException {
        writeTag(i3, 0);
        writeInt32NoTag(i16);
    }

    public void writeInt32NoTag(int i3) throws IOException {
        if (i3 >= 0) {
            writeRawVarint32(i3);
        } else {
            writeRawVarint64(i3);
        }
    }

    public void writeInt64(int i3, long j3) throws IOException {
        writeTag(i3, 0);
        writeInt64NoTag(j3);
    }

    public void writeInt64NoTag(long j3) throws IOException {
        writeRawVarint64(j3);
    }

    public void writeMessage(int i3, MessageMicro<?> messageMicro) throws IOException {
        writeTag(i3, 2);
        writeMessageNoTag(messageMicro);
    }

    public void writeMessageNoTag(MessageMicro<?> messageMicro) throws IOException {
        writeRawVarint32(messageMicro.getCachedSize());
        messageMicro.writeTo(this);
    }

    public void writeRawByte(byte b16) throws IOException {
        if (this.position == this.limit) {
            refreshBuffer();
        }
        byte[] bArr = this.buffer;
        int i3 = this.position;
        this.position = i3 + 1;
        bArr[i3] = b16;
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawLittleEndian32(int i3) throws IOException {
        writeRawByte(i3 & 255);
        writeRawByte((i3 >> 8) & 255);
        writeRawByte((i3 >> 16) & 255);
        writeRawByte((i3 >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j3) throws IOException {
        writeRawByte(((int) j3) & 255);
        writeRawByte(((int) (j3 >> 8)) & 255);
        writeRawByte(((int) (j3 >> 16)) & 255);
        writeRawByte(((int) (j3 >> 24)) & 255);
        writeRawByte(((int) (j3 >> 32)) & 255);
        writeRawByte(((int) (j3 >> 40)) & 255);
        writeRawByte(((int) (j3 >> 48)) & 255);
        writeRawByte(((int) (j3 >> 56)) & 255);
    }

    public void writeRawVarint32(int i3) throws IOException {
        while ((i3 & (-128)) != 0) {
            writeRawByte((i3 & 127) | 128);
            i3 >>>= 7;
        }
        writeRawByte(i3);
    }

    public void writeRawVarint64(long j3) throws IOException {
        while (((-128) & j3) != 0) {
            writeRawByte((((int) j3) & 127) | 128);
            j3 >>>= 7;
        }
        writeRawByte((int) j3);
    }

    public void writeSFixed32(int i3, int i16) throws IOException {
        writeTag(i3, 5);
        writeSFixed32NoTag(i16);
    }

    public void writeSFixed32NoTag(int i3) throws IOException {
        writeRawLittleEndian32(i3);
    }

    public void writeSFixed64(int i3, long j3) throws IOException {
        writeTag(i3, 1);
        writeSFixed64NoTag(j3);
    }

    public void writeSFixed64NoTag(long j3) throws IOException {
        writeRawLittleEndian64(j3);
    }

    public void writeSInt32(int i3, int i16) throws IOException {
        writeTag(i3, 0);
        writeSInt32NoTag(i16);
    }

    public void writeSInt32NoTag(int i3) throws IOException {
        writeRawVarint32(encodeZigZag32(i3));
    }

    public void writeSInt64(int i3, long j3) throws IOException {
        writeTag(i3, 0);
        writeSInt64NoTag(j3);
    }

    public void writeSInt64NoTag(long j3) throws IOException {
        writeRawVarint64(encodeZigZag64(j3));
    }

    public void writeString(int i3, String str) throws IOException {
        writeTag(i3, 2);
        writeStringNoTag(str);
    }

    public void writeStringNoTag(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i3, int i16) throws IOException {
        writeRawVarint32(WireFormatMicro.makeTag(i3, i16));
    }

    public void writeUInt32(int i3, int i16) throws IOException {
        writeTag(i3, 0);
        writeUInt32NoTag(i16);
    }

    public void writeUInt32NoTag(int i3) throws IOException {
        writeRawVarint32(i3);
    }

    public void writeUInt64(int i3, long j3) throws IOException {
        writeTag(i3, 0);
        writeUInt64NoTag(j3);
    }

    public void writeUInt64NoTag(long j3) throws IOException {
        writeRawVarint64(j3);
    }

    CodedOutputStreamMicro(byte[] bArr, int i3, int i16) {
        this.output = null;
        this.buffer = bArr;
        this.position = i3;
        this.limit = i3 + i16;
    }

    public static CodedOutputStreamMicro newInstance(OutputStream outputStream, int i3) {
        return new CodedOutputStreamMicro(outputStream, new byte[i3]);
    }

    public void writeRawByte(int i3) throws IOException {
        writeRawByte((byte) i3);
    }

    public void writeRawBytes(byte[] bArr, int i3, int i16) throws IOException {
        int i17 = this.limit;
        int i18 = this.position;
        if (i17 - i18 >= i16) {
            System.arraycopy(bArr, i3, this.buffer, i18, i16);
            this.position += i16;
            return;
        }
        int i19 = i17 - i18;
        System.arraycopy(bArr, i3, this.buffer, i18, i19);
        int i26 = i3 + i19;
        int i27 = i16 - i19;
        this.position = this.limit;
        refreshBuffer();
        if (i27 > this.limit) {
            this.output.write(bArr, i26, i27);
        } else {
            System.arraycopy(bArr, i26, this.buffer, 0, i27);
            this.position = i27;
        }
    }

    public static CodedOutputStreamMicro newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedOutputStreamMicro newInstance(byte[] bArr, int i3, int i16) {
        return new CodedOutputStreamMicro(bArr, i3, i16);
    }
}
