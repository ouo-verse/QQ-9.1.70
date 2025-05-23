package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.l;
import i0.a;
import java.util.Map;
import java.util.concurrent.Executor;
import s.a;
import s.h;

/* compiled from: P */
/* loaded from: classes.dex */
public class h implements i, h.a, l.a {

    /* renamed from: i, reason: collision with root package name */
    private static final boolean f31697i = Log.isLoggable("Engine", 2);

    /* renamed from: a, reason: collision with root package name */
    private final n f31698a;

    /* renamed from: b, reason: collision with root package name */
    private final k f31699b;

    /* renamed from: c, reason: collision with root package name */
    private final s.h f31700c;

    /* renamed from: d, reason: collision with root package name */
    private final b f31701d;

    /* renamed from: e, reason: collision with root package name */
    private final t f31702e;

    /* renamed from: f, reason: collision with root package name */
    private final c f31703f;

    /* renamed from: g, reason: collision with root package name */
    private final a f31704g;

    /* renamed from: h, reason: collision with root package name */
    private final ActiveResources f31705h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final DecodeJob.e f31706a;

        /* renamed from: b, reason: collision with root package name */
        final Pools.Pool<DecodeJob<?>> f31707b = i0.a.d(150, new C0217a());

        /* renamed from: c, reason: collision with root package name */
        private int f31708c;

        /* compiled from: P */
        /* renamed from: com.bumptech.glide.load.engine.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0217a implements a.d<DecodeJob<?>> {
            C0217a() {
            }

            @Override // i0.a.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DecodeJob<?> create() {
                a aVar = a.this;
                return new DecodeJob<>(aVar.f31706a, aVar.f31707b);
            }
        }

        a(DecodeJob.e eVar) {
            this.f31706a = eVar;
        }

        <R> DecodeJob<R> a(com.bumptech.glide.d dVar, Object obj, j jVar, com.bumptech.glide.load.c cVar, int i3, int i16, Class<?> cls, Class<R> cls2, Priority priority, g gVar, Map<Class<?>, com.bumptech.glide.load.h<?>> map, boolean z16, boolean z17, boolean z18, com.bumptech.glide.load.e eVar, DecodeJob.b<R> bVar) {
            DecodeJob decodeJob = (DecodeJob) h0.j.d(this.f31707b.acquire());
            int i17 = this.f31708c;
            this.f31708c = i17 + 1;
            return decodeJob.n(dVar, obj, jVar, cVar, i3, i16, cls, cls2, priority, gVar, map, z16, z17, z18, eVar, bVar, i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final GlideExecutor f31710a;

        /* renamed from: b, reason: collision with root package name */
        final GlideExecutor f31711b;

        /* renamed from: c, reason: collision with root package name */
        final GlideExecutor f31712c;

        /* renamed from: d, reason: collision with root package name */
        final GlideExecutor f31713d;

        /* renamed from: e, reason: collision with root package name */
        final i f31714e;

        /* renamed from: f, reason: collision with root package name */
        final l.a f31715f;

        /* renamed from: g, reason: collision with root package name */
        final Pools.Pool<EngineJob<?>> f31716g = i0.a.d(150, new a());

        /* compiled from: P */
        /* loaded from: classes.dex */
        class a implements a.d<EngineJob<?>> {
            a() {
            }

            @Override // i0.a.d
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public EngineJob<?> create() {
                b bVar = b.this;
                return new EngineJob<>(bVar.f31710a, bVar.f31711b, bVar.f31712c, bVar.f31713d, bVar.f31714e, bVar.f31715f, bVar.f31716g);
            }
        }

        b(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, i iVar, l.a aVar) {
            this.f31710a = glideExecutor;
            this.f31711b = glideExecutor2;
            this.f31712c = glideExecutor3;
            this.f31713d = glideExecutor4;
            this.f31714e = iVar;
            this.f31715f = aVar;
        }

        <R> EngineJob<R> a(com.bumptech.glide.load.c cVar, boolean z16, boolean z17, boolean z18, boolean z19) {
            return ((EngineJob) h0.j.d(this.f31716g.acquire())).l(cVar, z16, z17, z18, z19);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class c implements DecodeJob.e {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC11197a f31718a;

        /* renamed from: b, reason: collision with root package name */
        private volatile s.a f31719b;

        c(a.InterfaceC11197a interfaceC11197a) {
            this.f31718a = interfaceC11197a;
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.e
        public s.a a() {
            if (this.f31719b == null) {
                synchronized (this) {
                    if (this.f31719b == null) {
                        this.f31719b = this.f31718a.build();
                    }
                    if (this.f31719b == null) {
                        this.f31719b = new s.b();
                    }
                }
            }
            return this.f31719b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        private final EngineJob<?> f31720a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.request.f f31721b;

        d(com.bumptech.glide.request.f fVar, EngineJob<?> engineJob) {
            this.f31721b = fVar;
            this.f31720a = engineJob;
        }

        public void a() {
            synchronized (h.this) {
                this.f31720a.r(this.f31721b);
            }
        }
    }

    public h(s.h hVar, a.InterfaceC11197a interfaceC11197a, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z16) {
        this(hVar, interfaceC11197a, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, z16);
    }

    private l<?> e(com.bumptech.glide.load.c cVar) {
        q<?> b16 = this.f31700c.b(cVar);
        if (b16 == null) {
            return null;
        }
        if (b16 instanceof l) {
            return (l) b16;
        }
        return new l<>(b16, true, true, cVar, this);
    }

    @Nullable
    private l<?> g(com.bumptech.glide.load.c cVar) {
        l<?> e16 = this.f31705h.e(cVar);
        if (e16 != null) {
            e16.a();
        }
        return e16;
    }

    private l<?> h(com.bumptech.glide.load.c cVar) {
        l<?> e16 = e(cVar);
        if (e16 != null) {
            e16.a();
            this.f31705h.a(cVar, e16);
        }
        return e16;
    }

    @Nullable
    private l<?> i(j jVar, boolean z16, long j3) {
        if (!z16) {
            return null;
        }
        l<?> g16 = g(jVar);
        if (g16 != null) {
            if (f31697i) {
                j("Loaded resource from active resources", j3, jVar);
            }
            return g16;
        }
        l<?> h16 = h(jVar);
        if (h16 == null) {
            return null;
        }
        if (f31697i) {
            j("Loaded resource from cache", j3, jVar);
        }
        return h16;
    }

    private static void j(String str, long j3, com.bumptech.glide.load.c cVar) {
        Log.v("Engine", str + " in " + h0.f.a(j3) + "ms, key: " + cVar);
    }

    private <R> d l(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.c cVar, int i3, int i16, Class<?> cls, Class<R> cls2, Priority priority, g gVar, Map<Class<?>, com.bumptech.glide.load.h<?>> map, boolean z16, boolean z17, com.bumptech.glide.load.e eVar, boolean z18, boolean z19, boolean z26, boolean z27, com.bumptech.glide.request.f fVar, Executor executor, j jVar, long j3) {
        EngineJob<?> a16 = this.f31698a.a(jVar, z27);
        if (a16 != null) {
            a16.d(fVar, executor);
            if (f31697i) {
                j("Added to existing load", j3, jVar);
            }
            return new d(fVar, a16);
        }
        EngineJob<R> a17 = this.f31701d.a(jVar, z18, z19, z26, z27);
        DecodeJob<R> a18 = this.f31704g.a(dVar, obj, jVar, cVar, i3, i16, cls, cls2, priority, gVar, map, z16, z17, z27, eVar, a17);
        this.f31698a.c(jVar, a17);
        a17.d(fVar, executor);
        a17.s(a18);
        if (f31697i) {
            j("Started new load", j3, jVar);
        }
        return new d(fVar, a17);
    }

    @Override // com.bumptech.glide.load.engine.l.a
    public void a(com.bumptech.glide.load.c cVar, l<?> lVar) {
        this.f31705h.d(cVar);
        if (lVar.c()) {
            this.f31700c.c(cVar, lVar);
        } else {
            this.f31702e.a(lVar, false);
        }
    }

    @Override // com.bumptech.glide.load.engine.i
    public synchronized void b(EngineJob<?> engineJob, com.bumptech.glide.load.c cVar) {
        this.f31698a.d(cVar, engineJob);
    }

    @Override // s.h.a
    public void c(@NonNull q<?> qVar) {
        this.f31702e.a(qVar, true);
    }

    @Override // com.bumptech.glide.load.engine.i
    public synchronized void d(EngineJob<?> engineJob, com.bumptech.glide.load.c cVar, l<?> lVar) {
        if (lVar != null) {
            if (lVar.c()) {
                this.f31705h.a(cVar, lVar);
            }
        }
        this.f31698a.d(cVar, engineJob);
    }

    public <R> d f(com.bumptech.glide.d dVar, Object obj, com.bumptech.glide.load.c cVar, int i3, int i16, Class<?> cls, Class<R> cls2, Priority priority, g gVar, Map<Class<?>, com.bumptech.glide.load.h<?>> map, boolean z16, boolean z17, com.bumptech.glide.load.e eVar, boolean z18, boolean z19, boolean z26, boolean z27, com.bumptech.glide.request.f fVar, Executor executor) {
        long b16 = f31697i ? h0.f.b() : 0L;
        j a16 = this.f31699b.a(obj, cVar, i3, i16, map, cls, cls2, eVar);
        synchronized (this) {
            l<?> i17 = i(a16, z18, b16);
            if (i17 == null) {
                return l(dVar, obj, cVar, i3, i16, cls, cls2, priority, gVar, map, z16, z17, eVar, z18, z19, z26, z27, fVar, executor, a16, b16);
            }
            fVar.b(i17, DataSource.MEMORY_CACHE, false);
            return null;
        }
    }

    public void k(q<?> qVar) {
        if (qVar instanceof l) {
            ((l) qVar).d();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    h(s.h hVar, a.InterfaceC11197a interfaceC11197a, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, n nVar, k kVar, ActiveResources activeResources, b bVar, a aVar, t tVar, boolean z16) {
        this.f31700c = hVar;
        c cVar = new c(interfaceC11197a);
        this.f31703f = cVar;
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z16) : activeResources;
        this.f31705h = activeResources2;
        activeResources2.f(this);
        this.f31699b = kVar == null ? new k() : kVar;
        this.f31698a = nVar == null ? new n() : nVar;
        this.f31701d = bVar == null ? new b(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : bVar;
        this.f31704g = aVar == null ? new a(cVar) : aVar;
        this.f31702e = tVar == null ? new t() : tVar;
        hVar.d(this);
    }
}
