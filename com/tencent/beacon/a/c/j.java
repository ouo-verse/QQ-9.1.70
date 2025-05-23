package com.tencent.beacon.a.c;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.beacon.base.util.BeaconLogger;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.sdk.QimeiSDK;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f77678a = true;

    @Nullable
    public static Qimei b(String str) {
        Context b16 = c.c().b();
        if (b16 == null) {
            return null;
        }
        com.tencent.beacon.base.util.c.a("QimeiWrapper", "getQimeiWithAppkey  appkey is %s", str);
        c(b16, str);
        return QimeiSDK.getInstance(str).getQimei();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context, String str) {
        if (!f77678a) {
            return false;
        }
        QimeiSDK.getInstance(str).setSdkName("beacon");
        return QimeiSDK.getInstance(str).init(context);
    }

    private static void d(String str) {
        QimeiSDK.getInstance(str).setAppVersion(b.a()).setChannelID(c.c().a(str)).setLogAble(com.tencent.beacon.base.util.c.b()).addUserId("QQ", b.c()).addUserId("OMGID", c.c().f());
    }

    private static void e(String str) {
        BeaconLogger a16 = com.tencent.beacon.base.util.c.a();
        if (a16 != null) {
            QimeiSDK.getInstance(str).setLogObserver(new h(a16));
        }
    }

    public static String f() {
        String beaconTicket;
        if (!com.tencent.beacon.d.b.a().f() || (beaconTicket = QimeiSDK.getInstance(c.c().e()).getBeaconTicket()) == null) {
            return "";
        }
        return beaconTicket;
    }

    public static void g() {
        String e16 = c.c().e();
        com.tencent.beacon.base.util.c.a("QimeiWrapper", "initQimei: appkey is %s , qimei init %s", e16, Boolean.valueOf(c(c.c().b(), e16)));
        QimeiSDK.getInstance(e16).getQimei(new g());
    }

    public static void a(boolean z16) {
        f77678a = z16;
    }

    public static void a() {
        if (f77678a) {
            try {
                String e16 = c.c().e();
                d(e16);
                a(e16);
                e(e16);
            } catch (Throwable th5) {
                com.tencent.beacon.a.b.i.e().a(ThemeReporter.FROM_WEEKLOOP, "sdk init error! package name: " + b.b() + " , msg:" + th5.getMessage(), th5);
                com.tencent.beacon.base.util.c.a(th5);
            }
        }
    }

    public static String e() {
        return QimeiSDK.getInstance(c.c().e()).getSdkVersion();
    }

    public static String c() {
        Qimei qimei = QimeiSDK.getInstance(c.c().e()).getQimei();
        return qimei == null ? "" : qimei.getQimei36();
    }

    @Nullable
    public static Qimei b(Context context, String str) {
        if (context == null || context.getApplicationContext() == null) {
            return null;
        }
        c(context.getApplicationContext(), str);
        return QimeiSDK.getInstance(str).getQimei();
    }

    public static void c(String str) {
        com.tencent.beacon.base.util.c.b("\u5185\u90e8\u7248\u8be5\u63a5\u53e3\u65e0\u6548", new Object[0]);
    }

    public static Map<String, String> d() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("A3", b());
        hashMap.put("A153", c());
        return hashMap;
    }

    public static String b() {
        Qimei qimei = QimeiSDK.getInstance(c.c().e()).getQimei();
        return qimei == null ? "" : qimei.getQimei16();
    }

    public static void a(String str) {
        QimeiSDK.getInstance(str).getStrategy().enableProcessInfo(com.tencent.beacon.d.b.a().l());
    }

    public static void a(String str, Context context, IAsyncQimeiListener iAsyncQimeiListener) {
        com.tencent.beacon.base.util.e.a("context", context);
        com.tencent.beacon.base.util.e.a("ApplicationContext", context.getApplicationContext());
        com.tencent.beacon.a.b.a.a().a(new i(str, context, iAsyncQimeiListener));
    }

    public static synchronized void a(String str, String str2) {
        synchronized (j.class) {
            com.tencent.beacon.base.util.c.b("\u5185\u90e8\u7248\u8be5\u63a5\u53e3\u65e0\u6548", new Object[0]);
        }
    }
}
