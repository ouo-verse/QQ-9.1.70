package com.tencent.gcloud.apkchannel.v2;

import android.annotation.SuppressLint;
import android.util.Log;
import com.tencent.gcloud.apkchannel.ChannelComment;
import com.tencent.gcloud.apkchannel.v2.ApkSignatureSchemeV2Verifier;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ApkSignatureV2ChannelTool {
    static IPatchRedirector $redirector_ = null;
    private static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    private static final String TAG = "ApkSignatureV2ChannelTool";
    private static final int YYB_COMMENT_BLOCK_ID = 1903261812;

    public ApkSignatureV2ChannelTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0103, code lost:
    
        if (r8 != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0105, code lost:
    
        r6.putLong(r20.length + 4);
        r6.putInt(r19);
        r6.put(r20);
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0113, code lost:
    
        r0 = r18.getLong() + r8;
        r6.putLong(r0);
        r6.put(r18.array(), r18.array().length - 16, 16);
        r6.position(0);
        r6.putLong(r0);
        r6.position(0);
        r6.limit(((int) r0) + 8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0143, code lost:
    
        return com.tencent.gcloud.apkchannel.v2.Pair.create(r6, java.lang.Long.valueOf(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e7, code lost:
    
        throw new com.tencent.gcloud.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + r8 + " size out of range: " + r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<ByteBuffer, Long> genApkSigningBlockWithNewPair(ByteBuffer byteBuffer, int i3, byte[] bArr) throws ApkSignatureSchemeV2Verifier.SignatureNotFoundException, UnsupportedEncodingException {
        long j3;
        ApkSignatureSchemeV2Verifier.checkByteOrderLittleEndian(byteBuffer);
        int i16 = 8;
        ByteBuffer sliceFromTo = ApkSignatureSchemeV2Verifier.sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int length = bArr.length + 12;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity() + length);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.position(8);
        int i17 = 0;
        while (true) {
            if (sliceFromTo.hasRemaining()) {
                i17++;
                if (sliceFromTo.remaining() >= i16) {
                    long j16 = sliceFromTo.getLong();
                    if (j16 < 4 || j16 > TTL.MAX_VALUE) {
                        break;
                    }
                    int i18 = (int) j16;
                    int position = sliceFromTo.position() + i18;
                    if (i18 <= sliceFromTo.remaining()) {
                        int i19 = sliceFromTo.getInt();
                        if (i19 == i3) {
                            j3 = (bArr.length + 4) - i18;
                            allocate.putLong(bArr.length + 4);
                            allocate.putInt(i19);
                            allocate.put(bArr);
                            sliceFromTo.position(position);
                            allocate.put(sliceFromTo.array(), sliceFromTo.arrayOffset(), sliceFromTo.remaining());
                            sliceFromTo.position(sliceFromTo.limit());
                            break;
                        }
                        allocate.putLong(j16);
                        allocate.putInt(i19);
                        allocate.put(ApkSignatureSchemeV2Verifier.getByteBuffer(sliceFromTo, i18 - 4));
                        sliceFromTo.position(position);
                        i16 = 8;
                    } else {
                        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i17 + " size out of range: " + i18 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i17);
                }
            } else {
                j3 = 0;
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
    
        throw new com.tencent.gcloud.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + r6 + " size out of range: " + r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<ByteBuffer, Long> genApkSigningBlockWithNewPair2(ByteBuffer byteBuffer, int i3, byte[] bArr) throws ApkSignatureSchemeV2Verifier.SignatureNotFoundException, UnsupportedEncodingException {
        int i16;
        ByteBuffer byteBuffer2;
        ApkSignatureSchemeV2Verifier.checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = ApkSignatureSchemeV2Verifier.sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int length = bArr.length + 12;
        int i17 = 0;
        while (true) {
            if (sliceFromTo.hasRemaining()) {
                i17++;
                if (sliceFromTo.remaining() >= 8) {
                    long j3 = sliceFromTo.getLong();
                    if (j3 < 4 || j3 > TTL.MAX_VALUE) {
                        break;
                    }
                    int i18 = (int) j3;
                    int position = sliceFromTo.position() + i18;
                    if (i18 <= sliceFromTo.remaining()) {
                        int i19 = sliceFromTo.getInt();
                        if (i19 == APK_SIGNATURE_SCHEME_V2_BLOCK_ID) {
                            i16 = i18 + 8 + length + 8 + 8 + 16;
                            byteBuffer2 = ByteBuffer.allocate(i16);
                            byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
                            byteBuffer2.position(8);
                            byteBuffer2.putLong(j3);
                            byteBuffer2.putInt(i19);
                            byteBuffer2.put(ApkSignatureSchemeV2Verifier.getByteBuffer(sliceFromTo, i18 - 4));
                            break;
                        }
                        sliceFromTo.position(position);
                    } else {
                        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i17 + " size out of range: " + i18 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i17);
                }
            } else {
                i16 = 0;
                byteBuffer2 = null;
                break;
            }
        }
        if (byteBuffer2 == null) {
            return null;
        }
        byteBuffer2.putLong(bArr.length + 4);
        byteBuffer2.putInt(i3);
        byteBuffer2.put(bArr);
        long j16 = i16 - 8;
        long j17 = j16 - byteBuffer.getLong();
        byteBuffer2.putLong(j16);
        byteBuffer2.put(byteBuffer.array(), byteBuffer.array().length - 16, 16);
        byteBuffer2.position(0);
        byteBuffer2.putLong(j16);
        byteBuffer2.position(0);
        byteBuffer2.limit(((int) j16) + 8);
        return Pair.create(byteBuffer2, Long.valueOf(j17));
    }

    public static int getApkCurChannelId(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                int findChanelIdInSignBlock = ApkSignatureSchemeV2Verifier.findChanelIdInSignBlock(ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first);
                randomAccessFile.close();
                return findChanelIdInSignBlock;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    public static byte[] getApkCurChannelValue(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                ByteBuffer findApkChannelInfoBlock = ApkSignatureSchemeV2Verifier.findApkChannelInfoBlock(ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first);
                int remaining = findApkChannelInfoBlock.remaining();
                byte[] bArr = new byte[remaining];
                findApkChannelInfoBlock.get(bArr, 0, remaining);
                randomAccessFile.close();
                return bArr;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    private static ByteBuffer getCdfh(RandomAccessFile randomAccessFile, long j3, int i3) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        return allocate;
    }

    private static long getCentralDirOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                long centralDirOffset = ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue);
                randomAccessFile.close();
                return centralDirOffset;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    private static long getCentralDirSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                long centralDirSize = ApkSignatureSchemeV2Verifier.getCentralDirSize(byteBuffer, longValue);
                randomAccessFile.close();
                return centralDirSize;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    private static long getEocdOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            long longValue = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile).second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                randomAccessFile.close();
                return longValue;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    private static long getEocdSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, eocd.second.longValue())) {
                long capacity = byteBuffer.capacity();
                randomAccessFile.close();
                return capacity;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    public static long getSignBlockOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getSigningBlockOffset(str);
    }

    public static long getSignBlockSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getSigningBlockSize(str);
    }

    private static long getSigningBlockOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                long longValue2 = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).second.longValue();
                randomAccessFile.close();
                return longValue2;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    private static long getSigningBlockSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        long j3;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                ByteBuffer byteBuffer2 = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first;
                if (byteBuffer2 != null) {
                    j3 = byteBuffer2.capacity();
                } else {
                    j3 = 0;
                }
                randomAccessFile.close();
                return j3;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    public static boolean isSignatureV2Apk(String str) throws IOException {
        return ApkSignatureSchemeV2Verifier.hasSignature(str);
    }

    public static long readCDFHOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getCentralDirOffset(str);
    }

    public static long readCDFHSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getCentralDirSize(str);
    }

    private static long readChannelInfoOffset(String str, int i3) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                Pair<ByteBuffer, Long> findApkSigningBlock = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue));
                long longValue2 = findApkSigningBlock.second.longValue() + ApkSignatureSchemeV2Verifier.findChannelBlockOffset(findApkSigningBlock.first);
                ByteBuffer allocate = ByteBuffer.allocate((((int) readChannelInfoSize(str, 0)) - 4) - 8);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile.seek(8 + longValue2 + 4);
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                int remaining = allocate.remaining();
                byte[] bArr = new byte[remaining];
                allocate.get(bArr, 0, remaining);
                ChannelComment channelComment = new ChannelComment();
                try {
                    channelComment.decode(bArr);
                    Log.d(TAG, "apollo0511 readChannelInfoOffset getOffset and channelId:" + channelComment.f108391p.getProperty("channelId"));
                } catch (ProtocolException e16) {
                    e16.printStackTrace();
                }
                randomAccessFile.close();
                return longValue2;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    private static long readChannelInfoSize(String str, int i3) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                long apkSigningBlockChannelSize = ApkSignatureSchemeV2Verifier.getApkSigningBlockChannelSize(ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first);
                long readChannelInfoOffset = readChannelInfoOffset(str);
                ByteBuffer allocate = ByteBuffer.allocate((((int) apkSigningBlockChannelSize) - 8) - 4);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile.seek(readChannelInfoOffset + 8 + 4);
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                int remaining = allocate.remaining();
                byte[] bArr = new byte[remaining];
                allocate.get(bArr, 0, remaining);
                ChannelComment channelComment = new ChannelComment();
                try {
                    channelComment.decode(bArr);
                    Log.d(TAG, "apollo0511 readChannelInfoSize getSize and channelId:" + channelComment.f108391p.getProperty("channelId"));
                } catch (ProtocolException e16) {
                    e16.printStackTrace();
                }
                randomAccessFile.close();
                return apkSigningBlockChannelSize;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    public static long readCommentOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return readChannelInfoOffset(str, YYB_COMMENT_BLOCK_ID);
    }

    public static long readCommentSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return readChannelInfoSize(str, YYB_COMMENT_BLOCK_ID);
    }

    public static long readEOCDOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getEocdOffset(str);
    }

    public static long readEOCDSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getEocdSize(str);
    }

    private static byte[] readPairValueWithId(String str, int i3) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                ByteBuffer findApkSigningBlockWithId = ApkSignatureSchemeV2Verifier.findApkSigningBlockWithId(ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first, i3);
                int remaining = findApkSigningBlockWithId.remaining();
                byte[] bArr = new byte[remaining];
                findApkSigningBlockWithId.get(bArr, 0, remaining);
                randomAccessFile.close();
                return bArr;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    public static byte[] readYYBComment(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return readPairValueWithId(str, YYB_COMMENT_BLOCK_ID);
    }

    private static void updateApkWithPair(String str, int i3, byte[] bArr) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                long centralDirOffset = ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue);
                ByteBuffer cdfh = getCdfh(randomAccessFile, centralDirOffset, (int) (longValue - centralDirOffset));
                Pair<ByteBuffer, Long> findApkSigningBlock = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, centralDirOffset);
                ByteBuffer byteBuffer2 = findApkSigningBlock.first;
                long longValue2 = findApkSigningBlock.second.longValue();
                Pair<ByteBuffer, Long> genApkSigningBlockWithNewPair2 = genApkSigningBlockWithNewPair2(byteBuffer2, i3, bArr);
                if (genApkSigningBlockWithNewPair2 == null) {
                    randomAccessFile.close();
                    return;
                }
                ByteBuffer byteBuffer3 = genApkSigningBlockWithNewPair2.first;
                long longValue3 = genApkSigningBlockWithNewPair2.second.longValue();
                ZipUtils.setZipEocdCentralDirectoryOffset(byteBuffer, centralDirOffset + longValue3);
                randomAccessFile.seek(longValue2);
                randomAccessFile.write(byteBuffer3.array(), byteBuffer3.arrayOffset() + byteBuffer3.position(), byteBuffer3.remaining());
                randomAccessFile.write(cdfh.array(), cdfh.arrayOffset() + cdfh.position(), cdfh.remaining());
                randomAccessFile.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                if (longValue3 < 0) {
                    randomAccessFile.setLength(randomAccessFile.length() + longValue3);
                }
                randomAccessFile.close();
                return;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    public static void updateChannInfoBlock(String str, int i3, byte[] bArr) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        updateApkWithPair(str, i3, bArr);
    }

    public static void updateYYBComment(String str, byte[] bArr) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        updateApkWithPair(str, YYB_COMMENT_BLOCK_ID, bArr);
    }

    @SuppressLint({"NewApi"})
    private static long readChannelInfoOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                Pair<ByteBuffer, Long> findApkSigningBlock = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue));
                long longValue2 = findApkSigningBlock.second.longValue() + ApkSignatureSchemeV2Verifier.findChannelBlockOffset(findApkSigningBlock.first);
                randomAccessFile.close();
                return longValue2;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }
}
