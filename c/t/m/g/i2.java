package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* compiled from: P */
/* loaded from: classes.dex */
public class i2 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final n1 f29762a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f29763b;

    public i2(n1 n1Var) {
        this.f29762a = n1Var;
    }

    public void a() {
        if (this.f29763b) {
            this.f29763b = false;
            try {
                this.f29762a.f29875a.unregisterReceiver(this);
            } catch (Exception unused) {
            }
        }
    }

    public void b(Handler handler) {
        if (this.f29763b) {
            return;
        }
        this.f29763b = true;
        a(handler);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (intent.getBooleanExtra("noConnectivity", false)) {
                k3.a("net", "none");
                this.f29762a.a((Object) (-1));
            } else if (p3.c(context)) {
                k3.a("net", "conn");
                this.f29762a.a((Object) 1);
            } else {
                k3.a("net", "disconn");
                this.f29762a.a((Object) 0);
            }
        } catch (Exception e16) {
            o3.a("TxNetworkStateMonitor", "listenNetworkState: Exception", e16);
        }
    }

    public final void a(Handler handler) {
        try {
            this.f29762a.f29875a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, handler);
        } catch (Exception e16) {
            o3.a("TxNetworkStateMonitor", "listenNetworkState: failed", e16);
        }
    }
}
