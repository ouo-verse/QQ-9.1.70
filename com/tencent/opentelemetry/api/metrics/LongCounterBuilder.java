package com.tencent.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface LongCounterBuilder {
    LongCounter build();

    ObservableLongCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer);

    DoubleCounterBuilder ofDoubles();

    LongCounterBuilder setDescription(String str);

    LongCounterBuilder setUnit(String str);
}
