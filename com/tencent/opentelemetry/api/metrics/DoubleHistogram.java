package com.tencent.opentelemetry.api.metrics;

import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface DoubleHistogram {
    void record(double d16);

    void record(double d16, Attributes attributes);

    void record(double d16, Attributes attributes, Context context);
}
