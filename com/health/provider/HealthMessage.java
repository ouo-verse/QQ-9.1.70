package com.health.provider;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthMessage implements Parcelable {
    public static final Parcelable.Creator<HealthMessage> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public Integer f36077d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f36078e;

    /* renamed from: f, reason: collision with root package name */
    public Double f36079f;

    /* renamed from: h, reason: collision with root package name */
    public String f36080h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<HealthMessage> {
        @Override // android.os.Parcelable.Creator
        public HealthMessage createFromParcel(Parcel parcel) {
            return new HealthMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HealthMessage[] newArray(int i3) {
            return new HealthMessage[i3];
        }
    }

    public HealthMessage(Parcel parcel) {
        this.f36077d = 0;
        this.f36078e = 0;
        this.f36079f = Double.valueOf(0.0d);
        this.f36080h = null;
        this.f36077d = Integer.valueOf(parcel.readInt());
        this.f36078e = Integer.valueOf(parcel.readInt());
        this.f36079f = Double.valueOf(parcel.readDouble());
        this.f36080h = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "HealthMessage{subscribeType=" + this.f36077d + ", dataType=" + this.f36078e + ", targetValue=" + this.f36079f + ", data='" + this.f36080h + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36077d.intValue());
        parcel.writeInt(this.f36078e.intValue());
        parcel.writeDouble(this.f36079f.doubleValue());
        parcel.writeString(this.f36080h);
    }
}
