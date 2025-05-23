package org.jf.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SparseArray<E> {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArray() {
        this(10);
    }

    private static int binarySearch(int[] iArr, int i3, int i16, int i17) {
        int i18 = i16 + i3;
        int i19 = i3 - 1;
        int i26 = i18;
        while (i26 - i19 > 1) {
            int i27 = (i26 + i19) / 2;
            if (iArr[i27] < i17) {
                i19 = i27;
            } else {
                i26 = i27;
            }
        }
        if (i26 == i18) {
            return ~i18;
        }
        if (iArr[i26] == i17) {
            return i26;
        }
        return ~i26;
    }

    private void gc() {
        int i3 = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            Object obj = objArr[i17];
            if (obj != DELETED) {
                if (i17 != i16) {
                    iArr[i16] = iArr[i17];
                    objArr[i16] = obj;
                }
                i16++;
            }
        }
        this.mGarbage = false;
        this.mSize = i16;
    }

    public void append(int i3, E e16) {
        int i16 = this.mSize;
        if (i16 != 0 && i3 <= this.mKeys[i16 - 1]) {
            put(i3, e16);
            return;
        }
        if (this.mGarbage && i16 >= this.mKeys.length) {
            gc();
        }
        int i17 = this.mSize;
        int[] iArr = this.mKeys;
        if (i17 >= iArr.length) {
            int max = Math.max(i17 + 1, iArr.length * 2);
            int[] iArr2 = new int[max];
            Object[] objArr = new Object[max];
            int[] iArr3 = this.mKeys;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr2;
            this.mValues = objArr;
        }
        this.mKeys[i17] = i3;
        this.mValues[i17] = e16;
        this.mSize = i17 + 1;
    }

    public void clear() {
        int i3 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i16 = 0; i16 < i3; i16++) {
            objArr[i16] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void delete(int i3) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i3);
        if (binarySearch >= 0) {
            Object[] objArr = this.mValues;
            Object obj = objArr[binarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[binarySearch] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public void ensureCapacity(int i3) {
        if (this.mGarbage && this.mSize >= this.mKeys.length) {
            gc();
        }
        int[] iArr = this.mKeys;
        if (iArr.length < i3) {
            int[] iArr2 = new int[i3];
            Object[] objArr = new Object[i3];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr2;
            this.mValues = objArr;
        }
    }

    public E get(int i3) {
        return get(i3, null);
    }

    public List<E> getValues() {
        return Collections.unmodifiableList(Arrays.asList(this.mValues));
    }

    public int indexOfKey(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return binarySearch(this.mKeys, 0, this.mSize, i3);
    }

    public int indexOfValue(E e16) {
        if (this.mGarbage) {
            gc();
        }
        for (int i3 = 0; i3 < this.mSize; i3++) {
            if (this.mValues[i3] == e16) {
                return i3;
            }
        }
        return -1;
    }

    public int keyAt(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i3];
    }

    public void put(int i3, E e16) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i3);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e16;
            return;
        }
        int i16 = ~binarySearch;
        int i17 = this.mSize;
        if (i16 < i17) {
            Object[] objArr = this.mValues;
            if (objArr[i16] == DELETED) {
                this.mKeys[i16] = i3;
                objArr[i16] = e16;
                return;
            }
        }
        if (this.mGarbage && i17 >= this.mKeys.length) {
            gc();
            i16 = ~binarySearch(this.mKeys, 0, this.mSize, i3);
        }
        int i18 = this.mSize;
        int[] iArr = this.mKeys;
        if (i18 >= iArr.length) {
            int max = Math.max(i18 + 1, iArr.length * 2);
            int[] iArr2 = new int[max];
            Object[] objArr2 = new Object[max];
            int[] iArr3 = this.mKeys;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr2;
            this.mValues = objArr2;
        }
        int i19 = this.mSize;
        if (i19 - i16 != 0) {
            int[] iArr4 = this.mKeys;
            int i26 = i16 + 1;
            System.arraycopy(iArr4, i16, iArr4, i26, i19 - i16);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i16, objArr4, i26, this.mSize - i16);
        }
        this.mKeys[i16] = i3;
        this.mValues[i16] = e16;
        this.mSize++;
    }

    public void remove(int i3) {
        delete(i3);
    }

    public void setValueAt(int i3, E e16) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i3] = e16;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public E valueAt(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i3];
    }

    public SparseArray(int i3) {
        this.mGarbage = false;
        this.mKeys = new int[i3];
        this.mValues = new Object[i3];
        this.mSize = 0;
    }

    public E get(int i3, E e16) {
        E e17;
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i3);
        return (binarySearch < 0 || (e17 = (E) this.mValues[binarySearch]) == DELETED) ? e16 : e17;
    }
}
