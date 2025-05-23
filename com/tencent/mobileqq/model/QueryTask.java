package com.tencent.mobileqq.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.api.QueryCallback;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QueryTask<Param, Result> implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private Param f247227d;

    /* renamed from: e, reason: collision with root package name */
    public a<Param, Result> f247228e;

    /* renamed from: f, reason: collision with root package name */
    public QueryCallback<Result> f247229f;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a<P, R> {
        R query(P p16);
    }

    public QueryTask(a<Param, Result> aVar, QueryCallback<Result> queryCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) queryCallback);
        } else {
            this.f247228e = aVar;
            this.f247229f = queryCallback;
        }
    }

    public void a(Param param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) param);
        } else {
            this.f247227d = param;
            ThreadManagerV2.excute(this, 32, null, true);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable(this.f247228e.query(this.f247227d)) { // from class: com.tencent.mobileqq.model.QueryTask.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Object f247230d;

                {
                    this.f247230d = r5;
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
                        QueryTask.this.f247229f.postQuery(this.f247230d);
                    }
                }
            });
        }
    }
}
