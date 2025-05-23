package kotlin.reflect.jvm.internal.impl.protobuf;

import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class CodedInputStream {
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface RefillCallback {
        void onRefill();
    }

    CodedInputStream(InputStream inputStream) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
        this.bufferIsImmutable = false;
    }

    public static int decodeZigZag32(int i3) {
        return (-(i3 & 1)) ^ (i3 >>> 1);
    }

    public static long decodeZigZag64(long j3) {
        return (-(j3 & 1)) ^ (j3 >>> 1);
    }

    private void ensureAvailable(int i3) throws IOException {
        if (this.bufferSize - this.bufferPos < i3) {
            refillBuffer(i3);
        }
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    private byte[] readRawBytesSlowPath(int i3) throws IOException {
        int read;
        if (i3 <= 0) {
            if (i3 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i16 = this.totalBytesRetired;
        int i17 = this.bufferPos;
        int i18 = i16 + i17 + i3;
        int i19 = this.currentLimit;
        if (i18 <= i19) {
            if (i3 < 4096) {
                byte[] bArr = new byte[i3];
                int i26 = this.bufferSize - i17;
                System.arraycopy(this.buffer, i17, bArr, 0, i26);
                this.bufferPos = this.bufferSize;
                int i27 = i3 - i26;
                ensureAvailable(i27);
                System.arraycopy(this.buffer, 0, bArr, i26, i27);
                this.bufferPos = i27;
                return bArr;
            }
            int i28 = this.bufferSize;
            this.totalBytesRetired = i16 + i28;
            this.bufferPos = 0;
            this.bufferSize = 0;
            int i29 = i28 - i17;
            int i36 = i3 - i29;
            ArrayList<byte[]> arrayList = new ArrayList();
            while (i36 > 0) {
                int min = Math.min(i36, 4096);
                byte[] bArr2 = new byte[min];
                int i37 = 0;
                while (i37 < min) {
                    InputStream inputStream = this.input;
                    if (inputStream == null) {
                        read = -1;
                    } else {
                        read = inputStream.read(bArr2, i37, min - i37);
                    }
                    if (read != -1) {
                        this.totalBytesRetired += read;
                        i37 += read;
                    } else {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                }
                i36 -= min;
                arrayList.add(bArr2);
            }
            byte[] bArr3 = new byte[i3];
            System.arraycopy(this.buffer, i17, bArr3, 0, i29);
            for (byte[] bArr4 : arrayList) {
                System.arraycopy(bArr4, 0, bArr3, i29, bArr4.length);
                i29 += bArr4.length;
            }
            return bArr3;
        }
        skipRawBytes((i19 - i16) - i17);
        throw InvalidProtocolBufferException.truncatedMessage();
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

    private void refillBuffer(int i3) throws IOException {
        if (tryRefillBuffer(i3)) {
        } else {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void skipRawBytesSlowPath(int i3) throws IOException {
        if (i3 >= 0) {
            int i16 = this.totalBytesRetired;
            int i17 = this.bufferPos;
            int i18 = i16 + i17 + i3;
            int i19 = this.currentLimit;
            if (i18 <= i19) {
                int i26 = this.bufferSize;
                int i27 = i26 - i17;
                this.bufferPos = i26;
                refillBuffer(1);
                while (true) {
                    int i28 = i3 - i27;
                    int i29 = this.bufferSize;
                    if (i28 > i29) {
                        i27 += i29;
                        this.bufferPos = i29;
                        refillBuffer(1);
                    } else {
                        this.bufferPos = i28;
                        return;
                    }
                }
            } else {
                skipRawBytes((i19 - i16) - i17);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    private boolean tryRefillBuffer(int i3) throws IOException {
        int i16 = this.bufferPos;
        if (i16 + i3 > this.bufferSize) {
            if (this.totalBytesRetired + i16 + i3 > this.currentLimit) {
                return false;
            }
            RefillCallback refillCallback = this.refillCallback;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            if (this.input != null) {
                int i17 = this.bufferPos;
                if (i17 > 0) {
                    int i18 = this.bufferSize;
                    if (i18 > i17) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i17, bArr, 0, i18 - i17);
                    }
                    this.totalBytesRetired += i17;
                    this.bufferSize -= i17;
                    this.bufferPos = 0;
                }
                InputStream inputStream = this.input;
                byte[] bArr2 = this.buffer;
                int i19 = this.bufferSize;
                int read = inputStream.read(bArr2, i19, bArr2.length - i19);
                if (read != 0 && read >= -1 && read <= this.buffer.length) {
                    if (read > 0) {
                        this.bufferSize += read;
                        if ((this.totalBytesRetired + i3) - this.sizeLimit <= 0) {
                            recomputeBufferSizeAfterLimit();
                            if (this.bufferSize >= i3) {
                                return true;
                            }
                            return tryRefillBuffer(i3);
                        }
                        throw InvalidProtocolBufferException.sizeLimitExceeded();
                    }
                } else {
                    StringBuilder sb5 = new StringBuilder(102);
                    sb5.append("InputStream#read(byte[]) returned invalid result: ");
                    sb5.append(read);
                    sb5.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb5.toString());
                }
            }
            return false;
        }
        StringBuilder sb6 = new StringBuilder(77);
        sb6.append("refillBuffer() called when ");
        sb6.append(i3);
        sb6.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb6.toString());
    }

    public void checkLastTagWas(int i3) throws InvalidProtocolBufferException {
        if (this.lastTag == i3) {
        } else {
            throw InvalidProtocolBufferException.invalidEndTag();
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
        if (this.bufferPos == this.bufferSize && !tryRefillBuffer(1)) {
            return true;
        }
        return false;
    }

    public void popLimit(int i3) {
        this.currentLimit = i3;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i3) throws InvalidProtocolBufferException {
        if (i3 >= 0) {
            int i16 = i3 + this.totalBytesRetired + this.bufferPos;
            int i17 = this.currentLimit;
            if (i16 <= i17) {
                this.currentLimit = i16;
                recomputeBufferSizeAfterLimit();
                return i17;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    public boolean readBool() throws IOException {
        if (readRawVarint64() != 0) {
            return true;
        }
        return false;
    }

    public ByteString readBytes() throws IOException {
        ByteString copyFrom;
        int readRawVarint32 = readRawVarint32();
        int i3 = this.bufferSize;
        int i16 = this.bufferPos;
        if (readRawVarint32 <= i3 - i16 && readRawVarint32 > 0) {
            if (this.bufferIsImmutable && this.enableAliasing) {
                copyFrom = new BoundedByteString(this.buffer, this.bufferPos, readRawVarint32);
            } else {
                copyFrom = ByteString.copyFrom(this.buffer, i16, readRawVarint32);
            }
            this.bufferPos += readRawVarint32;
            return copyFrom;
        }
        if (readRawVarint32 == 0) {
            return ByteString.EMPTY;
        }
        return new LiteralByteString(readRawBytesSlowPath(readRawVarint32));
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

    public void readGroup(int i3, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i16 = this.recursionDepth;
        if (i16 < this.recursionLimit) {
            this.recursionDepth = i16 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i3, 4));
            this.recursionDepth--;
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(1);
        }
        byte[] bArr = this.buffer;
        int i3 = this.bufferPos;
        this.bufferPos = i3 + 1;
        return bArr[i3];
    }

    public int readRawLittleEndian32() throws IOException {
        int i3 = this.bufferPos;
        if (this.bufferSize - i3 < 4) {
            refillBuffer(4);
            i3 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i3 + 4;
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    public long readRawLittleEndian64() throws IOException {
        int i3 = this.bufferPos;
        if (this.bufferSize - i3 < 8) {
            refillBuffer(8);
            i3 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i3 + 8;
        return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
    
        if (r2[r3] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int readRawVarint32() throws IOException {
        int i3;
        long j3;
        int i16 = this.bufferPos;
        int i17 = this.bufferSize;
        if (i17 != i16) {
            byte[] bArr = this.buffer;
            int i18 = i16 + 1;
            byte b16 = bArr[i16];
            if (b16 >= 0) {
                this.bufferPos = i18;
                return b16;
            }
            if (i17 - i18 >= 9) {
                int i19 = i18 + 1;
                int i26 = b16 ^ (bArr[i18] << 7);
                long j16 = i26;
                if (j16 >= 0) {
                    int i27 = i19 + 1;
                    int i28 = i26 ^ (bArr[i19] << RegisterType.DOUBLE_LO);
                    long j17 = i28;
                    if (j17 >= 0) {
                        i3 = (int) (16256 ^ j17);
                    } else {
                        i19 = i27 + 1;
                        j16 = i28 ^ (bArr[i27] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                        if (j16 < 0) {
                            j3 = -2080896;
                        } else {
                            i27 = i19 + 1;
                            i3 = (int) ((r0 ^ (r1 << 28)) ^ 266354560);
                            if (bArr[i19] < 0) {
                                i19 = i27 + 1;
                                if (bArr[i27] < 0) {
                                    i27 = i19 + 1;
                                    if (bArr[i19] < 0) {
                                        i19 = i27 + 1;
                                        if (bArr[i27] < 0) {
                                            i27 = i19 + 1;
                                            if (bArr[i19] < 0) {
                                                i19 = i27 + 1;
                                            }
                                        }
                                    }
                                }
                                this.bufferPos = i19;
                                return i3;
                            }
                        }
                    }
                    i19 = i27;
                    this.bufferPos = i19;
                    return i3;
                }
                j3 = -128;
                i3 = (int) (j16 ^ j3);
                this.bufferPos = i19;
                return i3;
            }
        }
        return (int) readRawVarint64SlowPath();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
    
        if (r2[r0] < 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readRawVarint64() throws IOException {
        long j3;
        long j16;
        long j17;
        int i3 = this.bufferPos;
        int i16 = this.bufferSize;
        if (i16 != i3) {
            byte[] bArr = this.buffer;
            int i17 = i3 + 1;
            byte b16 = bArr[i3];
            if (b16 >= 0) {
                this.bufferPos = i17;
                return b16;
            }
            if (i16 - i17 >= 9) {
                int i18 = i17 + 1;
                long j18 = b16 ^ (bArr[i17] << 7);
                if (j18 < 0) {
                    j16 = -128;
                } else {
                    int i19 = i18 + 1;
                    long j19 = j18 ^ (bArr[i18] << RegisterType.DOUBLE_LO);
                    if (j19 >= 0) {
                        j17 = 16256;
                    } else {
                        i18 = i19 + 1;
                        j18 = j19 ^ (bArr[i19] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                        if (j18 < 0) {
                            j16 = -2080896;
                        } else {
                            i19 = i18 + 1;
                            j19 = j18 ^ (bArr[i18] << 28);
                            if (j19 >= 0) {
                                j17 = 266354560;
                            } else {
                                i18 = i19 + 1;
                                j18 = j19 ^ (bArr[i19] << 35);
                                if (j18 < 0) {
                                    j16 = -34093383808L;
                                } else {
                                    i19 = i18 + 1;
                                    j19 = j18 ^ (bArr[i18] << 42);
                                    if (j19 >= 0) {
                                        j17 = 4363953127296L;
                                    } else {
                                        i18 = i19 + 1;
                                        j18 = j19 ^ (bArr[i19] << 49);
                                        if (j18 < 0) {
                                            j16 = -558586000294016L;
                                        } else {
                                            int i26 = i18 + 1;
                                            long j26 = (j18 ^ (bArr[i18] << 56)) ^ 71499008037633920L;
                                            if (j26 < 0) {
                                                i18 = i26 + 1;
                                            } else {
                                                i18 = i26;
                                            }
                                            j3 = j26;
                                            this.bufferPos = i18;
                                            return j3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    j3 = j19 ^ j17;
                    i18 = i19;
                    this.bufferPos = i18;
                    return j3;
                }
                j3 = j18 ^ j16;
                this.bufferPos = i18;
                return j3;
            }
        }
        return readRawVarint64SlowPath();
    }

    long readRawVarint64SlowPath() throws IOException {
        long j3 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            j3 |= (r3 & Byte.MAX_VALUE) << i3;
            if ((readRawByte() & 128) == 0) {
                return j3;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
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
        if (readRawVarint32 == 0) {
            return "";
        }
        return new String(readRawBytesSlowPath(readRawVarint32), "UTF-8");
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] readRawBytesSlowPath;
        int readRawVarint32 = readRawVarint32();
        int i3 = this.bufferPos;
        if (readRawVarint32 <= this.bufferSize - i3 && readRawVarint32 > 0) {
            readRawBytesSlowPath = this.buffer;
            this.bufferPos = i3 + readRawVarint32;
        } else {
            if (readRawVarint32 == 0) {
                return "";
            }
            readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32);
            i3 = 0;
        }
        if (Utf8.isValidUtf8(readRawBytesSlowPath, i3, i3 + readRawVarint32)) {
            return new String(readRawBytesSlowPath, i3, readRawVarint32, "UTF-8");
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.lastTag = readRawVarint32;
        if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
            return this.lastTag;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public boolean skipField(int i3, CodedOutputStream codedOutputStream) throws IOException {
        int tagWireType = WireFormat.getTagWireType(i3);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType != 4) {
                            if (tagWireType == 5) {
                                int readRawLittleEndian32 = readRawLittleEndian32();
                                codedOutputStream.writeRawVarint32(i3);
                                codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                                return true;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    codedOutputStream.writeRawVarint32(i3);
                    skipMessage(codedOutputStream);
                    int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i3), 4);
                    checkLastTagWas(makeTag);
                    codedOutputStream.writeRawVarint32(makeTag);
                    return true;
                }
                ByteString readBytes = readBytes();
                codedOutputStream.writeRawVarint32(i3);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            }
            long readRawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i3);
            codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
            return true;
        }
        long readInt64 = readInt64();
        codedOutputStream.writeRawVarint32(i3);
        codedOutputStream.writeUInt64NoTag(readInt64);
        return true;
    }

    public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag, codedOutputStream));
    }

    public void skipRawBytes(int i3) throws IOException {
        int i16 = this.bufferSize;
        int i17 = this.bufferPos;
        if (i3 <= i16 - i17 && i3 >= 0) {
            this.bufferPos = i17 + i3;
        } else {
            skipRawBytesSlowPath(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodedInputStream newInstance(LiteralByteString literalByteString) {
        CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.pushLimit(literalByteString.size());
            return codedInputStream;
        } catch (InvalidProtocolBufferException e16) {
            throw new IllegalArgumentException(e16);
        }
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    CodedInputStream(LiteralByteString literalByteString) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = literalByteString.bytes;
        int offsetIntoBytes = literalByteString.getOffsetIntoBytes();
        this.bufferPos = offsetIntoBytes;
        this.bufferSize = offsetIntoBytes + literalByteString.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    public static int readRawVarint32(int i3, InputStream inputStream) throws IOException {
        if ((i3 & 128) == 0) {
            return i3;
        }
        int i16 = i3 & 127;
        int i17 = 7;
        while (i17 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i16 |= (read & 127) << i17;
            if ((read & 128) == 0) {
                return i16;
            }
            i17 += 7;
        }
        while (i17 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i16;
            }
            i17 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }
}
