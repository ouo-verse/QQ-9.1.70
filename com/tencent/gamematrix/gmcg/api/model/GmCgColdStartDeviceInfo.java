package com.tencent.gamematrix.gmcg.api.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GmCgColdStartDeviceInfo implements Parcelable {
    public static final Parcelable.Creator<GmCgColdStartDeviceInfo> CREATOR = new Parcelable.Creator<GmCgColdStartDeviceInfo>() { // from class: com.tencent.gamematrix.gmcg.api.model.GmCgColdStartDeviceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GmCgColdStartDeviceInfo createFromParcel(Parcel parcel) {
            return new GmCgColdStartDeviceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GmCgColdStartDeviceInfo[] newArray(int i3) {
            return new GmCgColdStartDeviceInfo[i3];
        }
    };
    public String coldStartDevice;
    public long coldStartTime;
    public String deviceState;
    public String pBizInfo;
    public double startPercent;

    public GmCgColdStartDeviceInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "GmCgColdStartDeviceInfo{coldStartDevice='" + this.coldStartDevice + "', deviceState='" + this.deviceState + "', startPercent=" + this.startPercent + ", pBizInfo='" + this.pBizInfo + "', coldStartTime=" + this.coldStartTime + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.coldStartDevice);
        parcel.writeString(this.deviceState);
        parcel.writeDouble(this.startPercent);
        parcel.writeString(this.pBizInfo);
        parcel.writeLong(this.coldStartTime);
    }

    protected GmCgColdStartDeviceInfo(Parcel parcel) {
        this.coldStartDevice = parcel.readString();
        this.deviceState = parcel.readString();
        this.startPercent = parcel.readDouble();
        this.pBizInfo = parcel.readString();
        this.coldStartTime = parcel.readLong();
    }
}
