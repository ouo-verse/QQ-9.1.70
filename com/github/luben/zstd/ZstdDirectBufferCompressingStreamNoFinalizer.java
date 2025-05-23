package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdDirectBufferCompressingStreamNoFinalizer implements Closeable, Flushable {

    /* renamed from: d, reason: collision with root package name */
    private ByteBuffer f32895d;

    /* renamed from: e, reason: collision with root package name */
    private final long f32896e;

    /* renamed from: f, reason: collision with root package name */
    private int f32897f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f32898h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32899i;

    static {
        Native.load();
    }

    private native long compressDirectByteBuffer(long j3, ByteBuffer byteBuffer, int i3, int i16, ByteBuffer byteBuffer2, int i17, int i18);

    private static native long createCStream();

    private native long endStream(long j3, ByteBuffer byteBuffer, int i3, int i16);

    private native long flushStream(long j3, ByteBuffer byteBuffer, int i3, int i16);

    private static native long freeCStream(long j3);

    private native long initCStream(long j3, int i3);

    private native long initCStreamWithDict(long j3, byte[] bArr, int i3, int i16);

    private native long initCStreamWithFastDict(long j3, ZstdDictCompress zstdDictCompress);

    private static native long recommendedCOutSize();

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        if (r5.isDirect() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
    
        if (r3 <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        if (r10.f32895d.hasRemaining() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        if (r3 > 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        throw new java.io.IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        throw new java.lang.IllegalArgumentException("Target buffer should be a direct buffer");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0067, code lost:
    
        throw new com.github.luben.zstd.ZstdIOException(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
    
        if (r10.f32899i != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000b, code lost:
    
        r5 = r10.f32896e;
        r7 = r10.f32895d;
        r3 = endStream(r5, r7, r7.position(), r10.f32895d.remaining());
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (com.github.luben.zstd.Zstd.isError(r3) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
    
        r5 = r10.f32895d;
        r5.position(r5.position() + r10.f32897f);
        r5 = a(r10.f32895d);
        r10.f32895d = r5;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws IOException {
        if (!this.f32898h) {
            try {
            } finally {
                freeCStream(this.f32896e);
                this.f32898h = true;
                this.f32899i = false;
                this.f32895d = null;
            }
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        long flushStream;
        if (!this.f32898h) {
            if (!this.f32899i) {
                return;
            }
            do {
                long j3 = this.f32896e;
                ByteBuffer byteBuffer = this.f32895d;
                flushStream = flushStream(j3, byteBuffer, byteBuffer.position(), this.f32895d.remaining());
                if (!Zstd.isError(flushStream)) {
                    ByteBuffer byteBuffer2 = this.f32895d;
                    byteBuffer2.position(byteBuffer2.position() + this.f32897f);
                    ByteBuffer a16 = a(this.f32895d);
                    this.f32895d = a16;
                    if (a16.isDirect()) {
                        if (flushStream > 0 && !this.f32895d.hasRemaining()) {
                            throw new IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
                        }
                    } else {
                        throw new IllegalArgumentException("Target buffer should be a direct buffer");
                    }
                } else {
                    throw new ZstdIOException(flushStream);
                }
            } while (flushStream > 0);
            return;
        }
        throw new IOException("Already closed");
    }

    protected ByteBuffer a(ByteBuffer byteBuffer) throws IOException {
        return byteBuffer;
    }
}
