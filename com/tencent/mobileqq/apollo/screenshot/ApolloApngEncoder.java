package com.tencent.mobileqq.apollo.screenshot;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0010\b'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0084 J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0084 J!\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0004H\u0084 J9\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0084 J\u0011\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0084 J)\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0084 J\t\u0010\u0018\u001a\u00020\u0006H\u0084 J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0084 J\u0019\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0010H\u0084 J\u0019\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH\u0084 J\u0019\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH\u0084 J\u0011\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0004H\u0084 J1\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0004H\u0084 J\u0019\u0010'\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u000eH\u0084 J\t\u0010)\u001a\u00020\u0004H\u0084 \u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/apollo/screenshot/ApolloApngEncoder;", "", "()V", "nativeEncoderAddFrame", "", "handle", "", "pixels", "", "width", "height", "delayNum", "delayDenominator", "nativeEncoderAssemble", "", "outputPath", "", "nativeEncoderConvertGif", "apngInputPath", "gifOutputPath", "gifEncoderType", "nativeEncoderEncodeFrame", "nativeEncoderEncodeFrameEnd", "nativeEncoderEncodeFramePrepare", "nativeEncoderInit", "nativeEncoderRelease", "", "nativeEncoderSavePNGs", "outputDir", "nativeEncoderSetCompressMode", "mode", "nativeEncoderSetFullRectMode", "nativeEncoderSetGifLimitedAlpha", "a", "nativeEncoderSetOptimization", "skipFirst", "skipPalette", "skipColor", "zipLevel", "nativeEncoderSetTrueColorBoost", "set", "nativeEncoderVersion", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public abstract class ApolloApngEncoder {
    /* JADX INFO: Access modifiers changed from: protected */
    public final native int nativeEncoderAddFrame(long handle, byte[] pixels, int width, int height, int delayNum, int delayDenominator);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native boolean nativeEncoderAssemble(long handle, String outputPath);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native boolean nativeEncoderConvertGif(String apngInputPath, String gifOutputPath, int gifEncoderType);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native boolean nativeEncoderEncodeFrame(long handle, byte[] pixels, int width, int height, int delayNum, int delayDenominator);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native boolean nativeEncoderEncodeFrameEnd(long handle);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native boolean nativeEncoderEncodeFramePrepare(long handle, String outputPath, int width, int height);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native long nativeEncoderInit();

    /* JADX INFO: Access modifiers changed from: protected */
    public final native void nativeEncoderRelease(long handle);

    protected final native void nativeEncoderSavePNGs(long handle, String outputDir);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native void nativeEncoderSetCompressMode(long handle, boolean mode);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native void nativeEncoderSetFullRectMode(long handle, boolean mode);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native void nativeEncoderSetGifLimitedAlpha(int a16);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native void nativeEncoderSetOptimization(long handle, boolean skipFirst, boolean skipPalette, boolean skipColor, int zipLevel);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native void nativeEncoderSetTrueColorBoost(long handle, boolean set);

    /* JADX INFO: Access modifiers changed from: protected */
    public final native int nativeEncoderVersion();
}
