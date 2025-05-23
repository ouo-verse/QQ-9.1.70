package org.jf.util;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SparseIntArray {
    private int[] mKeys;
    private int mSize;
    private int[] mValues;

    public SparseIntArray() {
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

    public void append(int i3, int i16) {
        int i17 = this.mSize;
        if (i17 != 0 && i3 <= this.mKeys[i17 - 1]) {
            put(i3, i16);
            return;
        }
        int[] iArr = this.mKeys;
        if (i17 >= iArr.length) {
            int max = Math.max(i17 + 1, iArr.length * 2);
            int[] iArr2 = new int[max];
            int[] iArr3 = new int[max];
            int[] iArr4 = this.mKeys;
            System.arraycopy(iArr4, 0, iArr2, 0, iArr4.length);
            int[] iArr5 = this.mValues;
            System.arraycopy(iArr5, 0, iArr3, 0, iArr5.length);
            this.mKeys = iArr2;
            this.mValues = iArr3;
        }
        this.mKeys[i17] = i3;
        this.mValues[i17] = i16;
        this.mSize = i17 + 1;
    }

    public void clear() {
        this.mSize = 0;
    }

    public void delete(int i3) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i3);
        if (binarySearch >= 0) {
            removeAt(binarySearch);
        }
    }

    public int get(int i3) {
        return get(i3, 0);
    }

    public int getClosestSmaller(int i3) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i3);
        if (binarySearch < 0) {
            int i16 = ~binarySearch;
            if (i16 > 0) {
                i16--;
            }
            return this.mValues[i16];
        }
        return this.mValues[binarySearch];
    }

    public int indexOfKey(int i3) {
        return binarySearch(this.mKeys, 0, this.mSize, i3);
    }

    public int indexOfValue(int i3) {
        for (int i16 = 0; i16 < this.mSize; i16++) {
            if (this.mValues[i16] == i3) {
                return i16;
            }
        }
        return -1;
    }

    public int keyAt(int i3) {
        return this.mKeys[i3];
    }

    public void put(int i3, int i16) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i3);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = i16;
            return;
        }
        int i17 = ~binarySearch;
        int i18 = this.mSize;
        int[] iArr = this.mKeys;
        if (i18 >= iArr.length) {
            int max = Math.max(i18 + 1, iArr.length * 2);
            int[] iArr2 = new int[max];
            int[] iArr3 = new int[max];
            int[] iArr4 = this.mKeys;
            System.arraycopy(iArr4, 0, iArr2, 0, iArr4.length);
            int[] iArr5 = this.mValues;
            System.arraycopy(iArr5, 0, iArr3, 0, iArr5.length);
            this.mKeys = iArr2;
            this.mValues = iArr3;
        }
        int i19 = this.mSize;
        if (i19 - i17 != 0) {
            int[] iArr6 = this.mKeys;
            int i26 = i17 + 1;
            System.arraycopy(iArr6, i17, iArr6, i26, i19 - i17);
            int[] iArr7 = this.mValues;
            System.arraycopy(iArr7, i17, iArr7, i26, this.mSize - i17);
        }
        this.mKeys[i17] = i3;
        this.mValues[i17] = i16;
        this.mSize++;
    }

    public void removeAt(int i3) {
        int[] iArr = this.mKeys;
        int i16 = i3 + 1;
        System.arraycopy(iArr, i16, iArr, i3, this.mSize - i16);
        int[] iArr2 = this.mValues;
        System.arraycopy(iArr2, i16, iArr2, i3, this.mSize - i16);
        this.mSize--;
    }

    public int size() {
        return this.mSize;
    }

    public int valueAt(int i3) {
        return this.mValues[i3];
    }

    public SparseIntArray(int i3) {
        this.mKeys = new int[i3];
        this.mValues = new int[i3];
        this.mSize = 0;
    }

    public int get(int i3, int i16) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i3);
        return binarySearch < 0 ? i16 : this.mValues[binarySearch];
    }
}
