package com.tencent.rtmp.video.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rtmp.video.a.a;

/* compiled from: P */
/* loaded from: classes25.dex */
final /* synthetic */ class e implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final a.C9791a f368831a;

    e(a.C9791a c9791a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) c9791a);
        } else {
            this.f368831a = c9791a;
        }
    }

    public static Runnable a(a.C9791a c9791a) {
        return new e(c9791a);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.C9791a c9791a = this.f368831a;
        a.this.f368818a.execute(c9791a.f368822b);
    }
}
