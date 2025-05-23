package cooperation.qqfav.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import java.lang.ref.WeakReference;

/* loaded from: classes28.dex */
public class HandlerPlus extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Handler.Callback> f390657a;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<TimerRunnable> f390658b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes28.dex */
    public class TimerRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<Runnable> f390659d;

        /* renamed from: e, reason: collision with root package name */
        int f390660e;

        /* renamed from: f, reason: collision with root package name */
        long f390661f;

        TimerRunnable(Runnable runnable) {
            this.f390659d = new WeakReference<>(runnable);
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            Runnable runnable = this.f390659d.get();
            if (runnable != null && (i3 = this.f390660e) > 0) {
                this.f390660e = i3 - 1;
                runnable.run();
                int i16 = this.f390660e;
                if (i16 > 0) {
                    HandlerPlus.this.a(runnable, i16, this.f390661f, 0L);
                }
            }
        }
    }

    public HandlerPlus(Looper looper, Handler.Callback callback) {
        super(looper);
        this.f390658b = new SparseArray<>();
        this.f390657a = new WeakReference<>(callback);
    }

    public boolean a(Runnable runnable, int i3, long j3, long j16) {
        TimerRunnable timerRunnable;
        synchronized (this.f390658b) {
            timerRunnable = this.f390658b.get(runnable.hashCode());
            if (timerRunnable == null) {
                timerRunnable = new TimerRunnable(runnable);
                this.f390658b.put(runnable.hashCode(), timerRunnable);
            }
            timerRunnable.f390660e = i3;
            timerRunnable.f390661f = j3;
        }
        return postDelayed(timerRunnable, j16);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Handler.Callback callback = this.f390657a.get();
        if (callback != null) {
            callback.handleMessage(message);
        }
    }
}
