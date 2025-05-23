package com.tencent.mobileqq.apollo.view.opengl;

import com.tencent.mobileqq.apollo.view.opengl.EglHelper;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GLThread extends BaseThread {
    static IPatchRedirector $redirector_;
    private boolean C;
    public boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private int N;
    private int P;
    private int Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private ArrayList<Runnable> U;
    private boolean V;
    private Runnable W;
    private EglHelper X;
    private WeakReference<h> Y;
    private final GLThreadManager Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f194411a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f194412b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f194413c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GLThread(GLThreadManager gLThreadManager, WeakReference<h> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) gLThreadManager, (Object) weakReference);
            return;
        }
        this.U = new ArrayList<>();
        this.V = true;
        this.W = null;
        this.f194411a0 = false;
        this.f194413c0 = true;
        setName("GLThread " + getId());
        this.N = 0;
        this.P = 0;
        this.R = true;
        this.Q = 1;
        this.Y = new WeakReference<>(weakReference.get());
        this.Z = gLThreadManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:216:0x02df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void guardedRun() throws InterruptedException {
        GL10 gl10;
        boolean z16;
        boolean z17;
        boolean z18;
        Runnable runnable;
        boolean z19;
        boolean z26;
        boolean preserveEGLContextOnPause;
        this.X = new EglHelper(this.Y);
        this.J = false;
        this.K = false;
        this.S = false;
        boolean z27 = false;
        boolean z28 = false;
        boolean z29 = false;
        boolean z36 = false;
        boolean z37 = false;
        boolean z38 = false;
        boolean z39 = false;
        boolean z46 = false;
        int i3 = 0;
        int i16 = 0;
        Runnable runnable2 = null;
        GL10 gl102 = null;
        while (true) {
            Runnable runnable3 = null;
            while (true) {
                try {
                    synchronized (this.Z) {
                        while (!this.C) {
                            boolean z47 = z29;
                            if (!this.U.isEmpty()) {
                                runnable3 = this.U.remove(0);
                                gl10 = gl102;
                                z29 = z47;
                                z16 = false;
                            } else {
                                boolean z48 = this.F;
                                boolean z49 = this.E;
                                if (z48 != z49) {
                                    this.F = z49;
                                    this.Z.notifyAll();
                                    z19 = z49;
                                    StringBuilder sb5 = new StringBuilder();
                                    runnable = runnable2;
                                    sb5.append("mPaused is now ");
                                    sb5.append(this.F);
                                    sb5.append(" tid=");
                                    gl10 = gl102;
                                    sb5.append(getId());
                                    QLog.i("[ApolloGL][GLThread]", 1, sb5.toString());
                                } else {
                                    runnable = runnable2;
                                    gl10 = gl102;
                                    z19 = false;
                                }
                                if (this.M) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    this.M = false;
                                    z29 = true;
                                } else {
                                    z29 = z47;
                                }
                                if (z27) {
                                    stopEglSurfaceLocked();
                                    stopEglContextLocked();
                                    z27 = false;
                                }
                                if (z19 && this.K) {
                                    stopEglSurfaceLocked();
                                }
                                if (z19 && this.J) {
                                    h hVar = this.Y.get();
                                    if (hVar == null) {
                                        preserveEGLContextOnPause = false;
                                    } else {
                                        preserveEGLContextOnPause = hVar.getPreserveEGLContextOnPause();
                                    }
                                    if (!preserveEGLContextOnPause || this.Z.g()) {
                                        stopEglContextLocked();
                                    }
                                }
                                if (z19 && this.Z.h()) {
                                    this.X.e();
                                }
                                if (!this.G && !this.I) {
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb6 = new StringBuilder();
                                        sb6.append("noticed surfaceView surface lost tid=");
                                        z26 = z36;
                                        sb6.append(getId());
                                        QLog.d("[ApolloGL][GLThread]", 2, sb6.toString());
                                    } else {
                                        z26 = z36;
                                    }
                                    if (this.K) {
                                        stopEglSurfaceLocked();
                                    }
                                    this.I = true;
                                    this.H = false;
                                    this.Z.notifyAll();
                                } else {
                                    z26 = z36;
                                }
                                if (this.G && this.I) {
                                    this.I = false;
                                    this.Z.notifyAll();
                                }
                                if (z28) {
                                    this.S = false;
                                    this.T = true;
                                    this.Z.notifyAll();
                                    z28 = false;
                                }
                                Runnable runnable4 = this.W;
                                if (runnable4 != null) {
                                    this.W = null;
                                } else {
                                    runnable4 = runnable;
                                }
                                if (readyToDraw()) {
                                    if (!this.J) {
                                        if (z29) {
                                            z36 = z26;
                                            z29 = false;
                                        } else if (this.Z.j(this)) {
                                            try {
                                                try {
                                                    this.X.j();
                                                    this.J = true;
                                                    this.Z.notifyAll();
                                                    z36 = true;
                                                } catch (RuntimeException e16) {
                                                    this.Z.f(this);
                                                    throw e16;
                                                }
                                            } catch (EglHelper.EGLException e17) {
                                                QLog.e("[ApolloGL][GLThread]", 1, e17.getMessage());
                                                synchronized (this.Z) {
                                                    stopEglSurfaceLocked();
                                                    stopEglContextLocked();
                                                    return;
                                                }
                                            }
                                        }
                                        if (this.J && !this.K) {
                                            this.K = true;
                                            z37 = true;
                                            z38 = true;
                                            z39 = true;
                                        }
                                        if (!this.K) {
                                            if (this.V) {
                                                i3 = this.N;
                                                i16 = this.P;
                                                this.S = true;
                                                this.V = false;
                                                z16 = false;
                                                z37 = true;
                                                z39 = true;
                                            } else {
                                                z16 = false;
                                            }
                                            this.R = z16;
                                            this.Z.notifyAll();
                                            if (this.S) {
                                                runnable2 = runnable4;
                                                z46 = true;
                                            } else {
                                                runnable2 = runnable4;
                                            }
                                        } else {
                                            runnable2 = runnable4;
                                        }
                                    }
                                    z36 = z26;
                                    if (this.J) {
                                        this.K = true;
                                        z37 = true;
                                        z38 = true;
                                        z39 = true;
                                    }
                                    if (!this.K) {
                                    }
                                } else if (runnable4 != null) {
                                    QLog.d("[ApolloGL][GLThread]", 4, "Warning, !readyToDraw() but waiting for draw finished! Early reporting draw finished.");
                                    runnable4.run();
                                    z36 = z26;
                                    runnable2 = null;
                                } else {
                                    runnable2 = runnable4;
                                    z36 = z26;
                                }
                                LockMethodProxy.wait(this.Z);
                                gl102 = gl10;
                            }
                        }
                        synchronized (this.Z) {
                            stopEglSurfaceLocked();
                            stopEglContextLocked();
                        }
                        return;
                    }
                } catch (Throwable th5) {
                    synchronized (this.Z) {
                    }
                }
                if (runnable3 != null) {
                    break;
                }
                if (z37) {
                    if (this.X.b()) {
                        synchronized (this.Z) {
                            this.L = true;
                            this.Z.notifyAll();
                        }
                        z37 = z16;
                    } else {
                        synchronized (this.Z) {
                            this.L = true;
                            this.H = true;
                            this.Z.notifyAll();
                        }
                        gl102 = gl10;
                    }
                    synchronized (this.Z) {
                        stopEglSurfaceLocked();
                        stopEglContextLocked();
                        throw th5;
                    }
                }
                if (z38) {
                    gl102 = (GL10) this.X.a();
                    this.Z.a(gl102);
                    z38 = false;
                } else {
                    gl102 = gl10;
                }
                if (z36) {
                    h hVar2 = this.Y.get();
                    if (hVar2 != null) {
                        hVar2.getRenderer().onSurfaceCreated(gl102, this.X.f194402e);
                    }
                    z36 = false;
                }
                if (z39) {
                    h hVar3 = this.Y.get();
                    if (hVar3 != null) {
                        if (QLog.isColorLevel()) {
                            z17 = z27;
                            QLog.d("[ApolloGL][GLThread]", 2, "TextureView onSurfaceChanged in Run()");
                        } else {
                            z17 = z27;
                        }
                        hVar3.getRenderer().onSurfaceChanged(gl102, i3, i16);
                    } else {
                        z17 = z27;
                    }
                    z39 = false;
                } else {
                    z17 = z27;
                }
                h hVar4 = this.Y.get();
                if (hVar4 != null && gl102 != null) {
                    hVar4.getRenderer().onDrawFrame(gl102);
                    if (runnable2 != null) {
                        runnable2.run();
                        runnable2 = null;
                    }
                }
                int k3 = this.X.k();
                if (k3 != 12288) {
                    if (k3 != 12302) {
                        EglHelper.i("[ApolloGL][GLThread]", "eglSwapBuffers", k3);
                        synchronized (this.Z) {
                            z18 = true;
                            this.H = true;
                            this.Z.notifyAll();
                        }
                    } else {
                        z18 = true;
                        z17 = true;
                    }
                } else {
                    z18 = true;
                }
                if (z46) {
                    z28 = z18;
                    z46 = false;
                }
                z27 = z17;
            }
            runnable3.run();
            gl102 = gl10;
        }
    }

    private boolean readyToDraw() {
        if (!this.F && this.G && !this.H && this.N > 0 && this.P > 0 && (this.R || this.Q == 1)) {
            return true;
        }
        return false;
    }

    private void stopEglContextLocked() {
        if (this.J) {
            this.X.e();
            this.J = false;
            this.Z.f(this);
        }
    }

    private void stopEglSurfaceLocked() {
        if (this.K) {
            this.K = false;
            this.X.c();
        }
    }

    public boolean ableToDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.J && this.K && readyToDraw()) {
            return true;
        }
        return false;
    }

    public void e(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
            return;
        }
        synchronized (this.Z) {
            if (Thread.currentThread() == this) {
                return;
            }
            this.S = true;
            this.R = true;
            this.T = false;
            this.W = runnable;
            this.Z.notifyAll();
        }
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.f194412b0 = z16;
        }
    }

    public void g(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) runnable);
            return;
        }
        synchronized (this.Z) {
            this.W = runnable;
        }
    }

    public int getRenderMode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        synchronized (this.Z) {
            i3 = this.Q;
        }
        return i3;
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.f194413c0 = z16;
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        synchronized (this.Z) {
            QLog.i("[ApolloGL][GLThread]", 1, "onPause tid=" + getId());
            this.E = true;
            this.Z.notifyAll();
            while (!this.D && !this.F) {
                QLog.i("[ApolloGL][GLThread]Main thread", 1, "onPause waiting for mPaused.");
                try {
                    LockMethodProxy.wait(this.Z);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        synchronized (this.Z) {
            QLog.i("[ApolloGL][GLThread]", 1, "onResume tid=" + getId());
            this.E = false;
            this.R = true;
            this.T = false;
            this.Z.notifyAll();
            while (!this.D && this.F && !this.T) {
                QLog.i("[ApolloGL][GLThread]Main thread", 1, "onResume waiting for !mPaused.");
                try {
                    LockMethodProxy.wait(this.Z);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void onWindowResize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        synchronized (this.Z) {
            this.N = i3;
            this.P = i16;
            this.V = true;
            this.R = true;
            this.T = false;
            if (Thread.currentThread() == this) {
                return;
            }
            this.Z.notifyAll();
            if (this.f194413c0) {
                while (!this.D && !this.F && !this.T && ableToDraw()) {
                    try {
                        LockMethodProxy.wait(this.Z);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void queueEvent(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) runnable);
            return;
        }
        if (runnable != null) {
            synchronized (this.Z) {
                this.U.remove(runnable);
                this.U.add(runnable);
                if (this.U.size() > 100) {
                    QLog.e("[ApolloGL][GLThread]", 1, "GLThread runable queueList size is > 100, last r:", runnable);
                }
                this.Z.notifyAll();
            }
            return;
        }
        throw new IllegalArgumentException("r must not be null");
    }

    public void requestExitAndWait() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        synchronized (this.Z) {
            this.C = true;
            this.Z.notifyAll();
            if (this.f194413c0) {
                while (!this.D) {
                    try {
                        LockMethodProxy.wait(this.Z);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void requestReleaseEglContextLocked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.M = true;
            this.Z.notifyAll();
        }
    }

    public void requestRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        synchronized (this.Z) {
            this.R = true;
            this.Z.notifyAll();
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            guardedRun();
        } catch (InterruptedException unused) {
        } catch (Throwable th5) {
            this.Z.i(this);
            throw th5;
        }
        this.Z.i(this);
    }

    public void setRenderMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (i3 >= 0 && i3 <= 1) {
            synchronized (this.Z) {
                this.Q = i3;
                this.Z.notifyAll();
            }
            return;
        }
        throw new IllegalArgumentException("renderMode");
    }

    public void surfaceCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        synchronized (this.Z) {
            this.G = true;
            this.L = false;
            this.Z.notifyAll();
            if (this.f194413c0) {
                while (this.I && !this.L && !this.D) {
                    try {
                        LockMethodProxy.wait(this.Z);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void surfaceDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.f194412b0) {
            this.G = false;
            new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.apollo.view.opengl.GLThread.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GLThread.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        synchronized (GLThread.this.Z) {
                            GLThread.this.G = false;
                            GLThread.this.Z.notifyAll();
                        }
                        return;
                    }
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }).start();
            return;
        }
        synchronized (this.Z) {
            this.G = false;
            this.Z.notifyAll();
            if (this.f194413c0) {
                while (!this.I && !this.D) {
                    if (!this.f194411a0 && QLog.isColorLevel()) {
                        this.f194411a0 = true;
                        QLog.d("[ApolloGL][GLThread]", 2, "mWaitingForSurface " + this.I + " mExited " + this.D);
                    }
                    try {
                        LockMethodProxy.wait(this.Z);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
