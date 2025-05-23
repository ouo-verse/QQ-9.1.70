package com.tencent.luggage.wxa.so;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final b f140564a;

    /* renamed from: b, reason: collision with root package name */
    public final a f140565b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f140566c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void a(Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        Object a();
    }

    public e(b bVar, a aVar) {
        this.f140564a = bVar;
        this.f140565b = aVar;
    }

    public static e a(b bVar, a aVar) {
        Objects.requireNonNull(bVar);
        Objects.requireNonNull(aVar);
        return new e(bVar, aVar);
    }

    public final void b() {
        Object obj;
        a aVar;
        synchronized (this) {
            obj = this.f140566c;
            this.f140566c = null;
        }
        if (obj != null && (aVar = this.f140565b) != null) {
            aVar.a(obj);
        }
    }

    public final Object a() {
        if (this.f140566c == null) {
            synchronized (this) {
                if (this.f140566c == null) {
                    this.f140566c = this.f140564a.a();
                }
            }
        }
        return this.f140566c;
    }
}
