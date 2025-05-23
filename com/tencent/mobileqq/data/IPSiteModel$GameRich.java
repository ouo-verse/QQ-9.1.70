package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class IPSiteModel$GameRich implements Parcelable {
    public static final Parcelable.Creator<IPSiteModel$GameRich> CREATOR = new a();
    public String anchorFaceUrl;
    public String anchorId;
    public String anchorName;
    public String coverUrl;
    public String online;
    public String richJumpUrl;
    public String title;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$GameRich createFromParcel(Parcel parcel) {
            IPSiteModel$GameRich iPSiteModel$GameRich = new IPSiteModel$GameRich();
            iPSiteModel$GameRich.anchorFaceUrl = parcel.readString();
            iPSiteModel$GameRich.anchorId = parcel.readString();
            iPSiteModel$GameRich.anchorName = parcel.readString();
            iPSiteModel$GameRich.coverUrl = parcel.readString();
            iPSiteModel$GameRich.online = parcel.readString();
            iPSiteModel$GameRich.title = parcel.readString();
            iPSiteModel$GameRich.richJumpUrl = parcel.readString();
            return iPSiteModel$GameRich;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$GameRich[] newArray(int i3) {
            return new IPSiteModel$GameRich[i3];
        }
    }

    public IPSiteModel$GameRich() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "GameRich{anchorFaceUrl='" + this.anchorFaceUrl + "', anchorId='" + this.anchorId + "', anchorName='" + this.anchorName + "', coverUrl='" + this.coverUrl + "', online='" + this.online + "', title='" + this.title + "', richJumpUrl='" + this.richJumpUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.anchorFaceUrl);
        parcel.writeString(this.anchorId);
        parcel.writeString(this.anchorName);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.online);
        parcel.writeString(this.title);
        parcel.writeString(this.richJumpUrl);
    }

    public IPSiteModel$GameRich(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.anchorFaceUrl = str;
        this.anchorId = str2;
        this.anchorName = str3;
        this.coverUrl = str4;
        this.online = str5;
        this.title = str6;
        this.richJumpUrl = str7;
    }
}
