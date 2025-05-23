package com.tencent.luggage.wxa.b9;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.eclipsesource.mmv8.MultiContextV8;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j0 {

    /* renamed from: h, reason: collision with root package name */
    public static final String f122227h = "MicroMsg.V8MemoryPressureMonitor" + com.tencent.luggage.wxa.tn.z.i().replace(com.tencent.luggage.wxa.tn.z.a(), "");

    /* renamed from: b, reason: collision with root package name */
    public final MultiContextV8 f122229b;

    /* renamed from: d, reason: collision with root package name */
    public boolean f122231d;

    /* renamed from: a, reason: collision with root package name */
    public final int f122228a = 1000;

    /* renamed from: c, reason: collision with root package name */
    public Integer f122230c = null;

    /* renamed from: e, reason: collision with root package name */
    public int f122232e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f122233f = new a();

    /* renamed from: g, reason: collision with root package name */
    public final ComponentCallbacks2 f122234g = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.d();
        }
    }

    public j0(MultiContextV8 multiContextV8) {
        this.f122229b = multiContextV8;
    }

    public void b() {
    }

    public void c() {
    }

    public final void d(int i3) {
        e();
        this.f122232e = i3;
        com.tencent.luggage.wxa.tn.w.d(f122227h, "reportPressure [%s]", i3 == 2 ? "CRITICAL" : i3 == 1 ? "MODERATE" : "NONE");
        this.f122229b.memoryPressureNotification(i3);
    }

    public final void e() {
        com.tencent.luggage.wxa.tn.w.d(f122227h, "startThrottlingInterval");
    }

    public static Integer b(int i3) {
        if (i3 >= 80 || i3 == 15) {
            return 2;
        }
        return i3 >= 40 ? 1 : null;
    }

    public void c(int i3) {
        if (this.f122231d) {
            com.tencent.luggage.wxa.tn.w.d(f122227h, "notifyPressure but throttle");
            this.f122230c = Integer.valueOf(i3);
        } else {
            d(i3);
        }
    }

    public final void d() {
        com.tencent.luggage.wxa.tn.w.d(f122227h, "onThrottlingIntervalFinished");
        this.f122231d = false;
        Integer num = this.f122230c;
        if (num == null || this.f122232e == num.intValue()) {
            return;
        }
        int intValue = this.f122230c.intValue();
        this.f122230c = null;
        d(intValue);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ComponentCallbacks2 {
        public b() {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            com.tencent.luggage.wxa.tn.w.d(j0.f122227h, "onLowMemory");
            j0.this.c(2);
            com.tencent.luggage.wxa.tn.w.d(j0.f122227h, "onLowMemory notification with CRITICAL end");
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i3) {
            com.tencent.luggage.wxa.tn.w.d(j0.f122227h, "onTrimMemory level = [%d]", Integer.valueOf(i3));
            Integer b16 = j0.b(i3);
            if (b16 != null) {
                j0.this.c(b16.intValue());
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }
    }
}
