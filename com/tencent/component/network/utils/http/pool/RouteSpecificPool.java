package com.tencent.component.network.utils.http.pool;

import com.tencent.component.network.utils.http.pool.PoolEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/* loaded from: classes5.dex */
abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>> {
    private final T route;
    private final Set<E> leased = new HashSet();
    private final LinkedList<E> available = new LinkedList<>();
    private final LinkedList<PoolEntryFuture<E>> pending = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public RouteSpecificPool(T t16) {
        this.route = t16;
    }

    public E add(C c16) {
        E createEntry = createEntry(c16);
        this.leased.add(createEntry);
        return createEntry;
    }

    protected abstract E createEntry(C c16);

    public void free(E e16, boolean z16) {
        if (e16 != null) {
            if (this.leased.remove(e16)) {
                if (z16) {
                    this.available.addFirst(e16);
                    return;
                }
                return;
            } else {
                throw new IllegalStateException("Entry " + e16 + " has not been leased from this pool");
            }
        }
        throw new IllegalArgumentException("Pool entry may not be null");
    }

    public int getAllocatedCount() {
        return this.available.size() + this.leased.size();
    }

    public int getAvailableCount() {
        return this.available.size();
    }

    public E getFree(Object obj) {
        if (!this.available.isEmpty()) {
            if (obj != null) {
                Iterator<E> it = this.available.iterator();
                while (it.hasNext()) {
                    E next = it.next();
                    if (obj.equals(next.getState())) {
                        it.remove();
                        this.leased.add(next);
                        return next;
                    }
                }
            }
            Iterator<E> it5 = this.available.iterator();
            while (it5.hasNext()) {
                E next2 = it5.next();
                if (next2.getState() == null) {
                    it5.remove();
                    this.leased.add(next2);
                    return next2;
                }
            }
            return null;
        }
        return null;
    }

    public E getLastUsed() {
        if (!this.available.isEmpty()) {
            return this.available.getLast();
        }
        return null;
    }

    public int getLeasedCount() {
        return this.leased.size();
    }

    public int getPendingCount() {
        return this.pending.size();
    }

    public final T getRoute() {
        return this.route;
    }

    public PoolEntryFuture<E> nextPending() {
        return this.pending.poll();
    }

    public void queue(PoolEntryFuture<E> poolEntryFuture) {
        if (poolEntryFuture == null) {
            return;
        }
        this.pending.add(poolEntryFuture);
    }

    public boolean remove(E e16) {
        if (e16 != null) {
            if (!this.available.remove(e16) && !this.leased.remove(e16)) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("Pool entry may not be null");
    }

    public void shutdown() {
        Iterator<PoolEntryFuture<E>> it = this.pending.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.pending.clear();
        Iterator<E> it5 = this.available.iterator();
        while (it5.hasNext()) {
            it5.next().close();
        }
        this.available.clear();
        Iterator<E> it6 = this.leased.iterator();
        while (it6.hasNext()) {
            it6.next().close();
        }
        this.leased.clear();
    }

    public String toString() {
        return "[route: " + this.route + "][leased: " + this.leased.size() + "][available: " + this.available.size() + "][pending: " + this.pending.size() + "]";
    }

    public void unqueue(PoolEntryFuture<E> poolEntryFuture) {
        if (poolEntryFuture == null) {
            return;
        }
        this.pending.remove(poolEntryFuture);
    }
}
