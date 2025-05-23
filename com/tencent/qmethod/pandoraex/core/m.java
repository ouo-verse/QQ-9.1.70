package com.tencent.qmethod.pandoraex.core;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f344144a;

    /* renamed from: b, reason: collision with root package name */
    private static BroadcastReceiver f344145b;

    /* renamed from: c, reason: collision with root package name */
    private static ConnectivityManager.NetworkCallback f344146c;

    /* renamed from: d, reason: collision with root package name */
    private static Context f344147d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            if (m.f344147d != null) {
                m.h(m.f344147d);
            }
            o.a(NetworkUtil.TAG, "NetworkCallback onLinkPropertiesChanged");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            if (m.f344147d != null) {
                m.h(m.f344147d);
            }
            o.a(NetworkUtil.TAG, "NetworkCallback onLost");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (m.f344144a == null) {
                ConnectivityManager unused = m.f344144a = (ConnectivityManager) context.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = m.f344144a.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (NetworkMonitor.getType(activeNetworkInfo) == 1 && m.f344147d != null) {
                    m.h(m.f344147d);
                }
                o.a(NetworkUtil.TAG, "NetworkChangedReceiver receive");
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    @SuppressLint({"NewApi"})
    private static ConnectivityManager.NetworkCallback d() {
        return new a();
    }

    private static boolean e(Context context) {
        if (f344145b == null) {
            try {
                f344145b = new b(null);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(f344145b, intentFilter);
                o.a(NetworkUtil.TAG, "registerNetworkReceiver success");
                return true;
            } catch (Exception e16) {
                o.d(NetworkUtil.TAG, "registerNetworkReceiver failed", e16);
                f344145b = null;
                return false;
            }
        }
        return true;
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    private static boolean f(Context context) {
        try {
            if (f344144a == null) {
                f344144a = (ConnectivityManager) context.getSystemService("connectivity");
            }
            if (f344146c == null) {
                f344146c = d();
            }
            f344144a.registerDefaultNetworkCallback(f344146c);
            o.a(NetworkUtil.TAG, "requestNetworkCallback success");
            return true;
        } catch (Exception e16) {
            o.d(NetworkUtil.TAG, "requestNetworkCallback failed", e16);
            return false;
        }
    }

    public static boolean g(Context context) {
        boolean e16;
        if (!r.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            e16 = f(context);
        } else {
            e16 = e(context);
        }
        if (e16) {
            f344147d = context.getApplicationContext();
        }
        return e16;
    }

    public static void h(Context context) {
        Iterator<String> it = d.f344035b.iterator();
        while (it.hasNext()) {
            String str = it.next() + "_network_state";
            if (!com.tencent.qmethod.pandoraex.api.r.d(context, str).booleanValue()) {
                o.a(NetworkUtil.TAG, "NetWorkState Change");
                com.tencent.qmethod.pandoraex.api.r.m(context, str, Boolean.TRUE);
            }
        }
    }
}
