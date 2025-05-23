package com.heytap.databaseengine.option;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataReadOption implements Parcelable {
    public static final int ASYNC_DOWNLOAD_DATA = 2;
    public static final int COMMON_USE_SYNC_DOWNLOAD = 0;
    public static final Parcelable.Creator<DataReadOption> CREATOR = new Parcelable.Creator<DataReadOption>() { // from class: com.heytap.databaseengine.option.DataReadOption.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataReadOption createFromParcel(Parcel parcel) {
            return new DataReadOption(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataReadOption[] newArray(int i3) {
            return new DataReadOption[i3];
        }
    };
    public static final int PARSE = 1;
    private int aggregateType;
    private int anchor;
    private int count;
    private String dataId;
    private String dataReadType;
    private int dataTable;
    private String deviceUniqueId;
    private long endTime;
    private int groupUnitSize;
    private int groupUnitType;
    private int isParse;
    private int readHealthDataType;
    private int readSportMode;
    private int sortOrder;
    private String ssoid;
    private long startTime;
    private long weightMeasurementMinTimestamp;
    private String weightUserTagId;

    public DataReadOption() {
        this.weightMeasurementMinTimestamp = Long.MAX_VALUE;
        this.isParse = 0;
    }

    public DataReadOptionV2 copyDataToReadOptionV2() {
        DataReadOptionV2 dataReadOptionV2 = new DataReadOptionV2();
        dataReadOptionV2.setSsoid(this.ssoid);
        dataReadOptionV2.setStartTime(this.startTime);
        dataReadOptionV2.setEndTime(this.endTime);
        dataReadOptionV2.setDeviceUniqueId(this.deviceUniqueId);
        dataReadOptionV2.setDataTable(this.dataTable);
        dataReadOptionV2.setAnchor(this.anchor);
        dataReadOptionV2.setCount(this.count);
        dataReadOptionV2.setSortOrder(this.sortOrder);
        dataReadOptionV2.setAggregateType(this.aggregateType);
        dataReadOptionV2.setGroupUnitSize(this.groupUnitSize);
        dataReadOptionV2.setGroupUnitType(this.groupUnitType);
        dataReadOptionV2.setReadSportMode(this.readSportMode);
        dataReadOptionV2.setReadHealthDataType(this.readHealthDataType);
        dataReadOptionV2.setDataId(this.dataId);
        dataReadOptionV2.setDataReadType(this.dataReadType);
        dataReadOptionV2.setWeightMeasurementMinTimestamp(this.weightMeasurementMinTimestamp);
        dataReadOptionV2.setWeightUserTagId(this.weightUserTagId);
        dataReadOptionV2.setIsParse(this.isParse);
        return dataReadOptionV2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAggregateType() {
        return this.aggregateType;
    }

    public int getAnchor() {
        return this.anchor;
    }

    public int getCount() {
        return this.count;
    }

    public String getDataId() {
        return this.dataId;
    }

    public String getDataReadType() {
        return this.dataReadType;
    }

    public int getDataTable() {
        return this.dataTable;
    }

    public String getDeviceUniqueId() {
        return this.deviceUniqueId;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getGroupUnitSize() {
        return this.groupUnitSize;
    }

    public int getGroupUnitType() {
        return this.groupUnitType;
    }

    public int getIsParse() {
        return this.isParse;
    }

    public int getReadHealthDataType() {
        return this.readHealthDataType;
    }

    public int getReadSportMode() {
        return this.readSportMode;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public String getSsoid() {
        return this.ssoid;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getWeightMeasurementMinTimestamp() {
        return this.weightMeasurementMinTimestamp;
    }

    public String getWeightUserTagId() {
        return this.weightUserTagId;
    }

    public void setAggregateType(int i3) {
        this.aggregateType = i3;
    }

    public void setAnchor(int i3) {
        this.anchor = i3;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setDataId(String str) {
        this.dataId = str;
    }

    public void setDataReadType(String str) {
        this.dataReadType = str;
    }

    public void setDataTable(int i3) {
        this.dataTable = i3;
    }

    public void setDeviceUniqueId(String str) {
        this.deviceUniqueId = str;
    }

    public void setEndTime(long j3) {
        this.endTime = j3;
    }

    public void setGroupUnitSize(int i3) {
        this.groupUnitSize = i3;
    }

    public void setGroupUnitType(int i3) {
        this.groupUnitType = i3;
    }

    public void setIsParse(@ParseType int i3) {
        this.isParse = i3;
    }

    public void setReadHealthDataType(int i3) {
        this.readHealthDataType = i3;
    }

    public void setReadSportMode(int i3) {
        this.readSportMode = i3;
    }

    public void setSortOrder(int i3) {
        this.sortOrder = i3;
    }

    public void setSsoid(String str) {
        this.ssoid = str;
    }

    public void setStartTime(long j3) {
        this.startTime = j3;
    }

    public void setWeightMeasurementMinTimestamp(long j3) {
        this.weightMeasurementMinTimestamp = j3;
    }

    public void setWeightUserTagId(String str) {
        this.weightUserTagId = str;
    }

    public String toString() {
        return "DataReadOption{startTime=" + this.startTime + ", endTime=" + this.endTime + ", deviceUniqueId='" + this.deviceUniqueId + "', dataTable=" + this.dataTable + ", anchor=" + this.anchor + ", count=" + this.count + ", sortOrder=" + this.sortOrder + ", aggregateType=" + this.aggregateType + ", groupUnitSize=" + this.groupUnitSize + ", groupUnitType=" + this.groupUnitType + ", readSportMode=" + this.readSportMode + ", readHealthDataType=" + this.readHealthDataType + ", dataId='" + this.dataId + "', dataReadType='" + this.dataReadType + "', weightMeasurementMinTimestamp=" + this.weightMeasurementMinTimestamp + ", weightUserTagId='" + this.weightUserTagId + "', isParse='" + this.isParse + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeInt(this.dataTable);
        parcel.writeInt(this.anchor);
        parcel.writeInt(this.count);
        parcel.writeInt(this.sortOrder);
        parcel.writeInt(this.aggregateType);
        parcel.writeInt(this.groupUnitSize);
        parcel.writeInt(this.groupUnitType);
        parcel.writeInt(this.readSportMode);
        parcel.writeInt(this.readHealthDataType);
        parcel.writeString(this.dataId);
        parcel.writeString(this.dataReadType);
        parcel.writeLong(this.weightMeasurementMinTimestamp);
        parcel.writeString(this.weightUserTagId);
        parcel.writeInt(this.isParse);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DataReadOption(Parcel parcel) {
        this.weightMeasurementMinTimestamp = Long.MAX_VALUE;
        this.isParse = 0;
        this.ssoid = parcel.readString();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.deviceUniqueId = parcel.readString();
        this.dataTable = parcel.readInt();
        this.anchor = parcel.readInt();
        this.count = parcel.readInt();
        this.sortOrder = parcel.readInt();
        this.aggregateType = parcel.readInt();
        this.groupUnitSize = parcel.readInt();
        this.groupUnitType = parcel.readInt();
        this.readSportMode = parcel.readInt();
        this.readHealthDataType = parcel.readInt();
        this.dataId = parcel.readString();
        this.dataReadType = parcel.readString();
        this.weightMeasurementMinTimestamp = parcel.readLong();
        this.weightUserTagId = parcel.readString();
        this.isParse = parcel.readInt();
    }
}
