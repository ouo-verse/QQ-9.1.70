package com.tencent.mobileqq.apollo.view.opengl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GLSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, h {
    static IPatchRedirector $redirector_;
    private static final GLThreadManager H;
    private g C;
    private i D;
    private int E;
    private int F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<h> f194404d;

    /* renamed from: e, reason: collision with root package name */
    private GLThread f194405e;

    /* renamed from: f, reason: collision with root package name */
    private k f194406f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f194407h;

    /* renamed from: i, reason: collision with root package name */
    private e f194408i;

    /* renamed from: m, reason: collision with root package name */
    private f f194409m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38024);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            H = new GLThreadManager();
        }
    }

    public GLSurfaceView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f194404d = new WeakReference<>(this);
            b();
        }
    }

    private void a() {
        if (this.f194405e == null) {
        } else {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void b() {
        GLThreadManager.e(getContext());
        getHolder().addCallback(this);
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            GLThread gLThread = this.f194405e;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public int getDebugFlags() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.E;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public e getEGLConfigChooser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (e) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f194408i;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public f getEGLContextFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (f) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f194409m;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public g getEGLWindowSurfaceFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (g) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.C;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public i getGLWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (i) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.D;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public Object getNativeWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return getHolder();
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public boolean getPreserveEGLContextOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.G;
    }

    @Override // com.tencent.mobileqq.apollo.view.opengl.h
    public k getRenderer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (k) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f194406f;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        QLog.d("[ApolloGL][GLSurfaceView]", 1, "onAttachedToWindow reattach =" + this.f194407h);
        if (this.f194407h && this.f194406f != null) {
            GLThread gLThread = this.f194405e;
            if (gLThread != null) {
                i3 = gLThread.getRenderMode();
            } else {
                i3 = 1;
            }
            GLThread gLThread2 = new GLThread(H, this.f194404d);
            this.f194405e = gLThread2;
            if (i3 != 1) {
                gLThread2.setRenderMode(i3);
            }
            this.f194405e.start();
        }
        this.f194407h = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        QLog.d("[ApolloGL][GLSurfaceView]", 1, NodeProps.ON_DETACHED_FROM_WINDOW);
        GLThread gLThread = this.f194405e;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.f194407h = true;
        super.onDetachedFromWindow();
    }

    public void setDebugFlags(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void setEGLConfigChooser(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) eVar);
        } else {
            a();
            this.f194408i = eVar;
        }
    }

    public void setEGLContextClientVersion(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            a();
            this.F = i3;
        }
    }

    public void setEGLContextFactory(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) fVar);
        } else {
            a();
            this.f194409m = fVar;
        }
    }

    public void setEGLWindowSurfaceFactory(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) gVar);
        } else {
            a();
            this.C = gVar;
        }
    }

    public void setGLWrapper(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iVar);
        } else {
            this.D = iVar;
        }
    }

    public void setPreserveEGLContextOnPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }

    public void setRenderMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.f194405e.setRenderMode(i3);
        }
    }

    public void setRenderer(k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) kVar);
            return;
        }
        a();
        if (this.f194408i == null) {
            this.f194408i = new l(this.F, true);
        }
        if (this.f194409m == null) {
            this.f194409m = new c(this.F);
        }
        if (this.C == null) {
            this.C = new d();
        }
        this.f194406f = kVar;
        GLThread gLThread = new GLThread(H, this.f194404d);
        this.f194405e = gLThread;
        gLThread.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.f194405e.onWindowResize(i16, i17);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) surfaceHolder);
        } else {
            this.f194405e.surfaceCreated();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) surfaceHolder);
        } else {
            this.f194405e.surfaceDestroyed();
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) surfaceHolder, (Object) runnable);
            return;
        }
        GLThread gLThread = this.f194405e;
        if (gLThread != null) {
            gLThread.e(runnable);
        }
    }

    public void setEGLConfigChooser(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            setEGLConfigChooser(new l(this.F, z16));
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
        }
    }

    public GLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f194404d = new WeakReference<>(this);
            b();
        }
    }

    public void setEGLConfigChooser(int i3, int i16, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            setEGLConfigChooser(new b(this.F, i3, i16, i17, i18, i19, i26));
        } else {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
        }
    }
}
