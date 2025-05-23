package com.tencent.theme;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    Resources f376062a;

    /* renamed from: b, reason: collision with root package name */
    SkinEngine f376063b;

    /* renamed from: c, reason: collision with root package name */
    c f376064c;

    /* renamed from: d, reason: collision with root package name */
    b f376065d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f376066e;

    /* renamed from: f, reason: collision with root package name */
    ConcurrentHashMap<String, byte[]> f376067f;

    /* renamed from: g, reason: collision with root package name */
    int f376068g;

    /* renamed from: h, reason: collision with root package name */
    HashMap<String, Integer> f376069h;

    /* renamed from: i, reason: collision with root package name */
    HashSet<String> f376070i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b extends AsyncTask<Void, Void, Void> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            m.a(SkinEngine.TAG_OPTIMIZE, 1, "CacheTask start");
            try {
                g.this.a();
            } catch (Exception e16) {
                m.d(SkinEngine.TAG_OPTIMIZE, 1, "CacheTask error", e16);
            }
            m.a(SkinEngine.TAG_OPTIMIZE, 1, "CacheTask finish");
            return null;
        }

        /* synthetic */ b(g gVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c extends AsyncTask<Void, Void, Void> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            g.this.i();
            return null;
        }

        /* synthetic */ c(g gVar, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar, (Object) aVar);
        }
    }

    public g(SkinEngine skinEngine, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) skinEngine, (Object) resources);
            return;
        }
        this.f376067f = new ConcurrentHashMap<>();
        this.f376068g = 0;
        this.f376069h = new HashMap<>();
        this.f376070i = new HashSet<>();
        this.f376062a = resources;
        this.f376068g = 0;
        this.f376063b = skinEngine;
        a aVar = null;
        this.f376064c = new c(this, aVar);
        this.f376065d = new b(this, aVar);
    }

    private void b(File file) {
        byte[] a16;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    b(file2);
                } else if (file2.exists() && f(file2.getAbsolutePath()) && (a16 = com.tencent.theme.engine.utils.b.a(file2.getAbsolutePath())) != null) {
                    this.f376067f.put(file2.getAbsolutePath(), a16);
                }
            }
        }
    }

    private boolean f(String str) {
        if (!str.endsWith(".png") && !str.endsWith(".xml")) {
            return false;
        }
        return true;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        m.b(SkinEngine.TAG_OPTIMIZE, 1, "[cache]start,  pid:" + Process.myPid(), null);
        File themeDirFile = this.f376063b.getThemeDirFile();
        if (themeDirFile != null && themeDirFile.exists() && themeDirFile.isDirectory()) {
            b(themeDirFile);
        } else {
            m.a(SkinEngine.TAG_OPTIMIZE, 1, "cacheAll, path empty!");
        }
        m.b(SkinEngine.TAG_OPTIMIZE, 1, "[cache]end, pid:" + Process.myPid() + " CacheDuration:" + (SystemClock.uptimeMillis() - uptimeMillis), null);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cache finish : map size : ");
        sb5.append(this.f376067f.size());
        m.a(SkinEngine.TAG_OPTIMIZE, 1, sb5.toString());
    }

    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f376069h.clear();
        this.f376070i.clear();
        this.f376068g = 0;
        this.f376066e = false;
        this.f376067f.clear();
    }

    public Integer d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return this.f376069h.get(str);
    }

    public boolean e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f376070i.contains(str);
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        c cVar = this.f376064c;
        if (cVar != null && cVar.getStatus() == AsyncTask.Status.RUNNING) {
            return true;
        }
        return false;
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!this.f376066e) {
            return false;
        }
        if (this.f376063b.getRealRootPath() != null && this.f376068g == 0) {
            m.a(SkinEngine.TAG, 1, "not default theme, but res size is 0");
            return false;
        }
        return this.f376066e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        int i3;
        Object valueOf;
        String[] list;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        m.b(SkinEngine.TAG, 2, "[record]start,  pid:" + Process.myPid(), null);
        int i17 = 0;
        this.f376068g = 0;
        File themeDirFile = this.f376063b.getThemeDirFile();
        int i18 = 1;
        if (themeDirFile != null && themeDirFile.exists()) {
            String[] list2 = themeDirFile.list();
            if (list2 != null && list2.length != 0) {
                int length = list2.length;
                int i19 = 0;
                while (i19 < length) {
                    String str = list2[i19];
                    File file = new File(themeDirFile, str + "/");
                    if (file.exists() && (list = file.list()) != null) {
                        int length2 = list.length;
                        while (i17 < length2) {
                            String str2 = list[i17];
                            String substring = str2.substring(str2.lastIndexOf("/") + 1);
                            int drawableDpi = this.f376063b.getDrawableDpi(str + "/");
                            if (-1 == drawableDpi) {
                                i16 = 1;
                            } else if (-2 == drawableDpi) {
                                this.f376070i.add(substring);
                                this.f376068g++;
                                i16 = 1;
                            } else {
                                this.f376069h.put(substring, Integer.valueOf(drawableDpi));
                                i16 = 1;
                                this.f376068g++;
                            }
                            i17++;
                            i18 = i16;
                        }
                        boolean z16 = i18;
                        m.a(SkinEngine.TAG, z16 ? 1 : 0, "record result success");
                        this.f376066e = z16;
                    }
                    i19++;
                    i17 = 0;
                    i18 = 1;
                }
                i3 = i18;
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("searchAll, allDrawable : ");
                if (list2 == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(list2.length);
                }
                sb5.append(valueOf);
                i3 = 1;
                m.a(SkinEngine.TAG, 1, sb5.toString());
            }
        } else {
            i3 = 1;
            m.a(SkinEngine.TAG, 1, "searchAll, themeDir : " + themeDirFile);
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        m.a(SkinEngine.TAG, i3, "record result : " + this.f376066e);
        m.b(SkinEngine.TAG, 2, "[record]end, mCacheEntry:" + this.f376068g + " pid:" + Process.myPid() + " touchCacheDuration:" + uptimeMillis2, null);
        m.a(SkinEngine.TAG, 1, "record finish : " + this.f376068g + " map size : " + this.f376069h.size() + "  color size : " + this.f376070i.size());
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        c cVar = this.f376064c;
        a aVar = null;
        if (cVar != null) {
            if (cVar.getStatus() == AsyncTask.Status.PENDING) {
                c();
                this.f376064c.execute(new Void[0]);
            } else if (this.f376064c.getStatus() == AsyncTask.Status.RUNNING) {
                this.f376064c.cancel(true);
                c();
                c cVar2 = new c(this, aVar);
                this.f376064c = cVar2;
                cVar2.execute(new Void[0]);
            } else if (this.f376064c.getStatus() == AsyncTask.Status.FINISHED) {
                this.f376064c = new c(this, aVar);
                c();
                this.f376064c.execute(new Void[0]);
            }
        } else {
            this.f376064c = new c(this, aVar);
            m.a(SkinEngine.TAG, 1, "mRecordTask is null");
            c();
            this.f376064c.execute(new Void[0]);
        }
        if (this.f376063b.isEnableCacheTask() && this.f376067f.isEmpty()) {
            b bVar = this.f376065d;
            if (bVar != null && !bVar.isCancelled()) {
                this.f376065d.cancel(false);
            }
            b bVar2 = new b(this, aVar);
            this.f376065d = bVar2;
            bVar2.execute(new Void[0]);
        }
    }
}
