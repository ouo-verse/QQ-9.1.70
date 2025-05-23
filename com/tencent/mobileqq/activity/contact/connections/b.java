package com.tencent.mobileqq.activity.contact.connections;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f181259a;

    /* renamed from: b, reason: collision with root package name */
    public int f181260b;

    /* renamed from: c, reason: collision with root package name */
    public int f181261c;

    public b(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f181259a = i3;
        this.f181260b = i16;
        this.f181261c = i17;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TabLayoutStatus{, tabId=" + this.f181259a + ", scrollPos=" + this.f181260b + ", scrollTop='" + this.f181261c + "'}";
    }
}
