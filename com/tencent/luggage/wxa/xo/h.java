package com.tencent.luggage.wxa.xo;

import com.tencent.luggage.wxa.ap.j;
import com.tencent.luggage.wxa.xo.d;
import com.tencent.luggage.wxa.xo.e;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.xo.a f145239a = new com.tencent.luggage.wxa.xo.a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f145240a;

        public a(com.tencent.luggage.wxa.xo.b bVar) {
            this.f145240a = bVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public void a(Object obj) {
            this.f145240a.a(obj);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f145241a;

        public b(com.tencent.luggage.wxa.xo.b bVar) {
            this.f145241a = bVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public void a(Object obj) {
            h.a(this.f145241a, obj);
        }
    }

    public static final d a(d.a aVar) {
        return new f().a(aVar);
    }

    public static com.tencent.luggage.wxa.ap.b b(Object obj, Object obj2) {
        return j.a(obj, obj2);
    }

    public static final d c() {
        return new f().a(new Object[0]);
    }

    public static final d a(Object obj) {
        return new f().a(obj);
    }

    public static final com.tencent.luggage.wxa.xo.b b() {
        com.tencent.luggage.wxa.xo.b a16 = a();
        if (a16 != null) {
            a16.b();
        } else {
            com.tencent.luggage.wxa.wo.a.d("Vending.QuickAccess", "dummy mario", new Object[0]);
        }
        return a16;
    }

    public static final d a(Object obj, Object obj2) {
        return new f().a(obj, obj2);
    }

    public static final com.tencent.luggage.wxa.xo.b a() {
        d b16 = g.a().b();
        return b16 != null ? b16.e() : f145239a;
    }

    public static final void a(com.tencent.luggage.wxa.xo.b bVar, Object... objArr) {
        if (bVar == null) {
            com.tencent.luggage.wxa.wo.a.d("Vending.QuickAccess", "dummy mario", new Object[0]);
        } else if (objArr.length > 0) {
            bVar.a(objArr);
        } else {
            bVar.a();
        }
    }

    public static final void a(e eVar) {
        com.tencent.luggage.wxa.xo.b b16 = b();
        eVar.a(new b(b16)).a(new a(b16));
    }

    public static final c a(com.tencent.luggage.wxa.uo.b bVar, com.tencent.luggage.wxa.uo.b bVar2) {
        return new c(bVar, bVar2);
    }
}
