package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LongSparseArray<E> implements Cloneable {
    static IPatchRedirector $redirector_;
    private static final Object DELETED;
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42396);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            DELETED = new Object();
        }
    }

    public LongSparseArray() {
        this(10);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private static int binarySearch(long[] jArr, int i3, int i16, long j3) {
        int i17 = i16 + i3;
        int i18 = i3 - 1;
        int i19 = i17;
        while (i19 - i18 > 1) {
            int i26 = (i19 + i18) / 2;
            if (jArr[i26] < j3) {
                i18 = i26;
            } else {
                i19 = i26;
            }
        }
        if (i19 == i17) {
            return ~i17;
        }
        if (jArr[i19] == j3) {
            return i19;
        }
        return ~i19;
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

    public static int idealByteArraySize(int i3) {
        for (int i16 = 4; i16 < 32; i16++) {
            int i17 = (1 << i16) - 12;
            if (i3 <= i17) {
                return i17;
            }
        }
        return i3;
    }

    public static int idealLongArraySize(int i3) {
        return idealByteArraySize(i3 * 8) / 8;
    }

    public void append(long j3, E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), e16);
            return;
        }
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
            int idealLongArraySize = idealLongArraySize(i16 + 1);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        int i3 = this.mSize;
        Object[] objArr = this.mValues;
        for (int i16 = 0; i16 < i3; i16++) {
            objArr[i16] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void delete(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, j3);
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

    public E get(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? get(j3, null) : (E) iPatchRedirector.redirect((short) 4, (Object) this, j3);
    }

    public int indexOfKey(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, j3)).intValue();
        }
        if (this.mGarbage) {
            gc();
        }
        return binarySearch(this.mKeys, 0, this.mSize, j3);
    }

    public int indexOfValue(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) e16)).intValue();
        }
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

    public long keyAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this, i3)).longValue();
        }
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i3];
    }

    public void put(long j3, E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(j3), e16);
            return;
        }
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, j3);
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
            i3 = ~binarySearch(this.mKeys, 0, this.mSize, j3);
        }
        int i17 = this.mSize;
        if (i17 >= this.mKeys.length) {
            int idealLongArraySize = idealLongArraySize(i17 + 1);
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

    public void remove(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            delete(j3);
        }
    }

    public void removeAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        Object[] objArr = this.mValues;
        Object obj = objArr[i3];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[i3] = obj2;
            this.mGarbage = true;
        }
    }

    public void setValueAt(int i3, E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) e16);
            return;
        }
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i3] = e16;
    }

    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public E valueAt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (E) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        if (this.mGarbage) {
            gc();
        }
        return (E) this.mValues[i3];
    }

    public LongSparseArray(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        this.mGarbage = false;
        int idealLongArraySize = idealLongArraySize(i3);
        this.mKeys = new long[idealLongArraySize];
        this.mValues = new Object[idealLongArraySize];
        this.mSize = 0;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongSparseArray<E> m287clone() {
        LongSparseArray<E> longSparseArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LongSparseArray) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        LongSparseArray<E> longSparseArray2 = null;
        try {
            longSparseArray = (LongSparseArray) super.clone();
        } catch (CloneNotSupportedException unused) {
        }
        try {
            longSparseArray.mKeys = (long[]) this.mKeys.clone();
            longSparseArray.mValues = (Object[]) this.mValues.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException unused2) {
            longSparseArray2 = longSparseArray;
            return longSparseArray2;
        }
    }

    public E get(long j3, E e16) {
        E e17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (E) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), e16);
        }
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, j3);
        return (binarySearch < 0 || (e17 = (E) this.mValues[binarySearch]) == DELETED) ? e16 : e17;
    }
}
