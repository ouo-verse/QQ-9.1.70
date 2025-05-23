package com.tencent.qmethod.monitor.utils;

import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0000\"\u001b\u0010\t\u001a\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\n"}, d2 = {"", "millis", "", "c", "lastTimeMillis", "b", "a", "Lkotlin/Lazy;", "()J", "TODAY_CALENDAR", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class DateUtilKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Lazy f343869a;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Long>() { // from class: com.tencent.qmethod.monitor.utils.DateUtilKt$TODAY_CALENDAR$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Long invoke() {
                return Long.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2() {
                Calendar calendar = Calendar.getInstance();
                calendar.set(11, 0);
                calendar.set(13, 0);
                calendar.set(12, 0);
                calendar.set(14, 0);
                Intrinsics.checkExpressionValueIsNotNull(calendar, "Calendar.getInstance().a\u2026dar.MILLISECOND, 0)\n    }");
                return calendar.getTimeInMillis();
            }
        });
        f343869a = lazy;
    }

    private static final long a() {
        return ((Number) f343869a.getValue()).longValue();
    }

    public static final boolean b(long j3) {
        if (System.currentTimeMillis() < j3 + 86400000) {
            return true;
        }
        return false;
    }

    public static final boolean c(long j3) {
        if (j3 >= a() && j3 < a() + 86400000) {
            return true;
        }
        return false;
    }
}
