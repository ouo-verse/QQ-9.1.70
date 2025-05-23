package com.tencent.luggage.wxa.jq;

import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements Runnable, d, f, g, e {

    /* renamed from: a, reason: collision with root package name */
    public Future f131220a;

    @Override // com.tencent.luggage.wxa.jq.e
    public boolean a() {
        return true;
    }

    public boolean b() {
        Future future = this.f131220a;
        if (future == null || future.isDone()) {
            return false;
        }
        return this.f131220a.cancel(false);
    }

    @Override // com.tencent.luggage.wxa.jq.d
    public void a(Future future) {
        this.f131220a = future;
    }
}
