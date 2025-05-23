package org.light.gles;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.ark.EGLContextHolder;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;

/* compiled from: P */
@TargetApi(17)
/* loaded from: classes29.dex */
public final class EglCore {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private static final String TAG = "EglCore";
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private int mGlVersion;
    private final Throwable throwableForStackTrace;

    public EglCore() {
        this(true);
    }

    private void checkEglError(String str) {
        EGL14.eglGetError();
    }

    private EGLConfig getConfig(int i3, int i16) {
        int i17;
        if (i16 >= 3) {
            i17 = 68;
        } else {
            i17 = 4;
        }
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i17, 12344, 0, 12344};
        if ((i3 & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.mEGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return null;
        }
        return eGLConfigArr[0];
    }

    public static void logCurrent(String str) {
        EGL14.eglGetCurrentDisplay();
        EGL14.eglGetCurrentContext();
        EGL14.eglGetCurrentSurface(12377);
    }

    public EGLSurface createOffscreenSurface(int i3, int i16) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, i3, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, i16, 12344}, 0);
        checkEglError("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public EGLSurface createWindowSurface(Object obj, EGLConfig eGLConfig) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, eGLConfig, obj, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
                release();
            }
        } finally {
            super.finalize();
        }
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public int getGlVersion() {
        return this.mGlVersion;
    }

    public boolean isCurrent(EGLSurface eGLSurface) {
        if (this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377))) {
            return true;
        }
        return false;
    }

    public void makeCurrent(EGLSurface eGLSurface, EGLContext eGLContext) {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
    }

    public void makeNothingCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
        } else {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public String queryString(int i3) {
        return EGL14.eglQueryString(this.mEGLDisplay, i3);
    }

    public int querySurface(EGLSurface eGLSurface, int i3) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, eGLSurface, i3, iArr, 0);
        return iArr[0];
    }

    public void release() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGLContext eGLContext = this.mEGLContext;
            if (eGLContext == EGL14.EGL_NO_CONTEXT) {
                return;
            }
            EGL14.eglDestroyContext(this.mEGLDisplay, eGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    public void releaseSurface(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.mEGLDisplay, eGLSurface);
    }

    @TargetApi(18)
    public void setPresentationTime(EGLSurface eGLSurface, long j3) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, eGLSurface, j3);
    }

    public boolean swapBuffers(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, eGLSurface);
    }

    public EglCore(boolean z16) {
        this(z16, null, 0);
    }

    public EglCore(EGLContext eGLContext, int i3) {
        this(true, eGLContext, i3);
    }

    public void makeCurrent(EGLSurface eGLSurface) {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext);
    }

    public EglCore(boolean z16, EGLContext eGLContext, int i3) {
        EGLConfig config;
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        this.throwableForStackTrace = new Throwable();
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.mEGLDisplay = eglGetDisplay;
            if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            if (z16) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    if ((i3 & 2) != 0 && (config = getConfig(i3, 3)) != null) {
                        EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEGLDisplay, config, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 3, 12344}, 0);
                        if (EGL14.eglGetError() == 12288) {
                            this.mEGLConfig = config;
                            this.mEGLContext = eglCreateContext;
                            this.mGlVersion = 3;
                        }
                    }
                    if (this.mEGLContext == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig config2 = getConfig(i3, 2);
                        if (config2 != null) {
                            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.mEGLDisplay, config2, eGLContext, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                            checkEglError("eglCreateContext");
                            this.mEGLConfig = config2;
                            this.mEGLContext = eglCreateContext2;
                            this.mGlVersion = 2;
                        } else {
                            throw new RuntimeException("Unable to find a suitable EGLConfig");
                        }
                    }
                    EGL14.eglQueryContext(this.mEGLDisplay, this.mEGLContext, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, new int[1], 0);
                    return;
                }
                this.mEGLDisplay = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            EGLConfig config3 = getConfig(i3, 3);
            if (config3 != null) {
                this.mEGLConfig = config3;
                this.mGlVersion = 3;
                return;
            }
            return;
        }
        throw new RuntimeException("EGL already set up");
    }

    public void makeCurrent(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLDisplay eGLDisplay2 = EGL14.EGL_NO_DISPLAY;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, this.mEGLContext)) {
            throw new RuntimeException("eglMakeCurrent(draw,read) failed");
        }
    }

    public EGLSurface createWindowSurface(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, obj, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }
}
