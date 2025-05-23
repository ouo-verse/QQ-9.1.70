package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes23.dex */
public class ResourcePreCacheInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<ResourcePreCacheInfo> CREATOR = new Parcelable.Creator<ResourcePreCacheInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResourcePreCacheInfo createFromParcel(Parcel parcel) {
            ResourcePreCacheInfo resourcePreCacheInfo = new ResourcePreCacheInfo();
            resourcePreCacheInfo.getDataUrl = parcel.readString();
            return resourcePreCacheInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResourcePreCacheInfo[] newArray(int i3) {
            return new ResourcePreCacheInfo[i3];
        }
    };
    public String getDataUrl;

    public ResourcePreCacheInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "getDataUrl:" + this.getDataUrl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.getDataUrl);
    }

    public ResourcePreCacheInfo(String str) {
        this.getDataUrl = str;
    }
}
