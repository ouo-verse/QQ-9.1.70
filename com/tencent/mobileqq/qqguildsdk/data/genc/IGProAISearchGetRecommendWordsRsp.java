package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProAISearchGetRecommendWordsRsp extends Serializable {
    String getFirstTitle();

    String getSecondTitle();

    ArrayList<IGProAISearchRecommendWord> getWords();

    String toString();
}
