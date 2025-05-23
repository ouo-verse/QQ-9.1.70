package com.heytap.databaseengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class SportDataDetail extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<SportDataDetail> CREATOR = new Parcelable.Creator<SportDataDetail>() { // from class: com.heytap.databaseengine.model.SportDataDetail.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportDataDetail createFromParcel(Parcel parcel) {
            return new SportDataDetail(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportDataDetail[] newArray(int i3) {
            return new SportDataDetail[i3];
        }
    };
    private int altitudeOffset;
    private long calories;
    private String deviceType;
    private String deviceUniqueId;
    private int display;
    private int distance;
    private long endTimestamp;
    private int moveAbout;
    private int sedentaryState;
    private int sportMode;
    private String ssoid;
    private long startTimestamp;
    private int steps;
    private int syncStatus;
    private String timezone;
    private int workout;

    public SportDataDetail() {
        this.deviceType = "Phone";
        this.display = 1;
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

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getDeviceUniqueId() {
        return this.deviceUniqueId;
    }

    public int getDisplay() {
        return this.display;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public long getEndTimestamp() {
        return this.endTimestamp;
    }

    public int getMoveAbout() {
        return this.moveAbout;
    }

    public int getSedentaryState() {
        return this.sedentaryState;
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

    public int getSteps() {
        return this.steps;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public int getWorkout() {
        return this.workout;
    }

    public void setAltitudeOffset(int i3) {
        this.altitudeOffset = i3;
    }

    public void setCalories(long j3) {
        this.calories = j3;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setDeviceUniqueId(String str) {
        this.deviceUniqueId = str;
    }

    public void setDisplay(int i3) {
        this.display = i3;
    }

    public void setDistance(int i3) {
        this.distance = i3;
    }

    public void setEndTimestamp(long j3) {
        this.endTimestamp = j3;
    }

    public void setMoveAbout(int i3) {
        this.moveAbout = i3;
    }

    public void setSedentaryState(int i3) {
        this.sedentaryState = i3;
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

    public void setSteps(int i3) {
        this.steps = i3;
    }

    public void setSyncStatus(int i3) {
        this.syncStatus = i3;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public void setWorkout(int i3) {
        this.workout = i3;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "SportDataDetail{ssoid='" + this.ssoid + "', deviceUniqueId='" + this.deviceUniqueId + "', deviceCategory='" + this.deviceType + "', startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", sportMode=" + this.sportMode + ", steps=" + this.steps + ", distance=" + this.distance + ", calories=" + this.calories + ", altitude=" + this.altitudeOffset + ", workout=" + this.workout + ", sedentaryState=" + this.sedentaryState + ", moveAbout=" + this.moveAbout + ", syncStatus=" + this.syncStatus + ", display=" + this.display + ", timezone='" + this.timezone + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeString(this.deviceType);
        parcel.writeLong(this.startTimestamp);
        parcel.writeLong(this.endTimestamp);
        parcel.writeInt(this.sportMode);
        parcel.writeInt(this.steps);
        parcel.writeInt(this.distance);
        parcel.writeLong(this.calories);
        parcel.writeInt(this.altitudeOffset);
        parcel.writeInt(this.workout);
        parcel.writeInt(this.sedentaryState);
        parcel.writeInt(this.moveAbout);
        parcel.writeInt(this.syncStatus);
        parcel.writeString(this.timezone);
        parcel.writeInt(this.display);
    }

    protected SportDataDetail(Parcel parcel) {
        this.deviceType = "Phone";
        this.display = 1;
        this.ssoid = parcel.readString();
        this.deviceUniqueId = parcel.readString();
        this.deviceType = parcel.readString();
        this.startTimestamp = parcel.readLong();
        this.endTimestamp = parcel.readLong();
        this.sportMode = parcel.readInt();
        this.steps = parcel.readInt();
        this.distance = parcel.readInt();
        this.calories = parcel.readLong();
        this.altitudeOffset = parcel.readInt();
        this.workout = parcel.readInt();
        this.sedentaryState = parcel.readInt();
        this.moveAbout = parcel.readInt();
        this.syncStatus = parcel.readInt();
        this.timezone = parcel.readString();
        this.display = parcel.readInt();
    }
}
