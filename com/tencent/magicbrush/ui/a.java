package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final C7014a f147478e;

    /* renamed from: a, reason: collision with root package name */
    public final MBRuntime f147479a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.r8.b f147480b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f147481c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f147482d;

    /* compiled from: P */
    /* renamed from: com.tencent.magicbrush.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C7014a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* renamed from: com.tencent.magicbrush.ui.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public /* synthetic */ class C7015a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f147483a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58543);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[b.values().length];
                try {
                    iArr[b.f147484a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[b.f147485b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[b.f147486c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[b.f147487d.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[b.f147488e.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f147483a = iArr;
            }
        }

        public C7014a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public final a a(MBRuntime runtime, com.tencent.luggage.wxa.r8.b jsThreadHandler, b strategy) {
            a bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, this, runtime, jsThreadHandler, strategy);
            }
            Intrinsics.checkNotNullParameter(runtime, "runtime");
            Intrinsics.checkNotNullParameter(jsThreadHandler, "jsThreadHandler");
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            int i3 = C7015a.f147483a[strategy.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                bVar = new i(runtime, jsThreadHandler);
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else {
                            bVar = new j(runtime, jsThreadHandler);
                        }
                    } else {
                        bVar = new d(runtime, jsThreadHandler);
                    }
                } else {
                    bVar = new c(runtime, jsThreadHandler);
                }
            } else {
                bVar = new com.tencent.magicbrush.ui.b(runtime, jsThreadHandler);
            }
            bVar.a();
            return bVar;
        }

        public /* synthetic */ C7014a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f147484a;

        /* renamed from: b, reason: collision with root package name */
        public static final b f147485b;

        /* renamed from: c, reason: collision with root package name */
        public static final b f147486c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f147487d;

        /* renamed from: e, reason: collision with root package name */
        public static final b f147488e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ b[] f147489f;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58579);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            f147484a = new b("ChoreographerInJsThread", 0);
            f147485b = new b("ChoreographerInMainThread", 1);
            f147486c = new b("EglSurfaceSwapLocker", 2);
            f147487d = new b("SchedulerLocker", 3);
            f147488e = new b("NativeLocker", 4);
            f147489f = a();
        }

        public b(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static final /* synthetic */ b[] a() {
            return new b[]{f147484a, f147485b, f147486c, f147487d, f147488e};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f147489f.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58587);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f147478e = new C7014a(null);
        }
    }

    public a(MBRuntime runtime, com.tencent.luggage.wxa.r8.b jsThreadHandler) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(jsThreadHandler, "jsThreadHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runtime, (Object) jsThreadHandler);
            return;
        }
        this.f147479a = runtime;
        this.f147480b = jsThreadHandler;
        this.f147481c = new Object();
    }

    public static final a a(MBRuntime mBRuntime, com.tencent.luggage.wxa.r8.b bVar, b bVar2) {
        return f147478e.a(mBRuntime, bVar, bVar2);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("AnimationFrameHandler", "AnimationFrameHandler[%s] destroy", f().name());
        synchronized (this.f147481c) {
            if (this.f147482d) {
                com.tencent.luggage.wxa.p8.f.c("AnimationFrameHandler", "AnimationFrameHandler[%s] pause automatically", f().name());
                l();
            }
            i();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final com.tencent.luggage.wxa.r8.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.luggage.wxa.r8.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f147480b;
    }

    public final Object d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f147481c;
    }

    public final MBRuntime e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MBRuntime) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f147479a;
    }

    public abstract b f();

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f147482d;
    }

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract void k();

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("AnimationFrameHandler", "AnimationFrameHandler[%s] pause", f().name());
        synchronized (this.f147481c) {
            if (!this.f147482d) {
                return;
            }
            j();
            this.f147482d = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.luggage.wxa.p8.f.c("AnimationFrameHandler", "AnimationFrameHandler[%s] resume", f().name());
        synchronized (this.f147481c) {
            if (this.f147482d) {
                return;
            }
            k();
            this.f147482d = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        com.tencent.luggage.wxa.p8.f.c("AnimationFrameHandler", "AnimationFrameHandler[" + f().name() + "] create " + Thread.currentThread().getName(), new Object[0]);
        h();
    }

    public final void a(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.f147479a.a(d16);
        } else {
            iPatchRedirector.redirect((short) 10, this, Double.valueOf(d16));
        }
    }
}
