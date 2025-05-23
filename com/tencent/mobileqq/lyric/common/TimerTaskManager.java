package com.tencent.mobileqq.lyric.common;

import android.util.Log;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TimerTaskManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f243128a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, InternalTaskEntry> f243129b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class InternalTaskEntry {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Runnable f243130a;

        /* renamed from: b, reason: collision with root package name */
        private long f243131b;

        /* renamed from: c, reason: collision with root package name */
        private TimerTaskRunnable f243132c;

        /* renamed from: d, reason: collision with root package name */
        private String f243133d;

        /* renamed from: e, reason: collision with root package name */
        private ScheduledFuture<?> f243134e;

        InternalTaskEntry() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f243130a = new Runnable() { // from class: com.tencent.mobileqq.lyric.common.TimerTaskManager.InternalTaskEntry.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InternalTaskEntry.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (InternalTaskEntry.this.f243132c != null) {
                            InternalTaskEntry.this.f243132c.run();
                        }
                    }
                };
                this.f243131b = Long.MIN_VALUE;
            }
        }

        public static InternalTaskEntry h(TimerTaskRunnable timerTaskRunnable) {
            InternalTaskEntry internalTaskEntry = new InternalTaskEntry();
            timerTaskRunnable.f243135d = true;
            internalTaskEntry.f243132c = timerTaskRunnable;
            return internalTaskEntry;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = Long.valueOf(this.f243131b);
            TimerTaskRunnable timerTaskRunnable = this.f243132c;
            if (timerTaskRunnable != null && timerTaskRunnable.f243135d) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            return String.format("Period = %d; IsValid = %b;", objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static abstract class TimerTaskRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f243135d;

        public TimerTaskRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract void e();

        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return !this.f243135d;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.f243135d) {
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends BaseScheduledThreadPoolExecutor {
        static IPatchRedirector $redirector_;

        a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TimerTaskManager.this, i3);
            }
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor
        protected void afterExecute(Runnable runnable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable, (Object) th5);
                return;
            }
            super.afterExecute(runnable, th5);
            if (th5 == null && (runnable instanceof Future)) {
                try {
                    Future future = (Future) runnable;
                    if (future.isDone()) {
                        future.get();
                    }
                } catch (InterruptedException unused) {
                } catch (CancellationException e16) {
                    th5 = e16;
                } catch (ExecutionException e17) {
                    th5 = e17.getCause();
                }
            }
            if (th5 != null) {
                Log.e("LyricTimerTaskManager", "Exception happen when execute task! : " + th5.toString());
            }
        }
    }

    public TimerTaskManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f243129b = new HashMap();
            b();
        }
    }

    private void b() {
        if (this.f243128a == null) {
            this.f243128a = new a(1);
        }
    }

    public synchronized void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        InternalTaskEntry internalTaskEntry = this.f243129b.get(str);
        if (internalTaskEntry != null) {
            Log.i("LyricTimerTaskManager", String.format("cancel -> cancel TimerTask [%s].", str));
            if (internalTaskEntry.f243134e != null) {
                internalTaskEntry.f243134e.cancel(true);
            }
            boolean remove = this.f243128a.remove(internalTaskEntry.f243130a);
            this.f243128a.purge();
            Log.d("LyricTimerTaskManager", "cancel -> cancel TimerTask:" + remove + "\n" + this.f243128a.toString());
            internalTaskEntry.f243132c.f243135d = false;
            internalTaskEntry.f243132c = null;
            this.f243129b.remove(str);
        } else {
            Log.i("LyricTimerTaskManager", String.format("cancel -> not find task[%s].", str));
        }
    }

    public synchronized void c(String str, long j3, long j16, TimerTaskRunnable timerTaskRunnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Long.valueOf(j16), timerTaskRunnable);
            return;
        }
        Log.i("LyricTimerTaskManager", String.format("schedule begin [%s].", str));
        if (str != null) {
            if (j3 >= 0 && j16 > 0) {
                if (timerTaskRunnable != null) {
                    b();
                    if (this.f243129b.containsKey(str)) {
                        Log.i("LyricTimerTaskManager", String.format("schedule -> cancel duplication of name[%s].", str));
                        a(str);
                    }
                    Log.i("LyricTimerTaskManager", String.format("schedule -> create new Task [%s][period : %d].", str, Long.valueOf(j16)));
                    InternalTaskEntry h16 = InternalTaskEntry.h(timerTaskRunnable);
                    h16.f243131b = j16;
                    h16.f243133d = str;
                    h16.f243134e = this.f243128a.scheduleWithFixedDelay(h16.f243130a, j3, j16, TimeUnit.MILLISECONDS);
                    this.f243129b.put(str, h16);
                    Log.i("LyricTimerTaskManager", String.format("schedule end [%s].", str));
                    return;
                }
                throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.u68));
            }
            throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.u67));
        }
        throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.u69));
    }
}
