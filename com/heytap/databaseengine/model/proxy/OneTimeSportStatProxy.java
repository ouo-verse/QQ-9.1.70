package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.OneTimeSportStat;
import com.heytap.databaseengine.model.SportHealthData;
import com.heytap.databaseengine.utils.DataParseUtil;

@Keep
/* loaded from: classes2.dex */
public class OneTimeSportStatProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<OneTimeSportStatProxy> CREATOR = new Parcelable.Creator<OneTimeSportStatProxy>() { // from class: com.heytap.databaseengine.model.proxy.OneTimeSportStatProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OneTimeSportStatProxy createFromParcel(Parcel parcel) {
            return new OneTimeSportStatProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OneTimeSportStatProxy[] newArray(int i3) {
            return new OneTimeSportStatProxy[i3];
        }
    };
    private int date;
    private long endTimestamp;
    private int sportMode;
    private long startTimestamp;
    private String timezone;
    private long totalAltitudeOffset;
    private long totalCalories;
    private long totalDistance;
    private long totalDuration;
    private long totalSteps;

    public OneTimeSportStatProxy(@NonNull OneTimeSportStat oneTimeSportStat) {
        this.startTimestamp = oneTimeSportStat.getStartTimestamp();
        this.endTimestamp = oneTimeSportStat.getEndTimestamp();
        this.date = oneTimeSportStat.getDate();
        this.sportMode = DataParseUtil.convertSportMode(oneTimeSportStat.getSportMode());
        this.totalSteps = oneTimeSportStat.getTotalSteps();
        this.totalDistance = oneTimeSportStat.getTotalDistance();
        this.totalCalories = oneTimeSportStat.getTotalCalories();
        this.totalDuration = oneTimeSportStat.getTotalDuration();
        this.totalAltitudeOffset = oneTimeSportStat.getTotalAltitudeOffset();
        this.timezone = oneTimeSportStat.getTimezone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDate() {
        return this.date;
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

    public String getTimezone() {
        return this.timezone;
    }

    public long getTotalAltitudeOffset() {
        return this.totalAltitudeOffset;
    }

    public long getTotalCalories() {
        return this.totalCalories;
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

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "OneTimeSportStatProxy:\nstartTime=" + getStartTime() + "\nendTime=" + getEndTime() + "\ndate=" + getDate() + "\nsportMode=" + getSportMode() + "\ntotalSteps=" + getTotalSteps() + "\ntotalDistance=" + getTotalDistance() + "\ntotalCalories=" + getTotalCalories() + "\ntotalDuration=" + getTotalDuration() + "\ntotalAltitudeOffset=" + getTotalAltitudeOffset() + "\ntimezone=" + getTimezone() + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.startTimestamp);
        parcel.writeLong(this.endTimestamp);
        parcel.writeInt(this.date);
        parcel.writeInt(this.sportMode);
        parcel.writeLong(this.totalSteps);
        parcel.writeLong(this.totalDistance);
        parcel.writeLong(this.totalCalories);
        parcel.writeLong(this.totalDuration);
        parcel.writeLong(this.totalAltitudeOffset);
        parcel.writeString(this.timezone);
    }

    protected OneTimeSportStatProxy(Parcel parcel) {
        this.startTimestamp = parcel.readLong();
        this.endTimestamp = parcel.readLong();
        this.date = parcel.readInt();
        this.sportMode = parcel.readInt();
        this.totalSteps = parcel.readLong();
        this.totalDistance = parcel.readLong();
        this.totalCalories = parcel.readLong();
        this.totalDuration = parcel.readLong();
        this.totalAltitudeOffset = parcel.readLong();
        this.timezone = parcel.readString();
    }
}
