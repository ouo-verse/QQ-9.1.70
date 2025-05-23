package com.tencent.luggage.wxa.q2;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.luggage.wxa.t9.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f137805a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f137806b = "";

    /* renamed from: c, reason: collision with root package name */
    public static Map f137807c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static String f137808d = "";

    /* renamed from: e, reason: collision with root package name */
    public static Map f137809e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    public static String f137810f = "";

    /* renamed from: g, reason: collision with root package name */
    public static Map f137811g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    public static String f137812h = "";

    /* renamed from: i, reason: collision with root package name */
    public static String f137813i = "";

    /* renamed from: j, reason: collision with root package name */
    public static volatile String f137814j = "";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String str = "";
                if (!TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
                    w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: Environment.getExternalStorageState is not equals Environment.MEDIA_MOUNTED");
                    String unused = c.f137814j = "";
                    return;
                }
                b bVar = new b("Tencent/ams/cache", "meta.dat");
                b bVar2 = new b("Android/data/com.tencent.ams/cache", "meta.dat");
                if (bVar.c() && bVar2.c()) {
                    String a16 = bVar.a(10240);
                    String a17 = bVar2.a(10240);
                    if (!w0.c(a16)) {
                        w.d("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file is " + a16);
                        str = a16;
                    } else if (!w0.c(a17)) {
                        w.d("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from fileBackup is " + a17);
                        str = a17;
                    } else {
                        w.d("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: result from file and fileBackup is null");
                    }
                    String unused2 = c.f137814j = str;
                    bVar.a();
                    bVar2.a();
                    w.d("AdDeviceInfo.DeviceInfoUtils", "getUUId, timeCost = " + (System.currentTimeMillis() - currentTimeMillis) + ", len = " + str.length() + ", result = " + str);
                    return;
                }
                w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: file or fileBackup can not open");
                String unused3 = c.f137814j = "";
                bVar.a();
                bVar2.a();
            } catch (Throwable th5) {
                w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getUUId: " + th5.toString());
            }
        }
    }

    public static String b() {
        Context c16;
        TelephonyManager telephonyManager;
        if (!w0.c(f137806b)) {
            return f137806b;
        }
        if (Build.VERSION.SDK_INT < 29 && (c16 = z.c()) != null) {
            try {
                Object systemService = c16.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String str = (String) com.tencent.luggage.wxa.ia.a.a(telephonyManager, "com/tencent/luggage/jsapi/device/DeviceInfoUtils", "getDeviceId", "()Ljava/lang/String;", "android/telephony/TelephonyManager", "getDeviceId", "()Ljava/lang/String;");
                    if (!w0.c(str)) {
                        f137806b = str;
                    }
                }
            } catch (Throwable th5) {
                w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId: " + th5.toString());
            }
        }
        return f137806b;
    }

    public static String c() {
        Context c16;
        TelephonyManager telephonyManager;
        if (!w0.c(f137808d)) {
            return f137808d;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29 && i3 >= 26 && (c16 = z.c()) != null) {
            try {
                Object systemService = c16.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String str = (String) com.tencent.luggage.wxa.ia.a.a(telephonyManager, "com/tencent/luggage/jsapi/device/DeviceInfoUtils", "getIMEI", "()Ljava/lang/String;", "android/telephony/TelephonyManager", "getImei", "()Ljava/lang/String;");
                    if (!w0.c(str)) {
                        f137808d = str;
                    }
                }
            } catch (Throwable th5) {
                w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI: " + th5.toString());
            }
        }
        return f137808d;
    }

    public static String d() {
        try {
            return l.a(false);
        } catch (Throwable th5) {
            w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEIWx: " + th5.toString());
            return "";
        }
    }

    public static String e() {
        Context c16;
        TelephonyManager telephonyManager;
        if (!w0.c(f137810f)) {
            return f137810f;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29 && i3 >= 26 && (c16 = z.c()) != null) {
            try {
                Object systemService = c16.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String str = (String) com.tencent.luggage.wxa.ia.a.a(telephonyManager, "com/tencent/luggage/jsapi/device/DeviceInfoUtils", "getMEID", "()Ljava/lang/String;", "android/telephony/TelephonyManager", "getMeid", "()Ljava/lang/String;");
                    if (!w0.c(str)) {
                        f137810f = str;
                    }
                }
            } catch (Throwable th5) {
                w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID: " + th5.toString());
            }
        }
        return f137810f;
    }

    public static String f() {
        if (!w0.c(f137805a)) {
            return f137805a;
        }
        try {
            f137805a = l.h();
        } catch (Throwable th5) {
            w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getOAID: " + th5.toString());
        }
        return f137805a;
    }

    public static String g() {
        h.f146825d.execute(new a());
        return f137814j;
    }

    public static String a(int i3) {
        Context c16;
        TelephonyManager telephonyManager;
        String str = (String) f137807c.get(Integer.valueOf(i3));
        if (!w0.c(str)) {
            return str;
        }
        if (Build.VERSION.SDK_INT < 29 && (c16 = z.c()) != null) {
            try {
                Object systemService = c16.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String str2 = (String) com.tencent.luggage.wxa.ia.a.a(telephonyManager, com.tencent.luggage.wxa.ja.b.a(i3, new com.tencent.luggage.wxa.ja.a()).a(), "com/tencent/luggage/jsapi/device/DeviceInfoUtils", "getDeviceId", "(I)Ljava/lang/String;", "android/telephony/TelephonyManager", "getDeviceId", "(I)Ljava/lang/String;");
                    if (!w0.c(str2)) {
                        f137807c.put(Integer.valueOf(i3), str2);
                    }
                }
            } catch (Throwable th5) {
                w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getDeviceId" + i3 + MsgSummary.STR_COLON + th5.toString());
            }
        }
        return w0.d((String) f137807c.get(Integer.valueOf(i3)));
    }

    public static void b(String str) {
        f137808d = str;
    }

    public static String c(int i3) {
        Context c16;
        TelephonyManager telephonyManager;
        String str = (String) f137811g.get(Integer.valueOf(i3));
        if (!w0.c(str)) {
            return str;
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i16 < 29 && i16 >= 26 && (c16 = z.c()) != null) {
            try {
                Object systemService = c16.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String str2 = (String) com.tencent.luggage.wxa.ia.a.a(telephonyManager, com.tencent.luggage.wxa.ja.b.a(i3, new com.tencent.luggage.wxa.ja.a()).a(), "com/tencent/luggage/jsapi/device/DeviceInfoUtils", "getMEID", "(I)Ljava/lang/String;", "android/telephony/TelephonyManager", "getMeid", "(I)Ljava/lang/String;");
                    if (!w0.c(str2)) {
                        f137811g.put(Integer.valueOf(i3), str2);
                    }
                }
            } catch (Throwable th5) {
                w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getMEID" + i3 + MsgSummary.STR_COLON + th5.toString());
            }
        }
        return w0.d((String) f137811g.get(Integer.valueOf(i3)));
    }

    public static void a(int i3, String str) {
        f137809e.put(Integer.valueOf(i3), str);
    }

    public static String b(int i3) {
        Context c16;
        TelephonyManager telephonyManager;
        String str = (String) f137809e.get(Integer.valueOf(i3));
        if (!w0.c(str)) {
            return str;
        }
        int i16 = Build.VERSION.SDK_INT;
        if (i16 < 29 && i16 >= 26 && (c16 = z.c()) != null) {
            try {
                Object systemService = c16.getSystemService("phone");
                if ((systemService instanceof TelephonyManager) && (telephonyManager = (TelephonyManager) TelephonyManager.class.cast(systemService)) != null) {
                    String str2 = (String) com.tencent.luggage.wxa.ia.a.a(telephonyManager, com.tencent.luggage.wxa.ja.b.a(i3, new com.tencent.luggage.wxa.ja.a()).a(), "com/tencent/luggage/jsapi/device/DeviceInfoUtils", "getIMEI", "(I)Ljava/lang/String;", "android/telephony/TelephonyManager", "getImei", "(I)Ljava/lang/String;");
                    if (!w0.c(str2)) {
                        f137809e.put(Integer.valueOf(i3), str2);
                    }
                }
            } catch (Throwable th5) {
                w.b("AdDeviceInfo.DeviceInfoUtils", "AdDeviceInfo.DeviceInfoUtils.getIMEI" + i3 + MsgSummary.STR_COLON + th5.toString());
            }
        }
        return w0.d((String) f137809e.get(Integer.valueOf(i3)));
    }

    public static String a() {
        return l.b();
    }
}
