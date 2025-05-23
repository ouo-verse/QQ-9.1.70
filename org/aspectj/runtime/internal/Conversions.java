package org.aspectj.runtime.internal;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Conversions {
    Conversions() {
    }

    public static Object booleanObject(boolean z16) {
        return new Boolean(z16);
    }

    public static boolean booleanValue(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        throw new ClassCastException(obj.getClass().getName() + " can not be converted to boolean");
    }

    public static Object byteObject(byte b16) {
        return new Byte(b16);
    }

    public static byte byteValue(Object obj) {
        if (obj == null) {
            return (byte) 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).byteValue();
        }
        throw new ClassCastException(obj.getClass().getName() + " can not be converted to byte");
    }

    public static Object charObject(char c16) {
        return new Character(c16);
    }

    public static char charValue(Object obj) {
        if (obj == null) {
            return (char) 0;
        }
        if (obj instanceof Character) {
            return ((Character) obj).charValue();
        }
        throw new ClassCastException(obj.getClass().getName() + " can not be converted to char");
    }

    public static Object doubleObject(double d16) {
        return new Double(d16);
    }

    public static double doubleValue(Object obj) {
        if (obj == null) {
            return 0.0d;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        throw new ClassCastException(obj.getClass().getName() + " can not be converted to double");
    }

    public static Object floatObject(float f16) {
        return new Float(f16);
    }

    public static float floatValue(Object obj) {
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        throw new ClassCastException(obj.getClass().getName() + " can not be converted to float");
    }

    public static Object intObject(int i3) {
        return new Integer(i3);
    }

    public static int intValue(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        throw new ClassCastException(obj.getClass().getName() + " can not be converted to int");
    }

    public static Object longObject(long j3) {
        return new Long(j3);
    }

    public static long longValue(Object obj) {
        if (obj == null) {
            return 0L;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        throw new ClassCastException(obj.getClass().getName() + " can not be converted to long");
    }

    public static Object shortObject(short s16) {
        return new Short(s16);
    }

    public static short shortValue(Object obj) {
        if (obj == null) {
            return (short) 0;
        }
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        throw new ClassCastException(obj.getClass().getName() + " can not be converted to short");
    }

    public static Object voidObject() {
        return null;
    }

    public static Object voidValue(Object obj) {
        return obj;
    }
}
