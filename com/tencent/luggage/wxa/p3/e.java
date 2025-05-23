package com.tencent.luggage.wxa.p3;

import android.os.Looper;
import com.tencent.luggage.wxa.n3.r;
import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final a f137142c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final ReentrantLock f137143d = new ReentrantLock();

    /* renamed from: a, reason: collision with root package name */
    public final String f137144a;

    /* renamed from: b, reason: collision with root package name */
    public final r f137145b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p3.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6569a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f137146a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AtomicReference f137147b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f137148c;

            public RunnableC6569a(e eVar, AtomicReference atomicReference, CountDownLatch countDownLatch) {
                this.f137146a = eVar;
                this.f137147b = atomicReference;
                this.f137148c = countDownLatch;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e.a(this.f137146a, new C6570a(this.f137147b, this.f137148c), null, null, 6, null);
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.p3.e$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6570a implements e.c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ AtomicReference f137149a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ CountDownLatch f137150b;

                public C6570a(AtomicReference atomicReference, CountDownLatch countDownLatch) {
                    this.f137149a = atomicReference;
                    this.f137150b = countDownLatch;
                }

                @Override // com.tencent.luggage.wxa.o3.e.c
                public void a(com.tencent.luggage.wxa.o3.j jVar) {
                    this.f137149a.set(new Pair(Integer.valueOf(com.tencent.luggage.wxa.o3.g.f136106d.b()), jVar));
                    this.f137150b.countDown();
                }

                @Override // com.tencent.luggage.wxa.o3.e.c
                public void a(com.tencent.luggage.wxa.o3.g err) {
                    Intrinsics.checkNotNullParameter(err, "err");
                    this.f137149a.set(new Pair(Integer.valueOf(err.f()), null));
                    this.f137150b.countDown();
                }
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pair a(e login) {
            Intrinsics.checkNotNullParameter(login, "login");
            if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                AtomicReference atomicReference = new AtomicReference(new Pair(-2, null));
                try {
                    e.f137143d.lock();
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    com.tencent.luggage.wxa.zp.h.f146825d.c(new RunnableC6569a(login, atomicReference, countDownLatch));
                    if (!countDownLatch.await(10L, TimeUnit.SECONDS)) {
                        w.f("WMPF.LoginByTdiCloneSession", "loginSync: timeout");
                    }
                    e.f137143d.unlock();
                    Object obj = atomicReference.get();
                    Intrinsics.checkNotNullExpressionValue(obj, "atomicReference.get()");
                    return (Pair) obj;
                } catch (Throwable th5) {
                    e.f137143d.unlock();
                    throw th5;
                }
            }
            throw new IllegalStateException("Must invoke in worker thread");
        }
    }

    public e(String appId, r tdiCloneSession) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(tdiCloneSession, "tdiCloneSession");
        this.f137144a = appId;
        this.f137145b = tdiCloneSession;
    }

    public static /* synthetic */ void a(e eVar, e.c cVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        eVar.a(cVar, str, str2);
    }

    public final void a(e.c callback, String avatarUrl, String nickName) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        com.tencent.luggage.wxa.o3.j jVar = new com.tencent.luggage.wxa.o3.j();
        jVar.e(this.f137144a);
        jVar.b(new com.tencent.luggage.wxa.y8.h(this.f137145b.getUin()).a());
        jVar.f("LoginByTdiCloneSession");
        String d16 = w0.d("");
        Intrinsics.checkNotNullExpressionValue(d16, "nullAsNil(\"\")");
        jVar.c(d16);
        jVar.a(Integer.MAX_VALUE);
        jVar.a(avatarUrl);
        jVar.b(nickName);
        com.tencent.luggage.wxa.o3.l lVar = com.tencent.luggage.wxa.o3.l.f136139a;
        lVar.a(jVar);
        ((d) com.tencent.luggage.wxa.h1.e.a(d.class)).a(new p(this.f137145b));
        callback.a(lVar.a());
    }
}
