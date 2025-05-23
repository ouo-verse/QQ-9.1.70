package com.tencent.luggage.wxa.tk;

import java.util.concurrent.FutureTask;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final FutureTask f141500a;

    public k(Runnable runnable) {
        this.f141500a = new FutureTask(runnable, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f141500a.run();
    }
}
