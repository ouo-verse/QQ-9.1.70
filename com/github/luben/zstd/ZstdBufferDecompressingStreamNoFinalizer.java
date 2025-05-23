package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdBufferDecompressingStreamNoFinalizer extends b {
    static {
        Native.load();
    }

    private native long createDStreamNative();

    private native long decompressStreamNative(long j3, byte[] bArr, int i3, int i16, byte[] bArr2, int i17, int i18);

    private native long freeDStreamNative(long j3);

    private native long initDStreamNative(long j3);

    private static native long recommendedDOutSizeNative();

    @Override // com.github.luben.zstd.b
    long a(long j3) {
        return freeDStreamNative(j3);
    }
}
