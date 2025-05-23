package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.tk;
import com.tencent.tencentmap.mapsdk.maps.MapParamConstants;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class v implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public int f151255d;

    /* renamed from: e, reason: collision with root package name */
    public double f151256e;

    /* renamed from: f, reason: collision with root package name */
    public double f151257f;

    /* renamed from: n, reason: collision with root package name */
    public Rect f151265n;

    /* renamed from: o, reason: collision with root package name */
    public ne f151266o;

    /* renamed from: p, reason: collision with root package name */
    public tk f151267p;

    /* renamed from: r, reason: collision with root package name */
    public c f151269r;

    /* renamed from: g, reason: collision with root package name */
    public double f151258g = 0.0d;

    /* renamed from: h, reason: collision with root package name */
    public double f151259h = 1.0d;

    /* renamed from: i, reason: collision with root package name */
    public double f151260i = 0.0d;

    /* renamed from: j, reason: collision with root package name */
    public double f151261j = 1.0d;

    /* renamed from: k, reason: collision with root package name */
    public double f151262k = 0.0d;

    /* renamed from: l, reason: collision with root package name */
    public double f151263l = 1.0d;

    /* renamed from: s, reason: collision with root package name */
    public boolean f151270s = false;

    /* renamed from: a, reason: collision with root package name */
    public int f151252a = 0;

    /* renamed from: b, reason: collision with root package name */
    public a f151253b = new a();

    /* renamed from: c, reason: collision with root package name */
    public Rect f151254c = new Rect();

    /* renamed from: m, reason: collision with root package name */
    public GeoPoint f151264m = new GeoPoint();

    /* renamed from: q, reason: collision with root package name */
    public fw f151268q = new fw();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.v$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f151271a;

        static {
            int[] iArr = new int[gh.a().length];
            f151271a = iArr;
            try {
                iArr[gh.f148492c - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public static final int f151272a = 20;

        /* renamed from: b, reason: collision with root package name */
        public static final int f151273b = 20;

        /* renamed from: c, reason: collision with root package name */
        public static final int f151274c = 20;

        /* renamed from: d, reason: collision with root package name */
        public static final int f151275d = 19;

        /* renamed from: e, reason: collision with root package name */
        public static final int f151276e = 22;

        /* renamed from: f, reason: collision with root package name */
        public static final int f151277f = 16;

        /* renamed from: g, reason: collision with root package name */
        public static final int f151278g = 3;

        /* renamed from: h, reason: collision with root package name */
        public static final float f151279h = 1.6f;

        /* renamed from: i, reason: collision with root package name */
        public static final float f151280i = 0.8f;

        /* renamed from: j, reason: collision with root package name */
        public static final float f151281j = 4.0f;

        /* renamed from: k, reason: collision with root package name */
        public static final float f151282k = 3.0517578E-5f;

        /* renamed from: r, reason: collision with root package name */
        public static final int f151283r = 20;

        /* renamed from: s, reason: collision with root package name */
        public static final int f151284s = 1;

        /* renamed from: t, reason: collision with root package name */
        public static final float f151285t = 1.9073486E-6f;

        /* renamed from: p, reason: collision with root package name */
        public float f151290p;

        /* renamed from: q, reason: collision with root package name */
        public int f151291q;

        /* renamed from: m, reason: collision with root package name */
        public float f151287m = 4.0f;

        /* renamed from: l, reason: collision with root package name */
        public float f151286l = 3.0517578E-5f;

        /* renamed from: o, reason: collision with root package name */
        public int f151289o = 20;

        /* renamed from: n, reason: collision with root package name */
        public int f151288n = 3;

        public static float a(int i3) {
            return (1 << (i3 - 1)) * 1.9073486E-6f;
        }

        private int c() {
            return this.f151291q;
        }

        private int d() {
            return this.f151288n;
        }

        private int e() {
            return this.f151289o;
        }

        private static int f() {
            return 20;
        }

        private float g() {
            return this.f151286l;
        }

        public final Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f151290p != aVar.f151290p || this.f151291q != aVar.f151291q) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return toString().hashCode();
        }

        public final String toString() {
            return "scale:" + this.f151290p + ", scaleLevel:" + this.f151291q;
        }

        private void a(float f16) {
            this.f151290p = f16;
        }

        private void b(float f16) {
            a aVar = new a();
            this.f151288n = aVar.f151291q;
            this.f151286l = f16 / aVar.a();
        }

        private void c(int i3) {
            this.f151288n = i3;
        }

        public final void a(int i3, float f16) {
            this.f151290p = f16;
            this.f151291q = i3;
        }

        private void a(a aVar) {
            this.f151286l = aVar.f151286l;
            this.f151287m = aVar.f151287m;
            this.f151288n = aVar.f151288n;
            this.f151289o = aVar.f151289o;
            this.f151290p = aVar.f151290p;
            this.f151291q = aVar.f151291q;
        }

        private float b() {
            return this.f151290p;
        }

        private void b(int i3) {
            this.f151289o = i3;
        }

        public final float a() {
            return this.f151290p / a(this.f151291q);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b implements Comparable<b> {

        /* renamed from: a, reason: collision with root package name */
        public long f151292a;

        /* renamed from: b, reason: collision with root package name */
        public long f151293b;

        /* renamed from: c, reason: collision with root package name */
        public long f151294c;

        public b() {
        }

        private int a(b bVar) {
            return (this.f151292a + "," + this.f151293b + "," + this.f151294c).compareTo(bVar.f151292a + "," + bVar.f151293b + "," + bVar.f151294c);
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(b bVar) {
            b bVar2 = bVar;
            return (this.f151292a + "," + this.f151293b + "," + this.f151294c).compareTo(bVar2.f151292a + "," + bVar2.f151293b + "," + bVar2.f151294c);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class == obj.getClass()) {
                b bVar = (b) obj;
                if (this.f151292a == bVar.f151292a && this.f151293b == bVar.f151293b && this.f151294c == bVar.f151294c) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Long.valueOf(this.f151292a), Long.valueOf(this.f151293b), Long.valueOf(this.f151294c));
        }

        public final String toString() {
            return "MapTile{x=" + this.f151292a + ", y=" + this.f151293b + ", z=" + this.f151294c + '}';
        }

        public b(long j3, long j16, long j17) {
            this.f151292a = j3;
            this.f151293b = j16;
            this.f151294c = j17;
        }
    }

    public v(ne neVar) {
        this.f151266o = neVar;
        this.f151267p = neVar.f149396i;
    }

    private void a(v vVar) {
        this.f151252a = vVar.f151252a;
        a aVar = this.f151253b;
        a aVar2 = vVar.f151253b;
        aVar.f151286l = aVar2.f151286l;
        aVar.f151287m = aVar2.f151287m;
        aVar.f151288n = aVar2.f151288n;
        aVar.f151289o = aVar2.f151289o;
        aVar.f151290p = aVar2.f151290p;
        aVar.f151291q = aVar2.f151291q;
        this.f151254c.set(vVar.f151254c);
        this.f151255d = vVar.f151255d;
        this.f151256e = vVar.f151256e;
        this.f151257f = vVar.f151257f;
        this.f151258g = vVar.f151258g;
        this.f151259h = vVar.f151259h;
        this.f151260i = vVar.f151260i;
        this.f151261j = vVar.f151261j;
        this.f151262k = vVar.f151262k;
        this.f151263l = vVar.f151263l;
        this.f151264m.setGeoPoint(vVar.f151264m);
        fw fwVar = this.f151268q;
        fw fwVar2 = vVar.f151268q;
        fwVar.a(fwVar2.f148383a, fwVar2.f148384b);
        this.f151265n = vVar.f151265n;
    }

    public static boolean b(int i3) {
        return i3 == 8 || i3 == 13 || i3 == 10;
    }

    private int c() {
        tk tkVar = this.f151267p;
        if (tkVar == null) {
            return this.f151252a;
        }
        return tkVar.u();
    }

    private float d() {
        return this.f151267p.s();
    }

    private double e() {
        return this.f151258g;
    }

    public static float f(float f16) {
        if (f16 < 16.0f) {
            return 40.0f;
        }
        if (f16 >= 16.0f && f16 < 17.0f) {
            return ((f16 - 16.0f) * 10.0f) + 40.0f;
        }
        if (f16 >= 17.0f && f16 < 18.0f) {
            return ((f16 - 17.0f) * 10.0f) + 50.0f;
        }
        if (f16 < 18.0f || f16 >= 19.0f) {
            return 75.0f;
        }
        return ((f16 - 18.0f) * 15.0f) + 60.0f;
    }

    private double g() {
        return this.f151260i;
    }

    private double h() {
        return this.f151261j;
    }

    private double i() {
        return this.f151263l;
    }

    private double j() {
        return this.f151262k;
    }

    private float k() {
        return this.f151267p.r();
    }

    private int l() {
        return this.f151255d;
    }

    private double m() {
        return this.f151256e;
    }

    private double n() {
        return this.f151257f;
    }

    private float o() {
        return this.f151253b.f151290p;
    }

    private int p() {
        return this.f151253b.f151291q;
    }

    private float q() {
        return this.f151253b.a();
    }

    private int r() {
        return this.f151253b.f151288n;
    }

    private int s() {
        return this.f151253b.f151289o;
    }

    private static int t() {
        return 20;
    }

    private float u() {
        return this.f151253b.f151286l;
    }

    private GeoPoint v() {
        return this.f151264m;
    }

    private Rect w() {
        return this.f151265n;
    }

    private fw x() {
        return this.f151268q;
    }

    private c y() {
        return this.f151269r;
    }

    private static byte[] z() {
        return null;
    }

    public final Object clone() throws CloneNotSupportedException {
        v vVar = (v) super.clone();
        vVar.f151254c = new Rect(this.f151254c);
        vVar.f151253b = (a) this.f151253b.clone();
        vVar.f151264m = new GeoPoint(this.f151264m);
        fw fwVar = this.f151268q;
        vVar.f151268q = new fw(fwVar.f148383a, fwVar.f148384b);
        return vVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (!vVar.f151264m.equals(this.f151264m) || !vVar.f151253b.equals(this.f151253b) || vVar.f151252a != this.f151252a) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        GeoPoint geoPoint = this.f151264m;
        sb5.append("mapParam: ");
        sb5.append("center:" + geoPoint.toString() + " ");
        sb5.append("mode:" + this.f151252a + " ");
        sb5.append("mapScale:" + this.f151253b.toString() + " ");
        StringBuilder sb6 = new StringBuilder("screenRect:");
        Rect rect = this.f151265n;
        if (rect != null) {
            str = rect.toString();
        } else {
            str = "null";
        }
        sb6.append(str);
        sb6.append(" ");
        sb5.append(sb6.toString());
        return sb5.toString();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public float f151295a;

        /* renamed from: b, reason: collision with root package name */
        public float f151296b;

        public c(float f16, float f17) {
            this.f151295a = f16;
            this.f151296b = f17;
        }

        private void a(float f16, float f17) {
            this.f151295a = f16;
            this.f151296b = f17;
        }

        private float b() {
            return this.f151296b;
        }

        private float a() {
            return this.f151295a;
        }
    }

    private void b() {
        if (this.f151266o == null) {
            return;
        }
        this.f151264m = this.f151267p.o();
        int q16 = this.f151267p.q();
        float p16 = this.f151267p.p();
        a aVar = this.f151253b;
        if (q16 != aVar.f151291q) {
            this.f151266o.f149398k.c(gh.f148492c);
        } else if (p16 != aVar.f151290p) {
            this.f151266o.f149398k.c(gh.f148491b);
        }
        if (this.f151253b != null) {
            float d16 = d(p16);
            if (d16 < a()) {
                float f16 = f(d16);
                if (this.f151267p.r() > f16) {
                    b(f16);
                }
            }
            this.f151253b.a(q16, p16);
        }
        this.f151252a = this.f151267p.u();
    }

    private void d(int i3) {
        double d16 = (1 << i3) * 256;
        this.f151255d = (int) d16;
        this.f151256e = d16 / 360.0d;
        this.f151257f = d16 / 6.283185307179586d;
    }

    private static float e(int i3) {
        return a.a(i3);
    }

    private double f() {
        return this.f151259h;
    }

    private int g(float f16) {
        tk tkVar = this.f151267p;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass188(f16));
        }
        this.f151253b.f151290p = f16;
        return gh.f148492c;
    }

    private void h(float f16) {
        float d16 = d(f16);
        if (d16 >= a()) {
            return;
        }
        float f17 = f(d16);
        if (this.f151267p.r() <= f17) {
            return;
        }
        b(f17);
    }

    private void i(float f16) {
        if (this.f151270s) {
            MapParamConstants.MAX_SKEW_ANGLE = f(f16);
        } else {
            MapParamConstants.MAX_SKEW_ANGLE = 40.0f;
        }
    }

    private void f(int i3) {
        this.f151253b.f151289o = i3;
    }

    public final void e(float f16) {
        a aVar = this.f151253b;
        a aVar2 = new a();
        aVar.f151288n = aVar2.f151291q;
        aVar.f151286l = f16 / aVar2.a();
    }

    public final int c(float f16) {
        int i3;
        float f17;
        ne neVar;
        int i16 = gh.f148490a;
        a aVar = this.f151253b;
        float f18 = aVar.f151290p;
        int i17 = aVar.f151291q;
        tk tkVar = this.f151267p;
        if (tkVar != null) {
            double d16 = f16;
            if (0 != tkVar.f150515e && (neVar = tkVar.f150520j) != null) {
                neVar.a(new tk.AnonymousClass186(d16));
            }
            f17 = this.f151267p.p();
            i3 = this.f151267p.q();
        } else {
            i3 = i17;
            f17 = f18;
        }
        this.f151253b.a(i3, f17);
        if (i3 != i17) {
            i16 = gh.f148492c;
        } else if (f17 != f18) {
            i16 = gh.f148491b;
        }
        if (AnonymousClass1.f151271a[i16 - 1] == 1) {
            double d17 = (1 << this.f151253b.f151291q) * 256;
            this.f151255d = (int) d17;
            this.f151256e = d17 / 360.0d;
            this.f151257f = d17 / 6.283185307179586d;
        }
        fw a16 = y.a(this, this.f151264m);
        this.f151268q.a(a16.f148383a, a16.f148384b);
        return i16;
    }

    public static float d(float f16) {
        return ((float) (Math.log(f16) / Math.log(2.0d))) + 20.0f;
    }

    private void g(int i3) {
        this.f151253b.f151288n = i3;
    }

    private void a(Rect rect, int i3, int i16) {
        this.f151265n = rect;
        this.f151254c = GeometryConstants.BOUNDARY_WORLD;
        c(13);
        a(0);
        a(i3, i16, false);
    }

    public final float b(float f16) {
        if (this.f151267p.r() == f16) {
            return f16;
        }
        i(a());
        float max = Math.max(0.0f, Math.min(MapParamConstants.MAX_SKEW_ANGLE, f16));
        double radians = Math.toRadians(f16);
        this.f151260i = Math.sin(radians);
        this.f151261j = Math.cos(radians);
        double d16 = 1.5707963267948966d - radians;
        this.f151263l = Math.cos(d16);
        this.f151262k = Math.sin(d16);
        tk tkVar = this.f151267p;
        if (tkVar != null) {
            tkVar.b(max);
        }
        return max;
    }

    public final boolean c(int i3) {
        return c(a.a(i3)) == gh.f148492c;
    }

    public final boolean a(int i3) {
        int u16;
        tk tkVar = this.f151267p;
        if (tkVar == null || (u16 = tkVar.u()) == i3) {
            return false;
        }
        if (u16 == 11) {
            this.f151266o.b(false);
        }
        if (i3 == 11) {
            this.f151266o.b(true);
        }
        this.f151252a = i3;
        this.f151267p.c(i3);
        this.f151267p.e(b(i3));
        LogUtil.b(ky.f149101g, "setMapStyle : styleId[" + i3 + "]");
        ne neVar = this.f151266o;
        if (neVar.f149407t) {
            neVar.I();
        }
        return true;
    }

    private boolean b(GeoPoint geoPoint) {
        int i3;
        int i16;
        int latitudeE6 = geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint.getLongitudeE6();
        int i17 = 1 << (20 - this.f151253b.f151291q);
        if (131072 > i17) {
            i3 = ((this.f151265n.width() * 131072) - (this.f151265n.width() * i17)) / 2;
            i16 = ((this.f151265n.height() * 131072) - (this.f151265n.height() * i17)) / 2;
        } else {
            i3 = 0;
            i16 = 0;
        }
        Rect rect = this.f151254c;
        int i18 = rect.left - i3;
        int i19 = rect.right + i3;
        int i26 = rect.top - i16;
        int i27 = rect.bottom + i16;
        if (latitudeE6 < i26) {
            latitudeE6 = i26;
        }
        if (latitudeE6 <= i27) {
            i27 = latitudeE6;
        }
        if (longitudeE6 < i18) {
            longitudeE6 = i18;
        }
        if (longitudeE6 <= i19) {
            i19 = longitudeE6;
        }
        GeoPoint geoPoint2 = new GeoPoint(i27, i19);
        tk tkVar = this.f151267p;
        tkVar.f150520j.a(new tk.AnonymousClass183(geoPoint2));
        return true;
    }

    public final float a(float f16) {
        if (this.f151267p.s() == f16) {
            return f16;
        }
        float f17 = f16 % 360.0f;
        double radians = Math.toRadians(f16);
        this.f151258g = Math.sin(radians);
        this.f151259h = Math.cos(radians);
        tk tkVar = this.f151267p;
        if (tkVar != null) {
            tkVar.a(new tk.AnonymousClass12(f17));
        }
        return f17;
    }

    public final float a() {
        return d(this.f151253b.f151290p);
    }

    private boolean b(int i3, int i16) {
        int i17;
        int i18;
        int i19 = 1 << (20 - this.f151253b.f151291q);
        if (131072 > i19) {
            i17 = ((this.f151265n.width() * 131072) - (this.f151265n.width() * i19)) / 2;
            i18 = ((this.f151265n.height() * 131072) - (this.f151265n.height() * i19)) / 2;
        } else {
            i17 = 0;
            i18 = 0;
        }
        Rect rect = this.f151254c;
        int i26 = rect.left - i17;
        int i27 = rect.right + i17;
        int i28 = rect.top - i18;
        int i29 = rect.bottom + i18;
        if (i3 < i28) {
            i3 = i28;
        }
        if (i3 <= i29) {
            i29 = i3;
        }
        if (i16 < i26) {
            i16 = i26;
        }
        if (i16 <= i27) {
            i27 = i16;
        }
        GeoPoint geoPoint = new GeoPoint(i29, i27);
        tk tkVar = this.f151267p;
        tkVar.f150520j.a(new tk.AnonymousClass183(geoPoint));
        return true;
    }

    public final void a(Rect rect) {
        this.f151254c.set(rect);
    }

    private boolean a(GeoPoint geoPoint) {
        return a(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6(), true);
    }

    private boolean a(int i3, int i16) {
        return a(i3, i16, false);
    }

    private void a(double d16, double d17) {
        this.f151268q.a(d16, d17);
    }

    public final boolean a(float f16, float f17, boolean z16) {
        c cVar = this.f151269r;
        if (cVar == null) {
            this.f151269r = new c(f16, f17);
        } else {
            cVar.f151295a = f16;
            cVar.f151296b = f17;
        }
        this.f151266o.a(f16, f17, z16);
        return true;
    }

    private void a(boolean z16) {
        this.f151270s = z16;
    }

    public final boolean a(int i3, int i16, boolean z16) {
        int i17;
        int i18;
        int i19 = this.f151253b.f151291q;
        boolean z17 = true;
        int i26 = (1 << (20 - i19)) < 0 ? 0 : 20 - i19;
        if (131072 > i26) {
            i17 = ((this.f151265n.width() * 131072) - (this.f151265n.width() * i26)) / 2;
            i18 = ((this.f151265n.height() * 131072) - (this.f151265n.height() * i26)) / 2;
        } else {
            i17 = 0;
            i18 = 0;
        }
        Rect rect = this.f151254c;
        int i27 = rect.left - i17;
        int i28 = rect.right + i17;
        int i29 = rect.top - i18;
        int i36 = rect.bottom + i18;
        if (i3 < i29) {
            i3 = i29;
        }
        if (i3 <= i36) {
            i36 = i3;
        }
        if (i16 < i27) {
            i16 = i27;
        }
        if (i16 <= i28) {
            i28 = i16;
        }
        if (i36 == this.f151264m.getLatitudeE6() && i28 == this.f151264m.getLongitudeE6()) {
            z17 = false;
        }
        this.f151264m.setLatitudeE6(i36);
        this.f151264m.setLongitudeE6(i28);
        fw a16 = y.a(this, this.f151264m);
        a(a16.f148383a, a16.f148384b);
        this.f151267p.a(this.f151264m, z16);
        return z17;
    }
}
