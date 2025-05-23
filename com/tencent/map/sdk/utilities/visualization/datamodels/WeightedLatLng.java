package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WeightedLatLng implements Parcelable {
    public static final Parcelable.Creator<WeightedLatLng> CREATOR = new Parcelable.Creator<WeightedLatLng>() { // from class: com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng.1
        private static WeightedLatLng a(@NonNull Parcel parcel) {
            return new WeightedLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WeightedLatLng createFromParcel(@NonNull Parcel parcel) {
            return new WeightedLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WeightedLatLng[] newArray(int i3) {
            return new WeightedLatLng[i3];
        }

        private static WeightedLatLng[] a(int i3) {
            return new WeightedLatLng[i3];
        }
    };
    private static final double DEFAULT_INTENSITY = 1.0d;
    private double mIntensity;
    private LatLng mPoint;

    /* JADX INFO: Access modifiers changed from: protected */
    public WeightedLatLng(Parcel parcel) {
        this.mPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mIntensity = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof WeightedLatLng)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        LatLng latLng = this.mPoint;
        if (latLng != null) {
            WeightedLatLng weightedLatLng = (WeightedLatLng) obj;
            if (!latLng.equals(weightedLatLng.mPoint) || this.mIntensity != weightedLatLng.mIntensity) {
                return false;
            }
            return true;
        }
        WeightedLatLng weightedLatLng2 = (WeightedLatLng) obj;
        if (weightedLatLng2.mPoint != null || this.mIntensity != weightedLatLng2.mIntensity) {
            return false;
        }
        return true;
    }

    public double getIntensity() {
        return this.mIntensity;
    }

    public LatLng getPoint() {
        return this.mPoint;
    }

    public int hashCode() {
        LatLng latLng = this.mPoint;
        if (latLng != null) {
            return latLng.hashCode() + ((int) (this.mIntensity * 1000000.0d));
        }
        return (int) (this.mIntensity * 1000000.0d);
    }

    public void setIntensity(double d16) {
        if (d16 >= 0.0d) {
            this.mIntensity = d16;
        } else {
            this.mIntensity = 1.0d;
        }
    }

    public void setPoint(LatLng latLng) {
        this.mPoint = latLng;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.mPoint, i3);
        parcel.writeDouble(this.mIntensity);
    }

    public WeightedLatLng(LatLng latLng, double d16) {
        setPoint(latLng);
        setIntensity(d16);
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }
}
