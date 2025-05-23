package org.apache.commons.lang.math;

import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = new Long(0);
    public static final Long LONG_ONE = new Long(1);
    public static final Long LONG_MINUS_ONE = new Long(-1);
    public static final Integer INTEGER_ZERO = new Integer(0);
    public static final Integer INTEGER_ONE = new Integer(1);
    public static final Integer INTEGER_MINUS_ONE = new Integer(-1);
    public static final Short SHORT_ZERO = new Short((short) 0);
    public static final Short SHORT_ONE = new Short((short) 1);
    public static final Short SHORT_MINUS_ONE = new Short((short) -1);
    public static final Byte BYTE_ZERO = new Byte((byte) 0);
    public static final Byte BYTE_ONE = new Byte((byte) 1);
    public static final Byte BYTE_MINUS_ONE = new Byte((byte) -1);
    public static final Double DOUBLE_ZERO = new Double(0.0d);
    public static final Double DOUBLE_ONE = new Double(1.0d);
    public static final Double DOUBLE_MINUS_ONE = new Double(-1.0d);
    public static final Float FLOAT_ZERO = new Float(0.0f);
    public static final Float FLOAT_ONE = new Float(1.0f);
    public static final Float FLOAT_MINUS_ONE = new Float(-1.0f);

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
        if (str == null) {
            return null;
        }
        if (!StringUtils.isBlank(str)) {
            return new BigDecimal(str);
        }
        throw new NumberFormatException("A blank string is not a valid number");
    }

    public static BigInteger createBigInteger(String str) {
        if (str == null) {
            return null;
        }
        return new BigInteger(str);
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.valueOf(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ee, code lost:
    
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
        if (!StringUtils.isBlank(str)) {
            if (str.startsWith("--")) {
                return null;
            }
            if (!str.startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING) && !str.startsWith("-0x")) {
                boolean z17 = true;
                char charAt = str.charAt(str.length() - 1);
                int indexOf = str.indexOf(46);
                int indexOf2 = str.indexOf(101) + str.indexOf(69) + 1;
                if (indexOf > -1) {
                    if (indexOf2 > -1) {
                        if (indexOf2 >= indexOf && indexOf2 <= str.length()) {
                            str3 = str.substring(indexOf + 1, indexOf2);
                        } else {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(" is not a valid number.");
                            throw new NumberFormatException(stringBuffer.toString());
                        }
                    } else {
                        str3 = str.substring(indexOf + 1);
                    }
                    str2 = str.substring(0, indexOf);
                } else {
                    if (indexOf2 > -1) {
                        if (indexOf2 <= str.length()) {
                            str2 = str.substring(0, indexOf2);
                        } else {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(str);
                            stringBuffer2.append(" is not a valid number.");
                            throw new NumberFormatException(stringBuffer2.toString());
                        }
                    } else {
                        str2 = str;
                    }
                    str3 = null;
                }
                if (!Character.isDigit(charAt) && charAt != '.') {
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
                if (!isAllZeros(str2) || !isAllZeros(str4)) {
                    z17 = false;
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
        throw new NumberFormatException("A blank string is not a valid number");
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
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!Character.isDigit(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x00cf, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0067, code lost:
    
        if (r3 >= r0.length) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0069, code lost:
    
        r0 = r0[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006b, code lost:
    
        if (r0 < '0') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006d, code lost:
    
        if (r0 > '9') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x006f, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0070, code lost:
    
        if (r0 == 'e') goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0072, code lost:
    
        if (r0 != 'E') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0075, code lost:
    
        if (r0 != '.') goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0077, code lost:
    
        if (r13 != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0079, code lost:
    
        if (r12 == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x007c, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x007d, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x007e, code lost:
    
        if (r6 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0082, code lost:
    
        if (r0 == 'd') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0086, code lost:
    
        if (r0 == 'D') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0088, code lost:
    
        if (r0 == 'f') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x008c, code lost:
    
        if (r0 != 'F') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x008e, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0091, code lost:
    
        if (r0 == 'l') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0095, code lost:
    
        if (r0 != 'L') goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0098, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0099, code lost:
    
        if (r11 == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x009b, code lost:
    
        if (r12 != false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x009e, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x009f, code lost:
    
        if (r6 != false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00a1, code lost:
    
        if (r11 == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00a4, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isNumber(String str) {
        int i3;
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
                char c16 = charArray[i17];
                if ((c16 < '0' || c16 > '9') && ((c16 < 'a' || c16 > 'f') && (c16 < 'A' || c16 > 'F'))) {
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
            if (i3 >= i18 && (i3 >= i18 + 1 || !z17 || z18)) {
                break;
            }
            char c17 = charArray[i3];
            if (c17 >= '0' && c17 <= '9') {
                z17 = false;
                z18 = true;
            } else if (c17 == '.') {
                if (z26 || z19) {
                    break;
                }
                z26 = true;
            } else if (c17 != 'e' && c17 != 'E') {
                if (c17 != '+' && c17 != '-') {
                    return false;
                }
                z17 = false;
                z18 = false;
            } else {
                if (z19 || !z18) {
                    return false;
                }
                z17 = true;
                z19 = true;
            }
            i3++;
            z16 = true;
        }
        return false;
    }

    public static byte max(byte b16, byte b17, byte b18) {
        if (b17 > b16) {
            b16 = b17;
        }
        return b18 > b16 ? b18 : b16;
    }

    public static byte min(byte b16, byte b17, byte b18) {
        if (b17 < b16) {
            b16 = b17;
        }
        return b18 < b16 ? b18 : b16;
    }

    public static int stringToInt(String str) {
        return toInt(str);
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    public static int max(int i3, int i16, int i17) {
        if (i16 > i3) {
            i3 = i16;
        }
        return i17 > i3 ? i17 : i3;
    }

    public static int min(int i3, int i16, int i17) {
        if (i16 < i3) {
            i3 = i16;
        }
        return i17 < i3 ? i17 : i3;
    }

    public static int stringToInt(String str, int i3) {
        return toInt(str, i3);
    }

    public static byte toByte(String str, byte b16) {
        if (str == null) {
            return b16;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b16;
        }
    }

    public static double toDouble(String str, double d16) {
        if (str == null) {
            return d16;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d16;
        }
    }

    public static float toFloat(String str, float f16) {
        if (str == null) {
            return f16;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f16;
        }
    }

    public static int toInt(String str, int i3) {
        if (str == null) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public static long toLong(String str, long j3) {
        if (str == null) {
            return j3;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j3;
        }
    }

    public static short toShort(String str, short s16) {
        if (str == null) {
            return s16;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s16;
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

    public static long max(long j3, long j16, long j17) {
        if (j16 > j3) {
            j3 = j16;
        }
        return j17 > j3 ? j17 : j3;
    }

    public static long min(long j3, long j16, long j17) {
        if (j16 < j3) {
            j3 = j16;
        }
        return j17 < j3 ? j17 : j3;
    }

    public static short max(short s16, short s17, short s18) {
        if (s17 > s16) {
            s16 = s17;
        }
        return s18 > s16 ? s18 : s16;
    }

    public static short min(short s16, short s17, short s18) {
        if (s17 < s16) {
            s16 = s17;
        }
        return s18 < s16 ? s18 : s16;
    }

    public static long max(long[] jArr) {
        if (jArr != null) {
            if (jArr.length != 0) {
                long j3 = jArr[0];
                for (int i3 = 1; i3 < jArr.length; i3++) {
                    long j16 = jArr[i3];
                    if (j16 > j3) {
                        j3 = j16;
                    }
                }
                return j3;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static long min(long[] jArr) {
        if (jArr != null) {
            if (jArr.length != 0) {
                long j3 = jArr[0];
                for (int i3 = 1; i3 < jArr.length; i3++) {
                    long j16 = jArr[i3];
                    if (j16 < j3) {
                        j3 = j16;
                    }
                }
                return j3;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static int max(int[] iArr) {
        if (iArr != null) {
            if (iArr.length != 0) {
                int i3 = iArr[0];
                for (int i16 = 1; i16 < iArr.length; i16++) {
                    int i17 = iArr[i16];
                    if (i17 > i3) {
                        i3 = i17;
                    }
                }
                return i3;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static int min(int[] iArr) {
        if (iArr != null) {
            if (iArr.length != 0) {
                int i3 = iArr[0];
                for (int i16 = 1; i16 < iArr.length; i16++) {
                    int i17 = iArr[i16];
                    if (i17 < i3) {
                        i3 = i17;
                    }
                }
                return i3;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static short max(short[] sArr) {
        if (sArr != null) {
            if (sArr.length != 0) {
                short s16 = sArr[0];
                for (int i3 = 1; i3 < sArr.length; i3++) {
                    short s17 = sArr[i3];
                    if (s17 > s16) {
                        s16 = s17;
                    }
                }
                return s16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static short min(short[] sArr) {
        if (sArr != null) {
            if (sArr.length != 0) {
                short s16 = sArr[0];
                for (int i3 = 1; i3 < sArr.length; i3++) {
                    short s17 = sArr[i3];
                    if (s17 < s16) {
                        s16 = s17;
                    }
                }
                return s16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static byte max(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                byte b16 = bArr[0];
                for (int i3 = 1; i3 < bArr.length; i3++) {
                    byte b17 = bArr[i3];
                    if (b17 > b16) {
                        b16 = b17;
                    }
                }
                return b16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static byte min(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                byte b16 = bArr[0];
                for (int i3 = 1; i3 < bArr.length; i3++) {
                    byte b17 = bArr[i3];
                    if (b17 < b16) {
                        b16 = b17;
                    }
                }
                return b16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double max(double[] dArr) {
        if (dArr != null) {
            if (dArr.length != 0) {
                double d16 = dArr[0];
                for (int i3 = 1; i3 < dArr.length; i3++) {
                    if (Double.isNaN(dArr[i3])) {
                        return Double.NaN;
                    }
                    double d17 = dArr[i3];
                    if (d17 > d16) {
                        d16 = d17;
                    }
                }
                return d16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double min(double[] dArr) {
        if (dArr != null) {
            if (dArr.length != 0) {
                double d16 = dArr[0];
                for (int i3 = 1; i3 < dArr.length; i3++) {
                    if (Double.isNaN(dArr[i3])) {
                        return Double.NaN;
                    }
                    double d17 = dArr[i3];
                    if (d17 < d16) {
                        d16 = d17;
                    }
                }
                return d16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static float max(float[] fArr) {
        if (fArr != null) {
            if (fArr.length != 0) {
                float f16 = fArr[0];
                for (int i3 = 1; i3 < fArr.length; i3++) {
                    if (Float.isNaN(fArr[i3])) {
                        return Float.NaN;
                    }
                    float f17 = fArr[i3];
                    if (f17 > f16) {
                        f16 = f17;
                    }
                }
                return f16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static float min(float[] fArr) {
        if (fArr != null) {
            if (fArr.length != 0) {
                float f16 = fArr[0];
                for (int i3 = 1; i3 < fArr.length; i3++) {
                    if (Float.isNaN(fArr[i3])) {
                        return Float.NaN;
                    }
                    float f17 = fArr[i3];
                    if (f17 < f16) {
                        f16 = f17;
                    }
                }
                return f16;
            }
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static double max(double d16, double d17, double d18) {
        return Math.max(Math.max(d16, d17), d18);
    }

    public static double min(double d16, double d17, double d18) {
        return Math.min(Math.min(d16, d17), d18);
    }

    public static float max(float f16, float f17, float f18) {
        return Math.max(Math.max(f16, f17), f18);
    }

    public static float min(float f16, float f17, float f18) {
        return Math.min(Math.min(f16, f17), f18);
    }
}
