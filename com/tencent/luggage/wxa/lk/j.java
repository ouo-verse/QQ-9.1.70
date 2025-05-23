package com.tencent.luggage.wxa.lk;

import android.util.Log;
import com.luggage.trace.TraceLogic;
import com.tencent.luggage.wxa.ic.b0;
import com.tencent.luggage.wxa.tn.w;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f133593c;

    /* renamed from: a, reason: collision with root package name */
    public static final j f133591a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static int f133592b = -1;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap f133594d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public static b f133595e = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements b {
        @Override // com.tencent.luggage.wxa.lk.b
        public com.tencent.luggage.wxa.lk.a a(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return f.f133585a;
                        }
                        return new b0();
                    }
                    return i.f133589b;
                }
                return h.f133587b;
            }
            return new g();
        }
    }

    public static final void a(String str, boolean z16) {
        a(str, z16 ? 0 : f133592b);
    }

    public static final int b(String str, String category, String name) {
        com.tencent.luggage.wxa.lk.a aVar;
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!f133593c || (aVar = (com.tencent.luggage.wxa.lk.a) f133594d.get(str)) == null) {
            return -1;
        }
        return aVar.traceBegin2(category, name);
    }

    public static final void c(String str, String category, String name) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        if (f133593c) {
            com.tencent.luggage.wxa.lk.a aVar = (com.tencent.luggage.wxa.lk.a) f133594d.get(str);
            if (aVar != null) {
                aVar.traceBegin(category, name);
            }
            com.tencent.luggage.wxa.lk.a aVar2 = (com.tencent.luggage.wxa.lk.a) f133594d.get(str);
            if (aVar2 != null) {
                aVar2.traceEnd();
            }
        }
    }

    public static final void a(String str, int i3) {
        f133593c = i3 != -1;
        w.d("Luggage.LuggageTracer", "init instanceId:" + str);
        if (str == null) {
            w.f("Luggage.LuggageTracer", "init fail, instanceId is null, stack:" + Log.getStackTraceString(new Throwable()));
            return;
        }
        f133594d.put(str, f133595e.a(i3));
    }

    public static final void b(String str, int i3) {
        com.tencent.luggage.wxa.lk.a aVar;
        if (!f133593c || (aVar = (com.tencent.luggage.wxa.lk.a) f133594d.get(str)) == null) {
            return;
        }
        aVar.traceEnd2(i3);
    }

    public static final void c(String str) {
        com.tencent.luggage.wxa.lk.a aVar;
        if (!f133593c || (aVar = (com.tencent.luggage.wxa.lk.a) f133594d.get(str)) == null) {
            return;
        }
        aVar.traceEnd();
    }

    public static final void b(String str) {
        if (f133593c) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.luggage.wxa.lk.a aVar = (com.tencent.luggage.wxa.lk.a) f133594d.get(str);
            if (aVar != null) {
                aVar.startTrace();
            }
            w.d("Luggage.LuggageTracer", "startTrace cost:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static final com.tencent.luggage.wxa.lk.a a(String str) {
        w.d("Luggage.LuggageTracer", "get instanceId:" + str);
        return (com.tencent.luggage.wxa.lk.a) f133594d.get(str);
    }

    public static final double a() {
        if (f133593c) {
            return TraceLogic.INSTANCE.currentMicroseconds();
        }
        return 0.0d;
    }

    public static final void a(String str, String category, String name) {
        com.tencent.luggage.wxa.lk.a aVar;
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!f133593c || (aVar = (com.tencent.luggage.wxa.lk.a) f133594d.get(str)) == null) {
            return;
        }
        aVar.traceBegin(category, name);
    }
}
