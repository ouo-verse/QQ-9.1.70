package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes19.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private Executor f304121a = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.a.a();

    /* renamed from: b, reason: collision with root package name */
    private Executor f304122b = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.a.c();

    /* renamed from: c, reason: collision with root package name */
    private b f304123c = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.a.d();

    /* renamed from: d, reason: collision with root package name */
    private Executor f304124d = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.a.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements b {

        /* renamed from: d, reason: collision with root package name */
        private Handler f304125d = new Handler(Looper.getMainLooper());

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.b
        public void d(Runnable runnable) {
            this.f304125d.post(runnable);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.f304125d.post(runnable);
            }
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.b
        public void executeDelay(Runnable runnable, long j3) {
            if (j3 > 0) {
                this.f304125d.postDelayed(runnable, j3);
            } else {
                execute(runnable);
            }
        }

        @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.b
        public void f(Runnable runnable) {
            if (runnable == null) {
                return;
            }
            this.f304125d.removeCallbacks(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Executor a() {
        return this.f304121a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Executor b() {
        return this.f304122b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public b c() {
        return this.f304123c;
    }
}
