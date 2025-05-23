package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildSearchAllGuildAIInfoRsp extends Serializable {
    IGProGuildSearchAISearchInfo getAiSearchInfo();

    String getAnswerMsgId();

    String getSessionId();

    String getUserMsgId();

    String toString();
}
