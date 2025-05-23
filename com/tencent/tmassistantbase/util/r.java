package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes26.dex */
public class r {
    protected static ArrayList<WeakReference<f>> A = null;

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f380496a = false;

    /* renamed from: b, reason: collision with root package name */
    protected static String f380497b = "";

    /* renamed from: c, reason: collision with root package name */
    protected static int f380498c = 2;

    /* renamed from: d, reason: collision with root package name */
    protected static int f380499d = 4;

    /* renamed from: e, reason: collision with root package name */
    protected static boolean f380500e = true;

    /* renamed from: f, reason: collision with root package name */
    protected static boolean f380501f = false;

    /* renamed from: g, reason: collision with root package name */
    protected static boolean f380502g = false;

    /* renamed from: h, reason: collision with root package name */
    protected static Context f380503h;

    /* renamed from: i, reason: collision with root package name */
    protected static boolean f380504i;

    /* renamed from: j, reason: collision with root package name */
    static LinkedBlockingQueue<String> f380505j;

    /* renamed from: k, reason: collision with root package name */
    protected static BufferedWriter f380506k;

    /* renamed from: l, reason: collision with root package name */
    static long f380507l;

    /* renamed from: m, reason: collision with root package name */
    static final ReentrantLock f380508m;

    /* renamed from: n, reason: collision with root package name */
    protected static int f380509n;

    /* renamed from: o, reason: collision with root package name */
    protected static String f380510o;

    /* renamed from: p, reason: collision with root package name */
    protected static String f380511p;

    /* renamed from: q, reason: collision with root package name */
    protected static long f380512q;

    /* renamed from: r, reason: collision with root package name */
    protected static SimpleDateFormat f380513r;

    /* renamed from: s, reason: collision with root package name */
    protected static AtomicBoolean f380514s;

    /* renamed from: t, reason: collision with root package name */
    protected static AtomicBoolean f380515t;

    /* renamed from: u, reason: collision with root package name */
    protected static final int[] f380516u;

    /* renamed from: v, reason: collision with root package name */
    protected static AtomicInteger f380517v;

    /* renamed from: w, reason: collision with root package name */
    protected static Handler f380518w;

    /* renamed from: x, reason: collision with root package name */
    protected static Runnable f380519x;

    /* renamed from: y, reason: collision with root package name */
    static Thread f380520y;

    /* renamed from: z, reason: collision with root package name */
    protected static ReferenceQueue<f> f380521z;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a extends ThreadLocal<char[]> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class b implements Runnable {

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class a extends BaseThread {
            a(b bVar, String str) {
                super(str);
            }

            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                if (r.l()) {
                    int i3 = 0;
                    if (r.f380515t.compareAndSet(false, true)) {
                        try {
                            r.m();
                            try {
                                r.f380510o = r.f380503h.getPackageName();
                            } catch (Exception unused) {
                                r.f380510o = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
                            }
                            r.f380505j = new LinkedBlockingQueue<>(15000);
                            r.f380509n = Process.myPid();
                            r.g();
                            r.f380520y.setName("logWriteThread");
                            r.f380520y.start();
                            r.f380518w.removeCallbacks(r.f380519x);
                        } catch (Exception e16) {
                            r.f380515t.set(false);
                            e16.printStackTrace();
                            int i16 = r.f380517v.get();
                            int[] iArr = r.f380516u;
                            int i17 = iArr[i16];
                            r.f380518w.removeCallbacks(r.f380519x);
                            r.f380518w.postDelayed(r.f380519x, iArr[i16] * 60000);
                            int i18 = i16 + 1;
                            if (i18 < iArr.length) {
                                i3 = i18;
                            }
                            r.f380517v.set(i3);
                        }
                    }
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.f380503h != null && r.l() && !r.f380515t.get()) {
                new a(this, "TMLogInitThread").start();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class c extends BaseThread {
        c() {
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    String take = r.f380505j.take();
                    if (take != null) {
                        r.d(take);
                    }
                } catch (InterruptedException e16) {
                    e16.toString();
                } catch (Throwable th5) {
                    if ((th5 instanceof IOException) && th5.getMessage().contains("ENOSPC")) {
                        if (r.f380514s.compareAndSet(false, true)) {
                            th5.printStackTrace();
                            return;
                        }
                        return;
                    } else {
                        r.f380514s.compareAndSet(true, false);
                        th5.printStackTrace();
                        try {
                            r.g();
                            return;
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                            return;
                        }
                    }
                }
            }
        }
    }

    static {
        Collections.synchronizedList(new ArrayList());
        f380504i = false;
        f380507l = 0L;
        f380508m = new ReentrantLock();
        f380510o = "";
        f380511p = "";
        f380512q = 0L;
        f380513r = new SimpleDateFormat("yy-MM-dd HH:mm");
        f380514s = new AtomicBoolean(false);
        f380515t = new AtomicBoolean(false);
        f380516u = new int[]{1, 2, 4, 8, 16, 29};
        f380517v = new AtomicInteger(0);
        f380518w = new Handler(Looper.getMainLooper());
        new a();
        f380519x = new b();
        f380520y = new c();
    }

    public static void c(String str, String str2) {
        a(5, str, str2, null);
    }

    public static synchronized String d() {
        String str;
        synchronized (r.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f380512q > 60000) {
                f380512q = currentTimeMillis;
                f380511p = f380513r.format(Long.valueOf(currentTimeMillis));
            }
            str = f380511p;
        }
        return str;
    }

    public static int e() {
        return f380498c;
    }

    public static int f() {
        return f380499d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void g() {
        synchronized (r.class) {
            File file = new File(c());
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(c() + f380510o + "_tmlog.txt");
            try {
                if (!file2.exists()) {
                    boolean createNewFile = file2.createNewFile();
                    n();
                    if (f380506k != null && l()) {
                        f380506k.write(d() + "|" + f380510o + "|" + DeviceInfoMonitor.getModel() + " " + Build.VERSION.RELEASE + " create newLogFile " + file2.getName() + " " + createNewFile + "\n");
                        f380506k.flush();
                    }
                } else {
                    if (file2.length() >= 512000) {
                        file2.delete();
                        file2.createNewFile();
                        file2.getName();
                    }
                    n();
                    if (f380506k != null && l()) {
                        f380506k.write(d() + "|" + f380510o + "|" + DeviceInfoMonitor.getModel() + " " + Build.VERSION.RELEASE + "|newLogFile " + file2.getName() + " is existed.\n");
                        f380506k.flush();
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            f380506k = new BufferedWriter(new FileWriter(file2, true), 8192);
            n();
        }
    }

    public static boolean h() {
        return f380502g;
    }

    public static boolean i() {
        return f380501f;
    }

    public static boolean j() {
        return false;
    }

    public static boolean k() {
        return f380500e;
    }

    public static boolean l() {
        return f380496a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            Properties properties = new Properties();
            try {
                File file = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/TMAssistantSDK/Logs/logConfig.properties");
                if (!file.exists()) {
                    return;
                }
                properties.load(new FileInputStream(file));
                if (properties.getProperty("isWriteLogToFile", "").trim().equals("true")) {
                    c(true);
                } else {
                    c(false);
                }
                String property = properties.getProperty("logfileOutputLevel", "");
                if (!TextUtils.isEmpty(property)) {
                    try {
                        b(Integer.valueOf(property).intValue());
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                    }
                }
                String property2 = properties.getProperty("logcatOutputLevel", "");
                if (!TextUtils.isEmpty(property2)) {
                    try {
                        a(Integer.valueOf(property2).intValue());
                    } catch (NumberFormatException e17) {
                        e17.printStackTrace();
                    }
                }
                c(properties.getProperty("logDirPath", ""));
                if (properties.getProperty("isUseWriterCache", "").trim().equals("false")) {
                    b(false);
                } else {
                    b(true);
                }
                if (properties.getProperty("isAppendLogTime", "").trim().equals("true")) {
                    a(true);
                } else {
                    a(false);
                }
                i();
                h();
                l();
                f();
                e();
                c();
                k();
                i();
                h();
                return;
            } catch (IOException e18) {
                e18.printStackTrace();
                return;
            }
        }
        c(false);
    }

    private static void n() {
        if (f380506k != null && l()) {
            f380506k.write("SDK_VERSION = 1.3|BUILD_NO = {BuildNo}|RELEASE_DATE: {ReleaseDate}\r\n");
            f380506k.flush();
        }
    }

    public static void b(String str, String str2) {
        a(4, str, str2, null);
    }

    public static void c(String str, String str2, Throwable th5) {
        a(5, str, str2, th5);
    }

    public static synchronized void a(Context context) {
        synchronized (r.class) {
            if (!f380504i) {
                f380503h = context;
                f380519x.run();
                f380504i = true;
            }
        }
    }

    public static void b(String str, String str2, Throwable th5) {
        a(4, str, str2, th5);
    }

    public static void c(boolean z16) {
        f380496a = z16;
    }

    public static void b(int i3) {
        f380499d = i3;
    }

    public static String c() {
        if (TextUtils.isEmpty(f380497b)) {
            f380497b = Environment.getExternalStorageDirectory().getPath() + "/tencent/TMAssistantSDK/Logs/";
        }
        return f380497b;
    }

    public static void b(boolean z16) {
        f380500e = z16;
    }

    private static boolean b(String str) {
        try {
            f380505j.add(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        if (l()) {
            if (f380506k == null) {
                long currentTimeMillis = System.currentTimeMillis();
                long j3 = f380507l;
                if (j3 == 0) {
                    f380507l = currentTimeMillis;
                } else if (currentTimeMillis - j3 > 60000) {
                    try {
                        g();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    f380507l = currentTimeMillis;
                }
            } else {
                ReentrantLock reentrantLock = f380508m;
                if (reentrantLock.tryLock()) {
                    try {
                        f380506k.write(str);
                        if (!k()) {
                            f380506k.flush();
                        }
                        reentrantLock.unlock();
                    } catch (Throwable th5) {
                        f380508m.unlock();
                        throw th5;
                    }
                } else {
                    b(str);
                }
            }
            f380514s.compareAndSet(true, false);
        }
    }

    public static void a(String str, String str2) {
        a(6, str, str2, null);
    }

    public static synchronized boolean b(f fVar) {
        boolean z16;
        synchronized (r.class) {
            if (fVar == null) {
                return false;
            }
            Iterator<WeakReference<f>> it = A.iterator();
            while (it.hasNext()) {
                WeakReference<f> next = it.next();
                if (next.get() == fVar) {
                    A.remove(next);
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("/") && str.endsWith("/")) {
            f380497b = str;
        }
    }

    public static void a(String str, String str2, Throwable th5) {
        a(6, str, str2, th5);
    }

    private static void a(int i3, String str, String str2, Throwable th5) {
        if ((i3 >= f() || i3 >= e()) && i3 >= e()) {
            if (i3 == 2) {
                j();
            }
            if (i3 == 3) {
                j();
            }
            if (i3 == 4) {
                if (th5 == null) {
                    Log.i(str, str2);
                } else {
                    Log.i(str, str2, th5);
                }
            }
            if (i3 == 5) {
                if (th5 == null) {
                    Log.w(str, str2);
                } else {
                    Log.w(str, str2, th5);
                }
            }
            if (i3 == 6) {
                if (th5 == null) {
                    Log.e(str, str2);
                } else {
                    Log.e(str, str2, th5);
                }
            }
        }
    }

    public static void a(int i3) {
        f380498c = i3;
    }

    public static void a(boolean z16) {
        f380502g = z16;
    }

    public static synchronized boolean a(f fVar) {
        synchronized (r.class) {
            if (fVar == null) {
                return false;
            }
            fVar.toString();
            if (A == null) {
                A = new ArrayList<>();
            }
            if (f380521z == null) {
                f380521z = new ReferenceQueue<>();
            }
            Reference<? extends f> poll = f380521z.poll();
            while (poll != null) {
                A.remove(poll);
            }
            Iterator<WeakReference<f>> it = A.iterator();
            while (it.hasNext()) {
                if (it.next().get() == fVar) {
                    return true;
                }
            }
            A.add(new WeakReference<>(fVar, f380521z));
            return true;
        }
    }
}
