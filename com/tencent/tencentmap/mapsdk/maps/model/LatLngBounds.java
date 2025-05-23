package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tencentmap.mapsdk.maps.exception.InvalidLatLngBoundsException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new Parcelable.Creator<LatLngBounds>() { // from class: com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.1
        private static LatLngBounds a(@NonNull Parcel parcel) {
            return LatLngBounds.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LatLngBounds createFromParcel(@NonNull Parcel parcel) {
            return LatLngBounds.readFromParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LatLngBounds[] newArray(int i3) {
            return new LatLngBounds[i3];
        }

        private static LatLngBounds[] a(int i3) {
            return new LatLngBounds[i3];
        }
    };
    private final double latitudeNorth;
    private final double latitudeSouth;
    private final double longitudeEast;
    private final double longitudeWest;
    public final LatLng northeast;
    public final LatLng southwest;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class Builder {
        private final List<LatLng> latLngList = new ArrayList();

        public final LatLngBounds build() {
            if (this.latLngList.size() >= 2) {
                return LatLngBounds.fromLatLngs(this.latLngList);
            }
            throw new InvalidLatLngBoundsException(this.latLngList.size());
        }

        @NonNull
        public final Builder include(@NonNull List<LatLng> list) {
            this.latLngList.addAll(list);
            return this;
        }

        @NonNull
        public final Builder include(@NonNull LatLng latLng) {
            this.latLngList.add(latLng);
            return this;
        }
    }

    LatLngBounds(double d16, double d17, double d18, double d19) {
        this.latitudeNorth = d16;
        this.longitudeEast = d17;
        this.latitudeSouth = d18;
        this.longitudeWest = d19;
        this.northeast = new LatLng(d16, d17);
        this.southwest = new LatLng(d18, d19);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static void checkParams(@FloatRange(from = -90.0d, to = 90.0d) double d16, double d17, @FloatRange(from = -90.0d, to = 90.0d) double d18, double d19) {
        if (!Double.isNaN(d16) && !Double.isNaN(d18)) {
            if (!Double.isNaN(d17) && !Double.isNaN(d19)) {
                if (!Double.isInfinite(d17) && !Double.isInfinite(d19)) {
                    if (d16 <= 90.0d && d16 >= -90.0d && d18 <= 90.0d && d18 >= -90.0d) {
                        if (d16 >= d18) {
                            if (d17 >= d19) {
                                return;
                            } else {
                                throw new IllegalArgumentException("lonEast cannot be less than lonWest");
                            }
                        }
                        throw new IllegalArgumentException("latNorth cannot be less than latSouth");
                    }
                    throw new IllegalArgumentException("latitude must be between -90 and 90");
                }
                throw new IllegalArgumentException("longitude must not be infinite");
            }
            throw new IllegalArgumentException("longitude must not be NaN");
        }
        throw new IllegalArgumentException("latitude must not be NaN");
    }

    private boolean containsLatitude(double d16) {
        if (d16 <= this.latitudeNorth && d16 >= this.latitudeSouth) {
            return true;
        }
        return false;
    }

    private boolean containsLongitude(double d16) {
        if (d16 <= this.longitudeEast && d16 >= this.longitudeWest) {
            return true;
        }
        return false;
    }

    public static LatLngBounds from(@FloatRange(from = -90.0d, to = 90.0d) double d16, double d17, @FloatRange(from = -90.0d, to = 90.0d) double d18, double d19) {
        checkParams(d16, d17, d18, d19);
        return new LatLngBounds(d16, d17, d18, d19);
    }

    static LatLngBounds fromLatLngs(List<? extends LatLng> list) {
        double d16 = Double.MAX_VALUE;
        double d17 = 90.0d;
        double d18 = -90.0d;
        double d19 = -1.7976931348623157E308d;
        for (LatLng latLng : list) {
            if (latLng != null) {
                double latitude = latLng.getLatitude();
                double longitude = latLng.getLongitude();
                d17 = Math.min(d17, latitude);
                d16 = Math.min(d16, longitude);
                d18 = Math.max(d18, latitude);
                d19 = Math.max(d19, longitude);
            }
        }
        return new LatLngBounds(d18, d19, d17, d16);
    }

    private LatLngBounds intersectNoParamCheck(double d16, double d17, double d18, double d19) {
        double max = Math.max(this.longitudeWest, d19);
        double min = Math.min(this.longitudeEast, d17);
        if (min >= max) {
            double max2 = Math.max(this.latitudeSouth, d18);
            double min2 = Math.min(this.latitudeNorth, d16);
            if (min2 >= max2) {
                return new LatLngBounds(min2, min, max2, max);
            }
            return null;
        }
        return null;
    }

    private static double lat_(int i3, int i16) {
        double pow = 3.141592653589793d - ((i16 * 6.283185307179586d) / Math.pow(2.0d, i3));
        return Math.toDegrees(Math.atan((Math.exp(pow) - Math.exp(-pow)) * 0.5d));
    }

    private static double lon_(int i3, int i16) {
        return ((i16 / Math.pow(2.0d, i3)) * 360.0d) - 180.0d;
    }

    protected static LatLngBounds readFromParcel(Parcel parcel) {
        return new LatLngBounds(parcel.readDouble(), parcel.readDouble(), parcel.readDouble(), parcel.readDouble());
    }

    private LatLngBounds unionNoParamCheck(double d16, double d17, double d18, double d19) {
        double d26;
        double d27 = this.latitudeNorth;
        if (d27 < d16) {
            d26 = d16;
        } else {
            d26 = d27;
        }
        double d28 = this.longitudeEast;
        if (d28 < d17) {
            d28 = d17;
        }
        double d29 = this.latitudeSouth;
        if (d29 > d18) {
            d29 = d18;
        }
        double d36 = this.longitudeWest;
        if (d36 > d19) {
            d36 = d19;
        }
        return new LatLngBounds(d26, d28, d29, d36);
    }

    public static LatLngBounds world() {
        return from(90.0d, 180.0d, -90.0d, -180.0d);
    }

    public boolean contains(@NonNull LatLng latLng) {
        return containsLatitude(latLng.getLatitude()) && containsLongitude(latLng.getLongitude());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LatLngBounds) {
            LatLngBounds latLngBounds = (LatLngBounds) obj;
            if (this.latitudeNorth == latLngBounds.getLatNorth() && this.latitudeSouth == latLngBounds.getLatSouth() && this.longitudeEast == latLngBounds.getLonEast() && this.longitudeWest == latLngBounds.getLonWest()) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public LatLng getCenter() {
        return new LatLng((this.latitudeNorth + this.latitudeSouth) / 2.0d, (this.longitudeEast + this.longitudeWest) / 2.0d);
    }

    public double getLatNorth() {
        return this.latitudeNorth;
    }

    public double getLatSouth() {
        return this.latitudeSouth;
    }

    public double getLatitudeSpan() {
        return Math.abs(this.latitudeNorth - this.latitudeSouth);
    }

    public double getLonEast() {
        return this.longitudeEast;
    }

    public double getLonWest() {
        return this.longitudeWest;
    }

    public double getLongitudeSpan() {
        return Math.abs(this.longitudeEast - this.longitudeWest);
    }

    @NonNull
    public LatLng getNorthEast() {
        return new LatLng(this.latitudeNorth, this.longitudeEast);
    }

    @NonNull
    public LatLng getNorthWest() {
        return new LatLng(this.latitudeNorth, this.longitudeWest);
    }

    @NonNull
    public LatLng getSouthEast() {
        return new LatLng(this.latitudeSouth, this.longitudeEast);
    }

    @NonNull
    public LatLng getSouthWest() {
        return new LatLng(this.latitudeSouth, this.longitudeWest);
    }

    @NonNull
    public LatLngSpan getSpan() {
        return new LatLngSpan(getLatitudeSpan(), getLongitudeSpan());
    }

    public int hashCode() {
        return (int) (this.latitudeNorth + 90.0d + ((this.latitudeSouth + 90.0d) * 1000.0d) + ((this.longitudeEast + 180.0d) * 1000000.0d) + ((this.longitudeWest + 180.0d) * 1.0E9d));
    }

    @NonNull
    public LatLngBounds include(@NonNull LatLng latLng) {
        return new Builder().include(getNorthEast()).include(getSouthWest()).include(latLng).build();
    }

    public LatLngBounds including(LatLng latLng) {
        return include(latLng);
    }

    @Nullable
    public LatLngBounds intersect(@NonNull LatLngBounds latLngBounds) {
        return intersectNoParamCheck(latLngBounds.getLatNorth(), latLngBounds.getLonEast(), latLngBounds.getLatSouth(), latLngBounds.getLonWest());
    }

    public boolean isEmptySpan() {
        if (getLongitudeSpan() != 0.0d && getLatitudeSpan() != 0.0d) {
            return false;
        }
        return true;
    }

    @NonNull
    public LatLng[] toLatLngs() {
        return new LatLng[]{getNorthEast(), getSouthWest()};
    }

    @NonNull
    public String toString() {
        return "N:" + this.latitudeNorth + "; E:" + this.longitudeEast + "; S:" + this.latitudeSouth + "; W:" + this.longitudeWest;
    }

    @NonNull
    public LatLngBounds union(@NonNull LatLngBounds latLngBounds) {
        return unionNoParamCheck(latLngBounds.getLatNorth(), latLngBounds.getLonEast(), latLngBounds.getLatSouth(), latLngBounds.getLonWest());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i3) {
        parcel.writeDouble(this.latitudeNorth);
        parcel.writeDouble(this.longitudeEast);
        parcel.writeDouble(this.latitudeSouth);
        parcel.writeDouble(this.longitudeWest);
    }

    @NonNull
    public LatLngBounds intersect(double d16, double d17, double d18, double d19) {
        checkParams(d16, d17, d18, d19);
        return intersectNoParamCheck(d16, d17, d18, d19);
    }

    public static LatLngBounds from(int i3, int i16, int i17) {
        return new LatLngBounds(lat_(i3, i17), lon_(i3, i16 + 1), lat_(i3, i17 + 1), lon_(i3, i16));
    }

    public boolean contains(@NonNull LatLngBounds latLngBounds) {
        return contains(latLngBounds.getNorthEast()) && contains(latLngBounds.getSouthWest());
    }

    @NonNull
    public LatLngBounds union(double d16, double d17, double d18, double d19) {
        checkParams(d16, d17, d18, d19);
        return unionNoParamCheck(d16, d17, d18, d19);
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.northeast = latLng;
        this.southwest = latLng2;
        this.latitudeNorth = latLng.latitude;
        this.longitudeEast = latLng.longitude;
        this.latitudeSouth = latLng2.latitude;
        this.longitudeWest = latLng2.longitude;
    }
}
