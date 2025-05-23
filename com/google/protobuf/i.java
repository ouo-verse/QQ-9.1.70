package com.google.protobuf;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* compiled from: P */
/* loaded from: classes2.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SoftReference<byte[]>> f35862a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?> f35863b;

    /* renamed from: c, reason: collision with root package name */
    private static final long f35864c;

    static {
        Class<?> e16 = e("java.io.FileOutputStream");
        f35863b = e16;
        f35864c = b(e16);
    }

    private static byte[] a() {
        SoftReference<byte[]> softReference = f35862a.get();
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    private static long b(Class<?> cls) {
        if (cls != null) {
            try {
                if (ch.H()) {
                    return ch.J(cls.getDeclaredField(WadlProxyConsts.CHANNEL));
                }
                return -1L;
            } catch (Throwable unused) {
                return -1L;
            }
        }
        return -1L;
    }

    private static byte[] c(int i3) {
        int max = Math.max(i3, 1024);
        byte[] a16 = a();
        if (a16 == null || d(max, a16.length)) {
            a16 = new byte[max];
            if (max <= 16384) {
                f(a16);
            }
        }
        return a16;
    }

    private static boolean d(int i3, int i16) {
        if (i16 < i3 && i16 < i3 * 0.5f) {
            return true;
        }
        return false;
    }

    private static Class<?> e(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static void f(byte[] bArr) {
        f35862a.set(new SoftReference<>(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        int position = byteBuffer.position();
        try {
            if (byteBuffer.hasArray()) {
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            } else if (!h(byteBuffer, outputStream)) {
                byte[] c16 = c(byteBuffer.remaining());
                while (byteBuffer.hasRemaining()) {
                    int min = Math.min(byteBuffer.remaining(), c16.length);
                    byteBuffer.get(c16, 0, min);
                    outputStream.write(c16, 0, min);
                }
            }
        } finally {
            byteBuffer.position(position);
        }
    }

    private static boolean h(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        WritableByteChannel writableByteChannel;
        long j3 = f35864c;
        if (j3 >= 0 && f35863b.isInstance(outputStream)) {
            try {
                writableByteChannel = (WritableByteChannel) ch.E(outputStream, j3);
            } catch (ClassCastException unused) {
                writableByteChannel = null;
            }
            if (writableByteChannel != null) {
                writableByteChannel.write(byteBuffer);
                return true;
            }
            return false;
        }
        return false;
    }
}
