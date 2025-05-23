package com.tencent.qimei.ai;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class j implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f343039a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f343040b;

    public j(k kVar, String str) {
        this.f343040b = kVar;
        this.f343039a = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar, (Object) str);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        k kVar = this.f343040b;
        String str = this.f343039a;
        synchronized (kVar.f343045d) {
            com.tencent.qimei.aa.f.b(kVar.f343042a).a("tn", str);
            com.tencent.qimei.aa.f.b(kVar.f343042a).a("t_s_t", System.currentTimeMillis());
        }
    }
}
