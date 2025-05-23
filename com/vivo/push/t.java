package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f387850a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private static final HandlerThread f387851b;

    /* renamed from: c, reason: collision with root package name */
    private static final Handler f387852c;

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("push_client_thread");
        f387851b = baseHandlerThread;
        baseHandlerThread.start();
        f387852c = new u(baseHandlerThread.getLooper());
    }

    public static void a(s sVar) {
        if (sVar == null) {
            com.vivo.push.util.u.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int a16 = sVar.a();
        Message message = new Message();
        message.what = a16;
        message.obj = sVar;
        f387852c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f387850a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = f387852c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        Handler handler = f387852c;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 15000L);
    }
}
