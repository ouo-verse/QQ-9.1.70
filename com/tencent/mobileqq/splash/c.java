package com.tencent.mobileqq.splash;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f288710a;

    /* renamed from: b, reason: collision with root package name */
    public Object f288711b;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(long j3);

        void b(c cVar);

        void c(long j3);

        void onDurationUpdate(long j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        } else {
            this.f288711b = obj;
        }
    }

    public abstract void a(a aVar);

    public abstract void b();

    public abstract void c();
}
