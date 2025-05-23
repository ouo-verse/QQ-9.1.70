package cooperation.qzone.model;

import LBS_V2_PROTOCOL.GPS_V2;
import android.os.Parcel;
import android.os.Parcelable;
import common.config.service.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class GpsInfo4LocalImage implements Parcelable {
    public static final Parcelable.Creator<GpsInfo4LocalImage> CREATOR = new Parcelable.Creator<GpsInfo4LocalImage>() { // from class: cooperation.qzone.model.GpsInfo4LocalImage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsInfo4LocalImage[] newArray(int i3) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GpsInfo4LocalImage createFromParcel(Parcel parcel) {
            return new GpsInfo4LocalImage(parcel.readFloat(), parcel.readFloat());
        }
    };
    public int gpsType;
    public float latitude;
    public float longtitude;

    public GpsInfo4LocalImage() {
    }

    public static GpsInfo4LocalImage copyFrom(GpsInfo4LocalImage gpsInfo4LocalImage) {
        if (gpsInfo4LocalImage == null) {
            return null;
        }
        float f16 = gpsInfo4LocalImage.latitude;
        GpsInfo4LocalImage gpsInfo4LocalImage2 = new GpsInfo4LocalImage(f16, f16);
        gpsInfo4LocalImage2.gpsType = 0;
        return gpsInfo4LocalImage2;
    }

    public static GpsInfo4LocalImage createFrom(GPS_V2 gps_v2) {
        if (gps_v2 == null) {
            return null;
        }
        GpsInfo4LocalImage gpsInfo4LocalImage = new GpsInfo4LocalImage((float) (gps_v2.iLat / 1000000.0d), (float) (gps_v2.iLon / 1000000.0d));
        gpsInfo4LocalImage.gpsType = 0;
        return gpsInfo4LocalImage;
    }

    public static double getDistance(double d16, double d17, double d18, double d19) {
        double rad = rad(d16 / 1000000.0d);
        double rad2 = rad(d18 / 1000000.0d);
        return Math.asin(Math.sqrt(Math.pow(Math.sin((rad - rad2) / 2.0d), 2.0d) + (Math.cos(rad) * Math.cos(rad2) * Math.pow(Math.sin((rad(d17 / 1000000.0d) - rad(d19 / 1000000.0d)) / 2.0d), 2.0d)))) * 2.0d * 6378.137d * 1000.0d;
    }

    private static double rad(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GpsInfo4LocalImage)) {
            return false;
        }
        if (this.gpsType != ((GpsInfo4LocalImage) obj).gpsType || getDistance(this.latitude * 1000000.0f, this.longtitude * 1000000.0f, r13.latitude * 1000000.0f, r13.longtitude * 1000000.0f) > c.a().b()) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "lat: " + this.latitude + ",lon: " + this.longtitude + ",alt: ,gpsType: ";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.latitude);
        parcel.writeFloat(this.longtitude);
    }

    public GpsInfo4LocalImage(Parcel parcel) {
        this.latitude = parcel.readFloat();
        this.longtitude = parcel.readFloat();
    }

    public GpsInfo4LocalImage(float f16, float f17) {
        this.latitude = f16;
        this.longtitude = f17;
        this.gpsType = 0;
    }
}
