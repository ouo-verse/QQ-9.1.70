package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LimitQueue<E> extends ConcurrentLinkedQueue<E> {
    private static final String TAG = "LimitQueue";
    private static final long serialVersionUID = -4636313759149307798L;
    private boolean deduplication;
    private int limit;

    public LimitQueue(int i3) {
        this.deduplication = false;
        this.limit = i3;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e16) {
        if (this.deduplication) {
            super.remove(e16);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.add(e16);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() > this.limit) {
            return false;
        }
        if (this.deduplication) {
            super.removeAll(collection);
        }
        for (int size = (collection.size() + super.size()) - this.limit; size > 0; size--) {
            super.poll();
        }
        return super.addAll(collection);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        super.clear();
    }

    public E get(int i3) {
        Iterator<E> it = iterator();
        E e16 = null;
        for (int i16 = 0; i16 <= i3 && it.hasNext(); i16++) {
            e16 = it.next();
        }
        return e16;
    }

    public int getLimit() {
        return this.limit;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public boolean offer(E e16) {
        if (this.deduplication) {
            super.remove(e16);
        }
        if (super.size() >= this.limit) {
            super.poll();
        }
        return super.offer(e16);
    }

    public E peekLast() {
        Iterator<E> it = iterator();
        E e16 = null;
        while (it.hasNext()) {
            e16 = it.next();
        }
        return e16;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public E poll() {
        return (E) super.poll();
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        try {
            return (E) super.remove();
        } catch (NoSuchElementException unused) {
            Logger.w(TAG, "remove failed, limitQueue is empty");
            return null;
        }
    }

    public LimitQueue(int i3, boolean z16) {
        this.limit = i3;
        this.deduplication = z16;
    }

    public LimitQueue(Collection<? extends E> collection, boolean z16) {
        this(collection.size(), z16);
        addAll(collection);
    }
}
