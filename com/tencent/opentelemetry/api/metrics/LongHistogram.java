package com.tencent.opentelemetry.api.metrics;

import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface LongHistogram {
    void record(long j3);

    void record(long j3, Attributes attributes);

    void record(long j3, Attributes attributes, Context context);
}
