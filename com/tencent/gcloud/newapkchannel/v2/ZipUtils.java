package com.tencent.gcloud.newapkchannel.v2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ZipUtils {
    static IPatchRedirector $redirector_ = null;
    private static final int UINT16_MAX_VALUE = 65535;
    private static final int ZIP64_EOCD_LOCATOR_SIG_REVERSE_BYTE_ORDER = 1347094023;
    private static final int ZIP64_EOCD_LOCATOR_SIZE = 20;
    private static final int ZIP_EOCD_CENTRAL_DIR_OFFSET_FIELD_OFFSET = 16;
    private static final int ZIP_EOCD_CENTRAL_DIR_SIZE_FIELD_OFFSET = 12;
    private static final int ZIP_EOCD_COMMENT_LENGTH_FIELD_OFFSET = 20;
    private static final int ZIP_EOCD_REC_MIN_SIZE = 22;
    private static final int ZIP_EOCD_REC_SIG = 101010256;

    ZipUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void assertByteOrderLittleEndian(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
        } else {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord = findZipEndOfCentralDirectoryRecord(randomAccessFile, 0);
        return findZipEndOfCentralDirectoryRecord != null ? findZipEndOfCentralDirectoryRecord : findZipEndOfCentralDirectoryRecord(randomAccessFile, 65535);
    }

    private static int getUnsignedInt16(ByteBuffer byteBuffer, int i3) {
        return byteBuffer.getShort(i3) & 65535;
    }

    private static long getUnsignedInt32(ByteBuffer byteBuffer, int i3) {
        return byteBuffer.getInt(i3) & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getZipEocdCentralDirectoryOffset(ByteBuffer byteBuffer) {
        assertByteOrderLittleEndian(byteBuffer);
        return getUnsignedInt32(byteBuffer, byteBuffer.position() + 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getZipEocdCentralDirectorySizeBytes(ByteBuffer byteBuffer) {
        assertByteOrderLittleEndian(byteBuffer);
        return getUnsignedInt32(byteBuffer, byteBuffer.position() + 12);
    }

    public static boolean isZip64EndOfCentralDirectoryLocatorPresent(RandomAccessFile randomAccessFile, long j3) throws IOException {
        long j16 = j3 - 20;
        if (j16 < 0) {
            return false;
        }
        randomAccessFile.seek(j16);
        if (randomAccessFile.readInt() != ZIP64_EOCD_LOCATOR_SIG_REVERSE_BYTE_ORDER) {
            return false;
        }
        return true;
    }

    private static void setUnsignedInt32(ByteBuffer byteBuffer, int i3, long j3) {
        if (j3 >= 0 && j3 <= 4294967295L) {
            byteBuffer.putInt(byteBuffer.position() + i3, (int) j3);
            return;
        }
        throw new IllegalArgumentException("uint32 value of out range: " + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZipEocdCentralDirectoryOffset(ByteBuffer byteBuffer, long j3) {
        assertByteOrderLittleEndian(byteBuffer);
        setUnsignedInt32(byteBuffer, byteBuffer.position() + 16, j3);
    }

    private static Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord(RandomAccessFile randomAccessFile, int i3) throws IOException {
        if (i3 >= 0 && i3 <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i3, length - 22)) + 22);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            long capacity = length - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            int findZipEndOfCentralDirectoryRecord = findZipEndOfCentralDirectoryRecord(allocate);
            if (findZipEndOfCentralDirectoryRecord == -1) {
                return null;
            }
            allocate.position(findZipEndOfCentralDirectoryRecord);
            ByteBuffer slice = allocate.slice();
            slice.order(byteOrder);
            return Pair.create(slice, Long.valueOf(capacity + findZipEndOfCentralDirectoryRecord));
        }
        throw new IllegalArgumentException("maxCommentSize: " + i3);
    }

    private static int findZipEndOfCentralDirectoryRecord(ByteBuffer byteBuffer) {
        assertByteOrderLittleEndian(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i3 = capacity - 22;
        int min = Math.min(i3, 65535);
        for (int i16 = 0; i16 < min; i16++) {
            int i17 = i3 - i16;
            if (byteBuffer.getInt(i17) == ZIP_EOCD_REC_SIG && getUnsignedInt16(byteBuffer, i17 + 20) == i16) {
                return i17;
            }
        }
        return -1;
    }
}
