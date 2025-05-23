package com.tencent.opentelemetry.api.metrics;

import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface Meter {
    LongCounterBuilder counterBuilder(String str);

    DoubleGaugeBuilder gaugeBuilder(String str);

    DoubleHistogramBuilder histogramBuilder(String str);

    LongUpDownCounterBuilder upDownCounterBuilder(String str);
}
