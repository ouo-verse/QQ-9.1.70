package com.tencent.luggage.wxa.md;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.luggage.wxa.ld.g;
import com.tencent.luggage.wxa.ld.i;
import com.tencent.luggage.wxa.ld.j;
import com.tencent.luggage.wxa.ld.l;
import com.tencent.luggage.wxa.md.e;
import com.tencent.luggage.wxa.nd.k;
import com.tencent.luggage.wxa.nd.m;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements com.tencent.luggage.wxa.od.b {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.md.b f134434a;

    /* renamed from: c, reason: collision with root package name */
    public f f134436c;

    /* renamed from: d, reason: collision with root package name */
    public f f134437d;

    /* renamed from: e, reason: collision with root package name */
    public f f134438e;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.pd.c f134440g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.pd.c f134441h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.md.d f134442i;

    /* renamed from: b, reason: collision with root package name */
    public k f134435b = k.d();

    /* renamed from: f, reason: collision with root package name */
    public e f134439f = new e();

    /* renamed from: j, reason: collision with root package name */
    public boolean f134443j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f134444k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f134445l = false;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.md.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6470c implements com.tencent.luggage.wxa.od.a {
        public C6470c() {
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            if (eVar != null && c.this.f134434a != null) {
                Log.e("MRDevice", c.this.f134434a.f134427g + " unSubscribeAVTransportEvent fail response code : " + eVar.f137497c);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e eVar) {
            c cVar = c.this;
            cVar.f134444k = false;
            cVar.f134440g = null;
            if (cVar.f134434a != null) {
                Log.i("MRDevice", c.this.f134434a.f134427g + " unSubscribeAVTransportEvent success");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.od.a {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            if (eVar != null && c.this.f134434a != null) {
                Log.e("MRDevice", c.this.f134434a.f134427g + " unSubscribeRenderingControlEvent fail response code : " + eVar.f137497c);
            }
        }

        @Override // com.tencent.luggage.wxa.od.a
        public void b(com.tencent.luggage.wxa.pd.e eVar) {
            c cVar = c.this;
            cVar.f134445l = false;
            cVar.f134441h = null;
            if (cVar.f134434a != null) {
                Log.i("MRDevice", c.this.f134434a.f134427g + " unSubscribeRenderingControlEvent success");
            }
        }
    }

    public c(com.tencent.luggage.wxa.md.b bVar) {
        this.f134434a = bVar;
        g();
    }

    public void a(e.a aVar) {
        this.f134439f.f134450a = aVar;
    }

    public f b() {
        return this.f134436c;
    }

    public com.tencent.luggage.wxa.md.b c() {
        return this.f134434a;
    }

    public e.a d() {
        return this.f134439f.f134450a;
    }

    public com.tencent.luggage.wxa.pd.c e() {
        return this.f134441h;
    }

    public boolean equals(Object obj) {
        com.tencent.luggage.wxa.md.b bVar = this.f134434a;
        if (bVar == null && obj == null) {
            return true;
        }
        if (bVar == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return bVar.equals(((c) obj).c());
    }

    public f f() {
        return this.f134437d;
    }

    public void g() {
        com.tencent.luggage.wxa.md.b bVar = this.f134434a;
        if (bVar == null || bVar.f134432l.size() == 0) {
            return;
        }
        Iterator it = this.f134434a.f134432l.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!TextUtils.isEmpty(fVar.f134459a)) {
                if (fVar.f134459a.startsWith("urn:schemas-upnp-org:service:AVTransport")) {
                    this.f134436c = fVar;
                } else if (fVar.f134459a.startsWith("urn:schemas-upnp-org:service:RenderingControl")) {
                    this.f134437d = fVar;
                } else if (fVar.f134459a.startsWith("urn:schemas-upnp-org:service:ConnectionManager")) {
                    this.f134438e = fVar;
                }
            }
        }
    }

    public boolean h() {
        if (this.f134436c != null && this.f134437d != null) {
            return true;
        }
        return false;
    }

    public void i() {
        if (this.f134444k) {
            return;
        }
        com.tencent.luggage.wxa.nd.e.d().a(this, new a());
    }

    public void j() {
        if (this.f134445l) {
            return;
        }
        com.tencent.luggage.wxa.nd.e.d().b(this, new b());
    }

    public void k() {
        if (!this.f134444k) {
            return;
        }
        com.tencent.luggage.wxa.nd.e.d().a(this, new C6470c());
    }

    public void l() {
        if (!this.f134445l) {
            return;
        }
        com.tencent.luggage.wxa.nd.e.d().b(this, new d());
    }

    public String toString() {
        return "MRDevice{mDevice=" + this.f134434a + '}';
    }

    public static c a(com.tencent.luggage.wxa.md.b bVar) {
        c cVar = new c(bVar);
        if (cVar.h()) {
            return cVar;
        }
        return null;
    }

    public void b(String str, com.tencent.luggage.wxa.od.a aVar) {
        f fVar = this.f134436c;
        if (fVar != null) {
            this.f134435b.a(new j(a(fVar), this.f134436c.f134459a, str), aVar);
        }
    }

    public void c(com.tencent.luggage.wxa.od.a aVar) {
        f fVar = this.f134437d;
        if (fVar != null) {
            this.f134435b.a(new com.tencent.luggage.wxa.ld.c(a(fVar), this.f134437d.f134459a), aVar);
        }
    }

    public void d(com.tencent.luggage.wxa.od.a aVar) {
        f fVar = this.f134436c;
        if (fVar != null) {
            this.f134435b.a(new com.tencent.luggage.wxa.ld.f(a(fVar), this.f134436c.f134459a), aVar);
        }
    }

    public void e(com.tencent.luggage.wxa.od.a aVar) {
        f fVar = this.f134436c;
        if (fVar != null) {
            this.f134435b.a(new g(a(fVar), this.f134436c.f134459a), aVar);
        }
    }

    public void f(com.tencent.luggage.wxa.od.a aVar) {
        f fVar = this.f134436c;
        if (fVar != null) {
            this.f134435b.a(new l(a(fVar), this.f134436c.f134459a), aVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.od.c {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.od.c
        public void a(com.tencent.luggage.wxa.pd.c cVar) {
            c cVar2 = c.this;
            cVar2.f134444k = true;
            cVar2.f134440g = cVar;
            if (cVar2.f134434a != null) {
                Log.i("MRDevice", c.this.f134434a.f134427g + " subscribeAVTransportEvent success");
            }
        }

        @Override // com.tencent.luggage.wxa.od.c
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            if (eVar == null || c.this.f134434a == null) {
                return;
            }
            Log.e("MRDevice", c.this.f134434a.f134427g + " subscribeAVTransportEvent fail response code : " + eVar.f137497c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.od.c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.od.c
        public void a(com.tencent.luggage.wxa.pd.c cVar) {
            c cVar2 = c.this;
            cVar2.f134445l = true;
            cVar2.f134441h = cVar;
            if (cVar2.f134434a != null) {
                Log.i("MRDevice", c.this.f134434a.f134427g + " subscribeRenderingControlEvent success");
            }
        }

        @Override // com.tencent.luggage.wxa.od.c
        public void a(com.tencent.luggage.wxa.pd.e eVar) {
            if (eVar == null || c.this.f134434a == null) {
                return;
            }
            Log.e("MRDevice", c.this.f134434a.f134427g + " subscribeRenderingControlEvent fail response code : " + eVar.f137497c);
        }
    }

    public com.tencent.luggage.wxa.pd.c a() {
        return this.f134440g;
    }

    public void a(int i3, com.tencent.luggage.wxa.od.a aVar) {
        f fVar = this.f134437d;
        if (fVar != null) {
            this.f134435b.a(new com.tencent.luggage.wxa.ld.k(a(fVar), this.f134437d.f134459a, i3), aVar);
        }
    }

    public void b(com.tencent.luggage.wxa.od.a aVar) {
        f fVar = this.f134436c;
        if (fVar != null) {
            this.f134435b.a(new com.tencent.luggage.wxa.ld.b(a(fVar), this.f134436c.f134459a), aVar);
        }
    }

    public void a(String str, com.tencent.luggage.wxa.od.a aVar) {
        f fVar = this.f134436c;
        if (fVar != null) {
            this.f134435b.a(new i(a(fVar), this.f134436c.f134459a, str), aVar);
        }
    }

    public void a(com.tencent.luggage.wxa.od.a aVar) {
        f fVar = this.f134436c;
        if (fVar != null) {
            this.f134435b.a(new com.tencent.luggage.wxa.ld.a(a(fVar), this.f134436c.f134459a), aVar);
        }
    }

    public final String a(f fVar) {
        com.tencent.luggage.wxa.md.b bVar = this.f134434a;
        return bVar != null ? com.tencent.luggage.wxa.nd.i.a(bVar.f134422b, bVar.f134423c, fVar.f134462d) : "";
    }

    public void a(com.tencent.luggage.wxa.md.d dVar) {
        this.f134442i = dVar;
    }

    @Override // com.tencent.luggage.wxa.od.b
    public boolean a(com.tencent.luggage.wxa.pd.d dVar) {
        String str;
        if (this.f134442i == null) {
            return true;
        }
        Map map = dVar.f137499b;
        if (map != null && !map.containsKey("LastChange")) {
            return false;
        }
        Map map2 = dVar.f137499b;
        if (map2 != null) {
            com.tencent.luggage.wxa.pd.a aVar = (com.tencent.luggage.wxa.pd.a) map2.get("LastChange");
            Objects.requireNonNull(aVar);
            str = aVar.a();
        } else {
            str = null;
        }
        HashMap a16 = str != null ? m.a().a(str) : null;
        if (a16 == null) {
            return false;
        }
        if ("avtEvent".equals(dVar.f137496c)) {
            com.tencent.luggage.wxa.pd.a aVar2 = (com.tencent.luggage.wxa.pd.a) a16.get("TransportState");
            if (aVar2 != null) {
                String a17 = aVar2.a(TPReportParams.JSON_KEY_VAL);
                if ("PLAYING".equalsIgnoreCase(a17)) {
                    this.f134442i.b(this);
                } else if ("PAUSED_PLAYBACK".equalsIgnoreCase(a17)) {
                    this.f134442i.a(this);
                } else if ("STOPPED".equalsIgnoreCase(a17)) {
                    this.f134442i.c(this);
                }
            }
            com.tencent.luggage.wxa.pd.a aVar3 = (com.tencent.luggage.wxa.pd.a) a16.get("CurrentTrackDuration");
            if (aVar3 != null) {
                String[] split = aVar3.a(TPReportParams.JSON_KEY_VAL).split(":");
                if (split.length == 3) {
                    this.f134442i.a(this, (Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]));
                }
            }
        } else if ("rdcEvent".equals(dVar.f137496c)) {
            com.tencent.luggage.wxa.pd.a aVar4 = (com.tencent.luggage.wxa.pd.a) a16.get("Volume");
            if (aVar4 != null) {
                this.f134442i.b(this, Integer.parseInt(aVar4.a(TPReportParams.JSON_KEY_VAL)));
            }
            if (((com.tencent.luggage.wxa.pd.a) a16.get("Mute")) != null) {
                this.f134442i.a(this, !"0".equals(r6.a(TPReportParams.JSON_KEY_VAL)));
            }
        }
        return true;
    }
}
