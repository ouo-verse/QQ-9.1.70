package com.tencent.matrix.traffic;

import android.os.Looper;
import androidx.annotation.Keep;
import e51.a;
import g51.b;
import g51.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes9.dex */
public class TrafficPlugin extends a {

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f151487a = false;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<String> f151488b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f151489c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, String> f151490d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private static int f151491e = 50;

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList<f51.a> f151492f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private static boolean f151493g = false;

    static {
        try {
            System.loadLibrary("matrix-traffic");
            f151488b.add("libcore.io.");
            f151488b.add("java.net.");
            f151488b.add("org.apache.http.");
            f151488b.add("okhttp3.internal");
            f151488b.add("com.android.okhttp.");
            f151487a = true;
        } catch (Throwable th5) {
            b.b("TrafficPlugin", "LoadLibrary Error: " + th5.toString(), new Object[0]);
            f151487a = false;
        }
    }

    private static void b(StringBuilder sb5) {
        if (!f151493g) {
            return;
        }
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        if (stackTrace.length > 0) {
            sb5.append("---mainThread---");
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append(stackTraceElement.toString());
            sb5.append("\n");
        }
    }

    private static native void nativeClearTrafficInfo();

    private static native String nativeGetNativeBackTraceByKey(String str);

    private static native HashMap<String, String> nativeGetTrafficConnectMap();

    private static native HashMap<String, ArrayList<String>> nativeGetTrafficDetailTimeMap(int i3);

    private static native HashMap<String, String> nativeGetTrafficInfoMap(int i3);

    private static native void nativeInitMatrixTraffic(boolean z16, boolean z17, boolean z18, boolean z19, String[] strArr);

    private static native void nativeReleaseMatrixTraffic();

    private static native void nativeSetCacheMapMaxSize(int i3);

    private static native void nativeStartBgDetailMonitor();

    private static native void nativeStopBgDetailMonitor();

    @Keep
    private static void notifyMonitors() {
        b.c("TrafficPlugin", "notifyMonitors", new Object[0]);
        Iterator<f51.a> it = f151492f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Keep
    private static void setFdStackTrace(String str) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i3 = 3; i3 < stackTrace.length; i3++) {
            String stackTraceElement = stackTrace[i3].toString();
            Iterator<String> it = f151488b.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (stackTraceElement.startsWith(it.next())) {
                        z16 = false;
                        break;
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                sb5.append(stackTraceElement);
                sb5.append("\n");
            }
        }
        b(sb5);
        if (sb5.length() > 0) {
            String d16 = c.d(sb5.toString());
            Map<String, String> map = f151489c;
            if (!map.containsKey(d16)) {
                map.put(d16, sb5.toString());
            }
            f151490d.put(str, d16);
        }
    }
}
