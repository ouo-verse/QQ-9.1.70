package com.tencent.component.network.utils.http.pool;

import com.tencent.component.network.utils.http.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final LinkedList<E> available;
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set<E> leased;
    private final Lock lock;
    private final Map<T, Integer> maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList<PoolEntryFuture<E>> pending;
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;

    public AbstractConnPool(ConnFactory<T, C> connFactory, int i3, int i16) {
        if (connFactory != null) {
            if (i3 > 0) {
                if (i16 > 0) {
                    this.lock = new ReentrantLock();
                    this.connFactory = connFactory;
                    this.routeToPool = new HashMap();
                    this.leased = new HashSet();
                    this.available = new LinkedList<>();
                    this.pending = new LinkedList<>();
                    this.maxPerRoute = new HashMap();
                    this.defaultMaxPerRoute = i3;
                    this.maxTotal = i16;
                    return;
                }
                throw new IllegalArgumentException("Max total value may not be negative or zero");
            }
            throw new IllegalArgumentException("Max per route value may not be negative or zero");
        }
        throw new IllegalArgumentException("Connection factory may not null");
    }

    private int getMax(T t16) {
        Integer num = this.maxPerRoute.get(t16);
        if (num != null) {
            return num.intValue();
        }
        return this.defaultMaxPerRoute;
    }

    private RouteSpecificPool<T, C, E> getPool(final T t16) {
        RouteSpecificPool<T, C, E> routeSpecificPool = this.routeToPool.get(t16);
        if (routeSpecificPool == null) {
            RouteSpecificPool<T, C, E> routeSpecificPool2 = (RouteSpecificPool<T, C, E>) new RouteSpecificPool<T, C, E>(t16) { // from class: com.tencent.component.network.utils.http.pool.AbstractConnPool.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.tencent.component.network.utils.http.pool.RouteSpecificPool
                protected E createEntry(C c16) {
                    return (E) AbstractConnPool.this.createEntry(t16, c16);
                }
            };
            this.routeToPool.put(t16, routeSpecificPool2);
            return routeSpecificPool2;
        }
        return routeSpecificPool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public E getPoolEntryBlocking(T t16, Object obj, long j3, TimeUnit timeUnit, PoolEntryFuture<E> poolEntryFuture) throws IOException, InterruptedException, TimeoutException {
        Date date;
        E e16 = null;
        if (j3 > 0) {
            date = new Date(System.currentTimeMillis() + timeUnit.toMillis(j3));
        } else {
            date = null;
        }
        this.lock.lock();
        try {
            RouteSpecificPool pool = getPool(t16);
            while (e16 == null) {
                if (!this.isShutDown) {
                    while (true) {
                        e16 = (E) pool.getFree(obj);
                        if (e16 == null) {
                            break;
                        }
                        if (!e16.isClosed() && !e16.isExpired(System.currentTimeMillis())) {
                            break;
                        }
                        e16.close();
                        this.available.remove(e16);
                        pool.free(e16, false);
                    }
                    if (e16 != null) {
                        this.available.remove(e16);
                        this.leased.add(e16);
                        return e16;
                    }
                    int max = getMax(t16);
                    int max2 = Math.max(0, (pool.getAllocatedCount() + 1) - max);
                    if (max2 > 0) {
                        for (int i3 = 0; i3 < max2; i3++) {
                            PoolEntry lastUsed = pool.getLastUsed();
                            if (lastUsed == null) {
                                break;
                            }
                            lastUsed.close();
                            this.available.remove(lastUsed);
                            pool.remove(lastUsed);
                        }
                    }
                    if (pool.getAllocatedCount() < max) {
                        int max3 = Math.max(this.maxTotal - this.leased.size(), 0);
                        if (max3 > 0) {
                            if (this.available.size() > max3 - 1 && !this.available.isEmpty()) {
                                E removeLast = this.available.removeLast();
                                removeLast.close();
                                getPool(removeLast.getRoute()).remove(removeLast);
                            }
                            E e17 = (E) pool.add(this.connFactory.create(t16));
                            this.leased.add(e17);
                            return e17;
                        }
                    }
                    try {
                        pool.queue(poolEntryFuture);
                        this.pending.add(poolEntryFuture);
                        if (!poolEntryFuture.await(date) && date != null && date.getTime() <= System.currentTimeMillis()) {
                            break;
                        }
                    } finally {
                        pool.unqueue(poolEntryFuture);
                        this.pending.remove(poolEntryFuture);
                    }
                } else {
                    throw new IllegalStateException("Connection pool shut down");
                }
            }
            throw new TimeoutException("Timeout waiting for connection");
        } finally {
            this.lock.unlock();
        }
    }

    private void notifyPending(RouteSpecificPool<T, C, E> routeSpecificPool) {
        PoolEntryFuture<E> nextPending = routeSpecificPool.nextPending();
        if (nextPending != null) {
            this.pending.remove(nextPending);
        } else {
            nextPending = this.pending.poll();
        }
        if (nextPending != null) {
            nextPending.wakeup();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void closeExpired() {
        long currentTimeMillis = System.currentTimeMillis();
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                if (next.isExpired(currentTimeMillis)) {
                    next.close();
                    RouteSpecificPool pool = getPool(next.getRoute());
                    pool.remove(next);
                    it.remove();
                    notifyPending(pool);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void closeIdle(long j3, TimeUnit timeUnit) {
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j3);
            if (millis < 0) {
                millis = 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - millis;
            this.lock.lock();
            try {
                Iterator<E> it = this.available.iterator();
                while (it.hasNext()) {
                    E next = it.next();
                    if (next.getUpdated() <= currentTimeMillis) {
                        next.close();
                        RouteSpecificPool pool = getPool(next.getRoute());
                        pool.remove(next);
                        it.remove();
                        notifyPending(pool);
                    }
                }
                return;
            } finally {
                this.lock.unlock();
            }
        }
        throw new IllegalArgumentException("Time unit must not be null.");
    }

    protected abstract E createEntry(T t16, C c16);

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public int getMaxPerRoute(T t16) {
        if (t16 != null) {
            this.lock.lock();
            try {
                return getMax(t16);
            } finally {
                this.lock.unlock();
            }
        }
        throw new IllegalArgumentException("Route may not be null");
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public PoolStats getStats(T t16) {
        if (t16 != null) {
            this.lock.lock();
            try {
                RouteSpecificPool<T, C, E> pool = getPool(t16);
                return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(t16));
            } finally {
                this.lock.unlock();
            }
        }
        throw new IllegalArgumentException("Route may not be null");
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPool
    public Future<E> lease(final T t16, final Object obj, FutureCallback<E> futureCallback) {
        if (t16 != null) {
            if (!this.isShutDown) {
                return new PoolEntryFuture<E>(this.lock, futureCallback) { // from class: com.tencent.component.network.utils.http.pool.AbstractConnPool.2
                    @Override // com.tencent.component.network.utils.http.pool.PoolEntryFuture
                    public E getPoolEntry(long j3, TimeUnit timeUnit) throws InterruptedException, TimeoutException, IOException {
                        return (E) AbstractConnPool.this.getPoolEntryBlocking(t16, obj, j3, timeUnit, this);
                    }
                };
            }
            throw new IllegalStateException("Connection pool shut down");
        }
        throw new IllegalArgumentException("Route may not be null");
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i3) {
        if (i3 > 0) {
            this.lock.lock();
            try {
                this.defaultMaxPerRoute = i3;
                return;
            } finally {
                this.lock.unlock();
            }
        }
        throw new IllegalArgumentException("Max value may not be negative or zero");
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public void setMaxPerRoute(T t16, int i3) {
        if (t16 != null) {
            if (i3 > 0) {
                this.lock.lock();
                try {
                    this.maxPerRoute.put(t16, Integer.valueOf(i3));
                    return;
                } finally {
                    this.lock.unlock();
                }
            }
            throw new IllegalArgumentException("Max value may not be negative or zero");
        }
        throw new IllegalArgumentException("Route may not be null");
    }

    @Override // com.tencent.component.network.utils.http.pool.ConnPoolControl
    public void setMaxTotal(int i3) {
        if (i3 > 0) {
            this.lock.lock();
            try {
                this.maxTotal = i3;
                return;
            } finally {
                this.lock.unlock();
            }
        }
        throw new IllegalArgumentException("Max value may not be negative or zero");
    }

    public void shutdown() throws IOException {
        if (this.isShutDown) {
            return;
        }
        this.isShutDown = true;
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            Iterator<E> it5 = this.leased.iterator();
            while (it5.hasNext()) {
                it5.next().close();
            }
            Iterator<RouteSpecificPool<T, C, E>> it6 = this.routeToPool.values().iterator();
            while (it6.hasNext()) {
                it6.next().shutdown();
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        return "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.component.network.utils.http.pool.ConnPool
    public void release(E e16, boolean z16) {
        this.lock.lock();
        try {
            if (this.leased.remove(e16)) {
                RouteSpecificPool pool = getPool(e16.getRoute());
                pool.free(e16, z16);
                if (z16 && !this.isShutDown) {
                    this.available.addFirst(e16);
                } else {
                    e16.close();
                }
                notifyPending(pool);
            }
        } finally {
            this.lock.unlock();
        }
    }

    public Future<E> lease(T t16, Object obj) {
        return lease(t16, obj, null);
    }
}
