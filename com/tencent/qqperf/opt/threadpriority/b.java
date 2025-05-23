package com.tencent.qqperf.opt.threadpriority;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f363345a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<Long, Integer> f363346b = new HashMap<>(40);

    /* renamed from: c, reason: collision with root package name */
    private static Handler f363347c = new a(ThreadManagerV2.getSubThreadLooper());

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                b.l();
            } else if (i3 == 2) {
                b.m();
            }
        }
    }

    private static Thread[] c() {
        try {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            Thread[] threadArr = new Thread[threadGroup.activeCount()];
            threadGroup.enumerate(threadArr);
            return threadArr;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ThreadPriorityManager", 2, "", e16);
            }
            return new Thread[0];
        }
    }

    private static boolean d(Thread thread) {
        if (thread != null && "LoginSuccessAnimDrawingThread".equals(thread.getName())) {
            return true;
        }
        return false;
    }

    private static boolean e(Thread thread) {
        Thread thread2 = Looper.getMainLooper().getThread();
        if (thread != null && thread2 != null && thread.getId() == thread2.getId()) {
            return true;
        }
        return false;
    }

    private static boolean f(Thread thread) {
        boolean z16;
        if (thread != null && thread.getName().equals("DisplayOperation")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && QLog.isColorLevel()) {
            QLog.w("ThreadPriorityManager", 2, "isNTDisplayThread true");
        }
        return z16;
    }

    private static boolean g(Thread thread) {
        boolean z16;
        if (thread != null && thread.getName().equals("ServiceContent")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && QLog.isColorLevel()) {
            QLog.w("ThreadPriorityManager", 2, "isNTServiceThread true");
        }
        return z16;
    }

    private static boolean h(Thread thread) {
        if (thread != null && "RenderThread".equalsIgnoreCase(thread.getName())) {
            return true;
        }
        return false;
    }

    private static boolean i(Thread thread) {
        Thread subThread = ThreadManagerV2.getSubThread();
        if (thread != null && subThread != null && thread.getId() == subThread.getId()) {
            return true;
        }
        return false;
    }

    private static boolean j(Thread thread) {
        if (!e(thread) && !i(thread) && !h(thread) && !f(thread) && !g(thread) && !d(thread)) {
            return false;
        }
        return true;
    }

    public static void k(boolean z16) {
        int i3;
        Handler handler = f363347c;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        handler.sendMessageAtFrontOfQueue(Message.obtain(handler, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        if (f363346b.size() <= 0) {
            return;
        }
        int i3 = 0;
        for (Thread thread : c()) {
            if (thread != null && thread.isAlive() && !j(thread)) {
                Integer num = f363346b.get(Long.valueOf(thread.getId()));
                if (num != null) {
                    i3 = num.intValue();
                }
                if (i3 != 0 && i3 <= 10 && i3 >= 1) {
                    try {
                        thread.setPriority(i3);
                    } catch (Throwable unused) {
                        QLog.e("ThreadPriorityManager", 1, "setPriority error");
                    }
                } else {
                    thread.setPriority(5);
                }
            }
        }
        f363346b.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        long j3;
        f363347c.removeMessages(1);
        f363347c.sendEmptyMessageDelayed(1, 30000L);
        if (f363346b.size() > 0) {
            return;
        }
        Thread[] c16 = c();
        if (c16.length < 2) {
            f363347c.removeMessages(1);
            return;
        }
        for (Thread thread : c16) {
            if (!j(thread) && thread != null && thread.isAlive()) {
                try {
                    j3 = thread.getId();
                    try {
                        f363346b.put(Long.valueOf(j3), Integer.valueOf(thread.getPriority()));
                        thread.setPriority(f363345a);
                    } catch (Throwable unused) {
                        if (j3 != -1) {
                            f363346b.remove(Long.valueOf(j3));
                        }
                    }
                } catch (Throwable unused2) {
                    j3 = -1;
                }
            }
        }
    }
}
