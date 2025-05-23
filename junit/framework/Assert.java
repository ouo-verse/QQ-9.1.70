package junit.framework;

/* compiled from: P */
@Deprecated
/* loaded from: classes28.dex */
public class Assert {
    public static void assertEquals(String str, Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj == null || !obj.equals(obj2)) {
            failNotEquals(str, obj, obj2);
        }
    }

    public static void assertFalse(String str, boolean z16) {
        assertTrue(str, !z16);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNull(Object obj) {
        if (obj != null) {
            assertNull("Expected: <null> but was: " + obj.toString(), obj);
        }
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        failNotSame(str, obj, obj2);
    }

    public static void assertTrue(String str, boolean z16) {
        if (z16) {
            return;
        }
        fail(str);
    }

    public static void fail(String str) {
        if (str == null) {
            throw new AssertionFailedError();
        }
        throw new AssertionFailedError(str);
    }

    public static void failNotEquals(String str, Object obj, Object obj2) {
        fail(format(str, obj, obj2));
    }

    public static void failNotSame(String str, Object obj, Object obj2) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    public static void failSame(String str) {
        String str2;
        if (str != null) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        fail(str2 + "expected not same");
    }

    public static String format(String str, Object obj, Object obj2) {
        String str2;
        if (str != null && str.length() > 0) {
            str2 = str + " ";
        } else {
            str2 = "";
        }
        return str2 + "expected:<" + obj + "> but was:<" + obj2 + ">";
    }

    public static void assertFalse(boolean z16) {
        assertFalse(null, z16);
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame(null, obj, obj2);
    }

    public static void assertNull(String str, Object obj) {
        assertTrue(str, obj == null);
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame(null, obj, obj2);
    }

    public static void assertTrue(boolean z16) {
        assertTrue(null, z16);
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void fail() {
        fail(null);
    }

    public static void assertEquals(String str, String str2, String str3) {
        if (str2 == null && str3 == null) {
            return;
        }
        if (str2 == null || !str2.equals(str3)) {
            if (str == null) {
                str = "";
            }
            throw new ComparisonFailure(str, str2, str3);
        }
    }

    public static void assertEquals(String str, String str2) {
        assertEquals((String) null, str, str2);
    }

    public static void assertEquals(String str, double d16, double d17, double d18) {
        if (Double.compare(d16, d17) != 0 && Math.abs(d16 - d17) > d18) {
            failNotEquals(str, new Double(d16), new Double(d17));
        }
    }

    public static void assertEquals(double d16, double d17, double d18) {
        assertEquals((String) null, d16, d17, d18);
    }

    public static void assertEquals(String str, float f16, float f17, float f18) {
        if (Float.compare(f16, f17) != 0 && Math.abs(f16 - f17) > f18) {
            failNotEquals(str, new Float(f16), new Float(f17));
        }
    }

    public static void assertEquals(float f16, float f17, float f18) {
        assertEquals((String) null, f16, f17, f18);
    }

    public static void assertEquals(String str, long j3, long j16) {
        assertEquals(str, Long.valueOf(j3), Long.valueOf(j16));
    }

    public static void assertEquals(long j3, long j16) {
        assertEquals((String) null, j3, j16);
    }

    public static void assertEquals(String str, boolean z16, boolean z17) {
        assertEquals(str, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    public static void assertEquals(boolean z16, boolean z17) {
        assertEquals((String) null, z16, z17);
    }

    public static void assertEquals(String str, byte b16, byte b17) {
        assertEquals(str, Byte.valueOf(b16), Byte.valueOf(b17));
    }

    public static void assertEquals(byte b16, byte b17) {
        assertEquals((String) null, b16, b17);
    }

    public static void assertEquals(String str, char c16, char c17) {
        assertEquals(str, Character.valueOf(c16), Character.valueOf(c17));
    }

    public static void assertEquals(char c16, char c17) {
        assertEquals((String) null, c16, c17);
    }

    public static void assertEquals(String str, short s16, short s17) {
        assertEquals(str, Short.valueOf(s16), Short.valueOf(s17));
    }

    public static void assertEquals(short s16, short s17) {
        assertEquals((String) null, s16, s17);
    }

    public static void assertEquals(String str, int i3, int i16) {
        assertEquals(str, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public static void assertEquals(int i3, int i16) {
        assertEquals((String) null, i3, i16);
    }
}
