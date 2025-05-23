package com.tencent.av.qavperf.manager;

import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Looper f74229a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Looper f74230b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Looper f74231c;

    public static Looper a() {
        if (f74231c == null) {
            synchronized (d.class) {
                if (f74231c == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("QAVP_CPU");
                    baseHandlerThread.start();
                    f74231c = baseHandlerThread.getLooper();
                }
            }
        }
        return f74231c;
    }

    public static Looper b() {
        if (f74229a == null) {
            synchronized (d.class) {
                if (f74229a == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("QAVP_FPS");
                    baseHandlerThread.start();
                    f74229a = baseHandlerThread.getLooper();
                }
            }
        }
        return f74229a;
    }

    public static Looper c() {
        if (f74230b == null) {
            synchronized (d.class) {
                if (f74230b == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("QAVP_MEMORY");
                    baseHandlerThread.start();
                    f74230b = baseHandlerThread.getLooper();
                }
            }
        }
        return f74230b;
    }
}
