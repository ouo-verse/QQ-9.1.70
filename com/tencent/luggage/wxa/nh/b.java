package com.tencent.luggage.wxa.nh;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f135820b;

    /* renamed from: a, reason: collision with root package name */
    public static final b f135819a = new b();

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f135821c = true;

    public final boolean a() {
        return f135820b;
    }

    public final e b() {
        return a(this, false, 1, null);
    }

    public final e c() {
        WifiInfo b16 = com.tencent.luggage.wxa.oh.d.b();
        if (b16 != null) {
            w.d("MicroMsg.AppBrand.GetCurrentWiFiLogic", "getIncompleteWiFiItem, wifiInfo.ssid: " + NetworkMonitor.getSSID(b16) + ", wifiInfo.bssid: " + NetworkMonitor.getBSSID(b16));
            e eVar = new e();
            eVar.f135822a = com.tencent.luggage.wxa.oh.e.a(NetworkMonitor.getSSID(b16));
            eVar.f135823b = NetworkMonitor.getBSSID(b16);
            f135819a.a(eVar, b16);
            return eVar;
        }
        return null;
    }

    public static /* synthetic */ e a(b bVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = f135820b;
        }
        return bVar.a(z16);
    }

    public final e a(boolean z16) {
        boolean z17 = f135821c;
        w.d("MicroMsg.AppBrand.GetCurrentWiFiLogic", "get, preventScanWifi: " + z17 + ", acceptIncompleteWiFiItem: " + z16);
        if (z17) {
            return c();
        }
        e b16 = g.b();
        if (b16 != null) {
            return b16;
        }
        if (z16) {
            return c();
        }
        return null;
    }

    public final void a(e eVar, WifiInfo wifiInfo) {
        if (wifiInfo == null) {
            wifiInfo = com.tencent.luggage.wxa.oh.d.b();
        }
        if (wifiInfo != null && Intrinsics.areEqual(eVar.f135823b, NetworkMonitor.getBSSID(wifiInfo))) {
            w.d("MicroMsg.AppBrand.GetCurrentWiFiLogic", "fillBestEffort, connectionInfo got");
            eVar.f135824c = Integer.valueOf(com.tencent.luggage.wxa.oh.d.a(wifiInfo.getRssi(), 100));
            eVar.f135826e = Integer.valueOf(wifiInfo.getFrequency());
        }
        WifiConfiguration b16 = com.tencent.luggage.wxa.oh.b.b(eVar.f135823b);
        if (b16 != null) {
            w.d("MicroMsg.AppBrand.GetCurrentWiFiLogic", "fillBestEffort, wifiConfig not null");
            eVar.f135825d = Boolean.valueOf(2 == com.tencent.luggage.wxa.oh.e.a(b16));
        }
        w.d("MicroMsg.AppBrand.GetCurrentWiFiLogic", "fillBestEffort, signalStrength: " + eVar.f135824c + ", frequency: " + eVar.f135826e + ", security: " + eVar.f135825d);
    }
}
