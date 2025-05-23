package com.tencent.mobileqq.msfcore;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFGeneralConfig implements MSFConfig {
    static IPatchRedirector $redirector_;
    String mAppIdentifier;
    String mAppVersion;
    int mBuildType;
    int mDefaultTimeoutInWiFi;
    int mDefaultTimeoutInXg;
    int mDelayConnectToWiFiTimeout;
    int mHeartbeatTimeout;
    int mPingTimeout;
    String mSandBoxPath;
    int mSecSigType;
    String mSysVersion;
    int mType;

    public MSFGeneralConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSandBoxPath = "";
        this.mAppIdentifier = "";
        this.mAppVersion = "";
        this.mSysVersion = "";
    }

    @NonNull
    public String getAppIdentifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mAppIdentifier;
    }

    @NonNull
    public String getAppVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mAppVersion;
    }

    public int getBuildType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mBuildType;
    }

    public int getDefaultTimeoutInWiFi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mDefaultTimeoutInWiFi;
    }

    public int getDefaultTimeoutInXg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mDefaultTimeoutInXg;
    }

    public int getDelayConnectToWiFiTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mDelayConnectToWiFiTimeout;
    }

    public int getHeartbeatTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mHeartbeatTimeout;
    }

    public int getPingTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mPingTimeout;
    }

    @NonNull
    public String getSandBoxPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mSandBoxPath;
    }

    public int getSecSigType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mSecSigType;
    }

    @NonNull
    public String getSysVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mSysVersion;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mType;
    }

    @NonNull
    public void setAppIdentifier(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            this.mAppIdentifier = str;
        }
    }

    @NonNull
    public void setAppVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str);
        } else {
            this.mAppVersion = str;
        }
    }

    public void setBuildType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.mBuildType = i3;
        }
    }

    public void setDefaultTimeoutInWiFi(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.mDefaultTimeoutInWiFi = i3;
        }
    }

    public void setDefaultTimeoutInXg(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.mDefaultTimeoutInXg = i3;
        }
    }

    public void setDelayConnectToWiFiTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
        } else {
            this.mDelayConnectToWiFiTimeout = i3;
        }
    }

    public void setHeartbeatTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.mHeartbeatTimeout = i3;
        }
    }

    public void setPingTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.mPingTimeout = i3;
        }
    }

    @NonNull
    public void setSandBoxPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.mSandBoxPath = str;
        }
    }

    public void setSecSigType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.mSecSigType = i3;
        }
    }

    @NonNull
    public void setSysVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            this.mSysVersion = str;
        }
    }

    public void setType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return "MSFGeneralConfig{mType=" + this.mType + ",mDefaultTimeoutInXg=" + this.mDefaultTimeoutInXg + ",mDefaultTimeoutInWiFi=" + this.mDefaultTimeoutInWiFi + ",mPingTimeout=" + this.mPingTimeout + ",mHeartbeatTimeout=" + this.mHeartbeatTimeout + ",mDelayConnectToWiFiTimeout=" + this.mDelayConnectToWiFiTimeout + ",mBuildType=" + this.mBuildType + ",mSecSigType=" + this.mSecSigType + ",mSandBoxPath=" + this.mSandBoxPath + ",mAppIdentifier=" + this.mAppIdentifier + ",mAppVersion=" + this.mAppVersion + ",mSysVersion=" + this.mSysVersion + ",}";
    }

    public MSFGeneralConfig(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), str, str2, str3, str4);
            return;
        }
        this.mType = i3;
        this.mDefaultTimeoutInXg = i16;
        this.mDefaultTimeoutInWiFi = i17;
        this.mPingTimeout = i18;
        this.mHeartbeatTimeout = i19;
        this.mDelayConnectToWiFiTimeout = i26;
        this.mBuildType = i27;
        this.mSecSigType = i28;
        this.mSandBoxPath = str;
        this.mAppIdentifier = str2;
        this.mAppVersion = str3;
        this.mSysVersion = str4;
    }
}
