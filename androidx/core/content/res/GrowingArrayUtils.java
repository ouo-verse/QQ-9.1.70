package androidx.core.content.res;

import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes.dex */
final class GrowingArrayUtils {
    GrowingArrayUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object[], java.lang.Object] */
    public static <T> T[] append(T[] tArr, int i3, T t16) {
        if (i3 + 1 > tArr.length) {
            ?? r06 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i3));
            System.arraycopy(tArr, 0, r06, 0, i3);
            tArr = r06;
        }
        tArr[i3] = t16;
        return tArr;
    }

    public static int growSize(int i3) {
        if (i3 <= 4) {
            return 8;
        }
        return i3 * 2;
    }

    public static <T> T[] insert(T[] tArr, int i3, int i16, T t16) {
        if (i3 + 1 <= tArr.length) {
            System.arraycopy(tArr, i16, tArr, i16 + 1, i3 - i16);
            tArr[i16] = t16;
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i3)));
        System.arraycopy(tArr, 0, tArr2, 0, i16);
        tArr2[i16] = t16;
        System.arraycopy(tArr, i16, tArr2, i16 + 1, tArr.length - i16);
        return tArr2;
    }

    public static int[] append(int[] iArr, int i3, int i16) {
        if (i3 + 1 > iArr.length) {
            int[] iArr2 = new int[growSize(i3)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr = iArr2;
        }
        iArr[i3] = i16;
        return iArr;
    }

    public static int[] insert(int[] iArr, int i3, int i16, int i17) {
        if (i3 + 1 <= iArr.length) {
            System.arraycopy(iArr, i16, iArr, i16 + 1, i3 - i16);
            iArr[i16] = i17;
            return iArr;
        }
        int[] iArr2 = new int[growSize(i3)];
        System.arraycopy(iArr, 0, iArr2, 0, i16);
        iArr2[i16] = i17;
        System.arraycopy(iArr, i16, iArr2, i16 + 1, iArr.length - i16);
        return iArr2;
    }

    public static long[] append(long[] jArr, int i3, long j3) {
        if (i3 + 1 > jArr.length) {
            long[] jArr2 = new long[growSize(i3)];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            jArr = jArr2;
        }
        jArr[i3] = j3;
        return jArr;
    }

    public static boolean[] append(boolean[] zArr, int i3, boolean z16) {
        if (i3 + 1 > zArr.length) {
            boolean[] zArr2 = new boolean[growSize(i3)];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            zArr = zArr2;
        }
        zArr[i3] = z16;
        return zArr;
    }

    public static long[] insert(long[] jArr, int i3, int i16, long j3) {
        if (i3 + 1 <= jArr.length) {
            System.arraycopy(jArr, i16, jArr, i16 + 1, i3 - i16);
            jArr[i16] = j3;
            return jArr;
        }
        long[] jArr2 = new long[growSize(i3)];
        System.arraycopy(jArr, 0, jArr2, 0, i16);
        jArr2[i16] = j3;
        System.arraycopy(jArr, i16, jArr2, i16 + 1, jArr.length - i16);
        return jArr2;
    }

    public static boolean[] insert(boolean[] zArr, int i3, int i16, boolean z16) {
        if (i3 + 1 <= zArr.length) {
            System.arraycopy(zArr, i16, zArr, i16 + 1, i3 - i16);
            zArr[i16] = z16;
            return zArr;
        }
        boolean[] zArr2 = new boolean[growSize(i3)];
        System.arraycopy(zArr, 0, zArr2, 0, i16);
        zArr2[i16] = z16;
        System.arraycopy(zArr, i16, zArr2, i16 + 1, zArr.length - i16);
        return zArr2;
    }
}
