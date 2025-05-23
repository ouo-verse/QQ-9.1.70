package org.light;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightTestResult {
    private long nativeContext = 0;

    static {
        LibraryLoadUtils.loadLibrary("light-sdk");
        nativeInit();
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    public native void exportToFile(String str);

    public native long failedFrameCount();

    protected void finalize() throws Throwable {
        super.finalize();
        nativeFinalize();
    }

    public native long successFrameCount();

    public native long totalFrameCount();
}
