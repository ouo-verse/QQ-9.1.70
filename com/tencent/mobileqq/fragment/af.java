package com.tencent.mobileqq.fragment;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class af {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f211242a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f211243b;

    /* renamed from: c, reason: collision with root package name */
    public TitlebarBaseFragment f211244c;

    public af(TitlebarBaseFragment titlebarBaseFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) titlebarBaseFragment);
            return;
        }
        this.f211242a = true;
        this.f211243b = false;
        this.f211244c = titlebarBaseFragment;
    }
}
