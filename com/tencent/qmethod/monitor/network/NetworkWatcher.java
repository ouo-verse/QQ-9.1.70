package com.tencent.qmethod.monitor.network;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.monitor.base.a;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\b\u0003\n\u0002\b\u0006*\u0002(+\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0003J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0006\u0010\u0011\u001a\u00020\u0002R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\u00020\t8B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010'\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/qmethod/monitor/network/NetworkWatcher;", "", "", "k", "e", "", "it", "Lcom/tencent/qmethod/monitor/network/NetworkState;", "networkState", "Lcom/tencent/qmethod/monitor/network/Apn;", DomainData.DOMAIN_NAME, "g", "o", "i", "", "l", h.F, "j", "Ljava/lang/ref/WeakReference;", "Landroid/app/Application;", "a", "Ljava/lang/ref/WeakReference;", "ctx", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "c", "Z", "isInited", "d", "Lcom/tencent/qmethod/monitor/network/Apn;", "f", "()Lcom/tencent/qmethod/monitor/network/Apn;", "apn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "setWifiAvailable", "(Z)V", "isWifiAvailable", "com/tencent/qmethod/monitor/network/NetworkWatcher$a", "Lcom/tencent/qmethod/monitor/network/NetworkWatcher$a;", "privateListener", "com/tencent/qmethod/monitor/network/NetworkWatcher$netStatusReceive$1", "Lcom/tencent/qmethod/monitor/network/NetworkWatcher$netStatusReceive$1;", "netStatusReceive", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class NetworkWatcher {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<Application> ctx;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isInited;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isWifiAvailable;

    /* renamed from: h, reason: collision with root package name */
    public static final NetworkWatcher f343743h = new NetworkWatcher();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile Apn apn = Apn.TYPE_INIT;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final a privateListener = new a();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final NetworkWatcher$netStatusReceive$1 netStatusReceive = new BroadcastReceiver() { // from class: com.tencent.qmethod.monitor.network.NetworkWatcher$netStatusReceive$1
        /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
        
            r2 = com.tencent.qmethod.monitor.network.NetworkWatcher.handler;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            WeakReference weakReference;
            Application application;
            Handler handler2;
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            NetworkWatcher networkWatcher = NetworkWatcher.f343743h;
            weakReference = NetworkWatcher.ctx;
            if (weakReference != null) {
                application = (Application) weakReference.get();
            } else {
                application = null;
            }
            if (application != null && handler2 != null) {
                handler2.post(new Runnable() { // from class: com.tencent.qmethod.monitor.network.NetworkWatcher$netStatusReceive$1$onReceive$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        NetworkWatcher.f343743h.e();
                    }
                });
            }
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qmethod/monitor/network/NetworkWatcher$a", "Lcom/tencent/qmethod/monitor/base/a;", "", "isAgree", "", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class a implements com.tencent.qmethod.monitor.base.a {
        a() {
        }

        @Override // com.tencent.qmethod.monitor.base.a
        public void a(boolean isAgree) {
            if (isAgree) {
                NetworkWatcher.f343743h.k();
            }
        }

        @Override // com.tencent.qmethod.monitor.base.a
        public void b() {
            a.C9329a.a(this);
        }
    }

    NetworkWatcher() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        o();
        boolean z16 = true;
        if (d.f343748a[f().ordinal()] != 1) {
            z16 = false;
        }
        isWifiAvailable = z16;
    }

    private final Apn f() {
        if (apn == Apn.TYPE_INIT) {
            o();
        }
        return apn;
    }

    private final Apn g(NetworkState networkState) {
        Apn n3;
        String i3 = i();
        if (i3 == null || (n3 = f343743h.n(i3, networkState)) == null) {
            return Apn.TYPE_NET;
        }
        return n3;
    }

    private final NetworkState h() {
        Object obj;
        Object obj2;
        Application application;
        Application application2;
        WeakReference<Application> weakReference = ctx;
        Integer num = null;
        if (weakReference != null && (application2 = weakReference.get()) != null) {
            obj = application2.getSystemService("connectivity");
        } else {
            obj = null;
        }
        if (!(obj instanceof ConnectivityManager)) {
            obj = null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) obj;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (!l()) {
                    if (activeNetworkInfo.isConnectedOrConnecting() && NetworkMonitor.getType(activeNetworkInfo) == 1) {
                        return NetworkState.NETWORK_WIFI;
                    }
                } else {
                    for (Network network : connectivityManager.getAllNetworks()) {
                        NetworkInfo it = connectivityManager.getNetworkInfo(network);
                        if (it != null) {
                            Intrinsics.checkExpressionValueIsNotNull(it, "it");
                            if (NetworkMonitor.getType(it) == 1 && (it.getState() == NetworkInfo.State.CONNECTED || it.getState() == NetworkInfo.State.CONNECTING)) {
                                return NetworkState.NETWORK_WIFI;
                            }
                        }
                    }
                }
                WeakReference<Application> weakReference2 = ctx;
                if (weakReference2 != null && (application = weakReference2.get()) != null) {
                    obj2 = application.getSystemService("phone");
                } else {
                    obj2 = null;
                }
                if (!(obj2 instanceof TelephonyManager)) {
                    obj2 = null;
                }
                TelephonyManager telephonyManager = (TelephonyManager) obj2;
                if (telephonyManager != null) {
                    num = Integer.valueOf(NetworkMonitor.getNetworkType(telephonyManager));
                }
                if ((num != null && num.intValue() == 1) || ((num != null && num.intValue() == 4) || ((num != null && num.intValue() == 2) || ((num != null && num.intValue() == 7) || (num != null && num.intValue() == 11))))) {
                    return NetworkState.NETWORK_2G;
                }
                if ((num != null && num.intValue() == 6) || ((num != null && num.intValue() == 3) || ((num != null && num.intValue() == 5) || ((num != null && num.intValue() == 8) || ((num != null && num.intValue() == 9) || ((num != null && num.intValue() == 10) || ((num != null && num.intValue() == 12) || ((num != null && num.intValue() == 14) || (num != null && num.intValue() == 15))))))))) {
                    return NetworkState.NETWORK_3G;
                }
                if (num != null && num.intValue() == 13) {
                    return NetworkState.NETWORK_4G;
                }
                return NetworkState.NETWORK_MOBILE;
            }
            return NetworkState.NETWORK_NONE;
        }
        return NetworkState.NETWORK_NONE;
    }

    private final String i() {
        Object obj;
        Application application;
        WeakReference<Application> weakReference = ctx;
        if (weakReference != null && (application = weakReference.get()) != null) {
            obj = application.getSystemService("phone");
        } else {
            obj = null;
        }
        if (!(obj instanceof TelephonyManager)) {
            obj = null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) obj;
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getSimOperatorName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        synchronized (NetworkWatcher.class) {
            if (!isInited) {
                WeakReference<Application> weakReference = new WeakReference<>(com.tencent.qmethod.monitor.a.f343451h.g().getContext());
                try {
                    Application application = weakReference.get();
                    if (application != null) {
                        application.registerReceiver(netStatusReceive, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    }
                } catch (Throwable th5) {
                    o.d("NetworkWatcher", "unInit, ", th5);
                }
                ctx = weakReference;
                handler = new Handler(ThreadManager.f343506c.a());
                isInited = true;
            }
            f343743h.e();
            Unit unit = Unit.INSTANCE;
        }
    }

    @SuppressLint({"AnnotateVersionCheck"})
    private final boolean l() {
        return true;
    }

    private final Apn n(String it, NetworkState networkState) {
        int hashCode = it.hashCode();
        if (hashCode != 618558396) {
            if (hashCode != 618596989) {
                if (hashCode == 618663094 && it.equals("\u4e2d\u56fd\u8054\u901a")) {
                    int i3 = d.f343751d[networkState.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return Apn.T_APN_WONET;
                        }
                        return Apn.T_APN_3GNET;
                    }
                    return Apn.T_APN_UNINET;
                }
            } else if (it.equals("\u4e2d\u56fd\u79fb\u52a8")) {
                int i16 = d.f343749b[networkState.ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        return Apn.T_APN_CMLTE;
                    }
                    return Apn.T_APN_CM3G;
                }
                return Apn.T_APN_CMNET;
            }
        } else if (it.equals("\u4e2d\u56fd\u7535\u4fe1")) {
            int i17 = d.f343750c[networkState.ordinal()];
            if (i17 != 1) {
                if (i17 != 2) {
                    return Apn.T_APN_CTLTE;
                }
                return Apn.T_APN_CTNET;
            }
            return Apn.TYPE_UNKNOWN;
        }
        return Apn.TYPE_NET;
    }

    private final void o() {
        Apn apn2;
        try {
            NetworkState h16 = h();
            int i3 = d.f343752e[h16.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    apn2 = g(h16);
                } else {
                    apn2 = Apn.TYPE_UNKNOWN;
                }
            } else {
                apn2 = Apn.TYPE_WIFI;
            }
        } catch (Exception e16) {
            o.c("NetworkWatcher", e16 + ": cannot get apn from network state, so use default");
            apn2 = Apn.TYPE_UNKNOWN;
        }
        apn = apn2;
    }

    public final void j() {
        com.tencent.qmethod.monitor.a aVar = com.tencent.qmethod.monitor.a.f343451h;
        aVar.o(privateListener);
        if (aVar.h()) {
            k();
        }
    }

    public final boolean m() {
        return isWifiAvailable;
    }
}
