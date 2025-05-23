package com.tencent.rdelivery.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.rdelivery.util.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0002\u000b\bB\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u001c\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/rdelivery/monitor/NetworkMonitor;", "Landroid/content/BroadcastReceiver;", "", "d", "Landroid/content/Context;", "context", "", "c", "b", "Lcom/tencent/rdelivery/monitor/NetworkMonitor$b;", "listener", "a", "Landroid/content/Intent;", "intent", "onReceive", "", "Ljava/util/List;", "listeners", "Z", "isNetConnected", "Lcom/tencent/rdelivery/util/c;", "Lcom/tencent/rdelivery/util/c;", "logger", "<init>", "(Landroid/content/Context;Lcom/tencent/rdelivery/util/c;)V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class NetworkMonitor extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<b> listeners;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isNetConnected;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final c logger;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rdelivery/monitor/NetworkMonitor$b;", "", "", "onReconnect", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public interface b {
        void onReconnect();
    }

    public NetworkMonitor(@NotNull Context context, @Nullable c cVar) {
        boolean z16;
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.logger = cVar;
        this.listeners = new CopyOnWriteArrayList();
        context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        if (!c(context) && !b(context)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isNetConnected = z16;
        if (cVar != null) {
            c.b(cVar, "RDelivery_NetworkMonitor", "init isNetConnected = " + this.isNetConnected, false, 4, null);
        }
    }

    private final boolean b(Context context) {
        Object systemService;
        NetworkInfo networkInfo = null;
        if (context != null) {
            try {
                systemService = context.getSystemService("connectivity");
            } catch (Exception e16) {
                c cVar = this.logger;
                if (cVar != null) {
                    cVar.d("RDelivery_NetworkMonitor", "isGprsConnected exception", e16);
                }
            }
        } else {
            systemService = null;
        }
        if (!(systemService instanceof ConnectivityManager)) {
            systemService = null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getNetworkInfo(0);
        }
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isConnected();
    }

    private final boolean c(Context context) {
        Object systemService;
        NetworkInfo networkInfo = null;
        if (context != null) {
            try {
                systemService = context.getSystemService("connectivity");
            } catch (Exception e16) {
                c cVar = this.logger;
                if (cVar != null) {
                    cVar.d("RDelivery_NetworkMonitor", "isWifiConnected exception", e16);
                }
            }
        } else {
            systemService = null;
        }
        if (!(systemService instanceof ConnectivityManager)) {
            systemService = null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getNetworkInfo(1);
        }
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    private final void d() {
        c cVar = this.logger;
        if (cVar != null) {
            c.b(cVar, "RDelivery_NetworkMonitor", "onReconnect", false, 4, null);
        }
        Iterator<b> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onReconnect();
        }
    }

    public final void a(@NotNull b listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String str;
        boolean z16;
        if (intent == null || (str = intent.getAction()) == null) {
            str = "";
        }
        if (!str.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            return;
        }
        boolean c16 = c(context);
        boolean b16 = b(context);
        c cVar = this.logger;
        if (cVar != null) {
            c.b(cVar, "RDelivery_NetworkMonitor", "onReceive wifiConnected = " + c16 + ", gprsConnected = " + b16 + ", curState = " + this.isNetConnected, false, 4, null);
        }
        if (!c16 && !b16) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.isNetConnected != z16) {
            this.isNetConnected = z16;
            if (z16) {
                d();
            }
        }
    }
}
