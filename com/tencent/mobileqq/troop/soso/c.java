package com.tencent.mobileqq.troop.soso;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f298869a;

    /* renamed from: b, reason: collision with root package name */
    public int f298870b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f298871c;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f298869a = "";
        }
    }

    @Override // com.tencent.mobileqq.troop.soso.a
    public String getIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f298869a;
    }

    @Override // com.tencent.mobileqq.troop.soso.a
    public int getPort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f298870b;
    }

    @Override // com.tencent.mobileqq.troop.soso.a
    public boolean isIpv6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f298871c;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f298869a == null) {
            this.f298869a = "";
        }
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(this.f298869a);
        sb5.append(":");
        sb5.append(this.f298870b);
        return sb5.toString();
    }
}
