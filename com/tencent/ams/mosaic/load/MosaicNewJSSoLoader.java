package com.tencent.ams.mosaic.load;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicManager;
import com.tencent.ams.mosaic.jsengine.common.download.IDownload;
import com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager;
import com.tencent.ams.mosaic.load.QuickJSSoLoader;
import com.tencent.ams.mosaic.load.b;
import com.tencent.ams.mosaic.load.d;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MosaicNewJSSoLoader implements com.tencent.ams.mosaic.load.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final Long f71457e;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f71458a;

    /* renamed from: b, reason: collision with root package name */
    private final List<QuickJSSoLoader.a> f71459b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<d.c, Long> f71460c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f71461d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f71467a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.mosaic.load.d f71468b;

        a(Context context, com.tencent.ams.mosaic.load.d dVar) {
            this.f71467a = context;
            this.f71468b = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MosaicNewJSSoLoader.this, context, dVar);
            }
        }

        @Override // com.tencent.ams.mosaic.load.MosaicNewJSSoLoader.f
        public void onDownloadFail(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                MosaicNewJSSoLoader.this.i(i3);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }

        @Override // com.tencent.ams.mosaic.load.MosaicNewJSSoLoader.f
        public void onDownloadSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MosaicNewJSSoLoader.this.r(this.f71467a, this.f71468b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends com.tencent.ams.mosaic.jsengine.common.download.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IMosaicDownloadManager.a f71470a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.mosaic.load.d f71471b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.c f71472c;

        b(IMosaicDownloadManager.a aVar, com.tencent.ams.mosaic.load.d dVar, d.c cVar) {
            this.f71470a = aVar;
            this.f71471b = dVar;
            this.f71472c = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MosaicNewJSSoLoader.this, aVar, dVar, cVar);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.c, com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            super.a(str);
            IMosaicDownloadManager.a aVar = this.f71470a;
            if (aVar != null) {
                aVar.a(str);
            }
            MosaicNewJSSoLoader.this.t(this.f71471b, this.f71472c);
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.c, com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onDownloadStart();
            IMosaicDownloadManager.a aVar = this.f71470a;
            if (aVar != null) {
                aVar.onDownloadStart();
            }
            MosaicNewJSSoLoader.this.v(this.f71471b, this.f71472c);
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.c, com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            super.onFailed(i3);
            IMosaicDownloadManager.a aVar = this.f71470a;
            if (aVar != null) {
                aVar.onFailed(i3);
            }
            MosaicNewJSSoLoader.this.u(this.f71471b, this.f71472c, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a f71474a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.ams.mosaic.load.d f71475b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f71476c;

        c(b.a aVar, com.tencent.ams.mosaic.load.d dVar, f fVar) {
            this.f71474a = aVar;
            this.f71475b = dVar;
            this.f71476c = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MosaicNewJSSoLoader.this, aVar, dVar, fVar);
            }
        }

        @Override // com.tencent.ams.mosaic.load.MosaicNewJSSoLoader.f
        public void onDownloadFail(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            b.a aVar = this.f71474a;
            if (aVar != null) {
                aVar.onFailure(this.f71475b, i3);
            }
            f fVar = this.f71476c;
            if (fVar != null) {
                fVar.onDownloadFail(i3);
            }
        }

        @Override // com.tencent.ams.mosaic.load.MosaicNewJSSoLoader.f
        public void onDownloadSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            b.a aVar = this.f71474a;
            if (aVar != null) {
                aVar.onComplete(this.f71475b);
            }
            f fVar = this.f71476c;
            if (fVar != null) {
                fVar.onDownloadSuccess();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d extends com.tencent.ams.mosaic.jsengine.common.download.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.c f71478a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f71479b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f71480c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f71481d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f71482e;

        d(d.c cVar, AtomicInteger atomicInteger, int i3, f fVar, AtomicBoolean atomicBoolean) {
            this.f71478a = cVar;
            this.f71479b = atomicInteger;
            this.f71480c = i3;
            this.f71481d = fVar;
            this.f71482e = atomicBoolean;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, MosaicNewJSSoLoader.this, cVar, atomicInteger, Integer.valueOf(i3), fVar, atomicBoolean);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.c, com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void a(String str) {
            f fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            this.f71478a.f71524g = 3;
            if (this.f71479b.addAndGet(1) == this.f71480c && (fVar = this.f71481d) != null) {
                fVar.onDownloadSuccess();
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.c, com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onFailed(int i3) {
            f fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else if (!this.f71482e.getAndSet(true) && (fVar = this.f71481d) != null) {
                fVar.onDownloadFail(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final MosaicNewJSSoLoader f71484a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59024);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f71484a = new MosaicNewJSSoLoader(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface f {
        void onDownloadFail(int i3);

        void onDownloadSuccess();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59032);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f71457e = 604800000L;
        }
    }

    /* synthetic */ MosaicNewJSSoLoader(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Context context) {
        boolean z16;
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", QCircleLpReportDc05507.KEY_CLEAR);
        List<File> f16 = com.tencent.ams.mosaic.load.f.f(context);
        if (f16 != null && !f16.isEmpty()) {
            for (File file : f16) {
                if (file != null && file.exists()) {
                    boolean p16 = p(context, file);
                    if (System.currentTimeMillis() - file.lastModified() > f71457e.longValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "isInConfigs: " + p16 + ", isExpirationTime: " + z16 + ", file: " + file);
                    if (!p16 && z16) {
                        try {
                            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "delete so file, result: " + file.delete() + ", file: " + file);
                        } catch (Throwable th5) {
                            com.tencent.ams.mosaic.utils.f.c("MosaicNewJSSoLoader", "delete so file error. file: " + file, th5);
                        }
                    }
                }
            }
            return;
        }
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "local so is empty.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3) {
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "dispatchSoLoadFail, failReason: " + i3);
        synchronized (this.f71459b) {
            if (this.f71459b.isEmpty()) {
                return;
            }
            Iterator<QuickJSSoLoader.a> it = this.f71459b.iterator();
            while (it.hasNext()) {
                it.next().onSoLoadFailed(i3);
            }
            this.f71459b.clear();
        }
    }

    private void j(int i3) {
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "dispatchSoLoadSuccess, loadState: " + i3);
        synchronized (this.f71459b) {
            if (this.f71459b.isEmpty()) {
                return;
            }
            Iterator<QuickJSSoLoader.a> it = this.f71459b.iterator();
            while (it.hasNext()) {
                it.next().onSoLoadSuccess(i3);
            }
            this.f71459b.clear();
        }
    }

    private void k(com.tencent.ams.mosaic.load.d dVar) {
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "dispatchSoLoaded");
        if (dVar != null && dVar.f71513b && !com.tencent.ams.mosaic.load.f.j(dVar.f71512a)) {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "force update, loaded version is too low");
            i(8);
        } else {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "so loaded, not load again");
            j(1);
        }
    }

    private void l(Context context, com.tencent.ams.mosaic.load.d dVar, f fVar) {
        AtomicBoolean atomicBoolean;
        AtomicInteger atomicInteger;
        int i3;
        int i16;
        String str;
        String str2 = "MosaicNewJSSoLoader";
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "downloadSoIfNeed, config: " + dVar);
        int i17 = 1;
        if (dVar == null) {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "config is null");
            if (fVar != null) {
                fVar.onDownloadFail(1);
                return;
            }
            return;
        }
        List<d.c> d16 = dVar.d(context);
        if (d16 != null && !d16.isEmpty()) {
            int size = d16.size();
            AtomicInteger atomicInteger2 = new AtomicInteger(0);
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
            for (d.c cVar : d16) {
                String h16 = com.tencent.ams.mosaic.load.f.h(context, cVar);
                String g16 = com.tencent.ams.mosaic.load.f.g(cVar);
                if (new File(h16, g16).exists()) {
                    com.tencent.ams.mosaic.utils.f.e(str2, "so exist, item: " + cVar);
                    cVar.f71524g = 2;
                    if (atomicInteger2.addAndGet(i17) == size && fVar != null) {
                        fVar.onDownloadSuccess();
                    }
                    atomicInteger = atomicInteger2;
                    i3 = size;
                    i16 = i17;
                    str = str2;
                    atomicBoolean = atomicBoolean2;
                } else {
                    com.tencent.ams.mosaic.utils.f.e(str2, "so not exist, start download so, item: " + cVar);
                    atomicBoolean = atomicBoolean2;
                    atomicInteger = atomicInteger2;
                    i3 = size;
                    i16 = i17;
                    str = str2;
                    m(dVar, cVar, g16, h16, new d(cVar, atomicInteger2, size, fVar, atomicBoolean2));
                }
                str2 = str;
                size = i3;
                atomicInteger2 = atomicInteger;
                i17 = i16;
                atomicBoolean2 = atomicBoolean;
            }
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("MosaicNewJSSoLoader", "so item list is empty.");
        if (fVar != null) {
            fVar.onDownloadFail(1);
        }
    }

    private void m(com.tencent.ams.mosaic.load.d dVar, @NonNull d.c cVar, String str, String str2, IMosaicDownloadManager.a aVar) {
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "downloadSo, config: " + dVar + ", soItem: " + cVar + ", soName: " + str + ", soPath: " + str2);
        com.tencent.ams.mosaic.jsengine.common.download.b bVar = new com.tencent.ams.mosaic.jsengine.common.download.b(cVar.f71518a, cVar.f71519b, str2, str);
        IMosaicDownloadManager e16 = com.tencent.ams.mosaic.f.k().e();
        if (e16 == null) {
            com.tencent.ams.mosaic.utils.f.h("MosaicNewJSSoLoader", "download manager is null, download error.");
            if (aVar != null) {
                aVar.onFailed(7);
                return;
            }
            return;
        }
        IDownload download = e16.download(bVar, new b(aVar, dVar, cVar));
        if (download != null) {
            download.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context, com.tencent.ams.mosaic.load.d dVar, f fVar) {
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "downloadSoIfNeed, config: " + dVar);
        b.a n3 = com.tencent.ams.mosaic.f.k().n();
        if (n3 != null) {
            n3.onStart(dVar);
        }
        l(context, dVar, new c(n3, dVar, fVar));
    }

    public static MosaicNewJSSoLoader o() {
        return e.f71484a;
    }

    private boolean p(Context context, File file) {
        if (file == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        List<com.tencent.ams.mosaic.load.d> f16 = com.tencent.ams.mosaic.load.d.f();
        if (f16 != null && !f16.isEmpty()) {
            Iterator<com.tencent.ams.mosaic.load.d> it = f16.iterator();
            while (it.hasNext()) {
                List<String> c16 = com.tencent.ams.mosaic.load.f.c(context, it.next());
                if (c16 != null && !c16.isEmpty()) {
                    Iterator<String> it5 = c16.iterator();
                    while (it5.hasNext()) {
                        if (absolutePath.contains(it5.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private synchronized void q(Context context, com.tencent.ams.mosaic.load.d dVar) {
        int i3;
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "loadLocalSo, config: " + dVar);
        if (dVar == null) {
            com.tencent.ams.mosaic.utils.f.h("MosaicNewJSSoLoader", "config is null");
            i(1);
            return;
        }
        List<d.c> d16 = dVar.d(context);
        if (d16 != null && !d16.isEmpty()) {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "so start loading.");
            this.f71458a = false;
            this.f71461d = true;
            int size = d16.size();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator<d.c> it = d16.iterator();
            int i16 = 2;
            while (true) {
                if (it.hasNext()) {
                    d.c next = it.next();
                    if (next.f71522e != 0) {
                        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "item not effective, failReason: " + next.f71522e);
                        i3 = next.f71522e;
                        break;
                    }
                    String h16 = com.tencent.ams.mosaic.load.f.h(context, next);
                    if (TextUtils.isEmpty(h16)) {
                        i3 = 4;
                        break;
                    }
                    File file = new File(h16, com.tencent.ams.mosaic.load.f.g(next));
                    if (!file.exists()) {
                        com.tencent.ams.mosaic.utils.f.h("MosaicNewJSSoLoader", "so file not exit");
                        i3 = 7;
                        break;
                    }
                    try {
                        System.load(file.getAbsolutePath());
                        if (next.f71524g == 3) {
                            i16 = 3;
                        }
                        file.setLastModified(System.currentTimeMillis());
                        atomicInteger.incrementAndGet();
                    } catch (Throwable th5) {
                        com.tencent.ams.mosaic.utils.f.c("MosaicNewJSSoLoader", "load so error.", th5);
                        i3 = 6;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            this.f71461d = false;
            if (atomicInteger.get() == size) {
                this.f71458a = true;
                j(i16);
            } else {
                this.f71458a = false;
                i(i3);
            }
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("MosaicNewJSSoLoader", "so items is empty.");
        i(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(Context context, com.tencent.ams.mosaic.load.d dVar) {
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "loadLocalSo, config: " + dVar);
        if (this.f71458a) {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "so is loaded.");
            k(dVar);
        } else if (this.f71461d) {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "so is loading.");
        } else {
            q(context, dVar);
        }
    }

    private void s(Context context, boolean z16, com.tencent.ams.mosaic.load.d dVar, QuickJSSoLoader.a aVar) {
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "loadOrDownloadSo, onlyLocal: " + z16 + ", config: " + dVar);
        if (aVar != null) {
            aVar.onSoLoadStart();
        }
        synchronized (this.f71459b) {
            this.f71459b.add(aVar);
        }
        if (this.f71458a) {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "so is loaded");
            k(dVar);
            return;
        }
        synchronized (this) {
            if (this.f71458a) {
                com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "so is loaded");
                k(dVar);
            } else {
                if (this.f71461d) {
                    com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "so is loading");
                    return;
                }
                if (z16) {
                    r(context, dVar);
                } else {
                    n(context, dVar, new a(context, dVar));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(com.tencent.ams.mosaic.load.d dVar, d.c cVar) {
        if (cVar == null) {
            com.tencent.ams.mosaic.utils.f.h("MosaicNewJSSoLoader", "notifySoDownloadComplete, so info is null");
            return;
        }
        Long remove = this.f71460c.remove(cVar);
        if (remove != null) {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "notifySoDownloadComplete, config:" + dVar + ", soItem: " + cVar + ", duration: " + (System.currentTimeMillis() - remove.longValue()));
            b.a n3 = com.tencent.ams.mosaic.f.k().n();
            if (n3 != null) {
                n3.onDownloadSuccess(dVar, cVar);
                return;
            }
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("MosaicNewJSSoLoader", "so need start downloaded. " + cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.tencent.ams.mosaic.load.d dVar, d.c cVar, int i3) {
        if (cVar == null) {
            com.tencent.ams.mosaic.utils.f.h("MosaicNewJSSoLoader", "notifySoDownloadFailure, so info is null");
            return;
        }
        Long remove = this.f71460c.remove(cVar);
        if (remove != null) {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "notifySoDownloadFailure, config:" + dVar + ", soItem: " + cVar + ", errorCode:" + i3 + "duration: " + (System.currentTimeMillis() - remove.longValue()));
            b.a n3 = com.tencent.ams.mosaic.f.k().n();
            if (n3 != null) {
                n3.onDownloadFailure(dVar, cVar, i3);
                return;
            }
            return;
        }
        com.tencent.ams.mosaic.utils.f.h("MosaicNewJSSoLoader", "notifySoDownloadFailure, so need start downloaded. " + cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(com.tencent.ams.mosaic.load.d dVar, d.c cVar) {
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "notifySoDownloadStart, config: " + dVar + ", soItem: " + cVar);
        if (cVar == null) {
            return;
        }
        if (this.f71460c.containsKey(cVar)) {
            com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", cVar + " so file is being downloaded. No need to report again");
            return;
        }
        this.f71460c.put(cVar, Long.valueOf(System.currentTimeMillis()));
        b.a n3 = com.tencent.ams.mosaic.f.k().n();
        if (n3 != null) {
            n3.onDownloadStart(dVar, cVar);
        }
    }

    @Override // com.tencent.ams.mosaic.load.b
    public boolean isSupportQuickJS() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        com.tencent.ams.mosaic.load.d g16 = com.tencent.ams.mosaic.load.d.g(MosaicManager.j().i());
        if (g16 != null && g16.f71513b) {
            return com.tencent.ams.mosaic.load.f.j(g16.f71512a);
        }
        return this.f71458a;
    }

    @Override // com.tencent.ams.mosaic.load.b
    public void loadSo(Context context, boolean z16, QuickJSSoLoader.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16), aVar);
            return;
        }
        com.tencent.ams.mosaic.load.d g16 = com.tencent.ams.mosaic.load.d.g(context);
        com.tencent.ams.mosaic.load.d c16 = com.tencent.ams.mosaic.load.d.c(context);
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "loadSo, onlyLocal: " + z16 + ", config: " + g16 + ", latestConfig: " + c16);
        s(context, z16, g16, aVar);
        if (c16 != null && g16 != c16 && MosaicUtils.i(c16.f71512a, g16.f71512a) > 0) {
            g.b().a().execute(new Runnable(context, c16) { // from class: com.tencent.ams.mosaic.load.MosaicNewJSSoLoader.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Context f71462d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.ams.mosaic.load.d f71463e;

                {
                    this.f71462d = context;
                    this.f71463e = c16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, MosaicNewJSSoLoader.this, context, c16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        MosaicNewJSSoLoader.this.n(this.f71462d, this.f71463e, null);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.load.b
    public boolean setSoConfigs(Context context, List<com.tencent.ams.mosaic.load.d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) list)).booleanValue();
        }
        if (list != null) {
            com.tencent.ams.mosaic.load.d.h(list);
        }
        com.tencent.ams.mosaic.load.d c16 = com.tencent.ams.mosaic.load.d.c(context);
        com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "setConfigs, latestConfig: " + c16);
        MosaicUtils.F(new Runnable(context, c16) { // from class: com.tencent.ams.mosaic.load.MosaicNewJSSoLoader.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f71464d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.ams.mosaic.load.d f71465e;

            /* compiled from: P */
            /* renamed from: com.tencent.ams.mosaic.load.MosaicNewJSSoLoader$4$a */
            /* loaded from: classes3.dex */
            class a implements f {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                    }
                }

                @Override // com.tencent.ams.mosaic.load.MosaicNewJSSoLoader.f
                public void onDownloadFail(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3);
                        return;
                    }
                    com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "download so fail, errorCode: " + i3);
                }

                @Override // com.tencent.ams.mosaic.load.MosaicNewJSSoLoader.f
                public void onDownloadSuccess() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.ams.mosaic.utils.f.e("MosaicNewJSSoLoader", "download so success");
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    MosaicNewJSSoLoader.this.r(anonymousClass4.f71464d, anonymousClass4.f71465e);
                }
            }

            {
                this.f71464d = context;
                this.f71465e = c16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MosaicNewJSSoLoader.this, context, c16);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MosaicNewJSSoLoader.this.h(this.f71464d);
                    com.tencent.ams.mosaic.load.d dVar = this.f71465e;
                    if (dVar != null) {
                        MosaicNewJSSoLoader.this.n(this.f71464d, dVar, new a());
                        return;
                    }
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        if (list != null && list.contains(c16)) {
            return true;
        }
        return false;
    }

    MosaicNewJSSoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f71458a = false;
        this.f71459b = new ArrayList();
        this.f71460c = new ConcurrentHashMap<>();
    }
}
