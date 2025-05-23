package com.tencent.luggage.wxa.hq;

import com.tencent.luggage.wxa.gq.g;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f129175a = new HashMap();

    @Override // com.tencent.luggage.wxa.hq.b
    public void a(g gVar) {
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public void b(g gVar) {
        b(gVar.f126813b.f126816c);
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public void d(g gVar) {
        a(gVar.f126813b.f126816c);
        if (gVar.f126813b.f126816c.intValue() <= 0) {
            HashMap hashMap = f129175a;
            synchronized (hashMap) {
                hashMap.remove(gVar.a());
            }
        }
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public g a(String str) {
        g.a aVar;
        HashMap hashMap = f129175a;
        synchronized (hashMap) {
            aVar = (g.a) hashMap.get(str);
            if (aVar == null) {
                aVar = new g.a(str, new AtomicInteger());
                hashMap.put(str, aVar);
            }
        }
        return new g(aVar);
    }

    public final void b(AtomicInteger atomicInteger) {
        int i3;
        do {
            i3 = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(i3, i3 + 1));
    }

    @Override // com.tencent.luggage.wxa.hq.b
    public Map a() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = f129175a;
        synchronized (hashMap2) {
            for (g.a aVar : hashMap2.values()) {
                int i3 = aVar.f126816c.get();
                if (i3 > 0) {
                    hashMap.put(aVar.f126815b, Integer.valueOf(i3));
                }
            }
        }
        return hashMap;
    }

    public final void a(AtomicInteger atomicInteger) {
        int i3;
        do {
            i3 = atomicInteger.get();
        } while (!atomicInteger.compareAndSet(i3, i3 - 1));
    }
}
