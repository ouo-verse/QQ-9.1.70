package com.tencent.mobileqq.perf.thread.block;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.monitor.MsfMonitorCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ThreadWatcher implements MsfMonitorCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f258092e;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.perf.thread.config.b f258093a;

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f258094b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f258095c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, a> f258096d;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class TimeoutRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private a f258097d;

        TimeoutRunnable(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ThreadWatcher.this, (Object) aVar);
            } else {
                this.f258097d = aVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            a aVar = this.f258097d;
            aVar.f258103f = uptimeMillis - aVar.f258102e;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            a aVar2 = this.f258097d;
            aVar.f258105h = elapsedRealtime - aVar2.f258104g;
            d.f(aVar2);
            this.f258097d.f258101d++;
            com.tencent.mobileqq.perf.log.a.d("TB", "TimeoutRunnable.run()\uff0ccost = " + (SystemClock.uptimeMillis() - uptimeMillis));
            a aVar3 = this.f258097d;
            aVar3.f258098a = null;
            if (aVar3.f258101d > aVar3.f258100c.f258120e && !QLog.isColorLevel()) {
                ThreadWatcher.this.g(this.f258097d);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47652);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f258092e = false;
        }
    }

    public ThreadWatcher(com.tencent.mobileqq.perf.thread.config.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        } else {
            this.f258096d = new HashMap<>();
            this.f258093a = bVar;
        }
    }

    private static String b(String str) {
        int indexOf;
        int indexOf2;
        if (str == null || str.length() == 0 || !str.startsWith(">>>") || (indexOf = str.indexOf(40)) == -1 || (indexOf2 = str.indexOf(41, indexOf)) == -1) {
            return null;
        }
        String substring = str.substring(indexOf + 1, indexOf2);
        int indexOf3 = str.indexOf("} ", indexOf2);
        if (indexOf3 == -1) {
            return null;
        }
        int i3 = indexOf3 + 2;
        int indexOf4 = str.indexOf(64, i3);
        if (indexOf4 == -1 && (indexOf4 = str.indexOf(58, i3)) == -1 && (indexOf4 = str.indexOf(32, i3)) == -1) {
            return null;
        }
        String substring2 = str.substring(i3, indexOf4);
        int indexOf5 = str.indexOf(MsgSummary.STR_COLON, indexOf4);
        if (indexOf5 == -1) {
            return null;
        }
        return String.format(MaxVideoConst.REPORT_CLICK_FORMAT, substring, substring2, str.substring(indexOf5 + 2));
    }

    private com.tencent.mobileqq.perf.thread.config.a c(int i3) {
        if (3 == i3) {
            return this.f258093a.f258130i;
        }
        if (1 == i3) {
            return this.f258093a.f258128g;
        }
        if (2 == i3) {
            return this.f258093a.f258129h;
        }
        return null;
    }

    private void f(String str, long j3, long j16) {
        if (QLog.isColorLevel()) {
            if (j3 > j16) {
                QLog.e("[TM]LooperWatcher", 1, Thread.currentThread() + " OOT cost=" + j3 + ", " + b(str));
                return;
            }
            if (f258092e) {
                QLog.d("[TM]LooperWatcher", 2, Thread.currentThread() + ", cost=" + j3 + ", " + b(str));
            }
        }
    }

    private void i() {
        if (QLog.isColorLevel()) {
            QLog.d("[TM]LooperWatcher", 2, "startWatcherThread");
        }
        HandlerThread newFreeHandlerThread = ThreadManagerV2.newFreeHandlerThread("[TM]Looper-watcher", 0);
        this.f258094b = newFreeHandlerThread;
        newFreeHandlerThread.start();
        Looper looper = this.f258094b.getLooper();
        if (looper != null) {
            this.f258095c = new Handler(looper);
        }
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            return;
        }
        if (this.f258095c == null) {
            i();
        }
        c cVar = new c(this);
        Thread thread = aVar.f258099b;
        if (thread instanceof HandlerThread) {
            h(cVar, (HandlerThread) thread);
        }
        this.f258096d.put(aVar.a(), aVar);
    }

    public void d(String str, long j3) {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3));
            return;
        }
        a aVar = this.f258096d.get(Thread.currentThread().getName());
        if (aVar == null) {
            return;
        }
        Handler handler = this.f258095c;
        if (handler != null && (runnable = aVar.f258098a) != null) {
            handler.removeCallbacks(runnable);
            aVar.f258098a = null;
        }
        f(str, j3, aVar.f258100c.f258119d);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        a aVar = this.f258096d.get(Thread.currentThread().getName());
        if (aVar != null && aVar.f258098a == null) {
            aVar.f258098a = new TimeoutRunnable(aVar);
            long j3 = aVar.f258100c.f258119d;
            aVar.f258102e = SystemClock.uptimeMillis();
            aVar.f258104g = SystemClock.elapsedRealtime();
            this.f258095c.postDelayed(aVar.f258098a, j3);
        }
    }

    public void g(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[TM]LooperWatcher", 2, "quitThreadFromWatcher, threadName = " + aVar.a());
        }
        Thread thread = aVar.f258099b;
        if (thread instanceof HandlerThread) {
            h(null, (HandlerThread) thread);
        }
        this.f258096d.remove(aVar.a());
    }

    public void h(c cVar, HandlerThread handlerThread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar, (Object) handlerThread);
            return;
        }
        Looper looper = handlerThread.getLooper();
        if (looper != null) {
            looper.setMessageLogging(cVar);
        }
    }

    @Override // com.tencent.mobileqq.monitor.MsfMonitorCallback
    public boolean handleEnd(int i3) {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        String name = Thread.currentThread().getName();
        a aVar = this.f258096d.get(name);
        if (aVar == null) {
            return true;
        }
        if (f258092e && QLog.isColorLevel()) {
            QLog.d("[TM]LooperWatcher", 2, "handleEnd, threadName = " + name + ", threadType = " + i3);
        }
        Handler handler = this.f258095c;
        if (handler != null && (runnable = aVar.f258098a) != null) {
            handler.removeCallbacks(runnable);
            aVar.f258098a = null;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.monitor.MsfMonitorCallback
    public boolean handleStart(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        com.tencent.mobileqq.perf.thread.config.a c16 = c(i3);
        if (c16 != null && c16.f258121f) {
            String name = Thread.currentThread().getName();
            a aVar = this.f258096d.get(name);
            if (aVar == null) {
                aVar = new a(Thread.currentThread(), c16);
                this.f258096d.put(name, aVar);
                if (QLog.isColorLevel()) {
                    QLog.d("[TM]LooperWatcher", 2, "handleStart, new ObservedThreadInfo.");
                }
            }
            if (aVar.f258101d > aVar.f258100c.f258120e && !QLog.isColorLevel()) {
                if (QLog.isColorLevel()) {
                    QLog.d("[TM]LooperWatcher", 2, "handleStart, reportedNum over limit.");
                }
                return true;
            }
            if (aVar.f258098a == null) {
                TimeoutRunnable timeoutRunnable = new TimeoutRunnable(aVar);
                aVar.f258098a = timeoutRunnable;
                this.f258095c.postDelayed(timeoutRunnable, aVar.f258100c.f258119d);
            }
            if (f258092e && QLog.isColorLevel()) {
                QLog.d("[TM]LooperWatcher", 2, "handleStart, threadName = " + name + ", threadType = " + i3);
            }
        }
        return true;
    }
}
