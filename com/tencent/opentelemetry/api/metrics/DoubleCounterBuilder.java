package com.tencent.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DoubleCounterBuilder {
    DoubleCounter build();

    ObservableDoubleCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer);

    DoubleCounterBuilder setDescription(String str);

    DoubleCounterBuilder setUnit(String str);
}
