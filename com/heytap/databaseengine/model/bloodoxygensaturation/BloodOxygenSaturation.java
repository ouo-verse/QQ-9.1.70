package com.heytap.databaseengine.model.bloodoxygensaturation;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.heytap.databaseengine.model.SportHealthData;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class BloodOxygenSaturation extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<BloodOxygenSaturation> CREATOR = new Parcelable.Creator<BloodOxygenSaturation>() { // from class: com.heytap.databaseengine.model.bloodoxygensaturation.BloodOxygenSaturation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BloodOxygenSaturation createFromParcel(Parcel parcel) {
            return new BloodOxygenSaturation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BloodOxygenSaturation[] newArray(int i3) {
            return new BloodOxygenSaturation[i3];
        }
    };
    private int bloodOxygenSaturationType;
    private int bloodOxygenSaturationValue;
    private long dataCreatedTimestamp;
    private String deviceUniqueId;
    private int display;
    private String ssoid;
    private int syncStatus;

    public BloodOxygenSaturation() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBloodOxygenSaturationType() {
        return this.bloodOxygenSaturationType;
    }

    public int getBloodOxygenSaturationValue() {
        return this.bloodOxygenSaturationValue;
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

    public void setBloodOxygenSaturationType(int i3) {
        this.bloodOxygenSaturationType = i3;
    }

    public void setBloodOxygenSaturationValue(int i3) {
        this.bloodOxygenSaturationValue = i3;
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

    public void setSsoid(String str) {
        this.ssoid = str;
    }

    public void setSyncStatus(int i3) {
        this.syncStatus = i3;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "BloodOxygenSaturation{ssoid='" + this.ssoid + "', deviceUniqueId='" + this.deviceUniqueId + "', dataCreatedTimestamp=" + this.dataCreatedTimestamp + ", bloodOxygenSaturationType=" + this.bloodOxygenSaturationType + ", bloodOxygenSaturationValue=" + this.bloodOxygenSaturationValue + ", display=" + this.display + ", syncStatus=" + this.syncStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeLong(this.dataCreatedTimestamp);
        parcel.writeInt(this.bloodOxygenSaturationType);
        parcel.writeInt(this.bloodOxygenSaturationValue);
        parcel.writeInt(this.display);
        parcel.writeInt(this.syncStatus);
    }

    protected BloodOxygenSaturation(Parcel parcel) {
        this.ssoid = parcel.readString();
        this.deviceUniqueId = parcel.readString();
        this.dataCreatedTimestamp = parcel.readLong();
        this.bloodOxygenSaturationType = parcel.readInt();
        this.bloodOxygenSaturationValue = parcel.readInt();
        this.display = parcel.readInt();
        this.syncStatus = parcel.readInt();
    }
}
