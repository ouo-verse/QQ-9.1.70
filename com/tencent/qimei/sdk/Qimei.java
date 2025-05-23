package com.tencent.qimei.sdk;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.as.a;
import com.tencent.qimei.at.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class Qimei {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f343371a;

    /* renamed from: b, reason: collision with root package name */
    public String f343372b;

    /* renamed from: c, reason: collision with root package name */
    public String f343373c;

    public Qimei() {
        this("");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String getQimei16() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        a aVar = com.tencent.qimei.ar.a.a(this.f343371a).f343094b;
        aVar.getClass();
        if (!com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343107e, aVar.f343146r).booleanValue()) {
            return "";
        }
        return this.f343372b;
    }

    public String getQimei36() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(this.f343371a).f343094b;
        aVar.getClass();
        if (!com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343108f, aVar.f343146r).booleanValue()) {
            return "";
        }
        return this.f343373c;
    }

    public boolean isEmpty() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        String str2 = this.f343372b;
        if ((str2 != null && !str2.isEmpty()) || ((str = this.f343373c) != null && !str.isEmpty())) {
            return false;
        }
        return true;
    }

    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Q16:");
        sb5.append(this.f343372b);
        if (TextUtils.isEmpty(this.f343373c)) {
            str = "";
        } else {
            str = "\nQ36:" + this.f343373c;
        }
        sb5.append(str);
        return sb5.toString();
    }

    public Qimei(String str) {
        this("", "", str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
    }

    public Qimei(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3);
            return;
        }
        this.f343372b = str == null ? "" : str;
        this.f343373c = str2 == null ? "" : str2;
        this.f343371a = str3;
    }
}
