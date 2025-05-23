package com.tencent.qqmini.sdk.statistics;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface Statistic {
    void addSample(float f16);

    float calculate();

    void reset();
}
