package com.tencent.mobileqq.app.monitor;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ThreadWrapContext;
import com.tencent.mobileqq.app.cb;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ThreadMonitorReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    public static ThreadWrapContext f196277g;

    /* renamed from: a, reason: collision with root package name */
    private ArrayBlockingQueue<c> f196278a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f196279b;

    /* renamed from: c, reason: collision with root package name */
    private int f196280c;

    /* renamed from: d, reason: collision with root package name */
    private String f196281d;

    /* renamed from: e, reason: collision with root package name */
    private int f196282e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f196283f;

    public ThreadMonitorReporter(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.f196278a = new ArrayBlockingQueue<>(5);
        this.f196279b = new Object();
        this.f196280c = 0;
        this.f196283f = new AtomicBoolean(false);
        this.f196281d = str;
        this.f196282e = i3;
    }

    public void a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
            return;
        }
        synchronized (this.f196279b) {
            if (this.f196278a.size() >= 5) {
                this.f196278a.poll();
            }
            this.f196278a.add(cVar);
            QLog.d("ThreadPoolMonitorThreadMonitorReporter", 1, cVar);
            this.f196280c++;
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (f196277g != null && !this.f196283f.getAndSet(true)) {
            f196277g.registerApplicationStatus(new cb() { // from class: com.tencent.mobileqq.app.monitor.ThreadMonitorReporter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ThreadMonitorReporter.this);
                    }
                }

                @Override // com.tencent.mobileqq.app.cb
                public void onApplicationBackground() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this);
                    } else {
                        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.app.monitor.ThreadMonitorReporter.1.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    ThreadMonitorReporter.this.c();
                                }
                            }
                        }, 16, null, true, 5000L);
                    }
                }

                @Override // com.tencent.mobileqq.app.cb
                public void onApplicationForeground() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.app.monitor.ThreadMonitorReporter.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    ThreadMonitorReporter.this.c();
                                }
                            }
                        }, 16, null, true, 5000L);
                    }
                }
            });
            QLog.d("ThreadPoolMonitorThreadMonitorReporter", 1, "success register report listener.");
        } else {
            QLog.d("ThreadPoolMonitorThreadMonitorReporter", 1, " register report failed. context is null");
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            synchronized (this.f196279b) {
                Iterator<c> it = this.f196278a.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    HashMap hashMap = new HashMap();
                    hashMap.put("queueSize", String.valueOf(next.f196301c));
                    hashMap.put("poolSize", String.valueOf(next.f196300b));
                    hashMap.put("poolCoreSize", String.valueOf(this.f196282e));
                    hashMap.put("runningTaskCount", String.valueOf(next.f196302d));
                    hashMap.put("jobWaitTime", String.valueOf(next.f196303e));
                    hashMap.put("jobRunTime", String.valueOf(next.f196304f));
                    hashMap.put("threadStatus", next.f196305g);
                    hashMap.put("poolName", this.f196281d);
                    hashMap.put("type", next.f196299a.name());
                    hashMap.put("jobKey", next.f196306h);
                    hashMap.put("blockThreadCount", String.valueOf(next.f196309k));
                    hashMap.put("currentThreadName", next.f196308j);
                    hashMap.put("jobHighFreqCount", String.valueOf(next.f196307i));
                    for (int i3 = 0; i3 < Math.min(next.f196310l.size(), 4); i3++) {
                        hashMap.put("blockThread_" + i3, next.f196310l.get(i3).toString());
                    }
                    if (f196277g != null) {
                        QLog.d("ThreadPoolMonitorThreadMonitorReporter", 1, "reportBeacon param:" + hashMap);
                        f196277g.reportBeacon("thread_pool_monitor_report", hashMap);
                    }
                }
                this.f196278a.clear();
            }
        } catch (Exception e16) {
            QLog.d("ThreadPoolMonitorThreadMonitorReporter", 1, "report error.", e16);
        }
    }
}
