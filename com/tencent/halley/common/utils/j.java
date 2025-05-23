package com.tencent.halley.common.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f113559a;

    /* renamed from: b, reason: collision with root package name */
    private static String f113560b;

    /* renamed from: c, reason: collision with root package name */
    private static String f113561c;

    /* renamed from: d, reason: collision with root package name */
    private static String f113562d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11721);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f113559a = "";
        f113560b = "";
        f113561c = "";
        f113562d = "";
    }

    public static int a(int i3, int i16, int i17) {
        return Math.min(Math.max(i3, i16), i17);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int c() {
        return (int) (Math.random() * 2.147483647E9d);
    }

    @SuppressLint({"MissingPermission"})
    public static String d() {
        return f113559a;
    }

    @SuppressLint({"MissingPermission"})
    public static String e() {
        return f113560b;
    }

    public static String f() {
        return f113561c;
    }

    public static String g() {
        Context a16 = com.tencent.halley.common.a.a();
        if (a16 == null) {
            return null;
        }
        return a16.getPackageName();
    }

    public static String h() {
        try {
            return g.a("" + System.currentTimeMillis() + c());
        } catch (Throwable th5) {
            th5.printStackTrace();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(System.currentTimeMillis());
            return sb5.toString();
        }
    }

    public static int a(int i3, int i16, int i17, int i18) {
        return ((i3 < i16 || i3 > i17) && i18 >= i16 && i18 <= i17) ? i18 : a(i3, i16, i17);
    }

    public static boolean b() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static String c(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(":")) {
            return (str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']') ? e.c(str.substring(1, str.length() - 1)) : e.c(str);
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String str2 : split) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt < 0 || parseInt > 255) {
                    return false;
                }
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static int a(com.tencent.halley.downloader.task.d.b bVar, String str, String str2) {
        int i3;
        List<com.tencent.halley.downloader.e.a> a16 = bVar.a();
        if (bVar.f113918i < 0) {
            return -2;
        }
        if (a16 == null || a16.size() <= 0 || TextUtils.isEmpty(bVar.f113922m)) {
            return -3;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String str3 = "";
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(str, str2), "r");
            Iterator<com.tencent.halley.downloader.e.a> it = a16.iterator();
            while (true) {
                i3 = 0;
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.halley.downloader.e.a next = it.next();
                long j3 = next.f113723a;
                int i16 = next.f113724b;
                byte[] bArr = new byte[i16];
                randomAccessFile.seek(j3);
                randomAccessFile.read(bArr, 0, i16);
                byteArrayOutputStream.write(bArr, 0, i16);
            }
            str3 = g.a(byteArrayOutputStream.toByteArray());
            if (TextUtils.isEmpty(str3)) {
                i3 = -5;
            } else if (str3.toLowerCase().equals(bVar.f113922m.toLowerCase())) {
                i3 = 1;
            }
            try {
                byteArrayOutputStream.close();
                randomAccessFile.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        } catch (IOException e17) {
            e17.printStackTrace();
            i3 = -4;
        }
        d.a("hijack", "md5:" + str3 + " cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms result:" + i3, true);
        return i3;
    }

    public static com.tencent.halley.a a() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i3) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i3 + "/cmdline"));
        } catch (Exception e16) {
            e = e16;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        try {
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                return readLine;
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e19) {
            e = e19;
            e.printStackTrace();
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            return null;
        }
    }

    public static String a(long j3, String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            return simpleDateFormat.format(calendar.getTime());
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
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
            } catch (Throwable th5) {
                th5.printStackTrace();
                return "";
            }
        }
        return URLEncoder.encode(str, "UTF-8");
    }

    public static List<String> a(String[] strArr) {
        return strArr == null ? Collections.emptyList() : Arrays.asList(strArr);
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }
}
