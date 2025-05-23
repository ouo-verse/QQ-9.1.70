package com.health.provider;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthDataDeleteRequest implements Parcelable {
    public static final Parcelable.Creator<HealthDataDeleteRequest> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public Integer f36058d;

    /* renamed from: e, reason: collision with root package name */
    public Long f36059e;

    /* renamed from: f, reason: collision with root package name */
    public Long f36060f;

    /* renamed from: h, reason: collision with root package name */
    public String f36061h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<HealthDataDeleteRequest> {
        @Override // android.os.Parcelable.Creator
        public HealthDataDeleteRequest createFromParcel(Parcel parcel) {
            return new HealthDataDeleteRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HealthDataDeleteRequest[] newArray(int i3) {
            return new HealthDataDeleteRequest[i3];
        }
    }

    public HealthDataDeleteRequest() {
        this.f36058d = 0;
        this.f36059e = 0L;
        this.f36060f = 0L;
        this.f36061h = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36058d.intValue());
        parcel.writeLong(this.f36059e.longValue());
        parcel.writeLong(this.f36060f.longValue());
        parcel.writeString(this.f36061h);
    }

    public HealthDataDeleteRequest(Parcel parcel) {
        this.f36058d = 0;
        this.f36059e = 0L;
        this.f36060f = 0L;
        this.f36061h = null;
        this.f36058d = Integer.valueOf(parcel.readInt());
        this.f36059e = Long.valueOf(parcel.readLong());
        this.f36060f = Long.valueOf(parcel.readLong());
        this.f36061h = parcel.readString();
    }
}
