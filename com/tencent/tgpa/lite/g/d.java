package com.tencent.tgpa.lite.g;

import android.app.UiModeManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tgpa.lite.PrivacyDataCallback;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    public static String a(String str) {
        if (l.a(str)) {
            return "";
        }
        PrivacyDataCallback b16 = com.tencent.tgpa.lite.f.a.b();
        String privacyData = b16 != null ? b16.getPrivacyData(str) : "";
        if (!l.a(privacyData)) {
            return privacyData;
        }
        if (b16 != null && !b16.canReadPrivacyDataBySelf()) {
            return privacyData;
        }
        String a16 = j.a(str, "");
        if (l.a(a16)) {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -945993409:
                    if (str.equals(PrivacyDataCallback.KEY_MANUFACTURER)) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -865464946:
                    if (str.equals(PrivacyDataCallback.KEY_CPUABI)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -816419260:
                    if (str.equals(PrivacyDataCallback.KEY_DEVICE)) {
                        c16 = 2;
                        break;
                    }
                    break;
                case 1496204761:
                    if (str.equals(PrivacyDataCallback.KEY_BRAND)) {
                        c16 = 3;
                        break;
                    }
                    break;
                case 1506276731:
                    if (str.equals(PrivacyDataCallback.KEY_MODEL)) {
                        c16 = 4;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    a16 = Build.MANUFACTURER;
                    break;
                case 1:
                    a16 = Build.CPU_ABI;
                    break;
                case 2:
                    a16 = Build.DEVICE;
                    break;
                case 3:
                    a16 = Build.BRAND;
                    break;
                case 4:
                    a16 = DeviceInfoMonitor.getModel();
                    break;
            }
            if (!l.a(a16)) {
                j.b(str, a16);
            }
        }
        return a16;
    }

    public static String b() {
        return a(PrivacyDataCallback.KEY_BRAND);
    }

    public static String c() {
        return a(PrivacyDataCallback.KEY_CPUABI);
    }

    public static String d() {
        return a(PrivacyDataCallback.KEY_DEVICE);
    }

    public static String e() {
        return a(PrivacyDataCallback.KEY_MANUFACTURER);
    }

    public static String f() {
        return a(PrivacyDataCallback.KEY_MODEL);
    }

    public static String g() {
        String str;
        try {
            str = f.a("/proc/cpuinfo", "Hardware");
        } catch (Exception unused) {
            h.b("TGPA-Device", "DeviceUtil:getCPU: Could not open file /proc/cpuinfo");
            str = null;
        }
        if (l.a(str)) {
            return m.a("ro.hardware", null);
        }
        return str.substring(str.indexOf(58, str.indexOf("Hardware")) + 1).trim();
    }

    public static double h() {
        if (a.a() == null) {
            return -1.0d;
        }
        ((WindowManager) a.a().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        return Math.sqrt(Math.pow(r1.widthPixels / r1.xdpi, 2.0d) + Math.pow(r1.heightPixels / r1.ydpi, 2.0d));
    }

    public static int i() {
        if (a.a() == null) {
            return -1;
        }
        return ((UiModeManager) a.a().getSystemService("uimode")).getCurrentModeType();
    }

    public static boolean a() {
        if (a.a() == null) {
            return true;
        }
        return a.a().getPackageManager().hasSystemFeature("android.hardware.telephony");
    }
}
