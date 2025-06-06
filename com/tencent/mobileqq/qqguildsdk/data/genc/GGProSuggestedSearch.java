package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSuggestedSearch;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GGProSuggestedSearch implements IGProSuggestedSearch {
    public final GProSuggestedSearch mInfo;

    public GGProSuggestedSearch(GProSuggestedSearch gProSuggestedSearch) {
        this.mInfo = gProSuggestedSearch;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSuggestedSearch
    public ArrayList<String> getContentList() {
        return this.mInfo.getContentList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSuggestedSearch
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSuggestedSearch
    public String toString() {
        return this.mInfo.toString();
    }
}
