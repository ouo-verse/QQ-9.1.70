package com.tencent.luggage.wxa.yi;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f145852b = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public HashMap f145853a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static c f145854a = new c();
    }

    public static c b() {
        return b.f145854a;
    }

    public int a() {
        return f145852b.incrementAndGet();
    }

    public c() {
        this.f145853a = new HashMap();
    }

    public com.tencent.luggage.wxa.yi.b a(String str) {
        if (this.f145853a.containsKey(str)) {
            return (com.tencent.luggage.wxa.yi.b) this.f145853a.get(str);
        }
        return null;
    }

    public boolean b(String str) {
        if (!this.f145853a.containsKey(str)) {
            return false;
        }
        ((com.tencent.luggage.wxa.yi.b) this.f145853a.remove(str)).release();
        return true;
    }

    public boolean a(String str, com.tencent.luggage.wxa.yi.b bVar) {
        if (this.f145853a.containsKey(str)) {
            return false;
        }
        this.f145853a.put(str, bVar);
        return true;
    }
}
