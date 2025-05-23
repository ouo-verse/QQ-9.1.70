package com.tencent.bugly;

import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class BuildConfigWrapper {
    public static final String SERVER_HOST_TYPE_BUGLY_OVERSEA = "https://android.bugly.tencent.com";
    public static final String SERVER_HOST_TYPE_BUGLY_PRE_TEST = "https://pre.rmonitor.qq.com";
    public static final String SERVER_HOST_TYPE_BUGLY_PRO = "https://pro.bugly.qq.com";
    public static final String SERVER_HOST_TYPE_BUGLY_PRO_TEST = "https://t.pro.bugly.qq.com";
    public static final String SERVER_HOST_TYPE_DEFAULT = "https://rmonitor.qq.com";
    public static final String SERVER_HOST_TYPE_DEFAULT_TEST = "https://t.rmonitor.qq.com";
    public static final String TAG = "BuildConfigWrapper";
    public static final Set<String> VALID_DOMAIN_SET;
    public static final String VERSION_NAME = "4.4.3";
    private static String domain;

    static {
        HashSet hashSet = new HashSet();
        VALID_DOMAIN_SET = hashSet;
        hashSet.add("https://rmonitor.qq.com");
        hashSet.add("https://pro.bugly.qq.com");
        hashSet.add("https://android.bugly.tencent.com");
        hashSet.add("https://t.rmonitor.qq.com");
        hashSet.add("https://t.pro.bugly.qq.com");
        hashSet.add("https://pre.rmonitor.qq.com");
        domain = "https://rmonitor.qq.com";
    }

    public static String getAttaUrl() {
        return "https://h.trace.qq.com/kv";
    }

    public static String getDomain() {
        return domain;
    }

    public static boolean setDomain(String str) {
        if (VALID_DOMAIN_SET.contains(str)) {
            domain = str;
            return true;
        }
        return false;
    }
}
