package com.tencent.luggage.wxa.ck;

import android.app.Activity;
import com.tencent.luggage.wxa.ck.g;
import com.tencent.luggage.wxa.fd.q;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {
    public static final h D = new h(true, null);
    public String A;
    public String B;
    public long C;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f123606a;

    /* renamed from: b, reason: collision with root package name */
    public final g f123607b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f123608c = false;

    /* renamed from: d, reason: collision with root package name */
    public int f123609d;

    /* renamed from: e, reason: collision with root package name */
    public String f123610e;

    /* renamed from: f, reason: collision with root package name */
    public String f123611f;

    /* renamed from: g, reason: collision with root package name */
    public String f123612g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.ic.g f123613h;

    /* renamed from: i, reason: collision with root package name */
    public int f123614i;

    /* renamed from: j, reason: collision with root package name */
    public int f123615j;

    /* renamed from: k, reason: collision with root package name */
    public int f123616k;

    /* renamed from: l, reason: collision with root package name */
    public String f123617l;

    /* renamed from: m, reason: collision with root package name */
    public String f123618m;

    /* renamed from: n, reason: collision with root package name */
    public long f123619n;

    /* renamed from: o, reason: collision with root package name */
    public long f123620o;

    /* renamed from: p, reason: collision with root package name */
    public String f123621p;

    /* renamed from: q, reason: collision with root package name */
    public int f123622q;

    /* renamed from: r, reason: collision with root package name */
    public String f123623r;

    /* renamed from: s, reason: collision with root package name */
    public long f123624s;

    /* renamed from: t, reason: collision with root package name */
    public int f123625t;

    /* renamed from: u, reason: collision with root package name */
    public int f123626u;

    /* renamed from: v, reason: collision with root package name */
    public String f123627v;

    /* renamed from: w, reason: collision with root package name */
    public int f123628w;

    /* renamed from: x, reason: collision with root package name */
    public String f123629x;

    /* renamed from: y, reason: collision with root package name */
    public int f123630y;

    /* renamed from: z, reason: collision with root package name */
    public int f123631z;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f123632a;

        public a(Object[] objArr) {
            this.f123632a = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.zj.d dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class);
            if (dVar == null) {
                w.b("MicroMsg.AppBrand.Report.kv_13536", "report get null kvReporter");
                return;
            }
            try {
                try {
                    String str = (String) this.f123632a[19];
                    w.a("MicroMsg.AppBrand.Report.kv_13536_desensitization", "original pagePathWithQuery:" + str);
                    if (!w0.c(str)) {
                        this.f123632a[19] = com.tencent.luggage.wxa.jd.a.a(str);
                    }
                } catch (Exception unused) {
                    this.f123632a[19] = "";
                    if (w0.d("").length() > 1024) {
                        this.f123632a[19] = "".substring(0, 1024);
                    }
                }
                int[] iArr = {1, 11, 13};
                for (int i3 = 0; i3 < 3; i3++) {
                    int i16 = iArr[i3];
                    String str2 = (String) this.f123632a[i16];
                    if (w0.d(str2).length() > 1024) {
                        this.f123632a[i16] = str2.substring(0, 1024);
                    }
                }
                w.d("MicroMsg.AppBrand.Report.kv_13536", "report " + Arrays.deepToString(this.f123632a));
                dVar.a(13536, com.tencent.luggage.wxa.bk.j.a(this.f123632a));
                dVar.a();
            } finally {
                String str3 = (String) this.f123632a[19];
                if (w0.d(str3).length() > 1024) {
                    this.f123632a[19] = str3.substring(0, 1024);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f123634a;

        static {
            int[] iArr = new int[e.d.values().length];
            f123634a = iArr;
            try {
                iArr[e.d.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f123634a[e.d.BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public h(boolean z16, g gVar) {
        this.f123606a = z16;
        this.f123607b = gVar;
    }

    public static h a() {
        return D;
    }

    public final void b(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.m4.b bVar) {
        g.c cVar;
        g.d dVar;
        q j06 = gVar.j0();
        if (j06 != null) {
            this.f123614i = j06.f125966l.pkgVersion;
        }
        com.tencent.luggage.wxa.rc.q i3 = bVar.i();
        if (i3 != null) {
            this.f123625t = i3.w();
        }
        this.f123624s = bVar.u1().c();
        this.f123619n = bVar.u1().b();
        this.f123620o = bVar.u1().a();
        bVar.u1();
        this.f123617l = bVar.A0();
        this.f123629x = bVar.B0();
        this.f123618m = com.tencent.luggage.wxa.bk.k.a(z.c());
        com.tencent.luggage.wxa.bk.e L1 = ((com.tencent.luggage.wxa.c5.e) gVar).L1();
        this.f123616k = L1 != null ? L1.f122986e : 0;
        g.b a16 = this.f123607b.a(bVar);
        if (a16 == null) {
            if (gVar.w0()) {
                e.d d16 = com.tencent.luggage.wxa.ic.e.d(bVar.getAppId());
                w.d("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, runtime.isFinishing=TRUE, pauseType=%s, maybe closed by user in LoadingSplash", bVar.B0(), d16);
                int i16 = b.f123634a[d16.ordinal()];
                if (i16 != 1) {
                    dVar = i16 != 2 ? null : new g.d(5);
                } else {
                    dVar = new g.d(4);
                }
                cVar = null;
            } else {
                w.b("MicroMsg.AppBrand.Report.kv_13536", "visitNode (%s) not found, maybe page switching to quickly", bVar.B0());
                dVar = null;
                cVar = null;
            }
        } else {
            g.d dVar2 = a16.f123601c;
            cVar = a16.f123602d;
            dVar = dVar2;
        }
        this.f123622q = dVar == null ? 0 : dVar.f123604a;
        this.f123623r = dVar == null ? null : dVar.f123605b;
        this.f123621p = cVar != null ? cVar.f123603a : null;
        this.f123628w = this.f123607b.a(this.f123629x) ? 1 : 0;
        com.tencent.luggage.wxa.j4.d dVar3 = (com.tencent.luggage.wxa.j4.d) gVar.S();
        if (dVar3 != null) {
            this.f123630y = dVar3.I;
            this.f123631z = dVar3.D;
        } else {
            int a17 = com.tencent.luggage.wxa.bk.d.a(this.f123612g);
            this.f123630y = a17;
            w.d("MicroMsg.AppBrand.Report.kv_13536", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(a17));
        }
        this.f123630y += 1000;
        String str = com.tencent.luggage.wxa.ic.k.b(bVar.getAppId()).f129904g;
        if (w0.c(str)) {
            return;
        }
        this.A = str;
    }

    public String toString() {
        return "kv_13536{scene=" + this.f123609d + ", sceneNote='" + this.f123610e + "', sessionId='" + this.f123611f + "', appId='" + this.f123612g + "', appVersion=" + this.f123614i + ", appState=" + this.f123615j + ", usedState=" + this.f123616k + ", pagePath='" + this.f123617l + "', networkType='" + this.f123618m + "', costTime=" + this.f123619n + ", stayTime=" + this.f123620o + ", referPagePath='" + this.f123621p + "', targetAction=" + this.f123622q + ", targetPagePath='" + this.f123623r + "', clickTimestamp=" + this.f123624s + ", publicLibVersion=" + this.f123625t + ", preScene=" + this.f123626u + ", preSceneNote='" + this.f123627v + "', isEntrance=" + this.f123628w + ", apptype=" + this.f123630y + ", systemRecentsReason=" + this.f123631z + ", referAction=" + this.A + ", manufacturerAppId=" + this.B + ", stayTimeFuncPageStart=" + this.C + '}';
    }

    public static h a(com.tencent.luggage.wxa.c5.e eVar, String str, g gVar) {
        h hVar = new h(false, gVar);
        hVar.f123611f = str;
        com.tencent.luggage.wxa.bk.e L1 = eVar.L1();
        hVar.f123609d = L1.f122984c;
        hVar.f123610e = L1.f122985d;
        hVar.f123612g = eVar.getAppId();
        hVar.f123613h = eVar;
        hVar.f123615j = eVar.S().f125811d + 1;
        hVar.f123614i = eVar.S().V;
        hVar.f123616k = L1.f122986e;
        hVar.f123626u = L1.f122982a;
        hVar.f123627v = L1.f122983b;
        return hVar;
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.m4.b bVar) {
        Activity a16 = com.tencent.luggage.wxa.bo.a.a(bVar.getContext());
        if (a16 != null && a16.isFinishing()) {
            this.f123608c = true;
        }
        b(gVar, bVar);
        b();
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.m4.b bVar, String str) {
        b(gVar, bVar);
        b();
    }

    public final void b() {
        if (this.f123606a) {
            return;
        }
        a aVar = new a(new Object[]{Integer.valueOf(this.f123609d), this.f123610e, this.f123611f, this.f123612g, Integer.valueOf(this.f123614i), Integer.valueOf(this.f123615j), Integer.valueOf(this.f123616k), this.f123617l, this.f123618m, Long.valueOf(this.f123619n), Long.valueOf(this.f123620o), this.f123621p, Integer.valueOf(this.f123622q), this.f123623r, Long.valueOf(this.f123624s), Integer.valueOf(this.f123625t), Integer.valueOf(this.f123626u), this.f123627v, Integer.valueOf(this.f123628w), this.f123629x, Integer.valueOf(this.f123630y), Integer.valueOf(this.f123631z), this.A, this.B, Long.valueOf(this.C)});
        if (this.f123608c) {
            aVar.run();
        } else {
            com.tencent.luggage.wxa.uk.j.a().d(aVar);
        }
    }
}
