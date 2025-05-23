package com.tencent.opentelemetry.sdk.autoconfigure.spi;

import com.tencent.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;

/* loaded from: classes22.dex */
public interface SdkMeterProviderConfigurer {
    void configure(SdkMeterProviderBuilder sdkMeterProviderBuilder);
}
