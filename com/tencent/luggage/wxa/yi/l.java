package com.tencent.luggage.wxa.yi;

import com.tencent.luggage.wxa.yi.g;
import com.tencent.luggage.wxa.yi.i;
import com.tencent.luggage.wxa.yi.j;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* compiled from: P */
/* loaded from: classes9.dex */
public class l extends n {

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f145921b = new ConcurrentHashMap(5);

    @Override // com.tencent.luggage.wxa.yi.k
    public i a(g gVar) {
        return (i) this.f145921b.get(n.c(gVar));
    }

    @Override // com.tencent.luggage.wxa.yi.k
    public boolean b(g gVar) {
        i iVar = (i) this.f145921b.remove(n.c(gVar));
        if (iVar != null) {
            iVar.release();
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.yi.k
    public i a(g gVar, final j jVar) {
        Object computeIfAbsent;
        computeIfAbsent = this.f145921b.computeIfAbsent(n.c(gVar), new Function() { // from class: x41.c
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                i a16;
                a16 = j.this.a((g) obj);
                return a16;
            }
        });
        return (i) computeIfAbsent;
    }
}
