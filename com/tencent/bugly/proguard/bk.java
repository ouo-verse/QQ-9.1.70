package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.bugly.common.config.configs.CommonConfig;
import com.tencent.bugly.common.hotpatch.HotPatchWrapper;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.HprofFileIUtil;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.az;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.rmonitor.base.config.ConfigFetcher;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class bk implements Thread.UncaughtExceptionHandler {

    /* renamed from: h, reason: collision with root package name */
    private static String f98285h;

    /* renamed from: i, reason: collision with root package name */
    private static final Object f98286i = new Object();

    /* renamed from: a, reason: collision with root package name */
    protected final Context f98287a;

    /* renamed from: b, reason: collision with root package name */
    protected final bd f98288b;

    /* renamed from: c, reason: collision with root package name */
    protected final ak f98289c;

    /* renamed from: d, reason: collision with root package name */
    protected final ai f98290d;

    /* renamed from: e, reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f98291e;

    /* renamed from: f, reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f98292f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f98293g = false;

    /* renamed from: j, reason: collision with root package name */
    private int f98294j;

    public bk(Context context, bd bdVar, ak akVar, ai aiVar) {
        this.f98287a = context;
        this.f98288b = bdVar;
        this.f98289c = akVar;
        this.f98290d = aiVar;
    }

    private static void d() {
        av.e("current process die", new Object[0]);
        SystemMethodProxy.killProcess(Process.myPid());
        System.exit(1);
    }

    public final synchronized void a() {
        if (this.f98294j >= 10) {
            av.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f98293g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (bk.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                av.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f98292f = defaultUncaughtExceptionHandler;
            } else {
                av.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
            }
            this.f98291e = defaultUncaughtExceptionHandler;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f98294j++;
        av.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null && defaultUncaughtExceptionHandler.getClass().getName().equals(bk.class.getName())) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public final synchronized void c() {
        this.f98293g = false;
        av.a("close java monitor!", new Object[0]);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null && bk.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
            av.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f98291e);
            this.f98294j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th5) {
        synchronized (f98286i) {
            a(thread, th5, true, null, null, this.f98290d.X);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x027e A[Catch: all -> 0x02af, TryCatch #0 {all -> 0x02af, blocks: (B:51:0x026b, B:42:0x0276, B:46:0x027e, B:48:0x028d, B:62:0x028f), top: B:50:0x026b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x028d A[Catch: all -> 0x02af, TryCatch #0 {all -> 0x02af, blocks: (B:51:0x026b, B:42:0x0276, B:46:0x027e, B:48:0x028d, B:62:0x028f), top: B:50:0x026b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CrashDetailBean a(Thread thread, Throwable th5, boolean z16, String str, byte[] bArr) {
        String a16;
        boolean z17;
        boolean z18;
        if (th5 == null) {
            av.d("We can do nothing with a null throwable.", new Object[0]);
            az.a().a(az.b.f98170b - 1, true, z16);
            return null;
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f97900z = System.currentTimeMillis();
        crashDetailBean.f97876b = z16 ? 0 : 2;
        crashDetailBean.I = this.f98290d.f98016d;
        crashDetailBean.J = thread.getName() + "(" + thread.getId() + ")";
        String name = th5.getClass().getName();
        String a17 = a(th5);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(th5.getStackTrace().length);
        objArr[1] = Boolean.valueOf(th5.getCause() != null);
        av.e("stack frame :%d, has cause %b", objArr);
        String str2 = "";
        String stackTraceElement = th5.getStackTrace().length > 0 ? th5.getStackTrace()[0].toString() : "";
        Throwable th6 = th5;
        while (th6 != null && th6.getCause() != null) {
            th6 = th6.getCause();
        }
        if (th6 != null && th6 != th5) {
            crashDetailBean.f97896v = th6.getClass().getName();
            crashDetailBean.f97897w = a(th6);
            if (th6.getStackTrace().length > 0) {
                crashDetailBean.f97898x = th6.getStackTrace()[0].toString();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(name);
            sb5.append(":");
            sb5.append(a17);
            sb5.append("\n");
            sb5.append(stackTraceElement);
            sb5.append("\n......");
            sb5.append("\nCaused by:\n");
            sb5.append(crashDetailBean.f97896v);
            sb5.append(":");
            sb5.append(crashDetailBean.f97897w);
            sb5.append("\n");
            a16 = a(th6, be.f98215i);
            sb5.append(a16);
            crashDetailBean.f97899y = sb5.toString();
        } else {
            crashDetailBean.f97896v = name;
            if (be.a().j() && z16) {
                av.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str2 = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.f97897w = a17 + str2;
            crashDetailBean.f97898x = stackTraceElement;
            a16 = a(th5, be.f98215i);
            crashDetailBean.f97899y = a16;
        }
        this.f98288b.b(crashDetailBean);
        az.a().a(az.b.f98171c - 1, true, z16);
        crashDetailBean.f97895u = this.f98290d.g();
        crashDetailBean.f97882h = this.f98290d.h();
        crashDetailBean.f97883i = this.f98290d.i();
        ai aiVar = this.f98290d;
        crashDetailBean.f97885k = aiVar.f98032t;
        crashDetailBean.f97884j = aiVar.f98020h;
        crashDetailBean.f97886l = aiVar.O;
        crashDetailBean.f97887m = aiVar.f98035w;
        crashDetailBean.f97889o = LifecycleCallback.G.h();
        ai aiVar2 = this.f98290d;
        crashDetailBean.f97881g = aiVar2.R;
        crashDetailBean.f97888n = aiVar2.r();
        crashDetailBean.V = this.f98290d.t();
        crashDetailBean.f97890p = this.f98290d.q();
        crashDetailBean.f97891q = this.f98290d.B();
        ai aiVar3 = this.f98290d;
        crashDetailBean.f97860aa = aiVar3.f97991a;
        crashDetailBean.f97861ab = aiVar3.b();
        crashDetailBean.C = ba.c(crashDetailBean.f97899y.getBytes());
        HashMap hashMap = new HashMap();
        crashDetailBean.H = hashMap;
        hashMap.put(crashDetailBean.J, a16);
        crashDetailBean.f97871al = HotPatchWrapper.getInstance().getAppHotPatchNum();
        crashDetailBean.f97872am = HotPatchWrapper.getInstance().getBaseInHotfixRFix();
        List<String> list = crashDetailBean.f97889o;
        if (list != null && !list.isEmpty()) {
            az.a().a(az.a.f98159b - 1, z16);
        }
        az.a().a(az.b.f98172d - 1, false, z16);
        crashDetailBean.K = aj.l();
        crashDetailBean.L = aj.f();
        crashDetailBean.M = aj.n();
        crashDetailBean.N = this.f98290d.l();
        crashDetailBean.O = this.f98290d.k();
        crashDetailBean.P = this.f98290d.m();
        if (!z16 && ai.C() >= 31) {
            crashDetailBean.Q = 0L;
        } else {
            crashDetailBean.Q = aj.a(this.f98287a);
        }
        crashDetailBean.R = aj.g();
        crashDetailBean.S = aj.h();
        crashDetailBean.T = aj.i();
        crashDetailBean.U = aj.j();
        az.a().a(az.b.f98173e - 1, false, z16);
        if (!z16) {
            if (str != null) {
                try {
                    if (str.length() > 0) {
                        z17 = true;
                        z18 = bArr == null && bArr.length > 0;
                        if (z17) {
                            HashMap hashMap2 = new HashMap(1);
                            crashDetailBean.f97862ac = hashMap2;
                            hashMap2.put("UserData", str);
                        }
                        if (z18) {
                            crashDetailBean.f97868ai = bArr;
                        }
                    }
                } catch (Throwable th7) {
                    av.e("handle crash error %s", th7.toString());
                }
            }
            z17 = false;
            if (bArr == null) {
            }
            if (z17) {
            }
            if (z18) {
            }
        }
        crashDetailBean.f97864ae = this.f98290d.A();
        ai aiVar4 = this.f98290d;
        crashDetailBean.f97865af = aiVar4.F;
        crashDetailBean.f97866ag = aiVar4.u();
        crashDetailBean.f97867ah = this.f98290d.z();
        bi.a(crashDetailBean);
        this.f98288b.b(crashDetailBean);
        az.a().a(az.b.f98174f - 1, true, z16);
        byte[] a18 = ay.a();
        crashDetailBean.G = a18;
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(a18 == null ? 0 : a18.length);
        av.a("user log size:%d", objArr2);
        return crashDetailBean;
    }

    private static boolean a(Thread thread) {
        synchronized (f98286i) {
            if (f98285h != null && thread.getName().equals(f98285h)) {
                return true;
            }
            f98285h = thread.getName();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0372 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0265 A[Catch: all -> 0x0320, TryCatch #1 {all -> 0x0320, blocks: (B:189:0x01dd, B:191:0x0265, B:193:0x0268, B:195:0x0294, B:196:0x02ae, B:198:0x02b6, B:200:0x02c3, B:203:0x029f, B:204:0x02fb), top: B:188:0x01dd, outer: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0483 A[Catch: all -> 0x050f, TryCatch #12 {all -> 0x050f, blocks: (B:79:0x0460, B:81:0x0468, B:83:0x047c, B:85:0x0483, B:87:0x049c, B:89:0x04a4, B:91:0x04b8, B:92:0x04c6, B:144:0x045d), top: B:143:0x045d }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x052d A[Catch: all -> 0x0570, TRY_LEAVE, TryCatch #14 {all -> 0x0570, blocks: (B:97:0x0527, B:99:0x052d), top: B:96:0x0527 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Thread thread, Throwable th5, boolean z16, String str, byte[] bArr, boolean z17) {
        String str2;
        Throwable th6;
        Thread thread2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        byte[] bArr2;
        FileInputStream fileInputStream;
        byte[] bArr3;
        Throwable th7;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr4;
        RandomAccessFile randomAccessFile;
        String str9;
        String charBuffer;
        Path path;
        CrashDetailBean a16;
        String str10;
        String str11;
        String str12 = "system handle end!";
        if (z16) {
            av.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                av.a("this class has handled this exception", new Object[0]);
                if (this.f98292f != null) {
                    av.a("call system handler", new Object[0]);
                    this.f98292f.uncaughtException(thread, th5);
                } else {
                    d();
                }
            }
        } else {
            av.e("Java Catch Happen", new Object[0]);
        }
        try {
        } catch (Throwable th8) {
            th = th8;
            str2 = "system handle end!";
            th6 = th5;
            thread2 = thread;
            str3 = "crashreport last handle end!";
            str4 = "crashreport last handle start!";
        }
        if (!this.f98293g) {
            av.c("Java crash handler is disable. Just return.", new Object[0]);
            if (z16) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f98291e;
                if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                    av.e("sys default last handle start!", new Object[0]);
                    this.f98291e.uncaughtException(thread, th5);
                    av.e("sys default last handle end!", new Object[0]);
                    return;
                } else if (this.f98292f != null) {
                    av.e("system handle start!", new Object[0]);
                    this.f98292f.uncaughtException(thread, th5);
                    av.e("system handle end!", new Object[0]);
                    return;
                } else {
                    av.e("crashreport last handle start!", new Object[0]);
                    d();
                    av.e("crashreport last handle end!", new Object[0]);
                    return;
                }
            }
            return;
        }
        if (!this.f98289c.b()) {
            av.d("no remote but still store!", new Object[0]);
        }
        if (!this.f98289c.c().f97841f && this.f98289c.b()) {
            av.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
            bd.a(z16 ? "JAVA_CRASH" : "JAVA_CATCH", ba.a(), this.f98290d.f98016d, thread.getName(), ba.a(th5), null);
            if (z16) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f98291e;
                if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                    av.e("sys default last handle start!", new Object[0]);
                    this.f98291e.uncaughtException(thread, th5);
                    av.e("sys default last handle end!", new Object[0]);
                    return;
                } else if (this.f98292f != null) {
                    av.e("system handle start!", new Object[0]);
                    this.f98292f.uncaughtException(thread, th5);
                    av.e("system handle end!", new Object[0]);
                    return;
                } else {
                    av.e("crashreport last handle start!", new Object[0]);
                    d();
                    av.e("crashreport last handle end!", new Object[0]);
                    return;
                }
            }
            return;
        }
        az a17 = az.a();
        int i3 = az.b.f98169a - 1;
        try {
            if (z16) {
                try {
                } catch (Throwable th9) {
                    th = th9;
                    thread2 = thread;
                    str2 = "system handle end!";
                    str3 = "crashreport last handle end!";
                    str4 = "crashreport last handle start!";
                    th6 = th5;
                }
                if (a17.f98152c) {
                    a17.f98153d = true;
                } else {
                    try {
                        File file = new File(a17.f98155f);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        str6 = "crashreport last handle end!";
                        str8 = "JAVA_CATCH";
                        try {
                            byte[] bArr5 = new byte[0];
                            if (AndroidVersion.isOverO()) {
                                path = file.toPath();
                                bArr2 = Files.readAllBytes(path);
                                str5 = "system handle end!";
                                str7 = "crashreport last handle start!";
                            } else {
                                try {
                                    fileInputStream = new FileInputStream(file);
                                    try {
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        bArr3 = bArr5;
                                    } catch (Throwable th10) {
                                        th = th10;
                                        str5 = "system handle end!";
                                        bArr3 = bArr5;
                                    }
                                    try {
                                        bArr4 = new byte[4096];
                                        str7 = "crashreport last handle start!";
                                    } catch (Throwable th11) {
                                        th = th11;
                                        str5 = "system handle end!";
                                        str7 = "crashreport last handle start!";
                                        th7 = th;
                                        try {
                                            throw th7;
                                        } catch (Throwable th12) {
                                            try {
                                                try {
                                                    fileInputStream.close();
                                                    throw th12;
                                                } catch (Throwable th13) {
                                                    th = th13;
                                                    bArr5 = bArr3;
                                                    try {
                                                        av.b(th);
                                                        bArr2 = bArr5;
                                                        randomAccessFile = new RandomAccessFile(file, "rw");
                                                        a17.f98151b = randomAccessFile.getChannel();
                                                        str9 = i3 + "\t0\t0\t0000000000000000\t" + ai.f97988af + "\t" + a17.f98154e.f98016d + "\t" + a17.f98154e.f98032t + "\t" + a17.f98154e.f98020h + "\t" + a17.f98154e.i() + "\t" + a17.f98154e.f98023k + "\tJAVA_CRASH#" + th5.getClass().getName() + "\t" + (((int) (System.currentTimeMillis() - a17.f98154e.f97991a)) / 1000) + "\t" + a17.f98154e.b() + "\n";
                                                        if (bArr2 == null) {
                                                        }
                                                        MappedByteBuffer map = a17.f98151b.map(FileChannel.MapMode.READ_WRITE, 0L, str9.length());
                                                        a17.f98150a = map;
                                                        map.put(str9.getBytes());
                                                        a17.f98150a.force();
                                                        randomAccessFile.close();
                                                        a17.f98152c = true;
                                                    } catch (Throwable th14) {
                                                        th = th14;
                                                        try {
                                                            av.e("record processing file failed!\n".concat(String.valueOf(th)), new Object[0]);
                                                            a16 = a(thread, th5, z16, str, bArr);
                                                            if (a16 != null) {
                                                            }
                                                        } catch (Throwable th15) {
                                                            th = th15;
                                                            thread2 = thread;
                                                            th6 = th5;
                                                            str3 = str6;
                                                            str4 = str7;
                                                            str2 = str5;
                                                        }
                                                        if (!av.a(th)) {
                                                        }
                                                        if (z16) {
                                                        }
                                                    }
                                                    a16 = a(thread, th5, z16, str, bArr);
                                                    if (a16 != null) {
                                                    }
                                                    if (!av.a(th)) {
                                                    }
                                                    if (z16) {
                                                    }
                                                }
                                            } catch (Throwable th16) {
                                                th7.addSuppressed(th16);
                                                throw th12;
                                            }
                                        }
                                    }
                                    while (true) {
                                        try {
                                            int read = fileInputStream.read(bArr4);
                                            str5 = str12;
                                            if (read == -1) {
                                                break;
                                            }
                                            try {
                                                byteArrayOutputStream.write(bArr4, 0, read);
                                                str12 = str5;
                                            } catch (Throwable th17) {
                                                th = th17;
                                            }
                                            th = th17;
                                        } catch (Throwable th18) {
                                            th = th18;
                                            str5 = str12;
                                        }
                                        th7 = th;
                                        throw th7;
                                    }
                                    bArr5 = byteArrayOutputStream.toByteArray();
                                } catch (Throwable th19) {
                                    th = th19;
                                    str5 = "system handle end!";
                                    str7 = "crashreport last handle start!";
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th20) {
                                    th = th20;
                                    av.b(th);
                                    bArr2 = bArr5;
                                    randomAccessFile = new RandomAccessFile(file, "rw");
                                    a17.f98151b = randomAccessFile.getChannel();
                                    str9 = i3 + "\t0\t0\t0000000000000000\t" + ai.f97988af + "\t" + a17.f98154e.f98016d + "\t" + a17.f98154e.f98032t + "\t" + a17.f98154e.f98020h + "\t" + a17.f98154e.i() + "\t" + a17.f98154e.f98023k + "\tJAVA_CRASH#" + th5.getClass().getName() + "\t" + (((int) (System.currentTimeMillis() - a17.f98154e.f97991a)) / 1000) + "\t" + a17.f98154e.b() + "\n";
                                    if (bArr2 == null) {
                                    }
                                    MappedByteBuffer map2 = a17.f98151b.map(FileChannel.MapMode.READ_WRITE, 0L, str9.length());
                                    a17.f98150a = map2;
                                    map2.put(str9.getBytes());
                                    a17.f98150a.force();
                                    randomAccessFile.close();
                                    a17.f98152c = true;
                                    a16 = a(thread, th5, z16, str, bArr);
                                    if (a16 != null) {
                                    }
                                    if (!av.a(th)) {
                                    }
                                    if (z16) {
                                    }
                                }
                                bArr2 = bArr5;
                            }
                            try {
                                randomAccessFile = new RandomAccessFile(file, "rw");
                            } catch (Throwable th21) {
                                av.b(th21);
                            }
                        } catch (Throwable th22) {
                            th = th22;
                            str5 = "system handle end!";
                            str7 = "crashreport last handle start!";
                        }
                    } catch (Throwable th23) {
                        th = th23;
                        str5 = "system handle end!";
                        str6 = "crashreport last handle end!";
                        str7 = "crashreport last handle start!";
                        str8 = "JAVA_CATCH";
                    }
                    try {
                        a17.f98151b = randomAccessFile.getChannel();
                        str9 = i3 + "\t0\t0\t0000000000000000\t" + ai.f97988af + "\t" + a17.f98154e.f98016d + "\t" + a17.f98154e.f98032t + "\t" + a17.f98154e.f98020h + "\t" + a17.f98154e.i() + "\t" + a17.f98154e.f98023k + "\tJAVA_CRASH#" + th5.getClass().getName() + "\t" + (((int) (System.currentTimeMillis() - a17.f98154e.f97991a)) / 1000) + "\t" + a17.f98154e.b() + "\n";
                        if (bArr2 == null && bArr2.length > 0) {
                            MappedByteBuffer map3 = a17.f98151b.map(FileChannel.MapMode.READ_WRITE, 0L, bArr2.length + str9.length());
                            a17.f98150a = map3;
                            map3.position(4);
                            ByteBuffer slice = a17.f98150a.slice();
                            slice.limit(36);
                            if (AndroidVersion.isOverKitKat()) {
                                charBuffer = StandardCharsets.UTF_8.decode(slice).toString();
                            } else {
                                charBuffer = Charset.forName("UTF-8").decode(slice).toString();
                            }
                            if (charBuffer.equals(ai.f97988af)) {
                                a17.f98153d = true;
                                a17.f98151b.close();
                                randomAccessFile.close();
                                a16 = a(thread, th5, z16, str, bArr);
                                if (a16 != null) {
                                    try {
                                        av.e("pkg crash data fail!", new Object[0]);
                                        if (z16) {
                                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f98291e;
                                            if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                                                av.e("sys default last handle start!", new Object[0]);
                                                this.f98291e.uncaughtException(thread, th5);
                                                av.e("sys default last handle end!", new Object[0]);
                                                return;
                                            } else if (this.f98292f != null) {
                                                av.e("system handle start!", new Object[0]);
                                                this.f98292f.uncaughtException(thread, th5);
                                                av.e(str5, new Object[0]);
                                                return;
                                            } else {
                                                av.e(str7, new Object[0]);
                                                d();
                                                av.e(str6, new Object[0]);
                                                return;
                                            }
                                        }
                                        return;
                                    } catch (Throwable th24) {
                                        th = th24;
                                        thread2 = thread;
                                        th6 = th5;
                                        str2 = str5;
                                        str3 = str6;
                                        str4 = str7;
                                    }
                                } else {
                                    thread2 = thread;
                                    th6 = th5;
                                    String str13 = str6;
                                    String str14 = str7;
                                    str2 = str5;
                                    try {
                                        a16.H.putAll(ba.a(z17, be.f98215i, true));
                                        if (z16 && Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
                                            a16.f97869aj = ba.a(this.f98287a, NativeCrashHandler.getInstance());
                                        }
                                        String str15 = a16.f97869aj;
                                        if (str15 != null && str15.length() >= 50) {
                                            az.a().a(az.a.f98158a - 1, z16);
                                        }
                                        str10 = str13;
                                        str11 = str14;
                                    } catch (Throwable th25) {
                                        th = th25;
                                        str10 = str13;
                                        str11 = str14;
                                    }
                                    try {
                                        bd.a(z16 ? "JAVA_CRASH" : str8, ba.a(), this.f98290d.f98016d, thread.getName(), ba.a(th5), a16);
                                        az.a().a(az.b.f98175g - 1, false, z16);
                                    } catch (Throwable th26) {
                                        th = th26;
                                        try {
                                            av.b(th);
                                            if (!this.f98288b.a(a16, z16)) {
                                                this.f98288b.b(a16, z16);
                                            }
                                            if (z16) {
                                            }
                                            if (z16) {
                                            }
                                        } catch (Throwable th27) {
                                            th = th27;
                                            str3 = str10;
                                            str4 = str11;
                                        }
                                    }
                                    if (!this.f98288b.a(a16, z16) && thread.getId() != Looper.getMainLooper().getThread().getId()) {
                                        this.f98288b.b(a16, z16);
                                    }
                                    if (z16) {
                                        NativeCrashHandler.getInstance().saveAdditionalAttachmentPaths("crash");
                                        com.tencent.rmonitor.base.config.data.k d16 = ConfigFetcher.g().d("common");
                                        if ((d16 instanceof CommonConfig) && ((CommonConfig) d16).isEnableOOMHprof() && th5.getClass().getName().equals(OutOfMemoryError.class.getName())) {
                                            HprofFileIUtil.dumpOOMHprof();
                                            az.a().a(az.a.f98166i - 1, true);
                                        }
                                        this.f98288b.a(a16);
                                    }
                                    if (z16) {
                                        return;
                                    }
                                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f98291e;
                                    if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                                        av.e("sys default last handle start!", new Object[0]);
                                        this.f98291e.uncaughtException(thread2, th6);
                                        av.e("sys default last handle end!", new Object[0]);
                                        return;
                                    } else if (this.f98292f != null) {
                                        av.e("system handle start!", new Object[0]);
                                        this.f98292f.uncaughtException(thread2, th6);
                                        av.e(str2, new Object[0]);
                                        return;
                                    } else {
                                        av.e(str11, new Object[0]);
                                        d();
                                        av.e(str10, new Object[0]);
                                        return;
                                    }
                                }
                                if (!av.a(th)) {
                                    th.printStackTrace();
                                }
                                if (z16) {
                                    return;
                                }
                                Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f98291e;
                                if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                                    av.e("sys default last handle start!", new Object[0]);
                                    this.f98291e.uncaughtException(thread2, th6);
                                    av.e("sys default last handle end!", new Object[0]);
                                    return;
                                } else if (this.f98292f != null) {
                                    av.e("system handle start!", new Object[0]);
                                    this.f98292f.uncaughtException(thread2, th6);
                                    av.e(str2, new Object[0]);
                                    return;
                                } else {
                                    av.e(str4, new Object[0]);
                                    d();
                                    av.e(str3, new Object[0]);
                                    return;
                                }
                            }
                            a17.f98150a.position(0);
                            a17.f98150a.put(str9.getBytes());
                            a17.f98150a.position(str9.length());
                            a17.f98150a.put(bArr2);
                            a17.f98150a.force();
                            a17.f98150a = a17.f98151b.map(FileChannel.MapMode.READ_WRITE, 0L, str9.length());
                        } else {
                            MappedByteBuffer map22 = a17.f98151b.map(FileChannel.MapMode.READ_WRITE, 0L, str9.length());
                            a17.f98150a = map22;
                            map22.put(str9.getBytes());
                            a17.f98150a.force();
                        }
                        randomAccessFile.close();
                        a17.f98152c = true;
                        a16 = a(thread, th5, z16, str, bArr);
                        if (a16 != null) {
                        }
                    } finally {
                    }
                    if (!av.a(th)) {
                    }
                    if (z16) {
                    }
                }
            }
            if (!av.a(th)) {
            }
            if (z16) {
            }
        } catch (Throwable th28) {
            if (z16) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f98291e;
                if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                    av.e("sys default last handle start!", new Object[0]);
                    this.f98291e.uncaughtException(thread2, th6);
                    av.e("sys default last handle end!", new Object[0]);
                } else if (this.f98292f != null) {
                    av.e("system handle start!", new Object[0]);
                    this.f98292f.uncaughtException(thread2, th6);
                    av.e(str2, new Object[0]);
                } else {
                    av.e(str4, new Object[0]);
                    d();
                    av.e(str3, new Object[0]);
                }
            }
            throw th28;
        }
        str5 = "system handle end!";
        str6 = "crashreport last handle end!";
        str7 = "crashreport last handle start!";
        str8 = "JAVA_CATCH";
        a16 = a(thread, th5, z16, str, bArr);
        if (a16 != null) {
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z16 = strategyBean.f97841f;
            if (z16 != this.f98293g) {
                av.a("java changed to %b", Boolean.valueOf(z16));
                if (strategyBean.f97841f) {
                    a();
                    return;
                }
                c();
            }
        }
    }

    private static String a(Throwable th5, int i3) {
        if (th5 == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        try {
            if (th5.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th5.getStackTrace()) {
                    if (i3 > 0 && sb5.length() >= i3) {
                        sb5.append("\n[Stack over limit size :" + i3 + " , has been cutted !]");
                        return sb5.toString();
                    }
                    sb5.append(stackTraceElement.toString());
                    sb5.append("\n");
                }
            }
        } catch (Throwable th6) {
            av.e("gen stack error %s", th6.toString());
        }
        return sb5.toString();
    }

    private static String a(Throwable th5) {
        String message = th5.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
