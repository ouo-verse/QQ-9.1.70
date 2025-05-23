package com.tencent.rtmp.video.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rtmp.video.a.a;

/* compiled from: P */
/* loaded from: classes25.dex */
final /* synthetic */ class d implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final a.C9791a f368829a;

    /* renamed from: b, reason: collision with root package name */
    private final Runnable f368830b;

    d(a.C9791a c9791a, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c9791a, (Object) runnable);
        } else {
            this.f368829a = c9791a;
            this.f368830b = runnable;
        }
    }

    public static Runnable a(a.C9791a c9791a, Runnable runnable) {
        return new d(c9791a, runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.C9791a c9791a = this.f368829a;
        this.f368830b.run();
        synchronized (a.this) {
            a.this.f368820c.remove(c9791a);
        }
    }
}
