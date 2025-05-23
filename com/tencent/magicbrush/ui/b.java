package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b extends a implements Choreographer.FrameCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.v8.a f147490f;

    /* renamed from: g, reason: collision with root package name */
    public Choreographer f147491g;

    /* renamed from: h, reason: collision with root package name */
    public int f147492h;

    /* renamed from: i, reason: collision with root package name */
    public final a.b f147493i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MBRuntime runtime, com.tencent.luggage.wxa.r8.b jsThreadHandler) {
        super(runtime, jsThreadHandler);
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(jsThreadHandler, "jsThreadHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runtime, (Object) jsThreadHandler);
        } else {
            this.f147490f = new com.tencent.luggage.wxa.v8.a();
            this.f147493i = a.b.f147484a;
        }
    }

    public static final void a(b this$0) {
        Choreographer b16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.g() || (b16 = this$0.b(true)) == null) {
            return;
        }
        b16.removeFrameCallback(this$0);
        b16.postFrameCallback(this$0);
        com.tencent.luggage.wxa.p8.f.c("AnimationFrameHandler", "Aha! we get a choreographer after try [" + this$0.f147492h + "] times ", new Object[0]);
    }

    public final Choreographer b(boolean z16) {
        Choreographer choreographer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Choreographer) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        Choreographer choreographer2 = this.f147491g;
        if (choreographer2 != null) {
            return choreographer2;
        }
        this.f147492h++;
        try {
            choreographer = Choreographer.getInstance();
        } catch (Exception e16) {
            if (this.f147492h == 1 || this.f147492h % 100000 == 0) {
                com.tencent.luggage.wxa.p8.f.a("AnimationFrameHandler", e16, "get choreographer failed [" + this.f147492h + "] times. but it's ok, i will try it later if needed. " + e16, new Object[0]);
            }
            choreographer = null;
        }
        if (choreographer == null && z16) {
            c().a(new Runnable() { // from class: com.tencent.magicbrush.ui.k
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(b.this);
                }
            });
            return null;
        }
        if (choreographer != null) {
            this.f147491g = choreographer;
        }
        return choreographer;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        if (g()) {
            this.f147490f.a(j3);
            Choreographer choreographer = this.f147491g;
            if (choreographer != null) {
                choreographer.postFrameCallback(this);
            }
            a(j3 / 1000000.0d);
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public a.b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f147493i;
    }

    @Override // com.tencent.magicbrush.ui.a
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Choreographer choreographer = this.f147491g;
        if (choreographer != null) {
            choreographer.removeFrameCallback(this);
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Choreographer b16 = b(true);
        if (b16 != null) {
            b16.removeFrameCallback(this);
        }
        if (b16 != null) {
            b16.postFrameCallback(this);
        }
    }
}
