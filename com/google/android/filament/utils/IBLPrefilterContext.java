package com.google.android.filament.utils;

/* loaded from: classes2.dex */
public class IBLPrefilterContext {
    private static native long nCreate(long j3);

    private static native long nCreateEquirectHelper(long j3);

    private static native long nCreateSpecularFilter(long j3);

    private static native void nDestroy(long j3);

    private static native void nDestroyEquirectHelper(long j3);

    private static native void nDestroySpecularFilter(long j3);

    private static native long nEquirectHelperRun(long j3, long j16);

    private static native long nSpecularFilterRun(long j3, long j16);
}
