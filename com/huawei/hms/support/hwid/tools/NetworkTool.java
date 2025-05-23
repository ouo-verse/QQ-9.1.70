package com.huawei.hms.support.hwid.tools;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class NetworkTool {
    private static boolean a(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public static String buildNetworkCookie(String str, String str2, String str3, String str4, Boolean bool, Boolean bool2, Long l3) {
        StringBuilder sb5 = new StringBuilder(str);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(str2);
        }
        if (a(bool)) {
            sb5.append(";HttpOnly");
        }
        if (a(bool2)) {
            sb5.append(";Secure");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb5.append(";Domain=");
            sb5.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb5.append(";Path=");
            sb5.append(str4);
        }
        if (l3 != null && l3.longValue() > 0) {
            sb5.append(";Max-Age=");
            sb5.append(l3);
        }
        return sb5.toString();
    }

    public static String buildNetworkUrl(String str, Boolean bool) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (a(bool)) {
                str2 = "https";
            } else {
                str2 = "http";
            }
            StringBuilder sb5 = new StringBuilder(str2.length() + 3 + String.valueOf(str).length());
            sb5.append(str2);
            sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            sb5.append(str);
            return sb5.toString();
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }
}
