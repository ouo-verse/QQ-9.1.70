package com.google.protobuf.nano;

import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CodedInputByteBufferNano {
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int bufferStart;
    private int lastTag;
    private int recursionDepth;
    private int currentLimit = Integer.MAX_VALUE;
    private int recursionLimit = 64;
    private int sizeLimit = 67108864;

    CodedInputByteBufferNano(byte[] bArr, int i3, int i16) {
        this.buffer = bArr;
        this.bufferStart = i3;
        this.bufferSize = i16 + i3;
        this.bufferPos = i3;
    }

    public static int decodeZigZag32(int i3) {
        return (-(i3 & 1)) ^ (i3 >>> 1);
    }

    public static long decodeZigZag64(long j3) {
        return (-(j3 & 1)) ^ (j3 >>> 1);
    }

    public static CodedInputByteBufferNano newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    private void recomputeBufferSizeAfterLimit() {
        int i3 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i3;
        int i16 = this.currentLimit;
        if (i3 > i16) {
            int i17 = i3 - i16;
            this.bufferSizeAfterLimit = i17;
            this.bufferSize = i3 - i17;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    public void checkLastTagWas(int i3) throws InvalidProtocolBufferNanoException {
        if (this.lastTag == i3) {
        } else {
            throw InvalidProtocolBufferNanoException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        int i3 = this.currentLimit;
        if (i3 == Integer.MAX_VALUE) {
            return -1;
        }
        return i3 - this.bufferPos;
    }

    public byte[] getData(int i3, int i16) {
        if (i16 == 0) {
            return WireFormatNano.EMPTY_BYTES;
        }
        byte[] bArr = new byte[i16];
        System.arraycopy(this.buffer, this.bufferStart + i3, bArr, 0, i16);
        return bArr;
    }

    public int getPosition() {
        return this.bufferPos - this.bufferStart;
    }

    public boolean isAtEnd() {
        if (this.bufferPos == this.bufferSize) {
            return true;
        }
        return false;
    }

    public void popLimit(int i3) {
        this.currentLimit = i3;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i3) throws InvalidProtocolBufferNanoException {
        if (i3 >= 0) {
            int i16 = i3 + this.bufferPos;
            int i17 = this.currentLimit;
            if (i16 <= i17) {
                this.currentLimit = i16;
                recomputeBufferSizeAfterLimit();
                return i17;
            }
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        throw InvalidProtocolBufferNanoException.negativeSize();
    }

    public boolean readBool() throws IOException {
        if (readRawVarint32() != 0) {
            return true;
        }
        return false;
    }

    public byte[] readBytes() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i3 = this.bufferSize;
        int i16 = this.bufferPos;
        if (readRawVarint32 <= i3 - i16 && readRawVarint32 > 0) {
            byte[] bArr = new byte[readRawVarint32];
            System.arraycopy(this.buffer, i16, bArr, 0, readRawVarint32);
            this.bufferPos += readRawVarint32;
            return bArr;
        }
        if (readRawVarint32 == 0) {
            return WireFormatNano.EMPTY_BYTES;
        }
        return readRawBytes(readRawVarint32);
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(MessageNano messageNano, int i3) throws IOException {
        int i16 = this.recursionDepth;
        if (i16 < this.recursionLimit) {
            this.recursionDepth = i16 + 1;
            messageNano.mergeFrom(this);
            checkLastTagWas(WireFormatNano.makeTag(i3, 4));
            this.recursionDepth--;
            return;
        }
        throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageNano messageNano) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            messageNano.mergeFrom(this);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferNanoException.recursionLimitExceeded();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object readPrimitiveField(int i3) throws IOException {
        switch (i3) {
            case 1:
                return Double.valueOf(readDouble());
            case 2:
                return Float.valueOf(readFloat());
            case 3:
                return Long.valueOf(readInt64());
            case 4:
                return Long.valueOf(readUInt64());
            case 5:
                return Integer.valueOf(readInt32());
            case 6:
                return Long.valueOf(readFixed64());
            case 7:
                return Integer.valueOf(readFixed32());
            case 8:
                return Boolean.valueOf(readBool());
            case 9:
                return readString();
            case 10:
            case 11:
            default:
                throw new IllegalArgumentException("Unknown type " + i3);
            case 12:
                return readBytes();
            case 13:
                return Integer.valueOf(readUInt32());
            case 14:
                return Integer.valueOf(readEnum());
            case 15:
                return Integer.valueOf(readSFixed32());
            case 16:
                return Long.valueOf(readSFixed64());
            case 17:
                return Integer.valueOf(readSInt32());
            case 18:
                return Long.valueOf(readSInt64());
        }
    }

    public byte readRawByte() throws IOException {
        int i3 = this.bufferPos;
        if (i3 != this.bufferSize) {
            byte[] bArr = this.buffer;
            this.bufferPos = i3 + 1;
            return bArr[i3];
        }
        throw InvalidProtocolBufferNanoException.truncatedMessage();
    }

    public byte[] readRawBytes(int i3) throws IOException {
        if (i3 >= 0) {
            int i16 = this.bufferPos;
            int i17 = i16 + i3;
            int i18 = this.currentLimit;
            if (i17 <= i18) {
                if (i3 <= this.bufferSize - i16) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.buffer, i16, bArr, 0, i3);
                    this.bufferPos += i3;
                    return bArr;
                }
                throw InvalidProtocolBufferNanoException.truncatedMessage();
            }
            skipRawBytes(i18 - i16);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        throw InvalidProtocolBufferNanoException.negativeSize();
    }

    public int readRawLittleEndian32() throws IOException {
        return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
    }

    public long readRawLittleEndian64() throws IOException {
        return ((readRawByte() & 255) << 8) | (readRawByte() & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
    }

    public int readRawVarint32() throws IOException {
        int i3;
        byte readRawByte = readRawByte();
        if (readRawByte >= 0) {
            return readRawByte;
        }
        int i16 = readRawByte & Byte.MAX_VALUE;
        byte readRawByte2 = readRawByte();
        if (readRawByte2 >= 0) {
            i3 = readRawByte2 << 7;
        } else {
            i16 |= (readRawByte2 & Byte.MAX_VALUE) << 7;
            byte readRawByte3 = readRawByte();
            if (readRawByte3 >= 0) {
                i3 = readRawByte3 << RegisterType.DOUBLE_LO;
            } else {
                i16 |= (readRawByte3 & Byte.MAX_VALUE) << 14;
                byte readRawByte4 = readRawByte();
                if (readRawByte4 >= 0) {
                    i3 = readRawByte4 << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER;
                } else {
                    int i17 = i16 | ((readRawByte4 & Byte.MAX_VALUE) << 21);
                    byte readRawByte5 = readRawByte();
                    int i18 = i17 | (readRawByte5 << 28);
                    if (readRawByte5 < 0) {
                        for (int i19 = 0; i19 < 5; i19++) {
                            if (readRawByte() >= 0) {
                                return i18;
                            }
                        }
                        throw InvalidProtocolBufferNanoException.malformedVarint();
                    }
                    return i18;
                }
            }
        }
        return i16 | i3;
    }

    public long readRawVarint64() throws IOException {
        long j3 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            j3 |= (r3 & Byte.MAX_VALUE) << i3;
            if ((readRawByte() & 128) == 0) {
                return j3;
            }
        }
        throw InvalidProtocolBufferNanoException.malformedVarint();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i3 = this.bufferSize;
        int i16 = this.bufferPos;
        if (readRawVarint32 <= i3 - i16 && readRawVarint32 > 0) {
            String str = new String(this.buffer, i16, readRawVarint32, InternalNano.UTF_8);
            this.bufferPos += readRawVarint32;
            return str;
        }
        return new String(readRawBytes(readRawVarint32), InternalNano.UTF_8);
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.lastTag = readRawVarint32;
        if (readRawVarint32 != 0) {
            return readRawVarint32;
        }
        throw InvalidProtocolBufferNanoException.invalidTag();
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public void rewindToPosition(int i3) {
        int i16 = this.bufferPos;
        int i17 = this.bufferStart;
        if (i3 <= i16 - i17) {
            if (i3 >= 0) {
                this.bufferPos = i17 + i3;
                return;
            }
            throw new IllegalArgumentException("Bad position " + i3);
        }
        throw new IllegalArgumentException("Position " + i3 + " is beyond current " + (this.bufferPos - this.bufferStart));
    }

    public int setRecursionLimit(int i3) {
        if (i3 >= 0) {
            int i16 = this.recursionLimit;
            this.recursionLimit = i3;
            return i16;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i3);
    }

    public int setSizeLimit(int i3) {
        if (i3 >= 0) {
            int i16 = this.sizeLimit;
            this.sizeLimit = i3;
            return i16;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i3);
    }

    public boolean skipField(int i3) throws IOException {
        int tagWireType = WireFormatNano.getTagWireType(i3);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType != 4) {
                            if (tagWireType == 5) {
                                readRawLittleEndian32();
                                return true;
                            }
                            throw InvalidProtocolBufferNanoException.invalidWireType();
                        }
                        return false;
                    }
                    skipMessage();
                    checkLastTagWas(WireFormatNano.makeTag(WireFormatNano.getTagFieldNumber(i3), 4));
                    return true;
                }
                skipRawBytes(readRawVarint32());
                return true;
            }
            readRawLittleEndian64();
            return true;
        }
        readInt32();
        return true;
    }

    public void skipMessage() throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag));
    }

    public void skipRawBytes(int i3) throws IOException {
        if (i3 >= 0) {
            int i16 = this.bufferPos;
            int i17 = i16 + i3;
            int i18 = this.currentLimit;
            if (i17 <= i18) {
                if (i3 <= this.bufferSize - i16) {
                    this.bufferPos = i16 + i3;
                    return;
                }
                throw InvalidProtocolBufferNanoException.truncatedMessage();
            }
            skipRawBytes(i18 - i16);
            throw InvalidProtocolBufferNanoException.truncatedMessage();
        }
        throw InvalidProtocolBufferNanoException.negativeSize();
    }

    public static CodedInputByteBufferNano newInstance(byte[] bArr, int i3, int i16) {
        return new CodedInputByteBufferNano(bArr, i3, i16);
    }

    public void resetSizeCounter() {
    }
}
