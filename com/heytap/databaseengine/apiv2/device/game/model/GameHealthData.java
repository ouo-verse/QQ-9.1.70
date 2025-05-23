package com.heytap.databaseengine.apiv2.device.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.heytap.databaseengine.model.HeartRate;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class GameHealthData implements Parcelable {
    public static final Parcelable.Creator<GameHealthData> CREATOR = new Parcelable.Creator<GameHealthData>() { // from class: com.heytap.databaseengine.apiv2.device.game.model.GameHealthData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameHealthData createFromParcel(Parcel parcel) {
            return new GameHealthData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GameHealthData[] newArray(int i3) {
            return new GameHealthData[i3];
        }
    };
    private int calorie;
    private long endTime;
    private List<HeartRate> heartRateList;
    private String packageName;
    private long startTime;
    private int stressAvg;

    public GameHealthData() {
        this.heartRateList = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCalorie() {
        return this.calorie;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public List<HeartRate> getHeartRateList() {
        return this.heartRateList;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStressAvg() {
        return this.stressAvg;
    }

    public void setCalorie(int i3) {
        this.calorie = i3;
    }

    public void setEndTime(long j3) {
        this.endTime = j3;
    }

    public void setHeartRateList(List<HeartRate> list) {
        this.heartRateList = list;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setStartTime(long j3) {
        this.startTime = j3;
    }

    public void setStressAvg(int i3) {
        this.stressAvg = i3;
    }

    public String toString() {
        return "GameHealthData{packageName='" + this.packageName + "', startTime=" + this.startTime + ", endTime=" + this.endTime + ", calorie=" + this.calorie + ", heartRateList=" + this.heartRateList + ", stressAvg=" + this.stressAvg + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.packageName);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeInt(this.calorie);
        parcel.writeTypedList(this.heartRateList);
        parcel.writeInt(this.stressAvg);
    }

    protected GameHealthData(Parcel parcel) {
        this.heartRateList = new ArrayList();
        this.packageName = parcel.readString();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.calorie = parcel.readInt();
        this.heartRateList = parcel.createTypedArrayList(HeartRate.CREATOR);
        this.stressAvg = parcel.readInt();
    }
}
