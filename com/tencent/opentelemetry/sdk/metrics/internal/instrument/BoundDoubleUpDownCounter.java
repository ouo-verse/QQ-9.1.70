package com.tencent.opentelemetry.sdk.metrics.internal.instrument;

import com.tencent.opentelemetry.context.Context;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface BoundDoubleUpDownCounter {
    void add(double d16);

    void add(double d16, Context context);

    void unbind();
}
