package org.light;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import org.light.device.LightDeviceProperty;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightTestCase {
    private long nativeContext = 0;

    static {
        LibraryLoadUtils.loadLibrary("light-sdk");
        nativeInit();
    }

    public static native LightTestCase Make(String str, String str2, String str3, String str4, int i3, int i16, float f16, long j3);

    public static LightTestCase Make(String str, String str2, String str3, String str4, int i3, int i16, float f16, EGLContext eGLContext) {
        long j3;
        if (eGLContext == null) {
            return null;
        }
        if (eGLContext != EGL14.EGL_NO_CONTEXT) {
            if (LightDeviceProperty.VERSION.SDK_INT >= 21) {
                j3 = eGLContext.getNativeHandle();
            } else {
                j3 = eGLContext.getHandle();
            }
        } else {
            j3 = 0;
        }
        return Make(str, str2, str3, str4, i3, i16, f16, j3);
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    protected void finalize() throws Throwable {
        super.finalize();
        nativeFinalize();
    }

    public void release() {
        nativeRelease();
    }

    public native LightTestResult run();

    public native void setFrameInterval(long j3);

    public native void setSaveResultDirectory(String str);

    public native void setSimilarityThreshold(float f16);
}
