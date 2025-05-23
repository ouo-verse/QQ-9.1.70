package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class i extends a implements Runnable {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(MBRuntime runtime, com.tencent.luggage.wxa.r8.b jsThreadHandler) {
        super(runtime, jsThreadHandler);
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(jsThreadHandler, "jsThreadHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runtime, (Object) jsThreadHandler);
        }
    }

    public static final void a(i this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e().p();
    }

    @Override // com.tencent.magicbrush.ui.a
    public a.b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.b.f147488e;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            c().a(new Runnable() { // from class: com.tencent.magicbrush.ui.l
                @Override // java.lang.Runnable
                public final void run() {
                    i.a(i.this);
                }
            });
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            c().a(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            com.tencent.luggage.wxa.p8.f.c("AnimationFrameHandler", "hy: start native raf looper", new Object[0]);
            e().k();
        }
    }
}
