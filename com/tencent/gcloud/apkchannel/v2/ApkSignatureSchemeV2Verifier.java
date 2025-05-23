package com.tencent.gcloud.apkchannel.v2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ApkSignatureSchemeV2Verifier {
    static IPatchRedirector $redirector_ = null;
    private static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    private static final long APK_SIG_BLOCK_MAGIC_HI = 3617552046287187010L;
    private static final long APK_SIG_BLOCK_MAGIC_LO = 2334950737559900225L;
    private static final int APK_SIG_BLOCK_MIN_SIZE = 32;
    static final int SF_ATTRIBUTE_ANDROID_APK_SIGNED_ID = 2;
    static final String SF_ATTRIBUTE_ANDROID_APK_SIGNED_NAME = "X-Android-APK-Signed";

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class SignatureNotFoundException extends Exception {
        static IPatchRedirector $redirector_ = null;
        private static final long serialVersionUID = 1;

        public SignatureNotFoundException(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }

        public SignatureNotFoundException(String str, Throwable th5) {
            super(str, th5);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) th5);
        }
    }

    public ApkSignatureSchemeV2Verifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkByteOrderLittleEndian(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
        } else {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer findApkChannelInfoBlock(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i3 = 0;
        while (sliceFromTo.hasRemaining()) {
            i3++;
            if (sliceFromTo.remaining() >= 8) {
                long j3 = sliceFromTo.getLong();
                if (j3 >= 4 && j3 <= TTL.MAX_VALUE) {
                    int i16 = (int) j3;
                    int position = sliceFromTo.position() + i16;
                    if (i16 <= sliceFromTo.remaining()) {
                        if (sliceFromTo.getInt() != APK_SIGNATURE_SCHEME_V2_BLOCK_ID) {
                            return getByteBuffer(sliceFromTo, i16 - 4);
                        }
                        sliceFromTo.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + i16 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + j3);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i3);
            }
        }
        throw new SignatureNotFoundException("No Channel block in APK Signing Block");
    }

    private static ByteBuffer findApkSignatureSchemeV2Block(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i3 = 0;
        while (sliceFromTo.hasRemaining()) {
            i3++;
            if (sliceFromTo.remaining() >= 8) {
                long j3 = sliceFromTo.getLong();
                if (j3 >= 4 && j3 <= TTL.MAX_VALUE) {
                    int i16 = (int) j3;
                    int position = sliceFromTo.position() + i16;
                    if (i16 <= sliceFromTo.remaining()) {
                        if (sliceFromTo.getInt() == APK_SIGNATURE_SCHEME_V2_BLOCK_ID) {
                            return getByteBuffer(sliceFromTo, i16 - 4);
                        }
                        sliceFromTo.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + i16 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + j3);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i3);
            }
        }
        throw new SignatureNotFoundException("No APK Signature Scheme v2 block in APK Signing Block");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> findApkSigningBlock(RandomAccessFile randomAccessFile, long j3) throws IOException, SignatureNotFoundException {
        if (j3 >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            randomAccessFile.seek(j3 - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == 2334950737559900225L && allocate.getLong(16) == 3617552046287187010L) {
                long j16 = allocate.getLong(0);
                if (j16 >= allocate.capacity() && j16 <= 2147483639) {
                    int i3 = (int) (8 + j16);
                    long j17 = j3 - i3;
                    if (j17 >= 0) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(i3);
                        allocate2.order(byteOrder);
                        randomAccessFile.seek(j17);
                        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                        long j18 = allocate2.getLong(0);
                        if (j18 == j16) {
                            return Pair.create(allocate2, Long.valueOf(j17));
                        }
                        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j18 + " vs " + j16);
                    }
                    throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j17);
                }
                throw new SignatureNotFoundException("APK Signing Block size out of range: " + j16);
            }
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer findApkSigningBlockWithId(ByteBuffer byteBuffer, int i3) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i16 = 0;
        while (sliceFromTo.hasRemaining()) {
            i16++;
            if (sliceFromTo.remaining() >= 8) {
                long j3 = sliceFromTo.getLong();
                if (j3 >= 4 && j3 <= TTL.MAX_VALUE) {
                    int i17 = (int) j3;
                    int position = sliceFromTo.position() + i17;
                    if (i17 <= sliceFromTo.remaining()) {
                        if (sliceFromTo.getInt() == i3) {
                            return getByteBuffer(sliceFromTo, i17 - 4);
                        }
                        sliceFromTo.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i16 + " size out of range: " + i17 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i16 + " size out of range: " + j3);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i16);
            }
        }
        throw new SignatureNotFoundException("No Channel block in APK Signing Block");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int findChanelIdInSignBlock(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i3 = 0;
        while (sliceFromTo.hasRemaining()) {
            i3++;
            if (sliceFromTo.remaining() >= 8) {
                long j3 = sliceFromTo.getLong();
                if (j3 >= 4 && j3 <= TTL.MAX_VALUE) {
                    int i16 = (int) j3;
                    int position = sliceFromTo.position() + i16;
                    if (i16 <= sliceFromTo.remaining()) {
                        int i17 = sliceFromTo.getInt();
                        if (i17 != APK_SIGNATURE_SCHEME_V2_BLOCK_ID) {
                            return i17;
                        }
                        sliceFromTo.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + i16 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + j3);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i3);
            }
        }
        throw new SignatureNotFoundException("No Channel block in APK Signing Block");
    }

    public static long findChannelBlockOffset(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i3 = 0;
        while (sliceFromTo.hasRemaining()) {
            i3++;
            if (sliceFromTo.remaining() >= 8) {
                long j3 = sliceFromTo.getLong();
                if (j3 >= 4 && j3 <= TTL.MAX_VALUE) {
                    int i16 = (int) j3;
                    int position = sliceFromTo.position() + i16;
                    if (i16 <= sliceFromTo.remaining()) {
                        if (sliceFromTo.getInt() != APK_SIGNATURE_SCHEME_V2_BLOCK_ID) {
                            return sliceFromTo.position() - 4;
                        }
                        sliceFromTo.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + i16 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + j3);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i3);
            }
        }
        throw new SignatureNotFoundException("No Channel block in APK Signing Block");
    }

    public static long getApkSigningBlockChannelSize(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i3 = 0;
        while (sliceFromTo.hasRemaining()) {
            i3++;
            if (sliceFromTo.remaining() >= 8) {
                long j3 = sliceFromTo.getLong();
                if (j3 >= 4 && j3 <= TTL.MAX_VALUE) {
                    int i16 = (int) j3;
                    int position = sliceFromTo.position() + i16;
                    if (i16 <= sliceFromTo.remaining()) {
                        if (sliceFromTo.getInt() != APK_SIGNATURE_SCHEME_V2_BLOCK_ID) {
                            return j3 + 8;
                        }
                        sliceFromTo.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + i16 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i3 + " size out of range: " + j3);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i3);
            }
        }
        throw new SignatureNotFoundException("No Channel block in APK Signing Block");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer getByteBuffer(ByteBuffer byteBuffer, int i3) throws BufferUnderflowException {
        if (i3 >= 0) {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            int i16 = i3 + position;
            if (i16 >= position && i16 <= limit) {
                byteBuffer.limit(i16);
                try {
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(i16);
                    return slice;
                } finally {
                    byteBuffer.limit(limit);
                }
            }
            throw new BufferUnderflowException();
        }
        throw new IllegalArgumentException("size: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getCentralDirOffset(ByteBuffer byteBuffer, long j3) throws SignatureNotFoundException {
        long zipEocdCentralDirectoryOffset = ZipUtils.getZipEocdCentralDirectoryOffset(byteBuffer);
        if (zipEocdCentralDirectoryOffset < j3) {
            if (ZipUtils.getZipEocdCentralDirectorySizeBytes(byteBuffer) + zipEocdCentralDirectoryOffset == j3) {
                return zipEocdCentralDirectoryOffset;
            }
            throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + zipEocdCentralDirectoryOffset + ". ZIP End of Central Directory offset: " + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getCentralDirSize(ByteBuffer byteBuffer, long j3) throws SignatureNotFoundException {
        long zipEocdCentralDirectoryOffset = ZipUtils.getZipEocdCentralDirectoryOffset(byteBuffer);
        if (zipEocdCentralDirectoryOffset < j3) {
            long zipEocdCentralDirectorySizeBytes = ZipUtils.getZipEocdCentralDirectorySizeBytes(byteBuffer);
            if (zipEocdCentralDirectoryOffset + zipEocdCentralDirectorySizeBytes == j3) {
                return zipEocdCentralDirectorySizeBytes;
            }
            throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + zipEocdCentralDirectoryOffset + ". ZIP End of Central Directory offset: " + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> getEocd(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord = ZipUtils.findZipEndOfCentralDirectoryRecord(randomAccessFile);
        if (findZipEndOfCentralDirectoryRecord != null) {
            return findZipEndOfCentralDirectoryRecord;
        }
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasSignature(String str) throws IOException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            try {
                Pair<ByteBuffer, Long> eocd = getEocd(randomAccessFile);
                ByteBuffer byteBuffer = eocd.first;
                long longValue = eocd.second.longValue();
                if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                    findApkSignatureSchemeV2Block(findApkSigningBlock(randomAccessFile, getCentralDirOffset(byteBuffer, longValue)).first);
                    randomAccessFile.close();
                    return true;
                }
                throw new SignatureNotFoundException("ZIP64 APK not supported");
            } finally {
            }
        } catch (SignatureNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer sliceFromTo(ByteBuffer byteBuffer, int i3, int i16) {
        if (i3 >= 0) {
            if (i16 >= i3) {
                int capacity = byteBuffer.capacity();
                if (i16 <= byteBuffer.capacity()) {
                    int limit = byteBuffer.limit();
                    int position = byteBuffer.position();
                    try {
                        byteBuffer.position(0);
                        byteBuffer.limit(i16);
                        byteBuffer.position(i3);
                        ByteBuffer slice = byteBuffer.slice();
                        slice.order(byteBuffer.order());
                        return slice;
                    } finally {
                        byteBuffer.position(0);
                        byteBuffer.limit(limit);
                        byteBuffer.position(position);
                    }
                }
                throw new IllegalArgumentException("end > capacity: " + i16 + " > " + capacity);
            }
            throw new IllegalArgumentException("end < start: " + i16 + " < " + i3);
        }
        throw new IllegalArgumentException("start: " + i3);
    }
}
