package com.health.provider;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthDataRemoteResponse implements Parcelable {
    public static final Parcelable.Creator<HealthDataRemoteResponse> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public Integer f36070d;

    /* renamed from: e, reason: collision with root package name */
    public String f36071e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f36072f;

    /* renamed from: h, reason: collision with root package name */
    public Integer f36073h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f36074i;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<HealthDataRemoteResponse> {
        @Override // android.os.Parcelable.Creator
        public HealthDataRemoteResponse createFromParcel(Parcel parcel) {
            return new HealthDataRemoteResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HealthDataRemoteResponse[] newArray(int i3) {
            return new HealthDataRemoteResponse[i3];
        }
    }

    public HealthDataRemoteResponse(Parcel parcel) {
        this.f36070d = 0;
        this.f36071e = null;
        this.f36072f = 0;
        this.f36073h = 1;
        this.f36074i = 0;
        this.f36070d = Integer.valueOf(parcel.readInt());
        this.f36071e = parcel.readString();
        this.f36072f = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.f36073h = Integer.valueOf(parcel.readInt());
        this.f36074i = Integer.valueOf(parcel.readInt());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36070d.intValue());
        parcel.writeString(this.f36071e);
        parcel.writeValue(this.f36072f);
        parcel.writeInt(this.f36073h.intValue());
        parcel.writeInt(this.f36074i.intValue());
    }
}
