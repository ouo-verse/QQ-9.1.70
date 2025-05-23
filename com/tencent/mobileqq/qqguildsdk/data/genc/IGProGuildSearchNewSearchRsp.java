package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildSearchNewSearchRsp extends Serializable {
    IGProGuildSearchAISearchInfo getAiSearchInfo();

    ArrayList<String> getHighlightWords();

    IGProGuildSearchUnionResult getUnionResult();

    String toString();
}
