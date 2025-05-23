package com.tencent.luggage.wxa.dj;

import com.tencent.luggage.wxa.ej.e;
import com.tencent.luggage.wxa.ic.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Map f124298a = new HashMap();

    public static c a(e.b bVar, l lVar) {
        c cVar = new c();
        cVar.a(new com.tencent.luggage.wxa.hj.a(bVar, lVar));
        cVar.a(new com.tencent.luggage.wxa.hj.c(bVar, lVar));
        cVar.a(new com.tencent.luggage.wxa.hj.b(bVar, lVar));
        return cVar;
    }

    public e a(int i3) {
        return (e) this.f124298a.get(Integer.valueOf(i3));
    }

    public final void a(e eVar) {
        this.f124298a.put(Integer.valueOf(eVar.a()), eVar);
    }
}
