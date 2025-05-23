package com.tencent.gamecenter.wadl.sdk.downloader.a;

import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import com.tencent.gamecenter.wadl.sdk.downloader.task.k.a;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.UnknownHostException;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    public static long a(long j3, long j16) {
        long j17 = j3 * 1000;
        return j16 > 0 ? j17 / j16 : j17;
    }

    public static int b(Throwable th5) {
        if (th5 == null) {
            return -48;
        }
        String message = th5.getMessage();
        if (!TextUtils.isEmpty(message) && message.contains("Permission")) {
            return -71;
        }
        if (!(th5 instanceof Exception)) {
            return -70;
        }
        if (th5 instanceof SocketTimeoutException) {
            return -25;
        }
        if (th5 instanceof UnknownHostException) {
            return -29;
        }
        if (th5 instanceof ConnectException) {
            return -24;
        }
        if (th5 instanceof SocketException) {
            return -26;
        }
        return th5 instanceof IOException ? -27 : -48;
    }

    private static String c(String str) {
        int indexOf;
        try {
            if (TextUtils.isEmpty(str) || -1 == (indexOf = str.indexOf("filename="))) {
                return null;
            }
            int i3 = indexOf + 9;
            int indexOf2 = str.indexOf(";", i3);
            if (indexOf2 == -1) {
                indexOf2 = str.length();
            }
            String substring = str.substring(i3, indexOf2);
            try {
                substring = URLDecoder.decode(substring, "utf-8");
            } catch (UnsupportedEncodingException e16) {
                try {
                    substring = URLDecoder.decode(substring, "gbk");
                } catch (UnsupportedEncodingException unused) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("DownloaderUtils", "getFileNameFromDisposition fail", e16);
                }
            }
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            int lastIndexOf = substring.lastIndexOf("/") + 1;
            return lastIndexOf > 0 ? substring.substring(lastIndexOf) : substring;
        } catch (Exception e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("text/html") && !lowerCase.startsWith("text/vnd.wap.wml") && !lowerCase.startsWith("text/webviewhtml")) {
            return false;
        }
        return true;
    }

    private static String e(String str) {
        return "downloadfile" + str;
    }

    public static long f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.valueOf(str).longValue();
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return -1L;
            }
        }
        return -1L;
    }

    public static long g(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("/")) != null && split.length == 2) {
            try {
                return Long.valueOf(split[1]).longValue();
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return -1L;
            }
        }
        return -1L;
    }

    private static String h(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "").replace("*", "").replace(":", "").replace("\\", "").replace("/", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "");
        }
        return str;
    }

    public static long a(com.tencent.gamecenter.wadl.sdk.downloader.a.e.b bVar, long j3) {
        if (bVar == null) {
            return j3;
        }
        long j16 = bVar.f107301b;
        return j16 == -1 ? j3 : j16 - bVar.f107300a;
    }

    private static String b(String str) {
        int lastIndexOf;
        try {
            String decode = Uri.decode(str);
            if (decode == null) {
                return null;
            }
            int indexOf = decode.indexOf(63);
            if (indexOf > 0) {
                decode = decode.substring(0, indexOf);
            }
            if (decode.endsWith("/") || (lastIndexOf = decode.lastIndexOf(47) + 1) <= 0) {
                return null;
            }
            return decode.substring(lastIndexOf);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean c(int i3) {
        return i3 == -16 || i3 == -15 || i3 == -77;
    }

    public static String a(String str) {
        try {
            return com.tencent.gamecenter.wadl.sdk.common.e.d.a(g.e() + System.currentTimeMillis() + str + g.d());
        } catch (Throwable unused) {
            return "" + System.currentTimeMillis();
        }
    }

    public static boolean b(int i3) {
        if (i3 == -76 || i3 == -73 || i3 == -71 || i3 == -68 || i3 == -51 || i3 == -44 || i3 == -43 || i3 == -11 || i3 == -10) {
            return true;
        }
        switch (i3) {
            case -56:
            case -55:
            case -54:
                return true;
            default:
                return a(i3);
        }
    }

    public static boolean c(Exception exc) {
        String message;
        return exc != null && (exc instanceof IOException) && (message = exc.getMessage()) != null && message.contains("Read-only file system");
    }

    public static String a(String str, String str2) {
        try {
            if (str.startsWith("/")) {
                URL url = new URL(str2);
                return url.getProtocol() + QzoneWebViewOfflinePlugin.STR_DEVIDER + url.getHost() + str;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return str;
    }

    public static boolean b(Exception exc) {
        String message;
        return (exc == null || (message = exc.getMessage()) == null || !message.contains("Permission denied")) ? false : true;
    }

    private static String a(String str, String str2, String str3) {
        String str4;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf <= 0) {
            if (TextUtils.isEmpty(str2) || !str2.equalsIgnoreCase("application/vnd.android.package-archive")) {
                return str + str3;
            }
            return str + str3 + ".apk";
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        if (str.length() > lastIndexOf + 1) {
            String substring = str.substring(0, lastIndexOf);
            str4 = str.substring(lastIndexOf);
            str = substring;
        } else {
            str4 = "";
        }
        return str + str3 + str4;
    }

    public static String a(String str, String str2, String str3, String str4) {
        String c16 = c(str3);
        if (c16 == null && (c16 = b(str)) == null) {
            c16 = e(str4);
        }
        return h(a(c16, str2, str4));
    }

    public static String a(Throwable th5) {
        return th5.getClass().getName() + ":" + th5.getMessage();
    }

    public static boolean a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean a(int i3) {
        return (i3 <= 0 || i3 == 200 || i3 == 206) ? false : true;
    }

    public static boolean a(a.EnumC1136a enumC1136a) {
        return enumC1136a == a.EnumC1136a.Type_CDN_Domain || enumC1136a == a.EnumC1136a.Type_Outer || enumC1136a == a.EnumC1136a.Type_Src_Domain;
    }

    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        File file2 = new File(file.getAbsolutePath() + "_" + System.currentTimeMillis());
        return file.renameTo(file2) ? file2.delete() : file.delete();
    }

    public static boolean a(Exception exc) {
        String message;
        if (exc == null || !(exc instanceof IOException) || (message = exc.getMessage()) == null) {
            return false;
        }
        return message.contains("ENOSPC") || message.contains("No space left on device");
    }
}
