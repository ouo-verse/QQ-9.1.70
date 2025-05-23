package com.tencent.luggage.wxa.p5;

import com.tencent.luggage.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.luggage.wxa.bk.n;
import com.tencent.luggage.wxa.ic.x;
import com.tencent.luggage.wxa.p004if.u;
import com.tencent.luggage.wxa.p004if.w;
import com.tencent.luggage.wxa.xd.l0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.xd.w0;
import com.tencent.luggage.wxa.yi.b;
import com.tencent.luggage.wxa.yi.d;
import com.tencent.luggage.wxa.yi.z;
import com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePlayer;
import com.tencent.mm.plugin.appbrand.jsapi.live.JsApiInsertLivePusher;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.h4.a {

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.p5.b f137267c = com.tencent.luggage.wxa.p5.b.XWalk;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements d.f {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.yi.d.f
        public boolean a(String str) {
            return true;
        }

        @Override // com.tencent.luggage.wxa.yi.d.f
        public boolean b(String str) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements d.f {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.yi.d.f
        public boolean a(String str) {
            return true;
        }

        @Override // com.tencent.luggage.wxa.yi.d.f
        public boolean b(String str) {
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.p5.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6576c implements b.d {
        public C6576c() {
        }

        @Override // com.tencent.luggage.wxa.yi.b.d
        public boolean a(String str) {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements b.d {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.yi.b.d
        public boolean a(String str) {
            return true;
        }
    }

    static {
        com.tencent.luggage.wxa.l1.b.u();
        com.tencent.luggage.wxa.l1.g.u();
        com.tencent.luggage.wxa.k2.f.a();
        com.tencent.luggage.wxa.h1.e.a(z.class, new n());
    }

    public void a(com.tencent.luggage.wxa.p5.b bVar) {
        this.f137267c = bVar;
    }

    @Override // com.tencent.luggage.wxa.h4.a
    public void c() {
        super.c();
        a(new JsApiInsertLivePlayer());
        a(new JsApiInsertLivePusher());
        a(new com.tencent.luggage.wxa.ff.d());
        a(new com.tencent.luggage.wxa.ff.e());
        a(new com.tencent.luggage.wxa.ff.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.live.c());
        a(new com.tencent.luggage.wxa.ff.f());
        a(new com.tencent.mm.plugin.appbrand.jsapi.live.d());
        a(new com.tencent.luggage.wxa.f3.c());
        a(new com.tencent.luggage.wxa.f3.e());
        a(new com.tencent.luggage.wxa.f3.d());
        a(new com.tencent.luggage.wxa.l2.c());
        a(new com.tencent.luggage.wxa.t2.e());
        a(new com.tencent.luggage.wxa.l2.b());
        a(new com.tencent.luggage.wxa.l2.d(false));
        a(new com.tencent.luggage.wxa.d3.a());
        a(new com.tencent.luggage.wxa.y2.f());
        a(new com.tencent.luggage.wxa.z2.a());
        a(new com.tencent.luggage.wxa.y2.d());
        a(new com.tencent.luggage.wxa.p2.a());
        a(new com.tencent.luggage.wxa.m2.a());
        a(new com.tencent.luggage.wxa.ci.e());
        a(new com.tencent.luggage.wxa.ci.i());
        a(new com.tencent.luggage.wxa.ci.f());
        a(new com.tencent.luggage.wxa.ci.h());
        a(new com.tencent.luggage.wxa.rh.b());
        a(new com.tencent.luggage.wxa.rh.c());
        a(new com.tencent.luggage.wxa.rh.d());
        a(new com.tencent.luggage.wxa.w2.b());
        a(new com.tencent.luggage.wxa.w2.a());
        a(new com.tencent.luggage.wxa.b3.a());
        a(new com.tencent.luggage.wxa.wh.e());
        a(new com.tencent.luggage.wxa.wh.i());
        a(new com.tencent.luggage.wxa.wh.f());
        a(new com.tencent.luggage.wxa.wh.h());
        a(new com.tencent.luggage.wxa.yh.d());
        a(new com.tencent.luggage.wxa.yh.g());
        a(new com.tencent.luggage.wxa.yh.e());
        a(new com.tencent.luggage.wxa.yh.f());
        a(new com.tencent.luggage.wxa.i2.c());
        a(new com.tencent.luggage.wxa.q2.d());
        a(new com.tencent.luggage.wxa.j2.b());
        a(new com.tencent.luggage.wxa.q2.e());
        a(new com.tencent.luggage.wxa.c3.h());
        Iterator it = com.tencent.luggage.wxa.a6.i.INST.b().iterator();
        while (it.hasNext()) {
            a((o) it.next());
        }
        a(new x());
    }

    @Override // com.tencent.luggage.wxa.h4.a
    public void d() {
        super.d();
        b(new com.tencent.mm.plugin.appbrand.jsapi.live.c());
        b(new com.tencent.luggage.wxa.ff.c());
        b(new com.tencent.luggage.wxa.l2.c());
        b(new com.tencent.luggage.wxa.t2.e());
        b(new com.tencent.luggage.wxa.l2.b());
        b(new com.tencent.luggage.wxa.l2.d(false));
        b(new com.tencent.luggage.wxa.l2.e());
        b(new com.tencent.luggage.wxa.u2.a());
        b(new com.tencent.luggage.wxa.v2.c());
        b(new u());
        b(new com.tencent.luggage.wxa.u2.b());
        b(new com.tencent.luggage.wxa.n2.a());
        b(new com.tencent.luggage.wxa.n2.b());
        b(new com.tencent.luggage.wxa.y2.f());
        b(new com.tencent.luggage.wxa.y2.g());
        b(new com.tencent.luggage.wxa.y2.a());
        b(new com.tencent.luggage.wxa.y2.j());
        b(new com.tencent.luggage.wxa.y2.e());
        b(new com.tencent.luggage.wxa.y2.h());
        b(new com.tencent.luggage.wxa.y2.i());
        b(new com.tencent.luggage.wxa.y2.b());
        b(new com.tencent.luggage.wxa.y2.c());
        b(new com.tencent.luggage.wxa.eg.b());
        b(new com.tencent.luggage.wxa.c3.d());
        b(new com.tencent.luggage.wxa.c3.e());
        b(new com.tencent.luggage.wxa.c3.f());
        b(new com.tencent.luggage.wxa.c3.g());
        b(new com.tencent.luggage.wxa.c3.i());
        b(new com.tencent.luggage.wxa.c3.h());
        b(new com.tencent.luggage.wxa.r2.a());
        b(new com.tencent.luggage.wxa.y2.d());
        b(new com.tencent.luggage.wxa.h3.a());
        b(new com.tencent.luggage.wxa.i2.e());
        b(new JsApiOperateMusicPlayer());
        b(new com.tencent.luggage.wxa.k2.d());
        b(new com.tencent.luggage.wxa.k2.e());
        b(new com.tencent.luggage.wxa.k2.b());
        b(new com.tencent.luggage.wxa.k2.c());
        b(new com.tencent.luggage.wxa.w2.b());
        b(new com.tencent.luggage.wxa.w2.a());
        b(new com.tencent.luggage.wxa.i2.a());
        b(new com.tencent.luggage.wxa.i2.b());
        b(new com.tencent.luggage.wxa.i2.d());
        b(new com.tencent.luggage.wxa.b3.a());
        b(new com.tencent.luggage.wxa.ci.e());
        b(new com.tencent.luggage.wxa.ci.i());
        b(new com.tencent.luggage.wxa.ci.f());
        b(new com.tencent.luggage.wxa.ci.h());
        b(new com.tencent.luggage.wxa.ci.g());
        b(new com.tencent.luggage.wxa.lf.c());
        b(new com.tencent.luggage.wxa.wh.e());
        b(new com.tencent.luggage.wxa.wh.i());
        b(new com.tencent.luggage.wxa.wh.f());
        b(new com.tencent.luggage.wxa.wh.h());
        b(new com.tencent.luggage.wxa.wh.g());
        b(new com.tencent.luggage.wxa.yh.d());
        b(new com.tencent.luggage.wxa.yh.g());
        b(new com.tencent.luggage.wxa.yh.e());
        b(new com.tencent.luggage.wxa.yh.f());
        b(new com.tencent.luggage.wxa.e3.a());
        b(new com.tencent.luggage.wxa.i2.c());
        b(new com.tencent.luggage.wxa.q2.d());
        b(new com.tencent.luggage.wxa.j2.b());
        b(new com.tencent.luggage.wxa.q2.e());
        b(new com.tencent.luggage.wxa.j2.c());
        b(new l0());
        b(new w0());
        b(new com.tencent.luggage.wxa.ig.j());
        b(new w());
        b(new com.tencent.luggage.wxa.mf.a());
        b(new com.tencent.luggage.wxa.eg.d());
        b(new com.tencent.luggage.wxa.eg.c());
        b(new com.tencent.luggage.wxa.pf.b(com.tencent.luggage.wxa.pf.a.f137501g, new a()));
        b(new com.tencent.luggage.wxa.pf.c(com.tencent.luggage.wxa.pf.a.f137501g, new b()));
        b(new com.tencent.luggage.wxa.of.b(new C6576c()));
        b(new com.tencent.luggage.wxa.of.c(new d()));
        b(new x());
        b(new com.tencent.luggage.wxa.p2.b());
    }
}
