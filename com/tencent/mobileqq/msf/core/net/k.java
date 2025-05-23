package com.tencent.mobileqq.msf.core.net;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f248769a = "MsfNetUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final int f248770b = 16;

    /* renamed from: c, reason: collision with root package name */
    private static final int f248771c = 17;

    /* renamed from: d, reason: collision with root package name */
    private static final int f248772d = 18;

    /* renamed from: e, reason: collision with root package name */
    private static final int f248773e = 19;

    /* renamed from: f, reason: collision with root package name */
    private static final int f248774f = 20;

    /* renamed from: g, reason: collision with root package name */
    private static final int f248775g = 10;

    /* renamed from: h, reason: collision with root package name */
    private static final int f248776h = 11;

    /* renamed from: i, reason: collision with root package name */
    private static final int f248777i = 12;

    /* renamed from: j, reason: collision with root package name */
    private static final int f248778j = 14;

    /* renamed from: k, reason: collision with root package name */
    private static final int f248779k = 15;

    /* renamed from: l, reason: collision with root package name */
    public static final String f248780l = "IPv4";

    /* renamed from: m, reason: collision with root package name */
    public static final String f248781m = "IPv6";

    /* renamed from: n, reason: collision with root package name */
    public static final String f248782n = "v4v6";

    /* renamed from: o, reason: collision with root package name */
    public static final String f248783o = "none";

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? "none" : "v4v6" : "IPv6" : "IPv4";
    }

    public static ArrayList<InetAddress> b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity");
        try {
            LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
            if (linkProperties != null) {
                return new ArrayList<>(linkProperties.getDnsServers());
            }
        } catch (Throwable unused) {
            QLog.w(f248769a, 1, "err: th");
        }
        return null;
    }

    public static String c() {
        return System.getProperty("http.proxyHost");
    }

    public static byte d() {
        if (NetConnInfoCenter.isWifiConn()) {
            return (byte) 1;
        }
        if (NetConnInfoCenter.isMobileConn()) {
            int mobileNetworkType = NetConnInfoCenter.getMobileNetworkType();
            if (mobileNetworkType != 20) {
                mobileNetworkType += 100;
            }
            if (mobileNetworkType > 254) {
                if (QLog.isColorLevel()) {
                    QLog.d(f248769a, 2, "error,netWorkType is 254");
                }
                mobileNetworkType = 254;
            }
            return (byte) mobileNetworkType;
        }
        return (byte) 0;
    }

    public static boolean e() {
        if (!NetConnInfoCenter.isWifiConn() && (NetConnInfoCenter.isWifiOrMobileConn() || NetConnInfoCenter.getCurrentAPN() != null)) {
            return false;
        }
        return true;
    }

    public static NetworkInfo[] a() {
        try {
            return ((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getAllNetworkInfo();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static int a(NetworkInfo networkInfo) {
        int i3;
        if (networkInfo != null && networkInfo.isAvailable()) {
            int type = NetworkMonitor.getType(networkInfo);
            i3 = 4;
            if (type != 0 && type != 2 && type != 3 && type != 4 && type != 5 && type != 14 && type != 15) {
                switch (type) {
                    case 10:
                    case 11:
                    case 12:
                        break;
                    default:
                        QLog.d(f248769a, 1, "Unexcepted Mobile Type:" + type);
                        i3 = -1;
                        break;
                }
            }
            TelephonyManager telephonyManager = (TelephonyManager) BaseApplication.getContext().getSystemService("phone");
            int a16 = com.tencent.mobileqq.msf.sdk.c.a(telephonyManager, networkInfo);
            switch (a16) {
                case 0:
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    i3 = 1;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    i3 = 2;
                    break;
                case 13:
                case 18:
                case 19:
                    i3 = 3;
                    break;
                case 20:
                    break;
                default:
                    i3 = com.tencent.mobileqq.msf.sdk.c.a(telephonyManager, a16);
                    QLog.d(f248769a, 1, "Unexcepted networkType:" + a16 + " ,mobileInfo:" + i3);
                    break;
            }
        } else {
            i3 = 0;
        }
        QLog.d(f248769a, 1, "Mobile Type:" + i3);
        return i3;
    }

    public static boolean a(com.tencent.mobileqq.msf.core.d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.f247935l)) {
            return false;
        }
        boolean z16 = true;
        char c16 = com.tencent.mobileqq.msf.core.d.f247921x.equals(dVar.f247935l) ? (char) 2 : (char) 1;
        if ((!NetConnInfoCenter.isWifiConn() || c16 != 1) && (!NetConnInfoCenter.isMobileConn() || c16 != 2)) {
            z16 = false;
        }
        if (com.tencent.mobileqq.msf.core.d.f247921x.equals(dVar.f247935l)) {
            return false;
        }
        return z16;
    }
}
