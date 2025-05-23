package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes33.dex */
public class PreCacheInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<PreCacheInfo> CREATOR = new Parcelable.Creator<PreCacheInfo>() { // from class: com.tencent.mobileqq.mini.apkg.PreCacheInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PreCacheInfo createFromParcel(Parcel parcel) {
            PreCacheInfo preCacheInfo = new PreCacheInfo();
            preCacheInfo.getDataUrl = parcel.readString();
            preCacheInfo.preCacheKey = parcel.readString();
            preCacheInfo.expireTime = parcel.readLong();
            preCacheInfo.cacheType = parcel.readInt();
            preCacheInfo.useProxy = parcel.readInt();
            return preCacheInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PreCacheInfo[] newArray(int i3) {
            return new PreCacheInfo[i3];
        }
    };
    public int cacheType;
    public long expireTime;
    public String getDataUrl;
    public String preCacheKey;
    public int useProxy;

    public PreCacheInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "getDataUrl:" + this.getDataUrl + "  preCacheKey:" + this.preCacheKey + "  expireTime:" + this.expireTime + "  cacheType:" + this.cacheType + "  useProxy:" + this.useProxy;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.getDataUrl);
        parcel.writeString(this.preCacheKey);
        parcel.writeLong(this.expireTime);
        parcel.writeInt(this.cacheType);
        parcel.writeInt(this.useProxy);
    }

    public PreCacheInfo(String str, String str2, long j3, int i3, int i16) {
        this.getDataUrl = str;
        this.preCacheKey = str2;
        this.expireTime = j3;
        this.cacheType = i3;
        this.useProxy = i16;
    }
}
