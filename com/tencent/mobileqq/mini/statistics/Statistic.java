package com.tencent.mobileqq.mini.statistics;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface Statistic {
    void addSample(float f16);

    float calculate();

    void reset();
}
