package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LatLngSpan implements Parcelable {
    public static final Parcelable.Creator<LatLngSpan> CREATOR = new Parcelable.Creator<LatLngSpan>() { // from class: com.tencent.tencentmap.mapsdk.maps.model.LatLngSpan.1
        private static LatLngSpan a(@NonNull Parcel parcel) {
            return new LatLngSpan(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLngSpan createFromParcel(@NonNull Parcel parcel) {
            return new LatLngSpan(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LatLngSpan[] newArray(int i3) {
            return new LatLngSpan[i3];
        }

        private static LatLngSpan[] a(int i3) {
            return new LatLngSpan[i3];
        }
    };
    private double mLatitudeSpan;
    private double mLongitudeSpan;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LatLngSpan) {
            LatLngSpan latLngSpan = (LatLngSpan) obj;
            if (this.mLongitudeSpan == latLngSpan.getLongitudeSpan() && this.mLatitudeSpan == latLngSpan.getLatitudeSpan()) {
                return true;
            }
        }
        return false;
    }

    public double getLatitudeSpan() {
        return this.mLatitudeSpan;
    }

    public double getLongitudeSpan() {
        return this.mLongitudeSpan;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.mLatitudeSpan);
        int i3 = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.mLongitudeSpan);
        return (i3 * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2));
    }

    public void setLatitudeSpan(double d16) {
        this.mLatitudeSpan = d16;
    }

    public void setLongitudeSpan(double d16) {
        this.mLongitudeSpan = d16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeDouble(this.mLatitudeSpan);
        parcel.writeDouble(this.mLongitudeSpan);
    }

    LatLngSpan(@NonNull Parcel parcel) {
        this.mLatitudeSpan = parcel.readDouble();
        this.mLongitudeSpan = parcel.readDouble();
    }

    public LatLngSpan(double d16, double d17) {
        this.mLatitudeSpan = d16;
        this.mLongitudeSpan = d17;
    }
}
