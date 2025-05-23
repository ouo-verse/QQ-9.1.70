package com.tencent.turingfd.sdk.xq;

import android.util.SparseArray;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Bagasse {
    public static <E> E a(SparseArray<Object> sparseArray, int i3, Class<E> cls) {
        if (sparseArray == null) {
            return null;
        }
        Object obj = sparseArray.get(i3);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public static int b(SparseArray<Object> sparseArray) {
        Integer num = (Integer) a(sparseArray, 0, Integer.class);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static byte[] a(SparseArray<Object> sparseArray) {
        byte[] bArr = (byte[]) a(sparseArray, 1, byte[].class);
        return bArr == null ? new byte[0] : bArr;
    }
}
