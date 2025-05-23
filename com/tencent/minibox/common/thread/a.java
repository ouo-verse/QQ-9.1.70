package com.tencent.minibox.common.thread;

import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a implements ThreadFactory {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicInteger f151639h = new AtomicInteger(1);

    /* renamed from: d, reason: collision with root package name */
    public final ThreadGroup f151640d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f151641e = new AtomicInteger(1);

    /* renamed from: f, reason: collision with root package name */
    public final String f151642f;

    public a(String str) {
        ThreadGroup threadGroup;
        String str2;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f151640d = threadGroup;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pool-");
        sb5.append(f151639h.getAndIncrement());
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "-" + str;
        }
        sb5.append(str2);
        sb5.append("-thread-");
        this.f151642f = sb5.toString();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        BaseThread baseThread = new BaseThread(this.f151640d, runnable, this.f151642f + this.f151641e.getAndIncrement(), 0L);
        if (baseThread.isDaemon()) {
            baseThread.setDaemon(false);
        }
        if (baseThread.getPriority() != 1) {
            baseThread.setPriority(1);
        }
        return baseThread;
    }
}
