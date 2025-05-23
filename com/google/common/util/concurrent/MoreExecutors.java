package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class MoreExecutors {

    /* compiled from: P */
    /* renamed from: com.google.common.util.concurrent.MoreExecutors$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BlockingQueue f35144d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ q f35145e;

        @Override // java.lang.Runnable
        public void run() {
            this.f35144d.add(this.f35145e);
        }
    }

    /* compiled from: P */
    /* renamed from: com.google.common.util.concurrent.MoreExecutors$5, reason: invalid class name */
    /* loaded from: classes2.dex */
    static class AnonymousClass5 implements Executor {

        /* renamed from: d, reason: collision with root package name */
        boolean f35146d = true;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Executor f35147e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AbstractFuture f35148f;

        AnonymousClass5(Executor executor, AbstractFuture abstractFuture) {
            this.f35147e = executor;
            this.f35148f = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            try {
                this.f35147e.execute(new Runnable() { // from class: com.google.common.util.concurrent.MoreExecutors.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5.this.f35146d = false;
                        runnable.run();
                    }
                });
            } catch (RejectedExecutionException e16) {
                if (this.f35146d) {
                    this.f35148f.E(e16);
                }
            }
        }
    }

    /* compiled from: P */
    @VisibleForTesting
    @GwtIncompatible
    /* loaded from: classes2.dex */
    static class a {
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor b(Executor executor, AbstractFuture<?> abstractFuture) {
        com.google.common.base.j.m(executor);
        com.google.common.base.j.m(abstractFuture);
        if (executor == a()) {
            return executor;
        }
        return new AnonymousClass5(executor, abstractFuture);
    }
}
