package com.tencent.luggage.wxa.lq;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements Future {

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f133791b = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    public final Future f133792a;

    public g(Future future) {
        this.f133792a = future;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z16) {
        if (z16) {
            f133791b.postAtFrontOfQueue(new a(new UnsupportedOperationException("Cannot cancel a main thread FutureTask with parameter 'mayInterruptIfRunning' equals to true.")));
        }
        return this.f133792a.cancel(z16);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.f133792a.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f133792a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f133792a.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        return this.f133792a.get(j3, timeUnit);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f133793a;

        public a(Throwable th5) {
            this.f133793a = th5;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(this.f133793a);
        }

        public static void a(Throwable th5) {
            throw th5;
        }
    }
}
