package com.tencent.mobileqq.pb;

import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class CodedInputStreamMicro {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private int sizeLimit;
    private int totalBytesRetired;

    CodedInputStreamMicro(InputStream inputStream) {
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.input = inputStream;
    }

    public static int decodeZigZag32(int i3) {
        return (-(i3 & 1)) ^ (i3 >>> 1);
    }

    public static long decodeZigZag64(long j3) {
        return (-(j3 & 1)) ^ (j3 >>> 1);
    }

    public static CodedInputStreamMicro newInstance(InputStream inputStream) {
        return new CodedInputStreamMicro(inputStream);
    }

    private void recomputeBufferSizeAfterLimit() {
        int i3 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i3;
        int i16 = this.totalBytesRetired + i3;
        int i17 = this.currentLimit;
        if (i16 > i17) {
            int i18 = i16 - i17;
            this.bufferSizeAfterLimit = i18;
            this.bufferSize = i3 - i18;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    private boolean refillBuffer(boolean z16) throws IOException {
        int read;
        int i3 = this.bufferPos;
        int i16 = this.bufferSize;
        if (i3 >= i16) {
            int i17 = this.totalBytesRetired;
            if (i17 + i16 == this.currentLimit) {
                if (!z16) {
                    return false;
                }
                throw InvalidProtocolBufferMicroException.truncatedMessage();
            }
            this.totalBytesRetired = i17 + i16;
            this.bufferPos = 0;
            InputStream inputStream = this.input;
            if (inputStream == null) {
                read = -1;
            } else {
                read = inputStream.read(this.buffer);
            }
            this.bufferSize = read;
            if (read != 0 && read >= -1) {
                if (read == -1) {
                    this.bufferSize = 0;
                    if (!z16) {
                        return false;
                    }
                    throw InvalidProtocolBufferMicroException.truncatedMessage();
                }
                recomputeBufferSizeAfterLimit();
                int i18 = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
                if (i18 <= this.sizeLimit && i18 >= 0) {
                    return true;
                }
                throw InvalidProtocolBufferMicroException.sizeLimitExceeded();
            }
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.bufferSize + "\nThe InputStream implementation is buggy.");
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    public void checkLastTagWas(int i3) throws InvalidProtocolBufferMicroException {
        if (this.lastTag == i3) {
        } else {
            throw InvalidProtocolBufferMicroException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        int i3 = this.currentLimit;
        if (i3 == Integer.MAX_VALUE) {
            return -1;
        }
        return i3 - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        if (this.bufferPos != this.bufferSize || refillBuffer(false)) {
            return false;
        }
        return true;
    }

    public void popLimit(int i3) {
        this.currentLimit = i3;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i3) throws InvalidProtocolBufferMicroException {
        if (i3 >= 0) {
            int i16 = i3 + this.totalBytesRetired + this.bufferPos;
            int i17 = this.currentLimit;
            if (i16 <= i17) {
                this.currentLimit = i16;
                recomputeBufferSizeAfterLimit();
                return i17;
            }
            throw InvalidProtocolBufferMicroException.truncatedMessage();
        }
        throw InvalidProtocolBufferMicroException.negativeSize();
    }

    public boolean readBool() throws IOException {
        if (readRawVarint32() != 0) {
            return true;
        }
        return false;
    }

    public ByteStringMicro readBytes() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i3 = this.bufferSize;
        int i16 = this.bufferPos;
        if (readRawVarint32 <= i3 - i16 && readRawVarint32 > 0) {
            ByteStringMicro copyFrom = ByteStringMicro.copyFrom(this.buffer, i16, readRawVarint32);
            this.bufferPos += readRawVarint32;
            return copyFrom;
        }
        return ByteStringMicro.copyFrom(readRawBytes(readRawVarint32));
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

    public void readGroup(MessageMicro<?> messageMicro, int i3) throws IOException {
        int i16 = this.recursionDepth;
        if (i16 < this.recursionLimit) {
            this.recursionDepth = i16 + 1;
            messageMicro.mergeFrom(this);
            checkLastTagWas(WireFormatMicro.makeTag(i3, 4));
            this.recursionDepth--;
            return;
        }
        throw InvalidProtocolBufferMicroException.recursionLimitExceeded();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageMicro<?> messageMicro) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            messageMicro.mergeFrom(this);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferMicroException.recursionLimitExceeded();
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(true);
        }
        byte[] bArr = this.buffer;
        int i3 = this.bufferPos;
        this.bufferPos = i3 + 1;
        return bArr[i3];
    }

    public byte[] readRawBytes(int i3) throws IOException {
        int read;
        if (i3 >= 0) {
            int i16 = this.totalBytesRetired;
            int i17 = this.bufferPos;
            int i18 = i16 + i17 + i3;
            int i19 = this.currentLimit;
            if (i18 <= i19) {
                int i26 = this.bufferSize;
                if (i3 <= i26 - i17) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.buffer, i17, bArr, 0, i3);
                    this.bufferPos += i3;
                    return bArr;
                }
                if (i3 < 4096) {
                    byte[] bArr2 = new byte[i3];
                    int i27 = i26 - i17;
                    System.arraycopy(this.buffer, i17, bArr2, 0, i27);
                    this.bufferPos = this.bufferSize;
                    while (true) {
                        refillBuffer(true);
                        int i28 = i3 - i27;
                        int i29 = this.bufferSize;
                        if (i28 <= i29) {
                            System.arraycopy(this.buffer, 0, bArr2, i27, i28);
                            this.bufferPos = i28;
                            return bArr2;
                        }
                        System.arraycopy(this.buffer, 0, bArr2, i27, i29);
                        int i36 = this.bufferSize;
                        i27 += i36;
                        this.bufferPos = i36;
                    }
                } else {
                    this.totalBytesRetired = i16 + i26;
                    this.bufferPos = 0;
                    this.bufferSize = 0;
                    int i37 = i26 - i17;
                    int i38 = i3 - i37;
                    ArrayList arrayList = new ArrayList();
                    while (i38 > 0) {
                        int min = Math.min(i38, 4096);
                        byte[] bArr3 = new byte[min];
                        int i39 = 0;
                        while (i39 < min) {
                            InputStream inputStream = this.input;
                            if (inputStream == null) {
                                read = -1;
                            } else {
                                read = inputStream.read(bArr3, i39, min - i39);
                            }
                            if (read != -1) {
                                this.totalBytesRetired += read;
                                i39 += read;
                            } else {
                                throw InvalidProtocolBufferMicroException.truncatedMessage();
                            }
                        }
                        i38 -= min;
                        arrayList.add(bArr3);
                    }
                    byte[] bArr4 = new byte[i3];
                    System.arraycopy(this.buffer, i17, bArr4, 0, i37);
                    for (int i46 = 0; i46 < arrayList.size(); i46++) {
                        byte[] bArr5 = (byte[]) arrayList.get(i46);
                        System.arraycopy(bArr5, 0, bArr4, i37, bArr5.length);
                        i37 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                skipRawBytes((i19 - i16) - i17);
                throw InvalidProtocolBufferMicroException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferMicroException.negativeSize();
        }
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
                if (readRawByte4 < 0) {
                    int i17 = i16 | ((readRawByte4 & Byte.MAX_VALUE) << 21);
                    byte readRawByte5 = readRawByte();
                    int i18 = i17 | (readRawByte5 << 28);
                    if (readRawByte5 >= 0) {
                        return i18;
                    }
                    for (int i19 = 0; i19 < 5; i19++) {
                        if (readRawByte() >= 0) {
                            return i18;
                        }
                    }
                    throw InvalidProtocolBufferMicroException.malformedVarint();
                }
                i3 = readRawByte4 << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER;
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
        throw InvalidProtocolBufferMicroException.malformedVarint();
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
            String str = new String(this.buffer, i16, readRawVarint32, "UTF-8");
            this.bufferPos += readRawVarint32;
            return str;
        }
        return new String(readRawBytes(readRawVarint32), "UTF-8");
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
        throw InvalidProtocolBufferMicroException.invalidTag();
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public void resetSizeCounter() {
        this.totalBytesRetired = 0;
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
        int tagWireType = WireFormatMicro.getTagWireType(i3);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType != 4) {
                            if (tagWireType == 5) {
                                readRawLittleEndian32();
                                return true;
                            }
                            throw InvalidProtocolBufferMicroException.invalidWireType();
                        }
                        return false;
                    }
                    skipMessage();
                    checkLastTagWas(WireFormatMicro.makeTag(WireFormatMicro.getTagFieldNumber(i3), 4));
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
        int skip;
        if (i3 >= 0) {
            int i16 = this.totalBytesRetired;
            int i17 = this.bufferPos;
            int i18 = i16 + i17 + i3;
            int i19 = this.currentLimit;
            if (i18 <= i19) {
                int i26 = this.bufferSize;
                if (i3 <= i26 - i17) {
                    this.bufferPos = i17 + i3;
                    return;
                }
                int i27 = i26 - i17;
                this.totalBytesRetired = i16 + i27;
                this.bufferPos = 0;
                this.bufferSize = 0;
                while (i27 < i3) {
                    InputStream inputStream = this.input;
                    if (inputStream == null) {
                        skip = -1;
                    } else {
                        skip = (int) inputStream.skip(i3 - i27);
                    }
                    if (skip > 0) {
                        i27 += skip;
                        this.totalBytesRetired += skip;
                    } else {
                        throw InvalidProtocolBufferMicroException.truncatedMessage();
                    }
                }
                return;
            }
            skipRawBytes((i19 - i16) - i17);
            throw InvalidProtocolBufferMicroException.truncatedMessage();
        }
        throw InvalidProtocolBufferMicroException.negativeSize();
    }

    CodedInputStreamMicro(byte[] bArr, int i3, int i16) {
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.buffer = bArr;
        this.bufferSize = i16 + i3;
        this.bufferPos = i3;
        this.input = null;
    }

    public static CodedInputStreamMicro newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    static int readRawVarint32(InputStream inputStream) throws IOException {
        int i3 = 0;
        int i16 = 0;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferMicroException.truncatedMessage();
            }
            i16 |= (read & 127) << i3;
            if ((read & 128) == 0) {
                return i16;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferMicroException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i16;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferMicroException.malformedVarint();
    }

    public static CodedInputStreamMicro newInstance(byte[] bArr, int i3, int i16) {
        return new CodedInputStreamMicro(bArr, i3, i16);
    }
}
