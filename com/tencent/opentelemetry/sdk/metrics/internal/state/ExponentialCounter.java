package com.tencent.opentelemetry.sdk.metrics.internal.state;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ExponentialCounter {
    void clear();

    long get(int i3);

    int getIndexEnd();

    int getIndexStart();

    int getMaxSize();

    boolean increment(int i3, long j3);

    boolean isEmpty();
}
