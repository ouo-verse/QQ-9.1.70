package com.tencent.luggage.wxa.np;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static volatile g f135894b;

    /* renamed from: a, reason: collision with root package name */
    public String f135895a = b.f135892a;

    public static g b() {
        g gVar;
        if (f135894b == null) {
            synchronized (g.class) {
                if (f135894b == null) {
                    f135894b = new g();
                }
                gVar = f135894b;
            }
            return gVar;
        }
        return f135894b;
    }

    public String a() {
        return this.f135895a;
    }

    public void a(String str) {
        this.f135895a = str;
    }
}
