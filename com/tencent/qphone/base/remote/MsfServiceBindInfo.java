package com.tencent.qphone.base.remote;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MsfServiceBindInfo implements Parcelable {
    public static final Parcelable.Creator<MsfServiceBindInfo> CREATOR = new Parcelable.Creator<MsfServiceBindInfo>() { // from class: com.tencent.qphone.base.remote.MsfServiceBindInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsfServiceBindInfo createFromParcel(Parcel parcel) {
            return new MsfServiceBindInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MsfServiceBindInfo[] newArray(int i3) {
            return new MsfServiceBindInfo[i3];
        }
    };
    private int appid;
    private String bootBoradcastName;
    private IMsfServiceCallbacker msfServiceCallbacker;
    private String processName;

    public MsfServiceBindInfo(int i3, String str, String str2, IMsfServiceCallbacker iMsfServiceCallbacker) {
        this.appid = i3;
        this.processName = str;
        this.bootBoradcastName = str2;
        this.msfServiceCallbacker = iMsfServiceCallbacker;
    }

    private void readFromParcel(Parcel parcel) {
        this.appid = parcel.readInt();
        this.processName = parcel.readString();
        this.bootBoradcastName = parcel.readString();
        this.msfServiceCallbacker = IMsfServiceCallbacker.Stub.asInterface(parcel.readStrongBinder());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAppid() {
        return this.appid;
    }

    public String getBootBoradcastName() {
        return this.bootBoradcastName;
    }

    public IMsfServiceCallbacker getMsfServiceCallbacker() {
        return this.msfServiceCallbacker;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setAppid(int i3) {
        this.appid = i3;
    }

    public void setBootBoradcastName(String str) {
        this.bootBoradcastName = str;
    }

    public void setMsfSericeCallbacker(IMsfServiceCallbacker iMsfServiceCallbacker) {
        this.msfServiceCallbacker = iMsfServiceCallbacker;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.appid);
        parcel.writeString(this.processName);
        parcel.writeString(this.bootBoradcastName);
        parcel.writeStrongInterface(this.msfServiceCallbacker);
    }

    public MsfServiceBindInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
