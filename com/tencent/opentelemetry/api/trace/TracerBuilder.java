package com.tencent.opentelemetry.api.trace;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface TracerBuilder {
    Tracer build();

    TracerBuilder setInstrumentationVersion(String str);

    TracerBuilder setSchemaUrl(String str);
}
