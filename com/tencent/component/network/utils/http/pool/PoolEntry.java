package com.tencent.component.network.utils.http.pool;

import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public abstract class PoolEntry<T, C> {
    private final C conn;
    private final long created;
    private long expiry;

    /* renamed from: id, reason: collision with root package name */
    private final String f99906id;
    private final T route;
    private volatile Object state;
    private long updated;
    private final long validUnit;

    public PoolEntry(String str, T t16, C c16, long j3, TimeUnit timeUnit) {
        if (t16 == null) {
            throw new IllegalArgumentException("Route may not be null");
        }
        if (c16 == null) {
            throw new IllegalArgumentException("Connection may not be null");
        }
        if (timeUnit != null) {
            this.f99906id = str;
            this.route = t16;
            this.conn = c16;
            long currentTimeMillis = System.currentTimeMillis();
            this.created = currentTimeMillis;
            if (j3 > 0) {
                this.validUnit = currentTimeMillis + timeUnit.toMillis(j3);
            } else {
                this.validUnit = Long.MAX_VALUE;
            }
            this.expiry = this.validUnit;
            return;
        }
        throw new IllegalArgumentException("Time unit may not be null");
    }

    public abstract void close();

    public C getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public synchronized long getExpiry() {
        return this.expiry;
    }

    public String getId() {
        return this.f99906id;
    }

    public T getRoute() {
        return this.route;
    }

    public Object getState() {
        return this.state;
    }

    public synchronized long getUpdated() {
        return this.updated;
    }

    public long getValidUnit() {
        return this.validUnit;
    }

    public abstract boolean isClosed();

    public synchronized boolean isExpired(long j3) {
        boolean z16;
        if (j3 >= this.expiry) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public String toString() {
        return "[id:" + this.f99906id + "][route:" + this.route + "][state:" + this.state + "]";
    }

    public synchronized void updateExpiry(long j3, TimeUnit timeUnit) {
        long j16;
        if (timeUnit != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.updated = currentTimeMillis;
            if (j3 > 0) {
                j16 = currentTimeMillis + timeUnit.toMillis(j3);
            } else {
                j16 = Long.MAX_VALUE;
            }
            this.expiry = Math.min(j16, this.validUnit);
        } else {
            throw new IllegalArgumentException("Time unit may not be null");
        }
    }

    public PoolEntry(String str, T t16, C c16) {
        this(str, t16, c16, 0L, TimeUnit.MILLISECONDS);
    }
}
