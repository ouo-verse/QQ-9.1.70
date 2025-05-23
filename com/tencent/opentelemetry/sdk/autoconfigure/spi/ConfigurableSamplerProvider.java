package com.tencent.opentelemetry.sdk.autoconfigure.spi;

import com.tencent.opentelemetry.sdk.autoconfigure.ConfigProperties;
import com.tencent.opentelemetry.sdk.trace.samplers.Sampler;

/* loaded from: classes22.dex */
public interface ConfigurableSamplerProvider {
    Sampler createSampler(ConfigProperties configProperties);

    String getName();
}
