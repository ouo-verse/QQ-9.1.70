package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class LongArray {
    private static final int DEFAULT_INITIAL_CAPACITY = 32;
    private int size;
    private long[] values;

    public LongArray() {
        this(32);
    }

    public void add(long j3) {
        int i3 = this.size;
        long[] jArr = this.values;
        if (i3 == jArr.length) {
            this.values = Arrays.copyOf(jArr, i3 * 2);
        }
        long[] jArr2 = this.values;
        int i16 = this.size;
        this.size = i16 + 1;
        jArr2[i16] = j3;
    }

    public long get(int i3) {
        if (i3 >= 0 && i3 < this.size) {
            return this.values[i3];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i3 + ", size is " + this.size);
    }

    public int size() {
        return this.size;
    }

    public long[] toArray() {
        return Arrays.copyOf(this.values, this.size);
    }

    public LongArray(int i3) {
        this.values = new long[i3];
    }
}
