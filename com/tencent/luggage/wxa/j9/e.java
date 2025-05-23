package com.tencent.luggage.wxa.j9;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Object f130925a;

    public e(Object obj) {
        this.f130925a = obj;
    }

    public synchronized Object a(Object obj) {
        Object obj2;
        obj2 = this.f130925a;
        this.f130925a = obj;
        com.tencent.luggage.wxa.m9.b.b("StateRunner", obj2.toString() + " -> " + this.f130925a.toString());
        return obj2;
    }

    public synchronized boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (this.f130925a.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public synchronized Object a() {
        return this.f130925a;
    }
}
