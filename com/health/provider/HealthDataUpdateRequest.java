package com.health.provider;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthDataUpdateRequest implements Parcelable {
    public static final Parcelable.Creator<HealthDataUpdateRequest> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public Integer f36075d;

    /* renamed from: e, reason: collision with root package name */
    public String f36076e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<HealthDataUpdateRequest> {
        @Override // android.os.Parcelable.Creator
        public HealthDataUpdateRequest createFromParcel(Parcel parcel) {
            return new HealthDataUpdateRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HealthDataUpdateRequest[] newArray(int i3) {
            return new HealthDataUpdateRequest[i3];
        }
    }

    public HealthDataUpdateRequest() {
        this.f36075d = 0;
        this.f36076e = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36075d.intValue());
        parcel.writeString(this.f36076e);
    }

    public HealthDataUpdateRequest(Parcel parcel) {
        this.f36075d = 0;
        this.f36076e = null;
        this.f36075d = Integer.valueOf(parcel.readInt());
        this.f36076e = parcel.readString();
    }
}
