package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class IPSiteModel$ComicRich implements Parcelable {
    public static final Parcelable.Creator<IPSiteModel$ComicRich> CREATOR = new a();
    public String extCover;
    public String extName;
    public String extTitle;
    public String extUrl;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$ComicRich createFromParcel(Parcel parcel) {
            IPSiteModel$ComicRich iPSiteModel$ComicRich = new IPSiteModel$ComicRich();
            iPSiteModel$ComicRich.extCover = parcel.readString();
            iPSiteModel$ComicRich.extName = parcel.readString();
            iPSiteModel$ComicRich.extTitle = parcel.readString();
            iPSiteModel$ComicRich.extUrl = parcel.readString();
            return iPSiteModel$ComicRich;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$ComicRich[] newArray(int i3) {
            return new IPSiteModel$ComicRich[i3];
        }
    }

    public IPSiteModel$ComicRich() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ComicRich{extCover='" + this.extCover + "', extName='" + this.extName + "', extTitle='" + this.extTitle + "', extUrl='" + this.extUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.extCover);
        parcel.writeString(this.extName);
        parcel.writeString(this.extTitle);
        parcel.writeString(this.extUrl);
    }

    public IPSiteModel$ComicRich(String str, String str2, String str3, String str4) {
        this.extCover = str;
        this.extName = str2;
        this.extTitle = str3;
        this.extUrl = str4;
    }
}
