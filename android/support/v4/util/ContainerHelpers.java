package android.support.v4.util;

/* compiled from: P */
/* loaded from: classes.dex */
class ContainerHelpers {
    static final int[] EMPTY_INTS = new int[0];
    static final long[] EMPTY_LONGS = new long[0];
    static final Object[] EMPTY_OBJECTS = new Object[0];

    ContainerHelpers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int binarySearch(int[] iArr, int i3, int i16) {
        int i17 = i3 - 1;
        int i18 = 0;
        while (i18 <= i17) {
            int i19 = (i18 + i17) >>> 1;
            int i26 = iArr[i19];
            if (i26 < i16) {
                i18 = i19 + 1;
            } else {
                if (i26 <= i16) {
                    return i19;
                }
                i17 = i19 - 1;
            }
        }
        return ~i18;
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
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

    public static int idealIntArraySize(int i3) {
        return idealByteArraySize(i3 * 4) / 4;
    }

    public static int idealLongArraySize(int i3) {
        return idealByteArraySize(i3 * 8) / 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int binarySearch(long[] jArr, int i3, long j3) {
        int i16 = i3 - 1;
        int i17 = 0;
        while (i17 <= i16) {
            int i18 = (i17 + i16) >>> 1;
            long j16 = jArr[i18];
            if (j16 < j3) {
                i17 = i18 + 1;
            } else {
                if (j16 <= j3) {
                    return i18;
                }
                i16 = i18 - 1;
            }
        }
        return ~i17;
    }
}
