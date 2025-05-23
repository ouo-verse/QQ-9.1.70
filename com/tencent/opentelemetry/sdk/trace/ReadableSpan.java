package com.tencent.opentelemetry.sdk.trace;

import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.trace.SpanContext;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ReadableSpan {
    @Nullable
    <T> T getAttribute(AttributeKey<T> attributeKey);

    InstrumentationLibraryInfo getInstrumentationLibraryInfo();

    InstrumentationScopeInfo getInstrumentationScopeInfo();

    SpanKind getKind();

    long getLatencyNanos();

    String getName();

    SpanContext getParentSpanContext();

    SpanContext getSpanContext();

    boolean hasEnded();

    SpanData toSpanData();
}
