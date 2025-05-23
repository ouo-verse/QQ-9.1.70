package com.tencent.luggage.wxa.d9;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static e f124160c;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f124161a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public Object f124162b = new Object();

    public static e a() {
        if (f124160c == null) {
            synchronized (e.class) {
                if (f124160c == null) {
                    f124160c = new e();
                }
            }
        }
        return f124160c;
    }

    public com.tencent.luggage.wxa.c9.e b() {
        synchronized (this.f124162b) {
            if (this.f124161a.size() > 0) {
                return (com.tencent.luggage.wxa.c9.e) this.f124161a.remove(r1.size() - 1);
            }
            return new com.tencent.luggage.wxa.c9.e();
        }
    }

    public synchronized long c() {
        return this.f124161a.size() * 3536;
    }

    public void a(com.tencent.luggage.wxa.c9.e eVar) {
        if (eVar == null || eVar.f123439f == null) {
            return;
        }
        eVar.b();
        synchronized (this.f124162b) {
            this.f124161a.add(0, eVar);
        }
    }
}
