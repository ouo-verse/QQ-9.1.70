package org.aspectj.runtime.internal.cflowstack;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ThreadCounter {
    void dec();

    void inc();

    boolean isNotZero();

    void removeThreadCounter();
}
