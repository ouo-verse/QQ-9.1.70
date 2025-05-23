package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
class d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static d f238154d;

    /* renamed from: a, reason: collision with root package name */
    private String f238155a;

    /* renamed from: b, reason: collision with root package name */
    private Throwable f238156b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f238157c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24253);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f238154d = new d(null);
        }
    }

    public d(String str) {
        this(str, null, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f238155a;
    }

    public d(String str, Object[] objArr, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, objArr, th5);
            return;
        }
        this.f238155a = str;
        this.f238156b = th5;
        this.f238157c = objArr;
    }
}
