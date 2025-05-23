package com.tencent.mobileqq.qzoneplayer.panorama;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLUtils;
import com.tencent.ark.EGLContextHolder;
import com.tencent.oskplayer.util.PlayerUtils;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes35.dex */
public abstract class e {
    public static String I = "TextureSurfaceRenderer";
    private EGLContext C;
    private EGLDisplay D;
    private EGLSurface E;
    private EGLConfig F;
    protected final Context G;
    private volatile boolean H;

    /* renamed from: d, reason: collision with root package name */
    protected b f279402d;

    /* renamed from: e, reason: collision with root package name */
    protected final SurfaceTexture f279403e;

    /* renamed from: f, reason: collision with root package name */
    protected int f279404f;

    /* renamed from: h, reason: collision with root package name */
    protected int f279405h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f279406i;

    /* renamed from: m, reason: collision with root package name */
    private EGL10 f279407m;

    public e(Context context, b bVar, SurfaceTexture surfaceTexture, int i3, int i16) {
        this.H = false;
        this.f279403e = surfaceTexture;
        this.f279404f = i3;
        this.f279405h = i16;
        this.H = true;
        this.G = context;
        this.f279402d = bVar;
    }

    private void h() {
        if (this.f279407m != null) {
            return;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f279407m = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.D = eglGetDisplay;
        if (EGL10.EGL_NO_DISPLAY == eglGetDisplay) {
            PlayerUtils.log(6, I, "eglGetDisplay failed: " + GLUtils.getEGLErrorString(this.f279407m.eglGetError()));
            return;
        }
        if (!this.f279407m.eglInitialize(eglGetDisplay, new int[2])) {
            PlayerUtils.log(6, I, "eglGetDisplay failed: eglInitialize failed: " + GLUtils.getEGLErrorString(this.f279407m.eglGetError()));
            return;
        }
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f279407m.eglChooseConfig(this.D, f(), eGLConfigArr, 1, iArr)) {
            PlayerUtils.log(6, I, "Failed to choose config:" + GLUtils.getEGLErrorString(this.f279407m.eglGetError()));
            return;
        }
        if (iArr[0] <= 0) {
            PlayerUtils.log(6, I, "eglChooseConfig failed: " + GLUtils.getEGLErrorString(this.f279407m.eglGetError()));
            return;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        this.F = eGLConfig;
        EGLContext a16 = a(this.f279407m, this.D, eGLConfig);
        this.C = a16;
        if (EGL10.EGL_NO_CONTEXT == a16) {
            PlayerUtils.log(6, I, "eglCreateContext failed: " + GLUtils.getEGLErrorString(this.f279407m.eglGetError()));
            return;
        }
        EGLSurface eglCreateWindowSurface = this.f279407m.eglCreateWindowSurface(this.D, this.F, this.f279403e, null);
        this.E = eglCreateWindowSurface;
        if (eglCreateWindowSurface != null && eglCreateWindowSurface != EGL10.EGL_NO_SURFACE) {
            if (this.f279407m.eglMakeCurrent(this.D, eglCreateWindowSurface, eglCreateWindowSurface, this.C)) {
                return;
            }
            throw new RuntimeException("GL Make current Error" + GLUtils.getEGLErrorString(this.f279407m.eglGetError()));
        }
        throw new RuntimeException("GL error:" + GLUtils.getEGLErrorString(this.f279407m.eglGetError()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        EGL10 egl10 = this.f279407m;
        if (egl10 != null) {
            EGLDisplay eGLDisplay = this.D;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.f279407m.eglDestroySurface(this.D, this.E);
            this.f279407m.eglDestroyContext(this.D, this.C);
            this.f279407m.eglTerminate(this.D);
            this.f279407m = null;
        }
    }

    protected abstract void c();

    public void d() {
        c();
        b();
        b bVar = this.f279402d;
        if (bVar != null) {
            bVar.j(false);
            this.f279402d = null;
        }
        this.f279406i = false;
    }

    protected abstract boolean e();

    protected void finalize() throws Throwable {
        super.finalize();
        this.H = false;
        d();
    }

    public void g() {
        b bVar = this.f279402d;
        if (bVar != null) {
            bVar.f(this);
        }
    }

    protected abstract void i();

    public boolean j() {
        try {
            h();
            i();
            this.f279406i = true;
        } catch (Exception e16) {
            this.f279406i = false;
            PlayerUtils.log(6, I, "init render error:" + e16.toString());
        }
        return this.f279406i;
    }

    public void k() {
        b bVar = this.f279402d;
        if (bVar != null) {
            bVar.g(this);
        }
    }

    public void n() {
        try {
            if (this.f279406i && e()) {
                this.f279407m.eglSwapBuffers(this.D, this.E);
            }
        } catch (Exception e16) {
            PlayerUtils.log(6, I, "render occur error:" + e16.toString());
        }
    }

    private EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
    }

    public void l() {
        this.f279406i = false;
        b bVar = this.f279402d;
        if (bVar != null) {
            bVar.h(this);
        }
    }

    public void m() {
        this.H = false;
        l();
    }

    private int[] f() {
        return new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    }
}
