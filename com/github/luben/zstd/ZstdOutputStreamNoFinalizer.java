package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.io.FilterOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdOutputStreamNoFinalizer extends FilterOutputStream {
    private static final int E;
    private boolean C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private final long f32906d;

    /* renamed from: e, reason: collision with root package name */
    private long f32907e;

    /* renamed from: f, reason: collision with root package name */
    private long f32908f;

    /* renamed from: h, reason: collision with root package name */
    private final byte[] f32909h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32910i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f32911m;

    static {
        Native.load();
        E = (int) recommendedCOutSize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        if (r8.C == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        r2 = endStream(r8.f32906d, r8.f32909h, com.github.luben.zstd.ZstdOutputStreamNoFinalizer.E);
        r4 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (com.github.luben.zstd.Zstd.isError(r4) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        ((java.io.FilterOutputStream) r8).out.write(r8.f32909h, 0, (int) r8.f32908f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r2 > 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
    
        throw new com.github.luben.zstd.ZstdIOException(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        if (r9 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
    
        ((java.io.FilterOutputStream) r8).out.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        r8.f32910i = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(boolean z16) throws IOException {
        if (this.f32910i) {
            return;
        }
        if (!this.D) {
            long resetCStream = resetCStream(this.f32906d);
            if (!Zstd.isError(resetCStream)) {
                this.C = false;
            } else {
                throw new ZstdIOException(resetCStream);
            }
        }
    }

    private native int compressStream(long j3, byte[] bArr, int i3, byte[] bArr2, int i16);

    private static native long createCStream();

    private native int endStream(long j3, byte[] bArr, int i3);

    private native int flushStream(long j3, byte[] bArr, int i3);

    private static native int freeCStream(long j3);

    public static native long recommendedCOutSize();

    private native int resetCStream(long j3);

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        a(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (com.github.luben.zstd.Zstd.isError(r2) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        ((java.io.FilterOutputStream) r6).out.write(r6.f32909h, 0, (int) r6.f32908f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r0 > 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        r6.C = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
    
        ((java.io.FilterOutputStream) r6).out.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        throw new com.github.luben.zstd.ZstdIOException(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0035, code lost:
    
        r0 = flushStream(r6.f32906d, r6.f32909h, com.github.luben.zstd.ZstdOutputStreamNoFinalizer.E);
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (com.github.luben.zstd.Zstd.isError(r2) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        ((java.io.FilterOutputStream) r6).out.write(r6.f32909h, 0, (int) r6.f32908f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        if (r0 > 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005d, code lost:
    
        throw new com.github.luben.zstd.ZstdIOException(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        if (r6.f32911m != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        r0 = endStream(r6.f32906d, r6.f32909h, com.github.luben.zstd.ZstdOutputStreamNoFinalizer.E);
        r2 = r0;
     */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void flush() throws IOException {
        if (!this.f32910i) {
            if (!this.C) {
            }
        } else {
            throw new IOException("StreamClosed");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i16) throws IOException {
        if (!this.f32910i) {
            if (this.C) {
                long resetCStream = resetCStream(this.f32906d);
                if (!Zstd.isError(resetCStream)) {
                    this.C = false;
                    this.D = true;
                } else {
                    throw new ZstdIOException(resetCStream);
                }
            }
            int i17 = i16 + i3;
            this.f32907e = i3;
            while (this.f32907e < i17) {
                long compressStream = compressStream(this.f32906d, this.f32909h, E, bArr, i17);
                if (!Zstd.isError(compressStream)) {
                    long j3 = this.f32908f;
                    if (j3 > 0) {
                        ((FilterOutputStream) this).out.write(this.f32909h, 0, (int) j3);
                    }
                } else {
                    throw new ZstdIOException(compressStream);
                }
            }
        } else {
            throw new IOException("StreamClosed");
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) throws IOException {
        write(new byte[]{(byte) i3}, 0, 1);
    }
}
