package com.tencent.aelight.camera.ae.flashshow.filter;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex;
import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

/* loaded from: classes32.dex */
public abstract class LSFilterProcessBase {

    /* renamed from: a, reason: collision with root package name */
    protected int f64255a;

    /* renamed from: b, reason: collision with root package name */
    protected int f64256b;

    /* renamed from: c, reason: collision with root package name */
    protected int f64257c;

    /* renamed from: d, reason: collision with root package name */
    protected int f64258d;

    /* renamed from: e, reason: collision with root package name */
    protected int f64259e;

    /* renamed from: f, reason: collision with root package name */
    protected int f64260f;

    /* renamed from: g, reason: collision with root package name */
    protected int f64261g;

    /* renamed from: h, reason: collision with root package name */
    protected int f64262h;

    /* renamed from: i, reason: collision with root package name */
    protected int f64263i;

    /* renamed from: j, reason: collision with root package name */
    protected int f64264j;

    /* renamed from: k, reason: collision with root package name */
    protected double f64265k;

    /* renamed from: l, reason: collision with root package name */
    protected double f64266l;

    /* renamed from: p, reason: collision with root package name */
    protected int f64270p;

    /* renamed from: q, reason: collision with root package name */
    protected SurfaceTexture f64271q;

    /* renamed from: v, reason: collision with root package name */
    protected LSFilterProcessTex.d f64276v;

    /* renamed from: w, reason: collision with root package name */
    private LSCameraGLSurfaceView.z f64277w;

    /* renamed from: y, reason: collision with root package name */
    private long f64279y;

    /* renamed from: m, reason: collision with root package name */
    protected VideoOutRatio f64267m = VideoOutRatio.NONE;

    /* renamed from: n, reason: collision with root package name */
    protected final int[] f64268n = new int[2];

    /* renamed from: o, reason: collision with root package name */
    protected boolean f64269o = false;

    /* renamed from: r, reason: collision with root package name */
    protected int[] f64272r = new int[2];

    /* renamed from: s, reason: collision with root package name */
    protected final float[] f64273s = new float[16];

    /* renamed from: t, reason: collision with root package name */
    protected volatile boolean f64274t = false;

    /* renamed from: u, reason: collision with root package name */
    protected int f64275u = 90;

    /* renamed from: x, reason: collision with root package name */
    protected final int f64278x = 1080;

    /* renamed from: z, reason: collision with root package name */
    private long f64280z = ((Long) ((IVSConfigManager) QRoute.api(IVSConfigManager.class)).getValue(IVSConfigManager.SMART_CUT_PIC_INTERVAL, 500L)).longValue();
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;

    /* loaded from: classes32.dex */
    public enum VideoOutRatio {
        NONE(0.0f),
        RATIO_9_16(0.5625f);

        float ratio;

        VideoOutRatio(float f16) {
            this.ratio = f16;
        }
    }

    private void e() {
        if (this.A) {
            GLES20.glDeleteTextures(1, new int[]{this.f64270p}, 0);
            this.f64271q.release();
            this.f64271q = null;
            this.A = false;
        }
    }

    public void a(int i3) {
        if (this.f64277w == null || i3 <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f64279y >= this.f64280z) {
            this.f64277w.onExtract(GlUtil.captureFrame(i3, this.f64259e, this.f64260f, 0));
            this.f64279y = currentTimeMillis;
        }
    }

    public void b() {
        e();
        if (this.C) {
            c();
            this.C = false;
        }
    }

    protected abstract void c();

    public abstract void d(boolean z16);

    public int[] f() {
        return this.f64268n;
    }

    public void g() {
        if (this.C) {
            return;
        }
        i();
        this.C = true;
    }

    public SurfaceTexture h() {
        if (l()) {
            return this.f64271q;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f64270p = iArr[0];
        com.tencent.aelight.camera.ae.camera.testpkg.c cVar = new com.tencent.aelight.camera.ae.camera.testpkg.c(this.f64270p);
        this.f64271q = cVar;
        this.A = true;
        return cVar;
    }

    protected abstract void i();

    public boolean j() {
        return this.f64267m == VideoOutRatio.RATIO_9_16;
    }

    public boolean k() {
        return l() && this.C;
    }

    protected boolean l() {
        return this.A || this.B;
    }

    public abstract void m();

    public void n(boolean z16, int i3, LSFilterProcessTex.d dVar) {
        this.f64274t = z16;
        this.f64275u = i3;
        this.f64276v = dVar;
    }

    public void o(LSCameraGLSurfaceView.z zVar) {
        this.f64277w = zVar;
    }

    public void p(boolean z16) {
        this.f64269o = z16;
    }

    public void q(int i3, SurfaceTexture surfaceTexture) {
        if (this.A) {
            e();
        }
        this.f64270p = i3;
        this.f64271q = surfaceTexture;
        this.B = true;
    }

    public void r(VideoOutRatio videoOutRatio) {
        this.f64267m = videoOutRatio;
    }

    public abstract int[] s(int i3, int i16, boolean z16);

    public void t() {
        try {
            SurfaceTexture surfaceTexture = this.f64271q;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.f64271q.getTransformMatrix(this.f64273s);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public abstract void u(float f16);

    public void v(int i3, int i16, int i17, int i18, int i19, int i26) {
        ms.a.f("LSFilterProcessBase", "previewWidth: " + i19 + " previewHeight: " + i26);
        double d16 = ((double) i3) / ((double) i16);
        this.f64266l = d16;
        if (i17 > 0 && i18 > 0) {
            this.f64261g = i17;
            this.f64262h = i18;
            this.f64265k = i17 / i18;
        }
        this.f64259e = i19;
        int i27 = (int) (i19 / d16);
        this.f64260f = i27;
        this.f64257c = i19;
        this.f64258d = (int) (i19 / d16);
        this.f64255a = 1080;
        this.f64256b = (int) (1080 / d16);
        int[] iArr = this.f64268n;
        iArr[0] = i19;
        iArr[1] = i27;
    }

    public void w(int i3, int i16) {
        this.f64263i = i3;
        this.f64264j = i16;
    }
}
