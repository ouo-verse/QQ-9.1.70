package org.light;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.view.Surface;
import org.light.device.LightDeviceProperty;
import org.light.utils.LightGLUtils;
import org.light.utils.LightLogUtil;
import org.light.utils.SimpleRenderer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightSurface {
    private static final String TAG = "LightSurface";
    private long nativeContext;
    private SimpleRenderer simpleRenderer = null;
    private NativeBuffer nativeBuffer = null;

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    public static LightSurface makeFromNativeTexture(int i3, int i16, int i17, boolean z16, boolean z17) {
        return makeFromTextureInternal(i3, i16, i17, z16, z17, false);
    }

    public static LightSurface makeFromSurface(Surface surface, EGLContext eGLContext) {
        return makeFromSurface(surface, eGLContext, true);
    }

    public static LightSurface makeFromSurfaceTexture(SurfaceTexture surfaceTexture) {
        return makeFromSurfaceTexture(surfaceTexture, EGL14.EGL_NO_CONTEXT);
    }

    public static LightSurface makeFromTexture(int i3, int i16, int i17) {
        return makeFromTextureInternal(i3, i16, i17, false, false, false);
    }

    private static LightSurface makeFromTextureInternal(int i3, int i16, int i17, boolean z16, boolean z17, boolean z18) {
        return nativeMakeFromTexture(i3, i16, i17, z16, z17);
    }

    private native void nativeClearRenderCurrent();

    private native void nativeFinalize();

    private native void nativeFreeCache();

    private native long nativeGetRenderCurrentGLContext();

    private static native void nativeInit();

    private static native LightSurface nativeMakeFromSurface(Surface surface, long j3, boolean z16);

    private static native LightSurface nativeMakeFromTexture(int i3, int i16, int i17, boolean z16, boolean z17);

    private native void nativeMakeRenderCurrent();

    private native void nativeRelease();

    private native void nativeUpdateSize(int i3, int i16);

    public void clearRenderCurrent() {
        nativeClearRenderCurrent();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.nativeContext != 0) {
            nativeFinalize();
        }
    }

    public void freeCache() {
        nativeFreeCache();
    }

    public long getRenderCurrentGLContext() {
        return nativeGetRenderCurrentGLContext();
    }

    public void makeRenderCurrent() {
        nativeMakeRenderCurrent();
    }

    public void release() {
        nativeRelease();
        SimpleRenderer simpleRenderer = this.simpleRenderer;
        if (simpleRenderer != null) {
            simpleRenderer.release();
            this.simpleRenderer = null;
        }
        NativeBuffer nativeBuffer = this.nativeBuffer;
        if (nativeBuffer != null) {
            LightGLUtils.deleteTexture(nativeBuffer.getBindTexture());
            this.nativeBuffer.release();
        }
    }

    public void updateSize(int i3, int i16) {
        nativeUpdateSize(i3, i16);
    }

    public static LightSurface makeFromSurface(Surface surface, EGLContext eGLContext, boolean z16) {
        long j3;
        if (surface == null) {
            return null;
        }
        if (eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT) {
            j3 = 0;
        } else if (LightDeviceProperty.VERSION.SDK_INT >= 21) {
            j3 = eGLContext.getNativeHandle();
        } else {
            j3 = eGLContext.getHandle();
        }
        return nativeMakeFromSurface(surface, j3, z16);
    }

    public static LightSurface makeFromSurfaceTexture(SurfaceTexture surfaceTexture, EGLContext eGLContext) {
        if (surfaceTexture == null) {
            return null;
        }
        return makeFromSurface(new Surface(surfaceTexture), eGLContext);
    }

    public static LightSurface makeFromTexture(int i3, int i16, int i17, boolean z16) {
        return makeFromTextureInternal(i3, i16, i17, z16, false, true);
    }

    public static LightSurface makeFromTexture(int i3, int i16, int i17, boolean z16, boolean z17) {
        return makeFromTextureInternal(i3, i16, i17, z16, false, z17);
    }

    public static void init() {
    }
}
