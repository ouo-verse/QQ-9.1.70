package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected String f298277a;

    /* renamed from: b, reason: collision with root package name */
    protected QQAppInterface f298278b;

    public a(QQAppInterface qQAppInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) str);
        } else {
            this.f298278b = qQAppInterface;
            this.f298277a = str;
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract String c();

    public abstract void d();
}
