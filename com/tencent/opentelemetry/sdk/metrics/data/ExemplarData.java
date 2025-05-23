package com.tencent.opentelemetry.sdk.metrics.data;

import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanContext;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface ExemplarData {
    long getEpochNanos();

    Attributes getFilteredAttributes();

    SpanContext getSpanContext();
}
