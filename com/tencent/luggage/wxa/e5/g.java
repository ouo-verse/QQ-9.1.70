package com.tencent.luggage.wxa.e5;

import android.os.SystemClock;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.l0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f124544a = new g();

    public static final String a(String logName, Runnable run) {
        Intrinsics.checkNotNullParameter(logName, "logName");
        Intrinsics.checkNotNullParameter(run, "run");
        return a(logName, run, null, 4, null);
    }

    public static /* synthetic */ String a(String str, Runnable runnable, Function2 function2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function2 = a.f124545a;
        }
        return a(str, runnable, function2);
    }

    public static final Object a(String logName, Function0 block) {
        String str;
        Intrinsics.checkNotNullParameter(logName, "logName");
        Intrinsics.checkNotNullParameter(block, "block");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Object invoke = block.invoke();
        if (invoke == null || (str = invoke.toString()) == null) {
            str = "";
        }
        boolean a16 = l0.a();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 32 && a16) {
            w.f("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + logName + " cost " + elapsedRealtime2 + " ms result:" + str + " isMainThread: " + a16 + TokenParser.SP);
        } else {
            w.d("Luggage.Utils.Profile", "runProfiled:log:" + logName + " cost " + elapsedRealtime2 + " ms result:" + str + " isMainThread: " + a16 + TokenParser.SP);
        }
        return invoke;
    }

    public static final String a(String logName, Runnable run, Function2 profileFunc) {
        Intrinsics.checkNotNullParameter(logName, "logName");
        Intrinsics.checkNotNullParameter(run, "run");
        Intrinsics.checkNotNullParameter(profileFunc, "profileFunc");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        run.run();
        String obj = "".toString();
        if (obj == null) {
            obj = "";
        }
        boolean a16 = l0.a();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 > 32 && a16) {
            w.f("Luggage.Utils.Profile", "block main thread and skip " + ((int) (elapsedRealtime2 / 16)) + " frames! runProfiled:log:" + logName + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + a16 + TokenParser.SP);
        } else {
            w.d("Luggage.Utils.Profile", "runProfiled:log:" + logName + " cost " + elapsedRealtime2 + " ms result:" + obj + " isMainThread: " + a16 + TokenParser.SP);
        }
        return "";
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f124545a = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).longValue(), ((Number) obj2).longValue());
            return Unit.INSTANCE;
        }

        public final void a(long j3, long j16) {
        }
    }
}
