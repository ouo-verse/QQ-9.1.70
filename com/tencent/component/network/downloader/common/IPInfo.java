package com.tencent.component.network.downloader.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class IPInfo implements Parcelable {
    public static final Parcelable.Creator<IPInfo> CREATOR = new Parcelable.Creator<IPInfo>() { // from class: com.tencent.component.network.downloader.common.IPInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPInfo createFromParcel(Parcel parcel) {
            return new IPInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPInfo[] newArray(int i3) {
            return new IPInfo[i3];
        }
    };

    /* renamed from: ip, reason: collision with root package name */
    public String f99897ip;
    public int port;

    public IPInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equalWith(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IPInfo)) {
            return false;
        }
        IPInfo iPInfo = (IPInfo) obj;
        if (equalWith(iPInfo.f99897ip, this.f99897ip) && iPInfo.port == this.port) {
            return true;
        }
        return false;
    }

    public String toString() {
        return new String(this.f99897ip + ":" + this.port);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel == null) {
            return;
        }
        parcel.writeString(this.f99897ip);
        parcel.writeInt(this.port);
    }

    public IPInfo(String str, int i3) {
        this.f99897ip = str;
        this.port = i3;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IPInfo m106clone() {
        return new IPInfo(this.f99897ip, this.port);
    }

    public IPInfo(Parcel parcel) {
        if (parcel == null) {
            return;
        }
        this.f99897ip = parcel.readString();
        this.port = parcel.readInt();
    }
}
