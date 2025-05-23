package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Zstd {
    static {
        Native.load();
    }

    public static byte[] a(byte[] bArr, int i3) {
        ZstdDecompressCtx zstdDecompressCtx = new ZstdDecompressCtx();
        try {
            return zstdDecompressCtx.i(bArr, i3);
        } finally {
            zstdDecompressCtx.close();
        }
    }

    public static long b(byte[] bArr, int i3, byte[] bArr2, int i16, int i17, byte[] bArr3) {
        ZstdDecompressCtx zstdDecompressCtx = new ZstdDecompressCtx();
        try {
            zstdDecompressCtx.l(bArr3);
            return zstdDecompressCtx.j(bArr, i3, bArr.length - i3, bArr2, i16, i17);
        } finally {
            zstdDecompressCtx.close();
        }
    }

    public static native int blockSizeMax();

    @Deprecated
    public static long c(byte[] bArr) {
        return d(bArr, 0);
    }

    public static native int chainLogMax();

    public static native int chainLogMin();

    public static native long compressBound(long j3);

    public static native long compressUnsafe(long j3, long j16, long j17, long j18, int i3, boolean z16);

    @Deprecated
    public static long d(byte[] bArr, int i3) {
        return e(bArr, i3, bArr.length - i3);
    }

    public static native long decompressUnsafe(long j3, long j16, long j17, long j18);

    @Deprecated
    public static native long decompressedDirectByteBufferSize(ByteBuffer byteBuffer, int i3, int i16, boolean z16);

    private static native long decompressedSize0(byte[] bArr, int i3, int i16, boolean z16);

    public static native int defaultCompressionLevel();

    @Deprecated
    public static long e(byte[] bArr, int i3, int i16) {
        return f(bArr, i3, i16, false);
    }

    public static native long errChecksumWrong();

    public static native long errCorruptionDetected();

    public static native long errDictionaryCorrupted();

    public static native long errDictionaryCreationFailed();

    public static native long errDictionaryWrong();

    public static native long errDstBufferNull();

    public static native long errDstSizeTooSmall();

    public static native long errFrameParameterUnsupported();

    public static native long errFrameParameterWindowTooLarge();

    public static native long errGeneric();

    public static native long errInitMissing();

    public static native long errMaxSymbolValueTooLarge();

    public static native long errMaxSymbolValueTooSmall();

    public static native long errMemoryAllocation();

    public static native long errNoError();

    public static native long errParameterOutOfBound();

    public static native long errParameterUnsupported();

    public static native long errPrefixUnknown();

    public static native long errSrcSizeWrong();

    public static native long errStageWrong();

    public static native long errTableLogTooLarge();

    public static native long errVersionUnsupported();

    public static native long errWorkSpaceTooSmall();

    @Deprecated
    public static long f(byte[] bArr, int i3, int i16, boolean z16) {
        if (i3 < bArr.length) {
            int i17 = i3 + i16;
            if (i17 <= bArr.length) {
                return decompressedSize0(bArr, i3, i16, z16);
            }
            throw new ArrayIndexOutOfBoundsException(i17);
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer g(c cVar, int i3) throws ZstdIOException {
        ByteBuffer byteBuffer = cVar.get(i3);
        if (byteBuffer != null) {
            if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
                return byteBuffer;
            }
            cVar.a(byteBuffer);
            throw new IllegalArgumentException("provided ByteBuffer lacks array or has non-zero arrayOffset");
        }
        throw new ZstdIOException(errMemoryAllocation(), "Cannot get ByteBuffer of size " + i3 + " from the BufferPool");
    }

    static native void generateSequences(long j3, long j16, long j17, long j18, long j19);

    static native long getBuiltinSequenceProducer();

    public static native long getDictIdFromDict(byte[] bArr);

    private static native long getDictIdFromDictDirect(ByteBuffer byteBuffer, int i3, int i16);

    public static native long getDictIdFromFrame(byte[] bArr);

    public static native long getDictIdFromFrameBuffer(ByteBuffer byteBuffer);

    public static native long getDirectByteBufferFrameContentSize(ByteBuffer byteBuffer, int i3, int i16, boolean z16);

    public static native long getErrorCode(long j3);

    public static native String getErrorName(long j3);

    private static native long getFrameContentSize0(byte[] bArr, int i3, int i16, boolean z16);

    static native long getStubSequenceProducer();

    public static native int hashLogMax();

    public static native int hashLogMin();

    public static native boolean isError(long j3);

    public static native int loadDictCompress(long j3, byte[] bArr, int i3);

    public static native int loadDictDecompress(long j3, byte[] bArr, int i3);

    public static native int loadFastDictCompress(long j3, ZstdDictCompress zstdDictCompress);

    public static native int loadFastDictDecompress(long j3, ZstdDictDecompress zstdDictDecompress);

    public static native int magicNumber();

    public static native int maxCompressionLevel();

    public static native int minCompressionLevel();

    public static native void registerSequenceProducer(long j3, long j16, long j17);

    public static native int searchLengthMax();

    public static native int searchLengthMin();

    public static native int searchLogMax();

    public static native int searchLogMin();

    public static native int setCompressionChainLog(long j3, int i3);

    public static native int setCompressionChecksums(long j3, boolean z16);

    public static native int setCompressionHashLog(long j3, int i3);

    public static native int setCompressionJobSize(long j3, int i3);

    public static native int setCompressionLevel(long j3, int i3);

    public static native int setCompressionLong(long j3, int i3);

    public static native int setCompressionMagicless(long j3, boolean z16);

    public static native int setCompressionMinMatch(long j3, int i3);

    public static native int setCompressionOverlapLog(long j3, int i3);

    public static native int setCompressionSearchLog(long j3, int i3);

    public static native int setCompressionStrategy(long j3, int i3);

    public static native int setCompressionTargetLength(long j3, int i3);

    public static native int setCompressionWindowLog(long j3, int i3);

    public static native int setCompressionWorkers(long j3, int i3);

    public static native int setDecompressionLongMax(long j3, int i3);

    public static native int setDecompressionMagicless(long j3, boolean z16);

    public static native int setEnableLongDistanceMatching(long j3, int i3);

    public static native int setRefMultipleDDicts(long j3, boolean z16);

    public static native int setSearchForExternalRepcodes(long j3, int i3);

    public static native int setSequenceProducerFallback(long j3, boolean z16);

    public static native int setValidateSequences(long j3, int i3);

    private static native long trainFromBuffer0(byte[][] bArr, byte[] bArr2, boolean z16);

    private static native long trainFromBufferDirect0(ByteBuffer byteBuffer, int[] iArr, ByteBuffer byteBuffer2, boolean z16);

    public static native int windowLogMax();

    public static native int windowLogMin();
}
