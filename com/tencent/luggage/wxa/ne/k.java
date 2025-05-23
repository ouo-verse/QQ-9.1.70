package com.tencent.luggage.wxa.ne;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k {

    /* renamed from: e, reason: collision with root package name */
    public static final k f135745e = new k(0, "", com.tencent.luggage.wxa.af.e.f121305a);

    /* renamed from: f, reason: collision with root package name */
    public static final k f135746f = new k(-1, "fail:internal error", com.tencent.luggage.wxa.af.b.V);

    /* renamed from: g, reason: collision with root package name */
    public static final k f135747g;

    /* renamed from: h, reason: collision with root package name */
    public static final k f135748h;

    /* renamed from: i, reason: collision with root package name */
    public static final k f135749i;

    /* renamed from: j, reason: collision with root package name */
    public static final k f135750j;

    /* renamed from: k, reason: collision with root package name */
    public static final k f135751k;

    /* renamed from: l, reason: collision with root package name */
    public static final k f135752l;

    /* renamed from: m, reason: collision with root package name */
    public static final k f135753m;

    /* renamed from: n, reason: collision with root package name */
    public static final k f135754n;

    /* renamed from: o, reason: collision with root package name */
    public static final k f135755o;

    /* renamed from: p, reason: collision with root package name */
    public static final k f135756p;

    /* renamed from: q, reason: collision with root package name */
    public static final k f135757q;

    /* renamed from: r, reason: collision with root package name */
    public static final k f135758r;

    /* renamed from: s, reason: collision with root package name */
    public static final k f135759s;

    /* renamed from: t, reason: collision with root package name */
    public static final k f135760t;

    /* renamed from: u, reason: collision with root package name */
    public static final k f135761u;

    /* renamed from: v, reason: collision with root package name */
    public static final k f135762v;

    /* renamed from: w, reason: collision with root package name */
    public static final k f135763w;

    /* renamed from: x, reason: collision with root package name */
    public static final k f135764x;

    /* renamed from: y, reason: collision with root package name */
    public static final k f135765y;

    /* renamed from: z, reason: collision with root package name */
    public static final k f135766z;

    /* renamed from: a, reason: collision with root package name */
    public int f135767a;

    /* renamed from: b, reason: collision with root package name */
    public String f135768b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.af.c f135769c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f135770d;

    static {
        com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.b.f121231d;
        f135747g = new k(-1, "fail:internal error", cVar);
        f135748h = new k(10000, "fail:not init", com.tencent.luggage.wxa.af.b.f121225a);
        f135749i = new k(10001, "fail:not available", com.tencent.luggage.wxa.af.b.f121227b);
        f135750j = new k(10004, "fail:no service", com.tencent.luggage.wxa.af.b.f121229c);
        f135751k = new k(10005, "fail:no characteristic", com.tencent.luggage.wxa.af.b.X);
        f135752l = new k(10006, "fail:no connection", com.tencent.luggage.wxa.af.b.Y);
        com.tencent.luggage.wxa.af.c cVar2 = com.tencent.luggage.wxa.af.b.Z;
        f135753m = new k(10007, "fail:property not support", cVar2);
        f135754n = new k(10008, "fail:system error", cVar);
        f135755o = new k(10009, "fail:system not support", com.tencent.luggage.wxa.af.b.f121233e);
        f135756p = new k(10008, "fail:no descriptor", cVar);
        f135757q = new k(10008, "fail:fail to set descriptor", cVar);
        f135758r = new k(10008, "fail:fail to write descriptor", cVar);
        f135759s = new k(10012, "fail:operate time out", com.tencent.luggage.wxa.af.b.f121226a0);
        f135760t = new k(-1, "fail:already connect", com.tencent.luggage.wxa.af.b.f121230c0);
        f135761u = new k(10013, "fail:invalid data", com.tencent.luggage.wxa.af.e.f121315k);
        f135762v = new k(10008, "fail:not found service", cVar);
        f135763w = new k(10014, "fail:need pin", com.tencent.luggage.wxa.af.b.f121240h0);
        f135764x = new k(com.tencent.luggage.wxa.af.b.f121232d0);
        f135765y = new k(com.tencent.luggage.wxa.af.b.f121234e0);
        f135766z = new k(10007, "fail:The writeType is not supported", cVar2);
    }

    public k(com.tencent.luggage.wxa.af.c cVar) {
        this(-1, cVar.f121278b, cVar, null);
    }

    public static k a(Object obj) {
        return new k(-1, "fail:internal error", com.tencent.luggage.wxa.af.b.f121231d, obj);
    }

    public static k b(Object obj) {
        return new k(0, "", com.tencent.luggage.wxa.af.e.f121305a, obj);
    }

    public static k c(String str) {
        return new k(10008, "fail:system error, " + str, com.tencent.luggage.wxa.af.b.f121231d);
    }

    public String toString() {
        return "Result{errCode=" + this.f135767a + ", errMsg='" + this.f135768b + "', errorInfo=" + this.f135769c + ", retObj=" + this.f135770d + '}';
    }

    public k(int i3, String str, com.tencent.luggage.wxa.af.c cVar) {
        this(i3, str, cVar, null);
    }

    public static k a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new k(-1, "fail:system error", com.tencent.luggage.wxa.af.b.f121231d);
        }
        return new k(-1, "fail:system error, " + str, com.tencent.luggage.wxa.af.b.f121231d);
    }

    public static k b(String str) {
        return new k(10008, "fail:not found service, " + str, com.tencent.luggage.wxa.af.b.f121231d);
    }

    public k(int i3, String str, com.tencent.luggage.wxa.af.c cVar, Object obj) {
        this.f135767a = i3;
        this.f135768b = str;
        this.f135769c = cVar;
        this.f135770d = obj;
    }
}
