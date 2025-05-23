package com.tencent.luggage.wxa.n0;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class u {
    public static String a(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] a16 = a(str2);
        if (a16[0] != -1) {
            sb5.append(str2);
            a(sb5, a16[1], a16[2]);
            return sb5.toString();
        }
        int[] a17 = a(str);
        if (a16[3] == 0) {
            sb5.append((CharSequence) str, 0, a17[3]);
            sb5.append(str2);
            return sb5.toString();
        }
        if (a16[2] == 0) {
            sb5.append((CharSequence) str, 0, a17[2]);
            sb5.append(str2);
            return sb5.toString();
        }
        int i3 = a16[1];
        if (i3 != 0) {
            int i16 = a17[0] + 1;
            sb5.append((CharSequence) str, 0, i16);
            sb5.append(str2);
            return a(sb5, a16[1] + i16, i16 + a16[2]);
        }
        if (str2.charAt(i3) == '/') {
            sb5.append((CharSequence) str, 0, a17[1]);
            sb5.append(str2);
            int i17 = a17[1];
            return a(sb5, i17, a16[2] + i17);
        }
        int i18 = a17[0] + 2;
        int i19 = a17[1];
        if (i18 < i19 && i19 == a17[2]) {
            sb5.append((CharSequence) str, 0, i19);
            sb5.append('/');
            sb5.append(str2);
            int i26 = a17[1];
            return a(sb5, i26, a16[2] + i26 + 1);
        }
        int lastIndexOf = str.lastIndexOf(47, a17[2] - 1);
        int i27 = lastIndexOf == -1 ? a17[1] : lastIndexOf + 1;
        sb5.append((CharSequence) str, 0, i27);
        sb5.append(str2);
        return a(sb5, a17[1], i27 + a16[2]);
    }

    public static Uri b(String str, String str2) {
        return Uri.parse(a(str, str2));
    }

    public static String a(StringBuilder sb5, int i3, int i16) {
        int i17;
        int i18;
        if (i3 >= i16) {
            return sb5.toString();
        }
        if (sb5.charAt(i3) == '/') {
            i3++;
        }
        int i19 = i3;
        int i26 = i19;
        while (i19 <= i16) {
            if (i19 == i16) {
                i17 = i19;
            } else if (sb5.charAt(i19) == '/') {
                i17 = i19 + 1;
            } else {
                i19++;
            }
            int i27 = i26 + 1;
            if (i19 == i27 && sb5.charAt(i26) == '.') {
                sb5.delete(i26, i17);
                i16 -= i17 - i26;
            } else {
                if (i19 == i26 + 2 && sb5.charAt(i26) == '.' && sb5.charAt(i27) == '.') {
                    i18 = sb5.lastIndexOf("/", i26 - 2) + 1;
                    int i28 = i18 > i3 ? i18 : i3;
                    sb5.delete(i28, i17);
                    i16 -= i17 - i28;
                } else {
                    i18 = i19 + 1;
                }
                i26 = i18;
            }
            i19 = i26;
        }
        return sb5.toString();
    }

    public static int[] a(String str) {
        int i3;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i16 = indexOf4 + 2;
        if (i16 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i16) == '/') {
            i3 = str.indexOf(47, indexOf4 + 3);
            if (i3 == -1 || i3 > indexOf2) {
                i3 = indexOf2;
            }
        } else {
            i3 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i3;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }
}
