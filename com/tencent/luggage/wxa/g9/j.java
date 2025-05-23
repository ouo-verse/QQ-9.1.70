package com.tencent.luggage.wxa.g9;

import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadGroup f126649a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f126650b;

    /* renamed from: c, reason: collision with root package name */
    public final String f126651c;

    /* renamed from: d, reason: collision with root package name */
    public String f126652d;

    public j() {
        this.f126650b = new AtomicInteger(1);
        this.f126651c = "audio_mix_thread#";
        this.f126652d = "";
        this.f126649a = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        if (TextUtils.isEmpty(this.f126652d)) {
            this.f126652d = "audio_mix_thread#";
        }
        BaseThread baseThread = new BaseThread(this.f126649a, runnable, this.f126652d + this.f126650b.getAndIncrement(), 0L);
        if (baseThread.isDaemon()) {
            baseThread.setDaemon(false);
        }
        if (baseThread.getPriority() != 5) {
            baseThread.setPriority(5);
        }
        return baseThread;
    }

    public j(String str, String str2) {
        this.f126650b = new AtomicInteger(1);
        this.f126651c = "audio_mix_thread#";
        this.f126652d = "";
        this.f126649a = new ThreadGroup(str);
        this.f126652d = str2;
    }
}
