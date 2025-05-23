package com.tencent.rmonitor.looper.provider;

import android.annotation.SuppressLint;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static final e f365689d = new e();

    /* renamed from: b, reason: collision with root package name */
    private HandlerThread f365691b = null;

    /* renamed from: c, reason: collision with root package name */
    private Looper f365692c = null;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Thread, HandlerThread> f365690a = new ConcurrentHashMap<>();

    e() {
    }

    public static Looper a(Thread thread) {
        if (e(thread)) {
            return f365689d.c();
        }
        return f365689d.b(thread);
    }

    private Looper b(Thread thread) {
        if (d(thread)) {
            return null;
        }
        HandlerThread handlerThread = this.f365690a.get(thread);
        if (handlerThread == null) {
            synchronized (this.f365690a) {
                handlerThread = this.f365690a.get(thread);
                if (handlerThread == null) {
                    String name = thread.getName();
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RStack_Of_" + name);
                    baseHandlerThread.start();
                    this.f365690a.put(thread, baseHandlerThread);
                    Logger.f365497g.i("RMonitor_looper_StackThreadProvider", "create stack thread for [" + name + "]");
                    handlerThread = baseHandlerThread;
                }
            }
        }
        return handlerThread.getLooper();
    }

    private Looper c() {
        if (this.f365692c == null) {
            synchronized (this) {
                if (this.f365692c == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RStack_Of_Main");
                    this.f365691b = baseHandlerThread;
                    baseHandlerThread.setPriority(10);
                    this.f365691b.start();
                    this.f365692c = this.f365691b.getLooper();
                    Logger.f365497g.i("RMonitor_looper_StackThreadProvider", "create stack thread for main thread. looper[" + this.f365692c + "]");
                }
            }
        }
        return this.f365692c;
    }

    private boolean d(Thread thread) {
        if (thread == null) {
            return true;
        }
        return false;
    }

    private static boolean e(Thread thread) {
        if (thread == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private void f(HandlerThread handlerThread) {
        if (handlerThread == null) {
            return;
        }
        if (AndroidVersion.isOverJellyBeanMr2()) {
            handlerThread.quitSafely();
        } else {
            handlerThread.quit();
        }
        Logger.f365497g.i("RMonitor_looper_StackThreadProvider", "quit stack thread [" + handlerThread.getName() + "]");
    }

    public static boolean g(Thread thread) {
        return f365689d.h(thread);
    }

    private boolean h(Thread thread) {
        if (d(thread) || e(thread)) {
            return false;
        }
        HandlerThread remove = this.f365690a.remove(thread);
        f(remove);
        if (remove != null) {
            Logger.f365497g.i("RMonitor_looper_StackThreadProvider", "release stack thread for [" + thread.getName() + "]");
        }
        if (remove == null) {
            return false;
        }
        return true;
    }
}
