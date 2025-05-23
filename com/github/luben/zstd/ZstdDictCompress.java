package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdDictCompress extends d {

    /* renamed from: f, reason: collision with root package name */
    private long f32893f;

    static {
        Native.load();
    }

    private native void free();

    private native void init(byte[] bArr, int i3, int i16, int i17);

    private native void initDirect(ByteBuffer byteBuffer, int i3, int i16, int i17);

    @Override // com.github.luben.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.github.luben.zstd.a
    void d() {
        if (this.f32893f != 0) {
            free();
            this.f32893f = 0L;
        }
    }
}
