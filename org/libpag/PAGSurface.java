package org.libpag;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.HardwareBuffer;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Build;
import android.util.Pair;
import android.view.Surface;

/* loaded from: classes29.dex */
public class PAGSurface {

    /* renamed from: a, reason: collision with root package name */
    private Surface f423752a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f423753b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f423754c = 0;
    long nativeSurface;

    static {
        org.extra.tools.a.b("pag");
        nativeInit();
    }

    PAGSurface(long j3) {
        this.nativeSurface = j3;
    }

    public static PAGSurface FromSurface(Surface surface) {
        return FromSurface(surface, EGL14.EGL_NO_CONTEXT);
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture) {
        return FromSurfaceTexture(surfaceTexture, EGL14.EGL_NO_CONTEXT);
    }

    public static PAGSurface FromTexture(int i3, int i16, int i17) {
        return FromTexture(i3, i16, i17, false);
    }

    public static PAGSurface FromTextureForAsyncThread(int i3, int i16, int i17) {
        return FromTextureForAsyncThread(i3, i16, i17, false);
    }

    public static PAGSurface MakeOffscreen(int i3, int i16) {
        long SetupOffscreen = SetupOffscreen(i3, i16);
        if (SetupOffscreen == 0) {
            return null;
        }
        return new PAGSurface(SetupOffscreen);
    }

    private static native long SetupFromSurfaceWithGLContext(Surface surface, long j3);

    public static native long SetupFromTexture(int i3, int i16, int i17, boolean z16, boolean z17);

    private static native long SetupOffscreen(int i3, int i16);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean clearAll();

    public native boolean copyPixelsTo(Bitmap bitmap);

    protected void finalize() {
        nativeFinalize();
    }

    public native void freeCache();

    public native int height();

    public Bitmap makeSnapshot() {
        Pair a16 = a.a(width(), height(), true);
        if (a16.first == null) {
            return null;
        }
        Object obj = a16.second;
        if (obj != null && Build.VERSION.SDK_INT >= 26) {
            ((HardwareBuffer) obj).close();
        }
        if (!copyPixelsTo((Bitmap) a16.first)) {
            return null;
        }
        return (Bitmap) a16.first;
    }

    public void release() {
        Surface surface;
        freeCache();
        if (this.f423753b && (surface = this.f423752a) != null) {
            surface.release();
        }
        nativeRelease();
    }

    public native void updateSize();

    public native int width();

    public static PAGSurface FromSurface(Surface surface, EGLContext eGLContext) {
        if (surface == null) {
            return null;
        }
        long SetupFromSurfaceWithGLContext = SetupFromSurfaceWithGLContext(surface, (eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT) ? 0L : eGLContext.getNativeHandle());
        if (SetupFromSurfaceWithGLContext == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(SetupFromSurfaceWithGLContext);
        pAGSurface.f423752a = surface;
        return pAGSurface;
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture, EGLContext eGLContext) {
        if (surfaceTexture == null) {
            return null;
        }
        PAGSurface FromSurface = FromSurface(new Surface(surfaceTexture), eGLContext);
        if (FromSurface != null) {
            FromSurface.f423753b = true;
        }
        return FromSurface;
    }

    public static PAGSurface FromTexture(int i3, int i16, int i17, boolean z16) {
        long SetupFromTexture = SetupFromTexture(i3, i16, i17, z16, false);
        if (SetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(SetupFromTexture);
        pAGSurface.f423754c = i3;
        return pAGSurface;
    }

    public static PAGSurface FromTextureForAsyncThread(int i3, int i16, int i17, boolean z16) {
        long SetupFromTexture = SetupFromTexture(i3, i16, i17, z16, true);
        if (SetupFromTexture == 0) {
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(SetupFromTexture);
        pAGSurface.f423754c = i3;
        return pAGSurface;
    }
}
