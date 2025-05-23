package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFNetworkConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFCoreNetworkConfigAdapter extends MSFNetworkConfig {
    static IPatchRedirector $redirector_ = null;
    public static final boolean DEFAULT_ENABLE_QUIC_REVERT_TCP_ON_CONN_FAIL = true;
    public static final boolean DEFAULT_ENABLE_QUIC_REVERT_TCP_ON_IPV6 = true;
    public static final int DEFAULT_NETWORK_CONN_MODE = 1;
    public static final int DEFAULT_QUICK_IDLE_CHECK_TIMEOUT = 2000;
    public static final int DEFAULT_TYPE = 9;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFNetworkConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFNetworkConfig mSFNetworkConfig = new MSFNetworkConfig();
            this.config = mSFNetworkConfig;
            mSFNetworkConfig.setType(9);
            mSFNetworkConfig.setNetworkConnMode(1);
            mSFNetworkConfig.setEnableQuicRevertToTcpOnConnFail(true);
            mSFNetworkConfig.setEnableQuicRevertToTcpOnIpv6(true);
            mSFNetworkConfig.setQuickIdleCheckTimeout(2000);
        }

        public MSFNetworkConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (MSFNetworkConfig) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.config;
        }

        public Builder connMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.config.setNetworkConnMode(i3);
            return this;
        }

        public Builder isQuicRevertTCPOnConnFail(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
            this.config.setEnableQuicRevertToTcpOnConnFail(z16);
            return this;
        }

        public Builder isQuicRevertTCPOnIPv6(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, z16);
            }
            this.config.setEnableQuicRevertToTcpOnIpv6(z16);
            return this;
        }

        public Builder quickIdleCheckTimeout(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.config.setQuickIdleCheckTimeout(i3);
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

    public MSFCoreNetworkConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
