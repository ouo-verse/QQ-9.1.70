package com.tencent.securitysdk.utils;

import android.util.Pair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ApkSignatureSchemeV2Verifier {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes25.dex */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
        } else {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer b(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        a(byteBuffer);
        ByteBuffer i3 = i(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i16 = 0;
        while (i3.hasRemaining()) {
            i16++;
            if (i3.remaining() >= 8) {
                long j3 = i3.getLong();
                if (j3 >= 4 && j3 <= TTL.MAX_VALUE) {
                    int i17 = (int) j3;
                    int position = i3.position() + i17;
                    if (i17 <= i3.remaining()) {
                        if (i3.getInt() == 1896449818) {
                            return e(i3, i17 - 4);
                        }
                        i3.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i16 + " size out of range: " + i17 + ", available: " + i3.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i16 + " size out of range: " + j3);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i16);
            }
        }
        throw new SignatureNotFoundException("No APK Signature Scheme v2 block in APK Signing Block");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile, long j3) throws IOException, SignatureNotFoundException {
        if (j3 >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            randomAccessFile.seek(j3 - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == com.tencent.gcloud.newapkchannel.v2.ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == com.tencent.gcloud.newapkchannel.v2.ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_HI) {
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
    public static ByteBuffer d(ByteBuffer byteBuffer, int i3) throws SignatureNotFoundException {
        a(byteBuffer);
        ByteBuffer i16 = i(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i17 = 0;
        while (i16.hasRemaining()) {
            i17++;
            if (i16.remaining() >= 8) {
                long j3 = i16.getLong();
                if (j3 >= 4 && j3 <= TTL.MAX_VALUE) {
                    int i18 = (int) j3;
                    int position = i16.position() + i18;
                    if (i18 <= i16.remaining()) {
                        if (i16.getInt() == i3) {
                            return e(i16, i18 - 4);
                        }
                        i16.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i17 + " size out of range: " + i18 + ", available: " + i16.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i17 + " size out of range: " + j3);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i17);
            }
        }
        throw new SignatureNotFoundException("No Channel block in APK Signing Block");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer e(ByteBuffer byteBuffer, int i3) throws BufferUnderflowException {
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
    public static long f(ByteBuffer byteBuffer, long j3) throws SignatureNotFoundException {
        long g16 = g.g(byteBuffer);
        if (g16 < j3) {
            if (g.h(byteBuffer) + g16 == j3) {
                return g16;
            }
            throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + g16 + ". ZIP End of Central Directory offset: " + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> g(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> c16 = g.c(randomAccessFile);
        if (c16 != null) {
            return c16;
        }
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    public static boolean h(String str) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                Pair<ByteBuffer, Long> g16 = g(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) g16.first;
                long longValue = ((Long) g16.second).longValue();
                if (!g.i(randomAccessFile2, longValue)) {
                    b((ByteBuffer) c(randomAccessFile2, f(byteBuffer, longValue)).first);
                    randomAccessFile2.close();
                    return true;
                }
                throw new SignatureNotFoundException("ZIP64 APK not supported");
            } catch (SignatureNotFoundException unused) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return false;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = randomAccessFile2;
                try {
                    th.printStackTrace();
                    return false;
                } finally {
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                }
            }
        } catch (SignatureNotFoundException unused2) {
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer i(ByteBuffer byteBuffer, int i3, int i16) {
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
