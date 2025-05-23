package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Ara implements Callable<Haw> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Auriga f382573a;

    public Ara(Auriga auriga) {
        this.f382573a = auriga;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) auriga);
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.turingfd.sdk.xq.Haw, java.lang.Object] */
    @Override // java.util.concurrent.Callable
    public Haw call() throws Exception {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        synchronized (Celse.class) {
            context = Celse.f383328a;
        }
        return i.a(context, this.f382573a.f382580a);
    }
}
