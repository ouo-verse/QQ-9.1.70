package com.tencent.opentelemetry.api.metrics;

import com.tencent.opentelemetry.api.common.Attributes;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ObservableLongMeasurement {
    void record(long j3);

    void record(long j3, Attributes attributes);
}
