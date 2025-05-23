package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFPacketCombineConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class MSFPacketCombineConfigAdapter extends MSFPacketCombineConfig {
    static IPatchRedirector $redirector_ = null;
    public static final boolean DEFAULT_IS_OPEN = true;
    public static final boolean DEFAULT_IS_SUPPORT_NT_REQUEST = false;
    public static final int DEFAULT_MAX_COMBINE_WINDOW_TIME = 6000;
    public static final int DEFAULT_MAX_PACKET_COUNT = 10;
    public static final int DEFAULT_MAX_PACKET_DELAY_TIME = 1000;
    public static final int DEFAULT_MAX_PACKET_SIZE = 3072;
    public static final int DEFAULT_MIN_PACKET_SIZE = 300;
    public static final int DEFAULT_TYPE = 1;

    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFPacketCombineConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFPacketCombineConfig mSFPacketCombineConfig = new MSFPacketCombineConfig();
            this.config = mSFPacketCombineConfig;
            mSFPacketCombineConfig.setType(1);
            mSFPacketCombineConfig.setIsOpen(true);
            mSFPacketCombineConfig.setMaxPacketCount(10);
            mSFPacketCombineConfig.setMaxPacketSize(3072);
            mSFPacketCombineConfig.setMinPacketSize(300);
            mSFPacketCombineConfig.setMaxPacketDelayTime(1000);
            mSFPacketCombineConfig.setMaxCombineWindowTime(6000);
            mSFPacketCombineConfig.setIsSupportNTRequest(false);
        }

        public MSFPacketCombineConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (MSFPacketCombineConfig) iPatchRedirector.redirect((short) 10, (Object) this);
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

        public Builder isSupportNTRequest(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, z16);
            }
            this.config.setIsSupportNTRequest(z16);
            return this;
        }

        public Builder maxCombineWindowTime(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.config.setMaxCombineWindowTime(i3);
            return this;
        }

        public Builder maxPacketCount(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.config.setMaxPacketCount(i3);
            return this;
        }

        public Builder maxPacketDelayTime(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.config.setMaxPacketDelayTime(i3);
            return this;
        }

        public Builder maxPacketSize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.config.setMaxPacketSize(i3);
            return this;
        }

        public Builder minPacketSize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.config.setMinPacketSize(i3);
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

    public MSFPacketCombineConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
