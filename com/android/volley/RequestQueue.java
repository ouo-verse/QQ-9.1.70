package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes.dex */
public class RequestQueue {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f31303a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Request<?>> f31304b;

    /* renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue<Request<?>> f31305c;

    /* renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<Request<?>> f31306d;

    /* renamed from: e, reason: collision with root package name */
    private final com.android.volley.c f31307e;

    /* renamed from: f, reason: collision with root package name */
    private final f f31308f;

    /* renamed from: g, reason: collision with root package name */
    private final i f31309g;

    /* renamed from: h, reason: collision with root package name */
    private final NetworkDispatcher[] f31310h;

    /* renamed from: i, reason: collision with root package name */
    private CacheDispatcher f31311i;

    /* renamed from: j, reason: collision with root package name */
    private final List<d> f31312j;

    /* renamed from: k, reason: collision with root package name */
    private final List<b> f31313k;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface RequestEvent {
        public static final int REQUEST_CACHE_LOOKUP_FINISHED = 2;
        public static final int REQUEST_CACHE_LOOKUP_STARTED = 1;
        public static final int REQUEST_FINISHED = 5;
        public static final int REQUEST_NETWORK_DISPATCH_FINISHED = 4;
        public static final int REQUEST_NETWORK_DISPATCH_STARTED = 3;
        public static final int REQUEST_QUEUED = 0;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f31314a;

        a(Object obj) {
            this.f31314a = obj;
        }

        @Override // com.android.volley.RequestQueue.c
        public boolean a(Request<?> request) {
            if (request.getTag() == this.f31314a) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b {
        void a(Request<?> request, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface c {
        boolean a(Request<?> request);
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes.dex */
    public interface d<T> {
        void a(Request<T> request);
    }

    public RequestQueue(com.android.volley.c cVar, f fVar, int i3, i iVar) {
        this.f31303a = new AtomicInteger();
        this.f31304b = new HashSet();
        this.f31305c = new PriorityBlockingQueue<>();
        this.f31306d = new PriorityBlockingQueue<>();
        this.f31312j = new ArrayList();
        this.f31313k = new ArrayList();
        this.f31307e = cVar;
        this.f31308f = fVar;
        this.f31310h = new NetworkDispatcher[i3];
        this.f31309g = iVar;
    }

    public <T> Request<T> a(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.f31304b) {
            this.f31304b.add(request);
        }
        request.setSequence(f());
        request.addMarker("add-to-queue");
        g(request, 0);
        b(request);
        return request;
    }

    <T> void b(Request<T> request) {
        if (!request.shouldCache()) {
            h(request);
        } else {
            this.f31305c.add(request);
        }
    }

    public void c(c cVar) {
        synchronized (this.f31304b) {
            for (Request<?> request : this.f31304b) {
                if (cVar.a(request)) {
                    request.cancel();
                }
            }
        }
    }

    public void d(Object obj) {
        if (obj != null) {
            c(new a(obj));
            return;
        }
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void e(Request<T> request) {
        synchronized (this.f31304b) {
            this.f31304b.remove(request);
        }
        synchronized (this.f31312j) {
            Iterator<d> it = this.f31312j.iterator();
            while (it.hasNext()) {
                it.next().a(request);
            }
        }
        g(request, 5);
    }

    public int f() {
        return this.f31303a.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Request<?> request, int i3) {
        synchronized (this.f31313k) {
            Iterator<b> it = this.f31313k.iterator();
            while (it.hasNext()) {
                it.next().a(request, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void h(Request<T> request) {
        this.f31306d.add(request);
    }

    public void i() {
        j();
        CacheDispatcher cacheDispatcher = new CacheDispatcher(this.f31305c, this.f31306d, this.f31307e, this.f31309g);
        this.f31311i = cacheDispatcher;
        cacheDispatcher.start();
        for (int i3 = 0; i3 < this.f31310h.length; i3++) {
            NetworkDispatcher networkDispatcher = new NetworkDispatcher(this.f31306d, this.f31308f, this.f31307e, this.f31309g);
            this.f31310h[i3] = networkDispatcher;
            networkDispatcher.start();
        }
    }

    public void j() {
        CacheDispatcher cacheDispatcher = this.f31311i;
        if (cacheDispatcher != null) {
            cacheDispatcher.quit();
        }
        for (NetworkDispatcher networkDispatcher : this.f31310h) {
            if (networkDispatcher != null) {
                networkDispatcher.quit();
            }
        }
    }

    public RequestQueue(com.android.volley.c cVar, f fVar, int i3) {
        this(cVar, fVar, i3, new ExecutorDelivery(new Handler(Looper.getMainLooper())));
    }

    public RequestQueue(com.android.volley.c cVar, f fVar) {
        this(cVar, fVar, 4);
    }
}
