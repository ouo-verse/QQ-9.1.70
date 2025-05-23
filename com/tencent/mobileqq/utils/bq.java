package com.tencent.mobileqq.utils;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bq {

    /* renamed from: a, reason: collision with root package name */
    private static volatile HandlerThread f307497a;

    public static Looper a() {
        boolean c16 = c();
        QLog.d("MemoryThreadHelper", 1, "getWorkLooper useSingleThread: " + c16);
        if (c16) {
            b();
            return f307497a.getLooper();
        }
        return ThreadManagerV2.getQQCommonThreadLooper();
    }

    private static void b() {
        if (f307497a == null) {
            synchronized (bq.class) {
                if (f307497a == null) {
                    f307497a = ThreadManagerV2.newFreeHandlerThread("guard_manager_thread", 0);
                    f307497a.start();
                }
            }
        }
    }

    private static boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106209", false);
    }
}
