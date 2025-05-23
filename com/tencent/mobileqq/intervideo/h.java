package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
final class h {
    static IPatchRedirector $redirector_;

    public static final d a(String str, Object[] objArr) {
        Throwable k3 = k(objArr);
        if (k3 != null) {
            objArr = s(objArr);
        }
        return b(str, objArr, k3);
    }

    public static final d b(String str, Object[] objArr, Throwable th5) {
        int i3;
        if (str == null) {
            return new d(null, objArr, th5);
        }
        if (objArr == null) {
            return new d(str);
        }
        StringBuilder sb5 = new StringBuilder(str.length() + 50);
        int i16 = 0;
        int i17 = 0;
        while (i16 < objArr.length) {
            int indexOf = str.indexOf("{}", i17);
            if (indexOf == -1) {
                if (i17 == 0) {
                    return new d(str, objArr, th5);
                }
                sb5.append((CharSequence) str, i17, str.length());
                return new d(sb5.toString(), objArr, th5);
            }
            if (n(str, indexOf)) {
                if (!m(str, indexOf)) {
                    i16--;
                    sb5.append((CharSequence) str, i17, indexOf - 1);
                    sb5.append('{');
                    i3 = indexOf + 1;
                    i17 = i3;
                    i16++;
                } else {
                    sb5.append((CharSequence) str, i17, indexOf - 1);
                    f(sb5, objArr[i16], new HashMap());
                }
            } else {
                sb5.append((CharSequence) str, i17, indexOf);
                f(sb5, objArr[i16], new HashMap());
            }
            i3 = indexOf + 2;
            i17 = i3;
            i16++;
        }
        sb5.append((CharSequence) str, i17, str.length());
        return new d(sb5.toString(), objArr, th5);
    }

    private static void c(StringBuilder sb5, boolean[] zArr) {
        sb5.append('[');
        int length = zArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append(zArr[i3]);
            if (i3 != length - 1) {
                sb5.append(", ");
            }
        }
        sb5.append(']');
    }

    private static void d(StringBuilder sb5, byte[] bArr) {
        sb5.append('[');
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append((int) bArr[i3]);
            if (i3 != length - 1) {
                sb5.append(", ");
            }
        }
        sb5.append(']');
    }

    private static void e(StringBuilder sb5, char[] cArr) {
        sb5.append('[');
        int length = cArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append(cArr[i3]);
            if (i3 != length - 1) {
                sb5.append(", ");
            }
        }
        sb5.append(']');
    }

    private static void f(StringBuilder sb5, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb5.append("null");
            return;
        }
        if (!obj.getClass().isArray()) {
            q(sb5, obj);
            return;
        }
        if (obj instanceof boolean[]) {
            c(sb5, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            d(sb5, (byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            e(sb5, (char[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            r(sb5, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            l(sb5, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            o(sb5, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            h(sb5, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb5, (double[]) obj);
        } else {
            p(sb5, (Object[]) obj, map);
        }
    }

    private static void g(StringBuilder sb5, double[] dArr) {
        sb5.append('[');
        int length = dArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append(dArr[i3]);
            if (i3 != length - 1) {
                sb5.append(", ");
            }
        }
        sb5.append(']');
    }

    private static void h(StringBuilder sb5, float[] fArr) {
        sb5.append('[');
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append(fArr[i3]);
            if (i3 != length - 1) {
                sb5.append(", ");
            }
        }
        sb5.append(']');
    }

    public static final d i(String str, Object obj) {
        return a(str, new Object[]{obj});
    }

    public static final d j(String str, Object obj, Object obj2) {
        return a(str, new Object[]{obj, obj2});
    }

    static final Throwable k(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    private static void l(StringBuilder sb5, int[] iArr) {
        sb5.append('[');
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append(iArr[i3]);
            if (i3 != length - 1) {
                sb5.append(", ");
            }
        }
        sb5.append(']');
    }

    static final boolean m(String str, int i3) {
        if (i3 >= 2 && str.charAt(i3 - 2) == '\\') {
            return true;
        }
        return false;
    }

    static final boolean n(String str, int i3) {
        if (i3 == 0 || str.charAt(i3 - 1) != '\\') {
            return false;
        }
        return true;
    }

    private static void o(StringBuilder sb5, long[] jArr) {
        sb5.append('[');
        int length = jArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append(jArr[i3]);
            if (i3 != length - 1) {
                sb5.append(", ");
            }
        }
        sb5.append(']');
    }

    private static void p(StringBuilder sb5, Object[] objArr, Map<Object[], Object> map) {
        sb5.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                f(sb5, objArr[i3], map);
                if (i3 != length - 1) {
                    sb5.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        }
        sb5.append(']');
    }

    private static void q(StringBuilder sb5, Object obj) {
        try {
            sb5.append(obj.toString());
        } catch (Throwable unused) {
            sb5.append("[FAILED toString()]");
        }
    }

    private static void r(StringBuilder sb5, short[] sArr) {
        sb5.append('[');
        int length = sArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb5.append((int) sArr[i3]);
            if (i3 != length - 1) {
                sb5.append(", ");
            }
        }
        sb5.append(']');
    }

    private static Object[] s(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            return objArr2;
        }
        throw new IllegalStateException("non-sensical empty or null argument array");
    }
}
