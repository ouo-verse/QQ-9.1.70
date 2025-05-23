package androidx.collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    private void doubleCapacity() {
        E[] eArr = this.mElements;
        int length = eArr.length;
        int i3 = this.mHead;
        int i16 = length - i3;
        int i17 = length << 1;
        if (i17 >= 0) {
            E[] eArr2 = (E[]) new Object[i17];
            System.arraycopy(eArr, i3, eArr2, 0, i16);
            System.arraycopy(this.mElements, 0, eArr2, i16, this.mHead);
            this.mElements = eArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i17 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E e16) {
        int i3 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i3;
        this.mElements[i3] = e16;
        if (i3 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(E e16) {
        E[] eArr = this.mElements;
        int i3 = this.mTail;
        eArr[i3] = e16;
        int i16 = this.mCapacityBitmask & (i3 + 1);
        this.mTail = i16;
        if (i16 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i3) {
        if (i3 >= 0 && i3 < size()) {
            return this.mElements[this.mCapacityBitmask & (this.mHead + i3)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getFirst() {
        int i3 = this.mHead;
        if (i3 != this.mTail) {
            return this.mElements[i3];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int i3 = this.mHead;
        int i16 = this.mTail;
        if (i3 != i16) {
            return this.mElements[(i16 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        if (this.mHead == this.mTail) {
            return true;
        }
        return false;
    }

    public E popFirst() {
        int i3 = this.mHead;
        if (i3 != this.mTail) {
            E[] eArr = this.mElements;
            E e16 = eArr[i3];
            eArr[i3] = null;
            this.mHead = (i3 + 1) & this.mCapacityBitmask;
            return e16;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int i3 = this.mHead;
        int i16 = this.mTail;
        if (i3 != i16) {
            int i17 = this.mCapacityBitmask & (i16 - 1);
            E[] eArr = this.mElements;
            E e16 = eArr[i17];
            eArr[i17] = null;
            this.mTail = i17;
            return e16;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i3) {
        int i16;
        int i17;
        if (i3 <= 0) {
            return;
        }
        if (i3 <= size()) {
            int i18 = this.mTail;
            if (i3 < i18) {
                i16 = i18 - i3;
            } else {
                i16 = 0;
            }
            int i19 = i16;
            while (true) {
                i17 = this.mTail;
                if (i19 >= i17) {
                    break;
                }
                this.mElements[i19] = null;
                i19++;
            }
            int i26 = i17 - i16;
            int i27 = i3 - i26;
            this.mTail = i17 - i26;
            if (i27 > 0) {
                int length = this.mElements.length;
                this.mTail = length;
                int i28 = length - i27;
                for (int i29 = i28; i29 < this.mTail; i29++) {
                    this.mElements[i29] = null;
                }
                this.mTail = i28;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (i3 <= size()) {
            int length = this.mElements.length;
            int i16 = this.mHead;
            if (i3 < length - i16) {
                length = i16 + i3;
            }
            while (i16 < length) {
                this.mElements[i16] = null;
                i16++;
            }
            int i17 = this.mHead;
            int i18 = length - i17;
            int i19 = i3 - i18;
            this.mHead = this.mCapacityBitmask & (i17 + i18);
            if (i19 > 0) {
                for (int i26 = 0; i26 < i19; i26++) {
                    this.mElements[i26] = null;
                }
                this.mHead = i19;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularArray(int i3) {
        if (i3 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i3 <= 1073741824) {
            i3 = Integer.bitCount(i3) != 1 ? Integer.highestOneBit(i3 - 1) << 1 : i3;
            this.mCapacityBitmask = i3 - 1;
            this.mElements = (E[]) new Object[i3];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
