package com.tencent.tmdownloader.internal.notification;

import java.nio.CharBuffer;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    protected static boolean a(char c16) {
        return c16 >= '\u00ff' || c16 < 0;
    }

    public static String a(String str, int i3, boolean z16, boolean z17) {
        int i16;
        String charSequence;
        if (str == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        CharBuffer decode = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(str));
        int length = decode.length();
        int i17 = 0;
        while (true) {
            if (i17 >= length) {
                break;
            }
            if (Character.isHighSurrogate(decode.charAt(i17))) {
                i16 = i17 + 2;
                charSequence = decode.subSequence(i17, i16).toString();
            } else {
                i16 = i17 + 1;
                charSequence = decode.subSequence(i17, i16).toString();
            }
            int a16 = a(charSequence);
            if (i3 >= a16) {
                i3 -= a16;
                sb5.append(charSequence);
                i17 = i16;
            } else if (z16 && !z17) {
                sb5.delete(sb5.length() - 2, sb5.length());
                sb5.append("\u2026");
            } else if (z16 && z17) {
                sb5.append("\u2026");
            }
        }
        return sb5.toString();
    }

    public static String a(String str, int i3, boolean z16) {
        int i16;
        String charSequence;
        if (str == null) {
            return "";
        }
        if (!z16) {
            return a(str, i3);
        }
        StringBuilder sb5 = new StringBuilder();
        CharBuffer decode = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(str));
        int length = decode.length();
        int i17 = 0;
        while (true) {
            if (i17 < length) {
                if (Character.isHighSurrogate(decode.charAt(i17))) {
                    i16 = i17 + 2;
                    charSequence = decode.subSequence(i17, i16).toString();
                } else {
                    i16 = i17 + 1;
                    charSequence = decode.subSequence(i17, i16).toString();
                }
                int a16 = a(charSequence);
                if (i3 >= a16) {
                    i3 -= a16;
                    sb5.append(charSequence);
                    i17 = i16;
                } else {
                    sb5.append("\u2026");
                    break;
                }
            } else {
                break;
            }
        }
        return sb5.toString();
    }

    public static String a(String str, int i3) {
        int i16;
        String charSequence;
        if (str == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        CharBuffer decode = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(str));
        int length = decode.length();
        int i17 = 0;
        while (true) {
            if (i17 < length) {
                if (Character.isHighSurrogate(decode.charAt(i17))) {
                    i16 = i17 + 2;
                    charSequence = decode.subSequence(i17, i16).toString();
                } else {
                    i16 = i17 + 1;
                    charSequence = decode.subSequence(i17, i16).toString();
                }
                int a16 = a(charSequence);
                if (i3 >= a16) {
                    i3 -= a16;
                    sb5.append(charSequence);
                    i17 = i16;
                } else {
                    sb5.delete(sb5.length() - 2, sb5.length());
                    sb5.append("\u2026");
                    break;
                }
            } else {
                break;
            }
        }
        return sb5.toString();
    }

    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            i3 = a(str.charAt(i16)) ? i3 + 2 : i3 + 1;
        }
        return i3;
    }
}
