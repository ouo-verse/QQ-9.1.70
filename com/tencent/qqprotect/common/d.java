package com.tencent.qqprotect.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.HexUtil;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f363497a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f363498b;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            f();
        }
    }

    private void d() {
        e(",");
    }

    private void e(String str) {
        if (this.f363498b) {
            this.f363497a.append(str);
        }
        this.f363498b = true;
    }

    public d a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (d) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        return b(String.format("%d", Integer.valueOf(i3)));
    }

    public d b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        d();
        if (str != null) {
            this.f363497a.append(str.replace(',', ';'));
        }
        return this;
    }

    public d c(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
        }
        return b(HexUtil.bytes2HexStr(bArr));
    }

    public d f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.f363497a = new StringBuilder();
        this.f363498b = false;
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f363497a.toString();
    }
}
