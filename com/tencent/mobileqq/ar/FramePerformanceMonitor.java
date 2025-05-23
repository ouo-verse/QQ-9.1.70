package com.tencent.mobileqq.ar;

import com.tencent.mobileqq.perf.block.LockMethodProxy;

/* loaded from: classes11.dex */
public class FramePerformanceMonitor {

    /* renamed from: b, reason: collision with root package name */
    private int f197454b = 1000;

    /* renamed from: a, reason: collision with root package name */
    private r f197453a = new r(100);

    /* loaded from: classes11.dex */
    private class CurrentRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private boolean f197455d;
        final /* synthetic */ FramePerformanceMonitor this$0;

        @Override // java.lang.Runnable
        public void run() {
            while (this.f197455d) {
                try {
                    if (this.this$0.f197453a.c() == 0) {
                        LockMethodProxy.sleep(this.this$0.f197454b);
                    } else {
                        this.this$0.f197453a.b();
                        FramePerformanceMonitor.b(this.this$0);
                        throw null;
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface a {
    }

    static /* bridge */ /* synthetic */ a b(FramePerformanceMonitor framePerformanceMonitor) {
        framePerformanceMonitor.getClass();
        return null;
    }
}
