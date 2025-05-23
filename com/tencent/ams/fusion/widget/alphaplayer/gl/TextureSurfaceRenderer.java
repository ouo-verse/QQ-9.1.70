package com.tencent.ams.fusion.widget.alphaplayer.gl;

import android.opengl.GLUtils;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class TextureSurfaceRenderer implements Runnable {
    static IPatchRedirector $redirector_ = null;
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final String LOG_TAG = "SurfaceTest.GL";
    private final Object drawLock;
    private EGL10 egl;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private int frames;
    protected int height;
    protected volatile boolean isClearSurface;
    protected volatile boolean isPause;
    private long lastFpsOutput;
    protected final Object nativeWindow;
    private RendererStatusChangeListener rendererStatusChangeListener;
    private boolean running;
    protected int width;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface RendererStatusChangeListener {
        void onGLComponentsDestroy();

        void onGLComponentsInitFailed();

        void onGLComponentsInitSuccess();

        void onGLDestroy();

        void onGLInitFailed();

        void onGLInitSuccess();
    }

    public TextureSurfaceRenderer(Object obj, int i3, int i16, RendererStatusChangeListener rendererStatusChangeListener) {
        this(obj, i3, i16, rendererStatusChangeListener, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), rendererStatusChangeListener);
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

    private void destroyGL() {
        EGL10 egl10 = this.egl;
        EGLDisplay eGLDisplay = this.eglDisplay;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
        this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
        this.egl.eglTerminate(this.eglDisplay);
        Logger.d(LOG_TAG, "OpenGL deinit OK.");
    }

    private int[] getConfig() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }

    private void initGL() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.egl = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.eglDisplay = eglGetDisplay;
        this.egl.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig chooseEglConfig = chooseEglConfig();
        this.eglContext = createContext(this.egl, this.eglDisplay, chooseEglConfig);
        EGLSurface eglCreateWindowSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, chooseEglConfig, this.nativeWindow, null);
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
            this.lastFpsOutput = SystemClock.elapsedRealtime();
        }
        this.frames++;
        if (SystemClock.elapsedRealtime() - this.lastFpsOutput > 1000) {
            Logger.d(LOG_TAG, "FPS: " + this.frames);
            this.lastFpsOutput = SystemClock.elapsedRealtime();
            this.frames = 0;
        }
    }

    protected abstract void destroyGLComponents();

    protected abstract boolean draw();

    public void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.finalize();
        this.running = false;
        this.rendererStatusChangeListener = null;
    }

    protected abstract void initGLComponents();

    public void onPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        this.isClearSurface = z16;
        this.isPause = true;
        synchronized (this.drawLock) {
            this.drawLock.notifyAll();
        }
    }

    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.isClearSurface = false;
        this.isPause = false;
        synchronized (this.drawLock) {
            this.drawLock.notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Process.setThreadPriority(-19);
        try {
            Logger.d(LOG_TAG, "initGL start");
            initGL();
            Logger.i(LOG_TAG, "initGL success");
            RendererStatusChangeListener rendererStatusChangeListener = this.rendererStatusChangeListener;
            if (rendererStatusChangeListener != null) {
                rendererStatusChangeListener.onGLInitSuccess();
            }
            try {
                Logger.d(LOG_TAG, "initGLComponents start");
                initGLComponents();
                RendererStatusChangeListener rendererStatusChangeListener2 = this.rendererStatusChangeListener;
                if (rendererStatusChangeListener2 != null) {
                    rendererStatusChangeListener2.onGLComponentsInitSuccess();
                }
                Logger.i(LOG_TAG, "OpenGL init OK.");
                synchronized (this.drawLock) {
                    while (this.running) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        pingFps();
                        if (draw()) {
                            this.egl.eglSwapBuffers(this.eglDisplay, this.eglSurface);
                        }
                        long elapsedRealtime2 = 16 - (SystemClock.elapsedRealtime() - elapsedRealtime);
                        if (elapsedRealtime2 > 0) {
                            try {
                                if (this.isPause) {
                                    LockMethodProxy.wait(this.drawLock);
                                } else {
                                    this.drawLock.wait(elapsedRealtime2);
                                }
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
                destroyGLComponents();
                RendererStatusChangeListener rendererStatusChangeListener3 = this.rendererStatusChangeListener;
                if (rendererStatusChangeListener3 != null) {
                    rendererStatusChangeListener3.onGLComponentsDestroy();
                }
                destroyGL();
                RendererStatusChangeListener rendererStatusChangeListener4 = this.rendererStatusChangeListener;
                if (rendererStatusChangeListener4 != null) {
                    rendererStatusChangeListener4.onGLDestroy();
                }
            } catch (Throwable th5) {
                Logger.e(LOG_TAG, "initGLComponents failed", th5);
                RendererStatusChangeListener rendererStatusChangeListener5 = this.rendererStatusChangeListener;
                if (rendererStatusChangeListener5 != null) {
                    rendererStatusChangeListener5.onGLComponentsInitFailed();
                }
            }
        } catch (Throwable th6) {
            Logger.e(LOG_TAG, "initGL failed", th6);
            RendererStatusChangeListener rendererStatusChangeListener6 = this.rendererStatusChangeListener;
            if (rendererStatusChangeListener6 != null) {
                rendererStatusChangeListener6.onGLInitFailed();
            }
        }
    }

    public TextureSurfaceRenderer(Object obj, int i3, int i16, RendererStatusChangeListener rendererStatusChangeListener, Executor executor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), rendererStatusChangeListener, executor);
            return;
        }
        this.drawLock = new Object();
        this.lastFpsOutput = 0L;
        this.nativeWindow = obj;
        this.width = i3;
        this.height = i16;
        this.running = true;
        this.rendererStatusChangeListener = rendererStatusChangeListener;
        if (executor != null) {
            executor.execute(this);
        } else {
            ProxyExecutors.newSingleThreadExecutor().execute(this);
        }
    }
}
