package com.tencent.opentelemetry.api.metrics;

import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface LongCounter {
    void add(long j3);

    void add(long j3, Attributes attributes);

    void add(long j3, Attributes attributes, Context context);
}
