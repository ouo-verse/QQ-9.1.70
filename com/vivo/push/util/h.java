package com.vivo.push.util;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
final class h implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f387902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.f387902a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        BaseThread baseThread = new BaseThread(runnable);
        baseThread.setName(this.f387902a);
        baseThread.setDaemon(true);
        return baseThread;
    }
}
