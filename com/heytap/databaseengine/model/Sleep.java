package com.heytap.databaseengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class Sleep extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<Sleep> CREATOR = new Parcelable.Creator<Sleep>() { // from class: com.heytap.databaseengine.model.Sleep.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Sleep createFromParcel(Parcel parcel) {
            return new Sleep(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Sleep[] newArray(int i3) {
            return new Sleep[i3];
        }
    };
    private int algOriginState;
    private int dataVersion;
    private Integer deviceType;
    private String deviceUniqueId;
    private int display;
    private long endTimestamp;
    private String metadata;
    private int sleepState;
    private int sleepType;
    private String ssoid;
    private long startTimestamp;
    private int syncStatus;

    public Sleep() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAlgOriginState() {
        return this.algOriginState;
    }

    public int getDataVersion() {
        return this.dataVersion;
    }

    public Integer getDeviceType() {
        return this.deviceType;
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

    public String getMetadata() {
        return this.metadata;
    }

    public int getSleepState() {
        return this.sleepState;
    }

    public int getSleepType() {
        return this.sleepType;
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

    public void setAlgOriginState(int i3) {
        this.algOriginState = i3;
    }

    public void setDataVersion(int i3) {
        this.dataVersion = i3;
    }

    public void setDeviceType(Integer num) {
        this.deviceType = num;
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

    public void setMetadata(String str) {
        this.metadata = str;
    }

    public void setSleepState(int i3) {
        this.sleepState = i3;
    }

    public void setSleepType(int i3) {
        this.sleepType = i3;
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

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "Sleep{ssoid='" + this.ssoid + "', deviceUniqueId='" + this.deviceUniqueId + "', startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", sleepType=" + this.sleepType + ", sleepState=" + this.sleepState + ", algOriginState=" + this.algOriginState + ", metadata='" + this.metadata + "', dataVersion=" + this.dataVersion + ", display=" + this.display + ", syncStatus=" + this.syncStatus + ", deviceType=" + this.deviceType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeLong(this.startTimestamp);
        parcel.writeLong(this.endTimestamp);
        parcel.writeInt(this.sleepType);
        parcel.writeInt(this.sleepState);
        parcel.writeInt(this.algOriginState);
        parcel.writeString(this.metadata);
        parcel.writeInt(this.dataVersion);
        parcel.writeInt(this.display);
        parcel.writeInt(this.syncStatus);
        parcel.writeValue(this.deviceType);
    }

    protected Sleep(Parcel parcel) {
        this.ssoid = parcel.readString();
        this.deviceUniqueId = parcel.readString();
        this.startTimestamp = parcel.readLong();
        this.endTimestamp = parcel.readLong();
        this.sleepType = parcel.readInt();
        this.sleepState = parcel.readInt();
        this.algOriginState = parcel.readInt();
        this.metadata = parcel.readString();
        this.dataVersion = parcel.readInt();
        this.display = parcel.readInt();
        this.syncStatus = parcel.readInt();
        this.deviceType = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
