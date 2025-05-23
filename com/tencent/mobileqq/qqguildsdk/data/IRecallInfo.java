package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecallInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface IRecallInfo extends IGProRecallInfo {
    float getQualityScore();

    String getQuery();

    String getRecallName();

    float getRelevanceScore();

    float getScore();

    String getTraceId();
}
