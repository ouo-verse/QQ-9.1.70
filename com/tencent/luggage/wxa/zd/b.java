package com.tencent.luggage.wxa.zd;

import android.os.HandlerThread;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b0 f146489a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile HandlerThread f146490b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f146491c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final Set f146492d = new ConcurrentSkipListSet();

    public static void a(String str) {
        w.d("MicroMsg.Audio.AudioApiTaskExecutor", "onCreate %s", str);
        f146492d.add(str);
    }

    public static void b(String str) {
        w.d("MicroMsg.Audio.AudioApiTaskExecutor", "onDestroy:%s", str);
        Set set = f146492d;
        if (set.remove(str) && set.isEmpty()) {
            synchronized (f146491c) {
                b();
            }
        }
    }

    public static void a() {
        if (f146490b == null) {
            f146490b = com.tencent.luggage.wxa.cq.d.c("app_brand_audio_player", 5);
            f146490b.start();
            com.tencent.luggage.wxa.yo.f.a("app_brand_audio_player", new com.tencent.luggage.wxa.yo.g(f146490b.getLooper(), "app_brand_audio_player"));
        }
        f146489a = new b0(f146490b.getLooper());
    }

    public static void b() {
        if (f146490b != null) {
            com.tencent.luggage.wxa.yo.f.b("app_brand_audio_player");
            f146490b.quit();
            f146490b = null;
            f146489a = null;
        }
    }

    public static void a(Runnable runnable) {
        if (f146489a == null) {
            synchronized (f146491c) {
                if (f146489a == null) {
                    a();
                }
            }
        }
        f146489a.a(runnable);
    }
}
