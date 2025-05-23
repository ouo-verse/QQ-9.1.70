package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils;

import android.app.Application;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$CHID;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$VersionDefine;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tvideo.protocol.pb.NetType;
import ev2.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import ov2.a;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdDeviceUtils {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f304109a = "";

    /* renamed from: b, reason: collision with root package name */
    private static volatile String f304110b = "";

    /* renamed from: c, reason: collision with root package name */
    private static volatile String f304111c = "";

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f304112d = "";

    /* renamed from: e, reason: collision with root package name */
    private static String f304113e = null;

    /* renamed from: f, reason: collision with root package name */
    private static final Object f304114f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static final Object f304115g = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f304116h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static final Object f304117i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static final Object f304118j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static String f304119k = null;

    /* renamed from: l, reason: collision with root package name */
    private static int f304120l = -1;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface HarmonyPure {
        public static final int HARMONY_NO_PURE = 1;
        public static final int HARMONY_PURE = 0;
        public static final int NO_HARMONY = -1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes19.dex */
    public @interface OsType {
        public static final int OS_TYPE_HARMONY = 1;
        public static final int OS_TYPE_NONE = -1;
        public static final int OS_TYPE_NORMAL = 0;
    }

    public static boolean A() {
        return "wifi".equals(b.d());
    }

    public static String a() {
        return b.a();
    }

    public static String b() {
        if (!TextUtils.isEmpty(f304110b)) {
            return f304110b;
        }
        synchronized (f304115g) {
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                f304110b = str;
            }
        }
        return f304110b;
    }

    public static String c() {
        String a16 = a.b().a();
        String c16 = qv2.b.c();
        if (QAdConfigDefine$CHID.QQ.equals(a16)) {
            return "QQ" + c16;
        }
        return "";
    }

    public static String d(String str) {
        String str2;
        boolean isEmpty = TextUtils.isEmpty(str);
        String str3 = AEResManagerConfigBean.DEFAULT_VERSION;
        if (isEmpty) {
            n.h("QAdDeviceUtils", "getHarmonyInfoFromSystemProperties propertyName is empty");
            return AEResManagerConfigBean.DEFAULT_VERSION;
        }
        try {
            str2 = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, str);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            n.e("QAdDeviceUtils", "getHarmonyInfoFromSystemProperties value: " + str2);
            return str2;
        } catch (Throwable th6) {
            th = th6;
            str3 = str2;
            n.i("QAdDeviceUtils", th, "getHarmonyInfoFromSystemProperties error: ");
            return str3;
        }
    }

    public static int e() {
        if (!z()) {
            return y(-1);
        }
        Application a16 = qv2.b.a();
        if (a16 == null) {
            return y(-1);
        }
        return y(Settings.Secure.getInt(a16.getContentResolver(), "pure_mode_state", -1));
    }

    public static synchronized String f() {
        synchronized (QAdDeviceUtils.class) {
            if (!TextUtils.isEmpty(f304119k)) {
                n.a("QAdDeviceUtils", "is cache, harmony version is = " + f304119k);
                return f304119k;
            }
            String d16 = d("hw_sc.build.platform.version");
            if (!TextUtils.isEmpty(d16)) {
                n.e("QAdDeviceUtils", "harmony version is = " + d16);
                f304119k = d16;
                return d16;
            }
            f304119k = AEResManagerConfigBean.DEFAULT_VERSION;
            return AEResManagerConfigBean.DEFAULT_VERSION;
        }
    }

    public static String g() {
        if (!TextUtils.isEmpty(f304112d)) {
            return f304112d;
        }
        synchronized (f304114f) {
            String valueOf = String.valueOf(DeviceInfoMonitor.getModel());
            if (!TextUtils.isEmpty(valueOf)) {
                f304112d = valueOf;
            }
        }
        return f304112d;
    }

    public static String h() {
        return x();
    }

    public static String i() {
        return b.c();
    }

    public static String j() {
        return b.d();
    }

    public static int k(String str) {
        if (str == null) {
            return 0;
        }
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 1653:
                if (str.equals(QADNetStatus.G_2)) {
                    c16 = 0;
                    break;
                }
                break;
            case 1684:
                if (str.equals(QADNetStatus.G_3)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1715:
                if (str.equals(QADNetStatus.G_4)) {
                    c16 = 2;
                    break;
                }
                break;
            case 1746:
                if (str.equals(QADNetStatus.G_5)) {
                    c16 = 3;
                    break;
                }
                break;
            case 3649301:
                if (str.equals("wifi")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 5;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    public static int l() {
        String j3 = j();
        if (!TextUtils.isEmpty(j3)) {
            return k(j3);
        }
        return 0;
    }

    public static int m(String str) {
        if (!TextUtils.isEmpty(str)) {
            return k(str);
        }
        return 0;
    }

    public static int n() {
        int i3;
        if (f304120l != -1) {
            n.a("QAdDeviceUtils", "sHarmonyOSStatus is = " + f304120l);
            return f304120l;
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            if (HardwareInfoProvider.HARMONY_OS.equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]))) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            f304120l = i3;
            n.e("QAdDeviceUtils", "sHarmonyOSStatus is = " + f304120l);
            return f304120l;
        } catch (Throwable th5) {
            n.b("QAdDeviceUtils", "getOSType, exception = " + th5.getMessage());
            f304120l = 0;
            return 0;
        }
    }

    public static String o() {
        return b.e();
    }

    public static String p() {
        if (!TextUtils.isEmpty(f304111c)) {
            return f304111c;
        }
        synchronized (f304116h) {
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str)) {
                f304111c = str;
            }
        }
        return f304111c;
    }

    public static NetType q() {
        String j3 = j();
        if (TextUtils.isEmpty(j3)) {
            return NetType.NET_INVALID;
        }
        j3.hashCode();
        char c16 = '\uffff';
        switch (j3.hashCode()) {
            case 1653:
                if (j3.equals(QADNetStatus.G_2)) {
                    c16 = 0;
                    break;
                }
                break;
            case 1684:
                if (j3.equals(QADNetStatus.G_3)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1715:
                if (j3.equals(QADNetStatus.G_4)) {
                    c16 = 2;
                    break;
                }
                break;
            case 1746:
                if (j3.equals(QADNetStatus.G_5)) {
                    c16 = 3;
                    break;
                }
                break;
            case 3649301:
                if (j3.equals("wifi")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return NetType.NET_2G;
            case 1:
                return NetType.NET_3G;
            case 2:
                return NetType.NET_4G;
            case 3:
                return NetType.NET_5G;
            case 4:
                return NetType.NET_WIFI;
            default:
                return NetType.NET_INVALID;
        }
    }

    public static String r() {
        return QAdConfigDefine$VersionDefine.K_QAD_PF;
    }

    public static int s() {
        return 11;
    }

    public static int t() {
        return b.g();
    }

    public static int u() {
        return b.h();
    }

    public static String v() {
        return "200043";
    }

    @NonNull
    public static String w() {
        Application a16;
        if (!TextUtils.isEmpty(f304113e)) {
            return f304113e;
        }
        synchronized (f304118j) {
            if (!TextUtils.isEmpty(f304113e)) {
                return f304113e;
            }
            try {
                a16 = qv2.b.a();
            } catch (Throwable th5) {
                n.d("QAdDeviceUtils", th5, "getSimOperator");
            }
            if (a16 == null) {
                return f304113e;
            }
            TelephonyManager telephonyManager = (TelephonyManager) a16.getSystemService("phone");
            if (telephonyManager != null) {
                if (telephonyManager.getSimState() == 5) {
                    f304113e = DeviceInfoMonitor.getSimOperator(telephonyManager);
                }
                if (f304113e == null) {
                    f304113e = "";
                }
            }
            return f304113e;
        }
    }

    public static String x() {
        if (!TextUtils.isEmpty(f304109a)) {
            return f304109a;
        }
        synchronized (f304117i) {
            String valueOf = String.valueOf(Build.VERSION.SDK_INT);
            if (!TextUtils.isEmpty(valueOf)) {
                f304109a = valueOf;
            }
        }
        return f304109a;
    }

    private static int y(int i3) {
        n.e("QAdDeviceUtils", "pureStatus = " + i3);
        if (i3 < -1) {
            return -1;
        }
        return i3;
    }

    private static boolean z() {
        if (n() == 1) {
            return true;
        }
        return false;
    }
}
