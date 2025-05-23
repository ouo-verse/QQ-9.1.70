package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ah {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f97985a = "@buglyAllChannel@".split(",");

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f97986b = "@buglyAllChannelPriority@".split(",");

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return "fail";
            }
            th5.printStackTrace();
            return "fail";
        }
    }

    public static PackageInfo b(Context context) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), a(context), 0);
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static String c(Context context) {
        CharSequence applicationLabel;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && applicationInfo != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                return applicationLabel.toString();
            }
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Object obj = applicationInfo.metaData.get("BUGLY_DISABLE");
            if (obj != null) {
                hashMap.put("BUGLY_DISABLE", obj.toString());
            }
            Object obj2 = applicationInfo.metaData.get("BUGLY_APPID");
            if (obj2 != null) {
                hashMap.put("BUGLY_APPID", obj2.toString());
            }
            Object obj3 = applicationInfo.metaData.get("BUGLY_APP_CHANNEL");
            if (obj3 != null) {
                hashMap.put("BUGLY_APP_CHANNEL", obj3.toString());
            }
            Object obj4 = applicationInfo.metaData.get("BUGLY_APP_VERSION");
            if (obj4 != null) {
                hashMap.put("BUGLY_APP_VERSION", obj4.toString());
            }
            Object obj5 = applicationInfo.metaData.get("BUGLY_ENABLE_DEBUG");
            if (obj5 != null) {
                hashMap.put("BUGLY_ENABLE_DEBUG", obj5.toString());
            }
            Object obj6 = applicationInfo.metaData.get("com.tencent.rdm.uuid");
            if (obj6 != null) {
                hashMap.put("com.tencent.rdm.uuid", obj6.toString());
            }
            Object obj7 = applicationInfo.metaData.get("BUGLY_APP_BUILD_NO");
            if (obj7 != null) {
                hashMap.put("BUGLY_APP_BUILD_NO", obj7.toString());
            }
            Object obj8 = applicationInfo.metaData.get("BUGLY_AREA");
            if (obj8 != null) {
                hashMap.put("BUGLY_AREA", obj8.toString());
            }
            return hashMap;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }

    public static String a(int i3) {
        FileReader fileReader;
        Throwable th5;
        try {
            fileReader = new FileReader("/proc/" + i3 + "/cmdline");
        } catch (Throwable th6) {
            fileReader = null;
            th5 = th6;
        }
        try {
            char[] cArr = new char[512];
            fileReader.read(cArr);
            int i16 = 0;
            while (i16 < 512 && cArr[i16] != 0) {
                i16++;
            }
            String substring = new String(cArr).substring(0, i16);
            try {
                fileReader.close();
            } catch (Throwable unused) {
            }
            return substring;
        } catch (Throwable th7) {
            th5 = th7;
            try {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
                String valueOf = String.valueOf(i3);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused2) {
                    }
                }
                return valueOf;
            } catch (Throwable th8) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th8;
            }
        }
    }

    public static boolean a(ActivityManager activityManager) {
        if (activityManager == null) {
            av.c("is proc running, ActivityManager is null", new Object[0]);
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        if (runningAppProcesses == null) {
            av.c("running proc info list is empty, my proc not running.", new Object[0]);
            return false;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (it.hasNext()) {
            if (it.next().pid == myPid) {
                av.c("my proc is running.", new Object[0]);
                return true;
            }
        }
        av.c("proc not in running proc info list, my proc not running.", new Object[0]);
        return false;
    }

    public static List<String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = map.get("BUGLY_DISABLE");
            if (str != null && str.length() != 0) {
                String[] split = str.split(",");
                for (int i3 = 0; i3 < split.length; i3++) {
                    split[i3] = split[i3].trim();
                }
                return Arrays.asList(split);
            }
            return null;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
            return null;
        }
    }
}
