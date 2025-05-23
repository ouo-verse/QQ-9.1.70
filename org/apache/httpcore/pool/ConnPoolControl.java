package org.apache.httpcore.pool;

/* loaded from: classes29.dex */
public interface ConnPoolControl<T> {
    int getDefaultMaxPerRoute();

    int getMaxPerRoute(T t16);

    int getMaxTotal();

    PoolStats getStats(T t16);

    PoolStats getTotalStats();

    void setDefaultMaxPerRoute(int i3);

    void setMaxPerRoute(T t16, int i3);

    void setMaxTotal(int i3);
}
