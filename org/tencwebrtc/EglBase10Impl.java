package org.tencwebrtc;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.support.annotation.Nullable;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.tencwebrtc.EglBase;
import org.tencwebrtc.EglBase10;

/* compiled from: P */
/* loaded from: classes29.dex */
class EglBase10Impl implements EglBase10 {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;

    @Nullable
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface = EGL10.EGL_NO_SURFACE;
    private final EGL10 egl = (EGL10) EGLContext.getEGL();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class Context implements EglBase10.Context {
        private final EGLContext eglContext;

        public Context(EGLContext eGLContext) {
            this.eglContext = eGLContext;
        }

        @Override // org.tencwebrtc.EglBase.Context
        public long getNativeEglContext() {
            return 0L;
        }

        @Override // org.tencwebrtc.EglBase10.Context
        public EGLContext getRawContext() {
            return this.eglContext;
        }
    }

    public EglBase10Impl(EGLContext eGLContext, int[] iArr) {
        EGLDisplay eglDisplay = getEglDisplay();
        this.eglDisplay = eglDisplay;
        EGLConfig eglConfig = getEglConfig(eglDisplay, iArr);
        this.eglConfig = eglConfig;
        this.eglContext = createEglContext(eGLContext, this.eglDisplay, eglConfig);
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay != EGL10.EGL_NO_DISPLAY && this.eglContext != EGL10.EGL_NO_CONTEXT && this.eglConfig != null) {
        } else {
            throw new RuntimeException("This object has been released");
        }
    }

    private EGLContext createEglContext(@Nullable EGLContext eGLContext, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        EGLContext eglCreateContext;
        if (eGLContext != null && eGLContext == EGL10.EGL_NO_CONTEXT) {
            throw new RuntimeException("Invalid sharedContext");
        }
        int[] iArr = {12440, 2, 12344};
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        synchronized (EglBase.lock) {
            eglCreateContext = this.egl.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }
        if (eglCreateContext != EGL10.EGL_NO_CONTEXT) {
            return eglCreateContext;
        }
        throw new RuntimeException("Failed to create EGL context: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    private void createSurfaceInternal(Object obj) {
        if (!(obj instanceof SurfaceHolder) && !(obj instanceof SurfaceTexture)) {
            throw new IllegalStateException("Input must be either a SurfaceHolder or SurfaceTexture");
        }
        checkIsNotReleased();
        if (this.eglSurface == EGL10.EGL_NO_SURFACE) {
            EGLSurface eglCreateWindowSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, obj, new int[]{12344});
            this.eglSurface = eglCreateWindowSurface;
            if (eglCreateWindowSurface != EGL10.EGL_NO_SURFACE) {
                return;
            }
            throw new RuntimeException("Failed to create window surface: 0x" + Integer.toHexString(this.egl.eglGetError()));
        }
        throw new RuntimeException("Already has an EGLSurface");
    }

    private EGLConfig getEglConfig(EGLDisplay eGLDisplay, int[] iArr) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        if (this.egl.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, 1, iArr2)) {
            if (iArr2[0] > 0) {
                EGLConfig eGLConfig = eGLConfigArr[0];
                if (eGLConfig != null) {
                    return eGLConfig;
                }
                throw new RuntimeException("eglChooseConfig returned null");
            }
            throw new RuntimeException("Unable to find any matching EGL config");
        }
        throw new RuntimeException("eglChooseConfig failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    private EGLDisplay getEglDisplay() {
        EGLDisplay eglGetDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (this.egl.eglInitialize(eglGetDisplay, new int[2])) {
                return eglGetDisplay;
            }
            throw new RuntimeException("Unable to initialize EGL10: 0x" + Integer.toHexString(this.egl.eglGetError()));
        }
        throw new RuntimeException("Unable to get EGL10 display: 0x" + Integer.toHexString(this.egl.eglGetError()));
    }

    @Override // org.tencwebrtc.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // org.tencwebrtc.EglBase
    public void createPbufferSurface(int i3, int i16) {
        checkIsNotReleased();
        if (this.eglSurface == EGL10.EGL_NO_SURFACE) {
            EGLSurface eglCreatePbufferSurface = this.egl.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, i3, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, i16, 12344});
            this.eglSurface = eglCreatePbufferSurface;
            if (eglCreatePbufferSurface != EGL10.EGL_NO_SURFACE) {
                return;
            }
            throw new RuntimeException("Failed to create pixel buffer surface with size " + i3 + HippyTKDListViewAdapter.X + i16 + ": 0x" + Integer.toHexString(this.egl.eglGetError()));
        }
        throw new RuntimeException("Already has an EGLSurface");
    }

    @Override // org.tencwebrtc.EglBase
    public void createSurface(Surface surface) {
        createSurfaceInternal(new SurfaceHolder(surface) { // from class: org.tencwebrtc.EglBase10Impl.1FakeSurfaceHolder
            private final Surface surface;

            {
                this.surface = surface;
            }

            @Override // android.view.SurfaceHolder
            public Surface getSurface() {
                return this.surface;
            }

            @Override // android.view.SurfaceHolder
            @Nullable
            public Rect getSurfaceFrame() {
                return null;
            }

            @Override // android.view.SurfaceHolder
            public boolean isCreating() {
                return false;
            }

            @Override // android.view.SurfaceHolder
            @Nullable
            public Canvas lockCanvas() {
                return null;
            }

            @Override // android.view.SurfaceHolder
            @Nullable
            public Canvas lockCanvas(Rect rect) {
                return null;
            }

            @Override // android.view.SurfaceHolder
            public void setSizeFromLayout() {
            }

            @Override // android.view.SurfaceHolder
            public void addCallback(SurfaceHolder.Callback callback) {
            }

            @Override // android.view.SurfaceHolder
            public void removeCallback(SurfaceHolder.Callback callback) {
            }

            @Override // android.view.SurfaceHolder
            public void setFormat(int i3) {
            }

            @Override // android.view.SurfaceHolder
            public void setKeepScreenOn(boolean z16) {
            }

            @Override // android.view.SurfaceHolder
            @Deprecated
            public void setType(int i3) {
            }

            @Override // android.view.SurfaceHolder
            public void unlockCanvasAndPost(Canvas canvas) {
            }

            @Override // android.view.SurfaceHolder
            public void setFixedSize(int i3, int i16) {
            }
        });
    }

    @Override // org.tencwebrtc.EglBase
    public void detachCurrent() {
        synchronized (EglBase.lock) {
            EGL10 egl10 = this.egl;
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT)) {
                throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
            }
        }
    }

    @Override // org.tencwebrtc.EglBase
    public EglBase.Context getEglBaseContext() {
        return new Context(this.eglContext);
    }

    @Override // org.tencwebrtc.EglBase
    public boolean hasSurface() {
        if (this.eglSurface != EGL10.EGL_NO_SURFACE) {
            return true;
        }
        return false;
    }

    @Override // org.tencwebrtc.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface != EGL10.EGL_NO_SURFACE) {
            synchronized (EglBase.lock) {
                EGL10 egl10 = this.egl;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = this.eglSurface;
                if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                    throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
                }
            }
            return;
        }
        throw new RuntimeException("No EGLSurface - can't make current");
    }

    @Override // org.tencwebrtc.EglBase
    public void release() {
        checkIsNotReleased();
        releaseSurface();
        detachCurrent();
        this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
        this.egl.eglTerminate(this.eglDisplay);
        this.eglContext = EGL10.EGL_NO_CONTEXT;
        this.eglDisplay = EGL10.EGL_NO_DISPLAY;
        this.eglConfig = null;
    }

    @Override // org.tencwebrtc.EglBase
    public void releaseSurface() {
        EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface != EGL10.EGL_NO_SURFACE) {
            this.egl.eglDestroySurface(this.eglDisplay, eGLSurface);
            this.eglSurface = EGL10.EGL_NO_SURFACE;
        }
    }

    @Override // org.tencwebrtc.EglBase
    public int surfaceHeight() {
        int[] iArr = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, iArr);
        return iArr[0];
    }

    @Override // org.tencwebrtc.EglBase
    public int surfaceWidth() {
        int[] iArr = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, iArr);
        return iArr[0];
    }

    @Override // org.tencwebrtc.EglBase
    public void swapBuffers() {
        checkIsNotReleased();
        if (this.eglSurface != EGL10.EGL_NO_SURFACE) {
            synchronized (EglBase.lock) {
                this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
            }
            return;
        }
        throw new RuntimeException("No EGLSurface - can't swap buffers");
    }

    @Override // org.tencwebrtc.EglBase
    public void createSurface(SurfaceTexture surfaceTexture) {
        createSurfaceInternal(surfaceTexture);
    }

    @Override // org.tencwebrtc.EglBase
    public void swapBuffers(long j3) {
        swapBuffers();
    }
}
