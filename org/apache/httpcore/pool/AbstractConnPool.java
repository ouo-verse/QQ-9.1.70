package org.apache.httpcore.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.concurrent.FutureCallback;
import org.apache.httpcore.pool.PoolEntry;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.Asserts;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes29.dex */
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final LinkedList<E> available;
    private final Condition condition;
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set<E> leased;
    private final Lock lock;
    private final Map<T, Integer> maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList<Future<E>> pending;
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
    private volatile int validateAfterInactivity;

    public AbstractConnPool(ConnFactory<T, C> connFactory, int i3, int i16) {
        this.connFactory = (ConnFactory) Args.notNull(connFactory, "Connection factory");
        this.defaultMaxPerRoute = Args.positive(i3, "Max per route value");
        this.maxTotal = Args.positive(i16, "Max total value");
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.routeToPool = new HashMap();
        this.leased = new HashSet();
        this.available = new LinkedList<>();
        this.pending = new LinkedList<>();
        this.maxPerRoute = new HashMap();
    }

    static /* synthetic */ Exception access$200() {
        return operationAborted();
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
            RouteSpecificPool<T, C, E> routeSpecificPool2 = (RouteSpecificPool<T, C, E>) new RouteSpecificPool<T, C, E>(t16) { // from class: org.apache.httpcore.pool.AbstractConnPool.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // org.apache.httpcore.pool.RouteSpecificPool
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
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0125, code lost:
    
        throw new java.util.concurrent.ExecutionException(operationAborted());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public E getPoolEntryBlocking(T t16, Object obj, long j3, TimeUnit timeUnit, Future<E> future) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        Date date;
        boolean z16;
        E e16;
        if (j3 > 0) {
            date = new Date(System.currentTimeMillis() + timeUnit.toMillis(j3));
        } else {
            date = null;
        }
        this.lock.lock();
        while (true) {
            try {
                boolean z17 = true;
                if (!this.isShutDown) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Asserts.check(z16, "Connection pool shut down");
                if (!future.isCancelled()) {
                    RouteSpecificPool pool = getPool(t16);
                    while (true) {
                        e16 = (E) pool.getFree(obj);
                        if (e16 == null) {
                            break;
                        }
                        if (e16.isExpired(System.currentTimeMillis())) {
                            e16.close();
                        }
                        if (!e16.isClosed()) {
                            break;
                        }
                        this.available.remove(e16);
                        pool.free(e16, false);
                    }
                    if (e16 != null) {
                        this.available.remove(e16);
                        this.leased.add(e16);
                        onReuse(e16);
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
                            if (this.available.size() > max3 - 1) {
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
                        pool.queue(future);
                        this.pending.add(future);
                        if (date != null) {
                            z17 = this.condition.awaitUntil(date);
                        } else {
                            this.condition.await();
                        }
                        if (future.isCancelled()) {
                            break;
                        }
                        if (!z17 && date != null && date.getTime() <= System.currentTimeMillis()) {
                            throw new TimeoutException("Timeout waiting for connection");
                        }
                    } finally {
                        pool.unqueue(future);
                        this.pending.remove(future);
                    }
                } else {
                    throw new ExecutionException(operationAborted());
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    private static Exception operationAborted() {
        return new CancellationException("Operation aborted");
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, RouteSpecificPool<T, C, E>>> it = this.routeToPool.entrySet().iterator();
        while (it.hasNext()) {
            RouteSpecificPool<T, C, E> value = it.next().getValue();
            if (value.getPendingCount() + value.getAllocatedCount() == 0) {
                it.remove();
            }
        }
    }

    public void closeExpired() {
        final long currentTimeMillis = System.currentTimeMillis();
        enumAvailable(new PoolEntryCallback<T, C>() { // from class: org.apache.httpcore.pool.AbstractConnPool.4
            @Override // org.apache.httpcore.pool.PoolEntryCallback
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.isExpired(currentTimeMillis)) {
                    poolEntry.close();
                }
            }
        });
    }

    public void closeIdle(long j3, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j3);
        if (millis < 0) {
            millis = 0;
        }
        final long currentTimeMillis = System.currentTimeMillis() - millis;
        enumAvailable(new PoolEntryCallback<T, C>() { // from class: org.apache.httpcore.pool.AbstractConnPool.3
            @Override // org.apache.httpcore.pool.PoolEntryCallback
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.getUpdated() <= currentTimeMillis) {
                    poolEntry.close();
                }
            }
        });
    }

    protected abstract E createEntry(T t16, C c16);

    protected void enumAvailable(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                poolEntryCallback.process(next);
                if (next.isClosed()) {
                    getPool(next.getRoute()).remove(next);
                    it.remove();
                }
            }
            purgePoolMap();
        } finally {
            this.lock.unlock();
        }
    }

    protected void enumLeased(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator<E> it = this.leased.iterator();
            while (it.hasNext()) {
                poolEntryCallback.process(it.next());
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.httpcore.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.httpcore.pool.ConnPoolControl
    public int getMaxPerRoute(T t16) {
        Args.notNull(t16, "Route");
        this.lock.lock();
        try {
            return getMax(t16);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.httpcore.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    public Set<T> getRoutes() {
        this.lock.lock();
        try {
            return new HashSet(this.routeToPool.keySet());
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.httpcore.pool.ConnPoolControl
    public PoolStats getStats(T t16) {
        Args.notNull(t16, "Route");
        this.lock.lock();
        try {
            RouteSpecificPool<T, C, E> pool = getPool(t16);
            return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(t16));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.httpcore.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    public int getValidateAfterInactivity() {
        return this.validateAfterInactivity;
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    @Override // org.apache.httpcore.pool.ConnPool
    public Future<E> lease(final T t16, final Object obj, final FutureCallback<E> futureCallback) {
        Args.notNull(t16, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return (Future<E>) new Future<E>() { // from class: org.apache.httpcore.pool.AbstractConnPool.2
            private final AtomicBoolean cancelled = new AtomicBoolean(false);
            private final AtomicBoolean done = new AtomicBoolean(false);
            private final AtomicReference<E> entryRef = new AtomicReference<>(null);

            @Override // java.util.concurrent.Future
            public boolean cancel(boolean z16) {
                if (!this.done.compareAndSet(false, true)) {
                    return false;
                }
                this.cancelled.set(true);
                AbstractConnPool.this.lock.lock();
                try {
                    AbstractConnPool.this.condition.signalAll();
                    AbstractConnPool.this.lock.unlock();
                    FutureCallback futureCallback2 = futureCallback;
                    if (futureCallback2 != null) {
                        futureCallback2.cancelled();
                    }
                    return true;
                } catch (Throwable th5) {
                    AbstractConnPool.this.lock.unlock();
                    throw th5;
                }
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return this.cancelled.get();
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                return this.done.get();
            }

            @Override // java.util.concurrent.Future
            public E get() throws InterruptedException, ExecutionException {
                try {
                    return (E) get(0L, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e16) {
                    throw new ExecutionException(e16);
                }
            }

            @Override // java.util.concurrent.Future
            public E get(long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                FutureCallback futureCallback2;
                E e16;
                while (true) {
                    synchronized (this) {
                        try {
                            E e17 = this.entryRef.get();
                            if (e17 != null) {
                                return e17;
                            }
                            if (!this.done.get()) {
                                e16 = (E) AbstractConnPool.this.getPoolEntryBlocking(t16, obj, j3, timeUnit, this);
                                if (AbstractConnPool.this.validateAfterInactivity <= 0 || e16.getUpdated() + AbstractConnPool.this.validateAfterInactivity > System.currentTimeMillis() || AbstractConnPool.this.validate(e16)) {
                                    break;
                                }
                                e16.close();
                                AbstractConnPool.this.release((AbstractConnPool) e16, false);
                            } else {
                                throw new ExecutionException(AbstractConnPool.access$200());
                            }
                        } catch (IOException e18) {
                            if (this.done.compareAndSet(false, true) && (futureCallback2 = futureCallback) != null) {
                                futureCallback2.failed(e18);
                            }
                            throw new ExecutionException(e18);
                        }
                    }
                }
                if (this.done.compareAndSet(false, true)) {
                    this.entryRef.set(e16);
                    this.done.set(true);
                    AbstractConnPool.this.onLease(e16);
                    FutureCallback futureCallback3 = futureCallback;
                    if (futureCallback3 != null) {
                        futureCallback3.completed(e16);
                    }
                    return e16;
                }
                AbstractConnPool.this.release((AbstractConnPool) e16, true);
                throw new ExecutionException(AbstractConnPool.access$200());
            }
        };
    }

    @Override // org.apache.httpcore.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i3) {
        Args.positive(i3, "Max per route value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i3;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.httpcore.pool.ConnPoolControl
    public void setMaxPerRoute(T t16, int i3) {
        Args.notNull(t16, "Route");
        this.lock.lock();
        try {
            if (i3 > -1) {
                this.maxPerRoute.put(t16, Integer.valueOf(i3));
            } else {
                this.maxPerRoute.remove(t16);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // org.apache.httpcore.pool.ConnPoolControl
    public void setMaxTotal(int i3) {
        Args.positive(i3, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = i3;
        } finally {
            this.lock.unlock();
        }
    }

    public void setValidateAfterInactivity(int i3) {
        this.validateAfterInactivity = i3;
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
        this.lock.lock();
        try {
            return "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";
        } finally {
            this.lock.unlock();
        }
    }

    protected boolean validate(E e16) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.httpcore.pool.ConnPool
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
                onRelease(e16);
                Future<E> nextPending = pool.nextPending();
                if (nextPending != null) {
                    this.pending.remove(nextPending);
                } else {
                    nextPending = this.pending.poll();
                }
                if (nextPending != null) {
                    this.condition.signalAll();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public Future<E> lease(T t16, Object obj) {
        return lease(t16, obj, null);
    }

    protected void onLease(E e16) {
    }

    protected void onRelease(E e16) {
    }

    protected void onReuse(E e16) {
    }
}
