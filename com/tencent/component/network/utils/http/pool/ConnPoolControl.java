package com.tencent.component.network.utils.http.pool;

/* loaded from: classes5.dex */
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
