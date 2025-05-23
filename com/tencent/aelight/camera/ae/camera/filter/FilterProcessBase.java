package com.tencent.aelight.camera.ae.camera.filter;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.util.api.IVSConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

/* loaded from: classes32.dex */
public abstract class FilterProcessBase {

    /* renamed from: a, reason: collision with root package name */
    protected int f62249a;

    /* renamed from: b, reason: collision with root package name */
    protected int f62250b;

    /* renamed from: c, reason: collision with root package name */
    protected int f62251c;

    /* renamed from: d, reason: collision with root package name */
    protected int f62252d;

    /* renamed from: e, reason: collision with root package name */
    protected int f62253e;

    /* renamed from: f, reason: collision with root package name */
    protected int f62254f;

    /* renamed from: g, reason: collision with root package name */
    protected int f62255g;

    /* renamed from: h, reason: collision with root package name */
    protected int f62256h;

    /* renamed from: i, reason: collision with root package name */
    protected int f62257i;

    /* renamed from: j, reason: collision with root package name */
    protected int f62258j;

    /* renamed from: k, reason: collision with root package name */
    protected double f62259k;

    /* renamed from: l, reason: collision with root package name */
    protected double f62260l;

    /* renamed from: p, reason: collision with root package name */
    protected int f62264p;

    /* renamed from: q, reason: collision with root package name */
    protected SurfaceTexture f62265q;

    /* renamed from: v, reason: collision with root package name */
    protected AEFilterProcessTex.c f62270v;

    /* renamed from: w, reason: collision with root package name */
    private AECameraGLSurfaceView.ExtractFrameRequest f62271w;

    /* renamed from: y, reason: collision with root package name */
    private long f62273y;

    /* renamed from: m, reason: collision with root package name */
    protected VideoOutRatio f62261m = VideoOutRatio.NONE;

    /* renamed from: n, reason: collision with root package name */
    protected final int[] f62262n = new int[2];

    /* renamed from: o, reason: collision with root package name */
    protected boolean f62263o = false;

    /* renamed from: r, reason: collision with root package name */
    protected int[] f62266r = new int[2];

    /* renamed from: s, reason: collision with root package name */
    protected final float[] f62267s = new float[16];

    /* renamed from: t, reason: collision with root package name */
    protected volatile boolean f62268t = false;

    /* renamed from: u, reason: collision with root package name */
    protected int f62269u = 90;

    /* renamed from: x, reason: collision with root package name */
    protected final int f62272x = 1080;

    /* renamed from: z, reason: collision with root package name */
    private long f62274z = ((Long) ((IVSConfigManager) QRoute.api(IVSConfigManager.class)).getValue(IVSConfigManager.SMART_CUT_PIC_INTERVAL, 500L)).longValue();
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
            GLES20.glDeleteTextures(1, new int[]{this.f62264p}, 0);
            this.f62265q.release();
            this.f62265q = null;
            this.A = false;
        }
    }

    public void a(int i3) {
        if (this.f62271w == null || i3 <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f62273y >= this.f62274z) {
            this.f62271w.onExtract(GlUtil.captureFrame(i3, this.f62253e, this.f62254f, 0));
            this.f62273y = currentTimeMillis;
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
        return this.f62262n;
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
            return this.f62265q;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f62264p = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f62264p);
        this.f62265q = surfaceTexture;
        this.A = true;
        return surfaceTexture;
    }

    protected abstract void i();

    public boolean j() {
        return this.f62261m == VideoOutRatio.RATIO_9_16;
    }

    public boolean k() {
        return l() && this.C;
    }

    protected boolean l() {
        return this.A || this.B;
    }

    public abstract void m();

    public void n(boolean z16, int i3, AEFilterProcessTex.c cVar) {
        this.f62268t = z16;
        this.f62269u = i3;
        this.f62270v = cVar;
    }

    public void o(AECameraGLSurfaceView.ExtractFrameRequest extractFrameRequest) {
        this.f62271w = extractFrameRequest;
    }

    public void p(boolean z16) {
        this.f62263o = z16;
    }

    public void q(int i3, SurfaceTexture surfaceTexture) {
        if (this.A) {
            e();
        }
        this.f62264p = i3;
        this.f62265q = surfaceTexture;
        this.B = true;
    }

    public void r(VideoOutRatio videoOutRatio) {
        this.f62261m = videoOutRatio;
    }

    public abstract int[] s(int i3, int i16, boolean z16);

    public void t() {
        try {
            SurfaceTexture surfaceTexture = this.f62265q;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
                this.f62265q.getTransformMatrix(this.f62267s);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public abstract void u(float f16);

    public void v(int i3, int i16, int i17, int i18, int i19, int i26) {
        ms.a.f("FilterProcessBase", "previewWidth: " + i19 + " previewHeight: " + i26);
        double d16 = ((double) i3) / ((double) i16);
        this.f62260l = d16;
        if (i17 > 0 && i18 > 0) {
            this.f62255g = i17;
            this.f62256h = i18;
            this.f62259k = i17 / i18;
        }
        this.f62253e = i19;
        int i27 = (int) (i19 / d16);
        this.f62254f = i27;
        this.f62251c = i19;
        this.f62252d = (int) (i19 / d16);
        this.f62249a = 1080;
        this.f62250b = (int) (1080 / d16);
        int[] iArr = this.f62262n;
        iArr[0] = i19;
        iArr[1] = i27;
    }

    public void w(int i3, int i16) {
        this.f62257i = i3;
        this.f62258j = i16;
    }
}
