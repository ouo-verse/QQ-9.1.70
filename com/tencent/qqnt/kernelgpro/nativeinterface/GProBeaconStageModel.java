package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.HashMap;

/* loaded from: classes24.dex */
public final class GProBeaconStageModel {
    public long reportTime;
    public long stageTime;
    public String stageCode = "";
    public String traceId = "";
    public HashMap<String, String> customReportInfo = new HashMap<>();
    public HashMap<String, String> extraParams = new HashMap<>();

    public HashMap<String, String> getCustomReportInfo() {
        return this.customReportInfo;
    }

    public HashMap<String, String> getExtraParams() {
        return this.extraParams;
    }

    public long getReportTime() {
        return this.reportTime;
    }

    public String getStageCode() {
        return this.stageCode;
    }

    public long getStageTime() {
        return this.stageTime;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProBeaconStageModel{stageCode=" + this.stageCode + ",reportTime=" + this.reportTime + ",stageTime=" + this.stageTime + ",traceId=" + this.traceId + ",customReportInfo=" + this.customReportInfo + ",extraParams=" + this.extraParams + ",}";
    }
}
