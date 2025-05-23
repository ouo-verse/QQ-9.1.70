package com.google.android.filament.utils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AutomationEngine {

    /* renamed from: a, reason: collision with root package name */
    private final long f33065a;

    public AutomationEngine() {
        long nCreateDefaultAutomationEngine = nCreateDefaultAutomationEngine();
        this.f33065a = nCreateDefaultAutomationEngine;
        if (nCreateDefaultAutomationEngine != 0) {
        } else {
            throw new IllegalStateException("Couldn't create AutomationEngine");
        }
    }

    private static native void nApplySettings(long j3, String str, long j16, long[] jArr, long j17, int i3, int[] iArr, long j18, long j19, long j26);

    private static native long nCreateAutomationEngine(String str);

    private static native long nCreateDefaultAutomationEngine();

    private static native void nDestroy(long j3);

    private static native long nGetColorGrading(long j3, long j16);

    private static native void nGetViewerOptions(long j3, Object obj);

    private static native void nSetOptions(long j3, float f16, int i3, boolean z16);

    private static native boolean nShouldClose(long j3);

    private static native void nSignalBatchMode(long j3);

    private static native void nStartBatchMode(long j3);

    private static native void nStartRunning(long j3);

    private static native void nStopRunning(long j3);

    private static native void nTick(long j3, long j16, long[] jArr, long j17, float f16);

    protected void finalize() throws Throwable {
        nDestroy(this.f33065a);
        super.finalize();
    }
}
