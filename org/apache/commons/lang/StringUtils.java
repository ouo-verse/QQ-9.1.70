package org.apache.commons.lang;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang.text.StrBuilder;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public class StringUtils {
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    private static final int PAD_LIMIT = 8192;

    public static String abbreviate(String str, int i3) {
        return abbreviate(str, 0, i3);
    }

    public static String abbreviateMiddle(String str, String str2, int i3) {
        if (!isEmpty(str) && !isEmpty(str2) && i3 < str.length() && i3 >= str2.length() + 2) {
            int length = i3 - str2.length();
            int i16 = length / 2;
            int i17 = (length % 2) + i16;
            int length2 = str.length() - i16;
            StrBuilder strBuilder = new StrBuilder(i3);
            strBuilder.append(str.substring(0, i17));
            strBuilder.append(str2);
            strBuilder.append(str.substring(length2));
            return strBuilder.toString();
        }
        return str;
    }

    public static String capitalise(String str) {
        return capitalize(str);
    }

    public static String capitaliseAllWords(String str) {
        return WordUtils.capitalize(str);
    }

    public static String capitalize(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            return new StrBuilder(length).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString();
        }
        return str;
    }

    public static String center(String str, int i3) {
        return center(str, i3, TokenParser.SP);
    }

    public static String chomp(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            return (charAt == '\r' || charAt == '\n') ? "" : str;
        }
        int length = str.length() - 1;
        char charAt2 = str.charAt(length);
        if (charAt2 == '\n') {
            if (str.charAt(length - 1) == '\r') {
                length--;
            }
        } else if (charAt2 != '\r') {
            length++;
        }
        return str.substring(0, length);
    }

    public static String chompLast(String str) {
        return chompLast(str, "\n");
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i3 = length - 1;
        String substring = str.substring(0, i3);
        if (str.charAt(i3) == '\n') {
            int i16 = i3 - 1;
            if (substring.charAt(i16) == '\r') {
                return substring.substring(0, i16);
            }
        }
        return substring;
    }

    public static String chopNewline(String str) {
        int length = str.length() - 1;
        if (length <= 0) {
            return "";
        }
        if (str.charAt(length) == '\n') {
            if (str.charAt(length - 1) == '\r') {
                length--;
            }
        } else {
            length++;
        }
        return str.substring(0, length);
    }

    public static String clean(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    public static String concatenate(Object[] objArr) {
        return join(objArr, (String) null);
    }

    public static boolean contains(String str, char c16) {
        return !isEmpty(str) && str.indexOf(c16) >= 0;
    }

    public static boolean containsAny(String str, char[] cArr) {
        if (!isEmpty(str) && !ArrayUtils.isEmpty(cArr)) {
            int length = str.length();
            int length2 = cArr.length;
            int i3 = length - 1;
            int i16 = length2 - 1;
            for (int i17 = 0; i17 < length; i17++) {
                char charAt = str.charAt(i17);
                for (int i18 = 0; i18 < length2; i18++) {
                    if (cArr[i18] == charAt) {
                        if (!CharUtils.isHighSurrogate(charAt) || i18 == i16) {
                            return true;
                        }
                        if (i17 < i3 && cArr[i18 + 1] == str.charAt(i17 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(String str, String str2) {
        if (str != null && str2 != null) {
            int length = str2.length();
            int length2 = str.length() - length;
            for (int i3 = 0; i3 <= length2; i3++) {
                if (str.regionMatches(true, i3, str2, 0, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNone(String str, char[] cArr) {
        if (str != null && cArr != null) {
            int length = str.length();
            int i3 = length - 1;
            int length2 = cArr.length;
            int i16 = length2 - 1;
            for (int i17 = 0; i17 < length; i17++) {
                char charAt = str.charAt(i17);
                for (int i18 = 0; i18 < length2; i18++) {
                    if (cArr[i18] == charAt) {
                        if (!CharUtils.isHighSurrogate(charAt) || i18 == i16) {
                            return false;
                        }
                        if (i17 < i3 && cArr[i18 + 1] == str.charAt(i17 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsOnly(String str, char[] cArr) {
        if (cArr == null || str == null) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        return cArr.length != 0 && indexOfAnyBut(str, cArr) == -1;
    }

    public static int countMatches(String str, String str2) {
        int i3 = 0;
        if (isEmpty(str) || isEmpty(str2)) {
            return 0;
        }
        int i16 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i3);
            if (indexOf != -1) {
                i16++;
                i3 = indexOf + str2.length();
            } else {
                return i16;
            }
        }
    }

    public static String defaultIfBlank(String str, String str2) {
        if (isBlank(str)) {
            return str2;
        }
        return str;
    }

    public static String defaultIfEmpty(String str, String str2) {
        if (isEmpty(str)) {
            return str2;
        }
        return str;
    }

    public static String defaultString(String str) {
        return str == null ? "" : str;
    }

    public static String deleteSpaces(String str) {
        if (str == null) {
            return null;
        }
        return CharSetUtils.delete(str, " \t\r\n\b");
    }

    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            if (!Character.isWhitespace(str.charAt(i16))) {
                cArr[i3] = str.charAt(i16);
                i3++;
            }
        }
        if (i3 == length) {
            return str;
        }
        return new String(cArr, 0, i3);
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        if (indexOfDifference == -1) {
            return "";
        }
        return str2.substring(indexOfDifference);
    }

    public static boolean endsWith(String str, String str2) {
        return endsWith(str, str2, false);
    }

    public static boolean endsWithAny(String str, String[] strArr) {
        if (!isEmpty(str) && !ArrayUtils.isEmpty(strArr)) {
            for (String str2 : strArr) {
                if (endsWith(str, str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean endsWithIgnoreCase(String str, String str2) {
        return endsWith(str, str2, true);
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        return str.equals(str2);
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static String escape(String str) {
        return StringEscapeUtils.escapeJava(str);
    }

    public static String getChomp(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf == str.length() - str2.length()) {
            return str2;
        }
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf);
        }
        return "";
    }

    public static String getCommonPrefix(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int indexOfDifference = indexOfDifference(strArr);
        if (indexOfDifference == -1) {
            String str = strArr[0];
            if (str == null) {
                return "";
            }
            return str;
        }
        if (indexOfDifference == 0) {
            return "";
        }
        return strArr[0].substring(0, indexOfDifference);
    }

    public static int getLevenshteinDistance(String str, String str2) {
        int i3;
        if (str != null && str2 != null) {
            int length = str.length();
            int length2 = str2.length();
            if (length == 0) {
                return length2;
            }
            if (length2 == 0) {
                return length;
            }
            if (length > length2) {
                length2 = str.length();
                length = length2;
            } else {
                str2 = str;
                str = str2;
            }
            int i16 = length + 1;
            int[] iArr = new int[i16];
            int[] iArr2 = new int[i16];
            for (int i17 = 0; i17 <= length; i17++) {
                iArr[i17] = i17;
            }
            int i18 = 1;
            while (i18 <= length2) {
                char charAt = str.charAt(i18 - 1);
                iArr2[0] = i18;
                for (int i19 = 1; i19 <= length; i19++) {
                    int i26 = i19 - 1;
                    if (str2.charAt(i26) == charAt) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    iArr2[i19] = Math.min(Math.min(iArr2[i26] + 1, iArr[i19] + 1), iArr[i26] + i3);
                }
                i18++;
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            return iArr[length];
        }
        throw new IllegalArgumentException("Strings must not be null");
    }

    public static String getNestedString(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String getPrechomp(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return "";
        }
        return str.substring(0, indexOf + str2.length());
    }

    public static int indexOf(String str, char c16) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.indexOf(c16);
    }

    public static int indexOfAny(String str, char[] cArr) {
        if (!isEmpty(str) && !ArrayUtils.isEmpty(cArr)) {
            int length = str.length();
            int i3 = length - 1;
            int length2 = cArr.length;
            int i16 = length2 - 1;
            for (int i17 = 0; i17 < length; i17++) {
                char charAt = str.charAt(i17);
                for (int i18 = 0; i18 < length2; i18++) {
                    if (cArr[i18] == charAt && (i17 >= i3 || i18 >= i16 || !CharUtils.isHighSurrogate(charAt) || cArr[i18 + 1] == str.charAt(i17 + 1))) {
                        return i17;
                    }
                }
            }
        }
        return -1;
    }

    public static int indexOfAnyBut(String str, char[] cArr) {
        if (!isEmpty(str) && !ArrayUtils.isEmpty(cArr)) {
            int length = str.length();
            int i3 = length - 1;
            int length2 = cArr.length;
            int i16 = length2 - 1;
            for (int i17 = 0; i17 < length; i17++) {
                char charAt = str.charAt(i17);
                for (int i18 = 0; i18 < length2; i18++) {
                    if (cArr[i18] != charAt || (i17 < i3 && i18 < i16 && CharUtils.isHighSurrogate(charAt) && cArr[i18 + 1] != str.charAt(i17 + 1))) {
                    }
                }
                return i17;
            }
        }
        return -1;
    }

    public static int indexOfDifference(String str, String str2) {
        if (str == str2) {
            return -1;
        }
        int i3 = 0;
        if (str != null && str2 != null) {
            while (i3 < str.length() && i3 < str2.length() && str.charAt(i3) == str2.charAt(i3)) {
                i3++;
            }
            if (i3 >= str2.length() && i3 >= str.length()) {
                return -1;
            }
        }
        return i3;
    }

    public static int indexOfIgnoreCase(String str, String str2) {
        return indexOfIgnoreCase(str, str2, 0);
    }

    public static boolean isAllLowerCase(String str) {
        if (str == null || isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isLowerCase(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUpperCase(String str) {
        if (str == null || isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isUpperCase(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isLetter(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isLetter(str.charAt(i3)) && str.charAt(i3) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isLetterOrDigit(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isLetterOrDigit(str.charAt(i3)) && str.charAt(i3) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAsciiPrintable(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!CharUtils.isAsciiPrintable(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i3 = 0; i3 < length; i3++) {
                if (!Character.isWhitespace(str.charAt(i3))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isDigit(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isDigit(str.charAt(i3)) && str.charAt(i3) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isWhitespace(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static String join(Object[] objArr) {
        return join(objArr, (String) null);
    }

    public static int lastIndexOf(String str, char c16) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.lastIndexOf(c16);
    }

    public static int lastIndexOfAny(String str, String[] strArr) {
        int lastIndexOf;
        int i3 = -1;
        if (str != null && strArr != null) {
            for (String str2 : strArr) {
                if (str2 != null && (lastIndexOf = str.lastIndexOf(str2)) > i3) {
                    i3 = lastIndexOf;
                }
            }
        }
        return i3;
    }

    public static int lastIndexOfIgnoreCase(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        return lastIndexOfIgnoreCase(str, str2, str.length());
    }

    public static int lastOrdinalIndexOf(String str, String str2, int i3) {
        return ordinalIndexOf(str, str2, i3, true);
    }

    public static String left(String str, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 < 0) {
            return "";
        }
        if (str.length() <= i3) {
            return str;
        }
        return str.substring(0, i3);
    }

    public static String leftPad(String str, int i3) {
        return leftPad(str, i3, TokenParser.SP);
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    public static String mid(String str, int i3, int i16) {
        if (str == null) {
            return null;
        }
        if (i16 >= 0 && i3 <= str.length()) {
            if (i3 < 0) {
                i3 = 0;
            }
            int i17 = i16 + i3;
            if (str.length() <= i17) {
                return str.substring(i3);
            }
            return str.substring(i3, i17);
        }
        return "";
    }

    public static String normalizeSpace(String str) {
        String strip = strip(str);
        if (strip != null && strip.length() > 2) {
            StrBuilder strBuilder = new StrBuilder(strip.length());
            for (int i3 = 0; i3 < strip.length(); i3++) {
                char charAt = strip.charAt(i3);
                if (Character.isWhitespace(charAt)) {
                    if (i3 > 0 && !Character.isWhitespace(strip.charAt(i3 - 1))) {
                        strBuilder.append(TokenParser.SP);
                    }
                } else {
                    strBuilder.append(charAt);
                }
            }
            return strBuilder.toString();
        }
        return strip;
    }

    public static int ordinalIndexOf(String str, String str2, int i3) {
        return ordinalIndexOf(str, str2, i3, false);
    }

    public static String overlay(String str, String str2, int i3, int i16) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > length) {
            i3 = length;
        }
        if (i16 < 0) {
            i16 = 0;
        }
        if (i16 > length) {
            i16 = length;
        }
        if (i3 > i16) {
            int i17 = i16;
            i16 = i3;
            i3 = i17;
        }
        return new StrBuilder(((length + i3) - i16) + str2.length() + 1).append(str.substring(0, i3)).append(str2).append(str.substring(i16)).toString();
    }

    public static String overlayString(String str, String str2, int i3, int i16) {
        return new StrBuilder((((str2.length() + i3) + str.length()) - i16) + 1).append(str.substring(0, i3)).append(str2).append(str.substring(i16)).toString();
    }

    private static String padding(int i3, char c16) throws IndexOutOfBoundsException {
        if (i3 >= 0) {
            char[] cArr = new char[i3];
            for (int i16 = 0; i16 < i3; i16++) {
                cArr[i16] = c16;
            }
            return new String(cArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cannot pad a negative amount: ");
        stringBuffer.append(i3);
        throw new IndexOutOfBoundsException(stringBuffer.toString());
    }

    public static String prechomp(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(indexOf + str2.length());
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    public static String removeEnd(String str, String str2) {
        if (!isEmpty(str) && !isEmpty(str2) && str.endsWith(str2)) {
            return str.substring(0, str.length() - str2.length());
        }
        return str;
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        if (!isEmpty(str) && !isEmpty(str2) && endsWithIgnoreCase(str, str2)) {
            return str.substring(0, str.length() - str2.length());
        }
        return str;
    }

    public static String removeStart(String str, String str2) {
        if (!isEmpty(str) && !isEmpty(str2) && str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return str;
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        if (!isEmpty(str) && !isEmpty(str2) && startsWithIgnoreCase(str, str2)) {
            return str.substring(str2.length());
        }
        return str;
    }

    public static String repeat(String str, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 <= 0) {
            return "";
        }
        int length = str.length();
        if (i3 == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i3 <= 8192) {
            return padding(i3, str.charAt(0));
        }
        int i16 = length * i3;
        if (length == 1) {
            char charAt = str.charAt(0);
            char[] cArr = new char[i16];
            for (int i17 = i3 - 1; i17 >= 0; i17--) {
                cArr[i17] = charAt;
            }
            return new String(cArr);
        }
        if (length != 2) {
            StrBuilder strBuilder = new StrBuilder(i16);
            for (int i18 = 0; i18 < i3; i18++) {
                strBuilder.append(str);
            }
            return strBuilder.toString();
        }
        char charAt2 = str.charAt(0);
        char charAt3 = str.charAt(1);
        char[] cArr2 = new char[i16];
        for (int i19 = (i3 * 2) - 2; i19 >= 0; i19 = (i19 - 1) - 1) {
            cArr2[i19] = charAt2;
            cArr2[i19 + 1] = charAt3;
        }
        return new String(cArr2);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public static String replaceChars(String str, char c16, char c17) {
        if (str == null) {
            return null;
        }
        return str.replace(c16, c17);
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        int length;
        if (strArr == null) {
            length = 0;
        } else {
            length = strArr.length;
        }
        return replaceEach(str, strArr, strArr2, true, length);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StrBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c16) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, c16);
        ArrayUtils.reverse(split);
        return join(split, c16);
    }

    public static String reverseDelimitedString(String str, String str2) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, str2);
        ArrayUtils.reverse(split);
        if (str2 == null) {
            return join(split, TokenParser.SP);
        }
        return join(split, str2);
    }

    public static String right(String str, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 < 0) {
            return "";
        }
        if (str.length() <= i3) {
            return str;
        }
        return str.substring(str.length() - i3);
    }

    public static String rightPad(String str, int i3) {
        return rightPad(str, i3, TokenParser.SP);
    }

    public static String[] split(String str) {
        return split(str, null, -1);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    private static String[] splitByWholeSeparatorWorker(String str, String str2, int i3, boolean z16) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 != null && !"".equals(str2)) {
            int length2 = str2.length();
            ArrayList arrayList = new ArrayList();
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i16 < length) {
                i16 = str.indexOf(str2, i17);
                if (i16 > -1) {
                    if (i16 > i17) {
                        i18++;
                        if (i18 == i3) {
                            arrayList.add(str.substring(i17));
                        } else {
                            arrayList.add(str.substring(i17, i16));
                        }
                    } else if (z16) {
                        i18++;
                        if (i18 == i3) {
                            arrayList.add(str.substring(i17));
                            i16 = length;
                        } else {
                            arrayList.add("");
                        }
                    }
                    i17 = i16 + length2;
                } else {
                    arrayList.add(str.substring(i17));
                }
                i16 = length;
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return splitWorker(str, null, i3, z16);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, null, -1, true);
    }

    private static String[] splitWorker(String str, char c16, boolean z16) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        boolean z17 = false;
        boolean z18 = false;
        int i16 = 0;
        while (i3 < length) {
            if (str.charAt(i3) == c16) {
                if (z17 || z16) {
                    arrayList.add(str.substring(i16, i3));
                    z17 = false;
                    z18 = true;
                }
                i16 = i3 + 1;
                i3 = i16;
            } else {
                i3++;
                z18 = false;
                z17 = true;
            }
        }
        if (z17 || (z16 && z18)) {
            arrayList.add(str.substring(i16, i3));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean startsWith(String str, String str2) {
        return startsWith(str, str2, false);
    }

    public static boolean startsWithAny(String str, String[] strArr) {
        if (!isEmpty(str) && !ArrayUtils.isEmpty(strArr)) {
            for (String str2 : strArr) {
                if (startsWith(str, str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        return startsWith(str, str2, true);
    }

    public static String strip(String str) {
        return strip(str, null);
    }

    public static String[] stripAll(String[] strArr) {
        return stripAll(strArr, null);
    }

    public static String stripEnd(String str, String str2) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            if (str2 == null) {
                while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                    length--;
                }
            } else {
                if (str2.length() == 0) {
                    return str;
                }
                while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                    length--;
                }
            }
            return str.substring(0, length);
        }
        return str;
    }

    public static String stripStart(String str, String str2) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            int i3 = 0;
            if (str2 == null) {
                while (i3 != length && Character.isWhitespace(str.charAt(i3))) {
                    i3++;
                }
            } else {
                if (str2.length() == 0) {
                    return str;
                }
                while (i3 != length && str2.indexOf(str.charAt(i3)) != -1) {
                    i3++;
                }
            }
            return str.substring(i3);
        }
        return str;
    }

    public static String stripToEmpty(String str) {
        if (str == null) {
            return "";
        }
        return strip(str, null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strip = strip(str, null);
        if (strip.length() == 0) {
            return null;
        }
        return strip;
    }

    public static String substring(String str, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 < 0) {
            i3 += str.length();
        }
        if (i3 < 0) {
            i3 = 0;
        }
        return i3 > str.length() ? "" : str.substring(i3);
    }

    public static String substringAfter(String str, String str2) {
        int indexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (str2 == null || (indexOf = str.indexOf(str2)) == -1) {
            return "";
        }
        return str.substring(indexOf + str2.length());
    }

    public static String substringAfterLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) {
            return "";
        }
        return str.substring(lastIndexOf + str2.length());
    }

    public static String substringBefore(String str, String str2) {
        if (!isEmpty(str) && str2 != null) {
            if (str2.length() == 0) {
                return "";
            }
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                return str;
            }
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static String substringBeforeLast(String str, String str2) {
        if (!isEmpty(str) && !isEmpty(str2)) {
            int lastIndexOf = str.lastIndexOf(str2);
            if (lastIndexOf == -1) {
                return str;
            }
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String[] substringsBetween(String str, String str2, String str3) {
        int indexOf;
        int i3;
        int indexOf2;
        if (str == null || isEmpty(str2) || isEmpty(str3)) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        int length2 = str3.length();
        int length3 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        while (i16 < length - length2 && (indexOf = str.indexOf(str2, i16)) >= 0 && (indexOf2 = str.indexOf(str3, (i3 = indexOf + length3))) >= 0) {
            arrayList.add(str.substring(i3, indexOf2));
            i16 = indexOf2 + length2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String swapCase(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            StrBuilder strBuilder = new StrBuilder(length);
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (Character.isUpperCase(charAt)) {
                    charAt = Character.toLowerCase(charAt);
                } else if (Character.isTitleCase(charAt)) {
                    charAt = Character.toLowerCase(charAt);
                } else if (Character.isLowerCase(charAt)) {
                    charAt = Character.toUpperCase(charAt);
                }
                strBuilder.append(charAt);
            }
            return strBuilder.toString();
        }
        return str;
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        if (isEmpty(trim)) {
            return null;
        }
        return trim;
    }

    public static String uncapitalise(String str) {
        return uncapitalize(str);
    }

    public static String uncapitalize(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            return new StrBuilder(length).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
        }
        return str;
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String abbreviate(String str, int i3, int i16) {
        if (str == null) {
            return null;
        }
        if (i16 >= 4) {
            if (str.length() <= i16) {
                return str;
            }
            if (i3 > str.length()) {
                i3 = str.length();
            }
            int i17 = i16 - 3;
            if (str.length() - i3 < i17) {
                i3 = str.length() - i17;
            }
            if (i3 <= 4) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str.substring(0, i17));
                stringBuffer.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                return stringBuffer.toString();
            }
            if (i16 >= 7) {
                if (i3 + i17 < str.length()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    stringBuffer2.append(abbreviate(str.substring(i3), i17));
                    return stringBuffer2.toString();
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                stringBuffer3.append(str.substring(str.length() - i17));
                return stringBuffer3.toString();
            }
            throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
        }
        throw new IllegalArgumentException("Minimum abbreviation width is 4");
    }

    public static String center(String str, int i3, char c16) {
        int length;
        int length2;
        return (str == null || i3 <= 0 || (length2 = i3 - (length = str.length())) <= 0) ? str : rightPad(leftPad(str, length + (length2 / 2), c16), i3, c16);
    }

    public static String chompLast(String str, String str2) {
        return (str.length() != 0 && str2.equals(str.substring(str.length() - str2.length()))) ? str.substring(0, str.length() - str2.length()) : str;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    private static boolean endsWith(String str, String str2, boolean z16) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (str2.length() > str.length()) {
            return false;
        }
        return str.regionMatches(z16, str.length() - str2.length(), str2, 0, str2.length());
    }

    public static String getNestedString(String str, String str2, String str3) {
        return substringBetween(str, str2, str3);
    }

    public static int indexOfIgnoreCase(String str, String str2, int i3) {
        if (str != null && str2 != null) {
            if (i3 < 0) {
                i3 = 0;
            }
            int length = (str.length() - str2.length()) + 1;
            if (i3 > length) {
                return -1;
            }
            if (str2.length() == 0) {
                return i3;
            }
            while (i3 < length) {
                if (str.regionMatches(true, i3, str2, 0, str2.length())) {
                    return i3;
                }
                i3++;
            }
        }
        return -1;
    }

    public static String join(Object[] objArr, char c16) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c16, 0, objArr.length);
    }

    public static int lastIndexOfIgnoreCase(String str, String str2, int i3) {
        if (str != null && str2 != null) {
            if (i3 > str.length() - str2.length()) {
                i3 = str.length() - str2.length();
            }
            if (i3 < 0) {
                return -1;
            }
            if (str2.length() == 0) {
                return i3;
            }
            while (i3 >= 0) {
                if (str.regionMatches(true, i3, str2, 0, str2.length())) {
                    return i3;
                }
                i3--;
            }
        }
        return -1;
    }

    public static String leftPad(String str, int i3, char c16) {
        if (str == null) {
            return null;
        }
        int length = i3 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i3, String.valueOf(c16));
        }
        return padding(length, c16).concat(str);
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(locale);
    }

    private static int ordinalIndexOf(String str, String str2, int i3, boolean z16) {
        if (str != null && str2 != null && i3 > 0) {
            int i16 = 0;
            if (str2.length() == 0) {
                if (z16) {
                    return str.length();
                }
                return 0;
            }
            r0 = z16 ? str.length() : -1;
            do {
                if (z16) {
                    r0 = str.lastIndexOf(str2, r0 - 1);
                } else {
                    r0 = str.indexOf(str2, r0 + 1);
                }
                if (r0 < 0) {
                    return r0;
                }
                i16++;
            } while (i16 < i3);
        }
        return r0;
    }

    public static String replace(String str, String str2, String str3, int i3) {
        int i16;
        if (isEmpty(str) || isEmpty(str2) || str3 == null || i3 == 0) {
            return str;
        }
        int i17 = 0;
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        if (i3 < 0) {
            i16 = 16;
        } else {
            i16 = 64;
            if (i3 <= 64) {
                i16 = i3;
            }
        }
        StrBuilder strBuilder = new StrBuilder(str.length() + (length2 * i16));
        while (indexOf != -1) {
            strBuilder.append(str.substring(i17, indexOf)).append(str3);
            i17 = indexOf + length;
            i3--;
            if (i3 == 0) {
                break;
            }
            indexOf = str.indexOf(str2, i17);
        }
        strBuilder.append(str.substring(i17));
        return strBuilder.toString();
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int length2 = str.length();
        StrBuilder strBuilder = new StrBuilder(length2);
        boolean z16 = false;
        for (int i3 = 0; i3 < length2; i3++) {
            char charAt = str.charAt(i3);
            int indexOf = str2.indexOf(charAt);
            if (indexOf >= 0) {
                if (indexOf < length) {
                    strBuilder.append(str3.charAt(indexOf));
                }
                z16 = true;
            } else {
                strBuilder.append(charAt);
            }
        }
        return z16 ? strBuilder.toString() : str;
    }

    private static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z16, int i3) {
        String str2;
        String str3;
        int length;
        String str4;
        if (str == null || str.length() == 0 || strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return str;
        }
        if (i3 >= 0) {
            int length2 = strArr.length;
            int length3 = strArr2.length;
            if (length2 == length3) {
                boolean[] zArr = new boolean[length2];
                int i16 = -1;
                int i17 = -1;
                for (int i18 = 0; i18 < length2; i18++) {
                    if (!zArr[i18] && (str4 = strArr[i18]) != null && str4.length() != 0 && strArr2[i18] != null) {
                        int indexOf = str.indexOf(strArr[i18]);
                        if (indexOf == -1) {
                            zArr[i18] = true;
                        } else if (i16 == -1 || indexOf < i16) {
                            i17 = i18;
                            i16 = indexOf;
                        }
                    }
                }
                if (i16 == -1) {
                    return str;
                }
                int i19 = 0;
                for (int i26 = 0; i26 < strArr.length; i26++) {
                    if (strArr[i26] != null && (str3 = strArr2[i26]) != null && (length = str3.length() - strArr[i26].length()) > 0) {
                        i19 += length * 3;
                    }
                }
                StrBuilder strBuilder = new StrBuilder(str.length() + Math.min(i19, str.length() / 5));
                int i27 = 0;
                while (i16 != -1) {
                    while (i27 < i16) {
                        strBuilder.append(str.charAt(i27));
                        i27++;
                    }
                    strBuilder.append(strArr2[i17]);
                    i27 = strArr[i17].length() + i16;
                    i16 = -1;
                    i17 = -1;
                    for (int i28 = 0; i28 < length2; i28++) {
                        if (!zArr[i28] && (str2 = strArr[i28]) != null && str2.length() != 0 && strArr2[i28] != null) {
                            int indexOf2 = str.indexOf(strArr[i28], i27);
                            if (indexOf2 == -1) {
                                zArr[i28] = true;
                            } else if (i16 == -1 || indexOf2 < i16) {
                                i17 = i28;
                                i16 = indexOf2;
                            }
                        }
                    }
                }
                int length4 = str.length();
                while (i27 < length4) {
                    strBuilder.append(str.charAt(i27));
                    i27++;
                }
                String strBuilder2 = strBuilder.toString();
                return !z16 ? strBuilder2 : replaceEach(strBuilder2, strArr, strArr2, z16, i3 - 1);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Search and Replace array lengths don't match: ");
            stringBuffer.append(length2);
            stringBuffer.append(" vs ");
            stringBuffer.append(length3);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("TimeToLive of ");
        stringBuffer2.append(i3);
        stringBuffer2.append(" is less than 0: ");
        stringBuffer2.append(str);
        throw new IllegalStateException(stringBuffer2.toString());
    }

    public static String rightPad(String str, int i3, char c16) {
        if (str == null) {
            return null;
        }
        int length = i3 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i3, String.valueOf(c16));
        }
        return str.concat(padding(length, c16));
    }

    public static String[] split(String str, char c16) {
        return splitWorker(str, c16, false);
    }

    private static String[] splitByCharacterType(String str, boolean z16) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int type = Character.getType(charArray[0]);
        for (int i16 = 1; i16 < charArray.length; i16++) {
            int type2 = Character.getType(charArray[i16]);
            if (type2 != type) {
                if (z16 && type2 == 2 && type == 1) {
                    int i17 = i16 - 1;
                    if (i17 != i3) {
                        arrayList.add(new String(charArray, i3, i17 - i3));
                        i3 = i17;
                    }
                } else {
                    arrayList.add(new String(charArray, i3, i16 - i3));
                    i3 = i16;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i3, charArray.length - i3));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i3) {
        return splitByWholeSeparatorWorker(str, str2, i3, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i3) {
        return splitByWholeSeparatorWorker(str, str2, i3, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c16) {
        return splitWorker(str, c16, true);
    }

    private static boolean startsWith(String str, String str2, boolean z16) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        if (str2.length() > str.length()) {
            return false;
        }
        return str.regionMatches(z16, 0, str2, 0, str2.length());
    }

    public static String strip(String str, String str2) {
        return isEmpty(str) ? str : stripEnd(stripStart(str, str2), str2);
    }

    public static String[] stripAll(String[] strArr, String str) {
        int length;
        if (strArr == null || (length = strArr.length) == 0) {
            return strArr;
        }
        String[] strArr2 = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            strArr2[i3] = strip(strArr[i3], str);
        }
        return strArr2;
    }

    public static String substringBetween(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(indexOf + str2.length(), indexOf2);
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(locale);
    }

    public static boolean contains(String str, String str2) {
        return (str == null || str2 == null || str.indexOf(str2) < 0) ? false : true;
    }

    public static int indexOf(String str, char c16, int i3) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.indexOf(c16, i3);
    }

    public static String join(Object[] objArr, char c16, int i3, int i16) {
        if (objArr == null) {
            return null;
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return "";
        }
        Object obj = objArr[i3];
        StrBuilder strBuilder = new StrBuilder(i17 * ((obj == null ? 16 : obj.toString().length()) + 1));
        for (int i18 = i3; i18 < i16; i18++) {
            if (i18 > i3) {
                strBuilder.append(c16);
            }
            Object obj2 = objArr[i18];
            if (obj2 != null) {
                strBuilder.append(obj2);
            }
        }
        return strBuilder.toString();
    }

    public static int lastIndexOf(String str, char c16, int i3) {
        if (isEmpty(str)) {
            return -1;
        }
        return str.lastIndexOf(c16, i3);
    }

    public static String remove(String str, char c16) {
        if (isEmpty(str) || str.indexOf(c16) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i3 = 0;
        for (char c17 : charArray) {
            if (c17 != c16) {
                charArray[i3] = c17;
                i3++;
            }
        }
        return new String(charArray, 0, i3);
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static boolean containsOnly(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return containsOnly(str, str2.toCharArray());
    }

    public static int indexOfDifference(String[] strArr) {
        if (strArr != null && strArr.length > 1) {
            int length = strArr.length;
            int i3 = Integer.MAX_VALUE;
            boolean z16 = true;
            int i16 = 0;
            boolean z17 = false;
            for (int i17 = 0; i17 < length; i17++) {
                String str = strArr[i17];
                if (str == null) {
                    z17 = true;
                    i3 = 0;
                } else {
                    i3 = Math.min(str.length(), i3);
                    i16 = Math.max(strArr[i17].length(), i16);
                    z16 = false;
                }
            }
            if (!z16 && (i16 != 0 || z17)) {
                if (i3 == 0) {
                    return 0;
                }
                int i18 = -1;
                for (int i19 = 0; i19 < i3; i19++) {
                    char charAt = strArr[0].charAt(i19);
                    int i26 = 1;
                    while (true) {
                        if (i26 >= length) {
                            break;
                        }
                        if (strArr[i26].charAt(i19) != charAt) {
                            i18 = i19;
                            break;
                        }
                        i26++;
                    }
                    if (i18 != -1) {
                        break;
                    }
                }
                return (i18 != -1 || i3 == i16) ? i18 : i3;
            }
        }
        return -1;
    }

    public static String[] split(String str, String str2, int i3) {
        return splitWorker(str, str2, i3, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i3) {
        return splitWorker(str, str2, i3, true);
    }

    public static String substring(String str, int i3, int i16) {
        if (str == null) {
            return null;
        }
        if (i16 < 0) {
            i16 += str.length();
        }
        if (i3 < 0) {
            i3 += str.length();
        }
        if (i16 > str.length()) {
            i16 = str.length();
        }
        if (i3 > i16) {
            return "";
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 < 0) {
            i16 = 0;
        }
        return str.substring(i3, i16);
    }

    public static String center(String str, int i3, String str2) {
        if (str == null || i3 <= 0) {
            return str;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str.length();
        int i16 = i3 - length;
        return i16 <= 0 ? str : rightPad(leftPad(str, length + (i16 / 2), str2), i3, str2);
    }

    public static int indexOf(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        return str.indexOf(str2);
    }

    public static int lastIndexOf(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        return str.lastIndexOf(str2);
    }

    public static String leftPad(String str, int i3, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i3 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i3, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i16 = 0; i16 < length2; i16++) {
            cArr[i16] = charArray[i16 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String rightPad(String str, int i3, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i3 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i3, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i16 = 0; i16 < length2; i16++) {
            cArr[i16] = charArray[i16 % length];
        }
        return str.concat(new String(cArr));
    }

    public static int indexOf(String str, String str2, int i3) {
        if (str == null || str2 == null) {
            return -1;
        }
        if (str2.length() == 0 && i3 >= str.length()) {
            return str.length();
        }
        return str.indexOf(str2, i3);
    }

    public static int lastIndexOf(String str, String str2, int i3) {
        if (str == null || str2 == null) {
            return -1;
        }
        return str.lastIndexOf(str2, i3);
    }

    public static boolean containsNone(String str, String str2) {
        if (str == null || str2 == null) {
            return true;
        }
        return containsNone(str, str2.toCharArray());
    }

    public static String chomp(String str, String str2) {
        return (isEmpty(str) || str2 == null || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static boolean containsAny(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        return containsAny(str, str2.toCharArray());
    }

    public static int indexOfAny(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return -1;
        }
        return indexOfAny(str, str2.toCharArray());
    }

    public static int indexOfAnyBut(String str, String str2) {
        if (!isEmpty(str) && !isEmpty(str2)) {
            int length = str.length();
            int i3 = 0;
            while (i3 < length) {
                char charAt = str.charAt(i3);
                boolean z16 = str2.indexOf(charAt) >= 0;
                int i16 = i3 + 1;
                if (i16 < length && CharUtils.isHighSurrogate(charAt)) {
                    char charAt2 = str.charAt(i16);
                    if (z16 && str2.indexOf(charAt2) < 0) {
                        return i3;
                    }
                } else if (!z16) {
                    return i3;
                }
                i3 = i16;
            }
        }
        return -1;
    }

    private static String[] splitWorker(String str, String str2, int i3, boolean z16) {
        int i16;
        boolean z17;
        boolean z18;
        int i17;
        int i18;
        boolean z19;
        boolean z26;
        int i19;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i18 = 0;
            z19 = false;
            z26 = false;
            i19 = 0;
            int i26 = 1;
            while (i18 < length) {
                if (Character.isWhitespace(str.charAt(i18))) {
                    if (z19 || z16) {
                        int i27 = i26 + 1;
                        if (i26 == i3) {
                            i18 = length;
                            z26 = false;
                        } else {
                            z26 = true;
                        }
                        arrayList.add(str.substring(i19, i18));
                        i26 = i27;
                        z19 = false;
                    }
                    i19 = i18 + 1;
                    i18 = i19;
                } else {
                    i18++;
                    z26 = false;
                    z19 = true;
                }
            }
        } else {
            if (str2.length() == 1) {
                char charAt = str2.charAt(0);
                i16 = 0;
                z17 = false;
                z18 = false;
                i17 = 0;
                int i28 = 1;
                while (i16 < length) {
                    if (str.charAt(i16) == charAt) {
                        if (z17 || z16) {
                            int i29 = i28 + 1;
                            if (i28 == i3) {
                                i16 = length;
                                z18 = false;
                            } else {
                                z18 = true;
                            }
                            arrayList.add(str.substring(i17, i16));
                            i28 = i29;
                            z17 = false;
                        }
                        i17 = i16 + 1;
                        i16 = i17;
                    } else {
                        i16++;
                        z18 = false;
                        z17 = true;
                    }
                }
            } else {
                i16 = 0;
                z17 = false;
                z18 = false;
                i17 = 0;
                int i36 = 1;
                while (i16 < length) {
                    if (str2.indexOf(str.charAt(i16)) >= 0) {
                        if (z17 || z16) {
                            int i37 = i36 + 1;
                            if (i36 == i3) {
                                i16 = length;
                                z18 = false;
                            } else {
                                z18 = true;
                            }
                            arrayList.add(str.substring(i17, i16));
                            i36 = i37;
                            z17 = false;
                        }
                        i17 = i16 + 1;
                        i16 = i17;
                    } else {
                        i16++;
                        z18 = false;
                        z17 = true;
                    }
                }
            }
            i18 = i16;
            z19 = z17;
            z26 = z18;
            i19 = i17;
        }
        if (z19 || (z16 && z26)) {
            arrayList.add(str.substring(i19, i18));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static int indexOfAny(String str, String[] strArr) {
        int indexOf;
        if (str == null || strArr == null) {
            return -1;
        }
        int i3 = Integer.MAX_VALUE;
        for (String str2 : strArr) {
            if (str2 != null && (indexOf = str.indexOf(str2)) != -1 && indexOf < i3) {
                i3 = indexOf;
            }
        }
        if (i3 == Integer.MAX_VALUE) {
            return -1;
        }
        return i3;
    }

    public static String join(Object[] objArr, String str, int i3, int i16) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return "";
        }
        Object obj = objArr[i3];
        StrBuilder strBuilder = new StrBuilder(i17 * ((obj == null ? 16 : obj.toString().length()) + str.length()));
        for (int i18 = i3; i18 < i16; i18++) {
            if (i18 > i3) {
                strBuilder.append(str);
            }
            Object obj2 = objArr[i18];
            if (obj2 != null) {
                strBuilder.append(obj2);
            }
        }
        return strBuilder.toString();
    }

    public static String join(Iterator it, char c16) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StrBuilder strBuilder = new StrBuilder(256);
        if (next != null) {
            strBuilder.append(next);
        }
        while (it.hasNext()) {
            strBuilder.append(c16);
            Object next2 = it.next();
            if (next2 != null) {
                strBuilder.append(next2);
            }
        }
        return strBuilder.toString();
    }

    public static String repeat(String str, String str2, int i3) {
        if (str != null && str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(str2);
            return removeEnd(repeat(stringBuffer.toString(), i3), str2);
        }
        return repeat(str, i3);
    }

    public static String join(Iterator it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return ObjectUtils.toString(next);
        }
        StrBuilder strBuilder = new StrBuilder(256);
        if (next != null) {
            strBuilder.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                strBuilder.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                strBuilder.append(next2);
            }
        }
        return strBuilder.toString();
    }

    public static String join(Collection collection, char c16) {
        if (collection == null) {
            return null;
        }
        return join(collection.iterator(), c16);
    }

    public static String join(Collection collection, String str) {
        if (collection == null) {
            return null;
        }
        return join(collection.iterator(), str);
    }
}
