package com.google.android.filament;

import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BufferObject {

    /* renamed from: a, reason: collision with root package name */
    private long f32955a;

    private static native void nBuilderBindingType(long j3, int i3);

    private static native long nBuilderBuild(long j3, long j16);

    private static native void nBuilderSize(long j3, int i3);

    private static native long nCreateBuilder();

    private static native void nDestroyBuilder(long j3);

    private static native int nGetByteCount(long j3);

    private static native int nSetBuffer(long j3, long j16, Buffer buffer, int i3, int i16, int i17, Object obj, Runnable runnable);

    public long a() {
        long j3 = this.f32955a;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed BufferObject");
    }
}
