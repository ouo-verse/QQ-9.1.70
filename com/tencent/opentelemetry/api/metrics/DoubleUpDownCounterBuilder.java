package com.tencent.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DoubleUpDownCounterBuilder {
    DoubleUpDownCounter build();

    ObservableDoubleUpDownCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer);

    DoubleUpDownCounterBuilder setDescription(String str);

    DoubleUpDownCounterBuilder setUnit(String str);
}
