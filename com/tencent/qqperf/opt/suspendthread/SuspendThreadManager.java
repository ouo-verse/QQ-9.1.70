package com.tencent.qqperf.opt.suspendthread;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.logcathook.LogcatHook;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.util.AppSetting;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SuspendThreadManager {

    /* renamed from: b, reason: collision with root package name */
    private static int f363286b;

    /* renamed from: c, reason: collision with root package name */
    private static int f363287c;

    /* renamed from: d, reason: collision with root package name */
    private static int f363288d;

    /* renamed from: k, reason: collision with root package name */
    private static volatile SuspendThreadManager f363295k;

    /* renamed from: s, reason: collision with root package name */
    private static a f363303s;

    /* renamed from: t, reason: collision with root package name */
    private static HandlerThread f363304t;

    /* renamed from: a, reason: collision with root package name */
    private boolean f363306a = false;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<String> f363289e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList<String> f363290f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private static ArrayList<Thread> f363291g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private static ArrayList<Thread> f363292h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private static Map<Integer, Thread> f363293i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private static Map<Thread, Integer> f363294j = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private static boolean f363296l = false;

    /* renamed from: m, reason: collision with root package name */
    private static long f363297m = 20;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f363298n = false;

    /* renamed from: o, reason: collision with root package name */
    private static int f363299o = 3;

    /* renamed from: p, reason: collision with root package name */
    private static int f363300p = 3;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f363301q = false;

    /* renamed from: r, reason: collision with root package name */
    private static int f363302r = 0;

    /* renamed from: u, reason: collision with root package name */
    public static int f363305u = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private Thread f363307a;

        /* renamed from: b, reason: collision with root package name */
        private Thread f363308b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f363309c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f363310d;

        /* renamed from: e, reason: collision with root package name */
        private SharedPreferences f363311e;

        /* renamed from: f, reason: collision with root package name */
        private SharedPreferences.Editor f363312f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f363313g;

        /* renamed from: h, reason: collision with root package name */
        private final float f363314h;

        /* renamed from: i, reason: collision with root package name */
        private int f363315i;

        /* renamed from: j, reason: collision with root package name */
        private int f363316j;

        /* renamed from: k, reason: collision with root package name */
        private int f363317k;

        /* renamed from: l, reason: collision with root package name */
        private HandlerThread f363318l;

        /* renamed from: m, reason: collision with root package name */
        private b f363319m;

        /* renamed from: n, reason: collision with root package name */
        private int f363320n;

        /* renamed from: o, reason: collision with root package name */
        private File f363321o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f363322p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f363323q;

        public a(Looper looper) {
            super(looper);
            this.f363309c = false;
            this.f363310d = false;
            this.f363313g = false;
            this.f363314h = 0.1f;
            this.f363315i = 0;
            this.f363316j = 0;
            this.f363317k = 0;
            this.f363321o = null;
            this.f363322p = false;
            this.f363323q = true;
        }

        private void b(String str, boolean z16) {
            if (z16) {
                QLog.d("TSManager", 1, str + ",createCheckFile");
            } else {
                QLog.d("TSManager", 1, str + ",deleteCheckFile");
            }
            try {
                if (z16) {
                    if (!this.f363321o.exists()) {
                        this.f363321o.createNewFile();
                    }
                } else if (this.f363321o.exists()) {
                    this.f363321o.delete();
                }
            } catch (IOException e16) {
                QLog.e("TSManager", 1, "createOrDelSuspendCheckFile failed", e16);
            }
        }

        private void c() {
            boolean z16;
            boolean z17;
            try {
                if (AppSetting.isCpu64Bit()) {
                    QLog.e("TSManager", 2, "IS_CPU_64_BIT libthreadsuspend not load !!!");
                    SuspendThreadManager.f363296l = false;
                    SuspendThreadManager.f363305u |= 1;
                    return;
                }
                System.loadLibrary("threadsuspend");
                SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(LogcatHook.LOGCAT_HOOK_SP_FILE, 0);
                this.f363311e = sharedPreferences;
                this.f363312f = sharedPreferences.edit();
                this.f363321o = new File(BaseApplication.getContext().getFilesDir().getPath() + File.separator + "suspend_check_file");
                this.f363322p = vy3.a.f443739h;
                this.f363323q = vy3.a.f443740i;
                int i3 = Build.VERSION.SDK_INT;
                if (i3 <= 23 && vy3.a.f443738g) {
                    SuspendThreadManager.f363305u |= 1;
                    z16 = true;
                } else {
                    if (i3 >= 24) {
                        SuspendThreadManager.f363305u |= 2;
                    }
                    z16 = false;
                }
                if (!AppSetting.isPublicVersion() && !z16) {
                    z16 = new File("/sdcard/suspend_test.txt").exists();
                    SuspendThreadManager.f363305u |= 4;
                }
                int i16 = this.f363311e.getInt("suspendCrashCount", 0);
                this.f363316j = i16;
                if (i16 > SuspendThreadManager.f363299o) {
                    SuspendThreadManager.f363305u |= 8;
                    z16 = false;
                }
                this.f363315i = this.f363311e.getInt("notResumeCountNew", 0);
                if (f()) {
                    int i17 = this.f363315i + 1;
                    this.f363315i = i17;
                    this.f363312f.putInt("notResumeCountNew", i17);
                    this.f363312f.commit();
                    l();
                }
                e();
                if (this.f363315i > SuspendThreadManager.f363300p) {
                    SuspendThreadManager.f363305u |= 16;
                    z16 = false;
                }
                QLog.d("TSManager", 1, "mCurrentNotResumeCount = " + this.f363315i + ",mCurrentCrashCount = " + this.f363316j + ",tempInitedSuccessful = " + z16);
                if (z16) {
                    Process.setThreadPriority(-2);
                    if (Math.random() < 0.10000000149011612d) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    this.f363313g = z17;
                    SuspendThreadManager.f363298n = SuspendThreadManager.D();
                    this.f363307a = Looper.getMainLooper().getThread();
                    this.f363308b = SuspendThreadManager.f363304t.getLooper().getThread();
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("suspendWatchdogThread");
                    this.f363318l = baseHandlerThread;
                    baseHandlerThread.start();
                    this.f363319m = new b(this.f363318l.getLooper(), Thread.currentThread(), this);
                    SuspendThreadManager.f363288d = SuspendThreadManager.J(this.f363318l);
                    SuspendThreadManager.f363286b = SuspendThreadManager.J(SuspendThreadManager.f363304t);
                    SuspendThreadManager.f363287c = SuspendThreadManager.J(this.f363307a);
                    this.f363320n = SuspendThreadManager.this.nativeInit(SuspendThreadManager.f363298n, SuspendThreadManager.f363286b);
                    k();
                    SuspendThreadManager.f363291g.add(this.f363307a);
                    SuspendThreadManager.f363291g.add(this.f363308b);
                    SuspendThreadManager.f363291g.add(this.f363318l);
                    d();
                }
                SuspendThreadManager.f363296l = z16;
                QLog.d("TSManager", 1, "init finished:", "mNativeApiSupportValue = ", Integer.valueOf(this.f363320n), ",sGuardThreadNativeAddr = ", Integer.valueOf(SuspendThreadManager.f363286b), ",sMainThreadNativeAddr = ", Integer.valueOf(SuspendThreadManager.f363287c), ",mFetchMainStackThisTime = ", Boolean.valueOf(this.f363313g), ",bDalvikVm = ", Boolean.valueOf(SuspendThreadManager.f363298n), ",sInitedSuccessful = ", Boolean.valueOf(SuspendThreadManager.f363296l), ",bIsFakeSuspendUser = ", Boolean.valueOf(this.f363322p), ",bSuspendWhiteListThreadOnly = ", Boolean.valueOf(this.f363323q));
            } catch (Throwable th5) {
                QLog.e("TSManager", 1, "libthreadsuspend load failed !!!", th5);
                SuspendThreadManager.f363296l = false;
                SuspendThreadManager.f363305u |= 32;
            }
        }

        private void d() {
            SuspendThreadManager.I().E(ThreadManagerV2.getSubThread().getName());
            SuspendThreadManager.I().E(ThreadManagerV2.getRecentThread().getName());
            SuspendThreadManager.I().E("MSF-Receiver");
            SuspendThreadManager.I().E("QQ_DB");
            SuspendThreadManager.I().E("QQ_FILE_RW");
        }

        private void e() {
            if (this.f363321o.exists()) {
                this.f363321o.delete();
            }
        }

        private boolean f() {
            return this.f363321o.exists();
        }

        private void g() {
            a(3);
        }

        private void h(Throwable th5) {
            this.f363312f.putInt("suspend_error_count", this.f363311e.getInt("suspend_error_count", 0) + 1);
            this.f363312f.commit();
            SuspendThreadManager.this.N(SuspendThreadManager.f363286b);
        }

        private void i() {
            String str;
            int O;
            SuspendThreadManager.f363302r = 0;
            if (SuspendThreadManager.f363292h.size() > 0) {
                Thread.State state = this.f363307a.getState();
                int i3 = this.f363317k + 1;
                this.f363317k = i3;
                if (state == Thread.State.BLOCKED) {
                    if (!this.f363310d && !SuspendThreadManager.f363298n && !SuspendThreadManager.f363293i.isEmpty()) {
                        Thread thread = (Thread) SuspendThreadManager.f363293i.get(Integer.valueOf(SuspendThreadManager.I().getContentThreadIdArt(SuspendThreadManager.f363287c)));
                        if (thread != null && SuspendThreadManager.f363292h.contains(thread) && (1 == (O = SuspendThreadManager.I().O(thread, SuspendThreadManager.f363286b)) || 2 == O)) {
                            synchronized (SuspendThreadManager.f363292h) {
                                SuspendThreadManager.f363292h.remove(thread);
                            }
                        }
                        this.f363310d = true;
                    } else {
                        if (this.f363313g) {
                            String G = SuspendThreadManager.this.G(this.f363307a, "Blocked");
                            SharedPreferences.Editor editor = this.f363312f;
                            if (editor != null) {
                                editor.putString("main_thread_stack", G);
                                this.f363312f.commit();
                            }
                        }
                        n();
                    }
                } else if (state != Thread.State.WAITING && state != Thread.State.TIMED_WAITING) {
                    this.f363309c = false;
                    this.f363310d = false;
                    if (i3 * SuspendThreadManager.f363297m > 1000) {
                        n();
                        this.f363317k = 0;
                    }
                } else if (this.f363309c) {
                    if (this.f363313g) {
                        SuspendThreadManager suspendThreadManager = SuspendThreadManager.this;
                        Thread thread2 = this.f363307a;
                        if (state == Thread.State.WAITING) {
                            str = "Waiting";
                        } else {
                            str = "TimedWaiting";
                        }
                        String G2 = suspendThreadManager.G(thread2, str);
                        SharedPreferences.Editor editor2 = this.f363312f;
                        if (editor2 != null) {
                            editor2.putString("main_thread_stack", G2);
                            this.f363312f.commit();
                        }
                    }
                    n();
                } else {
                    this.f363309c = true;
                }
            }
            if (!SuspendThreadManager.f363292h.isEmpty()) {
                p();
            }
        }

        private void j() {
            synchronized (SuspendThreadManager.f363292h) {
                SuspendThreadManager.f363292h.clear();
            }
            SuspendThreadManager.f363293i.clear();
            SuspendThreadManager.f363294j.clear();
            b("preSuspendThread", true);
            this.f363317k = 0;
            p();
            this.f363319m.b();
        }

        private void k() {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f363311e.getLong("last_report_time", 0L) > 86400000) {
                HashMap<String, String> hashMap = new HashMap<>(10);
                hashMap.put("api_support_cond", String.valueOf(this.f363320n));
                hashMap.put("resume_count", String.valueOf(this.f363311e.getInt("normal_resume_count", 0)));
                hashMap.put("timeout_count", String.valueOf(this.f363311e.getInt("timeout_resume_count", 0)));
                hashMap.put("watchdog_count", String.valueOf(this.f363311e.getInt("watchdog_resume_count", 0)));
                String str2 = "";
                hashMap.put("main_thread_stack", this.f363311e.getString("main_thread_stack", ""));
                hashMap.put("not_resume_count", String.valueOf(this.f363315i));
                hashMap.put("crash_count", String.valueOf(this.f363316j));
                hashMap.put("report_time", String.valueOf(System.currentTimeMillis()));
                hashMap.put("suspend_error_count", String.valueOf(this.f363311e.getInt("suspend_error_count", 0)));
                hashMap.put("resume_error_count", String.valueOf(this.f363311e.getInt("resume_error_count", 0)));
                String str3 = "1";
                if (this.f363322p) {
                    str = "1";
                } else {
                    str = "-1";
                }
                hashMap.put("fake_suspend", str);
                if (!this.f363323q) {
                    str3 = "-1";
                }
                hashMap.put("white_list_only", str3);
                try {
                    str2 = MobileQQ.sMobileQQ.getLastLoginUin();
                } catch (Throwable unused) {
                    QLog.e("TSManager", 1, "getAccount faild \uff01\uff01\uff01");
                }
                hashMap.put("qq_num", str2);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str2, "suspendThreadMonitor", true, this.f363320n, 0L, hashMap, null);
                this.f363312f.putLong("last_report_time", currentTimeMillis);
                this.f363312f.putInt("normal_resume_count", 0);
                this.f363312f.putInt("timeout_resume_count", 0);
                this.f363312f.putInt("suspend_error_count", 0);
                this.f363312f.putInt("resume_error_count", 0);
                this.f363312f.commit();
            }
        }

        private void l() {
            String str;
            String str2;
            HashMap<String, String> hashMap = new HashMap<>(10);
            hashMap.put("not_resume_count", String.valueOf(this.f363315i));
            hashMap.put("not_resume_time", String.valueOf(System.currentTimeMillis()));
            String str3 = "1";
            if (this.f363322p) {
                str = "1";
            } else {
                str = "-1";
            }
            hashMap.put("fake_suspend", str);
            if (!this.f363323q) {
                str3 = "-1";
            }
            hashMap.put("white_list_only", str3);
            try {
                str2 = MobileQQ.sMobileQQ.getLastLoginUin();
            } catch (Throwable unused) {
                QLog.e("TSManager", 1, "getAccount faild \uff01\uff01\uff01");
                str2 = "";
            }
            String str4 = str2;
            hashMap.put("qq_num", str4);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str4, "suspendThreadNotResume", true, 0L, 0L, hashMap, null);
        }

        private void m() {
            SuspendThreadManager.f363302r = 0;
            if (SuspendThreadManager.f363292h.size() > 0) {
                SuspendThreadManager.this.N(SuspendThreadManager.f363286b);
                a(1);
            }
        }

        private void n() {
            if (SuspendThreadManager.f363292h.size() > 0) {
                SuspendThreadManager.this.N(SuspendThreadManager.f363286b);
                if (this.f363312f != null) {
                    a(2);
                }
            }
        }

        private void p() {
            Message obtain = Message.obtain();
            obtain.what = 4;
            sendMessageDelayed(obtain, SuspendThreadManager.f363297m);
        }

        private void q(boolean z16) {
            SuspendThreadManager.f363302r = 0;
            try {
                if (SuspendThreadManager.f363292h.isEmpty()) {
                    j();
                    SuspendThreadManager.this.P(z16);
                }
            } catch (Throwable th5) {
                h(th5);
            }
        }

        public void a(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        this.f363312f.putInt("watchdog_resume_count", this.f363311e.getInt("watchdog_resume_count", 0) + 1);
                        this.f363319m.a();
                        if (SuspendThreadManager.f363302r == 1) {
                            b("afterResumeThread Watchdog", false);
                            SuspendThreadManager.f363302r = 0;
                        }
                    }
                } else {
                    this.f363312f.putInt("timeout_resume_count", this.f363311e.getInt("timeout_resume_count", 0) + 1);
                    this.f363319m.a();
                    b("afterResumeThread Timeout", false);
                }
            } else {
                this.f363312f.putInt("normal_resume_count", this.f363311e.getInt("normal_resume_count", 0) + 1);
                this.f363319m.a();
                b("afterResumeThread Normal", false);
            }
            if (SuspendThreadManager.f363301q) {
                this.f363312f.putInt("resume_error_count", this.f363311e.getInt("resume_error_count", 0) + 1);
                SuspendThreadManager.f363301q = false;
            }
            this.f363312f.commit();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                if (!this.f363322p) {
                                    g();
                                    return;
                                } else {
                                    b("fake afterResumeThread Watchdog", false);
                                    return;
                                }
                            }
                            return;
                        }
                        if (!this.f363322p) {
                            i();
                            return;
                        } else {
                            b("fake afterResumeThread Timeout", false);
                            return;
                        }
                    }
                    if (!this.f363322p) {
                        m();
                        return;
                    } else {
                        b("fake afterResumeThread Normal", false);
                        return;
                    }
                }
                if (!this.f363322p) {
                    q(this.f363323q);
                    return;
                } else {
                    b("fake preSuspendThread", true);
                    return;
                }
            }
            c();
        }

        public void o() {
            Message obtain = Message.obtain();
            obtain.what = 5;
            sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private Thread f363325a;

        /* renamed from: b, reason: collision with root package name */
        private a f363326b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f363327c;

        public b(Looper looper, Thread thread, a aVar) {
            super(looper);
            this.f363327c = false;
            this.f363325a = thread;
            this.f363326b = aVar;
        }

        public void a() {
            removeMessages(1);
        }

        public void b() {
            Message obtain = Message.obtain();
            obtain.what = 1;
            sendMessageDelayed(obtain, 200L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (this.f363325a.getState() == Thread.State.BLOCKED) {
                    if (this.f363327c) {
                        SuspendThreadManager.this.N(SuspendThreadManager.f363288d);
                        SuspendThreadManager.f363302r = 1;
                        a();
                        this.f363326b.o();
                        return;
                    }
                    this.f363327c = true;
                    b();
                    return;
                }
                if (!SuspendThreadManager.f363292h.isEmpty()) {
                    this.f363327c = false;
                    b();
                }
            }
        }
    }

    SuspendThreadManager(String str) {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str);
        f363304t = baseHandlerThread;
        baseHandlerThread.start();
        Looper looper = f363304t.getLooper();
        if (looper != null) {
            f363303s = new a(looper);
        }
    }

    static /* bridge */ /* synthetic */ boolean D() {
        return M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String G(Thread thread, String str) {
        if (thread != null) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reason:" + str + "\n");
            for (int i3 = 0; i3 < stackTrace.length && i3 < 30; i3++) {
                sb5.append(stackTrace[i3].toString());
                sb5.append("\n");
            }
            return sb5.toString();
        }
        return "";
    }

    private static Object H(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th5) {
            QLog.e("TSManager", 1, "getDalvikPrivateField", th5);
            return null;
        }
    }

    public static SuspendThreadManager I() {
        if (f363295k == null) {
            synchronized (SuspendThreadManager.class) {
                if (f363295k == null) {
                    f363295k = new SuspendThreadManager("SuspendGuardThread");
                }
            }
        }
        return f363295k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int J(Thread thread) {
        Integer num;
        try {
            Integer num2 = f363294j.get(thread);
            if (num2 != null && num2.intValue() != 0) {
                return num2.intValue();
            }
            boolean z16 = f363298n;
            if (!z16) {
                Long l3 = (Long) K(thread, "nativePeer");
                if (l3 != null) {
                    int intValue = l3.intValue();
                    f363294j.put(thread, Integer.valueOf(intValue));
                    return intValue;
                }
                return -1;
            }
            if (z16) {
                Object K = K(thread, "vmThread");
                if (K != null && (num = (Integer) H(K, "vmData")) != null) {
                    int intValue2 = num.intValue();
                    f363294j.put(thread, Integer.valueOf(intValue2));
                    return intValue2;
                }
                return 0;
            }
            return -1;
        } catch (Throwable th5) {
            QLog.e("TSManager", 1, "getNativeThreadAddr", th5);
            return -1;
        }
    }

    private static Object K(Object obj, String str) {
        try {
            Field declaredField = Thread.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th5) {
            QLog.d("TSManager", 1, "getPrivateField", th5);
            return null;
        }
    }

    private static Thread[] L() {
        try {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            Thread[] threadArr = new Thread[threadGroup.activeCount()];
            threadGroup.enumerate(threadArr);
            return threadArr;
        } catch (Throwable th5) {
            QLog.d("TSManager", 1, "getThreads", th5);
            return new Thread[0];
        }
    }

    private static boolean M() {
        int i3;
        if (((Long) K(Thread.currentThread(), "nativePeer")) != null) {
            QLog.i("TSManager", 1, "ART Mode");
            return false;
        }
        Object K = K(Thread.currentThread(), "vmThread");
        if (K != null) {
            Integer num = (Integer) H(K, "vmData");
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            if (i3 != 0) {
                QLog.i("TSManager", 1, "Dalvik Mode");
                return true;
            }
        }
        QLog.i("TSManager", 1, "default ART Mode");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(int i3) {
        f363301q = false;
        synchronized (f363292h) {
            if (!f363292h.isEmpty()) {
                Iterator<Thread> it = f363292h.iterator();
                while (it.hasNext()) {
                    if (O(it.next(), i3) == 2) {
                        f363301q = true;
                    }
                }
                f363292h.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O(Thread thread, int i3) {
        int resumeThreadDalvik;
        if (!f363298n) {
            resumeThreadDalvik = resumeThreadArt(J(thread), i3);
        } else {
            resumeThreadDalvik = resumeThreadDalvik(J(thread));
        }
        if (-1 == resumeThreadDalvik) {
            QLog.i("TSManager", 1, "resumeThread Fail,thread = " + thread);
        }
        return resumeThreadDalvik;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(boolean z16) {
        try {
            if (f363292h.isEmpty()) {
                for (Thread thread : L()) {
                    if (thread != null && !f363290f.contains(thread.getName()) && !f363291g.contains(thread) && !thread.getName().contains("Binder") && !thread.getName().contains("RenderThread") && !thread.getName().contains("Automator") && !thread.getName().contains("thread_sp") && !thread.getName().contains("logWriteThread") && !thread.getName().contains("Bugly")) {
                        if (thread.isAlive() && z16 && f363289e.contains(thread.getName())) {
                            I().Q(thread);
                            synchronized (f363292h) {
                                f363292h.add(thread);
                            }
                        } else if (!z16 && thread.isAlive()) {
                            I().Q(thread);
                            synchronized (f363292h) {
                                f363292h.add(thread);
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
            N(f363286b);
        }
    }

    private void Q(Thread thread) {
        int suspendThreadDalvik;
        if (!f363298n) {
            suspendThreadDalvik = suspendThreadArt(J(thread), f363286b);
            if (suspendThreadDalvik != 0) {
                f363293i.put(Integer.valueOf(suspendThreadDalvik), thread);
            }
        } else {
            suspendThreadDalvik = suspendThreadDalvik(J(thread));
        }
        if (-1 == suspendThreadDalvik) {
            QLog.i("TSManager", 1, "suspendThread Fail,thread = " + thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int getContentThreadIdArt(int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeInit(boolean z16, int i3);

    private native int resumeThreadArt(int i3, int i16);

    private native int resumeThreadDalvik(int i3);

    private native int suspendThreadArt(int i3, int i16);

    private native int suspendThreadDalvik(int i3);

    public void E(String str) {
        f363289e.add(str);
    }

    public void F() {
        SharedPreferences a16 = vy3.a.a();
        int i3 = a16.getInt("suspendCrashCount", 0);
        SharedPreferences.Editor edit = a16.edit();
        if (edit == null) {
            return;
        }
        int i16 = i3 + 1;
        QLog.d("TSManager", 1, "SuspendThreadManager has crashed " + i16 + " times");
        edit.putInt("suspendCrashCount", i16);
        edit.commit();
    }

    public void R() {
        if (!f363296l && f363303s != null) {
            QLog.i("TSManager", 1, "suspendThreads faild");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        a aVar = f363303s;
        if (aVar != null) {
            aVar.sendMessage(obtain);
        } else {
            QLog.e("TSManager", 1, "sGuardThreadHandler is null, cannot send suspend message");
        }
    }
}
