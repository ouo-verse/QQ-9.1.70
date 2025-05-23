package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface BlockingDeque<E> extends BlockingQueue<E>, Deque<E> {
    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean add(E e16);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    void addFirst(E e16);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    void addLast(E e16);

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean contains(Object obj);

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E element();

    @Override // java.util.Collection, java.lang.Iterable, com.nostra13.universalimageloader.core.assist.deque.Deque
    Iterator<E> iterator();

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean offer(E e16);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e16, long j3, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean offerFirst(E e16);

    boolean offerFirst(E e16, long j3, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean offerLast(E e16);

    boolean offerLast(E e16, long j3, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E peek();

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j3, TimeUnit timeUnit) throws InterruptedException;

    E pollFirst(long j3, TimeUnit timeUnit) throws InterruptedException;

    E pollLast(long j3, TimeUnit timeUnit) throws InterruptedException;

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    void push(E e16);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e16) throws InterruptedException;

    void putFirst(E e16) throws InterruptedException;

    void putLast(E e16) throws InterruptedException;

    @Override // java.util.Queue, com.nostra13.universalimageloader.core.assist.deque.Deque
    E remove();

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean remove(Object obj);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // com.nostra13.universalimageloader.core.assist.deque.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection, com.nostra13.universalimageloader.core.assist.deque.Deque
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws InterruptedException;

    E takeFirst() throws InterruptedException;

    E takeLast() throws InterruptedException;
}
