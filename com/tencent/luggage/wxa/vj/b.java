package com.tencent.luggage.wxa.vj;

import android.content.res.Configuration;
import android.graphics.Point;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.luggage.wxa.ag.g;
import com.tencent.luggage.wxa.ag.h;
import com.tencent.luggage.wxa.ag.j;
import com.tencent.luggage.wxa.il.f;
import com.tencent.luggage.wxa.kj.o0;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.f0;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {
    public int A;
    public int B;
    public int C;
    public int D;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;

    /* renamed from: b, reason: collision with root package name */
    public final v f143530b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.il.f f143531c;

    /* renamed from: d, reason: collision with root package name */
    public final View f143532d;

    /* renamed from: e, reason: collision with root package name */
    public final h f143533e;

    /* renamed from: f, reason: collision with root package name */
    public final j f143534f;

    /* renamed from: g, reason: collision with root package name */
    public final f0 f143535g;

    /* renamed from: j, reason: collision with root package name */
    public int f143538j;

    /* renamed from: k, reason: collision with root package name */
    public int f143539k;

    /* renamed from: m, reason: collision with root package name */
    public int f143541m;

    /* renamed from: n, reason: collision with root package name */
    public int f143542n;

    /* renamed from: o, reason: collision with root package name */
    public int f143543o;

    /* renamed from: p, reason: collision with root package name */
    public int f143544p;

    /* renamed from: q, reason: collision with root package name */
    public int f143545q;

    /* renamed from: r, reason: collision with root package name */
    public int f143546r;

    /* renamed from: s, reason: collision with root package name */
    public int f143547s;

    /* renamed from: t, reason: collision with root package name */
    public int f143548t;

    /* renamed from: u, reason: collision with root package name */
    public int f143549u;

    /* renamed from: v, reason: collision with root package name */
    public int f143550v;

    /* renamed from: w, reason: collision with root package name */
    public int f143551w;

    /* renamed from: x, reason: collision with root package name */
    public int f143552x;

    /* renamed from: y, reason: collision with root package name */
    public int f143553y;

    /* renamed from: z, reason: collision with root package name */
    public int f143554z;

    /* renamed from: a, reason: collision with root package name */
    public final String f143529a = "MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#" + hashCode();

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f143536h = false;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f143537i = false;

    /* renamed from: l, reason: collision with root package name */
    public d f143540l = null;
    public int E = com.tencent.luggage.wxa.il.f.f130665l0;
    public int F = com.tencent.luggage.wxa.il.f.f130664k0;
    public int G = com.tencent.luggage.wxa.il.f.f130666m0;
    public int H = com.tencent.luggage.wxa.il.f.f130667n0;
    public int I = com.tencent.luggage.wxa.il.f.f130668o0;
    public int J = com.tencent.luggage.wxa.il.f.f130669p0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements h.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ag.h.a
        public void a(int i3, int i16) {
            if (b.this.f143537i) {
                w.d(b.this.f143529a, "onConfigurationChanged, onVideoPositionGot, released");
            } else {
                b.this.f143531c.a(b.this.a(i3, i16, null));
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vj.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC6851b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Point f143556a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Point f143557b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f143558c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f143559d;

        public RunnableC6851b(Point point, Point point2, int i3, int i16) {
            this.f143556a = point;
            this.f143557b = point2;
            this.f143558c = i3;
            this.f143559d = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f143536h) {
                w.d(b.this.f143529a, "handleVideoPage2PipStart, true == mHandleStarted");
                return;
            }
            int i3 = b.this.f143533e.i();
            int k3 = b.this.f143533e.k();
            Point point = this.f143556a;
            int i16 = point.x;
            Point point2 = this.f143557b;
            w.d(b.this.f143529a, "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", Integer.valueOf(i16 + point2.x), Integer.valueOf(point.y + point2.y));
            com.tencent.luggage.wxa.il.f fVar = b.this.f143531c;
            b bVar = b.this;
            Point point3 = this.f143556a;
            fVar.a(bVar.a(point3.x, point3.y, this.f143557b));
            b.this.a(this.f143558c, this.f143559d, i3, k3);
            b.this.f143531c.a(b.this.f143553y, b.this.f143554z);
            b bVar2 = b.this;
            bVar2.a(0.0f, bVar2.f143541m, b.this.f143542n, b.this.f143543o, b.this.f143544p, b.this.f143545q, b.this.f143546r, b.this.f143547s, b.this.f143548t, b.this.f143549u, b.this.f143550v, b.this.f143551w, b.this.f143552x);
            b.this.f143536h = true;
            if (b.this.f143535g != null) {
                w.d(b.this.f143529a, "handleVideoPage2PipStart, run afterStartTask");
                b.this.f143535g.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements h.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Point f143561a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f143562b;

        public c(Point point, Runnable runnable) {
            this.f143561a = point;
            this.f143562b = runnable;
        }

        @Override // com.tencent.luggage.wxa.ag.h.a
        public void a(int i3, int i16) {
            if (b.this.f143537i) {
                w.d(b.this.f143529a, "handleVideoPage2PipStart, onVideoPositionGot, released");
                return;
            }
            Point point = this.f143561a;
            point.x = i3;
            point.y = i16;
            this.f143562b.run();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements f.d {

        /* renamed from: a, reason: collision with root package name */
        public int f143564a;

        /* renamed from: b, reason: collision with root package name */
        public int f143565b;

        /* renamed from: c, reason: collision with root package name */
        public Point f143566c;

        public d() {
            this.f143566c = null;
        }

        public /* synthetic */ d(b bVar, a aVar) {
            this();
        }

        @Override // com.tencent.luggage.wxa.il.f.d
        public void a(int i3, int i16) {
            w.a(b.this.f143529a, "MyOnStablePositionChangeListener, onStablePositionChange");
            if (b.this.f143537i) {
                w.d(b.this.f143529a, "onStablePositionChange, onVideoPositionGot, released");
                return;
            }
            int c16 = b.this.c();
            int b16 = b.this.b();
            int i17 = b.this.f143533e.i();
            int k3 = b.this.f143533e.k();
            if (this.f143566c == null) {
                this.f143566c = b.this.a();
            }
            Point point = this.f143566c;
            if (point == null) {
                w.f(b.this.f143529a, "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
                return;
            }
            int i18 = this.f143564a;
            int i19 = this.f143565b + point.y;
            w.d(b.this.f143529a, "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", Integer.valueOf(i18), Integer.valueOf(i19));
            b.this.a(c16, b16, i17, k3, i18, i19);
        }
    }

    public b(v vVar, com.tencent.luggage.wxa.il.f fVar, View view, h hVar, j jVar, f0 f0Var) {
        this.f143530b = vVar;
        this.f143531c = fVar;
        this.f143532d = view;
        this.f143533e = hVar;
        this.f143534f = jVar;
        this.f143535g = f0Var;
    }

    public void b(float f16) {
        if (!this.f143536h) {
            w.f(this.f143529a, "handleVideoTransferProgress, false == mHandleStarted");
        } else {
            a(f16);
            a(f16, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R, this.S, this.T, this.U, this.V);
        }
    }

    public final int c() {
        int videoWidth = this.f143534f.getVideoWidth();
        if (videoWidth == 0) {
            return -1;
        }
        return videoWidth;
    }

    public void d() {
        w.d(this.f143529a, "handleVideoPage2PipEnd");
        if (!this.f143536h) {
            a(false);
        }
        a(100.0f, this.f143553y, this.f143554z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J);
    }

    public boolean e() {
        return a(true);
    }

    public void f() {
        w.d(this.f143529a, "release");
        d dVar = this.f143540l;
        if (dVar != null) {
            this.f143531c.b(dVar);
        }
        this.f143537i = true;
    }

    public final int b() {
        int videoHeight = this.f143534f.getVideoHeight();
        if (videoHeight == 0) {
            return -1;
        }
        return videoHeight;
    }

    public void a(Configuration configuration) {
        w.d(this.f143529a, "onConfigurationChanged");
        if (!this.f143536h) {
            w.a(this.f143529a, "onConfigurationChanged, false == mHandleStarted");
        } else {
            this.f143533e.a(this.f143530b, new a());
        }
    }

    public final boolean a(boolean z16) {
        int c16 = c();
        int b16 = b();
        Point a16 = a();
        if (a16 == null) {
            w.f(this.f143529a, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
            return false;
        }
        Point point = new Point();
        RunnableC6851b runnableC6851b = new RunnableC6851b(point, a16, c16, b16);
        if (z16) {
            this.f143533e.a(this.f143530b, new c(point, runnableC6851b));
            return true;
        }
        Point e16 = this.f143533e.e();
        point.x = e16.x;
        point.y = e16.y;
        runnableC6851b.run();
        return true;
    }

    public final f.d a(int i3, int i16, Point point) {
        if (this.f143540l == null) {
            this.f143540l = new d(this, null);
        }
        this.f143540l.f143564a = i3;
        this.f143540l.f143565b = i16;
        this.f143540l.f143566c = point;
        return this.f143540l;
    }

    public final Point a() {
        o0 D0 = this.f143530b.D0();
        if (D0 == null) {
            w.f(this.f143529a, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
            return null;
        }
        View contentView = D0.getContentView();
        if (contentView == null) {
            w.f(this.f143529a, "calculateWebView2PipContainerParentOffset, null == webView");
            return null;
        }
        ViewParent parent = this.f143531c.getParent();
        if (!(parent instanceof ViewGroup)) {
            w.f(this.f143529a, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.f143538j = viewGroup.getWidth();
        this.f143539k = viewGroup.getHeight();
        w.a(this.f143529a, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", Integer.valueOf(this.f143538j), Integer.valueOf(this.f143539k));
        ViewParent parent2 = contentView.getParent();
        int i3 = 0;
        int i16 = 0;
        while (parent2 != null) {
            if (!(parent2 instanceof ViewGroup)) {
                w.f(this.f143529a, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
                return null;
            }
            i16 = (int) (i16 + contentView.getX());
            i3 = (int) (i3 + contentView.getY());
            if (parent2 == viewGroup) {
                w.a(this.f143529a, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", Integer.valueOf(i16), Integer.valueOf(i3));
                return new Point(i16, i3);
            }
            contentView = parent2;
            parent2 = contentView.getParent();
        }
        return null;
    }

    public final void a(int i3, int i16, int i17, int i18) {
        boolean z16 = true;
        if (!((-1 == i3 || -1 == i16) ? false : true) ? i17 < i18 : i3 < i16) {
            z16 = false;
        }
        if (z16) {
            this.f143553y = com.tencent.luggage.wxa.il.f.T;
            this.f143554z = com.tencent.luggage.wxa.il.f.U;
        } else {
            this.f143553y = com.tencent.luggage.wxa.il.f.f130654a0;
            this.f143554z = com.tencent.luggage.wxa.il.f.f130655b0;
        }
        KeyEvent.Callback callback = this.f143532d;
        if (callback instanceof g) {
            ((g) callback).a(z16 ? com.tencent.luggage.wxa.ag.f.LANDSCAPE : com.tencent.luggage.wxa.ag.f.PORTRAIT);
        }
    }

    public final void a(int i3, int i16, int i17, int i18, int i19, int i26) {
        int i27;
        int i28;
        int i29 = i3;
        int i36 = i16;
        boolean z16 = (-1 == i29 || -1 == i36) ? false : true;
        if (!z16 ? i17 < i18 : i29 < i36) {
            this.f143553y = com.tencent.luggage.wxa.il.f.T;
            this.f143554z = com.tencent.luggage.wxa.il.f.U;
            i27 = com.tencent.luggage.wxa.il.f.V;
            i28 = com.tencent.luggage.wxa.il.f.W;
        } else {
            this.f143553y = com.tencent.luggage.wxa.il.f.f130654a0;
            this.f143554z = com.tencent.luggage.wxa.il.f.f130655b0;
            i27 = com.tencent.luggage.wxa.il.f.f130656c0;
            i28 = com.tencent.luggage.wxa.il.f.f130657d0;
        }
        int stablePosX = this.f143531c.getStablePosX();
        int stablePosY = this.f143531c.getStablePosY();
        w.d(this.f143529a, "calculateStablePipContainerSizeAndPosition, stablePosX: %d, stablePosY: %d", Integer.valueOf(stablePosX), Integer.valueOf(stablePosY));
        this.A = Math.min(Math.max(0, stablePosX), this.f143538j - this.f143553y);
        this.B = Math.min(Math.max(0, stablePosY), this.f143539k - this.f143554z);
        w.d(this.f143529a, "calculateStablePipContainerSizeAndPosition, mEndPipContainerPosX: %d, mEndPipContainerPosY: %d", Integer.valueOf(this.A), Integer.valueOf(this.B));
        if (!z16) {
            i29 = i17;
            i36 = i18;
        }
        if ((i27 + 0.0f) / i29 >= (i28 + 0.0f) / i36) {
            this.C = i27;
            this.D = (int) Math.ceil(r10 * r2);
        } else {
            this.C = (int) Math.ceil(r12 * r1);
            this.D = i28;
        }
        this.f143545q = i17;
        this.f143546r = i18;
        w.a(this.f143529a, "calculateStablePipContainerSize, mStartVideoContainerWidth: %d, mStartVideoContainerHeight: %d", Integer.valueOf(i17), Integer.valueOf(this.f143546r));
        this.f143542n = (int) (((this.f143554z + 0.0f) / this.D) * this.f143546r);
        int i37 = (int) (((this.f143553y + 0.0f) / this.C) * this.f143545q);
        this.f143541m = i37;
        w.a(this.f143529a, "calculateStablePipContainerSize, mStartPipContainerWidth: %d, mStartPipContainerHeight: %d", Integer.valueOf(i37), Integer.valueOf(this.f143542n));
        this.C = i27;
        this.D = i28;
        float f16 = (this.f143541m + 0.0f) / this.f143553y;
        float f17 = (this.f143542n + 0.0f) / this.f143554z;
        w.a(this.f143529a, "calculateStablePipContainerSize, start2EndWidthRatio: %f, start2EndHeightRatio: %f", Float.valueOf(f16), Float.valueOf(f17));
        int min = Math.min(Math.max(i19, -this.f143541m), this.f143538j);
        int min2 = Math.min(Math.max(i26, -this.f143542n), this.f143539k);
        w.a(this.f143529a, "calculateStablePipContainerSize, originVideoPosX: %d, originVideoPosY: %d", Integer.valueOf(min), Integer.valueOf(min2));
        if (z16) {
            this.f143543o = min - ((int) ((f16 * (this.f143553y - i27)) / 2.0f));
            this.f143544p = min2 - ((int) (((this.f143554z - i28) * f17) / 2.0f));
        } else {
            int i38 = this.f143545q;
            this.f143543o = (min + ((i17 - i38) / 2)) - ((this.f143541m - i38) / 2);
            int i39 = this.f143546r;
            this.f143544p = (min2 + ((i18 - i39) / 2)) - ((this.f143542n - i39) / 2);
        }
        this.f143547s = (int) Math.ceil((this.f143541m - this.f143545q) * 0.5f);
        this.f143548t = (int) Math.ceil((this.f143542n - this.f143546r) * 0.4f);
        this.f143549u = (int) Math.ceil((this.f143542n - this.f143546r) * 0.6f);
        this.f143550v = (int) (this.H * f17);
        this.f143551w = (int) (this.I * f17);
        this.f143552x = (int) (f17 * this.J);
    }

    public final void a(float f16) {
        float f17 = f16 / 100.0f;
        this.K = this.f143541m + ((int) ((this.f143553y - r0) * f17));
        this.L = this.f143542n + ((int) ((this.f143554z - r1) * f17));
        this.M = this.f143543o + ((int) ((this.A - r1) * f17));
        this.N = this.f143544p + ((int) ((this.B - r1) * f17));
        this.O = this.f143545q + ((int) ((this.C - r1) * f17));
        this.P = this.f143546r + ((int) ((this.D - r2) * f17));
        this.Q = (int) Math.ceil((r0 - r1) * 0.5f);
        this.R = (int) Math.ceil((this.L - this.P) * 0.4f);
        this.S = (int) Math.ceil((this.L - this.P) * 0.6f);
        this.T = this.f143550v + ((int) ((this.H - r0) * f17));
        this.U = this.f143551w + ((int) ((this.I - r0) * f17));
        this.V = this.f143552x + ((int) (f17 * (this.J - r0)));
    }

    public final void a(float f16, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38) {
        float f17 = f16 / 100.0f;
        int i39 = (int) (i27 * f17);
        int i46 = (int) (i28 * f17);
        int i47 = (int) (i29 * f17);
        int i48 = (int) (i36 * f17);
        int i49 = (int) (i37 * f17);
        int i56 = (int) (f17 * i38);
        ViewGroup.LayoutParams layoutParams = this.f143531c.getLayoutParams();
        layoutParams.width = (i39 * 2) + i19;
        layoutParams.height = i26 + i46 + i47;
        this.f143531c.setLayoutParams(layoutParams);
        this.f143531c.setX(i17 + ((i3 - r7) / 2));
        this.f143531c.setY(i18 + ((i16 - r8) / 2));
        ViewGroup.LayoutParams layoutParams2 = this.f143532d.getLayoutParams();
        layoutParams2.width = i19;
        layoutParams2.height = i26;
        this.f143532d.setLayoutParams(layoutParams2);
        this.f143531c.a(i19, i39, i46, i47, i48, i49, i56);
    }
}
