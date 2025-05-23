package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ScatterLatLng implements Parcelable {
    public static final Parcelable.Creator<ScatterLatLng> CREATOR = new Parcelable.Creator<ScatterLatLng>() { // from class: com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng.1
        private static ScatterLatLng a(@NonNull Parcel parcel) {
            return new ScatterLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ScatterLatLng createFromParcel(@NonNull Parcel parcel) {
            return new ScatterLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ScatterLatLng[] newArray(int i3) {
            return new ScatterLatLng[i3];
        }

        private static ScatterLatLng[] a(int i3) {
            return new ScatterLatLng[i3];
        }
    };
    private static final double DEFAULT_INTENSITY = 1.0d;
    private static final int DEFAULT_TYPE = 0;
    private double mIntensity;
    private LatLng mPoint;
    private int mType;

    protected ScatterLatLng(Parcel parcel) {
        this.mPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mType = parcel.readInt();
        this.mIntensity = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ScatterLatLng)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        LatLng latLng = this.mPoint;
        if (latLng != null) {
            ScatterLatLng scatterLatLng = (ScatterLatLng) obj;
            if (!latLng.equals(scatterLatLng.mPoint) || this.mType != scatterLatLng.mType || this.mIntensity != scatterLatLng.mIntensity) {
                return false;
            }
            return true;
        }
        ScatterLatLng scatterLatLng2 = (ScatterLatLng) obj;
        if (scatterLatLng2.mPoint != null || this.mType != scatterLatLng2.mType || this.mIntensity != scatterLatLng2.mIntensity) {
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

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        int i3;
        double d16;
        LatLng latLng = this.mPoint;
        if (latLng != null) {
            i3 = latLng.hashCode() + ((int) (this.mType * 1000000.0d));
            d16 = this.mIntensity;
        } else {
            i3 = (int) (this.mType * 1000000.0d);
            d16 = this.mIntensity;
        }
        return i3 + ((int) (d16 * 1000000.0d));
    }

    public void setIntensity(double d16) {
        this.mIntensity = d16;
    }

    public void setPoint(LatLng latLng) {
        this.mPoint = latLng;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.mPoint, i3);
        parcel.writeInt(this.mType);
        parcel.writeDouble(this.mIntensity);
    }

    public ScatterLatLng(LatLng latLng, int i3) {
        setPoint(latLng);
        setType(i3);
        setIntensity(1.0d);
    }

    public ScatterLatLng(LatLng latLng, double d16) {
        setPoint(latLng);
        setType(0);
        setIntensity(d16);
    }

    public ScatterLatLng(LatLng latLng, int i3, double d16) {
        setPoint(latLng);
        setType(i3);
        setIntensity(d16);
    }

    public ScatterLatLng(LatLng latLng) {
        this(latLng, 0, 1.0d);
    }
}
