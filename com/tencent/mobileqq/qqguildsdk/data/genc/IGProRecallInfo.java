package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProRecallInfo extends Serializable {
    float getQualityScore();

    String getQuery();

    String getRecallName();

    float getRelevanceScore();

    float getScore();

    String getTraceId();

    String toString();
}
