package com.tencent.mobileqq.ocr.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    c[] f254854a;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f254854a = new c[3];
        }
    }

    public c a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        c cVar = this.f254854a[i3];
        if (cVar != null) {
            return cVar;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                cVar = new d();
            }
        } else {
            cVar = new SearchSougouResultItemBuilder();
        }
        this.f254854a[i3] = cVar;
        return cVar;
    }
}
