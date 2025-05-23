package com.tencent.luggage.wxa.nh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f135814a = false;

    /* renamed from: b, reason: collision with root package name */
    public static C6514a f135815b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.nh.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6514a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public final ConnectivityManager.NetworkCallback f135816a;

        /* renamed from: b, reason: collision with root package name */
        public final List f135817b = new CopyOnWriteArrayList();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.nh.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6515a extends ConnectivityManager.NetworkCallback {
            public C6515a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                w.d("MicroMsg.AppBrand.ConnectWifiEvents", "onAvailable");
                ConnectivityManager connectivityManager = (ConnectivityManager) z.c().getSystemService("connectivity");
                if (connectivityManager == null) {
                    w.f("MicroMsg.AppBrand.ConnectWifiEvents", "onAvailable, connectivityManager is null");
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    C6514a.this.a(activeNetworkInfo);
                } else {
                    w.f("MicroMsg.AppBrand.ConnectWifiEvents", "onAvailable, networkInfo is null");
                }
            }
        }

        public C6514a() {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f135816a = new C6515a();
            } else {
                this.f135816a = null;
            }
        }

        public void b(Context context) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.setPriority(Integer.MAX_VALUE);
            context.registerReceiver(this, intentFilter);
            if (Build.VERSION.SDK_INT >= 24) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    w.f("MicroMsg.AppBrand.ConnectWifiEvents", "enable, connectivityManager is null");
                    return;
                }
                try {
                    connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().removeCapability(14).build(), this.f135816a);
                } catch (Exception e16) {
                    w.a("MicroMsg.AppBrand.ConnectWifiEvents", e16, "registerNetworkCallback failure", new Object[0]);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Parcelable parcelableExtra;
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            w.d("MicroMsg.AppBrand.ConnectWifiEvents", "actiong:%s", action);
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("wifi_state", 0);
                w.d("MicroMsg.AppBrand.ConnectWifiEvents", "wifiState" + intExtra);
                if (intExtra == 1) {
                    a();
                }
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action) && (parcelableExtra = intent.getParcelableExtra("networkInfo")) != null) {
                a((NetworkInfo) parcelableExtra);
            }
        }

        public void a(Context context) {
            try {
                context.unregisterReceiver(this);
            } catch (IllegalArgumentException unused) {
            }
            if (Build.VERSION.SDK_INT >= 24) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    w.f("MicroMsg.AppBrand.ConnectWifiEvents", "disable, connectivityManager is null");
                    return;
                }
                try {
                    connectivityManager.unregisterNetworkCallback(this.f135816a);
                } catch (Exception e16) {
                    w.a("MicroMsg.AppBrand.ConnectWifiEvents", e16, "unregisterNetworkCallback failure", new Object[0]);
                }
            }
        }

        public void a(b bVar) {
            this.f135817b.add(bVar);
        }

        public final void a(e eVar) {
            Iterator it = this.f135817b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(eVar);
            }
        }

        public final void a() {
            Iterator it = this.f135817b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a();
            }
        }

        public final void a(NetworkInfo networkInfo) {
            boolean z16 = networkInfo.getState() == NetworkInfo.State.CONNECTED;
            boolean z17 = NetworkMonitor.getType(networkInfo) == 1;
            if (z16 && z17) {
                e b16 = com.tencent.luggage.wxa.nh.b.f135819a.b();
                w.d("MicroMsg.AppBrand.ConnectWifiEvents", "[mWiFiEventReceiver]currentWifi:%s", b16);
                if (b16 == null) {
                    return;
                }
                a(b16);
                b(b16);
                return;
            }
            a();
        }

        public void b(b bVar) {
            this.f135817b.remove(bVar);
        }

        public final void b(e eVar) {
            Iterator it = this.f135817b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(eVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void a(e eVar);

        void b(e eVar);
    }

    public static void a(Context context) {
        w.d("MicroMsg.AppBrand.ConnectWifiEvents", "disable");
        if (!f135814a) {
            w.d("MicroMsg.AppBrand.ConnectWifiEvents", "disable, not enable");
            return;
        }
        Context a16 = com.tencent.luggage.wxa.ye.c.a(context);
        if (a16 == null) {
            return;
        }
        f135814a = false;
        C6514a c6514a = f135815b;
        if (c6514a != null) {
            c6514a.a(a16);
            f135815b = null;
        } else {
            w.f("MicroMsg.AppBrand.ConnectWifiEvents", "enable, receiver is null");
        }
    }

    public static void b(Context context) {
        w.d("MicroMsg.AppBrand.ConnectWifiEvents", "enable");
        if (f135814a) {
            w.d("MicroMsg.AppBrand.ConnectWifiEvents", "enable, already enabled");
            return;
        }
        Context a16 = com.tencent.luggage.wxa.ye.c.a(context);
        if (a16 == null) {
            return;
        }
        f135814a = true;
        if (f135815b == null) {
            C6514a c6514a = new C6514a();
            f135815b = c6514a;
            c6514a.b(a16);
            return;
        }
        w.f("MicroMsg.AppBrand.ConnectWifiEvents", "enable, receiver is not null");
    }

    public static void a(b bVar) {
        w.d("MicroMsg.AppBrand.ConnectWifiEvents", "addListener");
        C6514a c6514a = f135815b;
        if (c6514a != null) {
            c6514a.a(bVar);
        } else {
            w.f("MicroMsg.AppBrand.ConnectWifiEvents", "addListener, receiver is null");
        }
    }

    public static void b(b bVar) {
        w.d("MicroMsg.AppBrand.ConnectWifiEvents", "removeListener");
        C6514a c6514a = f135815b;
        if (c6514a != null) {
            c6514a.b(bVar);
        } else {
            w.f("MicroMsg.AppBrand.ConnectWifiEvents", "removeListener, receiver is null");
        }
    }
}
