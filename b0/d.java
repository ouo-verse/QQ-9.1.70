package b0;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import b0.a;

/* compiled from: P */
/* loaded from: classes.dex */
public class d implements b {
    @Override // b0.b
    @NonNull
    public a a(@NonNull Context context, @NonNull a.InterfaceC0081a interfaceC0081a) {
        boolean z16;
        String str;
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            if (z16) {
                str = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
            } else {
                str = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            }
            Log.d("ConnectivityMonitor", str);
        }
        if (z16) {
            return new c(context, interfaceC0081a);
        }
        return new g();
    }
}
