package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public class FromToLatLng implements Parcelable {
    public static final Parcelable.Creator<FromToLatLng> CREATOR = new Parcelable.Creator<FromToLatLng>() { // from class: com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng.1
        private static FromToLatLng a(@NonNull Parcel parcel) {
            return new FromToLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ FromToLatLng createFromParcel(@NonNull Parcel parcel) {
            return new FromToLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ FromToLatLng[] newArray(int i3) {
            return new FromToLatLng[i3];
        }

        private static FromToLatLng[] a(int i3) {
            return new FromToLatLng[i3];
        }
    };
    private static final double DEFAULT_ARC = 45.0d;
    private double mArc;
    private LatLng mEndPoint;
    private LatLng mStartPoint;

    protected FromToLatLng(Parcel parcel) {
        this.mStartPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mEndPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mArc = parcel.readDouble();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof FromToLatLng)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        LatLng latLng = this.mStartPoint;
        if (latLng != null && this.mEndPoint != null) {
            FromToLatLng fromToLatLng = (FromToLatLng) obj;
            if (!latLng.equals(fromToLatLng.mStartPoint) || !this.mEndPoint.equals(fromToLatLng.mEndPoint) || this.mArc != fromToLatLng.mArc) {
                return false;
            }
            return true;
        }
        FromToLatLng fromToLatLng2 = (FromToLatLng) obj;
        if (fromToLatLng2.mStartPoint != null || this.mArc != fromToLatLng2.mArc) {
            return false;
        }
        return true;
    }

    public double getArc() {
        return this.mArc;
    }

    public LatLng getEndPoint() {
        return this.mEndPoint;
    }

    public LatLng getStartPoint() {
        return this.mStartPoint;
    }

    public int hashCode() {
        LatLng latLng = this.mStartPoint;
        if (latLng != null && this.mEndPoint != null) {
            return latLng.hashCode() + this.mEndPoint.hashCode() + ((int) (this.mArc * 1000000.0d));
        }
        return (int) (this.mArc * 1000000.0d);
    }

    public void setArc(double d16) {
        if (d16 > 0.0d && d16 <= 90.0d) {
            this.mArc = d16;
        } else {
            this.mArc = DEFAULT_ARC;
        }
    }

    public void setPoint(LatLng latLng, LatLng latLng2) {
        this.mStartPoint = latLng;
        this.mEndPoint = latLng2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.mStartPoint, i3);
        parcel.writeParcelable(this.mEndPoint, i3);
        parcel.writeDouble(this.mArc);
    }

    FromToLatLng(LatLng latLng, LatLng latLng2, double d16) {
        setPoint(latLng, latLng2);
        setArc(d16);
    }

    public FromToLatLng(LatLng latLng, LatLng latLng2) {
        this(latLng, latLng2, DEFAULT_ARC);
    }
}
