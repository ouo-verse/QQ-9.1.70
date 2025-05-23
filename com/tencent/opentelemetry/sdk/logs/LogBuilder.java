package com.tencent.opentelemetry.sdk.logs;

import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.logs.data.Severity;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface LogBuilder {
    void emit();

    LogBuilder setAttributes(Attributes attributes);

    LogBuilder setBody(String str);

    LogBuilder setContext(Context context);

    LogBuilder setEpoch(long j3, TimeUnit timeUnit);

    LogBuilder setEpoch(Instant instant);

    LogBuilder setSeverity(Severity severity);

    LogBuilder setSeverityText(String str);
}
