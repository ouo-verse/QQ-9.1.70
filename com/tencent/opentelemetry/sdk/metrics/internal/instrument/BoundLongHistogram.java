package com.tencent.opentelemetry.sdk.metrics.internal.instrument;

import com.tencent.opentelemetry.context.Context;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface BoundLongHistogram {
    void record(long j3);

    void record(long j3, Context context);

    void unbind();
}
