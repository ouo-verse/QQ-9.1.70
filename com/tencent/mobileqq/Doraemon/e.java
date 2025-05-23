package com.tencent.mobileqq.Doraemon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected DoraemonAPIManager f154095a;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(DoraemonAPIManager doraemonAPIManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) doraemonAPIManager);
        } else {
            this.f154095a = doraemonAPIManager;
            d();
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public abstract boolean c(int i3, String str, JSONObject jSONObject, a aVar);

    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }
}
