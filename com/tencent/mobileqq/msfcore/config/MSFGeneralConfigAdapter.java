package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFGeneralConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFGeneralConfigAdapter extends MSFGeneralConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_BUILD_TYPE = 0;
    public static final int DEFAULT_DEFAULT_TIMEOUT_IN_WIFI = 30;
    public static final int DEFAULT_DEFAULT_TIMEOUT_IN_XG = 45;
    public static final int DEFAULT_DELAY_CONNECT_TO_WIFI_TIMEOUT = 10;
    public static final int DEFAULT_HEARTBEAT_TIMEOUT = 5;
    public static final int DEFAULT_PING_TIMEOUT = 8;
    public static final int DEFAULT_SEC_SIG_TYPE = 2;
    public static final int DEFAULT_TYPE = 0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFGeneralConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFGeneralConfig mSFGeneralConfig = new MSFGeneralConfig();
            this.config = mSFGeneralConfig;
            mSFGeneralConfig.setType(0);
            mSFGeneralConfig.setDefaultTimeoutInXg(45);
            mSFGeneralConfig.setDefaultTimeoutInWiFi(30);
            mSFGeneralConfig.setPingTimeout(8);
            mSFGeneralConfig.setHeartbeatTimeout(5);
            mSFGeneralConfig.setDelayConnectToWiFiTimeout(10);
            mSFGeneralConfig.setBuildType(0);
            mSFGeneralConfig.setSecSigType(2);
        }

        public Builder appIdentifier(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            }
            this.config.setAppIdentifier(str);
            return this;
        }

        public Builder appVersion(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            }
            this.config.setAppVersion(str);
            return this;
        }

        public MSFGeneralConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (MSFGeneralConfig) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return this.config;
        }

        public Builder buildType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.config.setBuildType(i3);
            return this;
        }

        public Builder defaultTimeoutInWifi(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.config.setDefaultTimeoutInWiFi(i3);
            return this;
        }

        public Builder defaultTimeoutInXg(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.config.setDefaultTimeoutInXg(i3);
            return this;
        }

        public Builder delayConnectToWiFiTimeout(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.config.setDelayConnectToWiFiTimeout(i3);
            return this;
        }

        public Builder heartBeatTimeout(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.config.setHeartbeatTimeout(i3);
            return this;
        }

        public Builder pingTimeout(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.config.setPingTimeout(i3);
            return this;
        }

        public Builder sandBoxPath(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
            this.config.setSandBoxPath(str);
            return this;
        }

        public Builder secSigType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.config.setSecSigType(i3);
            return this;
        }

        public Builder sysVersion(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
            }
            this.config.setSysVersion(str);
            return this;
        }

        public Builder type(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.config.setType(i3);
            return this;
        }
    }

    public MSFGeneralConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
