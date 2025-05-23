package com.google.protobuf.nano;

import cooperation.qzone.ShareElfFile;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CodedOutputByteBufferNano {
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final int LITTLE_ENDIAN_64_SIZE = 8;
    private static final int MAX_UTF8_EXPANSION = 3;
    private final ByteBuffer buffer;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException(int i3, int i16) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i3 + " limit " + i16 + ").");
        }
    }

    CodedOutputByteBufferNano(byte[] bArr, int i3, int i16) {
        this(ByteBuffer.wrap(bArr, i3, i16));
    }

    public static int computeBoolSize(int i3, boolean z16) {
        return computeTagSize(i3) + computeBoolSizeNoTag(z16);
    }

    public static int computeBoolSizeNoTag(boolean z16) {
        return 1;
    }

    public static int computeBytesSize(int i3, byte[] bArr) {
        return computeTagSize(i3) + computeBytesSizeNoTag(bArr);
    }

    public static int computeBytesSizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeFieldSize(int i3, int i16, Object obj) {
        switch (i16) {
            case 1:
                return computeDoubleSize(i3, ((Double) obj).doubleValue());
            case 2:
                return computeFloatSize(i3, ((Float) obj).floatValue());
            case 3:
                return computeInt64Size(i3, ((Long) obj).longValue());
            case 4:
                return computeUInt64Size(i3, ((Long) obj).longValue());
            case 5:
                return computeInt32Size(i3, ((Integer) obj).intValue());
            case 6:
                return computeFixed64Size(i3, ((Long) obj).longValue());
            case 7:
                return computeFixed32Size(i3, ((Integer) obj).intValue());
            case 8:
                return computeBoolSize(i3, ((Boolean) obj).booleanValue());
            case 9:
                return computeStringSize(i3, (String) obj);
            case 10:
                return computeGroupSize(i3, (MessageNano) obj);
            case 11:
                return computeMessageSize(i3, (MessageNano) obj);
            case 12:
                return computeBytesSize(i3, (byte[]) obj);
            case 13:
                return computeUInt32Size(i3, ((Integer) obj).intValue());
            case 14:
                return computeEnumSize(i3, ((Integer) obj).intValue());
            case 15:
                return computeSFixed32Size(i3, ((Integer) obj).intValue());
            case 16:
                return computeSFixed64Size(i3, ((Long) obj).longValue());
            case 17:
                return computeSInt32Size(i3, ((Integer) obj).intValue());
            case 18:
                return computeSInt64Size(i3, ((Long) obj).longValue());
            default:
                throw new IllegalArgumentException("Unknown type: " + i16);
        }
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

    public static int computeGroupSize(int i3, MessageNano messageNano) {
        return (computeTagSize(i3) * 2) + computeGroupSizeNoTag(messageNano);
    }

    public static int computeGroupSizeNoTag(MessageNano messageNano) {
        return messageNano.getSerializedSize();
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

    public static int computeMessageSize(int i3, MessageNano messageNano) {
        return computeTagSize(i3) + computeMessageSizeNoTag(messageNano);
    }

    public static int computeMessageSizeNoTag(MessageNano messageNano) {
        int serializedSize = messageNano.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
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
        int encodedLength = encodedLength(str);
        return computeRawVarint32Size(encodedLength) + encodedLength;
    }

    public static int computeTagSize(int i3) {
        return computeRawVarint32Size(WireFormatNano.makeTag(i3, 0));
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

    private static void encode(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.isReadOnly()) {
            if (byteBuffer.hasArray()) {
                try {
                    byteBuffer.position(encode(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
                    return;
                } catch (ArrayIndexOutOfBoundsException e16) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e16);
                    throw bufferOverflowException;
                }
            }
            encodeDirect(charSequence, byteBuffer);
            return;
        }
        throw new ReadOnlyBufferException();
    }

    private static void encodeDirect(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < '\u0080') {
                byteBuffer.put((byte) charAt);
            } else if (charAt < '\u0800') {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else {
                if (charAt >= '\ud800' && '\udfff' >= charAt) {
                    int i16 = i3 + 1;
                    if (i16 != charSequence.length()) {
                        char charAt2 = charSequence.charAt(i16);
                        if (Character.isSurrogatePair(charAt, charAt2)) {
                            int codePoint = Character.toCodePoint(charAt, charAt2);
                            byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint & 63) | 128));
                            i3 = i16;
                        } else {
                            i3 = i16;
                        }
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Unpaired surrogate at index ");
                    sb5.append(i3 - 1);
                    throw new IllegalArgumentException(sb5.toString());
                }
                byteBuffer.put((byte) ((charAt >>> '\f') | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            }
            i3++;
        }
    }

    public static int encodeZigZag32(int i3) {
        return (i3 >> 31) ^ (i3 << 1);
    }

    public static long encodeZigZag64(long j3) {
        return (j3 >> 63) ^ (j3 << 1);
    }

    private static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < '\u0080') {
            i3++;
        }
        int i16 = length;
        while (true) {
            if (i3 < length) {
                char charAt = charSequence.charAt(i3);
                if (charAt < '\u0800') {
                    i16 += ('\u007f' - charAt) >>> 31;
                    i3++;
                } else {
                    i16 += encodedLengthGeneral(charSequence, i3);
                    break;
                }
            } else {
                break;
            }
        }
        if (i16 >= length) {
            return i16;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i16 + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i16 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < '\u0800') {
                i16 += ('\u007f' - charAt) >>> 31;
            } else {
                i16 += 2;
                if ('\ud800' <= charAt && charAt <= '\udfff') {
                    if (Character.codePointAt(charSequence, i3) >= 65536) {
                        i3++;
                    } else {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i3);
                    }
                }
            }
            i3++;
        }
        return i16;
    }

    public static CodedOutputByteBufferNano newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public void checkNoSpaceLeft() {
        if (spaceLeft() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public int position() {
        return this.buffer.position();
    }

    public void reset() {
        this.buffer.clear();
    }

    public int spaceLeft() {
        return this.buffer.remaining();
    }

    public void writeBool(int i3, boolean z16) throws IOException {
        writeTag(i3, 0);
        writeBoolNoTag(z16);
    }

    public void writeBoolNoTag(boolean z16) throws IOException {
        writeRawByte(z16 ? 1 : 0);
    }

    public void writeBytes(int i3, byte[] bArr) throws IOException {
        writeTag(i3, 2);
        writeBytesNoTag(bArr);
    }

    public void writeBytesNoTag(byte[] bArr) throws IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeField(int i3, int i16, Object obj) throws IOException {
        switch (i16) {
            case 1:
                writeDouble(i3, ((Double) obj).doubleValue());
                return;
            case 2:
                writeFloat(i3, ((Float) obj).floatValue());
                return;
            case 3:
                writeInt64(i3, ((Long) obj).longValue());
                return;
            case 4:
                writeUInt64(i3, ((Long) obj).longValue());
                return;
            case 5:
                writeInt32(i3, ((Integer) obj).intValue());
                return;
            case 6:
                writeFixed64(i3, ((Long) obj).longValue());
                return;
            case 7:
                writeFixed32(i3, ((Integer) obj).intValue());
                return;
            case 8:
                writeBool(i3, ((Boolean) obj).booleanValue());
                return;
            case 9:
                writeString(i3, (String) obj);
                return;
            case 10:
                writeGroup(i3, (MessageNano) obj);
                return;
            case 11:
                writeMessage(i3, (MessageNano) obj);
                return;
            case 12:
                writeBytes(i3, (byte[]) obj);
                return;
            case 13:
                writeUInt32(i3, ((Integer) obj).intValue());
                return;
            case 14:
                writeEnum(i3, ((Integer) obj).intValue());
                return;
            case 15:
                writeSFixed32(i3, ((Integer) obj).intValue());
                return;
            case 16:
                writeSFixed64(i3, ((Long) obj).longValue());
                return;
            case 17:
                writeSInt32(i3, ((Integer) obj).intValue());
                return;
            case 18:
                writeSInt64(i3, ((Long) obj).longValue());
                return;
            default:
                throw new IOException("Unknown type: " + i16);
        }
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

    public void writeGroup(int i3, MessageNano messageNano) throws IOException {
        writeTag(i3, 3);
        writeGroupNoTag(messageNano);
        writeTag(i3, 4);
    }

    public void writeGroupNoTag(MessageNano messageNano) throws IOException {
        messageNano.writeTo(this);
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

    public void writeMessage(int i3, MessageNano messageNano) throws IOException {
        writeTag(i3, 2);
        writeMessageNoTag(messageNano);
    }

    public void writeMessageNoTag(MessageNano messageNano) throws IOException {
        writeRawVarint32(messageNano.getCachedSize());
        messageNano.writeTo(this);
    }

    public void writeRawByte(byte b16) throws IOException {
        if (this.buffer.hasRemaining()) {
            this.buffer.put(b16);
            return;
        }
        throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawLittleEndian32(int i3) throws IOException {
        if (this.buffer.remaining() >= 4) {
            this.buffer.putInt(i3);
            return;
        }
        throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    }

    public void writeRawLittleEndian64(long j3) throws IOException {
        if (this.buffer.remaining() >= 8) {
            this.buffer.putLong(j3);
            return;
        }
        throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
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
        try {
            int computeRawVarint32Size = computeRawVarint32Size(str.length());
            if (computeRawVarint32Size == computeRawVarint32Size(str.length() * 3)) {
                int position = this.buffer.position();
                if (this.buffer.remaining() >= computeRawVarint32Size) {
                    this.buffer.position(position + computeRawVarint32Size);
                    encode(str, this.buffer);
                    int position2 = this.buffer.position();
                    this.buffer.position(position);
                    writeRawVarint32((position2 - position) - computeRawVarint32Size);
                    this.buffer.position(position2);
                    return;
                }
                throw new OutOfSpaceException(position + computeRawVarint32Size, this.buffer.limit());
            }
            writeRawVarint32(encodedLength(str));
            encode(str, this.buffer);
        } catch (BufferOverflowException e16) {
            OutOfSpaceException outOfSpaceException = new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
            outOfSpaceException.initCause(e16);
            throw outOfSpaceException;
        }
    }

    public void writeTag(int i3, int i16) throws IOException {
        writeRawVarint32(WireFormatNano.makeTag(i3, i16));
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

    CodedOutputByteBufferNano(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static CodedOutputByteBufferNano newInstance(byte[] bArr, int i3, int i16) {
        return new CodedOutputByteBufferNano(bArr, i3, i16);
    }

    public void writeRawBytes(byte[] bArr, int i3, int i16) throws IOException {
        if (this.buffer.remaining() >= i16) {
            this.buffer.put(bArr, i3, i16);
            return;
        }
        throw new OutOfSpaceException(this.buffer.position(), this.buffer.limit());
    }

    public void writeRawByte(int i3) throws IOException {
        writeRawByte((byte) i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r8 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int encode(CharSequence charSequence, byte[] bArr, int i3, int i16) {
        int i17;
        int i18;
        char charAt;
        int length = charSequence.length();
        int i19 = i16 + i3;
        int i26 = 0;
        while (i26 < length && (i18 = i26 + i3) < i19 && (charAt = charSequence.charAt(i26)) < '\u0080') {
            bArr[i18] = (byte) charAt;
            i26++;
        }
        int i27 = i3 + i26;
        while (i26 < length) {
            char charAt2 = charSequence.charAt(i26);
            if (charAt2 >= '\u0080' || i27 >= i19) {
                if (charAt2 < '\u0800' && i27 <= i19 - 2) {
                    int i28 = i27 + 1;
                    bArr[i27] = (byte) ((charAt2 >>> 6) | 960);
                    i27 = i28 + 1;
                    bArr[i28] = (byte) ((charAt2 & '?') | 128);
                } else {
                    if ((charAt2 >= '\ud800' && '\udfff' >= charAt2) || i27 > i19 - 3) {
                        if (i27 <= i19 - 4) {
                            int i29 = i26 + 1;
                            if (i29 != charSequence.length()) {
                                char charAt3 = charSequence.charAt(i29);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    int i36 = i27 + 1;
                                    bArr[i27] = (byte) ((codePoint >>> 18) | 240);
                                    int i37 = i36 + 1;
                                    bArr[i36] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i38 = i37 + 1;
                                    bArr[i37] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i27 = i38 + 1;
                                    bArr[i38] = (byte) ((codePoint & 63) | 128);
                                    i26 = i29;
                                } else {
                                    i26 = i29;
                                }
                            }
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Unpaired surrogate at index ");
                            sb5.append(i26 - 1);
                            throw new IllegalArgumentException(sb5.toString());
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i27);
                    }
                    int i39 = i27 + 1;
                    bArr[i27] = (byte) ((charAt2 >>> '\f') | 480);
                    int i46 = i39 + 1;
                    bArr[i39] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i17 = i46 + 1;
                    bArr[i46] = (byte) ((charAt2 & '?') | 128);
                }
                i26++;
            } else {
                i17 = i27 + 1;
                bArr[i27] = (byte) charAt2;
            }
            i27 = i17;
            i26++;
        }
        return i27;
    }
}
