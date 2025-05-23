package com.tencent.liteav.base.util;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final /* synthetic */ class m implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private final String f119040a;

    m(String str) {
        this.f119040a = str;
    }

    public static ThreadFactory a(String str) {
        return new m(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new BaseThread(runnable, this.f119040a);
    }
}
