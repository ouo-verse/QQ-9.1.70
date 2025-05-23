package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFSSIDConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFCoreSSIDConfigAdapter extends MSFSSIDConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_HISTORY_SSID_VALIDITY = 3;
    public static final boolean DEFAULT_IS_OPEN = false;
    public static final int DEFAULT_TYPE = 11;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFSSIDConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFSSIDConfig mSFSSIDConfig = new MSFSSIDConfig();
            this.config = mSFSSIDConfig;
            mSFSSIDConfig.setType(11);
            mSFSSIDConfig.setIsOpen(false);
            mSFSSIDConfig.setHistorySSIDValidity(3);
        }

        public MSFSSIDConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (MSFSSIDConfig) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.config;
        }

        public Builder historySSIDValidity(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.config.setHistorySSIDValidity(i3);
            return this;
        }

        public Builder isOpen(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, z16);
            }
            this.config.setIsOpen(z16);
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

    public MSFCoreSSIDConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
