package com.tencent.luggage.wxa.ck;

import android.webkit.WebResourceRequest;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l {

    /* renamed from: p, reason: collision with root package name */
    public static final l f123679p = new l(true);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f123680a;

    /* renamed from: b, reason: collision with root package name */
    public String f123681b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.c5.e f123682c;

    /* renamed from: d, reason: collision with root package name */
    public int f123683d;

    /* renamed from: e, reason: collision with root package name */
    public int f123684e;

    /* renamed from: f, reason: collision with root package name */
    public int f123685f;

    /* renamed from: g, reason: collision with root package name */
    public String f123686g;

    /* renamed from: h, reason: collision with root package name */
    public String f123687h;

    /* renamed from: i, reason: collision with root package name */
    public String f123688i;

    /* renamed from: j, reason: collision with root package name */
    public String f123689j;

    /* renamed from: k, reason: collision with root package name */
    public int f123690k;

    /* renamed from: l, reason: collision with root package name */
    public int f123691l;

    /* renamed from: m, reason: collision with root package name */
    public int f123692m;

    /* renamed from: n, reason: collision with root package name */
    public int f123693n;

    /* renamed from: o, reason: collision with root package name */
    public String f123694o;

    public l(boolean z16) {
        this.f123680a = z16;
    }

    public static l a(com.tencent.luggage.wxa.c5.e eVar) {
        l lVar = new l(false);
        lVar.f123681b = eVar.getAppId();
        lVar.f123682c = eVar;
        if (eVar.j0() == null) {
            lVar.f123684e = eVar.l0() + 1;
            lVar.f123683d = eVar.S().V;
        } else {
            lVar.f123684e = eVar.j0().a() + 1;
            lVar.f123683d = eVar.j0().f125966l.pkgVersion;
        }
        return lVar;
    }

    public String toString() {
        return "kv_19358{appId='" + this.f123681b + "', appVersion=" + this.f123683d + ", appState=" + this.f123684e + ", appType=" + this.f123685f + ", networkType='" + this.f123686g + "', pageUrl='" + this.f123687h + "', url='" + this.f123688i + "', method='" + this.f123689j + "', sentSize=" + this.f123690k + ", receivedSize=" + this.f123691l + ", statusCode=" + this.f123692m + ", visitType=" + this.f123693n + ", referer='" + this.f123694o + "'}";
    }

    public void a(com.tencent.luggage.wxa.m4.b bVar, String str, WebResourceRequest webResourceRequest) {
        if (this.f123680a || webResourceRequest == null) {
            return;
        }
        this.f123687h = str;
        this.f123688i = webResourceRequest.getUrl().toString();
        this.f123689j = webResourceRequest.getMethod();
        this.f123694o = webResourceRequest.getRequestHeaders().get("Referer");
        a(bVar);
        a();
    }

    public final void a(com.tencent.luggage.wxa.m4.b bVar) {
        com.tencent.luggage.wxa.j4.g j06 = bVar.getRuntime().j0();
        if (j06 != null) {
            this.f123683d = j06.f125966l.pkgVersion;
        }
        this.f123686g = com.tencent.luggage.wxa.bk.k.a(z.c());
        com.tencent.luggage.wxa.c5.e runtime = bVar.getRuntime();
        com.tencent.luggage.wxa.j4.d S = runtime == null ? null : runtime.S();
        if (S != null) {
            this.f123685f = S.I;
        } else {
            int a16 = com.tencent.luggage.wxa.bk.d.a(this.f123681b);
            this.f123685f = a16;
            w.d("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(a16));
        }
        this.f123685f += 1000;
    }

    public final void a() {
        if (this.f123680a) {
            return;
        }
        w.d("MicroMsg.AppBrand.Report.kv_19358", "report " + toString());
        ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(19358, com.tencent.luggage.wxa.bk.j.a(this.f123681b, Integer.valueOf(this.f123683d), Integer.valueOf(this.f123684e), Integer.valueOf(this.f123685f), this.f123686g, this.f123687h, this.f123688i, this.f123689j, Integer.valueOf(this.f123690k), Integer.valueOf(this.f123691l), Integer.valueOf(this.f123692m), Integer.valueOf(this.f123693n), this.f123694o));
    }
}
