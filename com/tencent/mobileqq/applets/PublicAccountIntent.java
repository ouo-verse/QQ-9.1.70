package com.tencent.mobileqq.applets;

import android.content.Context;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.NewIntent;
import mqq.app.Servlet;

/* loaded from: classes11.dex */
public class PublicAccountIntent extends NewIntent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private BusinessObserver f196751d;

    public PublicAccountIntent(Context context, Class<? extends Servlet> cls) {
        super(context, cls);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) cls);
        }
    }

    public BusinessObserver a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BusinessObserver) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f196751d;
    }

    public void b(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) businessObserver);
        } else {
            this.f196751d = businessObserver;
        }
    }
}
