package com.tencent.luggage.wxa.b9;

import android.os.SystemClock;
import com.eclipsesource.mmv8.IV8Tracer;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8TracerAccessible;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f122202a = new e0();

    /* renamed from: b, reason: collision with root package name */
    public static final long f122203b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements IV8Tracer {
        @Override // com.eclipsesource.mmv8.IV8Tracer
        public void beginSection(String scetionName) {
            Intrinsics.checkNotNullParameter(scetionName, "scetionName");
            com.tencent.luggage.wxa.lk.c.f133579a.a(scetionName);
        }

        @Override // com.eclipsesource.mmv8.IV8Tracer
        public void endSection() {
            com.tencent.luggage.wxa.lk.c.f133579a.a();
        }
    }

    static {
        V8TracerAccessible.setTracer(new a());
        try {
            com.tencent.luggage.wxa.lk.c cVar = com.tencent.luggage.wxa.lk.c.f133579a;
            cVar.a("LoadV8So");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            V8.getFlags();
            com.tencent.luggage.wxa.aa.h.b("mmv8", l.class.getClassLoader());
            com.tencent.luggage.wxa.aa.h.b("mmnode", l.class.getClassLoader());
            com.tencent.luggage.wxa.aa.h.b("mmj2v8", l.class.getClassLoader());
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            f122203b = elapsedRealtime2;
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.V8Env", "init, cost " + elapsedRealtime2 + " ms");
            cVar.a();
        } catch (Throwable th5) {
            com.tencent.luggage.wxa.lk.c.f133579a.a();
            throw th5;
        }
    }

    public static final long a() {
        return f122203b;
    }
}
