package com.tencent.mobileqq.msfcore;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFNetworkConfig implements MSFConfig {
    static IPatchRedirector $redirector_;
    boolean mEnableQuicRevertToTcpOnConnFail;
    boolean mEnableQuicRevertToTcpOnIpv6;
    int mNetworkConnMode;
    int mQuickIdleCheckTimeout;
    int mType;

    public MSFNetworkConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public boolean getEnableQuicRevertToTcpOnConnFail() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mEnableQuicRevertToTcpOnConnFail;
    }

    public boolean getEnableQuicRevertToTcpOnIpv6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mEnableQuicRevertToTcpOnIpv6;
    }

    public int getNetworkConnMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mNetworkConnMode;
    }

    public int getQuickIdleCheckTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mQuickIdleCheckTimeout;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mType;
    }

    public void setEnableQuicRevertToTcpOnConnFail(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.mEnableQuicRevertToTcpOnConnFail = z16;
        }
    }

    public void setEnableQuicRevertToTcpOnIpv6(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.mEnableQuicRevertToTcpOnIpv6 = z16;
        }
    }

    public void setNetworkConnMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mNetworkConnMode = i3;
        }
    }

    public void setQuickIdleCheckTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mQuickIdleCheckTimeout = i3;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.mType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "MSFNetworkConfig{mType=" + this.mType + ",mNetworkConnMode=" + this.mNetworkConnMode + ",mEnableQuicRevertToTcpOnConnFail=" + this.mEnableQuicRevertToTcpOnConnFail + ",mEnableQuicRevertToTcpOnIpv6=" + this.mEnableQuicRevertToTcpOnIpv6 + ",mQuickIdleCheckTimeout=" + this.mQuickIdleCheckTimeout + ",}";
    }

    public MSFNetworkConfig(int i3, int i16, boolean z16, boolean z17, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i17));
            return;
        }
        this.mType = i3;
        this.mNetworkConnMode = i16;
        this.mEnableQuicRevertToTcpOnConnFail = z16;
        this.mEnableQuicRevertToTcpOnIpv6 = z17;
        this.mQuickIdleCheckTimeout = i17;
    }
}
