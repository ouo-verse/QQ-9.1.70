package com.tencent.luggage.wxa.gq;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f126812a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public a f126813b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ConcurrentHashMap f126814a = new ConcurrentHashMap();

        /* renamed from: b, reason: collision with root package name */
        public String f126815b;

        /* renamed from: c, reason: collision with root package name */
        public AtomicInteger f126816c;

        public a(String str, AtomicInteger atomicInteger) {
            this.f126815b = str;
            this.f126816c = atomicInteger;
        }
    }

    public g(a aVar) {
        this.f126813b = aVar;
    }

    public String a() {
        return this.f126813b.f126815b;
    }

    public int b() {
        return this.f126813b.f126816c.get();
    }

    public void c(String str, int i3) {
        this.f126812a.put(str, Integer.valueOf(i3));
    }

    public void d(String str, int i3) {
        this.f126813b.f126814a.put(str, Integer.valueOf(i3));
    }

    public int a(String str) {
        return a(str, 0);
    }

    public void b(String str, long j3) {
        this.f126812a.put(str, Long.valueOf(j3));
    }

    public int a(String str, int i3) {
        Object obj = this.f126813b.f126814a.get(str);
        return obj == null ? i3 : ((Integer) obj).intValue();
    }

    public int b(String str, int i3) {
        Object obj = this.f126812a.get(str);
        return obj == null ? i3 : ((Integer) obj).intValue();
    }

    public long a(String str, long j3) {
        Object obj = this.f126812a.get(str);
        return obj == null ? j3 : ((Long) obj).longValue();
    }
}
