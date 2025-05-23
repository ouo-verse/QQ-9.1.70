package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.nio.channels.FileLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static p f369474a;

    /* renamed from: f, reason: collision with root package name */
    private static FileLock f369475f;

    /* renamed from: b, reason: collision with root package name */
    private q f369476b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f369477c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f369479e;

    /* renamed from: d, reason: collision with root package name */
    private boolean f369478d = false;

    /* renamed from: g, reason: collision with root package name */
    private long f369480g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f369481h = 0;

    p() {
    }

    public static p a() {
        if (f369474a == null) {
            synchronized (p.class) {
                if (f369474a == null) {
                    f369474a = new p();
                }
            }
        }
        return f369474a;
    }

    public boolean b() {
        if (QbSdk.f368992b || QbSdk.getIsSysWebViewForcedByOuter()) {
            return false;
        }
        return this.f369477c;
    }

    public q c() {
        if (QbSdk.f368992b) {
            return null;
        }
        return this.f369476b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f369478d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return "has init: " + this.f369478d + ";start time: " + this.f369480g + ";end time: " + this.f369481h + ";cost: " + (this.f369481h - this.f369480g);
    }

    public FileLock b(Context context) {
        TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        FileLock fileLock = f369475f;
        if (fileLock != null) {
            return fileLock;
        }
        synchronized (p.class) {
            if (f369475f == null) {
                FileLock d16 = FileUtil.d(context);
                f369475f = d16;
                if (d16 == null) {
                    TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock failed!");
                } else {
                    TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock succeeded: " + f369475f);
                }
            }
        }
        return f369475f;
    }

    public q a(boolean z16) {
        if (z16) {
            return this.f369476b;
        }
        return c();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7 A[Catch: all -> 0x026c, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:11:0x0027, B:14:0x005d, B:16:0x0061, B:23:0x009e, B:25:0x00ad, B:26:0x00b4, B:27:0x00c9, B:29:0x00e7, B:44:0x0151, B:46:0x015e, B:47:0x0262, B:50:0x01a0, B:52:0x0147, B:53:0x01e2, B:55:0x01e8, B:56:0x0229, B:57:0x0241, B:59:0x025f, B:62:0x0085, B:60:0x0095, B:64:0x00b7, B:34:0x00fa, B:36:0x0100, B:37:0x010e, B:39:0x0112, B:40:0x0138, B:42:0x013c, B:18:0x0075, B:20:0x007d), top: B:2:0x0001, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0241 A[Catch: all -> 0x026c, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000b, B:11:0x0027, B:14:0x005d, B:16:0x0061, B:23:0x009e, B:25:0x00ad, B:26:0x00b4, B:27:0x00c9, B:29:0x00e7, B:44:0x0151, B:46:0x015e, B:47:0x0262, B:50:0x01a0, B:52:0x0147, B:53:0x01e2, B:55:0x01e8, B:56:0x0229, B:57:0x0241, B:59:0x025f, B:62:0x0085, B:60:0x0095, B:64:0x00b7, B:34:0x00fa, B:36:0x0100, B:37:0x010e, B:39:0x0112, B:40:0x0138, B:42:0x013c, B:18:0x0075, B:20:0x007d), top: B:2:0x0001, inners: #1, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(Context context) {
        Throwable th5;
        if (this.f369478d && !QbSdk.isEnableX5WithoutRestart()) {
            TbsLog.w("X5CoreEngine", "coreEngine has init, mCanUseX5=" + this.f369477c);
            return;
        }
        this.f369480g = System.currentTimeMillis();
        TbsLog.i("X5CoreEngine", "init", "#1# Start init");
        g a16 = g.a(true);
        a16.a(context, false, false);
        TbsLog.i("X5CoreEngine", "init", "#2# SDKEngine init finish");
        StringBuilder sb5 = new StringBuilder();
        o a17 = a16.a();
        if (a16.b() && a17 != null) {
            if (!this.f369479e) {
                TbsLog.i("X5CoreEngine", "init", "#3-1# X5CoreWizard start to load dex and so");
                q qVar = new q(a17.c());
                this.f369476b = qVar;
                try {
                    boolean a18 = qVar.a();
                    this.f369477c = a18;
                    if (!a18) {
                        sb5.append("can not use X5 by x5corewizard return false");
                    }
                } catch (NoSuchMethodException unused) {
                    this.f369477c = true;
                    sb5.append("NoSuchMethodException");
                } catch (Throwable th6) {
                    th5 = th6;
                    this.f369477c = false;
                    sb5.append("can not use x5 by x5corewizard throwable ");
                    sb5.append(Log.getStackTraceString(th5));
                }
                th5 = null;
                sb5.append("mCanUseX5 is ");
                sb5.append(this.f369477c);
                if (this.f369477c) {
                    CookieManager.getInstance().a();
                }
                this.f369479e = true;
                TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.f369477c);
                if (this.f369477c) {
                    TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                    if (a16.b() && a17 != null && th5 == null) {
                        try {
                            DexLoader c16 = a17.c();
                            Object invokeStaticMethod = c16 != null ? c16.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]) : null;
                            if (invokeStaticMethod instanceof Throwable) {
                                Throwable th7 = (Throwable) invokeStaticMethod;
                                sb5.append("#");
                                sb5.append(th7.getMessage());
                                sb5.append("; cause: ");
                                sb5.append(th7.getCause());
                                sb5.append("; th: ");
                                sb5.append(th7);
                            }
                            if (invokeStaticMethod instanceof String) {
                                sb5.append("failure detail: ");
                                sb5.append(invokeStaticMethod);
                            }
                        } catch (Throwable th8) {
                            TbsLog.e("X5CoreEngine", "init", Log.getStackTraceString(th8));
                        }
                        if (sb5.toString().contains("isPreloadX5Disabled:-10000")) {
                            TbsCoreLoadStat.getInstance().a(context, 408, new Throwable("Core Crash, details: " + sb5.toString()));
                            TbsLog.e("X5CoreEngine", "init", "[LoadError] Core Crash, details: " + sb5.toString());
                        } else {
                            TbsCoreLoadStat.getInstance().a(context, 407, new Throwable("Failed in Core, details: " + sb5.toString()));
                            TbsLog.e("X5CoreEngine", "init", "[LoadError] Failed in Core, details: " + sb5.toString());
                        }
                    } else if (a16.b()) {
                        TbsCoreLoadStat.getInstance().a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + sb5.toString()));
                        TbsLog.e("X5CoreEngine", "init", "[LoadError] details: " + sb5.toString());
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, 410, new Throwable());
                        TbsLog.e("X5CoreEngine", "init", "[LoadError] mCanUseX5=false, available=false");
                    }
                } else {
                    TbsLog.i("X5CoreEngine", "init", "#5# sTbsCoreLoadFileLock is " + f369475f);
                    if (f369475f == null) {
                        b(context);
                    }
                }
                this.f369481h = System.currentTimeMillis();
                this.f369478d = true;
            }
        } else {
            this.f369477c = false;
            TbsLog.e("X5CoreEngine", "init", "SDKEngine tbs not available!");
            sb5.append("SDKEngine tbs not available_");
        }
        th5 = null;
        TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.f369477c);
        if (this.f369477c) {
        }
        this.f369481h = System.currentTimeMillis();
        this.f369478d = true;
    }
}
