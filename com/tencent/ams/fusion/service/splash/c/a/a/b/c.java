package com.tencent.ams.fusion.service.splash.c.a.a.b;

import android.text.TextUtils;
import com.tencent.ams.fusion.a.f;
import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.resdownload.ResRequest;
import com.tencent.ams.fusion.service.resdownload.d;
import com.tencent.ams.fusion.service.splash.c.a.a.b;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected SplashOrder f70414a;

    /* renamed from: b, reason: collision with root package name */
    protected a f70415b;

    /* renamed from: c, reason: collision with root package name */
    protected String f70416c;

    /* renamed from: d, reason: collision with root package name */
    protected long f70417d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f70418e;

    /* renamed from: f, reason: collision with root package name */
    protected AtomicBoolean f70419f;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(int i3, boolean z16);

        void a(boolean z16, int i3);

        void a_();

        void f();

        void g();

        void h(com.tencent.ams.fusion.service.resdownload.b bVar, boolean z16, int i3);

        void i(boolean z16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public SplashOrder f70425a;

        /* renamed from: b, reason: collision with root package name */
        public a f70426b;

        /* renamed from: c, reason: collision with root package name */
        public String f70427c;

        /* renamed from: d, reason: collision with root package name */
        public long f70428d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f70425a = null;
            this.f70426b = null;
            this.f70427c = null;
            this.f70428d = 5000L;
        }
    }

    public c(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            return;
        }
        this.f70414a = null;
        this.f70415b = null;
        this.f70416c = null;
        this.f70417d = 5000L;
        this.f70418e = false;
        this.f70419f = new AtomicBoolean(false);
        if (bVar != null) {
            this.f70414a = bVar.f70425a;
            this.f70415b = bVar.f70426b;
            this.f70416c = bVar.f70427c;
            this.f70417d = bVar.f70428d;
        }
        if (c() == 1) {
            this.f70418e = true;
        }
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(List<com.tencent.ams.fusion.service.splash.b.a.a> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, Boolean.valueOf(z16));
            return;
        }
        if (j.b(list)) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        for (com.tencent.ams.fusion.service.splash.b.a.a aVar : list) {
            if (aVar != null && !TextUtils.isEmpty(aVar.a())) {
                f.j("ResourceCompensationDownloadTask", " begin download: " + aVar.a());
                File b16 = com.tencent.ams.fusion.a.b.b(aVar.c());
                if (b16 == null) {
                    f.h("ResourceCompensationDownloadTask", " cacheDir == null");
                    countDownLatch.countDown();
                } else {
                    com.tencent.ams.fusion.service.b.b().g().b(new Runnable(new d(aVar.a(), b16.getAbsolutePath(), aVar.c(), this.f70414a), aVar, countDownLatch, z16) { // from class: com.tencent.ams.fusion.service.splash.c.a.a.b.c.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ResRequest f70420d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ com.tencent.ams.fusion.service.splash.b.a.a f70421e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ CountDownLatch f70422f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ boolean f70423h;

                        {
                            this.f70420d = r6;
                            this.f70421e = aVar;
                            this.f70422f = countDownLatch;
                            this.f70423h = z16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, c.this, r6, aVar, countDownLatch, Boolean.valueOf(z16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                com.tencent.ams.fusion.service.b.b().i().a(this.f70420d, new b.d(this.f70421e, this.f70422f, c.this.f70415b, this.f70423h));
                            }
                        }
                    });
                }
            } else {
                f.h("ResourceCompensationDownloadTask", " download return no url");
                countDownLatch.countDown();
            }
        }
        try {
            countDownLatch.await(this.f70417d, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e16) {
            f.c("ResourceCompensationDownloadTask", "countDown error:", e16);
        }
    }

    protected abstract int c();

    protected boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f70414a != null && this.f70415b != null && !TextUtils.isEmpty(this.f70416c)) {
            return true;
        }
        return false;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f70419f.compareAndSet(false, true);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!d()) {
            a aVar = this.f70415b;
            if (aVar != null) {
                aVar.a(1, true);
                return;
            }
            return;
        }
        a();
    }
}
