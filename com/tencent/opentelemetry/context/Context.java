package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface Context {
    public static final IPatchRedirector $redirector_ = null;

    @Nullable
    <V> V get(ContextKey<V> contextKey);

    Scope makeCurrent();

    <V> Context with(ContextKey<V> contextKey, V v3);

    Context with(ImplicitContextKeyed implicitContextKeyed);

    Runnable wrap(Runnable runnable);

    <T> Callable<T> wrap(Callable<T> callable);

    Executor wrap(Executor executor);

    ExecutorService wrap(ExecutorService executorService);

    ScheduledExecutorService wrap(ScheduledExecutorService scheduledExecutorService);
}
