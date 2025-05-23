package com.tencent.luggage.wxa.ic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q0 implements com.tencent.luggage.wxa.uk.s {

    /* renamed from: a, reason: collision with root package name */
    public final Set f129988a = new CopyOnWriteArraySet();

    @Override // com.tencent.luggage.wxa.uk.s
    public void a(com.tencent.luggage.wxa.vo.a aVar) {
        if (aVar != null) {
            this.f129988a.remove(aVar);
        }
    }

    @Override // com.tencent.luggage.wxa.vo.b
    public final void b(com.tencent.luggage.wxa.vo.a aVar) {
        if (aVar != null) {
            this.f129988a.add(aVar);
        }
    }

    public void a() {
        Iterator it = this.f129988a.iterator();
        while (it.hasNext()) {
            ((com.tencent.luggage.wxa.vo.a) it.next()).g();
        }
        this.f129988a.clear();
    }
}
