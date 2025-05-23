package kotlin.reflect.jvm.internal.impl.protobuf;

import cooperation.qzone.ShareElfFile;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int totalBytesWritten = 0;
    private int position = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.limit = bArr.length;
    }

    public static int computeBoolSize(int i3, boolean z16) {
        return computeTagSize(i3) + computeBoolSizeNoTag(z16);
    }

    public static int computeBoolSizeNoTag(boolean z16) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeBytesSize(int i3, ByteString byteString) {
        return computeTagSize(i3) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeRawVarint32Size(byteString.size()) + byteString.size();
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
        return computeInt32SizeNoTag(i3);
    }

    public static int computeFixed32SizeNoTag(int i3) {
        return 4;
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

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
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

    public static int computeInt64SizeNoTag(long j3) {
        return computeRawVarint64Size(j3);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        int serializedSize = lazyFieldLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeMessageSize(int i3, MessageLite messageLite) {
        return computeTagSize(i3) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computePreferredBufferSize(int i3) {
        if (i3 > 4096) {
            return 4096;
        }
        return i3;
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

    public static int computeSFixed32SizeNoTag(int i3) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j3) {
        return 8;
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

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e16) {
            throw new RuntimeException("UTF-8 not supported.", e16);
        }
    }

    public static int computeTagSize(int i3) {
        return computeRawVarint32Size(WireFormat.makeTag(i3, 0));
    }

    public static int computeUInt32SizeNoTag(int i3) {
        return computeRawVarint32Size(i3);
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

    public static CodedOutputStream newInstance(OutputStream outputStream, int i3) {
        return new CodedOutputStream(outputStream, new byte[i3]);
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

    public void flush() throws IOException {
        if (this.output != null) {
            refreshBuffer();
        }
    }

    public void writeBool(int i3, boolean z16) throws IOException {
        writeTag(i3, 0);
        writeBoolNoTag(z16);
    }

    public void writeBoolNoTag(boolean z16) throws IOException {
        writeRawByte(z16 ? 1 : 0);
    }

    public void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeBytes(int i3, ByteString byteString) throws IOException {
        writeTag(i3, 2);
        writeBytesNoTag(byteString);
    }

    public void writeBytesNoTag(ByteString byteString) throws IOException {
        writeRawVarint32(byteString.size());
        writeRawBytes(byteString);
    }

    public void writeDouble(int i3, double d16) throws IOException {
        writeTag(i3, 1);
        writeDoubleNoTag(d16);
    }

    public void writeDoubleNoTag(double d16) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(d16));
    }

    public void writeEnum(int i3, int i16) throws IOException {
        writeTag(i3, 0);
        writeEnumNoTag(i16);
    }

    public void writeEnumNoTag(int i3) throws IOException {
        writeInt32NoTag(i3);
    }

    public void writeFixed32NoTag(int i3) throws IOException {
        writeRawLittleEndian32(i3);
    }

    public void writeFixed64NoTag(long j3) throws IOException {
        writeRawLittleEndian64(j3);
    }

    public void writeFloat(int i3, float f16) throws IOException {
        writeTag(i3, 5);
        writeFloatNoTag(f16);
    }

    public void writeFloatNoTag(float f16) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(f16));
    }

    public void writeGroup(int i3, MessageLite messageLite) throws IOException {
        writeTag(i3, 3);
        writeGroupNoTag(messageLite);
        writeTag(i3, 4);
    }

    public void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
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

    public void writeInt64NoTag(long j3) throws IOException {
        writeRawVarint64(j3);
    }

    public void writeMessage(int i3, MessageLite messageLite) throws IOException {
        writeTag(i3, 2);
        writeMessageNoTag(messageLite);
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeMessageSetExtension(int i3, MessageLite messageLite) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i3);
        writeMessage(3, messageLite);
        writeTag(1, 4);
    }

    public void writeRawByte(byte b16) throws IOException {
        if (this.position == this.limit) {
            refreshBuffer();
        }
        byte[] bArr = this.buffer;
        int i3 = this.position;
        this.position = i3 + 1;
        bArr[i3] = b16;
        this.totalBytesWritten++;
    }

    public void writeRawBytes(ByteString byteString) throws IOException {
        writeRawBytes(byteString, 0, byteString.size());
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

    public void writeSFixed32NoTag(int i3) throws IOException {
        writeRawLittleEndian32(i3);
    }

    public void writeSFixed64NoTag(long j3) throws IOException {
        writeRawLittleEndian64(j3);
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

    public void writeStringNoTag(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i3, int i16) throws IOException {
        writeRawVarint32(WireFormat.makeTag(i3, i16));
    }

    public void writeUInt32(int i3, int i16) throws IOException {
        writeTag(i3, 0);
        writeUInt32NoTag(i16);
    }

    public void writeUInt32NoTag(int i3) throws IOException {
        writeRawVarint32(i3);
    }

    public void writeUInt64NoTag(long j3) throws IOException {
        writeRawVarint64(j3);
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i3, int i16) throws IOException {
        int i17 = this.limit;
        int i18 = this.position;
        if (i17 - i18 >= i16) {
            System.arraycopy(bArr, i3, this.buffer, i18, i16);
            this.position += i16;
            this.totalBytesWritten += i16;
            return;
        }
        int i19 = i17 - i18;
        System.arraycopy(bArr, i3, this.buffer, i18, i19);
        int i26 = i3 + i19;
        int i27 = i16 - i19;
        this.position = this.limit;
        this.totalBytesWritten += i19;
        refreshBuffer();
        if (i27 <= this.limit) {
            System.arraycopy(bArr, i26, this.buffer, 0, i27);
            this.position = i27;
        } else {
            this.output.write(bArr, i26, i27);
        }
        this.totalBytesWritten += i27;
    }

    public void writeRawByte(int i3) throws IOException {
        writeRawByte((byte) i3);
    }

    public void writeRawBytes(ByteString byteString, int i3, int i16) throws IOException {
        int i17 = this.limit;
        int i18 = this.position;
        if (i17 - i18 >= i16) {
            byteString.copyTo(this.buffer, i3, i18, i16);
            this.position += i16;
            this.totalBytesWritten += i16;
            return;
        }
        int i19 = i17 - i18;
        byteString.copyTo(this.buffer, i3, i18, i19);
        int i26 = i3 + i19;
        int i27 = i16 - i19;
        this.position = this.limit;
        this.totalBytesWritten += i19;
        refreshBuffer();
        if (i27 <= this.limit) {
            byteString.copyTo(this.buffer, i26, 0, i27);
            this.position = i27;
        } else {
            byteString.writeTo(this.output, i26, i27);
        }
        this.totalBytesWritten += i27;
    }
}
