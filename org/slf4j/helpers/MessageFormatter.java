package org.slf4j.helpers;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MessageFormatter {
    static final char DELIM_START = '{';
    static final char DELIM_STOP = '}';
    static final String DELIM_STR = "{}";
    private static final char ESCAPE_CHAR = '\\';

    public static final FormattingTuple arrayFormat(String str, Object[] objArr) {
        Throwable throwableCandidate = getThrowableCandidate(objArr);
        if (throwableCandidate != null) {
            objArr = trimmedCopy(objArr);
        }
        return arrayFormat(str, objArr, throwableCandidate);
    }

    private static void booleanArrayAppend(StringBuilder sb5, boolean[] zArr) {
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

    private static void byteArrayAppend(StringBuilder sb5, byte[] bArr) {
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

    private static void charArrayAppend(StringBuilder sb5, char[] cArr) {
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

    private static void deeplyAppendParameter(StringBuilder sb5, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb5.append("null");
            return;
        }
        if (!obj.getClass().isArray()) {
            safeObjectAppend(sb5, obj);
            return;
        }
        if (obj instanceof boolean[]) {
            booleanArrayAppend(sb5, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            byteArrayAppend(sb5, (byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            charArrayAppend(sb5, (char[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            shortArrayAppend(sb5, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            intArrayAppend(sb5, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            longArrayAppend(sb5, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            floatArrayAppend(sb5, (float[]) obj);
        } else if (obj instanceof double[]) {
            doubleArrayAppend(sb5, (double[]) obj);
        } else {
            objectArrayAppend(sb5, (Object[]) obj, map);
        }
    }

    private static void doubleArrayAppend(StringBuilder sb5, double[] dArr) {
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

    private static void floatArrayAppend(StringBuilder sb5, float[] fArr) {
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

    public static final FormattingTuple format(String str, Object obj) {
        return arrayFormat(str, new Object[]{obj});
    }

    public static Throwable getThrowableCandidate(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    private static void intArrayAppend(StringBuilder sb5, int[] iArr) {
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

    static final boolean isDoubleEscaped(String str, int i3) {
        if (i3 >= 2 && str.charAt(i3 - 2) == '\\') {
            return true;
        }
        return false;
    }

    static final boolean isEscapedDelimeter(String str, int i3) {
        if (i3 == 0 || str.charAt(i3 - 1) != '\\') {
            return false;
        }
        return true;
    }

    private static void longArrayAppend(StringBuilder sb5, long[] jArr) {
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

    private static void objectArrayAppend(StringBuilder sb5, Object[] objArr, Map<Object[], Object> map) {
        sb5.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                deeplyAppendParameter(sb5, objArr[i3], map);
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

    private static void safeObjectAppend(StringBuilder sb5, Object obj) {
        try {
            sb5.append(obj.toString());
        } catch (Throwable th5) {
            Util.report("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th5);
            sb5.append("[FAILED toString()]");
        }
    }

    private static void shortArrayAppend(StringBuilder sb5, short[] sArr) {
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

    public static Object[] trimmedCopy(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            if (length > 0) {
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return objArr2;
        }
        throw new IllegalStateException("non-sensical empty or null argument array");
    }

    public static final FormattingTuple format(String str, Object obj, Object obj2) {
        return arrayFormat(str, new Object[]{obj, obj2});
    }

    public static final FormattingTuple arrayFormat(String str, Object[] objArr, Throwable th5) {
        int i3;
        if (str == null) {
            return new FormattingTuple(null, objArr, th5);
        }
        if (objArr == null) {
            return new FormattingTuple(str);
        }
        StringBuilder sb5 = new StringBuilder(str.length() + 50);
        int i16 = 0;
        int i17 = 0;
        while (i16 < objArr.length) {
            int indexOf = str.indexOf("{}", i17);
            if (indexOf == -1) {
                if (i17 == 0) {
                    return new FormattingTuple(str, objArr, th5);
                }
                sb5.append((CharSequence) str, i17, str.length());
                return new FormattingTuple(sb5.toString(), objArr, th5);
            }
            if (isEscapedDelimeter(str, indexOf)) {
                if (!isDoubleEscaped(str, indexOf)) {
                    i16--;
                    sb5.append((CharSequence) str, i17, indexOf - 1);
                    sb5.append(DELIM_START);
                    i3 = indexOf + 1;
                    i17 = i3;
                    i16++;
                } else {
                    sb5.append((CharSequence) str, i17, indexOf - 1);
                    deeplyAppendParameter(sb5, objArr[i16], new HashMap());
                }
            } else {
                sb5.append((CharSequence) str, i17, indexOf);
                deeplyAppendParameter(sb5, objArr[i16], new HashMap());
            }
            i3 = indexOf + 2;
            i17 = i3;
            i16++;
        }
        sb5.append((CharSequence) str, i17, str.length());
        return new FormattingTuple(sb5.toString(), objArr, th5);
    }
}
