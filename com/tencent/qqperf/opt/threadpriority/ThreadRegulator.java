package com.tencent.qqperf.opt.threadpriority;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MainService;
import mqq.os.MqqHandler;
import mqq.os.MqqRegulatorCallback;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ThreadRegulator implements MqqRegulatorCallback {

    /* renamed from: e, reason: collision with root package name */
    private static ThreadRegulator f363329e;

    /* renamed from: a, reason: collision with root package name */
    private final RecyclablePool f363330a = new RecyclablePool(b.class, 2);

    /* renamed from: b, reason: collision with root package name */
    private volatile b f363331b = null;

    /* renamed from: c, reason: collision with root package name */
    private MqqHandler f363332c = new a(ThreadManagerV2.getSubThreadLooper());

    /* renamed from: d, reason: collision with root package name */
    Runnable f363333d = new Runnable() { // from class: com.tencent.qqperf.opt.threadpriority.ThreadRegulator.2
        @Override // java.lang.Runnable
        public void run() {
            if (ThreadRegulator.this.f363331b != null) {
                b unused = ThreadRegulator.this.f363331b;
                ThreadRegulator.this.f363331b = null;
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends MqqHandler {
        a(Looper looper) {
            super(looper);
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            b bVar = (b) message.obj;
            if (bVar != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ThreadManager.Regulaotr", 2, bVar.f363335h + " cost " + (bVar.f363337j - bVar.f363336i) + ", paused " + bVar.f363338k);
                }
                bVar.recycle();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b extends RecyclablePool.Recyclable {

        /* renamed from: h, reason: collision with root package name */
        int f363335h;

        /* renamed from: i, reason: collision with root package name */
        long f363336i;

        /* renamed from: j, reason: collision with root package name */
        long f363337j;

        /* renamed from: k, reason: collision with root package name */
        ConcurrentHashMap<String, Long> f363338k = new ConcurrentHashMap<>(4);

        @Override // com.tencent.commonsdk.pool.RecyclablePool.Recyclable
        public void recycle() {
            this.f363335h = 0;
            this.f363336i = 0L;
            this.f363337j = 0L;
            this.f363338k.clear();
            super.recycle();
        }
    }

    public static synchronized ThreadRegulator d() {
        ThreadRegulator threadRegulator;
        synchronized (ThreadRegulator.class) {
            if (f363329e == null) {
                f363329e = new ThreadRegulator();
            }
            threadRegulator = f363329e;
        }
        return threadRegulator;
    }

    public void c() {
        if (this.f363331b == null) {
            return;
        }
        while (this.f363331b != null) {
            try {
                LockMethodProxy.sleep(100L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    @Override // mqq.os.MqqRegulatorCallback
    public void checkInRegulatorMsg() {
        c();
    }

    public void e() {
        MqqHandler.sRegulatorCallback = this;
        MainService.sRegulatorCallback = this;
    }

    public void f(int i3) {
        if (com.tencent.qqperf.opt.threadpriority.a.c().a() && this.f363331b == null) {
            this.f363331b = (b) this.f363330a.obtain(b.class);
            this.f363331b.f363335h = i3;
            this.f363331b.f363336i = SystemClock.uptimeMillis();
            try {
                ThreadExcutor.getInstance().shrinkMaxPoolSize(true);
            } catch (Throwable th5) {
                if (AppSetting.isPublicVersion()) {
                    QLog.e("ThreadManager.Regulaotr", 1, "markBusyState: invoked. ", th5);
                    return;
                }
                QLog.e("ThreadManager.Regulaotr", 1, "ThreadExcutor.classloader = " + ThreadExcutor.class.getClassLoader().toString() + ", ThreadRegulator.classLoader = " + getClass().getClassLoader().toString(), th5);
                throw new RuntimeException();
            }
        }
    }

    public void g(int i3, long j3) {
        if (j3 == 0) {
            this.f363333d.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.f363333d, j3);
        }
    }

    @Override // mqq.os.MqqRegulatorCallback
    public boolean regulatorThread(Thread thread) {
        if (thread != ThreadManagerV2.getFileThread() && thread != ThreadManagerV2.getSubThread()) {
            if (!"MSF-Receiver".equals(thread.getName()) && !"MSF-Advance-Receiver".equals(thread.getName())) {
                if ("Rejected_Handler".equals(thread.getName())) {
                    return true;
                }
                return false;
            }
            if (com.tencent.qqperf.opt.threadpriority.a.c().d()) {
                thread.setPriority(1);
            }
        }
        return true;
    }
}
