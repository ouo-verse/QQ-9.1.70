package org.apache.httpcore.pool;

import java.util.concurrent.TimeUnit;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes29.dex */
public abstract class PoolEntry<T, C> {
    private final C conn;
    private final long created;
    private long expiry;

    /* renamed from: id, reason: collision with root package name */
    private final String f423550id;
    private final T route;
    private volatile Object state;
    private long updated;
    private final long validityDeadline;

    public PoolEntry(String str, T t16, C c16, long j3, TimeUnit timeUnit) {
        Args.notNull(t16, "Route");
        Args.notNull(c16, "Connection");
        Args.notNull(timeUnit, "Time unit");
        this.f423550id = str;
        this.route = t16;
        this.conn = c16;
        long currentTimeMillis = System.currentTimeMillis();
        this.created = currentTimeMillis;
        this.updated = currentTimeMillis;
        if (j3 > 0) {
            long millis = currentTimeMillis + timeUnit.toMillis(j3);
            this.validityDeadline = millis > 0 ? millis : Long.MAX_VALUE;
        } else {
            this.validityDeadline = Long.MAX_VALUE;
        }
        this.expiry = this.validityDeadline;
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
        return this.f423550id;
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

    @Deprecated
    public long getValidUnit() {
        return this.validityDeadline;
    }

    public long getValidityDeadline() {
        return this.validityDeadline;
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
        return "[id:" + this.f423550id + "][route:" + this.route + "][state:" + this.state + "]";
    }

    public synchronized void updateExpiry(long j3, TimeUnit timeUnit) {
        long j16;
        Args.notNull(timeUnit, "Time unit");
        long currentTimeMillis = System.currentTimeMillis();
        this.updated = currentTimeMillis;
        if (j3 > 0) {
            j16 = currentTimeMillis + timeUnit.toMillis(j3);
        } else {
            j16 = Long.MAX_VALUE;
        }
        this.expiry = Math.min(j16, this.validityDeadline);
    }

    public PoolEntry(String str, T t16, C c16) {
        this(str, t16, c16, 0L, TimeUnit.MILLISECONDS);
    }
}
