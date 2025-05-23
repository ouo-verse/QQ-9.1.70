package com.tencent.luggage.wxa.oh;

import android.net.wifi.WifiConfiguration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {
    public static int a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null || wifiConfiguration.networkId >= 0) {
            return -1;
        }
        int a16 = d.a(wifiConfiguration);
        wifiConfiguration.networkId = a16;
        return a16;
    }

    public static WifiConfiguration b(String str, int i3) {
        List a16 = a();
        if (a16 != null) {
            return a(str, i3, a16);
        }
        return null;
    }

    public static boolean c(String str, int i3) {
        boolean z16 = false;
        if (str != null && str.length() > 0) {
            List<WifiConfiguration> a16 = a();
            if (a16 != null) {
                for (WifiConfiguration wifiConfiguration : a16) {
                    if (e.a(wifiConfiguration.SSID).compareTo(str) == 0 && e.a(wifiConfiguration) == i3) {
                        z16 |= d.b(wifiConfiguration.networkId);
                    }
                }
            }
            if (z16) {
                d.f();
            }
        }
        return z16;
    }

    public static WifiConfiguration a(String str, int i3, List list) {
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WifiConfiguration wifiConfiguration = (WifiConfiguration) it.next();
            if (e.a(wifiConfiguration.SSID).compareTo(str) == 0 && e.a(wifiConfiguration) == i3) {
                return wifiConfiguration;
            }
        }
        return null;
    }

    public static WifiConfiguration b(String str) {
        List a16 = a();
        if (a16 != null) {
            return a(str, a16);
        }
        return null;
    }

    public static WifiConfiguration a(String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WifiConfiguration wifiConfiguration = (WifiConfiguration) it.next();
            if (Objects.equals(wifiConfiguration.BSSID, str)) {
                return wifiConfiguration;
            }
        }
        return null;
    }

    public static List a() {
        return d.a();
    }

    public static WifiConfiguration a(String str, int i3, String str2) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = a(str);
        wifiConfiguration.hiddenSSID = true;
        if (i3 == 0) {
            wifiConfiguration.allowedKeyManagement.set(0);
        } else {
            if (i3 != 2) {
                return null;
            }
            if (str2.length() != 0) {
                if (str2.matches("[0-9A-Fa-f]{64}")) {
                    wifiConfiguration.preSharedKey = str2;
                } else {
                    wifiConfiguration.preSharedKey = '\"' + str2 + '\"';
                }
            }
        }
        wifiConfiguration.status = 2;
        return wifiConfiguration;
    }

    public static String a(String str) {
        return "\"" + str + "\"";
    }

    public static boolean a(int i3) {
        if (!d.b(i3) && !d.a(i3)) {
            return false;
        }
        d.f();
        return true;
    }

    public static boolean a(String str, int i3) {
        if (!c(str, i3)) {
            return false;
        }
        d.f();
        return true;
    }
}
