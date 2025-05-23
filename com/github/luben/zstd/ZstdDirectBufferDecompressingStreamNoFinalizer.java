package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdDirectBufferDecompressingStreamNoFinalizer extends b {
    static {
        Native.load();
    }

    private static native long createDStreamNative();

    private native long decompressStreamNative(long j3, ByteBuffer byteBuffer, int i3, int i16, ByteBuffer byteBuffer2, int i17, int i18);

    private static native long freeDStreamNative(long j3);

    private native long initDStreamNative(long j3);

    private static native long recommendedDOutSizeNative();

    @Override // com.github.luben.zstd.b
    long a(long j3) {
        return freeDStreamNative(j3);
    }
}
