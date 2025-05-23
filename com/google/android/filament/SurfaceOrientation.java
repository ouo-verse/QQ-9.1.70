package com.google.android.filament;

import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SurfaceOrientation {
    private static native long nBuilderBuild(long j3);

    private static native void nBuilderNormals(long j3, Buffer buffer, int i3, int i16);

    private static native void nBuilderPositions(long j3, Buffer buffer, int i3, int i16);

    private static native void nBuilderTangents(long j3, Buffer buffer, int i3, int i16);

    private static native void nBuilderTriangleCount(long j3, int i3);

    private static native void nBuilderTriangles16(long j3, Buffer buffer, int i3);

    private static native void nBuilderTriangles32(long j3, Buffer buffer, int i3);

    private static native void nBuilderUVs(long j3, Buffer buffer, int i3, int i16);

    private static native void nBuilderVertexCount(long j3, int i3);

    private static native long nCreateBuilder();

    private static native void nDestroy(long j3);

    private static native void nDestroyBuilder(long j3);

    private static native void nGetQuatsAsFloat(long j3, Buffer buffer, int i3);

    private static native void nGetQuatsAsHalf(long j3, Buffer buffer, int i3);

    private static native void nGetQuatsAsShort(long j3, Buffer buffer, int i3);

    private static native int nGetVertexCount(long j3);
}
