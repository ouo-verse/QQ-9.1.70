package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class j extends com.tencent.magicbrush.ui.a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public final int f147545f;

    /* renamed from: g, reason: collision with root package name */
    public final long f147546g;

    /* renamed from: h, reason: collision with root package name */
    public int f147547h;

    /* renamed from: i, reason: collision with root package name */
    public final a f147548i;

    /* renamed from: j, reason: collision with root package name */
    public long f147549j;

    /* renamed from: k, reason: collision with root package name */
    public final a.b f147550k;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends com.tencent.luggage.wxa.v8.a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(MBRuntime runtime, com.tencent.luggage.wxa.r8.b jsThreadHandler) {
        super(runtime, jsThreadHandler);
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(jsThreadHandler, "jsThreadHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) runtime, (Object) jsThreadHandler);
            return;
        }
        this.f147545f = 60;
        this.f147546g = 1000000000 / 60;
        this.f147548i = new a();
        this.f147550k = a.b.f147487d;
    }

    @Override // com.tencent.magicbrush.ui.a
    public a.b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f147550k;
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
            this.f147549j = 0L;
        }
    }

    @Override // com.tencent.magicbrush.ui.a
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f147549j = 0L;
            c().a(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (r0 < r4) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        if (java.lang.System.nanoTime() < r8.f147549j) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        c().a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!g()) {
            return;
        }
        if (this.f147549j == 0) {
            this.f147549j = System.nanoTime();
        }
        long nanoTime = System.nanoTime();
        long j3 = nanoTime - this.f147549j;
        long j16 = this.f147546g;
        if (j3 >= j16) {
            this.f147547h = (int) (j3 / j16);
            this.f147549j = nanoTime - (j3 % j16);
        }
        this.f147548i.a(this.f147549j);
        a(this.f147549j / 1000000.0d);
        long nanoTime2 = System.nanoTime();
        long j17 = this.f147549j;
        long j18 = nanoTime2 - j17;
        long j19 = this.f147546g;
        this.f147549j = j17 + j19;
    }
}
