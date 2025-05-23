package com.tencent.could.component.common.ai.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DnsResolver implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f99977a;

    /* renamed from: b, reason: collision with root package name */
    public InetAddress f99978b;

    public DnsResolver(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f99977a = str;
        }
    }

    public synchronized InetAddress getHasAddress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (InetAddress) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f99978b;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            setAddress(InetAddress.getByName(this.f99977a));
        } catch (UnknownHostException e16) {
            TxNetWorkHelper.getInstance().logError("DnsResolver", "UnknownHostException " + this.f99977a + " e: " + e16.getLocalizedMessage());
            this.f99978b = null;
        }
    }

    public synchronized void setAddress(InetAddress inetAddress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) inetAddress);
        } else {
            this.f99978b = inetAddress;
        }
    }
}
