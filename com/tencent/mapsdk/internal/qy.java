package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qy {

    /* renamed from: a, reason: collision with root package name */
    public static final int f149968a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f149969b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f149970c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f149971d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f149972e = 16;

    /* renamed from: f, reason: collision with root package name */
    public static final int f149973f = 256;

    /* renamed from: g, reason: collision with root package name */
    public static final int f149974g = 4096;

    /* renamed from: h, reason: collision with root package name */
    public static final int f149975h = 65536;
    private Rect B;

    /* renamed from: i, reason: collision with root package name */
    public GeoPoint f149976i;

    /* renamed from: j, reason: collision with root package name */
    public Bitmap[] f149977j;

    /* renamed from: o, reason: collision with root package name */
    public int f149982o;

    /* renamed from: p, reason: collision with root package name */
    boolean f149983p;

    /* renamed from: q, reason: collision with root package name */
    public int f149984q;

    /* renamed from: r, reason: collision with root package name */
    public int f149985r;

    /* renamed from: s, reason: collision with root package name */
    public int f149986s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f149988u;

    /* renamed from: w, reason: collision with root package name */
    protected String f149990w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f149991x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f149992y;

    /* renamed from: k, reason: collision with root package name */
    public float f149978k = 0.5f;

    /* renamed from: l, reason: collision with root package name */
    public float f149979l = 0.5f;

    /* renamed from: m, reason: collision with root package name */
    public float f149980m = 1.0f;

    /* renamed from: n, reason: collision with root package name */
    public boolean f149981n = false;

    /* renamed from: t, reason: collision with root package name */
    public int f149987t = 2;

    /* renamed from: v, reason: collision with root package name */
    public boolean f149989v = true;

    /* renamed from: z, reason: collision with root package name */
    public boolean f149993z = true;
    public Object A = "";

    private qy a(GeoPoint geoPoint) {
        this.f149976i = geoPoint;
        return this;
    }

    private GeoPoint b() {
        return this.f149976i;
    }

    private Rect c() {
        return this.B;
    }

    private Bitmap[] d() {
        return this.f149977j;
    }

    private boolean e() {
        return this.f149981n;
    }

    private float f() {
        return this.f149980m;
    }

    private int[] g() {
        float f16 = this.f149978k;
        int i3 = f16 == 0.0f ? 4096 : f16 == 1.0f ? 65536 : 1;
        float f17 = this.f149979l;
        return new int[]{i3 | (f17 == 0.0f ? 256 : f17 == 1.0f ? 16 : 1)};
    }

    private int h() {
        int i3;
        float f16 = this.f149978k;
        int i16 = 1;
        if (f16 == 0.0f) {
            i3 = 4096;
        } else if (f16 == 1.0f) {
            i3 = 65536;
        } else {
            i3 = 1;
        }
        float f17 = this.f149979l;
        if (f17 == 0.0f) {
            i16 = 256;
        } else if (f17 == 1.0f) {
            i16 = 16;
        }
        return i3 | i16;
    }

    private float i() {
        return this.f149978k;
    }

    private float j() {
        return this.f149979l;
    }

    private int k() {
        return this.f149982o;
    }

    private boolean l() {
        return this.f149983p;
    }

    private boolean m() {
        return this.f149991x;
    }

    private boolean n() {
        return this.f149992y;
    }

    private int o() {
        return this.f149984q;
    }

    private int p() {
        return this.f149985r;
    }

    private int q() {
        return this.f149986s;
    }

    private int r() {
        return this.f149987t;
    }

    private boolean s() {
        return this.f149988u;
    }

    private boolean t() {
        return this.f149989v;
    }

    private boolean u() {
        return this.f149993z;
    }

    private Object v() {
        return this.A;
    }

    private String w() {
        Object obj = this.A;
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    private qy b(boolean z16) {
        this.f149981n = z16;
        return this;
    }

    private qy c(boolean z16) {
        this.f149983p = z16;
        return this;
    }

    private qy d(boolean z16) {
        this.f149991x = z16;
        return this;
    }

    private qy e(boolean z16) {
        this.f149992y = z16;
        return this;
    }

    private qy f(boolean z16) {
        this.f149988u = z16;
        return this;
    }

    public final qy a(String str, Bitmap... bitmapArr) {
        this.f149990w = str;
        this.f149977j = bitmapArr;
        return this;
    }

    private qy b(int i3) {
        this.f149986s = i3;
        return this;
    }

    private qy c(int i3) {
        this.f149987t = i3;
        return this;
    }

    private qy g(boolean z16) {
        this.f149993z = z16;
        return this;
    }

    private qy a(int i3, int i16) {
        this.f149984q = i3;
        this.f149985r = i16;
        return this;
    }

    private qy a(boolean z16) {
        this.f149989v = z16;
        return this;
    }

    private qy a(int i3, int i16, int i17, int i18) {
        this.B = new Rect(i3, i16, i17, i18);
        return this;
    }

    public final String a() {
        return this.f149990w;
    }

    private qy a(float f16) {
        this.f149980m = f16;
        return this;
    }

    private qy a(int... iArr) {
        if (iArr == null) {
            this.f149978k = 0.5f;
            this.f149979l = 1.0f;
            return this;
        }
        this.f149978k = 0.5f;
        this.f149979l = 0.5f;
        if (iArr.length != 1) {
            return this;
        }
        int i3 = iArr[0];
        if ((i3 & 256) == 256) {
            this.f149979l = 0.0f;
        } else if ((i3 & 16) == 16) {
            this.f149979l = 1.0f;
        }
        if ((i3 & 4096) == 4096) {
            this.f149978k = 0.0f;
        } else if ((i3 & 65536) == 65536) {
            this.f149978k = 1.0f;
        }
        return this;
    }

    public final qy a(float f16, float f17) {
        this.f149978k = f16;
        this.f149979l = f17;
        return this;
    }

    private qy a(int i3) {
        this.f149982o = i3;
        return this;
    }

    private qy a(Object obj) {
        this.A = obj;
        return this;
    }
}
