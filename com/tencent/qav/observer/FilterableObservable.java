package com.tencent.qav.observer;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.List;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FilterableObservable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<a> f342404a;

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f342405b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f342406c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f342407d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilterableObservable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f342404a = new Vector();
        this.f342405b = new Vector();
        if (this.f342406c == null) {
            this.f342406c = new Handler(Looper.getMainLooper());
        }
        if (this.f342407d == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FilterableObservable-bg-thread");
            baseHandlerThread.start();
            this.f342407d = new Handler(baseHandlerThread.getLooper());
        }
    }

    private void c(a aVar, Handler handler, int i3, Object... objArr) {
        handler.post(new Runnable(aVar, i3, objArr) { // from class: com.tencent.qav.observer.FilterableObservable.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f342408d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f342409e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Object[] f342410f;

            {
                this.f342408d = aVar;
                this.f342409e = i3;
                this.f342410f = objArr;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, FilterableObservable.this, aVar, Integer.valueOf(i3), objArr);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f342408d.a(this.f342409e, this.f342410f);
                }
            }
        });
    }

    public synchronized void a(a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, aVar, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            this.f342405b.add(aVar);
        } else {
            this.f342404a.add(aVar);
        }
    }

    public synchronized void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f342404a.clear();
        this.f342405b.clear();
        Handler handler = this.f342407d;
        if (handler != null) {
            handler.getLooper().quit();
        }
        this.f342406c = null;
        this.f342407d = null;
    }

    public void d(Class<? extends a> cls, int i3, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, cls, Integer.valueOf(i3), objArr);
            return;
        }
        synchronized (this.f342404a) {
            for (a aVar : this.f342404a) {
                if (cls != null && aVar != null && cls.isAssignableFrom(aVar.getClass())) {
                    c(aVar, this.f342406c, i3, objArr);
                }
            }
        }
        synchronized (this.f342405b) {
            for (a aVar2 : this.f342405b) {
                if (cls != null && aVar2 != null && cls.isAssignableFrom(aVar2.getClass())) {
                    c(aVar2, this.f342407d, i3, objArr);
                }
            }
        }
    }

    public synchronized void e(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null) {
            this.f342404a.remove(aVar);
            this.f342405b.remove(aVar);
        }
    }
}
