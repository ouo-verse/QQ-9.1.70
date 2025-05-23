package com.tencent.opentelemetry.sdk.metrics.internal.concurrent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface LongAdder {
    public static final IPatchRedirector $redirector_ = null;

    void add(long j3);

    void decrement();

    double doubleValue();

    float floatValue();

    void increment();

    int intValue();

    long longValue();

    void reset();

    long sum();

    long sumThenReset();
}
