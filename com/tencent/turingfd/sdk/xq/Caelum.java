package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.Filbert;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Caelum implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f382618a;

    public Caelum(Bootes bootes, String str) {
        this.f382618a = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bootes, (Object) str);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            try {
                Crux.a(new Filbert(new Filbert.Cdo("https://tdid.m.qq.com/event/report").a(this.f382618a)));
            } catch (Throwable unused) {
            }
        }
    }
}
