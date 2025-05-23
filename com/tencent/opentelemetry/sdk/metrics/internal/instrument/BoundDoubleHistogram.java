package com.tencent.opentelemetry.sdk.metrics.internal.instrument;

import com.tencent.opentelemetry.context.Context;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface BoundDoubleHistogram {
    void record(double d16);

    void record(double d16, Context context);

    void unbind();
}
