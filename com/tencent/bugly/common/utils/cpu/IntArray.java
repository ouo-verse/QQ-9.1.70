package com.tencent.bugly.common.utils.cpu;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes5.dex */
class IntArray implements Cloneable {
    private static final int MIN_CAPACITY_INCREMENT = 12;
    private int mSize;
    private int[] mValues;

    IntArray(int[] iArr, int i3) {
        this.mValues = iArr;
        this.mSize = checkArgumentInRange(i3, 0, iArr.length, "size");
    }

    public static int checkArgumentInRange(int i3, int i16, int i17, String str) {
        if (i3 >= i16) {
            if (i3 <= i17) {
                return i3;
            }
            throw new IllegalArgumentException(String.format("%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i16), Integer.valueOf(i17)));
        }
        throw new IllegalArgumentException(String.format("%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i16), Integer.valueOf(i17)));
    }

    public static void checkBounds(int i3, int i16) {
        if (i16 >= 0 && i3 > i16) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + i3 + "; index=" + i16);
    }

    private void ensureCapacity(int i3) {
        int i16;
        int i17 = this.mSize;
        int i18 = i3 + i17;
        if (i18 >= this.mValues.length) {
            if (i17 < 6) {
                i16 = 12;
            } else {
                i16 = i17 >> 1;
            }
            int i19 = i16 + i17;
            if (i19 > i18) {
                i18 = i19;
            }
            int[] newUnpaddedIntArray = newUnpaddedIntArray(i18);
            System.arraycopy(this.mValues, 0, newUnpaddedIntArray, 0, i17);
            this.mValues = newUnpaddedIntArray;
        }
    }

    public static int[] newUnpaddedIntArray(int i3) {
        return new int[i3];
    }

    public void add(int i3) {
        add(this.mSize, i3);
    }

    public void addAll(int[] iArr) {
        int length = iArr.length;
        ensureCapacity(length);
        System.arraycopy(iArr, 0, this.mValues, this.mSize, length);
        this.mSize += length;
    }

    public int[] toArray() {
        return Arrays.copyOf(this.mValues, this.mSize);
    }

    public void add(int i3, int i16) {
        ensureCapacity(1);
        int i17 = this.mSize;
        int i18 = i17 - i3;
        int i19 = i17 + 1;
        this.mSize = i19;
        checkBounds(i19, i3);
        if (i18 != 0) {
            int[] iArr = this.mValues;
            System.arraycopy(iArr, i3, iArr, i3 + 1, i18);
        }
        this.mValues[i3] = i16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IntArray m104clone() {
        return new IntArray((int[]) this.mValues.clone(), this.mSize);
    }

    public IntArray() {
        this(0);
    }

    public IntArray(int i3) {
        if (i3 == 0) {
            this.mValues = new int[0];
        } else {
            this.mValues = newUnpaddedIntArray(i3);
        }
        this.mSize = 0;
    }
}
