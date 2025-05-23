package com.google.protobuf.nano;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class FieldArray implements Cloneable {
    private static final FieldData DELETED = new FieldData();
    private FieldData[] mData;
    private int[] mFieldNumbers;
    private boolean mGarbage;
    private int mSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldArray() {
        this(10);
    }

    private boolean arrayEquals(int[] iArr, int[] iArr2, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            if (iArr[i16] != iArr2[i16]) {
                return false;
            }
        }
        return true;
    }

    private int binarySearch(int i3) {
        int i16 = this.mSize - 1;
        int i17 = 0;
        while (i17 <= i16) {
            int i18 = (i17 + i16) >>> 1;
            int i19 = this.mFieldNumbers[i18];
            if (i19 < i3) {
                i17 = i18 + 1;
            } else if (i19 > i3) {
                i16 = i18 - 1;
            } else {
                return i18;
            }
        }
        return ~i17;
    }

    private void gc() {
        int i3 = this.mSize;
        int[] iArr = this.mFieldNumbers;
        FieldData[] fieldDataArr = this.mData;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            FieldData fieldData = fieldDataArr[i17];
            if (fieldData != DELETED) {
                if (i17 != i16) {
                    iArr[i16] = iArr[i17];
                    fieldDataArr[i16] = fieldData;
                    fieldDataArr[i17] = null;
                }
                i16++;
            }
        }
        this.mGarbage = false;
        this.mSize = i16;
    }

    private int idealByteArraySize(int i3) {
        for (int i16 = 4; i16 < 32; i16++) {
            int i17 = (1 << i16) - 12;
            if (i3 <= i17) {
                return i17;
            }
        }
        return i3;
    }

    private int idealIntArraySize(int i3) {
        return idealByteArraySize(i3 * 4) / 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldData dataAt(int i3) {
        if (this.mGarbage) {
            gc();
        }
        return this.mData[i3];
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FieldArray)) {
            return false;
        }
        FieldArray fieldArray = (FieldArray) obj;
        if (size() != fieldArray.size()) {
            return false;
        }
        if (arrayEquals(this.mFieldNumbers, fieldArray.mFieldNumbers, this.mSize) && arrayEquals(this.mData, fieldArray.mData, this.mSize)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldData get(int i3) {
        FieldData fieldData;
        int binarySearch = binarySearch(i3);
        if (binarySearch >= 0 && (fieldData = this.mData[binarySearch]) != DELETED) {
            return fieldData;
        }
        return null;
    }

    public int hashCode() {
        if (this.mGarbage) {
            gc();
        }
        int i3 = 17;
        for (int i16 = 0; i16 < this.mSize; i16++) {
            i3 = (((i3 * 31) + this.mFieldNumbers[i16]) * 31) + this.mData[i16].hashCode();
        }
        return i3;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void put(int i3, FieldData fieldData) {
        int binarySearch = binarySearch(i3);
        if (binarySearch >= 0) {
            this.mData[binarySearch] = fieldData;
            return;
        }
        int i16 = ~binarySearch;
        int i17 = this.mSize;
        if (i16 < i17) {
            FieldData[] fieldDataArr = this.mData;
            if (fieldDataArr[i16] == DELETED) {
                this.mFieldNumbers[i16] = i3;
                fieldDataArr[i16] = fieldData;
                return;
            }
        }
        if (this.mGarbage && i17 >= this.mFieldNumbers.length) {
            gc();
            i16 = ~binarySearch(i3);
        }
        int i18 = this.mSize;
        if (i18 >= this.mFieldNumbers.length) {
            int idealIntArraySize = idealIntArraySize(i18 + 1);
            int[] iArr = new int[idealIntArraySize];
            FieldData[] fieldDataArr2 = new FieldData[idealIntArraySize];
            int[] iArr2 = this.mFieldNumbers;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            FieldData[] fieldDataArr3 = this.mData;
            System.arraycopy(fieldDataArr3, 0, fieldDataArr2, 0, fieldDataArr3.length);
            this.mFieldNumbers = iArr;
            this.mData = fieldDataArr2;
        }
        int i19 = this.mSize;
        if (i19 - i16 != 0) {
            int[] iArr3 = this.mFieldNumbers;
            int i26 = i16 + 1;
            System.arraycopy(iArr3, i16, iArr3, i26, i19 - i16);
            FieldData[] fieldDataArr4 = this.mData;
            System.arraycopy(fieldDataArr4, i16, fieldDataArr4, i26, this.mSize - i16);
        }
        this.mFieldNumbers[i16] = i3;
        this.mData[i16] = fieldData;
        this.mSize++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(int i3) {
        int binarySearch = binarySearch(i3);
        if (binarySearch >= 0) {
            FieldData[] fieldDataArr = this.mData;
            FieldData fieldData = fieldDataArr[binarySearch];
            FieldData fieldData2 = DELETED;
            if (fieldData != fieldData2) {
                fieldDataArr[binarySearch] = fieldData2;
                this.mGarbage = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    FieldArray(int i3) {
        this.mGarbage = false;
        int idealIntArraySize = idealIntArraySize(i3);
        this.mFieldNumbers = new int[idealIntArraySize];
        this.mData = new FieldData[idealIntArraySize];
        this.mSize = 0;
    }

    private boolean arrayEquals(FieldData[] fieldDataArr, FieldData[] fieldDataArr2, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            if (!fieldDataArr[i16].equals(fieldDataArr2[i16])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final FieldArray m67clone() {
        int size = size();
        FieldArray fieldArray = new FieldArray(size);
        System.arraycopy(this.mFieldNumbers, 0, fieldArray.mFieldNumbers, 0, size);
        for (int i3 = 0; i3 < size; i3++) {
            FieldData fieldData = this.mData[i3];
            if (fieldData != null) {
                fieldArray.mData[i3] = fieldData.m68clone();
            }
        }
        fieldArray.mSize = size;
        return fieldArray;
    }
}
