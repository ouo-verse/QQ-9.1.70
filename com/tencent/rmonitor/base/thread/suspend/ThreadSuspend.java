package com.tencent.rmonitor.base.thread.suspend;

import com.tencent.bugly.common.config.configs.CommonConfig;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.rmonitor.base.config.ConfigFetcher;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ThreadSuspend {

    /* renamed from: c, reason: collision with root package name */
    private static ThreadSuspend f365437c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f365438d = false;

    /* renamed from: a, reason: collision with root package name */
    private boolean f365439a = e();

    /* renamed from: b, reason: collision with root package name */
    private boolean f365440b;

    ThreadSuspend() {
    }

    public static ThreadSuspend c() {
        if (f365437c == null) {
            synchronized (ThreadSuspend.class) {
                if (f365437c == null) {
                    f365437c = new ThreadSuspend();
                }
            }
        }
        return f365437c;
    }

    private boolean e() {
        if (!b()) {
            Logger.f365497g.i("RMonitor_ThreadSuspend", "enableThisTime return false");
            return false;
        }
        try {
            this.f365440b = false;
            System.loadLibrary("rmonitor_base");
            this.f365440b = true;
            int nativeInit = nativeInit(PrivacyInformation.getInstance().getAndroidFrameworkVersion());
            Logger.f365497g.d("RMonitor_ThreadSuspend", "nativeInit's result is " + nativeInit);
            if (nativeInit == 0) {
                return true;
            }
            b.a(nativeInit);
            return false;
        } catch (Throwable th5) {
            Logger.f365497g.e("RMonitor_ThreadSuspend", "init failed: " + th5);
            b.a(999);
            return false;
        }
    }

    public boolean a(boolean z16, boolean z17) {
        if (this.f365440b && AndroidVersion.isOverO()) {
            nativeHookStackTrace(z16, z17);
            return true;
        }
        return false;
    }

    public boolean b() {
        k d16;
        if (f365438d) {
            return false;
        }
        String cpuAbiByLibDir = DeviceInfoUtil.getCpuAbiByLibDir(ContextUtil.getGlobalContext());
        if (cpuAbiByLibDir.contains(ResourceAttributes.HostArchValues.X86) || cpuAbiByLibDir.contains("fail") || !AndroidVersion.isOverM() || (d16 = ConfigFetcher.g().d("common")) == null || !(d16 instanceof CommonConfig)) {
            return false;
        }
        return ((CommonConfig) d16).isEnableThreadSuspend();
    }

    public int d(Thread thread) {
        if (this.f365439a && thread != null && thread.isAlive()) {
            return nativeGetThreadId(a.a(thread));
        }
        return 0;
    }

    public boolean f(long j3) {
        if (this.f365439a && j3 != 0) {
            return nativeResumeThread(j3);
        }
        return false;
    }

    public long g(Thread thread) {
        Thread currentThread = Thread.currentThread();
        if (this.f365439a && thread != null && thread.isAlive() && thread != currentThread) {
            long a16 = a.a(thread);
            if (a16 != -1) {
                int nativeGetThreadId = nativeGetThreadId(a16);
                if (nativeGetThreadId != 0) {
                    return nativeSuspendThread(nativeGetThreadId);
                }
                Logger.f365497g.e("RMonitor_ThreadSuspend", "thread id is not valid");
                return 0L;
            }
            return 0L;
        }
        return 0L;
    }

    native int nativeGetThreadId(long j3);

    native void nativeHookStackTrace(boolean z16, boolean z17);

    native int nativeInit(int i3);

    native boolean nativeResumeThread(long j3);

    native long nativeSuspendThread(int i3);
}
