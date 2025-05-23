package com.tencent.mobileqq.qqlive.data.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveSDKConfig {
    static IPatchRedirector $redirector_;
    public ConfigData appConfig;
    public CustomData customData;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private QQLiveSDKConfig config;

        Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.config = new QQLiveSDKConfig();
            }
        }

        public Builder appConfig(ConfigData configData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) configData);
            }
            this.config.appConfig = configData;
            return this;
        }

        public QQLiveSDKConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (QQLiveSDKConfig) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.config;
        }

        public Builder customData(CustomData customData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) customData);
            }
            this.config.customData = customData;
            return this;
        }
    }

    QQLiveSDKConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Builder createBuilder() {
        return new Builder();
    }
}
