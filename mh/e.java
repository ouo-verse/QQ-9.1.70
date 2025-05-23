package mh;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import lh.i;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    private static volatile e f416760c;

    /* renamed from: a, reason: collision with root package name */
    private final Handler f416761a = RFWThreadManager.createNewThreadHandler("QZoneVideoTimerManager", 0, new a());

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<WeakReference<i>> f416762b = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                e.this.f((i) message.obj);
                return false;
            }
            if (i3 == 2) {
                e.this.h((i) message.obj);
                return false;
            }
            if (i3 != 3) {
                return false;
            }
            e.this.g();
            return false;
        }
    }

    e() {
    }

    public static e d() {
        if (f416760c == null) {
            synchronized (e.class) {
                if (f416760c == null) {
                    f416760c = new e();
                }
            }
        }
        return f416760c;
    }

    private void e() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.f416761a.sendMessageDelayed(obtain, 33L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (bl.b(this.f416762b)) {
            return;
        }
        Iterator<WeakReference<i>> it = this.f416762b.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            if (next.get() != null) {
                next.get().onTimerCallback();
            }
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(i iVar) {
        if (iVar == null || bl.b(this.f416762b)) {
            return;
        }
        Iterator<WeakReference<i>> it = this.f416762b.iterator();
        while (it.hasNext()) {
            WeakReference<i> next = it.next();
            if (next.get() == iVar) {
                this.f416762b.remove(next);
            }
        }
        QLog.i("QZoneVideoTimerManager", 4, "handlerUnRegister, listener size:" + this.f416762b.size());
        if (this.f416762b.size() == 0) {
            this.f416761a.removeMessages(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(i iVar) {
        if (iVar == null) {
            return;
        }
        this.f416762b.add(new WeakReference<>(iVar));
        if (QLog.isColorLevel()) {
            QLog.i("QZoneVideoTimerManager", 4, "handlerRegister, listener size:" + this.f416762b.size());
        }
        if (this.f416762b.size() == 1) {
            g();
        }
    }

    public void i(i iVar) {
        if (iVar == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iVar;
        this.f416761a.sendMessage(obtain);
        if (QLog.isColorLevel()) {
            QLog.i("QZoneVideoTimerManager", 4, "registerTimerListener");
        }
    }

    public void j(i iVar) {
        if (iVar == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = iVar;
        this.f416761a.sendMessage(obtain);
        if (QLog.isColorLevel()) {
            QLog.i("QZoneVideoTimerManager", 4, "unRegisterTimerListener");
        }
    }
}
