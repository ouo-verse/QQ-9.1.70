package com.tencent.tmassistantbase.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static Map<b, Handler> f380461a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Handler f380462b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f380463a = new b("YYB_DOWNLOAD_SDK_DEFAULT", 0);

        /* renamed from: b, reason: collision with root package name */
        public static final b f380464b = new b("YYB_DOWNLOAD_SDK_CLIENT", 1);

        /* renamed from: c, reason: collision with root package name */
        public static final b f380465c = new b("YYB_NET_DOWNLOAD_SDK", 2);

        /* renamed from: d, reason: collision with root package name */
        public static final b f380466d = new b("YYB_DOWNLOAD_SDK_CONFIG", 3);

        /* renamed from: e, reason: collision with root package name */
        public static final b f380467e = new b("YYB_DOWNLOAD_SDK_HELPER", 4);

        /* renamed from: f, reason: collision with root package name */
        public static final b f380468f = new b("YYB_DOWNLOAD_SDK_FETCH", 5);

        b(String str, int i3) {
        }
    }

    private static Handler a(b bVar) {
        if (f380461a.containsKey(bVar)) {
            return f380461a.get(bVar);
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(bVar.name());
        baseHandlerThread.start();
        a aVar = new a(baseHandlerThread.getLooper());
        f380461a.put(bVar, aVar);
        return aVar;
    }

    public static Looper b(b bVar) {
        return a(bVar).getLooper();
    }

    public static Handler a() {
        if (f380462b == null) {
            f380462b = a(b.f380463a);
        }
        return f380462b;
    }
}
