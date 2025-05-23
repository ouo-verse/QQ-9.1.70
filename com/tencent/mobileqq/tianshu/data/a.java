package com.tencent.mobileqq.tianshu.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class a implements TianShuGetAdvCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f293074d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f293074d = "";
        }
    }
}
