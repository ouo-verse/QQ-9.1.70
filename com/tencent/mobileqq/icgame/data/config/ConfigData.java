package com.tencent.mobileqq.icgame.data.config;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class ConfigData implements Parcelable {
    public static final Parcelable.Creator<ConfigData> CREATOR = new Parcelable.Creator<ConfigData>() { // from class: com.tencent.mobileqq.icgame.data.config.ConfigData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfigData createFromParcel(Parcel parcel) {
            ConfigData configData = new ConfigData();
            configData.readFromParcel(parcel);
            return configData;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfigData[] newArray(int i3) {
            return new ConfigData[i3];
        }
    };
    public static final int UNKNOWN_CLIENT_TYPE = -1;
    private String liveAppId = "";
    private String liveAppKey = "";
    private int liveClientType = 0;
    private int pullMsgClientType = -1;
    private String openSDKAppId = "";
    private String trtcSDKAppId = "";
    private String smartEyeAppId = "";
    private String loginAuthAppid = "";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class Builder {
        private ConfigData configData = new ConfigData();

        Builder() {
        }

        public ConfigData build() {
            return this.configData;
        }

        public Builder setLiveAppId(String str) {
            this.configData.liveAppId = str;
            return this;
        }

        public Builder setLiveAppKey(String str) {
            this.configData.liveAppKey = str;
            return this;
        }

        public Builder setLiveClientType(int i3) {
            this.configData.liveClientType = i3;
            return this;
        }

        public Builder setLoginAuthAppid(String str) {
            this.configData.loginAuthAppid = str;
            return this;
        }

        public Builder setOpenSdkAppId(String str) {
            this.configData.openSDKAppId = str;
            return this;
        }

        public Builder setPullMsgClientType(int i3) {
            this.configData.pullMsgClientType = i3;
            return this;
        }

        public Builder setSmartEyeAppId(String str) {
            this.configData.smartEyeAppId = str;
            return this;
        }

        public Builder setTrtcAppId(String str) {
            this.configData.trtcSDKAppId = str;
            return this;
        }
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if ((obj instanceof ConfigData) && ((ConfigData) obj).liveAppId.equalsIgnoreCase(this.liveAppId)) {
            return true;
        }
        return super.equals(obj);
    }

    public String getLiveAppId() {
        return this.liveAppId;
    }

    public String getLiveAppKey() {
        return this.liveAppKey;
    }

    public int getLiveClientType() {
        return this.liveClientType;
    }

    public String getLoginAuthAppid() {
        return this.loginAuthAppid;
    }

    public String getOpenSDKAppId() {
        return this.openSDKAppId;
    }

    public int getPullMsgClientType() {
        return this.pullMsgClientType;
    }

    public String getSmartEyeAppId() {
        return this.smartEyeAppId;
    }

    public String getTrtcSDKAppId() {
        return this.trtcSDKAppId;
    }

    public void readFromParcel(Parcel parcel) {
        this.liveAppId = parcel.readString();
        this.liveAppKey = parcel.readString();
        this.liveClientType = parcel.readInt();
        this.openSDKAppId = parcel.readString();
        this.trtcSDKAppId = parcel.readString();
        this.smartEyeAppId = parcel.readString();
        this.pullMsgClientType = parcel.readInt();
        this.loginAuthAppid = parcel.readString();
    }

    public void setLoginAuthAppid(String str) {
        this.loginAuthAppid = str;
    }

    public void setPullMsgClientType(int i3) {
        this.pullMsgClientType = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.liveAppId);
        parcel.writeString(this.liveAppKey);
        parcel.writeInt(this.liveClientType);
        parcel.writeString(this.openSDKAppId);
        parcel.writeString(this.trtcSDKAppId);
        parcel.writeString(this.smartEyeAppId);
        parcel.writeInt(this.pullMsgClientType);
        parcel.writeString(this.loginAuthAppid);
    }
}
