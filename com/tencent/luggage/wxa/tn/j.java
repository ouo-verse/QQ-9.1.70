package com.tencent.luggage.wxa.tn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {

    /* renamed from: b, reason: collision with root package name */
    public static e f141600b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f141601c;

    /* renamed from: d, reason: collision with root package name */
    public static d f141602d;

    /* renamed from: f, reason: collision with root package name */
    public static final Lazy f141604f;

    /* renamed from: a, reason: collision with root package name */
    public static final a f141599a = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final c f141603e = new c();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.tn.j$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public interface InterfaceC6769a {
            void onSignalStrengthsChanged(SignalStrength signalStrength);
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends PhoneStateListener {

            /* renamed from: a, reason: collision with root package name */
            public InterfaceC6769a f141605a;

            public final void a(InterfaceC6769a interfaceC6769a) {
                this.f141605a = interfaceC6769a;
            }

            @Override // android.telephony.PhoneStateListener
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                Intrinsics.checkNotNullParameter(signalStrength, "signalStrength");
                super.onSignalStrengthsChanged(signalStrength);
                InterfaceC6769a interfaceC6769a = this.f141605a;
                if (interfaceC6769a != null) {
                    interfaceC6769a.onSignalStrengthsChanged(signalStrength);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends TelephonyCallback implements TelephonyCallback.SignalStrengthsListener {

            /* renamed from: a, reason: collision with root package name */
            public InterfaceC6769a f141606a;

            public final void a(InterfaceC6769a interfaceC6769a) {
                this.f141606a = interfaceC6769a;
            }

            @Override // android.telephony.TelephonyCallback.SignalStrengthsListener
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                Intrinsics.checkNotNullParameter(signalStrength, "signalStrength");
                InterfaceC6769a interfaceC6769a = this.f141606a;
                if (interfaceC6769a != null) {
                    interfaceC6769a.onSignalStrengthsChanged(signalStrength);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d implements InterfaceC6769a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f141607a;

            public d(int i3) {
                this.f141607a = i3;
            }

            @Override // com.tencent.luggage.wxa.tn.j.a.InterfaceC6769a
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                Intrinsics.checkNotNullParameter(signalStrength, "signalStrength");
                j.f141603e.c(this.f141607a);
                int c16 = j.f141603e.c();
                if (c16 != 1) {
                    if (c16 == 2) {
                        j.f141603e.a(signalStrength.getCdmaDbm());
                        return;
                    }
                    return;
                }
                j.f141603e.b(signalStrength.getGsmSignalStrength());
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final /* synthetic */ f b(a aVar) {
            aVar.e();
            return null;
        }

        public final b c() {
            return (b) j.f141604f.getValue();
        }

        public final c d() {
            return j.f141603e;
        }

        public final f e() {
            if (com.tencent.luggage.wxa.eo.g.b(f.class)) {
                com.tencent.luggage.wxa.k0.d.a(com.tencent.luggage.wxa.eo.g.a(f.class));
            }
            return null;
        }

        public final int f() {
            return a(this, false, 1, null);
        }

        public final int g() {
            return b(this, false, 1, null);
        }

        public final void h() {
            if (!j.f141601c) {
                j.f141601c = true;
                Object systemService = z.c().getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                d dVar = new d(telephonyManager.getPhoneType());
                if (com.tencent.luggage.wxa.aa.a.a(31)) {
                    c().a(dVar);
                    LocationMonitor.listen(telephonyManager, c(), 256);
                } else {
                    c cVar = new c();
                    cVar.a(dVar);
                    telephonyManager.registerTelephonyCallback(ProxyExecutors.newSingleThreadExecutor(), cVar);
                }
            }
        }

        public final void i() {
            if (Build.VERSION.SDK_INT >= 24 && j.f141602d == null) {
                j.f141602d = new d();
                Object systemService = z.c().getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
                try {
                    NetworkRequest build = new NetworkRequest.Builder().removeCapability(14).build();
                    d dVar = j.f141602d;
                    Intrinsics.checkNotNull(dVar);
                    connectivityManager.registerNetworkCallback(build, dVar);
                } catch (Exception e16) {
                    w.b("MicroMsg.ConnectivityCompat", "registerNetworkCallback fail: " + e16);
                }
            }
            if (j.f141600b == null) {
                j.f141600b = new e();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
                intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
                if (Build.VERSION.SDK_INT < 24) {
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                }
                z.c().registerReceiver(j.f141600b, intentFilter);
            } else {
                w.f("MicroMsg.ConnectivityCompat", "connectivity compat receiver has been registered, check " + d0.a());
            }
            g a16 = a();
            w.d("MicroMsg.ConnectivityCompat", "initialized new wifi info");
            a16.g();
        }

        public static /* synthetic */ int b(a aVar, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            return aVar.b(z16);
        }

        public static /* synthetic */ int a(a aVar, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            return aVar.a(z16);
        }

        public final int b(boolean z16) {
            int i3 = f0.e("connectivity_compat").getInt("connectivity_compat_key_wifi_rssi", 0);
            if (!z16) {
                e();
                return i3 == 0 ? a().d() : i3;
            }
            int d16 = a().d();
            e();
            return z16 ? d16 : i3;
        }

        public final int a(boolean z16) {
            int i3 = f0.e("connectivity_compat").getInt("connectivity_compat_key_wifi_idaddr", 0);
            if (!z16) {
                e();
                return i3 == 0 ? a().b() : i3;
            }
            int b16 = a().b();
            e();
            return z16 ? b16 : i3;
        }

        public final void b() {
            f0.e("connectivity_compat").putLong("wifi_info_update_timestamp", System.currentTimeMillis());
        }

        public final String a(int i3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3 & 255);
            sb5.append('.');
            sb5.append((i3 >> 8) & 255);
            sb5.append('.');
            sb5.append((i3 >> 16) & 255);
            sb5.append('.');
            sb5.append((i3 >> 24) & 255);
            return sb5.toString();
        }

        public final g b(Context context, WifiManager wifiManager) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                w.b("MicroMsg.ConnectivityCompat", "acquireWiFiInfo29(): access_fine_location perm not granted.");
                return new g(null);
            }
            return a(context, wifiManager);
        }

        public final g a(Context context, WifiManager wifiManager) {
            WifiInfo wifiInfo;
            try {
                if ((context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) && (wifiInfo = (WifiInfo) com.tencent.luggage.wxa.ia.a.a(wifiManager, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo27", "(Landroid/content/Context;Landroid/net/wifi/WifiManager;)Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;")) != null) {
                    return new g(wifiInfo);
                }
            } catch (Throwable th5) {
                w.a("MicroMsg.ConnectivityCompat", th5, "get wifi info failed directly", new Object[0]);
            }
            try {
                List list = (List) com.tencent.luggage.wxa.ia.a.a(wifiManager, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo27", "(Landroid/content/Context;Landroid/net/wifi/WifiManager;)Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConfiguredNetworks", "()Ljava/util/List;");
                Intrinsics.checkNotNullExpressionValue(list, "wm.getConfiguredNetworks()");
                WifiInfo wifiInfo2 = (WifiInfo) com.tencent.luggage.wxa.ia.a.a(wifiManager, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo27", "(Landroid/content/Context;Landroid/net/wifi/WifiManager;)Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((WifiConfiguration) it.next()).networkId == wifiInfo2.getNetworkId()) {
                        return new g(wifiInfo2);
                    }
                }
            } catch (Throwable th6) {
                w.a("MicroMsg.ConnectivityCompat", th6, "get wifi info failed from configurations", new Object[0]);
            }
            return new g(null);
        }

        public final g a() {
            Context gContext = z.c();
            Object systemService = z.c().getApplicationContext().getSystemService("wifi");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            if (((WifiManager) systemService).getWifiState() != 3) {
                w.d("MicroMsg.ConnectivityCompat", "not wifi currently, return empty wifi info");
                return new g(null);
            }
            Object systemService2 = gContext.getApplicationContext().getSystemService("wifi");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService2;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29) {
                Intrinsics.checkNotNullExpressionValue(gContext, "gContext");
                return b(gContext, wifiManager);
            }
            if (i3 >= 27) {
                Intrinsics.checkNotNullExpressionValue(gContext, "gContext");
                return a(gContext, wifiManager);
            }
            WifiInfo wifiInfo = (WifiInfo) com.tencent.luggage.wxa.ia.a.a(wifiManager, "com/tencent/mm/sdk/platformtools/ConnectivityCompat$Companion", "acquireWiFiInfo", "()Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiInfo;", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
            if (wifiInfo != null) {
                return new g(wifiInfo);
            }
            return new g(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f141608a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a.b invoke() {
            return new a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public int f141609a;

        /* renamed from: b, reason: collision with root package name */
        public int f141610b = 99;

        /* renamed from: c, reason: collision with root package name */
        public int f141611c;

        public final int a() {
            return this.f141611c;
        }

        public final int b() {
            return this.f141610b;
        }

        public final int c() {
            return this.f141609a;
        }

        public final boolean d() {
            if (this.f141609a == 1) {
                return true;
            }
            return false;
        }

        public final void a(int i3) {
            this.f141611c = i3;
        }

        public final void b(int i3) {
            this.f141610b = i3;
        }

        public final void c(int i3) {
            this.f141609a = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            w.d("MicroMsg.ConnectivityCompat", "network available (from network callback)");
            a aVar = j.f141599a;
            aVar.b();
            g a16 = aVar.a();
            w.d("MicroMsg.ConnectivityCompat", "updated new wifi info (api >= 24)");
            a16.g();
            a.b(aVar);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            w.d("MicroMsg.ConnectivityCompat", "network lost (from network callback)");
            j.f141599a.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1172645946) {
                    if (hashCode != -385684331) {
                        if (hashCode == 1878357501 && str.equals("android.net.wifi.SCAN_RESULTS")) {
                            w.d("MicroMsg.ConnectivityCompat", "scan results available, invalid last get time");
                            f0.e("connectivity_compat").putInt("connectivity_compat_key_wifi_last_get_time", 0);
                            f0.e("connectivity_compat").putLong("wifi_scan_result_update_timestamp", System.currentTimeMillis());
                            return;
                        }
                        return;
                    }
                    if (str.equals("android.net.wifi.RSSI_CHANGED")) {
                        int intExtra = intent.getIntExtra("newRssi", 0);
                        w.d("MicroMsg.ConnectivityCompat", "new rssi available, rssi: " + intExtra);
                        f0.e("connectivity_compat").putInt("connectivity_compat_key_wifi_rssi", intExtra);
                        return;
                    }
                    return;
                }
                if (str.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    w.d("MicroMsg.ConnectivityCompat", "connectivity action updated");
                    a aVar = j.f141599a;
                    aVar.b();
                    g a16 = aVar.a();
                    w.d("MicroMsg.ConnectivityCompat", "updated new wifi info (api < 24)");
                    a16.g();
                    a.b(aVar);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f extends com.tencent.luggage.wxa.eo.c {
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g {

        /* renamed from: g, reason: collision with root package name */
        public static final a f141612g = new a(null);

        /* renamed from: h, reason: collision with root package name */
        public static WifiInfo f141613h;

        /* renamed from: a, reason: collision with root package name */
        public final WifiInfo f141614a;

        /* renamed from: b, reason: collision with root package name */
        public final Lazy f141615b;

        /* renamed from: c, reason: collision with root package name */
        public final Lazy f141616c;

        /* renamed from: d, reason: collision with root package name */
        public final Lazy f141617d;

        /* renamed from: e, reason: collision with root package name */
        public final Lazy f141618e;

        /* renamed from: f, reason: collision with root package name */
        public final Lazy f141619f;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b extends Lambda implements Function0 {
            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                String str;
                WifiInfo f16 = g.this.f();
                if (f16 != null) {
                    str = NetworkMonitor.getBSSID(f16);
                } else {
                    str = null;
                }
                if (str == null) {
                    str = GlobalUtil.DEFAULT_MAC_ADDRESS;
                }
                w.d("MicroMsg.ConnectivityCompat", "getBssid:" + str);
                return str;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c extends Lambda implements Function0 {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                int i3;
                WifiInfo f16 = g.this.f();
                if (f16 != null) {
                    i3 = NetworkMonitor.getIpAddress(f16);
                } else {
                    i3 = 0;
                }
                return Integer.valueOf(i3);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d extends Lambda implements Function0 {
            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                int i3;
                WifiInfo f16 = g.this.f();
                if (f16 != null) {
                    i3 = f16.getNetworkId();
                } else {
                    i3 = 0;
                }
                return Integer.valueOf(i3);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class e extends Lambda implements Function0 {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                int i3;
                WifiInfo f16 = g.this.f();
                if (f16 != null) {
                    i3 = f16.getRssi();
                } else {
                    i3 = 0;
                }
                Integer valueOf = Integer.valueOf(i3);
                w.d("MicroMsg.ConnectivityCompat", "getRssi " + valueOf.intValue());
                return valueOf;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class f extends Lambda implements Function0 {
            public f() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String invoke() {
                String str;
                WifiInfo f16 = g.this.f();
                if (f16 != null) {
                    str = NetworkMonitor.getSSID(f16);
                } else {
                    str = null;
                }
                if (str == null) {
                    str = BaseConstants.UNKNOWN_SSID_STRING;
                }
                w.d("MicroMsg.ConnectivityCompat", "getSsid " + str);
                return str;
            }
        }

        public g(WifiInfo wifiInfo) {
            Lazy lazy;
            Lazy lazy2;
            Lazy lazy3;
            Lazy lazy4;
            Lazy lazy5;
            this.f141614a = wifiInfo;
            lazy = LazyKt__LazyJVMKt.lazy(new e());
            this.f141615b = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new b());
            this.f141616c = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new f());
            this.f141617d = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new d());
            this.f141618e = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new c());
            this.f141619f = lazy5;
        }

        public final String a() {
            return (String) this.f141616c.getValue();
        }

        public final int b() {
            return ((Number) this.f141619f.getValue()).intValue();
        }

        public final int c() {
            return ((Number) this.f141618e.getValue()).intValue();
        }

        public final int d() {
            return ((Number) this.f141615b.getValue()).intValue();
        }

        public final String e() {
            return (String) this.f141617d.getValue();
        }

        public final WifiInfo f() {
            return this.f141614a;
        }

        public final void g() {
            boolean z16;
            WifiInfo wifiInfo = f141613h;
            if (wifiInfo != null) {
                if (!wifiInfo.equals(this.f141614a)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return;
                }
            }
            f0.e("connectivity_compat").putInt("connectivity_compat_key_wifi_rssi", d());
            f0.e("connectivity_compat").putString("connectivity_compat_key_wifi_ssid", e());
            f0.e("connectivity_compat").putString("connectivity_compat_key_wifi_bssid", a());
            f0.e("connectivity_compat").putInt("connectivity_compat_key_wifi_networkid", c());
            f0.e("connectivity_compat").putInt("connectivity_compat_key_wifi_idaddr", b());
            f141613h = this.f141614a;
            w.d("MicroMsg.ConnectivityCompat", "saveMMKV:" + this.f141614a);
        }

        public String toString() {
            String format = String.format("rssi(%d), bssid(%s), ssid(%s), networkId(%d), ipaddr(%s)", Arrays.copyOf(new Object[]{Integer.valueOf(d()), a(), e(), Integer.valueOf(c()), j.f141599a.a(b())}, 5));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return format;
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(b.f141608a);
        f141604f = lazy;
    }
}
