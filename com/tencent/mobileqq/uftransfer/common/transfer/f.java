package com.tencent.mobileqq.uftransfer.common.transfer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.api.j;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected List<j> f305015a;

    /* renamed from: b, reason: collision with root package name */
    protected List<j> f305016b;

    /* renamed from: c, reason: collision with root package name */
    protected List<j> f305017c;

    /* renamed from: d, reason: collision with root package name */
    protected byte[] f305018d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f305019e;

    /* renamed from: f, reason: collision with root package name */
    protected String f305020f;

    /* renamed from: g, reason: collision with root package name */
    protected String f305021g;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        List<j> list = this.f305015a;
        if (list != null && list.size() != 0) {
            return true;
        }
        this.f305021g = "bigDataChnHost is empty";
        return false;
    }

    public List<j> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f305015a;
    }

    public byte[] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f305018d;
    }

    public String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f305021g;
    }

    public List<j> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f305016b;
    }

    public List<j> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f305017c;
    }

    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f305020f;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f305019e;
    }

    public void i(List<j> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.f305015a = list;
        }
    }

    public void j(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bArr);
        } else {
            this.f305018d = bArr;
        }
    }

    public void k(List<j> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.f305016b = list;
        }
    }

    public void l(List<j> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            this.f305017c = list;
        }
    }

    public void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.f305019e = z16;
        }
    }
}
