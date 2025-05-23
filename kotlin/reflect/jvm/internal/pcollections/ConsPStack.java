package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes28.dex */
final class ConsPStack<E> implements Iterable<E> {
    private static final ConsPStack<Object> EMPTY = new ConsPStack<>();
    final E first;
    final ConsPStack<E> rest;
    private final int size;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public static class Itr<E> implements Iterator<E> {
        private ConsPStack<E> next;

        public Itr(ConsPStack<E> consPStack) {
            this.next = consPStack;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (((ConsPStack) this.next).size > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            ConsPStack<E> consPStack = this.next;
            E e16 = consPStack.first;
            this.next = consPStack.rest;
            return e16;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    ConsPStack() {
        this.size = 0;
        this.first = null;
        this.rest = null;
    }

    public static <E> ConsPStack<E> empty() {
        return (ConsPStack<E>) EMPTY;
    }

    private ConsPStack<E> minus(Object obj) {
        if (this.size == 0) {
            return this;
        }
        if (this.first.equals(obj)) {
            return this.rest;
        }
        ConsPStack<E> minus = this.rest.minus(obj);
        return minus == this.rest ? this : new ConsPStack<>(this.first, minus);
    }

    private ConsPStack<E> subList(int i3) {
        if (i3 >= 0 && i3 <= this.size) {
            if (i3 == 0) {
                return this;
            }
            return this.rest.subList(i3 - 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public E get(int i3) {
        if (i3 >= 0 && i3 <= this.size) {
            try {
                return iterator(i3).next();
            } catch (NoSuchElementException unused) {
                throw new IndexOutOfBoundsException("Index: " + i3);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return iterator(0);
    }

    public ConsPStack<E> plus(E e16) {
        return new ConsPStack<>(e16, this);
    }

    public int size() {
        return this.size;
    }

    private Iterator<E> iterator(int i3) {
        return new Itr(subList(i3));
    }

    ConsPStack(E e16, ConsPStack<E> consPStack) {
        this.first = e16;
        this.rest = consPStack;
        this.size = consPStack.size + 1;
    }

    public ConsPStack<E> minus(int i3) {
        return minus(get(i3));
    }
}
