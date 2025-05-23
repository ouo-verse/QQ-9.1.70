package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes10.dex */
public class IPSiteModel$Video implements Parcelable {
    public static final Parcelable.Creator<IPSiteModel$Video> CREATOR = new a();
    public String buttonDesc;
    public String content;
    public String cover;
    public String desc;
    public String endTime;

    /* renamed from: id, reason: collision with root package name */
    public String f203085id;
    public int isShow;
    public String name;
    public long newEndTime;
    public long newStartTime;
    public String redirectUrl;
    public String showDate;
    public String videoSource;

    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Video createFromParcel(Parcel parcel) {
            IPSiteModel$Video iPSiteModel$Video = new IPSiteModel$Video();
            iPSiteModel$Video.f203085id = parcel.readString();
            iPSiteModel$Video.buttonDesc = parcel.readString();
            iPSiteModel$Video.content = parcel.readString();
            iPSiteModel$Video.cover = parcel.readString();
            iPSiteModel$Video.desc = parcel.readString();
            iPSiteModel$Video.name = parcel.readString();
            iPSiteModel$Video.endTime = parcel.readString();
            iPSiteModel$Video.isShow = parcel.readInt();
            iPSiteModel$Video.newStartTime = parcel.readLong();
            iPSiteModel$Video.newEndTime = parcel.readLong();
            iPSiteModel$Video.redirectUrl = parcel.readString();
            iPSiteModel$Video.videoSource = parcel.readString();
            iPSiteModel$Video.showDate = parcel.readString();
            return iPSiteModel$Video;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IPSiteModel$Video[] newArray(int i3) {
            return new IPSiteModel$Video[i3];
        }
    }

    public IPSiteModel$Video() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Video{id='" + this.f203085id + "', buttonDesc='" + this.buttonDesc + "', content='" + this.content + "', cover='" + this.cover + "', desc='" + this.desc + "', name='" + this.name + "', endTime='" + this.endTime + "', isShow=" + this.isShow + ", newStartTime=" + this.newStartTime + ", newEndTime=" + this.newEndTime + ", redirectUrl='" + this.redirectUrl + "', videoSource='" + this.videoSource + "', showDate='" + this.showDate + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f203085id);
        parcel.writeString(this.buttonDesc);
        parcel.writeString(this.content);
        parcel.writeString(this.cover);
        parcel.writeString(this.desc);
        parcel.writeString(this.name);
        parcel.writeString(this.endTime);
        parcel.writeInt(this.isShow);
        parcel.writeLong(this.newStartTime);
        parcel.writeLong(this.newEndTime);
        parcel.writeString(this.redirectUrl);
        parcel.writeString(this.videoSource);
        parcel.writeString(this.showDate);
    }

    public IPSiteModel$Video(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, long j3, long j16, String str8, String str9, String str10) {
        this.f203085id = str;
        this.buttonDesc = str2;
        this.content = str3;
        this.cover = str4;
        this.desc = str5;
        this.name = str6;
        this.endTime = str7;
        this.isShow = i3;
        this.newStartTime = j3;
        this.newEndTime = j16;
        this.redirectUrl = str8;
        this.videoSource = str9;
        this.showDate = str10;
    }
}
