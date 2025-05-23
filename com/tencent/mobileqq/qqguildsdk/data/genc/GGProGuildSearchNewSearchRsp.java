package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchNewSearchRsp;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProGuildSearchNewSearchRsp implements IGProGuildSearchNewSearchRsp {
    public final GProGuildSearchNewSearchRsp mInfo;

    public GGProGuildSearchNewSearchRsp(GProGuildSearchNewSearchRsp gProGuildSearchNewSearchRsp) {
        this.mInfo = gProGuildSearchNewSearchRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchNewSearchRsp
    public IGProGuildSearchAISearchInfo getAiSearchInfo() {
        return new GGProGuildSearchAISearchInfo(this.mInfo.getAiSearchInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchNewSearchRsp
    public ArrayList<String> getHighlightWords() {
        return this.mInfo.getHighlightWords();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchNewSearchRsp
    public IGProGuildSearchUnionResult getUnionResult() {
        return new GGProGuildSearchUnionResult(this.mInfo.getUnionResult());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchNewSearchRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
