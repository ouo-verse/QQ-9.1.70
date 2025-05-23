package com.tencent.luggage.wxa.u;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public c f141983a;

    /* renamed from: b, reason: collision with root package name */
    public long f141984b;

    /* renamed from: c, reason: collision with root package name */
    public long f141985c;

    /* renamed from: d, reason: collision with root package name */
    public long f141986d;

    /* renamed from: e, reason: collision with root package name */
    public int f141987e;

    /* renamed from: f, reason: collision with root package name */
    public int f141988f;

    /* renamed from: g, reason: collision with root package name */
    public long[] f141989g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f141990h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f141991i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f141992j;

    /* renamed from: k, reason: collision with root package name */
    public long[] f141993k;

    /* renamed from: l, reason: collision with root package name */
    public boolean[] f141994l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f141995m;

    /* renamed from: n, reason: collision with root package name */
    public boolean[] f141996n;

    /* renamed from: o, reason: collision with root package name */
    public k f141997o;

    /* renamed from: p, reason: collision with root package name */
    public int f141998p;

    /* renamed from: q, reason: collision with root package name */
    public com.tencent.luggage.wxa.n0.l f141999q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f142000r;

    /* renamed from: s, reason: collision with root package name */
    public long f142001s;

    public void a() {
        this.f141987e = 0;
        this.f142001s = 0L;
        this.f141995m = false;
        this.f142000r = false;
        this.f141997o = null;
    }

    public void b(int i3) {
        com.tencent.luggage.wxa.n0.l lVar = this.f141999q;
        if (lVar == null || lVar.d() < i3) {
            this.f141999q = new com.tencent.luggage.wxa.n0.l(i3);
        }
        this.f141998p = i3;
        this.f141995m = true;
        this.f142000r = true;
    }

    public void a(int i3, int i16) {
        this.f141987e = i3;
        this.f141988f = i16;
        int[] iArr = this.f141990h;
        if (iArr == null || iArr.length < i3) {
            this.f141989g = new long[i3];
            this.f141990h = new int[i3];
        }
        int[] iArr2 = this.f141991i;
        if (iArr2 == null || iArr2.length < i16) {
            int i17 = (i16 * 125) / 100;
            this.f141991i = new int[i17];
            this.f141992j = new int[i17];
            this.f141993k = new long[i17];
            this.f141994l = new boolean[i17];
            this.f141996n = new boolean[i17];
        }
    }

    public void a(com.tencent.luggage.wxa.q.e eVar) {
        eVar.a(this.f141999q.f135088a, 0, this.f141998p);
        this.f141999q.e(0);
        this.f142000r = false;
    }

    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        lVar.a(this.f141999q.f135088a, 0, this.f141998p);
        this.f141999q.e(0);
        this.f142000r = false;
    }

    public long a(int i3) {
        return this.f141993k[i3] + this.f141992j[i3];
    }
}
