package com.tencent.opentelemetry.api.metrics;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface MeterBuilder {
    Meter build();

    MeterBuilder setInstrumentationVersion(String str);

    MeterBuilder setSchemaUrl(String str);
}
