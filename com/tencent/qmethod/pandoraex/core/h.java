package com.tencent.qmethod.pandoraex.core;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes22.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Handler f344134a;

    /* renamed from: b, reason: collision with root package name */
    private static HandlerThread f344135b;

    public static Handler a() {
        if (f344134a == null) {
            synchronized (x.class) {
                if (f344134a == null) {
                    BaseHandlerThread baseHandlerThread = new BaseHandlerThread("QMethodPandoraEx", 0);
                    f344135b = baseHandlerThread;
                    baseHandlerThread.start();
                    f344134a = new Handler(f344135b.getLooper());
                }
            }
        }
        return f344134a;
    }
}
