package com.tencent.av.utils;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.Character;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    static final long f77114a = c(-1, 10);

    public static String a(long j3) {
        long j16 = Long.MAX_VALUE & j3;
        if (j3 == j16) {
            return String.valueOf(j16);
        }
        char[] charArray = "-9223372036854775808".toCharArray();
        charArray[0] = '0';
        for (int length = charArray.length - 1; length != 0 && j16 != 0; length--) {
            char c16 = (char) (charArray[length] + (j16 % 10));
            charArray[length] = c16;
            if (c16 > '9') {
                charArray[length] = (char) (c16 - '\n');
                int i3 = length - 1;
                charArray[i3] = (char) (charArray[i3] + 1);
            }
            j16 /= 10;
        }
        int i16 = '1' - charArray[0];
        return new String(charArray, i16, charArray.length - i16);
    }

    static int b(long j3, long j16) {
        if (j3 < j16) {
            return -1;
        }
        if (j3 > j16) {
            return 1;
        }
        return 0;
    }

    static long c(long j3, long j16) {
        if (j16 < 0) {
            if (b(j3, j16) < 0) {
                return 0L;
            }
            return 1L;
        }
        if (j3 >= 0) {
            return j3 / j16;
        }
        int i3 = 1;
        long j17 = ((j3 >>> 1) / j16) << 1;
        if (b(j3 - (j17 * j16), j16) < 0) {
            i3 = 0;
        }
        return j17 + i3;
    }

    public static boolean d(char c16) {
        Character.UnicodeBlock of5 = Character.UnicodeBlock.of(c16);
        if (of5 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS && of5 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS && of5 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT && of5 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A && of5 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B && of5 != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS && of5 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION && of5 != Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS && of5 != Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return false;
        }
        return true;
    }

    public static int e(String str) {
        int i3 = 0;
        for (int i16 = 0; str != null && i16 < str.length(); i16++) {
            if (d(str.charAt(i16))) {
                i3 += 2;
            } else {
                i3++;
            }
        }
        return i3;
    }

    private static boolean f(long j3, int i3, int i16) {
        if (j3 < 0) {
            return true;
        }
        long j16 = f77114a;
        if (j3 < j16) {
            return false;
        }
        if (j3 > j16 || i3 > 5) {
            return true;
        }
        return false;
    }

    public static long g(String str) {
        long j3 = 0;
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.e("CharacterUtil", 2, "the strind is null!");
            }
            return 0L;
        }
        if (str.length() == 0) {
            if (QLog.isColorLevel()) {
                QLog.e("CharacterUtil", 2, "invalid string!");
            }
            return 0L;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            int digit = Character.digit(str.charAt(i3), 10);
            if (digit != -1) {
                if (i3 > 18 && f(j3, digit, 10)) {
                    throw new NumberFormatException("Too large for unsigned long: " + str);
                }
                j3 = (j3 * 10) + digit;
            } else {
                throw new NumberFormatException(str);
            }
        }
        return j3;
    }

    public static String h(String str, int i3, int i16) {
        if (!TextUtils.isEmpty(str)) {
            for (int i17 = i3; i17 < i16; i17++) {
                if (d(str.charAt(i17))) {
                    i16--;
                }
            }
            return str.substring(i3, i16);
        }
        return "";
    }
}
