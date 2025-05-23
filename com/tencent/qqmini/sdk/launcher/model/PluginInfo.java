package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes23.dex */
public class PluginInfo implements Parcelable {
    public static final Parcelable.Creator<PluginInfo> CREATOR = new Parcelable.Creator<PluginInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.PluginInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginInfo createFromParcel(Parcel parcel) {
            PluginInfo pluginInfo = new PluginInfo();
            pluginInfo.pluginId = parcel.readString();
            pluginInfo.innerVersion = parcel.readString();
            return pluginInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginInfo[] newArray(int i3) {
            return new PluginInfo[i3];
        }
    };
    private String innerVersion;
    private String pluginId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getInnerVersion() {
        return this.innerVersion;
    }

    public String getPluginId() {
        return this.pluginId;
    }

    public void setInnerVersion(String str) {
        this.innerVersion = str;
    }

    public void setPluginId(String str) {
        this.pluginId = str;
    }

    public String toString() {
        return "PluginInfo{plugin_id='" + this.pluginId + "', inner_version='" + this.innerVersion + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.pluginId);
        parcel.writeString(this.innerVersion);
    }
}
