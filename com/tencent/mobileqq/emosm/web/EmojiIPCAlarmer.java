package com.tencent.mobileqq.emosm.web;

import android.os.Handler;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* loaded from: classes6.dex */
public class EmojiIPCAlarmer {

    /* renamed from: a, reason: collision with root package name */
    private volatile Handler f204461a;

    /* renamed from: b, reason: collision with root package name */
    a f204462b;

    /* loaded from: classes6.dex */
    class TimeoutTaskWrapper implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f204463d;

        public TimeoutTaskWrapper(int i3) {
            this.f204463d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = EmojiIPCAlarmer.this.f204462b;
            if (aVar != null) {
                try {
                    aVar.onTimeOut(this.f204463d);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface a {
        void onTimeOut(int i3);
    }

    public EmojiIPCAlarmer(a aVar) {
        this.f204462b = aVar;
    }

    public Runnable a(int i3, long j3) {
        TimeoutTaskWrapper timeoutTaskWrapper = new TimeoutTaskWrapper(i3);
        this.f204461a.postDelayed(timeoutTaskWrapper, j3);
        return timeoutTaskWrapper;
    }

    public void b() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("EmojiIPCTimeoutChecker", 5);
        baseHandlerThread.start();
        this.f204461a = new Handler(baseHandlerThread.getLooper());
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            this.f204461a.removeCallbacks(runnable);
        }
    }

    /* loaded from: classes6.dex */
    class PendingTaskWrapper implements Runnable {
        final /* synthetic */ EmojiIPCAlarmer this$0;

        @Override // java.lang.Runnable
        public void run() {
        }
    }
}
