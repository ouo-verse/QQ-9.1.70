package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdCompressCtx extends a {

    /* renamed from: f, reason: collision with root package name */
    private long f32888f;

    /* renamed from: h, reason: collision with root package name */
    private ZstdDictCompress f32889h = null;

    /* renamed from: i, reason: collision with root package name */
    private long f32890i = 0;

    static {
        Native.load();
    }

    public ZstdCompressCtx() {
        this.f32888f = 0L;
        long init = init();
        this.f32888f = init;
        if (0 != init) {
            g();
            return;
        }
        throw new IllegalStateException("ZSTD_createCompressCtx failed");
    }

    private static native long compressByteArray0(long j3, byte[] bArr, int i3, int i16, byte[] bArr2, int i17, int i18);

    private static native long compressDirectByteBuffer0(long j3, ByteBuffer byteBuffer, int i3, int i16, ByteBuffer byteBuffer2, int i17, int i18);

    private static native long compressDirectByteBufferStream0(long j3, ByteBuffer byteBuffer, int i3, int i16, ByteBuffer byteBuffer2, int i17, int i18, int i19);

    private static native void free(long j3);

    private static native ZstdFrameProgression getFrameProgression0(long j3);

    private static native long init();

    private native long loadCDict0(long j3, byte[] bArr);

    private native long loadCDictFast0(long j3, ZstdDictCompress zstdDictCompress);

    private static native long reset0(long j3);

    private static native void setChecksum0(long j3, boolean z16);

    private static native void setContentSize0(long j3, boolean z16);

    private static native void setDictID0(long j3, boolean z16);

    private static native void setLevel0(long j3, int i3);

    private static native long setPledgedSrcSize0(long j3, long j16);

    @Override // com.github.luben.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.github.luben.zstd.a
    void d() {
        long j3 = this.f32888f;
        if (j3 != 0) {
            free(j3);
            this.f32888f = 0L;
        }
    }
}
