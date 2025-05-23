package com.heytap.databaseengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class HeartRate extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<HeartRate> CREATOR = new Parcelable.Creator<HeartRate>() { // from class: com.heytap.databaseengine.model.HeartRate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRate createFromParcel(Parcel parcel) {
            return new HeartRate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HeartRate[] newArray(int i3) {
            return new HeartRate[i3];
        }
    };
    private long dataCreatedTimestamp;
    private String deviceUniqueId;
    private int display;
    private int heartRateType;
    private int heartRateValue;
    private String ssoid;
    private int syncStatus;

    public HeartRate() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDataCreatedTimestamp() {
        return this.dataCreatedTimestamp;
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
        return getDataCreatedTimestamp();
    }

    public int getHeartRateType() {
        return this.heartRateType;
    }

    public int getHeartRateValue() {
        return this.heartRateValue;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getSsoid() {
        return this.ssoid;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public long getStartTimestamp() {
        return getDataCreatedTimestamp();
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public void setDataCreatedTimestamp(long j3) {
        this.dataCreatedTimestamp = j3;
    }

    public void setDeviceUniqueId(String str) {
        this.deviceUniqueId = str;
    }

    public void setDisplay(int i3) {
        this.display = i3;
    }

    public void setHeartRateType(int i3) {
        this.heartRateType = i3;
    }

    public void setHeartRateValue(int i3) {
        this.heartRateValue = i3;
    }

    public void setSsoid(String str) {
        this.ssoid = str;
    }

    public void setSyncStatus(int i3) {
        this.syncStatus = i3;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "HeartRate{ssoid='" + this.ssoid + "', deviceUniqueId='" + this.deviceUniqueId + "', dataCreatedTimestamp=" + this.dataCreatedTimestamp + ", heartRateType=" + this.heartRateType + ", heartRateValue=" + this.heartRateValue + ", display=" + this.display + ", syncStatus=" + this.syncStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeLong(this.dataCreatedTimestamp);
        parcel.writeInt(this.heartRateType);
        parcel.writeInt(this.heartRateValue);
        parcel.writeInt(this.display);
        parcel.writeInt(this.syncStatus);
    }

    public HeartRate(long j3, int i3) {
        this.dataCreatedTimestamp = j3;
        this.heartRateValue = i3;
    }

    protected HeartRate(Parcel parcel) {
        this.ssoid = parcel.readString();
        this.deviceUniqueId = parcel.readString();
        this.dataCreatedTimestamp = parcel.readLong();
        this.heartRateType = parcel.readInt();
        this.heartRateValue = parcel.readInt();
        this.display = parcel.readInt();
        this.syncStatus = parcel.readInt();
    }
}
