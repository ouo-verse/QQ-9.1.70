package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ac implements com.tencent.mobileqq.uftransfer.api.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f305484a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f305485b;

    /* renamed from: c, reason: collision with root package name */
    private String f305486c;

    /* renamed from: d, reason: collision with root package name */
    private String f305487d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f305488e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f305489f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f305490g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f305491h;

    /* renamed from: i, reason: collision with root package name */
    private String f305492i;

    /* renamed from: j, reason: collision with root package name */
    private int f305493j;

    /* renamed from: k, reason: collision with root package name */
    private int f305494k;

    public ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f305485b = false;
        this.f305488e = false;
        this.f305489f = false;
        this.f305490g = false;
        this.f305491h = false;
        this.f305493j = 0;
        this.f305494k = 0;
    }

    @Override // com.tencent.mobileqq.uftransfer.api.c
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f305485b;
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            this.f305486c = str;
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.f305484a = str;
        }
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f305485b = z16;
        }
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.f305492i = str;
        }
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.f305493j = i3;
        }
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.f305494k = i3;
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.api.c
    public String getErrMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f305486c;
    }

    @Override // com.tencent.mobileqq.uftransfer.api.c
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f305487d;
    }

    public void h(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            this.f305487d = str;
        }
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.f305490g = z16;
        }
    }
}
