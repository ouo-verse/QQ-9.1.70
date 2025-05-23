package android.support.v4.util;

/* compiled from: P */
/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public SparseArrayCompat() {
        this(10);
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
                    objArr[i17] = null;
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
        if (i17 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i17 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = iArr;
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
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
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

    public E get(int i3) {
        return get(i3, null);
    }

    public int indexOfKey(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
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
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
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
            i16 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
        }
        int i18 = this.mSize;
        if (i18 >= this.mKeys.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i18 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = this.mKeys;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = iArr;
            this.mValues = objArr2;
        }
        int i19 = this.mSize;
        if (i19 - i16 != 0) {
            int[] iArr3 = this.mKeys;
            int i26 = i16 + 1;
            System.arraycopy(iArr3, i16, iArr3, i26, i19 - i16);
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

    public void removeAt(int i3) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i3];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i3] = obj2;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int i3, int i16) {
        int min = Math.min(this.mSize, i16 + i3);
        while (i3 < min) {
            removeAt(i3);
            i3++;
        }
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

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb5 = new StringBuilder(this.mSize * 28);
        sb5.append('{');
        for (int i3 = 0; i3 < this.mSize; i3++) {
            if (i3 > 0) {
                sb5.append(", ");
            }
            sb5.append(keyAt(i3));
            sb5.append('=');
            E valueAt = valueAt(i3);
            if (valueAt != this) {
                sb5.append(valueAt);
            } else {
                sb5.append("(this Map)");
            }
        }
        sb5.append('}');
        return sb5.toString();
    }

    public E valueAt(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i3];
    }

    public SparseArrayCompat(int i3) {
        this.mGarbage = false;
        if (i3 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3);
            this.mKeys = new int[idealIntArraySize];
            this.mValues = new Object[idealIntArraySize];
        }
        this.mSize = 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m1clone() {
        SparseArrayCompat<E> sparseArrayCompat;
        SparseArrayCompat<E> sparseArrayCompat2 = null;
        try {
            sparseArrayCompat = (SparseArrayCompat) super.clone();
        } catch (CloneNotSupportedException unused) {
        }
        try {
            sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
            sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException unused2) {
            sparseArrayCompat2 = sparseArrayCompat;
            return sparseArrayCompat2;
        }
    }

    public E get(int i3, E e16) {
        E e17;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i3);
        return (binarySearch < 0 || (e17 = (E) this.mValues[binarySearch]) == DELETED) ? e16 : e17;
    }
}
