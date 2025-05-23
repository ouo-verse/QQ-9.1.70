package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ServerAddr {
    static IPatchRedirector $redirector_;
    public boolean isDomain;
    public boolean isIpv6;
    public String mIp;
    public int port;

    public ServerAddr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.port = 80;
            this.isDomain = false;
        }
    }

    public String getServerUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        String str2 = null;
        if (str == null) {
            return null;
        }
        if (this.isDomain) {
            if (str.startsWith("http://")) {
                str2 = "http://" + this.mIp;
            } else if (str.startsWith("https://")) {
                str2 = "https://" + this.mIp;
            }
            return str2 + "/";
        }
        if (str.startsWith("http://")) {
            if (this.isIpv6 && !this.mIp.startsWith("[")) {
                str2 = "http://[" + this.mIp + "]";
            } else {
                str2 = "http://" + this.mIp;
            }
        } else if (str.startsWith("https://")) {
            if (this.isIpv6 && !this.mIp.startsWith("[")) {
                str2 = "https://[" + this.mIp + "]";
            } else {
                str2 = "https://" + this.mIp;
            }
        }
        if (this.port != 80) {
            return str2 + ":" + this.port + "/";
        }
        return str2 + "/";
    }

    public void onFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void onSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mIp + ":" + this.port;
    }
}
