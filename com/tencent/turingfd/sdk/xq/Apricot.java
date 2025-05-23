package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.turingfd.sdk.xq.Arbutus;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Apricot extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Arbutus.Cdo f382558a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f382559b;

    public Apricot(Arbutus.Cdo cdo, Context context) {
        this.f382558a = cdo;
        this.f382559b = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cdo, (Object) context);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f382558a.f382577a.b(this.f382559b);
        }
    }
}
