package com.tencent.luggage.wxa.oh;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.luggage.wxa.tn.w;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static WifiManager f136524a;

    public static int a(int i3, int i16) {
        if (i3 <= -100) {
            return 0;
        }
        int i17 = i16 - 1;
        if (i3 >= -55) {
            return i17;
        }
        return (int) (((i3 - (-100)) * i17) / 45.0f);
    }

    public static boolean b(int i3) {
        try {
            return f136524a.removeNetwork(i3);
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "removeNetwork", new Object[0]);
            return false;
        }
    }

    public static List c() {
        try {
            return (List) com.tencent.luggage.wxa.ia.a.a(f136524a, "com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiManagerInternalWrapper", "getScanResults", "()Ljava/util/List;", "android/net/wifi/WifiManager", "getScanResults", "()Ljava/util/List;");
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "getScanResults", new Object[0]);
            return null;
        }
    }

    public static WifiManager d() {
        return f136524a;
    }

    public static boolean e() {
        try {
            return f136524a.isWifiEnabled();
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "isWifiEnabled", new Object[0]);
            return false;
        }
    }

    public static boolean f() {
        try {
            return f136524a.saveConfiguration();
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "saveConfiguration", new Object[0]);
            return false;
        }
    }

    public static boolean g() {
        try {
            return ((Boolean) com.tencent.luggage.wxa.ia.a.a(f136524a, "com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiManagerInternalWrapper", "startScan", "()Z", "android/net/wifi/WifiManager", "startScan", "()Z")).booleanValue();
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "startScan", new Object[0]);
            return false;
        }
    }

    public static void a(WifiManager wifiManager) {
        f136524a = wifiManager;
    }

    public static List a() {
        try {
            return (List) com.tencent.luggage.wxa.ia.a.a(f136524a, "com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiManagerInternalWrapper", "getConfiguredNetworks", "()Ljava/util/List;", "android/net/wifi/WifiManager", "getConfiguredNetworks", "()Ljava/util/List;");
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "getConfiguredNetworks", new Object[0]);
            return null;
        }
    }

    public static WifiInfo b() {
        try {
            return (WifiInfo) com.tencent.luggage.wxa.ia.a.a(f136524a, "com/tencent/mm/plugin/appbrand/jsapi/wifi/wifisdk/internal/WifiManagerInternalWrapper", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "getConnectionInfo", new Object[0]);
            return null;
        }
    }

    public static int a(WifiConfiguration wifiConfiguration) {
        try {
            return f136524a.addNetwork(wifiConfiguration);
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "addNetwork", new Object[0]);
            return e.f136525a;
        }
    }

    public static boolean a(int i3, boolean z16) {
        try {
            return f136524a.enableNetwork(i3, z16);
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "enableNetwork", new Object[0]);
            return false;
        }
    }

    public static boolean a(int i3) {
        try {
            return f136524a.disableNetwork(i3);
        } catch (Throwable th5) {
            w.a("MicroMsg.WifiManagerInternalWrapper", th5, "disableNetwork", new Object[0]);
            return false;
        }
    }
}
