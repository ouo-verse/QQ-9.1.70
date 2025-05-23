package androidx.collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    private void doubleCapacity() {
        int[] iArr = this.mElements;
        int length = iArr.length;
        int i3 = this.mHead;
        int i16 = length - i3;
        int i17 = length << 1;
        if (i17 >= 0) {
            int[] iArr2 = new int[i17];
            System.arraycopy(iArr, i3, iArr2, 0, i16);
            System.arraycopy(this.mElements, 0, iArr2, i16, this.mHead);
            this.mElements = iArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i17 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(int i3) {
        int i16 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i16;
        this.mElements[i16] = i3;
        if (i16 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int i3) {
        int[] iArr = this.mElements;
        int i16 = this.mTail;
        iArr[i16] = i3;
        int i17 = this.mCapacityBitmask & (i16 + 1);
        this.mTail = i17;
        if (i17 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int i3) {
        if (i3 >= 0 && i3 < size()) {
            return this.mElements[this.mCapacityBitmask & (this.mHead + i3)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        int i3 = this.mHead;
        if (i3 != this.mTail) {
            return this.mElements[i3];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
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

    public int popFirst() {
        int i3 = this.mHead;
        if (i3 != this.mTail) {
            int i16 = this.mElements[i3];
            this.mHead = (i3 + 1) & this.mCapacityBitmask;
            return i16;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i3 = this.mHead;
        int i16 = this.mTail;
        if (i3 != i16) {
            int i17 = this.mCapacityBitmask & (i16 - 1);
            int i18 = this.mElements[i17];
            this.mTail = i17;
            return i18;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (i3 <= size()) {
            this.mTail = this.mCapacityBitmask & (this.mTail - i3);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i3) {
        if (i3 <= 0) {
            return;
        }
        if (i3 <= size()) {
            this.mHead = this.mCapacityBitmask & (this.mHead + i3);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularIntArray(int i3) {
        if (i3 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i3 <= 1073741824) {
            i3 = Integer.bitCount(i3) != 1 ? Integer.highestOneBit(i3 - 1) << 1 : i3;
            this.mCapacityBitmask = i3 - 1;
            this.mElements = new int[i3];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
