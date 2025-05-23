package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.ams.adcore.mma.api.Global;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public final class p2 extends BroadcastReceiver {

    /* renamed from: l, reason: collision with root package name */
    public static Handler f29926l;

    /* renamed from: m, reason: collision with root package name */
    public static final Comparator<ScanResult> f29927m = new c();

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f29928a;

    /* renamed from: b, reason: collision with root package name */
    public final n1 f29929b;

    /* renamed from: c, reason: collision with root package name */
    public final WifiManager f29930c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f29931d;

    /* renamed from: e, reason: collision with root package name */
    public long f29932e;

    /* renamed from: f, reason: collision with root package name */
    public HashSet<String> f29933f;

    /* renamed from: g, reason: collision with root package name */
    public List<ScanResult> f29934g;

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f29935h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f29936i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f29937j = false;

    /* renamed from: k, reason: collision with root package name */
    public w1 f29938k = new a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements w1 {
        public a() {
        }

        @Override // c.t.m.g.w1
        public void a(int i3) {
            k3.a("appStat", "status: " + i3);
            if (i3 == 1 && p2.this.f29937j && p2.this.f29928a) {
                try {
                    o3.a("backgroundloc", "back to foreground ,scan wifi again");
                    p2.this.e();
                } catch (Throwable th5) {
                    o3.a("TxWifiProvider", th5.toString());
                }
                p2.this.f29937j = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o1.b() == 1) {
                p2.this.f29937j = false;
                o3.a("backgroundloc", "TxWifiProvider scanwifi beacause app inter foreground");
                p2.this.e();
            } else {
                o3.a("backgroundloc", "TxWifiProvider scanwifi donot allow,beacause app inter background");
                p2.this.f29937j = true;
            }
            long r16 = p2.this.f29929b.a().r();
            p2.this.a(r16);
            o3.a("TxWifiProvider", "Interval:" + r16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class c implements Comparator<ScanResult> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    public p2(n1 n1Var) {
        this.f29929b = n1Var;
        this.f29930c = n1Var.f();
        n1Var.a().a(this.f29938k);
        this.f29933f = new HashSet<>();
        this.f29935h = new b();
    }

    public final void a(String str, List<ScanResult> list) {
    }

    public void d() {
        synchronized (this.f29936i) {
            if (!this.f29928a) {
                return;
            }
            this.f29928a = false;
            x3.f30105c = 0L;
            x3.f30104b = 0L;
            f29926l.removeCallbacksAndMessages(null);
            try {
                this.f29929b.f29875a.unregisterReceiver(this);
                o3.a("TxWifiProvider", "unregisterReceiver success");
                Log.i("TencentLocationSDK", "unregister system wifi provider,thread name:" + Thread.currentThread().getName());
            } catch (Exception unused) {
                o3.a("TxWifiProvider", "unregisterReceiver failed");
            }
            this.f29932e = 0L;
            this.f29933f = null;
            List<ScanResult> list = this.f29934g;
            if (list != null) {
                list.clear();
            }
            HashSet<String> hashSet = this.f29933f;
            if (hashSet != null) {
                hashSet.clear();
            }
            o3.b("TxWifiProvider", "shutdown: state=[shutdown]");
            k3.a(Global.TRACKING_WIFI, "stop");
        }
    }

    public final boolean e() {
        if (x3.c(this.f29929b) && !this.f29931d) {
            return x3.a(this.f29930c);
        }
        o3.a("TxWifiProvider", "no try scan ,return!!");
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Object valueOf;
        if (intent == null) {
            return;
        }
        try {
            synchronized (this.f29936i) {
                String action = intent.getAction();
                o3.b("TxWifiProvider", "onReceive " + action);
                if (o1.b() == 1) {
                    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                        b();
                    }
                    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) || "android.net.wifi.SCAN_RESULTS".equals(action)) {
                        List<ScanResult> a16 = x3.a(this.f29930c, "android.net.wifi.SCAN_RESULTS".equals(action));
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("ScanResult list is ");
                        if (a16 == null) {
                            valueOf = "null";
                        } else {
                            valueOf = Integer.valueOf(a16.size());
                        }
                        sb5.append(valueOf);
                        o3.b("TxWifiProvider", sb5.toString());
                        if (a16 != null && a16.size() > 0) {
                            ArrayList arrayList = new ArrayList(a16);
                            this.f29934g = arrayList;
                            a("before filter!", arrayList);
                            q2.a(this.f29934g);
                            a("after filter!", this.f29934g);
                            List<ScanResult> list = this.f29934g;
                            if (list != null && list.size() > 0) {
                                Collections.sort(this.f29934g, f29927m);
                                a();
                            }
                        } else {
                            o3.b("TxWifiProvider", "post empty wifiInfo");
                            b();
                            this.f29929b.a(x2.f30100c);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            o3.a("TxWifiProvider", e16.toString());
        }
    }

    public void a(boolean z16) {
    }

    public final void b() {
        int wifiState = this.f29930c.getWifiState();
        int i3 = 1;
        if (wifiState == 3) {
            a(0L);
        } else if (wifiState == 1) {
            List<ScanResult> list = this.f29934g;
            if (list != null) {
                list.clear();
            }
            this.f29929b.a(x2.f30100c);
            i3 = 0;
        } else {
            i3 = -1;
        }
        try {
            if (!this.f29929b.b().isProviderEnabled("network")) {
                if (!this.f29929b.b().isProviderEnabled("gps")) {
                    i3 = 5;
                }
            }
        } catch (Exception unused) {
        }
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12001;
        message.arg2 = i3;
        this.f29929b.a(message);
    }

    public int c() {
        return !e() ? 1 : 0;
    }

    public void a(Handler handler, boolean z16) {
        if (this.f29928a) {
            return;
        }
        this.f29928a = true;
        this.f29931d = z16;
        f29926l = handler;
        a(handler);
        if (!this.f29931d) {
            a(0L);
        }
        o3.b("TxWifiProvider", "startup: state=[start]");
        k3.a(Global.TRACKING_WIFI, "start");
    }

    public final void a(Handler handler) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        try {
            this.f29929b.f29875a.registerReceiver(this, intentFilter, null, handler);
        } catch (Exception e16) {
            o3.a("TxWifiProvider", "listenWifiState: failed", e16);
        }
    }

    public final void a(long j3) {
        o3.a("TxWifiProvider", "ScanInterval:" + j3);
        Handler handler = f29926l;
        Runnable runnable = this.f29935h;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, j3);
    }

    public final void a() {
        o3.a("TxWifiProvider", Thread.currentThread().getName());
        if (this.f29933f == null) {
            this.f29933f = new HashSet<>();
        }
        if (this.f29933f.size() == 0) {
            Iterator<ScanResult> it = this.f29934g.iterator();
            while (it.hasNext()) {
                this.f29933f.add(it.next().toString());
            }
            this.f29932e = System.currentTimeMillis();
            o3.a("TxWifiProvider", "first receiver");
            a(this.f29934g);
            return;
        }
        int size = this.f29933f.size();
        if (size != this.f29934g.size()) {
            this.f29933f.clear();
            for (ScanResult scanResult : this.f29934g) {
                this.f29933f.add(scanResult.BSSID + scanResult.level);
            }
            this.f29932e = System.currentTimeMillis();
            o3.a("TxWifiProvider", "size not same");
            a(this.f29934g);
            return;
        }
        for (ScanResult scanResult2 : this.f29934g) {
            this.f29933f.add(scanResult2.BSSID + scanResult2.level);
        }
        if (size != this.f29933f.size()) {
            this.f29933f.clear();
            for (ScanResult scanResult3 : this.f29934g) {
                this.f29933f.add(scanResult3.BSSID + scanResult3.level);
            }
            this.f29932e = System.currentTimeMillis();
            o3.a("TxWifiProvider", "size same,but mac is not same");
            a(this.f29934g);
            return;
        }
        o3.a("TxWifiProvider", "size same,mac and rssi same");
    }

    public final void a(List<ScanResult> list) {
        if (list != null && list.size() != 0) {
            if (x3.f30103a) {
                x3.f30103a = false;
                b();
            }
        } else {
            b();
        }
        this.f29929b.a(new x2(list, this.f29932e, this.f29930c.getWifiState()));
    }
}
