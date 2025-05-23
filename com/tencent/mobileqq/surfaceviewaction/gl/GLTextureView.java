package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    static IPatchRedirector $redirector_;
    private EGLConfig C;
    private GL10 D;
    private boolean E;
    private RenderThreadRunnable F;
    private int G;
    private int H;
    private int I;
    private List<a> J;
    private List<Runnable> K;
    private Object L;
    private volatile boolean M;
    private boolean N;

    /* renamed from: d, reason: collision with root package name */
    private GLSurfaceView.Renderer f291234d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceTexture f291235e;

    /* renamed from: f, reason: collision with root package name */
    private EGLDisplay f291236f;

    /* renamed from: h, reason: collision with root package name */
    private EGLSurface f291237h;

    /* renamed from: i, reason: collision with root package name */
    private EGLContext f291238i;

    /* renamed from: m, reason: collision with root package name */
    private EGL10 f291239m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class RenderThreadRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public boolean f291240d;

        RenderThreadRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GLTextureView.this);
            } else {
                this.f291240d = false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GLTextureView", 2, "run RenderThread");
            }
            synchronized (GLTextureView.class) {
                this.f291240d = true;
            }
            GLTextureView.this.E = true;
            try {
                GLTextureView.this.t();
            } catch (Exception e16) {
                QLog.e("GLTextureView", 1, "run initGL: " + QLog.getStackTraceString(e16));
            }
            GLTextureView.this.q();
            for (int i3 = 0; i3 < GLTextureView.this.J.size(); i3++) {
                ((a) GLTextureView.this.J.get(i3)).onCreate();
            }
            GLTextureView.this.post(new Runnable() { // from class: com.tencent.mobileqq.surfaceviewaction.gl.GLTextureView.RenderThreadRunnable.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RenderThreadRunnable.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        GLTextureView.this.setAlpha(1.0f);
                    }
                }
            });
            long currentTimeMillis = System.currentTimeMillis();
            while (this.f291240d) {
                while (GLTextureView.this.f291234d == null) {
                    try {
                        LockMethodProxy.sleep(50L);
                    } catch (InterruptedException unused) {
                    }
                }
                if (GLTextureView.this.E) {
                    GLTextureView gLTextureView = GLTextureView.this;
                    gLTextureView.v(gLTextureView.f291234d);
                    GLTextureView.this.E = false;
                }
                if (!GLTextureView.this.y()) {
                    currentTimeMillis = System.currentTimeMillis();
                    synchronized (GLTextureView.this.L) {
                        for (int i16 = 0; i16 < GLTextureView.this.K.size(); i16++) {
                            ((Runnable) GLTextureView.this.K.get(i16)).run();
                        }
                        GLTextureView.this.K.clear();
                    }
                    synchronized (GLTextureView.class) {
                        try {
                            if (this.f291240d && !GLTextureView.this.M) {
                                GLTextureView.this.s();
                            }
                        } catch (Exception e17) {
                            if (QLog.isColorLevel()) {
                                QLog.e("GLTextureView", 1, "drawFrame error: " + QLog.getStackTraceString(e17));
                            }
                        }
                    }
                }
                if (!GLTextureView.this.y() && !GLTextureView.this.M) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    try {
                        LockMethodProxy.sleep(Math.max(5L, GLTextureView.this.G - (currentTimeMillis2 - currentTimeMillis)));
                    } catch (InterruptedException unused2) {
                    }
                    currentTimeMillis = currentTimeMillis2;
                }
                LockMethodProxy.sleep(50L);
            }
            synchronized (GLTextureView.this.L) {
                for (int i17 = 0; i17 < GLTextureView.this.K.size(); i17++) {
                    ((Runnable) GLTextureView.this.K.get(i17)).run();
                }
                GLTextureView.this.K.clear();
            }
            GLTextureView.this.r();
            for (int i18 = 0; i18 < GLTextureView.this.J.size(); i18++) {
                ((a) GLTextureView.this.J.get(i18)).onDestroy();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void onCreate();

        void onDestroy();
    }

    public GLTextureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = false;
        this.G = 16;
        this.J = Collections.synchronizedList(new ArrayList());
        this.K = new LinkedList();
        this.L = new Object();
        this.M = false;
        this.N = VasNormalToggle.VAS_ENTER_EFFECT_TEXTURE_VIEW_SWITCH.isEnable(true);
        u(context);
    }

    private void p() {
        int eglGetError = this.f291239m.eglGetError();
        if (eglGetError != 12288 && QLog.isColorLevel()) {
            QLog.e("GLTextureView", 1, "EGL error = 0x" + Integer.toHexString(eglGetError));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        GL10 gl10 = this.D;
        if (gl10 != null) {
            int glGetError = gl10.glGetError();
            if (glGetError != 0 && QLog.isColorLevel()) {
                QLog.e("GLTextureView", 1, "GL error = 0x" + Integer.toHexString(glGetError));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("GLTextureView", 1, "mGl == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f291239m.eglDestroyContext(this.f291236f, this.f291238i);
        try {
            this.f291239m.eglDestroySurface(this.f291236f, this.f291237h);
        } catch (IllegalArgumentException e16) {
            QLog.e("GLTextureView", 1, "destoryGL: " + QLog.getStackTraceString(e16));
        }
        this.f291238i = EGL10.EGL_NO_CONTEXT;
        this.f291237h = EGL10.EGL_NO_SURFACE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s() {
        GLSurfaceView.Renderer renderer = this.f291234d;
        if (renderer != null) {
            renderer.onDrawFrame(this.D);
        }
        if (!this.f291239m.eglSwapBuffers(this.f291236f, this.f291237h) && QLog.isColorLevel()) {
            QLog.e("GLTextureView", 1, "cannot swap buffers!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f291239m = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f291236f = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (this.f291239m.eglInitialize(eglGetDisplay, new int[2])) {
                int[] iArr = new int[1];
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                this.C = null;
                if (this.f291239m.eglChooseConfig(this.f291236f, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, eGLConfigArr, 1, iArr)) {
                    if (iArr[0] > 0) {
                        this.C = eGLConfigArr[0];
                    }
                    EGLConfig eGLConfig = this.C;
                    if (eGLConfig != null) {
                        this.f291238i = this.f291239m.eglCreateContext(this.f291236f, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
                        p();
                        this.f291237h = this.f291239m.eglCreateWindowSurface(this.f291236f, this.C, this.f291235e, null);
                        p();
                        EGLSurface eGLSurface = this.f291237h;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.f291239m.eglMakeCurrent(this.f291236f, eGLSurface, eGLSurface, this.f291238i)) {
                                p();
                                this.D = (GL10) this.f291238i.getGL();
                                p();
                                return;
                            } else {
                                throw new RuntimeException("eglMakeCurrent failed " + GLUtils.getEGLErrorString(this.f291239m.eglGetError()));
                            }
                        }
                        int eglGetError = this.f291239m.eglGetError();
                        if (eglGetError == 12299) {
                            if (QLog.isColorLevel()) {
                                QLog.e("GLTextureView", 1, "eglCreateWindowSurface returned EGL10.EGL_BAD_NATIVE_WINDOW");
                                return;
                            }
                            return;
                        } else {
                            throw new RuntimeException("eglCreateWindowSurface failed " + GLUtils.getEGLErrorString(eglGetError));
                        }
                    }
                    throw new RuntimeException("eglConfig not initialized");
                }
                throw new IllegalArgumentException("eglChooseConfig failed " + GLUtils.getEGLErrorString(this.f291239m.eglGetError()));
            }
            throw new RuntimeException("eglInitialize failed " + GLUtils.getEGLErrorString(this.f291239m.eglGetError()));
        }
        throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.f291239m.eglGetError()));
    }

    private void u(Context context) {
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v(GLSurfaceView.Renderer renderer) {
        if (renderer != null) {
            RenderThreadRunnable renderThreadRunnable = this.F;
            if (renderThreadRunnable != null && renderThreadRunnable.f291240d) {
                renderer.onSurfaceCreated(this.D, this.C);
                renderer.onSurfaceChanged(this.D, this.I, this.H);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        if (this.f291234d == null) {
            return true;
        }
        return false;
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.F != null) {
            if (QLog.isColorLevel()) {
                QLog.d("GLTextureView", 2, "Stopping and joining GLTextureView");
            }
            synchronized (GLTextureView.class) {
                this.F.f291240d = false;
                this.F = null;
            }
        }
    }

    public void o(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.J.add(aVar);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("GLTextureView", 1, "onSurfaceTextureAvailable");
        z(surfaceTexture, i3, i16);
        setAlpha(0.0f);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        QLog.i("GLTextureView", 1, "onSurfaceTextureDestroyed");
        A();
        return this.N;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("GLTextureView", 1, "onSurfaceTextureSizeChanged");
        setDimensions(i3, i16);
        GLSurfaceView.Renderer renderer = this.f291234d;
        if (renderer != null) {
            renderer.onSurfaceChanged(this.D, i3, i16);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) surfaceTexture);
        }
    }

    public void setDimensions(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.I = i3;
            this.H = i16;
        }
    }

    public void setFps(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.G = (int) ((1.0f / i3) * 1000.0f);
        }
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) renderer);
        } else {
            this.f291234d = renderer;
            this.E = true;
        }
    }

    public void w(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) runnable);
            return;
        }
        synchronized (this.L) {
            this.K.add(runnable);
        }
    }

    public void x(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.J.remove(aVar);
        }
    }

    public void z(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GLTextureView", 2, "Starting GLTextureView thread");
        }
        this.F = new RenderThreadRunnable();
        this.f291235e = surfaceTexture;
        setDimensions(i3, i16);
        ThreadManagerV2.post(this.F, 10, null, true);
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.E = false;
        this.G = 16;
        this.J = Collections.synchronizedList(new ArrayList());
        this.K = new LinkedList();
        this.L = new Object();
        this.M = false;
        this.N = VasNormalToggle.VAS_ENTER_EFFECT_TEXTURE_VIEW_SWITCH.isEnable(true);
        u(context);
    }
}
