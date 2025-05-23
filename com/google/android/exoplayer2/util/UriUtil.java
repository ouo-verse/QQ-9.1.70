package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class UriUtil {
    private static final int FRAGMENT = 3;
    private static final int INDEX_COUNT = 4;
    private static final int PATH = 1;
    private static final int QUERY = 2;
    private static final int SCHEME_COLON = 0;

    UriUtil() {
    }

    private static int[] getUriIndices(String str) {
        boolean z16;
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
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
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

    private static String removeDotSegments(StringBuilder sb5, int i3, int i16) {
        int i17;
        int i18;
        int i19;
        if (i3 >= i16) {
            return sb5.toString();
        }
        if (sb5.charAt(i3) == '/') {
            i3++;
        }
        int i26 = i3;
        int i27 = i26;
        while (i26 <= i16) {
            if (i26 == i16) {
                i17 = i26;
            } else if (sb5.charAt(i26) == '/') {
                i17 = i26 + 1;
            } else {
                i26++;
            }
            int i28 = i27 + 1;
            if (i26 == i28 && sb5.charAt(i27) == '.') {
                sb5.delete(i27, i17);
                i16 -= i17 - i27;
            } else {
                if (i26 == i27 + 2 && sb5.charAt(i27) == '.' && sb5.charAt(i28) == '.') {
                    i18 = sb5.lastIndexOf("/", i27 - 2) + 1;
                    if (i18 > i3) {
                        i19 = i18;
                    } else {
                        i19 = i3;
                    }
                    sb5.delete(i19, i17);
                    i16 -= i17 - i19;
                } else {
                    i18 = i26 + 1;
                }
                i27 = i18;
            }
            i26 = i27;
        }
        return sb5.toString();
    }

    public static String resolve(String str, String str2) {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] uriIndices = getUriIndices(str2);
        if (uriIndices[0] != -1) {
            sb5.append(str2);
            removeDotSegments(sb5, uriIndices[1], uriIndices[2]);
            return sb5.toString();
        }
        int[] uriIndices2 = getUriIndices(str);
        if (uriIndices[3] == 0) {
            sb5.append((CharSequence) str, 0, uriIndices2[3]);
            sb5.append(str2);
            return sb5.toString();
        }
        if (uriIndices[2] == 0) {
            sb5.append((CharSequence) str, 0, uriIndices2[2]);
            sb5.append(str2);
            return sb5.toString();
        }
        int i16 = uriIndices[1];
        if (i16 != 0) {
            int i17 = uriIndices2[0] + 1;
            sb5.append((CharSequence) str, 0, i17);
            sb5.append(str2);
            return removeDotSegments(sb5, uriIndices[1] + i17, i17 + uriIndices[2]);
        }
        if (str2.charAt(i16) == '/') {
            sb5.append((CharSequence) str, 0, uriIndices2[1]);
            sb5.append(str2);
            int i18 = uriIndices2[1];
            return removeDotSegments(sb5, i18, uriIndices[2] + i18);
        }
        int i19 = uriIndices2[0] + 2;
        int i26 = uriIndices2[1];
        if (i19 < i26 && i26 == uriIndices2[2]) {
            sb5.append((CharSequence) str, 0, i26);
            sb5.append('/');
            sb5.append(str2);
            int i27 = uriIndices2[1];
            return removeDotSegments(sb5, i27, uriIndices[2] + i27 + 1);
        }
        int lastIndexOf = str.lastIndexOf(47, uriIndices2[2] - 1);
        if (lastIndexOf == -1) {
            i3 = uriIndices2[1];
        } else {
            i3 = lastIndexOf + 1;
        }
        sb5.append((CharSequence) str, 0, i3);
        sb5.append(str2);
        return removeDotSegments(sb5, uriIndices2[1], i3 + uriIndices[2]);
    }

    public static Uri resolveToUri(String str, String str2) {
        return Uri.parse(resolve(str, str2));
    }
}
