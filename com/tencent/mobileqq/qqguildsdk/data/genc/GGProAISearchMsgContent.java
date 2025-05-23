package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchMsgContent;

/* loaded from: classes17.dex */
public class GGProAISearchMsgContent implements IGProAISearchMsgContent {
    public final GProAISearchMsgContent mInfo;

    public GGProAISearchMsgContent(GProAISearchMsgContent gProAISearchMsgContent) {
        this.mInfo = gProAISearchMsgContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchMsgContent
    public int getFinishReason() {
        return this.mInfo.getFinishReason();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchMsgContent
    public String getModelContent() {
        return this.mInfo.getModelContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchMsgContent
    public long getModelThinkingTime() {
        return this.mInfo.getModelThinkingTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchMsgContent
    public String getReasoningContent() {
        return this.mInfo.getReasoningContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchMsgContent
    public String getUserQuery() {
        return this.mInfo.getUserQuery();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchMsgContent
    public String toString() {
        return this.mInfo.toString();
    }
}
