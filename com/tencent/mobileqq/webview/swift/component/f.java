package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.component.b;
import java.util.Hashtable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f extends b.C8976b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    Hashtable<String, Boolean> f314454e;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f314454e = new Hashtable<>();
        }
    }

    public boolean g(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        Boolean bool = this.f314454e.get(str);
        if (bool == null) {
            return z16;
        }
        return bool.booleanValue();
    }

    public void h(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
        } else {
            this.f314454e.put(str, Boolean.valueOf(z16));
        }
    }
}
