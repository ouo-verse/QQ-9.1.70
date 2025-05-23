package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    private void gc() {
        int i3 = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            Object obj = objArr[i17];
            if (obj != DELETED) {
                if (i17 != i16) {
                    jArr[i16] = jArr[i17];
                    objArr[i16] = obj;
                    objArr[i17] = null;
                }
                i16++;
            }
        }
        this.mGarbage = false;
        this.mSize = i16;
    }

    public void append(long j3, E e16) {
        int i3 = this.mSize;
        if (i3 != 0 && j3 <= this.mKeys[i3 - 1]) {
            put(j3, e16);
            return;
        }
        if (this.mGarbage && i3 >= this.mKeys.length) {
            gc();
        }
        int i16 = this.mSize;
        if (i16 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i16 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.mValues;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.mKeys = jArr;
            this.mValues = objArr;
        }
        this.mKeys[i16] = j3;
        this.mValues[i16] = e16;
        this.mSize = i16 + 1;
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

    public boolean containsKey(long j3) {
        if (indexOfKey(j3) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(E e16) {
        if (indexOfValue(e16) >= 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public void delete(long j3) {
        remove(j3);
    }

    @Nullable
    public E get(long j3) {
        return get(j3, null);
    }

    public int indexOfKey(long j3) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j3);
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

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public long keyAt(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i3];
    }

    public void put(long j3, E e16) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j3);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e16;
            return;
        }
        int i3 = ~binarySearch;
        int i16 = this.mSize;
        if (i3 < i16) {
            Object[] objArr = this.mValues;
            if (objArr[i3] == DELETED) {
                this.mKeys[i3] = j3;
                objArr[i3] = e16;
                return;
            }
        }
        if (this.mGarbage && i16 >= this.mKeys.length) {
            gc();
            i3 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, j3);
        }
        int i17 = this.mSize;
        if (i17 >= this.mKeys.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i17 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr2 = new Object[idealLongArraySize];
            long[] jArr2 = this.mKeys;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.mValues;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.mKeys = jArr;
            this.mValues = objArr2;
        }
        int i18 = this.mSize;
        if (i18 - i3 != 0) {
            long[] jArr3 = this.mKeys;
            int i19 = i3 + 1;
            System.arraycopy(jArr3, i3, jArr3, i19, i18 - i3);
            Object[] objArr4 = this.mValues;
            System.arraycopy(objArr4, i3, objArr4, i19, this.mSize - i3);
        }
        this.mKeys[i3] = j3;
        this.mValues[i3] = e16;
        this.mSize++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            put(longSparseArray.keyAt(i3), longSparseArray.valueAt(i3));
        }
    }

    @Nullable
    public E putIfAbsent(long j3, E e16) {
        E e17 = get(j3);
        if (e17 == null) {
            put(j3, e16);
        }
        return e17;
    }

    public void remove(long j3) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j3);
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

    public void removeAt(int i3) {
        Object[] objArr = this.mValues;
        Object obj = objArr[i3];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i3] = obj2;
            this.mGarbage = true;
        }
    }

    @Nullable
    public E replace(long j3, E e16) {
        int indexOfKey = indexOfKey(j3);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.mValues;
        E e17 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e16;
        return e17;
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

    public LongSparseArray(int i3) {
        this.mGarbage = false;
        if (i3 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i3);
            this.mKeys = new long[idealLongArraySize];
            this.mValues = new Object[idealLongArraySize];
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m3clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e16) {
            throw new AssertionError(e16);
        }
    }

    public E get(long j3, E e16) {
        E e17;
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j3);
        return (binarySearch < 0 || (e17 = (E) this.mValues[binarySearch]) == DELETED) ? e16 : e17;
    }

    public boolean replace(long j3, E e16, E e17) {
        int indexOfKey = indexOfKey(j3);
        if (indexOfKey < 0) {
            return false;
        }
        Object obj = this.mValues[indexOfKey];
        if (obj != e16 && (e16 == null || !e16.equals(obj))) {
            return false;
        }
        this.mValues[indexOfKey] = e17;
        return true;
    }

    public boolean remove(long j3, Object obj) {
        int indexOfKey = indexOfKey(j3);
        if (indexOfKey < 0) {
            return false;
        }
        E valueAt = valueAt(indexOfKey);
        if (obj != valueAt && (obj == null || !obj.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
