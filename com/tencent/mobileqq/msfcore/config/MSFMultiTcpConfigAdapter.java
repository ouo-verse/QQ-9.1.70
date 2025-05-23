package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFMultiTcpConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFMultiTcpConfigAdapter extends MSFMultiTcpConfig {
    static IPatchRedirector $redirector_ = null;
    public static final boolean DEFAULT_IS_OPEN = true;
    public static final int DEFAULT_RESEND_INTERVAL_TIME_IN_WIFI = 8;
    public static final int DEFAULT_RESEND_INTERVAL_TIME_IN_XG = 15;
    public static final int DEFAULT_SEND_DELAY_TIME_IN_WIFI = 3;
    public static final int DEFAULT_SEND_DELAY_TIME_IN_XG = 3;
    public static final int DEFAULT_SIDE_WAY_MODE = 2;
    public static final int DEFAULT_TYPE = 4;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFMultiTcpConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFMultiTcpConfig mSFMultiTcpConfig = new MSFMultiTcpConfig();
            this.config = mSFMultiTcpConfig;
            mSFMultiTcpConfig.setType(4);
            mSFMultiTcpConfig.setIsOpen(true);
            mSFMultiTcpConfig.setSendDelayTimeInXg(3);
            mSFMultiTcpConfig.setSendDelayTimeInWiFi(3);
            mSFMultiTcpConfig.setResendIntervalTimeInXg(15);
            mSFMultiTcpConfig.setResendIntervalTimeInWiFi(8);
            mSFMultiTcpConfig.setSidewayMode(2);
        }

        public MSFMultiTcpConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (MSFMultiTcpConfig) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.config;
        }

        public Builder isOpen(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
            this.config.setIsOpen(z16);
            return this;
        }

        public Builder resendIntervalTimeInWiFi(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.config.setResendIntervalTimeInWiFi(i3);
            return this;
        }

        public Builder resendIntervalTimeInXg(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.config.setResendIntervalTimeInXg(i3);
            return this;
        }

        public Builder sendDelayTimeInWiFi(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.config.setSendDelayTimeInWiFi(i3);
            return this;
        }

        public Builder sendDelayTimeInXg(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.config.setSendDelayTimeInXg(i3);
            return this;
        }

        public Builder sidewayMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.config.setSidewayMode(i3);
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

    public MSFMultiTcpConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
