package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public class ListenableFutureTask<V> extends FutureTask<V> implements q<V> {

    /* renamed from: d, reason: collision with root package name */
    private final j f35136d;

    ListenableFutureTask(Callable<V> callable) {
        super(callable);
        this.f35136d = new j();
    }

    public static <V> ListenableFutureTask<V> a(Callable<V> callable) {
        return new ListenableFutureTask<>(callable);
    }

    @Override // com.google.common.util.concurrent.q
    public void c(Runnable runnable, Executor executor) {
        this.f35136d.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.f35136d.b();
    }
}
