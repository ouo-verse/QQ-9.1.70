package com.tencent.mobileqq.miniapp;

import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public MiniAppActivity f246785a;

    /* renamed from: b, reason: collision with root package name */
    public d f246786b;

    public abstract boolean a();

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f246785a = null;
        }
    }

    public void c(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        this.f246786b = dVar;
        MiniAppActivity miniAppActivity = this.f246785a;
        if (miniAppActivity != null) {
            miniAppActivity.f246821c0 = dVar;
        }
    }

    public abstract void d();

    public abstract void e();
}
