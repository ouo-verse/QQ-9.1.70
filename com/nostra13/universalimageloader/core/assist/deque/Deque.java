package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface Deque<E> extends Queue<E> {
    boolean add(E e16);

    void addFirst(E e16);

    void addLast(E e16);

    boolean contains(Object obj);

    Iterator<E> descendingIterator();

    E element();

    E getFirst();

    E getLast();

    Iterator<E> iterator();

    boolean offer(E e16);

    boolean offerFirst(E e16);

    boolean offerLast(E e16);

    E peek();

    E peekFirst();

    E peekLast();

    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E e16);

    E remove();

    boolean remove(Object obj);

    E removeFirst();

    boolean removeFirstOccurrence(Object obj);

    E removeLast();

    boolean removeLastOccurrence(Object obj);

    int size();
}
