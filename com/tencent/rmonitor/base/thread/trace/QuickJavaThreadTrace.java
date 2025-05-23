package com.tencent.rmonitor.base.thread.trace;

import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.base.thread.suspend.ThreadSuspend;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QuickJavaThreadTrace {

    /* renamed from: g, reason: collision with root package name */
    private static boolean f365442g = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f365443a;

    /* renamed from: b, reason: collision with root package name */
    private int f365444b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f365445c = 0;

    /* renamed from: d, reason: collision with root package name */
    private Thread f365446d;

    /* renamed from: e, reason: collision with root package name */
    private long f365447e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f365448f;

    static {
        boolean z16;
        Object obj;
        int i3;
        boolean z17 = true;
        int i16 = 0;
        try {
            if (AndroidVersion.isOverM()) {
                System.loadLibrary("rmonitor_base");
                int nativeInit = nativeInit(PrivacyInformation.getInstance().getAndroidFrameworkVersion());
                try {
                    if (nativeInit == 0) {
                        f365442g = true;
                        Logger.f365497g.d("RMonitor_ThreadTrace", "init success");
                    } else {
                        Logger.f365497g.e("RMonitor_ThreadTrace", "init error, initResult = " + nativeInit);
                    }
                    i16 = nativeInit;
                } catch (Throwable th5) {
                    obj = th5;
                    i3 = nativeInit;
                    z16 = true;
                    Logger logger = Logger.f365497g;
                    String[] strArr = new String[2];
                    strArr[i16] = "RMonitor_ThreadTrace";
                    strArr[1] = "init failed: " + obj;
                    logger.e(strArr);
                    a.c(999);
                    z17 = z16;
                    i16 = i3;
                    if (f365442g) {
                    } else {
                        return;
                    }
                }
            } else {
                z17 = false;
            }
        } catch (Throwable th6) {
            z16 = false;
            obj = th6;
            i3 = 0;
        }
        if (f365442g && z17) {
            a.c(i16);
        }
    }

    public QuickJavaThreadTrace(Thread thread, boolean z16, boolean z17) {
        this.f365443a = false;
        this.f365446d = null;
        this.f365447e = 0L;
        this.f365448f = false;
        if (f365442g && thread != null && thread.isAlive()) {
            try {
                long d16 = ThreadSuspend.c().d(thread);
                if (0 == d16) {
                    this.f365448f = false;
                    Logger.f365497g.e("RMonitor_ThreadTrace", "NativeGetThreadID error");
                    a.b();
                } else {
                    long nativeCreate = nativeCreate(com.tencent.rmonitor.base.thread.suspend.a.a(thread), d16, z16, z17);
                    this.f365447e = nativeCreate;
                    if (nativeCreate != 0) {
                        this.f365446d = thread;
                        this.f365443a = z16;
                        this.f365448f = true;
                    } else {
                        this.f365446d = null;
                        this.f365443a = false;
                        this.f365448f = false;
                        a.a();
                    }
                }
            } catch (Throwable th5) {
                this.f365448f = false;
                Logger.f365497g.e("RMonitor_ThreadTrace", "nativeCreate faild: " + th5);
            }
        }
    }

    public static boolean f() {
        return f365442g;
    }

    static native int nativeInit(int i3);

    public ArrayList<b> d(long j3, long j16) {
        Thread thread;
        if (this.f365448f && (thread = this.f365446d) != null && thread.isAlive()) {
            String nativeGetStackTrace = nativeGetStackTrace(this.f365447e, j3, j16);
            ArrayList<b> a16 = c.a(nativeGetStackTrace);
            Collections.sort(a16);
            if (this.f365443a) {
                a.f(a16, this.f365444b);
                a.d(nativeGetStackTrace.substring(nativeGetStackTrace.lastIndexOf("#") + 1));
            }
            return a16;
        }
        return null;
    }

    public boolean e() {
        Thread thread;
        if (this.f365448f && (thread = this.f365446d) != null && thread.isAlive()) {
            return true;
        }
        return false;
    }

    public boolean g(int i3, int i16) {
        Thread thread;
        if (this.f365448f && (thread = this.f365446d) != null && thread.isAlive()) {
            this.f365444b = i3;
            this.f365445c = i16;
            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.rmonitor.base.thread.trace.QuickJavaThreadTrace.1
                @Override // java.lang.Runnable
                public void run() {
                    a.e();
                    QuickJavaThreadTrace quickJavaThreadTrace = QuickJavaThreadTrace.this;
                    quickJavaThreadTrace.nativePrepare(quickJavaThreadTrace.f365447e, com.tencent.rmonitor.base.thread.suspend.a.a(Thread.currentThread()), false, QuickJavaThreadTrace.this.f365444b, QuickJavaThreadTrace.this.f365445c);
                }
            });
            baseThread.setName("QST-" + this.f365446d.getName());
            baseThread.start();
            return true;
        }
        return false;
    }

    public boolean h() {
        Thread thread;
        if (this.f365448f && (thread = this.f365446d) != null && thread.isAlive()) {
            nativeStart(this.f365447e);
            return true;
        }
        return false;
    }

    public boolean i() {
        Thread thread;
        if (this.f365448f && (thread = this.f365446d) != null && thread.isAlive()) {
            nativeStop(this.f365447e);
            return true;
        }
        return false;
    }

    native long nativeCreate(long j3, long j16, boolean z16, boolean z17);

    native void nativeDestroy(long j3);

    native String nativeGetStackTrace(long j3, long j16, long j17);

    native void nativePrepare(long j3, long j16, boolean z16, int i3, int i16);

    native void nativeStart(long j3);

    native void nativeStop(long j3);
}
