package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.c;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes19.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor a() {
        return ev2.d.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor b() {
        return ProxyExecutors.newSingleThreadExecutor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor c() {
        return ev2.d.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b d() {
        return new c.a();
    }
}
