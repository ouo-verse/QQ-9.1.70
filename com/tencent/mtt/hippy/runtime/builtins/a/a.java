package com.tencent.mtt.hippy.runtime.builtins.a;

import com.tencent.mtt.hippy.runtime.builtins.e;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class a extends e implements Iterable<Object> {
    public static long c(String str) {
        if (str != null && d(str) && a(str.charAt(0))) {
            return e(str);
        }
        return -1L;
    }

    private static boolean d(String str) {
        int length = str.length();
        if (length > 0 && length <= 10) {
            return true;
        }
        return false;
    }

    private static long e(String str) {
        int length = str.length();
        if (length > 1 && str.charAt(0) == '0') {
            return -1L;
        }
        long j3 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (!a(str.charAt(i3))) {
                return -1L;
            }
            j3 = (j3 * 10) + (r1 - '0');
        }
        return j3;
    }

    public abstract Object a(int i3);

    public abstract Object a(int i3, Object obj);

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    public Object a(String str) {
        long c16 = c(str);
        if (!a(c16)) {
            return super.a(str);
        }
        if (c16 < 2147483646) {
            return a((int) c16);
        }
        throw new IndexOutOfBoundsException("Index key(" + c16 + ") out of Java Arrays max size");
    }

    @Override // com.tencent.mtt.hippy.runtime.builtins.e
    public Object a(String str, Object obj) {
        long c16 = c(str);
        if (!a(c16)) {
            return super.a(str, obj);
        }
        if (c16 < 2147483646) {
            a((int) c16, obj);
            return obj;
        }
        throw new IndexOutOfBoundsException("Index key(" + c16 + ") out of Java Arrays max size");
    }

    private static boolean a(char c16) {
        return '0' <= c16 && c16 <= '9';
    }

    public static boolean a(long j3) {
        return 0 <= j3 && j3 < 4294967295L;
    }
}
