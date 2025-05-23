package com.tencent.mobileqq.app.monitor;

import com.tencent.mobileqq.app.Job;
import com.tencent.mobileqq.app.ThreadSetting;
import com.tencent.mobileqq.app.monitor.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f196319a;

    /* renamed from: b, reason: collision with root package name */
    private int f196320b;

    /* renamed from: c, reason: collision with root package name */
    private int f196321c;

    /* renamed from: d, reason: collision with root package name */
    private int f196322d;

    /* renamed from: e, reason: collision with root package name */
    private long f196323e;

    /* renamed from: f, reason: collision with root package name */
    private long f196324f;

    /* renamed from: g, reason: collision with root package name */
    private e f196325g;

    /* renamed from: h, reason: collision with root package name */
    private ThreadMonitorReporter f196326h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayBlockingQueue<WeakReference<Thread>> f196327i;

    /* renamed from: j, reason: collision with root package name */
    private b f196328j;

    public f(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f196323e = 0L;
        this.f196324f = 0L;
        try {
            this.f196319a = str;
            this.f196320b = i3;
            this.f196321c = i16;
            this.f196322d = i17;
            this.f196327i = new ArrayBlockingQueue<>(i16);
            this.f196325g = e.a();
            this.f196326h = new ThreadMonitorReporter(str, i3);
            this.f196328j = new b();
        } catch (Exception e16) {
            QLog.e("ThreadPoolMonitor", 1, "ThreadPoolMonitor init error", e16);
        }
    }

    private void a(c cVar) {
        ArrayList<Thread> arrayList = new ArrayList();
        Iterator<WeakReference<Thread>> it = this.f196327i.iterator();
        int i3 = 0;
        String str = "";
        while (it.hasNext()) {
            Thread thread = it.next().get();
            if (thread != null) {
                String name = thread.getName();
                Thread.State state = thread.getState();
                if (Thread.State.BLOCKED.equals(state)) {
                    i3++;
                    arrayList.add(thread);
                }
                str = str + name + ":" + state + ", ";
            }
        }
        if (i3 >= 4) {
            for (Thread thread2 : arrayList) {
                if (thread2 != null) {
                    cVar.f196310l.add(new a(thread2.getName(), thread2.getState().toString(), d.a(thread2)));
                }
            }
        }
        cVar.f196309k = i3;
        cVar.f196305g = str;
    }

    public static f b(String str, int i3, int i16, int i17) {
        if (ThreadSetting.sProcessId != ThreadSetting.PROCESS_QQ) {
            return null;
        }
        return new f(str, i3, i16, i17);
    }

    private String d() {
        Thread currentThread = Thread.currentThread();
        if (currentThread != null && currentThread.isAlive()) {
            return currentThread.getName();
        }
        return "";
    }

    private String g(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(64);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    private void h(c cVar) {
        boolean z16;
        e eVar = this.f196325g;
        if (eVar == null) {
            return;
        }
        if (eVar.f196318h >= Math.random()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        if (cVar.f196304f == 0) {
            cVar.f196304f = this.f196324f;
        }
        if (cVar.f196303e == 0) {
            cVar.f196303e = this.f196323e;
        }
        if (cVar.f196299a != ReportType.JOB_HIGH_FREQ_RUN) {
            a(cVar);
        }
        ThreadMonitorReporter threadMonitorReporter = this.f196326h;
        if (threadMonitorReporter != null) {
            threadMonitorReporter.a(cVar);
        }
    }

    public void c(ThreadPoolExecutor threadPoolExecutor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) threadPoolExecutor);
            return;
        }
        e eVar = this.f196325g;
        if (eVar != null && eVar.f196311a) {
            try {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                int poolSize = threadPoolExecutor.getPoolSize();
                int size = queue.size();
                if (size > this.f196325g.f196315e * this.f196322d) {
                    c cVar = new c(ReportType.QUEUE_SIZE_HIGH);
                    cVar.f196301c = size;
                    cVar.f196300b = poolSize;
                    h(cVar);
                }
            } catch (Exception e16) {
                QLog.e("ThreadPoolMonitor", 1, "executeBeforeCollectInfo error.", e16);
            }
        }
    }

    public void e(Job job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) job);
            return;
        }
        try {
            e eVar = this.f196325g;
            if (eVar != null && eVar.f196311a) {
                long j3 = job.cost;
                if (j3 >= eVar.f196313c) {
                    c cVar = new c(ReportType.JOB_RUN_TIME_HIGH);
                    cVar.f196304f = j3;
                    cVar.f196306h = g(job.mName);
                    cVar.f196308j = d();
                    h(cVar);
                    this.f196324f = Math.max(this.f196324f, j3);
                }
                b bVar = this.f196328j;
                String g16 = g(job.mName);
                e eVar2 = this.f196325g;
                b.c a16 = bVar.a(g16, eVar2.f196316f, eVar2.f196317g);
                if (a16 != null) {
                    c cVar2 = new c(ReportType.JOB_HIGH_FREQ_RUN);
                    cVar2.f196306h = a16.f196296a;
                    cVar2.f196307i = a16.f196297b;
                    h(cVar2);
                }
            }
        } catch (Exception e16) {
            QLog.e("ThreadPoolMonitor", 1, "jobRunAfterCollectionInfo error.", e16);
        }
    }

    public void f(Job job) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) job);
            return;
        }
        e eVar = this.f196325g;
        if (eVar != null && eVar.f196311a) {
            try {
                long j3 = job.wait;
                if (j3 >= eVar.f196312b) {
                    c cVar = new c(ReportType.JOB_WAIT_TIME_HIGH);
                    cVar.f196303e = j3;
                    cVar.f196306h = g(job.mName);
                    cVar.f196308j = d();
                    h(cVar);
                    this.f196323e = Math.max(this.f196323e, j3);
                    QLog.d("ThreadPoolMonitor", 1, "job wait time exceeded " + this.f196325g.f196312b);
                }
            } catch (Exception e16) {
                QLog.e("ThreadPoolMonitor", 1, "jobRunBeforeCollectInfo error.", e16);
            }
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        e eVar = this.f196325g;
        if (eVar != null && eVar.f196311a) {
            QLog.d("ThreadPoolMonitor", 1, "rejectedExecutionCollectionInfo");
            try {
                h(new c(ReportType.REJECTED_EXECUTION));
            } catch (Exception e16) {
                QLog.d("ThreadPoolMonitor", 1, "rejectedExecutionCollectionInfo error.", e16);
            }
        }
    }

    public void j(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
        } else {
            this.f196325g = e.b(jSONObject);
            k();
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f196326h.b();
        }
    }

    public void l(Thread thread) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) thread);
            return;
        }
        try {
            this.f196327i.add(new WeakReference<>(thread));
        } catch (Exception e16) {
            QLog.d("ThreadPoolMonitor", 1, "threadPoolCreateThreadCollectionInfo error.", e16);
            this.f196327i.clear();
        }
    }
}
