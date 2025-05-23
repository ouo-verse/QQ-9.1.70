package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class c implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final QQAppInterface f196404a;

    /* renamed from: b, reason: collision with root package name */
    protected final e f196405b;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(QQAppInterface qQAppInterface, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) eVar);
        } else {
            this.f196404a = qQAppInterface;
            this.f196405b = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f196405b.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f196405b.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f196405b.c();
    }

    public abstract int e(Message message);

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f196405b.l(this.f196405b.f() + this.f196405b.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Message message, e eVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) message, (Object) eVar);
            return;
        }
        if (message.counter > 1) {
            String c16 = eVar.c();
            if (message.counter > 100) {
                str = c16 + " (" + this.f196404a.getApp().getString(R.string.ckz) + ")";
            } else {
                str = c16 + " (" + message.counter + this.f196404a.getApp().getString(R.string.cip) + ")";
            }
            eVar.i(str);
        }
    }
}
