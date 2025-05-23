package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class c extends com.tencent.magicbrush.ui.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.v8.a f147494f;

    /* renamed from: g, reason: collision with root package name */
    public final a.b f147495g;

    /* renamed from: h, reason: collision with root package name */
    public volatile Choreographer f147496h;

    /* renamed from: i, reason: collision with root package name */
    public final a f147497i;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public final class a implements Choreographer.FrameCallback, Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f147498a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
                return;
            }
            this.f147498a = j3;
            c.this.f147494f.a(j3);
            c.this.c().a(c.this.f147497i);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (c.this.g()) {
                Object d16 = c.this.d();
                c cVar = c.this;
                synchronized (d16) {
                    Choreographer n3 = cVar.n();
                    if (n3 != null) {
                        n3.postFrameCallback(cVar.f147497i);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                c.this.a(this.f147498a / 1000000.0d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends Lambda implements Function0 {
        static IPatchRedirector $redirector_;

        public b() {
            super(0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Object d16 = c.this.d();
            c cVar = c.this;
            synchronized (d16) {
                cVar.a(Choreographer.getInstance());
                if (cVar.g()) {
                    Choreographer n3 = cVar.n();
                    Intrinsics.checkNotNull(n3);
                    n3.postFrameCallback(cVar.f147497i);
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MBRuntime runtime, com.tencent.luggage.wxa.r8.b jsThreadHandler) {
        super(runtime, jsThreadHandler);
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(jsThreadHandler, "jsThreadHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runtime, (Object) jsThreadHandler);
            return;
        }
        this.f147494f = new com.tencent.luggage.wxa.v8.a();
        this.f147495g = a.b.f147485b;
        this.f147497i = new a();
    }

    @Override // com.tencent.magicbrush.ui.a
    public a.b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f147495g;
    }

    @Override // com.tencent.magicbrush.ui.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            com.tencent.luggage.wxa.w8.g.f144126a.a(new b());
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (this.f147496h != null) {
            Choreographer choreographer = this.f147496h;
            Intrinsics.checkNotNull(choreographer);
            choreographer.removeFrameCallback(this.f147497i);
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f147496h != null) {
            Choreographer choreographer = this.f147496h;
            Intrinsics.checkNotNull(choreographer);
            choreographer.removeFrameCallback(this.f147497i);
            Choreographer choreographer2 = this.f147496h;
            Intrinsics.checkNotNull(choreographer2);
            choreographer2.postFrameCallback(this.f147497i);
        }
    }

    public final Choreographer n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Choreographer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f147496h;
    }

    public final void a(Choreographer choreographer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f147496h = choreographer;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) choreographer);
        }
    }
}
