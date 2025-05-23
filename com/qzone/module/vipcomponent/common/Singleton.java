package com.qzone.module.vipcomponent.common;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class Singleton<T, P> {

    /* renamed from: a, reason: collision with root package name */
    private volatile T f49037a;

    protected abstract T a(P p16);

    public final T get(P p16) {
        if (this.f49037a == null) {
            synchronized (this) {
                if (this.f49037a == null) {
                    this.f49037a = a(p16);
                }
            }
        }
        return this.f49037a;
    }
}
