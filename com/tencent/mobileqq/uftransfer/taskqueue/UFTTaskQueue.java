package com.tencent.mobileqq.uftransfer.taskqueue;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.uftransfer.depend.c;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class UFTTaskQueue implements com.tencent.mobileqq.uftransfer.task.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static int f305697e;

    /* renamed from: a, reason: collision with root package name */
    private int f305698a;

    /* renamed from: b, reason: collision with root package name */
    private int f305699b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<UFTBaseTask> f305700c;

    /* renamed from: d, reason: collision with root package name */
    private LinkedList<UFTBaseTask> f305701d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42760);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            f305697e = 1;
        }
    }

    public UFTTaskQueue(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f305699b = 0;
        this.f305700c = new LinkedList<>();
        this.f305701d = new LinkedList<>();
        int i16 = f305697e;
        f305697e = i16 + 1;
        this.f305698a = i16;
        this.f305699b = i3;
        if (i3 <= 0) {
            c.b("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] maxRunningNum < 1 cannot run!!!!!");
        }
    }

    private UFTBaseTask g() {
        Iterator<UFTBaseTask> it = this.f305700c.iterator();
        while (it.hasNext()) {
            UFTBaseTask next = it.next();
            if (next == null) {
                it.remove();
            } else if (k(next)) {
                c.e("[UFTTransfer] UFTTaskQueue", 1, "my queue have same task is running");
            } else if (!d(next)) {
                c.e("[UFTTransfer] UFTTaskQueue", 1, "other busi queue have same task is running");
            } else {
                it.remove();
                return next;
            }
        }
        return null;
    }

    private boolean k(UFTBaseTask uFTBaseTask) {
        if (uFTBaseTask == null) {
            return false;
        }
        Iterator<UFTBaseTask> it = this.f305701d.iterator();
        while (it.hasNext()) {
            if (uFTBaseTask.f(it.next())) {
                return true;
            }
        }
        return false;
    }

    private String n() {
        return " queueInfo [maxnum:" + this.f305699b + " waitnum:" + this.f305700c.size() + " runnum:" + this.f305701d.size() + "]";
    }

    @Override // com.tencent.mobileqq.uftransfer.task.a
    public void a(UFTBaseTask uFTBaseTask, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uFTBaseTask, i3);
            return;
        }
        if (uFTBaseTask != null) {
            if (e(uFTBaseTask.d()) != null) {
                c.c("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] onTaskCompleted. task:" + uFTBaseTask.d() + n());
                l(uFTBaseTask);
            }
        } else {
            c.b("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] onTaskCompleted. task=null");
        }
        c();
    }

    public void b(UFTBaseTask uFTBaseTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uFTBaseTask);
            return;
        }
        if (uFTBaseTask == null) {
            return;
        }
        this.f305700c.add(uFTBaseTask);
        c.c("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] addTask:" + uFTBaseTask.d() + n());
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            com.tencent.mobileqq.uftransfer.a.a().b(new Runnable() { // from class: com.tencent.mobileqq.uftransfer.taskqueue.UFTTaskQueue.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTTaskQueue.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        UFTTaskQueue.this.o();
                    }
                }
            });
        }
    }

    protected boolean d(UFTBaseTask uFTBaseTask) {
        throw null;
    }

    UFTBaseTask e(long j3) {
        Iterator<UFTBaseTask> it = this.f305701d.iterator();
        while (it.hasNext()) {
            UFTBaseTask next = it.next();
            if (next.d() == j3) {
                it.remove();
                c.c("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] delRunningTask:" + j3 + n());
                return next;
            }
        }
        return null;
    }

    UFTBaseTask f(long j3) {
        Iterator<UFTBaseTask> it = this.f305700c.iterator();
        while (it.hasNext()) {
            UFTBaseTask next = it.next();
            if (next.d() == j3) {
                it.remove();
                c.c("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] delWaitTask:" + j3 + n());
                return next;
            }
        }
        return null;
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f305698a;
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.f305700c.size();
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f305701d.size() >= this.f305699b) {
            return true;
        }
        return false;
    }

    protected void l(UFTBaseTask uFTBaseTask) {
        throw null;
    }

    protected void m(UFTBaseTask uFTBaseTask) {
        throw null;
    }

    void o() {
        if (j()) {
            return;
        }
        c.c("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] runNext...");
        UFTBaseTask g16 = g();
        if (g16 != null) {
            if (g16.j()) {
                this.f305701d.add(g16);
                m(g16);
                return;
            }
            c.b("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] task start fail. taskId:" + g16.d());
            c();
            return;
        }
        c.c("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] current is no waiting task that can run.");
    }

    public void p(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        c.c("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] stopAll");
        Iterator<UFTBaseTask> it = this.f305700c.iterator();
        while (it.hasNext()) {
            it.next().k(bundle);
        }
        Iterator<UFTBaseTask> it5 = this.f305701d.iterator();
        while (it5.hasNext()) {
            UFTBaseTask next = it5.next();
            next.k(bundle);
            l(next);
        }
        this.f305700c.clear();
        this.f305701d.clear();
    }

    public void q(long j3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), bundle);
            return;
        }
        c.c("[UFTTransfer] UFTTaskQueue", 1, "QID[" + this.f305698a + "] stopTask:" + j3);
        UFTBaseTask f16 = f(j3);
        if (f16 != null) {
            f16.k(bundle);
            return;
        }
        UFTBaseTask e16 = e(j3);
        if (e16 != null) {
            e16.k(bundle);
            l(e16);
            c();
        }
    }
}
