package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public class cj {

    /* renamed from: b, reason: collision with root package name */
    private static volatile cj f388413b;

    /* renamed from: a, reason: collision with root package name */
    private ci f388414a;

    public static cj b() {
        if (f388413b == null) {
            synchronized (cj.class) {
                if (f388413b == null) {
                    f388413b = new cj();
                }
            }
        }
        return f388413b;
    }

    public ci a() {
        return this.f388414a;
    }

    public void c(ci ciVar) {
        this.f388414a = ciVar;
    }
}
