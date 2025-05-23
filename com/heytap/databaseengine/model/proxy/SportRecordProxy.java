package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.SportHealthData;
import com.heytap.databaseengine.model.SportRecord;
import com.heytap.databaseengine.utils.DataParseUtil;

@Keep
/* loaded from: classes2.dex */
public class SportRecordProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<SportRecordProxy> CREATOR = new Parcelable.Creator<SportRecordProxy>() { // from class: com.heytap.databaseengine.model.proxy.SportRecordProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportRecordProxy createFromParcel(Parcel parcel) {
            return new SportRecordProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportRecordProxy[] newArray(int i3) {
            return new SportRecordProxy[i3];
        }
    };
    private String deviceType;
    private int distance;
    private long duration;
    private long endTime;
    private String metaData;
    private long startTime;
    private String timezone;
    private int trackType;

    public SportRecordProxy(@NonNull SportRecord sportRecord) {
        this.trackType = DataParseUtil.convertSportMode(sportRecord.getTrackType());
        this.startTime = sportRecord.getStartTime();
        this.endTime = sportRecord.getEndTime();
        this.duration = sportRecord.getDuration();
        this.distance = sportRecord.getDistance();
        this.metaData = sportRecord.getMetaData();
        this.timezone = sportRecord.getTimezone();
        this.deviceType = sportRecord.getDeviceType();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public int getDistance() {
        return this.distance;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getMetaData() {
        return this.metaData;
    }

    public int getSportMode() {
        return this.trackType;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getTimezone() {
        return this.timezone;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "SportRecordProxy:\nstartTime=" + getStartTime() + "\nendTime=" + getEndTime() + "\nsportMode=" + getSportMode() + "\nduration=" + getDuration() + "\ndistance=" + getDistance() + "\nmetaData=" + getMetaData() + "\ntimezone=" + getTimezone() + "\ndeviceType=" + getDeviceType() + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.trackType);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.distance);
        parcel.writeString(this.metaData);
        parcel.writeString(this.timezone);
        parcel.writeString(this.deviceType);
    }

    protected SportRecordProxy(Parcel parcel) {
        this.trackType = parcel.readInt();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.duration = parcel.readLong();
        this.distance = parcel.readInt();
        this.metaData = parcel.readString();
        this.timezone = parcel.readString();
        this.deviceType = parcel.readString();
    }
}
