package com.tencent.opentelemetry.sdk.logs.data;

import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.resources.Resource;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface LogData {
    Attributes getAttributes();

    Body getBody();

    long getEpochNanos();

    InstrumentationScopeInfo getInstrumentationScopeInfo();

    Resource getResource();

    Severity getSeverity();

    @Nullable
    String getSeverityText();

    SpanContext getSpanContext();
}
