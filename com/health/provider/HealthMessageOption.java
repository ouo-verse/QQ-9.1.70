package com.health.provider;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HealthMessageOption implements Parcelable {
    public static final Parcelable.Creator<HealthMessageOption> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public Integer f36081d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f36082e;

    /* renamed from: f, reason: collision with root package name */
    public Double f36083f;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<HealthMessageOption> {
        @Override // android.os.Parcelable.Creator
        public HealthMessageOption createFromParcel(Parcel parcel) {
            return new HealthMessageOption(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public HealthMessageOption[] newArray(int i3) {
            return new HealthMessageOption[i3];
        }
    }

    public HealthMessageOption(Parcel parcel) {
        this.f36081d = 0;
        this.f36082e = 0;
        this.f36083f = Double.valueOf(0.0d);
        this.f36081d = Integer.valueOf(parcel.readInt());
        this.f36082e = Integer.valueOf(parcel.readInt());
        this.f36083f = Double.valueOf(parcel.readDouble());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "HealthMessage{subscribeType=" + this.f36081d + ", dataType=" + this.f36082e + ", targetValue=" + this.f36083f + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36081d.intValue());
        parcel.writeInt(this.f36082e.intValue());
        parcel.writeDouble(this.f36083f.doubleValue());
    }
}
