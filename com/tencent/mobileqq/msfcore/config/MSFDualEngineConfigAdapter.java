package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFDualEngineConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFDualEngineConfigAdapter extends MSFDualEngineConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_ACTIVE_CHECK_PING_INTERVAL = 45;
    public static final int DEFAULT_BACKGROUND_CHECK_PING_INTERVAL = 300;
    public static final int DEFAULT_CHECK_PING_TIMEOUT = 15;
    public static final boolean DEFAULT_ENABLE_0RTT_PING = false;
    public static final boolean DEFAULT_ENABLE_DYNAMIC_SIDE_CONN_POOL = true;
    public static final boolean DEFAULT_ENABLE_HANDSHAKE_PERSIST = false;
    public static final boolean DEFAULT_ENABLE_HEARTBEAT_OPT = true;
    public static final int DEFAULT_MAIN_CONN_TYPE = 1;
    public static final int DEFAULT_SIDE_WAY_CONN_LIMIT = 1;
    public static final int DEFAULT_SIDE_WAY_CONN_TYPE = 5;
    public static final int DEFAULT_TYPE = 13;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFDualEngineConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFDualEngineConfig mSFDualEngineConfig = new MSFDualEngineConfig();
            this.config = mSFDualEngineConfig;
            mSFDualEngineConfig.setType(13);
            mSFDualEngineConfig.setMainConnType(1);
            mSFDualEngineConfig.setSideWayConnType(5);
            mSFDualEngineConfig.setSideWayConnLimit(1);
            mSFDualEngineConfig.setIsEnableHeartBeatOpt(true);
            mSFDualEngineConfig.setCheckPingTimeout(15);
            mSFDualEngineConfig.setActiveCheckPingInterval(45);
            mSFDualEngineConfig.setBackgroundCheckPingInterval(300);
            mSFDualEngineConfig.setEnableDynamicSideConnPool(true);
            mSFDualEngineConfig.setEnableHandshakePersist(false);
            mSFDualEngineConfig.setEnable0RTTPing(false);
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

        public MSFDualEngineConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (MSFDualEngineConfig) iPatchRedirector.redirect((short) 13, (Object) this);
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

        public Builder enable0RTTPing(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, z16);
            }
            this.config.setEnable0RTTPing(z16);
            return this;
        }

        public Builder enableDynamicSideConnPool(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, z16);
            }
            this.config.setEnableDynamicSideConnPool(z16);
            return this;
        }

        public Builder enableHandshakePersist(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, z16);
            }
            this.config.setEnableHandshakePersist(z16);
            return this;
        }

        public Builder isEnableHeartbeatOpt(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, z16);
            }
            this.config.setIsEnableHeartBeatOpt(z16);
            return this;
        }

        public Builder mainConnType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.config.setMainConnType(i3);
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

        public Builder sideWayConnType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.config.setSideWayConnType(i3);
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

    public MSFDualEngineConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
