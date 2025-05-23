package com.tencent.mobileqq.wink.editor.music.lyric.common;

import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes21.dex */
public class TimerTaskManager {

    /* renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f320864a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, InternalTaskEntry> f320865b = new HashMap();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private static class InternalTaskEntry {

        /* renamed from: a, reason: collision with root package name */
        private Runnable f320866a = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.common.TimerTaskManager.InternalTaskEntry.1
            @Override // java.lang.Runnable
            public void run() {
                if (InternalTaskEntry.this.f320868c != null) {
                    InternalTaskEntry.this.f320868c.run();
                }
            }
        };

        /* renamed from: b, reason: collision with root package name */
        private long f320867b = Long.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        private TimerTaskRunnable f320868c;

        /* renamed from: d, reason: collision with root package name */
        private ScheduledFuture<?> f320869d;

        InternalTaskEntry() {
        }

        public String toString() {
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = Long.valueOf(this.f320867b);
            TimerTaskRunnable timerTaskRunnable = this.f320868c;
            if (timerTaskRunnable != null && timerTaskRunnable.f320870d) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            return String.format("Period = %d; IsValid = %b;", objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static abstract class TimerTaskRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private boolean f320870d;

        public abstract void e();

        public boolean isCancelled() {
            return !this.f320870d;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f320870d) {
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a extends BaseScheduledThreadPoolExecutor {
        a(int i3) {
            super(i3);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th5) {
            super.afterExecute(runnable, th5);
            if (th5 == null && (runnable instanceof Future)) {
                try {
                    Future future = (Future) runnable;
                    if (future.isDone()) {
                        future.get();
                    }
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                } catch (CancellationException e17) {
                    th5 = e17;
                } catch (ExecutionException e18) {
                    th5 = e18.getCause();
                }
            }
            if (th5 != null) {
                Log.e("LyricTimerTaskManager", "Exception happen when execute task! : " + th5.toString());
            }
        }
    }

    public TimerTaskManager() {
        b();
    }

    private synchronized void b() {
        if (this.f320864a == null) {
            this.f320864a = new a(1);
        }
    }

    public synchronized void a(String str) {
        InternalTaskEntry internalTaskEntry = this.f320865b.get(str);
        if (internalTaskEntry != null) {
            Log.i("LyricTimerTaskManager", String.format("cancel -> cancel TimerTask [%s].", str));
            if (internalTaskEntry.f320869d != null) {
                internalTaskEntry.f320869d.cancel(true);
            }
            boolean remove = this.f320864a.remove(internalTaskEntry.f320866a);
            this.f320864a.purge();
            Log.d("LyricTimerTaskManager", "cancel -> cancel TimerTask:" + remove + "\n" + this.f320864a.toString());
            internalTaskEntry.f320868c.f320870d = false;
            internalTaskEntry.f320868c = null;
            this.f320865b.remove(str);
        } else {
            Log.i("LyricTimerTaskManager", String.format("cancel -> not find task[%s].", str));
        }
    }
}
