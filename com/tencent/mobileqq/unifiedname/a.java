package com.tencent.mobileqq.unifiedname;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f305803a;

    /* renamed from: b, reason: collision with root package name */
    public String f305804b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else if (aVar != null) {
            this.f305803a = aVar.f305803a;
            this.f305804b = aVar.f305804b;
        }
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new a(this.f305803a, this.f305804b);
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.f305803a == this.f305803a && Utils.p(aVar.f305804b, this.f305804b)) {
                return true;
            }
        }
        return false;
    }

    public a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        } else {
            this.f305803a = i3;
            this.f305804b = str;
        }
    }
}
