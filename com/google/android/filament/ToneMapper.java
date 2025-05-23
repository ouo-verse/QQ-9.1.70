package com.google.android.filament;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ToneMapper {

    /* renamed from: a, reason: collision with root package name */
    private final long f32983a;

    private static native long nCreateACESLegacyToneMapper();

    private static native long nCreateACESToneMapper();

    private static native long nCreateFilmicToneMapper();

    private static native long nCreateGenericToneMapper(float f16, float f17, float f18, float f19);

    private static native long nCreateLinearToneMapper();

    private static native void nDestroyToneMapper(long j3);

    private static native float nGenericGetContrast(long j3);

    private static native float nGenericGetHdrMax(long j3);

    private static native float nGenericGetMidGrayIn(long j3);

    private static native float nGenericGetMidGrayOut(long j3);

    private static native void nGenericSetContrast(long j3, float f16);

    private static native void nGenericSetHdrMax(long j3, float f16);

    private static native void nGenericSetMidGrayIn(long j3, float f16);

    private static native void nGenericSetMidGrayOut(long j3, float f16);

    protected void finalize() throws Throwable {
        try {
            super.finalize();
        } finally {
            nDestroyToneMapper(this.f32983a);
        }
    }
}
