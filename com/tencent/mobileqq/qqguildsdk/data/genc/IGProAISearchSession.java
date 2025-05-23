package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProAISearchSession extends Serializable {
    String getFirstMsgId();

    int getIsDeleted();

    String getSessionId();

    int getSessionStatus();

    String getSummary();

    long getTimestamp();

    long getUpdateTimestamp();

    String toString();
}
