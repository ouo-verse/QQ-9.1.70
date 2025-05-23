package org.apache.commons.lang;

import kotlinx.coroutines.DebugKt;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BooleanUtils {
    public static boolean isFalse(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return !bool.booleanValue();
    }

    public static boolean isNotFalse(Boolean bool) {
        return !isFalse(bool);
    }

    public static boolean isNotTrue(Boolean bool) {
        return !isTrue(bool);
    }

    public static boolean isTrue(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static Boolean negate(Boolean bool) {
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static boolean toBoolean(int i3) {
        return i3 != 0;
    }

    public static boolean toBooleanDefaultIfNull(Boolean bool, boolean z16) {
        if (bool == null) {
            return z16;
        }
        return bool.booleanValue();
    }

    public static Boolean toBooleanObject(boolean z16) {
        return z16 ? Boolean.TRUE : Boolean.FALSE;
    }

    public static int toInteger(boolean z16) {
        return z16 ? 1 : 0;
    }

    public static Integer toIntegerObject(boolean z16, Integer num, Integer num2) {
        return z16 ? num : num2;
    }

    public static String toString(boolean z16, String str, String str2) {
        return z16 ? str : str2;
    }

    public static String toStringOnOff(Boolean bool) {
        return toString(bool, "on", DebugKt.DEBUG_PROPERTY_VALUE_OFF, null);
    }

    public static String toStringTrueFalse(Boolean bool) {
        return toString(bool, "true", "false", null);
    }

    public static String toStringYesNo(Boolean bool) {
        return toString(bool, "yes", "no", null);
    }

    public static boolean xor(boolean[] zArr) {
        if (zArr != null) {
            if (zArr.length != 0) {
                int i3 = 0;
                for (boolean z16 : zArr) {
                    if (z16) {
                        if (i3 >= 1) {
                            return false;
                        }
                        i3++;
                    }
                }
                return i3 == 1;
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static boolean toBoolean(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static Boolean toBooleanObject(int i3) {
        return i3 == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static int toInteger(boolean z16, int i3, int i16) {
        return z16 ? i3 : i16;
    }

    public static Integer toIntegerObject(boolean z16) {
        return z16 ? org.apache.commons.lang.math.NumberUtils.INTEGER_ONE : org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;
    }

    public static String toString(Boolean bool, String str, String str2, String str3) {
        return bool == null ? str3 : bool.booleanValue() ? str : str2;
    }

    public static String toStringOnOff(boolean z16) {
        return toString(z16, "on", DebugKt.DEBUG_PROPERTY_VALUE_OFF);
    }

    public static String toStringTrueFalse(boolean z16) {
        return toString(z16, "true", "false");
    }

    public static String toStringYesNo(boolean z16) {
        return toString(z16, "yes", "no");
    }

    public static boolean toBoolean(int i3, int i16, int i17) {
        if (i3 == i16) {
            return true;
        }
        if (i3 == i17) {
            return false;
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static Boolean toBooleanObject(Integer num) {
        if (num == null) {
            return null;
        }
        return num.intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public static int toInteger(Boolean bool, int i3, int i16, int i17) {
        return bool == null ? i17 : bool.booleanValue() ? i3 : i16;
    }

    public static Integer toIntegerObject(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return bool.booleanValue() ? org.apache.commons.lang.math.NumberUtils.INTEGER_ONE : org.apache.commons.lang.math.NumberUtils.INTEGER_ZERO;
    }

    public static boolean toBoolean(Integer num, Integer num2, Integer num3) {
        if (num == null) {
            if (num2 == null) {
                return true;
            }
            if (num3 == null) {
                return false;
            }
        } else {
            if (num.equals(num2)) {
                return true;
            }
            if (num.equals(num3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The Integer did not match either specified value");
    }

    public static Boolean toBooleanObject(int i3, int i16, int i17, int i18) {
        if (i3 == i16) {
            return Boolean.TRUE;
        }
        if (i3 == i17) {
            return Boolean.FALSE;
        }
        if (i3 == i18) {
            return null;
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static Integer toIntegerObject(Boolean bool, Integer num, Integer num2, Integer num3) {
        return bool == null ? num3 : bool.booleanValue() ? num : num2;
    }

    public static Boolean xor(Boolean[] boolArr) {
        if (boolArr != null) {
            if (boolArr.length != 0) {
                try {
                    return xor(ArrayUtils.toPrimitive(boolArr)) ? Boolean.TRUE : Boolean.FALSE;
                } catch (NullPointerException unused) {
                    throw new IllegalArgumentException("The array must not contain any null elements");
                }
            }
            throw new IllegalArgumentException("Array is empty");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static boolean toBoolean(String str) {
        return toBoolean(toBooleanObject(str));
    }

    public static Boolean toBooleanObject(Integer num, Integer num2, Integer num3, Integer num4) {
        if (num == null) {
            if (num2 == null) {
                return Boolean.TRUE;
            }
            if (num3 == null) {
                return Boolean.FALSE;
            }
            if (num4 == null) {
                return null;
            }
        } else {
            if (num.equals(num2)) {
                return Boolean.TRUE;
            }
            if (num.equals(num3)) {
                return Boolean.FALSE;
            }
            if (num.equals(num4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The Integer did not match any specified value");
    }

    public static boolean toBoolean(String str, String str2, String str3) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            if (str3 == null) {
                return false;
            }
        } else {
            if (str.equals(str2)) {
                return true;
            }
            if (str.equals(str3)) {
                return false;
            }
        }
        throw new IllegalArgumentException("The String did not match either specified value");
    }

    public static Boolean toBooleanObject(String str) {
        if (str == "true") {
            return Boolean.TRUE;
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 1) {
            char charAt = str.charAt(0);
            if (charAt == 'y' || charAt == 'Y' || charAt == 't' || charAt == 'T') {
                return Boolean.TRUE;
            }
            if (charAt == 'n' || charAt == 'N' || charAt == 'f' || charAt == 'F') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 2) {
            char charAt2 = str.charAt(0);
            char charAt3 = str.charAt(1);
            if ((charAt2 == 'o' || charAt2 == 'O') && (charAt3 == 'n' || charAt3 == 'N')) {
                return Boolean.TRUE;
            }
            if (charAt2 != 'n' && charAt2 != 'N') {
                return null;
            }
            if (charAt3 == 'o' || charAt3 == 'O') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 3) {
            char charAt4 = str.charAt(0);
            char charAt5 = str.charAt(1);
            char charAt6 = str.charAt(2);
            if ((charAt4 == 'y' || charAt4 == 'Y') && ((charAt5 == 'e' || charAt5 == 'E') && (charAt6 == 's' || charAt6 == 'S'))) {
                return Boolean.TRUE;
            }
            if (charAt4 != 'o' && charAt4 != 'O') {
                return null;
            }
            if (charAt5 != 'f' && charAt5 != 'F') {
                return null;
            }
            if (charAt6 == 'f' || charAt6 == 'F') {
                return Boolean.FALSE;
            }
            return null;
        }
        if (length == 4) {
            char charAt7 = str.charAt(0);
            char charAt8 = str.charAt(1);
            char charAt9 = str.charAt(2);
            char charAt10 = str.charAt(3);
            if (charAt7 != 't' && charAt7 != 'T') {
                return null;
            }
            if (charAt8 != 'r' && charAt8 != 'R') {
                return null;
            }
            if (charAt9 != 'u' && charAt9 != 'U') {
                return null;
            }
            if (charAt10 == 'e' || charAt10 == 'E') {
                return Boolean.TRUE;
            }
            return null;
        }
        if (length != 5) {
            return null;
        }
        char charAt11 = str.charAt(0);
        char charAt12 = str.charAt(1);
        char charAt13 = str.charAt(2);
        char charAt14 = str.charAt(3);
        char charAt15 = str.charAt(4);
        if (charAt11 != 'f' && charAt11 != 'F') {
            return null;
        }
        if (charAt12 != 'a' && charAt12 != 'A') {
            return null;
        }
        if (charAt13 != 'l' && charAt13 != 'L') {
            return null;
        }
        if (charAt14 != 's' && charAt14 != 'S') {
            return null;
        }
        if (charAt15 == 'e' || charAt15 == 'E') {
            return Boolean.FALSE;
        }
        return null;
    }

    public static Boolean toBooleanObject(String str, String str2, String str3, String str4) {
        if (str == null) {
            if (str2 == null) {
                return Boolean.TRUE;
            }
            if (str3 == null) {
                return Boolean.FALSE;
            }
            if (str4 == null) {
                return null;
            }
        } else {
            if (str.equals(str2)) {
                return Boolean.TRUE;
            }
            if (str.equals(str3)) {
                return Boolean.FALSE;
            }
            if (str.equals(str4)) {
                return null;
            }
        }
        throw new IllegalArgumentException("The String did not match any specified value");
    }
}
