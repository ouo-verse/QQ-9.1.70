package com.tencent.ams.mosaic.load;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.common.download.IDownload;
import com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager;
import com.tencent.ams.mosaic.load.QuickJSSoLoader;
import com.tencent.ams.mosaic.load.b;
import com.tencent.ams.mosaic.load.d;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements com.tencent.ams.mosaic.load.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final c f71485f;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.ams.mosaic.load.d f71486a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f71487b;

    /* renamed from: c, reason: collision with root package name */
    private List<QuickJSSoLoader.a> f71488c;

    /* renamed from: d, reason: collision with root package name */
    private d f71489d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71490e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements QuickJSSoLoader.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f71491a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f71492b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QuickJSSoLoader.a f71493c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b.a f71494d;

        a(AtomicInteger atomicInteger, int i3, QuickJSSoLoader.a aVar, b.a aVar2) {
            this.f71491a = atomicInteger;
            this.f71492b = i3;
            this.f71493c = aVar;
            this.f71494d = aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, atomicInteger, Integer.valueOf(i3), aVar, aVar2);
            }
        }

        @Override // com.tencent.ams.mosaic.load.QuickJSSoLoader.a
        public void onSoLoadFailed(int i3) {
            b.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            QuickJSSoLoader.a aVar2 = this.f71493c;
            if (aVar2 != null) {
                aVar2.onSoLoadFailed(i3);
            }
            if (c.this.f71490e && (aVar = this.f71494d) != null) {
                aVar.onFailure(c.this.f71486a, i3);
            }
            synchronized (c.this) {
                c.this.f71490e = false;
                if (c.this.f71488c != null && !c.this.f71488c.isEmpty()) {
                    for (QuickJSSoLoader.a aVar3 : c.this.f71488c) {
                        if (aVar3 != null) {
                            aVar3.onSoLoadFailed(i3);
                        }
                    }
                    c.this.f71488c = null;
                }
            }
        }

        @Override // com.tencent.ams.mosaic.load.QuickJSSoLoader.a
        public void onSoLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.ams.mosaic.load.QuickJSSoLoader.a
        public void onSoLoadSuccess(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (this.f71491a.addAndGet(1) == this.f71492b) {
                QuickJSSoLoader.a aVar = this.f71493c;
                if (aVar != null) {
                    aVar.onSoLoadSuccess(i3);
                }
                synchronized (c.this) {
                    c.this.f71490e = false;
                    c.this.f71487b = true;
                    if (c.this.f71488c != null && !c.this.f71488c.isEmpty()) {
                        for (QuickJSSoLoader.a aVar2 : c.this.f71488c) {
                            if (aVar2 != null) {
                                aVar2.onSoLoadSuccess(i3);
                            }
                        }
                        c.this.f71488c = null;
                    }
                }
                b.a aVar3 = this.f71494d;
                if (aVar3 != null) {
                    aVar3.onComplete(c.this.f71486a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements IMosaicDownloadManager.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a f71496a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c f71497b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f71498c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f71499d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QuickJSSoLoader.a f71500e;

        b(b.a aVar, d.c cVar, String str, String str2, QuickJSSoLoader.a aVar2) {
            this.f71496a = aVar;
            this.f71497b = cVar;
            this.f71498c = str;
            this.f71499d = str2;
            this.f71500e = aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, aVar, cVar, str, str2, aVar2);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("MosaicOldJSSoLoader", "downloadSo onDownloadComplete");
            c.this.q(this.f71497b, this.f71498c + File.separator + this.f71499d, 3, this.f71500e);
            b.a aVar = this.f71496a;
            if (aVar != null) {
                aVar.onDownloadSuccess(c.this.f71486a, this.f71497b);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void b(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadPause() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadResume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.ams.mosaic.utils.f.e("MosaicOldJSSoLoader", "onDownloadStart");
            b.a aVar = this.f71496a;
            if (aVar != null) {
                aVar.onDownloadStart(c.this.f71486a, this.f71497b);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
        public void onFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
                return;
            }
            com.tencent.ams.mosaic.utils.f.b("MosaicOldJSSoLoader", "downloadSo failed. errorCode: " + i3);
            c.k(this.f71500e, 5);
            b.a aVar = this.f71496a;
            if (aVar != null) {
                aVar.onDownloadFailure(c.this.f71486a, this.f71497b, i3);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.ams.mosaic.load.c$c, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0696c implements Comparator<com.tencent.ams.mosaic.load.d> {
        static IPatchRedirector $redirector_;

        C0696c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.ams.mosaic.load.d dVar, com.tencent.ams.mosaic.load.d dVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) dVar2)).intValue();
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final Map<Integer, e> f71503a;

        /* renamed from: b, reason: collision with root package name */
        private int f71504b;

        /* renamed from: c, reason: collision with root package name */
        private int f71505c;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f71503a = new ConcurrentHashMap();
            this.f71504b = 0;
            this.f71505c = 1;
        }

        private void a(d.c cVar, String str, QuickJSSoLoader.a aVar) {
            try {
                System.load(str);
                com.tencent.ams.mosaic.utils.f.e("MosaicOldJSSoLoader", "loadSo success: " + cVar.f71518a);
                c.m(aVar, this.f71505c);
                int i3 = this.f71504b + 1;
                this.f71504b = i3;
                e eVar = this.f71503a.get(Integer.valueOf(i3));
                if (eVar != null) {
                    a(eVar.f71506a, eVar.f71508c, eVar.f71507b);
                }
            } catch (Throwable th5) {
                com.tencent.ams.mosaic.utils.f.i("MosaicOldJSSoLoader", "loadSo failed: " + cVar.f71518a, th5);
                c.k(aVar, 6);
            }
        }

        public synchronized void b(d.c cVar, String str, int i3, QuickJSSoLoader.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, cVar, str, Integer.valueOf(i3), aVar);
                return;
            }
            if (cVar == null) {
                return;
            }
            if (i3 > this.f71505c) {
                this.f71505c = i3;
            }
            if (this.f71504b == cVar.f71523f) {
                a(cVar, str, aVar);
            } else {
                e eVar = new e();
                eVar.f71506a = cVar;
                eVar.f71508c = str;
                eVar.f71507b = aVar;
                this.f71503a.put(Integer.valueOf(cVar.f71523f), eVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        d.c f71506a;

        /* renamed from: b, reason: collision with root package name */
        QuickJSSoLoader.a f71507b;

        /* renamed from: c, reason: collision with root package name */
        String f71508c;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59086);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f71485f = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f71486a = com.tencent.ams.mosaic.load.a.a();
            this.f71487b = false;
        }
    }

    private void j(String str, String str2) {
        File[] listFiles;
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && (TextUtils.isEmpty(str2) || !file2.getName().contains(str2))) {
                        file2.delete();
                        com.tencent.ams.mosaic.utils.f.e("MosaicOldJSSoLoader", "clearOldSo delete cache so: " + file2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(QuickJSSoLoader.a aVar, int i3) {
        if (aVar != null) {
            aVar.onSoLoadFailed(i3);
        }
    }

    private static void l(QuickJSSoLoader.a aVar) {
        if (aVar != null) {
            aVar.onSoLoadStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(QuickJSSoLoader.a aVar, int i3) {
        if (aVar != null) {
            aVar.onSoLoadSuccess(i3);
        }
    }

    private void n(@NonNull d.c cVar, String str, String str2, QuickJSSoLoader.a aVar) {
        com.tencent.ams.mosaic.jsengine.common.download.b bVar = new com.tencent.ams.mosaic.jsengine.common.download.b(cVar.f71518a, cVar.f71519b, str2, str);
        IMosaicDownloadManager e16 = com.tencent.ams.mosaic.f.k().e();
        if (e16 == null) {
            k(aVar, 5);
            return;
        }
        IDownload download = e16.download(bVar, new b(com.tencent.ams.mosaic.f.k().n(), cVar, str2, str, aVar));
        if (download != null) {
            download.start();
        }
    }

    public static c o() {
        return f71485f;
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private void p(@NonNull d.c cVar, boolean z16, Context context, QuickJSSoLoader.a aVar) {
        String h16 = f.h(context, cVar);
        if (TextUtils.isEmpty(h16)) {
            k(aVar, 4);
            return;
        }
        String g16 = f.g(cVar);
        File file = new File(h16, g16);
        if (!file.exists()) {
            if (z16) {
                k(aVar, 7);
                return;
            } else {
                j(h16, g16);
                n(cVar, g16, h16, aVar);
                return;
            }
        }
        String absolutePath = file.getAbsolutePath();
        com.tencent.ams.mosaic.utils.f.e("MosaicOldJSSoLoader", "loadSo find cache so: " + absolutePath);
        q(cVar, absolutePath, 2, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public void q(d.c cVar, String str, int i3, QuickJSSoLoader.a aVar) {
        d dVar = this.f71489d;
        if (dVar != null) {
            dVar.b(cVar, str, i3, aVar);
        }
    }

    @Override // com.tencent.ams.mosaic.load.b
    public boolean isSupportQuickJS() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        com.tencent.ams.mosaic.load.d dVar = this.f71486a;
        if (dVar != null && f.j(dVar.f71512a)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ams.mosaic.load.b
    public void loadSo(Context context, boolean z16, QuickJSSoLoader.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(z16), aVar);
            return;
        }
        l(aVar);
        if (this.f71487b) {
            com.tencent.ams.mosaic.utils.f.e("MosaicOldJSSoLoader", "so loaded, not load again");
            m(aVar, 1);
            return;
        }
        synchronized (this) {
            if (this.f71487b) {
                com.tencent.ams.mosaic.utils.f.e("MosaicOldJSSoLoader", "so loaded, not load again");
                m(aVar, 1);
                return;
            }
            if (!this.f71490e) {
                List<d.c> d16 = this.f71486a.d(context);
                if (d16 == null) {
                    k(aVar, 1);
                    return;
                }
                int size = d16.size();
                this.f71490e = true;
                this.f71489d = new d();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                b.a n3 = com.tencent.ams.mosaic.f.k().n();
                if (n3 != null) {
                    n3.onStart(this.f71486a);
                }
                Iterator<d.c> it = d16.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d.c next = it.next();
                    if (next != null) {
                        if (next.f71522e != 0) {
                            com.tencent.ams.mosaic.utils.f.h("MosaicOldJSSoLoader", "loadSo failed failReason: " + next.f71522e);
                            this.f71490e = false;
                            k(aVar, next.f71522e);
                            if (n3 != null) {
                                n3.onFailure(this.f71486a, next.f71522e);
                            }
                        } else {
                            p(next, z16, context, new a(atomicInteger, size, aVar, n3));
                        }
                    }
                }
            } else {
                if (this.f71488c == null) {
                    this.f71488c = new ArrayList();
                }
                this.f71488c.add(aVar);
            }
        }
    }

    @Override // com.tencent.ams.mosaic.load.b
    public boolean setSoConfigs(Context context, List<com.tencent.ams.mosaic.load.d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) list)).booleanValue();
        }
        if (list == null || list.isEmpty()) {
            return false;
        }
        Collections.sort(list, new C0696c());
        com.tencent.ams.mosaic.load.d dVar = list.get(0);
        if (dVar == null || MosaicUtils.i(dVar.f71512a, this.f71486a.f71512a) <= 0) {
            return false;
        }
        this.f71486a = dVar;
        this.f71487b = false;
        return true;
    }
}
