package com.tencent.opentelemetry.sdk.metrics.internal.concurrent;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DoubleAdder {
    public static final IPatchRedirector $redirector_ = null;

    void add(double d16);

    double doubleValue();

    float floatValue();

    int intValue();

    long longValue();

    void reset();

    double sum();

    double sumThenReset();
}
