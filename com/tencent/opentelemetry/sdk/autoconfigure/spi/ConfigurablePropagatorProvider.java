package com.tencent.opentelemetry.sdk.autoconfigure.spi;

import com.tencent.opentelemetry.context.propagation.TextMapPropagator;

/* loaded from: classes22.dex */
public interface ConfigurablePropagatorProvider {
    String getName();

    TextMapPropagator getPropagator();
}
