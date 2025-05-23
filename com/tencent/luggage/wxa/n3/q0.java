package com.tencent.luggage.wxa.n3;

import android.os.Looper;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.s3.h;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q0 {

    /* renamed from: a */
    public static final q0 f135244a = new q0();

    /* renamed from: b */
    public static final ReentrantLock f135245b = new ReentrantLock();

    /* renamed from: c */
    public static boolean f135246c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f135247a;

        public a(boolean z16) {
            this.f135247a = z16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q0.f135244a.b(this.f135247a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements t.a {

        /* renamed from: a */
        public final /* synthetic */ com.tencent.luggage.wxa.s3.c f135248a;

        /* renamed from: b */
        public final /* synthetic */ Function2 f135249b;

        public b(com.tencent.luggage.wxa.s3.c cVar, Function2 function2) {
            this.f135248a = cVar;
            this.f135249b = function2;
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, int i16, com.tencent.luggage.wxa.n3.a aVar) {
            ai.a(this, i3, i16, aVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void onLoginComplete(int i3) {
            boolean z16;
            this.f135248a.b(this);
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaTdiLoginBoot", "Wxa login logic boot: step 3: onLoginComplete errCode:" + i3);
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                r createCloneSession = this.f135248a.k().createCloneSession();
                if (createCloneSession != null) {
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaTdiLoginBoot", "Wxa login logic boot: step 3.1: createCloneSession success");
                    int intValue = ((Number) com.tencent.luggage.wxa.p3.e.f137142c.a(new com.tencent.luggage.wxa.p3.e(com.tencent.luggage.wxa.s3.f.c(), createCloneSession)).getFirst()).intValue();
                    if (intValue == 0) {
                        this.f135249b.invoke(0, "");
                        return;
                    }
                    this.f135249b.invoke(-1, "LoginByTdiCloneSession failed: errCode=" + intValue);
                    return;
                }
                return;
            }
            String str = "fail:autoLogin fail, errCode=" + i3;
            if (i3 > 0) {
                this.f135249b.invoke(-2, str);
            } else {
                this.f135249b.invoke(-1, str);
            }
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void onLogoutComplete(int i3) {
            ai.h(this, i3);
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public /* synthetic */ void a(int i3, int i16, byte[] bArr) {
            aj.a(this, i3, i16, bArr);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, com.tencent.luggage.wxa.n3.c cVar) {
            ai.b(this, i3, cVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, com.tencent.luggage.wxa.n3.d dVar) {
            ai.c(this, i3, dVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, l lVar) {
            ai.d(this, i3, lVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, o oVar) {
            ai.e(this, i3, oVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(y yVar) {
            ai.f(this, yVar);
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public /* synthetic */ void a(byte[] bArr) {
            aj.b(this, bArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends Lambda implements Function2 {

        /* renamed from: a */
        public final /* synthetic */ AtomicInteger f135250a;

        /* renamed from: b */
        public final /* synthetic */ AtomicReference f135251b;

        /* renamed from: c */
        public final /* synthetic */ CountDownLatch f135252c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AtomicInteger atomicInteger, AtomicReference atomicReference, CountDownLatch countDownLatch) {
            super(2);
            this.f135250a = atomicInteger;
            this.f135251b = atomicReference;
            this.f135252c = countDownLatch;
        }

        public final void a(int i3, String _errMsg) {
            Intrinsics.checkNotNullParameter(_errMsg, "_errMsg");
            this.f135250a.set(i3);
            this.f135251b.set(_errMsg);
            this.f135252c.countDown();
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).intValue(), (String) obj2);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Function2 f135253a;

        public d(Function2 function2) {
            this.f135253a = function2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            q0.a(true, this.f135253a, false, 4, null);
        }
    }

    public final boolean b(boolean z16) {
        com.tencent.luggage.wxa.s3.f.f140021a.h();
        com.tencent.luggage.wxa.s3.c activateDeviceLogic = (com.tencent.luggage.wxa.s3.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.s3.c.class);
        if (!a()) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.WxaTdiLoginBoot", "Tdi ilink device activate failed");
            return false;
        }
        com.tencent.luggage.wxa.o3.l lVar = com.tencent.luggage.wxa.o3.l.f136139a;
        if (lVar.c()) {
            int a16 = a(false, null, z16, 3, null);
            if (a16 != -2) {
                if (a16 != -1) {
                    if (a16 == 0) {
                        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaTdiLoginBoot", "Login OK");
                        Intrinsics.checkNotNullExpressionValue(activateDeviceLogic, "activateDeviceLogic");
                        a(activateDeviceLogic);
                        return true;
                    }
                    return true;
                }
                com.tencent.luggage.wxa.tn.w.f("Luggage.WxaTdiLoginBoot", "Login failed");
                lVar.b();
                return true;
            }
            com.tencent.luggage.wxa.tn.w.f("Luggage.WxaTdiLoginBoot", "Login failed, but can ignored");
            return true;
        }
        return true;
    }

    public static /* synthetic */ void a(q0 q0Var, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        q0Var.a(z16);
    }

    public final void a(boolean z16) {
        com.tencent.luggage.wxa.er.a.b(com.tencent.luggage.wxa.tn.z.m());
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaTdiLoginBoot", "Wxa login logic boot.");
        com.tencent.luggage.wxa.zp.h.f146825d.a(new a(z16), "LOGIN_QUEUE_TAG");
    }

    public final void a(com.tencent.luggage.wxa.s3.c cVar) {
        t k3 = cVar.k();
        if (k3 != null) {
            p0.f135239a.a(k3.getUin());
            if (1 == com.tencent.luggage.wxa.p3.g.a()) {
                new com.tencent.luggage.wxa.t3.a(k3).a(Looper.getMainLooper());
            }
        }
    }

    public final boolean a() {
        com.tencent.luggage.wxa.s3.c cVar = (com.tencent.luggage.wxa.s3.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.s3.c.class);
        com.tencent.luggage.wxa.s3.f fVar = com.tencent.luggage.wxa.s3.f.f140021a;
        if (fVar.g()) {
            return fVar.f() || cVar.F() == h.d.SUCCESS;
        }
        com.tencent.luggage.wxa.tn.w.f("Luggage.WxaTdiLoginBoot", "loginIlinkDevice: no device info");
        return true;
    }

    public static /* synthetic */ int a(boolean z16, Function2 function2, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        return a(z16, function2, z17);
    }

    public static final int a(boolean z16, Function2 function2, boolean z17) {
        com.tencent.luggage.wxa.tn.w.d("Luggage.WxaTdiLoginBoot", "userAutoLoginSync treatNoLoginAsFail:" + z16 + ", resetLoginSession:" + z17 + " start");
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            if (!com.tencent.luggage.wxa.o3.l.f136139a.c()) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.WxaTdiLoginBoot", "userAutoLoginSync treatNoLoginAsFail:" + z16 + ", resetLoginSession:" + z17 + ", no login");
                if (!z16) {
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE, "no login");
                    }
                    return 0;
                }
                if (function2 == null) {
                    return -1;
                }
                function2.invoke(Boolean.FALSE, "no login");
                return -1;
            }
            AtomicInteger atomicInteger = new AtomicInteger(-2);
            AtomicReference atomicReference = new AtomicReference(null);
            try {
                ReentrantLock reentrantLock = f135245b;
                reentrantLock.lock();
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaTdiLoginBoot", "userAutoLoginSync autoLoginRequested:" + f135246c + ", resetLoginSession:" + z17);
                if (f135246c && !z17) {
                    com.tencent.luggage.wxa.tn.w.d("Luggage.WxaTdiLoginBoot", "userAutoLoginSync autoLoginRequested=true, skip and return ok directly");
                    if (function2 != null) {
                        function2.invoke(Boolean.TRUE, null);
                    }
                    reentrantLock.unlock();
                    return 0;
                }
                CountDownLatch countDownLatch = new CountDownLatch(1);
                com.tencent.luggage.wxa.s3.c activateDeviceLogic = (com.tencent.luggage.wxa.s3.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.s3.c.class);
                q0 q0Var = f135244a;
                Intrinsics.checkNotNullExpressionValue(activateDeviceLogic, "activateDeviceLogic");
                q0Var.a(activateDeviceLogic, new c(atomicInteger, atomicReference, countDownLatch));
                try {
                    if (!countDownLatch.await(30L, TimeUnit.SECONDS)) {
                        com.tencent.luggage.wxa.tn.w.b("Luggage.WxaTdiLoginBoot", "userAutoLoginSync: await timeout");
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                f135246c = atomicInteger.get() == 0;
                if (function2 != null) {
                    function2.invoke(Boolean.valueOf(atomicInteger.get() == 0), atomicReference.get());
                }
                int i3 = atomicInteger.get();
                com.tencent.luggage.wxa.tn.w.d("Luggage.WxaTdiLoginBoot", "userAutoLoginSync treatNoLoginAsFail:" + z16 + ", resetLoginSession:" + z17 + ", ret:" + atomicInteger.get());
                return i3;
            } finally {
                f135245b.unlock();
            }
        }
        throw new IllegalStateException("Must invoke in worker thread");
    }

    public final void a(com.tencent.luggage.wxa.s3.c cVar, Function2 function2) {
        com.tencent.luggage.wxa.er.a.b(com.tencent.luggage.wxa.tn.z.m());
        boolean a16 = cVar.a(new b(cVar, function2));
        if (com.tencent.luggage.wxa.tn.e.f141559a) {
            com.tencent.luggage.wxa.er.a.b(a16);
        }
        if (!a16) {
            com.tencent.luggage.wxa.tn.w.f("Luggage.WxaTdiLoginBoot", "userAutoLogin failed");
            function2.invoke(-1, "fail:invalid session");
            return;
        }
        t k3 = cVar.k();
        if (k3 == null) {
            com.tencent.luggage.wxa.tn.w.b("Luggage.WxaTdiLoginBoot", "userAutoLoginForMainProcess with NULL session, return false");
            function2.invoke(-1, "fail:invalid session");
        } else {
            com.tencent.luggage.wxa.tn.w.d("Luggage.WxaTdiLoginBoot", "userAutoLoginForMainProcess invoke tdiSession.autoLogin()");
            k3.autoLogin();
        }
    }

    public final void a(Function2 function2) {
        com.tencent.luggage.wxa.zp.h.f146825d.d(new d(function2));
    }
}
