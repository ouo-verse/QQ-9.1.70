package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAISearchGetRecommendWordsRsp {
    public String firstTitle = "";
    public String secondTitle = "";
    public ArrayList<GProAISearchRecommendWord> words = new ArrayList<>();

    public String getFirstTitle() {
        return this.firstTitle;
    }

    public String getSecondTitle() {
        return this.secondTitle;
    }

    public ArrayList<GProAISearchRecommendWord> getWords() {
        return this.words;
    }

    public String toString() {
        return "GProAISearchGetRecommendWordsRsp{firstTitle=" + this.firstTitle + ",secondTitle=" + this.secondTitle + ",words=" + this.words + ",}";
    }
}
