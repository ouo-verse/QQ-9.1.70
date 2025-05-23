package com.tencent.luggage.wxa.qa;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f138551a;

    /* renamed from: b, reason: collision with root package name */
    public Class f138552b;

    public e(Class cls) {
        com.tencent.luggage.wxa.er.a.a(cls);
        this.f138552b = cls;
    }

    public Object a() {
        if (this.f138551a == null) {
            synchronized (this) {
                if (this.f138551a == null) {
                    this.f138551a = com.tencent.luggage.wxa.sa.b.b(this.f138552b);
                }
            }
        }
        return this.f138551a;
    }
}
