package com.tencent.luggage.wxa.d9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f {

    /* renamed from: d, reason: collision with root package name */
    public static f f124163d;

    /* renamed from: a, reason: collision with root package name */
    public volatile LinkedList f124164a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public volatile HashMap f124165b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f124166c = new Object();

    public static f c() {
        if (f124163d == null) {
            synchronized (f.class) {
                if (f124163d == null) {
                    f124163d = new f();
                }
            }
        }
        return f124163d;
    }

    public void a() {
        g();
    }

    public com.tencent.luggage.wxa.c9.d b(String str) {
        com.tencent.luggage.wxa.c9.d dVar;
        synchronized (this.f124166c) {
            if (!this.f124164a.contains(str)) {
                this.f124164a.add(str);
            }
            dVar = (com.tencent.luggage.wxa.c9.d) this.f124165b.get(str);
            if (dVar == null) {
                dVar = new com.tencent.luggage.wxa.c9.d(str);
                this.f124165b.put(str, dVar);
            }
        }
        return dVar;
    }

    public boolean d(String str) {
        synchronized (this.f124166c) {
            if (!this.f124164a.contains(str)) {
                return false;
            }
            com.tencent.luggage.wxa.c9.d dVar = (com.tencent.luggage.wxa.c9.d) this.f124165b.get(str);
            return dVar != null && dVar.m() > 0 && dVar.h();
        }
    }

    public ArrayList e() {
        ArrayList arrayList;
        synchronized (this.f124166c) {
            arrayList = new ArrayList();
            arrayList.addAll(this.f124164a);
        }
        return arrayList;
    }

    public void f() {
        synchronized (this.f124166c) {
            Iterator it = this.f124164a.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.c9.d dVar = (com.tencent.luggage.wxa.c9.d) this.f124165b.get((String) it.next());
                if (dVar != null) {
                    dVar.k();
                }
            }
            this.f124164a.clear();
            this.f124165b.clear();
        }
    }

    public void g() {
        synchronized (this.f124166c) {
            Iterator it = this.f124164a.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.c9.d dVar = (com.tencent.luggage.wxa.c9.d) this.f124165b.get((String) it.next());
                if (dVar != null) {
                    dVar.l();
                }
            }
            this.f124164a.clear();
            this.f124165b.clear();
        }
    }

    public long a(String str) {
        synchronized (this.f124166c) {
            if (!this.f124164a.contains(str)) {
                return 0L;
            }
            com.tencent.luggage.wxa.c9.d dVar = (com.tencent.luggage.wxa.c9.d) this.f124165b.get(str);
            if (dVar == null || !dVar.h()) {
                return 0L;
            }
            return dVar.e();
        }
    }

    public int c(String str) {
        synchronized (this.f124166c) {
            if (!this.f124164a.contains(str)) {
                return 0;
            }
            com.tencent.luggage.wxa.c9.d dVar = (com.tencent.luggage.wxa.c9.d) this.f124165b.get(str);
            if (dVar == null) {
                return 0;
            }
            return dVar.m();
        }
    }

    public long d() {
        long j3;
        synchronized (this.f124166c) {
            Iterator it = this.f124164a.iterator();
            j3 = 0;
            while (it.hasNext()) {
                com.tencent.luggage.wxa.c9.d dVar = (com.tencent.luggage.wxa.c9.d) this.f124165b.get((String) it.next());
                if (dVar != null && dVar.h() && !dVar.g()) {
                    j3 += dVar.e();
                }
            }
        }
        return j3;
    }

    public void b() {
        synchronized (this.f124166c) {
            Iterator it = this.f124164a.iterator();
            while (it.hasNext()) {
                com.tencent.luggage.wxa.c9.d dVar = (com.tencent.luggage.wxa.c9.d) this.f124165b.get((String) it.next());
                if (dVar != null && dVar.h() && dVar.g()) {
                    dVar.b();
                }
            }
        }
    }
}
