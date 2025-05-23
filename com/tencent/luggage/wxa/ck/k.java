package com.tencent.luggage.wxa.ck;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.wxa.aa.m;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.rc.q;
import com.tencent.luggage.wxa.tn.r;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k {
    public static final k A = new k(true);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f123650a;

    /* renamed from: e, reason: collision with root package name */
    public int f123654e;

    /* renamed from: f, reason: collision with root package name */
    public String f123655f;

    /* renamed from: g, reason: collision with root package name */
    public String f123656g;

    /* renamed from: h, reason: collision with root package name */
    public String f123657h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.c5.e f123658i;

    /* renamed from: j, reason: collision with root package name */
    public int f123659j;

    /* renamed from: k, reason: collision with root package name */
    public int f123660k;

    /* renamed from: l, reason: collision with root package name */
    public int f123661l;

    /* renamed from: m, reason: collision with root package name */
    public String f123662m;

    /* renamed from: n, reason: collision with root package name */
    public String f123663n;

    /* renamed from: o, reason: collision with root package name */
    public String f123664o;

    /* renamed from: p, reason: collision with root package name */
    public String f123665p;

    /* renamed from: q, reason: collision with root package name */
    public int f123666q;

    /* renamed from: r, reason: collision with root package name */
    public String f123667r;

    /* renamed from: s, reason: collision with root package name */
    public long f123668s;

    /* renamed from: t, reason: collision with root package name */
    public int f123669t;

    /* renamed from: u, reason: collision with root package name */
    public int f123670u;

    /* renamed from: v, reason: collision with root package name */
    public String f123671v;

    /* renamed from: w, reason: collision with root package name */
    public int f123672w;

    /* renamed from: x, reason: collision with root package name */
    public String f123673x;

    /* renamed from: y, reason: collision with root package name */
    public int f123674y;

    /* renamed from: b, reason: collision with root package name */
    public String f123651b = "";

    /* renamed from: c, reason: collision with root package name */
    public final LinkedList f123652c = new LinkedList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f123653d = false;

    /* renamed from: z, reason: collision with root package name */
    public boolean f123675z = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f123676a;

        public a(Object[] objArr) {
            this.f123676a = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a16;
            com.tencent.luggage.wxa.zj.d dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
            if (dVar == null) {
                w.b("MicroMsg.AppBrand.Report.kv_14992", "report get null kvReporter");
                return;
            }
            try {
                String str = (String) this.f123676a[18];
                if (!w0.c(str)) {
                    int indexOf = str.indexOf(63);
                    if (indexOf < 0) {
                        a16 = "";
                    } else {
                        a16 = m.a(str.substring(indexOf + 1, str.length()));
                    }
                    this.f123676a[18] = a16;
                }
            } catch (Exception unused) {
                this.f123676a[18] = "";
            }
            dVar.a(14992, com.tencent.luggage.wxa.bk.j.a(this.f123676a));
            dVar.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f123678a;

        static {
            int[] iArr = new int[e.d.values().length];
            f123678a = iArr;
            try {
                iArr[e.d.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f123678a[e.d.HANG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f123678a[e.d.LAUNCH_MINI_PROGRAM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public k(boolean z16) {
        this.f123650a = z16;
    }

    public static k a() {
        return A;
    }

    public void b() {
        this.f123675z = true;
    }

    public final void c() {
        if (this.f123650a) {
            return;
        }
        w.d("MicroMsg.AppBrand.Report.kv_14992", "report " + toString());
        a aVar = new a(new Object[]{Integer.valueOf(this.f123654e), this.f123655f, this.f123656g, this.f123657h, Integer.valueOf(this.f123659j), Integer.valueOf(this.f123660k), Integer.valueOf(this.f123661l), this.f123662m, this.f123663n, this.f123664o, this.f123665p, Integer.valueOf(this.f123666q), this.f123667r, Long.valueOf(this.f123668s), Integer.valueOf(this.f123669t), Integer.valueOf(this.f123670u), this.f123671v, Integer.valueOf(this.f123672w), this.f123673x, Integer.valueOf(this.f123674y)});
        if (this.f123653d) {
            aVar.run();
        } else {
            com.tencent.luggage.wxa.uk.j.a().d(aVar);
        }
    }

    public String toString() {
        return "kv_14992{scene=" + this.f123654e + ", sceneNote='" + this.f123655f + "', sessionId='" + this.f123656g + "', appId='" + this.f123657h + "', appVersion=" + this.f123659j + ", appState=" + this.f123660k + ", usedState=" + this.f123661l + ", pagePath='" + this.f123662m + "', currentUrl='" + this.f123663n + "', networkType='" + this.f123664o + "', referPagePath='" + this.f123665p + "', targetAction=" + this.f123666q + ", targetPagePath='" + this.f123667r + "', clickTimestamp=" + this.f123668s + ", publicLibVersion=" + this.f123669t + ", preScene=" + this.f123670u + ", preSceneNote='" + this.f123671v + "', isEntrance=" + this.f123672w + ", apptype=" + this.f123674y + '}';
    }

    public static k a(com.tencent.luggage.wxa.c5.e eVar, String str, LinkedList linkedList) {
        k kVar = new k(false);
        kVar.f123656g = str;
        com.tencent.luggage.wxa.bk.e L1 = eVar.L1();
        kVar.f123654e = L1.f122984c;
        kVar.f123655f = L1.f122985d;
        kVar.f123657h = eVar.getAppId();
        kVar.f123658i = eVar;
        if (eVar.j0() == null) {
            kVar.f123660k = eVar.l0() + 1;
            kVar.f123659j = eVar.S().V;
        } else {
            kVar.f123660k = eVar.j0().a() + 1;
            kVar.f123659j = eVar.j0().f125966l.pkgVersion;
        }
        kVar.f123661l = L1.f122986e;
        kVar.f123670u = L1.f122982a;
        kVar.f123671v = L1.f122983b;
        if (linkedList != null) {
            kVar.f123652c.addAll(linkedList);
        }
        return kVar;
    }

    public final void b(com.tencent.luggage.wxa.m4.b bVar) {
        com.tencent.luggage.wxa.lh.a q16 = bVar.q1();
        if (q16 == null) {
            return;
        }
        a(bVar, q16);
        c();
    }

    public void a(com.tencent.luggage.wxa.m4.b bVar) {
        String className;
        this.f123665p = (String) this.f123652c.peekFirst();
        this.f123667r = null;
        int i3 = b.f123678a[com.tencent.luggage.wxa.ic.e.d(this.f123657h).ordinal()];
        if (i3 == 1) {
            this.f123666q = 3;
        } else if (i3 == 2) {
            this.f123666q = 6;
        } else if (i3 != 3) {
            Intent c16 = this.f123658i.Y().getReporter().c();
            if (c16 != null) {
                if (c16.getComponent() == null) {
                    w.b("MicroMsg.AppBrand.Report.kv_14992", "onBackground, intent %s, get null cmp name", c16);
                    className = "";
                } else {
                    className = c16.getComponent().getClassName();
                }
                this.f123666q = 8;
                String b16 = w0.b(r.a(c16, "appbrand_report_key_target_activity"), className);
                this.f123667r = b16;
                a(b16);
            } else {
                this.f123666q = 7;
            }
        }
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(bVar.getContext());
        if (a16 != null && a16.isFinishing()) {
            this.f123653d = true;
        }
        b(bVar);
    }

    public void a(com.tencent.luggage.wxa.m4.b bVar, String str) {
        this.f123665p = (String) this.f123652c.peekFirst();
        this.f123666q = 2;
        this.f123667r = str;
        this.f123652c.push(bVar.A0());
        this.f123651b = bVar.A0();
        b(bVar);
    }

    public void a(com.tencent.luggage.wxa.m4.b bVar, String str, String str2) {
        this.f123665p = (String) this.f123652c.peekFirst();
        this.f123666q = 2;
        this.f123667r = str2;
        this.f123652c.push(str);
        b(bVar);
    }

    public void a(com.tencent.luggage.wxa.m4.b bVar, boolean z16) {
        this.f123666q = z16 ? 1 : 7;
        String str = (String) this.f123652c.pollFirst();
        this.f123667r = str;
        this.f123665p = str;
        if (!z16) {
            this.f123667r = this.f123651b;
        }
        b(bVar);
    }

    public final void a(String str) {
        this.f123652c.pollFirst();
        this.f123652c.push(w0.d(str));
    }

    public final void a(com.tencent.luggage.wxa.m4.b bVar, com.tencent.luggage.wxa.lh.a aVar) {
        com.tencent.luggage.wxa.j4.g j06 = bVar.getRuntime().j0();
        if (j06 != null) {
            this.f123659j = j06.f125966l.pkgVersion;
        }
        q i3 = bVar.i();
        if (i3 != null) {
            this.f123669t = i3.w();
        }
        this.f123668s = System.currentTimeMillis();
        String url = aVar.getUrl();
        if (url == null) {
            url = "";
        }
        this.f123663n = m.a(url);
        this.f123662m = bVar.A0();
        this.f123673x = bVar.B0();
        this.f123664o = com.tencent.luggage.wxa.bk.k.a(z.c());
        this.f123672w = this.f123675z ? 1 : 0;
        this.f123675z = false;
        com.tencent.luggage.wxa.c5.e runtime = bVar.getRuntime();
        com.tencent.luggage.wxa.j4.d S = runtime == null ? null : runtime.S();
        if (S != null) {
            this.f123674y = S.I;
        } else {
            int a16 = com.tencent.luggage.wxa.bk.d.a(this.f123657h);
            this.f123674y = a16;
            w.d("MicroMsg.AppBrand.Report.kv_14992", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(a16));
        }
        this.f123674y += 1000;
    }
}
