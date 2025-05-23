package com.tencent.mobileqq.loginregister;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f242843a;

    /* renamed from: b, reason: collision with root package name */
    public final String f242844b;

    /* renamed from: c, reason: collision with root package name */
    public final int f242845c;

    /* renamed from: d, reason: collision with root package name */
    public final int f242846d;

    /* renamed from: e, reason: collision with root package name */
    private String f242847e;

    public h(Object obj, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, obj, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f242847e = "";
        this.f242843a = c(obj, str);
        this.f242844b = str;
        this.f242845c = i3;
        this.f242846d = i16;
    }

    public static String c(Object obj, String str) {
        Object obj2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        if (obj != null) {
            obj2 = Integer.valueOf(obj.hashCode());
        } else {
            obj2 = "null";
        }
        sb5.append(obj2);
        return sb5.toString();
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f242847e;
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f242847e = str;
        }
    }
}
