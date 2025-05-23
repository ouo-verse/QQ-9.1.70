package com.tencent.mobileqq.kandian.base.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f239078a;

    /* renamed from: b, reason: collision with root package name */
    private static Handler f239079b;

    /* renamed from: c, reason: collision with root package name */
    private static ReadInJoySSOHandlerThread f239080c;

    /* renamed from: d, reason: collision with root package name */
    private static Queue<Integer> f239081d = new LinkedBlockingQueue(100);

    /* renamed from: e, reason: collision with root package name */
    private static String f239082e = null;

    public static Handler a() {
        if (f239079b == null) {
            synchronized (e.class) {
                if (f239079b == null) {
                    f239079b = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f239079b;
    }

    public static synchronized Handler b() {
        Handler handler;
        synchronized (e.class) {
            if (f239080c == null) {
                ReadInJoySSOHandlerThread readInJoySSOHandlerThread = new ReadInJoySSOHandlerThread("kandian_network_thread");
                f239080c = readInJoySSOHandlerThread;
                readInJoySSOHandlerThread.start();
                f239078a = new Handler(f239080c.getLooper());
            }
            handler = f239078a;
        }
        return handler;
    }
}
