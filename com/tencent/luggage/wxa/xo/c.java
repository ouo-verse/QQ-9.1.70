package com.tencent.luggage.wxa.xo;

import com.tencent.luggage.wxa.ap.k;
import com.tencent.luggage.wxa.xo.e;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c implements com.tencent.luggage.wxa.uo.b {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.uo.b[] f145184b;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f145187e;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.xo.b f145190h;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.vo.c f145185c = new com.tencent.luggage.wxa.vo.c();

    /* renamed from: d, reason: collision with root package name */
    public int f145186d = 0;

    /* renamed from: f, reason: collision with root package name */
    public e.a f145188f = new a();

    /* renamed from: g, reason: collision with root package name */
    public e.b f145189g = new b();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements e.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public void a(Object obj) {
            c.this.f145185c.g();
            c.this.f145190h.a(obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements e.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.xo.e.b
        public void a(Object obj) {
            c.this.f145190h.b(obj);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xo.c$c, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6923c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public int f145193a;

        public C6923c(int i3) {
            this.f145193a = i3;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(Object obj) {
            synchronized (c.this) {
                c.b(c.this);
                c.this.f145187e[this.f145193a] = obj;
                if (c.this.f145186d == c.this.f145184b.length) {
                    h.a(c.this.f145190h, k.b(c.this.f145187e));
                }
            }
        }
    }

    public c(com.tencent.luggage.wxa.uo.b... bVarArr) {
        this.f145184b = bVarArr;
    }

    public static /* synthetic */ int b(c cVar) {
        int i3 = cVar.f145186d;
        cVar.f145186d = i3 + 1;
        return i3;
    }

    @Override // com.tencent.luggage.wxa.uo.b
    public Object call(Object obj) {
        this.f145187e = new Object[this.f145184b.length];
        com.tencent.luggage.wxa.xo.b b16 = h.b();
        this.f145190h = b16;
        if (com.tencent.luggage.wxa.bp.a.a(b16)) {
            com.tencent.luggage.wxa.wo.a.d("Vending.ParallelsFunctional", "Plz run ParallelsFunctional in pipeline!", new Object[0]);
        }
        int i3 = 0;
        for (com.tencent.luggage.wxa.uo.b bVar : this.f145184b) {
            h.a(obj).a(this.f145185c).b(bVar).a(this.f145189g).a(this.f145188f).a(new C6923c(i3));
            i3++;
        }
        return null;
    }
}
