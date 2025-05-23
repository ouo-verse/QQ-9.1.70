package com.tencent.cache.core.size.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class a implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public static int C;

    @NotNull
    public static final a D;

    /* renamed from: d, reason: collision with root package name */
    public static final HandlerThread f98807d;

    /* renamed from: e, reason: collision with root package name */
    public static Handler f98808e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f98809f;

    /* renamed from: h, reason: collision with root package name */
    public static volatile boolean f98810h;

    /* renamed from: i, reason: collision with root package name */
    public static int f98811i;

    /* renamed from: m, reason: collision with root package name */
    public static int f98812m;

    /* compiled from: P */
    /* renamed from: com.tencent.cache.core.size.task.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1004a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final com.tencent.cache.core.collection.base.d f98813a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f98814b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final Object f98815c;

        public C1004a(@NotNull com.tencent.cache.core.collection.base.d cacheInfo, boolean z16, @NotNull Object target) {
            Intrinsics.checkNotNullParameter(cacheInfo, "cacheInfo");
            Intrinsics.checkNotNullParameter(target, "target");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cacheInfo, Boolean.valueOf(z16), target);
                return;
            }
            this.f98813a = cacheInfo;
            this.f98814b = z16;
            this.f98815c = target;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final com.tencent.cache.core.bitmap.cache.b<?, ?> f98816a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f98817b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final com.tencent.cache.core.bitmap.base.lrucache.b<?, ?> f98818c;

        public b(@NotNull com.tencent.cache.core.bitmap.cache.b<?, ?> cacheItem, boolean z16, @NotNull com.tencent.cache.core.bitmap.base.lrucache.b<?, ?> target) {
            Intrinsics.checkNotNullParameter(cacheItem, "cacheItem");
            Intrinsics.checkNotNullParameter(target, "target");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cacheItem, Boolean.valueOf(z16), target);
                return;
            }
            this.f98816a = cacheItem;
            this.f98817b = z16;
            this.f98818c = target;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function0<Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1004a f98819a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C1004a c1004a) {
            super(0);
            this.f98819a = c1004a;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c1004a);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.Unit, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a.D.b(this.f98819a, com.tencent.cache.api.util.c.e(com.tencent.cache.api.util.c.f98640a, this.f98819a.f98815c, true, false, false, 8, null), true);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class d extends Lambda implements Function0<Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f98820a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar) {
            super(0);
            this.f98820a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.Unit, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this);
            }
            com.tencent.cache.core.bitmap.cache.b<?, ?> bVar = this.f98820a.f98816a;
            com.tencent.cache.api.util.c cVar = com.tencent.cache.api.util.c.f98640a;
            V v3 = bVar.f98664f;
            Intrinsics.checkNotNull(v3);
            bVar.f98663e = com.tencent.cache.api.util.c.e(cVar, v3, true, true, false, 8, null);
            b bVar2 = this.f98820a;
            bVar2.f98818c.s(bVar2.f98816a.f98663e, bVar2.f98817b);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class e implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f98821d;

        public e(Runnable runnable) {
            this.f98821d = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                a.C--;
                this.f98821d.run();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14595);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        D = new a();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Cache-Size-Calculator");
        baseHandlerThread.start();
        f98807d = baseHandlerThread;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull com.tencent.cache.core.collection.base.d cacheInfo, boolean z16, @NotNull Object target) {
        int e16;
        Message obtain;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, cacheInfo, Boolean.valueOf(z16), target);
            return;
        }
        Intrinsics.checkNotNullParameter(cacheInfo, "cacheInfo");
        Intrinsics.checkNotNullParameter(target, "target");
        if (!d()) {
            e16 = 2048;
        } else {
            Integer b16 = cacheInfo.b(target);
            if (b16 != null) {
                e16 = b16.intValue();
            } else {
                e16 = com.tencent.cache.api.util.c.e(com.tencent.cache.api.util.c.f98640a, target, false, false, false, 8, null);
            }
        }
        C1004a c1004a = new C1004a(cacheInfo, z16, target);
        if (e16 != 0) {
            b(c1004a, e16, false);
            return;
        }
        com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
        if (bVar.i()) {
            obtain = new Message();
        } else {
            obtain = Message.obtain();
        }
        if (obtain == null) {
            bVar.j("SizeCalculator", 1, "msg obtain is null");
            return;
        }
        f98812m++;
        obtain.what = 1;
        obtain.obj = c1004a;
        Handler handler = f98808e;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public final void b(C1004a c1004a, int i3, boolean z16) {
        com.tencent.cache.core.collection.base.d dVar;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, c1004a, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        try {
            if (c1004a.f98814b) {
                if (z16) {
                    com.tencent.cache.core.collection.base.d dVar2 = c1004a.f98813a;
                    Object target = c1004a.f98815c;
                    dVar2.getClass();
                    Intrinsics.checkNotNullParameter(target, "target");
                    if (!com.tencent.cache.core.util.a.a(target)) {
                        dVar2.f98711j.i(target, Integer.valueOf(i3));
                    }
                }
                dVar = c1004a.f98813a;
                j3 = dVar.f98708g + i3;
            } else {
                com.tencent.cache.core.collection.base.d dVar3 = c1004a.f98813a;
                Object target2 = c1004a.f98815c;
                dVar3.getClass();
                Intrinsics.checkNotNullParameter(target2, "target");
                if (!com.tencent.cache.core.util.a.a(target2)) {
                    dVar3.f98711j.k(target2);
                }
                dVar = c1004a.f98813a;
                long j16 = dVar.f98708g;
                long j17 = i3;
                if (j16 > j17) {
                    j3 = j16 - j17;
                } else {
                    j3 = 0;
                }
            }
            dVar.f98708g = j3;
        } catch (Exception e16) {
            com.tencent.cache.core.util.b.f98833f.b("SizeCalculator", 1, "updateCacheInfo fail", e16);
        }
    }

    public final void c(@NotNull Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
            return;
        }
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (!com.tencent.cache.core.util.b.f98833f.i() && !(!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))) {
            C++;
            Handler handler = f98808e;
            if (handler != null) {
                handler.postAtFrontOfQueue(new e(runnable));
                return;
            }
            return;
        }
        runnable.run();
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (!f98809f) {
            com.tencent.cache.core.manager.api.c cVar = com.tencent.cache.core.manager.api.c.f98725d;
            if (cVar.h() == 0) {
                return false;
            }
            if (SystemClock.elapsedRealtime() - cVar.h() > cVar.d().p()) {
                if (!f98810h) {
                    synchronized (this) {
                        if (!f98810h) {
                            f98810h = true;
                            f98808e = new Handler(f98807d.getLooper(), D);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                f98809f = true;
                com.tencent.cache.core.util.b.f98833f.j("SizeCalculator", 1, "satisfy delay from init, start size calculator");
            }
        }
        if (!com.tencent.cache.core.manager.api.c.f98725d.d().c() || !f98809f) {
            return false;
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Class<?> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            f98812m--;
            Object obj = msg2.obj;
            if (obj != null) {
                C1004a c1004a = (C1004a) obj;
                Integer b16 = c1004a.f98813a.b(c1004a.f98815c);
                if (b16 != null) {
                    D.b(c1004a, b16.intValue(), false);
                    return true;
                }
                com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
                StringBuilder a16 = com.tencent.cache.api.collection.c.a("handle CacheInfoAction, ");
                a16.append(c1004a.f98815c.getClass());
                a16.append(TokenParser.SP);
                bVar.e("SizeCalculator", a16.toString(), new c(c1004a));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.cache.core.size.task.SizeCalculator.CacheInfoAction");
            }
        } else if (i3 == 2) {
            f98811i--;
            Object obj2 = msg2.obj;
            if (obj2 != null) {
                b bVar2 = (b) obj2;
                com.tencent.cache.core.util.b bVar3 = com.tencent.cache.core.util.b.f98833f;
                StringBuilder a17 = com.tencent.cache.api.collection.c.a("handle CacheItem, ");
                V v3 = bVar2.f98816a.f98664f;
                if (v3 != 0) {
                    cls = v3.getClass();
                } else {
                    cls = null;
                }
                a17.append(cls);
                a17.append(TokenParser.SP);
                bVar3.e("SizeCalculator", a17.toString(), new d(bVar2));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.cache.core.size.task.SizeCalculator.CacheItemAction");
            }
        }
        return true;
    }
}
