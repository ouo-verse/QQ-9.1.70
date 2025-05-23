package com.tencent.mtt.supportui.utils.struct;

/* compiled from: P */
/* loaded from: classes21.dex */
class ContainerHelpers {

    /* renamed from: a, reason: collision with root package name */
    static final int[] f337711a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    static final long[] f337712b = new long[0];

    /* renamed from: c, reason: collision with root package name */
    static final Object[] f337713c = new Object[0];

    ContainerHelpers() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i3, int i16) {
        int i17 = i3 - 1;
        int i18 = 0;
        while (i18 <= i17) {
            int i19 = (i18 + i17) >>> 1;
            int i26 = iArr[i19];
            if (i26 < i16) {
                i18 = i19 + 1;
            } else if (i26 > i16) {
                i17 = i19 - 1;
            } else {
                return i19;
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
}
