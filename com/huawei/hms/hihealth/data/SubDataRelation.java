package com.huawei.hms.hihealth.data;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SubDataRelation {
    private String dataCollectorId;
    private String dataTypeName;
    private long endTime;
    private long startTime;

    public SubDataRelation(long j3, long j16, String str, String str2) {
        this.startTime = j3;
        this.endTime = j16;
        this.dataCollectorId = str;
        this.dataTypeName = str2;
    }

    public String getDataCollectorId() {
        return this.dataCollectorId;
    }

    public String getDataTypeName() {
        return this.dataTypeName;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setDataCollectorId(String str) {
        this.dataCollectorId = str;
    }

    public void setDataTypeName(String str) {
        this.dataTypeName = str;
    }

    public void setEndTime(long j3) {
        this.endTime = j3;
    }

    public void setStartTime(long j3) {
        this.startTime = j3;
    }
}
