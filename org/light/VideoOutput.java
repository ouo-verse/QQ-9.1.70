package org.light;

import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoOutput {
    private static final String TAG = "VideoOutput";
    private long nativeContext;

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native boolean nativeReadSample(long j3);

    private native boolean nativeReadSampleCheckFlush(long j3);

    private native void nativeRelease();

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativeContext != 0) {
            nativeFinalize();
        }
    }

    public boolean readSample(long j3) {
        return nativeReadSample(j3);
    }

    public boolean readSampleCheckFlush(long j3) {
        return nativeReadSampleCheckFlush(j3);
    }

    public final void release() {
        nativeRelease();
    }

    public static void init() {
    }
}
