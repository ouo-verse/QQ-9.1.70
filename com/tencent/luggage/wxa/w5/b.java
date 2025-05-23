package com.tencent.luggage.wxa.w5;

import android.content.Context;
import com.tencent.luggage.wxa.aa.h;
import com.tencent.luggage.wxa.gp.a;
import com.tencent.luggage.wxa.i1.a;
import com.tencent.luggage.wxa.jo.a;
import com.tencent.luggage.wxa.ko.a;
import com.tencent.luggage.wxa.n3.l0;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.p5.g;
import com.tencent.luggage.wxa.t2.d;
import com.tencent.luggage.wxa.vc.e;
import com.tencent.luggage.wxa.zj.f;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends com.tencent.luggage.wxa.h4.b {

    /* renamed from: b, reason: collision with root package name */
    public Context f144084b;

    /* renamed from: c, reason: collision with root package name */
    public g f144085c = com.tencent.luggage.wxa.u5.a.f142121a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.jo.a.b
        public void loadLibrary(String str) {
            h.g(str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w5.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6864b implements a.b {
        public C6864b() {
        }

        @Override // com.tencent.luggage.wxa.ko.a.b
        public void loadLibrary(String str) {
            h.g(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements a.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.gp.a.b
        public void loadLibrary(String str) {
            h.g(str);
        }
    }

    public b(Context context) {
        this.f144084b = context;
    }

    @Override // com.tencent.luggage.wxa.h4.b, com.tencent.luggage.wxa.h4.c, com.tencent.luggage.wxa.j1.a, com.tencent.luggage.wxa.i1.a.c
    public void a(a.d dVar) {
        super.a(dVar);
        dVar.a(com.tencent.luggage.wxa.xk.a.class, new com.tencent.luggage.wxa.e6.a());
        dVar.a(com.tencent.luggage.wxa.k4.a.class, new com.tencent.luggage.wxa.w5.a());
        dVar.a(com.tencent.luggage.wxa.bj.c.class, l0.f135214b);
        dVar.a(d.class, com.tencent.luggage.wxa.t2.b.f140840a);
        dVar.a(com.tencent.luggage.wxa.ih.d.class, new com.tencent.luggage.wxa.a3.a());
        dVar.a(com.tencent.luggage.wxa.zj.b.class, com.tencent.luggage.wxa.zj.a.f146727a);
        dVar.a(com.tencent.luggage.wxa.zj.d.class, f.f146728a);
        l.f136139a.a(true);
        dVar.a(e.class, new com.tencent.luggage.wxa.mi.c());
        dVar.a(com.tencent.luggage.wxa.re.d.class, new com.tencent.luggage.wxa.qh.b());
        com.tencent.luggage.wxa.jo.a.a(new a());
        com.tencent.luggage.wxa.ko.a.a(new C6864b());
        com.tencent.luggage.wxa.gp.a.a(new c());
    }
}
