package com.tencent.gamecenter.wadl.sdk.common.e;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static String f107240a = "";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f107241b = false;

    public static int a(int i3, int i16, int i17) {
        return Math.min(Math.max(i3, i16), i17);
    }

    public static String b() {
        Context b16 = com.tencent.gamecenter.wadl.sdk.common.a.b();
        if (b16 == null) {
            return null;
        }
        return b16.getPackageName();
    }

    public static String c() {
        try {
            return "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int d() {
        return (int) (Math.random() * 2.147483647E9d);
    }

    public static String e() {
        if (!f107241b) {
            return f107240a;
        }
        if (e(f107240a)) {
            if (!TextUtils.isEmpty("")) {
                if (com.tencent.gamecenter.wadl.sdk.common.a.f106989l) {
                    try {
                        f107240a = "M_" + d.a("");
                    } catch (Throwable unused) {
                    }
                } else {
                    f107240a = "";
                }
            }
            if (TextUtils.isEmpty(f107240a)) {
                f107240a = "UNKNOWN";
            }
        }
        return f107240a;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(":")) {
            if (str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']') {
                return c.c(str.substring(1, str.length() - 1));
            }
            return c.c(str);
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

    public static int a(int i3, int i16, int i17, int i18) {
        return ((i3 < i16 || i3 > i17) && i18 >= i16 && i18 <= i17) ? i18 : a(i3, i16, i17);
    }

    public static void b(String str) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        File file = new File(str);
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].isDirectory()) {
                    b(listFiles[i3].getAbsolutePath());
                } else {
                    listFiles[i3].delete();
                }
            }
        }
        file.delete();
    }

    public static Map<String, String> c(String str) {
        int indexOf;
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) == -1) {
            return hashMap;
        }
        try {
            for (String str2 : str.substring(indexOf + 1).split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split.length == 2) {
                    hashMap.put(split[0], URLDecoder.decode(split[1]));
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    public static String d(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public static boolean e(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String a() {
        try {
            return d.a("" + e() + System.currentTimeMillis() + d());
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "" + System.currentTimeMillis();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i3) {
        BufferedReader bufferedReader;
        LineNumberReader lineNumberReader = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/" + i3 + "/cmdline"));
            } catch (Exception e16) {
                e = e16;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                if (lineNumberReader != 0) {
                }
                throw th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return readLine;
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            lineNumberReader = "/proc/";
            if (lineNumberReader != 0) {
                try {
                    lineNumberReader.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, int i3) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int size;
        int i16;
        Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            try {
                activityManager = (ActivityManager) systemService;
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (activityManager != null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) == null || runningAppProcesses.size() <= 0) {
                return null;
            }
            size = runningAppProcesses.size();
            for (i16 = 0; i16 < size; i16++) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i16);
                if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i3) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        activityManager = null;
        if (activityManager != null) {
            return null;
        }
        size = runningAppProcesses.size();
        while (i16 < size) {
        }
        return null;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str, String str2) {
        try {
            URL url = new URL(str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(url.getProtocol());
            sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            sb5.append(str2);
            if (url.getPort() != -1) {
                sb5.append(":" + url.getPort());
            }
            sb5.append(url.getPath());
            if (!TextUtils.isEmpty(url.getQuery())) {
                sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + url.getQuery());
            }
            if (!TextUtils.isEmpty(url.getRef())) {
                sb5.append("#" + url.getRef());
            }
            return sb5.toString();
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return str;
        }
    }

    public static String a(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (z16) {
            try {
                if (str.length() > 30) {
                    str = str.substring(0, 30);
                }
            } catch (Throwable unused) {
                return "";
            }
        }
        return URLEncoder.encode(str, "UTF-8");
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }
}
