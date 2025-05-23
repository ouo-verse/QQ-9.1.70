package com.heytap.databaseengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class OneTimeSportStat extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<OneTimeSportStat> CREATOR = new Parcelable.Creator<OneTimeSportStat>() { // from class: com.heytap.databaseengine.model.OneTimeSportStat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OneTimeSportStat createFromParcel(Parcel parcel) {
            return new OneTimeSportStat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OneTimeSportStat[] newArray(int i3) {
            return new OneTimeSportStat[i3];
        }
    };
    private short britishFastestPace;
    private int date;
    private String deviceUniqueId;
    private int display;
    private long endTimestamp;
    private short fastestPace;
    private int longestDistance;
    private long maxDuration;
    private int oxMax;
    private int sportMode;
    private String ssoid;
    private long startTimestamp;
    private int syncStatus;
    private String timezone;
    private int totalAbnormalCounts;
    private long totalAltitudeOffset;
    private long totalCalories;
    private int totalCounts;
    private long totalDistance;
    private long totalDuration;
    private long totalSteps;

    public OneTimeSportStat() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public short getBritishFastestPace() {
        return this.britishFastestPace;
    }

    public int getDate() {
        return this.date;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getDeviceUniqueId() {
        return this.deviceUniqueId;
    }

    public int getDisplay() {
        return this.display;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public long getEndTimestamp() {
        return this.endTimestamp;
    }

    public short getFastestPace() {
        return this.fastestPace;
    }

    public int getLongestDistance() {
        return this.longestDistance;
    }

    public long getMaxDuration() {
        return this.maxDuration;
    }

    public int getOxMax() {
        return this.oxMax;
    }

    public int getSportMode() {
        return this.sportMode;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getSsoid() {
        return this.ssoid;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public long getStartTimestamp() {
        return this.startTimestamp;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public int getTotalAbnormalCounts() {
        return this.totalAbnormalCounts;
    }

    public long getTotalAltitudeOffset() {
        return this.totalAltitudeOffset;
    }

    public long getTotalCalories() {
        return this.totalCalories;
    }

    public int getTotalCounts() {
        return this.totalCounts;
    }

    public long getTotalDistance() {
        return this.totalDistance;
    }

    public long getTotalDuration() {
        return this.totalDuration;
    }

    public long getTotalSteps() {
        return this.totalSteps;
    }

    public void setBritishFastestPace(short s16) {
        this.britishFastestPace = s16;
    }

    public void setDate(int i3) {
        this.date = i3;
    }

    public void setDeviceUniqueId(String str) {
        this.deviceUniqueId = str;
    }

    public void setDisplay(int i3) {
        this.display = i3;
    }

    public void setEndTimestamp(long j3) {
        this.endTimestamp = j3;
    }

    public void setFastestPace(short s16) {
        this.fastestPace = s16;
    }

    public void setLongestDistance(int i3) {
        this.longestDistance = i3;
    }

    public void setMaxDuration(long j3) {
        this.maxDuration = j3;
    }

    public void setOxMax(int i3) {
        this.oxMax = i3;
    }

    public void setSportMode(int i3) {
        this.sportMode = i3;
    }

    public void setSsoid(String str) {
        this.ssoid = str;
    }

    public void setStartTimestamp(long j3) {
        this.startTimestamp = j3;
    }

    public void setSyncStatus(int i3) {
        this.syncStatus = i3;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public void setTotalAbnormalCounts(int i3) {
        this.totalAbnormalCounts = i3;
    }

    public void setTotalAltitudeOffset(long j3) {
        this.totalAltitudeOffset = j3;
    }

    public void setTotalCalories(long j3) {
        this.totalCalories = j3;
    }

    public void setTotalCounts(int i3) {
        this.totalCounts = i3;
    }

    public void setTotalDistance(long j3) {
        this.totalDistance = j3;
    }

    public void setTotalDuration(long j3) {
        this.totalDuration = j3;
    }

    public void setTotalSteps(long j3) {
        this.totalSteps = j3;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "OneTimeSportStat{ssoid=" + this.ssoid + ", deviceUniqueId='" + this.deviceUniqueId + "', startTimeStamp=" + this.startTimestamp + ", endTimeStamp=" + this.endTimestamp + ", date=" + this.date + ", sportMode=" + this.sportMode + ", totalSteps=" + this.totalSteps + ", totalDistance=" + this.totalDistance + ", totalCalories=" + this.totalCalories + ", totalDuration=" + this.totalDuration + ", maxDuration=" + this.maxDuration + ", totalAltitudeOffset=" + this.totalAltitudeOffset + ", totalCounts=" + this.totalCounts + ", totalAbnormalCounts=" + this.totalAbnormalCounts + ", fastestPace=" + ((int) this.fastestPace) + ", longestDistance=" + this.longestDistance + ", oxMax=" + this.oxMax + ", britishFastestPace=" + ((int) this.britishFastestPace) + ", display=" + this.display + ", syncStatus=" + this.syncStatus + ", timezone='" + this.timezone + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeLong(this.startTimestamp);
        parcel.writeLong(this.endTimestamp);
        parcel.writeInt(this.date);
        parcel.writeInt(this.sportMode);
        parcel.writeLong(this.totalSteps);
        parcel.writeLong(this.totalDistance);
        parcel.writeLong(this.totalCalories);
        parcel.writeLong(this.totalDuration);
        parcel.writeLong(this.totalAltitudeOffset);
        parcel.writeInt(this.totalCounts);
        parcel.writeInt(this.totalAbnormalCounts);
        parcel.writeInt(this.fastestPace);
        parcel.writeInt(this.longestDistance);
        parcel.writeInt(this.oxMax);
        parcel.writeInt(this.britishFastestPace);
        parcel.writeInt(this.display);
        parcel.writeInt(this.syncStatus);
        parcel.writeString(this.timezone);
        parcel.writeLong(this.maxDuration);
    }

    protected OneTimeSportStat(Parcel parcel) {
        this.ssoid = parcel.readString();
        this.deviceUniqueId = parcel.readString();
        this.startTimestamp = parcel.readLong();
        this.endTimestamp = parcel.readLong();
        this.date = parcel.readInt();
        this.sportMode = parcel.readInt();
        this.totalSteps = parcel.readLong();
        this.totalDistance = parcel.readLong();
        this.totalCalories = parcel.readLong();
        this.totalDuration = parcel.readLong();
        this.totalAltitudeOffset = parcel.readLong();
        this.totalCounts = parcel.readInt();
        this.totalAbnormalCounts = parcel.readInt();
        this.fastestPace = (short) parcel.readInt();
        this.longestDistance = parcel.readInt();
        this.oxMax = parcel.readInt();
        this.britishFastestPace = (short) parcel.readInt();
        this.display = parcel.readInt();
        this.syncStatus = parcel.readInt();
        this.timezone = parcel.readString();
        this.maxDuration = parcel.readLong();
    }
}
