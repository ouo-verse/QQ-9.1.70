package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class x3 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f30103a = false;

    /* renamed from: b, reason: collision with root package name */
    public static long f30104b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static long f30105c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f30106d = false;

    /* renamed from: e, reason: collision with root package name */
    public static List<ScanResult> f30107e;

    /* renamed from: f, reason: collision with root package name */
    public static long f30108f;

    public static synchronized boolean a(WifiManager wifiManager) {
        boolean z16;
        boolean z17;
        synchronized (x3.class) {
            z16 = false;
            if (wifiManager != null) {
                try {
                    if (System.currentTimeMillis() - f30104b >= 30000) {
                        o3.a("Wifis", "start scan");
                        z17 = NetworkMonitor.startScan(wifiManager);
                        try {
                            f30106d = z17;
                            f30104b = System.currentTimeMillis();
                        } catch (Exception unused) {
                            z16 = z17;
                            f30103a = true;
                            return z16;
                        }
                    } else {
                        z17 = f30106d;
                    }
                    z16 = z17;
                } catch (Exception unused2) {
                }
            }
        }
        return z16;
    }

    public static boolean b(n1 n1Var) {
        try {
            WifiManager f16 = n1Var.f();
            if (f16 == null) {
                return false;
            }
            if (!f16.isWifiEnabled()) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            o3.a("Wifis", th5.toString());
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean c(n1 n1Var) {
        WifiManager f16 = n1Var.f();
        boolean z16 = false;
        if (f16 == null) {
            return false;
        }
        try {
            z16 = f16.isWifiEnabled();
            if (!z16) {
                return f16.isScanAlwaysAvailable();
            }
            return z16;
        } catch (Throwable unused) {
            return z16;
        }
    }

    public static synchronized List<ScanResult> a(WifiManager wifiManager, boolean z16) {
        synchronized (x3.class) {
            if (!z16) {
                r1 = System.currentTimeMillis() - f30108f < 20000 ? f30107e : null;
                if (r1 != null) {
                    o3.a("wifis", "getScanResultsQuietly, cached wifi size: " + r1.size());
                    return r1;
                }
            }
            if (wifiManager != null) {
                try {
                    if (f30108f != 0 && System.currentTimeMillis() - f30108f <= 10000) {
                        r1 = f30107e;
                        f30103a = false;
                    }
                    r1 = NetworkMonitor.getScanResults(wifiManager);
                    f30108f = System.currentTimeMillis();
                    f30107e = r1;
                    f30103a = false;
                } catch (Exception unused) {
                    f30103a = true;
                }
            }
            if (r1 == null) {
                r1 = Collections.emptyList();
            }
            return r1;
        }
    }

    public static String a(n1 n1Var) {
        String bssid;
        int rssi;
        Context context = n1Var.f29875a;
        if (context == null) {
            return "{}";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (wifiManager != null && connectivityManager != null) {
                WifiInfo connectionInfo = LocationMonitor.getConnectionInfo(wifiManager);
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (connectionInfo != null && networkInfo != null && networkInfo.isConnected() && (bssid = NetworkMonitor.getBSSID(connectionInfo)) != null && !bssid.equals("000000000000") && !bssid.equals("00-00-00-00-00-00") && !bssid.equals("00:00:00:00:00:00") && (rssi = connectionInfo.getRssi()) >= -100 && rssi <= -20) {
                    return "{\"mac\":\"" + bssid + "\",\"rssi\":" + rssi + ",\"ssid\":\"" + NetworkMonitor.getSSID(connectionInfo).replace("\"", "").replace("|", "") + "\"}";
                }
            }
        } catch (Exception unused) {
        }
        return "{}";
    }
}
