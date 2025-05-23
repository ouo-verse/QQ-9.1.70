package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ht;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TencentMapInitializer {
    private static final Map<String, String> EXTRA_MAP = new ConcurrentHashMap();
    public static final String KEY_AGREE_PRIVACY = "privacy";

    public static synchronized void addExtra(String str, String str2) {
        synchronized (TencentMapInitializer.class) {
            if ("privacy".equals(str) && !TextUtils.isEmpty(str2)) {
                EXTRA_MAP.put("privacy", str2);
            } else {
                if (!isAgreePrivacy()) {
                    return;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    EXTRA_MAP.put(str, str2);
                    ht.a(str, str2);
                }
            }
        }
    }

    public static synchronized boolean getAgreePrivacy() {
        boolean isAgreePrivacy;
        synchronized (TencentMapInitializer.class) {
            isAgreePrivacy = isAgreePrivacy();
            if (!isAgreePrivacy) {
                LogUtil.d("\u8bf7\u8bbe\u7f6e\u540c\u610f\u9690\u79c1\u534f\u8bae, \u9700\u8981\u5728\u521d\u59cb\u5316\u5730\u56fe\u4e4b\u524d\u5b8c\u6210");
            }
        }
        return isAgreePrivacy;
    }

    public static synchronized String getDuid(Context context) {
        synchronized (TencentMapInitializer.class) {
            if (isAgreePrivacy()) {
                return ht.g(context);
            }
            return "undefined";
        }
    }

    public static synchronized String getExtra(String str) {
        synchronized (TencentMapInitializer.class) {
            if (isAgreePrivacy() && !TextUtils.isEmpty(str)) {
                return EXTRA_MAP.get(str);
            }
            return null;
        }
    }

    public static synchronized String getSuid(Context context) {
        synchronized (TencentMapInitializer.class) {
            if (isAgreePrivacy()) {
                return ht.f(context);
            }
            return "undefined";
        }
    }

    private static boolean isAgreePrivacy() {
        return Boolean.parseBoolean(EXTRA_MAP.get("privacy"));
    }

    public static synchronized void setAgreePrivacy(boolean z16) {
        synchronized (TencentMapInitializer.class) {
            EXTRA_MAP.put("privacy", String.valueOf(z16));
        }
    }
}
