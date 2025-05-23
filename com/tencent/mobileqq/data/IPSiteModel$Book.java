package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class IPSiteModel$Book implements Parcelable {
    public static final Parcelable.Creator<IPSiteModel$Book> CREATOR = new a();
    public String authorName;
    public String cover;
    public String desc;

    /* renamed from: id, reason: collision with root package name */
    public String f203080id;
    public String jumpUrl;
    public String name;
    public String recommDesc;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Book createFromParcel(Parcel parcel) {
            IPSiteModel$Book iPSiteModel$Book = new IPSiteModel$Book();
            iPSiteModel$Book.cover = parcel.readString();
            iPSiteModel$Book.desc = parcel.readString();
            iPSiteModel$Book.f203080id = parcel.readString();
            iPSiteModel$Book.jumpUrl = parcel.readString();
            iPSiteModel$Book.name = parcel.readString();
            iPSiteModel$Book.recommDesc = parcel.readString();
            iPSiteModel$Book.authorName = parcel.readString();
            return iPSiteModel$Book;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Book[] newArray(int i3) {
            return new IPSiteModel$Book[i3];
        }
    }

    public IPSiteModel$Book() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Book{cover='" + this.cover + "', desc='" + this.desc + "', id='" + this.f203080id + "', jumpUrl='" + this.jumpUrl + "', name='" + this.name + "', recommDesc='" + this.recommDesc + "', authorName='" + this.authorName + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.cover);
        parcel.writeString(this.desc);
        parcel.writeString(this.f203080id);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.recommDesc);
        parcel.writeString(this.authorName);
    }

    public IPSiteModel$Book(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.cover = str;
        this.desc = str2;
        this.f203080id = str3;
        this.jumpUrl = str4;
        this.name = str5;
        this.recommDesc = str6;
        this.authorName = str7;
    }
}
