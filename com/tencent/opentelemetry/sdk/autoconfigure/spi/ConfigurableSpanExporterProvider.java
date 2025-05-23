package com.tencent.opentelemetry.sdk.autoconfigure.spi;

import com.tencent.opentelemetry.sdk.autoconfigure.ConfigProperties;
import com.tencent.opentelemetry.sdk.trace.export.SpanExporter;

/* loaded from: classes22.dex */
public interface ConfigurableSpanExporterProvider {
    SpanExporter createExporter(ConfigProperties configProperties);

    String getName();
}
