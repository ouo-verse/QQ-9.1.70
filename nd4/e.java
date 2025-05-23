package nd4;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes26.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f419980a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f419981b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile NetworkRequest f419982c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile AtomicBoolean f419983d = new AtomicBoolean(false);

    /* compiled from: P */
    @RequiresApi(api = 21)
    /* loaded from: classes26.dex */
    private static class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            e.b();
            Log.d("TAB.NetworkUtils", "network onAvailable");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            e.b();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            e.b();
            Log.d("TAB.NetworkUtils", "network onLost");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        f419980a = null;
    }

    private static boolean c(ConnectivityManager connectivityManager) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return d(networkCapabilities);
    }

    @RequiresApi(api = 21)
    private static boolean d(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return false;
        }
        if (!NetworkMonitor.hasTransport(networkCapabilities, 1) && !NetworkMonitor.hasTransport(networkCapabilities, 0) && !NetworkMonitor.hasTransport(networkCapabilities, 3) && !NetworkMonitor.hasTransport(networkCapabilities, 7) && !NetworkMonitor.hasTransport(networkCapabilities, 4) && !networkCapabilities.hasCapability(16)) {
            return false;
        }
        return true;
    }

    private static boolean e(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
            return NetworkMonitor.hasTransport(networkCapabilities, 1);
        }
        return false;
    }

    private static String f(TelephonyManager telephonyManager, ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo;
        int h16 = h(telephonyManager);
        if (h16 == 0) {
            if (Build.VERSION.SDK_INT >= 30) {
                return "NULL";
            }
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                h16 = NetworkMonitor.getSubtype(activeNetworkInfo);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put(1, "2G");
        hashMap.put(2, "2G");
        hashMap.put(4, "2G");
        hashMap.put(7, "2G");
        hashMap.put(11, "2G");
        hashMap.put(3, "3G");
        hashMap.put(5, "3G");
        hashMap.put(6, "3G");
        hashMap.put(8, "3G");
        hashMap.put(9, "3G");
        hashMap.put(10, "3G");
        hashMap.put(12, "3G");
        hashMap.put(14, "3G");
        hashMap.put(15, "3G");
        hashMap.put(13, "4G");
        hashMap.put(18, "4G");
        hashMap.put(19, "4G");
        String str = (String) hashMap.get(Integer.valueOf(h16));
        if (TextUtils.isEmpty(str)) {
            return "UNKNOWN";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g() {
        try {
            if (!TextUtils.isEmpty(f419980a) && !TextUtils.equals("NULL", f419980a)) {
                return f419980a;
            }
            Application a16 = l.a();
            if (!u.a("android.permission.ACCESS_NETWORK_STATE")) {
                f419980a = "NULL";
                return "NULL";
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) a16.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (!c(connectivityManager)) {
                    f419980a = "NULL";
                    return "NULL";
                }
                if (e(connectivityManager)) {
                    f419980a = com.tencent.mobileqq.msf.core.x.q.f250391w;
                    return com.tencent.mobileqq.msf.core.x.q.f250391w;
                }
            }
            String f16 = f((TelephonyManager) a16.getSystemService("phone"), connectivityManager);
            f419980a = f16;
            return f16;
        } catch (Exception unused) {
            f419980a = "NULL";
            return "NULL";
        }
    }

    private static int h(TelephonyManager telephonyManager) {
        if (telephonyManager != null) {
            if (Build.VERSION.SDK_INT > 30 && (u.a(DeviceInfoUtil.PERMISSION_READ_PHONE) || telephonyManager.hasCarrierPrivileges())) {
                return NetworkMonitor.getDataNetworkType(telephonyManager);
            }
            try {
                return NetworkMonitor.getNetworkType(telephonyManager);
            } catch (Exception e16) {
                Log.e("TAB.NetworkUtils", e16.getMessage());
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void i() {
        synchronized (e.class) {
            Application a16 = l.a();
            try {
                if (f419981b == null || f419982c == null) {
                    f419981b = new b();
                    f419982c = new NetworkRequest.Builder().build();
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) a16.getSystemService("connectivity");
                if (f419983d.compareAndSet(false, true) && connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(f419982c, f419981b);
                    Log.d("TAB.NetworkUtils", "Register NetworkCallback");
                }
            } catch (Exception e16) {
                Log.d("TAB.NetworkUtils", e16.toString());
            }
        }
    }
}
