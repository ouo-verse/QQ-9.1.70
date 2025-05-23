package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: P */
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class AbstractScheduledService implements Service {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f35107b = Logger.getLogger(AbstractScheduledService.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final e f35108a = new ServiceDelegate(this, null);

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class a {
    }

    protected AbstractScheduledService() {
    }

    protected abstract void c() throws Exception;

    protected abstract a d();

    protected String e() {
        return getClass().getSimpleName();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f35108a.state();
    }

    public String toString() {
        return e() + " [" + state() + "]";
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class ServiceDelegate extends e {

        /* renamed from: p, reason: collision with root package name */
        @MonotonicNonNullDecl
        private volatile Future<?> f35109p;

        /* renamed from: q, reason: collision with root package name */
        @MonotonicNonNullDecl
        private volatile ScheduledExecutorService f35110q;

        /* renamed from: r, reason: collision with root package name */
        private final ReentrantLock f35111r;

        /* renamed from: s, reason: collision with root package name */
        private final Runnable f35112s;

        /* compiled from: P */
        /* renamed from: com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$2, reason: invalid class name */
        /* loaded from: classes2.dex */
        class AnonymousClass2 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ServiceDelegate f35114d;

            @Override // java.lang.Runnable
            public void run() {
                this.f35114d.f35111r.lock();
                try {
                    AbstractScheduledService.this.g();
                    AbstractScheduledService.this.d();
                    e unused = AbstractScheduledService.this.f35108a;
                    ScheduledExecutorService unused2 = this.f35114d.f35110q;
                    Runnable unused3 = this.f35114d.f35112s;
                    throw null;
                } catch (Throwable th5) {
                    try {
                        this.f35114d.h(th5);
                        if (this.f35114d.f35109p != null) {
                            this.f35114d.f35109p.cancel(false);
                        }
                    } finally {
                        this.f35114d.f35111r.unlock();
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class Task implements Runnable {
            Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.this.f35111r.lock();
                try {
                } finally {
                    try {
                    } finally {
                    }
                }
                if (ServiceDelegate.this.f35109p.isCancelled()) {
                    return;
                }
                AbstractScheduledService.this.c();
            }
        }

        ServiceDelegate() {
            this.f35111r = new ReentrantLock();
            this.f35112s = new Task();
        }

        @Override // com.google.common.util.concurrent.e
        protected final void c() {
            this.f35109p.cancel(false);
            this.f35110q.execute(new Runnable() { // from class: com.google.common.util.concurrent.AbstractScheduledService.ServiceDelegate.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ServiceDelegate.this.f35111r.lock();
                        try {
                            if (ServiceDelegate.this.state() != Service.State.STOPPING) {
                                return;
                            }
                            AbstractScheduledService.this.f();
                            ServiceDelegate.this.f35111r.unlock();
                            ServiceDelegate.this.j();
                        } finally {
                            ServiceDelegate.this.f35111r.unlock();
                        }
                    } catch (Throwable th5) {
                        ServiceDelegate.this.h(th5);
                    }
                }
            });
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }

        /* synthetic */ ServiceDelegate(AbstractScheduledService abstractScheduledService, d dVar) {
            this();
        }
    }

    protected void f() throws Exception {
    }

    protected void g() throws Exception {
    }
}
