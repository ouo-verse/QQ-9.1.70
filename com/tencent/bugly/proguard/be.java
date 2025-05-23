package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.constants.SPKey;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.upload.UploadProxy;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ao;
import com.tencent.rmonitor.base.config.ConfigFetcher;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class be {
    private static be F = null;

    /* renamed from: a, reason: collision with root package name */
    public static int f98207a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f98208b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f98209c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f98210d = false;

    /* renamed from: e, reason: collision with root package name */
    public static int f98211e = 61440;

    /* renamed from: f, reason: collision with root package name */
    public static int f98212f = 10240;

    /* renamed from: g, reason: collision with root package name */
    public static int f98213g = 50;

    /* renamed from: h, reason: collision with root package name */
    public static int f98214h = 3000;

    /* renamed from: i, reason: collision with root package name */
    public static int f98215i = 20480;

    /* renamed from: j, reason: collision with root package name */
    public static long f98216j = 209715200;

    /* renamed from: k, reason: collision with root package name */
    public static long f98217k = 604800000;

    /* renamed from: l, reason: collision with root package name */
    public static String f98218l = null;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f98219m = false;

    /* renamed from: n, reason: collision with root package name */
    public static String f98220n = null;

    /* renamed from: o, reason: collision with root package name */
    public static int f98221o = 5000;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f98222p = true;

    /* renamed from: q, reason: collision with root package name */
    public static boolean f98223q = true;

    /* renamed from: r, reason: collision with root package name */
    public static long f98224r = 2;

    /* renamed from: s, reason: collision with root package name */
    public static long f98225s = 30000;

    /* renamed from: t, reason: collision with root package name */
    public static long f98226t = 10000;

    /* renamed from: u, reason: collision with root package name */
    public static String f98227u;

    /* renamed from: v, reason: collision with root package name */
    public static String f98228v;
    public BuglyStrategy.a A;
    public bm B;
    private final Context E;
    private final bk G;
    private final bn H;

    /* renamed from: w, reason: collision with root package name */
    public final bd f98229w;

    /* renamed from: x, reason: collision with root package name */
    public final NativeCrashHandler f98230x;

    /* renamed from: y, reason: collision with root package name */
    public final ak f98231y;

    /* renamed from: z, reason: collision with root package name */
    public final at f98232z;
    public int C = 31;
    public boolean D = false;
    private final bf I = new bf();

    be(int i3, Context context, at atVar, boolean z16, BuglyStrategy.a aVar, bm bmVar) {
        f98207a = i3;
        Context a16 = ba.a(context);
        this.E = a16;
        ak a17 = ak.a();
        this.f98231y = a17;
        this.f98232z = atVar;
        this.A = aVar;
        this.B = bmVar;
        bd bdVar = new bd(i3, a16, aq.a(), ae.a(), a17, aVar, bmVar);
        this.f98229w = bdVar;
        ai a18 = ai.a(a16);
        this.G = new bk(a16, bdVar, a17, a18);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a16, a18, bdVar, a17, atVar, z16, null);
        this.f98230x = nativeCrashHandler;
        a18.U = nativeCrashHandler;
        this.H = bn.a(a16, a17, a18, atVar, bdVar);
    }

    protected static void k() {
        try {
            com.tencent.rmonitor.base.config.data.k d16 = ConfigFetcher.g().d("crash_report");
            if (d16 instanceof w) {
                ai.f97987ae = ((w) d16).f98579b;
                av.a("crash upload with json = " + ai.f97987ae, new Object[0]);
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
    }

    public final void d() {
        this.I.f98247a = true;
        this.G.a();
    }

    public final void e() {
        this.I.f98248b = false;
        this.f98230x.setUserOpened(false);
    }

    public final void f() {
        this.I.f98248b = true;
        this.f98230x.setUserOpened(true);
    }

    public final void g() {
        this.I.f98249c = true;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.proguard.be.1
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(true);
            }
        });
        this.H.b(true);
    }

    public final void h() {
        this.I.f98249c = false;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.bugly.proguard.be.2
            @Override // java.lang.Runnable
            public final void run() {
                NativeCrashHandler.getInstance().unBlockSigquit(false);
            }
        });
        this.H.b(false);
    }

    public final synchronized void i() {
        bn.c();
    }

    public final boolean j() {
        return this.H.f98299a.get();
    }

    public final void l() {
        if (ai.c().f98016d.equals(ah.a(this.E))) {
            this.f98230x.removeEmptyNativeRecordFiles();
        }
    }

    public final boolean m() {
        if ((this.C & 16) > 0) {
            return true;
        }
        return false;
    }

    public final boolean n() {
        if ((this.C & 8) > 0) {
            return true;
        }
        return false;
    }

    public static synchronized be a(int i3, Context context, boolean z16, BuglyStrategy.a aVar, bm bmVar) {
        be beVar;
        synchronized (be.class) {
            if (F == null) {
                F = new be(i3, context, at.a(), z16, aVar, bmVar);
            }
            beVar = F;
        }
        return beVar;
    }

    public final synchronized void b() {
        bk bkVar;
        try {
            if (this.I.f98247a && (bkVar = this.G) != null) {
                bkVar.b();
            }
            NativeCrashHandler nativeCrashHandler = this.f98230x;
            if (nativeCrashHandler != null) {
                nativeCrashHandler.reRegisterNativeHandler(this.I.f98248b);
                this.f98230x.reRegisterANRHandler(this.I.f98249c);
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
    }

    public final void c() {
        this.I.f98247a = false;
        this.G.c();
    }

    static /* synthetic */ void d(be beVar) {
        bh a16 = bh.a();
        try {
            a16.f98263a = beVar.E;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a16.f98263a.getFilesDir().getCanonicalPath());
            String str = File.separator;
            sb5.append(str);
            sb5.append("bugly_custom_zips");
            sb5.append(str);
            a16.f98271i = sb5.toString();
            bh.a(new File(a16.f98271i));
            a16.f98266d = a16.b();
            a16.f98267e = a16.c();
            a16.f98268f = new UserMeta();
            ai a17 = ai.a(a16.f98263a);
            a16.f98265c = a17;
            a16.f98268f.uin = a17.g();
            UserMeta userMeta = a16.f98268f;
            ai aiVar = a16.f98265c;
            userMeta.buildNumber = aiVar.O;
            userMeta.appKey = "unknow_app_key";
            userMeta.appId = aiVar.f();
            UserMeta userMeta2 = a16.f98268f;
            userMeta2.appVersion = a16.f98265c.f98032t;
            userMeta2.sharePreference = SharedPreferencesProvider.getInstance().getSharedPreferences(a16.f98263a, SPKey.SP_NAME, true);
            a16.f98268f.crashSharedPreferences = SharedPreferencesProvider.getInstance().getSharedPreferences(a16.f98263a, Constants.BUGLY_SHARED_PREFERENCES, true);
            UserMeta userMeta3 = a16.f98268f;
            ai aiVar2 = a16.f98265c;
            userMeta3.sdkVersion = aiVar2.f98020h;
            userMeta3.setModel(aiVar2.i());
            a16.f98268f.setUniqueID(a16.f98265c.h());
            a16.f98269g = new UploadProxy(a16.f98263a, a16.f98265c.f());
            a16.f98270h = a16.f98272j + "/v1/" + ai.a(a16.f98263a).f() + "/custom/upload-file";
            a16.f98264b = Boolean.TRUE;
        } catch (Throwable th5) {
            av.b(th5);
        }
        bh.a();
        Context context = beVar.E;
        bh.a(context.getFilesDir().getAbsolutePath() + "/bugly_upload_file");
        bh.a(context.getFilesDir().getAbsolutePath() + "/bugly_upload_zip");
        bh.a();
        bh.a(beVar.E.getFilesDir().getAbsolutePath() + File.separator + "bugly_asan_zip");
    }

    static /* synthetic */ void e(be beVar) {
        try {
            List<CrashDetailBean> a16 = bd.a(bd.b());
            if (a16 == null || a16.size() <= 0) {
                return;
            }
            for (CrashDetailBean crashDetailBean : a16) {
                if (crashDetailBean.f97880f) {
                    bh.a().a(beVar.E, crashDetailBean.f97878d);
                }
            }
        } catch (Throwable th5) {
            av.a(th5);
        }
    }

    public final synchronized void a(bm bmVar) {
        bd bdVar = this.f98229w;
        if (bdVar != null) {
            bdVar.f98204f = bmVar;
        }
    }

    public static synchronized be a() {
        be beVar;
        synchronized (be.class) {
            beVar = F;
        }
        return beVar;
    }

    public final void a(StrategyBean strategyBean) {
        this.G.a(strategyBean);
        this.f98230x.onStrategyChanged(strategyBean);
        this.H.b();
    }

    public final synchronized void a(boolean z16, boolean z17, boolean z18) {
        this.f98230x.testNativeCrash(z16, z17, z18);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.f98229w.b(crashDetailBean);
    }

    public final void a(long j3, final boolean z16) {
        at.a().a(new BaseThread() { // from class: com.tencent.bugly.proguard.be.4
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public final void run() {
                boolean z17;
                be.k();
                if (!ba.a(be.this.E, "local_crash_lock")) {
                    av.c("Failed to lock file for uploading local crash.", new Object[0]);
                    return;
                }
                if (z16) {
                    be.this.f98230x.checkSaveRecordCrash();
                }
                be.d(be.this);
                be.e(be.this);
                ao a16 = ao.a.a();
                List<ao.b> a17 = ao.a();
                if (a17 != null && !a17.isEmpty()) {
                    av.c("sla load local data list size:%s", Integer.valueOf(a17.size()));
                    Iterator<ao.b> it = a17.iterator();
                    ArrayList arrayList = new ArrayList();
                    while (it.hasNext()) {
                        ao.b next = it.next();
                        if (next.f98061b < ba.b() - 604800000) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            av.c("sla local data is expired:%s", next.f98062c);
                            arrayList.add(next);
                            it.remove();
                        }
                    }
                    ao.d(arrayList);
                    a16.b(a17);
                } else {
                    av.c("sla local data is null", new Object[0]);
                }
                av.a("check db and upload record.", new Object[0]);
                List<CrashDetailBean> a18 = bd.a();
                if (a18 != null && a18.size() > 0) {
                    av.c("Size of crash list need to upload: %s", Integer.valueOf(a18.size()));
                    be.a(be.this, a18);
                } else {
                    av.c("no crash need to be uploaded at this start.", new Object[0]);
                }
                ba.b(be.this.E, "local_crash_lock");
            }
        }, j3);
    }

    private void a(final List<CrashDetailBean> list, long j3) {
        if (list.isEmpty()) {
            return;
        }
        av.c("do post a delay upload task to upload crash, delay time: ".concat(String.valueOf(j3)), new Object[0]);
        at.a().a(new BaseThread() { // from class: com.tencent.bugly.proguard.be.5
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public final void run() {
                be.this.f98229w.a(list, 0L, false, false, false);
                av.c("do upload db crash delay, upload crash num: " + list.size(), new Object[0]);
            }
        }, j3);
    }

    static /* synthetic */ void a(be beVar, List list) {
        int size = list.size();
        if (size > 20) {
            ArrayList arrayList = new ArrayList();
            Collections.sort(list);
            for (int i3 = 0; i3 < 20; i3++) {
                arrayList.add(list.get((size - 1) - i3));
            }
            list = arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (CrashDetailBean crashDetailBean : list) {
            int i16 = crashDetailBean.f97876b;
            if ((i16 == 3 && currentTimeMillis - crashDetailBean.f97900z < f98225s) || ((i16 == 0 || i16 == 1) && currentTimeMillis - crashDetailBean.f97900z < f98226t)) {
                av.c("crash may in upload process, try add to delay list, crash type: " + crashDetailBean.f97896v, new Object[0]);
                if (!crashDetailBean.f97873an) {
                    if (crashDetailBean.f97876b == 3) {
                        arrayList3.add(crashDetailBean);
                    } else {
                        arrayList4.add(crashDetailBean);
                    }
                    crashDetailBean.f97873an = true;
                    beVar.a(crashDetailBean);
                } else {
                    av.c("crash in upload delay process, do not add to delay upload list again.", new Object[0]);
                }
            } else {
                arrayList2.add(crashDetailBean);
            }
        }
        av.c("try upload crash, " + arrayList2.size() + " immediately, " + arrayList4.size() + " crash delay, " + arrayList3.size() + " anr delay.", new Object[0]);
        if (!arrayList2.isEmpty()) {
            beVar.f98229w.a(arrayList2, 0L, false, false, false);
            av.c("do upload db crash immediately, upload crash num: " + arrayList2.size(), new Object[0]);
        }
        beVar.a(arrayList3, f98225s);
        beVar.a(arrayList4, f98226t);
    }
}
