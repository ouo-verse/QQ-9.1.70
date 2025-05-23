package org.apache.httpcore.pool;

/* loaded from: classes29.dex */
public interface PoolEntryCallback<T, C> {
    void process(PoolEntry<T, C> poolEntry);
}
