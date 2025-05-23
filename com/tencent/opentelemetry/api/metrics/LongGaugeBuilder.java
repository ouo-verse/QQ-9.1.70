package com.tencent.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface LongGaugeBuilder {
    ObservableLongGauge buildWithCallback(Consumer<ObservableLongMeasurement> consumer);

    LongGaugeBuilder setDescription(String str);

    LongGaugeBuilder setUnit(String str);
}
