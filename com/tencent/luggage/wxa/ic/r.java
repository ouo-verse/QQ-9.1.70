package com.tencent.luggage.wxa.ic;

import com.tencent.luggage.wxa.ya.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r extends com.tencent.luggage.wxa.ya.d {

    /* renamed from: d, reason: collision with root package name */
    public final Set f129989d = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: e, reason: collision with root package name */
    public volatile d.a f129990e;

    public r() {
        super.a(new a());
    }

    public void a() {
        HashSet hashSet = new HashSet(this.f129989d);
        this.f129989d.clear();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            super.c((Class) it.next());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements d.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ya.d.a
        public void a(Class cls, com.tencent.luggage.wxa.ya.c cVar) {
            r.this.f129989d.add(cls);
            d.a aVar = r.this.f129990e;
            if (aVar != null) {
                aVar.a(cls, cVar);
            }
        }

        @Override // com.tencent.luggage.wxa.ya.d.a
        public void b(Class cls, com.tencent.luggage.wxa.ya.c cVar) {
            d.a aVar = r.this.f129990e;
            if (aVar != null) {
                aVar.b(cls, cVar);
            }
        }

        @Override // com.tencent.luggage.wxa.ya.d.a
        public void a(Class cls, com.tencent.luggage.wxa.ya.a aVar) {
            d.a aVar2 = r.this.f129990e;
            if (aVar2 != null) {
                aVar2.a(cls, aVar);
            }
        }
    }
}
