package com.tencent.luggage.wxa.ee;

import com.tencent.luggage.wxa.ei.p;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f124644a = new ConcurrentHashMap(5);

    public void a(String str, p pVar) {
        this.f124644a.put(str, pVar);
    }

    public void b(String str) {
        this.f124644a.remove(str);
    }

    public p a(String str) {
        return (p) this.f124644a.get(str);
    }

    public void a() {
        this.f124644a.clear();
    }
}
