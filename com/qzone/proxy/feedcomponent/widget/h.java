package com.qzone.proxy.feedcomponent.widget;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class h<T, P> {

    /* renamed from: a, reason: collision with root package name */
    volatile T f50956a;

    protected abstract T a(P p16);

    public final T b(P p16) {
        if (this.f50956a == null) {
            synchronized (this) {
                if (this.f50956a == null) {
                    this.f50956a = a(p16);
                }
            }
        }
        return this.f50956a;
    }
}
