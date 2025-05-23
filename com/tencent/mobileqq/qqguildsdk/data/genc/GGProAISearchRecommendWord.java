package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchRecommendWord;

/* loaded from: classes17.dex */
public class GGProAISearchRecommendWord implements IGProAISearchRecommendWord {
    public final GProAISearchRecommendWord mInfo;

    public GGProAISearchRecommendWord(GProAISearchRecommendWord gProAISearchRecommendWord) {
        this.mInfo = gProAISearchRecommendWord;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchRecommendWord
    public String getContent() {
        return this.mInfo.getContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchRecommendWord
    public String getWordId() {
        return this.mInfo.getWordId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchRecommendWord
    public String toString() {
        return this.mInfo.toString();
    }
}
