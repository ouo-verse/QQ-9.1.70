package com.android.volley;

import android.os.SystemClock;
import com.android.volley.b;
import com.android.volley.c;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes.dex */
public class AsyncRequestQueue extends RequestQueue {

    /* compiled from: P */
    /* renamed from: com.android.volley.AsyncRequestQueue$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ AsyncRequestQueue this$0;

        /* compiled from: P */
        /* renamed from: com.android.volley.AsyncRequestQueue$1$a */
        /* loaded from: classes.dex */
        class a {
            a() {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncRequestQueue.l(null);
            new a();
            throw null;
        }
    }

    /* compiled from: P */
    /* renamed from: com.android.volley.AsyncRequestQueue$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ AsyncRequestQueue this$0;

        /* compiled from: P */
        /* renamed from: com.android.volley.AsyncRequestQueue$2$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AnonymousClass2 f31285d;

            @Override // java.lang.Runnable
            public void run() {
                this.f31285d.getClass();
                AsyncRequestQueue.k(null);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class CacheParseTask<T> extends RequestTask<T> {

        /* renamed from: e, reason: collision with root package name */
        c.a f31286e;

        /* renamed from: f, reason: collision with root package name */
        long f31287f;
        final /* synthetic */ AsyncRequestQueue this$0;

        /* compiled from: P */
        /* renamed from: com.android.volley.AsyncRequestQueue$CacheParseTask$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CacheParseTask f31288d;

            @Override // java.lang.Runnable
            public void run() {
                this.f31288d.getClass();
                Request<T> request = this.f31288d.f31316d;
                throw null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f31316d.addMarker("cache-hit");
            Request<T> request = this.f31316d;
            c.a aVar = this.f31286e;
            h<T> parseNetworkResponse = request.parseNetworkResponse(new g(200, aVar.f31317a, false, 0L, aVar.f31324h));
            this.f31316d.addMarker("cache-hit-parsed");
            if (this.f31286e.c(this.f31287f)) {
                this.f31316d.addMarker("cache-hit-refresh-needed");
                this.f31316d.setCacheEntry(this.f31286e);
                parseNetworkResponse.f31340d = true;
                if (!AsyncRequestQueue.m(null).c(this.f31316d)) {
                    throw null;
                }
                throw null;
            }
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class CachePutTask<T> extends RequestTask<T> {

        /* renamed from: e, reason: collision with root package name */
        h<?> f31289e;
        final /* synthetic */ AsyncRequestQueue this$0;

        CachePutTask(AsyncRequestQueue asyncRequestQueue, Request<T> request, h<?> hVar) {
            super(request);
            this.f31289e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            AsyncRequestQueue.l(null);
            throw null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class CacheTask<T> extends RequestTask<T> {
        final /* synthetic */ AsyncRequestQueue this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f31316d.isCanceled()) {
                this.f31316d.finish("cache-discard-canceled");
            } else {
                this.f31316d.addMarker("cache-queue-take");
                AsyncRequestQueue.l(null);
                throw null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class NetworkParseTask<T> extends RequestTask<T> {

        /* renamed from: e, reason: collision with root package name */
        g f31290e;
        final /* synthetic */ AsyncRequestQueue this$0;

        @Override // java.lang.Runnable
        public void run() {
            h<T> parseNetworkResponse = this.f31316d.parseNetworkResponse(this.f31290e);
            this.f31316d.addMarker("network-parse-complete");
            if (this.f31316d.shouldCache() && parseNetworkResponse.f31338b != null) {
                AsyncRequestQueue.l(null);
                AsyncRequestQueue.n(null).execute(new CachePutTask(null, this.f31316d, parseNetworkResponse));
            } else {
                AsyncRequestQueue.p(null, this.f31316d, parseNetworkResponse, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class NetworkTask<T> extends RequestTask<T> {
        final /* synthetic */ AsyncRequestQueue this$0;

        /* compiled from: P */
        /* loaded from: classes.dex */
        class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f31291a;

            a(long j3) {
                this.f31291a = j3;
            }

            @Override // com.android.volley.b.a
            public void a(VolleyError volleyError) {
                volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - this.f31291a);
                NetworkTask.this.getClass();
                ExecutorService n3 = AsyncRequestQueue.n(null);
                NetworkTask.this.getClass();
                n3.execute(new ParseErrorTask(null, NetworkTask.this.f31316d, volleyError));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f31316d.isCanceled()) {
                this.f31316d.finish("network-discard-cancelled");
                this.f31316d.notifyListenerResponseNotUsable();
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f31316d.addMarker("network-queue-take");
                AsyncRequestQueue.o(null);
                new a(elapsedRealtime);
                throw null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class ParseErrorTask<T> extends RequestTask<T> {

        /* renamed from: e, reason: collision with root package name */
        VolleyError f31293e;
        final /* synthetic */ AsyncRequestQueue this$0;

        ParseErrorTask(AsyncRequestQueue asyncRequestQueue, Request<T> request, VolleyError volleyError) {
            super(request);
            this.f31293e = volleyError;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f31316d.parseNetworkError(this.f31293e);
            throw null;
        }
    }

    static /* synthetic */ void k(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    static /* synthetic */ a l(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    static /* synthetic */ l m(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    static /* synthetic */ ExecutorService n(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    static /* synthetic */ b o(AsyncRequestQueue asyncRequestQueue) {
        throw null;
    }

    static /* synthetic */ void p(AsyncRequestQueue asyncRequestQueue, Request request, h hVar, boolean z16) {
        throw null;
    }
}
