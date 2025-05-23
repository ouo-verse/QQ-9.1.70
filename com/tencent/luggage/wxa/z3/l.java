package com.tencent.luggage.wxa.z3;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.wxa.z3.c;
import com.tencent.luggage.wxa.z3.d;
import com.tencent.luggage.wxa.z3.e;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes9.dex */
public class l {

    /* renamed from: c, reason: collision with root package name */
    public static l f146245c;

    /* renamed from: a, reason: collision with root package name */
    public ExecutorService f146246a = ProxyExecutors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    public Handler f146247b = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z3.c f146248a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c.a f146249b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.z3.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC6970a implements Runnable {
            public RunnableC6970a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f146249b.a();
            }
        }

        public a(com.tencent.luggage.wxa.z3.c cVar, c.a aVar) {
            this.f146248a = cVar;
            this.f146249b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f146248a.call();
                if (this.f146249b != null) {
                    l.this.f146247b.post(new RunnableC6970a());
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z3.e f146252a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e.a f146253b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f146253b.a();
            }
        }

        public b(com.tencent.luggage.wxa.z3.e eVar, e.a aVar) {
            this.f146252a = eVar;
            this.f146253b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f146252a.call();
                if (this.f146253b != null) {
                    l.this.f146247b.post(new a());
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f146256a;

        public c(f fVar) {
            this.f146256a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f146256a.call();
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z3.b f146258a;

        public d(com.tencent.luggage.wxa.z3.b bVar) {
            this.f146258a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f146258a.call();
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z3.d f146260a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d.a f146261b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f146261b.a();
            }
        }

        public e(com.tencent.luggage.wxa.z3.d dVar, d.a aVar) {
            this.f146260a = dVar;
            this.f146261b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f146260a.call();
                if (this.f146261b != null) {
                    l.this.f146247b.post(new a());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static l a() {
        if (f146245c == null) {
            synchronized (l.class) {
                if (f146245c == null) {
                    f146245c = new l();
                }
            }
        }
        return f146245c;
    }

    public void a(com.tencent.luggage.wxa.z3.c cVar, c.a aVar) {
        this.f146246a.submit(new a(cVar, aVar));
    }

    public void a(com.tencent.luggage.wxa.z3.e eVar, e.a aVar) {
        this.f146246a.submit(new b(eVar, aVar));
    }

    public void a(f fVar) {
        this.f146246a.submit(new c(fVar));
    }

    public void a(com.tencent.luggage.wxa.z3.b bVar) {
        this.f146246a.submit(new d(bVar));
    }

    public void a(com.tencent.luggage.wxa.z3.d dVar, d.a aVar) {
        this.f146246a.submit(new e(dVar, aVar));
    }
}
