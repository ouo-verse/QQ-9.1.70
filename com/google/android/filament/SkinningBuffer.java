package com.google.android.filament;

import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SkinningBuffer {

    /* renamed from: a, reason: collision with root package name */
    private long f32977a;

    private static native void nBuilderBoneCount(long j3, int i3);

    private static native long nBuilderBuild(long j3, long j16);

    private static native void nBuilderInitialize(long j3, boolean z16);

    private static native long nCreateBuilder();

    private static native void nDestroyBuilder(long j3);

    private static native int nGetBoneCount(long j3);

    private static native int nSetBonesAsMatrices(long j3, long j16, Buffer buffer, int i3, int i16, int i17);

    private static native int nSetBonesAsQuaternions(long j3, long j16, Buffer buffer, int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f32977a = 0L;
    }

    public long b() {
        long j3 = this.f32977a;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed IndexBuffer");
    }
}
