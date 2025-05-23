package b0;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import b0.a;

/* compiled from: P */
/* loaded from: classes.dex */
final class c implements b0.a {

    /* renamed from: d, reason: collision with root package name */
    private final Context f27598d;

    /* renamed from: e, reason: collision with root package name */
    final a.InterfaceC0081a f27599e;

    /* renamed from: f, reason: collision with root package name */
    boolean f27600f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f27601h;

    /* renamed from: i, reason: collision with root package name */
    private final BroadcastReceiver f27602i = new a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            c cVar = c.this;
            boolean z16 = cVar.f27600f;
            cVar.f27600f = cVar.d(context);
            if (z16 != c.this.f27600f) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + c.this.f27600f);
                }
                c cVar2 = c.this;
                cVar2.f27599e.a(cVar2.f27600f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull Context context, @NonNull a.InterfaceC0081a interfaceC0081a) {
        this.f27598d = context.getApplicationContext();
        this.f27599e = interfaceC0081a;
    }

    private void i() {
        if (this.f27601h) {
            return;
        }
        this.f27600f = d(this.f27598d);
        try {
            this.f27598d.registerReceiver(this.f27602i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f27601h = true;
        } catch (SecurityException e16) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e16);
            }
        }
    }

    private void j() {
        if (!this.f27601h) {
            return;
        }
        this.f27598d.unregisterReceiver(this.f27602i);
        this.f27601h = false;
    }

    @SuppressLint({"MissingPermission"})
    boolean d(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) h0.j.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            return false;
        } catch (RuntimeException e16) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e16);
            }
            return true;
        }
    }

    @Override // b0.f
    public void onStart() {
        i();
    }

    @Override // b0.f
    public void onStop() {
        j();
    }

    @Override // b0.f
    public void onDestroy() {
    }
}
