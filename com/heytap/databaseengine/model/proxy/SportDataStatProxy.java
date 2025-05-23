package com.heytap.databaseengine.model.proxy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.heytap.databaseengine.model.SportDataStat;
import com.heytap.databaseengine.model.SportHealthData;

@Keep
/* loaded from: classes2.dex */
public class SportDataStatProxy extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<SportDataStatProxy> CREATOR = new Parcelable.Creator<SportDataStatProxy>() { // from class: com.heytap.databaseengine.model.proxy.SportDataStatProxy.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportDataStatProxy createFromParcel(Parcel parcel) {
            return new SportDataStatProxy(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SportDataStatProxy[] newArray(int i3) {
            return new SportDataStatProxy[i3];
        }
    };
    private int date;
    private String timezone;
    private int totalAltitudeOffset;
    private long totalCalories;
    private int totalDistance;
    private long totalDuration;
    private int totalSteps;
    private long updateTimestamp;

    public SportDataStatProxy(@NonNull SportDataStat sportDataStat) {
        this.date = sportDataStat.getDate();
        this.totalSteps = sportDataStat.getTotalSteps();
        this.totalDistance = sportDataStat.getTotalDistance();
        this.totalCalories = sportDataStat.getTotalCalories();
        this.totalAltitudeOffset = sportDataStat.getTotalAltitudeOffset();
        this.totalDuration = sportDataStat.getTotalDuration();
        this.timezone = sportDataStat.getTimezone();
        this.updateTimestamp = sportDataStat.getUpdateTimestamp();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDate() {
        return this.date;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public int getTotalAltitudeOffset() {
        return this.totalAltitudeOffset;
    }

    public long getTotalCalories() {
        return this.totalCalories;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    public long getTotalDuration() {
        return this.totalDuration;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public long getUpdateTime() {
        return this.updateTimestamp;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    @NonNull
    public String toString() {
        return "SportDataStatProxy:\nDate=" + getDate() + "\ntotalSteps=" + getTotalSteps() + "\ntotalDistance=" + getTotalDistance() + "\ntotalCalories=" + getTotalCalories() + "\ntotalAltitude=" + getTotalAltitudeOffset() + "\ntotalDuration=" + getTotalDuration() + "\ntimezone=" + getTimezone() + "\nupdateTime=" + getUpdateTime() + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.date);
        parcel.writeInt(this.totalSteps);
        parcel.writeInt(this.totalDistance);
        parcel.writeLong(this.totalCalories);
        parcel.writeInt(this.totalAltitudeOffset);
        parcel.writeLong(this.totalDuration);
        parcel.writeString(this.timezone);
        parcel.writeLong(this.updateTimestamp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SportDataStatProxy(Parcel parcel) {
        this.date = parcel.readInt();
        this.totalSteps = parcel.readInt();
        this.totalDistance = parcel.readInt();
        this.totalCalories = parcel.readLong();
        this.totalAltitudeOffset = parcel.readInt();
        this.totalDuration = parcel.readLong();
        this.timezone = parcel.readString();
        this.updateTimestamp = parcel.readLong();
    }
}
