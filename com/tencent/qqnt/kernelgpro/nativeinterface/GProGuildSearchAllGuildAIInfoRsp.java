package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildSearchAllGuildAIInfoRsp {
    public String userMsgId = "";
    public String answerMsgId = "";
    public GProGuildSearchAISearchInfo aiSearchInfo = new GProGuildSearchAISearchInfo();
    public String sessionId = "";

    public GProGuildSearchAISearchInfo getAiSearchInfo() {
        return this.aiSearchInfo;
    }

    public String getAnswerMsgId() {
        return this.answerMsgId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getUserMsgId() {
        return this.userMsgId;
    }

    public String toString() {
        return "GProGuildSearchAllGuildAIInfoRsp{userMsgId=" + this.userMsgId + ",answerMsgId=" + this.answerMsgId + ",aiSearchInfo=" + this.aiSearchInfo + ",sessionId=" + this.sessionId + ",}";
    }
}
