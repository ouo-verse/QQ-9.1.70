package com.tencent.mobileqq.vpng.glrenderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Iterator;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class GLRenderer {
    static IPatchRedirector $redirector_;
    private final Object C;
    protected boolean D;
    SurfaceTexture E;
    int F;
    int G;
    private Runnable H;

    /* renamed from: d, reason: collision with root package name */
    private EGLDisplay f313184d;

    /* renamed from: e, reason: collision with root package name */
    private EGLContext f313185e;

    /* renamed from: f, reason: collision with root package name */
    private EGLSurface f313186f;

    /* renamed from: h, reason: collision with root package name */
    private EGL10 f313187h;

    /* renamed from: i, reason: collision with root package name */
    private RenderThreadThread f313188i;

    /* renamed from: m, reason: collision with root package name */
    private LinkedList<Runnable> f313189m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class RenderThreadThread extends BaseThread {
        static IPatchRedirector $redirector_;
        private boolean C;

        RenderThreadThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GLRenderer.this);
                return;
            }
            this.C = true;
            setName("GLRenderer-" + getId());
        }

        /* JADX WARN: Code restructure failed: missing block: B:44:0x00c2, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00bf, code lost:
        
            if (r7.this$0.H == null) goto L34;
         */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                try {
                    GLRenderer.this.h();
                    GLRenderer.this.j();
                    while (this.C) {
                        try {
                            long currentTimeMillis = System.currentTimeMillis();
                            synchronized (GLRenderer.this.C) {
                                Iterator it = GLRenderer.this.f313189m.iterator();
                                while (it.hasNext()) {
                                    ((Runnable) it.next()).run();
                                }
                                GLRenderer.this.f313189m.clear();
                            }
                            GLRenderer gLRenderer = GLRenderer.this;
                            if (!gLRenderer.D) {
                                gLRenderer.o();
                            }
                            Thread.sleep(Math.max(0L, 33 - (System.currentTimeMillis() - currentTimeMillis)));
                        } catch (InterruptedException e16) {
                            e16.printStackTrace();
                        }
                    }
                } catch (Exception e17) {
                    QLog.e("GLThread", 2, "RenderThreadThread error : thread=" + getName(), e17);
                }
            } finally {
                if (GLRenderer.this.H != null) {
                    GLRenderer.this.H.run();
                    GLRenderer.this.H = null;
                }
                GLRenderer.this.k();
                GLRenderer.this.i();
                GLRenderer.this.f313189m.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GLRenderer(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f313184d = EGL10.EGL_NO_DISPLAY;
        this.f313185e = EGL10.EGL_NO_CONTEXT;
        this.f313186f = EGL10.EGL_NO_SURFACE;
        this.f313189m = new LinkedList<>();
        this.C = new Object();
        this.D = false;
        this.F = i3;
        this.G = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f313187h = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f313184d = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (this.f313187h.eglInitialize(eglGetDisplay, new int[2])) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (this.f313187h.eglChooseConfig(this.f313184d, new int[]{12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = this.f313187h.eglCreateContext(this.f313184d, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                    this.f313185e = eglCreateContext;
                    if (eglCreateContext != EGL10.EGL_NO_CONTEXT) {
                        int[] iArr = {MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, this.F, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, this.G, 12344};
                        SurfaceTexture surfaceTexture = this.E;
                        if (surfaceTexture != null) {
                            this.f313186f = this.f313187h.eglCreateWindowSurface(this.f313184d, eGLConfig, surfaceTexture, null);
                        } else {
                            this.f313186f = this.f313187h.eglCreatePbufferSurface(this.f313184d, eGLConfig, iArr);
                        }
                        EGL10 egl102 = this.f313187h;
                        EGLDisplay eGLDisplay = this.f313184d;
                        EGLSurface eGLSurface = this.f313186f;
                        egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f313185e);
                        return;
                    }
                    throw new RuntimeException("EGL error " + this.f313187h.eglGetError());
                }
                throw new RuntimeException("EGL error " + this.f313187h.eglGetError());
            }
            throw new RuntimeException("EGL error " + this.f313187h.eglGetError());
        }
        throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.f313187h.eglGetError()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        SurfaceTexture surfaceTexture = this.E;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.E = null;
        }
        this.f313187h.eglDestroyContext(this.f313184d, this.f313185e);
        this.f313187h.eglDestroySurface(this.f313184d, this.f313186f);
        this.f313185e = EGL10.EGL_NO_CONTEXT;
        this.f313184d = EGL10.EGL_NO_DISPLAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        EGL10 egl10 = this.f313187h;
        EGLDisplay eGLDisplay = this.f313184d;
        EGLSurface eGLSurface = this.f313186f;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f313185e);
        GLES20.glViewport(0, 0, this.F, this.G);
        l();
        this.f313187h.eglSwapBuffers(this.f313184d, this.f313186f);
        m();
    }

    public abstract void j();

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
        } else {
            this.H = runnable;
        }
    }

    public void q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.F = i3;
            this.G = i16;
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        RenderThreadThread renderThreadThread = this.f313188i;
        if (renderThreadThread == null || !renderThreadThread.C) {
            RenderThreadThread renderThreadThread2 = new RenderThreadThread();
            this.f313188i = renderThreadThread2;
            renderThreadThread2.start();
        }
    }

    public void s(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) surfaceTexture);
        } else {
            this.E = surfaceTexture;
            r();
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        RenderThreadThread renderThreadThread = this.f313188i;
        if (renderThreadThread != null) {
            renderThreadThread.C = false;
            this.f313188i = null;
        }
    }
}
