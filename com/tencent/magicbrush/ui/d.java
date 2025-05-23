package com.tencent.magicbrush.ui;

import android.os.SystemClock;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class d extends a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public final a.b f147501f;

    /* renamed from: g, reason: collision with root package name */
    public double f147502g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MBRuntime runtime, com.tencent.luggage.wxa.r8.b jsThreadHandler) {
        super(runtime, jsThreadHandler);
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(jsThreadHandler, "jsThreadHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runtime, (Object) jsThreadHandler);
        } else {
            this.f147501f = a.b.f147486c;
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public a.b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f147501f;
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
        } else {
            this.f147502g = 0.0d;
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            c().a(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (g()) {
            c().a(this);
            if (this.f147502g == 0.0d) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.f147502g = SystemClock.elapsedRealtime();
            }
            a(this.f147502g);
            this.f147502g = SystemClock.elapsedRealtime();
        }
    }
}
