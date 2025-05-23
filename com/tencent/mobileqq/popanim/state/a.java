package com.tencent.mobileqq.popanim.state;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected Context f259122d;

    /* renamed from: e, reason: collision with root package name */
    protected ViewGroup f259123e;

    /* renamed from: f, reason: collision with root package name */
    protected f f259124f;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(ViewGroup viewGroup, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewGroup, (Object) fVar);
            return;
        }
        this.f259122d = BaseApplication.getContext();
        this.f259123e = viewGroup;
        this.f259124f = fVar;
    }

    public void a(a aVar) {
        throw null;
    }

    public void b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
    }

    public boolean c(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return true;
    }
}
