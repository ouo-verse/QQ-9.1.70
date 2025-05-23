package com.tencent.component.network.utils.thread.internel;

import java.util.Iterator;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface Deque<E> extends Queue<E> {
    @Override // java.util.Collection, com.tencent.component.network.utils.thread.internel.Deque, java.util.Queue
    boolean add(E e16);

    void addFirst(E e16);

    void addLast(E e16);

    boolean contains(Object obj);

    Iterator<E> descendingIterator();

    @Override // java.util.Queue
    E element();

    E getFirst();

    E getLast();

    Iterator<E> iterator();

    @Override // java.util.Queue
    boolean offer(E e16);

    boolean offerFirst(E e16);

    boolean offerLast(E e16);

    @Override // java.util.Queue
    E peek();

    E peekFirst();

    E peekLast();

    @Override // java.util.Queue
    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E e16);

    @Override // java.util.Queue
    E remove();

    boolean remove(Object obj);

    E removeFirst();

    boolean removeFirstOccurrence(Object obj);

    E removeLast();

    boolean removeLastOccurrence(Object obj);

    int size();
}
