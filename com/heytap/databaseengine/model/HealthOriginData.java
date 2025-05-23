package com.heytap.databaseengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class HealthOriginData extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<HealthOriginData> CREATOR = new Parcelable.Creator<HealthOriginData>() { // from class: com.heytap.databaseengine.model.HealthOriginData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HealthOriginData createFromParcel(Parcel parcel) {
            return new HealthOriginData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public HealthOriginData[] newArray(int i3) {
            return new HealthOriginData[i3];
        }
    };
    private String clientDataId;
    private String data;
    private int dataType;
    private String deviceType;
    private String deviceUniqueId;
    private long endTimestamp;
    private String metadata;
    private String ssoid;
    private long startTimestamp;
    private int syncStatus;
    private int version;

    public HealthOriginData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getClientDataId() {
        return this.clientDataId;
    }

    public String getData() {
        return this.data;
    }

    public int getDataType() {
        return this.dataType;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getDeviceUniqueId() {
        return this.deviceUniqueId;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public long getEndTimestamp() {
        return this.endTimestamp;
    }

    public String getMetadata() {
        return this.metadata;
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

    public int getVersion() {
        return this.version;
    }

    public void setClientDataId(String str) {
        this.clientDataId = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDataType(int i3) {
        this.dataType = i3;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setDeviceUniqueId(String str) {
        this.deviceUniqueId = str;
    }

    public void setEndTimestamp(long j3) {
        this.endTimestamp = j3;
    }

    public void setMetadata(String str) {
        this.metadata = str;
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

    public void setVersion(int i3) {
        this.version = i3;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "HealthOriginData{ssoid='" + this.ssoid + "', clientDataId='" + this.clientDataId + "', deviceUniqueId='" + this.deviceUniqueId + "', deviceCategory='" + this.deviceType + "', startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", dataType=" + this.dataType + ", data='" + this.data + "', metadata='" + this.metadata + "', version=" + this.version + ", syncStatus=" + this.syncStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeString(this.clientDataId);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeString(this.deviceType);
        parcel.writeLong(this.startTimestamp);
        parcel.writeLong(this.endTimestamp);
        parcel.writeInt(this.dataType);
        parcel.writeString(this.data);
        parcel.writeString(this.metadata);
        parcel.writeInt(this.version);
        parcel.writeInt(this.syncStatus);
    }

    protected HealthOriginData(Parcel parcel) {
        this.ssoid = parcel.readString();
        this.clientDataId = parcel.readString();
        this.deviceUniqueId = parcel.readString();
        this.deviceType = parcel.readString();
        this.startTimestamp = parcel.readLong();
        this.endTimestamp = parcel.readLong();
        this.dataType = parcel.readInt();
        this.data = parcel.readString();
        this.metadata = parcel.readString();
        this.version = parcel.readInt();
        this.syncStatus = parcel.readInt();
    }
}
