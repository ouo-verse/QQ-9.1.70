package com.qq.e.comm.plugin.g.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.ams.monitor.metric.m;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
class f implements m {

    /* renamed from: a, reason: collision with root package name */
    private HandlerThread f39402a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f39403b;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f39406a;

        /* renamed from: b, reason: collision with root package name */
        private final String f39407b;

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f39406a;
            if (runnable == null) {
                return;
            }
            try {
                runnable.run();
            } catch (Throwable th5) {
                GDTLogger.e("[MetricReporter][MetricThreadManagerAdapter][SafeRunnable]error happens in " + StringUtil.safeString(this.f39407b), th5);
            }
        }

        a(Runnable runnable, String str) {
            this.f39406a = runnable;
            this.f39407b = str;
        }
    }

    public f() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("MRCommonSingleThread");
        this.f39402a = baseHandlerThread;
        baseHandlerThread.start();
        this.f39403b = new Handler(this.f39402a.getLooper());
    }

    @Override // com.tencent.ams.monitor.metric.m
    public boolean postDelayed(final Runnable runnable, int i3, long j3) {
        Handler handler = this.f39403b;
        HandlerThread handlerThread = this.f39402a;
        if (i3 != 10) {
            if (handler != null && handlerThread != null && handlerThread.isAlive()) {
                handler.postDelayed(new a(runnable, "commonSingleThread"), j3);
                return true;
            }
            GDTLogger.e("[MetricReporter][MetricThreadManagerAdapter][postDelayed]handlerThread is not alive");
            return false;
        }
        if (j3 != 0) {
            if (handler != null) {
                handler.postDelayed(new Runnable() { // from class: com.qq.e.comm.plugin.g.a.f.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtSDKThreadManager.getInstance().runOnThread(2, new a(runnable, "networkThread"));
                    }
                }, j3);
            } else {
                GDTLogger.e("[MetricReporter][MetricThreadManagerAdapter][postDelayed] handler is null");
                return false;
            }
        } else {
            GdtSDKThreadManager.getInstance().runOnThread(2, new a(runnable, "networkThread"));
        }
        return true;
    }

    @Override // com.tencent.ams.monitor.metric.m
    public boolean quitSafely() {
        HandlerThread handlerThread = this.f39402a;
        Handler handler = this.f39403b;
        if (handlerThread != null && handler != null) {
            try {
                handlerThread.quitSafely();
                this.f39402a = null;
                this.f39403b = null;
                return true;
            } catch (Throwable th5) {
                GDTLogger.e("[MetricReporter][MetricThreadManagerAdapter] quitSafely fail", th5);
                return false;
            }
        }
        return true;
    }
}
