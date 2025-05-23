package com.tencent.luggage.wxa.ck;

import com.tencent.luggage.wxa.bk.p;
import com.tencent.luggage.wxa.ck.g;
import com.tencent.luggage.wxa.hn.pe;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: n, reason: collision with root package name */
    public static final i f123635n = new i(true, g.f123598a);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f123636a;

    /* renamed from: b, reason: collision with root package name */
    public final g f123637b;

    /* renamed from: c, reason: collision with root package name */
    public String f123638c;

    /* renamed from: d, reason: collision with root package name */
    public String f123639d;

    /* renamed from: e, reason: collision with root package name */
    public int f123640e;

    /* renamed from: f, reason: collision with root package name */
    public String f123641f;

    /* renamed from: g, reason: collision with root package name */
    public int f123642g;

    /* renamed from: h, reason: collision with root package name */
    public String f123643h;

    /* renamed from: i, reason: collision with root package name */
    public String f123644i;

    /* renamed from: j, reason: collision with root package name */
    public int f123645j;

    /* renamed from: k, reason: collision with root package name */
    public int f123646k;

    /* renamed from: l, reason: collision with root package name */
    public String f123647l;

    /* renamed from: m, reason: collision with root package name */
    public int f123648m;

    public i(boolean z16, g gVar) {
        this.f123636a = z16;
        this.f123637b = gVar;
    }

    public static i a() {
        return f123635n;
    }

    public void b(com.tencent.luggage.wxa.m4.b bVar) {
        g.c cVar;
        this.f123644i = bVar.B0();
        g.b a16 = this.f123637b.a(bVar);
        if (com.tencent.luggage.wxa.tn.e.f141559a && a16 == null) {
            throw new IllegalStateException("mismatch stack state, call @smoothieli fix this");
        }
        this.f123647l = (a16 == null || (cVar = a16.f123602d) == null) ? null : cVar.f123603a;
        this.f123648m = this.f123637b.a(this.f123644i) ? 1 : 0;
        b();
    }

    public String toString() {
        return "kv_14004{appId='" + this.f123638c + "', sessionId='" + this.f123639d + "', scene=" + this.f123640e + ", sceneNote='" + this.f123641f + "', preScene=" + this.f123642g + ", preSceneNote='" + this.f123643h + "', pagePath='" + this.f123644i + "', usedState=" + this.f123645j + ", appState=" + this.f123646k + ", referPagePath='" + this.f123647l + "', isEntrance=" + this.f123648m + '}';
    }

    public static i a(com.tencent.luggage.wxa.c5.e eVar, String str, g gVar) {
        i iVar = new i(false, gVar);
        try {
            iVar.f123639d = str;
            iVar.f123638c = eVar.getAppId();
            com.tencent.luggage.wxa.bk.e L1 = eVar.L1();
            iVar.f123640e = L1.f122984c;
            iVar.f123641f = L1.f122985d;
            iVar.f123642g = L1.f122982a;
            iVar.f123643h = L1.f122983b;
            iVar.f123645j = L1.f122986e;
            iVar.f123646k = eVar.S().f125811d + 1;
        } catch (Exception e16) {
            w.a("MicroMsg.AppBrand.Report.kv_14004", e16, "Kv_14004 protect the npe", new Object[0]);
        }
        return iVar;
    }

    public final void b() {
        if (this.f123636a) {
            return;
        }
        this.f123644i = a(this.f123644i);
        this.f123647l = a(this.f123647l);
        pe peVar = new pe();
        peVar.f128440d = 1;
        peVar.f128441e = this.f123638c;
        peVar.f128442f = this.f123644i;
        peVar.f128443g = 0;
        peVar.f128444h = (int) w0.d();
        peVar.f128445i = 1;
        peVar.f128446j = "";
        peVar.f128447k = this.f123646k;
        peVar.f128448l = this.f123639d;
        peVar.f128449m = com.tencent.luggage.wxa.bk.k.a(z.c());
        peVar.f128450n = this.f123640e;
        peVar.f128451o = this.f123645j;
        peVar.f128452p = this.f123641f;
        peVar.f128453q = this.f123647l;
        peVar.f128454r = this.f123642g;
        peVar.f128455s = this.f123643h;
        peVar.f128456t = this.f123648m;
        p.a.a().a(peVar);
        w.d("MicroMsg.AppBrand.Report.kv_14004", "report " + toString());
    }

    public void a(com.tencent.luggage.wxa.m4.b bVar) {
        b(bVar);
    }

    public final String a(String str) {
        return w0.d(str).length() > 1024 ? str.substring(0, 1024) : str;
    }
}
