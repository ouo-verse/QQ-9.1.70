package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class f0 extends i0 {

    /* renamed from: c, reason: collision with root package name */
    public volatile HandlerThread f29606c = null;

    /* renamed from: d, reason: collision with root package name */
    public volatile a f29607d = null;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                f0.this.a(message);
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a(f0.this.a(), "handleInnerMessage[" + message.what + "] error.", th5);
                }
            }
        }
    }

    public void a(long j3) {
        synchronized (this.f29761b) {
            try {
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a(a(), "shutdown error.", th5);
                }
            }
            if (this.f29760a) {
                if (c1.a()) {
                    c1.a(a(), "shutdown()");
                }
                c();
                b(j3);
                this.f29760a = false;
            }
        }
    }

    public abstract void a(Message message) throws Exception;

    public int b(Looper looper) {
        synchronized (this.f29761b) {
            if (b()) {
                return -1;
            }
            this.f29760a = true;
            try {
                if (c1.a()) {
                    c1.a(a(), "startup()");
                }
                if (looper == null) {
                    this.f29606c = new BaseHandlerThread("th_" + a());
                    this.f29606c.start();
                    this.f29607d = new a(this.f29606c.getLooper());
                } else {
                    this.f29607d = new a(looper);
                }
                return a(this.f29607d.getLooper());
            } catch (Throwable th5) {
                if (c1.a()) {
                    c1.a(a(), "startup error.", th5);
                }
                return -1;
            }
        }
    }

    public Handler d() {
        a aVar;
        synchronized (this.f29761b) {
            aVar = this.f29607d;
        }
        return aVar;
    }

    public void e() {
        a(0L);
    }

    public boolean a(int i3, long j3) {
        boolean a16;
        synchronized (this.f29761b) {
            a16 = y0.a(this.f29607d, i3, j3);
        }
        return a16;
    }

    public boolean a(Message message, long j3) {
        boolean a16;
        synchronized (this.f29761b) {
            a16 = y0.a(this.f29607d, message, j3);
        }
        return a16;
    }

    public final void b(long j3) {
        try {
            x0.a(this.f29606c, this.f29607d, j3, false);
            this.f29606c = null;
            this.f29607d = null;
        } catch (Throwable th5) {
            if (c1.a()) {
                c1.a(a(), "shutdown thread error.", th5);
            }
        }
    }
}
