package com.tencent.mobileqq.qzoneplayer.panorama;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f279393b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f279394c;

    /* renamed from: a, reason: collision with root package name */
    private final String f279392a = "RenderThreadHandler";

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f279395d = false;

    /* renamed from: e, reason: collision with root package name */
    private long f279396e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            if (eVar == null) {
                PlayerUtils.log(6, "RenderThreadHandler", "msg body renderer is null");
                return;
            }
            int i3 = message.what;
            if (i3 == 1) {
                eVar.j();
                return;
            }
            if (i3 == 2) {
                eVar.n();
            } else {
                if (i3 != 3) {
                    return;
                }
                eVar.d();
                b.this.f279396e = System.currentTimeMillis();
            }
        }
    }

    public b() {
        HandlerThread handlerThread = new HandlerThread("RenderThreadHandlerthread");
        this.f279393b = handlerThread;
        handlerThread.start();
        b();
    }

    private void b() {
        Looper looper = this.f279393b.getLooper();
        if (looper == null) {
            PlayerUtils.log(6, "RenderThreadHandler", "create thread looper is null!!!");
        } else {
            this.f279394c = new a(looper);
        }
    }

    public long c() {
        return this.f279396e;
    }

    public boolean d() {
        return this.f279393b.getLooper() != null;
    }

    public boolean e() {
        return this.f279395d;
    }

    public void i(e eVar, int i3) {
        Handler handler;
        if (this.f279394c == null) {
            b();
        }
        if (eVar == null || (handler = this.f279394c) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(i3);
        obtainMessage.obj = eVar;
        obtainMessage.sendToTarget();
    }

    public synchronized void j(boolean z16) {
        this.f279395d = z16;
    }

    public void f(e eVar) {
        i(eVar, 1);
    }

    public void g(e eVar) {
        i(eVar, 2);
    }

    public void h(e eVar) {
        i(eVar, 3);
    }
}
