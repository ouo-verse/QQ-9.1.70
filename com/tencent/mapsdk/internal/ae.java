package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.aa;
import com.tencent.mapsdk.internal.tk;
import com.tencent.mapsdk.internal.v;
import com.tencent.tencentmap.mapsdk.maps.MapParamConstants;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ae implements fs, iu, jq, op, pa {
    private static final int P = 20;
    private static final int Q = 0;
    private static final int R = 1;
    private static final int S = 2;
    private static final int T = 3;
    private static final int U = 4;

    /* renamed from: a, reason: collision with root package name */
    public static final int f147715a = 12;

    /* renamed from: b, reason: collision with root package name */
    public static final int f147716b = 11;

    /* renamed from: c, reason: collision with root package name */
    public static final int f147717c = 10;

    /* renamed from: d, reason: collision with root package name */
    public static final int f147718d = 18;

    /* renamed from: e, reason: collision with root package name */
    public static final int f147719e = 13;

    /* renamed from: f, reason: collision with root package name */
    public static final int f147720f = 15;

    /* renamed from: g, reason: collision with root package name */
    public static final int f147721g = 15;

    /* renamed from: h, reason: collision with root package name */
    public static final int f147722h = 17;

    /* renamed from: i, reason: collision with root package name */
    public static final int f147723i = 18;

    /* renamed from: j, reason: collision with root package name */
    public static final int f147724j = 16;

    /* renamed from: k, reason: collision with root package name */
    public static final int f147725k = 18;

    /* renamed from: l, reason: collision with root package name */
    public static final int f147726l = 12;

    /* renamed from: m, reason: collision with root package name */
    public static int f147727m = 116307503;

    /* renamed from: n, reason: collision with root package name */
    public static int f147728n = 39984186;
    public v A;
    public fa B;
    public Rect C;
    public boolean N;
    private List<ph> V;
    private List<fo> W;
    private List<fs> X;
    private final List<ft> Y;
    private List<fq> Z;

    /* renamed from: ab, reason: collision with root package name */
    private Rect f147730ab;

    /* renamed from: ac, reason: collision with root package name */
    private Runnable f147731ac;

    /* renamed from: o, reason: collision with root package name */
    public aa f147732o;

    /* renamed from: p, reason: collision with root package name */
    public qj f147733p;

    /* renamed from: q, reason: collision with root package name */
    public List<fl> f147734q;

    /* renamed from: r, reason: collision with root package name */
    public List<fg> f147735r;

    /* renamed from: s, reason: collision with root package name */
    public List<fi> f147736s;

    /* renamed from: u, reason: collision with root package name */
    public List<fn> f147738u;

    /* renamed from: v, reason: collision with root package name */
    public List<bc> f147739v;

    /* renamed from: x, reason: collision with root package name */
    public List<fm> f147741x;

    /* renamed from: y, reason: collision with root package name */
    public bb f147742y;

    /* renamed from: z, reason: collision with root package name */
    public bf f147743z;

    /* renamed from: t, reason: collision with root package name */
    public final byte[] f147737t = new byte[0];

    /* renamed from: w, reason: collision with root package name */
    public final byte[] f147740w = new byte[0];

    /* renamed from: aa, reason: collision with root package name */
    private Stack<v> f147729aa = new Stack<>();
    public a D = null;
    public float E = 0.5f;
    public float F = 0.5f;
    public boolean G = false;
    public int H = 0;
    public int I = 0;
    public int J = 0;
    public int K = 0;
    public boolean L = false;
    public boolean M = false;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ae$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements ph {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f147744a;

        public AnonymousClass1(boolean z16) {
            this.f147744a = z16;
        }

        @Override // com.tencent.mapsdk.internal.ph
        public final void a() {
            PointF a16 = ae.this.a();
            ae.this.a(a16.x, a16.y, this.f147744a);
            ae.this.b(this);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ae$3, reason: invalid class name */
    /* loaded from: classes9.dex */
    final class AnonymousClass3 extends jn {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f147754a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f147755b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f147756c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ double f147757d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ double f147758e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ double f147759f = 0.0d;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ double f147760g = 0.0d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(double[] dArr, boolean z16, long j3, float f16, float f17, double d16, double d17) {
            super(102, dArr, z16);
            this.f147754a = j3;
            this.f147755b = f16;
            this.f147756c = f17;
            this.f147757d = d16;
            this.f147758e = d17;
        }

        @Override // com.tencent.mapsdk.internal.jn
        public final boolean a() {
            boolean z16;
            boolean z17;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f147754a;
            double a16 = jk.a(elapsedRealtime, this.f147755b);
            double a17 = jk.a(elapsedRealtime, this.f147756c);
            double[] dArr = this.A;
            dArr[2] = dArr[2] + Math.abs(a16);
            double[] dArr2 = this.A;
            dArr2[3] = dArr2[3] + Math.abs(a17);
            if (this.A[2] >= Math.abs(this.f147757d)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.A[3] >= Math.abs(this.f147758e)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16) {
                this.A[0] = this.f147759f - ae.this.h();
            } else {
                this.A[0] = a16;
            }
            if (z17) {
                this.A[1] = this.f147760g - ae.this.i();
            } else {
                this.A[1] = a17;
            }
            if (z16 && z17) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ae$4, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ae.this.a(0.0d, 0.0d, false);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ae$5, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ double f147763a;

        public AnonymousClass5(double d16) {
            this.f147763a = d16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ae.this.a((360.0d - this.f147763a) % 360.0d, MapParamConstants.MAX_SKEW_ANGLE, false);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ae$7, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GeoPoint f147767a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f147768b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Runnable f147769c;

        public AnonymousClass7(GeoPoint geoPoint, float f16, Runnable runnable) {
            this.f147767a = geoPoint;
            this.f147768b = f16;
            this.f147769c = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ae.this.b(this.f147767a, this.f147768b, this.f147769c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(jn jnVar);
    }

    public ae(bf bfVar) {
        this.f147743z = bfVar;
        this.f147742y = (bb) bfVar.b();
        this.A = bfVar.f();
        this.B = bfVar.d();
        this.C = bfVar.h();
        aa aaVar = new aa(this);
        this.f147732o = aaVar;
        aaVar.f147676i = this;
        a(aaVar);
        this.W = new CopyOnWriteArrayList();
        this.f147738u = new CopyOnWriteArrayList();
        this.f147734q = new CopyOnWriteArrayList();
        this.f147735r = new CopyOnWriteArrayList();
        this.V = new CopyOnWriteArrayList();
        this.Y = new CopyOnWriteArrayList();
        this.f147741x = new CopyOnWriteArrayList();
        this.Z = new CopyOnWriteArrayList();
        this.X = new CopyOnWriteArrayList();
        a(es.f148293a);
    }

    private void A() {
        aa aaVar = this.f147732o;
        if (aaVar != null) {
            aaVar.a();
        }
    }

    private void B() {
        aa.a aVar;
        aa aaVar = this.f147732o;
        if (aaVar != null && (aVar = aaVar.f147671d) != null) {
            aVar.destroy();
        }
    }

    private aa C() {
        return this.f147732o;
    }

    private void D() {
        for (fm fmVar : this.f147741x) {
        }
    }

    private void E() {
        LogUtil.b("skew notifySkew");
        for (fq fqVar : this.Z) {
        }
    }

    private void F() {
        GeoPoint geoPoint = new GeoPoint(f147728n, f147727m);
        v vVar = this.A;
        Rect h16 = this.f147743z.h();
        int latitudeE6 = geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint.getLongitudeE6();
        vVar.f151265n = h16;
        vVar.f151254c = GeometryConstants.BOUNDARY_WORLD;
        vVar.c(13);
        vVar.a(0);
        vVar.a(latitudeE6, longitudeE6, false);
        this.f147743z.g().b(this.G);
    }

    private float G() {
        return this.A.f151253b.f151290p;
    }

    private int H() {
        return this.A.f151253b.f151291q;
    }

    private GeoPoint I() {
        return this.A.f151264m;
    }

    private float J() {
        return this.A.f151253b.a();
    }

    private void K() {
        this.A.a(0.0f);
        this.A.b(0.0f);
        D();
        E();
        c();
    }

    private void L() {
        o();
        a(h(), MapParamConstants.MAX_SKEW_ANGLE, true);
    }

    private void M() {
        o();
        a(h(), MapParamConstants.MAX_SKEW_ANGLE, true);
    }

    private boolean N() {
        qj qjVar = this.f147733p;
        if (qjVar == null) {
            return false;
        }
        boolean z16 = qjVar.f149829c;
        qjVar.f149829c = false;
        return z16;
    }

    private void O() {
        o();
        j();
    }

    private void P() {
        o();
        this.f147732o.e();
        a(0.0d, 0.0d);
    }

    private void Q() {
        o();
        this.f147732o.e();
        a(h(), MapParamConstants.MAX_SKEW_ANGLE);
    }

    private boolean R() {
        v.a aVar = this.A.f151253b;
        if (aVar.f151291q > aVar.f151288n) {
            return true;
        }
        return false;
    }

    private void S() {
        b(0);
    }

    private void T() {
        for (fl flVar : this.f147734q) {
        }
        c();
    }

    private void U() {
        for (fg fgVar : this.f147735r) {
        }
        T();
    }

    private void V() {
        for (fs fsVar : this.X) {
            if (fsVar != null) {
                try {
                    fsVar.u();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    private Rect W() {
        GeoPoint s16 = s();
        GeoPoint t16 = t();
        return new Rect(s16.getLongitudeE6(), s16.getLatitudeE6(), t16.getLongitudeE6(), t16.getLatitudeE6());
    }

    private void X() {
        this.f147732o.e();
    }

    private boolean Y() {
        return this.f147732o.f();
    }

    private boolean Z() {
        return this.f147732o.g();
    }

    private v aa() {
        return this.A;
    }

    private void j(double d16) {
        a((360.0d - d16) % 360.0d, i(), true);
    }

    private void k(double d16) {
        this.f147732o.e();
        b(new jn(100, new double[]{d16}));
    }

    private void l(double d16) {
        a((360.0d - d16) % 360.0d, MapParamConstants.MAX_SKEW_ANGLE, true);
    }

    private static double m(double d16) {
        double d17 = d16 % 360.0d;
        if (d17 > 180.0d) {
            return d17 - 360.0d;
        }
        return d17 < -180.0d ? d17 + 360.0d : d17;
    }

    private void v() {
        this.N = true;
    }

    private boolean w() {
        return this.N;
    }

    private boolean x() {
        Rect rect = this.C;
        if (rect != null && rect.width() > 0 && this.C.height() > 0) {
            return true;
        }
        return false;
    }

    private aa y() {
        aa aaVar = this.f147732o;
        aa.a aVar = aaVar.f147671d;
        if (aVar != null) {
            aVar.destroy();
        }
        aa.a aVar2 = new aa.a(aaVar);
        aaVar.f147671d = aVar2;
        aVar2.start();
        return this.f147732o;
    }

    private void z() {
        aa aaVar = this.f147732o;
        if (aaVar != null) {
            aaVar.b();
        }
    }

    public final Rect b() {
        return new Rect(this.H, this.I, this.J, this.K);
    }

    public final void c() {
        List<bc> list = this.f147739v;
        if (list == null) {
            return;
        }
        for (bc bcVar : list) {
            if (bcVar != null) {
                try {
                    bcVar.a(this.A);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.op
    public final void d() {
    }

    public final void e() {
        try {
            v vVar = (v) this.A.clone();
            LogUtil.b("mapParam stack saveMapParam:" + vVar.toString());
            this.f147729aa.push(vVar);
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
        }
    }

    public final void f() {
        try {
            v pop = this.f147729aa.pop();
            v.a aVar = pop.f151253b;
            int i3 = aVar.f151291q;
            v.a aVar2 = this.A.f151253b;
            if (i3 != aVar2.f151291q) {
                c(gh.f148492c);
            } else if (aVar.f151290p != aVar2.f151290p) {
                c(gh.f148491b);
            }
            if (pop.f151267p.s() != this.A.f151267p.s()) {
                pop.f151267p.s();
                D();
            }
            if (pop.f151267p.r() != this.A.f151267p.r()) {
                pop.f151267p.r();
                E();
            }
            v vVar = this.A;
            vVar.f151252a = pop.f151252a;
            v.a aVar3 = vVar.f151253b;
            v.a aVar4 = pop.f151253b;
            aVar3.f151286l = aVar4.f151286l;
            aVar3.f151287m = aVar4.f151287m;
            aVar3.f151288n = aVar4.f151288n;
            aVar3.f151289o = aVar4.f151289o;
            aVar3.f151290p = aVar4.f151290p;
            aVar3.f151291q = aVar4.f151291q;
            vVar.f151254c.set(pop.f151254c);
            vVar.f151255d = pop.f151255d;
            vVar.f151256e = pop.f151256e;
            vVar.f151257f = pop.f151257f;
            vVar.f151258g = pop.f151258g;
            vVar.f151259h = pop.f151259h;
            vVar.f151260i = pop.f151260i;
            vVar.f151261j = pop.f151261j;
            vVar.f151262k = pop.f151262k;
            vVar.f151263l = pop.f151263l;
            vVar.f151264m.setGeoPoint(pop.f151264m);
            fw fwVar = vVar.f151268q;
            fw fwVar2 = pop.f151268q;
            fwVar.a(fwVar2.f148383a, fwVar2.f148384b);
            vVar.f151265n = pop.f151265n;
            c();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public final v g() {
        try {
            return (v) this.A.clone();
        } catch (CloneNotSupportedException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public final float h() {
        return this.A.f151267p.s();
    }

    public final float i() {
        return this.A.f151267p.r();
    }

    public final void n() {
        b(this.f147730ab);
        for (ph phVar : this.V) {
            if (phVar != null) {
                try {
                    phVar.a();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public final void o() {
        if (this.f147736s == null) {
            return;
        }
        k();
        for (fi fiVar : this.f147736s) {
        }
    }

    public final void p() {
        for (fn fnVar : this.f147738u) {
        }
    }

    public final Rect q() {
        fw fwVar = new fw(this.f147743z.h().width(), this.f147743z.h().height());
        GeoPoint a16 = this.B.a(fwVar);
        fwVar.a(0.0d, this.f147743z.h().height());
        GeoPoint a17 = this.B.a(fwVar);
        fwVar.a(this.f147743z.h().width(), 0.0d);
        GeoPoint a18 = this.B.a(fwVar);
        fwVar.a(0.0d, 0.0d);
        GeoPoint a19 = this.B.a(fwVar);
        return new Rect(Math.min(Math.min(Math.min(a19.getLongitudeE6(), a16.getLongitudeE6()), a17.getLongitudeE6()), a18.getLongitudeE6()), Math.min(Math.min(Math.min(a19.getLatitudeE6(), a16.getLatitudeE6()), a17.getLatitudeE6()), a18.getLatitudeE6()), Math.max(Math.max(Math.max(a19.getLongitudeE6(), a16.getLongitudeE6()), a17.getLongitudeE6()), a18.getLongitudeE6()), Math.max(Math.max(Math.max(a19.getLatitudeE6(), a16.getLatitudeE6()), a17.getLatitudeE6()), a18.getLatitudeE6()));
    }

    public final Rect r() {
        if (this.B == null) {
            return null;
        }
        fw fwVar = new fw(this.H, this.I);
        GeoPoint a16 = this.B.a(fwVar);
        fwVar.a(this.f147743z.h().width() - this.J, this.f147743z.h().height() - this.K);
        GeoPoint a17 = this.B.a(fwVar);
        return new Rect(Math.min(a16.getLongitudeE6(), a17.getLongitudeE6()), Math.min(a16.getLatitudeE6(), a17.getLatitudeE6()), Math.max(a16.getLongitudeE6(), a17.getLongitudeE6()), Math.max(a16.getLatitudeE6(), a17.getLatitudeE6()));
    }

    public final GeoPoint s() {
        return this.B.a(new fw(0.0d, 0.0d));
    }

    public final GeoPoint t() {
        return this.B.a(new fw(this.f147743z.h().width(), this.f147743z.h().height()));
    }

    @Override // com.tencent.mapsdk.internal.fs
    public final void u() {
        for (fs fsVar : this.X) {
            if (fsVar != null) {
                try {
                    fsVar.u();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    private void b(bc bcVar) {
        if (this.f147739v == null) {
            return;
        }
        synchronized (this.f147740w) {
            this.f147739v.remove(bcVar);
        }
    }

    private void d(double d16) {
        if (d16 == 0.0d) {
            return;
        }
        v vVar = this.A;
        vVar.b(vVar.f151267p.r() + ((float) d16));
        c();
        E();
    }

    public final void j() {
        this.f147732o.e();
        a(0.0d, 0.0d, true);
    }

    public final boolean l() {
        v.a aVar = this.A.f151253b;
        return aVar.f151291q < aVar.f151289o;
    }

    public final int m() {
        v vVar = this.A;
        tk tkVar = vVar.f151267p;
        if (tkVar == null) {
            return vVar.f151252a;
        }
        return tkVar.u();
    }

    private void g(double d16) {
        a((float) d16);
    }

    private void h(double d16) {
        this.f147732o.e();
        b(new jn(102, new double[]{0.0d, d16}));
    }

    private void i(double d16) {
        this.f147732o.e();
        b(new jn(102, new double[]{d16, 0.0d}));
    }

    public final boolean k() {
        return ((double) Math.abs(i())) > 1.0E-6d || Math.abs(h()) > 1.0f;
    }

    private int a(int i3, int i16, int i17, int i18, boolean z16) {
        this.H = i3;
        this.I = i16;
        this.J = i17;
        this.K = i18;
        Rect rect = this.C;
        if (rect != null && rect.width() > 0 && this.C.height() > 0) {
            if (i3 + i17 > this.C.width() || i16 + i18 > this.C.height()) {
                return -1;
            }
            PointF a16 = a();
            a(a16.x, a16.y, z16);
            return 0;
        }
        a(new AnonymousClass1(z16));
        bf bfVar = this.f147743z;
        if (!(bfVar instanceof ne)) {
            return -2;
        }
        Context context = ((ne) bfVar).getContext();
        return (i3 + i17 > ht.b(context) || i16 + i18 > ht.c(context)) ? -1 : 0;
    }

    private void c(boolean z16) {
        this.G = z16;
        this.f147743z.g().b(this.G);
    }

    private void e(double d16) {
        if (d16 == 0.0d) {
            return;
        }
        v vVar = this.A;
        vVar.a(vVar.f151267p.s() + ((float) d16));
        c();
        D();
    }

    private void b(fm fmVar) {
        synchronized (this.f147741x) {
            this.f147741x.remove(fmVar);
        }
    }

    private void c(float f16) {
        a(f16);
    }

    private void d(jn jnVar) {
        int i3 = jnVar.f148935z;
        if (i3 == 2) {
            bb bbVar = this.f147742y;
            if (bbVar == null || bbVar.getMapRenderView() == null) {
                return;
            }
            this.f147742y.getMapRenderView().d();
            return;
        }
        if (i3 == 3) {
            double[] dArr = jnVar.A;
            b(dArr[0], dArr[1]);
            return;
        }
        if (i3 == 4) {
            double[] dArr2 = jnVar.A;
            a((int) dArr2[0], (int) dArr2[1], dArr2.length > 2 ? (int) dArr2[2] : 1);
            return;
        }
        if (i3 == 6) {
            Runnable runnable = jnVar.E;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (i3 == 120) {
            a((float) jnVar.A[0]);
            double[] dArr3 = jnVar.A;
            a((int) dArr3[1], (int) dArr3[2], 1);
            return;
        }
        if (i3 != 10000) {
            switch (i3) {
                case 100:
                    f(jnVar.A[0]);
                    return;
                case 101:
                    int width = this.f147743z.h().width();
                    int height = this.f147743z.h().height();
                    int i16 = width / 2;
                    int i17 = height / 2;
                    v.c cVar = this.A.f151269r;
                    if (cVar != null) {
                        i16 = (int) (i16 + (cVar.f151295a * width));
                        i17 = (int) (i17 + (cVar.f151296b * height));
                    }
                    double d16 = i16;
                    double[] dArr4 = jnVar.A;
                    double d17 = d16 - dArr4[1];
                    double d18 = i17;
                    double d19 = d18 - dArr4[2];
                    double d26 = dArr4[3] - d16;
                    double d27 = dArr4[4] - d18;
                    b(d17, d19);
                    f(jnVar.A[0]);
                    b(d26, d27);
                    return;
                case 102:
                    e(jnVar.A[0]);
                    d(jnVar.A[1]);
                    return;
                case 103:
                    int width2 = this.f147743z.h().width() / 2;
                    int height2 = this.f147743z.h().height() / 2;
                    double d28 = width2;
                    double[] dArr5 = jnVar.A;
                    double d29 = height2;
                    b(d28 - dArr5[1], d29 - dArr5[2]);
                    e(jnVar.A[0]);
                    double[] dArr6 = jnVar.A;
                    b(dArr6[3] - d28, dArr6[4] - d29);
                    return;
                case 104:
                    this.A.a(0.0f);
                    this.A.b(0.0f);
                    D();
                    E();
                    c();
                    return;
                default:
                    switch (i3) {
                        case 108:
                            a((float) jnVar.A[0]);
                            return;
                        case 109:
                            b(jnVar.A[0]);
                            return;
                        case 110:
                            a(jnVar.A[0]);
                            return;
                        default:
                            return;
                    }
            }
        }
        a aVar = this.D;
        if (aVar != null) {
            aVar.a(jnVar);
        }
    }

    private void c(double d16, double d17) {
        aa aaVar = this.f147732o;
        synchronized (aaVar.f147670c) {
            while (!aaVar.f147669b.isEmpty()) {
                ArrayList<jn> arrayList = aaVar.f147669b;
                if (arrayList.get(arrayList.size() - 1).f148935z != 3) {
                    break;
                }
                ArrayList<jn> arrayList2 = aaVar.f147669b;
                double[] dArr = arrayList2.remove(arrayList2.size() - 1).A;
                d16 += dArr[0];
                d17 += dArr[1];
            }
            aaVar.a(new jn(3, new double[]{d16, d17}));
        }
    }

    public final void b(fq fqVar) {
        synchronized (this.Z) {
            LogUtil.b("skew addSkewListener");
            this.Z.remove(fqVar);
        }
    }

    private void e(int i3) {
        a(i3, (Runnable) new AnonymousClass4());
    }

    private void e(boolean z16) {
        this.L = z16;
    }

    private void b(int i3, int i16) {
        a(i3, i16, 1);
    }

    private void b(float f16) {
        b(f16);
    }

    private void b(double d16, double d17) {
        this.f147743z.g().b((float) d16, (float) d17);
        U();
        c();
    }

    public final PointF a() {
        int i3;
        int i16;
        Rect rect = this.C;
        if (rect != null) {
            i3 = rect.width();
            i16 = this.C.height();
        } else {
            i3 = 0;
            i16 = 0;
        }
        int i17 = this.H;
        int i18 = i17 + (((i3 - i17) - this.J) / 2);
        int i19 = this.I;
        int i26 = i19 + (((i16 - i19) - this.K) / 2);
        if (i3 != 0 && i16 != 0) {
            return new PointF((i18 * 1.0f) / i3, (i26 * 1.0f) / i16);
        }
        return new PointF(0.5f, 0.5f);
    }

    public final void c(double d16) {
        this.f147732o.e();
        b(new jn(108, new double[]{d16}));
    }

    public final void b(double d16) {
        if (lj.a(d16 - this.A.f151267p.s()) == 0.0d) {
            return;
        }
        this.A.a((float) d16);
        c();
        D();
    }

    private void c(Runnable runnable) {
        if (l()) {
            this.f147743z.g().c(this.f147743z.h().width() / 2.0f, this.f147743z.h().height() / 2.0f);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final void a(bc bcVar) {
        if (bcVar == null) {
            return;
        }
        if (this.f147739v == null) {
            this.f147739v = new CopyOnWriteArrayList();
        }
        synchronized (this.f147740w) {
            if (!this.f147739v.contains(bcVar)) {
                this.f147739v.add(bcVar);
            }
        }
    }

    private void b(float f16, float f17, Runnable runnable) {
        if (l()) {
            Rect rect = this.A.f151265n;
            int height = rect.height();
            float t16 = this.f147743z.g().t();
            if (f17 >= rect.top && f17 < (r0 + height) - t16) {
                f17 = (r0 + height) - t16;
            }
            this.f147743z.g().c(f16, f17);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final void c(int i3) {
        if (i3 == gh.f148490a) {
            return;
        }
        for (fo foVar : this.W) {
            if (foVar != null) {
                foVar.b(i3);
            }
        }
        c();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.ae$6, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ iw f147765a;

        public AnonymousClass6(iw iwVar) {
            this.f147765a = iwVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    private void c(GeoPoint geoPoint) {
        a(geoPoint, (Runnable) null);
    }

    public final void a(Rect rect) {
        if (x()) {
            float a16 = a(rect, this.C);
            this.A.a(rect);
            this.A.e(a16);
        }
    }

    public final void c(Rect rect, Rect rect2) {
        if (rect == null) {
            return;
        }
        if (rect.height() > 0 || rect.width() > 0) {
            a(rect, rect2, false);
        }
        U();
    }

    private void b(boolean z16, Runnable runnable) {
        double m3 = m(0.0d - h());
        double i3 = 0.0d - i();
        if (m3 == 0.0d && i3 == 0.0d) {
            if (runnable != null) {
                jn jnVar = new jn(runnable);
                jnVar.D = true;
                jnVar.B = 0L;
                b(jnVar);
                return;
            }
            return;
        }
        LogUtil.b("postRotateAndSkew distance:" + m3 + "," + i3);
        b(new AnonymousClass3(new double[]{0.0d, 0.0d, 0.0d, 0.0d}, z16 ^ true, SystemClock.elapsedRealtime(), (float) (m3 * 0.10000000149011612d), (float) (0.10000000149011612d * i3), m3, i3));
        if (runnable != null) {
            jn jnVar2 = new jn(runnable);
            jnVar2.D = true;
            jnVar2.B = 0L;
            b(jnVar2);
        }
    }

    @Override // com.tencent.mapsdk.internal.jq
    public final void c(jn jnVar) {
        if (jnVar != null) {
            d(jnVar);
        }
    }

    private void a(fm fmVar) {
        if (fmVar == null) {
            return;
        }
        synchronized (this.f147741x) {
            if (!this.f147741x.contains(fmVar)) {
                this.f147741x.add(fmVar);
            }
        }
    }

    private float c(GeoPoint geoPoint, GeoPoint geoPoint2) {
        int i3;
        int i16;
        Rect rect = this.C;
        if (rect != null) {
            i3 = rect.width();
            i16 = this.C.height();
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (i3 == 0 || i16 == 0 || geoPoint == null || geoPoint2 == null) {
            return 1.0f;
        }
        fw a16 = a(geoPoint);
        fw a17 = a(geoPoint2);
        double d16 = a17.f148383a - a16.f148383a;
        if (d16 < 0.0d) {
            d16 = Math.abs(d16);
        }
        double d17 = a17.f148384b - a16.f148384b;
        if (d17 < 0.0d) {
            d17 = Math.abs(d17);
        }
        double d18 = d16 * 1.0d;
        double d19 = d17 * 1.0d;
        int i17 = (i3 - this.H) - this.J;
        int i18 = (i16 - this.I) - this.K;
        if (i17 <= 0) {
            i17 = 1;
        }
        if (i18 <= 0) {
            i18 = 1;
        }
        float max = (float) (20.0d - Math.max(Math.log(d18 / i17) / Math.log(2.0d), Math.log(d19 / i18) / Math.log(2.0d)));
        return this.A != null ? v.a.a((int) max) : max;
    }

    public final void a(fq fqVar) {
        if (fqVar == null) {
            return;
        }
        synchronized (this.Z) {
            LogUtil.b("skew addSkewListener");
            if (!this.Z.contains(fqVar)) {
                this.Z.add(fqVar);
            }
        }
    }

    private void a(qm qmVar) {
        if (this.f147733p == null) {
            this.f147733p = this.f147742y.M();
        }
        qj qjVar = this.f147733p;
        qjVar.f149828b = qmVar;
        boolean a16 = qmVar.a();
        bb bbVar = qjVar.f149830d;
        if (bbVar != null) {
            if (a16) {
                bbVar.b(qjVar);
            } else {
                bbVar.a(qjVar);
            }
        }
    }

    private void f(double d16) {
        a(this.A.f151253b.f151290p * ((float) d16));
    }

    public final void b(int i3) {
        if (this.A.a(i3)) {
            for (ft ftVar : this.Y) {
                if (ftVar != null) {
                    try {
                        ftVar.i(i3);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
            c();
        }
    }

    private void c(GeoPoint geoPoint, float f16, Runnable runnable) {
        int i3;
        if (geoPoint == null) {
            return;
        }
        this.f147732o.e();
        double d16 = this.A.f151253b.f151290p;
        double d17 = f16;
        double d18 = d17 / d16;
        if (d18 > 1.0d) {
            i3 = (int) (d18 / 0.5d);
        } else {
            if (d18 >= 1.0d) {
                b(geoPoint, runnable);
                return;
            }
            i3 = d18 != 1.0d ? (int) (0.5d / d18) : 0;
        }
        int max = Math.max(60, Math.min(120, (i3 >> 1) << 1));
        double log10 = Math.log10(d16) / Math.log10(2.0d);
        double log102 = Math.log10(d17) / Math.log10(2.0d);
        GeoPoint geoPoint2 = this.A.f151264m;
        int i16 = 0;
        while (i16 < max) {
            long j3 = max;
            i16++;
            long j16 = i16;
            double d19 = log10;
            double pow = Math.pow(2.0d, mo.a(log10, log102, j3, j16));
            double a16 = mo.a(geoPoint2.getLatitudeE6(), geoPoint.getLatitudeE6(), j3, j16);
            double d26 = log102;
            double a17 = mo.a(geoPoint2.getLongitudeE6(), geoPoint.getLongitudeE6(), j3, j16);
            LogUtil.b("debug location anim zoomOut:" + a16 + "," + a17);
            b(new jn(120, new double[]{pow, a16, a17}));
            log10 = d19;
            log102 = d26;
        }
        if (runnable != null) {
            b(new jn(runnable));
        }
    }

    private void f(boolean z16) {
        this.M = z16;
    }

    private void a(int i3, GeoPoint geoPoint) {
        a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), 1);
        a(i3);
    }

    public final void b(float f16, float f17, boolean z16) {
        this.A.a(f16 - 0.5f, f17 - 0.5f, z16);
        c();
    }

    private void b(float f16, float f17) {
        this.E = f16;
        this.F = f17;
    }

    private void a(GeoPoint geoPoint, float f16, float f17, float f18) {
        a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), 1);
        a(f16);
        b(f17);
        a(f18);
    }

    private void d(boolean z16) {
        b(z16 ? 12 : 0);
    }

    private void d(int i3) {
        for (ft ftVar : this.Y) {
            if (ftVar != null) {
                try {
                    ftVar.i(i3);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        c();
    }

    public final void b(Rect rect) {
        ne neVar;
        Rect rect2;
        if (this.C == null || rect == null) {
            return;
        }
        this.f147730ab = rect;
        bf bfVar = this.f147743z;
        if ((bfVar instanceof ne) && (rect2 = (neVar = (ne) bfVar).f149405r) != null) {
            neVar.F = rect;
            int width = rect2.width();
            int height = neVar.f149405r.height();
            int i3 = rect.left;
            int i16 = rect.bottom;
            neVar.a(i3, i16, (width - rect.right) - i3, (height - i16) - rect.top, true);
        }
        c();
    }

    private void d(Rect rect) {
        b(rect, (Rect) null);
    }

    public final void a(int i3) {
        if (this.A.c(i3)) {
            c(gh.f148492c);
        }
    }

    private float d(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(this.f147743z.h());
        if (rect2 != null) {
            rect3.left += rect2.left;
            rect3.right -= rect2.right;
            rect3.top += rect2.top;
            rect3.bottom -= rect2.bottom;
        }
        return a(rect, rect3);
    }

    public final void a(int i3, int i16, int i17) {
        this.A.a(i3, i16, false);
        if (i17 == 1) {
            U();
            c();
        }
    }

    private void a(float f16, float f17) {
        tk g16;
        bf bfVar = this.f147743z;
        if (bfVar == null || (g16 = bfVar.g()) == null) {
            return;
        }
        g16.b(f16, f17);
        c();
        a(true);
    }

    private boolean d(GeoPoint geoPoint) {
        boolean z16;
        if (geoPoint == null) {
            return true;
        }
        Rect r16 = r();
        boolean contains = r16 != null ? r16.contains(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6()) : false;
        fw a16 = this.B.a(this.A.f151264m);
        fw a17 = this.B.a(geoPoint);
        if (this.C != null) {
            double abs = Math.abs(a16.f148383a - a17.f148383a);
            double abs2 = Math.abs(a16.f148384b - a17.f148384b);
            if (abs > this.C.width() || abs2 > this.C.height()) {
                z16 = false;
                return contains && !z16;
            }
        }
        z16 = true;
        if (contains) {
        }
    }

    private void c(GeoPoint geoPoint, Runnable runnable) {
        if (geoPoint == null) {
            return;
        }
        a(geoPoint, this.A.f151253b.f151291q, runnable);
    }

    private void b(fi fiVar) {
        if (this.f147736s == null) {
            return;
        }
        synchronized (this.f147737t) {
            this.f147736s.remove(fiVar);
        }
    }

    public final void a(boolean z16) {
        this.f147732o.f147677j = z16;
    }

    public final float a(Rect rect, Rect rect2) {
        GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
        GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
        Rect rect3 = new Rect();
        rect3.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
        rect3.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        rect3.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
        return (float) this.f147743z.g().a(rect3, rect2);
    }

    private void c(Rect rect) {
        b(rect, (Rect) null);
    }

    public final void b(fo foVar) {
        synchronized (this.W) {
            this.W.remove(foVar);
        }
    }

    private void b(fn fnVar) {
        synchronized (this.f147738u) {
            this.f147738u.remove(fnVar);
        }
    }

    private void d(Runnable runnable) {
        ne neVar;
        v.a aVar = this.A.f151253b;
        if (aVar.f151291q > aVar.f151288n) {
            tk g16 = this.f147743z.g();
            if (0 != g16.f150515e && (neVar = g16.f150520j) != null) {
                neVar.a(new tk.AnonymousClass3());
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private void a(Rect rect, Rect rect2, boolean z16) {
        if (x()) {
            Rect rect3 = new Rect(this.C);
            if (rect2 != null) {
                rect3.left += rect2.left;
                rect3.right -= rect2.right;
                rect3.top += rect2.top;
                rect3.bottom -= rect2.bottom;
            }
            GeoPoint geoPoint = new GeoPoint(rect.top, rect.left);
            GeoPoint geoPoint2 = new GeoPoint(rect.bottom, rect.right);
            Rect rect4 = new Rect();
            rect4.left = Math.min(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.right = Math.max(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6());
            rect4.top = Math.min(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            rect4.bottom = Math.max(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6());
            this.f147743z.g().a(rect4, rect3, z16);
        }
    }

    public final void b(fs fsVar) {
        synchronized (this.X) {
            this.X.remove(fsVar);
        }
    }

    private void b(fl flVar) {
        synchronized (this.f147734q) {
            this.f147734q.remove(flVar);
        }
    }

    private void d(GeoPoint geoPoint, Runnable runnable) {
        a(geoPoint, 18, runnable);
    }

    private void b(fg fgVar) {
        synchronized (this.f147735r) {
            this.f147735r.remove(fgVar);
        }
    }

    public final void b(ph phVar) {
        synchronized (this.V) {
            this.V.remove(phVar);
        }
    }

    public final void b(ft ftVar) {
        synchronized (this.Y) {
            this.Y.remove(ftVar);
        }
    }

    public final void a(float f16) {
        c(this.A.c(f16));
    }

    private void b(GeoPoint geoPoint, Rect rect) {
        fa faVar = this.B;
        fw a16 = faVar.a(geoPoint);
        double centerX = rect.centerX() - a16.f148383a;
        double centerY = rect.centerY() - a16.f148384b;
        fw a17 = faVar.a(this.A.f151264m);
        a17.f148383a -= centerX;
        a17.f148384b -= centerY;
        a(faVar.a(a17), (Runnable) null);
    }

    private double a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        fw a16 = this.B.a(geoPoint);
        fw a17 = this.B.a(geoPoint2);
        double d16 = a17.f148383a - a16.f148383a;
        double d17 = a17.f148384b - a16.f148384b;
        return Math.sqrt((d16 * d16) + (d17 * d17));
    }

    public final void a(double d16) {
        if (d16 == this.A.f151267p.r()) {
            return;
        }
        this.A.b((float) d16);
        c();
        E();
    }

    private void b(GeoPoint geoPoint, int i3, Runnable runnable) {
        a(geoPoint, i3, runnable);
    }

    public final void a(jn jnVar) {
        this.f147732o.e();
        b(jnVar);
    }

    private float b(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (!x()) {
            return this.A.f151253b.f151290p;
        }
        int latitudeE6 = geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint.getLongitudeE6();
        int latitudeE62 = geoPoint2.getLatitudeE6();
        int longitudeE62 = geoPoint2.getLongitudeE6();
        return a(new Rect(Math.min(longitudeE62, longitudeE6), Math.min(latitudeE62, latitudeE6), Math.max(longitudeE62, longitudeE6), Math.max(latitudeE62, latitudeE6)), this.C);
    }

    private void a(double d16, double d17, double d18, double d19, double d26) {
        this.f147732o.e();
        float width = this.f147743z.h().width() / 2.0f;
        float height = this.f147743z.h().height() / 2.0f;
        v.c cVar = this.A.f151269r;
        if (this.M) {
            if (cVar != null) {
                d17 = width + (cVar.f151295a * width * 2.0f);
                height += cVar.f151296b * height * 2.0f;
            } else {
                d17 = width;
            }
            d18 = height;
            d19 = d17;
            d26 = d18;
        }
        c(new jn(103, new double[]{d16, d17, d18, d19, d26}));
    }

    public final void a(double d16, double d17, double d18, double d19, double d26, Runnable runnable) {
        double d27;
        double d28;
        double d29;
        double d36;
        this.f147732o.e();
        float width = this.f147743z.h().width() / 2.0f;
        float height = this.f147743z.h().height() / 2.0f;
        v.c cVar = this.A.f151269r;
        if (this.L) {
            if (cVar != null) {
                d27 = width + (cVar.f151295a * width * 2.0f);
                d28 = height + (cVar.f151296b * height * 2.0f);
            } else {
                d27 = width;
                d28 = height;
            }
            d36 = d28;
            d29 = d27;
        } else {
            d27 = d17;
            d28 = d18;
            d29 = d19;
            d36 = d26;
        }
        b(new jn(101, new double[]{d16, d27, d28, d29, d36}));
        jn jnVar = new jn(runnable);
        jnVar.D = false;
        jnVar.B = 0L;
        b(jnVar);
    }

    public final void b(Rect rect, Rect rect2) {
        if (x()) {
            Rect rect3 = new Rect(this.C);
            if (rect2 != null) {
                rect3.left += rect2.left;
                rect3.right -= rect2.right;
                rect3.top += rect2.top;
                rect3.bottom -= rect2.bottom;
            }
            a(rect, rect2, true);
            U();
        }
    }

    public final void b(jn jnVar) {
        this.f147732o.a(jnVar);
    }

    private void a(float f16, float f17, Runnable runnable) {
        if (this.L) {
            v.c cVar = this.A.f151269r;
            if (cVar != null) {
                float width = this.f147743z.h().width() * (cVar.f151295a + 0.5f);
                f17 = (cVar.f151296b + 0.5f) * this.f147743z.h().height();
                f16 = width;
            } else {
                a(runnable);
                return;
            }
        }
        if (l()) {
            Rect rect = this.A.f151265n;
            int height = rect.height();
            float t16 = this.f147743z.g().t();
            if (f17 >= rect.top && f17 < (r0 + height) - t16) {
                f17 = (r0 + height) - t16;
            }
            this.f147743z.g().c(f16, f17);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final void b(GeoPoint geoPoint, float f16, Runnable runnable) {
        int i3;
        boolean z16;
        if (geoPoint == null) {
            return;
        }
        this.f147732o.e();
        double d16 = this.A.f151253b.f151290p;
        double d17 = f16;
        double d18 = d17 / d16;
        if (d18 > 1.0d) {
            i3 = (int) (d18 / 0.5d);
            z16 = true;
        } else if (d18 >= 1.0d) {
            b(geoPoint, runnable);
            return;
        } else {
            i3 = d18 != 1.0d ? (int) (0.5d / d18) : 0;
            z16 = false;
        }
        int max = Math.max(60, Math.min(120, (i3 >> 1) << 1));
        double log10 = Math.log10(d16) / Math.log10(2.0d);
        double log102 = Math.log10(d17) / Math.log10(2.0d);
        GeoPoint geoPoint2 = this.A.f151264m;
        if (z16) {
            int i16 = 0;
            while (i16 < max) {
                long j3 = max;
                i16++;
                long j16 = i16;
                double d19 = log102;
                double pow = Math.pow(2.0d, mo.c(log10, log102, j3, j16));
                double d26 = log10;
                double e16 = mo.e(geoPoint2.getLatitudeE6(), geoPoint.getLatitudeE6(), j3, j16);
                double e17 = mo.e(geoPoint2.getLongitudeE6(), geoPoint.getLongitudeE6(), j3, j16);
                LogUtil.b("debug location anim zoomOut:" + e16 + "," + e17);
                b(new jn(120, new double[]{pow, e16, e17}));
                log102 = d19;
                log10 = d26;
                geoPoint2 = geoPoint2;
            }
        } else {
            int i17 = 0;
            while (i17 < max) {
                long j17 = max;
                i17++;
                long j18 = i17;
                double pow2 = Math.pow(2.0d, mo.b(log10, log102, j17, j18));
                double d27 = mo.d(geoPoint2.getLatitudeE6(), geoPoint.getLatitudeE6(), j17, j18);
                double d28 = mo.d(geoPoint2.getLongitudeE6(), geoPoint.getLongitudeE6(), j17, j18);
                LogUtil.b("debug location anim zoomin:" + d27 + "," + d28);
                b(new jn(120, new double[]{pow2, d27, d28}));
            }
        }
        if (runnable != null) {
            b(new jn(runnable));
        }
    }

    private void a(boolean z16, Runnable runnable) {
        this.f147732o.e();
        double m3 = m(0.0d - h());
        double i3 = 0.0d - i();
        if (m3 == 0.0d && i3 == 0.0d) {
            if (runnable != null) {
                jn jnVar = new jn(runnable);
                jnVar.D = true;
                jnVar.B = 0L;
                b(jnVar);
                return;
            }
            return;
        }
        LogUtil.b("postRotateAndSkew distance:" + m3 + "," + i3);
        b(new AnonymousClass3(new double[]{0.0d, 0.0d, 0.0d, 0.0d}, z16 ^ true, SystemClock.elapsedRealtime(), (float) (m3 * 0.10000000149011612d), (float) (0.10000000149011612d * i3), m3, i3));
        if (runnable != null) {
            jn jnVar2 = new jn(runnable);
            jnVar2.D = true;
            jnVar2.B = 0L;
            b(jnVar2);
        }
    }

    public final void b(GeoPoint geoPoint, Runnable runnable) {
        if (geoPoint == null) {
            return;
        }
        this.f147732o.e();
        GeoPoint geoPoint2 = this.A.f151264m;
        double[] a16 = iv.a(geoPoint2.getLatitudeE6(), geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6());
        double[] a17 = iv.a(geoPoint2.getLongitudeE6(), geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6());
        for (int i3 = 0; i3 < 20; i3++) {
            b(new jn(4, new double[]{a16[i3], a17[i3]}));
        }
        if (runnable != null) {
            b(new jn(runnable));
        }
    }

    public final void a(double d16, double d17) {
        double m3 = m(d16 - h());
        double i3 = d17 - i();
        if (m3 == 0.0d && i3 == 0.0d) {
            return;
        }
        LogUtil.b("rotateAndSkew distance:" + m3 + "," + i3);
        b(new jn(102, new double[]{m3, i3, 0.0d, 0.0d}, true));
    }

    public final void a(final double d16, final double d17, boolean z16) {
        final double m3 = m(d16 - h());
        final double i3 = d17 - i();
        if (m3 == 0.0d && i3 == 0.0d) {
            return;
        }
        LogUtil.b("postRotateAndSkew distance:" + m3 + "," + i3);
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final float f16 = (float) (m3 * 0.10000000149011612d);
        final float f17 = (float) (0.10000000149011612d * i3);
        b(new jn(new double[]{d16, d17, 0.0d, 0.0d}, z16 ^ true) { // from class: com.tencent.mapsdk.internal.ae.2
            @Override // com.tencent.mapsdk.internal.jn
            public final boolean a() {
                boolean z17;
                boolean z18;
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                double a16 = jk.a(elapsedRealtime2, f16);
                double a17 = jk.a(elapsedRealtime2, f17);
                double[] dArr = this.A;
                dArr[2] = dArr[2] + Math.abs(a16);
                double[] dArr2 = this.A;
                dArr2[3] = dArr2[3] + Math.abs(a17);
                if (this.A[2] >= Math.abs(m3)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (this.A[3] >= Math.abs(i3)) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z17) {
                    this.A[0] = d16 - ae.this.h();
                } else {
                    this.A[0] = a16;
                }
                if (z18) {
                    this.A[1] = d17 - ae.this.i();
                } else {
                    this.A[1] = a17;
                }
                if (z17 && z18) {
                    return true;
                }
                return false;
            }
        });
    }

    @Override // com.tencent.mapsdk.internal.pa
    public final void b(boolean z16) {
        if (z16) {
            Runnable runnable = this.f147731ac;
            if (runnable != null) {
                runnable.run();
                this.f147731ac = null;
            }
            c();
        }
    }

    public final void a(float f16, float f17, boolean z16) {
        this.A.a(f16 - 0.5f, f17 - 0.5f, z16);
        if (z16) {
            c();
        }
    }

    public final void b(Runnable runnable) {
        ne neVar;
        v.a aVar = this.A.f151253b;
        if (aVar.f151291q > aVar.f151288n) {
            tk g16 = this.f147743z.g();
            if (0 != g16.f150515e && (neVar = g16.f150520j) != null) {
                neVar.a(new tk.AnonymousClass3());
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private void a(fi fiVar) {
        if (fiVar == null) {
            return;
        }
        if (this.f147736s == null) {
            this.f147736s = new ArrayList();
        }
        synchronized (this.f147737t) {
            if (!this.f147736s.contains(fiVar)) {
                this.f147736s.add(fiVar);
            }
        }
    }

    private void b(GeoPoint geoPoint) {
        a(geoPoint, (Runnable) null);
    }

    public final void a(fo foVar) {
        if (foVar == null) {
            return;
        }
        synchronized (this.W) {
            if (!this.W.contains(foVar)) {
                this.W.add(foVar);
            }
        }
    }

    private void a(fn fnVar) {
        if (fnVar == null) {
            return;
        }
        synchronized (this.f147738u) {
            if (!this.f147738u.contains(fnVar)) {
                this.f147738u.add(fnVar);
            }
        }
    }

    public final void a(fs fsVar) {
        if (fsVar == null) {
            return;
        }
        synchronized (this.X) {
            if (!this.X.contains(fsVar)) {
                this.X.add(fsVar);
            }
        }
    }

    private void a(fl flVar) {
        if (flVar == null) {
            return;
        }
        synchronized (this.f147734q) {
            if (!this.f147734q.contains(flVar)) {
                this.f147734q.add(flVar);
            }
        }
    }

    private void a(fg fgVar) {
        if (fgVar == null) {
            return;
        }
        synchronized (this.f147735r) {
            if (!this.f147735r.contains(fgVar)) {
                this.f147735r.add(fgVar);
            }
        }
    }

    public final void a(ph phVar) {
        if (phVar == null || this.V.contains(phVar)) {
            return;
        }
        this.V.add(phVar);
    }

    public final void a(ft ftVar) {
        if (ftVar == null) {
            return;
        }
        synchronized (this.Y) {
            if (!this.Y.contains(ftVar)) {
                this.Y.add(ftVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        if (r1 > r10) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(GeoPoint geoPoint, Rect rect) {
        double d16;
        double d17;
        int i3;
        fa faVar = this.B;
        fw a16 = faVar.a(geoPoint);
        if (rect.contains((int) a16.f148383a, (int) a16.f148384b)) {
            return;
        }
        double d18 = a16.f148383a;
        int i16 = rect.left;
        double d19 = 0.0d;
        if (d18 >= i16) {
            i16 = rect.right;
            if (d18 <= i16) {
                d16 = 0.0d;
                d17 = a16.f148384b;
                i3 = rect.top;
                if (d17 >= i3) {
                    i3 = rect.bottom;
                }
                d19 = i3 - d17;
                fw a17 = faVar.a(this.A.f151264m);
                a17.f148383a -= d16;
                a17.f148384b -= d19;
                a(faVar.a(a17), (Runnable) null);
            }
        }
        d16 = i16 - d18;
        d17 = a16.f148384b;
        i3 = rect.top;
        if (d17 >= i3) {
        }
        d19 = i3 - d17;
        fw a172 = faVar.a(this.A.f151264m);
        a172.f148383a -= d16;
        a172.f148384b -= d19;
        a(faVar.a(a172), (Runnable) null);
    }

    public final void a(GeoPoint geoPoint, int i3, Runnable runnable) {
        a(geoPoint, i3, runnable);
    }

    public final void a(GeoPoint geoPoint, float f16, Runnable runnable) {
        if (geoPoint == null) {
            return;
        }
        if (f16 >= 3.0f && f16 <= 20.0f) {
            this.f147743z.g().a(geoPoint, (int) f16);
        }
        this.f147731ac = runnable;
    }

    public final void a(int i3, Runnable runnable) {
        ne neVar;
        tk g16 = this.f147743z.g();
        if (0 != g16.f150515e && (neVar = g16.f150520j) != null) {
            neVar.a(new tk.AnonymousClass189(i3));
        }
        runnable.run();
    }

    private void a(int i3, double d16) {
        a(i3, (Runnable) new AnonymousClass5(d16));
    }

    private ix a(int i3, Object obj, Object obj2) {
        if (i3 == 0) {
            return jh.a((iu) this, 0, 1);
        }
        if (i3 == 1) {
            return jh.a((iu) this, (jl) new il(), new Object[]{obj, obj2});
        }
        if (i3 == 2) {
            return jh.a(this, 3, Math.log10(((Number) obj).doubleValue()) / Math.log10(2.0d), Math.log10(((Number) obj2).doubleValue()) / Math.log10(2.0d));
        }
        if (i3 == 3) {
            return jh.a(this, 2, h(), (((Number) obj2).doubleValue() - ((Number) obj).doubleValue()) + h());
        }
        if (i3 != 4) {
            return null;
        }
        return jh.a(this, 4, i(), (((Number) obj2).doubleValue() - ((Number) obj).doubleValue()) + i());
    }

    @Override // com.tencent.mapsdk.internal.iu
    public final void a(int i3, Object obj) {
        if (i3 == 1) {
            GeoPoint geoPoint = (GeoPoint) obj;
            a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), 2);
        } else if (i3 == 2) {
            e(((Number) obj).doubleValue() - h());
        } else if (i3 == 3) {
            a((float) Math.pow(2.0d, ((Number) obj).doubleValue()));
        } else {
            if (i3 != 4) {
                return;
            }
            d(((Number) obj).doubleValue() - i());
        }
    }

    public final void a(int i3, int i16) {
        b(i3, i16);
    }

    private void a(a aVar) {
        this.D = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(GeoPoint geoPoint, iw iwVar) {
        boolean z16;
        int i3;
        float f16;
        Rect r16 = r();
        int i16 = 0;
        boolean contains = r16 != null ? r16.contains(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6()) : false;
        AnonymousClass6 anonymousClass6 = new AnonymousClass6(iwVar);
        v vVar = this.A;
        float f17 = vVar.f151253b.f151290p;
        if (!contains) {
            GeoPoint geoPoint2 = vVar.f151264m;
            fw a16 = this.B.a(geoPoint2);
            fw a17 = this.B.a(geoPoint);
            if (this.C != null) {
                double abs = Math.abs(a16.f148383a - a17.f148383a);
                double abs2 = Math.abs(a16.f148384b - a17.f148384b);
                if (abs > this.C.width() || abs2 > this.C.height()) {
                    z16 = false;
                    if (z16) {
                        Rect rect = this.C;
                        if (rect != null) {
                            i16 = rect.width();
                            i3 = this.C.height();
                        } else {
                            i3 = 0;
                        }
                        if (i16 == 0 || i3 == 0 || geoPoint2 == null || geoPoint == null) {
                            f16 = 1.0f;
                        } else {
                            fw a18 = a(geoPoint2);
                            fw a19 = a(geoPoint);
                            double d16 = a19.f148383a - a18.f148383a;
                            if (d16 < 0.0d) {
                                d16 = Math.abs(d16);
                            }
                            double d17 = a19.f148384b - a18.f148384b;
                            if (d17 < 0.0d) {
                                d17 = Math.abs(d17);
                            }
                            double d18 = d16 * 1.0d;
                            double d19 = d17 * 1.0d;
                            int i17 = (i16 - this.H) - this.J;
                            int i18 = (i3 - this.I) - this.K;
                            if (i17 <= 0) {
                                i17 = 1;
                            }
                            f16 = (float) (20.0d - Math.max(Math.log(d18 / i17) / Math.log(2.0d), Math.log(d19 / (i18 > 0 ? i18 : 1)) / Math.log(2.0d)));
                            if (this.A != null) {
                                f16 = v.a.a((int) f16);
                            }
                        }
                        b(new GeoPoint((geoPoint.getLatitudeE6() + geoPoint2.getLatitudeE6()) / 2, (geoPoint.getLongitudeE6() + geoPoint2.getLongitudeE6()) / 2), f16, new AnonymousClass7(geoPoint, f17, anonymousClass6));
                        return;
                    }
                    b(geoPoint, anonymousClass6);
                    return;
                }
            }
            z16 = true;
            if (z16) {
            }
        } else {
            b(geoPoint, anonymousClass6);
        }
    }

    public static fw a(GeoPoint geoPoint) {
        double min = Math.min(Math.max(Math.sin((geoPoint.getLatitudeE6() / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
        double longitudeE6 = ((geoPoint.getLongitudeE6() / 1000000.0d) * 745654.0444444445d) + 1.34217728E8d;
        double log = (Math.log((min + 1.0d) / (1.0d - min)) * 4.272282972352698E7d * 0.5d) + 1.34217728E8d;
        fw fwVar = new fw();
        fwVar.a(longitudeE6, log);
        return fwVar;
    }

    public final void a(Runnable runnable) {
        if (l()) {
            this.f147743z.g().c(this.f147743z.h().width() / 2.0f, this.f147743z.h().height() / 2.0f);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final void a(GeoPoint geoPoint, Runnable runnable) {
        if (geoPoint == null) {
            return;
        }
        a(geoPoint, this.A.f151253b.f151291q, runnable);
    }
}
