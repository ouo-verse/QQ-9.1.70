package com.tencent.gcloud.newapkchannel.v2;

import com.tencent.gcloud.newapkchannel.MSDKComment;
import com.tencent.gcloud.newapkchannel.v2.ApkSignatureSchemeV2Verifier;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ApkSignatureV2V3ChannelTool {
    static IPatchRedirector $redirector_ = null;
    private static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    private static final int APK_SIGNATURE_SCHEME_V3_BLOCK_ID = -262969152;
    private static final int MSDK_COMMENT_BLOCK_ID = 1903261812;
    private static final int YYB_COMMENT_BLOCK_ID = 1903261812;

    public ApkSignatureV2V3ChannelTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static int GetApkSignatureBlockSize(String str, int i3, MSDKComment mSDKComment) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
        } catch (Throwable unused) {
        }
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                long centralDirOffset = ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue);
                getCdfh(randomAccessFile, centralDirOffset, (int) (longValue - centralDirOffset));
                int capacity = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, centralDirOffset).first.capacity();
                randomAccessFile.close();
                return capacity;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable unused2) {
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
                return -1;
            }
            return -1;
        }
    }

    public static int GetApkSignatureSize(String str, MSDKComment mSDKComment) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return GetApkSignatureBlockSize(str, 1903261812, mSDKComment);
    }

    private static boolean checkNeedPaddingData(ByteBuffer byteBuffer) {
        return new String(byteBuffer.array()).endsWith("APK Sig Block 42");
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
    
        return com.tencent.gcloud.newapkchannel.v2.Pair.create(r6, java.lang.Long.valueOf(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e7, code lost:
    
        throw new com.tencent.gcloud.newapkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + r8 + " size out of range: " + r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<ByteBuffer, Long> genApkSigningBlockWithNewPair(ByteBuffer byteBuffer, int i3, byte[] bArr) throws ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
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

    private static ByteBuffer getCdfh(RandomAccessFile randomAccessFile, long j3, int i3) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        return allocate;
    }

    private static String getSignValidString(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String getSignatureV2(String str) throws IOException {
        byte[] readPairValueWithId = readPairValueWithId(str, APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
        if (readPairValueWithId == null) {
            return null;
        }
        return getSignValidString(readPairValueWithId);
    }

    public static String getSignatureV3(String str) throws IOException {
        byte[] readPairValueWithId = readPairValueWithId(str, APK_SIGNATURE_SCHEME_V3_BLOCK_ID);
        if (readPairValueWithId == null) {
            return null;
        }
        return getSignValidString(readPairValueWithId);
    }

    public static boolean isSignatureV2Apk(String str) throws IOException {
        return ApkSignatureSchemeV2Verifier.hasSignature(str, APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
    }

    public static boolean isSignatureV3Apk(String str) throws IOException {
        return ApkSignatureSchemeV2Verifier.hasSignature(str, APK_SIGNATURE_SCHEME_V3_BLOCK_ID);
    }

    private static byte[] readPairValueWithId(String str, int i3) throws IOException {
        byte[] bArr;
        RandomAccessFile randomAccessFile = null;
        byte[] bArr2 = null;
        randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                try {
                    Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile2);
                    ByteBuffer byteBuffer = eocd.first;
                    long longValue = eocd.second.longValue();
                    if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile2, longValue)) {
                        ByteBuffer findApkSigningBlockWithId = ApkSignatureSchemeV2Verifier.findApkSigningBlockWithId(ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile2, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first, i3);
                        if (findApkSigningBlockWithId != null) {
                            int remaining = findApkSigningBlockWithId.remaining();
                            bArr2 = new byte[remaining];
                            findApkSigningBlockWithId.get(bArr2, 0, remaining);
                        }
                        randomAccessFile2.close();
                        return bArr2;
                    }
                    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
                } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
                    e = e16;
                    bArr = null;
                    randomAccessFile = randomAccessFile2;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return bArr;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e17) {
            e = e17;
            bArr = null;
        }
    }

    public static byte[] readYYBComment(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return readPairValueWithId(str, 1903261812);
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            String num = Integer.toString(b16 & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb5.append(num);
        }
        return sb5.toString();
    }

    private static void updateApkWithPair(String str, int i3, MSDKComment mSDKComment) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rw");
            try {
                Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile2);
                ByteBuffer byteBuffer = eocd.first;
                long longValue = eocd.second.longValue();
                if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile2, longValue)) {
                    long centralDirOffset = ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue);
                    ByteBuffer cdfh = getCdfh(randomAccessFile2, centralDirOffset, (int) (longValue - centralDirOffset));
                    Pair<ByteBuffer, Long> findApkSigningBlock = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile2, centralDirOffset);
                    ByteBuffer byteBuffer2 = findApkSigningBlock.first;
                    long longValue2 = findApkSigningBlock.second.longValue();
                    Pair<ByteBuffer, Long> genApkSigningBlockWithNewPair = genApkSigningBlockWithNewPair(byteBuffer2, i3, mSDKComment.encode(checkNeedPaddingData(byteBuffer2)));
                    ByteBuffer byteBuffer3 = genApkSigningBlockWithNewPair.first;
                    long longValue3 = genApkSigningBlockWithNewPair.second.longValue();
                    ZipUtils.setZipEocdCentralDirectoryOffset(byteBuffer, centralDirOffset + longValue3);
                    randomAccessFile2.seek(longValue2);
                    randomAccessFile2.write(byteBuffer3.array(), byteBuffer3.arrayOffset() + byteBuffer3.position(), byteBuffer3.remaining());
                    randomAccessFile2.write(cdfh.array(), cdfh.arrayOffset() + cdfh.position(), cdfh.remaining());
                    randomAccessFile2.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                    if (longValue3 < 0) {
                        randomAccessFile2.setLength(randomAccessFile2.length() + longValue3);
                    }
                    randomAccessFile2.close();
                    return;
                }
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static void updateYYBComment(String str, MSDKComment mSDKComment) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        updateApkWithPair(str, 1903261812, mSDKComment);
    }
}
