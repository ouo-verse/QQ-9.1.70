package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import com.tencent.ark.EGLContextHolder;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private static int K;
    private static final j L = new j();
    private GLSurfaceView.Renderer C;
    private boolean D;
    private f E;
    private g F;
    private h G;
    private int H;
    private int I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    private boolean f68242d;

    /* renamed from: e, reason: collision with root package name */
    int f68243e;

    /* renamed from: f, reason: collision with root package name */
    int f68244f;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f68245h;

    /* renamed from: i, reason: collision with root package name */
    private final WeakReference<GLTextureView> f68246i;

    /* renamed from: m, reason: collision with root package name */
    private GLThread f68247m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class GLThread extends BaseThread {
        private boolean D;
        private boolean E;
        private boolean F;
        private boolean G;
        private boolean H;
        private boolean I;
        private boolean J;
        private boolean K;
        private boolean L;
        private boolean M;
        private boolean N;
        private boolean T;
        private i W;
        private WeakReference<GLTextureView> X;
        private boolean C = false;
        private ArrayList<Runnable> U = new ArrayList<>();
        private boolean V = true;
        private int P = 0;
        private int Q = 0;
        private boolean S = true;
        private int R = 1;

        GLThread(WeakReference<GLTextureView> weakReference) {
            this.X = weakReference;
        }

        private boolean readyToDraw() {
            return !this.G && this.H && !this.I && this.P > 0 && this.Q > 0 && (this.S || this.R == 1);
        }

        private void stopEglContextLocked() {
            if (this.K) {
                this.W.e();
                this.K = false;
                GLTextureView.L.c(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.L) {
                this.L = false;
                this.W.c();
            }
        }

        public boolean ableToDraw() {
            return this.K && this.L && readyToDraw();
        }

        public int getRenderMode() {
            int i3;
            synchronized (GLTextureView.L) {
                i3 = this.R;
            }
            return i3;
        }

        public void onWindowResize(int i3, int i16) {
            synchronized (GLTextureView.L) {
                this.P = i3;
                this.Q = i16;
                this.V = true;
                this.S = true;
                this.T = false;
                GLTextureView.L.notifyAll();
                while (!this.E && !this.G && !this.T && ableToDraw()) {
                    try {
                        LockMethodProxy.wait(GLTextureView.L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestExitAndWait() {
            synchronized (GLTextureView.L) {
                this.D = true;
                GLTextureView.L.notifyAll();
                while (!this.E) {
                    try {
                        LockMethodProxy.wait(GLTextureView.L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestRender() {
            synchronized (GLTextureView.L) {
                this.S = true;
                GLTextureView.L.notifyAll();
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th5) {
                GLTextureView.L.f(this);
                throw th5;
            }
            GLTextureView.L.f(this);
        }

        public void surfaceCreated() {
            synchronized (GLTextureView.L) {
                this.H = true;
                this.M = false;
                GLTextureView.L.notifyAll();
                while (this.J && !this.M && !this.E) {
                    try {
                        LockMethodProxy.wait(GLTextureView.L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (GLTextureView.L) {
                this.H = false;
                GLTextureView.L.notifyAll();
                while (!this.J && !this.E) {
                    if (!this.C && QLog.isColorLevel()) {
                        this.C = true;
                        QLog.d("GLTextureView", 2, "mWaitingForSurface " + this.J + " mExited " + this.E);
                    }
                    try {
                        LockMethodProxy.wait(GLTextureView.L);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.N = true;
            GLTextureView.L.notifyAll();
        }

        /* JADX WARN: Removed duplicated region for block: B:193:0x0287 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x026c  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x016d A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void guardedRun() throws InterruptedException {
            boolean z16;
            GL10 gl10;
            boolean z17;
            GL10 gl102;
            boolean z18;
            boolean z19;
            boolean z26;
            this.W = new i(this.X);
            this.K = false;
            this.L = false;
            boolean z27 = false;
            boolean z28 = false;
            boolean z29 = false;
            boolean z36 = false;
            boolean z37 = false;
            boolean z38 = false;
            boolean z39 = false;
            int i3 = 0;
            int i16 = 0;
            boolean z46 = false;
            GL10 gl103 = null;
            Runnable runnable = null;
            while (true) {
                try {
                    synchronized (GLTextureView.L) {
                        while (!this.D) {
                            if (!this.U.isEmpty()) {
                                runnable = this.U.remove(0);
                                z16 = z27;
                                gl10 = gl103;
                                z17 = false;
                            } else {
                                boolean z47 = this.G;
                                boolean z48 = this.F;
                                if (z47 != z48) {
                                    this.G = z48;
                                    GLTextureView.L.notifyAll();
                                } else {
                                    z48 = false;
                                }
                                if (this.N) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    this.N = false;
                                    z29 = true;
                                }
                                if (z27) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    z27 = false;
                                }
                                if (z48 && this.L) {
                                    stopEglSurfaceLocked();
                                }
                                if (z48 && this.K) {
                                    GLTextureView gLTextureView = this.X.get();
                                    if (!(gLTextureView == null ? false : gLTextureView.J) || GLTextureView.L.d()) {
                                        stopEglContextLocked();
                                    }
                                }
                                if (z48 && GLTextureView.L.e()) {
                                    this.W.e();
                                }
                                if (this.H || this.J) {
                                    z16 = z27;
                                    gl10 = gl103;
                                    z19 = z36;
                                } else {
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        z16 = z27;
                                        sb5.append("noticed surfaceView surface lost tid=");
                                        gl10 = gl103;
                                        z19 = z36;
                                        sb5.append(getId());
                                        QLog.d("GLTextureView", 2, sb5.toString());
                                    } else {
                                        z16 = z27;
                                        gl10 = gl103;
                                        z19 = z36;
                                    }
                                    if (this.L) {
                                        stopEglSurfaceLocked();
                                    }
                                    this.J = true;
                                    this.I = false;
                                    GLTextureView.L.notifyAll();
                                }
                                if (this.H && this.J) {
                                    this.J = false;
                                    GLTextureView.L.notifyAll();
                                }
                                if (z28) {
                                    this.T = true;
                                    GLTextureView.L.notifyAll();
                                    z28 = false;
                                    z46 = false;
                                }
                                if (readyToDraw()) {
                                    if (!this.K) {
                                        if (z29) {
                                            z36 = z19;
                                            z29 = false;
                                        } else if (GLTextureView.L.g(this)) {
                                            try {
                                                this.W.j();
                                                this.K = true;
                                                GLTextureView.L.notifyAll();
                                                z36 = true;
                                            } catch (RuntimeException e16) {
                                                GLTextureView.L.c(this);
                                                throw e16;
                                            }
                                        }
                                        if (this.K && !this.L) {
                                            this.L = true;
                                            z37 = true;
                                            z38 = true;
                                            z39 = true;
                                        }
                                        if (this.L) {
                                            z26 = false;
                                        } else {
                                            if (this.V) {
                                                int i17 = this.P;
                                                int i18 = this.Q;
                                                z17 = false;
                                                this.V = false;
                                                i3 = i17;
                                                i16 = i18;
                                                z37 = true;
                                                z39 = true;
                                                z46 = true;
                                            } else {
                                                z17 = false;
                                            }
                                            this.S = z17;
                                            GLTextureView.L.notifyAll();
                                        }
                                    }
                                    z36 = z19;
                                    if (this.K) {
                                        this.L = true;
                                        z37 = true;
                                        z38 = true;
                                        z39 = true;
                                    }
                                    if (this.L) {
                                    }
                                } else {
                                    z26 = false;
                                    z36 = z19;
                                }
                                LockMethodProxy.wait(GLTextureView.L);
                                gl103 = gl10;
                                z27 = z16;
                            }
                        }
                        synchronized (GLTextureView.L) {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                        }
                        return;
                    }
                } catch (Throwable th5) {
                    synchronized (GLTextureView.L) {
                    }
                }
                if (runnable != null) {
                    runnable.run();
                    runnable = null;
                } else {
                    if (z37) {
                        if (this.W.b()) {
                            synchronized (GLTextureView.L) {
                                this.M = true;
                                GLTextureView.L.notifyAll();
                            }
                            z37 = z17;
                        } else {
                            synchronized (GLTextureView.L) {
                                this.M = true;
                                this.I = true;
                                GLTextureView.L.notifyAll();
                            }
                        }
                        synchronized (GLTextureView.L) {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                            throw th5;
                        }
                    }
                    if (z38) {
                        gl102 = (GL10) this.W.a();
                        GLTextureView.L.a(gl102);
                        z38 = z17;
                    } else {
                        gl102 = gl10;
                    }
                    if (z36) {
                        GLTextureView gLTextureView2 = this.X.get();
                        if (gLTextureView2 != null && gLTextureView2.C != null) {
                            gLTextureView2.C.onSurfaceCreated(gl102, this.W.f68265e);
                        }
                        z36 = z17;
                    }
                    if (z39) {
                        GLTextureView gLTextureView3 = this.X.get();
                        if (gLTextureView3 != null && gLTextureView3.C != null) {
                            gLTextureView3.C.onSurfaceChanged(gl102, i3, i16);
                        }
                        z39 = z17;
                    }
                    GLTextureView gLTextureView4 = this.X.get();
                    if (gLTextureView4 != null && gLTextureView4.C != null && gl102 != null) {
                        gLTextureView4.C.onDrawFrame(gl102);
                    }
                    int k3 = this.W.k();
                    if (k3 == 12288) {
                        z18 = true;
                    } else if (k3 != 12302) {
                        i.i("GLThread", "eglSwapBuffers", k3);
                        synchronized (GLTextureView.L) {
                            z18 = true;
                            this.I = true;
                            GLTextureView.L.notifyAll();
                        }
                    } else {
                        z18 = true;
                        z16 = true;
                    }
                    if (z46) {
                        z28 = z18;
                    }
                    z27 = z16;
                    gl103 = gl102;
                }
                gl103 = gl10;
                z27 = z16;
            }
        }

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLTextureView.L) {
                    this.U.add(runnable);
                    GLTextureView.L.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public void setRenderMode(int i3) {
            if (i3 >= 0 && i3 <= 1) {
                synchronized (GLTextureView.L) {
                    this.R = i3;
                    GLTextureView.L.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("renderMode");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            GLTextureView gLTextureView = GLTextureView.this;
            gLTextureView.K(gLTextureView.getSurfaceTexture(), 0, i17 - i3, i18 - i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private abstract class b implements f {

        /* renamed from: a, reason: collision with root package name */
        protected int[] f68249a;

        public b(int[] iArr) {
            this.f68249a = b(iArr);
        }

        private int[] b(int[] iArr) {
            if (GLTextureView.this.I != 2 && GLTextureView.this.I != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i3 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = 12352;
            if (GLTextureView.this.I == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.f
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f68249a, null, 0, iArr)) {
                int i3 = iArr[0];
                if (i3 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i3];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f68249a, eGLConfigArr, i3, iArr)) {
                        EGLConfig a16 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a16 != null) {
                            return a16;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class c extends b {

        /* renamed from: c, reason: collision with root package name */
        private int[] f68251c;

        /* renamed from: d, reason: collision with root package name */
        protected int f68252d;

        /* renamed from: e, reason: collision with root package name */
        protected int f68253e;

        /* renamed from: f, reason: collision with root package name */
        protected int f68254f;

        /* renamed from: g, reason: collision with root package name */
        protected int f68255g;

        /* renamed from: h, reason: collision with root package name */
        protected int f68256h;

        /* renamed from: i, reason: collision with root package name */
        protected int f68257i;

        public c(int i3, int i16, int i17, int i18, int i19, int i26) {
            super(new int[]{12324, i3, 12323, i16, 12322, i17, 12321, i18, 12325, i19, 12326, i26, 12344});
            this.f68251c = new int[1];
            this.f68252d = i3;
            this.f68253e = i16;
            this.f68254f = i17;
            this.f68255g = i18;
            this.f68256h = i19;
            this.f68257i = i26;
        }

        private int c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3, int i16) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, this.f68251c) ? this.f68251c[0] : i16;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.b
        public EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int c16 = c(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int c17 = c(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (c16 >= this.f68256h && c17 >= this.f68257i) {
                    int c18 = c(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int c19 = c(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int c26 = c(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int c27 = c(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (c18 == this.f68252d && c19 == this.f68253e && c26 == this.f68254f && c27 == this.f68255g) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class d implements g {

        /* renamed from: a, reason: collision with root package name */
        private int f68259a = EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION;

        d() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.g
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            i.m("eglDestroyContex", egl10.eglGetError());
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.g
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.f68259a, GLTextureView.this.I, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.I == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class e implements h {
        e() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.h
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.h
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e16) {
                Log.e("GLTextureView", "eglCreateWindowSurface", e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface f {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface g {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface h {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        private boolean f68267a;

        /* renamed from: b, reason: collision with root package name */
        private int f68268b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f68269c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f68270d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f68271e;

        /* renamed from: f, reason: collision with root package name */
        private GLThread f68272f;

        j() {
        }

        private void b() {
            if (this.f68267a) {
                return;
            }
            int i3 = GLTextureView.K;
            this.f68268b = i3;
            if (i3 >= 131072) {
                this.f68270d = true;
            }
            this.f68267a = true;
        }

        public synchronized void a(GL10 gl10) {
            if (!this.f68269c) {
                b();
                String glGetString = gl10.glGetString(7937);
                if (this.f68268b < 131072) {
                    this.f68270d = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                this.f68271e = this.f68270d ? false : true;
                this.f68269c = true;
            }
        }

        public void c(GLThread gLThread) {
            if (this.f68272f == gLThread) {
                this.f68272f = null;
            }
            notifyAll();
        }

        public synchronized boolean d() {
            return this.f68271e;
        }

        public synchronized boolean e() {
            b();
            return !this.f68270d;
        }

        public synchronized void f(GLThread gLThread) {
            gLThread.E = true;
            if (this.f68272f == gLThread) {
                this.f68272f = null;
            }
            notifyAll();
        }

        public boolean g(GLThread gLThread) {
            GLThread gLThread2 = this.f68272f;
            if (gLThread2 != gLThread && gLThread2 != null) {
                b();
                if (this.f68270d) {
                    return true;
                }
                GLThread gLThread3 = this.f68272f;
                if (gLThread3 == null) {
                    return false;
                }
                gLThread3.requestReleaseEglContextLocked();
                return false;
            }
            this.f68272f = gLThread;
            notifyAll();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface k {
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class m extends c {
        public m(boolean z16) {
            super(8, 8, 8, 0, z16 ? 16 : 0, 0);
        }
    }

    public GLTextureView(Context context) {
        super(context);
        this.f68243e = 0;
        this.f68244f = 0;
        this.f68245h = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.2
            @Override // java.lang.Runnable
            public void run() {
                GLTextureView.this.f68247m.onWindowResize(GLTextureView.this.getWidth(), GLTextureView.this.getHeight());
                if (QLog.isColorLevel()) {
                    QLog.d("GLTextureView", 2, "TextureView mCheckAlphaTask,alpha:" + GLTextureView.this.G());
                }
                if (GLTextureView.this.G() != 1.0f) {
                    GLTextureView.this.J(1.0f);
                }
            }
        };
        this.f68246i = new WeakReference<>(this);
        H();
    }

    public static Integer F(Context context, String str, int i3) throws IllegalArgumentException {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
            return (Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(i3));
        } catch (IllegalArgumentException e16) {
            throw e16;
        } catch (Exception unused) {
            return Integer.valueOf(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float G() {
        return getAlpha();
    }

    private void H() {
        K = F(getContext(), "ro.opengles.version", 0).intValue();
        setSurfaceTextureListener(this);
        addOnLayoutChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(float f16) {
        setAlpha(f16);
        if (QLog.isColorLevel()) {
            QLog.d("GLTextureView", 2, "TextureView setAlpha,alpha:" + f16);
        }
    }

    static /* bridge */ /* synthetic */ k i(GLTextureView gLTextureView) {
        gLTextureView.getClass();
        return null;
    }

    private void p() {
        if (this.f68247m != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    public void I(Runnable runnable) {
        this.f68247m.queueEvent(runnable);
    }

    public void K(SurfaceTexture surfaceTexture, int i3, int i16, int i17) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f68243e != i16 || this.f68244f != i17) {
            this.f68243e = i16;
            this.f68244f = i17;
            this.f68247m.onWindowResize(i16, i17);
            if (QLog.isColorLevel()) {
                QLog.d("GLTextureView", 2, " surfaceChanged, onWindowResize");
            }
        }
        removeCallbacks(this.f68245h);
        if (this.f68242d && G() != 1.0f) {
            J(1.0f);
        }
        if (QLog.isColorLevel()) {
            QLog.d("GLTextureView", 2, " surfaceChanged, w:" + i16 + ",h:" + i17 + " use:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void L(SurfaceTexture surfaceTexture) {
        this.f68247m.surfaceCreated();
    }

    public void M(SurfaceTexture surfaceTexture) {
        this.f68247m.surfaceDestroyed();
    }

    protected void finalize() throws Throwable {
        try {
            GLThread gLThread = this.f68247m;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.D && this.C != null) {
            GLThread gLThread = this.f68247m;
            int renderMode = gLThread != null ? gLThread.getRenderMode() : 1;
            GLThread gLThread2 = new GLThread(this.f68246i);
            this.f68247m = gLThread2;
            if (renderMode != 1) {
                gLThread2.setRenderMode(renderMode);
            }
            this.f68247m.start();
        }
        this.D = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        GLThread gLThread = this.f68247m;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.D = true;
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("GLTextureView", "onSurfaceTextureSizeChanged");
        K(surfaceTexture, 0, i3, i16);
        if (QLog.isColorLevel()) {
            QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureSizeChanged surfaceChanged use:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void requestRender() {
        this.f68247m.requestRender();
    }

    public void setDebugFlags(int i3) {
        this.H = i3;
    }

    public void setEGLConfigChooser(f fVar) {
        p();
        this.E = fVar;
    }

    public void setEGLContextClientVersion(int i3) {
        p();
        this.I = i3;
    }

    public void setEGLContextFactory(g gVar) {
        p();
        this.F = gVar;
    }

    public void setEGLWindowSurfaceFactory(h hVar) {
        p();
        this.G = hVar;
    }

    public void setPreserveEGLContextOnPause(boolean z16) {
        this.J = z16;
    }

    public void setRenderMode(int i3) {
        this.f68247m.setRenderMode(i3);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        p();
        if (this.E == null) {
            this.E = new m(true);
        }
        if (this.F == null) {
            this.F = new d();
        }
        if (this.G == null) {
            this.G = new e();
        }
        this.C = renderer;
        GLThread gLThread = new GLThread(this.f68246i);
        this.f68247m = gLThread;
        gLThread.start();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        this.f68242d = true;
        this.f68243e = 0;
        this.f68244f = 0;
        Log.d("GLTextureView", "onSurfaceTextureAvailable");
        long currentTimeMillis = System.currentTimeMillis();
        L(surfaceTexture);
        postDelayed(this.f68245h, 250L);
        if (QLog.isColorLevel()) {
            QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureAvailable surfaceCreated use:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f68242d = false;
        Log.d("GLTextureView", "onSurfaceTextureDestroyed");
        M(surfaceTexture);
        if (QLog.isColorLevel()) {
            QLog.d("GLTextureView", 2, " TextureView onSurfaceTextureDestroyed");
        }
        J(0.0f);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<GLTextureView> f68261a;

        /* renamed from: b, reason: collision with root package name */
        EGL10 f68262b;

        /* renamed from: c, reason: collision with root package name */
        EGLDisplay f68263c;

        /* renamed from: d, reason: collision with root package name */
        EGLSurface f68264d;

        /* renamed from: e, reason: collision with root package name */
        EGLConfig f68265e;

        /* renamed from: f, reason: collision with root package name */
        EGLContext f68266f;

        public i(WeakReference<GLTextureView> weakReference) {
            this.f68261a = weakReference;
        }

        private void d() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.f68264d;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.f68262b.eglMakeCurrent(this.f68263c, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            GLTextureView gLTextureView = this.f68261a.get();
            if (gLTextureView != null) {
                gLTextureView.G.destroySurface(this.f68262b, this.f68263c, this.f68264d);
            }
            this.f68264d = null;
        }

        public static String f(String str, int i3) {
            return str + " failed: " + g(i3);
        }

        private static String h(int i3) {
            return RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i3);
        }

        public static void i(String str, String str2, int i3) {
            Log.w(str, f(str2, i3));
        }

        private void l(String str) {
            m(str, this.f68262b.eglGetError());
        }

        public static void m(String str, int i3) {
            throw new RuntimeException(f(str, i3));
        }

        GL a() {
            GL gl5 = this.f68266f.getGL();
            GLTextureView gLTextureView = this.f68261a.get();
            if (gLTextureView == null) {
                return gl5;
            }
            GLTextureView.i(gLTextureView);
            if ((gLTextureView.H & 3) != 0) {
                return GLDebugHelper.wrap(gl5, (gLTextureView.H & 1) == 0 ? 0 : 1, (gLTextureView.H & 2) != 0 ? new l() : null);
            }
            return gl5;
        }

        public boolean b() {
            if (this.f68262b != null) {
                if (this.f68263c != null) {
                    if (this.f68265e != null) {
                        d();
                        GLTextureView gLTextureView = this.f68261a.get();
                        if (gLTextureView != null) {
                            this.f68264d = gLTextureView.G.createWindowSurface(this.f68262b, this.f68263c, this.f68265e, gLTextureView.getSurfaceTexture());
                        } else {
                            this.f68264d = null;
                        }
                        EGLSurface eGLSurface = this.f68264d;
                        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                            if (this.f68262b.eglMakeCurrent(this.f68263c, eGLSurface, eGLSurface, this.f68266f)) {
                                return true;
                            }
                            i("EGLHelper", "eglMakeCurrent", this.f68262b.eglGetError());
                            return false;
                        }
                        if (this.f68262b.eglGetError() == 12299) {
                            Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                        }
                        return false;
                    }
                    throw new RuntimeException("mEglConfig not initialized");
                }
                throw new RuntimeException("eglDisplay not initialized");
            }
            throw new RuntimeException("egl not initialized");
        }

        public void c() {
            d();
        }

        public void e() {
            if (this.f68266f != null) {
                GLTextureView gLTextureView = this.f68261a.get();
                if (gLTextureView != null) {
                    gLTextureView.F.destroyContext(this.f68262b, this.f68263c, this.f68266f);
                }
                this.f68266f = null;
            }
            EGLDisplay eGLDisplay = this.f68263c;
            if (eGLDisplay != null) {
                this.f68262b.eglTerminate(eGLDisplay);
                this.f68263c = null;
            }
        }

        public void j() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f68262b = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f68263c = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f68262b.eglInitialize(eglGetDisplay, new int[2])) {
                    GLTextureView gLTextureView = this.f68261a.get();
                    if (gLTextureView == null) {
                        this.f68265e = null;
                        this.f68266f = null;
                    } else {
                        this.f68265e = gLTextureView.E.chooseConfig(this.f68262b, this.f68263c);
                        this.f68266f = gLTextureView.F.createContext(this.f68262b, this.f68263c, this.f68265e);
                    }
                    EGLContext eGLContext = this.f68266f;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f68266f = null;
                        l("createContext");
                    }
                    this.f68264d = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public int k() {
            if (this.f68262b.eglSwapBuffers(this.f68263c, this.f68264d)) {
                return 12288;
            }
            return this.f68262b.eglGetError();
        }

        public static String g(int i3) {
            switch (i3) {
                case 12288:
                    return "EGL_SUCCESS";
                case 12289:
                    return "EGL_NOT_INITIALIZED";
                case 12290:
                    return "EGL_BAD_ACCESS";
                case 12291:
                    return "EGL_BAD_ALLOC";
                case 12292:
                    return "EGL_BAD_ATTRIBUTE";
                case 12293:
                    return "EGL_BAD_CONFIG";
                case 12294:
                    return "EGL_BAD_CONTEXT";
                case 12295:
                    return "EGL_BAD_CURRENT_SURFACE";
                case 12296:
                    return "EGL_BAD_DISPLAY";
                case 12297:
                    return "EGL_BAD_MATCH";
                case 12298:
                    return "EGL_BAD_NATIVE_PIXMAP";
                case 12299:
                    return "EGL_BAD_NATIVE_WINDOW";
                case 12300:
                    return "EGL_BAD_PARAMETER";
                case 12301:
                    return "EGL_BAD_SURFACE";
                case 12302:
                    return "EGL_CONTEXT_LOST";
                default:
                    return h(i3);
            }
        }
    }

    public void setEGLConfigChooser(boolean z16) {
        setEGLConfigChooser(new m(z16));
    }

    public void setEGLConfigChooser(int i3, int i16, int i17, int i18, int i19, int i26) {
        setEGLConfigChooser(new c(i3, i16, i17, i18, i19, i26));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class l extends Writer {

        /* renamed from: d, reason: collision with root package name */
        private StringBuilder f68273d = new StringBuilder();

        l() {
        }

        private void a() {
            if (this.f68273d.length() > 0) {
                Log.v("GLTextureView", this.f68273d.toString());
                StringBuilder sb5 = this.f68273d;
                sb5.delete(0, sb5.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            a();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i16) {
            for (int i17 = 0; i17 < i16; i17++) {
                char c16 = cArr[i3 + i17];
                if (c16 == '\n') {
                    a();
                } else {
                    this.f68273d.append(c16);
                }
            }
        }
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68243e = 0;
        this.f68244f = 0;
        this.f68245h = new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.GLTextureView.2
            @Override // java.lang.Runnable
            public void run() {
                GLTextureView.this.f68247m.onWindowResize(GLTextureView.this.getWidth(), GLTextureView.this.getHeight());
                if (QLog.isColorLevel()) {
                    QLog.d("GLTextureView", 2, "TextureView mCheckAlphaTask,alpha:" + GLTextureView.this.G());
                }
                if (GLTextureView.this.G() != 1.0f) {
                    GLTextureView.this.J(1.0f);
                }
            }
        };
        this.f68246i = new WeakReference<>(this);
        H();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setGLWrapper(k kVar) {
    }
}
