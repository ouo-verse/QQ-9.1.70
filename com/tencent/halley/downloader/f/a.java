package com.tencent.halley.downloader.f;

import com.tencent.halley.common.a.a.d;
import com.tencent.halley.common.a.f;
import com.tencent.halley.common.utils.j;
import com.tencent.halley.downloader.DownloaderTaskCategory;
import com.tencent.halley.downloader.f.a.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f113742c;

    /* renamed from: a, reason: collision with root package name */
    public d f113743a;

    /* renamed from: b, reason: collision with root package name */
    public d f113744b;

    /* renamed from: d, reason: collision with root package name */
    private Map<DownloaderTaskCategory, b> f113745d;

    /* renamed from: e, reason: collision with root package name */
    private Map<DownloaderTaskCategory, Integer> f113746e;

    /* renamed from: f, reason: collision with root package name */
    private d f113747f;

    /* compiled from: P */
    /* renamed from: com.tencent.halley.downloader.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1244a implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Future<?> f113750a;

        public C1244a(Future<?> future) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) future);
            } else {
                this.f113750a = future;
            }
        }

        @Override // com.tencent.halley.common.a.f
        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            Future<?> future = this.f113750a;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15957);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f113742c = null;
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113745d = new HashMap();
            this.f113746e = new HashMap();
        }
    }

    public final f a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? new C1244a(this.f113747f.submit(runnable)) : (f) iPatchRedirector.redirect((short) 4, (Object) this, (Object) runnable);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        int i3 = 0;
        for (DownloaderTaskCategory downloaderTaskCategory : this.f113745d.keySet()) {
            if (downloaderTaskCategory != DownloaderTaskCategory.Cate_DefaultEase) {
                i3 += this.f113745d.get(downloaderTaskCategory).getMaximumPoolSize();
            }
        }
        if (i3 == 0) {
            i3 = 2;
        }
        d dVar = this.f113744b;
        if (dVar == null) {
            com.tencent.halley.common.a.a.b bVar = new com.tencent.halley.common.a.a.b((byte) 0);
            int i16 = (i3 * 2) + 1;
            d dVar2 = new d(0, i16, TimeUnit.SECONDS, bVar, new com.tencent.halley.common.a.a.a("HallyDownload-HijackPool"));
            this.f113744b = dVar2;
            bVar.f113204a = dVar2;
            com.tencent.halley.common.utils.d.a("halley-downloader-ThreadPoolHolder", "create thread pool for Hijack Task, cur num:" + i16, true);
            return;
        }
        dVar.setMaximumPoolSize((i3 * 2) + 1);
    }

    public final synchronized f a(Runnable runnable, DownloaderTaskCategory downloaderTaskCategory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable, (Object) downloaderTaskCategory);
        }
        b bVar = this.f113745d.get(downloaderTaskCategory);
        if (bVar == null) {
            bVar = a(downloaderTaskCategory);
        }
        return new C1244a(bVar.submit(runnable));
    }

    private synchronized b a(DownloaderTaskCategory downloaderTaskCategory) {
        b bVar;
        Integer num = this.f113746e.get(downloaderTaskCategory);
        int a16 = j.a(num == null ? downloaderTaskCategory == DownloaderTaskCategory.Cate_DefaultEase ? 3 : 2 : num.intValue(), 1, 20);
        bVar = this.f113745d.get(downloaderTaskCategory);
        if (bVar == null) {
            com.tencent.halley.downloader.f.a.a aVar = new com.tencent.halley.downloader.f.a.a();
            b bVar2 = new b(a16, TimeUnit.SECONDS, aVar, new com.tencent.halley.common.a.a.a(downloaderTaskCategory.name()));
            aVar.f113748a = bVar2;
            this.f113745d.put(downloaderTaskCategory, bVar2);
            com.tencent.halley.common.utils.d.a("halley-downloader-ThreadPoolHolder", "create thread pool for category:" + downloaderTaskCategory + ",num:" + a16, true);
            bVar = bVar2;
        } else {
            int maximumPoolSize = a16 - bVar.getMaximumPoolSize();
            bVar.setMaximumPoolSize(a16);
            com.tencent.halley.common.utils.d.a("halley-downloader-ThreadPoolHolder", "update thread pool for category:" + downloaderTaskCategory + ",num:" + a16, true);
            a16 = maximumPoolSize;
        }
        d dVar = this.f113743a;
        if (dVar == null) {
            com.tencent.halley.common.a.a.b bVar3 = new com.tencent.halley.common.a.a.b((byte) 0);
            int i3 = (a16 <= 0 ? 1 : a16) + 1;
            d dVar2 = new d(0, i3, TimeUnit.SECONDS, bVar3, new com.tencent.halley.common.a.a.a("HallyDownload-DirectPool"));
            this.f113743a = dVar2;
            bVar3.f113204a = dVar2;
            com.tencent.halley.common.utils.d.a("halley-downloader-ThreadPoolHolder", "create thread pool for Direct Download, cur num:" + i3, true);
        } else {
            int maximumPoolSize2 = dVar.getMaximumPoolSize() + a16;
            this.f113743a.setMaximumPoolSize(maximumPoolSize2);
            com.tencent.halley.common.utils.d.a("halley-downloader-ThreadPoolHolder", "update thread pool for Direct Download, cur num:" + maximumPoolSize2, true);
        }
        if (downloaderTaskCategory != DownloaderTaskCategory.Cate_DefaultEase) {
            a(a16);
        }
        if (this.f113744b != null) {
            b();
        }
        return bVar;
    }

    public static a a() {
        if (f113742c == null) {
            synchronized (a.class) {
                if (f113742c == null) {
                    f113742c = new a();
                }
            }
        }
        return f113742c;
    }

    public final void a(int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        d dVar = this.f113747f;
        if (dVar == null) {
            com.tencent.halley.common.a.a.b bVar = new com.tencent.halley.common.a.a.b((byte) 0);
            if (i3 <= 0) {
                i3 = 1;
            }
            int i16 = i3 + 1;
            d dVar2 = new d(0, i16, TimeUnit.SECONDS, bVar, new com.tencent.halley.common.a.a.a("HallyDownload-SchedulePool"));
            this.f113747f = dVar2;
            bVar.f113204a = dVar2;
            str = "create thread pool for Schedule Download, cur num:" + i16;
        } else {
            int maximumPoolSize = dVar.getMaximumPoolSize() + i3;
            this.f113747f.setMaximumPoolSize(maximumPoolSize);
            str = "update thread pool for Schedule Download, cur num:" + maximumPoolSize;
        }
        com.tencent.halley.common.utils.d.a("halley-downloader-ThreadPoolHolder", str, true);
    }

    public final synchronized void a(DownloaderTaskCategory downloaderTaskCategory, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloaderTaskCategory, i3);
            return;
        }
        if (downloaderTaskCategory == null || i3 <= 0) {
            return;
        }
        int a16 = j.a(i3, 1, 20);
        com.tencent.halley.common.utils.d.a("halley-downloader-ThreadPoolHolder_qqq", downloaderTaskCategory + " - final setTaskNum:" + a16, true);
        this.f113746e.put(downloaderTaskCategory, Integer.valueOf(a16));
        if (this.f113745d.get(downloaderTaskCategory) != null) {
            a(downloaderTaskCategory);
        }
    }
}
