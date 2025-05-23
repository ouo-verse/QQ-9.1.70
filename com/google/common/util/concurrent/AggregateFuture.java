package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ai;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.h<OutputT> {
    private static final Logger E = Logger.getLogger(AggregateFuture.class.getName());

    @NullableDecl
    private AggregateFuture<InputT, OutputT>.RunningState D;

    AggregateFuture() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean L(Set<Throwable> set, Throwable th5) {
        while (th5 != null) {
            if (!set.add(th5)) {
                return false;
            }
            th5 = th5.getCause();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public String A() {
        ImmutableCollection immutableCollection;
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.D;
        if (runningState == null || (immutableCollection = ((RunningState) runningState).f35117i) == null) {
            return null;
        }
        return "futures=[" + immutableCollection + "]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void q() {
        boolean z16;
        super.q();
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.D;
        if (runningState != null) {
            this.D = null;
            ImmutableCollection immutableCollection = ((RunningState) runningState).f35117i;
            boolean H = H();
            if (H) {
                runningState.p();
            }
            boolean isCancelled = isCancelled();
            if (immutableCollection != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (isCancelled & z16) {
                ai it = immutableCollection.iterator();
                while (it.hasNext()) {
                    ((q) it.next()).cancel(H);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    abstract class RunningState extends f implements Runnable {
        private final boolean C;

        /* renamed from: i, reason: collision with root package name */
        private ImmutableCollection<? extends q<? extends InputT>> f35117i;

        /* renamed from: m, reason: collision with root package name */
        private final boolean f35118m;
        final /* synthetic */ AggregateFuture this$0;

        /* compiled from: P */
        /* renamed from: com.google.common.util.concurrent.AggregateFuture$RunningState$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        class AnonymousClass1 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f35119d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ q f35120e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ RunningState f35121f;

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f35121f.o(this.f35119d, this.f35120e);
                } finally {
                    this.f35121f.l();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l() {
            boolean z16;
            int f16 = f();
            if (f16 >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.google.common.base.j.t(z16, "Less than 0 remaining futures");
            if (f16 == 0) {
                q();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void n(Throwable th5) {
            boolean z16;
            boolean z17;
            boolean z18;
            String str;
            com.google.common.base.j.m(th5);
            if (this.f35118m) {
                z16 = this.this$0.E(th5);
                if (!z16) {
                    z17 = AggregateFuture.L(g(), th5);
                    z18 = th5 instanceof Error;
                    if (!(((!z16) & this.f35118m & z17) | z18)) {
                        if (z18) {
                            str = "Input Future failed with Error";
                        } else {
                            str = "Got more than one input Future failure. Logging failures after the first";
                        }
                        AggregateFuture.E.log(Level.SEVERE, str, th5);
                        return;
                    }
                    return;
                }
                r();
            } else {
                z16 = false;
            }
            z17 = true;
            z18 = th5 instanceof Error;
            if (!(((!z16) & this.f35118m & z17) | z18)) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void o(int i3, Future<? extends InputT> future) {
            boolean z16;
            if (!this.f35118m && this.this$0.isDone() && !this.this$0.isCancelled()) {
                z16 = false;
            } else {
                z16 = true;
            }
            com.google.common.base.j.t(z16, "Future was done before all dependencies completed");
            try {
                com.google.common.base.j.t(future.isDone(), "Tried to set value from future which is not done");
                if (this.f35118m) {
                    if (future.isCancelled()) {
                        this.this$0.D = null;
                        this.this$0.cancel(false);
                    } else {
                        Object a16 = Futures.a(future);
                        if (this.C) {
                            k(this.f35118m, i3, a16);
                        }
                    }
                } else if (this.C && !future.isCancelled()) {
                    k(this.f35118m, i3, Futures.a(future));
                }
            } catch (ExecutionException e16) {
                n(e16.getCause());
            } catch (Throwable th5) {
                n(th5);
            }
        }

        private void q() {
            if (this.C & (!this.f35118m)) {
                ai<? extends q<? extends InputT>> it = this.f35117i.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    o(i3, it.next());
                    i3++;
                }
            }
            m();
        }

        @Override // com.google.common.util.concurrent.f
        final void e(Set<Throwable> set) {
            if (!this.this$0.isCancelled()) {
                AggregateFuture.L(set, this.this$0.e());
            }
        }

        abstract void k(boolean z16, int i3, @NullableDecl InputT inputt);

        abstract void m();

        /* JADX INFO: Access modifiers changed from: package-private */
        @ForOverride
        @OverridingMethodsMustInvokeSuper
        public void r() {
            this.f35117i = null;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l();
        }

        void p() {
        }
    }
}
