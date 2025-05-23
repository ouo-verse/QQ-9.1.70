package com.google.android.filament;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ColorGrading {

    /* renamed from: a, reason: collision with root package name */
    long f32956a;

    private static native long nBuilderBuild(long j3, long j16);

    private static native void nBuilderChannelMixer(long j3, float[] fArr, float[] fArr2, float[] fArr3);

    private static native void nBuilderContrast(long j3, float f16);

    private static native void nBuilderCurves(long j3, float[] fArr, float[] fArr2, float[] fArr3);

    private static native void nBuilderDimensions(long j3, int i3);

    private static native void nBuilderExposure(long j3, float f16);

    private static native void nBuilderFormat(long j3, int i3);

    private static native void nBuilderGamutMapping(long j3, boolean z16);

    private static native void nBuilderLuminanceScaling(long j3, boolean z16);

    private static native void nBuilderNightAdaptation(long j3, float f16);

    private static native void nBuilderQuality(long j3, int i3);

    private static native void nBuilderSaturation(long j3, float f16);

    private static native void nBuilderShadowsMidtonesHighlights(long j3, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    private static native void nBuilderSlopeOffsetPower(long j3, float[] fArr, float[] fArr2, float[] fArr3);

    private static native void nBuilderToneMapper(long j3, long j16);

    private static native void nBuilderToneMapping(long j3, int i3);

    private static native void nBuilderVibrance(long j3, float f16);

    private static native void nBuilderWhiteBalance(long j3, float f16, float f17);

    private static native long nCreateBuilder();

    private static native void nDestroyBuilder(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f32956a = 0L;
    }

    public long b() {
        long j3 = this.f32956a;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed ColorGrading");
    }
}
