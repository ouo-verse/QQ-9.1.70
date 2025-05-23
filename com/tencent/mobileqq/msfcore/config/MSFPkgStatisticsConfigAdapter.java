package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFPkgStatisticsConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class MSFPkgStatisticsConfigAdapter extends MSFPkgStatisticsConfig {
    static IPatchRedirector $redirector_ = null;
    public static final boolean DEFAULT_IS_OPEN = true;
    public static final int DEFAULT_RTT_LOW_BOUND = 500;
    public static final int DEFAULT_RTT_UP_BOUND = 1500;
    public static final int DEFAULT_THRESHOLD_FOR_HEARTBEAT_RTT = 1000;
    public static final int DEFAULT_TOO_LONG_CONN_TIME = 1500;
    public static final int DEFAULT_TYPE = 6;

    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFPkgStatisticsConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFPkgStatisticsConfig mSFPkgStatisticsConfig = new MSFPkgStatisticsConfig();
            this.config = mSFPkgStatisticsConfig;
            mSFPkgStatisticsConfig.setType(6);
            mSFPkgStatisticsConfig.setIsOpen(true);
            mSFPkgStatisticsConfig.setTooLongConnTime(1500);
            mSFPkgStatisticsConfig.setRTTUpBound(1500);
            mSFPkgStatisticsConfig.setRTTLowBound(500);
            mSFPkgStatisticsConfig.setThresholdForHeartBeatRtt(1000);
        }

        public Builder RTTLowBound(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.config.setRTTLowBound(i3);
            return this;
        }

        public Builder RTTUpBound(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.config.setRTTUpBound(i3);
            return this;
        }

        public MSFPkgStatisticsConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (MSFPkgStatisticsConfig) iPatchRedirector.redirect((short) 8, (Object) this);
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

        public Builder thresholdForHeartBeatRtt(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.config.setThresholdForHeartBeatRtt(i3);
            return this;
        }

        public Builder tooLongConnTime(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.config.setTooLongConnTime(i3);
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

    public MSFPkgStatisticsConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
