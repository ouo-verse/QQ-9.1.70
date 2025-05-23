package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    static int f369355a = 0;

    /* renamed from: b, reason: collision with root package name */
    static boolean f369356b = false;

    /* renamed from: e, reason: collision with root package name */
    private static g f369357e = null;

    /* renamed from: h, reason: collision with root package name */
    private static int f369358h = 0;

    /* renamed from: j, reason: collision with root package name */
    private static int f369359j = 3;

    /* renamed from: l, reason: collision with root package name */
    private static String f369360l;

    /* renamed from: c, reason: collision with root package name */
    private o f369361c = null;

    /* renamed from: d, reason: collision with root package name */
    private o f369362d = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f369363f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f369364g = false;

    /* renamed from: i, reason: collision with root package name */
    private String f369365i = "";

    /* renamed from: k, reason: collision with root package name */
    private File f369366k = null;

    g() {
    }

    public static g a(boolean z16) {
        if (f369357e == null && z16) {
            synchronized (g.class) {
                if (f369357e == null) {
                    f369357e = new g();
                }
            }
        }
        return f369357e;
    }

    public static int d() {
        return f369358h;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int j() {
        BufferedInputStream bufferedInputStream;
        Exception e16;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(this.f369366k, "count.prop");
            if (!file.exists()) {
                return 0;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    int intValue = Integer.valueOf(properties.getProperty(f369360l, "1")).intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    return intValue;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e16 = e19;
                e16.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                    }
                }
                return 0;
            }
        } catch (Exception e27) {
            bufferedInputStream = null;
            e16 = e27;
        } catch (Throwable th6) {
            th = th6;
            if (bufferedInputStream2 != null) {
            }
            throw th;
        }
    }

    public boolean b() {
        return this.f369363f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o c() {
        return this.f369361c;
    }

    public String e() {
        o oVar = this.f369361c;
        if (oVar != null && !QbSdk.f368992b) {
            return oVar.a();
        }
        return "system webview get nothing...";
    }

    public String f() {
        o oVar = this.f369361c;
        if (oVar != null && !QbSdk.f368992b) {
            return oVar.b();
        }
        return "system webview get nothing...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        if (f369356b) {
            if (f369360l == null) {
                return false;
            }
            int j3 = j();
            if (j3 == 0) {
                b(1);
            } else {
                int i3 = j3 + 1;
                if (i3 > f369359j) {
                    return false;
                }
                b(i3);
            }
        }
        return f369356b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f369364g;
    }

    public boolean i() {
        return QbSdk.useSoftWare();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(boolean z16) {
        f369356b = z16;
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i3) {
        FileOutputStream fileOutputStream;
        IOException e16;
        FileNotFoundException e17;
        String valueOf = String.valueOf(i3);
        Properties properties = new Properties();
        properties.setProperty(f369360l, valueOf);
        try {
            fileOutputStream = new FileOutputStream(new File(this.f369366k, "count.prop"));
        } catch (FileNotFoundException e18) {
            fileOutputStream = null;
            e17 = e18;
        } catch (IOException e19) {
            fileOutputStream = null;
            e16 = e19;
        }
        try {
            properties.store(fileOutputStream, (String) null);
        } catch (FileNotFoundException e26) {
            e17 = e26;
            e17.printStackTrace();
            if (fileOutputStream != null) {
            }
        } catch (IOException e27) {
            e16 = e27;
            e16.printStackTrace();
            if (fileOutputStream != null) {
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void a(Context context, boolean z16, boolean z17) {
        TbsLog.initIfNeed(context);
        f369355a++;
        TbsLog.i("SDKEngine", "init", "#1# context: " + context + ", mInitCount: " + f369355a);
        if (this.f369363f) {
            return;
        }
        n.a().b(context, f369355a == 1);
        n.a().i(context);
        boolean a16 = QbSdk.a(context, z16);
        TbsLog.i("SDKEngine", "init", "#2# canLoadX5 is " + a16);
        if (a16) {
            TbsLog.i("SDKEngine", "init", "#3# start to load tbs");
            try {
                File n3 = n.a().n(context);
                Context applicationContext = context.getApplicationContext() != null ? context.getApplicationContext() : context;
                if (n3 != null && n3.exists()) {
                    String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, applicationContext, n3.getAbsolutePath());
                    for (int i3 = 0; i3 < dexLoaderFileList.length; i3++) {
                        TbsLog.i("SDKEngine", "dexLoaderFileList[" + i3 + "]: " + dexLoaderFileList[i3]);
                    }
                    String absolutePath = n3.getAbsolutePath();
                    TbsLog.i("SDKEngine", "init", "#4# optDir is " + absolutePath);
                    o oVar = this.f369362d;
                    if (oVar != null) {
                        this.f369361c = oVar;
                        oVar.a(context, applicationContext, n3.getAbsolutePath(), absolutePath, dexLoaderFileList, QbSdk.f368995e);
                    } else {
                        this.f369361c = new o(context, applicationContext, n3.getAbsolutePath(), absolutePath, dexLoaderFileList, QbSdk.f368995e);
                    }
                    this.f369363f = true;
                    this.f369365i = "true01";
                }
                this.f369363f = false;
                this.f369365i = "false03";
                TbsCoreLoadStat.getInstance().a(context, 312, new Throwable());
                QbSdk.a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                return;
            } catch (Throwable th5) {
                TbsLog.e("SDKEngine", "useSystemWebView by exception: " + th5);
                TbsCoreLoadStat.getInstance().a(context, 320, th5);
                this.f369363f = false;
                this.f369365i = "false04";
                QbSdk.a(context, "SDKEngine::useSystemWebView by exception: " + th5);
            }
        } else if (!QbSdk.f368992b || !this.f369363f) {
            this.f369363f = false;
            this.f369365i = "false05";
            TbsLog.e("SDKEngine", "init", "[LoadError] check log upon for details");
        }
        this.f369366k = n.o(context);
        this.f369364g = true;
    }

    public o a() {
        if (this.f369363f) {
            return this.f369361c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i3) {
        f369358h = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        f369360l = str;
    }
}
