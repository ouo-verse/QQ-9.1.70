package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class EncodeUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37998a = "EncodeUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f37999b = {',', '.', '-'};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f38000c = new String[256];

    static {
        for (char c16 = 0; c16 < '\u00ff'; c16 = (char) (c16 + 1)) {
            if ((c16 >= '0' && c16 <= '9') || ((c16 >= 'A' && c16 <= 'Z') || (c16 >= 'a' && c16 <= 'z'))) {
                f38000c[c16] = null;
            } else {
                f38000c[c16] = b(c16).intern();
            }
        }
    }

    private static String a(char[] cArr, String str) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < str.length(); i3++) {
            sb5.append(a(cArr, Character.valueOf(str.charAt(i3))));
        }
        return sb5.toString();
    }

    private static String b(char c16) {
        return Integer.toHexString(c16);
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            a aVar = new a(str);
            while (aVar.a()) {
                Character a16 = a(aVar);
                if (a16 != null) {
                    sb5.append(a16);
                } else {
                    sb5.append(aVar.d());
                }
            }
            return sb5.toString();
        } catch (Exception e16) {
            Log.e(f37998a, "decode js: " + e16.getMessage());
            return "";
        }
    }

    public static String encodeForJavaScript(String str) {
        return encodeForJavaScript(str, f37999b);
    }

    public static String encodeForJavaScript(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(cArr, str);
        } catch (Exception e16) {
            Log.e(f37998a, "encode js: " + e16.getMessage());
            return "";
        }
    }

    private static String a(char[] cArr, Character ch5) {
        if (a(ch5.charValue(), cArr)) {
            return "" + ch5;
        }
        if (a(ch5.charValue()) == null) {
            return "" + ch5;
        }
        String hexString = Integer.toHexString(ch5.charValue());
        if (ch5.charValue() < '\u0100') {
            return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
        return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
    }

    private static boolean a(char c16, char[] cArr) {
        for (char c17 : cArr) {
            if (c16 == c17) {
                return true;
            }
        }
        return false;
    }

    private static String a(char c16) {
        if (c16 < '\u00ff') {
            return f38000c[c16];
        }
        return b(c16);
    }

    private static Character a(a aVar) {
        aVar.c();
        Character d16 = aVar.d();
        if (d16 == null) {
            aVar.i();
            return null;
        }
        if (d16.charValue() != '\\') {
            aVar.i();
            return null;
        }
        Character d17 = aVar.d();
        if (d17 == null) {
            aVar.i();
            return null;
        }
        if (d17.charValue() == 'b') {
            return '\b';
        }
        if (d17.charValue() == 't') {
            return '\t';
        }
        if (d17.charValue() == 'n') {
            return '\n';
        }
        if (d17.charValue() == 'v') {
            return (char) 11;
        }
        if (d17.charValue() == 'f') {
            return '\f';
        }
        if (d17.charValue() == 'r') {
            return '\r';
        }
        if (d17.charValue() == '\"') {
            return '\"';
        }
        if (d17.charValue() == '\'') {
            return '\'';
        }
        if (d17.charValue() == '\\') {
            return '\\';
        }
        int i3 = 0;
        if (Character.toLowerCase(d17.charValue()) == 'x') {
            StringBuilder sb5 = new StringBuilder();
            while (i3 < 2) {
                Character e16 = aVar.e();
                if (e16 != null) {
                    sb5.append(e16);
                    i3++;
                } else {
                    aVar.i();
                    return null;
                }
            }
            try {
                int parseInt = Integer.parseInt(sb5.toString(), 16);
                if (Character.isValidCodePoint(parseInt)) {
                    return Character.valueOf((char) parseInt);
                }
            } catch (NumberFormatException unused) {
                aVar.i();
                return null;
            }
        } else if (Character.toLowerCase(d17.charValue()) == 'u') {
            StringBuilder sb6 = new StringBuilder();
            while (i3 < 4) {
                Character e17 = aVar.e();
                if (e17 != null) {
                    sb6.append(e17);
                    i3++;
                } else {
                    aVar.i();
                    return null;
                }
            }
            try {
                int parseInt2 = Integer.parseInt(sb6.toString(), 16);
                if (Character.isValidCodePoint(parseInt2)) {
                    return Character.valueOf((char) parseInt2);
                }
            } catch (NumberFormatException unused2) {
                aVar.i();
                return null;
            }
        } else if (a.c(d17)) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(d17);
            Character d18 = aVar.d();
            if (!a.c(d18)) {
                aVar.a(d18);
            } else {
                sb7.append(d18);
                Character d19 = aVar.d();
                if (!a.c(d19)) {
                    aVar.a(d19);
                } else {
                    sb7.append(d19);
                }
            }
            try {
                int parseInt3 = Integer.parseInt(sb7.toString(), 8);
                if (Character.isValidCodePoint(parseInt3)) {
                    return Character.valueOf((char) parseInt3);
                }
            } catch (NumberFormatException unused3) {
                aVar.i();
                return null;
            }
        }
        return d17;
    }
}
