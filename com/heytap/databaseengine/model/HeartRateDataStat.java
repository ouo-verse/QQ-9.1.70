package com.heytap.databaseengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class HeartRateDataStat extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<HeartRateDataStat> CREATOR = new Parcelable.Creator<HeartRateDataStat>() { // from class: com.heytap.databaseengine.model.HeartRateDataStat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateDataStat createFromParcel(Parcel parcel) {
            return new HeartRateDataStat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRateDataStat[] newArray(int i3) {
            return new HeartRateDataStat[i3];
        }
    };
    public static final String LOW_HR_WARN_MAX = "lowHRWarnMax";
    public static final String LOW_HR_WARN_MIN = "lowHRWarnMin";
    public static final String LOW_HR_WARN_TIME_END = "lowHRWarnTimeEnd";
    public static final String LOW_HR_WARN_TIME_START = "lowHRWarnTimeStart";
    public static final String QUIET_HR_HIGH_MAX = "quietHRHighMax";
    public static final String QUIET_HR_HIGH_MIN = "quietHRHighMin";
    public static final String QUIET_HR_HIGH_TIME_END = "quietHRHighTimeEnd";
    public static final String QUIET_HR_HIGH_TIME_START = "quietHRHighTimeStart";
    public static final String QUIET_HR_MAX = "quietHRMax";
    public static final String QUIET_HR_MIN = "quietHRMin";
    public static final String SLEEP_BASE_HR = "sleepBaseHR";
    public static final String WALK_AVG_HR = "walkAvgHR";
    private int averageHeartRate;
    private int date;
    private String deviceUniqueId;
    private int maxHeartRate;
    private String metadata;
    private int minHeartRate;
    private int restHeartRate;
    private int sleepBaseHeartRate;
    private String ssoid;
    private int syncStatus;
    private String timezone;
    private int walkAvgHeartRate;

    public HeartRateDataStat() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAverageHeartRate() {
        return this.averageHeartRate;
    }

    public int getDate() {
        return this.date;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getDeviceUniqueId() {
        return this.deviceUniqueId;
    }

    public int getMaxHeartRate() {
        return this.maxHeartRate;
    }

    public String getMetadata() {
        return this.metadata;
    }

    public int getMinHeartRate() {
        return this.minHeartRate;
    }

    public int getRestHeartRate() {
        return this.restHeartRate;
    }

    public int getSleepBaseHeartRate() {
        return this.sleepBaseHeartRate;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getSsoid() {
        return this.ssoid;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public int getWalkAvgHeartRate() {
        return this.walkAvgHeartRate;
    }

    public void setAverageHeartRate(int i3) {
        this.averageHeartRate = i3;
    }

    public void setDate(int i3) {
        this.date = i3;
    }

    public void setDeviceUniqueId(String str) {
        this.deviceUniqueId = str;
    }

    public void setMaxHeartRate(int i3) {
        this.maxHeartRate = i3;
    }

    public void setMetadata(String str) {
        this.metadata = str;
    }

    public void setMinHeartRate(int i3) {
        this.minHeartRate = i3;
    }

    public void setRestHeartRate(int i3) {
        this.restHeartRate = i3;
    }

    public void setSleepBaseHeartRate(int i3) {
        this.sleepBaseHeartRate = i3;
    }

    public void setSsoid(String str) {
        this.ssoid = str;
    }

    public void setSyncStatus(int i3) {
        this.syncStatus = i3;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public void setWalkAvgHeartRate(int i3) {
        this.walkAvgHeartRate = i3;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "HeartRateDataStat{ssoid='" + this.ssoid + "', deviceUniqueId='" + this.deviceUniqueId + "', date=" + this.date + ", timezone='" + this.timezone + "', maxHR=" + this.maxHeartRate + ", minHR=" + this.minHeartRate + ", averageHR=" + this.averageHeartRate + ", restHR=" + this.restHeartRate + ", walkAvgHR=" + this.walkAvgHeartRate + ", sleepBaseHR=" + this.sleepBaseHeartRate + ", metadata='" + this.metadata + "', syncStatus=" + this.syncStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeInt(this.date);
        parcel.writeString(this.timezone);
        parcel.writeInt(this.maxHeartRate);
        parcel.writeInt(this.minHeartRate);
        parcel.writeInt(this.averageHeartRate);
        parcel.writeInt(this.restHeartRate);
        parcel.writeInt(this.walkAvgHeartRate);
        parcel.writeInt(this.sleepBaseHeartRate);
        parcel.writeString(this.metadata);
        parcel.writeInt(this.syncStatus);
    }

    protected HeartRateDataStat(Parcel parcel) {
        this.ssoid = parcel.readString();
        this.deviceUniqueId = parcel.readString();
        this.date = parcel.readInt();
        this.timezone = parcel.readString();
        this.maxHeartRate = parcel.readInt();
        this.minHeartRate = parcel.readInt();
        this.averageHeartRate = parcel.readInt();
        this.restHeartRate = parcel.readInt();
        this.walkAvgHeartRate = parcel.readInt();
        this.sleepBaseHeartRate = parcel.readInt();
        this.metadata = parcel.readString();
        this.syncStatus = parcel.readInt();
    }
}
