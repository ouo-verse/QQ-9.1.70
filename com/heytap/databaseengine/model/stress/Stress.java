package com.heytap.databaseengine.model.stress;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.heytap.databaseengine.model.SportHealthData;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class Stress extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<Stress> CREATOR = new Parcelable.Creator<Stress>() { // from class: com.heytap.databaseengine.model.stress.Stress.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Stress createFromParcel(Parcel parcel) {
            return new Stress(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Stress[] newArray(int i3) {
            return new Stress[i3];
        }
    };
    private long dataCreatedTimestamp;
    private String deviceName;
    private String deviceUniqueId;
    private int display;
    private Integer rmssd;
    private Integer sdnn;
    private String ssoid;
    private int stressType;
    private int stressValue;
    private int syncStatus;

    public Stress() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDataCreatedTimestamp() {
        return this.dataCreatedTimestamp;
    }

    public String getDeviceName() {
        return this.deviceName;
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

    public Integer getRmssd() {
        return this.rmssd;
    }

    public Integer getSdnn() {
        return this.sdnn;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getSsoid() {
        return this.ssoid;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public long getStartTimestamp() {
        return getDataCreatedTimestamp();
    }

    public int getStressType() {
        return this.stressType;
    }

    public int getStressValue() {
        return this.stressValue;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public void setDataCreatedTimestamp(long j3) {
        this.dataCreatedTimestamp = j3;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceUniqueId(String str) {
        this.deviceUniqueId = str;
    }

    public void setDisplay(int i3) {
        this.display = i3;
    }

    public void setRmssd(Integer num) {
        this.rmssd = num;
    }

    public void setSdnn(Integer num) {
        this.sdnn = num;
    }

    public void setSsoid(String str) {
        this.ssoid = str;
    }

    public void setStressType(int i3) {
        this.stressType = i3;
    }

    public void setStressValue(int i3) {
        this.stressValue = i3;
    }

    public void setSyncStatus(int i3) {
        this.syncStatus = i3;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "Stress{ssoid='" + this.ssoid + "', deviceUniqueId='" + this.deviceUniqueId + "', deviceName='" + this.deviceName + "', dataCreatedTimestamp=" + this.dataCreatedTimestamp + ", stressType=" + this.stressType + ", stressValue=" + this.stressValue + ", display=" + this.display + ", syncStatus=" + this.syncStatus + ", sdnn=" + this.sdnn + ", rmssd=" + this.rmssd + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeString(this.deviceName);
        parcel.writeLong(this.dataCreatedTimestamp);
        parcel.writeInt(this.stressType);
        parcel.writeInt(this.stressValue);
        parcel.writeInt(this.display);
        parcel.writeInt(this.syncStatus);
        parcel.writeValue(this.sdnn);
        parcel.writeValue(this.rmssd);
    }

    protected Stress(Parcel parcel) {
        this.ssoid = parcel.readString();
        this.deviceUniqueId = parcel.readString();
        this.deviceName = parcel.readString();
        this.dataCreatedTimestamp = parcel.readLong();
        this.stressType = parcel.readInt();
        this.stressValue = parcel.readInt();
        this.display = parcel.readInt();
        this.syncStatus = parcel.readInt();
        this.sdnn = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.rmssd = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
