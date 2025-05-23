package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tfd.sdk.wxa.TuringIDService;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Fig extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ctransient f375607a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f375608b;

    public Fig(Ctransient ctransient, Context context) {
        this.f375607a = ctransient;
        this.f375608b = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ctransient, (Object) context);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Ctransient ctransient = this.f375607a;
        if (ctransient != null) {
            ((TuringIDService.Cdo) ctransient).a(Cherry.f375527h.a(this.f375608b, false, 1));
        }
    }
}
