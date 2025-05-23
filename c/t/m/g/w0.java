package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<String, HandlerThread> f30087a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap<String, Integer> f30088b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static ConcurrentHashMap<String, Long> f30089c = new ConcurrentHashMap<>();

    public static synchronized HandlerThread a(String str, int i3) {
        HandlerThread handlerThread;
        synchronized (w0.class) {
            handlerThread = f30087a.get(str);
            if (handlerThread == null) {
                handlerThread = new BaseHandlerThread(str, i3);
                handlerThread.start();
                f30087a.put(str, handlerThread);
                f30088b.put(str, 1);
            } else {
                ConcurrentHashMap<String, Integer> concurrentHashMap = f30088b;
                concurrentHashMap.put(str, Integer.valueOf(concurrentHashMap.get(str).intValue() + 1));
            }
        }
        return handlerThread;
    }

    public static synchronized HandlerThread b(String str) {
        HandlerThread a16;
        synchronized (w0.class) {
            a16 = a(str, 0);
        }
        return a16;
    }

    public static void a(String str) {
        a(str, 0L);
    }

    public static synchronized void a(String str, long j3) {
        synchronized (w0.class) {
            if (f30088b.containsKey(str)) {
                int intValue = f30088b.get(str).intValue() - 1;
                if (intValue == 0) {
                    f30088b.remove(str);
                    HandlerThread remove = f30087a.remove(str);
                    if (f30089c.containsKey(str)) {
                        j3 = Math.max(j3, f30089c.remove(str).longValue() - System.currentTimeMillis());
                    }
                    x0.a(remove, null, j3, false);
                } else {
                    f30088b.put(str, Integer.valueOf(intValue));
                    if (j3 != 0) {
                        f30089c.put(str, Long.valueOf(Math.max(System.currentTimeMillis() + j3, f30089c.containsKey(str) ? f30089c.get(str).longValue() : 0L)));
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, Runnable runnable) {
        synchronized (w0.class) {
            y0.a(new Handler(b(str).getLooper()), runnable);
            a(str);
        }
    }
}
