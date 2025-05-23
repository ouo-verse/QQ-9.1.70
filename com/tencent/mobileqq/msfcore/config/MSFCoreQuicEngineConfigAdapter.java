package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFQuicEngineConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFCoreQuicEngineConfigAdapter extends MSFQuicEngineConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_ACTIVE_CHECK_PING_INTERVAL = 45;
    public static final int DEFAULT_BACKGROUND_CHECK_PING_INTERVAL = 300;
    public static final int DEFAULT_CHECK_PING_TIMEOUT = 15;
    public static final boolean DEFAULT_IS_ENABLE_HEARTBEAT_OPT = true;
    public static final double DEFAULT_PARALLEL_CONN_INTERVAL = 3000.0d;
    public static final int DEFAULT_PARALLEL_CONN_NUM = 3;
    public static final int DEFAULT_SIDE_WAY_CONN_LIMIT = 0;
    public static final int DEFAULT_TYPE = 10;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFQuicEngineConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFQuicEngineConfig mSFQuicEngineConfig = new MSFQuicEngineConfig();
            this.config = mSFQuicEngineConfig;
            mSFQuicEngineConfig.setType(10);
            mSFQuicEngineConfig.setParallelConnNum(3);
            mSFQuicEngineConfig.setParallelConnInterval(3000.0d);
            mSFQuicEngineConfig.setSideWayConnLimit(0);
            mSFQuicEngineConfig.setIsEnableHearbeatOpt(true);
            mSFQuicEngineConfig.setCheckPingTimeout(15);
            mSFQuicEngineConfig.setActiveCheckPingInterval(45);
            mSFQuicEngineConfig.setBackgroundCheckPingInterval(300);
            mSFQuicEngineConfig.setEnableHandshakePersist(false);
        }

        public Builder activeCheckPingInterval(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.config.setActiveCheckPingInterval(i3);
            return this;
        }

        public Builder backgroundCheckPingInterval(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.config.setBackgroundCheckPingInterval(i3);
            return this;
        }

        public MSFQuicEngineConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (MSFQuicEngineConfig) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.config;
        }

        public Builder checkPingTimeout(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.config.setCheckPingTimeout(i3);
            return this;
        }

        public Builder enableHandshakePersist(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, z16);
            }
            this.config.setEnableHandshakePersist(z16);
            return this;
        }

        public Builder isEnableHeartbeatOpt(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.config.setIsEnableHearbeatOpt(z16);
            return this;
        }

        public Builder parallelConnInterval(double d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, this, Double.valueOf(d16));
            }
            this.config.setParallelConnInterval(d16);
            return this;
        }

        public Builder parallelConnNum(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.config.setParallelConnNum(i3);
            return this;
        }

        public Builder sideWayConnLimit(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.config.setSideWayConnLimit(i3);
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

    public MSFCoreQuicEngineConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
