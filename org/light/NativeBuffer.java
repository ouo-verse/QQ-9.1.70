package org.light;

import android.hardware.HardwareBuffer;
import android.os.ParcelFileDescriptor;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NativeBuffer {
    private static final int EGL_NO_NATIVE_FENCE_FD_ANDROID = -1;
    private static final String TAG = "NativeBuffer";
    private static boolean available = false;
    private HardwareBuffer buffer;
    private boolean eglFenceEnabled;
    private long nativeContext;

    static {
        try {
            available = available();
        } catch (Throwable th5) {
            LightLogUtil.e(TAG, "NativeBuffer available() error:" + th5);
        }
        LightLogUtil.d(TAG, "NativeBuffer available():" + available);
        if (!available) {
            LightLogUtil.e(TAG, "NativeBuffer not available");
        }
    }

    public NativeBuffer(HardwareBuffer hardwareBuffer) {
        this.nativeContext = 0L;
        this.buffer = null;
        this.eglFenceEnabled = false;
        LightLogUtil.d(TAG, "create from buffer");
        this.nativeContext = createFromBuffer(hardwareBuffer);
        this.buffer = hardwareBuffer;
        init();
    }

    private static native boolean available();

    private native boolean bindTexture(long j3, int i3);

    private native long create(int i3, int i16);

    private static native int createEGLFence();

    private native long createFromBuffer(HardwareBuffer hardwareBuffer);

    private native void destroy(long j3);

    private native int getBindTexture(long j3);

    private native HardwareBuffer getBuffer(long j3);

    private native int getHeight(long j3);

    private native int getWidth(long j3);

    private void init() {
        this.eglFenceEnabled = isFenceEnabled();
    }

    public static boolean isAvailable() {
        return available;
    }

    private static native boolean isEglFenceEnabled();

    public static boolean isFenceEnabled() {
        return isEglFenceEnabled();
    }

    private native boolean resize(long j3, int i3, int i16);

    private static native void setEglFenceEnabled(boolean z16);

    public static void setFenceEnabled(boolean z16) {
        setEglFenceEnabled(z16);
    }

    private static native boolean waitEGLFence(int i3);

    public boolean bindTexture(int i3) {
        long j3 = this.nativeContext;
        if (j3 != 0) {
            return bindTexture(j3, i3);
        }
        return false;
    }

    public ParcelFileDescriptor createFence() {
        int createEGLFence;
        if (!this.eglFenceEnabled || (createEGLFence = createEGLFence()) == -1) {
            return null;
        }
        return ParcelFileDescriptor.adoptFd(createEGLFence);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }

    public int getBindTexture() {
        long j3 = this.nativeContext;
        if (j3 != 0) {
            return getBindTexture(j3);
        }
        return 0;
    }

    public int getBufferHeight() {
        long j3 = this.nativeContext;
        if (j3 != 0) {
            return getHeight(j3);
        }
        return 0;
    }

    public int getBufferWidth() {
        long j3 = this.nativeContext;
        if (j3 != 0) {
            return getWidth(j3);
        }
        return 0;
    }

    public HardwareBuffer getHardwareBuffer() {
        if (this.nativeContext == 0) {
            return null;
        }
        HardwareBuffer hardwareBuffer = this.buffer;
        if (hardwareBuffer != null) {
            hardwareBuffer.close();
            this.buffer = null;
        }
        HardwareBuffer buffer = getBuffer(this.nativeContext);
        this.buffer = buffer;
        return buffer;
    }

    public void release() {
        if (this.nativeContext != 0) {
            LightLogUtil.d(TAG, "destroy");
            HardwareBuffer hardwareBuffer = this.buffer;
            if (hardwareBuffer != null) {
                hardwareBuffer.close();
                this.buffer = null;
            }
            destroy(this.nativeContext);
            this.nativeContext = 0L;
        }
    }

    public boolean updateSize(int i3, int i16) {
        long j3 = this.nativeContext;
        if (j3 != 0) {
            return resize(j3, i3, i16);
        }
        return false;
    }

    public boolean waitFence(ParcelFileDescriptor parcelFileDescriptor) {
        int detachFd;
        if (parcelFileDescriptor != null && (detachFd = parcelFileDescriptor.detachFd()) != -1) {
            return waitEGLFence(detachFd);
        }
        return false;
    }

    public NativeBuffer(int i3, int i16) {
        this.nativeContext = 0L;
        this.buffer = null;
        this.eglFenceEnabled = false;
        LightLogUtil.d(TAG, "create new");
        this.nativeContext = create(i3, i16);
        init();
    }
}
