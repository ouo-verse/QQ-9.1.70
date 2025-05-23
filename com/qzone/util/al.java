package com.qzone.util;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class al<T, P> {

    /* renamed from: a, reason: collision with root package name */
    private volatile T f59785a;

    protected abstract T a(P p16);

    public final T get(P p16) {
        if (this.f59785a == null) {
            synchronized (this) {
                if (this.f59785a == null) {
                    this.f59785a = a(p16);
                }
            }
        }
        return this.f59785a;
    }
}
