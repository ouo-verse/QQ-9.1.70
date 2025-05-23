package com.tencent.qfsmonet.api.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.config.MonetConfig;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetCropConfig extends MonetConfig {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder extends MonetConfig.Builder {
        static IPatchRedirector $redirector_;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qfsmonet.api.config.MonetConfig.Builder
        public MonetConfig.Builder setManufacturerBlackList(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MonetConfig.Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            super.setManufacturerBlackList(str);
            return this;
        }

        @Override // com.tencent.qfsmonet.api.config.MonetConfig.Builder
        public MonetConfig.Builder setModelBlackList(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MonetConfig.Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            super.setModelBlackList(str);
            return this;
        }
    }

    public MonetCropConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
