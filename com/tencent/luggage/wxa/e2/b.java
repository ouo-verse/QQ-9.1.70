package com.tencent.luggage.wxa.e2;

import androidx.core.util.Pools;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements Pools.Pool {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentLinkedQueue f124471a = new ConcurrentLinkedQueue();

    public abstract Object a();

    @Override // androidx.core.util.Pools.Pool
    public Object acquire() {
        Object poll = this.f124471a.poll();
        if (poll == null) {
            return a();
        }
        return poll;
    }

    public void b() {
        this.f124471a.clear();
    }

    @Override // androidx.core.util.Pools.Pool
    public boolean release(Object obj) {
        return this.f124471a.offer(obj);
    }
}
