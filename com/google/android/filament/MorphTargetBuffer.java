package com.google.android.filament;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MorphTargetBuffer {

    /* renamed from: a, reason: collision with root package name */
    private long f32966a;

    private static native long nBuilderBuild(long j3, long j16);

    private static native void nBuilderCount(long j3, int i3);

    private static native void nBuilderVertexCount(long j3, int i3);

    private static native long nCreateBuilder();

    private static native void nDestroyBuilder(long j3);

    private static native int nGetCount(long j3);

    private static native int nGetVertexCount(long j3);

    private static native int nSetPositionsAt(long j3, long j16, int i3, float[] fArr, int i16);

    private static native int nSetTangentsAt(long j3, long j16, int i3, short[] sArr, int i16);

    public long a() {
        long j3 = this.f32966a;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed MorphTargetBuffer");
    }

    public int b() {
        return nGetVertexCount(this.f32966a);
    }
}
