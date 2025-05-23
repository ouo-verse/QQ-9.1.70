package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAISearchMsgContent {
    public int finishReason;
    public long modelThinkingTime;
    public String userQuery = "";
    public String modelContent = "";
    public String reasoningContent = "";

    public int getFinishReason() {
        return this.finishReason;
    }

    public String getModelContent() {
        return this.modelContent;
    }

    public long getModelThinkingTime() {
        return this.modelThinkingTime;
    }

    public String getReasoningContent() {
        return this.reasoningContent;
    }

    public String getUserQuery() {
        return this.userQuery;
    }

    public String toString() {
        return "GProAISearchMsgContent{userQuery=" + this.userQuery + ",modelContent=" + this.modelContent + ",reasoningContent=" + this.reasoningContent + ",finishReason=" + this.finishReason + ",modelThinkingTime=" + this.modelThinkingTime + ",}";
    }
}
