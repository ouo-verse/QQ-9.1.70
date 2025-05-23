package com.tencent.opentelemetry.sdk.logs;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface LogEmitterBuilder {
    LogEmitter build();

    LogEmitterBuilder setInstrumentationVersion(String str);

    LogEmitterBuilder setSchemaUrl(String str);
}
