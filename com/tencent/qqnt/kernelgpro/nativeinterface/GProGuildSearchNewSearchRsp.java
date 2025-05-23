package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildSearchNewSearchRsp {
    public GProGuildSearchUnionResult unionResult = new GProGuildSearchUnionResult();
    public ArrayList<String> highlightWords = new ArrayList<>();
    public GProGuildSearchAISearchInfo aiSearchInfo = new GProGuildSearchAISearchInfo();

    public GProGuildSearchAISearchInfo getAiSearchInfo() {
        return this.aiSearchInfo;
    }

    public ArrayList<String> getHighlightWords() {
        return this.highlightWords;
    }

    public GProGuildSearchUnionResult getUnionResult() {
        return this.unionResult;
    }

    public String toString() {
        return "GProGuildSearchNewSearchRsp{unionResult=" + this.unionResult + ",highlightWords=" + this.highlightWords + ",aiSearchInfo=" + this.aiSearchInfo + ",}";
    }
}
