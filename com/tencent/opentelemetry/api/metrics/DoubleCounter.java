package com.tencent.opentelemetry.api.metrics;

import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.context.Context;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface DoubleCounter {
    void add(double d16);

    void add(double d16, Attributes attributes);

    void add(double d16, Attributes attributes, Context context);
}
