package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface BoundStorageHandle {
    void recordDouble(double d16, Attributes attributes, Context context);

    void recordLong(long j3, Attributes attributes, Context context);

    void release();
}
