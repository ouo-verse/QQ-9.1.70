package hynb.u;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f406875a = new a("Make");

    /* renamed from: b, reason: collision with root package name */
    public static final a f406876b = new a("heart");

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Handler f406877a;

        /* renamed from: b, reason: collision with root package name */
        public final HandlerThread f406878b;

        public a(String str) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("StatisticsThread-" + str);
            baseHandlerThread.setPriority(10);
            this.f406878b = baseHandlerThread;
            baseHandlerThread.start();
        }

        public Handler a() {
            if (this.f406877a == null) {
                this.f406877a = new Handler(this.f406878b.getLooper());
            }
            return this.f406877a;
        }
    }

    public static void a(Runnable runnable, long j3) {
        f406875a.a().postDelayed(runnable, j3);
    }

    public static Handler a() {
        return f406876b.a();
    }

    public static void a(Runnable runnable) {
        a aVar = f406875a;
        if (aVar.f406878b.getThreadId() == Process.myTid()) {
            runnable.run();
        } else {
            aVar.a().post(runnable);
        }
    }
}
