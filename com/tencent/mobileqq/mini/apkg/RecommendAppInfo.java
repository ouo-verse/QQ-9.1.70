package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RecommendAppInfo implements Parcelable {
    public static final Parcelable.Creator<RecommendAppInfo> CREATOR = new Parcelable.Creator<RecommendAppInfo>() { // from class: com.tencent.mobileqq.mini.apkg.RecommendAppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecommendAppInfo createFromParcel(Parcel parcel) {
            RecommendAppInfo recommendAppInfo = new RecommendAppInfo();
            recommendAppInfo.appId = parcel.readString();
            recommendAppInfo.exposuredNum = parcel.readInt();
            recommendAppInfo.pullTime = parcel.readLong();
            return recommendAppInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecommendAppInfo[] newArray(int i3) {
            return new RecommendAppInfo[i3];
        }
    };
    public String appId;
    public int exposuredNum;
    public long pullTime;

    public RecommendAppInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getExposuredNum() {
        return this.exposuredNum;
    }

    public long getPullTime() {
        return this.pullTime;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setExposuredNum(int i3) {
        this.exposuredNum = i3;
    }

    public void setPullTime(long j3) {
        this.pullTime = j3;
    }

    public String toString() {
        return "RecommendAppInfo{appId='" + this.appId + "', exposuredNum=" + this.exposuredNum + ", pullTime=" + this.pullTime + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.exposuredNum);
        parcel.writeLong(this.pullTime);
    }

    public RecommendAppInfo(String str, int i3, long j3) {
        this.appId = str;
        this.exposuredNum = i3;
        this.pullTime = j3;
    }
}
