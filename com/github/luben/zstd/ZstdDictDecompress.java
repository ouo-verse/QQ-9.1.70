package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdDictDecompress extends d {

    /* renamed from: f, reason: collision with root package name */
    private long f32894f;

    static {
        Native.load();
    }

    private native void free();

    private native void init(byte[] bArr, int i3, int i16);

    private native void initDirect(ByteBuffer byteBuffer, int i3, int i16);

    @Override // com.github.luben.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.github.luben.zstd.a
    void d() {
        if (this.f32894f != 0) {
            free();
            this.f32894f = 0L;
        }
    }
}
