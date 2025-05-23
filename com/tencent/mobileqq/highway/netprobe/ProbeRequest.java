package com.tencent.mobileqq.highway.netprobe;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class ProbeRequest {
    static IPatchRedirector $redirector_;

    /* renamed from: ip, reason: collision with root package name */
    private String f236833ip;
    ProbeItem root;
    int trigglePoint;

    public ProbeRequest(String str, ProbeItem probeItem) {
        this(str, -1, probeItem);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) probeItem);
    }

    public String getIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f236833ip;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (TextUtils.isEmpty(this.f236833ip)) {
            return "unkonw";
        }
        return this.f236833ip;
    }

    public ProbeRequest(String str, int i3, ProbeItem probeItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), probeItem);
            return;
        }
        this.f236833ip = str;
        this.root = probeItem;
        this.trigglePoint = i3;
    }
}
