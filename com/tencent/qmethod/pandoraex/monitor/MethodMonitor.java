package com.tencent.qmethod.pandoraex.monitor;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MethodMonitor {
    private static final CopyOnWriteArrayList<com.tencent.qmethod.pandoraex.api.a> ACTIVITY_EXTEND_LIFECYCLES = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<com.tencent.qmethod.pandoraex.api.x> SERVICE_METHOD_HOOKS = new CopyOnWriteArrayList<>();
    private static final String TAG = "MethodMonitor";

    MethodMonitor() {
    }

    public static int afterServiceOnStartCommand(int i3, Service service, Intent intent, int i16, int i17) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "afterServiceOnStartCommand, returnValue=" + i3 + " class=" + service.getClass().getName());
        Iterator<com.tencent.qmethod.pandoraex.api.x> it = SERVICE_METHOD_HOOKS.iterator();
        while (it.hasNext()) {
            it.next().a(i3, service, intent, i16, i17);
        }
        return 2;
    }

    public static void beforeActivityOnNewIntent(Activity activity, Intent intent) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "beforeActivityOnNewIntent");
        Iterator<com.tencent.qmethod.pandoraex.api.a> it = ACTIVITY_EXTEND_LIFECYCLES.iterator();
        while (it.hasNext()) {
            it.next().c(activity, intent);
        }
    }

    public static void beforeActivityOnResult(Activity activity, int i3, int i16, @Nullable Intent intent) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "beforeActivityOnResult");
        Iterator<com.tencent.qmethod.pandoraex.api.a> it = ACTIVITY_EXTEND_LIFECYCLES.iterator();
        while (it.hasNext()) {
            it.next().a(activity, i3, i16, intent);
        }
    }

    public static boolean registerImplClass(Object obj) {
        if (obj instanceof com.tencent.qmethod.pandoraex.api.a) {
            return ACTIVITY_EXTEND_LIFECYCLES.addIfAbsent((com.tencent.qmethod.pandoraex.api.a) obj);
        }
        if (obj instanceof com.tencent.qmethod.pandoraex.api.x) {
            return SERVICE_METHOD_HOOKS.addIfAbsent((com.tencent.qmethod.pandoraex.api.x) obj);
        }
        return false;
    }
}
