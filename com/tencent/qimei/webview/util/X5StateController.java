package com.tencent.qimei.webview.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class X5StateController {
    static IPatchRedirector $redirector_;
    private volatile X5Controller controller;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface X5Controller {
        boolean detectX5InitFinished();
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final X5StateController f343419a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16095);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f343419a = new X5StateController(null);
            }
        }
    }

    X5StateController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public static X5StateController getInstance() {
        return b.f343419a;
    }

    public X5Controller getController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (X5Controller) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.controller;
    }

    public void setController(X5Controller x5Controller) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) x5Controller);
        } else {
            this.controller = x5Controller;
        }
    }

    public /* synthetic */ X5StateController(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }
}
