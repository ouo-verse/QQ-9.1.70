package com.tencent.rtmp.video.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rtmp.video.a.f;

/* compiled from: P */
/* loaded from: classes25.dex */
final /* synthetic */ class l implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final f f368859a;

    l(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        } else {
            this.f368859a = fVar;
        }
    }

    public static Runnable a(f fVar) {
        return new l(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.AnonymousClass1.a(this.f368859a);
    }
}
