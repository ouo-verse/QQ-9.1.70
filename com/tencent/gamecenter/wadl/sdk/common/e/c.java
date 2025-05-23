package com.tencent.gamecenter.wadl.sdk.common.e;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    public static com.tencent.gamecenter.wadl.sdk.downloader.b.d.b a(InetAddress[] inetAddressArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (inetAddressArr != null && inetAddressArr.length > 0) {
            for (InetAddress inetAddress : inetAddressArr) {
                if (inetAddress instanceof Inet4Address) {
                    arrayList.add(inetAddress.getHostAddress());
                } else if (inetAddress instanceof Inet6Address) {
                    arrayList2.add(inetAddress.getHostAddress());
                }
            }
        }
        return new com.tencent.gamecenter.wadl.sdk.downloader.b.d.b(arrayList, arrayList2);
    }

    public static String b(URL url, String str) {
        if (url == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String url2 = url.toString();
        String host = url.getHost();
        String replace = url2.replace(host, ("[" + str + "]") + "/" + url.getHost());
        b.c("Wadl_InetUtils", "[replaceDomainByV6Ip] result= " + replace + " getProtocol: " + url.getProtocol());
        return replace;
    }

    public static boolean c(String str) {
        int d16;
        boolean contains = str.contains("::");
        if (!a(str, contains)) {
            return false;
        }
        String[] a16 = a(str, contains, str.split(":"));
        if (a16.length > 8) {
            return false;
        }
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < a16.length; i17++) {
            String str2 = a16[i17];
            if (str2.length() == 0) {
                i16++;
                if (i16 > 1) {
                    return false;
                }
            } else if (i17 == a16.length - 1 && str2.contains(".")) {
                if (!b(str2)) {
                    return false;
                }
                i3 += 2;
                i16 = 0;
            } else {
                if (str2.length() > 4 || (d16 = d(str2)) < 0 || d16 > 65535) {
                    return false;
                }
                i16 = 0;
            }
            i3++;
        }
        if (a(i3, contains)) {
            return false;
        }
        return true;
    }

    private static int d(String str) {
        try {
            return Integer.parseInt(str, 16);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static String a(URL url, String str) {
        if (url == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String replace = url.toString().replace(url.getHost(), str + "/" + url.getHost());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[replaceDomainByV4Ip] result= ");
        sb5.append(replace);
        b.c("Wadl_InetUtils", sb5.toString());
        return replace;
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
                int i3 = (parseInt >= 0 && parseInt <= 255) ? i3 + 1 : 0;
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return true;
    }

    private static boolean a(int i3, boolean z16) {
        return i3 > 8 || (i3 < 8 && !z16);
    }

    public static boolean a(String str) {
        if (!str.startsWith(":") && str.contains(":")) {
            try {
                int parseInt = Integer.parseInt(str.split(":")[0], 16);
                if (parseInt >= 0 && parseInt <= 65535 && ((parseInt >> 13) ^ 1) == 0) {
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    private static boolean a(String str, boolean z16) {
        if (z16 && str.indexOf("::") != str.lastIndexOf("::")) {
            return false;
        }
        if (!str.startsWith(":") || str.startsWith("::")) {
            return !str.endsWith(":") || str.endsWith("::");
        }
        return false;
    }

    private static String[] a(String str, boolean z16, String[] strArr) {
        if (!z16) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        if (str.endsWith("::")) {
            arrayList.add("");
        } else if (str.startsWith("::") && !arrayList.isEmpty()) {
            arrayList.remove(0);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
