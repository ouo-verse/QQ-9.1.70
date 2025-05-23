package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.rmonitor.base.thread.suspend.ThreadSuspend;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final Handler f98346a;

    /* renamed from: d, reason: collision with root package name */
    long f98349d;

    /* renamed from: e, reason: collision with root package name */
    private final String f98350e;

    /* renamed from: f, reason: collision with root package name */
    private final List<bq> f98351f = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    long f98347b = 5000;

    /* renamed from: g, reason: collision with root package name */
    private final long f98352g = 5000;

    /* renamed from: c, reason: collision with root package name */
    boolean f98348c = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(Handler handler, String str) {
        this.f98346a = handler;
        this.f98350e = str;
    }

    private Thread e() {
        return this.f98346a.getLooper().getThread();
    }

    public final boolean a() {
        if (!this.f98348c && SystemClock.uptimeMillis() >= this.f98349d + this.f98347b) {
            return true;
        }
        return false;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.f98349d;
    }

    public final List<bq> c() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f98351f) {
            arrayList = new ArrayList(this.f98351f.size());
            for (int i3 = 0; i3 < this.f98351f.size(); i3++) {
                bq bqVar = this.f98351f.get(i3);
                if (!bqVar.f98329e && currentTimeMillis - bqVar.f98326b < 200000) {
                    arrayList.add(bqVar);
                    bqVar.f98329e = true;
                }
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb5 = new StringBuilder(1024);
        long nanoTime = System.nanoTime();
        try {
            long g16 = ThreadSuspend.c().g(e());
            StackTraceElement[] stackTrace = e().getStackTrace();
            ThreadSuspend.c().f(g16);
            if (stackTrace.length == 0) {
                sb5.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb5.append(stackTraceElement);
                    sb5.append("\n");
                }
            }
        } catch (SecurityException e16) {
            sb5.append("getStackTrace() encountered:\n");
            sb5.append(e16.getMessage());
            sb5.append("\n");
            av.a(e16);
        }
        long nanoTime2 = System.nanoTime();
        bq bqVar = new bq(sb5.toString(), System.currentTimeMillis());
        bqVar.f98328d = nanoTime2 - nanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        bqVar.f98325a = name;
        synchronized (this.f98351f) {
            while (this.f98351f.size() >= 32) {
                this.f98351f.remove(0);
            }
            this.f98351f.add(bqVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f98348c = true;
        this.f98347b = this.f98352g;
    }
}
