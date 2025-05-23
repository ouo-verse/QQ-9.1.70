package com.google.android.filament.utils;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Size;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Manipulator {

    /* renamed from: b, reason: collision with root package name */
    private static final Mode[] f33070b = Mode.values();

    /* renamed from: a, reason: collision with root package name */
    private final long f33071a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Mode {
        ORBIT,
        MAP,
        FREE_FLIGHT
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final C0226a f33072a;

        /* renamed from: b, reason: collision with root package name */
        private final long f33073b;

        /* compiled from: P */
        /* renamed from: com.google.android.filament.utils.Manipulator$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private static class C0226a {

            /* renamed from: a, reason: collision with root package name */
            private final long f33074a;

            C0226a(long j3) {
                this.f33074a = j3;
            }

            public void finalize() {
                try {
                    super.finalize();
                } catch (Throwable unused) {
                }
                Manipulator.nDestroyBuilder(this.f33074a);
            }
        }

        public a() {
            long a16 = Manipulator.a();
            this.f33073b = a16;
            this.f33072a = new C0226a(a16);
        }

        @NonNull
        public Manipulator a(Mode mode) {
            long nBuilderBuild = Manipulator.nBuilderBuild(this.f33073b, mode.ordinal());
            if (nBuilderBuild != 0) {
                return new Manipulator(nBuilderBuild);
            }
            throw new IllegalStateException("Couldn't create Manipulator");
        }

        @NonNull
        public a b(float f16, float f17, float f18) {
            Manipulator.nBuilderTargetPosition(this.f33073b, f16, f17, f18);
            return this;
        }

        @NonNull
        public a c(@IntRange(from = 1) int i3, @IntRange(from = 1) int i16) {
            Manipulator.nBuilderViewport(this.f33073b, i3, i16);
            return this;
        }
    }

    public Manipulator(long j3) {
        this.f33071a = j3;
    }

    static /* synthetic */ long a() {
        return nCreateBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nBuilderBuild(long j3, int i3);

    private static native void nBuilderFarPlane(long j3, float f16);

    private static native void nBuilderFlightMaxMoveSpeed(long j3, float f16);

    private static native void nBuilderFlightMoveDamping(long j3, float f16);

    private static native void nBuilderFlightPanSpeed(long j3, float f16, float f17);

    private static native void nBuilderFlightSpeedSteps(long j3, int i3);

    private static native void nBuilderFlightStartOrientation(long j3, float f16, float f17);

    private static native void nBuilderFlightStartPosition(long j3, float f16, float f17, float f18);

    private static native void nBuilderFovDegrees(long j3, float f16);

    private static native void nBuilderFovDirection(long j3, int i3);

    private static native void nBuilderGroundPlane(long j3, float f16, float f17, float f18, float f19);

    private static native void nBuilderMapExtent(long j3, float f16, float f17);

    private static native void nBuilderMapMinDistance(long j3, float f16);

    private static native void nBuilderOrbitHomePosition(long j3, float f16, float f17, float f18);

    private static native void nBuilderOrbitSpeed(long j3, float f16, float f17);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderTargetPosition(long j3, float f16, float f17, float f18);

    private static native void nBuilderUpVector(long j3, float f16, float f17, float f18);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderViewport(long j3, int i3, int i16);

    private static native void nBuilderZoomSpeed(long j3, float f16);

    private static native long nCreateBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    private static native void nDestroyManipulator(long j3);

    private static native long nGetCurrentBookmark(long j3);

    private static native long nGetHomeBookmark(long j3);

    private static native void nGetLookAtDouble(long j3, double[] dArr, double[] dArr2, double[] dArr3);

    private static native void nGetLookAtFloat(long j3, float[] fArr, float[] fArr2, float[] fArr3);

    private static native int nGetMode(long j3);

    private static native void nGrabBegin(long j3, int i3, int i16, boolean z16);

    private static native void nGrabEnd(long j3);

    private static native void nGrabUpdate(long j3, int i3, int i16);

    private static native void nJumpToBookmark(long j3, long j16);

    private static native void nKeyDown(long j3, int i3);

    private static native void nKeyUp(long j3, int i3);

    private static native void nRaycast(long j3, int i3, int i16, float[] fArr);

    private static native void nScroll(long j3, int i3, int i16, float f16);

    private static native void nSetViewport(long j3, int i3, int i16);

    private static native void nUpdate(long j3, float f16);

    public Bookmark f() {
        return new Bookmark(nGetCurrentBookmark(this.f33071a));
    }

    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable unused) {
        }
        nDestroyManipulator(this.f33071a);
    }

    public void g(@NonNull @Size(min = 3) double[] dArr, @NonNull @Size(min = 3) double[] dArr2, @NonNull @Size(min = 3) double[] dArr3) {
        nGetLookAtDouble(this.f33071a, dArr, dArr2, dArr3);
    }

    public void h(int i3, int i16, boolean z16) {
        nGrabBegin(this.f33071a, i3, i16, z16);
    }

    public void i() {
        nGrabEnd(this.f33071a);
    }

    public void j(int i3, int i16) {
        nGrabUpdate(this.f33071a, i3, i16);
    }

    public void k(Bookmark bookmark) {
        nJumpToBookmark(this.f33071a, bookmark.a());
    }

    public void l(int i3, int i16, float f16) {
        nScroll(this.f33071a, i3, i16, f16);
    }

    public void m(int i3, int i16) {
        nSetViewport(this.f33071a, i3, i16);
    }
}
