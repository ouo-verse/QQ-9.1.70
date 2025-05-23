package com.tencent.bugly.common.utils;

import com.tencent.rmonitor.common.logger.Logger;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NetWorkUtil {
    private static final String IPV4_LINK_LOCAL = "169\\.254\\.(?:[0-9]{1,3}\\.)[0-9]{1,3}";
    private static final String IPV4_LOOPBACK = "127\\.(?:[0-9]{1,3}\\.){2}[0-9]{1,3}";
    private static final String IPV4_PRIVATE_A = "10\\.(?:[0-9]{1,3}\\.){2}[0-9]{1,3}";
    private static final String IPV4_PRIVATE_B = "172\\.(?:1[6-9]|2[0-9]|3[0-1])\\.(?:[0-9]{1,3}\\.)[0-9]{1,3}";
    private static final String IPV4_PRIVATE_C = "192\\.168\\.(?:[0-9]{1,3}\\.)[0-9]{1,3}";
    private static final String IPV6_LINK_LOCAL = "fe80:(?::[0-9a-fA-F]{0,4}){0,7}";
    private static final String IPV6_LOOPBACK = "::1";
    private static final String IPV6_UNIQUE_LOCAL = "fc[0-9a-fA-F]{2}:(?::[0-9a-fA-F]{0,4}){0,7}";
    private static final Pattern LOCAL_IP_PATTERN = Pattern.compile("^(127\\.(?:[0-9]{1,3}\\.){2}[0-9]{1,3}|10\\.(?:[0-9]{1,3}\\.){2}[0-9]{1,3}|172\\.(?:1[6-9]|2[0-9]|3[0-1])\\.(?:[0-9]{1,3}\\.)[0-9]{1,3}|192\\.168\\.(?:[0-9]{1,3}\\.)[0-9]{1,3}|169\\.254\\.(?:[0-9]{1,3}\\.)[0-9]{1,3}|::1|fe80:(?::[0-9a-fA-F]{0,4}){0,7}|fc[0-9a-fA-F]{2}:(?::[0-9a-fA-F]{0,4}){0,7})$");
    public static final String TAG = "NetWorkUtil";

    public static boolean isLocalAddress(String str) {
        try {
            return LOCAL_IP_PATTERN.matcher(str).matches();
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
            return false;
        }
    }
}
