package com.epicgames.ue4;

import android.hardware.HardwareBuffer;
import android.os.Build;
import android.os.ParcelFileDescriptor;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GraphicBuffer {
    private static final int EGL_NO_NATIVE_FENCE_FD_ANDROID = -1;
    public static Logger Log = new Logger("UE4", "UE4");
    private static boolean isFenceEnabled = true;
    private long nativeInstance;

    GraphicBuffer(long j3) {
        this.nativeInstance = j3;
    }

    public static ParcelFileDescriptor createFence() {
        int nativeCreateFence;
        if (!isFenceEnabled || (nativeCreateFence = nativeCreateFence()) == -1) {
            return null;
        }
        return ParcelFileDescriptor.adoptFd(nativeCreateFence);
    }

    public static GraphicBuffer fromHardwareBuffer(HardwareBuffer hardwareBuffer) {
        return new GraphicBuffer(nativeFromHardwareBuffer(hardwareBuffer));
    }

    public static GraphicBuffer fromTexture(int i3, int i16, int i17) {
        return new GraphicBuffer(nativeFromTexture(i3, i16, i17));
    }

    public static GraphicBuffer fromUERenderTexture(int i3, int i16) {
        return new GraphicBuffer(nativeFromUERenderTexture(i3, i16));
    }

    public static boolean isFenceEnabled() {
        return isFenceEnabled;
    }

    public static boolean isSupport() {
        boolean z16;
        boolean z17;
        try {
            z16 = nativeSupport();
        } catch (Throwable th5) {
            Log.error("GraphicBuffer support() error", th5);
            z16 = false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    private static native boolean nativeBindGLTexture(long j3, int i3);

    private static native void nativeBindUETexture(long j3, int i3);

    private static native int nativeCreateFence();

    private static native long nativeFromHardwareBuffer(HardwareBuffer hardwareBuffer);

    private static native long nativeFromTexture(int i3, int i16, int i17);

    private static native long nativeFromUERenderTexture(int i3, int i16);

    private static native int nativeGetFenceForUERender(long j3);

    private static native HardwareBuffer nativeGetHardwareBuffer(long j3);

    private static native void nativeRelease(long j3);

    private static native void nativeSavePng(long j3, String str);

    private static native void nativeSetFenceEnable(boolean z16);

    private static native boolean nativeSupport();

    private static native boolean nativeWaitFence(int i3);

    public static void setFenceEnable(boolean z16) {
        isFenceEnabled = z16;
        nativeSetFenceEnable(z16);
    }

    public static boolean waitFence(ParcelFileDescriptor parcelFileDescriptor) {
        int detachFd;
        if (!isFenceEnabled || parcelFileDescriptor == null || (detachFd = parcelFileDescriptor.detachFd()) == -1) {
            return false;
        }
        return nativeWaitFence(detachFd);
    }

    public boolean bindGLTexture(int i3) {
        return nativeBindGLTexture(this.nativeInstance, i3);
    }

    public void bindUETexture(int i3) {
        nativeBindUETexture(this.nativeInstance, i3);
    }

    public void debugSavePng(String str) {
        nativeSavePng(this.nativeInstance, str);
    }

    public ParcelFileDescriptor getFenceForUERender() {
        int nativeGetFenceForUERender;
        if (!isFenceEnabled || (nativeGetFenceForUERender = nativeGetFenceForUERender(this.nativeInstance)) == -1) {
            return null;
        }
        return ParcelFileDescriptor.adoptFd(nativeGetFenceForUERender);
    }

    public HardwareBuffer getHardwareBuffer() {
        return nativeGetHardwareBuffer(this.nativeInstance);
    }

    public void release() {
        nativeRelease(this.nativeInstance);
    }
}
