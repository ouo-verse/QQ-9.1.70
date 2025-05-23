package com.tencent.gdtad.statistics.metric;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f109501b;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.gdtad.config.data.f f109502a = wm0.b.m().g();

    b() {
    }

    public static b b() {
        if (f109501b == null) {
            synchronized (b.class) {
                if (f109501b == null) {
                    f109501b = new b();
                }
            }
        }
        return f109501b;
    }

    public com.tencent.gdtad.config.data.f a() {
        return this.f109502a;
    }
}
