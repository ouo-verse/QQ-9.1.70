package com.tencent.qqmini.miniapp.util.TextureRender;

import android.opengl.GLUtils;
import android.os.Handler;
import android.view.Surface;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TextureSurfaceRenderer implements Runnable {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final String TAG = "miniapp-embedded";
    private EGL10 egl;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;
    private int frames;
    protected int height;
    protected Handler mHandler;
    private Surface surface;
    protected int width;
    private boolean pause = false;
    private long lastFpsOutput = 0;
    private boolean running = true;

    public TextureSurfaceRenderer(Surface surface, int i3, int i16, Handler handler) {
        this.surface = surface;
        this.width = i3;
        this.height = i16;
        this.mHandler = handler;
        new BaseThread(this).start();
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

    private void deinitGL() {
        try {
            EGL10 egl10 = this.egl;
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.egl.eglDestroySurface(this.eglDisplay, this.eglSurface);
            this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
            this.egl.eglTerminate(this.eglDisplay);
            QMLog.d(TAG, "OpenGL deinit OK.");
        } catch (Throwable th5) {
            QMLog.e(TAG, "deinitGL error, ", th5);
        }
    }

    private int[] getConfig() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }

    private void initGL() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.egl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.eglDisplay = eglGetDisplay;
            this.egl.eglInitialize(eglGetDisplay, new int[2]);
            EGLConfig chooseEglConfig = chooseEglConfig();
            this.eglContext = createContext(this.egl, this.eglDisplay, chooseEglConfig);
            EGLSurface eglCreateWindowSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, chooseEglConfig, this.surface, null);
            this.eglSurface = eglCreateWindowSurface;
            if (eglCreateWindowSurface != null && eglCreateWindowSurface != EGL10.EGL_NO_SURFACE) {
                if (!this.egl.eglMakeCurrent(this.eglDisplay, eglCreateWindowSurface, eglCreateWindowSurface, this.eglContext)) {
                    throw new RuntimeException("GL Make current error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
                }
                return;
            }
            throw new RuntimeException("GL Error: " + GLUtils.getEGLErrorString(this.egl.eglGetError()));
        } catch (Throwable th5) {
            QMLog.e(TAG, "initGL error.", th5);
        }
    }

    private void pingFps() {
        if (this.lastFpsOutput == 0) {
            this.lastFpsOutput = System.currentTimeMillis();
        }
        this.frames++;
        if (System.currentTimeMillis() - this.lastFpsOutput > 1000) {
            this.lastFpsOutput = System.currentTimeMillis();
            this.frames = 0;
        }
    }

    protected abstract void deinitGLComponents();

    protected abstract boolean draw();

    protected void finalize() throws Throwable {
        super.finalize();
        this.running = false;
    }

    protected abstract void initGLComponents();

    public void onPause() {
        this.running = false;
    }

    public void pauseRender() {
        this.pause = true;
    }

    public void resumeRender() {
        this.pause = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            initGL();
            initGLComponents();
            QMLog.d(TAG, "OpenGL init OK.");
            while (this.running) {
                if (!this.pause) {
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
            }
            deinitGLComponents();
            deinitGL();
        } catch (Throwable th5) {
            QMLog.e(TAG, "TextureSurfaceRenderer run error,", th5);
        }
    }
}
