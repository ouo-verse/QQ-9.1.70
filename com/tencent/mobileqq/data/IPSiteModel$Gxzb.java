package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class IPSiteModel$Gxzb implements Parcelable {
    public static final Parcelable.Creator<IPSiteModel$Gxzb> CREATOR = new a();
    public String appName;
    public int appid;
    public String cover;
    public int feeType;

    /* renamed from: id, reason: collision with root package name */
    public String f203084id;
    public String name;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Gxzb createFromParcel(Parcel parcel) {
            IPSiteModel$Gxzb iPSiteModel$Gxzb = new IPSiteModel$Gxzb();
            iPSiteModel$Gxzb.appid = parcel.readInt();
            iPSiteModel$Gxzb.appName = parcel.readString();
            iPSiteModel$Gxzb.cover = parcel.readString();
            iPSiteModel$Gxzb.feeType = parcel.readInt();
            iPSiteModel$Gxzb.f203084id = parcel.readString();
            iPSiteModel$Gxzb.name = parcel.readString();
            return iPSiteModel$Gxzb;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Gxzb[] newArray(int i3) {
            return new IPSiteModel$Gxzb[i3];
        }
    }

    public IPSiteModel$Gxzb() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Gxzb{appid=" + this.appid + ", appName='" + this.appName + "', cover='" + this.cover + "', feeType=" + this.feeType + ", id='" + this.f203084id + "', name='" + this.name + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.appid);
        parcel.writeString(this.appName);
        parcel.writeString(this.cover);
        parcel.writeInt(this.feeType);
        parcel.writeString(this.f203084id);
        parcel.writeString(this.name);
    }

    public IPSiteModel$Gxzb(int i3, String str, String str2, int i16, String str3, String str4) {
        this.appid = i3;
        this.appName = str;
        this.cover = str2;
        this.feeType = i16;
        this.f203084id = str3;
        this.name = str4;
    }
}
