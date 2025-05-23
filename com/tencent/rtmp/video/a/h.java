package com.tencent.rtmp.video.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public final /* synthetic */ class h implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final f f368848a;

    h(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
        } else {
            this.f368848a = fVar;
        }
    }

    public static Runnable a(f fVar) {
        return new h(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f368848a.c();
    }
}
