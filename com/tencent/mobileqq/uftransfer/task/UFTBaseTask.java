package com.tencent.mobileqq.uftransfer.task;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.depend.c;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class UFTBaseTask {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final AppRuntime f305357a;

    /* renamed from: b, reason: collision with root package name */
    protected final com.tencent.mobileqq.uftransfer.api.impl.a f305358b;

    /* renamed from: c, reason: collision with root package name */
    protected final com.tencent.mobileqq.uftransfer.task.taskinfo.a f305359c;

    /* renamed from: d, reason: collision with root package name */
    private final a f305360d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f305361e;

    /* JADX INFO: Access modifiers changed from: protected */
    public UFTBaseTask(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar2, a aVar3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, aVar, aVar2, aVar3);
            return;
        }
        this.f305361e = true;
        this.f305357a = appRuntime;
        this.f305358b = aVar;
        this.f305359c = aVar2;
        this.f305360d = aVar3;
    }

    public static boolean c(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.api.impl.a aVar, com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar2, a aVar3, String str) {
        if (appRuntime == null) {
            c.b(str, 1, "task.app is null");
            return false;
        }
        if (aVar == null) {
            c.b(str, 1, "task.transfer key is null");
            return false;
        }
        if (aVar2 == null) {
            c.b(str, 1, "task.task info is null");
            return false;
        }
        if (aVar3 != null) {
            return true;
        }
        c.b(str, 1, "task.task callback is null");
        return false;
    }

    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar = this.f305359c;
        if (aVar != null) {
            return aVar.i();
        }
        return 0L;
    }

    protected UFTBaseTask e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (UFTBaseTask) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this;
    }

    public abstract boolean f(UFTBaseTask uFTBaseTask);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        this.f305361e = true;
        i(3);
        com.tencent.mobileqq.uftransfer.a.a().d(new Runnable(i3) { // from class: com.tencent.mobileqq.uftransfer.task.UFTBaseTask.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f305362d;

            {
                this.f305362d = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UFTBaseTask.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    UFTBaseTask.this.f305360d.a(UFTBaseTask.this.e(), this.f305362d);
                }
            }
        });
    }

    protected abstract boolean h();

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        com.tencent.mobileqq.uftransfer.task.taskinfo.a aVar = this.f305359c;
        if (aVar != null) {
            aVar.m(i3);
        }
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        this.f305361e = false;
        i(2);
        return h();
    }

    public void k(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        } else {
            this.f305361e = true;
            i(3);
        }
    }
}
