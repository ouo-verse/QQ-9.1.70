package com.tencent.mobileqq.qqlive.data.config;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
@Deprecated
/* loaded from: classes17.dex */
public class ConfigData implements Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<ConfigData> CREATOR;
    public static final int UNKNOWN_CLIENT_TYPE = -1;
    private String liveAppId;
    private String liveAppKey;
    private int liveClientType;
    private String openSDKAppId;
    private int pullMsgClientType;
    private String smartEyeAppId;
    private String trtcSDKAppId;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private ConfigData configData;

        Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.configData = new ConfigData();
            }
        }

        public ConfigData build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (ConfigData) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.configData;
        }

        public Builder setLiveAppId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.configData.liveAppId = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }

        public Builder setLiveAppKey(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.configData.liveAppKey = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }

        public Builder setLiveClientType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                this.configData.liveClientType = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }

        public Builder setOpenSdkAppId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.configData.openSDKAppId = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }

        public Builder setPullMsgClientType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                this.configData.pullMsgClientType = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }

        public Builder setSmartEyeAppId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                this.configData.smartEyeAppId = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }

        public Builder setTrtcAppId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                this.configData.trtcSDKAppId = str;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            CREATOR = new Parcelable.Creator<ConfigData>() { // from class: com.tencent.mobileqq.qqlive.data.config.ConfigData.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ConfigData createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (ConfigData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                    }
                    ConfigData configData = new ConfigData();
                    configData.readFromParcel(parcel);
                    return configData;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ConfigData[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ConfigData[i3] : (ConfigData[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public ConfigData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.liveAppId = "";
        this.liveAppKey = "";
        this.liveClientType = 0;
        this.pullMsgClientType = -1;
        this.openSDKAppId = "";
        this.trtcSDKAppId = "";
        this.smartEyeAppId = "";
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, obj)).booleanValue();
        }
        if ((obj instanceof ConfigData) && ((ConfigData) obj).liveAppId.equalsIgnoreCase(this.liveAppId)) {
            return true;
        }
        return super.equals(obj);
    }

    public String getLiveAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.liveAppId;
    }

    public String getLiveAppKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.liveAppKey;
    }

    public int getLiveClientType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.liveClientType;
    }

    public String getOpenSDKAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.openSDKAppId;
    }

    public int getPullMsgClientType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.pullMsgClientType;
    }

    public String getSmartEyeAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.smartEyeAppId;
    }

    public String getTrtcSDKAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.trtcSDKAppId;
    }

    public void readFromParcel(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) parcel);
            return;
        }
        this.liveAppId = parcel.readString();
        this.liveAppKey = parcel.readString();
        this.liveClientType = parcel.readInt();
        this.openSDKAppId = parcel.readString();
        this.trtcSDKAppId = parcel.readString();
        this.smartEyeAppId = parcel.readString();
        this.pullMsgClientType = parcel.readInt();
    }

    public void setPullMsgClientType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.pullMsgClientType = i3;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.liveAppId);
        parcel.writeString(this.liveAppKey);
        parcel.writeInt(this.liveClientType);
        parcel.writeString(this.openSDKAppId);
        parcel.writeString(this.trtcSDKAppId);
        parcel.writeString(this.smartEyeAppId);
        parcel.writeInt(this.pullMsgClientType);
    }
}
