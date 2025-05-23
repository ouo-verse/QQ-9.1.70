package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes33.dex */
public class PluginInfo implements Parcelable {
    public static final Parcelable.Creator<PluginInfo> CREATOR = new Parcelable.Creator<PluginInfo>() { // from class: com.tencent.mobileqq.mini.apkg.PluginInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginInfo createFromParcel(Parcel parcel) {
            PluginInfo pluginInfo = new PluginInfo();
            pluginInfo.plugin_id = parcel.readString();
            pluginInfo.inner_version = parcel.readString();
            return pluginInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PluginInfo[] newArray(int i3) {
            return new PluginInfo[i3];
        }
    };
    private String inner_version;
    private String plugin_id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getInnerVersion() {
        return this.inner_version;
    }

    public String getPluginId() {
        return this.plugin_id;
    }

    public void setInnerVersion(String str) {
        this.inner_version = str;
    }

    public void setPluginId(String str) {
        this.plugin_id = str;
    }

    public String toString() {
        return "PluginInfo{plugin_id='" + this.plugin_id + "', inner_version='" + this.inner_version + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.plugin_id);
        parcel.writeString(this.inner_version);
    }
}
