package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildSearchGetAllGuildAIInfoReq {
    public int modelType;
    public String query = "";
    public String sessionId = "";

    public int getModelType() {
        return this.modelType;
    }

    public String getQuery() {
        return this.query;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String toString() {
        return "GProGuildSearchGetAllGuildAIInfoReq{query=" + this.query + ",modelType=" + this.modelType + ",sessionId=" + this.sessionId + ",}";
    }
}
