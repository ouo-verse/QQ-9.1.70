package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f291375a;

    /* renamed from: b, reason: collision with root package name */
    public String f291376b;

    /* renamed from: c, reason: collision with root package name */
    public String f291377c;

    /* renamed from: d, reason: collision with root package name */
    public String f291378d;

    /* renamed from: e, reason: collision with root package name */
    public String f291379e;

    /* renamed from: f, reason: collision with root package name */
    public String f291380f;

    /* renamed from: g, reason: collision with root package name */
    public String f291381g;

    /* renamed from: h, reason: collision with root package name */
    public String f291382h;

    /* renamed from: i, reason: collision with root package name */
    public String f291383i;

    /* renamed from: j, reason: collision with root package name */
    public String f291384j;

    /* renamed from: k, reason: collision with root package name */
    public String f291385k;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        return this.f291376b.equals(((a) obj).f291376b);
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return super.hashCode();
    }
}
