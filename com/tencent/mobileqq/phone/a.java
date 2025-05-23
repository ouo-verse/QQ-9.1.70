package com.tencent.mobileqq.phone;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f258337a;

    /* renamed from: b, reason: collision with root package name */
    public String f258338b;

    /* renamed from: c, reason: collision with root package name */
    public String f258339c;

    public a(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.f258337a = str;
        this.f258338b = str2;
        this.f258339c = str3;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "PhoneInfo{countryCode='" + this.f258337a + "', areaCode='" + this.f258338b + "', rawPhoneNum='" + this.f258339c + "'}";
    }
}
