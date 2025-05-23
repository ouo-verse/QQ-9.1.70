package com.tencent.luggage.wxa.yi;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    public static AtomicInteger f145954b = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public HashMap f145955a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static s f145956a = new s();
    }

    public static s b() {
        return b.f145956a;
    }

    public com.tencent.luggage.wxa.kh.d a(String str) {
        if (this.f145955a.containsKey(str)) {
            return (com.tencent.luggage.wxa.kh.d) this.f145955a.get(str);
        }
        return null;
    }

    public s() {
        this.f145955a = new HashMap();
    }

    public boolean b(String str) {
        if (!this.f145955a.containsKey(str)) {
            return false;
        }
        com.tencent.luggage.wxa.kh.d dVar = (com.tencent.luggage.wxa.kh.d) this.f145955a.remove(str);
        if (dVar == null) {
            return true;
        }
        dVar.release();
        return true;
    }

    public boolean a(String str, com.tencent.luggage.wxa.kh.d dVar) {
        if (this.f145955a.containsKey(str)) {
            return false;
        }
        this.f145955a.put(str, dVar);
        return true;
    }

    public int a() {
        return f145954b.incrementAndGet();
    }
}
