package org.apache.commons.lang;

import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NumberUtils {
    public static int compare(double d16, double d17) {
        if (d16 < d17) {
            return -1;
        }
        if (d16 > d17) {
            return 1;
        }
        long doubleToLongBits = Double.doubleToLongBits(d16);
        long doubleToLongBits2 = Double.doubleToLongBits(d17);
        if (doubleToLongBits == doubleToLongBits2) {
            return 0;
        }
        return doubleToLongBits < doubleToLongBits2 ? -1 : 1;
    }

    public static BigDecimal createBigDecimal(String str) {
        return new BigDecimal(str);
    }

    public static BigInteger createBigInteger(String str) {
        return new BigInteger(str);
    }

    public static Double createDouble(String str) {
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        return Long.valueOf(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f1, code lost:
    
        if (r1 == 'l') goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Number createNumber(String str) throws NumberFormatException {
        String str2;
        String str3;
        boolean z16;
        String str4 = null;
        if (str == null) {
            return null;
        }
        if (str.length() != 0) {
            boolean z17 = false;
            if (str.length() == 1 && !Character.isDigit(str.charAt(0))) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append(" is not a valid number.");
                throw new NumberFormatException(stringBuffer.toString());
            }
            if (str.startsWith("--")) {
                return null;
            }
            if (!str.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING) && !str.startsWith("-0x")) {
                char charAt = str.charAt(str.length() - 1);
                int indexOf = str.indexOf(46);
                int indexOf2 = str.indexOf(101) + str.indexOf(69) + 1;
                if (indexOf > -1) {
                    if (indexOf2 > -1) {
                        if (indexOf2 >= indexOf) {
                            str3 = str.substring(indexOf + 1, indexOf2);
                        } else {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(str);
                            stringBuffer2.append(" is not a valid number.");
                            throw new NumberFormatException(stringBuffer2.toString());
                        }
                    } else {
                        str3 = str.substring(indexOf + 1);
                    }
                    str2 = str.substring(0, indexOf);
                } else {
                    if (indexOf2 > -1) {
                        str2 = str.substring(0, indexOf2);
                    } else {
                        str2 = str;
                    }
                    str3 = null;
                }
                if (!Character.isDigit(charAt)) {
                    if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                        str4 = str.substring(indexOf2 + 1, str.length() - 1);
                    }
                    String substring = str.substring(0, str.length() - 1);
                    if (isAllZeros(str2) && isAllZeros(str4)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (charAt != 'D') {
                        if (charAt != 'F') {
                            if (charAt != 'L') {
                                if (charAt != 'd') {
                                    if (charAt != 'f') {
                                    }
                                }
                            }
                            if (str3 == null && str4 == null && ((substring.charAt(0) == '-' && isDigits(substring.substring(1))) || isDigits(substring))) {
                                try {
                                    return createLong(substring);
                                } catch (NumberFormatException unused) {
                                    return createBigInteger(substring);
                                }
                            }
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append(str);
                            stringBuffer3.append(" is not a valid number.");
                            throw new NumberFormatException(stringBuffer3.toString());
                        }
                        try {
                            Float createFloat = createFloat(substring);
                            if (!createFloat.isInfinite()) {
                                if (createFloat.floatValue() != 0.0f || z16) {
                                    return createFloat;
                                }
                            }
                        } catch (NumberFormatException unused2) {
                        }
                    }
                    try {
                        Double createDouble = createDouble(substring);
                        if (!createDouble.isInfinite()) {
                            if (createDouble.floatValue() != 0.0d || z16) {
                                return createDouble;
                            }
                        }
                    } catch (NumberFormatException unused3) {
                    }
                    try {
                        return createBigDecimal(substring);
                    } catch (NumberFormatException unused4) {
                        StringBuffer stringBuffer4 = new StringBuffer();
                        stringBuffer4.append(str);
                        stringBuffer4.append(" is not a valid number.");
                        throw new NumberFormatException(stringBuffer4.toString());
                    }
                }
                if (indexOf2 > -1 && indexOf2 < str.length() - 1) {
                    str4 = str.substring(indexOf2 + 1, str.length());
                }
                if (str3 == null && str4 == null) {
                    try {
                        try {
                            return createInteger(str);
                        } catch (NumberFormatException unused5) {
                            return createLong(str);
                        }
                    } catch (NumberFormatException unused6) {
                        return createBigInteger(str);
                    }
                }
                if (isAllZeros(str2) && isAllZeros(str4)) {
                    z17 = true;
                }
                try {
                    Float createFloat2 = createFloat(str);
                    if (!createFloat2.isInfinite()) {
                        if (createFloat2.floatValue() != 0.0f || z17) {
                            return createFloat2;
                        }
                    }
                } catch (NumberFormatException unused7) {
                }
                try {
                    Double createDouble2 = createDouble(str);
                    if (!createDouble2.isInfinite()) {
                        if (createDouble2.doubleValue() != 0.0d || z17) {
                            return createDouble2;
                        }
                    }
                } catch (NumberFormatException unused8) {
                }
                return createBigDecimal(str);
            }
            return createInteger(str);
        }
        throw new NumberFormatException("\"\" is not a valid number.");
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        if (str.length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isDigits(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!Character.isDigit(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0063, code lost:
    
        if (r3 >= r0.length) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0065, code lost:
    
        r0 = r0[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0067, code lost:
    
        if (r0 < '0') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0069, code lost:
    
        if (r0 > '9') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006b, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x006c, code lost:
    
        if (r0 == 'e') goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x006e, code lost:
    
        if (r0 != 'E') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0071, code lost:
    
        if (r6 != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0075, code lost:
    
        if (r0 == 'd') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0079, code lost:
    
        if (r0 == 'D') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x007b, code lost:
    
        if (r0 == 'f') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x007d, code lost:
    
        if (r0 != 'F') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x007f, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0082, code lost:
    
        if (r0 == 'l') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0086, code lost:
    
        if (r0 != 'L') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0089, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x008a, code lost:
    
        if (r11 == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x008c, code lost:
    
        if (r12 != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x008f, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0090, code lost:
    
        if (r6 != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0092, code lost:
    
        if (r11 == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0095, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00ae, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isNumber(String str) {
        int i3;
        char c16;
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z16 = true;
        if (charArray[0] == '-') {
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i16 = i3 + 1;
        if (length > i16 && charArray[i3] == '0' && charArray[i16] == 'x') {
            int i17 = i3 + 2;
            if (i17 == length) {
                return false;
            }
            while (i17 < charArray.length) {
                char c17 = charArray[i17];
                if ((c17 < '0' || c17 > '9') && ((c17 < 'a' || c17 > 'f') && (c17 < 'A' || c17 > 'F'))) {
                    return false;
                }
                i17++;
            }
            return true;
        }
        int i18 = length - 1;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        boolean z26 = false;
        while (true) {
            if (i3 < i18 || (i3 < i18 + 1 && z17 && !z18)) {
                char c18 = charArray[i3];
                if (c18 >= '0' && c18 <= '9') {
                    z17 = false;
                    z18 = z16;
                    c16 = '-';
                } else if (c18 == '.') {
                    if (z26 || z19) {
                        break;
                    }
                    c16 = '-';
                    z26 = true;
                } else if (c18 != 'e' && c18 != 'E') {
                    if (c18 != '+') {
                        c16 = '-';
                        if (c18 != '-') {
                            return false;
                        }
                    } else {
                        c16 = '-';
                    }
                    if (!z17) {
                        return false;
                    }
                    z17 = false;
                    z18 = false;
                } else {
                    c16 = '-';
                    if (z19 || !z18) {
                        return false;
                    }
                    z17 = true;
                    z19 = true;
                }
                i3++;
                z16 = true;
            }
        }
    }

    public static int maximum(int i3, int i16, int i17) {
        if (i16 > i3) {
            i3 = i16;
        }
        return i17 > i3 ? i17 : i3;
    }

    public static int minimum(int i3, int i16, int i17) {
        if (i16 < i3) {
            i3 = i16;
        }
        return i17 < i3 ? i17 : i3;
    }

    public static int stringToInt(String str) {
        return stringToInt(str, 0);
    }

    public static long maximum(long j3, long j16, long j17) {
        if (j16 > j3) {
            j3 = j16;
        }
        return j17 > j3 ? j17 : j3;
    }

    public static long minimum(long j3, long j16, long j17) {
        if (j16 < j3) {
            j3 = j16;
        }
        return j17 < j3 ? j17 : j3;
    }

    public static int stringToInt(String str, int i3) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public static int compare(float f16, float f17) {
        if (f16 < f17) {
            return -1;
        }
        if (f16 > f17) {
            return 1;
        }
        int floatToIntBits = Float.floatToIntBits(f16);
        int floatToIntBits2 = Float.floatToIntBits(f17);
        if (floatToIntBits == floatToIntBits2) {
            return 0;
        }
        return floatToIntBits < floatToIntBits2 ? -1 : 1;
    }
}
