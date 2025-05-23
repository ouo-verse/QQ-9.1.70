package com.tencent.luggage.wxa.zp;

import android.content.Context;
import com.tencent.luggage.wxa.zp.b;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h implements com.tencent.luggage.wxa.zp.i, com.tencent.luggage.wxa.zp.c {

    /* renamed from: d, reason: collision with root package name */
    public static com.tencent.luggage.wxa.zp.i f146825d;

    /* renamed from: e, reason: collision with root package name */
    public static com.tencent.luggage.wxa.zp.c f146826e;

    /* renamed from: a, reason: collision with root package name */
    public AtomicBoolean f146827a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.zp.a f146828b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.iq.e f146829c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f146830a;

        public a(long j3) {
            this.f146830a = j3;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.h a(Runnable runnable) {
            com.tencent.luggage.wxa.jq.h a16 = com.tencent.luggage.wxa.aq.a.a(runnable, this.f146830a, (String) null);
            if (runnable instanceof com.tencent.luggage.wxa.jq.d) {
                ((com.tencent.luggage.wxa.jq.d) runnable).a(a16);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f146832a;

        public b(boolean z16) {
            this.f146832a = z16;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.c a(com.tencent.luggage.wxa.jq.h hVar) {
            return h.this.f146829c.a(hVar, this.f146832a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f146834a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f146835b;

        public c(long j3, String str) {
            this.f146834a = j3;
            this.f146835b = str;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.h a(Runnable runnable) {
            com.tencent.luggage.wxa.jq.h a16 = com.tencent.luggage.wxa.aq.a.a(runnable, this.f146834a, this.f146835b);
            if (runnable instanceof com.tencent.luggage.wxa.jq.d) {
                ((com.tencent.luggage.wxa.jq.d) runnable).a(a16);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements com.tencent.luggage.wxa.eq.a {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.c a(com.tencent.luggage.wxa.jq.h hVar) {
            return h.this.f146829c.a(hVar, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f146838a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f146839b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f146840c;

        public e(long j3, long j16, boolean z16) {
            this.f146838a = j3;
            this.f146839b = j16;
            this.f146840c = z16;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.h a(Runnable runnable) {
            com.tencent.luggage.wxa.jq.h a16 = com.tencent.luggage.wxa.aq.a.a(runnable, this.f146838a, this.f146839b, this.f146840c);
            if (runnable instanceof com.tencent.luggage.wxa.jq.d) {
                ((com.tencent.luggage.wxa.jq.d) runnable).a(a16);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f146842a;

        public f(boolean z16) {
            this.f146842a = z16;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.c a(com.tencent.luggage.wxa.jq.h hVar) {
            return h.this.f146829c.d(hVar, this.f146842a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f146844a;

        public g(long j3) {
            this.f146844a = j3;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.h a(Callable callable) {
            com.tencent.luggage.wxa.jq.h a16 = com.tencent.luggage.wxa.aq.a.a(callable, this.f146844a, (String) null);
            if (callable instanceof com.tencent.luggage.wxa.jq.d) {
                ((com.tencent.luggage.wxa.jq.d) callable).a(a16);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.zp.h$h, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6997h implements com.tencent.luggage.wxa.eq.a {
        public C6997h() {
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.c a(com.tencent.luggage.wxa.jq.h hVar) {
            return h.this.f146829c.c(hVar, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f146847a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f146848b;

        public i(long j3, String str) {
            this.f146847a = j3;
            this.f146848b = str;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.h a(Callable callable) {
            com.tencent.luggage.wxa.jq.h a16 = com.tencent.luggage.wxa.aq.a.a(callable, this.f146847a, this.f146848b);
            if (callable instanceof com.tencent.luggage.wxa.jq.d) {
                ((com.tencent.luggage.wxa.jq.d) callable).a(a16);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class j implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f146850a;

        public j(boolean z16) {
            this.f146850a = z16;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.c a(com.tencent.luggage.wxa.jq.h hVar) {
            return h.this.f146829c.d(hVar, this.f146850a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f146852a;

        public k(long j3) {
            this.f146852a = j3;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.h a(Runnable runnable) {
            com.tencent.luggage.wxa.jq.h a16 = com.tencent.luggage.wxa.aq.a.a(runnable, this.f146852a, (String) null);
            if (runnable instanceof com.tencent.luggage.wxa.jq.d) {
                ((com.tencent.luggage.wxa.jq.d) runnable).a(a16);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l implements com.tencent.luggage.wxa.eq.a {
        public l() {
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.c a(com.tencent.luggage.wxa.jq.h hVar) {
            return h.this.f146829c.b(hVar, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class m implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f146855a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f146856b;

        public m(long j3, String str) {
            this.f146855a = j3;
            this.f146856b = str;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.h a(Runnable runnable) {
            com.tencent.luggage.wxa.jq.h a16 = com.tencent.luggage.wxa.aq.a.a(runnable, this.f146855a, this.f146856b);
            if (runnable instanceof com.tencent.luggage.wxa.jq.d) {
                ((com.tencent.luggage.wxa.jq.d) runnable).a(a16);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n implements com.tencent.luggage.wxa.eq.a {
        public n() {
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.c a(com.tencent.luggage.wxa.jq.h hVar) {
            return h.this.f146829c.c(hVar, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class o implements com.tencent.luggage.wxa.eq.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f146859a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f146860b;

        public o(long j3, String str) {
            this.f146859a = j3;
            this.f146860b = str;
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.h a(Runnable runnable) {
            com.tencent.luggage.wxa.jq.h a16 = com.tencent.luggage.wxa.aq.a.a(runnable, this.f146859a, this.f146860b);
            if (runnable instanceof com.tencent.luggage.wxa.jq.d) {
                ((com.tencent.luggage.wxa.jq.d) runnable).a(a16);
            }
            return a16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class p implements com.tencent.luggage.wxa.eq.a {
        public p() {
        }

        @Override // com.tencent.luggage.wxa.eq.a
        public com.tencent.luggage.wxa.jq.c a(com.tencent.luggage.wxa.jq.h hVar) {
            return h.this.f146829c.a(hVar, false);
        }
    }

    public h(com.tencent.luggage.wxa.zp.a aVar) {
        this.f146828b = aVar;
        this.f146829c = new com.tencent.luggage.wxa.iq.e(aVar);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c b(Runnable runnable, String str) {
        Objects.requireNonNull(runnable);
        return a(runnable, 0L, str);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c c(Runnable runnable, long j3) {
        Objects.requireNonNull(runnable);
        return a(runnable, j3, false);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c d(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return b(runnable, 0L);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c e(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return a(runnable, 0L, true);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c execute(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return a(runnable, 0L);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public boolean isShutdown() {
        return this.f146827a.get();
    }

    public static synchronized void a(Context context, com.tencent.luggage.wxa.zp.a aVar) {
        synchronized (h.class) {
            h hVar = new h(aVar);
            f146825d = hVar;
            f146826e = hVar;
        }
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c b(Runnable runnable, long j3) {
        Objects.requireNonNull(runnable);
        return d(runnable, j3, null);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c c(Runnable runnable, String str) {
        Objects.requireNonNull(runnable);
        return a(runnable, 0L, str, true);
    }

    public com.tencent.luggage.wxa.jq.c d(Runnable runnable, long j3) {
        Objects.requireNonNull(runnable);
        return e(runnable, j3, null);
    }

    public final com.tencent.luggage.wxa.jq.c e(Runnable runnable, long j3, String str) {
        return (com.tencent.luggage.wxa.jq.c) com.tencent.luggage.wxa.eq.e.a(runnable).b(new o(j3, str)).b(new n()).e();
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c a(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return a(runnable, 0L, false);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c b(Callable callable) {
        Objects.requireNonNull(callable);
        return a(callable, 0L);
    }

    public com.tencent.luggage.wxa.jq.c c(Runnable runnable, long j3, String str) {
        Objects.requireNonNull(runnable);
        return d(runnable, j3, str);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c d(Runnable runnable, String str) {
        Objects.requireNonNull(runnable);
        return b(runnable, 0L, str);
    }

    public final com.tencent.luggage.wxa.jq.c e(Runnable runnable, long j3) {
        return (com.tencent.luggage.wxa.jq.c) com.tencent.luggage.wxa.eq.e.a(runnable).b(new a(j3)).b(new p()).e();
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c a(Callable callable) {
        Objects.requireNonNull(callable);
        return a(callable, 0L, false);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c b(Runnable runnable, long j3, String str) {
        Objects.requireNonNull(runnable);
        return e(runnable, j3, str);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c c(Runnable runnable) {
        Objects.requireNonNull(runnable);
        return d(runnable, 0L);
    }

    public final com.tencent.luggage.wxa.jq.c d(Runnable runnable, long j3, String str) {
        return (com.tencent.luggage.wxa.jq.c) com.tencent.luggage.wxa.eq.e.a(runnable).b(new m(j3, str)).b(new l()).e();
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c a(Runnable runnable, long j3) {
        Objects.requireNonNull(runnable);
        return e(runnable, j3);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c b(Runnable runnable, long j3, long j16) {
        Objects.requireNonNull(runnable);
        return a(runnable, j3, j16, true);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c a(Runnable runnable, long j3, String str) {
        Objects.requireNonNull(runnable);
        return a(runnable, j3, str, false);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c b(Runnable runnable) {
        return d(runnable);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c a(Runnable runnable, String str) {
        Objects.requireNonNull(runnable);
        return c(runnable, 0L, str);
    }

    public com.tencent.luggage.wxa.jq.c a(Callable callable, long j3) {
        Objects.requireNonNull(callable);
        return a(callable, j3, (String) null);
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.jq.c a(Runnable runnable, long j3, long j16) {
        Objects.requireNonNull(runnable);
        return a(runnable, j3, j16, false);
    }

    @Override // com.tencent.luggage.wxa.zp.c
    public Map a() {
        return com.tencent.luggage.wxa.gq.h.f126817a.a();
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.zp.b a(String str) {
        return new com.tencent.luggage.wxa.zp.b(str, 1, 1, new LinkedBlockingQueue(), new b.a());
    }

    @Override // com.tencent.luggage.wxa.zp.i
    public com.tencent.luggage.wxa.zp.b a(String str, int i3, int i16, BlockingQueue blockingQueue) {
        return new com.tencent.luggage.wxa.zp.b(str, i3, i16, blockingQueue, new b.a());
    }

    public final com.tencent.luggage.wxa.jq.c a(Runnable runnable, long j3, boolean z16) {
        return (com.tencent.luggage.wxa.jq.c) com.tencent.luggage.wxa.eq.e.a(runnable).b(new k(j3)).b(new j(z16)).e();
    }

    public final com.tencent.luggage.wxa.jq.c a(Runnable runnable, long j3, String str, boolean z16) {
        return (com.tencent.luggage.wxa.jq.c) com.tencent.luggage.wxa.eq.e.a(runnable).b(new c(j3, str)).b(new b(z16)).e();
    }

    public final com.tencent.luggage.wxa.jq.c a(Runnable runnable, long j3, long j16, boolean z16) {
        return (com.tencent.luggage.wxa.jq.c) com.tencent.luggage.wxa.eq.e.a(runnable).b(new e(j3, j16, z16)).b(new d()).e();
    }

    public final com.tencent.luggage.wxa.jq.c a(Callable callable, long j3, boolean z16) {
        return (com.tencent.luggage.wxa.jq.c) com.tencent.luggage.wxa.eq.e.a(callable).b(new g(j3)).b(new f(z16)).e();
    }

    public final com.tencent.luggage.wxa.jq.c a(Callable callable, long j3, String str) {
        return (com.tencent.luggage.wxa.jq.c) com.tencent.luggage.wxa.eq.e.a(callable).b(new i(j3, str)).b(new C6997h()).e();
    }
}
