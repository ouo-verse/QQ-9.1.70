package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;

/* compiled from: P */
/* loaded from: classes.dex */
public class p3 {
    public static int a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (q3.a(connectivityManager)) {
            return -1;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return NetworkMonitor.getType(activeNetworkInfo);
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static String b(Context context) {
        int a16 = a(context);
        if (a16 == -1) {
            return "none";
        }
        if (a16 == 0) {
            return DeviceType.DeviceCategory.MOBILE;
        }
        if (a16 != 1) {
            return "none";
        }
        return "wifi";
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!q3.a(connectivityManager) && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 1) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
