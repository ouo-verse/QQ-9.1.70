package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ZstdDecompressCtx extends a {

    /* renamed from: f, reason: collision with root package name */
    private long f32891f;

    /* renamed from: h, reason: collision with root package name */
    private ZstdDictDecompress f32892h = null;

    static {
        Native.load();
    }

    public ZstdDecompressCtx() {
        this.f32891f = 0L;
        long init = init();
        this.f32891f = init;
        if (0 != init) {
            g();
            return;
        }
        throw new IllegalStateException("ZSTD_createDeCompressCtx failed");
    }

    private static native long decompressByteArray0(long j3, byte[] bArr, int i3, int i16, byte[] bArr2, int i17, int i18);

    private static native long decompressDirectByteBuffer0(long j3, ByteBuffer byteBuffer, int i3, int i16, ByteBuffer byteBuffer2, int i17, int i18);

    private static native long decompressDirectByteBufferStream0(long j3, ByteBuffer byteBuffer, int i3, int i16, ByteBuffer byteBuffer2, int i17, int i18);

    private static native void free(long j3);

    private static native long init();

    private void k() {
        if (this.f32891f != 0) {
        } else {
            throw new IllegalStateException("Decompression context is closed");
        }
    }

    private static native long loadDDict0(long j3, byte[] bArr);

    private static native long loadDDictFast0(long j3, ZstdDictDecompress zstdDictDecompress);

    private static native void reset0(long j3);

    @Override // com.github.luben.zstd.a, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.github.luben.zstd.a
    void d() {
        long j3 = this.f32891f;
        if (j3 != 0) {
            free(j3);
            this.f32891f = 0L;
        }
    }

    public int h(byte[] bArr, byte[] bArr2) {
        return j(bArr, 0, bArr.length, bArr2, 0, bArr2.length);
    }

    public byte[] i(byte[] bArr, int i3) throws ZstdException {
        if (i3 >= 0) {
            byte[] bArr2 = new byte[i3];
            int h16 = h(bArr2, bArr);
            if (h16 != i3) {
                return Arrays.copyOfRange(bArr2, 0, h16);
            }
            return bArr2;
        }
        throw new ZstdException(Zstd.errGeneric(), "Original size should not be negative");
    }

    public int j(byte[] bArr, int i3, int i16, byte[] bArr2, int i17, int i18) {
        k();
        a();
        try {
            long decompressByteArray0 = decompressByteArray0(this.f32891f, bArr, i3, i16, bArr2, i17, i18);
            if (!Zstd.isError(decompressByteArray0)) {
                if (decompressByteArray0 <= TTL.MAX_VALUE) {
                    return (int) decompressByteArray0;
                }
                throw new ZstdException(Zstd.errGeneric(), "Output size is greater than MAX_INT");
            }
            throw new ZstdException(decompressByteArray0);
        } finally {
            e();
        }
    }

    public ZstdDecompressCtx l(byte[] bArr) {
        k();
        a();
        try {
            long loadDDict0 = loadDDict0(this.f32891f, bArr);
            if (!Zstd.isError(loadDDict0)) {
                this.f32892h = null;
                return this;
            }
            throw new ZstdException(loadDDict0);
        } finally {
            e();
        }
    }
}
