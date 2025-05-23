package com.tencent.qqcamerakit.preview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.widget.Toast;
import com.tencent.ark.EGLContextHolder;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqcamerakit.capture.c;
import com.tencent.qqcamerakit.capture.camerastrategy.c;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CameraCaptureView extends GLSurfaceView implements com.tencent.qqcamerakit.common.d, GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener, c.b, c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: g0, reason: collision with root package name */
    static final /* synthetic */ boolean f344920g0;
    protected int C;
    protected int D;
    private int E;
    private int F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    public EGLConfig K;
    public EGLContext L;
    private final float[] M;
    private int N;
    private int P;
    private SurfaceTexture Q;
    private EglHandlerThread R;
    private g S;
    private f T;
    private boolean U;
    private com.tencent.qqcamerakit.capture.cameraextend.a V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private Matrix f344921a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f344922b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f344923c0;

    /* renamed from: d, reason: collision with root package name */
    public int f344924d;

    /* renamed from: d0, reason: collision with root package name */
    private long f344925d0;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.qqcamerakit.capture.c f344926e;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.qqcamerakit.capture.b f344927e0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f344928f;

    /* renamed from: f0, reason: collision with root package name */
    private GLSurfaceView.EGLContextFactory f344929f0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f344930h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f344931i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f344932m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements GLSurfaceView.EGLContextFactory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f344934a;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CameraCaptureView.this);
            } else {
                this.f344934a = EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION;
            }
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (EGLContext) iPatchRedirector.redirect((short) 2, this, egl10, eGLDisplay, eGLConfig);
            }
            int[] iArr = {this.f344934a, 2, 12344};
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 1, "createContext. display = " + eGLDisplay + " tid = " + Thread.currentThread().getId());
            }
            CameraCaptureView cameraCaptureView = CameraCaptureView.this;
            cameraCaptureView.K = eGLConfig;
            cameraCaptureView.L = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, iArr);
            return CameraCaptureView.this.L;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, egl10, eGLDisplay, eGLContext);
                return;
            }
            CameraCaptureView.this.l();
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                com.tencent.qqcamerakit.common.e.d("CameraCaptureView", 1, "destroyContext. display = " + eGLDisplay + " context = " + eGLContext + " tid = " + Thread.currentThread().getId());
            }
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 1, "destroyContext. display = " + eGLDisplay + " context = " + eGLContext + " tid = " + Thread.currentThread().getId());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11656);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
        } else {
            f344920g0 = true;
        }
    }

    public CameraCaptureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f344924d = 2;
        this.f344928f = false;
        this.f344930h = false;
        this.f344931i = false;
        this.f344932m = false;
        this.K = null;
        this.L = null;
        this.M = new float[16];
        this.U = false;
        this.f344921a0 = new Matrix();
        this.f344922b0 = false;
        this.f344923c0 = -1L;
        this.f344925d0 = 0L;
        this.f344929f0 = new a();
        g();
    }

    public static int d(int i3) {
        int i16 = i3 % 16;
        if (i16 != 0) {
            if (i16 < 8) {
                return i3 - i16;
            }
            return i3 + (16 - i16);
        }
        return i3;
    }

    public static int[] e(int i3, int i16, int i17, int i18, float f16) {
        float f17 = i3;
        int d16 = d((int) (f17 * f16));
        float f18 = i16;
        int d17 = d((int) (f18 * f16));
        float f19 = (f18 * 1.0f) / f17;
        float f26 = (i18 * 1.0f) / i17;
        if (f19 > f26) {
            d17 = d((int) (d16 * f26));
        } else {
            d16 = d((int) (d17 / f26));
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 2, "clipVideoSize(" + i3 + "," + i16 + "," + i17 + "," + i18 + "," + f16 + ") = (" + d16 + "," + d17 + ")");
        }
        return new int[]{d16, d17};
    }

    private void f() {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f344923c0;
        if (j3 == -1) {
            this.f344923c0 = currentTimeMillis;
            return;
        }
        if (currentTimeMillis - j3 >= 500) {
            this.f344923c0 = currentTimeMillis;
            this.f344925d0 = 0L;
        }
        this.f344925d0++;
    }

    private void g() {
        setEGLContextFactory(this.f344929f0);
        setEGLContextClientVersion(2);
        this.f344926e = new com.tencent.qqcamerakit.capture.c(getContext(), null);
        setRenderer(this);
        setRenderMode(0);
        this.V = new com.tencent.qqcamerakit.capture.cameraextend.a();
    }

    private int i() {
        if (!f344920g0 && this.T == null) {
            throw new AssertionError();
        }
        this.T.a();
        synchronized (this.Q) {
            this.Q.getTransformMatrix(this.M);
            this.S.a(36197, this.P, this.M, c.a(this.G, this.H, this.T.d(), this.T.b()));
        }
        this.T.e();
        return this.T.c();
    }

    private void m() {
        if (!this.f344931i && this.f344928f) {
            this.f344926e.j(this);
            this.f344926e.i(this.f344924d, this.f344922b0);
            this.f344931i = true;
        }
    }

    private void n() {
        if (this.f344930h && this.f344931i) {
            if (!this.f344932m || this.E != this.C || this.F != this.D) {
                if (com.tencent.qqcamerakit.common.e.f()) {
                    com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 2, "startCameraPreview, surfaceWidth:" + this.C + ", surfaceHeight:" + this.D);
                }
                this.f344926e.o(new com.tencent.qqcamerakit.capture.d(1920, 1080), 30);
                this.f344926e.r(this.Q, this.f344927e0);
                this.f344932m = true;
                this.E = this.C;
                this.F = this.D;
            }
        }
    }

    private void o() {
        if (!this.f344931i) {
            return;
        }
        this.f344926e.s(false);
        this.f344932m = false;
        this.f344926e.b(false);
        this.f344931i = false;
        this.f344926e.v(this);
    }

    @Override // com.tencent.qqcamerakit.capture.c.b
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        if (str.startsWith("/storage/emulated/0")) {
            str = str.replace("/storage/emulated/0", "SD\u5361");
        }
        Toast.makeText(getContext(), "\u5df2\u4fdd\u5b58\u7167\u7247\u5230" + str, 1).show();
    }

    protected void h(com.tencent.qqcamerakit.capture.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) dVar);
            return;
        }
        int i3 = dVar.f344912b;
        this.G = i3;
        int i16 = dVar.f344911a;
        this.H = i16;
        int[] e16 = e(i3, i16, this.C, this.D, 1.0f);
        int i17 = e16[0];
        this.I = i17;
        int i18 = e16[1];
        this.J = i18;
        this.f344921a0 = this.V.d(i17, i18, this.C, this.D, this.f344924d);
        queueEvent(new Runnable() { // from class: com.tencent.qqcamerakit.preview.CameraCaptureView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CameraCaptureView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    CameraCaptureView cameraCaptureView = CameraCaptureView.this;
                    cameraCaptureView.T = new f(cameraCaptureView.I, cameraCaptureView.J, 33984);
                }
            }
        });
    }

    protected int j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        return i3;
    }

    protected int k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        return i3;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 2, "onSurfaceDestroy");
        }
        this.f344930h = false;
        SurfaceTexture surfaceTexture = this.Q;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
        }
        o();
    }

    @Override // com.tencent.qqcamerakit.common.d
    public void notify(int i3, int i16, String str, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16), str, objArr);
            return;
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 2, "notify, eventId:", Integer.valueOf(i3), "  errorCode:", Integer.valueOf(i16), "  errorMsg:", str, "  args:", Arrays.toString(objArr));
        }
        if (i3 != 1) {
            if (i3 == 2) {
                if (i16 == 0) {
                    h((com.tencent.qqcamerakit.capture.d) objArr[0]);
                    return;
                } else {
                    Toast.makeText(getContext(), "\u76f8\u673a\u6253\u5f00\u5931\u8d25", 1).show();
                    return;
                }
            }
            return;
        }
        if (i16 != 0) {
            Toast.makeText(getContext(), "\u76f8\u673a\u6253\u5f00\u5931\u8d25", 1).show();
        }
    }

    @Override // com.tencent.qqcamerakit.capture.c.a
    public void onAutoFocusCallback(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else {
            this.W = z16;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) gl10);
            return;
        }
        if (this.G != 0 && this.H != 0 && this.T != null) {
            if (!this.f344931i) {
                if (com.tencent.qqcamerakit.common.e.f()) {
                    com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 2, "onDrawFrame ignore");
                    return;
                }
                return;
            }
            int i3 = i();
            this.N = i3;
            int k3 = k(j(i3));
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glViewport(0, 0, this.C, this.D);
            this.S.a(GLSLRender.GL_TEXTURE_2D, k3, null, null);
            f();
            return;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 2, "onDrawFrame clean");
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) surfaceTexture);
            return;
        }
        Runnable runnable = new Runnable(surfaceTexture) { // from class: com.tencent.qqcamerakit.preview.CameraCaptureView.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SurfaceTexture f344933d;

            {
                this.f344933d = surfaceTexture;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CameraCaptureView.this, (Object) surfaceTexture);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    try {
                        synchronized (CameraCaptureView.this.Q) {
                            this.f344933d.updateTexImage();
                        }
                        CameraCaptureView.this.requestRender();
                        return;
                    } catch (Exception e16) {
                        com.tencent.qqcamerakit.common.e.c("CameraCaptureView", 1, e16, new Object[0]);
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        if (this.R.isInitSuccess() && !this.U) {
            this.R.getHandler().post(runnable);
        } else {
            queueEvent(runnable);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, gl10, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 2, "onSurfaceChanged(): width " + i3 + ";height" + i16);
        }
        this.f344930h = true;
        this.C = i3;
        this.D = i16;
        m();
        n();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) gl10, (Object) eGLConfig);
            return;
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.a("CameraCaptureView", 2, "onSurfaceCreated");
        }
        this.f344930h = false;
        EglHandlerThread eglHandlerThread = this.R;
        EglHandlerThread eglHandlerThread2 = new EglHandlerThread("update_texture", EGL14.eglGetCurrentContext());
        this.R = eglHandlerThread2;
        eglHandlerThread2.start();
        if (eglHandlerThread != null) {
            eglHandlerThread.quitSafely();
        }
        this.S = new g();
        this.P = e.d(36197);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.P);
        this.Q = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.U = com.tencent.qqcamerakit.capture.camerastrategy.b.e(c.a.f344896e);
    }

    public void setExposure(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.f344926e.l(i3, j3);
        }
    }

    public void setFrameListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) bVar);
        }
    }

    public void setFrontFlashEnable(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, activity, Boolean.valueOf(z16));
        } else {
            this.f344926e.n(activity, z16);
        }
    }

    public void setPreviewCallBack(com.tencent.qqcamerakit.capture.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) bVar);
        } else {
            this.f344927e0 = bVar;
        }
    }

    public void setUseWideAngleLens(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else if (this.f344922b0 != z16) {
            this.f344922b0 = z16;
            o();
            m();
            n();
        }
    }

    public void setZoom(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        } else {
            this.f344926e.q(f16);
        }
    }

    public CameraCaptureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f344924d = 2;
        this.f344928f = false;
        this.f344930h = false;
        this.f344931i = false;
        this.f344932m = false;
        this.K = null;
        this.L = null;
        this.M = new float[16];
        this.U = false;
        this.f344921a0 = new Matrix();
        this.f344922b0 = false;
        this.f344923c0 = -1L;
        this.f344925d0 = 0L;
        this.f344929f0 = new a();
        g();
    }
}
