package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.turingfd.sdk.xq.TuringIDService;

/* compiled from: P */
/* loaded from: classes27.dex */
public class g extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GalacticCore f383356a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f383357b;

    public g(GalacticCore galacticCore, Context context) {
        this.f383356a = galacticCore;
        this.f383357b = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) galacticCore, (Object) context);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        GalacticCore galacticCore = this.f383356a;
        if (galacticCore != null) {
            ((TuringIDService.Cdo) galacticCore).f383139a.onResult(new White(Vermillion.f383180l.a(this.f383357b, false, 1)));
        }
    }
}
