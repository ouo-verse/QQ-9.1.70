package com.tencent.tencentmap.mapsdk.maps.model;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LatLng implements Parcelable, Coordinate {
    public static final Parcelable.Creator<LatLng> CREATOR = new Parcelable.Creator<LatLng>() { // from class: com.tencent.tencentmap.mapsdk.maps.model.LatLng.1
        private static LatLng a(@NonNull Parcel parcel) {
            return new LatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLng createFromParcel(@NonNull Parcel parcel) {
            return new LatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LatLng[] newArray(int i3) {
            return new LatLng[i3];
        }

        private static LatLng[] a(int i3) {
            return new LatLng[i3];
        }
    };
    public double altitude;
    public double latitude;
    public double longitude;
    private boolean throwException;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Builder {
        private double mAltitude;
        private double mLatitude;
        private double mLongitude;
        private final boolean mThrowException;

        public Builder(LatLng latLng, boolean z16) {
            if (latLng != null) {
                this.mLongitude = latLng.getLongitude();
                this.mLatitude = latLng.getLatitude();
                this.mAltitude = latLng.getAltitude();
            }
            this.mThrowException = z16;
        }

        public LatLng build() {
            return new LatLng(this.mLatitude, this.mLongitude, this.mAltitude, this.mThrowException);
        }

        public Builder setAltitude(double d16) {
            this.mAltitude = d16;
            return this;
        }

        public Builder setLatitude(double d16) {
            this.mLatitude = d16;
            return this;
        }

        public Builder setLongitude(double d16) {
            this.mLongitude = d16;
            return this;
        }
    }

    public LatLng() {
        this.altitude = 0.0d;
        this.throwException = false;
        this.latitude = 0.0d;
        this.longitude = 0.0d;
    }

    private void doThrowException(double d16, double d17, double d18, boolean z16) {
        this.throwException = z16;
        if (z16) {
            setLatitudeThrowException(d16);
            setLongitudeThrowException(d17);
        } else {
            setLatitude(d16);
            setLongitude(d17);
        }
        setAltitude(d18);
    }

    public static Builder newBuilder() {
        return new Builder(null, false);
    }

    public static Builder newBuilderThrowException() {
        return new Builder(null, true);
    }

    static double wrap(double d16, double d17, double d18) {
        double d19 = d18 - d17;
        double d26 = (((d16 - d17) % d19) + d19) % d19;
        return (d16 < d18 || d26 != 0.0d) ? d26 + d17 : d18;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LatLng latLng = (LatLng) obj;
            if (Double.compare(latLng.altitude, this.altitude) == 0 && Double.compare(latLng.latitude, this.latitude) == 0 && Double.compare(latLng.longitude, this.longitude) == 0) {
                return true;
            }
        }
        return false;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        int i3 = (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.altitude);
        return (i3 * 31) + ((int) ((doubleToLongBits3 >>> 32) ^ doubleToLongBits3));
    }

    public boolean isThrowException() {
        return this.throwException;
    }

    public void setAltitude(double d16) {
        this.altitude = d16;
    }

    public void setLatitude(@FloatRange(from = -90.0d, to = 90.0d) double d16) {
        if (Double.isNaN(d16)) {
            LogUtil.d("latitude must not be NaN");
        } else if (Math.abs(d16) > 90.0d) {
            LogUtil.d("latitude must be between -90 and 90");
        } else {
            this.latitude = d16;
        }
    }

    public void setLatitudeThrowException(@FloatRange(from = -90.0d, to = 90.0d) double d16) {
        if (!Double.isNaN(d16)) {
            if (Math.abs(d16) <= 90.0d) {
                this.latitude = d16;
                return;
            }
            throw new IllegalArgumentException("latitude must be between -90 and 90");
        }
        throw new IllegalArgumentException("latitude must not be NaN");
    }

    public void setLongitude(@FloatRange(from = -1.7976931348623157E308d, to = Double.MAX_VALUE) double d16) {
        if (Double.isNaN(d16)) {
            LogUtil.d("longitude must not be NaN");
        } else if (Double.isInfinite(d16)) {
            LogUtil.d("longitude must not be infinite");
        } else {
            this.longitude = d16;
        }
    }

    public void setLongitudeThrowException(@FloatRange(from = -1.7976931348623157E308d, to = Double.MAX_VALUE) double d16) {
        if (!Double.isNaN(d16)) {
            if (!Double.isInfinite(d16)) {
                this.longitude = d16;
                return;
            }
            throw new IllegalArgumentException("longitude must not be infinite");
        }
        throw new IllegalArgumentException("longitude must not be NaN");
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setX(double d16) {
        this.latitude = d16;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setY(double d16) {
        this.longitude = d16;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public void setZ(double d16) {
        this.altitude = d16;
    }

    @NonNull
    public String toString() {
        return "LatLng [latitude=" + this.latitude + ", longitude=" + this.longitude + ", altitude=" + this.altitude + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.altitude);
        parcel.writeByte(this.throwException ? (byte) 1 : (byte) 0);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double x() {
        return this.latitude;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double y() {
        return this.longitude;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public double z() {
        return this.altitude;
    }

    public static Builder newBuilder(LatLng latLng) {
        return new Builder(latLng, false);
    }

    public static Builder newBuilderThrowException(LatLng latLng) {
        return new Builder(latLng, true);
    }

    @NonNull
    public LatLng wrap() {
        return new LatLng(this.latitude, wrap(this.longitude, -180.0d, 180.0d));
    }

    public LatLng(double d16, double d17) {
        this.altitude = 0.0d;
        this.throwException = false;
        setLatitude(d16);
        setLongitude(d17);
    }

    public LatLng(double d16, double d17, double d18) {
        this.altitude = 0.0d;
        this.throwException = false;
        setLatitude(d16);
        setLongitude(d17);
        setAltitude(d18);
    }

    public LatLng(double d16, double d17, double d18, boolean z16) {
        this.altitude = 0.0d;
        this.throwException = false;
        doThrowException(d16, d17, d18, z16);
    }

    public LatLng(Location location) {
        this(location.getLatitude(), location.getLongitude(), location.getAltitude());
    }

    public LatLng(LatLng latLng) {
        this.altitude = 0.0d;
        this.throwException = false;
        this.latitude = latLng.latitude;
        this.longitude = latLng.longitude;
        this.altitude = latLng.altitude;
        this.throwException = latLng.throwException;
    }

    public LatLng(Parcel parcel) {
        this.altitude = 0.0d;
        this.throwException = false;
        doThrowException(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readByte() != 0);
    }
}
