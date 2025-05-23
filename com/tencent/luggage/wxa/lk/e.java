package com.tencent.luggage.wxa.lk;

import android.content.Context;
import android.os.Trace;
import androidx.core.os.TraceCompat;
import com.tencent.luggage.wxa.tn.w;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f133582a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f133583b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f133584c = new AtomicInteger(0);

    public static final void a(Context context) {
        Object m476constructorimpl;
        if (!f133583b.compareAndSet(false, true)) {
            w.d("MicroMsg.LuggageSystrace", "enable, hasTryEnable");
            return;
        }
        if (f133582a.b(context)) {
            w.d("MicroMsg.LuggageSystrace", "enable, isDebuggable");
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(Trace.class.getDeclaredMethod("setAppTracingAllowed", Boolean.TYPE).invoke(null, Boolean.TRUE));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl == null) {
            return;
        }
        w.a("MicroMsg.LuggageSystrace", m479exceptionOrNullimpl, "enable, reflect setAppTracingAllowed failure", new Object[0]);
    }

    public final boolean b(Context context) {
        if (context == null || (context.getApplicationInfo().flags & 2) == 0) {
            return false;
        }
        return true;
    }

    public static final void a(String sectionName) {
        String take;
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
        take = StringsKt___StringsKt.take(sectionName, 127);
        TraceCompat.beginSection(take);
    }

    public static final void a() {
        TraceCompat.endSection();
    }
}
