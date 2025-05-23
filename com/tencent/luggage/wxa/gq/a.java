package com.tencent.luggage.wxa.gq;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends e {

    /* renamed from: e, reason: collision with root package name */
    public ReentrantLock f126804e;

    /* renamed from: f, reason: collision with root package name */
    public final Condition f126805f;

    public a(int i3, int i16) {
        super(i3, i16);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f126804e = reentrantLock;
        this.f126805f = reentrantLock.newCondition();
    }

    @Override // com.tencent.luggage.wxa.hq.a, com.tencent.luggage.wxa.hq.b
    public void a(g gVar) {
        super.a(gVar);
        while (!c(gVar)) {
            try {
                try {
                    this.f126804e.lock();
                    this.f126805f.await();
                    this.f126804e.unlock();
                } catch (Throwable th5) {
                    this.f126804e.unlock();
                    throw th5;
                }
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.gq.b, com.tencent.luggage.wxa.hq.a, com.tencent.luggage.wxa.hq.b
    public void d(g gVar) {
        super.d(gVar);
        try {
            this.f126804e.lock();
            this.f126805f.signal();
        } finally {
            this.f126804e.unlock();
        }
    }
}
