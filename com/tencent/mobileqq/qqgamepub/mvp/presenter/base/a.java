package com.tencent.mobileqq.qqgamepub.mvp.presenter.base;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kh2.a;
import lh2.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class a<V extends lh2.a, M extends kh2.a> implements b<V> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected WeakReference<V> f264631d;

    /* renamed from: e, reason: collision with root package name */
    protected M f264632e;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f264632e = c();
        }
    }

    public void b(V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            this.f264631d = new WeakReference<>(v3);
        }
    }

    protected abstract M c();

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        WeakReference<V> weakReference = this.f264631d;
        if (weakReference != null) {
            weakReference.clear();
            this.f264631d = null;
        }
    }

    public void e(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        }
    }

    public void f(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) configuration);
        }
    }

    public void g(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    public M i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (M) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f264632e;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        WeakReference<V> weakReference = this.f264631d;
        if (weakReference != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }
}
