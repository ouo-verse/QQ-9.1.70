package com.tencent.mobileqq.msfcore.config;

import com.tencent.mobileqq.msfcore.MSFModifyConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFCoreModifyConfigAdapter extends MSFModifyConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_TYPE = 8;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private final MSFModifyConfig config;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            MSFModifyConfig mSFModifyConfig = new MSFModifyConfig();
            this.config = mSFModifyConfig;
            mSFModifyConfig.setType(8);
        }

        public Builder ConfigMap(HashMap<String, Boolean> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) hashMap);
            }
            this.config.setConfigMap(hashMap);
            return this;
        }

        public MSFModifyConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MSFModifyConfig) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.config;
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

    public MSFCoreModifyConfigAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
