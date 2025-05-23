package org.apache.httpcore.protocol;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
final class ChainBuilder<E> {
    private final LinkedList<E> list = new LinkedList<>();
    private final Map<Class<?>, E> uniqueClasses = new HashMap();

    private void ensureUnique(E e16) {
        E remove = this.uniqueClasses.remove(e16.getClass());
        if (remove != null) {
            this.list.remove(remove);
        }
        this.uniqueClasses.put(e16.getClass(), e16);
    }

    public ChainBuilder<E> addAllFirst(Collection<E> collection) {
        if (collection == null) {
            return this;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            addFirst(it.next());
        }
        return this;
    }

    public ChainBuilder<E> addAllLast(Collection<E> collection) {
        if (collection == null) {
            return this;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            addLast(it.next());
        }
        return this;
    }

    public ChainBuilder<E> addFirst(E e16) {
        if (e16 == null) {
            return this;
        }
        ensureUnique(e16);
        this.list.addFirst(e16);
        return this;
    }

    public ChainBuilder<E> addLast(E e16) {
        if (e16 == null) {
            return this;
        }
        ensureUnique(e16);
        this.list.addLast(e16);
        return this;
    }

    public LinkedList<E> build() {
        return new LinkedList<>(this.list);
    }

    public ChainBuilder<E> addAllFirst(E... eArr) {
        if (eArr == null) {
            return this;
        }
        for (E e16 : eArr) {
            addFirst(e16);
        }
        return this;
    }

    public ChainBuilder<E> addAllLast(E... eArr) {
        if (eArr == null) {
            return this;
        }
        for (E e16 : eArr) {
            addLast(e16);
        }
        return this;
    }
}
