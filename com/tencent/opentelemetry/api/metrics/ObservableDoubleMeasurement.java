package com.tencent.opentelemetry.api.metrics;

import com.tencent.opentelemetry.api.common.Attributes;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ObservableDoubleMeasurement {
    void record(double d16);

    void record(double d16, Attributes attributes);
}
