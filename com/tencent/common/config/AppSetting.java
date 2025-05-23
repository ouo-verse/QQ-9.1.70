package com.tencent.common.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AppSetting {
    static IPatchRedirector $redirector_ = null;
    public static boolean A = false;
    public static boolean B = false;
    public static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static volatile boolean G = false;
    public static boolean H = false;
    private static String I = null;
    public static int J = 0;
    public static boolean K = false;
    public static String L = null;
    public static boolean M = false;
    public static boolean N = false;
    public static boolean O = false;
    public static int P = 0;
    public static int Q = 0;
    private static String R = null;

    /* renamed from: a, reason: collision with root package name */
    public static String f99541a = null;

    /* renamed from: b, reason: collision with root package name */
    public static final String f99542b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f99543c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f99544d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f99545e;

    /* renamed from: f, reason: collision with root package name */
    private static int f99546f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static int f99547g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f99548h = false;

    /* renamed from: i, reason: collision with root package name */
    private static String f99549i = null;

    /* renamed from: j, reason: collision with root package name */
    private static String f99550j = null;

    /* renamed from: k, reason: collision with root package name */
    public static final String f99551k;

    /* renamed from: l, reason: collision with root package name */
    private static String f99552l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f99553m;

    /* renamed from: n, reason: collision with root package name */
    public static final String f99554n;

    /* renamed from: o, reason: collision with root package name */
    private static String f99555o;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f99556p;

    /* renamed from: q, reason: collision with root package name */
    private static int f99557q;

    /* renamed from: r, reason: collision with root package name */
    public static final String f99558r;

    /* renamed from: s, reason: collision with root package name */
    public static final String f99559s;

    /* renamed from: t, reason: collision with root package name */
    private static final String f99560t;

    /* renamed from: u, reason: collision with root package name */
    private static String f99561u;

    /* renamed from: v, reason: collision with root package name */
    private static String f99562v;

    /* renamed from: w, reason: collision with root package name */
    private static String f99563w;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f99564x;

    /* renamed from: y, reason: collision with root package name */
    public static boolean f99565y;

    /* renamed from: z, reason: collision with root package name */
    public static boolean f99566z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36764);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f99541a = "";
        f99542b = f99542b;
        f99543c = "88c475c0";
        f99544d = f99544d;
        f99545e = f99545e;
        f99546f = 537285947;
        f99547g = 537280317;
        f99548h = true;
        f99549i = "18F838FE9AB92520";
        f99550j = "210EA24B7A6C9C0F";
        f99551k = f99551k;
        String str = "V " + f99551k + "." + f99542b;
        f99552l = str;
        f99553m = str;
        f99554n = f99551k + "." + f99542b;
        f99556p = true;
        f99557q = -1;
        String str2 = "2013 " + f99551k;
        f99558r = str2;
        f99559s = str2 + f99542b;
        f99560t = Build.VERSION.RELEASE;
        f99561u = "0";
        f99562v = "";
        f99564x = false;
        f99565y = false;
        f99566z = false;
        A = false;
        B = false;
        C = false;
        G = false;
        H = false;
        f99555o = f99551k + "." + f99542b + "." + f99545e + ".88c475c0." + f99562v;
        J = 1048576;
        K = true;
        L = "use_msg_reflesh_delay";
        M = true;
        N = false;
        O = false;
        P = 1000;
        Q = 1000 + 1;
        R = "";
    }

    public AppSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean A() {
        return false;
    }

    public static boolean B() {
        return false;
    }

    private static void a() {
        if (f99548h && !G) {
            synchronized (AppSetting.class) {
                if (!G) {
                    v();
                    G = true;
                }
            }
        }
    }

    public static int b(String str) throws NumberFormatException {
        String[] split = f99551k.split("\\.");
        String[] split2 = str.split("\\.");
        int min = Math.min(split.length, split2.length);
        for (int i3 = 0; i3 < min; i3++) {
            int parseInt = Integer.parseInt(split[i3]);
            int parseInt2 = Integer.parseInt(split2[i3]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    public static String c() {
        a();
        return f99555o;
    }

    public static String d() {
        a();
        return f99552l;
    }

    public static String e() {
        return "application/vnd.android.package-archive";
    }

    public static int f() {
        a();
        if (p(BaseApplication.getContext())) {
            return f99547g;
        }
        return f99546f;
    }

    public static String g() {
        a();
        return f99562v;
    }

    public static String h() {
        a();
        return f99561u;
    }

    public static String i() {
        a();
        if (p(BaseApplication.getContext())) {
            return f99550j;
        }
        return f99549i;
    }

    public static String j(Context context) {
        int i3 = 0;
        try {
            i3 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
        }
        return f99551k + "." + i3;
    }

    public static String k() {
        String str;
        String str2 = f99563w;
        if (str2 != null) {
            return str2;
        }
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            str = (String) declaredMethod.invoke(null, "ro.product.manufacturer");
        } catch (SecurityException | Exception unused) {
            str = "";
        }
        String str3 = str + DeviceInfoMonitor.getModel();
        if (str3 != null) {
            char[] charArray = str3.toCharArray();
            StringBuffer stringBuffer = new StringBuffer(32);
            for (char c16 : charArray) {
                if (c16 > ' ' && c16 != '/' && c16 != '_' && c16 != '&' && c16 != '|' && c16 != '-') {
                    stringBuffer.append(c16);
                }
            }
            if (stringBuffer.length() > 0) {
                str3 = stringBuffer.toString();
            }
        } else {
            str3 = "ALL";
        }
        if (str3.length() > 20) {
            str3 = str3.substring(0, 20);
        }
        String str4 = "AQQ_2013 4.6/" + f99559s + ContainerUtils.FIELD_DELIMITER + "NA_0/000000" + ContainerUtils.FIELD_DELIMITER + "ADR" + ContainerUtils.FIELD_DELIMITER + I + "18" + ContainerUtils.FIELD_DELIMITER + str3 + ContainerUtils.FIELD_DELIMITER + h() + ContainerUtils.FIELD_DELIMITER + i() + ContainerUtils.FIELD_DELIMITER + f99560t + ContainerUtils.FIELD_DELIMITER + "V3";
        f99563w = str4;
        return str4;
    }

    public static String l() {
        return f99543c;
    }

    public static int m() {
        if (f99557q < 0) {
            BaseApplication context = BaseApplication.getContext();
            String packageName = context.getPackageName();
            f99557q = 31;
            try {
                f99557q = context.getPackageManager().getApplicationInfo(packageName, 0).targetSdkVersion;
            } catch (PackageManager.NameNotFoundException e16) {
                QLog.e("AppSetting", 1, "getTargetSdkVersion error", e16);
            }
        }
        return f99557q;
    }

    public static final String n() {
        return "android " + f99551k;
    }

    public static boolean o(Context context) {
        DeviceType a16 = PadUtil.a(context);
        if ((PadUtil.b(context) && a16 == DeviceType.FOLD) || a16 == DeviceType.TABLET) {
            return true;
        }
        return false;
    }

    public static boolean p(Context context) {
        if (PadUtil.a(context) == DeviceType.TABLET) {
            return true;
        }
        return false;
    }

    public static boolean q() {
        return F;
    }

    public static boolean r() {
        return D;
    }

    public static boolean s() {
        if (!TextUtils.isEmpty(k())) {
            k().endsWith("RDM_B");
            return false;
        }
        return false;
    }

    public static boolean t(Context context) {
        DeviceType a16 = PadUtil.a(context);
        if ((PadUtil.b(context) && a16 == DeviceType.FOLD) || a16 == DeviceType.TABLET) {
            return true;
        }
        return false;
    }

    public static boolean u() {
        return E;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void v() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            applicationInfo = BaseApplication.getContext().getPackageManager().getApplicationInfo(BaseApplication.getContext().getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e16) {
            QLog.e("AppSetting", 1, "setArgsFromManifest fail, ", e16);
            applicationInfo = null;
            if (applicationInfo != null) {
            } else {
                return;
            }
        } catch (Exception e17) {
            QLog.e("AppSetting", 1, "setArgsFromManifest fail, ", e17);
            applicationInfo = null;
            if (applicationInfo != null) {
            }
        }
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
            x(bundle.getString("AppSetting_params"), applicationInfo.metaData.getString("AppSetting_params_pad"));
        }
    }

    public static void w(boolean z16) {
        E = z16;
    }

    public static void x(String str, String str2) {
        if (str != null) {
            String[] split = str.split("#");
            f99546f = Integer.valueOf(split[0]).intValue();
            f99549i = split[1];
            f99561u = split[2];
            f99562v = split[3];
        }
        if (str2 != null) {
            String[] split2 = str2.split("#");
            f99547g = Integer.valueOf(split2[0]).intValue();
            f99550j = split2[1];
        }
        if (!"".equals(f99562v)) {
            StringBuilder sb5 = new StringBuilder();
            String str3 = f99555o;
            sb5.append(str3.substring(0, str3.lastIndexOf(".")));
            sb5.append(".");
            sb5.append(f99562v);
            f99555o = sb5.toString();
        }
    }

    public static void y(boolean z16) {
        D = z16;
    }

    public static void z(boolean z16) {
        F = z16;
    }
}
