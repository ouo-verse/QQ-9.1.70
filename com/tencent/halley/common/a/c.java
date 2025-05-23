package com.tencent.halley.common.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
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
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f113241a;

    /* renamed from: b, reason: collision with root package name */
    public static String f113242b;

    /* renamed from: c, reason: collision with root package name */
    public static String f113243c;

    /* renamed from: d, reason: collision with root package name */
    public static String f113244d;

    /* renamed from: e, reason: collision with root package name */
    public static String f113245e;

    /* renamed from: f, reason: collision with root package name */
    public static String f113246f;

    /* renamed from: g, reason: collision with root package name */
    private static volatile byte f113247g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f113248h;

    /* renamed from: i, reason: collision with root package name */
    private static String f113249i;

    /* renamed from: j, reason: collision with root package name */
    private static String f113250j;

    /* renamed from: k, reason: collision with root package name */
    private static volatile int f113251k;

    /* renamed from: l, reason: collision with root package name */
    private static volatile int f113252l;

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, e> f113253m;

    /* renamed from: n, reason: collision with root package name */
    private static BroadcastReceiver f113254n;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f113241a = false;
        f113242b = "";
        f113243c = "cmwap";
        f113244d = "3gwap";
        f113245e = "uniwap";
        f113246f = "ctwap";
        f113247g = (byte) 0;
        f113248h = true;
        f113249i = "";
        f113250j = "unknown";
        f113251k = 0;
        f113252l = -1;
        f113253m = new ConcurrentHashMap();
        f113254n = new BroadcastReceiver() { // from class: com.tencent.halley.common.a.c.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                } else {
                    com.tencent.halley.common.a.h().post(new Runnable() { // from class: com.tencent.halley.common.a.c.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                c.e();
                                if (com.tencent.halley.common.utils.f.f113549c) {
                                    com.tencent.halley.common.a.a();
                                    com.tencent.halley.common.utils.f.a();
                                }
                                if (c.o()) {
                                    com.tencent.halley.common.a.h().postDelayed(new Runnable() { // from class: com.tencent.halley.common.a.c.1.1.1
                                        static IPatchRedirector $redirector_;

                                        {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RunnableC12371.this);
                                            }
                                        }

                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            IPatchRedirector iPatchRedirector3 = $redirector_;
                                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                                return;
                                            }
                                            try {
                                                com.tencent.halley.common.utils.d.b("ApnInfo", "delay call update ip type..");
                                                c.o();
                                            } catch (Throwable unused) {
                                            }
                                        }
                                    }, 2000L);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            }
        };
    }

    public static void a() {
        try {
            p();
            e();
            com.tencent.halley.common.a.a().registerReceiver(f113254n, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable unused) {
        }
    }

    private static byte b(String str) {
        try {
            NetworkInterface byName = NetworkInterface.getByName(str);
            if (!byName.isUp()) {
                com.tencent.halley.common.utils.d.b("ApnInfo", "networkInterface is down just pass it..");
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
                    if (com.tencent.halley.common.utils.e.b(hostAddress)) {
                        z16 = true;
                    } else if (!z17 && com.tencent.halley.common.utils.e.c(hostAddress) && com.tencent.halley.common.utils.e.a(hostAddress)) {
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
            e16.printStackTrace();
            return (byte) 0;
        }
    }

    public static String c() {
        int i3 = f113251k;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "";
                    }
                    return QADNetStatus.G_4;
                }
                return QADNetStatus.G_3;
            }
            return QADNetStatus.G_2;
        }
        return "wifi";
    }

    public static String d() {
        int i3 = f113251k;
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3 && i3 != 4) {
                return "null";
            }
            return f113249i;
        }
        return "wifi";
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d6 A[Catch: all -> 0x0148, TryCatch #3 {all -> 0x0148, blocks: (B:6:0x0005, B:8:0x0019, B:10:0x001f, B:12:0x0025, B:14:0x002e, B:16:0x0038, B:43:0x007d, B:45:0x0083, B:48:0x008b, B:59:0x00c0, B:60:0x00c9, B:62:0x00d6, B:65:0x00e3, B:66:0x00e6, B:69:0x00f4, B:72:0x0102, B:76:0x00c4, B:77:0x00c7, B:78:0x0114), top: B:5:0x0005, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void e() {
        boolean contains;
        String str;
        synchronized (c.class) {
            int i3 = f113251k;
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.tencent.halley.common.a.a().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    f113248h = true;
                    int type = NetworkMonitor.getType(activeNetworkInfo);
                    if (type == 1) {
                        f113251k = 1;
                        f113252l = 0;
                        f113241a = false;
                        if (i3 != f113251k) {
                            LocationMonitor.getConnectionInfo((WifiManager) com.tencent.halley.common.a.a().getApplicationContext().getSystemService("wifi"));
                            String str2 = f113250j;
                            f113250j = "ssid_fakewifiaa:bb:cc:dd:ee:ff";
                            com.tencent.halley.common.utils.d.c("ApnInfo", "updateApn, lastApnName= " + str2 + ", S_DB_APN_NAME= " + f113250j, new Throwable("forDebugOnly"));
                        }
                    } else {
                        String netGetExInfo = NetworkMonitor.netGetExInfo(activeNetworkInfo);
                        if (netGetExInfo != null && type == 0) {
                            f113249i = netGetExInfo.trim().toLowerCase();
                            f113250j = "apn_" + f113249i;
                            int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
                            f113252l = subtype;
                            if (subtype != 1 && subtype != 2 && subtype != 4) {
                                if (subtype != 13 && subtype != 19) {
                                    f113251k = 3;
                                    contains = f113249i.contains("wap");
                                    f113241a = contains;
                                    if (contains) {
                                        if (f113249i.contains(f113244d)) {
                                            str = "10.0.0.172";
                                        } else if (f113249i.contains(f113243c)) {
                                            str = "10.0.0.172";
                                        } else if (f113249i.contains(f113245e)) {
                                            str = "10.0.0.172";
                                        } else if (f113249i.contains(f113246f)) {
                                            str = "10.0.0.200";
                                        } else {
                                            str = "";
                                        }
                                        f113242b = str;
                                    }
                                }
                                f113251k = 4;
                                contains = f113249i.contains("wap");
                                f113241a = contains;
                                if (contains) {
                                }
                            }
                            f113251k = 2;
                            contains = f113249i.contains("wap");
                            f113241a = contains;
                            if (contains) {
                            }
                        }
                        q();
                    }
                } else {
                    q();
                    f113248h = false;
                    f113247g = (byte) 0;
                }
                if (i3 != f113251k) {
                    synchronized (f113253m) {
                        for (e eVar : f113253m.values()) {
                            if (eVar != null) {
                                eVar.a(f113251k, f113250j);
                            }
                        }
                    }
                }
            } catch (Throwable th5) {
                try {
                    th5.printStackTrace();
                    if (i3 != f113251k) {
                        synchronized (f113253m) {
                            for (e eVar2 : f113253m.values()) {
                                if (eVar2 != null) {
                                    eVar2.a(f113251k, f113250j);
                                }
                            }
                        }
                    }
                } catch (Throwable th6) {
                    if (i3 != f113251k) {
                        synchronized (f113253m) {
                            for (e eVar3 : f113253m.values()) {
                                if (eVar3 != null) {
                                    eVar3.a(f113251k, f113250j);
                                }
                            }
                        }
                    }
                    throw th6;
                }
            }
        }
    }

    public static String f() {
        if (f113252l == -1) {
            return "unknown";
        }
        switch (f113252l) {
            case 0:
                return "wifi";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO_0";
            case 6:
                return "EVDO_A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "EVDO_B";
            case 13:
                return "LTE";
            case 14:
                return "EHRPD";
            case 15:
                return "HSPAP";
            default:
                return "unknown";
        }
    }

    public static boolean g() {
        if (f113251k != 2 && f113251k != 3 && f113251k != 4) {
            return false;
        }
        return true;
    }

    public static int h() {
        return f113251k;
    }

    public static byte i() {
        return f113247g;
    }

    public static boolean j() {
        return f113248h;
    }

    public static boolean k() {
        return f113241a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        if (r0.equals("46003") != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a8, code lost:
    
        if (r0.contains("ctwap") == false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Integer l() {
        Integer num;
        e();
        int i3 = 0;
        if (g()) {
            Context a16 = com.tencent.halley.common.a.a();
            String str = f113249i;
            TelephonyManager telephonyManager = (TelephonyManager) a16.getSystemService("phone");
            if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                String simOperator = DeviceInfoMonitor.getSimOperator(telephonyManager);
                if (simOperator.length() > 0) {
                    if (!simOperator.equals("46000") && !simOperator.equals("46002")) {
                        if (!simOperator.equals("46001")) {
                        }
                        num = 2;
                        i3 = num.intValue();
                    }
                    num = 1;
                    i3 = num.intValue();
                }
            }
            if (str != null) {
                String lowerCase = str.toLowerCase();
                if (!lowerCase.contains("cmnet") && !lowerCase.contains("cmwap")) {
                    if (!lowerCase.contains("uninet") && !lowerCase.contains("uniwap") && !lowerCase.contains("3gnet") && !lowerCase.contains("3gwap")) {
                        if (!lowerCase.contains("ctnet")) {
                        }
                        num = 3;
                        i3 = num.intValue();
                    }
                    num = 2;
                    i3 = num.intValue();
                }
                num = 1;
                i3 = num.intValue();
            }
            num = 0;
            i3 = num.intValue();
        }
        return Integer.valueOf(i3);
    }

    public static Proxy m() {
        if (f113241a && !TextUtils.isEmpty(f113242b)) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(f113242b, 80));
        }
        return null;
    }

    public static boolean n() {
        try {
            PowerManager powerManager = (PowerManager) com.tencent.halley.common.a.a().getSystemService("power");
            if (powerManager != null) {
                return ((Boolean) PowerManager.class.getDeclaredMethod(com.tencent.mobileqq.msf.core.c0.j.K0, new Class[0]).invoke(powerManager, new Object[0])).booleanValue();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return false;
    }

    static /* synthetic */ boolean o() {
        return p();
    }

    private static boolean p() {
        ConnectivityManager connectivityManager = (ConnectivityManager) com.tencent.halley.common.a.a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            com.tencent.halley.common.utils.d.b("ApnInfo", "ready to obtain iptype");
            try {
                LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
                if (linkProperties == null) {
                    com.tencent.halley.common.utils.d.b("ApnInfo", "activeLinkProperties is null");
                    f113247g = (byte) 0;
                } else {
                    f113247g = b(linkProperties.getInterfaceName());
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                f113247g = (byte) 0;
            }
            com.tencent.halley.common.utils.d.b("ApnInfo", "IPType is:" + ((int) f113247g));
            return true;
        }
        f113247g = (byte) 0;
        com.tencent.halley.common.utils.d.b("ApnInfo", "not obtain ip type");
        return false;
    }

    private static void q() {
        f113249i = "unknown";
        f113251k = 0;
        f113252l = -1;
        f113250j = "unknown";
        f113241a = false;
    }

    public static void a(String str) {
        synchronized (f113253m) {
            f113253m.remove(str);
        }
    }

    public static String b() {
        return f113250j;
    }

    public static void a(String str, e eVar) {
        synchronized (f113253m) {
            f113253m.put(str, eVar);
        }
    }
}
