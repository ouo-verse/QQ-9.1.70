package com.tencent.mobileqq.qqgamepub.web.delegate;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.base.b;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class a<P extends b> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected P f264838d;

    /* renamed from: e, reason: collision with root package name */
    protected View f264839e;

    public a(P p16, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) p16, (Object) view);
        } else {
            this.f264838d = p16;
            this.f264839e = view;
        }
    }
}
