package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProAISearchMsgContent extends Serializable {
    int getFinishReason();

    String getModelContent();

    long getModelThinkingTime();

    String getReasoningContent();

    String getUserQuery();

    String toString();
}
