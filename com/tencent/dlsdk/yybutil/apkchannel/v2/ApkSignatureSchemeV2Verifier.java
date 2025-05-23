package com.tencent.dlsdk.yybutil.apkchannel.v2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ApkSignatureSchemeV2Verifier {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class SignatureNotFoundException extends Exception {
        static IPatchRedirector $redirector_;

        public SignatureNotFoundException(String str) {
            super(str);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }
    }

    public ApkSignatureSchemeV2Verifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile) {
        c<ByteBuffer, Long> a16 = a.a(randomAccessFile);
        if (a16 != null) {
            return a16;
        }
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    static ByteBuffer b(ByteBuffer byteBuffer, int i3) {
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
    public static long a(ByteBuffer byteBuffer, long j3) {
        long c16 = a.c(byteBuffer);
        if (c16 < j3) {
            if (a.d(byteBuffer) + c16 == j3) {
                return c16;
            }
            throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + c16 + ". ZIP End of Central Directory offset: " + j3);
    }

    static ByteBuffer a(ByteBuffer byteBuffer, int i3, int i16) {
        if (i3 < 0) {
            throw new IllegalArgumentException("start: " + i3);
        }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j3) {
        if (j3 >= 32) {
            ByteBuffer allocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            randomAccessFile.seek(j3 - allocate.capacity());
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            if (allocate.getLong(8) == com.tencent.gcloud.newapkchannel.v2.ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == com.tencent.gcloud.newapkchannel.v2.ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_HI) {
                long j16 = allocate.getLong(0);
                if (j16 < allocate.capacity() || j16 > 2147483639) {
                    throw new SignatureNotFoundException("APK Signing Block size out of range: " + j16);
                }
                int i3 = (int) (8 + j16);
                long j17 = j3 - i3;
                if (j17 >= 0) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(i3);
                    allocate2.order(byteOrder);
                    randomAccessFile.seek(j17);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    long j18 = allocate2.getLong(0);
                    if (j18 == j16) {
                        return c.a(allocate2, Long.valueOf(j17));
                    }
                    throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j18 + " vs " + j16);
                }
                throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j17);
            }
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer a(ByteBuffer byteBuffer, int i3) {
        a(byteBuffer);
        ByteBuffer a16 = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i16 = 0;
        while (a16.hasRemaining()) {
            i16++;
            if (a16.remaining() >= 8) {
                long j3 = a16.getLong();
                if (j3 >= 4 && j3 <= TTL.MAX_VALUE) {
                    int i17 = (int) j3;
                    int position = a16.position() + i17;
                    if (i17 <= a16.remaining()) {
                        if (a16.getInt() == i3) {
                            return b(a16, i17 - 4);
                        }
                        a16.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i16 + " size out of range: " + i17 + ", available: " + a16.remaining());
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

    static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }
}
