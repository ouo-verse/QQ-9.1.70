package com.tencent.mobileqq.uftransfer.proto;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private byte[] f305252g;

    /* renamed from: h, reason: collision with root package name */
    private String f305253h;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public byte[] m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f305252g;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305253h;
    }

    public void o(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        } else {
            this.f305252g = bArr;
        }
    }

    public void p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f305253h = str;
        }
    }
}
