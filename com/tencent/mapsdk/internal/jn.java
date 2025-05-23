package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public class jn {
    public static final jn F = new jn(1, null);
    public static final jn G = new jn(2, null, true);
    public static final jn H = new jn(104, null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f148917i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static final int f148918j = 2;

    /* renamed from: k, reason: collision with root package name */
    public static final int f148919k = 3;

    /* renamed from: l, reason: collision with root package name */
    public static final int f148920l = 4;

    /* renamed from: m, reason: collision with root package name */
    public static final int f148921m = 5;

    /* renamed from: n, reason: collision with root package name */
    public static final int f148922n = 6;

    /* renamed from: o, reason: collision with root package name */
    public static final int f148923o = 100;

    /* renamed from: p, reason: collision with root package name */
    public static final int f148924p = 101;

    /* renamed from: q, reason: collision with root package name */
    public static final int f148925q = 102;

    /* renamed from: r, reason: collision with root package name */
    public static final int f148926r = 103;

    /* renamed from: s, reason: collision with root package name */
    public static final int f148927s = 104;

    /* renamed from: t, reason: collision with root package name */
    public static final int f148928t = 105;

    /* renamed from: u, reason: collision with root package name */
    public static final int f148929u = 10000;

    /* renamed from: v, reason: collision with root package name */
    public static final int f148930v = 108;

    /* renamed from: w, reason: collision with root package name */
    public static final int f148931w = 109;

    /* renamed from: x, reason: collision with root package name */
    public static final int f148932x = 110;

    /* renamed from: y, reason: collision with root package name */
    public static final int f148933y = 120;
    public double[] A;
    public long B;
    public boolean C;
    public boolean D;
    public Runnable E;

    /* renamed from: a, reason: collision with root package name */
    private iw f148934a;

    /* renamed from: z, reason: collision with root package name */
    public int f148935z;

    public jn() {
        this.B = -1L;
        this.C = false;
    }

    private long c() {
        long j3 = this.B;
        if (j3 >= 0) {
            return j3;
        }
        if (this.f148935z < 100) {
            return 0L;
        }
        return 20L;
    }

    protected boolean a() {
        return true;
    }

    private void a(iw iwVar) {
        this.f148934a = iwVar;
    }

    public boolean a(jq jqVar) {
        boolean a16 = a();
        jqVar.c(this);
        return a16;
    }

    public jn(int i3, double[] dArr) {
        this(i3, dArr, false);
    }

    public jn(int i3, double[] dArr, boolean z16) {
        this.B = -1L;
        this.C = false;
        this.f148935z = i3;
        this.A = dArr;
        this.D = z16;
    }

    public jn(Runnable runnable) {
        this.B = -1L;
        this.C = false;
        this.f148935z = 6;
        this.E = runnable;
    }

    private static void d() {
    }

    public void b() {
    }
}
