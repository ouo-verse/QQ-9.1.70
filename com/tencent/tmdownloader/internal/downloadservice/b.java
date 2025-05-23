package com.tencent.tmdownloader.internal.downloadservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.tmassistantbase.common.TMAssistantDownloadContentType;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {
    public static String a(String str) {
        return str.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "_").replace("*", "_").replace(" ", "_").replace("$", "_").replace(ContainerUtils.FIELD_DELIMITER, "_").replace("@", "_").replace("#", "_").replace("<", "_").replace(">", "_").replace("|", "_").replace(":", "_").replace("/", "_").replace("\\", "_").replace("\"", "_");
    }

    public static String b(String str) {
        String trim = str.replace("\r", "").replace("\n", "").trim();
        String str2 = new String(trim);
        try {
            Uri parse = Uri.parse(trim);
            String lastPathSegment = parse.getLastPathSegment();
            return (lastPathSegment == null || lastPathSegment.length() <= 0) ? str2 : str2.replace(lastPathSegment, URLEncoder.encode(parse.getLastPathSegment()).replace(Marker.ANY_NON_NULL_MARKER, "%20"));
        } catch (Exception e16) {
            e16.printStackTrace();
            r.c("DownloadHelper", "exception: ", e16);
            return str2;
        }
    }

    public static String c(String str) {
        if (str != null) {
            return URLDecoder.decode(str);
        }
        return null;
    }

    public static String d(String str) {
        String str2;
        if (str.contains(".apk")) {
            str2 = str.trim().substring(str.lastIndexOf("/") + 1).trim();
            if (str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str2 = str2.substring(0, str2.lastIndexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
            }
            if (!TextUtils.isEmpty(str2)) {
                return a(c(str2)).replace(".apk", "") + "_" + GlobalUtil.calcMD5AsString(str) + ".apk";
            }
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return a(str, "application/vnd.android.package-archive");
        }
        return str2;
    }

    public static boolean e(String str) {
        boolean z16 = false;
        if (str == null) {
            return false;
        }
        try {
            z16 = new File(com.tencent.tmdownloader.f.b.c.b(str)).exists();
        } catch (Exception e16) {
            r.c("DownloadHelper", "exception: ", e16);
            e16.printStackTrace();
        }
        return z16;
    }

    public static boolean f(String str) {
        try {
            new URI(b(str));
            return true;
        } catch (Throwable th5) {
            r.c("DownloadHelper", "exception: ", th5);
            th5.printStackTrace();
            return false;
        }
    }

    public static boolean b() {
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null) {
            r.c("DownloadHelper", "GlobalUtil.getInstance().getContext() == null.");
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
            return false;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    public static String a(String str, String str2) {
        String str3;
        String calcMD5AsString = GlobalUtil.calcMD5AsString(str);
        if (TextUtils.isEmpty(calcMD5AsString)) {
            calcMD5AsString = Integer.toString(Math.abs(str.hashCode()));
        }
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals("application/vnd.android.package-archive")) {
                str3 = ".apk";
            } else if (str2.equals(TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF)) {
                str3 = ".diff";
            } else if (str2.equals(TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS)) {
                str3 = ".other";
            }
            return calcMD5AsString + str3;
        }
        str3 = "";
        return calcMD5AsString + str3;
    }

    public static boolean b(String str, String str2) {
        boolean z16 = false;
        try {
            z16 = new File(com.tencent.tmdownloader.f.b.c.b(a(str, str2))).exists();
            if (z16) {
                return z16;
            }
            if (!"application/vnd.android.package-archive".equals(str2) && !str.contains(".apk")) {
                return z16;
            }
            if (new File(com.tencent.tmdownloader.f.b.c.b(d(str))).exists()) {
                return true;
            }
            return z16;
        } catch (Exception e16) {
            r.c("DownloadHelper", "halleytest exception: ", e16);
            return z16;
        }
    }

    public static synchronized String a() {
        synchronized (b.class) {
            Context context = GlobalUtil.getInstance().getContext();
            if (context == null) {
                return "";
            }
            try {
                if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                    return "";
                }
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return "";
                }
                if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    return "wifi";
                }
                String netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
                if (netGetExInfo == null) {
                    return "";
                }
                return netGetExInfo.toLowerCase();
            } catch (Exception e16) {
                r.c("DownloadHelper", "exception: ", e16);
                return "";
            }
        }
    }
}
