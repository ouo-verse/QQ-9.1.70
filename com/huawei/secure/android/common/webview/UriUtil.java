package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UriUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38059a = "UriUtil";

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i(f38059a, "whiteListUrl is null");
            return null;
        }
        if (!URLUtil.isNetworkUrl(str)) {
            return str;
        }
        return getHostByURI(str);
    }

    @TargetApi(9)
    public static String getHostByURI(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i(f38059a, "url is null");
            return str;
        }
        try {
            if (!URLUtil.isNetworkUrl(str)) {
                LogsUtil.e(f38059a, "url don't starts with http or https");
                return "";
            }
            return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
        } catch (MalformedURLException e16) {
            LogsUtil.e(f38059a, "getHostByURI error  MalformedURLException : " + e16.getMessage());
            return "";
        }
    }

    public static boolean isUrlHostAndPathInWhitelist(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (isUrlHostAndPathMatchWhitelist(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.e(f38059a, "whitelist is null");
        return false;
    }

    public static boolean isUrlHostAndPathMatchWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.contains("..") && !str.contains("@")) {
                if (!str2.equals(str)) {
                    if (!str.startsWith(str2 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        if (!str.startsWith(str2 + "#")) {
                            if (!str2.endsWith("/")) {
                                return false;
                            }
                            if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                                return false;
                            }
                            return str.startsWith(str2);
                        }
                    }
                }
                return true;
            }
            Log.e(f38059a, "url contains unsafe char");
        }
        return false;
    }

    public static boolean isUrlHostInWhitelist(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (isUrlHostMatchWhitelist(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.e(f38059a, "whitelist is null");
        return false;
    }

    public static boolean isUrlHostMatchWhitelist(String str, String str2) {
        String hostByURI = getHostByURI(str);
        if (!TextUtils.isEmpty(hostByURI) && !TextUtils.isEmpty(str2)) {
            String a16 = a(str2);
            if (TextUtils.isEmpty(a16)) {
                Log.e(f38059a, "whitelist host is null");
                return false;
            }
            if (a16.equals(hostByURI)) {
                return true;
            }
            if (hostByURI.endsWith(a16)) {
                try {
                    String substring = hostByURI.substring(0, hostByURI.length() - a16.length());
                    if (!substring.endsWith(".")) {
                        return false;
                    }
                    return substring.matches("^[A-Za-z0-9.-]+$");
                } catch (IndexOutOfBoundsException e16) {
                    LogsUtil.e(f38059a, "IndexOutOfBoundsException" + e16.getMessage());
                } catch (Exception e17) {
                    LogsUtil.e(f38059a, "Exception : " + e17.getMessage());
                    return false;
                }
            }
            return false;
        }
        LogsUtil.e(f38059a, "url or whitelist is null");
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return TextUtils.equals(getHostByURI(str), a(str2));
        }
        Log.e(f38059a, "isUrlHostSameWhitelist: url or host is null");
        return false;
    }

    public static boolean isUrlHostSameWhitelist(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (isUrlHostSameWhitelist(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.e(f38059a, "whitelist is null");
        return false;
    }
}
