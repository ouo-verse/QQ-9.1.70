package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.current.SessionWrap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {
    private boolean A;
    private SessionWrap B;
    private String C;
    private com.tencent.mobileqq.activity.richmedia.i D;
    private Float E;
    private Integer F;

    /* renamed from: a, reason: collision with root package name */
    private boolean f61942a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f61943b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f61944c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f61945d;

    /* renamed from: e, reason: collision with root package name */
    private int f61946e;

    /* renamed from: f, reason: collision with root package name */
    private int f61947f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f61948g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f61949h;

    /* renamed from: i, reason: collision with root package name */
    private int f61950i;

    /* renamed from: j, reason: collision with root package name */
    private int f61951j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f61952k;

    /* renamed from: l, reason: collision with root package name */
    private int f61953l;

    /* renamed from: m, reason: collision with root package name */
    private final int f61954m;

    /* renamed from: n, reason: collision with root package name */
    private int f61955n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f61956o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f61957p;

    /* renamed from: q, reason: collision with root package name */
    private int f61958q;

    /* renamed from: r, reason: collision with root package name */
    private int f61959r;

    /* renamed from: s, reason: collision with root package name */
    private int f61960s;

    /* renamed from: t, reason: collision with root package name */
    private int f61961t;

    /* renamed from: u, reason: collision with root package name */
    private int f61962u;

    /* renamed from: v, reason: collision with root package name */
    private int f61963v;

    /* renamed from: w, reason: collision with root package name */
    private AECaptureMode f61964w;

    /* renamed from: x, reason: collision with root package name */
    private AECaptureMode[] f61965x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f61966y;

    /* renamed from: z, reason: collision with root package name */
    private c f61967z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0530a implements c {
        C0530a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b {
        private boolean A;
        private boolean B;
        private boolean C;
        private boolean D;
        private c E;
        private int F;

        /* renamed from: c, reason: collision with root package name */
        public boolean f61971c;

        /* renamed from: f, reason: collision with root package name */
        private Float f61974f;

        /* renamed from: g, reason: collision with root package name */
        private Integer f61975g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f61976h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f61977i;

        /* renamed from: k, reason: collision with root package name */
        private boolean f61979k;

        /* renamed from: l, reason: collision with root package name */
        private com.tencent.mobileqq.activity.richmedia.i f61980l;

        /* renamed from: u, reason: collision with root package name */
        private AECaptureMode f61989u;

        /* renamed from: v, reason: collision with root package name */
        private AECaptureMode[] f61990v;

        /* renamed from: w, reason: collision with root package name */
        private boolean f61991w;

        /* renamed from: x, reason: collision with root package name */
        private SessionWrap f61992x;

        /* renamed from: y, reason: collision with root package name */
        private String f61993y;

        /* renamed from: z, reason: collision with root package name */
        private boolean f61994z;

        /* renamed from: a, reason: collision with root package name */
        public int f61969a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f61970b = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f61973e = 14;

        /* renamed from: d, reason: collision with root package name */
        public int f61972d = -1;

        /* renamed from: t, reason: collision with root package name */
        private int f61988t = 120;

        /* renamed from: m, reason: collision with root package name */
        private boolean f61981m = true;

        /* renamed from: n, reason: collision with root package name */
        private int f61982n = -1;

        /* renamed from: j, reason: collision with root package name */
        private int f61978j = -1;

        /* renamed from: o, reason: collision with root package name */
        private int f61983o = 2;

        /* renamed from: p, reason: collision with root package name */
        private int f61984p = AEVideoStoryTopBarViewModel.Ratio.R_1_1.code;

        /* renamed from: q, reason: collision with root package name */
        private int f61985q = js.a.f410904d.b();

        /* renamed from: r, reason: collision with root package name */
        private int f61986r = 0;

        /* renamed from: s, reason: collision with root package name */
        private int f61987s = 200;

        public b() {
            AECaptureMode aECaptureMode = AECaptureMode.NORMAL;
            this.f61989u = aECaptureMode;
            this.f61990v = new AECaptureMode[]{aECaptureMode, AECaptureMode.PLAY, AECaptureMode.GIF};
            this.f61991w = false;
            this.f61992x = null;
            this.f61993y = null;
            this.f61979k = false;
            this.f61980l = null;
            this.f61974f = null;
            this.f61975g = null;
            this.f61976h = true;
            this.f61977i = true;
            this.F = -1;
            this.C = true;
            this.f61994z = true;
            this.A = true;
            this.B = true;
            this.D = true;
            this.f61971c = true;
        }

        public a C() {
            return new a(this);
        }

        public b D(String str) {
            this.f61993y = str;
            return this;
        }

        public b E(boolean z16) {
            this.f61976h = z16;
            return this;
        }

        public b F(int i3) {
            this.f61973e = i3;
            return this;
        }

        public b G(int i3) {
            this.F = i3;
            return this;
        }

        public b H(int i3) {
            this.f61987s = i3;
            return this;
        }

        public b I(int i3) {
            this.f61970b = i3;
            return this;
        }

        public b J(int i3) {
            this.f61983o = i3;
            return this;
        }

        public b K(int i3) {
            this.f61986r = i3;
            return this;
        }

        public b L(boolean z16) {
            this.f61971c = z16;
            return this;
        }

        public b M(boolean z16) {
            this.C = z16;
            return this;
        }

        public b N(AECaptureMode[] aECaptureModeArr) {
            this.f61990v = aECaptureModeArr;
            return this;
        }

        public b O(boolean z16) {
            this.A = z16;
            return this;
        }

        public b P(boolean z16) {
            this.f61994z = z16;
            return this;
        }

        public b Q(boolean z16) {
            this.B = z16;
            return this;
        }

        public b R(int i3) {
            this.f61988t = i3;
            return this;
        }

        public b S(int i3) {
            this.f61985q = i3;
            return this;
        }

        public b T(boolean z16) {
            this.f61991w = z16;
            return this;
        }

        public b U(AECaptureMode aECaptureMode) {
            this.f61989u = aECaptureMode;
            return this;
        }

        public b V(int i3) {
            this.f61969a = i3;
            return this;
        }

        public b W(int i3) {
            this.f61982n = i3;
            return this;
        }

        public b X(int i3) {
            this.f61984p = i3;
            return this;
        }

        public b Y(int i3) {
            this.f61972d = i3;
            return this;
        }

        public b Z(SessionWrap sessionWrap) {
            this.f61992x = sessionWrap;
            return this;
        }

        public b a0(boolean z16) {
            this.D = z16;
            return this;
        }

        public b b0(boolean z16) {
            this.f61977i = z16;
            return this;
        }

        public b c0(int i3) {
            this.f61978j = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
    }

    a(b bVar) {
        this.f61950i = -1;
        this.f61952k = bVar.f61981m;
        this.f61953l = bVar.f61982n;
        this.f61958q = bVar.f61983o;
        this.f61959r = bVar.f61984p;
        this.f61960s = bVar.f61985q;
        this.f61962u = bVar.f61986r;
        this.f61965x = bVar.f61990v;
        this.f61964w = bVar.f61989u;
        this.f61963v = bVar.f61987s;
        this.A = bVar.f61991w;
        this.B = bVar.f61992x;
        this.C = bVar.f61993y;
        this.f61966y = bVar.f61979k;
        this.D = bVar.f61980l;
        this.E = bVar.f61974f;
        this.F = bVar.f61975g;
        this.f61956o = bVar.f61976h;
        this.f61957p = bVar.f61977i;
        this.f61955n = bVar.f61978j;
        this.f61961t = bVar.f61973e;
        this.f61954m = bVar.f61988t;
        this.f61951j = bVar.F;
        this.f61943b = bVar.C;
        this.f61945d = bVar.f61994z;
        this.f61948g = bVar.A;
        this.f61942a = bVar.D;
        this.f61949h = bVar.B;
        this.f61947f = bVar.f61970b;
        this.f61946e = bVar.f61972d;
        this.f61950i = bVar.f61969a;
        this.f61944c = bVar.f61971c;
        if (bVar.E == null) {
            this.f61967z = D();
        } else {
            this.f61967z = bVar.E;
        }
    }

    private c D() {
        return new C0530a();
    }

    public boolean A() {
        return this.f61949h;
    }

    public boolean B() {
        return this.f61942a;
    }

    public boolean C() {
        return this.f61957p;
    }

    public String a() {
        return this.C;
    }

    public Integer b() {
        if (this.F == null) {
            int a16 = com.tencent.aelight.camera.ae.flashshow.util.a.a();
            int i3 = this.f61958q;
            if (i3 == 0 && a16 == 0) {
                a16 = 1;
            }
            if (i3 == 0) {
                i3 = a16;
            }
            this.F = Integer.valueOf(com.tencent.aelight.camera.ae.util.q.c().a(i3) * 1000);
        }
        return this.F;
    }

    public int c() {
        return this.f61961t;
    }

    public int d() {
        return this.f61951j;
    }

    public int e() {
        return this.f61963v;
    }

    public int f() {
        return this.f61947f;
    }

    public int g() {
        return this.f61958q;
    }

    public Integer h() {
        return Integer.valueOf(this.f61962u);
    }

    public AECaptureMode[] i() {
        return this.f61965x;
    }

    public int j() {
        return this.f61954m;
    }

    public int k() {
        return this.f61960s;
    }

    public AECaptureMode l() {
        return this.f61964w;
    }

    public int m() {
        return this.f61950i;
    }

    public int n() {
        return this.f61953l;
    }

    public com.tencent.mobileqq.activity.richmedia.i o() {
        if (this.D == null) {
            int i3 = this.f61958q;
            if (i3 == 0) {
                i3 = com.tencent.aelight.camera.ae.flashshow.util.a.a();
            }
            this.D = com.tencent.aelight.camera.ae.util.q.c().b(i3);
        }
        return this.D;
    }

    public int p() {
        return this.f61959r;
    }

    public SessionWrap q() {
        return this.B;
    }

    public int r() {
        return this.f61955n;
    }

    public Float s() {
        if (this.E == null) {
            int i3 = this.f61958q;
            if (i3 == 0) {
                i3 = com.tencent.aelight.camera.ae.flashshow.util.a.a();
            }
            this.E = Float.valueOf(com.tencent.aelight.camera.ae.util.q.c().e(i3));
        }
        return this.E;
    }

    public boolean t() {
        return this.A;
    }

    public boolean u() {
        return this.f61956o;
    }

    public boolean v() {
        return this.f61944c;
    }

    public boolean w() {
        return this.f61943b;
    }

    public boolean x() {
        return this.f61966y;
    }

    public boolean y() {
        return this.f61948g;
    }

    public boolean z() {
        return this.f61945d;
    }
}
