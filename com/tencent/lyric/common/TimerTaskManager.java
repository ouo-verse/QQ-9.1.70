package com.tencent.lyric.common;

import android.util.Log;
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
/* loaded from: classes9.dex */
public class TimerTaskManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f147046a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, InternalTaskEntry> f147047b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class InternalTaskEntry {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Runnable f147048a;

        /* renamed from: b, reason: collision with root package name */
        private long f147049b;

        /* renamed from: c, reason: collision with root package name */
        private TimerTaskRunnable f147050c;

        /* renamed from: d, reason: collision with root package name */
        private String f147051d;

        /* renamed from: e, reason: collision with root package name */
        private ScheduledFuture<?> f147052e;

        InternalTaskEntry() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f147048a = new Runnable() { // from class: com.tencent.lyric.common.TimerTaskManager.InternalTaskEntry.1
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
                        } else if (InternalTaskEntry.this.f147050c != null) {
                            InternalTaskEntry.this.f147050c.run();
                        }
                    }
                };
                this.f147049b = Long.MIN_VALUE;
            }
        }

        public static InternalTaskEntry h(TimerTaskRunnable timerTaskRunnable) {
            InternalTaskEntry internalTaskEntry = new InternalTaskEntry();
            timerTaskRunnable.f147053d = true;
            internalTaskEntry.f147050c = timerTaskRunnable;
            return internalTaskEntry;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = Long.valueOf(this.f147049b);
            TimerTaskRunnable timerTaskRunnable = this.f147050c;
            if (timerTaskRunnable != null && timerTaskRunnable.f147053d) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            return String.format("Period = %d; IsValid = %b;", objArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class TimerTaskRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private boolean f147053d;

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
            return !this.f147053d;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (this.f147053d) {
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
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
            this.f147047b = new HashMap();
            b();
        }
    }

    private void b() {
        if (this.f147046a == null) {
            this.f147046a = new a(1);
        }
    }

    public synchronized void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        InternalTaskEntry internalTaskEntry = this.f147047b.get(str);
        if (internalTaskEntry != null) {
            Log.i("LyricTimerTaskManager", String.format("cancel -> cancel TimerTask [%s].", str));
            if (internalTaskEntry.f147052e != null) {
                internalTaskEntry.f147052e.cancel(true);
            }
            boolean remove = this.f147046a.remove(internalTaskEntry.f147048a);
            this.f147046a.purge();
            Log.i("LyricTimerTaskManager", "cancel -> cancel TimerTask:" + remove + "\n" + this.f147046a.toString());
            internalTaskEntry.f147050c.f147053d = false;
            internalTaskEntry.f147050c = null;
            this.f147047b.remove(str);
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
                    if (this.f147047b.containsKey(str)) {
                        Log.i("LyricTimerTaskManager", String.format("schedule -> cancel duplication of name[%s].", str));
                        a(str);
                    }
                    Log.i("LyricTimerTaskManager", String.format("schedule -> create new Task [%s][period : %d].", str, Long.valueOf(j16)));
                    InternalTaskEntry h16 = InternalTaskEntry.h(timerTaskRunnable);
                    h16.f147049b = j16;
                    h16.f147051d = str;
                    h16.f147052e = this.f147046a.scheduleWithFixedDelay(h16.f147048a, j3, j16, TimeUnit.MILLISECONDS);
                    this.f147047b.put(str, h16);
                    Log.i("LyricTimerTaskManager", String.format("schedule end [%s].", str));
                    return;
                }
                throw new IllegalArgumentException("runnable \u53c2\u6570\u4e0d\u80fd\u4e3a null.");
            }
            throw new IllegalArgumentException("delay \u6216\u8005 period \u4e0d\u5408\u6cd5.");
        }
        throw new IllegalArgumentException("taskName \u53c2\u6570\u4e0d\u80fd\u4e3a null.");
    }
}
