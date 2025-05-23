package org.apache.httpcore.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;
import org.apache.httpcore.pool.PoolEntry;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.Asserts;

/* loaded from: classes29.dex */
abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>> {
    private final T route;
    private final Set<E> leased = new HashSet();
    private final LinkedList<E> available = new LinkedList<>();
    private final LinkedList<Future<E>> pending = new LinkedList<>();

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
        Args.notNull(e16, "Pool entry");
        Asserts.check(this.leased.remove(e16), "Entry %s has not been leased from this pool", e16);
        if (z16) {
            this.available.addFirst(e16);
        }
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
        if (this.available.isEmpty()) {
            return null;
        }
        return this.available.getLast();
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

    public Future<E> nextPending() {
        return this.pending.poll();
    }

    public void queue(Future<E> future) {
        if (future == null) {
            return;
        }
        this.pending.add(future);
    }

    public boolean remove(E e16) {
        Args.notNull(e16, "Pool entry");
        if (!this.available.remove(e16) && !this.leased.remove(e16)) {
            return false;
        }
        return true;
    }

    public void shutdown() {
        Iterator<Future<E>> it = this.pending.iterator();
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

    public void unqueue(Future<E> future) {
        if (future == null) {
            return;
        }
        this.pending.remove(future);
    }
}
