package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.pj;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class pi extends pj implements pj.a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f149482a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f149483b = 16;

    /* renamed from: c, reason: collision with root package name */
    public static final int f149484c = 256;

    /* renamed from: d, reason: collision with root package name */
    public static final int f149485d = 4096;

    /* renamed from: e, reason: collision with root package name */
    public static final int f149486e = 65536;
    public boolean A;
    public final AtomicInteger B;
    public boolean C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public boolean H;
    public final qx I;
    public boolean J;
    private RectF Y;
    private int Z;

    /* renamed from: aa, reason: collision with root package name */
    private int f149487aa;

    /* renamed from: ab, reason: collision with root package name */
    private int f149488ab;

    /* renamed from: ac, reason: collision with root package name */
    private int f149489ac;

    /* renamed from: ad, reason: collision with root package name */
    private boolean f149490ad;

    /* renamed from: f, reason: collision with root package name */
    public String f149491f;

    /* renamed from: g, reason: collision with root package name */
    public String f149492g;

    /* renamed from: h, reason: collision with root package name */
    public Bitmap[] f149493h;

    /* renamed from: i, reason: collision with root package name */
    public double f149494i;

    /* renamed from: j, reason: collision with root package name */
    public double f149495j;

    /* renamed from: k, reason: collision with root package name */
    public int f149496k;

    /* renamed from: l, reason: collision with root package name */
    public int f149497l;

    /* renamed from: m, reason: collision with root package name */
    public final String f149498m;

    /* renamed from: n, reason: collision with root package name */
    public float f149499n;

    /* renamed from: o, reason: collision with root package name */
    public float f149500o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f149501p;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicInteger f149502q;

    /* renamed from: r, reason: collision with root package name */
    public float f149503r;

    /* renamed from: s, reason: collision with root package name */
    public float f149504s;

    /* renamed from: t, reason: collision with root package name */
    public float f149505t;

    /* renamed from: u, reason: collision with root package name */
    public float f149506u;

    /* renamed from: v, reason: collision with root package name */
    public float f149507v;

    /* renamed from: w, reason: collision with root package name */
    public float f149508w;

    /* renamed from: x, reason: collision with root package name */
    public float f149509x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f149510y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f149511z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public pi(qx qxVar, @NonNull qy qyVar) {
        this(qxVar, r2, r0 == null ? "" : r0.toString(), qyVar.f149976i, qyVar.f149978k, qyVar.f149979l, qyVar.f149984q, qyVar.f149985r, qyVar.f149977j);
        String a16 = qyVar.a();
        Object obj = qyVar.A;
    }

    private float A() {
        return this.f149505t;
    }

    private float B() {
        return this.f149506u;
    }

    private boolean C() {
        return this.f149490ad;
    }

    private int D() {
        return this.F;
    }

    private int E() {
        return this.G;
    }

    private boolean F() {
        return this.J;
    }

    private void a(int i3, int i16) {
        if (this.Z == i3 && this.f149487aa == i16) {
            return;
        }
        this.Z = i3;
        this.f149487aa = i16;
        float f16 = this.f149496k / i3;
        float f17 = this.f149497l / i16;
        this.Y = new RectF(f16, -f17, 0.0f, -0.0f);
        float f18 = this.f149499n - f16;
        this.f149499n = f18;
        float f19 = this.f149500o - f17;
        this.f149500o = f19;
        int i17 = this.Z;
        float f26 = (-i17) * f18;
        this.f149503r = f26;
        this.f149504s = i17 + f26;
        int i18 = this.f149487aa;
        float f27 = i18 * f19;
        this.f149505t = f27;
        this.f149506u = f27 - i18;
    }

    private void c(int i3) {
        this.I.f149561m = i3;
    }

    private double e() {
        return this.f149494i;
    }

    private double f() {
        return this.f149495j;
    }

    private boolean g() {
        return this.H;
    }

    private boolean h() {
        if (this.f149502q.get() > 0) {
            this.f149501p = true;
            this.f149502q.set(0);
        }
        return this.f149501p;
    }

    private boolean i() {
        if (this.B.get() > 0) {
            this.A = true;
            this.B.set(0);
        }
        return this.A;
    }

    private String j() {
        return this.f149492g;
    }

    private int k() {
        return this.I.a();
    }

    private float l() {
        return this.f149499n;
    }

    private float m() {
        return this.f149500o;
    }

    private float n() {
        return this.f149507v;
    }

    private float o() {
        return this.f149508w;
    }

    private float p() {
        return this.f149509x;
    }

    private boolean q() {
        return this.f149510y;
    }

    private boolean r() {
        return this.C;
    }

    private boolean s() {
        return this.f149511z;
    }

    private boolean t() {
        return this.D;
    }

    private boolean u() {
        return this.E;
    }

    private RectF v() {
        return new RectF(this.Y);
    }

    private String w() {
        return this.f149491f;
    }

    private String x() {
        return this.f149498m;
    }

    private float y() {
        return this.f149503r;
    }

    private float z() {
        return this.f149504s;
    }

    @Override // com.tencent.mapsdk.internal.pj.a
    public final boolean b() {
        return true;
    }

    public final void d(boolean z16) {
        this.E = z16;
        LogUtil.b(ky.f149101g, "setAvoidMarker = ".concat(String.valueOf(z16)));
        a(true);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof pi) || this.I.a() != ((pi) obj).I.a()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return String.valueOf(this.I.a()).hashCode() + 527;
    }

    private void b(int i3, int i16) {
        this.f149496k = i3;
        this.f149497l = i16;
        a(true);
    }

    private void e(boolean z16) {
        this.H = z16;
    }

    private void f(boolean z16) {
        this.f149510y = z16;
    }

    private void g(boolean z16) {
        this.C = z16;
    }

    private void j(boolean z16) {
        a(this.J != z16);
        this.J = z16;
    }

    private void e(int i3) {
        this.F = i3;
    }

    private void f(int i3) {
        this.G = i3;
    }

    public final void c(boolean z16) {
        this.D = z16;
        LogUtil.b(ky.f149101g, "setAvoidPoi = ".concat(String.valueOf(z16)));
        a(true);
    }

    private Bitmap d(int i3) {
        Bitmap[] bitmapArr = this.f149493h;
        if (bitmapArr == null) {
            return null;
        }
        if (i3 >= 0 && i3 < bitmapArr.length) {
            return bitmapArr[i3];
        }
        return bitmapArr[0];
    }

    private void h(boolean z16) {
        this.f149511z = z16;
        a(true);
    }

    private void i(boolean z16) {
        this.f149490ad = z16;
    }

    public final void b(boolean z16) {
        if (z16) {
            this.B.incrementAndGet();
        }
        this.A = z16;
        if (z16) {
            return;
        }
        this.f149492g = this.f149491f;
    }

    @Override // com.tencent.mapsdk.internal.pj.a
    public final String c() {
        return this.f149491f;
    }

    private void b(float f16, float f17) {
        this.f149508w = f16;
        this.f149509x = f17;
        a(true);
    }

    @Override // com.tencent.mapsdk.internal.pj.a
    public final synchronized Bitmap d() {
        return d(this.N);
    }

    pi(qx qxVar, String str, String str2, GeoPoint geoPoint, float f16, float f17, int i3, int i16, Bitmap... bitmapArr) {
        this.f149488ab = 0;
        this.f149499n = 0.5f;
        this.f149500o = 0.5f;
        this.f149501p = false;
        this.f149502q = new AtomicInteger(0);
        this.f149503r = 0.0f;
        this.f149504s = 0.0f;
        this.f149505t = 0.0f;
        this.f149506u = 0.0f;
        this.f149507v = 1.0f;
        this.f149489ac = 0;
        this.f149508w = 1.0f;
        this.f149509x = 1.0f;
        this.f149510y = false;
        this.f149511z = true;
        this.A = false;
        this.B = new AtomicInteger(0);
        this.C = true;
        this.D = false;
        this.E = false;
        this.f149490ad = true;
        this.H = false;
        this.I = qxVar;
        a(this);
        this.f149498m = str2;
        this.f149499n = f16;
        this.f149500o = f17;
        this.f149496k = i3;
        this.f149497l = i16;
        if (geoPoint != null) {
            this.f149494i = geoPoint.getLongitudeE6() / 1000000.0d;
            this.f149495j = geoPoint.getLatitudeE6() / 1000000.0d;
        }
        a(str, bitmapArr);
    }

    @Override // com.tencent.mapsdk.internal.pj
    public final synchronized void b(int i3) {
        this.f149488ab = i3;
        a(true);
        b(true);
        Bitmap d16 = d(i3);
        if (d16 != null) {
            int width = d16.getWidth();
            int height = d16.getHeight();
            if (this.Z != width || this.f149487aa != height) {
                a(width, height);
            }
        }
        super.b(i3);
    }

    private void a(GeoPoint geoPoint) {
        if (geoPoint != null) {
            double d16 = this.f149510y ? 1.0d : 1000000.0d;
            this.f149494i = geoPoint.getLongitudeE6() / d16;
            this.f149495j = geoPoint.getLatitudeE6() / d16;
            a(true);
        }
    }

    public final void a(boolean z16) {
        if (z16) {
            this.f149502q.incrementAndGet();
        }
        this.f149501p = z16;
    }

    public final synchronized void a(String str, Bitmap... bitmapArr) {
        if (bitmapArr == null) {
            return;
        }
        a(true);
        b(true);
        this.f149491f = str;
        this.f149493h = bitmapArr;
        int i3 = this.f149488ab;
        if (i3 < 0 || i3 >= bitmapArr.length) {
            this.f149488ab = 0;
        }
        Bitmap bitmap = bitmapArr[this.f149488ab];
        if (bitmap != null) {
            a(bitmap.getWidth(), bitmapArr[this.f149488ab].getHeight());
        }
    }

    public final void a(float f16, float f17) {
        this.f149499n = f16;
        this.f149500o = f17;
        a(this.Z, this.f149487aa);
        a(true);
    }

    public final void a(float f16) {
        this.f149507v = f16;
        a(true);
    }

    public final void a(int i3) {
        this.f149489ac = i3;
        a(true);
    }

    public final float a() {
        return this.f149490ad ? 360 - this.f149489ac : this.f149489ac;
    }

    public final void a(qy qyVar) {
        a(qyVar.f149980m);
        a(qyVar.f149978k, qyVar.f149979l);
        a(qyVar.f149982o);
        this.f149510y = qyVar.f149988u;
        this.C = qyVar.f149989v;
        c(qyVar.f149991x);
        d(qyVar.f149992y);
        this.f149490ad = qyVar.f149993z;
        this.f149511z = qyVar.f149981n;
        a(true);
        this.F = qyVar.f149987t;
        this.G = qyVar.f149986s;
    }
}
