package com.heytap.databaseengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class ECGRecord extends SportHealthData implements Parcelable {
    public static final Parcelable.Creator<ECGRecord> CREATOR = new Parcelable.Creator<ECGRecord>() { // from class: com.heytap.databaseengine.model.ECGRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ECGRecord createFromParcel(Parcel parcel) {
            return new ECGRecord(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ECGRecord[] newArray(int i3) {
            return new ECGRecord[i3];
        }
    };
    private String aacData;
    private long aacStartTimestamp;
    private String algorithmsAnalyzeResult;
    private String appVersion;
    private int avgHeartRate;
    private String clientDataId;
    private String data;
    private String deviceUniqueId;
    private int deviceVersion;
    private String ecgAppVersion;
    private String ecgId;
    private String ecgResultId;
    private String ecgResultName;
    private long ecgStartTimestamp;
    private long endTimestamp;
    private String expertInterpretation;
    private int expertState;
    private int hand;
    private int maxHeartRate;
    private String personState;
    private String ppgData;
    private String reportId;
    private String serviceApplyId;
    private String ssoid;
    private long startTimestamp;
    private String symptoms;
    private int syncStatus;
    private String userInfo;
    private int version;

    public ECGRecord() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAacData() {
        return this.aacData;
    }

    public long getAacStartTimestamp() {
        return this.aacStartTimestamp;
    }

    public String getAlgorithmsAnalyzeResult() {
        return this.algorithmsAnalyzeResult;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public int getAvgHeartRate() {
        return this.avgHeartRate;
    }

    public String getClientDataId() {
        return this.clientDataId;
    }

    public String getData() {
        return this.data;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getDeviceUniqueId() {
        return this.deviceUniqueId;
    }

    public int getDeviceVersion() {
        return this.deviceVersion;
    }

    public String getEcgAppVersion() {
        return this.ecgAppVersion;
    }

    public String getEcgId() {
        return this.ecgId;
    }

    public String getEcgResultId() {
        return this.ecgResultId;
    }

    public String getEcgResultName() {
        return this.ecgResultName;
    }

    public long getEcgStartTimestamp() {
        return this.ecgStartTimestamp;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public long getEndTimestamp() {
        return this.endTimestamp;
    }

    public String getExpertInterpretation() {
        return this.expertInterpretation;
    }

    public int getExpertState() {
        return this.expertState;
    }

    public int getHand() {
        return this.hand;
    }

    public int getMaxHeartRate() {
        return this.maxHeartRate;
    }

    public String getPersonState() {
        return this.personState;
    }

    public String getPpgData() {
        return this.ppgData;
    }

    public String getReportId() {
        return this.reportId;
    }

    public String getServiceApplyId() {
        return this.serviceApplyId;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String getSsoid() {
        return this.ssoid;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public long getStartTimestamp() {
        return this.startTimestamp;
    }

    public String getSymptoms() {
        return this.symptoms;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public int getVersion() {
        return this.version;
    }

    public void setAacData(String str) {
        this.aacData = str;
    }

    public void setAacStartTimestamp(long j3) {
        this.aacStartTimestamp = j3;
    }

    public void setAlgorithmsAnalyzeResult(String str) {
        this.algorithmsAnalyzeResult = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setAvgHeartRate(int i3) {
        this.avgHeartRate = i3;
    }

    public void setClientDataId(String str) {
        this.clientDataId = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setDeviceUniqueId(String str) {
        this.deviceUniqueId = str;
    }

    public void setDeviceVersion(int i3) {
        this.deviceVersion = i3;
    }

    public void setEcgAppVersion(String str) {
        this.ecgAppVersion = str;
    }

    public void setEcgId(String str) {
        this.ecgId = str;
    }

    public void setEcgResultId(String str) {
        this.ecgResultId = str;
    }

    public void setEcgResultName(String str) {
        this.ecgResultName = str;
    }

    public void setEcgStartTimestamp(long j3) {
        this.ecgStartTimestamp = j3;
    }

    public void setEndTimestamp(long j3) {
        this.endTimestamp = j3;
    }

    public void setExpertInterpretation(String str) {
        this.expertInterpretation = str;
    }

    public void setExpertState(int i3) {
        this.expertState = i3;
    }

    public void setHand(int i3) {
        this.hand = i3;
    }

    public void setMaxHeartRate(int i3) {
        this.maxHeartRate = i3;
    }

    public void setPersonState(String str) {
        this.personState = str;
    }

    public void setPpgData(String str) {
        this.ppgData = str;
    }

    public void setReportId(String str) {
        this.reportId = str;
    }

    public void setServiceApplyId(String str) {
        this.serviceApplyId = str;
    }

    public void setSsoid(String str) {
        this.ssoid = str;
    }

    public void setStartTimestamp(long j3) {
        this.startTimestamp = j3;
    }

    public void setSymptoms(String str) {
        this.symptoms = str;
    }

    public void setSyncStatus(int i3) {
        this.syncStatus = i3;
    }

    public void setUserInfo(String str) {
        this.userInfo = str;
    }

    public void setVersion(int i3) {
        this.version = i3;
    }

    @Override // com.heytap.databaseengine.model.SportHealthData
    public String toString() {
        return "ECGRecord{clientDataId='" + this.clientDataId + "', ssoid='" + this.ssoid + "', deviceUniqueId='" + this.deviceUniqueId + "', startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", ecgId=" + this.ecgId + ", hand=" + this.hand + ", ecgStartTimestamp=" + this.ecgStartTimestamp + ", aacStartTimestamp=" + this.aacStartTimestamp + ", version=" + this.version + ", avgHeartRate=" + this.avgHeartRate + ", maxHeartRate=" + this.maxHeartRate + ", expertInterpretation='" + this.expertInterpretation + "', algorithmsAnalyzeResult='" + this.algorithmsAnalyzeResult + "', expertState=" + this.expertState + ", reportId='" + this.reportId + "', serviceApplyId='" + this.serviceApplyId + "', personState='" + this.personState + "', deviceVersion=" + this.deviceVersion + ", syncStatus=" + this.syncStatus + ", ecgAppVersion='" + this.ecgAppVersion + "', appVersion='" + this.appVersion + "', userInfo='" + this.userInfo + "', ecgResultId='" + this.ecgResultId + "', ecgResultName='" + this.ecgResultName + "', symptoms='" + this.symptoms + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.clientDataId);
        parcel.writeString(this.ssoid);
        parcel.writeString(this.deviceUniqueId);
        parcel.writeLong(this.startTimestamp);
        parcel.writeLong(this.endTimestamp);
        parcel.writeString(this.ecgId);
        parcel.writeInt(this.hand);
        parcel.writeString(this.data);
        parcel.writeString(this.ppgData);
        parcel.writeString(this.aacData);
        parcel.writeLong(this.ecgStartTimestamp);
        parcel.writeLong(this.aacStartTimestamp);
        parcel.writeInt(this.version);
        parcel.writeInt(this.avgHeartRate);
        parcel.writeInt(this.maxHeartRate);
        parcel.writeString(this.expertInterpretation);
        parcel.writeString(this.algorithmsAnalyzeResult);
        parcel.writeInt(this.expertState);
        parcel.writeString(this.reportId);
        parcel.writeString(this.serviceApplyId);
        parcel.writeString(this.personState);
        parcel.writeInt(this.syncStatus);
        parcel.writeInt(this.deviceVersion);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.ecgAppVersion);
        parcel.writeString(this.symptoms);
        parcel.writeString(this.ecgResultId);
        parcel.writeString(this.ecgResultName);
        parcel.writeString(this.userInfo);
    }

    protected ECGRecord(Parcel parcel) {
        this.clientDataId = parcel.readString();
        this.ssoid = parcel.readString();
        this.deviceUniqueId = parcel.readString();
        this.startTimestamp = parcel.readLong();
        this.endTimestamp = parcel.readLong();
        this.ecgId = parcel.readString();
        this.hand = parcel.readInt();
        this.data = parcel.readString();
        this.ppgData = parcel.readString();
        this.aacData = parcel.readString();
        this.ecgStartTimestamp = parcel.readLong();
        this.aacStartTimestamp = parcel.readLong();
        this.version = parcel.readInt();
        this.avgHeartRate = parcel.readInt();
        this.maxHeartRate = parcel.readInt();
        this.expertInterpretation = parcel.readString();
        this.algorithmsAnalyzeResult = parcel.readString();
        this.expertState = parcel.readInt();
        this.reportId = parcel.readString();
        this.serviceApplyId = parcel.readString();
        this.personState = parcel.readString();
        this.syncStatus = parcel.readInt();
        this.deviceVersion = parcel.readInt();
        this.appVersion = parcel.readString();
        this.ecgAppVersion = parcel.readString();
        this.symptoms = parcel.readString();
        this.ecgResultId = parcel.readString();
        this.ecgResultName = parcel.readString();
        this.userInfo = parcel.readString();
    }
}
