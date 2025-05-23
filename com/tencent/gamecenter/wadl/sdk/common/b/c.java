package com.tencent.gamecenter.wadl.sdk.common.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile byte f107012a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f107013b = true;

    /* renamed from: c, reason: collision with root package name */
    private static String f107014c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f107015d = "unknown";

    /* renamed from: e, reason: collision with root package name */
    private static volatile int f107016e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f107017f = false;

    /* renamed from: g, reason: collision with root package name */
    public static String f107018g = "";

    /* renamed from: h, reason: collision with root package name */
    private static Map<String, d> f107019h = new ConcurrentHashMap();

    /* renamed from: i, reason: collision with root package name */
    private static BroadcastReceiver f107020i = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends BroadcastReceiver {

        /* compiled from: P */
        /* renamed from: com.tencent.gamecenter.wadl.sdk.common.b.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class RunnableC1123a implements Runnable {

            /* compiled from: P */
            /* renamed from: com.tencent.gamecenter.wadl.sdk.common.b.c$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            class RunnableC1124a implements Runnable {
                RunnableC1124a(RunnableC1123a runnableC1123a) {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.a("ApnInfo", "delay call update ip type..");
                        c.a();
                    } catch (Throwable th5) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.c("ApnInfo", "delay call update ip type fail", th5);
                    }
                }
            }

            RunnableC1123a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.m();
                    if (c.a()) {
                        com.tencent.gamecenter.wadl.sdk.common.a.g().postDelayed(new RunnableC1124a(this), 2000L);
                    }
                } catch (Throwable th5) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.c("ApnInfo", "update apn fail", th5);
                }
            }
        }

        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.tencent.gamecenter.wadl.sdk.common.a.g().post(new RunnableC1123a(this));
        }
    }

    private static byte a(String str) {
        try {
            NetworkInterface byName = NetworkInterface.getByName(str);
            if (!byName.isUp()) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("ApnInfo", "networkInterface is down just pass it..");
                return (byte) 1;
            }
            Iterator<InterfaceAddress> it = NetworkMonitor.getInterfaceAddresses(byName).iterator();
            boolean z16 = false;
            boolean z17 = false;
            while (it.hasNext()) {
                InetAddress address = it.next().getAddress();
                if (!address.isLoopbackAddress()) {
                    String hostAddress = address.getHostAddress();
                    if (hostAddress.contains("%")) {
                        hostAddress = hostAddress.split("%")[0];
                    }
                    if (com.tencent.gamecenter.wadl.sdk.common.e.c.b(hostAddress)) {
                        z16 = true;
                    } else if (!z17 && com.tencent.gamecenter.wadl.sdk.common.e.c.c(hostAddress) && com.tencent.gamecenter.wadl.sdk.common.e.c.a(hostAddress)) {
                        z17 = true;
                    }
                }
            }
            if (z16 && z17) {
                return (byte) 2;
            }
            if (z17) {
                return (byte) 3;
            }
            return z16 ? (byte) 1 : (byte) 0;
        } catch (Exception e16) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("ApnInfo", "checkIPType exception", e16);
            return (byte) 0;
        }
    }

    public static int b(String str) {
        int i3;
        Integer num = 0;
        if (TextUtils.isEmpty(str)) {
            return num.intValue();
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("cmnet") || lowerCase.contains("cmwap")) {
            i3 = 1;
        } else if (lowerCase.contains("uninet") || lowerCase.contains("uniwap") || lowerCase.contains("3gnet") || lowerCase.contains("3gwap")) {
            i3 = 2;
        } else {
            if (!lowerCase.contains("ctnet") && !lowerCase.contains("ctwap")) {
                return num.intValue();
            }
            i3 = 3;
        }
        return Integer.valueOf(i3).intValue();
    }

    public static byte c() {
        return f107012a;
    }

    public static int d() {
        return f107016e;
    }

    public static Proxy e() {
        if (k() && !TextUtils.isEmpty(f107018g)) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(f107018g, 80));
        }
        return null;
    }

    public static Integer f() {
        int i3;
        m();
        if (i()) {
            i3 = a(com.tencent.gamecenter.wadl.sdk.common.a.b(), f107014c).intValue();
        } else {
            i3 = 0;
        }
        return Integer.valueOf(i3);
    }

    public static void g() {
        try {
            n();
            m();
            com.tencent.gamecenter.wadl.sdk.common.a.b().registerReceiver(f107020i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable th5) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("ApnInfo", "init fail", th5);
        }
    }

    public static boolean h() {
        try {
            PowerManager powerManager = (PowerManager) com.tencent.gamecenter.wadl.sdk.common.a.b().getSystemService("power");
            if (powerManager != null) {
                return ((Boolean) PowerManager.class.getDeclaredMethod(j.K0, new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
            }
        } catch (Throwable th5) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("ApnInfo", "isDozeMode check fail", th5);
        }
        return false;
    }

    public static boolean i() {
        if (f107016e != 2 && f107016e != 3 && f107016e != 4 && f107016e != 5) {
            return false;
        }
        return true;
    }

    public static boolean j() {
        return f107013b;
    }

    public static boolean k() {
        return f107017f;
    }

    private static void l() {
        f107014c = "unknown";
        f107016e = 0;
        f107015d = "unknown";
        f107017f = false;
    }

    public static synchronized void m() {
        synchronized (c.class) {
            int i3 = f107016e;
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.tencent.gamecenter.wadl.sdk.common.a.b().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    f107013b = true;
                    int type = NetworkMonitor.getType(activeNetworkInfo);
                    if (type == 1) {
                        f107016e = 1;
                        f107017f = false;
                        f107015d = "ssid_wifi";
                    } else if (type == 0) {
                        String netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
                        if (netGetExInfo != null) {
                            f107014c = netGetExInfo.trim().toLowerCase();
                            f107015d = "apn_" + f107014c;
                            f107016e = a(NetworkMonitor.getSubtype(activeNetworkInfo));
                            f107017f = f107014c.contains("wap");
                            if (f107017f) {
                                f107018g = c(f107014c);
                            }
                        } else {
                            l();
                        }
                    }
                } else {
                    l();
                    f107013b = false;
                    f107012a = (byte) 0;
                }
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("ApnInfo", "updateApn lastType=" + i3 + ",DB_APN_NAME=" + f107015d);
                if (i3 != f107016e) {
                    synchronized (f107019h) {
                        for (d dVar : f107019h.values()) {
                            if (dVar != null) {
                                dVar.onNetworkSwitch(f107016e, f107015d);
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                try {
                    th5.printStackTrace();
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("ApnInfo", "updateApn lastType=" + i3 + ",DB_APN_NAME=" + f107015d);
                    if (i3 != f107016e) {
                        synchronized (f107019h) {
                            for (d dVar2 : f107019h.values()) {
                                if (dVar2 != null) {
                                    dVar2.onNetworkSwitch(f107016e, f107015d);
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("ApnInfo", "updateApn lastType=" + i3 + ",DB_APN_NAME=" + f107015d);
                    if (i3 != f107016e) {
                        synchronized (f107019h) {
                            for (d dVar3 : f107019h.values()) {
                                if (dVar3 != null) {
                                    dVar3.onNetworkSwitch(f107016e, f107015d);
                                }
                            }
                        }
                    }
                    throw th6;
                }
            }
        }
    }

    private static boolean n() {
        LinkProperties linkProperties;
        ConnectivityManager connectivityManager = (ConnectivityManager) com.tencent.gamecenter.wadl.sdk.common.a.b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("ApnInfo", "ready to obtain iptype");
            try {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null) {
                    linkProperties = connectivityManager.getLinkProperties(activeNetwork);
                } else {
                    linkProperties = null;
                }
                if (linkProperties == null) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("ApnInfo", "activeLinkProperties is null");
                    f107012a = (byte) 0;
                } else {
                    f107012a = a(linkProperties.getInterfaceName());
                }
            } catch (Exception unused) {
                f107012a = (byte) 0;
            }
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("ApnInfo", "IPType is:" + ((int) f107012a));
            return true;
        }
        f107012a = (byte) 0;
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("ApnInfo", "not obtain ip type");
        return false;
    }

    private static int a(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            return 2;
        }
        if (i3 == 13 || i3 == 19) {
            return 4;
        }
        return i3 == 20 ? 5 : 3;
    }

    public static String b() {
        return f107015d;
    }

    private static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : (str.contains("3gwap") || str.contains("cmwap") || str.contains("uniwap")) ? "10.0.0.172" : str.contains("ctwap") ? "10.0.0.200" : "";
    }

    public static void d(String str) {
        synchronized (f107019h) {
            f107019h.remove(str);
        }
    }

    private static Integer a(Context context, String str) {
        int b16;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && telephonyManager.getSimState() == 5) {
            String simOperator = DeviceInfoMonitor.getSimOperator(telephonyManager);
            if (simOperator.length() > 0) {
                if (simOperator.equals("46000") || simOperator.equals("46002")) {
                    b16 = 1;
                } else if (simOperator.equals("46001")) {
                    b16 = 2;
                } else if (simOperator.equals("46003")) {
                    b16 = 3;
                }
                return Integer.valueOf(b16);
            }
        }
        b16 = b(str);
        return Integer.valueOf(b16);
    }

    public static void a(String str, d dVar) {
        synchronized (f107019h) {
            f107019h.put(str, dVar);
        }
    }

    static /* synthetic */ boolean a() {
        return n();
    }
}
