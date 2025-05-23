package com.tencent.qqnt.emotion;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes24.dex */
public class QueryTask<Param, Result> implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Param f356123d;

    /* renamed from: e, reason: collision with root package name */
    public a<Param, Result> f356124e;

    /* renamed from: f, reason: collision with root package name */
    public c<Result> f356125f;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public interface a<P, R> {
        R query(P p16);
    }

    public QueryTask(a<Param, Result> aVar, c<Result> cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) cVar);
        } else {
            this.f356124e = aVar;
            this.f356125f = cVar;
        }
    }

    public void a(Param param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) param);
        } else {
            this.f356123d = param;
            ThreadManagerV2.excute(this, 32, null, true);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(this.f356124e.query(this.f356123d)) { // from class: com.tencent.qqnt.emotion.QueryTask.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Object f356126d;

                {
                    this.f356126d = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QueryTask.this, r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QueryTask.this.f356125f.postQuery(this.f356126d);
                    }
                }
            });
        }
    }
}
