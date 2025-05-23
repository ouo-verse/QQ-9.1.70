package com.tencent.mobileqq.troop.unreadmsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f301844a;

    /* renamed from: b, reason: collision with root package name */
    public String f301845b;

    /* renamed from: c, reason: collision with root package name */
    public int f301846c;

    /* renamed from: d, reason: collision with root package name */
    public int f301847d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("[");
        sb5.append(this.f301845b);
        sb5.append(",");
        sb5.append(this.f301844a);
        sb5.append(",");
        sb5.append(this.f301846c);
        sb5.append(",");
        sb5.append(this.f301847d);
        sb5.append("]");
        return sb5.toString();
    }
}
