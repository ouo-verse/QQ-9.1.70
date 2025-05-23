package com.tencent.mobileqq.ark.base;

import com.tencent.ark.ArkDispatchTask;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b {
    public static void a(Runnable runnable, long j3) {
        c().postDelayed("logicqueue", runnable, j3);
    }

    public static void b(Runnable runnable) {
        c().post("logicqueue", runnable);
    }

    public static ArkDispatchTask c() {
        l91.a.b(true);
        return ArkDispatchTask.getInstance();
    }
}
