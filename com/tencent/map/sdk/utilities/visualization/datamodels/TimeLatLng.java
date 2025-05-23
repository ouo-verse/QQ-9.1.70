package com.tencent.map.sdk.utilities.visualization.datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TimeLatLng implements Parcelable {
    public static final Parcelable.Creator<TimeLatLng> CREATOR = new Parcelable.Creator<TimeLatLng>() { // from class: com.tencent.map.sdk.utilities.visualization.datamodels.TimeLatLng.1
        private static TimeLatLng a(@NonNull Parcel parcel) {
            return new TimeLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeLatLng createFromParcel(@NonNull Parcel parcel) {
            return new TimeLatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeLatLng[] newArray(int i3) {
            return new TimeLatLng[i3];
        }

        private static TimeLatLng[] a(int i3) {
            return new TimeLatLng[i3];
        }
    };
    private static final int DEFAULT_TIME = 0;
    private LatLng mPoint;
    private int mTime;

    protected TimeLatLng(Parcel parcel) {
        this.mPoint = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.mTime = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TimeLatLng)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        LatLng latLng = this.mPoint;
        if (latLng != null) {
            TimeLatLng timeLatLng = (TimeLatLng) obj;
            if (!latLng.equals(timeLatLng.mPoint) || this.mTime != timeLatLng.mTime) {
                return false;
            }
            return true;
        }
        TimeLatLng timeLatLng2 = (TimeLatLng) obj;
        if (timeLatLng2.mPoint != null || this.mTime != timeLatLng2.mTime) {
            return false;
        }
        return true;
    }

    public LatLng getPoint() {
        return this.mPoint;
    }

    public int getTime() {
        return this.mTime;
    }

    public int hashCode() {
        LatLng latLng = this.mPoint;
        if (latLng != null) {
            return latLng.hashCode() + ((int) (this.mTime * 1000000.0d));
        }
        return (int) (this.mTime * 1000000.0d);
    }

    public void setPoint(LatLng latLng) {
        this.mPoint = latLng;
    }

    public void setTime(int i3) {
        if (i3 >= 0) {
            this.mTime = i3;
        } else {
            this.mTime = 0;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.mPoint, i3);
        parcel.writeInt(this.mTime);
    }

    public TimeLatLng(LatLng latLng, int i3) {
        setPoint(latLng);
        setTime(i3);
    }

    public TimeLatLng(LatLng latLng) {
        this(latLng, 0);
    }
}
