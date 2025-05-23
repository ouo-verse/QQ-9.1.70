package org.apache.httpcore.util;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class LangUtils {
    public static final int HASH_OFFSET = 37;
    public static final int HASH_SEED = 17;

    LangUtils() {
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int hashCode(int i3, int i16) {
        return (i3 * 37) + i16;
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return objArr2 == null;
        }
        if (objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (!equals(objArr[i3], objArr2[i3])) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(int i3, boolean z16) {
        return hashCode(i3, z16 ? 1 : 0);
    }

    public static int hashCode(int i3, Object obj) {
        return hashCode(i3, obj != null ? obj.hashCode() : 0);
    }
}
