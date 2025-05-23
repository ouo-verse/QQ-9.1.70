package com.tencent.mobileqq.qzoneplayer.videorenderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class TextureSurfaceRenderer implements Runnable, OnSurfaceSizeChangedListener {
    static IPatchRedirector $redirector_ = null;
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static String LOG_TAG;
    private EGL10 egl;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private int frames;
    protected int height;
    private long lastFpsOutput;
    private final Object mLock;
    private boolean running;
    protected final SurfaceTexture texture;
    protected int width;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13017);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            LOG_TAG = "TextureSurfaceRenderer";
        }
    }

    public TextureSurfaceRenderer(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.lastFpsOutput = 0L;
        this.texture = surfaceTexture;
        this.width = i3;
        this.height = i16;
        this.running = true;
        this.mLock = new Object();
        new BaseThread(this, "TextureSurfaceRenderer").start();
    }

    private EGLConfig chooseEglConfig() {
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (this.egl.eglChooseConfig(this.eglDisplay, getConfig(), eGLConfigArr, 1, iArr)) {
            if (iArr[0] > 0) {
                return eGLConfigArr[0];
            }
            return null;
        }
        throw new IllegalArgumentException("Failed to choose config: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
    }

    private EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
    }

    private void deinitEGL() {
        EGL10 egl10 = this.egl;
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
        this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
        this.egl.eglTerminate(this.eglDisplay);
        PlayerUtils.log(4, LOG_TAG, "OpenGL deinit OK.");
    }

    private int[] getConfig() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }

    private void initEGL() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.egl = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.eglDisplay = eglGetDisplay;
        this.egl.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig chooseEglConfig = chooseEglConfig();
        this.eglContext = createContext(this.egl, this.eglDisplay, chooseEglConfig);
        EGLSurface eglCreateWindowSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, chooseEglConfig, this.texture, null);
        this.eglSurface = eglCreateWindowSurface;
        if (eglCreateWindowSurface != null && eglCreateWindowSurface != EGL10.EGL_NO_SURFACE) {
            if (this.egl.eglMakeCurrent(this.eglDisplay, eglCreateWindowSurface, eglCreateWindowSurface, this.eglContext)) {
                return;
            }
            throw new RuntimeException("GL Make current error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
        }
        throw new RuntimeException("GL Error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
    }

    private void pingFps() {
        if (this.lastFpsOutput == 0) {
            this.lastFpsOutput = System.currentTimeMillis();
        }
        this.frames++;
        if (System.currentTimeMillis() - this.lastFpsOutput > 1000) {
            PlayerUtils.log(2, LOG_TAG, "FPS: " + this.frames);
            this.lastFpsOutput = System.currentTimeMillis();
            this.frames = 0;
        }
    }

    protected abstract void deinitGLComponents();

    protected abstract boolean draw();

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.finalize();
            this.running = false;
        }
    }

    public abstract SurfaceTexture getSurfaceTexture();

    protected abstract void initGLComponents();

    @Override // com.tencent.mobileqq.qzoneplayer.videorenderer.OnSurfaceSizeChangedListener
    public void onSurfaceSizeChanged(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.width = i3;
            this.height = i16;
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.running = false;
        PlayerUtils.log(4, LOG_TAG, "start release");
        synchronized (this.mLock) {
            try {
                this.mLock.wait(800L);
            } catch (InterruptedException e16) {
                PlayerUtils.log(4, LOG_TAG, "interrupted " + PlayerUtils.getPrintableStackTrace(e16));
            }
        }
        PlayerUtils.log(4, LOG_TAG, "released");
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            try {
                PlayerUtils.log(4, LOG_TAG, "TextureSurfaceRenderer init!");
                initEGL();
                initGLComponents();
                PlayerUtils.log(4, LOG_TAG, "OpenGL init OK.");
                while (this.running) {
                    long currentTimeMillis = System.currentTimeMillis();
                    pingFps();
                    if (draw()) {
                        this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
                    }
                    long currentTimeMillis2 = 16 - (System.currentTimeMillis() - currentTimeMillis);
                    if (currentTimeMillis2 > 0) {
                        try {
                            LockMethodProxy.sleep(currentTimeMillis2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                deinitGLComponents();
                deinitEGL();
                PlayerUtils.log(4, LOG_TAG, "TextureSurfaceRenderer done!");
                synchronized (this.mLock) {
                    this.mLock.notify();
                }
            } catch (Exception e16) {
                PlayerUtils.log(6, LOG_TAG, "TextureSurfaceRenderer Error " + e16.toString() + ", stack:\n" + PlayerUtils.getPrintableStackTrace(e16));
                PlayerUtils.log(4, LOG_TAG, "TextureSurfaceRenderer done!");
                synchronized (this.mLock) {
                    this.mLock.notify();
                }
            }
        } catch (Throwable th5) {
            PlayerUtils.log(4, LOG_TAG, "TextureSurfaceRenderer done!");
            synchronized (this.mLock) {
                this.mLock.notify();
                throw th5;
            }
        }
    }
}
