package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes.dex */
public class x0 {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a extends TimerTask {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HandlerThread f30090a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f30091b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f30092c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Timer f30093d;

        public a(HandlerThread handlerThread, Handler handler, boolean z16, Timer timer) {
            this.f30090a = handlerThread;
            this.f30091b = handler;
            this.f30092c = z16;
            this.f30093d = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                x0.b(this.f30090a, this.f30091b, this.f30092c);
                Timer timer = this.f30093d;
                if (timer != null) {
                    timer.cancel();
                }
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a("HandlerThreadUtil", "timertask error.", th5);
                }
            }
        }
    }

    public static void b(HandlerThread handlerThread, Handler handler, boolean z16) {
        if (z16) {
            try {
                y0.b(handler);
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a("HandlerThreadUtil", "quit error.", th5);
                    return;
                }
                return;
            }
        }
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    public static void a(HandlerThread handlerThread, Handler handler, long j3, boolean z16) {
        if (handlerThread == null && handler == null) {
            return;
        }
        if (j3 <= 0) {
            b(handlerThread, handler, z16);
        } else {
            BaseTimer baseTimer = new BaseTimer("th_loc_tmp");
            baseTimer.schedule(new a(handlerThread, handler, z16, baseTimer), j3);
        }
    }
}
