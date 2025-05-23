package com.tencent.luggage.wxa.hj;

import com.tencent.luggage.wxa.ej.e;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.qc.c;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends e {

    /* renamed from: d, reason: collision with root package name */
    public c.InterfaceC6640c f127222d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.InterfaceC6640c {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String str, com.tencent.luggage.wxa.qc.b bVar) {
            HashMap hashMap = new HashMap();
            hashMap.put("state", Integer.valueOf(bVar.ordinal()));
            c.this.a(hashMap);
        }
    }

    public c(e.b bVar, l lVar) {
        super(bVar, lVar);
    }

    @Override // com.tencent.luggage.wxa.ej.e
    public int a() {
        return 2;
    }

    @Override // com.tencent.luggage.wxa.ej.e
    public void b() {
        com.tencent.luggage.wxa.qc.c c06;
        if (this.f127222d == null || this.f124913a.getRuntime() == null || (c06 = this.f124913a.getRuntime().c0()) == null) {
            return;
        }
        c06.b(this.f127222d);
    }

    @Override // com.tencent.luggage.wxa.ej.e
    public void c() {
        this.f127222d = new a();
        this.f124913a.getRuntime().c0().a(this.f127222d);
    }
}
