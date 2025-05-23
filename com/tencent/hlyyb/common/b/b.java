package com.tencent.hlyyb.common.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URLEncoder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f114351a = "";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11114);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        }
    }

    public static int a() {
        return (int) (Math.random() * 2.147483647E9d);
    }

    public static String b() {
        return "";
    }

    public static String c() {
        return "";
    }

    public static String d() {
        Context a16 = com.tencent.hlyyb.common.a.a();
        if (a16 == null) {
            return null;
        }
        return a16.getPackageName();
    }

    public static String e() {
        String packageName;
        Context a16 = com.tencent.hlyyb.common.a.a();
        if (a16 == null) {
            return null;
        }
        Context a17 = com.tencent.hlyyb.common.a.a();
        if (a17 == null) {
            packageName = null;
        } else {
            packageName = a17.getPackageName();
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(a16.getPackageManager(), packageName, 0).versionName;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int f() {
        String packageName;
        Context a16 = com.tencent.hlyyb.common.a.a();
        if (a16 == null) {
            return 0;
        }
        Context a17 = com.tencent.hlyyb.common.a.a();
        if (a17 == null) {
            packageName = null;
        } else {
            packageName = a17.getPackageName();
        }
        try {
            return InstalledAppListMonitor.getPackageInfo(a16.getPackageManager(), packageName, 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String g() {
        return a.a("" + b() + c() + System.currentTimeMillis() + h() + ((int) (Math.random() * 2.147483647E9d)));
    }

    public static String h() {
        return "";
    }

    public static int a(int i3, int i16, int i17) {
        return Math.min(Math.max(i3, 1), 5);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str);
        } catch (Throwable unused) {
            return "";
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

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f114351a)) {
            return f114351a;
        }
        String packageName = context.getPackageName();
        String a16 = a(Process.myPid());
        if (TextUtils.isEmpty(a16) || !a16.startsWith(packageName)) {
            a16 = a(context, Process.myPid());
        }
        f114351a = a16;
        return a16;
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
        return URLEncoder.encode(str);
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }
}
