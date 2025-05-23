package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class n3 {

    /* renamed from: a, reason: collision with root package name */
    public static n3 f29894a;

    public static n3 a() {
        if (f29894a == null) {
            f29894a = new n3();
        }
        return f29894a;
    }

    public boolean b(Context context) {
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception unused) {
        }
        if (telephonyManager == null) {
            return false;
        }
        if (telephonyManager.getSimState() != 5) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:5|6|7|(4:9|10|11|(1:13)(10:37|15|16|(8:18|(1:20)(1:33)|21|22|(1:24)|(1:26)|(1:28)|(2:30|31)(1:32))|35|22|(0)|(0)|(0)|(0)(0)))(1:42)|14|15|16|(0)|35|22|(0)|(0)|(0)|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036 A[Catch: Exception -> 0x0048, TryCatch #0 {Exception -> 0x0048, blocks: (B:16:0x002b, B:18:0x0036, B:33:0x0041), top: B:15:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(Context context) {
        boolean z16;
        boolean z17;
        boolean z18;
        LocationManager locationManager;
        WifiManager wifiManager;
        if (context == null) {
            return -1;
        }
        boolean b16 = b(context);
        boolean z19 = false;
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
        } catch (Error | Exception unused) {
            z16 = false;
        }
        if (wifiManager != null) {
            z16 = wifiManager.isWifiEnabled();
            try {
            } catch (Error | Exception unused2) {
                z17 = false;
                locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager != null) {
                }
                z18 = false;
                int i3 = !b16 ? 1 : 0;
                if (!z16) {
                }
                if (!z19) {
                }
                if (!z17) {
                }
                if (z18) {
                }
            }
            if (wifiManager.isScanAlwaysAvailable()) {
                z17 = true;
            } else {
                z17 = true;
                locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager != null) {
                    boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                    List<String> allProviders = locationManager.getAllProviders();
                    if (allProviders != null) {
                        z19 = allProviders.contains("gps");
                    }
                    z18 = z19;
                    z19 = isProviderEnabled;
                    int i36 = !b16 ? 1 : 0;
                    if (!z16) {
                        i36 |= 2;
                    }
                    if (!z19) {
                        i36 |= 4;
                    }
                    if (!z17) {
                        i36 |= 8;
                    }
                    return z18 ? i36 | 16 : i36;
                }
                z18 = false;
                int i362 = !b16 ? 1 : 0;
                if (!z16) {
                }
                if (!z19) {
                }
                if (!z17) {
                }
                if (z18) {
                }
            }
        } else {
            z17 = false;
        }
        z16 = z17;
        locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager != null) {
        }
        z18 = false;
        int i3622 = !b16 ? 1 : 0;
        if (!z16) {
        }
        if (!z19) {
        }
        if (!z17) {
        }
        if (z18) {
        }
    }
}
