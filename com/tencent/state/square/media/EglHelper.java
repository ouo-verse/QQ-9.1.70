package com.tencent.state.square.media;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0002J(\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/square/media/EglHelper;", "", "()V", "egl", "Ljavax/microedition/khronos/egl/EGL10;", "eglConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "eglContext", "Ljavax/microedition/khronos/egl/EGLContext;", "eglDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "chooseConfig", "createContext", "getAttributes", "", "release", "", "start", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "swapBuffers", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class EglHelper {
    private static final String TAG = "Square_EglHelper";
    private EGL10 egl;
    private EGLConfig eglConfig;
    private EGLDisplay eglDisplay = EGL10.EGL_NO_DISPLAY;
    private EGLSurface eglSurface = EGL10.EGL_NO_SURFACE;
    private EGLContext eglContext = EGL10.EGL_NO_CONTEXT;

    public final void release() {
        EGL10 egl10 = this.egl;
        if (egl10 != null) {
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroySurface(this.eglDisplay, this.eglSurface);
            egl10.eglDestroyContext(this.eglDisplay, this.eglContext);
            egl10.eglTerminate(this.eglDisplay);
        }
    }

    public final boolean start(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        try {
            EGL egl = EGLContext.getEGL();
            if (egl != null) {
                EGL10 egl10 = (EGL10) egl;
                this.egl = egl10;
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                this.eglDisplay = eglGetDisplay;
                int[] iArr = new int[2];
                EGL10 egl102 = this.egl;
                Boolean valueOf = egl102 != null ? Boolean.valueOf(egl102.eglInitialize(eglGetDisplay, iArr)) : null;
                EGLConfig chooseConfig = chooseConfig();
                this.eglConfig = chooseConfig;
                EGL10 egl103 = this.egl;
                EGLSurface eglCreateWindowSurface = egl103 != null ? egl103.eglCreateWindowSurface(this.eglDisplay, chooseConfig, new Surface(surfaceTexture), null) : null;
                this.eglSurface = eglCreateWindowSurface;
                if (eglCreateWindowSurface != null && !Intrinsics.areEqual(eglCreateWindowSurface, EGL10.EGL_NO_SURFACE)) {
                    EGLContext createContext = createContext(this.egl, this.eglDisplay, this.eglConfig);
                    this.eglContext = createContext;
                    if (createContext != null && !Intrinsics.areEqual(createContext, EGL10.EGL_NO_CONTEXT)) {
                        EGL10 egl104 = this.egl;
                        if (egl104 == null) {
                            return true;
                        }
                        EGLDisplay eGLDisplay = this.eglDisplay;
                        EGLSurface eGLSurface = this.eglSurface;
                        if (egl104.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                            return true;
                        }
                        SquareLogger squareLog = SquareBaseKt.getSquareLog();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("make current error:");
                        EGL10 egl105 = this.egl;
                        sb5.append(Integer.toHexString(egl105 != null ? egl105.eglGetError() : 0));
                        sb5.append(", ");
                        sb5.append(this.eglContext);
                        sb5.append(", NO_CONTEXT: ");
                        sb5.append(EGL10.EGL_NO_CONTEXT);
                        SquareLogger.DefaultImpls.e$default(squareLog, TAG, sb5.toString(), null, 4, null);
                        return false;
                    }
                    SquareLogger squareLog2 = SquareBaseKt.getSquareLog();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("eglCreateContext error:");
                    EGL10 egl106 = this.egl;
                    sb6.append(Integer.toHexString(egl106 != null ? egl106.eglGetError() : 0));
                    sb6.append(", ");
                    sb6.append(this.eglContext);
                    SquareLogger.DefaultImpls.e$default(squareLog2, TAG, sb6.toString(), null, 4, null);
                    return false;
                }
                SquareLogger squareLog3 = SquareBaseKt.getSquareLog();
                StringBuilder sb7 = new StringBuilder();
                sb7.append("eglCreateWindowSurface error:");
                EGL10 egl107 = this.egl;
                sb7.append(Integer.toHexString(egl107 != null ? egl107.eglGetError() : 0));
                sb7.append(", eglInitialize: ");
                sb7.append(valueOf);
                SquareLogger.DefaultImpls.e$default(squareLog3, TAG, sb7.toString(), null, 4, null);
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "error:" + th5, th5);
            return false;
        }
    }

    public final void swapBuffers() {
        EGLSurface eGLSurface;
        EGL10 egl10;
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay == null || (eGLSurface = this.eglSurface) == null || (egl10 = this.egl) == null) {
            return;
        }
        egl10.eglSwapBuffers(eGLDisplay, eGLSurface);
    }

    private final EGLConfig chooseConfig() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] attributes = getAttributes();
        EGL10 egl10 = this.egl;
        if (egl10 == null || !egl10.eglChooseConfig(this.eglDisplay, attributes, eGLConfigArr, 1, iArr)) {
            return null;
        }
        return eGLConfigArr[0];
    }

    private final EGLContext createContext(EGL10 egl, EGLDisplay eglDisplay, EGLConfig eglConfig) {
        int[] iArr = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
        if (egl != null) {
            return egl.eglCreateContext(eglDisplay, eglConfig, EGL10.EGL_NO_CONTEXT, iArr);
        }
        return null;
    }

    private final int[] getAttributes() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }
}
