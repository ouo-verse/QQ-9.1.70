package com.bumptech.glide.load.engine;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.l;
import i0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes.dex */
class EngineJob<R> implements DecodeJob.b<R>, a.f {
    private static final a W = new a();
    private final GlideExecutor C;
    private final GlideExecutor D;
    private final GlideExecutor E;
    private final GlideExecutor F;
    private final AtomicInteger G;
    private com.bumptech.glide.load.c H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private q<?> M;
    DataSource N;
    private boolean P;
    GlideException Q;
    private boolean R;
    l<?> S;
    private DecodeJob<R> T;
    private volatile boolean U;
    private boolean V;

    /* renamed from: d, reason: collision with root package name */
    final c f31627d;

    /* renamed from: e, reason: collision with root package name */
    private final i0.c f31628e;

    /* renamed from: f, reason: collision with root package name */
    private final l.a f31629f;

    /* renamed from: h, reason: collision with root package name */
    private final Pools.Pool<EngineJob<?>> f31630h;

    /* renamed from: i, reason: collision with root package name */
    private final a f31631i;

    /* renamed from: m, reason: collision with root package name */
    private final i f31632m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class CallLoadFailed implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final com.bumptech.glide.request.f f31633d;

        CallLoadFailed(com.bumptech.glide.request.f fVar) {
            this.f31633d = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f31633d.getLock()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f31627d.d(this.f31633d)) {
                        EngineJob.this.e(this.f31633d);
                    }
                    EngineJob.this.i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class CallResourceReady implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final com.bumptech.glide.request.f f31634d;

        CallResourceReady(com.bumptech.glide.request.f fVar) {
            this.f31634d = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f31634d.getLock()) {
                synchronized (EngineJob.this) {
                    if (EngineJob.this.f31627d.d(this.f31634d)) {
                        EngineJob.this.S.a();
                        EngineJob.this.f(this.f31634d);
                        EngineJob.this.r(this.f31634d);
                    }
                    EngineJob.this.i();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public <R> l<R> a(q<R> qVar, boolean z16, com.bumptech.glide.load.c cVar, l.a aVar) {
            return new l<>(qVar, z16, true, cVar, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final com.bumptech.glide.request.f f31635a;

        /* renamed from: b, reason: collision with root package name */
        final Executor f31636b;

        b(com.bumptech.glide.request.f fVar, Executor executor) {
            this.f31635a = fVar;
            this.f31636b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f31635a.equals(((b) obj).f31635a);
            }
            return false;
        }

        public int hashCode() {
            return this.f31635a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class c implements Iterable<b> {

        /* renamed from: d, reason: collision with root package name */
        private final List<b> f31637d;

        c() {
            this(new ArrayList(2));
        }

        private static b h(com.bumptech.glide.request.f fVar) {
            return new b(fVar, h0.e.a());
        }

        void a(com.bumptech.glide.request.f fVar, Executor executor) {
            this.f31637d.add(new b(fVar, executor));
        }

        void clear() {
            this.f31637d.clear();
        }

        boolean d(com.bumptech.glide.request.f fVar) {
            return this.f31637d.contains(h(fVar));
        }

        c g() {
            return new c(new ArrayList(this.f31637d));
        }

        void i(com.bumptech.glide.request.f fVar) {
            this.f31637d.remove(h(fVar));
        }

        boolean isEmpty() {
            return this.f31637d.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<b> iterator() {
            return this.f31637d.iterator();
        }

        int size() {
            return this.f31637d.size();
        }

        c(List<b> list) {
            this.f31637d = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, i iVar, l.a aVar, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, iVar, aVar, pool, W);
    }

    private GlideExecutor j() {
        if (this.J) {
            return this.E;
        }
        if (this.K) {
            return this.F;
        }
        return this.D;
    }

    private boolean m() {
        if (!this.R && !this.P && !this.U) {
            return false;
        }
        return true;
    }

    private synchronized void q() {
        if (this.H != null) {
            this.f31627d.clear();
            this.H = null;
            this.S = null;
            this.M = null;
            this.R = false;
            this.U = false;
            this.P = false;
            this.V = false;
            this.T.w(false);
            this.T = null;
            this.Q = null;
            this.N = null;
            this.f31630h.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void a(GlideException glideException) {
        synchronized (this) {
            this.Q = glideException;
        }
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void b(q<R> qVar, DataSource dataSource, boolean z16) {
        synchronized (this) {
            this.M = qVar;
            this.N = dataSource;
            this.V = z16;
        }
        o();
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.b
    public void c(DecodeJob<?> decodeJob) {
        j().execute(decodeJob);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void d(com.bumptech.glide.request.f fVar, Executor executor) {
        this.f31628e.c();
        this.f31627d.a(fVar, executor);
        boolean z16 = true;
        if (this.P) {
            k(1);
            executor.execute(new CallResourceReady(fVar));
        } else if (this.R) {
            k(1);
            executor.execute(new CallLoadFailed(fVar));
        } else {
            if (this.U) {
                z16 = false;
            }
            h0.j.a(z16, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @GuardedBy("this")
    void e(com.bumptech.glide.request.f fVar) {
        try {
            fVar.a(this.Q);
        } catch (Throwable th5) {
            throw new CallbackException(th5);
        }
    }

    @GuardedBy("this")
    void f(com.bumptech.glide.request.f fVar) {
        try {
            fVar.b(this.S, this.N, this.V);
        } catch (Throwable th5) {
            throw new CallbackException(th5);
        }
    }

    void g() {
        if (m()) {
            return;
        }
        this.U = true;
        this.T.cancel();
        this.f31632m.b(this, this.H);
    }

    @Override // i0.a.f
    @NonNull
    public i0.c h() {
        return this.f31628e;
    }

    void i() {
        boolean z16;
        l<?> lVar;
        synchronized (this) {
            this.f31628e.c();
            h0.j.a(m(), "Not yet complete!");
            int decrementAndGet = this.G.decrementAndGet();
            if (decrementAndGet >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            h0.j.a(z16, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                lVar = this.S;
                q();
            } else {
                lVar = null;
            }
        }
        if (lVar != null) {
            lVar.d();
        }
    }

    synchronized void k(int i3) {
        l<?> lVar;
        h0.j.a(m(), "Not yet complete!");
        if (this.G.getAndAdd(i3) == 0 && (lVar = this.S) != null) {
            lVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized EngineJob<R> l(com.bumptech.glide.load.c cVar, boolean z16, boolean z17, boolean z18, boolean z19) {
        this.H = cVar;
        this.I = z16;
        this.J = z17;
        this.K = z18;
        this.L = z19;
        return this;
    }

    void n() {
        synchronized (this) {
            this.f31628e.c();
            if (this.U) {
                q();
                return;
            }
            if (!this.f31627d.isEmpty()) {
                if (!this.R) {
                    this.R = true;
                    com.bumptech.glide.load.c cVar = this.H;
                    c g16 = this.f31627d.g();
                    k(g16.size() + 1);
                    this.f31632m.d(this, cVar, null);
                    Iterator<b> it = g16.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        next.f31636b.execute(new CallLoadFailed(next.f31635a));
                    }
                    i();
                    return;
                }
                throw new IllegalStateException("Already failed once");
            }
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
    }

    void o() {
        synchronized (this) {
            this.f31628e.c();
            if (this.U) {
                this.M.recycle();
                q();
                return;
            }
            if (!this.f31627d.isEmpty()) {
                if (!this.P) {
                    this.S = this.f31631i.a(this.M, this.I, this.H, this.f31629f);
                    this.P = true;
                    c g16 = this.f31627d.g();
                    k(g16.size() + 1);
                    this.f31632m.d(this, this.H, this.S);
                    Iterator<b> it = g16.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        next.f31636b.execute(new CallResourceReady(next.f31635a));
                    }
                    i();
                    return;
                }
                throw new IllegalStateException("Already have resource");
            }
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void r(com.bumptech.glide.request.f fVar) {
        boolean z16;
        this.f31628e.c();
        this.f31627d.i(fVar);
        if (this.f31627d.isEmpty()) {
            g();
            if (!this.P && !this.R) {
                z16 = false;
                if (z16 && this.G.get() == 0) {
                    q();
                }
            }
            z16 = true;
            if (z16) {
                q();
            }
        }
    }

    public synchronized void s(DecodeJob<R> decodeJob) {
        GlideExecutor j3;
        this.T = decodeJob;
        if (decodeJob.C()) {
            j3 = this.C;
        } else {
            j3 = j();
        }
        j3.execute(decodeJob);
    }

    @VisibleForTesting
    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, i iVar, l.a aVar, Pools.Pool<EngineJob<?>> pool, a aVar2) {
        this.f31627d = new c();
        this.f31628e = i0.c.a();
        this.G = new AtomicInteger();
        this.C = glideExecutor;
        this.D = glideExecutor2;
        this.E = glideExecutor3;
        this.F = glideExecutor4;
        this.f31632m = iVar;
        this.f31629f = aVar;
        this.f31630h = pool;
        this.f31631i = aVar2;
    }
}
