package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFPkgCompressConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* loaded from: classes15.dex */
public class MSFPkgCompressConfigAdapter extends MSFPkgCompressConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_COMPRESS_THRESHOLD = 3000;
    public static final boolean DEFAULT_IS_OPEN = false;
    public static final int DEFAULT_TYPE = 7;

    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFPkgCompressConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFPkgCompressConfig mSFPkgCompressConfig = new MSFPkgCompressConfig();
            this.config = mSFPkgCompressConfig;
            mSFPkgCompressConfig.setType(7);
            mSFPkgCompressConfig.setIsOpen(false);
            mSFPkgCompressConfig.setCompressThreshold(3000);
            mSFPkgCompressConfig.setCompressThresholdMap(new HashMap<>());
        }

        public MSFPkgCompressConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (MSFPkgCompressConfig) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.config;
        }

        public Builder compressThreshold(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.config.setCompressThreshold(i3);
            return this;
        }

        public Builder compressThresholdMap(HashMap<String, Integer> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) hashMap);
            }
            this.config.setCompressThresholdMap(hashMap);
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

    public MSFPkgCompressConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
