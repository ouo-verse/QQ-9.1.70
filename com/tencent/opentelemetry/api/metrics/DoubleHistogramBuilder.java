package com.tencent.opentelemetry.api.metrics;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DoubleHistogramBuilder {
    DoubleHistogram build();

    LongHistogramBuilder ofLongs();

    DoubleHistogramBuilder setDescription(String str);

    DoubleHistogramBuilder setUnit(String str);
}
