package com.tencent.luggage.wxa.yi;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class p {

    /* renamed from: b, reason: collision with root package name */
    public static AtomicInteger f145934b = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public HashMap f145935a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static p f145936a = new p();
    }

    public static p b() {
        return b.f145936a;
    }

    public int a() {
        return f145934b.incrementAndGet();
    }

    public p() {
        this.f145935a = new HashMap();
    }

    public o a(String str) {
        if (this.f145935a.containsKey(str)) {
            return (o) this.f145935a.get(str);
        }
        return null;
    }

    public boolean b(String str) {
        if (!this.f145935a.containsKey(str)) {
            return false;
        }
        ((o) this.f145935a.remove(str)).release();
        return true;
    }

    public boolean a(String str, o oVar) {
        if (this.f145935a.containsKey(str)) {
            return false;
        }
        this.f145935a.put(str, oVar);
        return true;
    }
}
