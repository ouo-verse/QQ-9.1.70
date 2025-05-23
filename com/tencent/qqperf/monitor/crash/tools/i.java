package com.tencent.qqperf.monitor.crash.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class i {
    public static void a(Context context, StringBuilder sb5) throws Exception {
        Map map = (Map) wy2.f.b("android.app.LoadedApk", ((WeakReference) ((Map) wy2.f.b("android.app.ActivityThread", wy2.f.g("android.app.ActivityThread", "currentActivityThread", new Object[0], new Class[0]), "mPackages")).get(context.getPackageName())).get(), "mReceivers");
        for (Object obj : map.keySet()) {
            for (Object obj2 : ((Map) map.get(obj)).keySet()) {
                sb5.append("\n");
                BroadcastReceiver broadcastReceiver = (BroadcastReceiver) obj2;
                sb5.append(broadcastReceiver.getClass().getName() + ":" + broadcastReceiver);
                sb5.append(" in ");
                sb5.append(obj.getClass().getName() + ":" + obj);
            }
        }
    }
}
