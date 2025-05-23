package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.SportDataDetail;
import com.heytap.databaseengine.model.SportHealthData;
import com.heytap.databaseengine.utils.DataParseUtil;

@Keep
/* loaded from: classes2.dex */
public class SportDataDetailProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<SportDataDetailProxy> CREATOR = new Parcelable.Creator<SportDataDetailProxy>() { // from class: com.heytap.databaseengine.model.proxy.SportDataDetailProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportDataDetailProxy createFromParcel(Parcel parcel) {
            return new SportDataDetailProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportDataDetailProxy[] newArray(int i3) {
            return new SportDataDetailProxy[i3];
        }
    };
    private int altitudeOffset;
    private long calories;
    private String deviceType;
    private int distance;
    private long endTimestamp;
    private int sportMode;
    private long startTimestamp;
    private int steps;
    private String timezone;

    public SportDataDetailProxy(@NonNull SportDataDetail sportDataDetail) {
        this.deviceType = sportDataDetail.getDeviceType();
        this.startTimestamp = sportDataDetail.getStartTimestamp();
        this.endTimestamp = sportDataDetail.getEndTimestamp();
        this.sportMode = DataParseUtil.convertSportMode(sportDataDetail.getSportMode());
        this.steps = sportDataDetail.getSteps();
        this.distance = sportDataDetail.getDistance();
        this.calories = sportDataDetail.getCalories();
        this.altitudeOffset = sportDataDetail.getAltitudeOffset();
        this.timezone = sportDataDetail.getTimezone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAltitudeOffset() {
        return this.altitudeOffset;
    }

    public long getCalories() {
        return this.calories;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public int getDistance() {
        return this.distance;
    }

    public long getEndTime() {
        return this.endTimestamp;
    }

    public int getSportMode() {
        return this.sportMode;
    }

    public long getStartTime() {
        return this.startTimestamp;
    }

    public int getSteps() {
        return this.steps;
    }

    public String getTimezone() {
        return this.timezone;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "SportDataDetailProxy:\ndeviceCategory='" + getDeviceType() + "\nstartTime=" + getStartTime() + "\nendTime=" + getEndTime() + "\nsportMode=" + getSportMode() + "\nsteps=" + getSteps() + "\ndistance=" + getDistance() + "\ncalories=" + getCalories() + "\naltitude=" + getAltitudeOffset() + "\ntimezone='" + getTimezone() + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.deviceType);
        parcel.writeLong(this.startTimestamp);
        parcel.writeLong(this.endTimestamp);
        parcel.writeInt(this.sportMode);
        parcel.writeInt(this.steps);
        parcel.writeInt(this.distance);
        parcel.writeLong(this.calories);
        parcel.writeInt(this.altitudeOffset);
        parcel.writeString(this.timezone);
    }

    protected SportDataDetailProxy(Parcel parcel) {
        this.deviceType = parcel.readString();
        this.startTimestamp = parcel.readLong();
        this.endTimestamp = parcel.readLong();
        this.sportMode = parcel.readInt();
        this.steps = parcel.readInt();
        this.distance = parcel.readInt();
        this.calories = parcel.readLong();
        this.altitudeOffset = parcel.readInt();
        this.timezone = parcel.readString();
    }
}
