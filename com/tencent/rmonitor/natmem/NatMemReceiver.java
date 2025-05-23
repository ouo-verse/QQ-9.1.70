package com.tencent.rmonitor.natmem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.rmonitor.DebugInterfaceProxy;

/* compiled from: P */
/* loaded from: classes25.dex */
public class NatMemReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.tencent.rmonitor.natmem.USAGE_DUMP".equals(action) && DebugInterfaceProxy.a()) {
            NatMemMonitor.getInstance().e("/storage/emulated/0/rmonitor/natmem_usage.json");
        } else if ("com.tencent.rmonitor.natmem.LEAK_DUMP".equals(action) && DebugInterfaceProxy.a()) {
            NatMemMonitor.getInstance().d("/storage/emulated/0/rmonitor/natmem_leak.json");
        }
    }
}
