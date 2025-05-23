package hynb.o;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final HandlerThread f406794a;

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f406795b;

    static {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("HuyaSDK-ThreadUtilsHandlerThread");
        f406794a = baseHandlerThread;
        baseHandlerThread.start();
        f406795b = new Handler(baseHandlerThread.getLooper());
    }

    public static void a(Runnable runnable, long j3) {
        f406795b.postDelayed(runnable, j3);
    }
}
