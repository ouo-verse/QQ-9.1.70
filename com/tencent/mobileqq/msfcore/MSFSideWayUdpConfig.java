package com.tencent.mobileqq.msfcore;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFSideWayUdpConfig implements MSFConfig {
    static IPatchRedirector $redirector_;
    boolean mIsOpen;
    int mResendIntervalTimeInWiFi;
    int mResendIntervalTimeInXg;
    int mSendDelayTimeInWiFi;
    int mSendDelayTimeInXg;
    int mSidewayMode;
    int mType;

    public MSFSideWayUdpConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public boolean getIsOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mIsOpen;
    }

    public int getResendIntervalTimeInWiFi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mResendIntervalTimeInWiFi;
    }

    public int getResendIntervalTimeInXg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mResendIntervalTimeInXg;
    }

    public int getSendDelayTimeInWiFi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mSendDelayTimeInWiFi;
    }

    public int getSendDelayTimeInXg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mSendDelayTimeInXg;
    }

    public int getSidewayMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mSidewayMode;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mType;
    }

    public void setIsOpen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.mIsOpen = z16;
        }
    }

    public void setResendIntervalTimeInWiFi(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mResendIntervalTimeInWiFi = i3;
        }
    }

    public void setResendIntervalTimeInXg(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mResendIntervalTimeInXg = i3;
        }
    }

    public void setSendDelayTimeInWiFi(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.mSendDelayTimeInWiFi = i3;
        }
    }

    public void setSendDelayTimeInXg(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mSendDelayTimeInXg = i3;
        }
    }

    public void setSidewayMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.mSidewayMode = i3;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.mType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return "MSFSideWayUdpConfig{mType=" + this.mType + ",mIsOpen=" + this.mIsOpen + ",mSendDelayTimeInXg=" + this.mSendDelayTimeInXg + ",mSendDelayTimeInWiFi=" + this.mSendDelayTimeInWiFi + ",mResendIntervalTimeInXg=" + this.mResendIntervalTimeInXg + ",mResendIntervalTimeInWiFi=" + this.mResendIntervalTimeInWiFi + ",mSidewayMode=" + this.mSidewayMode + ",}";
    }

    public MSFSideWayUdpConfig(int i3, boolean z16, int i16, int i17, int i18, int i19, int i26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26));
            return;
        }
        this.mType = i3;
        this.mIsOpen = z16;
        this.mSendDelayTimeInXg = i16;
        this.mSendDelayTimeInWiFi = i17;
        this.mResendIntervalTimeInXg = i18;
        this.mResendIntervalTimeInWiFi = i19;
        this.mSidewayMode = i26;
    }
}
