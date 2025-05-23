package org.junit;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.internal.ArrayComparisonFailure;
import org.junit.internal.ExactComparisonCriteria;
import org.junit.internal.InexactComparisonCriteria;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Assert {
    protected Assert() {
    }

    public static void assertArrayEquals(String str, Object[] objArr, Object[] objArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, objArr, objArr2);
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        if (equalsRegardingNull(obj, obj2)) {
            return;
        }
        if ((obj instanceof String) && (obj2 instanceof String)) {
            if (str == null) {
                str = "";
            }
            throw new ComparisonFailure(str, (String) obj, (String) obj2);
        }
        failNotEquals(str, obj, obj2);
    }

    public static void assertFalse(String str, boolean z16) {
        assertTrue(str, !z16);
    }

    public static void assertNotEquals(String str, Object obj, Object obj2) {
        if (equalsRegardingNull(obj, obj2)) {
            failEquals(str, obj2);
        }
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNull(String str, Object obj) {
        if (obj == null) {
            return;
        }
        failNotNull(str, obj);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        failNotSame(str, obj, obj2);
    }

    public static <T> void assertThat(T t16, Matcher<? super T> matcher) {
        assertThat("", t16, matcher);
    }

    public static void assertTrue(String str, boolean z16) {
        if (z16) {
            return;
        }
        fail(str);
    }

    private static boolean doubleIsDifferent(double d16, double d17, double d18) {
        if (Double.compare(d16, d17) == 0 || Math.abs(d16 - d17) <= d18) {
            return false;
        }
        return true;
    }

    private static boolean equalsRegardingNull(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return isEquals(obj, obj2);
    }

    public static void fail(String str) {
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    private static void failEquals(String str, Object obj) {
        String str2;
        if (str != null) {
            str2 = str + ". ";
        } else {
            str2 = "Values should be different. ";
        }
        fail(str2 + "Actual: " + obj);
    }

    private static void failNotEquals(String str, Object obj, Object obj2) {
        fail(format(str, obj, obj2));
    }

    private static void failNotNull(String str, Object obj) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected null, but was:<" + obj + ">");
    }

    private static void failNotSame(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    private static void failSame(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected not same");
    }

    private static boolean floatIsDifferent(float f16, float f17, float f18) {
        if (Float.compare(f16, f17) == 0 || Math.abs(f16 - f17) <= f18) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String format(String str, Object obj, Object obj2) {
        String str2 = "";
        if (str != null && !str.equals("")) {
            str2 = str + " ";
        }
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        if (valueOf.equals(valueOf2)) {
            return str2 + "expected: " + formatClassAndValue(obj, valueOf) + " but was: " + formatClassAndValue(obj2, valueOf2);
        }
        return str2 + "expected:<" + valueOf + "> but was:<" + valueOf2 + ">";
    }

    private static String formatClassAndValue(Object obj, String str) {
        String name;
        if (obj == null) {
            name = "null";
        } else {
            name = obj.getClass().getName();
        }
        return name + "<" + str + ">";
    }

    private static void internalArrayEquals(String str, Object obj, Object obj2) throws ArrayComparisonFailure {
        new ExactComparisonCriteria().arrayEquals(str, obj, obj2);
    }

    private static boolean isEquals(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static void assertArrayEquals(Object[] objArr, Object[] objArr2) {
        assertArrayEquals((String) null, objArr, objArr2);
    }

    public static void assertFalse(boolean z16) {
        assertFalse(null, z16);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame(null, obj, obj2);
    }

    public static void assertNull(Object obj) {
        assertNull(null, obj);
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame(null, obj, obj2);
    }

    public static <T> void assertThat(String str, T t16, Matcher<? super T> matcher) {
        MatcherAssert.assertThat(str, t16, matcher);
    }

    public static void assertTrue(boolean z16) {
        assertTrue(null, z16);
    }

    public static void assertArrayEquals(String str, boolean[] zArr, boolean[] zArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, zArr, zArr2);
    }

    public static void assertNotEquals(Object obj, Object obj2) {
        assertNotEquals((String) null, obj, obj2);
    }

    public static void fail() {
        fail(null);
    }

    public static void assertArrayEquals(boolean[] zArr, boolean[] zArr2) {
        assertArrayEquals((String) null, zArr, zArr2);
    }

    public static void assertNotEquals(String str, long j3, long j16) {
        if (j3 == j16) {
            failEquals(str, Long.valueOf(j16));
        }
    }

    public static void assertArrayEquals(String str, byte[] bArr, byte[] bArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, bArr, bArr2);
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void assertNotEquals(long j3, long j16) {
        assertNotEquals((String) null, j3, j16);
    }

    public static void assertArrayEquals(byte[] bArr, byte[] bArr2) {
        assertArrayEquals((String) null, bArr, bArr2);
    }

    public static void assertEquals(String str, double d16, double d17, double d18) {
        if (doubleIsDifferent(d16, d17, d18)) {
            failNotEquals(str, Double.valueOf(d16), Double.valueOf(d17));
        }
    }

    public static void assertNotEquals(String str, double d16, double d17, double d18) {
        if (doubleIsDifferent(d16, d17, d18)) {
            return;
        }
        failEquals(str, Double.valueOf(d17));
    }

    public static void assertArrayEquals(String str, char[] cArr, char[] cArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, cArr, cArr2);
    }

    public static void assertArrayEquals(char[] cArr, char[] cArr2) {
        assertArrayEquals((String) null, cArr, cArr2);
    }

    public static void assertEquals(String str, float f16, float f17, float f18) {
        if (floatIsDifferent(f16, f17, f18)) {
            failNotEquals(str, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    public static void assertNotEquals(double d16, double d17, double d18) {
        assertNotEquals((String) null, d16, d17, d18);
    }

    public static void assertArrayEquals(String str, short[] sArr, short[] sArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, sArr, sArr2);
    }

    public static void assertNotEquals(float f16, float f17, float f18) {
        assertNotEquals((String) null, f16, f17, f18);
    }

    public static void assertArrayEquals(short[] sArr, short[] sArr2) {
        assertArrayEquals((String) null, sArr, sArr2);
    }

    public static void assertEquals(long j3, long j16) {
        assertEquals((String) null, j3, j16);
    }

    public static void assertNotEquals(String str, float f16, float f17, float f18) {
        if (floatIsDifferent(f16, f17, f18)) {
            return;
        }
        failEquals(str, Float.valueOf(f17));
    }

    public static void assertArrayEquals(String str, int[] iArr, int[] iArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, iArr, iArr2);
    }

    public static void assertEquals(String str, long j3, long j16) {
        if (j3 != j16) {
            failNotEquals(str, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public static void assertArrayEquals(int[] iArr, int[] iArr2) {
        assertArrayEquals((String) null, iArr, iArr2);
    }

    @Deprecated
    public static void assertEquals(double d16, double d17) {
        assertEquals((String) null, d16, d17);
    }

    public static void assertArrayEquals(String str, long[] jArr, long[] jArr2) throws ArrayComparisonFailure {
        internalArrayEquals(str, jArr, jArr2);
    }

    @Deprecated
    public static void assertEquals(String str, double d16, double d17) {
        fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    public static void assertArrayEquals(long[] jArr, long[] jArr2) {
        assertArrayEquals((String) null, jArr, jArr2);
    }

    public static void assertEquals(double d16, double d17, double d18) {
        assertEquals((String) null, d16, d17, d18);
    }

    public static void assertArrayEquals(String str, double[] dArr, double[] dArr2, double d16) throws ArrayComparisonFailure {
        new InexactComparisonCriteria(d16).arrayEquals(str, dArr, dArr2);
    }

    public static void assertEquals(float f16, float f17, float f18) {
        assertEquals((String) null, f16, f17, f18);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, double d16) {
        assertArrayEquals((String) null, dArr, dArr2, d16);
    }

    @Deprecated
    public static void assertEquals(String str, Object[] objArr, Object[] objArr2) {
        assertArrayEquals(str, objArr, objArr2);
    }

    public static void assertArrayEquals(String str, float[] fArr, float[] fArr2, float f16) throws ArrayComparisonFailure {
        new InexactComparisonCriteria(f16).arrayEquals(str, fArr, fArr2);
    }

    @Deprecated
    public static void assertEquals(Object[] objArr, Object[] objArr2) {
        assertArrayEquals(objArr, objArr2);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, float f16) {
        assertArrayEquals((String) null, fArr, fArr2, f16);
    }
}
