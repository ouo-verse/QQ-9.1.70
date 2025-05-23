package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class ab {

    /* renamed from: a, reason: collision with root package name */
    protected Context f387552a;

    /* renamed from: b, reason: collision with root package name */
    protected Handler f387553b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f387554c = new Object();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ab.this.b(message);
        }
    }

    public ab() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(getClass().getSimpleName(), 1);
        baseHandlerThread.start();
        this.f387553b = new a(baseHandlerThread.getLooper());
    }

    public final void a(Context context) {
        this.f387552a = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.f387554c) {
            Handler handler = this.f387553b;
            if (handler == null) {
                String str = "Dead worker dropping a message: " + message.what;
                com.vivo.push.util.u.e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                handler.sendMessage(message);
            }
        }
    }
}
