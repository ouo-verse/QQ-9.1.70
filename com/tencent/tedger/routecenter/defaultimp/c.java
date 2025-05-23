package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import ue4.a;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class c<T extends ue4.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f375319f;

    /* renamed from: a, reason: collision with root package name */
    protected final String f375320a;

    /* renamed from: b, reason: collision with root package name */
    protected final String f375321b;

    /* renamed from: c, reason: collision with root package name */
    protected volatile T f375322c;

    /* renamed from: d, reason: collision with root package name */
    protected ve4.l f375323d;

    /* renamed from: e, reason: collision with root package name */
    protected WeakReference<com.tencent.tedger.routecenter.a> f375324e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43891);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f375319f = false;
        }
    }

    public c(com.tencent.tedger.routecenter.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f375320a = getClass().getSimpleName();
        this.f375321b = getClass().getName();
        this.f375324e = new WeakReference<>(aVar);
        f375319f = false;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return f375319f;
    }

    /* JADX WARN: Incorrect types in method signature: <X:TT;>(TX;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public void H(ue4.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f375323d = this.f375324e.get().f375318p;
            this.f375322c = aVar;
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            f375319f = true;
            this.f375322c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (B()) {
            this.f375324e.get().f375318p.e(this.f375320a, 9, this.f375321b + " can't be call after destroyed!");
            return true;
        }
        if (this.f375322c == null) {
            this.f375324e.get().f375318p.e(this.f375320a, 9, this.f375321b + " don't have imp.");
            return true;
        }
        return false;
    }
}
