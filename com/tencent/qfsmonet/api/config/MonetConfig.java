package com.tencent.qfsmonet.api.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MonetConfig {
    static IPatchRedirector $redirector_;
    private String mChipBlackList;
    private String mChipWhiteList;
    private boolean mConfigEnable;
    private boolean mConfigEnableAlive;
    private String mManufacturerBlackList;
    private String mManufacturerWhiteList;
    private String mModelBlackList;
    private String mModelWhiteList;
    private int mSupportApiVersion;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private String mChipBlackList;
        private String mChipWhiteList;
        private boolean mConfigEnable;
        private boolean mConfigEnableAlive;
        private String mManufacturerBlackList;
        private String mManufacturerWhiteList;
        private String mModelBlackList;
        private String mModelWhiteList;
        private int mSupportApiVersion;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mConfigEnableAlive = false;
            }
        }

        public MonetConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (MonetConfig) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            MonetConfig monetConfig = new MonetConfig();
            monetConfig.mConfigEnable = this.mConfigEnable;
            monetConfig.mConfigEnableAlive = this.mConfigEnableAlive;
            monetConfig.mModelBlackList = this.mModelBlackList;
            monetConfig.mModelWhiteList = this.mModelWhiteList;
            monetConfig.mManufacturerBlackList = this.mManufacturerBlackList;
            monetConfig.mManufacturerWhiteList = this.mManufacturerWhiteList;
            monetConfig.mChipBlackList = this.mChipBlackList;
            monetConfig.mChipWhiteList = this.mChipWhiteList;
            monetConfig.mSupportApiVersion = this.mSupportApiVersion;
            return monetConfig;
        }

        public Builder setChipBlackList(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            }
            this.mChipBlackList = str;
            return this;
        }

        public Builder setChipWhiteList(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            }
            this.mChipWhiteList = str;
            return this;
        }

        public Builder setConfigEnable(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
            this.mConfigEnable = z16;
            this.mConfigEnableAlive = true;
            return this;
        }

        public Builder setManufacturerBlackList(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            }
            this.mManufacturerBlackList = str;
            return this;
        }

        public Builder setManufacturerWhiteList(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            }
            this.mManufacturerWhiteList = str;
            return this;
        }

        public Builder setModelBlackList(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.mModelBlackList = str;
            return this;
        }

        public Builder setModelWhiteList(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
            this.mModelWhiteList = str;
            return this;
        }

        public Builder setSupportApiVersion(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.mSupportApiVersion = i3;
            return this;
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface MonetConfigType {
        public static final String CROP_INFO_CONFIG = "CROP_INFO_CONFIG";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MonetConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mConfigEnable = true;
        this.mConfigEnableAlive = false;
        this.mModelBlackList = null;
        this.mModelWhiteList = null;
        this.mManufacturerBlackList = null;
        this.mManufacturerWhiteList = null;
        this.mChipBlackList = null;
        this.mChipWhiteList = null;
        this.mSupportApiVersion = 0;
    }

    public String getChipBlackList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mChipBlackList;
    }

    public String getChipWhiteList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mChipWhiteList;
    }

    public boolean getConfigEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mConfigEnable;
    }

    public boolean getConfigEnableAlive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mConfigEnableAlive;
    }

    public String getManufacturerBlackList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mManufacturerBlackList;
    }

    public String getManufacturerWhiteList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mManufacturerWhiteList;
    }

    public String getModelBlackList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mModelBlackList;
    }

    public String getModelWhiteList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mModelWhiteList;
    }

    public int getSupportApiVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mSupportApiVersion;
    }
}
