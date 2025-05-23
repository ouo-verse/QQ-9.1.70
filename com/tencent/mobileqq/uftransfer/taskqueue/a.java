package com.tencent.mobileqq.uftransfer.taskqueue;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.depend.c;
import com.tencent.mobileqq.uftransfer.task.UFTBaseTask;
import com.tencent.mobileqq.uftransfer.task.upload.d;
import com.tencent.mobileqq.uftransfer.taskqueue.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends UFTTaskQueue {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uftransfer.taskqueue.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8874a extends b.a {
        static IPatchRedirector $redirector_;

        C8874a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.uftransfer.taskqueue.b.a
        protected void a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
            } else if (i3 != a.this.h() && a.this.i() > 0 && !a.this.j()) {
                a.this.c();
            }
        }
    }

    public a(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            b.c().addObserver(new C8874a());
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.taskqueue.UFTTaskQueue
    public void b(UFTBaseTask uFTBaseTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uFTBaseTask);
        } else if (uFTBaseTask instanceof d) {
            super.b(uFTBaseTask);
        } else {
            c.b("[UFTTransfer] UFTUploadTaskQueue", 1, "add task fail. task must is subclass of UFTBaseUploadTask");
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.taskqueue.UFTTaskQueue
    protected boolean d(UFTBaseTask uFTBaseTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uFTBaseTask)).booleanValue();
        }
        return !b.c().b(((d) uFTBaseTask).r());
    }

    @Override // com.tencent.mobileqq.uftransfer.taskqueue.UFTTaskQueue
    protected void l(UFTBaseTask uFTBaseTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uFTBaseTask);
        } else {
            b.c().d(((d) uFTBaseTask).r(), h());
        }
    }

    @Override // com.tencent.mobileqq.uftransfer.taskqueue.UFTTaskQueue
    protected void m(UFTBaseTask uFTBaseTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uFTBaseTask);
        } else {
            b.c().a(((d) uFTBaseTask).r());
        }
    }
}
