package com.tencent.luggage.wxa.nh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f135831a = false;

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference f135832b;

    /* renamed from: c, reason: collision with root package name */
    public static e f135833c;

    /* renamed from: d, reason: collision with root package name */
    public static c f135834d;

    /* renamed from: e, reason: collision with root package name */
    public static Context f135835e;

    /* renamed from: f, reason: collision with root package name */
    public static BroadcastReceiver f135836f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile d f135837g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            w.d("MicroMsg.WiFiManagerWrapper", "onReceive");
            if (intent != null && "android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                d dVar = g.f135837g;
                if (dVar == null) {
                    w.d("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
                    return;
                } else {
                    dVar.a(g.b(false));
                    return;
                }
            }
            w.f("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
        }
    }

    public static e b() {
        String str;
        WifiInfo b16 = com.tencent.luggage.wxa.oh.d.b();
        String str2 = "";
        if (b16 == null || TextUtils.isEmpty(NetworkMonitor.getSSID(b16))) {
            str = "";
        } else {
            String a16 = com.tencent.luggage.wxa.oh.e.a(NetworkMonitor.getSSID(b16));
            str = w0.b(NetworkMonitor.getBSSID(b16), "");
            str2 = a16;
        }
        e eVar = f135833c;
        if (eVar != null && str2.compareTo(eVar.f135822a) == 0 && str.compareTo(f135833c.f135823b) == 0) {
            return f135833c;
        }
        if (b16 == null) {
            return null;
        }
        w.d("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
        c();
        return f135833c;
    }

    public static f c() {
        return b(true);
    }

    public static void d() {
        w.d("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
        f135837g = null;
    }

    public static void a(Context context) {
        if (f135831a || context == null) {
            return;
        }
        f135835e = z.c();
        w.d("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
        if (f135836f == null) {
            f135836f = new b();
        }
        f135835e.registerReceiver(f135836f, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        WifiManager wifiManager = (WifiManager) f135835e.getSystemService("wifi");
        if (wifiManager != null) {
            com.tencent.luggage.wxa.oh.d.a(wifiManager);
            f135831a = true;
        }
    }

    public static void a(d dVar) {
        w.d("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
        f135833c = null;
        if (f135831a && com.tencent.luggage.wxa.oh.d.e()) {
            w.d("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
            com.tencent.luggage.wxa.oh.d.g();
            f135837g = dVar;
        } else {
            f fVar = new f();
            if (f135831a) {
                fVar.f135829a = "wifi is disable";
            } else {
                fVar.f135829a = "sdk not init";
            }
            dVar.a(fVar);
        }
    }

    public static f b(boolean z16) {
        String str;
        f fVar = new f();
        String str2 = null;
        f135833c = null;
        if (f135831a && com.tencent.luggage.wxa.oh.d.e()) {
            if (z16) {
                com.tencent.luggage.wxa.oh.d.g();
            }
            List<ScanResult> c16 = com.tencent.luggage.wxa.oh.d.c();
            fVar.f135830b = new ArrayList();
            fVar.f135829a = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            if (c16 != null) {
                w.a("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", c16, Integer.valueOf(c16.size()));
                WifiInfo b16 = com.tencent.luggage.wxa.oh.d.b();
                w.a("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", b16);
                if (b16 == null || TextUtils.isEmpty(NetworkMonitor.getSSID(b16))) {
                    str = null;
                } else {
                    str2 = com.tencent.luggage.wxa.oh.e.a(NetworkMonitor.getSSID(b16));
                    str = w0.b(NetworkMonitor.getBSSID(b16), "");
                }
                for (ScanResult scanResult : c16) {
                    if (scanResult != null) {
                        int a16 = com.tencent.luggage.wxa.oh.e.a(scanResult);
                        e eVar = new e();
                        eVar.f135822a = com.tencent.luggage.wxa.oh.e.a(scanResult.SSID);
                        eVar.f135823b = w0.b(scanResult.BSSID, "");
                        eVar.f135824c = Integer.valueOf(com.tencent.luggage.wxa.oh.d.a(scanResult.level, 100));
                        eVar.f135825d = Boolean.valueOf(a16 == 2);
                        eVar.f135826e = Integer.valueOf(scanResult.frequency);
                        if (str2 != null && str != null && eVar.f135822a.compareTo(str2) == 0 && eVar.f135823b.compareTo(str) == 0) {
                            f135833c = eVar;
                        }
                        if (a16 == 0 || a16 == 2) {
                            fVar.f135830b.add(eVar);
                        }
                    }
                }
                w.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] mCurrentWiFi: " + f135833c);
            } else {
                w.b("MicroMsg.WiFiManagerWrapper", "wifiList is null");
            }
        } else if (f135831a) {
            fVar.f135829a = "wifi is disable";
        } else {
            fVar.f135829a = "sdk not init";
        }
        return fVar;
    }

    public static void a(String str, String str2, String str3, long j3, boolean z16) {
        com.tencent.luggage.wxa.oh.a aVar;
        WeakReference weakReference = f135832b;
        if (weakReference != null && (aVar = (com.tencent.luggage.wxa.oh.a) weakReference.get()) != null && !aVar.a()) {
            aVar.a("duplicated request");
        }
        com.tencent.luggage.wxa.oh.a aVar2 = new com.tencent.luggage.wxa.oh.a(f135834d, f135835e, z16);
        aVar2.a(str, str2, str3, j3);
        f135832b = new WeakReference(aVar2);
    }

    public static void a(c cVar) {
        f135834d = cVar;
    }
}
