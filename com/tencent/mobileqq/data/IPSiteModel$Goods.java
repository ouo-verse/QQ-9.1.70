package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class IPSiteModel$Goods implements Parcelable {
    public static final Parcelable.Creator<IPSiteModel$Goods> CREATOR = new a();
    public String cover;
    public String goodsTags;

    /* renamed from: id, reason: collision with root package name */
    public String f203083id;
    public String moreUrl;
    public String name;
    public String price;
    public String saleNum;
    public String saleTags;
    public String svipPrice;
    public String url;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Goods createFromParcel(Parcel parcel) {
            IPSiteModel$Goods iPSiteModel$Goods = new IPSiteModel$Goods();
            iPSiteModel$Goods.cover = parcel.readString();
            iPSiteModel$Goods.goodsTags = parcel.readString();
            iPSiteModel$Goods.f203083id = parcel.readString();
            iPSiteModel$Goods.name = parcel.readString();
            iPSiteModel$Goods.price = parcel.readString();
            iPSiteModel$Goods.saleTags = parcel.readString();
            iPSiteModel$Goods.svipPrice = parcel.readString();
            iPSiteModel$Goods.url = parcel.readString();
            iPSiteModel$Goods.moreUrl = parcel.readString();
            iPSiteModel$Goods.saleNum = parcel.readString();
            return iPSiteModel$Goods;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Goods[] newArray(int i3) {
            return new IPSiteModel$Goods[i3];
        }
    }

    public IPSiteModel$Goods() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Goods{cover='" + this.cover + "', goodsTags='" + this.goodsTags + "', id='" + this.f203083id + "', name='" + this.name + "', price='" + this.price + "', saleTags='" + this.saleTags + "', svipPrice='" + this.svipPrice + "', url='" + this.url + "', moreUrl='" + this.moreUrl + "', saleNum='" + this.saleNum + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.cover);
        parcel.writeString(this.goodsTags);
        parcel.writeString(this.f203083id);
        parcel.writeString(this.name);
        parcel.writeString(this.price);
        parcel.writeString(this.saleTags);
        parcel.writeString(this.svipPrice);
        parcel.writeString(this.url);
        parcel.writeString(this.moreUrl);
        parcel.writeString(this.saleNum);
    }

    public IPSiteModel$Goods(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.cover = str;
        this.goodsTags = str2;
        this.f203083id = str3;
        this.name = str4;
        this.price = str5;
        this.saleTags = str6;
        this.svipPrice = str7;
        this.url = str8;
        this.moreUrl = str9;
        this.saleNum = str10;
    }
}
