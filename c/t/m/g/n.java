package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap f29873a = new HashMap();

    public static int a(Context context) {
        try {
            return a((WifiManager) context.getSystemService("wifi"));
        } catch (Throwable unused) {
            return 4;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int a(WifiManager wifiManager) {
        if (wifiManager != null) {
            try {
            } catch (Throwable unused) {
                return 4;
            }
        }
        return wifiManager.getWifiState();
    }

    @SuppressLint({"MissingPermission"})
    public static String a() {
        try {
            d0 a16 = m1.a();
            if (a16 == null) {
                return "{}";
            }
            a16.a();
            throw null;
        } catch (Throwable unused) {
            return "{}";
        }
    }

    public static boolean a(List<ScanResult> list) {
        if (list != null && list.size() > 1) {
            String str = list.get(0).BSSID;
            for (int i3 = 1; i3 < list.size(); i3++) {
                if (!str.equals(list.get(i3).BSSID)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static synchronized boolean a(List<ScanResult> list, List<ScanResult> list2) {
        synchronized (n.class) {
            if (list == list2) {
                return true;
            }
            int size = list == null ? 0 : list.size();
            if (size != (list2 == null ? 0 : list2.size())) {
                return false;
            }
            if (size == 0) {
                return true;
            }
            try {
                HashMap hashMap = f29873a;
                hashMap.clear();
                for (ScanResult scanResult : list) {
                    hashMap.put(scanResult.BSSID, Integer.valueOf(scanResult.level));
                }
                for (ScanResult scanResult2 : list2) {
                    if (!hashMap.containsKey(scanResult2.BSSID) || scanResult2.level != ((Integer) hashMap.get(scanResult2.BSSID)).intValue()) {
                        return false;
                    }
                }
            } catch (Throwable th5) {
                c1.a("Wifis", "", th5);
            }
            return true;
        }
    }
}
