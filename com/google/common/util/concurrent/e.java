package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.r;
import com.google.errorprone.annotations.ForOverride;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class e implements Service {

    /* renamed from: h, reason: collision with root package name */
    private static final ListenerCallQueue.a<Service.b> f35164h = new a();

    /* renamed from: i, reason: collision with root package name */
    private static final ListenerCallQueue.a<Service.b> f35165i = new b();

    /* renamed from: j, reason: collision with root package name */
    private static final ListenerCallQueue.a<Service.b> f35166j;

    /* renamed from: k, reason: collision with root package name */
    private static final ListenerCallQueue.a<Service.b> f35167k;

    /* renamed from: l, reason: collision with root package name */
    private static final ListenerCallQueue.a<Service.b> f35168l;

    /* renamed from: m, reason: collision with root package name */
    private static final ListenerCallQueue.a<Service.b> f35169m;

    /* renamed from: n, reason: collision with root package name */
    private static final ListenerCallQueue.a<Service.b> f35170n;

    /* renamed from: o, reason: collision with root package name */
    private static final ListenerCallQueue.a<Service.b> f35171o;

    /* renamed from: a, reason: collision with root package name */
    private final r f35172a = new r();

    /* renamed from: b, reason: collision with root package name */
    private final r.a f35173b = new h();

    /* renamed from: c, reason: collision with root package name */
    private final r.a f35174c = new i();

    /* renamed from: d, reason: collision with root package name */
    private final r.a f35175d = new g();

    /* renamed from: e, reason: collision with root package name */
    private final r.a f35176e = new j();

    /* renamed from: f, reason: collision with root package name */
    private final ListenerCallQueue<Service.b> f35177f = new ListenerCallQueue<>();

    /* renamed from: g, reason: collision with root package name */
    private volatile k f35178g = new k(Service.State.NEW);

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class a implements ListenerCallQueue.a<Service.b> {
        a() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Service.b bVar) {
            bVar.c();
        }

        public String toString() {
            return "starting()";
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class b implements ListenerCallQueue.a<Service.b> {
        b() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Service.b bVar) {
            bVar.b();
        }

        public String toString() {
            return "running()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c implements ListenerCallQueue.a<Service.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Service.State f35179a;

        c(Service.State state) {
            this.f35179a = state;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Service.b bVar) {
            bVar.e(this.f35179a);
        }

        public String toString() {
            return "terminated({from = " + this.f35179a + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d implements ListenerCallQueue.a<Service.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Service.State f35180a;

        d(Service.State state) {
            this.f35180a = state;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Service.b bVar) {
            bVar.d(this.f35180a);
        }

        public String toString() {
            return "stopping({from = " + this.f35180a + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.common.util.concurrent.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0248e implements ListenerCallQueue.a<Service.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Service.State f35181a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable f35182b;

        C0248e(Service.State state, Throwable th5) {
            this.f35181a = state;
            this.f35182b = th5;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Service.b bVar) {
            bVar.a(this.f35181a, this.f35182b);
        }

        public String toString() {
            return "failed({from = " + this.f35181a + ", cause = " + this.f35182b + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35184a;

        static {
            int[] iArr = new int[Service.State.values().length];
            f35184a = iArr;
            try {
                iArr[Service.State.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35184a[Service.State.STARTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35184a[Service.State.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35184a[Service.State.STOPPING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35184a[Service.State.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35184a[Service.State.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class g extends r.a {
        g() {
            super(e.this.f35172a);
        }

        @Override // com.google.common.util.concurrent.r.a
        public boolean a() {
            if (e.this.state().compareTo(Service.State.RUNNING) >= 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class h extends r.a {
        h() {
            super(e.this.f35172a);
        }

        @Override // com.google.common.util.concurrent.r.a
        public boolean a() {
            if (e.this.state() == Service.State.NEW) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class i extends r.a {
        i() {
            super(e.this.f35172a);
        }

        @Override // com.google.common.util.concurrent.r.a
        public boolean a() {
            if (e.this.state().compareTo(Service.State.RUNNING) <= 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class j extends r.a {
        j() {
            super(e.this.f35172a);
        }

        @Override // com.google.common.util.concurrent.r.a
        public boolean a() {
            return e.this.state().isTerminal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class k {

        /* renamed from: a, reason: collision with root package name */
        final Service.State f35189a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f35190b;

        /* renamed from: c, reason: collision with root package name */
        @NullableDecl
        final Throwable f35191c;

        k(Service.State state) {
            this(state, false, null);
        }

        Service.State a() {
            if (this.f35190b && this.f35189a == Service.State.STARTING) {
                return Service.State.STOPPING;
            }
            return this.f35189a;
        }

        k(Service.State state, boolean z16, @NullableDecl Throwable th5) {
            com.google.common.base.j.i(!z16 || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            com.google.common.base.j.j(!((state == Service.State.FAILED) ^ (th5 != null)), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th5);
            this.f35189a = state;
            this.f35190b = z16;
            this.f35191c = th5;
        }
    }

    static {
        Service.State state = Service.State.STARTING;
        f35166j = k(state);
        Service.State state2 = Service.State.RUNNING;
        f35167k = k(state2);
        f35168l = l(Service.State.NEW);
        f35169m = l(state);
        f35170n = l(state2);
        f35171o = l(Service.State.STOPPING);
    }

    private void b() {
        if (!this.f35172a.c()) {
            this.f35177f.b();
        }
    }

    private void d(Service.State state, Throwable th5) {
        this.f35177f.c(new C0248e(state, th5));
    }

    private void e() {
        this.f35177f.c(f35165i);
    }

    private void f(Service.State state) {
        switch (f.f35184a[state.ordinal()]) {
            case 1:
                this.f35177f.c(f35168l);
                return;
            case 2:
                this.f35177f.c(f35169m);
                return;
            case 3:
                this.f35177f.c(f35170n);
                return;
            case 4:
                this.f35177f.c(f35171o);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    private static ListenerCallQueue.a<Service.b> k(Service.State state) {
        return new d(state);
    }

    private static ListenerCallQueue.a<Service.b> l(Service.State state) {
        return new c(state);
    }

    @ForOverride
    protected abstract void c();

    public final boolean g() {
        if (state() == Service.State.RUNNING) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(Throwable th5) {
        com.google.common.base.j.m(th5);
        this.f35172a.b();
        try {
            Service.State state = state();
            int i3 = f.f35184a[state.ordinal()];
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3 && i3 != 4) {
                    if (i3 != 5) {
                    }
                } else {
                    this.f35178g = new k(Service.State.FAILED, false, th5);
                    d(state, th5);
                }
                return;
            }
            throw new IllegalStateException("Failed while in state:" + state, th5);
        } finally {
            this.f35172a.e();
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        this.f35172a.b();
        try {
            if (this.f35178g.f35189a == Service.State.STARTING) {
                if (this.f35178g.f35190b) {
                    this.f35178g = new k(Service.State.STOPPING);
                    c();
                } else {
                    this.f35178g = new k(Service.State.RUNNING);
                    e();
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.f35178g.f35189a);
            h(illegalStateException);
            throw illegalStateException;
        } finally {
            this.f35172a.e();
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        this.f35172a.b();
        try {
            Service.State state = state();
            switch (f.f35184a[state.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    throw new IllegalStateException("Cannot notifyStopped() when the service is " + state);
                case 2:
                case 3:
                case 4:
                    this.f35178g = new k(Service.State.TERMINATED);
                    f(state);
                    break;
            }
        } finally {
            this.f35172a.e();
            b();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.f35178g.a();
    }
}
