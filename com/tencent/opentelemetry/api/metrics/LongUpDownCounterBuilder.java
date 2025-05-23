package com.tencent.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface LongUpDownCounterBuilder {
    LongUpDownCounter build();

    ObservableLongUpDownCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer);

    DoubleUpDownCounterBuilder ofDoubles();

    LongUpDownCounterBuilder setDescription(String str);

    LongUpDownCounterBuilder setUnit(String str);
}
