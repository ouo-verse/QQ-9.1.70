package com.tencent.tedger.resource;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tedgecontext.b;
import com.tencent.tedger.outapi.utils.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Semaphore;
import ve4.m;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ResourceManagerImp extends b implements m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f375288a;

    /* compiled from: P */
    /* renamed from: com.tencent.tedger.resource.ResourceManagerImp$6, reason: invalid class name */
    /* loaded from: classes26.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Semaphore f375297d;

        /* compiled from: P */
        /* renamed from: com.tencent.tedger.resource.ResourceManagerImp$6$a */
        /* loaded from: classes26.dex */
        class a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                }
            }
        }

        AnonymousClass6(m.a aVar, Semaphore semaphore) {
            this.f375297d = semaphore;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ResourceManagerImp.this, aVar, semaphore);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                new a();
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Handler f375300a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f375301b;

        public a(Handler handler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResourceManagerImp.this, (Object) handler);
            } else {
                this.f375301b = false;
                this.f375300a = handler;
            }
        }
    }

    public ResourceManagerImp(com.tencent.tedgecontext.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f375288a = new HashMap();
        }
    }

    private void H(a aVar, Runnable runnable) {
        Handler handler;
        if (aVar != null && (handler = aVar.f375300a) != null) {
            handler.post(new Runnable(aVar, runnable) { // from class: com.tencent.tedger.resource.ResourceManagerImp.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f375293d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Runnable f375294e;

                {
                    this.f375293d = aVar;
                    this.f375294e = runnable;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ResourceManagerImp.this, aVar, runnable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    synchronized (this.f375293d) {
                        this.f375293d.f375301b = true;
                        this.f375294e.run();
                        this.f375293d.f375301b = false;
                    }
                }
            });
        } else {
            this.mLog.e("ResourceManager", 4, "async run thread fail with null handler.");
        }
    }

    private void I(a aVar, Runnable runnable, long j3) {
        aVar.f375300a.postDelayed(new Runnable(aVar, runnable) { // from class: com.tencent.tedger.resource.ResourceManagerImp.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ a f375291d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Runnable f375292e;

            {
                this.f375291d = aVar;
                this.f375292e = runnable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ResourceManagerImp.this, aVar, runnable);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (this.f375291d) {
                    this.f375291d.f375301b = true;
                    this.f375292e.run();
                    this.f375291d.f375301b = false;
                }
            }
        }, j3);
    }

    private Handler J(String str, int i3, Handler.Callback callback) {
        a.C9901a c9901a = new a.C9901a();
        Handler a16 = com.tencent.tedger.outapi.utils.a.a(str, i3, callback, c9901a);
        if (a16 == null) {
            this.mLog.e("ResourceManager", 4, c9901a.f375277a);
        }
        return a16;
    }

    private a K(String str) {
        return L(str, null);
    }

    private a L(String str, Handler.Callback callback) {
        a aVar;
        String M = M(str);
        synchronized (this) {
            if (!this.f375288a.containsKey(M)) {
                this.f375288a.put(M, new a(J(M, 0, callback)));
            }
            aVar = this.f375288a.get(M);
        }
        return aVar;
    }

    private String M(String str) {
        return str + "_" + getContext().c();
    }

    private void N(a aVar, Runnable runnable) {
        if (Looper.myLooper().equals(aVar.f375300a.getLooper())) {
            runnable.run();
            return;
        }
        synchronized (aVar) {
            if (aVar.f375301b) {
                this.mLog.f("ResourceManager", 4, "can't sync run thread in the thread self.");
                return;
            }
            aVar.f375301b = true;
            try {
                Semaphore semaphore = new Semaphore(0, true);
                aVar.f375300a.post(new Runnable(runnable, semaphore) { // from class: com.tencent.tedger.resource.ResourceManagerImp.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Runnable f375289d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ Semaphore f375290e;

                    {
                        this.f375289d = runnable;
                        this.f375290e = semaphore;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, ResourceManagerImp.this, runnable, semaphore);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.f375289d.run();
                            this.f375290e.release();
                        }
                    }
                });
                semaphore.acquire();
            } catch (InterruptedException unused) {
            }
            synchronized (aVar) {
                aVar.f375301b = false;
            }
        }
    }

    @Override // ve4.m
    public String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return getContext().j().a() + "/SO";
    }

    @Override // com.tencent.tedgecontext.b, ve4.m
    public void asyncRunInRequestThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) runnable);
        } else {
            H(K("TEdgeRSRequest"), runnable);
        }
    }

    @Override // ve4.m
    public void l(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) runnable);
        } else {
            H(K("TEdgeRSMain"), runnable);
        }
    }

    @Override // ve4.m
    public void m(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) runnable);
        } else {
            H(K("TEdgeRSTraining"), runnable);
        }
    }

    @Override // ve4.m
    public void onDestroy() {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        try {
            Iterator<String> it = this.f375288a.keySet().iterator();
            while (it.hasNext()) {
                a aVar = this.f375288a.get(it.next());
                if (aVar != null && (handler = aVar.f375300a) != null) {
                    handler.removeCallbacksAndMessages(null);
                    aVar.f375300a.getLooper().quitSafely();
                }
            }
            this.f375288a.clear();
        } catch (Exception e16) {
            this.mLog.e("ResourceManager", 4, "onDestroy fail with exception: " + e16);
        }
    }

    @Override // com.tencent.tedgecontext.b, ve4.m
    public void syncRunInRequestThread(m.a aVar, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, aVar, Long.valueOf(j3));
            return;
        }
        try {
            if (j3 <= 0) {
                N(K("TEdgeRSRequest"), new Runnable(aVar) { // from class: com.tencent.tedger.resource.ResourceManagerImp.4
                    static IPatchRedirector $redirector_;

                    /* compiled from: P */
                    /* renamed from: com.tencent.tedger.resource.ResourceManagerImp$4$a */
                    /* loaded from: classes26.dex */
                    class a {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }
                    }

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ResourceManagerImp.this, (Object) aVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            new a();
                            throw null;
                        }
                    }
                });
                return;
            }
            Semaphore semaphore = new Semaphore(0, true);
            I(K("TEdgeRSRequest"), new Runnable(aVar, semaphore) { // from class: com.tencent.tedger.resource.ResourceManagerImp.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Semaphore f375296d;

                {
                    this.f375296d = semaphore;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ResourceManagerImp.this, aVar, semaphore);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    throw null;
                }
            }, j3);
            asyncRunInRequestThread(new AnonymousClass6(aVar, semaphore));
            semaphore.acquire();
        } catch (InterruptedException e16) {
            this.mLog.e("ResourceManager", 4, "sync run thread fail with exception: " + e16.toString());
        }
    }
}
