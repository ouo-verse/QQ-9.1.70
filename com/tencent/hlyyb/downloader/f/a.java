package com.tencent.hlyyb.downloader.f;

import com.tencent.hlyyb.common.a.a;
import com.tencent.hlyyb.common.a.f;
import com.tencent.hlyyb.common.a.g;
import com.tencent.hlyyb.downloader.DownloaderTaskCategory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static a f114641f;

    /* renamed from: a, reason: collision with root package name */
    public Map<DownloaderTaskCategory, c> f114642a;

    /* renamed from: b, reason: collision with root package name */
    public Map<DownloaderTaskCategory, Integer> f114643b;

    /* renamed from: c, reason: collision with root package name */
    public g f114644c;

    /* renamed from: d, reason: collision with root package name */
    public g f114645d;

    /* renamed from: e, reason: collision with root package name */
    public g f114646e;

    /* compiled from: P */
    /* renamed from: com.tencent.hlyyb.downloader.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5822a implements com.tencent.hlyyb.common.a.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Future<?> f114647a;

        public C5822a(Future<?> future) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) future);
            } else {
                this.f114647a = future;
            }
        }

        @Override // com.tencent.hlyyb.common.a.d
        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            Future<?> future = this.f114647a;
            if (future != null) {
                try {
                    return future.cancel(false);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12662);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f114641f = new a();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f114642a = new HashMap();
            this.f114643b = new HashMap();
        }
    }

    public final com.tencent.hlyyb.common.a.d a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? new C5822a(this.f114644c.submit(runnable)) : (com.tencent.hlyyb.common.a.d) iPatchRedirector.redirect((short) 5, (Object) this, (Object) runnable);
    }

    public final com.tencent.hlyyb.common.a.d b(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? new C5822a(this.f114645d.submit(runnable)) : (com.tencent.hlyyb.common.a.d) iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
    }

    public final com.tencent.hlyyb.common.a.d c(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.hlyyb.common.a.d) iPatchRedirector.redirect((short) 7, (Object) this, (Object) runnable);
        }
        if (this.f114646e == null) {
            b();
        }
        return new C5822a(this.f114646e.submit(runnable));
    }

    private void b() {
        int i3 = 0;
        for (DownloaderTaskCategory downloaderTaskCategory : this.f114642a.keySet()) {
            if (downloaderTaskCategory != DownloaderTaskCategory.Cate_DefaultEase) {
                i3 += this.f114642a.get(downloaderTaskCategory).getMaximumPoolSize();
            }
        }
        if (i3 == 0) {
            i3 = 2;
        }
        g gVar = this.f114646e;
        if (gVar != null) {
            gVar.setMaximumPoolSize((i3 << 1) + 1);
            return;
        }
        a.c cVar = new a.c(16);
        g gVar2 = new g(0, (i3 << 1) + 1, 5L, TimeUnit.SECONDS, cVar, new f("HallyDownload-HijackPool"));
        this.f114646e = gVar2;
        cVar.a(gVar2);
    }

    public final synchronized com.tencent.hlyyb.common.a.d a(Runnable runnable, DownloaderTaskCategory downloaderTaskCategory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.hlyyb.common.a.d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable, (Object) downloaderTaskCategory);
        }
        c cVar = this.f114642a.get(downloaderTaskCategory);
        if (cVar == null) {
            cVar = a(downloaderTaskCategory);
        }
        return new C5822a(cVar.submit(runnable));
    }

    public static a a() {
        return f114641f;
    }

    private synchronized c a(DownloaderTaskCategory downloaderTaskCategory) {
        c cVar;
        Integer num = this.f114643b.get(downloaderTaskCategory);
        int a16 = com.tencent.hlyyb.common.b.b.a(num == null ? downloaderTaskCategory == DownloaderTaskCategory.Cate_DefaultEase ? 3 : 2 : num.intValue(), 1, 5);
        cVar = this.f114642a.get(downloaderTaskCategory);
        if (cVar == null) {
            b bVar = new b(64);
            c cVar2 = new c(0, a16, 5L, TimeUnit.SECONDS, bVar, new f(downloaderTaskCategory.name()));
            bVar.a(cVar2);
            this.f114642a.put(downloaderTaskCategory, cVar2);
            cVar = cVar2;
        } else {
            int maximumPoolSize = a16 - cVar.getMaximumPoolSize();
            cVar.setMaximumPoolSize(a16);
            a16 = maximumPoolSize;
        }
        g gVar = this.f114644c;
        if (gVar == null) {
            a.c cVar3 = new a.c(16);
            g gVar2 = new g(0, (a16 <= 0 ? 1 : a16) + 1, 5L, TimeUnit.SECONDS, cVar3, new f("HallyDownload-DirectPool"));
            this.f114644c = gVar2;
            cVar3.a(gVar2);
        } else {
            this.f114644c.setMaximumPoolSize(gVar.getMaximumPoolSize() + a16);
        }
        if (downloaderTaskCategory != DownloaderTaskCategory.Cate_DefaultEase) {
            g gVar3 = this.f114645d;
            if (gVar3 == null) {
                a.c cVar4 = new a.c(16);
                if (a16 <= 0) {
                    a16 = 1;
                }
                g gVar4 = new g(0, a16 + 1, 5L, TimeUnit.SECONDS, cVar4, new f("HallyDownload-SchedulePool"));
                this.f114645d = gVar4;
                cVar4.a(gVar4);
            } else {
                this.f114645d.setMaximumPoolSize(gVar3.getMaximumPoolSize() + a16);
            }
        }
        if (this.f114646e != null) {
            b();
        }
        return cVar;
    }

    public final synchronized void a(DownloaderTaskCategory downloaderTaskCategory, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloaderTaskCategory, i3);
            return;
        }
        if (downloaderTaskCategory == null || i3 <= 0) {
            return;
        }
        this.f114643b.put(downloaderTaskCategory, Integer.valueOf(com.tencent.hlyyb.common.b.b.a(i3, 1, 5)));
        if (this.f114642a.get(downloaderTaskCategory) != null) {
            a(downloaderTaskCategory);
        }
    }
}
