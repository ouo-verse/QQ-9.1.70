package com.tencent.luggage.wxa.s7;

import com.tencent.luggage.wxa.tn.w;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final e f140120a;

    /* renamed from: b, reason: collision with root package name */
    public static Thread.UncaughtExceptionHandler f140121b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f140122c;

    static {
        e eVar = new e();
        f140120a = eVar;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Intrinsics.checkNotNullExpressionValue(defaultUncaughtExceptionHandler, "getDefaultUncaughtExceptionHandler()");
        f140121b = defaultUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(eVar);
        f140122c = new ArrayList();
    }

    public final void a(a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        f140122c.add(l3);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable throwable) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        throwable.printStackTrace();
        try {
            Iterator it = f140122c.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(thread, throwable);
            }
        } catch (Exception e16) {
            w.a("Luggage.WXA.CrashReportSetup", e16, "invoke crash handler fail", new Object[0]);
        }
        w.b();
        f140121b.uncaughtException(thread, throwable);
    }
}
