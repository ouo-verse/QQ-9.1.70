package com.pay.http;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class APToolNetwork {
    private static final int BASE_16 = 16;
    private static final int IPV6_MAX_HEX_DIGITS_PER_GROUP = 4;
    private static final int IPV6_MAX_HEX_GROUPS = 8;
    private static final int MAX_UNSIGNED_SHORT = 65535;
    private static final Pattern PATTERN = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public static boolean isIPAddress(String str) {
        if (!validateIPV4(str) && !validateIPV6(str)) {
            return false;
        }
        return true;
    }

    public static String joinDomainPort(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (validateIPV4(str)) {
                return str + ":" + str2;
            }
            if (validateIPV6(str)) {
                return "[" + str + "]:" + str2;
            }
            return str;
        }
        return str;
    }

    public static boolean validateIPV4(String str) {
        return Patterns.IP_ADDRESS.matcher(str).matches();
    }

    public static boolean validateIPV6(String str) {
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
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < split.length; i17++) {
            String str2 = split[i17];
            if (str2.length() == 0) {
                i16++;
                if (i16 > 1) {
                    return false;
                }
            } else if (i17 == split.length - 1 && str2.contains(".")) {
                if (!Patterns.IP_ADDRESS.matcher(str2).matches()) {
                    return false;
                }
                i3 += 2;
                i16 = 0;
            } else {
                if (str2.length() > 4) {
                    return false;
                }
                try {
                    int parseInt = Integer.parseInt(str2, 16);
                    if (parseInt >= 0 && parseInt <= 65535) {
                        i16 = 0;
                    }
                } catch (NumberFormatException unused) {
                }
                return false;
            }
            i3++;
        }
        if (i3 > 8 || (i3 < 8 && !contains)) {
            return false;
        }
        return true;
    }
}
