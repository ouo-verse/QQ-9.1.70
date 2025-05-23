package com.tencent.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DoubleGaugeBuilder {
    ObservableDoubleGauge buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer);

    LongGaugeBuilder ofLongs();

    DoubleGaugeBuilder setDescription(String str);

    DoubleGaugeBuilder setUnit(String str);
}
