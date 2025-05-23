package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.d;
import com.bumptech.glide.load.engine.f;
import i0.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
class DecodeJob<R> implements d.a, Runnable, Comparable<DecodeJob<?>>, a.f {
    private com.bumptech.glide.d D;
    private com.bumptech.glide.load.c E;
    private Priority F;
    private j G;
    private int H;
    private int I;
    private g J;
    private com.bumptech.glide.load.e K;
    private b<R> L;
    private int M;
    private Stage N;
    private RunReason P;
    private long Q;
    private boolean R;
    private Object S;
    private Thread T;
    private com.bumptech.glide.load.c U;
    private com.bumptech.glide.load.c V;
    private Object W;
    private DataSource X;
    private com.bumptech.glide.load.data.d<?> Y;
    private volatile com.bumptech.glide.load.engine.d Z;

    /* renamed from: a0, reason: collision with root package name */
    private volatile boolean f31607a0;

    /* renamed from: b0, reason: collision with root package name */
    private volatile boolean f31608b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f31609c0;

    /* renamed from: h, reason: collision with root package name */
    private final e f31613h;

    /* renamed from: i, reason: collision with root package name */
    private final Pools.Pool<DecodeJob<?>> f31614i;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.e<R> f31610d = new com.bumptech.glide.load.engine.e<>();

    /* renamed from: e, reason: collision with root package name */
    private final List<Throwable> f31611e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final i0.c f31612f = i0.c.a();

    /* renamed from: m, reason: collision with root package name */
    private final d<?> f31615m = new d<>();
    private final f C = new f();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31616a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f31617b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f31618c;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            f31618c = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31618c[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            f31617b = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31617b[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31617b[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31617b[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31617b[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            f31616a = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31616a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31616a[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b<R> {
        void a(GlideException glideException);

        void b(q<R> qVar, DataSource dataSource, boolean z16);

        void c(DecodeJob<?> decodeJob);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class c<Z> implements f.a<Z> {

        /* renamed from: a, reason: collision with root package name */
        private final DataSource f31619a;

        c(DataSource dataSource) {
            this.f31619a = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.f.a
        @NonNull
        public q<Z> a(@NonNull q<Z> qVar) {
            return DecodeJob.this.v(this.f31619a, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class d<Z> {

        /* renamed from: a, reason: collision with root package name */
        private com.bumptech.glide.load.c f31621a;

        /* renamed from: b, reason: collision with root package name */
        private com.bumptech.glide.load.g<Z> f31622b;

        /* renamed from: c, reason: collision with root package name */
        private p<Z> f31623c;

        d() {
        }

        void a() {
            this.f31621a = null;
            this.f31622b = null;
            this.f31623c = null;
        }

        void b(e eVar, com.bumptech.glide.load.e eVar2) {
            i0.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f31621a, new com.bumptech.glide.load.engine.c(this.f31622b, this.f31623c, eVar2));
            } finally {
                this.f31623c.d();
                i0.b.d();
            }
        }

        boolean c() {
            if (this.f31623c != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void d(com.bumptech.glide.load.c cVar, com.bumptech.glide.load.g<X> gVar, p<X> pVar) {
            this.f31621a = cVar;
            this.f31622b = gVar;
            this.f31623c = pVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface e {
        s.a a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f31624a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f31625b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f31626c;

        f() {
        }

        private boolean a(boolean z16) {
            if ((this.f31626c || z16 || this.f31625b) && this.f31624a) {
                return true;
            }
            return false;
        }

        synchronized boolean b() {
            this.f31625b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.f31626c = true;
            return a(false);
        }

        synchronized boolean d(boolean z16) {
            this.f31624a = true;
            return a(z16);
        }

        synchronized void e() {
            this.f31625b = false;
            this.f31624a = false;
            this.f31626c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob(e eVar, Pools.Pool<DecodeJob<?>> pool) {
        this.f31613h = eVar;
        this.f31614i = pool;
    }

    private void A() {
        int i3 = a.f31616a[this.P.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    j();
                    return;
                }
                throw new IllegalStateException("Unrecognized run reason: " + this.P);
            }
            y();
            return;
        }
        this.N = l(Stage.INITIALIZE);
        this.Z = k();
        y();
    }

    private void B() {
        Throwable th5;
        this.f31612f.c();
        if (this.f31607a0) {
            if (this.f31611e.isEmpty()) {
                th5 = null;
            } else {
                List<Throwable> list = this.f31611e;
                th5 = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th5);
        }
        this.f31607a0 = true;
    }

    private <Data> q<R> f(com.bumptech.glide.load.data.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dVar.cleanup();
            return null;
        }
        try {
            long b16 = h0.f.b();
            q<R> g16 = g(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + g16, b16);
            }
            return g16;
        } finally {
            dVar.cleanup();
        }
    }

    private <Data> q<R> g(Data data, DataSource dataSource) throws GlideException {
        return z(data, dataSource, this.f31610d.h(data.getClass()));
    }

    private int getPriority() {
        return this.F.ordinal();
    }

    private void j() {
        q<R> qVar;
        if (Log.isLoggable("DecodeJob", 2)) {
            p("Retrieved data", this.Q, "data: " + this.W + ", cache key: " + this.U + ", fetcher: " + this.Y);
        }
        try {
            qVar = f(this.Y, this.W, this.X);
        } catch (GlideException e16) {
            e16.setLoggingDetails(this.V, this.X);
            this.f31611e.add(e16);
            qVar = null;
        }
        if (qVar != null) {
            r(qVar, this.X, this.f31609c0);
        } else {
            y();
        }
    }

    private com.bumptech.glide.load.engine.d k() {
        int i3 = a.f31617b[this.N.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: " + this.N);
                }
                return new u(this.f31610d, this);
            }
            return new com.bumptech.glide.load.engine.a(this.f31610d, this);
        }
        return new r(this.f31610d, this);
    }

    private Stage l(Stage stage) {
        int i3 = a.f31617b[stage.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    if (i3 == 5) {
                        if (this.J.b()) {
                            return Stage.RESOURCE_CACHE;
                        }
                        return l(Stage.RESOURCE_CACHE);
                    }
                    throw new IllegalArgumentException("Unrecognized stage: " + stage);
                }
                return Stage.FINISHED;
            }
            if (this.R) {
                return Stage.FINISHED;
            }
            return Stage.SOURCE;
        }
        if (this.J.a()) {
            return Stage.DATA_CACHE;
        }
        return l(Stage.DATA_CACHE);
    }

    @NonNull
    private com.bumptech.glide.load.e m(DataSource dataSource) {
        boolean z16;
        com.bumptech.glide.load.e eVar = this.K;
        if (Build.VERSION.SDK_INT < 26) {
            return eVar;
        }
        if (dataSource != DataSource.RESOURCE_DISK_CACHE && !this.f31610d.w()) {
            z16 = false;
        } else {
            z16 = true;
        }
        com.bumptech.glide.load.d<Boolean> dVar = com.bumptech.glide.load.resource.bitmap.q.f31839j;
        Boolean bool = (Boolean) eVar.c(dVar);
        if (bool != null && (!bool.booleanValue() || z16)) {
            return eVar;
        }
        com.bumptech.glide.load.e eVar2 = new com.bumptech.glide.load.e();
        eVar2.d(this.K);
        eVar2.e(dVar, Boolean.valueOf(z16));
        return eVar2;
    }

    private void o(String str, long j3) {
        p(str, j3, null);
    }

    private void p(String str, long j3, String str2) {
        String str3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(" in ");
        sb5.append(h0.f.a(j3));
        sb5.append(", load key: ");
        sb5.append(this.G);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb5.append(str3);
        sb5.append(", thread: ");
        sb5.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb5.toString());
    }

    private void q(q<R> qVar, DataSource dataSource, boolean z16) {
        B();
        this.L.b(qVar, dataSource, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r(q<R> qVar, DataSource dataSource, boolean z16) {
        p pVar;
        if (qVar instanceof m) {
            ((m) qVar).initialize();
        }
        if (this.f31615m.c()) {
            qVar = p.b(qVar);
            pVar = qVar;
        } else {
            pVar = 0;
        }
        q(qVar, dataSource, z16);
        this.N = Stage.ENCODE;
        try {
            if (this.f31615m.c()) {
                this.f31615m.b(this.f31613h, this.K);
            }
            t();
        } finally {
            if (pVar != 0) {
                pVar.d();
            }
        }
    }

    private void s() {
        B();
        this.L.a(new GlideException("Failed to load resource", new ArrayList(this.f31611e)));
        u();
    }

    private void t() {
        if (this.C.b()) {
            x();
        }
    }

    private void u() {
        if (this.C.c()) {
            x();
        }
    }

    private void x() {
        this.C.e();
        this.f31615m.a();
        this.f31610d.a();
        this.f31607a0 = false;
        this.D = null;
        this.E = null;
        this.K = null;
        this.F = null;
        this.G = null;
        this.L = null;
        this.N = null;
        this.Z = null;
        this.T = null;
        this.U = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Q = 0L;
        this.f31608b0 = false;
        this.S = null;
        this.f31611e.clear();
        this.f31614i.release(this);
    }

    private void y() {
        this.T = Thread.currentThread();
        this.Q = h0.f.b();
        boolean z16 = false;
        while (!this.f31608b0 && this.Z != null && !(z16 = this.Z.a())) {
            this.N = l(this.N);
            this.Z = k();
            if (this.N == Stage.SOURCE) {
                i();
                return;
            }
        }
        if ((this.N == Stage.FINISHED || this.f31608b0) && !z16) {
            s();
        }
    }

    private <Data, ResourceType> q<R> z(Data data, DataSource dataSource, o<Data, ResourceType, R> oVar) throws GlideException {
        com.bumptech.glide.load.e m3 = m(dataSource);
        com.bumptech.glide.load.data.e<Data> l3 = this.D.i().l(data);
        try {
            return oVar.a(l3, m3, this.H, this.I, new c(dataSource));
        } finally {
            l3.cleanup();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C() {
        Stage l3 = l(Stage.INITIALIZE);
        if (l3 != Stage.RESOURCE_CACHE && l3 != Stage.DATA_CACHE) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.engine.d.a
    public void c(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.U = cVar;
        this.W = obj;
        this.Y = dVar;
        this.X = dataSource;
        this.V = cVar2;
        boolean z16 = false;
        if (cVar != this.f31610d.c().get(0)) {
            z16 = true;
        }
        this.f31609c0 = z16;
        if (Thread.currentThread() != this.T) {
            this.P = RunReason.DECODE_DATA;
            this.L.c(this);
        } else {
            i0.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                j();
            } finally {
                i0.b.d();
            }
        }
    }

    public void cancel() {
        this.f31608b0 = true;
        com.bumptech.glide.load.engine.d dVar = this.Z;
        if (dVar != null) {
            dVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.d.a
    public void d(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        dVar.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.a());
        this.f31611e.add(glideException);
        if (Thread.currentThread() != this.T) {
            this.P = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.L.c(this);
        } else {
            y();
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int priority = getPriority() - decodeJob.getPriority();
        if (priority == 0) {
            return this.M - decodeJob.M;
        }
        return priority;
    }

    @Override // i0.a.f
    @NonNull
    public i0.c h() {
        return this.f31612f;
    }

    @Override // com.bumptech.glide.load.engine.d.a
    public void i() {
        this.P = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.L.c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodeJob<R> n(com.bumptech.glide.d dVar, Object obj, j jVar, com.bumptech.glide.load.c cVar, int i3, int i16, Class<?> cls, Class<R> cls2, Priority priority, g gVar, Map<Class<?>, com.bumptech.glide.load.h<?>> map, boolean z16, boolean z17, boolean z18, com.bumptech.glide.load.e eVar, b<R> bVar, int i17) {
        this.f31610d.u(dVar, obj, cVar, i3, i16, gVar, cls, cls2, priority, eVar, map, z16, z17, this.f31613h);
        this.D = dVar;
        this.E = cVar;
        this.F = priority;
        this.G = jVar;
        this.H = i3;
        this.I = i16;
        this.J = gVar;
        this.R = z18;
        this.K = eVar;
        this.L = bVar;
        this.M = i17;
        this.P = RunReason.INITIALIZE;
        this.S = obj;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        i0.b.b("DecodeJob#run(model=%s)", this.S);
        com.bumptech.glide.load.data.d<?> dVar = this.Y;
        try {
            try {
                try {
                    if (this.f31608b0) {
                        s();
                        if (dVar != null) {
                            dVar.cleanup();
                        }
                        i0.b.d();
                        return;
                    }
                    A();
                    if (dVar != null) {
                        dVar.cleanup();
                    }
                    i0.b.d();
                } catch (Throwable th5) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.f31608b0 + ", stage: " + this.N, th5);
                    }
                    if (this.N != Stage.ENCODE) {
                        this.f31611e.add(th5);
                        s();
                    }
                    if (!this.f31608b0) {
                        throw th5;
                    }
                    throw th5;
                }
            } catch (CallbackException e16) {
                throw e16;
            }
        } catch (Throwable th6) {
            if (dVar != null) {
                dVar.cleanup();
            }
            i0.b.d();
            throw th6;
        }
    }

    @NonNull
    <Z> q<Z> v(DataSource dataSource, @NonNull q<Z> qVar) {
        q<Z> qVar2;
        com.bumptech.glide.load.h<Z> hVar;
        EncodeStrategy encodeStrategy;
        com.bumptech.glide.load.c bVar;
        Class<?> cls = qVar.get().getClass();
        com.bumptech.glide.load.g<Z> gVar = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            com.bumptech.glide.load.h<Z> r16 = this.f31610d.r(cls);
            hVar = r16;
            qVar2 = r16.a(this.D, qVar, this.H, this.I);
        } else {
            qVar2 = qVar;
            hVar = null;
        }
        if (!qVar.equals(qVar2)) {
            qVar.recycle();
        }
        if (this.f31610d.v(qVar2)) {
            gVar = this.f31610d.n(qVar2);
            encodeStrategy = gVar.b(this.K);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        com.bumptech.glide.load.g gVar2 = gVar;
        if (this.J.d(!this.f31610d.x(this.U), dataSource, encodeStrategy)) {
            if (gVar2 != null) {
                int i3 = a.f31618c[encodeStrategy.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        bVar = new s(this.f31610d.b(), this.U, this.E, this.H, this.I, hVar, cls, this.K);
                    } else {
                        throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                    }
                } else {
                    bVar = new com.bumptech.glide.load.engine.b(this.U, this.E);
                }
                p b16 = p.b(qVar2);
                this.f31615m.d(bVar, gVar2, b16);
                return b16;
            }
            throw new Registry.NoResultEncoderAvailableException(qVar2.get().getClass());
        }
        return qVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(boolean z16) {
        if (this.C.d(z16)) {
            x();
        }
    }
}
