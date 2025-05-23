package g93;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f401557d;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f401558a;

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f401559b;

    /* renamed from: c, reason: collision with root package name */
    private final List<g93.a> f401560c;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                b.this.f((g93.a) message.obj);
            } else if (i3 == 2) {
                b.this.h((g93.a) message.obj);
            } else if (i3 == 3) {
                b.this.g();
            }
        }
    }

    b() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FSVideoTimerManager");
        this.f401559b = baseHandlerThread;
        baseHandlerThread.start();
        this.f401558a = new a(baseHandlerThread.getLooper());
        this.f401560c = new ArrayList();
    }

    public static b d() {
        if (f401557d == null) {
            synchronized (b.class) {
                if (f401557d == null) {
                    f401557d = new b();
                }
            }
        }
        return f401557d;
    }

    private void e() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.f401558a.sendMessageDelayed(obtain, 33L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(g93.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f401560c.add(aVar);
        QLog.i("FSVideoTimerManager", 4, "handlerRegister, listener size:" + this.f401560c.size());
        if (this.f401560c.size() == 1) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f401560c.size() <= 0) {
            return;
        }
        Iterator<g93.a> it = this.f401560c.iterator();
        while (it.hasNext()) {
            it.next().onTimerCallback();
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(g93.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f401560c.remove(aVar);
        QLog.i("FSVideoTimerManager", 4, "handlerUnRegister, listener size:" + this.f401560c.size());
        if (this.f401560c.size() == 0) {
            this.f401558a.removeMessages(3);
        }
    }

    public void i(g93.a aVar) {
        if (aVar == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = aVar;
        this.f401558a.sendMessage(obtain);
        QLog.i("FSVideoTimerManager", 4, "registerTimerListener");
    }

    public void j(g93.a aVar) {
        if (aVar == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = aVar;
        this.f401558a.sendMessage(obtain);
        QLog.i("FSVideoTimerManager", 4, "unRegisterTimerListener");
    }
}
