package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import i2.d;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DeviceInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceInfo> CREATOR = new a();
    private String C = "";

    /* renamed from: d, reason: collision with root package name */
    private String f36262d;

    /* renamed from: e, reason: collision with root package name */
    private String f36263e;

    /* renamed from: f, reason: collision with root package name */
    private String f36264f;

    /* renamed from: h, reason: collision with root package name */
    private String f36265h;

    /* renamed from: i, reason: collision with root package name */
    private String f36266i;

    /* renamed from: m, reason: collision with root package name */
    private String f36267m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<DeviceInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceInfo createFromParcel(Parcel parcel) {
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.f36263e = parcel.readString();
            deviceInfo.f36265h = parcel.readString();
            deviceInfo.f36262d = parcel.readString();
            deviceInfo.f36264f = parcel.readString();
            deviceInfo.f36266i = parcel.readString();
            deviceInfo.f36267m = parcel.readString();
            deviceInfo.C = parcel.readString();
            return deviceInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeviceInfo[] newArray(int i3) {
            return new DeviceInfo[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "{'mDeviceAliasName':" + d.b(this.f36265h) + ",'mDeviceId':" + d.b(this.f36263e) + ",'mTerminalType':" + this.f36264f + ",'mDeviceType':" + this.f36262d + ",'mLoginTime':" + this.f36266i + ",'mLogoutTime':" + this.f36267m + ",'mFrequentlyUsed':" + this.C + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f36263e);
        parcel.writeString(this.f36265h);
        parcel.writeString(this.f36262d);
        parcel.writeString(this.f36264f);
        parcel.writeString(this.f36266i);
        parcel.writeString(this.f36267m);
        parcel.writeString(this.C);
    }
}
