package com.tencent.qqmini.sdk.core.utils;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import java.lang.Character;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class StringUtil {
    private static final String ELIPSE_CHARACTOR = "\u2026";
    public static final int ERR_ACC_INVALID = 4;
    public static final int ERR_UIN_EMPTY = 3;
    public static final int ERR_UIN_INVALID_EMAIL = 2;
    public static final int ERR_UIN_TOO_LONG = 1;
    public static final int ERR_UIN_TOO_SHORT = 0;
    public static final int RES_VALID_UIN = -1;

    public static String byte2HexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (Integer.toHexString(bArr[i3] & 255).length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(bArr[i3] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(bArr[i3] & 255));
            }
        }
        return stringBuffer.toString();
    }

    public static String crypticCenter(String str) {
        if (str != null) {
            int i3 = 2;
            if (str.length() >= 2) {
                int length = str.length() - 1;
                if (length != 1) {
                    i3 = length;
                }
                StringBuffer stringBuffer = new StringBuffer(str);
                stringBuffer.replace(1, i3, "*");
                return stringBuffer.toString();
            }
            return str;
        }
        return str;
    }

    public static String formatSize(long j3) {
        String str = "" + j3;
        if (j3 >= 0 && j3 < 1024) {
            return str + "B";
        }
        if (j3 >= 1024 && j3 < 1048576) {
            return Long.toString(j3 / 1024) + "KB";
        }
        if (j3 >= 1048576 && j3 < 1073741824) {
            return Long.toString(j3 / 1048576) + "MB";
        }
        if (j3 < 1073741824) {
            return "";
        }
        return Long.toString(j3 / 1073741824) + "GB";
    }

    public static String getElipseStringWide(String str, int i3) {
        boolean z16;
        double d16;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        float f16 = 0.0f;
        int i16 = 0;
        while (true) {
            if (i16 < str.length()) {
                double d17 = f16;
                if (isChinese(str.charAt(i16))) {
                    d16 = 2.0d;
                } else {
                    d16 = 1.5d;
                }
                f16 = (float) (d17 + d16);
                if (f16 > i3) {
                    z16 = true;
                    break;
                }
                i16++;
            } else {
                z16 = false;
                break;
            }
        }
        if (z16) {
            return str.substring(0, i16) + "\u2026";
        }
        return str;
    }

    public static String getIPFromUrl(String str) {
        if (str == null) {
            return "";
        }
        Matcher matcher = Pattern.compile("\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b").matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        Matcher matcher2 = Pattern.compile("(?<=http://)[\\w\\.]+[^/]", 2).matcher(str);
        if (!matcher2.find()) {
            return "";
        }
        return matcher2.group();
    }

    public static String getSimpleUinForPrint(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 4) {
            return substring(str, str.length() - 4, str.length());
        }
        return str;
    }

    public static int getWordCount(String str) {
        if (str == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            char charAt = str.charAt(i16);
            if (charAt >= 0 && charAt <= '\u00ff') {
                i3++;
            } else {
                i3 += 2;
            }
        }
        return i3;
    }

    public static int getWordCountNeo(String str) {
        int i3 = 0;
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i16 = 0;
        while (i3 < length) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 0 && codePointAt <= 255) {
                i16++;
            } else {
                i16 += 2;
            }
            i3 += Character.charCount(codePointAt);
        }
        return i16;
    }

    public static byte[] hexStr2Bytes(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            int digit = Character.digit(charArray[i16 + 1], 16) | (Character.digit(charArray[i16], 16) << 4);
            if (digit > 127) {
                digit -= 256;
            }
            bArr[i3] = (byte) digit;
        }
        return bArr;
    }

    public static int hexToInt(String str, int i3, int i16) {
        long j3 = 0;
        while (i3 < i16) {
            j3 = (j3 * 16) + Integer.parseInt(str.substring(i3, r2), 16);
            i3++;
        }
        return (int) j3;
    }

    public static boolean isAlphaDigit(char c16) {
        if (!Character.isDigit(c16) && ((c16 < 'A' || c16 > 'Z') && (c16 < 'a' || c16 > 'z'))) {
            return false;
        }
        return true;
    }

    public static boolean isAsciiAlpha(char c16) {
        if ((c16 >= 'A' && c16 <= 'Z') || (c16 >= 'a' && c16 <= 'z')) {
            return true;
        }
        return false;
    }

    public static boolean isChinese(char c16) {
        Character.UnicodeBlock of5 = Character.UnicodeBlock.of(c16);
        if (of5 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS && of5 != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS && of5 != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A && of5 != Character.UnicodeBlock.GENERAL_PUNCTUATION && of5 != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION && of5 != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isNoneOutOfDateMobileNum(String str) {
        if (str == null || "".equals(str.trim()) || str.trim().equals("0")) {
            return false;
        }
        return true;
    }

    public static boolean isReadableChar(char c16) {
        if (Character.isISOControl(c16) && !Character.isLetterOrDigit(c16) && !Character.isSpace(c16) && !Character.isSpaceChar(c16)) {
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String str) {
        return Pattern.compile("^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", 2).matcher(str).matches();
    }

    public static boolean isValidMobileNumForHead(String str) {
        if (str != null && !"".equals(str.trim()) && str.trim().startsWith(Marker.ANY_NON_NULL_MARKER)) {
            return true;
        }
        return false;
    }

    public static boolean isValideUin(String str) {
        String trim;
        int length;
        if (str == null || "".equals(str.trim()) || (length = (trim = str.trim()).length()) < 5) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isDigit(trim.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static HashMap<String, String> json2map(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject == null) {
            return hashMap;
        }
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, jSONObject.getString(str));
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public static String listToString(List<? extends Object> list, String str) {
        if (list != null && list.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < list.size(); i3++) {
                stringBuffer.append(list.get(i3).toString());
                stringBuffer.append(str);
            }
            stringBuffer.delete(stringBuffer.lastIndexOf(str), stringBuffer.length());
            return stringBuffer.toString();
        }
        return "";
    }

    public static String longToString(long j3) {
        BigInteger valueOf = BigInteger.valueOf(j3);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(BigInteger.ONE.shiftLeft(64));
        }
        return valueOf.toString();
    }

    public static String makeLogMsg(Object... objArr) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        for (Object obj : objArr) {
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(" , ");
        }
        sb5.append("]");
        return sb5.toString();
    }

    public static String[] split(String str, char c16) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList(50);
        char[] charArray = str.toCharArray();
        int i3 = 0;
        boolean z16 = false;
        int i16 = 0;
        while (i3 < length) {
            if (charArray[i3] == c16) {
                arrayList.add(str.substring(i16, i3));
                i16 = i3 + 1;
                z16 = true;
                i3 = i16;
            } else {
                i3++;
                z16 = false;
            }
        }
        if (!z16) {
            arrayList.add(str.substring(i16, i3));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String stringFilter(String str) {
        return Pattern.compile("[\u300e\u300f]").matcher(str.replaceAll("\u3010", "[").replaceAll("\u3011", "]").replaceAll("\uff01", "!").replaceAll("\uff1a", ":")).replaceAll("").trim();
    }

    public static long stringToLong(String str, String str2) {
        try {
            return Long.parseLong(str2);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String substring(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) < 0 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) < 0) {
            return null;
        }
        return str.substring(indexOf + str2.length(), indexOf2);
    }

    public static String substringNeo(String str, int i3, int i16) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(i16);
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            if (getWordCountNeo(stringBuffer.toString() + charAt) > i16) {
                break;
            }
            stringBuffer.append(charAt);
            i3++;
        }
        return stringBuffer.toString();
    }

    public static String to8BitAsciiString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length);
        for (byte b16 : bArr) {
            sb5.appendCodePoint(b16 & 255);
        }
        return sb5.toString();
    }

    public static String toDBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            char c16 = charArray[i3];
            if (c16 == '\u3000') {
                charArray[i3] = TokenParser.SP;
            } else if (c16 > '\uff00' && c16 < '\uff5f') {
                charArray[i3] = (char) (c16 - '\ufee0');
            }
        }
        return new String(charArray);
    }

    public static String toHexString(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : str.getBytes()) {
            stringBuffer.append(Integer.toHexString(new Integer(b16 & 255).intValue()));
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    public static String toNoSpaceHexString(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : str.getBytes()) {
            stringBuffer.append(Integer.toHexString(new Integer(b16 & 255).intValue()));
        }
        return stringBuffer.toString();
    }

    public static String toSemiAngleString(String str) {
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            char c16 = charArray[i3];
            if (c16 == '\u3000') {
                charArray[i3] = TokenParser.SP;
            } else if (c16 > '\uff00' && c16 < '\uff5f') {
                charArray[i3] = (char) (c16 - '\ufee0');
            }
        }
        return String.valueOf(charArray);
    }

    public static String trim(String str) {
        if (str != null && !"".equals(str)) {
            StringBuffer stringBuffer = new StringBuffer(str);
            while (stringBuffer.length() > 0 && (Character.isWhitespace(stringBuffer.charAt(0)) || stringBuffer.charAt(0) == 0)) {
                stringBuffer.deleteCharAt(0);
            }
            for (int length = stringBuffer.length(); length > 0; length = stringBuffer.length()) {
                int i3 = length - 1;
                if (!Character.isWhitespace(stringBuffer.charAt(i3)) && stringBuffer.charAt(0) != 0) {
                    break;
                }
                stringBuffer.deleteCharAt(i3);
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static String trimUnreadableInFriendRequest(String str) {
        if (str == null) {
            return "";
        }
        int i3 = 0;
        int i16 = 0;
        boolean z16 = true;
        for (int i17 = 0; i17 < str.length(); i17++) {
            if (z16) {
                if (isReadableChar(str.charAt(i17))) {
                    z16 = false;
                    i16 = i17;
                }
            } else if (isReadableChar(str.charAt(i17)) && (str.length() - 1 == i17 || !isReadableChar(str.charAt(i17 + 1)))) {
                i3 = i17;
                break;
            }
        }
        int i18 = i3 + 1;
        if (i16 >= i18) {
            return "";
        }
        if (i18 >= str.length()) {
            i18 = str.length();
        }
        return str.substring(i16, i18);
    }

    public static int validateAccount(String str) {
        if (str != null && !"".equals(str.trim())) {
            String trim = str.trim();
            int length = trim.length();
            boolean z16 = true;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Character.isDigit(trim.charAt(i3))) {
                    z16 = false;
                }
            }
            if (z16) {
                if (length < 5) {
                    return 0;
                }
                if (length > 15) {
                    return 1;
                }
            } else if (trim.contains("@")) {
                if (!isValidEmail(trim)) {
                    return 2;
                }
            } else {
                return 4;
            }
            return -1;
        }
        return 3;
    }

    public static boolean verifyUin(String str) {
        try {
            if (Long.valueOf(Long.parseLong(str)).longValue() <= 10000) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String substring(String str, int i3, int i16) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(i16);
        int i17 = 0;
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            i17 = (charAt < 0 || charAt > '\u00ff') ? i17 + 2 : i17 + 1;
            if (i17 > i16) {
                break;
            }
            stringBuffer.append(charAt);
            i3++;
        }
        return stringBuffer.toString();
    }

    public static String substring(String str, int i3, int i16, String str2) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i17 = 0;
        while (true) {
            if (i3 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i3);
            i17 = (charAt < 0 || charAt > '\u00ff') ? i17 + 2 : i17 + 1;
            if (i17 > i16) {
                stringBuffer.append(str2);
                break;
            }
            stringBuffer.append(charAt);
            i3++;
        }
        return stringBuffer.toString();
    }
}
