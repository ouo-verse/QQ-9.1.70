package com.tencent.component.network.utils.thread.internel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 2340985798034038923L;
    private transient Object[] elements;
    private transient int head;
    private transient int tail;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class DeqIterator implements Iterator<E> {
        private int cursor;
        private int fence;
        private int lastRet;

        DeqIterator() {
            this.cursor = ArrayDeque.this.head;
            this.fence = ArrayDeque.this.tail;
            this.lastRet = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.cursor != this.fence) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.cursor != this.fence) {
                E e16 = (E) ArrayDeque.this.elements[this.cursor];
                if (ArrayDeque.this.tail == this.fence && e16 != null) {
                    int i3 = this.cursor;
                    this.lastRet = i3;
                    this.cursor = (i3 + 1) & (ArrayDeque.this.elements.length - 1);
                    return e16;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            int i3 = this.lastRet;
            if (i3 >= 0) {
                if (ArrayDeque.this.delete(i3)) {
                    this.cursor = (this.cursor - 1) & (ArrayDeque.this.elements.length - 1);
                    this.fence = ArrayDeque.this.tail;
                }
                this.lastRet = -1;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class DescendingIterator implements Iterator<E> {
        private int cursor;
        private int fence;
        private int lastRet;

        DescendingIterator() {
            this.cursor = ArrayDeque.this.tail;
            this.fence = ArrayDeque.this.head;
            this.lastRet = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.cursor != this.fence) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            int i3 = this.cursor;
            if (i3 != this.fence) {
                this.cursor = (i3 - 1) & (ArrayDeque.this.elements.length - 1);
                E e16 = (E) ArrayDeque.this.elements[this.cursor];
                if (ArrayDeque.this.head == this.fence && e16 != null) {
                    this.lastRet = this.cursor;
                    return e16;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            int i3 = this.lastRet;
            if (i3 >= 0) {
                if (!ArrayDeque.this.delete(i3)) {
                    this.cursor = (this.cursor + 1) & (ArrayDeque.this.elements.length - 1);
                    this.fence = ArrayDeque.this.head;
                }
                this.lastRet = -1;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public ArrayDeque() {
        this.elements = new Object[16];
    }

    private void allocateElements(int i3) {
        int i16 = 8;
        if (i3 >= 8) {
            int i17 = i3 | (i3 >>> 1);
            int i18 = i17 | (i17 >>> 2);
            int i19 = i18 | (i18 >>> 4);
            int i26 = i19 | (i19 >>> 8);
            i16 = (i26 | (i26 >>> 16)) + 1;
            if (i16 < 0) {
                i16 >>>= 1;
            }
        }
        this.elements = new Object[i16];
    }

    private <T> T[] copyElements(T[] tArr) {
        int i3 = this.head;
        int i16 = this.tail;
        if (i3 < i16) {
            System.arraycopy(this.elements, i3, tArr, 0, size());
        } else if (i3 > i16) {
            Object[] objArr = this.elements;
            int length = objArr.length - i3;
            System.arraycopy(objArr, i3, tArr, 0, length);
            System.arraycopy(this.elements, 0, tArr, length, this.tail);
        }
        return tArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean delete(int i3) {
        checkInvariants();
        Object[] objArr = this.elements;
        int length = objArr.length - 1;
        int i16 = this.head;
        int i17 = this.tail;
        int i18 = (i3 - i16) & length;
        int i19 = (i17 - i3) & length;
        if (i18 < ((i17 - i16) & length)) {
            if (i18 < i19) {
                if (i16 <= i3) {
                    System.arraycopy(objArr, i16, objArr, i16 + 1, i18);
                } else {
                    System.arraycopy(objArr, 0, objArr, 1, i3);
                    objArr[0] = objArr[length];
                    System.arraycopy(objArr, i16, objArr, i16 + 1, length - i16);
                }
                objArr[i16] = null;
                this.head = (i16 + 1) & length;
                return false;
            }
            if (i3 < i17) {
                System.arraycopy(objArr, i3 + 1, objArr, i3, i19);
                this.tail = i17 - 1;
            } else {
                System.arraycopy(objArr, i3 + 1, objArr, i3, length - i3);
                objArr[length] = objArr[0];
                System.arraycopy(objArr, 1, objArr, 0, i17);
                this.tail = (i17 - 1) & length;
            }
            return true;
        }
        throw new ConcurrentModificationException();
    }

    private void doubleCapacity() {
        int i3 = this.head;
        Object[] objArr = this.elements;
        int length = objArr.length;
        int i16 = length - i3;
        int i17 = length << 1;
        if (i17 >= 0) {
            Object[] objArr2 = new Object[i17];
            System.arraycopy(objArr, i3, objArr2, 0, i16);
            System.arraycopy(this.elements, 0, objArr2, i16, i3);
            this.elements = objArr2;
            this.head = 0;
            this.tail = length;
            return;
        }
        throw new IllegalStateException("Sorry, deque too big");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        allocateElements(readInt);
        this.head = 0;
        this.tail = readInt;
        for (int i3 = 0; i3 < readInt; i3++) {
            this.elements[i3] = objectInputStream.readObject();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        int length = this.elements.length - 1;
        for (int i3 = this.head; i3 != this.tail; i3 = (i3 + 1) & length) {
            objectOutputStream.writeObject(this.elements[i3]);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.tencent.component.network.utils.thread.internel.Deque, java.util.Queue
    public boolean add(E e16) {
        addLast(e16);
        return true;
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public void addFirst(E e16) {
        if (e16 != null) {
            Object[] objArr = this.elements;
            int length = (this.head - 1) & (objArr.length - 1);
            this.head = length;
            objArr[length] = e16;
            if (length == this.tail) {
                doubleCapacity();
                return;
            }
            return;
        }
        throw new NullPointerException("e == null");
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public void addLast(E e16) {
        if (e16 != null) {
            Object[] objArr = this.elements;
            int i3 = this.tail;
            objArr[i3] = e16;
            int length = (objArr.length - 1) & (i3 + 1);
            this.tail = length;
            if (length == this.head) {
                doubleCapacity();
                return;
            }
            return;
        }
        throw new NullPointerException("e == null");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int i3 = this.head;
        int i16 = this.tail;
        if (i3 != i16) {
            this.tail = 0;
            this.head = 0;
            int length = this.elements.length - 1;
            do {
                this.elements[i3] = null;
                i3 = (i3 + 1) & length;
            } while (i3 != i16);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.tencent.component.network.utils.thread.internel.Deque
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.elements.length - 1;
        int i3 = this.head;
        while (true) {
            Object obj2 = this.elements[i3];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                return true;
            }
            i3 = (i3 + 1) & length;
        }
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque, java.util.Queue
    public E element() {
        return getFirst();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public E getFirst() {
        E e16 = (E) this.elements[this.head];
        if (e16 != null) {
            return e16;
        }
        throw new NoSuchElementException();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public E getLast() {
        E e16 = (E) this.elements[(this.tail - 1) & (r0.length - 1)];
        if (e16 != null) {
            return e16;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (this.head == this.tail) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.tencent.component.network.utils.thread.internel.Deque
    public Iterator<E> iterator() {
        return new DeqIterator();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque, java.util.Queue
    public boolean offer(E e16) {
        return offerLast(e16);
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public boolean offerFirst(E e16) {
        addFirst(e16);
        return true;
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public boolean offerLast(E e16) {
        addLast(e16);
        return true;
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque, java.util.Queue
    public E peek() {
        return peekFirst();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public E peekFirst() {
        return (E) this.elements[this.head];
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public E peekLast() {
        return (E) this.elements[(this.tail - 1) & (r0.length - 1)];
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque, java.util.Queue
    public E poll() {
        return pollFirst();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public E pollFirst() {
        int i3 = this.head;
        Object[] objArr = this.elements;
        E e16 = (E) objArr[i3];
        if (e16 == null) {
            return null;
        }
        objArr[i3] = null;
        this.head = (i3 + 1) & (objArr.length - 1);
        return e16;
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public E pollLast() {
        int i3 = this.tail - 1;
        Object[] objArr = this.elements;
        int length = i3 & (objArr.length - 1);
        E e16 = (E) objArr[length];
        if (e16 == null) {
            return null;
        }
        objArr[length] = null;
        this.tail = length;
        return e16;
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public void push(E e16) {
        addFirst(e16);
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.elements.length - 1;
        int i3 = this.head;
        while (true) {
            Object obj2 = this.elements[i3];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                delete(i3);
                return true;
            }
            i3 = (i3 + 1) & length;
        }
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    @Override // com.tencent.component.network.utils.thread.internel.Deque
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.elements.length - 1;
        int i3 = this.tail - 1;
        while (true) {
            int i16 = i3 & length;
            Object obj2 = this.elements[i16];
            if (obj2 == null) {
                return false;
            }
            if (obj.equals(obj2)) {
                delete(i16);
                return true;
            }
            i3 = i16 - 1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.tencent.component.network.utils.thread.internel.Deque
    public int size() {
        return (this.tail - this.head) & (this.elements.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return copyElements(new Object[size()]);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ArrayDeque<E> m108clone() {
        try {
            ArrayDeque<E> arrayDeque = (ArrayDeque) super.clone();
            Object[] objArr = this.elements;
            arrayDeque.elements = Arrays.copyOf(objArr, objArr.length);
            return arrayDeque;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.tencent.component.network.utils.thread.internel.Deque
    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        copyElements(tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public ArrayDeque(int i3) {
        allocateElements(i3);
    }

    public ArrayDeque(Collection<? extends E> collection) {
        allocateElements(collection.size());
        addAll(collection);
    }

    private void checkInvariants() {
    }
}
