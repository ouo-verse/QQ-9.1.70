package com.tencent.open.base;

import com.tencent.mobileqq.tianshu.ui.RedTouch;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class j {
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        return str.replace(RedTouch.NEWLINE_CHAR, "\n").replace("&#92;", "\\").replace("&#39;", "'").replace("&quot;", "\"").replace("&gt;", ">").replace("&lt;", "<");
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("%7D", "%257D").replace("%3A;", "%253A").replace("%2C';", "%252C").replace("}", "%7D").replace(":", "%3A").replace(",", "%2C");
    }

    public static int c(String str) {
        if (str == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            if (e(str.charAt(i16))) {
                i3 += 2;
            } else {
                i3++;
            }
        }
        return i3;
    }

    public static boolean d(String str) {
        if (str != null && str.trim().length() != 0) {
            return false;
        }
        return true;
    }

    protected static boolean e(char c16) {
        if (c16 < '\u00ff' && c16 >= 0) {
            return false;
        }
        return true;
    }

    public static String[] f(String str, String str2) {
        if (str != null && str2 != null && str2.length() != 0) {
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                int indexOf = str.indexOf(str2, i3);
                if (indexOf < 0) {
                    break;
                }
                arrayList.add(str.substring(i3, indexOf));
                i3 = str2.length() + indexOf;
            }
            arrayList.add(str.substring(i3));
            for (int size = arrayList.size() - 1; size >= 0 && ((String) arrayList.get(size)).length() == 0; size--) {
                arrayList.remove(size);
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return null;
    }

    public static String g(String str, int i3, boolean z16, boolean z17) {
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
            int c16 = c(charSequence);
            if (i3 >= c16) {
                i3 -= c16;
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

    public static String h(String str, int i3) {
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
                int c16 = c(charSequence);
                if (i3 >= c16) {
                    i3 -= c16;
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

    public static String i(String str, int i3, boolean z16) {
        int i16;
        String charSequence;
        if (str == null) {
            return "";
        }
        if (!z16) {
            return h(str, i3);
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
                int c16 = c(charSequence);
                if (i3 >= c16) {
                    i3 -= c16;
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
}
