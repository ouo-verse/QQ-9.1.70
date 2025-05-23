package com.tencent.luggage.wxa.s1;

import com.tencent.luggage.wxa.u1.g;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static volatile c f139999b;

    /* renamed from: a, reason: collision with root package name */
    public g f140000a;

    public static c b() {
        if (f139999b == null) {
            synchronized (c.class) {
                if (f139999b == null) {
                    f139999b = new c();
                }
            }
        }
        return f139999b;
    }

    public g a() {
        g gVar = this.f140000a;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = (g) com.tencent.luggage.wxa.eo.g.a(g.class);
        this.f140000a = gVar2;
        if (gVar2 != null) {
            return gVar2;
        }
        com.tencent.luggage.wxa.u1.b bVar = new com.tencent.luggage.wxa.u1.b();
        this.f140000a = bVar;
        return bVar;
    }
}
