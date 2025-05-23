package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.reporter.link.PluginLinkDataProxy;
import com.tencent.bugly.common.utils.GcInfoStatHelper;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.az;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bn {

    /* renamed from: q, reason: collision with root package name */
    private static bn f98296q = null;

    /* renamed from: s, reason: collision with root package name */
    private static volatile String f98297s = null;

    /* renamed from: t, reason: collision with root package name */
    private static volatile long f98298t = -1;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityManager f98300b;

    /* renamed from: f, reason: collision with root package name */
    private final Context f98304f;

    /* renamed from: g, reason: collision with root package name */
    private final ai f98305g;

    /* renamed from: h, reason: collision with root package name */
    private final at f98306h;

    /* renamed from: i, reason: collision with root package name */
    private final ak f98307i;

    /* renamed from: j, reason: collision with root package name */
    private final bd f98308j;

    /* renamed from: l, reason: collision with root package name */
    private String f98310l;

    /* renamed from: m, reason: collision with root package name */
    private FileObserver f98311m;

    /* renamed from: o, reason: collision with root package name */
    private bv f98313o;

    /* renamed from: p, reason: collision with root package name */
    private int f98314p;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f98299a = new AtomicBoolean(false);

    /* renamed from: k, reason: collision with root package name */
    private final Object f98309k = new Object();

    /* renamed from: n, reason: collision with root package name */
    private boolean f98312n = true;

    /* renamed from: r, reason: collision with root package name */
    private long f98315r = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f98301c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f98302d = "";

    /* renamed from: e, reason: collision with root package name */
    public long f98303e = -1;

    bn(Context context, ak akVar, ai aiVar, at atVar, bd bdVar) {
        Context a16 = ba.a(context);
        this.f98304f = a16;
        this.f98300b = (ActivityManager) a16.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (ba.b(NativeCrashHandler.getDumpFilePath())) {
            this.f98310l = context.getDir("bugly", 0).getAbsolutePath();
        } else {
            this.f98310l = NativeCrashHandler.getDumpFilePath();
        }
        this.f98305g = aiVar;
        this.f98306h = atVar;
        this.f98307i = akVar;
        this.f98308j = bdVar;
    }

    private synchronized void f() {
        if (!g()) {
            av.d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f98311m.stopWatching();
            this.f98311m = null;
            av.d("close anr monitor!", new Object[0]);
        } catch (Throwable th5) {
            av.d("stop anr monitor failed!", new Object[0]);
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
    }

    private synchronized boolean g() {
        if (this.f98311m != null) {
            return true;
        }
        return false;
    }

    private synchronized boolean h() {
        return this.f98312n;
    }

    private synchronized void i() {
        if (g()) {
            av.d("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f98310l)) {
            return;
        }
        synchronized (this.f98309k) {
            bv bvVar = this.f98313o;
            if (bvVar == null || !bvVar.isAlive()) {
                bv bvVar2 = new bv();
                this.f98313o = bvVar2;
                boolean z16 = this.f98305g.Z;
                bvVar2.f98354b = z16;
                av.c("set record stack trace enable:".concat(String.valueOf(z16)), new Object[0]);
                bv bvVar3 = this.f98313o;
                StringBuilder sb5 = new StringBuilder("Bugly-ThreadMonitor");
                int i3 = this.f98314p;
                this.f98314p = i3 + 1;
                sb5.append(i3);
                bvVar3.setName(sb5.toString());
                if (this.f98305g.Z) {
                    this.f98313o.b();
                }
            }
        }
        FileObserver fileObserver = new FileObserver(this.f98310l) { // from class: com.tencent.bugly.proguard.bn.4
            @Override // android.os.FileObserver
            public final void onEvent(int i16, String str) {
                if (str == null) {
                    return;
                }
                av.d("observe file, dir:%s fileName:%s", bn.this.f98310l, str);
                if (!bn.a(str)) {
                    av.c("not manual trace file, ignore.", new Object[0]);
                    return;
                }
                if (!bn.this.f98299a.get()) {
                    av.c("proc is not in anr, just ignore", new Object[0]);
                    return;
                }
                long a16 = aw.a(str, "manual_bugly_trace_", ".txt");
                bn.this.a(a16, bn.this.f98310l + "/" + str);
            }
        };
        this.f98311m = fileObserver;
        try {
            fileObserver.startWatching();
            av.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f98310l);
            this.f98306h.a(new Runnable() { // from class: com.tencent.bugly.proguard.bn.5
                @Override // java.lang.Runnable
                public final void run() {
                    bn.b(bn.this);
                }
            });
        } catch (Throwable th5) {
            this.f98311m = null;
            av.d("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
    }

    private synchronized void j() {
        if (!g()) {
            av.d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.f98309k) {
            bv bvVar = this.f98313o;
            if (bvVar != null) {
                bvVar.a();
                this.f98313o = null;
            }
        }
        av.a("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f98311m.stopWatching();
            this.f98311m = null;
            av.d("close anr monitor!", new Object[0]);
        } catch (Throwable th5) {
            av.d("stop anr monitor failed!", new Object[0]);
            if (!av.a(th5)) {
                th5.printStackTrace();
            }
        }
    }

    public final void b(boolean z16) {
        d(z16);
        boolean h16 = h();
        ak a16 = ak.a();
        if (a16 != null) {
            h16 = h16 && a16.c().f97841f;
        }
        if (h16 != g()) {
            av.a("anr changed to %b", Boolean.valueOf(h16));
            c(h16);
        }
    }

    private synchronized void c(boolean z16) {
        if (z16) {
            i();
        } else {
            j();
        }
    }

    private synchronized void d(boolean z16) {
        if (this.f98312n != z16) {
            av.a("user change anr %b", Boolean.valueOf(z16));
            this.f98312n = z16;
        }
    }

    private synchronized void e() {
        if (g()) {
            av.d("start when started!", new Object[0]);
            return;
        }
        FileObserver fileObserver = new FileObserver("/data/anr/") { // from class: com.tencent.bugly.proguard.bn.1
            @Override // android.os.FileObserver
            public final void onEvent(int i3, String str) {
                if (str == null) {
                    return;
                }
                final String concat = "/data/anr/".concat(str);
                av.d("watching file %s", concat);
                if (!concat.contains("trace")) {
                    av.d("not anr file %s", concat);
                } else {
                    bn.this.f98306h.a(new Runnable() { // from class: com.tencent.bugly.proguard.bn.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            bn.a(bn.this, concat);
                        }
                    });
                }
            }
        };
        this.f98311m = fileObserver;
        try {
            fileObserver.startWatching();
            av.a("start anr monitor!", new Object[0]);
            this.f98306h.a(new Runnable() { // from class: com.tencent.bugly.proguard.bn.2
                @Override // java.lang.Runnable
                public final void run() {
                    bn.b(bn.this);
                }
            });
        } catch (Throwable th5) {
            this.f98311m = null;
            av.d("start anr monitor failed!", new Object[0]);
            if (av.a(th5)) {
                return;
            }
            th5.printStackTrace();
        }
    }

    public static bn a(Context context, ak akVar, ai aiVar, at atVar, bd bdVar) {
        if (f98296q == null) {
            f98296q = new bn(context, akVar, aiVar, atVar, bdVar);
        }
        return f98296q;
    }

    public static void c() {
        int i3 = 0;
        while (true) {
            int i16 = i3 + 1;
            if (i3 >= 30) {
                return;
            }
            try {
                av.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i16));
                ba.b(5000L);
                i3 = i16;
            } catch (Throwable th5) {
                if (av.a(th5)) {
                    return;
                }
                th5.printStackTrace();
                return;
            }
        }
    }

    public static synchronized bn a() {
        bn bnVar;
        synchronized (bn.class) {
            bnVar = f98296q;
        }
        return bnVar;
    }

    public final boolean d() {
        try {
            av.a("preDumpAnrInfo", new Object[0]);
            this.f98303e = System.currentTimeMillis();
            if (u.a().f98572b) {
                this.f98301c = new bp(u.a().f98571a, PluginLinkDataProxy.getInstance()).a();
                av.c("pre save main thread's message schedule info", new Object[0]);
            }
            this.f98302d = ba.a(Looper.getMainLooper().getThread());
            return true;
        } catch (Throwable th5) {
            av.b(th5);
            return true;
        }
    }

    private CrashDetailBean a(String str, CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            try {
                crashDetailBean = new CrashDetailBean();
            } catch (Throwable th5) {
                av.b(th5);
                return null;
            }
        }
        if (crashDetailBean.f97900z < 0) {
            long j3 = this.f98303e;
            if (j3 != -1) {
                crashDetailBean.f97900z = j3;
            } else {
                crashDetailBean.f97900z = System.currentTimeMillis();
            }
        }
        crashDetailBean.f97876b = 3;
        crashDetailBean.f97896v = "ANR_EXCEPTION";
        if (TextUtils.isEmpty(str)) {
            str = "main stack is null , some error may be encountered.";
        }
        crashDetailBean.f97899y = str;
        crashDetailBean.I = this.f98305g.f98016d;
        return crashDetailBean;
    }

    public final synchronized void b() {
        av.d("customer decides whether to open or close.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[Catch: all -> 0x00ff, TryCatch #3 {all -> 0x00ff, blocks: (B:3:0x0004, B:4:0x0006, B:10:0x0019, B:12:0x0043, B:14:0x0049, B:18:0x0053, B:21:0x0064, B:23:0x0075, B:24:0x00dc, B:25:0x00de, B:37:0x00fb, B:40:0x0086, B:43:0x0090, B:45:0x00a0, B:46:0x00aa, B:48:0x00b0, B:49:0x00c1, B:52:0x00cc, B:54:0x00d2, B:55:0x00d7, B:57:0x00b9, B:58:0x008e, B:59:0x0084, B:61:0x006d, B:65:0x00fe, B:27:0x00df, B:29:0x00e3, B:30:0x00f0, B:6:0x0007, B:8:0x000b, B:9:0x0018), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075 A[Catch: all -> 0x00ff, TryCatch #3 {all -> 0x00ff, blocks: (B:3:0x0004, B:4:0x0006, B:10:0x0019, B:12:0x0043, B:14:0x0049, B:18:0x0053, B:21:0x0064, B:23:0x0075, B:24:0x00dc, B:25:0x00de, B:37:0x00fb, B:40:0x0086, B:43:0x0090, B:45:0x00a0, B:46:0x00aa, B:48:0x00b0, B:49:0x00c1, B:52:0x00cc, B:54:0x00d2, B:55:0x00d7, B:57:0x00b9, B:58:0x008e, B:59:0x0084, B:61:0x006d, B:65:0x00fe, B:27:0x00df, B:29:0x00e3, B:30:0x00f0, B:6:0x0007, B:8:0x000b, B:9:0x0018), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(CrashDetailBean crashDetailBean) {
        CrashDetailBean a16;
        ActivityManager.ProcessErrorStateInfo a17;
        boolean z16;
        try {
            synchronized (this.f98309k) {
                if (this.f98313o != null) {
                    av.c("Disable record main stack trace.", new Object[0]);
                    this.f98313o.c();
                }
            }
            a16 = a(crashDetailBean);
            NativeCrashHandler.getInstance().saveAdditionalAttachmentPaths(QZoneAppCtrlUploadFileLogic.ANR_LOG_DIRECTORY);
            NativeCrashHandler.getInstance().getProcessInfoAnr();
            NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98175g - 1, false);
        } finally {
            try {
            } finally {
            }
        }
        if (this.f98305g.b()) {
            if (!aj.q() && !aj.r()) {
                z16 = false;
                av.c("isAnrCrashDevice:%s", Boolean.valueOf(z16));
                if (z16) {
                    a17 = bo.a(this.f98300b, 21000L);
                    if (a16 != null) {
                        av.e("pack anr fail!", new Object[0]);
                    } else {
                        a16.f97897w = a17 == null ? "Find process anr, but unable to get anr message." : a17.shortMsg;
                        String str = a17 == null ? "" : a17.longMsg;
                        a16.f97863ad.put("BUGLY_CR_01", str);
                        if (str.length() >= 50) {
                            NativeCrashHandler.getInstance().modifyAttachmentState(az.a.f98164g - 1);
                        }
                        if (a16.f97859a >= 0) {
                            av.a("backup anr record success!", new Object[0]);
                        } else {
                            av.d("backup anr record fail!", new Object[0]);
                        }
                        if (!this.f98308j.a(a16, !aj.t())) {
                            this.f98308j.b(a16, true);
                        }
                        this.f98308j.a(a16);
                    }
                    synchronized (this.f98309k) {
                        if (this.f98313o != null) {
                            av.c("Finish anr process.", new Object[0]);
                            this.f98313o.d();
                        }
                    }
                    return;
                }
            }
            z16 = true;
            av.c("isAnrCrashDevice:%s", Boolean.valueOf(z16));
            if (z16) {
            }
        }
        a17 = bo.a(this.f98300b, 0L);
        if (a16 != null) {
        }
        synchronized (this.f98309k) {
        }
    }

    private static boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.f97909d) != null && !map.isEmpty()) {
            StringBuilder sb5 = new StringBuilder(1024);
            String[] strArr = readTargetDumpInfo.f97909d.get("main");
            if (strArr != null && strArr.length >= 3) {
                sb5.append("\"main\" tid=");
                sb5.append(strArr[2]);
                sb5.append(" :\n");
                sb5.append(strArr[0]);
                sb5.append("\n");
                sb5.append(strArr[1]);
                sb5.append("\n\n");
            }
            for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f97909d.entrySet()) {
                if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                    sb5.append("\"");
                    sb5.append(entry.getKey());
                    sb5.append("\" tid=");
                    sb5.append(entry.getValue()[2]);
                    sb5.append(" :\n");
                    sb5.append(entry.getValue()[0]);
                    sb5.append("\n");
                    sb5.append(entry.getValue()[1]);
                    sb5.append("\n\n");
                }
            }
            return aw.a(str2, sb5.toString(), sb5.length() * 2);
        }
        av.e("not found trace dump for %s", str3);
        return false;
    }

    private CrashDetailBean a(CrashDetailBean crashDetailBean) {
        NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98171c - 1, false);
        String str = this.f98302d;
        if (TextUtils.isEmpty(str)) {
            str = ba.a(Looper.getMainLooper().getThread());
        }
        NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98172d - 1, false, str.length() > 0);
        CrashDetailBean a16 = a(str, crashDetailBean);
        if (a16 == null) {
            av.e("pack anr fail!", new Object[0]);
            return null;
        }
        GcInfoStatHelper gcInfoStatHelper = GcInfoStatHelper.getInstance();
        long j3 = a16.f97900z;
        JSONObject json = gcInfoStatHelper.toJSON(j3 - 60000, j3);
        if (json != null) {
            a16.f97875ap = json.toString();
        }
        this.f98308j.b(a16);
        NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98173e - 1, true);
        try {
            if (u.a().f98572b) {
                String str2 = this.f98301c;
                if (TextUtils.isEmpty(str2)) {
                    str2 = new bp(u.a().f98571a, PluginLinkDataProxy.getInstance()).a();
                }
                av.c("save main thread's message schedule info", new Object[0]);
                StringBuilder sb5 = new StringBuilder();
                bh.a();
                sb5.append(bh.a(this.f98304f, QZoneAppCtrlUploadFileLogic.ANR_LOG_DIRECTORY, ai.f97988af));
                sb5.append(File.separator);
                File file = new File(sb5.toString());
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "main_thread_msg.json");
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                aw.a(file2, str2, TTL.MAX_VALUE, false);
                if (!TextUtils.isEmpty(str2)) {
                    NativeCrashHandler.getInstance().modifyAttachmentState(az.a.f98162e - 1);
                }
            }
        } catch (Throwable th5) {
            av.b(th5);
        }
        NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98174f - 1, false);
        for (int i3 = 0; i3 < 10000; i3 += 100) {
            if (f98298t != -1 && f98297s != null) {
                a16.f97900z = f98298t;
                a16.D = f98297s;
                this.f98308j.b(a16);
                break;
            }
            ba.b(100L);
        }
        try {
            a16.K = aj.l();
            a16.L = aj.f();
            a16.M = aj.n();
            a16.N = this.f98305g.l();
            a16.O = this.f98305g.k();
            a16.P = this.f98305g.m();
            a16.Q = aj.a(this.f98304f);
            a16.R = aj.g();
            a16.S = aj.h();
            a16.T = aj.i();
            a16.U = aj.j();
            ai aiVar = this.f98305g;
            a16.f97885k = aiVar.f98032t;
            a16.f97884j = aiVar.f98020h;
            a16.f97886l = aiVar.O;
            a16.f97887m = aiVar.f98035w;
            a16.f97889o = LifecycleCallback.G.h();
            ai aiVar2 = this.f98305g;
            a16.f97881g = aiVar2.R;
            a16.f97888n = aiVar2.r();
            a16.f97895u = this.f98305g.g();
            a16.f97883i = this.f98305g.i();
            a16.f97882h = this.f98305g.h();
            a16.f97863ad = new HashMap();
            String str3 = a16.f97899y;
            int indexOf = str3 != null ? str3.indexOf("\n") : -1;
            a16.f97898x = indexOf > 0 ? a16.f97899y.substring(0, indexOf) : "GET_FAIL";
            String str4 = a16.f97899y;
            if (str4 != null) {
                a16.C = ba.c(str4.getBytes());
            }
            a16.J = "main(1)";
            a16.V = this.f98305g.t();
            a16.f97890p = this.f98305g.q();
            a16.f97891q = this.f98305g.B();
            ai aiVar3 = this.f98305g;
            a16.Z = aiVar3.C;
            a16.f97860aa = aiVar3.f97991a;
            a16.f97861ab = aiVar3.b();
            a16.f97864ae = this.f98305g.A();
            ai aiVar4 = this.f98305g;
            a16.f97865af = aiVar4.F;
            a16.f97866ag = aiVar4.u();
            a16.f97867ah = this.f98305g.z();
            a16.f97871al = HotPatchWrapper.getInstance().getAppHotPatchNum();
            a16.f97872am = HotPatchWrapper.getInstance().getBaseInHotfixRFix();
            List<String> list = a16.f97889o;
            if (list != null && !list.isEmpty()) {
                NativeCrashHandler.getInstance().modifyAttachmentState(az.a.f98159b - 1);
            }
        } catch (Throwable th6) {
            if (!av.a(th6)) {
                th6.printStackTrace();
            }
        }
        this.f98308j.b(a16);
        bd.a(QZoneAppCtrlUploadFileLogic.ANR_PATH, ba.a(), a16.I, "main", a16.f97899y, a16);
        a16.H = ba.a(this.f98305g.Y, be.f98215i, false);
        String a17 = ba.a(this.f98304f, NativeCrashHandler.getInstance());
        a16.f97869aj = a17;
        if (a17 != null && a17.length() >= 50) {
            NativeCrashHandler.getInstance().modifyAttachmentState(az.a.f98158a - 1);
        }
        bi.a(a16);
        this.f98308j.b(a16);
        a16.G = ay.a();
        return a16;
    }

    static /* synthetic */ void b(bn bnVar) {
        long currentTimeMillis = (be.f98217k + System.currentTimeMillis()) - ba.b();
        aw.a(bnVar.f98310l, "bugly_trace_", ".txt", currentTimeMillis);
        aw.a(bnVar.f98310l, "manual_bugly_trace_", ".txt", currentTimeMillis);
        aw.a(bnVar.f98310l, "main_stack_record_", ".txt", currentTimeMillis);
        aw.a(bnVar.f98310l, "main_stack_record_", ".txt.merged", currentTimeMillis);
    }

    private static String a(List<bq> list, long j3) {
        if (list == null || list.isEmpty()) {
            return "main thread stack not enable\n";
        }
        StringBuilder sb5 = new StringBuilder(4096);
        sb5.append("\n>>>>> \u4ee5\u4e0b\u4e3aanr\u8fc7\u7a0b\u4e2d\u4e3b\u7ebf\u7a0b\u5806\u6808\u8bb0\u5f55\uff0c\u53ef\u6839\u636e\u5806\u6808\u51fa\u73b0\u6b21\u6570\u63a8\u6d4b\u5728\u8be5\u5806\u6808\u963b\u585e\u7684\u65f6\u95f4\uff0c\u51fa\u73b0\u6b21\u6570\u8d8a\u591a\u5bf9anr\u8d21\u732e\u8d8a\u5927\uff0c\u8d8a\u53ef\u80fd\u662f\u9020\u6210anr\u7684\u539f\u56e0 >>>>>\n");
        sb5.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
        for (int i3 = 0; i3 < list.size(); i3++) {
            bq bqVar = list.get(i3);
            sb5.append("Thread name:");
            sb5.append(bqVar.f98325a);
            sb5.append("\n");
            long j16 = bqVar.f98326b - j3;
            String str = j16 <= 0 ? "before " : "after ";
            sb5.append("Got ");
            sb5.append(str);
            sb5.append("anr:");
            sb5.append(Math.abs(j16));
            sb5.append("ms\n");
            sb5.append(bqVar.f98327c);
            sb5.append("\n");
            if (sb5.length() * 2 >= 101376) {
                break;
            }
        }
        sb5.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
        return sb5.toString();
    }

    public final boolean a(boolean z16) {
        boolean compareAndSet = this.f98299a.compareAndSet(!z16, z16);
        av.c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z16), Boolean.valueOf(compareAndSet));
        return compareAndSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j3, String str) {
        List<bq> list;
        bu buVar;
        av.c("anr time:%s", Long.valueOf(j3));
        av.c("trace file:%s", str);
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            File file = new File(this.f98310l, "bugly_trace_" + j3 + ".txt");
            av.c("trace file exists", new Object[0]);
            if (str.startsWith("/data/anr/")) {
                av.a("backup trace isOK:%s", Boolean.valueOf(a(str, file.getAbsolutePath(), ah.a(Process.myPid()))));
            } else {
                av.a("trace file rename :%s", Boolean.valueOf(new File(str).renameTo(file)));
            }
            synchronized (this.f98309k) {
                bv bvVar = this.f98313o;
                list = null;
                if (bvVar != null && (buVar = bvVar.f98353a) != null) {
                    list = buVar.c();
                }
            }
            if (list != null) {
                String a16 = a(list, j3);
                av.c("save main stack trace", new Object[0]);
                aw.a(file, a16, TTL.MAX_VALUE, true);
            }
            f98298t = j3;
            f98297s = file.getAbsolutePath();
            return;
        }
        av.c("trace file is null or not exists, just ignore", new Object[0]);
    }

    public final boolean a(long j3) {
        if (Math.abs(j3 - this.f98315r) < 10000) {
            av.d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.f98315r = j3;
        return false;
    }

    static /* synthetic */ void a(bn bnVar, String str) {
        if (bnVar.a(true)) {
            try {
                av.c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j3 = readFirstDumpInfo != null ? readFirstDumpInfo.f97908c : -1L;
                if (j3 == -1) {
                    av.d("trace dump fail could not get time!", new Object[0]);
                    j3 = System.currentTimeMillis();
                }
                if (bnVar.a(j3)) {
                    return;
                }
                NativeCrashHandler.getInstance().recordProcessingState(QZoneAppCtrlUploadFileLogic.ANR_PATH, az.b.f98169a - 1);
                bnVar.a(j3, str);
                CrashDetailBean crashDetailBean = new CrashDetailBean();
                crashDetailBean.f97900z = f98298t;
                crashDetailBean.D = f98297s;
                bnVar.f98308j.b(crashDetailBean);
                NativeCrashHandler.getInstance().modifyProcessingState(az.b.f98170b - 1, true);
                bnVar.b(crashDetailBean);
            } catch (Throwable th5) {
                if (!av.a(th5)) {
                    th5.printStackTrace();
                }
                av.e("handle anr error %s", th5.getClass().toString());
            }
        }
    }

    static /* synthetic */ boolean a(String str) {
        return str.startsWith("manual_bugly_trace_") && str.endsWith(".txt");
    }
}
