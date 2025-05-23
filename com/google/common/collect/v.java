package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static Object a(Object obj, int i3) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static Object[] b(Object... objArr) {
        return c(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static Object[] c(Object[] objArr, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            a(objArr[i16], i16);
        }
        return objArr;
    }

    public static <T> T[] d(T[] tArr, int i3) {
        return (T[]) y.b(tArr, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] e(Object[] objArr, int i3, int i16, T[] tArr) {
        com.google.common.base.j.r(i3, i3 + i16, objArr.length);
        if (tArr.length < i16) {
            tArr = (T[]) d(tArr, i16);
        } else if (tArr.length > i16) {
            tArr[i16] = null;
        }
        System.arraycopy(objArr, i3, tArr, 0, i16);
        return tArr;
    }
}
