package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchGetRecommendWordsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchRecommendWord;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProAISearchGetRecommendWordsRsp implements IGProAISearchGetRecommendWordsRsp {
    public final GProAISearchGetRecommendWordsRsp mInfo;

    public GGProAISearchGetRecommendWordsRsp(GProAISearchGetRecommendWordsRsp gProAISearchGetRecommendWordsRsp) {
        this.mInfo = gProAISearchGetRecommendWordsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetRecommendWordsRsp
    public String getFirstTitle() {
        return this.mInfo.getFirstTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetRecommendWordsRsp
    public String getSecondTitle() {
        return this.mInfo.getSecondTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetRecommendWordsRsp
    public ArrayList<IGProAISearchRecommendWord> getWords() {
        ArrayList<GProAISearchRecommendWord> words = this.mInfo.getWords();
        ArrayList<IGProAISearchRecommendWord> arrayList = new ArrayList<>();
        Iterator<GProAISearchRecommendWord> it = words.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProAISearchRecommendWord(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchGetRecommendWordsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
