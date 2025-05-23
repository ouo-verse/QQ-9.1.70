package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ay {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f98121a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f98122b = true;

    /* renamed from: c, reason: collision with root package name */
    private static SimpleDateFormat f98123c = null;

    /* renamed from: d, reason: collision with root package name */
    private static int f98124d = 51200;

    /* renamed from: e, reason: collision with root package name */
    private static StringBuilder f98125e = null;

    /* renamed from: f, reason: collision with root package name */
    private static StringBuilder f98126f = null;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f98127g = false;

    /* renamed from: h, reason: collision with root package name */
    private static a f98128h = null;

    /* renamed from: i, reason: collision with root package name */
    private static String f98129i = null;

    /* renamed from: j, reason: collision with root package name */
    private static String f98130j = null;

    /* renamed from: k, reason: collision with root package name */
    private static Context f98131k = null;

    /* renamed from: l, reason: collision with root package name */
    private static String f98132l = null;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f98133m = false;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f98134n = false;

    /* renamed from: o, reason: collision with root package name */
    private static ExecutorService f98135o;

    /* renamed from: p, reason: collision with root package name */
    private static int f98136p;

    /* renamed from: q, reason: collision with root package name */
    private static final Object f98137q = new Object();

    static {
        try {
            f98123c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th5) {
            av.b(th5.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (ay.class) {
            if (f98133m || context == null || !f98122b) {
                return;
            }
            try {
                f98135o = ProxyExecutors.newSingleThreadExecutor();
                f98126f = new StringBuilder(0);
                f98125e = new StringBuilder(0);
                f98131k = context;
                f98129i = ai.a(context).f98016d;
                f98130j = "";
                f98132l = f98131k.getFilesDir().getPath() + "/buglylog_" + f98129i + "_" + f98130j + ".txt";
                f98136p = Process.myPid();
            } catch (Throwable unused) {
            }
            f98133m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, String str2, String str3) {
        r rVar;
        try {
            ai c16 = ai.c();
            if (c16 != null && (rVar = c16.U) != null) {
                return rVar.appendLogToNative(str, str2, str3);
            }
            return false;
        } catch (Throwable th5) {
            if (!av.a(th5)) {
                th5.printStackTrace();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void e(String str, String str2, String str3) {
        synchronized (ay.class) {
            if (f98121a) {
                f(str, str2, str3);
            } else {
                g(str, str2, str3);
            }
        }
    }

    private static synchronized void f(String str, String str2, String str3) {
        synchronized (ay.class) {
            String a16 = a(str, str2, str3, Process.myTid());
            synchronized (f98137q) {
                try {
                    f98126f.append(a16);
                    if (f98126f.length() >= f98124d) {
                        StringBuilder sb5 = f98126f;
                        f98126f = sb5.delete(0, sb5.indexOf("\u0001\r\n") + 1);
                    }
                } finally {
                }
            }
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        synchronized (ay.class) {
            String a16 = a(str, str2, str3, Process.myTid());
            synchronized (f98137q) {
                try {
                    f98126f.append(a16);
                } catch (Throwable unused) {
                }
                if (f98126f.length() <= f98124d) {
                    return;
                }
                if (f98127g) {
                    return;
                }
                f98127g = true;
                a aVar = f98128h;
                if (aVar == null) {
                    f98128h = new a(f98132l);
                } else {
                    File file = aVar.f98145b;
                    if (file == null || file.length() + f98126f.length() > f98128h.f98146c) {
                        f98128h.a();
                    }
                }
                if (f98128h.a(f98126f.toString())) {
                    f98126f.setLength(0);
                    f98127g = false;
                }
            }
        }
    }

    private static String b() {
        r rVar;
        try {
            ai c16 = ai.c();
            if (c16 == null || (rVar = c16.U) == null) {
                return null;
            }
            return rVar.getLogFromNative();
        } catch (Throwable th5) {
            if (av.a(th5)) {
                return null;
            }
            th5.printStackTrace();
            return null;
        }
    }

    private static byte[] c() {
        File file;
        if (!f98122b) {
            return null;
        }
        if (f98134n) {
            av.a("[LogUtil] Get user log from native.", new Object[0]);
            String b16 = b();
            if (b16 != null) {
                av.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(b16.length()));
                return ba.a(b16, "BuglyNativeLog.txt");
            }
        }
        StringBuilder sb5 = new StringBuilder();
        synchronized (f98137q) {
            a aVar = f98128h;
            if (aVar != null && aVar.f98144a && (file = aVar.f98145b) != null && file.length() > 0) {
                sb5.append(ba.a(f98128h.f98145b, 30720));
            }
            StringBuilder sb6 = f98126f;
            if (sb6 != null && sb6.length() > 0) {
                sb5.append(f98126f.toString());
            }
        }
        return ba.a(sb5.toString(), "BuglyLog.txt");
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f98144a;

        /* renamed from: b, reason: collision with root package name */
        File f98145b;

        /* renamed from: c, reason: collision with root package name */
        long f98146c = 30720;

        /* renamed from: d, reason: collision with root package name */
        private String f98147d;

        /* renamed from: e, reason: collision with root package name */
        private long f98148e;

        public a(String str) {
            if (str != null && !str.equals("")) {
                this.f98147d = str;
                this.f98144a = a();
            }
        }

        final boolean a() {
            try {
                File file = new File(this.f98147d);
                this.f98145b = file;
                if (file.exists() && !this.f98145b.delete()) {
                    this.f98144a = false;
                    return false;
                }
                if (this.f98145b.createNewFile()) {
                    return true;
                }
                this.f98144a = false;
                return false;
            } catch (Throwable th5) {
                av.a(th5);
                this.f98144a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.f98144a) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.f98145b, true);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f98148e += r10.length;
                this.f98144a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream2 = fileOutputStream;
                try {
                    av.a(th);
                    this.f98144a = false;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th7) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th7;
                }
            }
        }
    }

    public static void a(int i3) {
        synchronized (f98137q) {
            f98124d = i3;
            if (i3 < 0) {
                f98124d = 0;
            } else if (i3 > 102400) {
                f98124d = RFixConstants.MD5_FILE_BUF_LENGTH;
            }
        }
    }

    public static void a(String str, String str2, Throwable th5) {
        if (th5 == null) {
            return;
        }
        String message = th5.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + ba.b(th5));
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        synchronized (ay.class) {
            if (f98133m && f98122b) {
                try {
                    if (f98134n) {
                        f98135o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ay.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ay.d(str, str2, str3);
                            }
                        });
                    } else {
                        f98135o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.ay.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                ay.e(str, str2, str3);
                            }
                        });
                    }
                } catch (Exception e16) {
                    av.b(e16);
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j3) {
        String date;
        f98125e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        if (f98123c != null) {
            date = ba.a(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb5 = f98125e;
        sb5.append(date);
        sb5.append(" ");
        sb5.append(f98136p);
        sb5.append(" ");
        sb5.append(j3);
        sb5.append(" ");
        sb5.append(str);
        sb5.append(" ");
        sb5.append(str2);
        sb5.append(MsgSummary.STR_COLON);
        sb5.append(str3);
        sb5.append("\u0001\r\n");
        return f98125e.toString();
    }

    public static byte[] a() {
        if (f98121a) {
            if (f98122b) {
                return ba.a(f98126f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return c();
    }
}
