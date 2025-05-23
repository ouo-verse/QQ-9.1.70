package com.health.provider;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthDataInsertRequest implements Parcelable {
    public static final Parcelable.Creator<HealthDataInsertRequest> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public Integer f36062d;

    /* renamed from: e, reason: collision with root package name */
    public String f36063e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<HealthDataInsertRequest> {
        @Override // android.os.Parcelable.Creator
        public HealthDataInsertRequest createFromParcel(Parcel parcel) {
            return new HealthDataInsertRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HealthDataInsertRequest[] newArray(int i3) {
            return new HealthDataInsertRequest[i3];
        }
    }

    public HealthDataInsertRequest(Parcel parcel) {
        this.f36062d = 0;
        this.f36063e = null;
        this.f36062d = Integer.valueOf(parcel.readInt());
        this.f36063e = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36062d.intValue());
        parcel.writeString(this.f36063e);
    }

    public HealthDataInsertRequest() {
        this.f36062d = 0;
        this.f36063e = null;
    }
}
