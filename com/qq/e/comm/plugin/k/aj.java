package com.qq.e.comm.plugin.k;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.managers.status.TGDeviceInfo;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class aj {

    /* renamed from: a, reason: collision with root package name */
    private static final String f39620a = "aj";

    /* renamed from: b, reason: collision with root package name */
    private static volatile int f39621b = 9;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Class f39622c;

    public static int a() {
        return f39621b;
    }

    public static boolean b() {
        Object a16 = a("testAdCgiOn");
        GDTLogger.d(String.format("testAdCgiOn = %s", a16));
        if (!(a16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    public static boolean c() {
        Object a16 = a("autoAdCgiOn");
        GDTLogger.d(String.format("autoAdCgiOn = %s", a16));
        if (!(a16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    public static boolean d() {
        Object a16 = a("testSplashCgiOn");
        GDTLogger.d(String.format("testSplashCgiOn = %s", a16));
        if (!(a16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    public static boolean e() {
        Object a16 = a("testControlServerOn");
        GDTLogger.d(String.format("testControlServerOn = %s", a16));
        if (!(a16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    public static boolean f() {
        Object a16 = a("testReportOn");
        GDTLogger.d(String.format("testReportOn = %s", a16));
        if (!(a16 instanceof Boolean)) {
            return false;
        }
        return ((Boolean) a16).booleanValue();
    }

    public static boolean g() {
        if (SDKStatus.getSDKVersionCode() >= 120) {
            return GDTLogger.isEnableConsoleLog();
        }
        return false;
    }

    public static String h() {
        if (SDKStatus.getSDKVersionCode() >= 60) {
            return GDTADManager.getInstance().getSM().getSettingDir();
        }
        return Constants.SETTING.SETTINGDIR;
    }

    public static TGDeviceInfo i() {
        return GlobalSetting.getTGDeviceInfo();
    }

    private static Object a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (f39622c == null) {
                ClassLoader classLoader = aj.class.getClassLoader();
                if (classLoader == null) {
                    return null;
                }
                try {
                    f39622c = classLoader.loadClass("com.qq.e.adnet.ProductConfig");
                } catch (ClassNotFoundException unused) {
                    return null;
                }
            }
            try {
                return f39622c.getDeclaredField(str).get(f39622c);
            } catch (IllegalAccessException | NoSuchFieldException unused2) {
            }
        }
        return null;
    }
}
