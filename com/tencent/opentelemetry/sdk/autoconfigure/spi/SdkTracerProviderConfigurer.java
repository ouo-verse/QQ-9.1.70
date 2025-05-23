package com.tencent.opentelemetry.sdk.autoconfigure.spi;

import com.tencent.opentelemetry.sdk.trace.SdkTracerProviderBuilder;

/* loaded from: classes22.dex */
public interface SdkTracerProviderConfigurer {
    void configure(SdkTracerProviderBuilder sdkTracerProviderBuilder);
}
