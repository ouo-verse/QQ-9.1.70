package com.tencent.luggage.wxa.a4;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C5984a f120840a = new C5984a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C5984a {
        public C5984a() {
        }

        public /* synthetic */ C5984a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExecutorService a(Integer num) {
            int i3;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = Integer.MAX_VALUE;
            }
            return new c(new BaseThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(i3)));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends AbstractExecutorService {

        /* renamed from: a, reason: collision with root package name */
        public final ExecutorService f120841a;

        public b(ExecutorService e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            this.f120841a = e16;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j3, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            return this.f120841a.awaitTermination(j3, unit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            this.f120841a.execute(command);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public List invokeAll(Collection tasks) {
            Intrinsics.checkNotNullParameter(tasks, "tasks");
            List invokeAll = this.f120841a.invokeAll(tasks);
            Intrinsics.checkNotNullExpressionValue(invokeAll, "e.invokeAll(tasks)");
            return invokeAll;
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Object invokeAny(Collection tasks) {
            Intrinsics.checkNotNullParameter(tasks, "tasks");
            return this.f120841a.invokeAny(tasks);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.f120841a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.f120841a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.f120841a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List shutdownNow() {
            List<Runnable> shutdownNow = this.f120841a.shutdownNow();
            Intrinsics.checkNotNullExpressionValue(shutdownNow, "e.shutdownNow()");
            return shutdownNow;
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future submit(Runnable task) {
            Intrinsics.checkNotNullParameter(task, "task");
            Future<?> submit = this.f120841a.submit(task);
            Intrinsics.checkNotNullExpressionValue(submit, "e.submit(task)");
            return submit;
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public List invokeAll(Collection tasks, long j3, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(tasks, "tasks");
            Intrinsics.checkNotNullParameter(unit, "unit");
            List invokeAll = this.f120841a.invokeAll(tasks, j3, unit);
            Intrinsics.checkNotNullExpressionValue(invokeAll, "e.invokeAll(tasks, timeout, unit)");
            return invokeAll;
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Object invokeAny(Collection tasks, long j3, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(tasks, "tasks");
            Intrinsics.checkNotNullParameter(unit, "unit");
            return this.f120841a.invokeAny(tasks, j3, unit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future submit(Callable task) {
            Intrinsics.checkNotNullParameter(task, "task");
            Future submit = this.f120841a.submit(task);
            Intrinsics.checkNotNullExpressionValue(submit, "e.submit(task)");
            return submit;
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future submit(Runnable task, Object obj) {
            Intrinsics.checkNotNullParameter(task, "task");
            Future submit = this.f120841a.submit(task, obj);
            Intrinsics.checkNotNullExpressionValue(submit, "e.submit(task, result)");
            return submit;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends b {

        /* renamed from: b, reason: collision with root package name */
        public final String f120842b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ExecutorService executor) {
            super(executor);
            Intrinsics.checkNotNullParameter(executor, "executor");
            this.f120842b = "luggage.LuggageFinalizableDelegatedExecutorService";
        }

        @Override // com.tencent.luggage.wxa.a4.a.b, java.util.concurrent.Executor
        public void execute(Runnable command) {
            Intrinsics.checkNotNullParameter(command, "command");
            try {
                super.execute(command);
            } catch (RejectedExecutionException unused) {
                w.d(this.f120842b, "RejectedExecutionException");
            }
        }

        public final void finalize() {
            super.shutdown();
        }
    }
}
