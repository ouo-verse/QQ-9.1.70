package com.tencent.luggage.wxa.tj;

import android.text.TextUtils;
import android.view.View;
import com.tencent.luggage.wxa.fd.q;
import com.tencent.luggage.wxa.hn.c5;
import com.tencent.luggage.wxa.hn.fg;
import com.tencent.luggage.wxa.hn.gf;
import com.tencent.luggage.wxa.hn.m9;
import com.tencent.luggage.wxa.hn.o5;
import com.tencent.luggage.wxa.hn.p5;
import com.tencent.luggage.wxa.hn.pb;
import com.tencent.luggage.wxa.hn.q5;
import com.tencent.luggage.wxa.hn.r5;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ml.j;
import com.tencent.luggage.wxa.rj.p;
import com.tencent.luggage.wxa.tj.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.d0;
import com.tencent.luggage.wxa.xo.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public static com.tencent.luggage.wxa.tj.c f141432d;

    /* renamed from: e, reason: collision with root package name */
    public static final i f141433e = i.f141475a;

    /* renamed from: f, reason: collision with root package name */
    public static final g f141434f = new g(null);

    /* renamed from: a, reason: collision with root package name */
    public final j f141435a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.tj.e f141436b;

    /* renamed from: c, reason: collision with root package name */
    public final int f141437c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.tj.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6761b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f141440b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f141441c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f141442d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f141443e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f141444f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ k f141445g;

        public C6761b(int i3, String str, String str2, String str3, boolean z16, k kVar) {
            this.f141440b = i3;
            this.f141441c = str;
            this.f141442d = str2;
            this.f141443e = str3;
            this.f141444f = z16;
            this.f141445g = kVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(p5 p5Var) {
            if (p5Var.f128399e.f127384d == 0 && 1 == this.f141440b) {
                w.d("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s  scope=%s", this.f141441c, this.f141442d, this.f141443e);
                if (this.f141444f) {
                    b.f141434f.b(this.f141441c, this.f141442d);
                }
            }
            this.f141445g.a();
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f141447a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f141448b;

        public c(String str, String str2) {
            this.f141447a = str;
            this.f141448b = str2;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public void a(Object obj) {
            String obj2;
            com.tencent.luggage.wxa.tj.c cVar = b.f141432d;
            if ((obj instanceof com.tencent.luggage.wxa.bj.a) && cVar != null && cVar.a(b.this.f141436b, b.this.f141435a, (com.tencent.luggage.wxa.bj.a) obj)) {
                return;
            }
            b.f141434f.a(this.f141447a, this.f141448b);
            j jVar = b.this.f141435a;
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[1];
            if (obj == null) {
                obj2 = "";
            } else {
                obj2 = obj.toString();
            }
            objArr[0] = obj2;
            jVar.a(String.format(locale, "cgi failed %s", objArr));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements e.c {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(Void r16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.bj.c f141451b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f141452c;

        public e(com.tencent.luggage.wxa.bj.c cVar, String str) {
            this.f141451b = cVar;
            this.f141452c = str;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call(r5 r5Var) {
            try {
                b bVar = b.this;
                bVar.a(this.f141451b, bVar.a(r5Var));
                return null;
            } catch (Exception e16) {
                w.b("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth appId = %s, e = %s", this.f141452c, e16);
                com.tencent.luggage.wxa.xo.h.a().a(e16);
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f141454a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f141455b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f141456c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ r5 f141457d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f141458e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f141459f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.bj.c f141460g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f141461h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ m9 f141462i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f141463j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f141464k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ boolean f141465l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f141466m;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements d.c {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.tj.b$f$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C6762a implements k {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ boolean f141468a;

                public C6762a(boolean z16) {
                    this.f141468a = z16;
                }

                @Override // com.tencent.luggage.wxa.tj.b.k
                public void a() {
                    if (this.f141468a) {
                        b.this.f141435a.a();
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.tj.b$f$a$b, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C6763b implements k {
                public C6763b() {
                }

                @Override // com.tencent.luggage.wxa.tj.b.k
                public void a() {
                    b.this.f141435a.a(null);
                }
            }

            public a() {
            }

            @Override // com.tencent.luggage.wxa.tj.d.c
            public void a(int i3, ArrayList arrayList, int i16, boolean z16) {
                boolean z17;
                String str;
                f fVar = f.this;
                String str2 = fVar.f141456c;
                if (fVar.f141457d.f128576f.size() > 1) {
                    if (com.tencent.luggage.wxa.h6.c.a(arrayList).size() > 0) {
                        str = (String) arrayList.get(0);
                    } else {
                        str = f.this.f141456c;
                    }
                    str2 = str;
                    f fVar2 = f.this;
                    w.d("MicroMsg.AppBrandJsApiUserAuth", "response.jsapi_scope %s, scopeAcc %s, appId %s, api %s", fVar2.f141457d.f128584n, str2, fVar2.f141458e, fVar2.f141459f);
                    f fVar3 = f.this;
                    String str3 = fVar3.f141457d.f128584n;
                    if (str3 == null) {
                        b.this.f141435a.onCancel();
                        return;
                    }
                    z17 = str3.equals(str2);
                } else {
                    z17 = true;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            g gVar = b.f141434f;
                            f fVar4 = f.this;
                            gVar.a(fVar4.f141458e, fVar4.f141459f);
                            f fVar5 = f.this;
                            w.d("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user cancel, appId %s, api %s", fVar5.f141458e, fVar5.f141459f);
                            b.this.f141435a.onCancel();
                            return;
                        }
                        return;
                    }
                    f fVar6 = f.this;
                    b.this.a(fVar6.f141460g, str2, 2, z17, z16, new C6763b());
                    g gVar2 = b.f141434f;
                    f fVar7 = f.this;
                    gVar2.a(fVar7.f141458e, fVar7.f141459f);
                    f fVar8 = f.this;
                    w.d("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user deny, appId %s, api %s", fVar8.f141458e, fVar8.f141459f);
                    return;
                }
                f fVar9 = f.this;
                b.this.a(fVar9.f141460g, str2, 1, z17, z16, new C6762a(z17));
                if (!z17) {
                    f fVar10 = f.this;
                    w.d("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth appId %s, api %s , target scope:%s, accept scope:%s, deny!", fVar10.f141458e, fVar10.f141459f, fVar10.f141456c, str2);
                    b.this.f141435a.a(null);
                    return;
                }
                if (f.this.f141456c.equals("scope.voip")) {
                    com.tencent.luggage.wxa.tj.g.a(f.this.f141455b);
                }
                g gVar3 = b.f141434f;
                f fVar11 = f.this;
                gVar3.b(fVar11.f141458e, fVar11.f141459f);
                f fVar12 = f.this;
                w.d("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, appId %s, api %s", fVar12.f141458e, fVar12.f141459f);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.tj.b$f$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class ViewOnClickListenerC6764b implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.tj.d f141471a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f141472b;

            public ViewOnClickListenerC6764b(com.tencent.luggage.wxa.tj.d dVar, String str) {
                this.f141471a = dVar;
                this.f141472b = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.tencent.luggage.wxa.tj.d dVar = this.f141471a;
                com.tencent.luggage.wxa.ic.d dVar2 = f.this.f141455b;
                dVar.a(dVar2, this.f141472b, (d0) dVar2.b(d0.class)).b(f.this.f141455b);
            }
        }

        public f(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ic.d dVar, String str, r5 r5Var, String str2, String str3, com.tencent.luggage.wxa.bj.c cVar, String str4, m9 m9Var, String str5, String str6, boolean z16, String str7) {
            this.f141454a = gVar;
            this.f141455b = dVar;
            this.f141456c = str;
            this.f141457d = r5Var;
            this.f141458e = str2;
            this.f141459f = str3;
            this.f141460g = cVar;
            this.f141461h = str4;
            this.f141462i = m9Var;
            this.f141463j = str5;
            this.f141464k = str6;
            this.f141465l = z16;
            this.f141466m = str7;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            boolean z16;
            String str2;
            if (this.f141454a.Y() == null) {
                return;
            }
            com.tencent.luggage.wxa.tj.d a16 = d.a.a(this.f141455b, new a(), this.f141457d.f128576f);
            a16.b(this.f141454a.j0().f125955a);
            a16.k(this.f141461h);
            a16.h(this.f141462i.f128169e);
            a16.l(this.f141463j);
            a16.j(this.f141464k);
            a16.a(this.f141457d.f128578h);
            LinkedList linkedList = this.f141457d.f128576f;
            if (linkedList != null && linkedList.size() > 0) {
                str = ((m9) this.f141457d.f128576f.get(0)).f128173i;
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                a16.g(str);
            } else if (this.f141465l) {
                a16.g(this.f141466m);
            }
            if (b.this.a(this.f141454a)) {
                a16.a(false);
            } else {
                com.tencent.luggage.wxa.hn.i iVar = this.f141457d.f128582l;
                if (iVar == null) {
                    z16 = false;
                } else {
                    z16 = iVar.f127822d;
                }
                if (iVar == null) {
                    str2 = null;
                } else {
                    str2 = iVar.f127823e;
                }
                if (z16 && !TextUtils.isEmpty(str2)) {
                    a16.a(true);
                    a16.a(new ViewOnClickListenerC6764b(a16, str2));
                } else {
                    a16.a(false);
                }
            }
            if (this.f141457d.f128576f.size() > 1) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new j.a(1, ((m9) this.f141457d.f128576f.get(0)).f128174j, ((m9) this.f141457d.f128576f.get(0)).f128168d, true));
                for (int i3 = 1; i3 < this.f141457d.f128576f.size(); i3++) {
                    arrayList.add(new j.a(1, ((m9) this.f141457d.f128576f.get(i3)).f128174j, ((m9) this.f141457d.f128576f.get(i3)).f128168d, false));
                }
                a16.a(8);
                a16.a(arrayList);
            }
            pb pbVar = this.f141457d.f128585o;
            if (pbVar != null && pbVar.f128430d && !TextUtils.isEmpty(pbVar.f128431e)) {
                a16.c(this.f141457d.f128585o.f128431e);
                a16.a((d0) this.f141455b.b(d0.class));
            }
            a16.b(this.f141455b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends com.tencent.luggage.wxa.tk.h {
        public g() {
        }

        public void a(String str, String str2) {
            super.c(str, str2);
        }

        public /* synthetic */ g(a aVar) {
            this();
        }

        public void a(String str) {
            super.b(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class h implements j {

        /* renamed from: a, reason: collision with root package name */
        public final j f141474a;

        public h(j jVar) {
            this.f141474a = jVar;
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public /* synthetic */ void a(String str) {
            e41.a.a(this, str);
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public void onCancel() {
            j jVar = this.f141474a;
            if (jVar != null) {
                jVar.onCancel();
            }
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public void a() {
            j jVar = this.f141474a;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // com.tencent.luggage.wxa.tj.b.j
        public void a(int i3, String str) {
            j jVar = this.f141474a;
            if (jVar != null) {
                jVar.a(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface i {

        /* renamed from: a, reason: collision with root package name */
        public static final i f141475a = new a();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements i {
            @Override // com.tencent.luggage.wxa.tj.b.i
            public b a(j jVar, com.tencent.luggage.wxa.tj.e eVar) {
                return new b(jVar, eVar);
            }
        }

        b a(j jVar, com.tencent.luggage.wxa.tj.e eVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface j {
        void a();

        void a(int i3, String str);

        void a(String str);

        void onCancel();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface k {
        void a();
    }

    public b(j jVar, com.tencent.luggage.wxa.tj.e eVar) {
        this.f141435a = new a(jVar, eVar);
        this.f141436b = eVar;
        this.f141437c = eVar.d().getRuntime().l0();
    }

    public static void d() {
        f141434f.a();
    }

    public r5 a(r5 r5Var) {
        return r5Var;
    }

    public final void c() {
        com.tencent.luggage.wxa.bj.c cVar;
        com.tencent.luggage.wxa.ic.d d16 = this.f141436b.d();
        String appId = d16.getAppId();
        String a16 = this.f141436b.a();
        if (a(d16)) {
            cVar = com.tencent.luggage.wxa.cj.a.a(d16);
        } else {
            com.tencent.luggage.wxa.bj.c cVar2 = (com.tencent.luggage.wxa.bj.c) d16.b(com.tencent.luggage.wxa.bj.c.class);
            Objects.requireNonNull(cVar2);
            cVar = cVar2;
        }
        com.tencent.luggage.wxa.ic.g runtime = d16.getRuntime();
        w.d("MicroMsg.AppBrandJsApiUserAuth", "checkAuth appId = %s,mApi = %s", appId, a16);
        q5 q5Var = new q5();
        q5Var.f128498e = appId;
        q5Var.f128502i = a16;
        q5Var.f128500g = this.f141437c;
        q5Var.f128501h = new gf();
        q5Var.f128504k = d16.getRuntime().d(a16);
        if (!StringUtils.isEmpty(StringUtils.trim(this.f141436b.e()))) {
            try {
                JSONObject jSONObject = new JSONObject(this.f141436b.e());
                fg fgVar = new fg();
                q5Var.f128503j = fgVar;
                fgVar.f127640d = jSONObject.optString("appId", null);
                com.tencent.luggage.wxa.j4.f fVar = (com.tencent.luggage.wxa.j4.f) runtime.a(com.tencent.luggage.wxa.j4.f.class, false);
                if (fVar != null) {
                    fg fgVar2 = q5Var.f128503j;
                    fgVar2.f127642f = fVar.a(fgVar2.f127640d);
                }
            } catch (Exception unused) {
            }
        }
        if (runtime instanceof com.tencent.luggage.wxa.c5.e) {
            q5Var.f128501h.f127719e = ((com.tencent.luggage.wxa.c5.e) runtime).L1().f122984c;
        }
        if (d16 instanceof l) {
            q5Var.f128501h.f127720f = 1;
        } else if (d16 instanceof v) {
            q5Var.f128501h.f127720f = 2;
        }
        cVar.b("/cgi-bin/mmbiz-bin/js-authorize", appId, q5Var, r5.class).b(new e(cVar, appId)).a(new d()).a(new c(appId, a16));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends h {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.tj.e f141438b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar, com.tencent.luggage.wxa.tj.e eVar) {
            super(jVar);
            this.f141438b = eVar;
        }

        @Override // com.tencent.luggage.wxa.tj.b.h, com.tencent.luggage.wxa.tj.b.j
        public void a() {
            super.a();
            w.d("MicroMsg.AppBrandJsApiUserAuth", "onConfirm " + b());
        }

        public final String b() {
            com.tencent.luggage.wxa.ic.d d16 = this.f141438b.d();
            return String.format(Locale.ENGLISH, "component[%s %d], api[%s] callbackId[%d]", d16.getAppId(), Integer.valueOf(d16.getComponentId()), this.f141438b.a(), Integer.valueOf(this.f141438b.c()));
        }

        @Override // com.tencent.luggage.wxa.tj.b.h, com.tencent.luggage.wxa.tj.b.j
        public void onCancel() {
            super.onCancel();
            w.d("MicroMsg.AppBrandJsApiUserAuth", "onCancel " + b());
        }

        @Override // com.tencent.luggage.wxa.tj.b.h, com.tencent.luggage.wxa.tj.b.j
        public void a(int i3, String str) {
            super.a(i3, str);
            w.d("MicroMsg.AppBrandJsApiUserAuth", "onDeny errno[%d] errMsg[%s] %s", Integer.valueOf(i3), str, b());
        }
    }

    public static void a(com.tencent.luggage.wxa.tj.c cVar) {
        f141432d = cVar;
    }

    public final void a(com.tencent.luggage.wxa.bj.c cVar, String str, int i3, boolean z16, boolean z17, k kVar) {
        o5 o5Var = new o5();
        o5Var.f128322e = this.f141436b.d().getAppId();
        o5Var.f128323f.add(str);
        o5Var.f128324g = i3;
        o5Var.f128327j = z17;
        String appId = this.f141436b.d().getAppId();
        cVar.b("/cgi-bin/mmbiz-bin/js-authorize-confirm", appId, o5Var, p5.class).b(new C6761b(i3, appId, this.f141436b.a(), str, z16, kVar));
    }

    public final boolean a(com.tencent.luggage.wxa.ic.d dVar) {
        if (dVar.getRuntime() instanceof com.tencent.luggage.wxa.c5.e) {
            return ((com.tencent.luggage.wxa.c5.e) dVar.getRuntime()).N1().a();
        }
        return false;
    }

    public boolean a(com.tencent.luggage.wxa.ic.g gVar) {
        if (gVar == null) {
            return false;
        }
        com.tencent.luggage.wxa.fd.i S = gVar.S();
        if (S instanceof com.tencent.luggage.wxa.j4.d) {
            return ((com.tencent.luggage.wxa.j4.d) S).f130813y0.a();
        }
        return false;
    }

    public final void a(com.tencent.luggage.wxa.bj.c cVar, r5 r5Var) {
        com.tencent.luggage.wxa.ic.d d16 = this.f141436b.d();
        String appId = d16.getAppId();
        String a16 = this.f141436b.a();
        com.tencent.luggage.wxa.ic.g runtime = d16.getRuntime();
        w.d("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, appId %s, api %s, checkAuth Response.errcode %d", appId, a16, Integer.valueOf(r5Var.f128575e.f127384d));
        c5 c5Var = r5Var.f128575e;
        int i3 = c5Var.f127384d;
        if (i3 == 0) {
            f141434f.b(appId, a16);
            this.f141435a.a();
            return;
        }
        if (i3 != -12000) {
            int i16 = c5Var.f127386f;
            if (i16 != 0) {
                this.f141435a.a(i16, c5Var.f127385e);
                return;
            } else {
                this.f141435a.a(c5Var.f127385e);
                return;
            }
        }
        m9 m9Var = (m9) r5Var.f128576f.get(0);
        if (m9Var == null) {
            this.f141435a.a(null);
            return;
        }
        if ((runtime instanceof com.tencent.luggage.wxa.c5.e) && ((com.tencent.luggage.wxa.c5.e) runtime).x1()) {
            w.d("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, is headless mode");
            this.f141435a.onCancel();
            return;
        }
        String str = r5Var.f128581k;
        String str2 = r5Var.f128580j;
        String str3 = r5Var.f128579i;
        String str4 = m9Var.f128168d;
        boolean a17 = p.a(str4, runtime.j0());
        String a18 = p.a(str4, runtime);
        if (a17 && TextUtils.isEmpty(a18)) {
            this.f141435a.a("fail:require permission desc");
            w.d("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, error = fail:require permission desc");
        } else {
            d16.a(new f(runtime, d16, str4, r5Var, appId, a16, cVar, str, m9Var, str3, str2, a17, a18));
        }
    }

    public static boolean a(String str, String str2) {
        return f141434f.a((Object) str, (Object) str2);
    }

    public static boolean a(com.tencent.luggage.wxa.xd.i iVar, String str) {
        if (!str.equals(com.tencent.luggage.wxa.mh.c.NAME)) {
            return false;
        }
        q j06 = iVar.getRuntime().j0();
        w.d("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", Boolean.valueOf(!j06.f125963i));
        return !j06.f125963i;
    }

    public static void a(com.tencent.luggage.wxa.tj.e eVar, j jVar) {
        com.tencent.luggage.wxa.tj.a a16;
        if (w0.c(eVar.d().getAppId()) || w0.c(eVar.a()) || (a16 = com.tencent.luggage.wxa.tj.a.a(eVar.d())) == null) {
            return;
        }
        a16.a(eVar, jVar);
    }

    public static void a(String str) {
        f141434f.a(str);
    }

    public static void a(com.tencent.luggage.wxa.tj.e eVar, j jVar, i iVar) {
        if (!eVar.d().isRunning()) {
            jVar.onCancel();
            return;
        }
        String appId = eVar.d().getAppId();
        String a16 = eVar.a();
        if (f141434f.a((Object) appId, (Object) a16)) {
            w.d("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, before cgi, appId %s, api %s, found in AUTH_CACHE, return ok", appId, a16);
            jVar.a();
        } else {
            w.d("MicroMsg.AppBrandJsApiUserAuth", "requestUSerAuth, before cgi, appId %s, api %s", appId, a16);
            iVar.a(jVar, eVar).c();
        }
    }
}
