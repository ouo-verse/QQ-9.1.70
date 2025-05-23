package com.tencent.mobileqq.mini.apkg;

import NS_MINI_INTERFACE.INTERFACE$StPluginInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: classes33.dex */
public class MiniGamePluginInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<MiniGamePluginInfo> CREATOR = new Parcelable.Creator<MiniGamePluginInfo>() { // from class: com.tencent.mobileqq.mini.apkg.MiniGamePluginInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniGamePluginInfo createFromParcel(Parcel parcel) {
            return new MiniGamePluginInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniGamePluginInfo[] newArray(int i3) {
            return new MiniGamePluginInfo[i3];
        }
    };

    /* renamed from: id, reason: collision with root package name */
    public final String f246320id;
    public final String name;
    public final int packageSize;
    public final String url;
    public final String version;

    public MiniGamePluginInfo(String str, String str2, String str3, String str4, int i3) {
        this.name = str;
        this.f246320id = str2;
        this.version = str3;
        this.url = str4;
        this.packageSize = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.f246320id.hashCode()) * 31) + this.version.hashCode()) * 31) + this.url.hashCode()) * 31) + this.packageSize;
    }

    public String toString() {
        return "MiniGamePluginInfo{name='" + this.name + "', id='" + this.f246320id + "', version='" + this.version + "', url='" + this.url + "', packageSize=" + this.packageSize + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.name);
        parcel.writeString(this.f246320id);
        parcel.writeString(this.version);
        parcel.writeString(this.url);
        parcel.writeInt(this.packageSize);
    }

    public static MiniGamePluginInfo fromProtocol(INTERFACE$StPluginInfo iNTERFACE$StPluginInfo) {
        if (iNTERFACE$StPluginInfo == null || TextUtils.isEmpty(iNTERFACE$StPluginInfo.pluginName.get()) || TextUtils.isEmpty(iNTERFACE$StPluginInfo.pluginId.get()) || TextUtils.isEmpty(iNTERFACE$StPluginInfo.version.get()) || TextUtils.isEmpty(iNTERFACE$StPluginInfo.url.get())) {
            return null;
        }
        return new MiniGamePluginInfo(iNTERFACE$StPluginInfo.pluginName.get(), iNTERFACE$StPluginInfo.pluginId.get(), iNTERFACE$StPluginInfo.version.get(), iNTERFACE$StPluginInfo.url.get(), iNTERFACE$StPluginInfo.fileSize.get());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MiniGamePluginInfo)) {
            return false;
        }
        MiniGamePluginInfo miniGamePluginInfo = (MiniGamePluginInfo) obj;
        if (this.packageSize == miniGamePluginInfo.packageSize && this.name.equals(miniGamePluginInfo.name) && this.f246320id.equals(miniGamePluginInfo.f246320id) && this.version.equals(miniGamePluginInfo.version)) {
            return this.url.equals(miniGamePluginInfo.url);
        }
        return false;
    }

    protected MiniGamePluginInfo(Parcel parcel) {
        this.name = parcel.readString();
        this.f246320id = parcel.readString();
        this.version = parcel.readString();
        this.url = parcel.readString();
        this.packageSize = parcel.readInt();
    }
}
