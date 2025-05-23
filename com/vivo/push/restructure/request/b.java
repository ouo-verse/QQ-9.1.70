package com.vivo.push.restructure.request;

import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class b<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {

    /* renamed from: a, reason: collision with root package name */
    private a<I, O> f387827a;

    /* renamed from: b, reason: collision with root package name */
    private c<O> f387828b;

    /* renamed from: c, reason: collision with root package name */
    private long f387829c;

    b(a<I, O> aVar) {
        this.f387829c = 5000L;
        this.f387827a = aVar;
        if (aVar == null) {
            u.a(8100, "Command object is null, please construct command first");
        }
    }

    public final a a() {
        return this.f387827a;
    }

    public final c b() {
        return this.f387828b;
    }

    public final long c() {
        return this.f387829c;
    }

    b(a<I, O> aVar, c<O> cVar) {
        this(aVar);
        this.f387828b = cVar;
    }

    public b(a<I, O> aVar, c<O> cVar, byte b16) {
        this(aVar, cVar);
        this.f387829c = 20000L;
    }
}
