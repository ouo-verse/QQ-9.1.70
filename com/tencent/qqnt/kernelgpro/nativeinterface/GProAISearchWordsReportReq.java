package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAISearchWordsReportReq {
    public ArrayList<String> guildWordIds = new ArrayList<>();
    public int reportType;
    public long timestamp;

    public ArrayList<String> getGuildWordIds() {
        return this.guildWordIds;
    }

    public int getReportType() {
        return this.reportType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        return "GProAISearchWordsReportReq{guildWordIds=" + this.guildWordIds + ",reportType=" + this.reportType + ",timestamp=" + this.timestamp + ",}";
    }
}
