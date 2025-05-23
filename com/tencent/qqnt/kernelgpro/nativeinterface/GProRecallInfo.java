package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRecallInfo {
    public float qualityScore;
    public String query;
    public String recallName;
    public float relevanceScore;
    public float score;
    public String traceId;

    public GProRecallInfo() {
        this.query = "";
        this.recallName = "";
        this.traceId = "";
    }

    public float getQualityScore() {
        return this.qualityScore;
    }

    public String getQuery() {
        return this.query;
    }

    public String getRecallName() {
        return this.recallName;
    }

    public float getRelevanceScore() {
        return this.relevanceScore;
    }

    public float getScore() {
        return this.score;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String toString() {
        return "GProRecallInfo{query=" + this.query + ",recallName=" + this.recallName + ",relevanceScore=" + this.relevanceScore + ",qualityScore=" + this.qualityScore + ",score=" + this.score + ",traceId=" + this.traceId + ",}";
    }

    public GProRecallInfo(String str, String str2, float f16, float f17, float f18, String str3) {
        this.query = str;
        this.recallName = str2;
        this.relevanceScore = f16;
        this.qualityScore = f17;
        this.score = f18;
        this.traceId = str3;
    }
}
