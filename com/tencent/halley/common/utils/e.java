package com.tencent.halley.common.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e {
    public static boolean a(String str) {
        if (!str.startsWith(":") && str.contains(":")) {
            try {
                int parseInt = Integer.parseInt(str.split(":")[0], 16);
                return parseInt >= 0 && parseInt <= 65535 && ((parseInt >> 13) ^ 1) == 0;
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String str2 : split) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt >= 0 && parseInt <= 255) {
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }

    public static boolean c(String str) {
        boolean contains = str.contains("::");
        if (contains && str.indexOf("::") != str.lastIndexOf("::")) {
            return false;
        }
        if ((str.startsWith(":") && !str.startsWith("::")) || (str.endsWith(":") && !str.endsWith("::"))) {
            return false;
        }
        String[] split = str.split(":");
        if (contains) {
            ArrayList arrayList = new ArrayList(Arrays.asList(split));
            if (str.endsWith("::")) {
                arrayList.add("");
            } else if (str.startsWith("::") && !arrayList.isEmpty()) {
                arrayList.remove(0);
            }
            split = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        if (split.length > 8) {
            return false;
        }
        return a(split, contains);
    }

    private static boolean a(String[] strArr, boolean z16) {
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < strArr.length; i17++) {
            String str = strArr[i17];
            if (str.length() == 0) {
                i16++;
                if (i16 > 1) {
                    return false;
                }
            } else if (i17 == strArr.length - 1 && str.contains(".")) {
                if (!b(str)) {
                    return false;
                }
                i3 += 2;
                i16 = 0;
            } else {
                if (str.length() > 4) {
                    return false;
                }
                try {
                    int parseInt = Integer.parseInt(str, 16);
                    if (parseInt < 0 || parseInt > 65535) {
                        return false;
                    }
                    i16 = 0;
                } catch (NumberFormatException e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
            i3++;
        }
        return i3 <= 8 && (i3 >= 8 || z16);
    }
}
