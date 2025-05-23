package com.tencent.opentelemetry.sdk.autoconfigure.spi;

import com.tencent.opentelemetry.sdk.autoconfigure.ConfigProperties;
import com.tencent.opentelemetry.sdk.resources.Resource;

/* loaded from: classes22.dex */
public interface ResourceProvider {
    Resource createResource(ConfigProperties configProperties);
}
