package com.tencent.ams.fusion.service.splash.b.b;

import android.text.TextUtils;
import com.tencent.ams.fusion.a.i;
import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.splash.b.b.a.b;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.luggage.wxa.yf.t;
import com.tencent.luggage.wxa.yf.u;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements kt.b<nt.f, nt.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private nt.f f70373a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.data.a f70374b;

    /* renamed from: c, reason: collision with root package name */
    private List<com.tencent.ams.fusion.service.splash.b.b.a.a> f70375c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements Comparator<com.tencent.ams.fusion.service.splash.b.b.a.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.ams.fusion.service.splash.b.b.a.a aVar, com.tencent.ams.fusion.service.splash.b.b.a.a aVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return d.this.a(aVar, aVar2);
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2)).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b implements com.tencent.ams.fusion.service.resdownload.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f70381a;

        /* renamed from: b, reason: collision with root package name */
        private nt.a f70382b;

        /* renamed from: c, reason: collision with root package name */
        private final AtomicInteger f70383c;

        /* renamed from: d, reason: collision with root package name */
        private int f70384d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f70385e;

        /* renamed from: f, reason: collision with root package name */
        private long f70386f;

        public b(WeakReference<d> weakReference, nt.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) weakReference, (Object) aVar);
                return;
            }
            this.f70383c = new AtomicInteger();
            this.f70384d = com.tencent.ams.fusion.service.splash.a.a.d().p();
            this.f70386f = 0L;
            this.f70382b = aVar;
            this.f70381a = weakReference;
            this.f70386f = System.currentTimeMillis();
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void c() {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("download onPaused ");
            nt.a aVar = this.f70382b;
            if (aVar != null) {
                str = aVar.a();
            } else {
                str = "";
            }
            sb5.append(str);
            com.tencent.ams.fusion.a.f.j("PreloadResourceDownloadTask", sb5.toString());
            if (com.tencent.ams.fusion.service.splash.a.a.d().a()) {
                i3 = LocaleManager.MOBILE_COUNTRY_CODE_CN_INT;
            } else {
                i3 = 461;
            }
            d.q(i3, (com.tencent.ams.fusion.service.splash.b.b.a.a) this.f70382b, -104, System.currentTimeMillis() - this.f70386f);
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void d() {
            String str;
            d dVar;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("download onCanceled ");
            nt.a aVar = this.f70382b;
            if (aVar != null) {
                str = aVar.a();
            } else {
                str = "";
            }
            sb5.append(str);
            com.tencent.ams.fusion.a.f.j("PreloadResourceDownloadTask", sb5.toString());
            WeakReference<d> weakReference = this.f70381a;
            if (weakReference != null) {
                dVar = weakReference.get();
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.w();
            }
            if (com.tencent.ams.fusion.service.splash.a.a.d().a()) {
                i3 = 458;
            } else {
                i3 = u.CTRL_INDEX;
            }
            d.q(i3, (com.tencent.ams.fusion.service.splash.b.b.a.a) this.f70382b, -103, System.currentTimeMillis() - this.f70386f);
            com.tencent.ams.fusion.service.b.b().m().a(2, this.f70382b);
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void e() {
            String str;
            int i3;
            d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("download complete ");
            nt.a aVar = this.f70382b;
            String str2 = "";
            if (aVar == null) {
                str = "";
            } else {
                str = aVar.a();
            }
            sb5.append(str);
            com.tencent.ams.fusion.a.f.j("PreloadResourceDownloadTask", sb5.toString());
            this.f70385e = true;
            if (com.tencent.ams.fusion.service.splash.a.a.d().a()) {
                i3 = 457;
            } else {
                i3 = t.CTRL_INDEX;
            }
            d.q(i3, (com.tencent.ams.fusion.service.splash.b.b.a.a) this.f70382b, Integer.MIN_VALUE, System.currentTimeMillis() - this.f70386f);
            com.tencent.ams.fusion.service.splash.data.b m3 = com.tencent.ams.fusion.service.b.b().m();
            nt.a aVar2 = this.f70382b;
            if (aVar2 != null) {
                str2 = aVar2.a();
            }
            m3.a(str2);
            com.tencent.ams.fusion.service.b.b().m().a(1, this.f70382b);
            WeakReference<d> weakReference = this.f70381a;
            if (weakReference != null) {
                dVar = weakReference.get();
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.w();
            }
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void a(long j3, long j16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void a(long j3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Boolean.valueOf(z16));
        }

        @Override // com.tencent.ams.fusion.service.resdownload.a
        public void a(com.tencent.ams.fusion.service.resdownload.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("download onFailed ");
            nt.a aVar = this.f70382b;
            sb5.append(aVar != null ? aVar.a() : "");
            com.tencent.ams.fusion.a.f.j("PreloadResourceDownloadTask", sb5.toString());
            d.q(com.tencent.ams.fusion.service.splash.a.a.d().a() ? 458 : u.CTRL_INDEX, (com.tencent.ams.fusion.service.splash.b.b.a.a) this.f70382b, bVar != null ? bVar.c() : -99, System.currentTimeMillis() - this.f70386f);
            com.tencent.ams.fusion.service.b.b().m().a(3, this.f70382b);
            if (this.f70385e) {
                com.tencent.ams.fusion.a.f.h("PreloadResourceDownloadTask", "download onFailed :status error");
                return;
            }
            if (this.f70383c.incrementAndGet() <= this.f70384d) {
                com.tencent.ams.fusion.service.resdownload.c i3 = com.tencent.ams.fusion.service.b.b().i();
                lt.a g16 = com.tencent.ams.fusion.service.b.b().g();
                this.f70386f = System.currentTimeMillis();
                d.r(i3, g16, (com.tencent.ams.fusion.service.splash.b.b.a.a) this.f70382b, this);
                return;
            }
            WeakReference<d> weakReference = this.f70381a;
            d dVar = weakReference != null ? weakReference.get() : null;
            if (dVar != null) {
                dVar.w();
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.tencent.ams.fusion.service.splash.b.b.a.a aVar, com.tencent.ams.fusion.service.splash.b.b.a.a aVar2) {
        if (aVar == null && aVar2 == null) {
            return 0;
        }
        if (aVar != null && aVar2 != null) {
            return Integer.valueOf(aVar2.e()).compareTo(Integer.valueOf(aVar.e()));
        }
        if (aVar == null) {
            return 1;
        }
        return -1;
    }

    private Collection<com.tencent.ams.fusion.service.splash.b.b.a.a> d(Map<String, rt.a> map, String str) {
        Set<Map.Entry<String, rt.a>> set;
        rt.a aVar;
        if (map != null) {
            set = map.entrySet();
        } else {
            set = null;
        }
        if (set == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, rt.a> entry : set) {
            if (entry != null) {
                aVar = entry.getValue();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                m(aVar.b(), hashMap, str, entry.getKey(), true);
                k(aVar.c(), hashMap, str, entry.getKey());
                if (!j.b(aVar.d())) {
                    Iterator<SplashOrder> it = aVar.d().iterator();
                    while (it.hasNext()) {
                        k(it.next(), hashMap, str, entry.getKey());
                    }
                }
                if (!j.b(aVar.e())) {
                    Iterator<SplashOrder> it5 = aVar.e().iterator();
                    while (it5.hasNext()) {
                        k(it5.next(), hashMap, str, entry.getKey());
                    }
                }
            }
        }
        hashMap.remove(null);
        return hashMap.values();
    }

    private List<com.tencent.ams.fusion.service.splash.b.b.a.a> e(Collection<com.tencent.ams.fusion.service.splash.b.b.a.a> collection) {
        if (j.b(collection)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection);
        arrayList.removeAll(Collections.singleton(null));
        Collections.sort(arrayList, new a());
        try {
            return new CopyOnWriteArrayList(arrayList);
        } catch (Throwable th5) {
            com.tencent.ams.fusion.a.f.c("PreloadResourceDownloadTask", "[sortTaskModelByPriority]", th5);
            return null;
        }
    }

    private nt.b g(int i3) {
        b.c cVar = new b.c();
        cVar.b(i3);
        return cVar;
    }

    private void k(SplashOrder splashOrder, Map<String, com.tencent.ams.fusion.service.splash.b.b.a.a> map, String str, String str2) {
        m(splashOrder, map, str, str2, false);
    }

    private void l(SplashOrder splashOrder, Map<String, com.tencent.ams.fusion.service.splash.b.b.a.a> map, String str, String str2, List<com.tencent.ams.fusion.service.splash.b.a.a> list, boolean z16, boolean z17) {
        if (map != null && !j.b(list) && splashOrder != null && !splashOrder.bk()) {
            for (com.tencent.ams.fusion.service.splash.b.a.a aVar : list) {
                if (aVar != null && !TextUtils.isEmpty(aVar.a())) {
                    String a16 = aVar.a();
                    com.tencent.ams.fusion.service.splash.b.b.a.a aVar2 = new com.tencent.ams.fusion.service.splash.b.b.a.a(splashOrder, str, str2, aVar.c(), a16, aVar.b(), z16, z17);
                    if (map.containsKey(a16)) {
                        com.tencent.ams.fusion.service.splash.b.b.a.a aVar3 = map.get(a16);
                        if (aVar3 == null) {
                            map.put(a16, aVar2);
                        } else {
                            aVar3.b(Math.max(aVar3.e(), aVar2.e()));
                        }
                    } else {
                        map.put(a16, aVar2);
                    }
                }
            }
        }
    }

    private void m(SplashOrder splashOrder, Map<String, com.tencent.ams.fusion.service.splash.b.b.a.a> map, String str, String str2, boolean z16) {
        if (map != null && splashOrder != null && !splashOrder.bk()) {
            l(splashOrder, map, str, str2, i.h(splashOrder), z16, true);
            l(splashOrder, map, str, str2, i.j(splashOrder), z16, false);
        }
    }

    private void n(List<com.tencent.ams.fusion.service.splash.b.b.a.a> list) {
        if (j.b(list)) {
            com.tencent.ams.fusion.a.f.h("PreloadResourceDownloadTask", "[downloadPreloadResByPriority] taskModels == null");
        } else {
            this.f70375c = list;
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(int i3, com.tencent.ams.fusion.service.splash.b.b.a.a aVar, int i16, long j3) {
        if (aVar == null) {
            return;
        }
        com.tencent.ams.fusion.service.event.impl.b bVar = new com.tencent.ams.fusion.service.event.impl.b();
        bVar.f70286b = i3;
        bVar.f70287c = i16;
        bVar.f70288d.f70291a = aVar.i();
        bVar.f70288d.f70292b = aVar.h();
        bVar.f70288d.f70293c = aVar.f();
        bVar.f70289e.f70299a = aVar.b();
        bVar.f70290f.f70296c = aVar.a();
        bVar.f70290f.f70297d = aVar.c();
        bVar.f70290f.f70294a = j3;
        nt.d.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean r(com.tencent.ams.fusion.service.resdownload.c cVar, lt.a aVar, com.tencent.ams.fusion.service.splash.b.b.a.a aVar2, com.tencent.ams.fusion.service.resdownload.a aVar3) {
        int i3;
        int i16;
        if (cVar != null && aVar != null && aVar2 != null) {
            if (com.tencent.ams.fusion.service.splash.a.a.d().a()) {
                i3 = QFSNumberConstants.Int.NUM_456;
            } else {
                i3 = 452;
            }
            q(i3, aVar2, Integer.MIN_VALUE, 0L);
            File b16 = com.tencent.ams.fusion.a.b.b(aVar2.c());
            int i17 = 458;
            if (b16 != null && b16.isDirectory()) {
                File c16 = c(aVar2);
                if (c16 != null && c16.exists()) {
                    com.tencent.ams.fusion.a.f.h("PreloadResourceDownloadTask", "source cached : " + c16.getAbsolutePath());
                    if (com.tencent.ams.fusion.service.splash.a.a.d().a()) {
                        i16 = 459;
                    } else {
                        i16 = 455;
                    }
                    com.tencent.ams.fusion.service.b.b().m().a(aVar2.a());
                    q(i16, aVar2, Integer.MIN_VALUE, 0L);
                    return false;
                }
                if (!com.tencent.ams.fusion.service.b.b().m().a(aVar2.a(), aVar2.i(), aVar2.c())) {
                    com.tencent.ams.fusion.a.f.b("PreloadResourceDownloadTask", "start download filtered :" + aVar2.a() + "\n resType:" + aVar2.c());
                    if (!com.tencent.ams.fusion.service.splash.a.a.d().a()) {
                        i17 = 454;
                    }
                    q(i17, aVar2, -101, 0L);
                    return false;
                }
                aVar.d(new Runnable(b16, cVar, aVar3) { // from class: com.tencent.ams.fusion.service.splash.b.b.d.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ File f70377e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ com.tencent.ams.fusion.service.resdownload.c f70378f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ com.tencent.ams.fusion.service.resdownload.a f70379h;

                    {
                        this.f70377e = b16;
                        this.f70378f = cVar;
                        this.f70379h = aVar3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, com.tencent.ams.fusion.service.splash.b.b.a.a.this, b16, cVar, aVar3);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        com.tencent.ams.fusion.a.f.j("PreloadResourceDownloadTask", "start download ResType :" + com.tencent.ams.fusion.service.splash.b.b.a.a.this.c() + ", md5 :" + com.tencent.ams.fusion.service.splash.b.b.a.a.this.d() + ", url :" + com.tencent.ams.fusion.service.splash.b.b.a.a.this.a() + ", Priority :" + com.tencent.ams.fusion.service.splash.b.b.a.a.this.e());
                        com.tencent.ams.fusion.service.resdownload.d dVar = new com.tencent.ams.fusion.service.resdownload.d(com.tencent.ams.fusion.service.splash.b.b.a.a.this.a(), this.f70377e.getAbsolutePath(), com.tencent.ams.fusion.service.splash.b.b.a.a.this.c(), com.tencent.ams.fusion.service.splash.b.b.a.a.this.n());
                        dVar.b(com.tencent.ams.fusion.service.splash.b.b.a.a.this.d());
                        this.f70378f.a(dVar, this.f70379h);
                    }
                });
                return true;
            }
            com.tencent.ams.fusion.a.f.b("PreloadResourceDownloadTask", "execute, dir error return");
            if (!com.tencent.ams.fusion.service.splash.a.a.d().a()) {
                i17 = 454;
            }
            q(i17, aVar2, -100, 0L);
            return false;
        }
        com.tencent.ams.fusion.a.f.b("PreloadResourceDownloadTask", "[startSingleResourceDownload] error");
        return false;
    }

    private nt.b u() {
        com.tencent.ams.fusion.a.f.b("PreloadResourceDownloadTask", "[excuteInternal]");
        rt.c x16 = x();
        if (x16 == null) {
            com.tencent.ams.fusion.a.f.b("PreloadResourceDownloadTask", "[excuteInternal] preloadParseData == null");
            return g(2);
        }
        n(e(d(x16.a(), x16.b())));
        return new b.c();
    }

    private void v() {
        if (j.b(this.f70375c)) {
            com.tencent.ams.fusion.a.f.h("PreloadResourceDownloadTask", "[checkThreadAndDownload] taskModels == null");
            return;
        }
        int n3 = com.tencent.ams.fusion.service.splash.a.a.d().n();
        for (int i3 = 0; i3 < n3; i3++) {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        lt.a g16 = com.tencent.ams.fusion.service.b.b().g();
        com.tencent.ams.fusion.service.resdownload.c i3 = com.tencent.ams.fusion.service.b.b().i();
        List<com.tencent.ams.fusion.service.splash.b.b.a.a> list = this.f70375c;
        if (list != null && !list.isEmpty()) {
            boolean z16 = false;
            while (!z16) {
                try {
                    if (!this.f70375c.isEmpty()) {
                        com.tencent.ams.fusion.service.splash.b.b.a.a remove = this.f70375c.remove(0);
                        z16 = r(i3, g16, remove, new b(new WeakReference(this), remove));
                    } else {
                        return;
                    }
                } catch (Throwable th5) {
                    com.tencent.ams.fusion.a.f.c("PreloadResourceDownloadTask", "[runNextDownloadTask] multiThread error", th5);
                    return;
                }
            }
            return;
        }
        com.tencent.ams.fusion.a.f.h("PreloadResourceDownloadTask", "[runNextDownloadTask] taskModels == null");
    }

    private rt.c x() {
        StringBuilder sb5;
        String str;
        if (s() == null) {
            return null;
        }
        String b16 = s().b();
        if (s().a()) {
            sb5 = new StringBuilder();
            sb5.append(b16);
            str = "key_preload_parse_data_hot";
        } else {
            sb5 = new StringBuilder();
            sb5.append(b16);
            str = "key_preload_parse_data_cold";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        try {
            if (t() == null) {
                return null;
            }
            return (rt.c) t().a(sb6);
        } catch (Exception e16) {
            com.tencent.ams.fusion.a.f.c("PreloadResourceDownloadTask", "getParseDataByRequest error", e16);
            return null;
        }
    }

    @Override // kt.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? "PreloadResourceDownloadTask" : (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    @Override // kt.c
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public nt.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (nt.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.ams.fusion.a.f.b("PreloadResourceDownloadTask", "[execute]");
        if (s() == null) {
            com.tencent.ams.fusion.a.f.b("PreloadResourceDownloadTask", "[execute] getRequest() == null");
            return g(1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        nt.d.b(this.f70373a, 450, 0L, 0L, 0);
        nt.b u16 = u();
        if (u16 instanceof b.c) {
            ((b.c) u16).c(System.currentTimeMillis() - currentTimeMillis);
        }
        nt.d.b(this.f70373a, 451, u16.a(), u16.c(), 0);
        return u16;
    }

    public void j(com.tencent.ams.fusion.service.splash.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.f70374b = aVar;
        }
    }

    public void o(nt.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
        } else {
            this.f70373a = fVar;
        }
    }

    public nt.f s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (nt.f) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f70373a;
    }

    public com.tencent.ams.fusion.service.splash.data.a t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.ams.fusion.service.splash.data.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f70374b;
    }

    private static File c(com.tencent.ams.fusion.service.splash.b.b.a.a aVar) {
        if (aVar.c() != 1 && aVar.c() != 2) {
            if (aVar.c() == 3) {
                return com.tencent.ams.fusion.a.b.o(aVar.c(), aVar.a());
            }
            return null;
        }
        if (TextUtils.isEmpty(aVar.d())) {
            return com.tencent.ams.fusion.a.b.c(aVar.c(), aVar.a());
        }
        return com.tencent.ams.fusion.a.b.c(aVar.c(), aVar.d());
    }
}
